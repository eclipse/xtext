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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.BacktrackingContentAssistTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBacktrackingContentAssistTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'body'", "':'", "'context'", "'static'", "'def'", "'('", "','", "')'", "'='", "'derive'", "'init'", "'inv'", "'package'", "'endpackage'", "'post'", "'pre'", "'::'", "'.'", "'->'", "'^^'", "'^'", "'?'", "'e'", "'E'", "'+'", "'-'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'Tuple'", "'{'", "'}'", "'..'", "'true'", "'false'", "'invalid'", "'null'", "'implies'", "'xor'", "'or'", "'and'", "'<>'", "'>'", "'<'", "'>='", "'<='", "'*'", "'/'", "'not'", "'@'", "';'", "'|'", "'['", "']'", "'self'", "'if'", "'then'", "'else'", "'endif'", "'let'", "'in'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=5;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=4;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__80=80;
    public static final int T__46=46;
    public static final int T__81=81;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;

    // delegates
    // delegators


        public InternalBacktrackingContentAssistTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBacktrackingContentAssistTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBacktrackingContentAssistTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBacktrackingContentAssistTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private BacktrackingContentAssistTestLanguageGrammarAccess grammarAccess;
     	
        public InternalBacktrackingContentAssistTestLanguageParser(TokenStream input, BacktrackingContentAssistTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Document";	
       	}
       	
       	@Override
       	protected BacktrackingContentAssistTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleDocument"
    // InternalBacktrackingContentAssistTestLanguage.g:73:1: entryRuleDocument returns [EObject current=null] : iv_ruleDocument= ruleDocument EOF ;
    public final EObject entryRuleDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocument = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:74:2: (iv_ruleDocument= ruleDocument EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:75:2: iv_ruleDocument= ruleDocument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDocumentRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDocument=ruleDocument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDocument; 
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
    // $ANTLR end "entryRuleDocument"


    // $ANTLR start "ruleDocument"
    // InternalBacktrackingContentAssistTestLanguage.g:82:1: ruleDocument returns [EObject current=null] : ( ( (lv_packages_0_0= rulePackageDeclaration ) ) | ( (lv_contexts_1_0= ruleContextDecl ) ) )* ;
    public final EObject ruleDocument() throws RecognitionException {
        EObject current = null;

        EObject lv_packages_0_0 = null;

        EObject lv_contexts_1_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:85:28: ( ( ( (lv_packages_0_0= rulePackageDeclaration ) ) | ( (lv_contexts_1_0= ruleContextDecl ) ) )* )
            // InternalBacktrackingContentAssistTestLanguage.g:86:1: ( ( (lv_packages_0_0= rulePackageDeclaration ) ) | ( (lv_contexts_1_0= ruleContextDecl ) ) )*
            {
            // InternalBacktrackingContentAssistTestLanguage.g:86:1: ( ( (lv_packages_0_0= rulePackageDeclaration ) ) | ( (lv_contexts_1_0= ruleContextDecl ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==23) ) {
                    alt1=1;
                }
                else if ( (LA1_0==13) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:86:2: ( (lv_packages_0_0= rulePackageDeclaration ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:86:2: ( (lv_packages_0_0= rulePackageDeclaration ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:87:1: (lv_packages_0_0= rulePackageDeclaration )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:87:1: (lv_packages_0_0= rulePackageDeclaration )
            	    // InternalBacktrackingContentAssistTestLanguage.g:88:3: lv_packages_0_0= rulePackageDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDocumentAccess().getPackagesPackageDeclarationParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_packages_0_0=rulePackageDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDocumentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"packages",
            	              		lv_packages_0_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.PackageDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:105:6: ( (lv_contexts_1_0= ruleContextDecl ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:105:6: ( (lv_contexts_1_0= ruleContextDecl ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:106:1: (lv_contexts_1_0= ruleContextDecl )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:106:1: (lv_contexts_1_0= ruleContextDecl )
            	    // InternalBacktrackingContentAssistTestLanguage.g:107:3: lv_contexts_1_0= ruleContextDecl
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDocumentAccess().getContextsContextDeclParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_contexts_1_0=ruleContextDecl();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDocumentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"contexts",
            	              		lv_contexts_1_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.ContextDecl");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleDocument"


    // $ANTLR start "entryRuleBody"
    // InternalBacktrackingContentAssistTestLanguage.g:131:1: entryRuleBody returns [EObject current=null] : iv_ruleBody= ruleBody EOF ;
    public final EObject entryRuleBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBody = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:132:2: (iv_ruleBody= ruleBody EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:133:2: iv_ruleBody= ruleBody EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBodyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBody=ruleBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBody; 
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
    // $ANTLR end "entryRuleBody"


    // $ANTLR start "ruleBody"
    // InternalBacktrackingContentAssistTestLanguage.g:140:1: ruleBody returns [EObject current=null] : (otherlv_0= 'body' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_constraintName_1_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:143:28: ( (otherlv_0= 'body' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:144:1: (otherlv_0= 'body' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:144:1: (otherlv_0= 'body' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:144:3: otherlv_0= 'body' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBodyAccess().getBodyKeyword_0());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:148:1: ( (lv_constraintName_1_0= ruleIdentifier ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||(LA2_0>=33 && LA2_0<=34)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:149:1: (lv_constraintName_1_0= ruleIdentifier )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:149:1: (lv_constraintName_1_0= ruleIdentifier )
                    // InternalBacktrackingContentAssistTestLanguage.g:150:3: lv_constraintName_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getBodyAccess().getConstraintNameIdentifierParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_constraintName_1_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getBodyRule());
                      	        }
                             		set(
                             			current, 
                             			"constraintName",
                              		lv_constraintName_1_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getBodyAccess().getColonKeyword_2());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:170:1: ( (lv_expression_3_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:171:1: (lv_expression_3_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:171:1: (lv_expression_3_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:172:3: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBodyAccess().getExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBodyRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_3_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
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
    // $ANTLR end "ruleBody"


    // $ANTLR start "entryRuleClassifierContextDecl"
    // InternalBacktrackingContentAssistTestLanguage.g:196:1: entryRuleClassifierContextDecl returns [EObject current=null] : iv_ruleClassifierContextDecl= ruleClassifierContextDecl EOF ;
    public final EObject entryRuleClassifierContextDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifierContextDecl = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:197:2: (iv_ruleClassifierContextDecl= ruleClassifierContextDecl EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:198:2: iv_ruleClassifierContextDecl= ruleClassifierContextDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassifierContextDeclRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClassifierContextDecl=ruleClassifierContextDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassifierContextDecl; 
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
    // $ANTLR end "entryRuleClassifierContextDecl"


    // $ANTLR start "ruleClassifierContextDecl"
    // InternalBacktrackingContentAssistTestLanguage.g:205:1: ruleClassifierContextDecl returns [EObject current=null] : (otherlv_0= 'context' ( ( (lv_selfName_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_classifier_3_0= ruleClassifierRef ) ) ( ( (lv_invariants_4_0= ruleInvariant ) ) | ( (lv_definitions_5_0= ruleDefinition ) ) )* ) ;
    public final EObject ruleClassifierContextDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_selfName_1_0 = null;

        EObject lv_classifier_3_0 = null;

        EObject lv_invariants_4_0 = null;

        EObject lv_definitions_5_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:208:28: ( (otherlv_0= 'context' ( ( (lv_selfName_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_classifier_3_0= ruleClassifierRef ) ) ( ( (lv_invariants_4_0= ruleInvariant ) ) | ( (lv_definitions_5_0= ruleDefinition ) ) )* ) )
            // InternalBacktrackingContentAssistTestLanguage.g:209:1: (otherlv_0= 'context' ( ( (lv_selfName_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_classifier_3_0= ruleClassifierRef ) ) ( ( (lv_invariants_4_0= ruleInvariant ) ) | ( (lv_definitions_5_0= ruleDefinition ) ) )* )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:209:1: (otherlv_0= 'context' ( ( (lv_selfName_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_classifier_3_0= ruleClassifierRef ) ) ( ( (lv_invariants_4_0= ruleInvariant ) ) | ( (lv_definitions_5_0= ruleDefinition ) ) )* )
            // InternalBacktrackingContentAssistTestLanguage.g:209:3: otherlv_0= 'context' ( ( (lv_selfName_1_0= ruleIdentifier ) ) otherlv_2= ':' )? ( (lv_classifier_3_0= ruleClassifierRef ) ) ( ( (lv_invariants_4_0= ruleInvariant ) ) | ( (lv_definitions_5_0= ruleDefinition ) ) )*
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClassifierContextDeclAccess().getContextKeyword_0());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:213:1: ( ( (lv_selfName_1_0= ruleIdentifier ) ) otherlv_2= ':' )?
            int alt3=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==12) ) {
                        alt3=1;
                    }
                    }
                    break;
                case 33:
                    {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2==12) ) {
                        alt3=1;
                    }
                    }
                    break;
                case 34:
                    {
                    int LA3_3 = input.LA(2);

                    if ( (LA3_3==12) ) {
                        alt3=1;
                    }
                    }
                    break;
            }

            switch (alt3) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:213:2: ( (lv_selfName_1_0= ruleIdentifier ) ) otherlv_2= ':'
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:213:2: ( (lv_selfName_1_0= ruleIdentifier ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:214:1: (lv_selfName_1_0= ruleIdentifier )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:214:1: (lv_selfName_1_0= ruleIdentifier )
                    // InternalBacktrackingContentAssistTestLanguage.g:215:3: lv_selfName_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClassifierContextDeclAccess().getSelfNameIdentifierParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_selfName_1_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClassifierContextDeclRule());
                      	        }
                             		set(
                             			current, 
                             			"selfName",
                              		lv_selfName_1_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getClassifierContextDeclAccess().getColonKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // InternalBacktrackingContentAssistTestLanguage.g:235:3: ( (lv_classifier_3_0= ruleClassifierRef ) )
            // InternalBacktrackingContentAssistTestLanguage.g:236:1: (lv_classifier_3_0= ruleClassifierRef )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:236:1: (lv_classifier_3_0= ruleClassifierRef )
            // InternalBacktrackingContentAssistTestLanguage.g:237:3: lv_classifier_3_0= ruleClassifierRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClassifierContextDeclAccess().getClassifierClassifierRefParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_8);
            lv_classifier_3_0=ruleClassifierRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getClassifierContextDeclRule());
              	        }
                     		set(
                     			current, 
                     			"classifier",
                      		lv_classifier_3_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.ClassifierRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBacktrackingContentAssistTestLanguage.g:253:2: ( ( (lv_invariants_4_0= ruleInvariant ) ) | ( (lv_definitions_5_0= ruleDefinition ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==22) ) {
                    alt4=1;
                }
                else if ( ((LA4_0>=14 && LA4_0<=15)) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:253:3: ( (lv_invariants_4_0= ruleInvariant ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:253:3: ( (lv_invariants_4_0= ruleInvariant ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:254:1: (lv_invariants_4_0= ruleInvariant )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:254:1: (lv_invariants_4_0= ruleInvariant )
            	    // InternalBacktrackingContentAssistTestLanguage.g:255:3: lv_invariants_4_0= ruleInvariant
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getClassifierContextDeclAccess().getInvariantsInvariantParserRuleCall_3_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_invariants_4_0=ruleInvariant();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getClassifierContextDeclRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"invariants",
            	              		lv_invariants_4_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Invariant");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:272:6: ( (lv_definitions_5_0= ruleDefinition ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:272:6: ( (lv_definitions_5_0= ruleDefinition ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:273:1: (lv_definitions_5_0= ruleDefinition )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:273:1: (lv_definitions_5_0= ruleDefinition )
            	    // InternalBacktrackingContentAssistTestLanguage.g:274:3: lv_definitions_5_0= ruleDefinition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getClassifierContextDeclAccess().getDefinitionsDefinitionParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_definitions_5_0=ruleDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getClassifierContextDeclRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"definitions",
            	              		lv_definitions_5_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Definition");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleClassifierContextDecl"


    // $ANTLR start "entryRuleClassifierRef"
    // InternalBacktrackingContentAssistTestLanguage.g:298:1: entryRuleClassifierRef returns [EObject current=null] : iv_ruleClassifierRef= ruleClassifierRef EOF ;
    public final EObject entryRuleClassifierRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifierRef = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:299:2: (iv_ruleClassifierRef= ruleClassifierRef EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:300:2: iv_ruleClassifierRef= ruleClassifierRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassifierRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClassifierRef=ruleClassifierRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassifierRef; 
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
    // $ANTLR end "entryRuleClassifierRef"


    // $ANTLR start "ruleClassifierRef"
    // InternalBacktrackingContentAssistTestLanguage.g:307:1: ruleClassifierRef returns [EObject current=null] : (this_QualifiedClassifierRef_0= ruleQualifiedClassifierRef | this_SimpleClassifierRef_1= ruleSimpleClassifierRef ) ;
    public final EObject ruleClassifierRef() throws RecognitionException {
        EObject current = null;

        EObject this_QualifiedClassifierRef_0 = null;

        EObject this_SimpleClassifierRef_1 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:310:28: ( (this_QualifiedClassifierRef_0= ruleQualifiedClassifierRef | this_SimpleClassifierRef_1= ruleSimpleClassifierRef ) )
            // InternalBacktrackingContentAssistTestLanguage.g:311:1: (this_QualifiedClassifierRef_0= ruleQualifiedClassifierRef | this_SimpleClassifierRef_1= ruleSimpleClassifierRef )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:311:1: (this_QualifiedClassifierRef_0= ruleQualifiedClassifierRef | this_SimpleClassifierRef_1= ruleSimpleClassifierRef )
            int alt5=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==EOF||(LA5_1>=13 && LA5_1<=15)||(LA5_1>=22 && LA5_1<=24)) ) {
                    alt5=2;
                }
                else if ( (LA5_1==27) ) {
                    alt5=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
                }
                break;
            case 33:
                {
                int LA5_2 = input.LA(2);

                if ( (LA5_2==EOF||(LA5_2>=13 && LA5_2<=15)||(LA5_2>=22 && LA5_2<=24)) ) {
                    alt5=2;
                }
                else if ( (LA5_2==27) ) {
                    alt5=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;
                }
                }
                break;
            case 34:
                {
                int LA5_3 = input.LA(2);

                if ( (LA5_3==27) ) {
                    alt5=1;
                }
                else if ( (LA5_3==EOF||(LA5_3>=13 && LA5_3<=15)||(LA5_3>=22 && LA5_3<=24)) ) {
                    alt5=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:312:2: this_QualifiedClassifierRef_0= ruleQualifiedClassifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClassifierRefAccess().getQualifiedClassifierRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QualifiedClassifierRef_0=ruleQualifiedClassifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_QualifiedClassifierRef_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:325:2: this_SimpleClassifierRef_1= ruleSimpleClassifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClassifierRefAccess().getSimpleClassifierRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SimpleClassifierRef_1=ruleSimpleClassifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SimpleClassifierRef_1; 
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
    // $ANTLR end "ruleClassifierRef"


    // $ANTLR start "entryRuleContextDecl"
    // InternalBacktrackingContentAssistTestLanguage.g:344:1: entryRuleContextDecl returns [EObject current=null] : iv_ruleContextDecl= ruleContextDecl EOF ;
    public final EObject entryRuleContextDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextDecl = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:345:2: (iv_ruleContextDecl= ruleContextDecl EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:346:2: iv_ruleContextDecl= ruleContextDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContextDeclRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContextDecl=ruleContextDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContextDecl; 
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
    // $ANTLR end "entryRuleContextDecl"


    // $ANTLR start "ruleContextDecl"
    // InternalBacktrackingContentAssistTestLanguage.g:353:1: ruleContextDecl returns [EObject current=null] : (this_PropertyContextDecl_0= rulePropertyContextDecl | this_ClassifierContextDecl_1= ruleClassifierContextDecl | this_OperationContextDecl_2= ruleOperationContextDecl ) ;
    public final EObject ruleContextDecl() throws RecognitionException {
        EObject current = null;

        EObject this_PropertyContextDecl_0 = null;

        EObject this_ClassifierContextDecl_1 = null;

        EObject this_OperationContextDecl_2 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:356:28: ( (this_PropertyContextDecl_0= rulePropertyContextDecl | this_ClassifierContextDecl_1= ruleClassifierContextDecl | this_OperationContextDecl_2= ruleOperationContextDecl ) )
            // InternalBacktrackingContentAssistTestLanguage.g:357:1: (this_PropertyContextDecl_0= rulePropertyContextDecl | this_ClassifierContextDecl_1= ruleClassifierContextDecl | this_OperationContextDecl_2= ruleOperationContextDecl )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:357:1: (this_PropertyContextDecl_0= rulePropertyContextDecl | this_ClassifierContextDecl_1= ruleClassifierContextDecl | this_OperationContextDecl_2= ruleOperationContextDecl )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==13) ) {
                int LA6_1 = input.LA(2);

                if ( (synpred8_InternalBacktrackingContentAssistTestLanguage()) ) {
                    alt6=1;
                }
                else if ( (synpred9_InternalBacktrackingContentAssistTestLanguage()) ) {
                    alt6=2;
                }
                else if ( (true) ) {
                    alt6=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:358:2: this_PropertyContextDecl_0= rulePropertyContextDecl
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getContextDeclAccess().getPropertyContextDeclParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PropertyContextDecl_0=rulePropertyContextDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PropertyContextDecl_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:371:2: this_ClassifierContextDecl_1= ruleClassifierContextDecl
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getContextDeclAccess().getClassifierContextDeclParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClassifierContextDecl_1=ruleClassifierContextDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ClassifierContextDecl_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalBacktrackingContentAssistTestLanguage.g:384:2: this_OperationContextDecl_2= ruleOperationContextDecl
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getContextDeclAccess().getOperationContextDeclParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_OperationContextDecl_2=ruleOperationContextDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OperationContextDecl_2; 
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
    // $ANTLR end "ruleContextDecl"


    // $ANTLR start "entryRuleDefinition"
    // InternalBacktrackingContentAssistTestLanguage.g:403:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:404:2: (iv_ruleDefinition= ruleDefinition EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:405:2: iv_ruleDefinition= ruleDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefinition; 
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
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // InternalBacktrackingContentAssistTestLanguage.g:412:1: ruleDefinition returns [EObject current=null] : ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'def' ( (lv_constraintName_2_0= ruleIdentifier ) )? otherlv_3= ':' ( (lv_constrainedName_4_0= ruleIdentifier ) ) (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleParameter ) ) )* )? otherlv_9= ')' )? otherlv_10= ':' ( (lv_type_11_0= ruleTypeExp ) )? otherlv_12= '=' ( (lv_expression_13_0= ruleExpression ) ) ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_static_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_constraintName_2_0 = null;

        AntlrDatatypeRuleToken lv_constrainedName_4_0 = null;

        EObject lv_parameters_6_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_type_11_0 = null;

        EObject lv_expression_13_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:415:28: ( ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'def' ( (lv_constraintName_2_0= ruleIdentifier ) )? otherlv_3= ':' ( (lv_constrainedName_4_0= ruleIdentifier ) ) (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleParameter ) ) )* )? otherlv_9= ')' )? otherlv_10= ':' ( (lv_type_11_0= ruleTypeExp ) )? otherlv_12= '=' ( (lv_expression_13_0= ruleExpression ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:416:1: ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'def' ( (lv_constraintName_2_0= ruleIdentifier ) )? otherlv_3= ':' ( (lv_constrainedName_4_0= ruleIdentifier ) ) (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleParameter ) ) )* )? otherlv_9= ')' )? otherlv_10= ':' ( (lv_type_11_0= ruleTypeExp ) )? otherlv_12= '=' ( (lv_expression_13_0= ruleExpression ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:416:1: ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'def' ( (lv_constraintName_2_0= ruleIdentifier ) )? otherlv_3= ':' ( (lv_constrainedName_4_0= ruleIdentifier ) ) (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleParameter ) ) )* )? otherlv_9= ')' )? otherlv_10= ':' ( (lv_type_11_0= ruleTypeExp ) )? otherlv_12= '=' ( (lv_expression_13_0= ruleExpression ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:416:2: ( (lv_static_0_0= 'static' ) )? otherlv_1= 'def' ( (lv_constraintName_2_0= ruleIdentifier ) )? otherlv_3= ':' ( (lv_constrainedName_4_0= ruleIdentifier ) ) (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleParameter ) ) )* )? otherlv_9= ')' )? otherlv_10= ':' ( (lv_type_11_0= ruleTypeExp ) )? otherlv_12= '=' ( (lv_expression_13_0= ruleExpression ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:416:2: ( (lv_static_0_0= 'static' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:417:1: (lv_static_0_0= 'static' )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:417:1: (lv_static_0_0= 'static' )
                    // InternalBacktrackingContentAssistTestLanguage.g:418:3: lv_static_0_0= 'static'
                    {
                    lv_static_0_0=(Token)match(input,14,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_static_0_0, grammarAccess.getDefinitionAccess().getStaticStaticKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDefinitionRule());
                      	        }
                             		setWithLastConsumed(current, "static", true, "static");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getDefinitionAccess().getDefKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:435:1: ( (lv_constraintName_2_0= ruleIdentifier ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||(LA8_0>=33 && LA8_0<=34)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:436:1: (lv_constraintName_2_0= ruleIdentifier )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:436:1: (lv_constraintName_2_0= ruleIdentifier )
                    // InternalBacktrackingContentAssistTestLanguage.g:437:3: lv_constraintName_2_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefinitionAccess().getConstraintNameIdentifierParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_constraintName_2_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"constraintName",
                              		lv_constraintName_2_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDefinitionAccess().getColonKeyword_3());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:457:1: ( (lv_constrainedName_4_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:458:1: (lv_constrainedName_4_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:458:1: (lv_constrainedName_4_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:459:3: lv_constrainedName_4_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDefinitionAccess().getConstrainedNameIdentifierParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_10);
            lv_constrainedName_4_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"constrainedName",
                      		lv_constrainedName_4_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBacktrackingContentAssistTestLanguage.g:475:2: (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleParameter ) ) )* )? otherlv_9= ')' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:475:4: otherlv_5= '(' ( ( (lv_parameters_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleParameter ) ) )* )? otherlv_9= ')'
                    {
                    otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_0());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:479:1: ( ( (lv_parameters_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleParameter ) ) )* )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_ID||(LA10_0>=33 && LA10_0<=34)||(LA10_0>=37 && LA10_0<=50)) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:479:2: ( (lv_parameters_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleParameter ) ) )*
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:479:2: ( (lv_parameters_6_0= ruleParameter ) )
                            // InternalBacktrackingContentAssistTestLanguage.g:480:1: (lv_parameters_6_0= ruleParameter )
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:480:1: (lv_parameters_6_0= ruleParameter )
                            // InternalBacktrackingContentAssistTestLanguage.g:481:3: lv_parameters_6_0= ruleParameter
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDefinitionAccess().getParametersParameterParserRuleCall_5_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_12);
                            lv_parameters_6_0=ruleParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"parameters",
                                      		lv_parameters_6_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Parameter");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalBacktrackingContentAssistTestLanguage.g:497:2: (otherlv_7= ',' ( (lv_parameters_8_0= ruleParameter ) ) )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==17) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // InternalBacktrackingContentAssistTestLanguage.g:497:4: otherlv_7= ',' ( (lv_parameters_8_0= ruleParameter ) )
                            	    {
                            	    otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_13); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_7, grammarAccess.getDefinitionAccess().getCommaKeyword_5_1_1_0());
                            	          
                            	    }
                            	    // InternalBacktrackingContentAssistTestLanguage.g:501:1: ( (lv_parameters_8_0= ruleParameter ) )
                            	    // InternalBacktrackingContentAssistTestLanguage.g:502:1: (lv_parameters_8_0= ruleParameter )
                            	    {
                            	    // InternalBacktrackingContentAssistTestLanguage.g:502:1: (lv_parameters_8_0= ruleParameter )
                            	    // InternalBacktrackingContentAssistTestLanguage.g:503:3: lv_parameters_8_0= ruleParameter
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDefinitionAccess().getParametersParameterParserRuleCall_5_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_12);
                            	    lv_parameters_8_0=ruleParameter();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"parameters",
                            	              		lv_parameters_8_0, 
                            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Parameter");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
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
                            break;

                    }

                    otherlv_9=(Token)match(input,18,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2());
                          
                    }

                    }
                    break;

            }

            otherlv_10=(Token)match(input,12,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getDefinitionAccess().getColonKeyword_6());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:527:1: ( (lv_type_11_0= ruleTypeExp ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||(LA12_0>=33 && LA12_0<=34)||(LA12_0>=37 && LA12_0<=50)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:528:1: (lv_type_11_0= ruleTypeExp )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:528:1: (lv_type_11_0= ruleTypeExp )
                    // InternalBacktrackingContentAssistTestLanguage.g:529:3: lv_type_11_0= ruleTypeExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefinitionAccess().getTypeTypeExpParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_15);
                    lv_type_11_0=ruleTypeExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_11_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TypeExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,19,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getDefinitionAccess().getEqualsSignKeyword_8());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:549:1: ( (lv_expression_13_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:550:1: (lv_expression_13_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:550:1: (lv_expression_13_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:551:3: lv_expression_13_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDefinitionAccess().getExpressionExpressionParserRuleCall_9_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expression_13_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_13_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
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
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleDer"
    // InternalBacktrackingContentAssistTestLanguage.g:575:1: entryRuleDer returns [EObject current=null] : iv_ruleDer= ruleDer EOF ;
    public final EObject entryRuleDer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDer = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:576:2: (iv_ruleDer= ruleDer EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:577:2: iv_ruleDer= ruleDer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDerRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDer=ruleDer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDer; 
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
    // $ANTLR end "entryRuleDer"


    // $ANTLR start "ruleDer"
    // InternalBacktrackingContentAssistTestLanguage.g:584:1: ruleDer returns [EObject current=null] : (otherlv_0= 'derive' otherlv_1= ':' ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleDer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:587:28: ( (otherlv_0= 'derive' otherlv_1= ':' ( (lv_expression_2_0= ruleExpression ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:588:1: (otherlv_0= 'derive' otherlv_1= ':' ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:588:1: (otherlv_0= 'derive' otherlv_1= ':' ( (lv_expression_2_0= ruleExpression ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:588:3: otherlv_0= 'derive' otherlv_1= ':' ( (lv_expression_2_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDerAccess().getDeriveKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getDerAccess().getColonKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:596:1: ( (lv_expression_2_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:597:1: (lv_expression_2_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:597:1: (lv_expression_2_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:598:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDerAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDerRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
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
    // $ANTLR end "ruleDer"


    // $ANTLR start "entryRuleInit"
    // InternalBacktrackingContentAssistTestLanguage.g:622:1: entryRuleInit returns [EObject current=null] : iv_ruleInit= ruleInit EOF ;
    public final EObject entryRuleInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInit = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:623:2: (iv_ruleInit= ruleInit EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:624:2: iv_ruleInit= ruleInit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInitRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInit=ruleInit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInit; 
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
    // $ANTLR end "entryRuleInit"


    // $ANTLR start "ruleInit"
    // InternalBacktrackingContentAssistTestLanguage.g:631:1: ruleInit returns [EObject current=null] : (otherlv_0= 'init' otherlv_1= ':' ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:634:28: ( (otherlv_0= 'init' otherlv_1= ':' ( (lv_expression_2_0= ruleExpression ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:635:1: (otherlv_0= 'init' otherlv_1= ':' ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:635:1: (otherlv_0= 'init' otherlv_1= ':' ( (lv_expression_2_0= ruleExpression ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:635:3: otherlv_0= 'init' otherlv_1= ':' ( (lv_expression_2_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInitAccess().getInitKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInitAccess().getColonKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:643:1: ( (lv_expression_2_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:644:1: (lv_expression_2_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:644:1: (lv_expression_2_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:645:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInitAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getInitRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
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
    // $ANTLR end "ruleInit"


    // $ANTLR start "entryRuleInvariant"
    // InternalBacktrackingContentAssistTestLanguage.g:669:1: entryRuleInvariant returns [EObject current=null] : iv_ruleInvariant= ruleInvariant EOF ;
    public final EObject entryRuleInvariant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvariant = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:670:2: (iv_ruleInvariant= ruleInvariant EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:671:2: iv_ruleInvariant= ruleInvariant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvariantRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInvariant=ruleInvariant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvariant; 
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
    // $ANTLR end "entryRuleInvariant"


    // $ANTLR start "ruleInvariant"
    // InternalBacktrackingContentAssistTestLanguage.g:678:1: ruleInvariant returns [EObject current=null] : (otherlv_0= 'inv' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleInvariant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_constraintName_1_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:681:28: ( (otherlv_0= 'inv' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:682:1: (otherlv_0= 'inv' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:682:1: (otherlv_0= 'inv' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:682:3: otherlv_0= 'inv' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInvariantAccess().getInvKeyword_0());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:686:1: ( (lv_constraintName_1_0= ruleIdentifier ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID||(LA13_0>=33 && LA13_0<=34)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:687:1: (lv_constraintName_1_0= ruleIdentifier )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:687:1: (lv_constraintName_1_0= ruleIdentifier )
                    // InternalBacktrackingContentAssistTestLanguage.g:688:3: lv_constraintName_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInvariantAccess().getConstraintNameIdentifierParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_constraintName_1_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getInvariantRule());
                      	        }
                             		set(
                             			current, 
                             			"constraintName",
                              		lv_constraintName_1_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getInvariantAccess().getColonKeyword_2());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:708:1: ( (lv_expression_3_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:709:1: (lv_expression_3_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:709:1: (lv_expression_3_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:710:3: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInvariantAccess().getExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getInvariantRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_3_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
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
    // $ANTLR end "ruleInvariant"


    // $ANTLR start "entryRuleOperationContextDecl"
    // InternalBacktrackingContentAssistTestLanguage.g:734:1: entryRuleOperationContextDecl returns [EObject current=null] : iv_ruleOperationContextDecl= ruleOperationContextDecl EOF ;
    public final EObject entryRuleOperationContextDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationContextDecl = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:735:2: (iv_ruleOperationContextDecl= ruleOperationContextDecl EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:736:2: iv_ruleOperationContextDecl= ruleOperationContextDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationContextDeclRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOperationContextDecl=ruleOperationContextDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationContextDecl; 
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
    // $ANTLR end "entryRuleOperationContextDecl"


    // $ANTLR start "ruleOperationContextDecl"
    // InternalBacktrackingContentAssistTestLanguage.g:743:1: ruleOperationContextDecl returns [EObject current=null] : (otherlv_0= 'context' ( (lv_operation_1_0= ruleOperationRef ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleTypeExp ) )? ( ( (lv_pres_9_0= rulePre ) ) | ( (lv_posts_10_0= rulePost ) ) | ( (lv_bodies_11_0= ruleBody ) ) )* ) ;
    public final EObject ruleOperationContextDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_operation_1_0 = null;

        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_type_8_0 = null;

        EObject lv_pres_9_0 = null;

        EObject lv_posts_10_0 = null;

        EObject lv_bodies_11_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:746:28: ( (otherlv_0= 'context' ( (lv_operation_1_0= ruleOperationRef ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleTypeExp ) )? ( ( (lv_pres_9_0= rulePre ) ) | ( (lv_posts_10_0= rulePost ) ) | ( (lv_bodies_11_0= ruleBody ) ) )* ) )
            // InternalBacktrackingContentAssistTestLanguage.g:747:1: (otherlv_0= 'context' ( (lv_operation_1_0= ruleOperationRef ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleTypeExp ) )? ( ( (lv_pres_9_0= rulePre ) ) | ( (lv_posts_10_0= rulePost ) ) | ( (lv_bodies_11_0= ruleBody ) ) )* )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:747:1: (otherlv_0= 'context' ( (lv_operation_1_0= ruleOperationRef ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleTypeExp ) )? ( ( (lv_pres_9_0= rulePre ) ) | ( (lv_posts_10_0= rulePost ) ) | ( (lv_bodies_11_0= ruleBody ) ) )* )
            // InternalBacktrackingContentAssistTestLanguage.g:747:3: otherlv_0= 'context' ( (lv_operation_1_0= ruleOperationRef ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleTypeExp ) )? ( ( (lv_pres_9_0= rulePre ) ) | ( (lv_posts_10_0= rulePost ) ) | ( (lv_bodies_11_0= ruleBody ) ) )*
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOperationContextDeclAccess().getContextKeyword_0());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:751:1: ( (lv_operation_1_0= ruleOperationRef ) )
            // InternalBacktrackingContentAssistTestLanguage.g:752:1: (lv_operation_1_0= ruleOperationRef )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:752:1: (lv_operation_1_0= ruleOperationRef )
            // InternalBacktrackingContentAssistTestLanguage.g:753:3: lv_operation_1_0= ruleOperationRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOperationContextDeclAccess().getOperationOperationRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_16);
            lv_operation_1_0=ruleOperationRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOperationContextDeclRule());
              	        }
                     		set(
                     			current, 
                     			"operation",
                      		lv_operation_1_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.OperationRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOperationContextDeclAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:773:1: ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID||(LA15_0>=33 && LA15_0<=34)||(LA15_0>=37 && LA15_0<=50)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:773:2: ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:773:2: ( (lv_parameters_3_0= ruleParameter ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:774:1: (lv_parameters_3_0= ruleParameter )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:774:1: (lv_parameters_3_0= ruleParameter )
                    // InternalBacktrackingContentAssistTestLanguage.g:775:3: lv_parameters_3_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationContextDeclAccess().getParametersParameterParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_12);
                    lv_parameters_3_0=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationContextDeclRule());
                      	        }
                             		add(
                             			current, 
                             			"parameters",
                              		lv_parameters_3_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Parameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:791:2: (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==17) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalBacktrackingContentAssistTestLanguage.g:791:4: otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getOperationContextDeclAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalBacktrackingContentAssistTestLanguage.g:795:1: ( (lv_parameters_5_0= ruleParameter ) )
                    	    // InternalBacktrackingContentAssistTestLanguage.g:796:1: (lv_parameters_5_0= ruleParameter )
                    	    {
                    	    // InternalBacktrackingContentAssistTestLanguage.g:796:1: (lv_parameters_5_0= ruleParameter )
                    	    // InternalBacktrackingContentAssistTestLanguage.g:797:3: lv_parameters_5_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationContextDeclAccess().getParametersParameterParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_12);
                    	    lv_parameters_5_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationContextDeclRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"parameters",
                    	              		lv_parameters_5_0, 
                    	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Parameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOperationContextDeclAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getOperationContextDeclAccess().getColonKeyword_5());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:821:1: ( (lv_type_8_0= ruleTypeExp ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID||(LA16_0>=33 && LA16_0<=34)||(LA16_0>=37 && LA16_0<=50)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:822:1: (lv_type_8_0= ruleTypeExp )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:822:1: (lv_type_8_0= ruleTypeExp )
                    // InternalBacktrackingContentAssistTestLanguage.g:823:3: lv_type_8_0= ruleTypeExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationContextDeclAccess().getTypeTypeExpParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_18);
                    lv_type_8_0=ruleTypeExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationContextDeclRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_8_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TypeExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalBacktrackingContentAssistTestLanguage.g:839:3: ( ( (lv_pres_9_0= rulePre ) ) | ( (lv_posts_10_0= rulePost ) ) | ( (lv_bodies_11_0= ruleBody ) ) )*
            loop17:
            do {
                int alt17=4;
                switch ( input.LA(1) ) {
                case 26:
                    {
                    alt17=1;
                    }
                    break;
                case 25:
                    {
                    alt17=2;
                    }
                    break;
                case 11:
                    {
                    alt17=3;
                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:839:4: ( (lv_pres_9_0= rulePre ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:839:4: ( (lv_pres_9_0= rulePre ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:840:1: (lv_pres_9_0= rulePre )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:840:1: (lv_pres_9_0= rulePre )
            	    // InternalBacktrackingContentAssistTestLanguage.g:841:3: lv_pres_9_0= rulePre
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOperationContextDeclAccess().getPresPreParserRuleCall_7_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_18);
            	    lv_pres_9_0=rulePre();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOperationContextDeclRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"pres",
            	              		lv_pres_9_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Pre");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:858:6: ( (lv_posts_10_0= rulePost ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:858:6: ( (lv_posts_10_0= rulePost ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:859:1: (lv_posts_10_0= rulePost )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:859:1: (lv_posts_10_0= rulePost )
            	    // InternalBacktrackingContentAssistTestLanguage.g:860:3: lv_posts_10_0= rulePost
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOperationContextDeclAccess().getPostsPostParserRuleCall_7_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_18);
            	    lv_posts_10_0=rulePost();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOperationContextDeclRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"posts",
            	              		lv_posts_10_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Post");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:877:6: ( (lv_bodies_11_0= ruleBody ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:877:6: ( (lv_bodies_11_0= ruleBody ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:878:1: (lv_bodies_11_0= ruleBody )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:878:1: (lv_bodies_11_0= ruleBody )
            	    // InternalBacktrackingContentAssistTestLanguage.g:879:3: lv_bodies_11_0= ruleBody
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOperationContextDeclAccess().getBodiesBodyParserRuleCall_7_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_18);
            	    lv_bodies_11_0=ruleBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOperationContextDeclRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"bodies",
            	              		lv_bodies_11_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Body");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleOperationContextDecl"


    // $ANTLR start "entryRuleOperationRef"
    // InternalBacktrackingContentAssistTestLanguage.g:903:1: entryRuleOperationRef returns [EObject current=null] : iv_ruleOperationRef= ruleOperationRef EOF ;
    public final EObject entryRuleOperationRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationRef = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:904:2: (iv_ruleOperationRef= ruleOperationRef EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:905:2: iv_ruleOperationRef= ruleOperationRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOperationRef=ruleOperationRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationRef; 
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
    // $ANTLR end "entryRuleOperationRef"


    // $ANTLR start "ruleOperationRef"
    // InternalBacktrackingContentAssistTestLanguage.g:912:1: ruleOperationRef returns [EObject current=null] : (this_QualifiedOperationRef_0= ruleQualifiedOperationRef | this_SimpleOperationRef_1= ruleSimpleOperationRef ) ;
    public final EObject ruleOperationRef() throws RecognitionException {
        EObject current = null;

        EObject this_QualifiedOperationRef_0 = null;

        EObject this_SimpleOperationRef_1 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:915:28: ( (this_QualifiedOperationRef_0= ruleQualifiedOperationRef | this_SimpleOperationRef_1= ruleSimpleOperationRef ) )
            // InternalBacktrackingContentAssistTestLanguage.g:916:1: (this_QualifiedOperationRef_0= ruleQualifiedOperationRef | this_SimpleOperationRef_1= ruleSimpleOperationRef )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:916:1: (this_QualifiedOperationRef_0= ruleQualifiedOperationRef | this_SimpleOperationRef_1= ruleSimpleOperationRef )
            int alt18=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==EOF||LA18_1==16) ) {
                    alt18=2;
                }
                else if ( (LA18_1==27) ) {
                    alt18=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
                }
                break;
            case 33:
                {
                int LA18_2 = input.LA(2);

                if ( (LA18_2==EOF||LA18_2==16) ) {
                    alt18=2;
                }
                else if ( (LA18_2==27) ) {
                    alt18=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 2, input);

                    throw nvae;
                }
                }
                break;
            case 34:
                {
                int LA18_3 = input.LA(2);

                if ( (LA18_3==27) ) {
                    alt18=1;
                }
                else if ( (LA18_3==EOF||LA18_3==16) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:917:2: this_QualifiedOperationRef_0= ruleQualifiedOperationRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getOperationRefAccess().getQualifiedOperationRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QualifiedOperationRef_0=ruleQualifiedOperationRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_QualifiedOperationRef_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:930:2: this_SimpleOperationRef_1= ruleSimpleOperationRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getOperationRefAccess().getSimpleOperationRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SimpleOperationRef_1=ruleSimpleOperationRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SimpleOperationRef_1; 
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
    // $ANTLR end "ruleOperationRef"


    // $ANTLR start "entryRulePackageDeclaration"
    // InternalBacktrackingContentAssistTestLanguage.g:949:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:950:2: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:951:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPackageDeclarationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePackageDeclaration=rulePackageDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackageDeclaration; 
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
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // InternalBacktrackingContentAssistTestLanguage.g:958:1: rulePackageDeclaration returns [EObject current=null] : (otherlv_0= 'package' ( (lv_package_1_0= rulePackageRef ) ) ( (lv_contexts_2_0= ruleContextDecl ) )* otherlv_3= 'endpackage' ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_package_1_0 = null;

        EObject lv_contexts_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:961:28: ( (otherlv_0= 'package' ( (lv_package_1_0= rulePackageRef ) ) ( (lv_contexts_2_0= ruleContextDecl ) )* otherlv_3= 'endpackage' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:962:1: (otherlv_0= 'package' ( (lv_package_1_0= rulePackageRef ) ) ( (lv_contexts_2_0= ruleContextDecl ) )* otherlv_3= 'endpackage' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:962:1: (otherlv_0= 'package' ( (lv_package_1_0= rulePackageRef ) ) ( (lv_contexts_2_0= ruleContextDecl ) )* otherlv_3= 'endpackage' )
            // InternalBacktrackingContentAssistTestLanguage.g:962:3: otherlv_0= 'package' ( (lv_package_1_0= rulePackageRef ) ) ( (lv_contexts_2_0= ruleContextDecl ) )* otherlv_3= 'endpackage'
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:966:1: ( (lv_package_1_0= rulePackageRef ) )
            // InternalBacktrackingContentAssistTestLanguage.g:967:1: (lv_package_1_0= rulePackageRef )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:967:1: (lv_package_1_0= rulePackageRef )
            // InternalBacktrackingContentAssistTestLanguage.g:968:3: lv_package_1_0= rulePackageRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getPackagePackageRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_19);
            lv_package_1_0=rulePackageRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
              	        }
                     		set(
                     			current, 
                     			"package",
                      		lv_package_1_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.PackageRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBacktrackingContentAssistTestLanguage.g:984:2: ( (lv_contexts_2_0= ruleContextDecl ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==13) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:985:1: (lv_contexts_2_0= ruleContextDecl )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:985:1: (lv_contexts_2_0= ruleContextDecl )
            	    // InternalBacktrackingContentAssistTestLanguage.g:986:3: lv_contexts_2_0= ruleContextDecl
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getContextsContextDeclParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    lv_contexts_2_0=ruleContextDecl();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"contexts",
            	              		lv_contexts_2_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.ContextDecl");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPackageDeclarationAccess().getEndpackageKeyword_3());
                  
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
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRulePackageRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1014:1: entryRulePackageRef returns [EObject current=null] : iv_rulePackageRef= rulePackageRef EOF ;
    public final EObject entryRulePackageRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageRef = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1015:2: (iv_rulePackageRef= rulePackageRef EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1016:2: iv_rulePackageRef= rulePackageRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPackageRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePackageRef=rulePackageRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackageRef; 
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
    // $ANTLR end "entryRulePackageRef"


    // $ANTLR start "rulePackageRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1023:1: rulePackageRef returns [EObject current=null] : (this_QualifiedPackageRef_0= ruleQualifiedPackageRef | this_SimplePackageRef_1= ruleSimplePackageRef ) ;
    public final EObject rulePackageRef() throws RecognitionException {
        EObject current = null;

        EObject this_QualifiedPackageRef_0 = null;

        EObject this_SimplePackageRef_1 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1026:28: ( (this_QualifiedPackageRef_0= ruleQualifiedPackageRef | this_SimplePackageRef_1= ruleSimplePackageRef ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1027:1: (this_QualifiedPackageRef_0= ruleQualifiedPackageRef | this_SimplePackageRef_1= ruleSimplePackageRef )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1027:1: (this_QualifiedPackageRef_0= ruleQualifiedPackageRef | this_SimplePackageRef_1= ruleSimplePackageRef )
            int alt20=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==27) ) {
                    alt20=1;
                }
                else if ( (LA20_1==EOF||LA20_1==13||LA20_1==24) ) {
                    alt20=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
                }
                break;
            case 33:
                {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==27) ) {
                    alt20=1;
                }
                else if ( (LA20_2==EOF||LA20_2==13||LA20_2==24) ) {
                    alt20=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 2, input);

                    throw nvae;
                }
                }
                break;
            case 34:
                {
                int LA20_3 = input.LA(2);

                if ( (LA20_3==EOF||LA20_3==13||LA20_3==24) ) {
                    alt20=2;
                }
                else if ( (LA20_3==27) ) {
                    alt20=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:1028:2: this_QualifiedPackageRef_0= ruleQualifiedPackageRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPackageRefAccess().getQualifiedPackageRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QualifiedPackageRef_0=ruleQualifiedPackageRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_QualifiedPackageRef_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:1041:2: this_SimplePackageRef_1= ruleSimplePackageRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPackageRefAccess().getSimplePackageRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SimplePackageRef_1=ruleSimplePackageRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SimplePackageRef_1; 
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
    // $ANTLR end "rulePackageRef"


    // $ANTLR start "entryRuleParameter"
    // InternalBacktrackingContentAssistTestLanguage.g:1060:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1061:2: (iv_ruleParameter= ruleParameter EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1062:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalBacktrackingContentAssistTestLanguage.g:1069:1: ruleParameter returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' )? ( (lv_type_2_0= ruleTypeExp ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1072:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' )? ( (lv_type_2_0= ruleTypeExp ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1073:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' )? ( (lv_type_2_0= ruleTypeExp ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1073:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' )? ( (lv_type_2_0= ruleTypeExp ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1073:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' )? ( (lv_type_2_0= ruleTypeExp ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1073:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' )?
            int alt21=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1==12) ) {
                        alt21=1;
                    }
                    }
                    break;
                case 33:
                    {
                    int LA21_2 = input.LA(2);

                    if ( (LA21_2==12) ) {
                        alt21=1;
                    }
                    }
                    break;
                case 34:
                    {
                    int LA21_3 = input.LA(2);

                    if ( (LA21_3==12) ) {
                        alt21=1;
                    }
                    }
                    break;
            }

            switch (alt21) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:1073:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':'
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1073:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:1074:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1074:1: (lv_name_0_0= ruleIdentifier )
                    // InternalBacktrackingContentAssistTestLanguage.g:1075:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_name_0_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // InternalBacktrackingContentAssistTestLanguage.g:1095:3: ( (lv_type_2_0= ruleTypeExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1096:1: (lv_type_2_0= ruleTypeExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1096:1: (lv_type_2_0= ruleTypeExp )
            // InternalBacktrackingContentAssistTestLanguage.g:1097:3: lv_type_2_0= ruleTypeExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeExpParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_type_2_0=ruleTypeExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParameterRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TypeExp");
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRulePost"
    // InternalBacktrackingContentAssistTestLanguage.g:1121:1: entryRulePost returns [EObject current=null] : iv_rulePost= rulePost EOF ;
    public final EObject entryRulePost() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePost = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1122:2: (iv_rulePost= rulePost EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1123:2: iv_rulePost= rulePost EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePost=rulePost();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePost; 
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
    // $ANTLR end "entryRulePost"


    // $ANTLR start "rulePost"
    // InternalBacktrackingContentAssistTestLanguage.g:1130:1: rulePost returns [EObject current=null] : (otherlv_0= 'post' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject rulePost() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_constraintName_1_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1133:28: ( (otherlv_0= 'post' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1134:1: (otherlv_0= 'post' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1134:1: (otherlv_0= 'post' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1134:3: otherlv_0= 'post' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPostAccess().getPostKeyword_0());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:1138:1: ( (lv_constraintName_1_0= ruleIdentifier ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID||(LA22_0>=33 && LA22_0<=34)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:1139:1: (lv_constraintName_1_0= ruleIdentifier )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1139:1: (lv_constraintName_1_0= ruleIdentifier )
                    // InternalBacktrackingContentAssistTestLanguage.g:1140:3: lv_constraintName_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostAccess().getConstraintNameIdentifierParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_constraintName_1_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPostRule());
                      	        }
                             		set(
                             			current, 
                             			"constraintName",
                              		lv_constraintName_1_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPostAccess().getColonKeyword_2());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:1160:1: ( (lv_expression_3_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1161:1: (lv_expression_3_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1161:1: (lv_expression_3_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:1162:3: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostAccess().getExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPostRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_3_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
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
    // $ANTLR end "rulePost"


    // $ANTLR start "entryRulePre"
    // InternalBacktrackingContentAssistTestLanguage.g:1186:1: entryRulePre returns [EObject current=null] : iv_rulePre= rulePre EOF ;
    public final EObject entryRulePre() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePre = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1187:2: (iv_rulePre= rulePre EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1188:2: iv_rulePre= rulePre EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPreRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePre=rulePre();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePre; 
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
    // $ANTLR end "entryRulePre"


    // $ANTLR start "rulePre"
    // InternalBacktrackingContentAssistTestLanguage.g:1195:1: rulePre returns [EObject current=null] : (otherlv_0= 'pre' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject rulePre() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_constraintName_1_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1198:28: ( (otherlv_0= 'pre' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1199:1: (otherlv_0= 'pre' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1199:1: (otherlv_0= 'pre' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1199:3: otherlv_0= 'pre' ( (lv_constraintName_1_0= ruleIdentifier ) )? otherlv_2= ':' ( (lv_expression_3_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPreAccess().getPreKeyword_0());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:1203:1: ( (lv_constraintName_1_0= ruleIdentifier ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID||(LA23_0>=33 && LA23_0<=34)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:1204:1: (lv_constraintName_1_0= ruleIdentifier )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1204:1: (lv_constraintName_1_0= ruleIdentifier )
                    // InternalBacktrackingContentAssistTestLanguage.g:1205:3: lv_constraintName_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPreAccess().getConstraintNameIdentifierParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_constraintName_1_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPreRule());
                      	        }
                             		set(
                             			current, 
                             			"constraintName",
                              		lv_constraintName_1_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPreAccess().getColonKeyword_2());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:1225:1: ( (lv_expression_3_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1226:1: (lv_expression_3_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1226:1: (lv_expression_3_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:1227:3: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPreAccess().getExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPreRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_3_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
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
    // $ANTLR end "rulePre"


    // $ANTLR start "entryRulePropertyContextDecl"
    // InternalBacktrackingContentAssistTestLanguage.g:1251:1: entryRulePropertyContextDecl returns [EObject current=null] : iv_rulePropertyContextDecl= rulePropertyContextDecl EOF ;
    public final EObject entryRulePropertyContextDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyContextDecl = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1252:2: (iv_rulePropertyContextDecl= rulePropertyContextDecl EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1253:2: iv_rulePropertyContextDecl= rulePropertyContextDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyContextDeclRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyContextDecl=rulePropertyContextDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyContextDecl; 
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
    // $ANTLR end "entryRulePropertyContextDecl"


    // $ANTLR start "rulePropertyContextDecl"
    // InternalBacktrackingContentAssistTestLanguage.g:1260:1: rulePropertyContextDecl returns [EObject current=null] : (otherlv_0= 'context' ( (lv_property_1_0= rulePropertyRef ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ( ( ( (lv_init_4_0= ruleInit ) ) ( (lv_der_5_0= ruleDer ) )? )? | ( ( (lv_der_6_0= ruleDer ) ) ( (lv_init_7_0= ruleInit ) )? ) ) ) ;
    public final EObject rulePropertyContextDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_property_1_0 = null;

        EObject lv_type_3_0 = null;

        EObject lv_init_4_0 = null;

        EObject lv_der_5_0 = null;

        EObject lv_der_6_0 = null;

        EObject lv_init_7_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1263:28: ( (otherlv_0= 'context' ( (lv_property_1_0= rulePropertyRef ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ( ( ( (lv_init_4_0= ruleInit ) ) ( (lv_der_5_0= ruleDer ) )? )? | ( ( (lv_der_6_0= ruleDer ) ) ( (lv_init_7_0= ruleInit ) )? ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1264:1: (otherlv_0= 'context' ( (lv_property_1_0= rulePropertyRef ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ( ( ( (lv_init_4_0= ruleInit ) ) ( (lv_der_5_0= ruleDer ) )? )? | ( ( (lv_der_6_0= ruleDer ) ) ( (lv_init_7_0= ruleInit ) )? ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1264:1: (otherlv_0= 'context' ( (lv_property_1_0= rulePropertyRef ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ( ( ( (lv_init_4_0= ruleInit ) ) ( (lv_der_5_0= ruleDer ) )? )? | ( ( (lv_der_6_0= ruleDer ) ) ( (lv_init_7_0= ruleInit ) )? ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1264:3: otherlv_0= 'context' ( (lv_property_1_0= rulePropertyRef ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ( ( ( (lv_init_4_0= ruleInit ) ) ( (lv_der_5_0= ruleDer ) )? )? | ( ( (lv_der_6_0= ruleDer ) ) ( (lv_init_7_0= ruleInit ) )? ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPropertyContextDeclAccess().getContextKeyword_0());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:1268:1: ( (lv_property_1_0= rulePropertyRef ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1269:1: (lv_property_1_0= rulePropertyRef )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1269:1: (lv_property_1_0= rulePropertyRef )
            // InternalBacktrackingContentAssistTestLanguage.g:1270:3: lv_property_1_0= rulePropertyRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyContextDeclAccess().getPropertyPropertyRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_5);
            lv_property_1_0=rulePropertyRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropertyContextDeclRule());
              	        }
                     		set(
                     			current, 
                     			"property",
                      		lv_property_1_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.PropertyRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPropertyContextDeclAccess().getColonKeyword_2());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:1290:1: ( (lv_type_3_0= ruleTypeExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1291:1: (lv_type_3_0= ruleTypeExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1291:1: (lv_type_3_0= ruleTypeExp )
            // InternalBacktrackingContentAssistTestLanguage.g:1292:3: lv_type_3_0= ruleTypeExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyContextDeclAccess().getTypeTypeExpParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_20);
            lv_type_3_0=ruleTypeExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropertyContextDeclRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_3_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TypeExp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBacktrackingContentAssistTestLanguage.g:1308:2: ( ( ( (lv_init_4_0= ruleInit ) ) ( (lv_der_5_0= ruleDer ) )? )? | ( ( (lv_der_6_0= ruleDer ) ) ( (lv_init_7_0= ruleInit ) )? ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==EOF||LA27_0==13||LA27_0==21||(LA27_0>=23 && LA27_0<=24)) ) {
                alt27=1;
            }
            else if ( (LA27_0==20) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:1308:3: ( ( (lv_init_4_0= ruleInit ) ) ( (lv_der_5_0= ruleDer ) )? )?
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1308:3: ( ( (lv_init_4_0= ruleInit ) ) ( (lv_der_5_0= ruleDer ) )? )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==21) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:1308:4: ( (lv_init_4_0= ruleInit ) ) ( (lv_der_5_0= ruleDer ) )?
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:1308:4: ( (lv_init_4_0= ruleInit ) )
                            // InternalBacktrackingContentAssistTestLanguage.g:1309:1: (lv_init_4_0= ruleInit )
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:1309:1: (lv_init_4_0= ruleInit )
                            // InternalBacktrackingContentAssistTestLanguage.g:1310:3: lv_init_4_0= ruleInit
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPropertyContextDeclAccess().getInitInitParserRuleCall_4_0_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_21);
                            lv_init_4_0=ruleInit();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getPropertyContextDeclRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"init",
                                      		lv_init_4_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Init");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalBacktrackingContentAssistTestLanguage.g:1326:2: ( (lv_der_5_0= ruleDer ) )?
                            int alt24=2;
                            int LA24_0 = input.LA(1);

                            if ( (LA24_0==20) ) {
                                alt24=1;
                            }
                            switch (alt24) {
                                case 1 :
                                    // InternalBacktrackingContentAssistTestLanguage.g:1327:1: (lv_der_5_0= ruleDer )
                                    {
                                    // InternalBacktrackingContentAssistTestLanguage.g:1327:1: (lv_der_5_0= ruleDer )
                                    // InternalBacktrackingContentAssistTestLanguage.g:1328:3: lv_der_5_0= ruleDer
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getPropertyContextDeclAccess().getDerDerParserRuleCall_4_0_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_2);
                                    lv_der_5_0=ruleDer();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getPropertyContextDeclRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"der",
                                              		lv_der_5_0, 
                                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Der");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:1345:6: ( ( (lv_der_6_0= ruleDer ) ) ( (lv_init_7_0= ruleInit ) )? )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1345:6: ( ( (lv_der_6_0= ruleDer ) ) ( (lv_init_7_0= ruleInit ) )? )
                    // InternalBacktrackingContentAssistTestLanguage.g:1345:7: ( (lv_der_6_0= ruleDer ) ) ( (lv_init_7_0= ruleInit ) )?
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1345:7: ( (lv_der_6_0= ruleDer ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:1346:1: (lv_der_6_0= ruleDer )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1346:1: (lv_der_6_0= ruleDer )
                    // InternalBacktrackingContentAssistTestLanguage.g:1347:3: lv_der_6_0= ruleDer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyContextDeclAccess().getDerDerParserRuleCall_4_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_22);
                    lv_der_6_0=ruleDer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPropertyContextDeclRule());
                      	        }
                             		set(
                             			current, 
                             			"der",
                              		lv_der_6_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Der");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:1363:2: ( (lv_init_7_0= ruleInit ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==21) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:1364:1: (lv_init_7_0= ruleInit )
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:1364:1: (lv_init_7_0= ruleInit )
                            // InternalBacktrackingContentAssistTestLanguage.g:1365:3: lv_init_7_0= ruleInit
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPropertyContextDeclAccess().getInitInitParserRuleCall_4_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_init_7_0=ruleInit();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getPropertyContextDeclRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"init",
                                      		lv_init_7_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Init");
                              	        afterParserOrEnumRuleCall();
                              	    
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
    // $ANTLR end "rulePropertyContextDecl"


    // $ANTLR start "entryRulePropertyRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1389:1: entryRulePropertyRef returns [EObject current=null] : iv_rulePropertyRef= rulePropertyRef EOF ;
    public final EObject entryRulePropertyRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyRef = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1390:2: (iv_rulePropertyRef= rulePropertyRef EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1391:2: iv_rulePropertyRef= rulePropertyRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyRef=rulePropertyRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyRef; 
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
    // $ANTLR end "entryRulePropertyRef"


    // $ANTLR start "rulePropertyRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1398:1: rulePropertyRef returns [EObject current=null] : (this_QualifiedPropertyRef_0= ruleQualifiedPropertyRef | this_SimplePropertyRef_1= ruleSimplePropertyRef ) ;
    public final EObject rulePropertyRef() throws RecognitionException {
        EObject current = null;

        EObject this_QualifiedPropertyRef_0 = null;

        EObject this_SimplePropertyRef_1 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1401:28: ( (this_QualifiedPropertyRef_0= ruleQualifiedPropertyRef | this_SimplePropertyRef_1= ruleSimplePropertyRef ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1402:1: (this_QualifiedPropertyRef_0= ruleQualifiedPropertyRef | this_SimplePropertyRef_1= ruleSimplePropertyRef )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1402:1: (this_QualifiedPropertyRef_0= ruleQualifiedPropertyRef | this_SimplePropertyRef_1= ruleSimplePropertyRef )
            int alt28=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==EOF||LA28_1==12) ) {
                    alt28=2;
                }
                else if ( (LA28_1==27) ) {
                    alt28=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
                }
                break;
            case 33:
                {
                int LA28_2 = input.LA(2);

                if ( (LA28_2==27) ) {
                    alt28=1;
                }
                else if ( (LA28_2==EOF||LA28_2==12) ) {
                    alt28=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 2, input);

                    throw nvae;
                }
                }
                break;
            case 34:
                {
                int LA28_3 = input.LA(2);

                if ( (LA28_3==27) ) {
                    alt28=1;
                }
                else if ( (LA28_3==EOF||LA28_3==12) ) {
                    alt28=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 3, input);

                    throw nvae;
                }
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
                    // InternalBacktrackingContentAssistTestLanguage.g:1403:2: this_QualifiedPropertyRef_0= ruleQualifiedPropertyRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyRefAccess().getQualifiedPropertyRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QualifiedPropertyRef_0=ruleQualifiedPropertyRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_QualifiedPropertyRef_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:1416:2: this_SimplePropertyRef_1= ruleSimplePropertyRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyRefAccess().getSimplePropertyRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SimplePropertyRef_1=ruleSimplePropertyRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SimplePropertyRef_1; 
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
    // $ANTLR end "rulePropertyRef"


    // $ANTLR start "entryRuleQualifiedClassifierRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1435:1: entryRuleQualifiedClassifierRef returns [EObject current=null] : iv_ruleQualifiedClassifierRef= ruleQualifiedClassifierRef EOF ;
    public final EObject entryRuleQualifiedClassifierRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedClassifierRef = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1436:2: (iv_ruleQualifiedClassifierRef= ruleQualifiedClassifierRef EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1437:2: iv_ruleQualifiedClassifierRef= ruleQualifiedClassifierRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedClassifierRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQualifiedClassifierRef=ruleQualifiedClassifierRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedClassifierRef; 
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
    // $ANTLR end "entryRuleQualifiedClassifierRef"


    // $ANTLR start "ruleQualifiedClassifierRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1444:1: ruleQualifiedClassifierRef returns [EObject current=null] : ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleClassifierRef ) ) ) ;
    public final EObject ruleQualifiedClassifierRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_namespace_0_0 = null;

        EObject lv_element_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1447:28: ( ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleClassifierRef ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1448:1: ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleClassifierRef ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1448:1: ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleClassifierRef ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1448:2: ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleClassifierRef ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1448:2: ( (lv_namespace_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1449:1: (lv_namespace_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1449:1: (lv_namespace_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:1450:3: lv_namespace_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedClassifierRefAccess().getNamespaceIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_23);
            lv_namespace_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedClassifierRefRule());
              	        }
                     		set(
                     			current, 
                     			"namespace",
                      		lv_namespace_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getQualifiedClassifierRefAccess().getColonColonKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:1470:1: ( (lv_element_2_0= ruleClassifierRef ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1471:1: (lv_element_2_0= ruleClassifierRef )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1471:1: (lv_element_2_0= ruleClassifierRef )
            // InternalBacktrackingContentAssistTestLanguage.g:1472:3: lv_element_2_0= ruleClassifierRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedClassifierRefAccess().getElementClassifierRefParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_element_2_0=ruleClassifierRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedClassifierRefRule());
              	        }
                     		set(
                     			current, 
                     			"element",
                      		lv_element_2_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.ClassifierRef");
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
    // $ANTLR end "ruleQualifiedClassifierRef"


    // $ANTLR start "entryRuleQualifiedOperationRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1496:1: entryRuleQualifiedOperationRef returns [EObject current=null] : iv_ruleQualifiedOperationRef= ruleQualifiedOperationRef EOF ;
    public final EObject entryRuleQualifiedOperationRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedOperationRef = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1497:2: (iv_ruleQualifiedOperationRef= ruleQualifiedOperationRef EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1498:2: iv_ruleQualifiedOperationRef= ruleQualifiedOperationRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedOperationRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQualifiedOperationRef=ruleQualifiedOperationRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedOperationRef; 
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
    // $ANTLR end "entryRuleQualifiedOperationRef"


    // $ANTLR start "ruleQualifiedOperationRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1505:1: ruleQualifiedOperationRef returns [EObject current=null] : ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleOperationRef ) ) ) ;
    public final EObject ruleQualifiedOperationRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_namespace_0_0 = null;

        EObject lv_element_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1508:28: ( ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleOperationRef ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1509:1: ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleOperationRef ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1509:1: ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleOperationRef ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1509:2: ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleOperationRef ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1509:2: ( (lv_namespace_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1510:1: (lv_namespace_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1510:1: (lv_namespace_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:1511:3: lv_namespace_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedOperationRefAccess().getNamespaceIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_23);
            lv_namespace_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedOperationRefRule());
              	        }
                     		set(
                     			current, 
                     			"namespace",
                      		lv_namespace_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getQualifiedOperationRefAccess().getColonColonKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:1531:1: ( (lv_element_2_0= ruleOperationRef ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1532:1: (lv_element_2_0= ruleOperationRef )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1532:1: (lv_element_2_0= ruleOperationRef )
            // InternalBacktrackingContentAssistTestLanguage.g:1533:3: lv_element_2_0= ruleOperationRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedOperationRefAccess().getElementOperationRefParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_element_2_0=ruleOperationRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedOperationRefRule());
              	        }
                     		set(
                     			current, 
                     			"element",
                      		lv_element_2_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.OperationRef");
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
    // $ANTLR end "ruleQualifiedOperationRef"


    // $ANTLR start "entryRuleQualifiedPropertyRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1557:1: entryRuleQualifiedPropertyRef returns [EObject current=null] : iv_ruleQualifiedPropertyRef= ruleQualifiedPropertyRef EOF ;
    public final EObject entryRuleQualifiedPropertyRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPropertyRef = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1558:2: (iv_ruleQualifiedPropertyRef= ruleQualifiedPropertyRef EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1559:2: iv_ruleQualifiedPropertyRef= ruleQualifiedPropertyRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPropertyRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQualifiedPropertyRef=ruleQualifiedPropertyRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPropertyRef; 
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
    // $ANTLR end "entryRuleQualifiedPropertyRef"


    // $ANTLR start "ruleQualifiedPropertyRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1566:1: ruleQualifiedPropertyRef returns [EObject current=null] : ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= rulePropertyRef ) ) ) ;
    public final EObject ruleQualifiedPropertyRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_namespace_0_0 = null;

        EObject lv_element_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1569:28: ( ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= rulePropertyRef ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1570:1: ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= rulePropertyRef ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1570:1: ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= rulePropertyRef ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1570:2: ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= rulePropertyRef ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1570:2: ( (lv_namespace_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1571:1: (lv_namespace_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1571:1: (lv_namespace_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:1572:3: lv_namespace_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPropertyRefAccess().getNamespaceIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_23);
            lv_namespace_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedPropertyRefRule());
              	        }
                     		set(
                     			current, 
                     			"namespace",
                      		lv_namespace_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getQualifiedPropertyRefAccess().getColonColonKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:1592:1: ( (lv_element_2_0= rulePropertyRef ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1593:1: (lv_element_2_0= rulePropertyRef )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1593:1: (lv_element_2_0= rulePropertyRef )
            // InternalBacktrackingContentAssistTestLanguage.g:1594:3: lv_element_2_0= rulePropertyRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPropertyRefAccess().getElementPropertyRefParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_element_2_0=rulePropertyRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedPropertyRefRule());
              	        }
                     		set(
                     			current, 
                     			"element",
                      		lv_element_2_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.PropertyRef");
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
    // $ANTLR end "ruleQualifiedPropertyRef"


    // $ANTLR start "entryRuleQualifiedPackageRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1618:1: entryRuleQualifiedPackageRef returns [EObject current=null] : iv_ruleQualifiedPackageRef= ruleQualifiedPackageRef EOF ;
    public final EObject entryRuleQualifiedPackageRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPackageRef = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1619:2: (iv_ruleQualifiedPackageRef= ruleQualifiedPackageRef EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1620:2: iv_ruleQualifiedPackageRef= ruleQualifiedPackageRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPackageRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQualifiedPackageRef=ruleQualifiedPackageRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPackageRef; 
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
    // $ANTLR end "entryRuleQualifiedPackageRef"


    // $ANTLR start "ruleQualifiedPackageRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1627:1: ruleQualifiedPackageRef returns [EObject current=null] : ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= rulePackageRef ) ) ) ;
    public final EObject ruleQualifiedPackageRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_namespace_0_0 = null;

        EObject lv_element_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1630:28: ( ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= rulePackageRef ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1631:1: ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= rulePackageRef ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1631:1: ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= rulePackageRef ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1631:2: ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= rulePackageRef ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1631:2: ( (lv_namespace_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1632:1: (lv_namespace_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1632:1: (lv_namespace_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:1633:3: lv_namespace_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPackageRefAccess().getNamespaceIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_23);
            lv_namespace_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedPackageRefRule());
              	        }
                     		set(
                     			current, 
                     			"namespace",
                      		lv_namespace_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getQualifiedPackageRefAccess().getColonColonKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:1653:1: ( (lv_element_2_0= rulePackageRef ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1654:1: (lv_element_2_0= rulePackageRef )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1654:1: (lv_element_2_0= rulePackageRef )
            // InternalBacktrackingContentAssistTestLanguage.g:1655:3: lv_element_2_0= rulePackageRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPackageRefAccess().getElementPackageRefParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_element_2_0=rulePackageRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedPackageRefRule());
              	        }
                     		set(
                     			current, 
                     			"element",
                      		lv_element_2_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.PackageRef");
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
    // $ANTLR end "ruleQualifiedPackageRef"


    // $ANTLR start "entryRuleSimpleClassifierRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1679:1: entryRuleSimpleClassifierRef returns [EObject current=null] : iv_ruleSimpleClassifierRef= ruleSimpleClassifierRef EOF ;
    public final EObject entryRuleSimpleClassifierRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleClassifierRef = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1680:2: (iv_ruleSimpleClassifierRef= ruleSimpleClassifierRef EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1681:2: iv_ruleSimpleClassifierRef= ruleSimpleClassifierRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleClassifierRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleClassifierRef=ruleSimpleClassifierRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleClassifierRef; 
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
    // $ANTLR end "entryRuleSimpleClassifierRef"


    // $ANTLR start "ruleSimpleClassifierRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1688:1: ruleSimpleClassifierRef returns [EObject current=null] : ( (lv_classifier_0_0= ruleIdentifier ) ) ;
    public final EObject ruleSimpleClassifierRef() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_classifier_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1691:28: ( ( (lv_classifier_0_0= ruleIdentifier ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1692:1: ( (lv_classifier_0_0= ruleIdentifier ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1692:1: ( (lv_classifier_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1693:1: (lv_classifier_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1693:1: (lv_classifier_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:1694:3: lv_classifier_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSimpleClassifierRefAccess().getClassifierIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_classifier_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSimpleClassifierRefRule());
              	        }
                     		set(
                     			current, 
                     			"classifier",
                      		lv_classifier_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
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
    // $ANTLR end "ruleSimpleClassifierRef"


    // $ANTLR start "entryRuleSimpleOperationRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1718:1: entryRuleSimpleOperationRef returns [EObject current=null] : iv_ruleSimpleOperationRef= ruleSimpleOperationRef EOF ;
    public final EObject entryRuleSimpleOperationRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleOperationRef = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1719:2: (iv_ruleSimpleOperationRef= ruleSimpleOperationRef EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1720:2: iv_ruleSimpleOperationRef= ruleSimpleOperationRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleOperationRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleOperationRef=ruleSimpleOperationRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleOperationRef; 
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
    // $ANTLR end "entryRuleSimpleOperationRef"


    // $ANTLR start "ruleSimpleOperationRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1727:1: ruleSimpleOperationRef returns [EObject current=null] : ( (lv_operation_0_0= ruleIdentifier ) ) ;
    public final EObject ruleSimpleOperationRef() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operation_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1730:28: ( ( (lv_operation_0_0= ruleIdentifier ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1731:1: ( (lv_operation_0_0= ruleIdentifier ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1731:1: ( (lv_operation_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1732:1: (lv_operation_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1732:1: (lv_operation_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:1733:3: lv_operation_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSimpleOperationRefAccess().getOperationIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_operation_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSimpleOperationRefRule());
              	        }
                     		set(
                     			current, 
                     			"operation",
                      		lv_operation_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
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
    // $ANTLR end "ruleSimpleOperationRef"


    // $ANTLR start "entryRuleSimplePackageRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1757:1: entryRuleSimplePackageRef returns [EObject current=null] : iv_ruleSimplePackageRef= ruleSimplePackageRef EOF ;
    public final EObject entryRuleSimplePackageRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimplePackageRef = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1758:2: (iv_ruleSimplePackageRef= ruleSimplePackageRef EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1759:2: iv_ruleSimplePackageRef= ruleSimplePackageRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimplePackageRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimplePackageRef=ruleSimplePackageRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimplePackageRef; 
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
    // $ANTLR end "entryRuleSimplePackageRef"


    // $ANTLR start "ruleSimplePackageRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1766:1: ruleSimplePackageRef returns [EObject current=null] : ( (lv_package_0_0= ruleIdentifier ) ) ;
    public final EObject ruleSimplePackageRef() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_package_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1769:28: ( ( (lv_package_0_0= ruleIdentifier ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1770:1: ( (lv_package_0_0= ruleIdentifier ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1770:1: ( (lv_package_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1771:1: (lv_package_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1771:1: (lv_package_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:1772:3: lv_package_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSimplePackageRefAccess().getPackageIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_package_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSimplePackageRefRule());
              	        }
                     		set(
                     			current, 
                     			"package",
                      		lv_package_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
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
    // $ANTLR end "ruleSimplePackageRef"


    // $ANTLR start "entryRuleSimplePropertyRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1796:1: entryRuleSimplePropertyRef returns [EObject current=null] : iv_ruleSimplePropertyRef= ruleSimplePropertyRef EOF ;
    public final EObject entryRuleSimplePropertyRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimplePropertyRef = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1797:2: (iv_ruleSimplePropertyRef= ruleSimplePropertyRef EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1798:2: iv_ruleSimplePropertyRef= ruleSimplePropertyRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimplePropertyRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimplePropertyRef=ruleSimplePropertyRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimplePropertyRef; 
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
    // $ANTLR end "entryRuleSimplePropertyRef"


    // $ANTLR start "ruleSimplePropertyRef"
    // InternalBacktrackingContentAssistTestLanguage.g:1805:1: ruleSimplePropertyRef returns [EObject current=null] : ( (lv_feature_0_0= ruleIdentifier ) ) ;
    public final EObject ruleSimplePropertyRef() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_feature_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1808:28: ( ( (lv_feature_0_0= ruleIdentifier ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1809:1: ( (lv_feature_0_0= ruleIdentifier ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1809:1: ( (lv_feature_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1810:1: (lv_feature_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1810:1: (lv_feature_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:1811:3: lv_feature_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSimplePropertyRefAccess().getFeatureIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_feature_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSimplePropertyRefRule());
              	        }
                     		set(
                     			current, 
                     			"feature",
                      		lv_feature_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
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
    // $ANTLR end "ruleSimplePropertyRef"


    // $ANTLR start "entryRuleNavigationExp"
    // InternalBacktrackingContentAssistTestLanguage.g:1835:1: entryRuleNavigationExp returns [EObject current=null] : iv_ruleNavigationExp= ruleNavigationExp EOF ;
    public final EObject entryRuleNavigationExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1836:2: (iv_ruleNavigationExp= ruleNavigationExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:1837:2: iv_ruleNavigationExp= ruleNavigationExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigationExp=ruleNavigationExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationExp; 
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
    // $ANTLR end "entryRuleNavigationExp"


    // $ANTLR start "ruleNavigationExp"
    // InternalBacktrackingContentAssistTestLanguage.g:1844:1: ruleNavigationExp returns [EObject current=null] : (this_SubNavigationExp_0= ruleSubNavigationExp ( ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) ) | ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' ) )? ) ;
    public final EObject ruleNavigationExp() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_5_1=null;
        Token lv_op_5_2=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject this_SubNavigationExp_0 = null;

        EObject lv_argument_3_0 = null;

        AntlrDatatypeRuleToken lv_messageName_6_0 = null;

        EObject lv_arguments_8_0 = null;

        EObject lv_arguments_10_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:1847:28: ( (this_SubNavigationExp_0= ruleSubNavigationExp ( ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) ) | ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' ) )? ) )
            // InternalBacktrackingContentAssistTestLanguage.g:1848:1: (this_SubNavigationExp_0= ruleSubNavigationExp ( ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) ) | ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' ) )? )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:1848:1: (this_SubNavigationExp_0= ruleSubNavigationExp ( ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) ) | ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' ) )? )
            // InternalBacktrackingContentAssistTestLanguage.g:1849:2: this_SubNavigationExp_0= ruleSubNavigationExp ( ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) ) | ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigationExpAccess().getSubNavigationExpParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_24);
            this_SubNavigationExp_0=ruleSubNavigationExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_SubNavigationExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:1860:1: ( ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) ) | ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' ) )?
            int alt33=3;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=28 && LA33_0<=29)) ) {
                alt33=1;
            }
            else if ( ((LA33_0>=30 && LA33_0<=31)) ) {
                alt33=2;
            }
            switch (alt33) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:1860:2: ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1860:2: ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:1860:3: () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1860:3: ()
                    // InternalBacktrackingContentAssistTestLanguage.g:1861:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getNavigationExpAccess().getInfixExpSourceAction_1_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:1869:2: ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:1870:1: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1870:1: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:1871:1: (lv_op_2_1= '.' | lv_op_2_2= '->' )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1871:1: (lv_op_2_1= '.' | lv_op_2_2= '->' )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==28) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==29) ) {
                        alt29=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:1872:3: lv_op_2_1= '.'
                            {
                            lv_op_2_1=(Token)match(input,28,FollowSets000.FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getNavigationExpAccess().getOpFullStopKeyword_1_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getNavigationExpRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalBacktrackingContentAssistTestLanguage.g:1884:8: lv_op_2_2= '->'
                            {
                            lv_op_2_2=(Token)match(input,29,FollowSets000.FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getNavigationExpAccess().getOpHyphenMinusGreaterThanSignKeyword_1_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getNavigationExpRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:1899:2: ( (lv_argument_3_0= ruleNavigatingExp ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:1900:1: (lv_argument_3_0= ruleNavigatingExp )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1900:1: (lv_argument_3_0= ruleNavigatingExp )
                    // InternalBacktrackingContentAssistTestLanguage.g:1901:3: lv_argument_3_0= ruleNavigatingExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigationExpAccess().getArgumentNavigatingExpParserRuleCall_1_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_argument_3_0=ruleNavigatingExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigationExpRule());
                      	        }
                             		set(
                             			current, 
                             			"argument",
                              		lv_argument_3_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.NavigatingExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:1918:6: ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1918:6: ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' )
                    // InternalBacktrackingContentAssistTestLanguage.g:1918:7: () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')'
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1918:7: ()
                    // InternalBacktrackingContentAssistTestLanguage.g:1919:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getNavigationExpAccess().getOclMessageSourceAction_1_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:1927:2: ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:1928:1: ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1928:1: ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:1929:1: (lv_op_5_1= '^^' | lv_op_5_2= '^' )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1929:1: (lv_op_5_1= '^^' | lv_op_5_2= '^' )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==30) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==31) ) {
                        alt30=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:1930:3: lv_op_5_1= '^^'
                            {
                            lv_op_5_1=(Token)match(input,30,FollowSets000.FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_5_1, grammarAccess.getNavigationExpAccess().getOpCircumflexAccentCircumflexAccentKeyword_1_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getNavigationExpRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_5_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalBacktrackingContentAssistTestLanguage.g:1942:8: lv_op_5_2= '^'
                            {
                            lv_op_5_2=(Token)match(input,31,FollowSets000.FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_5_2, grammarAccess.getNavigationExpAccess().getOpCircumflexAccentKeyword_1_1_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getNavigationExpRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_5_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:1957:2: ( (lv_messageName_6_0= ruleIdentifier ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:1958:1: (lv_messageName_6_0= ruleIdentifier )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:1958:1: (lv_messageName_6_0= ruleIdentifier )
                    // InternalBacktrackingContentAssistTestLanguage.g:1959:3: lv_messageName_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigationExpAccess().getMessageNameIdentifierParserRuleCall_1_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
                    lv_messageName_6_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigationExpRule());
                      	        }
                             		set(
                             			current, 
                             			"messageName",
                              		lv_messageName_6_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getNavigationExpAccess().getLeftParenthesisKeyword_1_1_3());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:1979:1: ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( ((LA32_0>=RULE_INT && LA32_0<=RULE_STRING)||LA32_0==16||(LA32_0>=32 && LA32_0<=34)||(LA32_0>=36 && LA32_0<=50)||(LA32_0>=54 && LA32_0<=57)||LA32_0==69||(LA32_0>=75 && LA32_0<=76)||LA32_0==80) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:1979:2: ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )*
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:1979:2: ( (lv_arguments_8_0= ruleOclMessageArg ) )
                            // InternalBacktrackingContentAssistTestLanguage.g:1980:1: (lv_arguments_8_0= ruleOclMessageArg )
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:1980:1: (lv_arguments_8_0= ruleOclMessageArg )
                            // InternalBacktrackingContentAssistTestLanguage.g:1981:3: lv_arguments_8_0= ruleOclMessageArg
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigationExpAccess().getArgumentsOclMessageArgParserRuleCall_1_1_4_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_12);
                            lv_arguments_8_0=ruleOclMessageArg();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigationExpRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"arguments",
                                      		lv_arguments_8_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.OclMessageArg");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalBacktrackingContentAssistTestLanguage.g:1997:2: (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )*
                            loop31:
                            do {
                                int alt31=2;
                                int LA31_0 = input.LA(1);

                                if ( (LA31_0==17) ) {
                                    alt31=1;
                                }


                                switch (alt31) {
                            	case 1 :
                            	    // InternalBacktrackingContentAssistTestLanguage.g:1997:4: otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) )
                            	    {
                            	    otherlv_9=(Token)match(input,17,FollowSets000.FOLLOW_26); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_9, grammarAccess.getNavigationExpAccess().getCommaKeyword_1_1_4_1_0());
                            	          
                            	    }
                            	    // InternalBacktrackingContentAssistTestLanguage.g:2001:1: ( (lv_arguments_10_0= ruleOclMessageArg ) )
                            	    // InternalBacktrackingContentAssistTestLanguage.g:2002:1: (lv_arguments_10_0= ruleOclMessageArg )
                            	    {
                            	    // InternalBacktrackingContentAssistTestLanguage.g:2002:1: (lv_arguments_10_0= ruleOclMessageArg )
                            	    // InternalBacktrackingContentAssistTestLanguage.g:2003:3: lv_arguments_10_0= ruleOclMessageArg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getNavigationExpAccess().getArgumentsOclMessageArgParserRuleCall_1_1_4_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_12);
                            	    lv_arguments_10_0=ruleOclMessageArg();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getNavigationExpRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"arguments",
                            	              		lv_arguments_10_0, 
                            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.OclMessageArg");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
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

                    otherlv_11=(Token)match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getNavigationExpAccess().getRightParenthesisKeyword_1_1_5());
                          
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
    // $ANTLR end "ruleNavigationExp"


    // $ANTLR start "entryRuleNavigatingExp"
    // InternalBacktrackingContentAssistTestLanguage.g:2031:1: entryRuleNavigatingExp returns [EObject current=null] : iv_ruleNavigatingExp= ruleNavigatingExp EOF ;
    public final EObject entryRuleNavigatingExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2032:2: (iv_ruleNavigatingExp= ruleNavigatingExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2033:2: iv_ruleNavigatingExp= ruleNavigatingExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigatingExp=ruleNavigatingExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingExp; 
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
    // $ANTLR end "entryRuleNavigatingExp"


    // $ANTLR start "ruleNavigatingExp"
    // InternalBacktrackingContentAssistTestLanguage.g:2040:1: ruleNavigatingExp returns [EObject current=null] : (this_SubNavigatingExp_0= ruleSubNavigatingExp ( ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) ) | ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' ) )? ) ;
    public final EObject ruleNavigatingExp() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_5_1=null;
        Token lv_op_5_2=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject this_SubNavigatingExp_0 = null;

        EObject lv_argument_3_0 = null;

        AntlrDatatypeRuleToken lv_messageName_6_0 = null;

        EObject lv_arguments_8_0 = null;

        EObject lv_arguments_10_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2043:28: ( (this_SubNavigatingExp_0= ruleSubNavigatingExp ( ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) ) | ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' ) )? ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2044:1: (this_SubNavigatingExp_0= ruleSubNavigatingExp ( ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) ) | ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' ) )? )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2044:1: (this_SubNavigatingExp_0= ruleSubNavigatingExp ( ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) ) | ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' ) )? )
            // InternalBacktrackingContentAssistTestLanguage.g:2045:2: this_SubNavigatingExp_0= ruleSubNavigatingExp ( ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) ) | ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingExpAccess().getSubNavigatingExpParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_24);
            this_SubNavigatingExp_0=ruleSubNavigatingExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_SubNavigatingExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:2056:1: ( ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) ) | ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' ) )?
            int alt38=3;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=28 && LA38_0<=29)) ) {
                alt38=1;
            }
            else if ( ((LA38_0>=30 && LA38_0<=31)) ) {
                alt38=2;
            }
            switch (alt38) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2056:2: ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2056:2: ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:2056:3: () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= ruleNavigatingExp ) )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2056:3: ()
                    // InternalBacktrackingContentAssistTestLanguage.g:2057:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getNavigatingExpAccess().getInfixExpSourceAction_1_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:2065:2: ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:2066:1: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2066:1: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:2067:1: (lv_op_2_1= '.' | lv_op_2_2= '->' )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2067:1: (lv_op_2_1= '.' | lv_op_2_2= '->' )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==28) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==29) ) {
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
                            // InternalBacktrackingContentAssistTestLanguage.g:2068:3: lv_op_2_1= '.'
                            {
                            lv_op_2_1=(Token)match(input,28,FollowSets000.FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getNavigatingExpAccess().getOpFullStopKeyword_1_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getNavigatingExpRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalBacktrackingContentAssistTestLanguage.g:2080:8: lv_op_2_2= '->'
                            {
                            lv_op_2_2=(Token)match(input,29,FollowSets000.FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getNavigatingExpAccess().getOpHyphenMinusGreaterThanSignKeyword_1_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getNavigatingExpRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:2095:2: ( (lv_argument_3_0= ruleNavigatingExp ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:2096:1: (lv_argument_3_0= ruleNavigatingExp )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2096:1: (lv_argument_3_0= ruleNavigatingExp )
                    // InternalBacktrackingContentAssistTestLanguage.g:2097:3: lv_argument_3_0= ruleNavigatingExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingExpAccess().getArgumentNavigatingExpParserRuleCall_1_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_argument_3_0=ruleNavigatingExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingExpRule());
                      	        }
                             		set(
                             			current, 
                             			"argument",
                              		lv_argument_3_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.NavigatingExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2114:6: ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2114:6: ( () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')' )
                    // InternalBacktrackingContentAssistTestLanguage.g:2114:7: () ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) ) ( (lv_messageName_6_0= ruleIdentifier ) ) otherlv_7= '(' ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )? otherlv_11= ')'
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2114:7: ()
                    // InternalBacktrackingContentAssistTestLanguage.g:2115:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getNavigatingExpAccess().getOclMessageSourceAction_1_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:2123:2: ( ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:2124:1: ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2124:1: ( (lv_op_5_1= '^^' | lv_op_5_2= '^' ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:2125:1: (lv_op_5_1= '^^' | lv_op_5_2= '^' )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2125:1: (lv_op_5_1= '^^' | lv_op_5_2= '^' )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==30) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==31) ) {
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
                            // InternalBacktrackingContentAssistTestLanguage.g:2126:3: lv_op_5_1= '^^'
                            {
                            lv_op_5_1=(Token)match(input,30,FollowSets000.FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_5_1, grammarAccess.getNavigatingExpAccess().getOpCircumflexAccentCircumflexAccentKeyword_1_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getNavigatingExpRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_5_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalBacktrackingContentAssistTestLanguage.g:2138:8: lv_op_5_2= '^'
                            {
                            lv_op_5_2=(Token)match(input,31,FollowSets000.FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_5_2, grammarAccess.getNavigatingExpAccess().getOpCircumflexAccentKeyword_1_1_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getNavigatingExpRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_5_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:2153:2: ( (lv_messageName_6_0= ruleIdentifier ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:2154:1: (lv_messageName_6_0= ruleIdentifier )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2154:1: (lv_messageName_6_0= ruleIdentifier )
                    // InternalBacktrackingContentAssistTestLanguage.g:2155:3: lv_messageName_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingExpAccess().getMessageNameIdentifierParserRuleCall_1_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
                    lv_messageName_6_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingExpRule());
                      	        }
                             		set(
                             			current, 
                             			"messageName",
                              		lv_messageName_6_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getNavigatingExpAccess().getLeftParenthesisKeyword_1_1_3());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:2175:1: ( ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )* )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( ((LA37_0>=RULE_INT && LA37_0<=RULE_STRING)||LA37_0==16||(LA37_0>=32 && LA37_0<=34)||(LA37_0>=36 && LA37_0<=50)||(LA37_0>=54 && LA37_0<=57)||LA37_0==69||(LA37_0>=75 && LA37_0<=76)||LA37_0==80) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:2175:2: ( (lv_arguments_8_0= ruleOclMessageArg ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )*
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:2175:2: ( (lv_arguments_8_0= ruleOclMessageArg ) )
                            // InternalBacktrackingContentAssistTestLanguage.g:2176:1: (lv_arguments_8_0= ruleOclMessageArg )
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:2176:1: (lv_arguments_8_0= ruleOclMessageArg )
                            // InternalBacktrackingContentAssistTestLanguage.g:2177:3: lv_arguments_8_0= ruleOclMessageArg
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingExpAccess().getArgumentsOclMessageArgParserRuleCall_1_1_4_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_12);
                            lv_arguments_8_0=ruleOclMessageArg();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingExpRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"arguments",
                                      		lv_arguments_8_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.OclMessageArg");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalBacktrackingContentAssistTestLanguage.g:2193:2: (otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) ) )*
                            loop36:
                            do {
                                int alt36=2;
                                int LA36_0 = input.LA(1);

                                if ( (LA36_0==17) ) {
                                    alt36=1;
                                }


                                switch (alt36) {
                            	case 1 :
                            	    // InternalBacktrackingContentAssistTestLanguage.g:2193:4: otherlv_9= ',' ( (lv_arguments_10_0= ruleOclMessageArg ) )
                            	    {
                            	    otherlv_9=(Token)match(input,17,FollowSets000.FOLLOW_26); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_9, grammarAccess.getNavigatingExpAccess().getCommaKeyword_1_1_4_1_0());
                            	          
                            	    }
                            	    // InternalBacktrackingContentAssistTestLanguage.g:2197:1: ( (lv_arguments_10_0= ruleOclMessageArg ) )
                            	    // InternalBacktrackingContentAssistTestLanguage.g:2198:1: (lv_arguments_10_0= ruleOclMessageArg )
                            	    {
                            	    // InternalBacktrackingContentAssistTestLanguage.g:2198:1: (lv_arguments_10_0= ruleOclMessageArg )
                            	    // InternalBacktrackingContentAssistTestLanguage.g:2199:3: lv_arguments_10_0= ruleOclMessageArg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getNavigatingExpAccess().getArgumentsOclMessageArgParserRuleCall_1_1_4_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_12);
                            	    lv_arguments_10_0=ruleOclMessageArg();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getNavigatingExpRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"arguments",
                            	              		lv_arguments_10_0, 
                            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.OclMessageArg");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop36;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getNavigatingExpAccess().getRightParenthesisKeyword_1_1_5());
                          
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
    // $ANTLR end "ruleNavigatingExp"


    // $ANTLR start "entryRuleOclMessageArg"
    // InternalBacktrackingContentAssistTestLanguage.g:2227:1: entryRuleOclMessageArg returns [EObject current=null] : iv_ruleOclMessageArg= ruleOclMessageArg EOF ;
    public final EObject entryRuleOclMessageArg() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclMessageArg = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2228:2: (iv_ruleOclMessageArg= ruleOclMessageArg EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2229:2: iv_ruleOclMessageArg= ruleOclMessageArg EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOclMessageArgRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOclMessageArg=ruleOclMessageArg();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOclMessageArg; 
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
    // $ANTLR end "entryRuleOclMessageArg"


    // $ANTLR start "ruleOclMessageArg"
    // InternalBacktrackingContentAssistTestLanguage.g:2236:1: ruleOclMessageArg returns [EObject current=null] : ( ( () otherlv_1= '?' (otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) )? ) | this_Expression_4= ruleExpression ) ;
    public final EObject ruleOclMessageArg() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_type_3_0 = null;

        EObject this_Expression_4 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2239:28: ( ( ( () otherlv_1= '?' (otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) )? ) | this_Expression_4= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2240:1: ( ( () otherlv_1= '?' (otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) )? ) | this_Expression_4= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2240:1: ( ( () otherlv_1= '?' (otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) )? ) | this_Expression_4= ruleExpression )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==32) ) {
                alt40=1;
            }
            else if ( ((LA40_0>=RULE_INT && LA40_0<=RULE_STRING)||LA40_0==16||(LA40_0>=33 && LA40_0<=34)||(LA40_0>=36 && LA40_0<=50)||(LA40_0>=54 && LA40_0<=57)||LA40_0==69||(LA40_0>=75 && LA40_0<=76)||LA40_0==80) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2240:2: ( () otherlv_1= '?' (otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) )? )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2240:2: ( () otherlv_1= '?' (otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) )? )
                    // InternalBacktrackingContentAssistTestLanguage.g:2240:3: () otherlv_1= '?' (otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) )?
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2240:3: ()
                    // InternalBacktrackingContentAssistTestLanguage.g:2241:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getOclMessageArgAccess().getOclMessageArgAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getOclMessageArgAccess().getQuestionMarkKeyword_0_1());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:2253:1: (otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==12) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:2253:3: otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) )
                            {
                            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getOclMessageArgAccess().getColonKeyword_0_2_0());
                                  
                            }
                            // InternalBacktrackingContentAssistTestLanguage.g:2257:1: ( (lv_type_3_0= ruleTypeExp ) )
                            // InternalBacktrackingContentAssistTestLanguage.g:2258:1: (lv_type_3_0= ruleTypeExp )
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:2258:1: (lv_type_3_0= ruleTypeExp )
                            // InternalBacktrackingContentAssistTestLanguage.g:2259:3: lv_type_3_0= ruleTypeExp
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getOclMessageArgAccess().getTypeTypeExpParserRuleCall_0_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_type_3_0=ruleTypeExp();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getOclMessageArgRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"type",
                                      		lv_type_3_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TypeExp");
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
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2277:2: this_Expression_4= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getOclMessageArgAccess().getExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Expression_4=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expression_4; 
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
    // $ANTLR end "ruleOclMessageArg"


    // $ANTLR start "entryRuleNUMBER_LITERAL"
    // InternalBacktrackingContentAssistTestLanguage.g:2296:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2297:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2298:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
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
    // $ANTLR end "entryRuleNUMBER_LITERAL"


    // $ANTLR start "ruleNUMBER_LITERAL"
    // InternalBacktrackingContentAssistTestLanguage.g:2305:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ( (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_7=null;

         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2308:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ( (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT )? ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2309:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ( (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2309:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ( (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT )? )
            // InternalBacktrackingContentAssistTestLanguage.g:2309:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ( (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:2316:1: (kw= '.' this_INT_2= RULE_INT )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==28) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==RULE_INT) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2317:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getNUMBER_LITERALAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_2, grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall_1_1()); 
                          
                    }

                    }
                    break;

            }

            // InternalBacktrackingContentAssistTestLanguage.g:2329:3: ( (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=33 && LA44_0<=34)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2329:4: (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_7= RULE_INT
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2329:4: (kw= 'e' | kw= 'E' )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==33) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==34) ) {
                        alt42=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 0, input);

                        throw nvae;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:2330:2: kw= 'e'
                            {
                            kw=(Token)match(input,33,FollowSets000.FOLLOW_31); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNUMBER_LITERALAccess().getEKeyword_2_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // InternalBacktrackingContentAssistTestLanguage.g:2337:2: kw= 'E'
                            {
                            kw=(Token)match(input,34,FollowSets000.FOLLOW_31); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNUMBER_LITERALAccess().getEKeyword_2_0_1()); 
                                  
                            }

                            }
                            break;

                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:2342:2: (kw= '+' | kw= '-' )?
                    int alt43=3;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==35) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==36) ) {
                        alt43=2;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:2343:2: kw= '+'
                            {
                            kw=(Token)match(input,35,FollowSets000.FOLLOW_29); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNUMBER_LITERALAccess().getPlusSignKeyword_2_1_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // InternalBacktrackingContentAssistTestLanguage.g:2350:2: kw= '-'
                            {
                            kw=(Token)match(input,36,FollowSets000.FOLLOW_29); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNUMBER_LITERALAccess().getHyphenMinusKeyword_2_1_1()); 
                                  
                            }

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_7);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_7, grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall_2_2()); 
                          
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
    // $ANTLR end "ruleNUMBER_LITERAL"


    // $ANTLR start "entryRuleEssentialOCLRestrictedKeywords"
    // InternalBacktrackingContentAssistTestLanguage.g:2370:1: entryRuleEssentialOCLRestrictedKeywords returns [String current=null] : iv_ruleEssentialOCLRestrictedKeywords= ruleEssentialOCLRestrictedKeywords EOF ;
    public final String entryRuleEssentialOCLRestrictedKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLRestrictedKeywords = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2371:2: (iv_ruleEssentialOCLRestrictedKeywords= ruleEssentialOCLRestrictedKeywords EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2372:2: iv_ruleEssentialOCLRestrictedKeywords= ruleEssentialOCLRestrictedKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLRestrictedKeywordsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEssentialOCLRestrictedKeywords=ruleEssentialOCLRestrictedKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLRestrictedKeywords.getText(); 
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
    // $ANTLR end "entryRuleEssentialOCLRestrictedKeywords"


    // $ANTLR start "ruleEssentialOCLRestrictedKeywords"
    // InternalBacktrackingContentAssistTestLanguage.g:2379:1: ruleEssentialOCLRestrictedKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'e' | kw= 'E' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLRestrictedKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2382:28: ( (kw= 'e' | kw= 'E' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2383:1: (kw= 'e' | kw= 'E' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2383:1: (kw= 'e' | kw= 'E' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==33) ) {
                alt45=1;
            }
            else if ( (LA45_0==34) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2384:2: kw= 'e'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLRestrictedKeywordsAccess().getEKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2391:2: kw= 'E'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLRestrictedKeywordsAccess().getEKeyword_1()); 
                          
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
    // $ANTLR end "ruleEssentialOCLRestrictedKeywords"


    // $ANTLR start "entryRuleRestrictedKeywords"
    // InternalBacktrackingContentAssistTestLanguage.g:2404:1: entryRuleRestrictedKeywords returns [String current=null] : iv_ruleRestrictedKeywords= ruleRestrictedKeywords EOF ;
    public final String entryRuleRestrictedKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRestrictedKeywords = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2405:2: (iv_ruleRestrictedKeywords= ruleRestrictedKeywords EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2406:2: iv_ruleRestrictedKeywords= ruleRestrictedKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRestrictedKeywordsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRestrictedKeywords=ruleRestrictedKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRestrictedKeywords.getText(); 
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
    // $ANTLR end "entryRuleRestrictedKeywords"


    // $ANTLR start "ruleRestrictedKeywords"
    // InternalBacktrackingContentAssistTestLanguage.g:2413:1: ruleRestrictedKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLRestrictedKeywords_0= ruleEssentialOCLRestrictedKeywords ;
    public final AntlrDatatypeRuleToken ruleRestrictedKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLRestrictedKeywords_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2416:28: (this_EssentialOCLRestrictedKeywords_0= ruleEssentialOCLRestrictedKeywords )
            // InternalBacktrackingContentAssistTestLanguage.g:2418:5: this_EssentialOCLRestrictedKeywords_0= ruleEssentialOCLRestrictedKeywords
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRestrictedKeywordsAccess().getEssentialOCLRestrictedKeywordsParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_EssentialOCLRestrictedKeywords_0=ruleEssentialOCLRestrictedKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLRestrictedKeywords_0);
                  
            }
            if ( state.backtracking==0 ) {
               
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
    // $ANTLR end "ruleRestrictedKeywords"


    // $ANTLR start "entryRuleIdentifier"
    // InternalBacktrackingContentAssistTestLanguage.g:2436:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2437:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2438:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalBacktrackingContentAssistTestLanguage.g:2445:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_RestrictedKeywords_1= ruleRestrictedKeywords ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_RestrictedKeywords_1 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2448:28: ( (this_ID_0= RULE_ID | this_RestrictedKeywords_1= ruleRestrictedKeywords ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2449:1: (this_ID_0= RULE_ID | this_RestrictedKeywords_1= ruleRestrictedKeywords )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2449:1: (this_ID_0= RULE_ID | this_RestrictedKeywords_1= ruleRestrictedKeywords )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            else if ( ((LA46_0>=33 && LA46_0<=34)) ) {
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
                    // InternalBacktrackingContentAssistTestLanguage.g:2449:6: this_ID_0= RULE_ID
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
                    // InternalBacktrackingContentAssistTestLanguage.g:2458:5: this_RestrictedKeywords_1= ruleRestrictedKeywords
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdentifierAccess().getRestrictedKeywordsParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RestrictedKeywords_1=ruleRestrictedKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_RestrictedKeywords_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
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
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalBacktrackingContentAssistTestLanguage.g:2476:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2477:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2478:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
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
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalBacktrackingContentAssistTestLanguage.g:2485:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2488:28: (this_STRING_0= RULE_STRING )
            // InternalBacktrackingContentAssistTestLanguage.g:2489:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_STRING_0, grammarAccess.getStringLiteralAccess().getSTRINGTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRulePrimitiveTypeIdentifier"
    // InternalBacktrackingContentAssistTestLanguage.g:2506:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2507:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2508:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
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
    // $ANTLR end "entryRulePrimitiveTypeIdentifier"


    // $ANTLR start "rulePrimitiveTypeIdentifier"
    // InternalBacktrackingContentAssistTestLanguage.g:2515:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2518:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2519:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2519:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt47=8;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt47=1;
                }
                break;
            case 38:
                {
                alt47=2;
                }
                break;
            case 39:
                {
                alt47=3;
                }
                break;
            case 40:
                {
                alt47=4;
                }
                break;
            case 41:
                {
                alt47=5;
                }
                break;
            case 42:
                {
                alt47=6;
                }
                break;
            case 43:
                {
                alt47=7;
                }
                break;
            case 44:
                {
                alt47=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2520:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2527:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2534:2: kw= 'Real'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2541:2: kw= 'String'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2548:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2555:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2562:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2569:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7()); 
                          
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
    // $ANTLR end "rulePrimitiveTypeIdentifier"


    // $ANTLR start "entryRulePrimitiveType"
    // InternalBacktrackingContentAssistTestLanguage.g:2582:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2583:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2584:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveType; 
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
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // InternalBacktrackingContentAssistTestLanguage.g:2591:1: rulePrimitiveType returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2594:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2595:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2595:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2596:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2596:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:2597:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_name_0_0=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.PrimitiveTypeIdentifier");
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
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleCollectionTypeIdentifier"
    // InternalBacktrackingContentAssistTestLanguage.g:2621:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2622:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2623:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
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
    // $ANTLR end "entryRuleCollectionTypeIdentifier"


    // $ANTLR start "ruleCollectionTypeIdentifier"
    // InternalBacktrackingContentAssistTestLanguage.g:2630:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2633:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2634:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2634:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt48=5;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt48=1;
                }
                break;
            case 46:
                {
                alt48=2;
                }
                break;
            case 47:
                {
                alt48=3;
                }
                break;
            case 48:
                {
                alt48=4;
                }
                break;
            case 49:
                {
                alt48=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2635:2: kw= 'Set'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2642:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2649:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2656:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2663:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4()); 
                          
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
    // $ANTLR end "ruleCollectionTypeIdentifier"


    // $ANTLR start "entryRuleTypeExp"
    // InternalBacktrackingContentAssistTestLanguage.g:2676:1: entryRuleTypeExp returns [EObject current=null] : iv_ruleTypeExp= ruleTypeExp EOF ;
    public final EObject entryRuleTypeExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2677:2: (iv_ruleTypeExp= ruleTypeExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2678:2: iv_ruleTypeExp= ruleTypeExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeExp=ruleTypeExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExp; 
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
    // $ANTLR end "entryRuleTypeExp"


    // $ANTLR start "ruleTypeExp"
    // InternalBacktrackingContentAssistTestLanguage.g:2685:1: ruleTypeExp returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_NameExp_1= ruleNameExp | this_CollectionType_2= ruleCollectionType | this_TupleType_3= ruleTupleType ) ;
    public final EObject ruleTypeExp() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_NameExp_1 = null;

        EObject this_CollectionType_2 = null;

        EObject this_TupleType_3 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2688:28: ( (this_PrimitiveType_0= rulePrimitiveType | this_NameExp_1= ruleNameExp | this_CollectionType_2= ruleCollectionType | this_TupleType_3= ruleTupleType ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2689:1: (this_PrimitiveType_0= rulePrimitiveType | this_NameExp_1= ruleNameExp | this_CollectionType_2= ruleCollectionType | this_TupleType_3= ruleTupleType )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2689:1: (this_PrimitiveType_0= rulePrimitiveType | this_NameExp_1= ruleNameExp | this_CollectionType_2= ruleCollectionType | this_TupleType_3= ruleTupleType )
            int alt49=4;
            switch ( input.LA(1) ) {
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                {
                alt49=1;
                }
                break;
            case RULE_ID:
            case 33:
            case 34:
                {
                alt49=2;
                }
                break;
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt49=3;
                }
                break;
            case 50:
                {
                alt49=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2690:2: this_PrimitiveType_0= rulePrimitiveType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpAccess().getPrimitiveTypeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PrimitiveType_0=rulePrimitiveType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimitiveType_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2703:2: this_NameExp_1= ruleNameExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpAccess().getNameExpParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NameExp_1=ruleNameExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NameExp_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2716:2: this_CollectionType_2= ruleCollectionType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpAccess().getCollectionTypeParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CollectionType_2=ruleCollectionType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionType_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2729:2: this_TupleType_3= ruleTupleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpAccess().getTupleTypeParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TupleType_3=ruleTupleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TupleType_3; 
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
    // $ANTLR end "ruleTypeExp"


    // $ANTLR start "entryRuleCollectionType"
    // InternalBacktrackingContentAssistTestLanguage.g:2748:1: entryRuleCollectionType returns [EObject current=null] : iv_ruleCollectionType= ruleCollectionType EOF ;
    public final EObject entryRuleCollectionType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionType = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2749:2: (iv_ruleCollectionType= ruleCollectionType EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2750:2: iv_ruleCollectionType= ruleCollectionType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionType=ruleCollectionType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionType; 
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
    // $ANTLR end "entryRuleCollectionType"


    // $ANTLR start "ruleCollectionType"
    // InternalBacktrackingContentAssistTestLanguage.g:2757:1: ruleCollectionType returns [EObject current=null] : ( ( (lv_typeIdentifier_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_typeIdentifier_0_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2760:28: ( ( ( (lv_typeIdentifier_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= ')' )? ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2761:1: ( ( (lv_typeIdentifier_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= ')' )? )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2761:1: ( ( (lv_typeIdentifier_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= ')' )? )
            // InternalBacktrackingContentAssistTestLanguage.g:2761:2: ( (lv_typeIdentifier_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= ')' )?
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2761:2: ( (lv_typeIdentifier_0_0= ruleCollectionTypeIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2762:1: (lv_typeIdentifier_0_0= ruleCollectionTypeIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2762:1: (lv_typeIdentifier_0_0= ruleCollectionTypeIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:2763:3: lv_typeIdentifier_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeAccess().getTypeIdentifierCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_32);
            lv_typeIdentifier_0_0=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionTypeRule());
              	        }
                     		set(
                     			current, 
                     			"typeIdentifier",
                      		lv_typeIdentifier_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.CollectionTypeIdentifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBacktrackingContentAssistTestLanguage.g:2779:2: (otherlv_1= '(' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= ')' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==16) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2779:4: otherlv_1= '(' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:2783:1: ( (lv_type_2_0= ruleTypeExp ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:2784:1: (lv_type_2_0= ruleTypeExp )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2784:1: (lv_type_2_0= ruleTypeExp )
                    // InternalBacktrackingContentAssistTestLanguage.g:2785:3: lv_type_2_0= ruleTypeExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeAccess().getTypeTypeExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_33);
                    lv_type_2_0=ruleTypeExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_2_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TypeExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCollectionTypeAccess().getRightParenthesisKeyword_1_2());
                          
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
    // $ANTLR end "ruleCollectionType"


    // $ANTLR start "entryRuleTupleType"
    // InternalBacktrackingContentAssistTestLanguage.g:2813:1: entryRuleTupleType returns [EObject current=null] : iv_ruleTupleType= ruleTupleType EOF ;
    public final EObject entryRuleTupleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleType = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2814:2: (iv_ruleTupleType= ruleTupleType EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2815:2: iv_ruleTupleType= ruleTupleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTupleType=ruleTupleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleType; 
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
    // $ANTLR end "entryRuleTupleType"


    // $ANTLR start "ruleTupleType"
    // InternalBacktrackingContentAssistTestLanguage.g:2822:1: ruleTupleType returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) otherlv_1= '(' ( ( (lv_part_2_0= ruletuplePart ) ) (otherlv_3= ',' ( (lv_part_4_0= ruletuplePart ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleTupleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_part_2_0 = null;

        EObject lv_part_4_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2825:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) otherlv_1= '(' ( ( (lv_part_2_0= ruletuplePart ) ) (otherlv_3= ',' ( (lv_part_4_0= ruletuplePart ) ) )* )? otherlv_5= ')' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2826:1: ( ( (lv_name_0_0= 'Tuple' ) ) otherlv_1= '(' ( ( (lv_part_2_0= ruletuplePart ) ) (otherlv_3= ',' ( (lv_part_4_0= ruletuplePart ) ) )* )? otherlv_5= ')' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2826:1: ( ( (lv_name_0_0= 'Tuple' ) ) otherlv_1= '(' ( ( (lv_part_2_0= ruletuplePart ) ) (otherlv_3= ',' ( (lv_part_4_0= ruletuplePart ) ) )* )? otherlv_5= ')' )
            // InternalBacktrackingContentAssistTestLanguage.g:2826:2: ( (lv_name_0_0= 'Tuple' ) ) otherlv_1= '(' ( ( (lv_part_2_0= ruletuplePart ) ) (otherlv_3= ',' ( (lv_part_4_0= ruletuplePart ) ) )* )? otherlv_5= ')'
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2826:2: ( (lv_name_0_0= 'Tuple' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2827:1: (lv_name_0_0= 'Tuple' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2827:1: (lv_name_0_0= 'Tuple' )
            // InternalBacktrackingContentAssistTestLanguage.g:2828:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,50,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getTupleTypeAccess().getNameTupleKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTupleTypeRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "Tuple");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleTypeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:2845:1: ( ( (lv_part_2_0= ruletuplePart ) ) (otherlv_3= ',' ( (lv_part_4_0= ruletuplePart ) ) )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID||(LA52_0>=33 && LA52_0<=34)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2845:2: ( (lv_part_2_0= ruletuplePart ) ) (otherlv_3= ',' ( (lv_part_4_0= ruletuplePart ) ) )*
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2845:2: ( (lv_part_2_0= ruletuplePart ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:2846:1: (lv_part_2_0= ruletuplePart )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2846:1: (lv_part_2_0= ruletuplePart )
                    // InternalBacktrackingContentAssistTestLanguage.g:2847:3: lv_part_2_0= ruletuplePart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleTypeAccess().getPartTuplePartParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_12);
                    lv_part_2_0=ruletuplePart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTupleTypeRule());
                      	        }
                             		add(
                             			current, 
                             			"part",
                              		lv_part_2_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.tuplePart");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:2863:2: (otherlv_3= ',' ( (lv_part_4_0= ruletuplePart ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==17) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalBacktrackingContentAssistTestLanguage.g:2863:4: otherlv_3= ',' ( (lv_part_4_0= ruletuplePart ) )
                    	    {
                    	    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalBacktrackingContentAssistTestLanguage.g:2867:1: ( (lv_part_4_0= ruletuplePart ) )
                    	    // InternalBacktrackingContentAssistTestLanguage.g:2868:1: (lv_part_4_0= ruletuplePart )
                    	    {
                    	    // InternalBacktrackingContentAssistTestLanguage.g:2868:1: (lv_part_4_0= ruletuplePart )
                    	    // InternalBacktrackingContentAssistTestLanguage.g:2869:3: lv_part_4_0= ruletuplePart
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTupleTypeAccess().getPartTuplePartParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_12);
                    	    lv_part_4_0=ruletuplePart();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTupleTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"part",
                    	              		lv_part_4_0, 
                    	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.tuplePart");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getTupleTypeAccess().getRightParenthesisKeyword_3());
                  
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
    // $ANTLR end "ruleTupleType"


    // $ANTLR start "entryRuletuplePart"
    // InternalBacktrackingContentAssistTestLanguage.g:2897:1: entryRuletuplePart returns [EObject current=null] : iv_ruletuplePart= ruletuplePart EOF ;
    public final EObject entryRuletuplePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletuplePart = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2898:2: (iv_ruletuplePart= ruletuplePart EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2899:2: iv_ruletuplePart= ruletuplePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruletuplePart=ruletuplePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruletuplePart; 
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
    // $ANTLR end "entryRuletuplePart"


    // $ANTLR start "ruletuplePart"
    // InternalBacktrackingContentAssistTestLanguage.g:2906:1: ruletuplePart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) ) ;
    public final EObject ruletuplePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2909:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2910:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2910:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2910:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2910:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2911:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2911:1: (lv_name_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:2912:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_5);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTuplePartRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartAccess().getColonKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:2932:1: ( (lv_type_2_0= ruleTypeExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2933:1: (lv_type_2_0= ruleTypeExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2933:1: (lv_type_2_0= ruleTypeExp )
            // InternalBacktrackingContentAssistTestLanguage.g:2934:3: lv_type_2_0= ruleTypeExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartAccess().getTypeTypeExpParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_type_2_0=ruleTypeExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTuplePartRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TypeExp");
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
    // $ANTLR end "ruletuplePart"


    // $ANTLR start "entryRuleCollectionLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:2958:1: entryRuleCollectionLiteralExp returns [EObject current=null] : iv_ruleCollectionLiteralExp= ruleCollectionLiteralExp EOF ;
    public final EObject entryRuleCollectionLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2959:2: (iv_ruleCollectionLiteralExp= ruleCollectionLiteralExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:2960:2: iv_ruleCollectionLiteralExp= ruleCollectionLiteralExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionLiteralExp=ruleCollectionLiteralExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExp; 
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
    // $ANTLR end "entryRuleCollectionLiteralExp"


    // $ANTLR start "ruleCollectionLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:2967:1: ruleCollectionLiteralExp returns [EObject current=null] : (this_CollectionType_0= ruleCollectionType ( () otherlv_2= '{' ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart ) ) (otherlv_4= ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart ) ) )* )? otherlv_6= '}' )? ) ;
    public final EObject ruleCollectionLiteralExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_CollectionType_0 = null;

        EObject lv_collectionLiteralParts_3_0 = null;

        EObject lv_collectionLiteralParts_5_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:2970:28: ( (this_CollectionType_0= ruleCollectionType ( () otherlv_2= '{' ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart ) ) (otherlv_4= ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart ) ) )* )? otherlv_6= '}' )? ) )
            // InternalBacktrackingContentAssistTestLanguage.g:2971:1: (this_CollectionType_0= ruleCollectionType ( () otherlv_2= '{' ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart ) ) (otherlv_4= ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart ) ) )* )? otherlv_6= '}' )? )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:2971:1: (this_CollectionType_0= ruleCollectionType ( () otherlv_2= '{' ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart ) ) (otherlv_4= ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart ) ) )* )? otherlv_6= '}' )? )
            // InternalBacktrackingContentAssistTestLanguage.g:2972:2: this_CollectionType_0= ruleCollectionType ( () otherlv_2= '{' ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart ) ) (otherlv_4= ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart ) ) )* )? otherlv_6= '}' )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCollectionLiteralExpAccess().getCollectionTypeParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_35);
            this_CollectionType_0=ruleCollectionType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_CollectionType_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:2983:1: ( () otherlv_2= '{' ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart ) ) (otherlv_4= ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart ) ) )* )? otherlv_6= '}' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==51) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:2983:2: () otherlv_2= '{' ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart ) ) (otherlv_4= ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart ) ) )* )? otherlv_6= '}'
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:2983:2: ()
                    // InternalBacktrackingContentAssistTestLanguage.g:2984:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getCollectionLiteralExpAccess().getCollectionLiteralExpTypeAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,51,FollowSets000.FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getCollectionLiteralExpAccess().getLeftCurlyBracketKeyword_1_1());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:2996:1: ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart ) ) (otherlv_4= ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart ) ) )* )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( ((LA54_0>=RULE_INT && LA54_0<=RULE_STRING)||LA54_0==16||(LA54_0>=33 && LA54_0<=34)||(LA54_0>=36 && LA54_0<=50)||(LA54_0>=54 && LA54_0<=57)||LA54_0==69||(LA54_0>=75 && LA54_0<=76)||LA54_0==80) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:2996:2: ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart ) ) (otherlv_4= ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart ) ) )*
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:2996:2: ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart ) )
                            // InternalBacktrackingContentAssistTestLanguage.g:2997:1: (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart )
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:2997:1: (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart )
                            // InternalBacktrackingContentAssistTestLanguage.g:2998:3: lv_collectionLiteralParts_3_0= ruleCollectionLiteralPart
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCollectionLiteralExpAccess().getCollectionLiteralPartsCollectionLiteralPartParserRuleCall_1_2_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_37);
                            lv_collectionLiteralParts_3_0=ruleCollectionLiteralPart();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"collectionLiteralParts",
                                      		lv_collectionLiteralParts_3_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.CollectionLiteralPart");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalBacktrackingContentAssistTestLanguage.g:3014:2: (otherlv_4= ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart ) ) )*
                            loop53:
                            do {
                                int alt53=2;
                                int LA53_0 = input.LA(1);

                                if ( (LA53_0==17) ) {
                                    alt53=1;
                                }


                                switch (alt53) {
                            	case 1 :
                            	    // InternalBacktrackingContentAssistTestLanguage.g:3014:4: otherlv_4= ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart ) )
                            	    {
                            	    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_6); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_4, grammarAccess.getCollectionLiteralExpAccess().getCommaKeyword_1_2_1_0());
                            	          
                            	    }
                            	    // InternalBacktrackingContentAssistTestLanguage.g:3018:1: ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart ) )
                            	    // InternalBacktrackingContentAssistTestLanguage.g:3019:1: (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart )
                            	    {
                            	    // InternalBacktrackingContentAssistTestLanguage.g:3019:1: (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart )
                            	    // InternalBacktrackingContentAssistTestLanguage.g:3020:3: lv_collectionLiteralParts_5_0= ruleCollectionLiteralPart
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpAccess().getCollectionLiteralPartsCollectionLiteralPartParserRuleCall_1_2_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_37);
                            	    lv_collectionLiteralParts_5_0=ruleCollectionLiteralPart();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"collectionLiteralParts",
                            	              		lv_collectionLiteralParts_5_0, 
                            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.CollectionLiteralPart");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop53;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getCollectionLiteralExpAccess().getRightCurlyBracketKeyword_1_3());
                          
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
    // $ANTLR end "ruleCollectionLiteralExp"


    // $ANTLR start "entryRuleCollectionLiteralPart"
    // InternalBacktrackingContentAssistTestLanguage.g:3048:1: entryRuleCollectionLiteralPart returns [EObject current=null] : iv_ruleCollectionLiteralPart= ruleCollectionLiteralPart EOF ;
    public final EObject entryRuleCollectionLiteralPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPart = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3049:2: (iv_ruleCollectionLiteralPart= ruleCollectionLiteralPart EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3050:2: iv_ruleCollectionLiteralPart= ruleCollectionLiteralPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionLiteralPart=ruleCollectionLiteralPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPart; 
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
    // $ANTLR end "entryRuleCollectionLiteralPart"


    // $ANTLR start "ruleCollectionLiteralPart"
    // InternalBacktrackingContentAssistTestLanguage.g:3057:1: ruleCollectionLiteralPart returns [EObject current=null] : ( ( (lv_expression_0_0= ruleExpression ) ) (otherlv_1= '..' ( (lv_lastExpression_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleCollectionLiteralPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_0_0 = null;

        EObject lv_lastExpression_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3060:28: ( ( ( (lv_expression_0_0= ruleExpression ) ) (otherlv_1= '..' ( (lv_lastExpression_2_0= ruleExpression ) ) )? ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3061:1: ( ( (lv_expression_0_0= ruleExpression ) ) (otherlv_1= '..' ( (lv_lastExpression_2_0= ruleExpression ) ) )? )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3061:1: ( ( (lv_expression_0_0= ruleExpression ) ) (otherlv_1= '..' ( (lv_lastExpression_2_0= ruleExpression ) ) )? )
            // InternalBacktrackingContentAssistTestLanguage.g:3061:2: ( (lv_expression_0_0= ruleExpression ) ) (otherlv_1= '..' ( (lv_lastExpression_2_0= ruleExpression ) ) )?
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3061:2: ( (lv_expression_0_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3062:1: (lv_expression_0_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3062:1: (lv_expression_0_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:3063:3: lv_expression_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralPartAccess().getExpressionExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_38);
            lv_expression_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBacktrackingContentAssistTestLanguage.g:3079:2: (otherlv_1= '..' ( (lv_lastExpression_2_0= ruleExpression ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==53) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:3079:4: otherlv_1= '..' ( (lv_lastExpression_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,53,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:3083:1: ( (lv_lastExpression_2_0= ruleExpression ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:3084:1: (lv_lastExpression_2_0= ruleExpression )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:3084:1: (lv_lastExpression_2_0= ruleExpression )
                    // InternalBacktrackingContentAssistTestLanguage.g:3085:3: lv_lastExpression_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartAccess().getLastExpressionExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_lastExpression_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartRule());
                      	        }
                             		set(
                             			current, 
                             			"lastExpression",
                              		lv_lastExpression_2_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
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
    // $ANTLR end "ruleCollectionLiteralPart"


    // $ANTLR start "entryRulePrimitiveLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3109:1: entryRulePrimitiveLiteralExp returns [EObject current=null] : iv_rulePrimitiveLiteralExp= rulePrimitiveLiteralExp EOF ;
    public final EObject entryRulePrimitiveLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3110:2: (iv_rulePrimitiveLiteralExp= rulePrimitiveLiteralExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3111:2: iv_rulePrimitiveLiteralExp= rulePrimitiveLiteralExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimitiveLiteralExp=rulePrimitiveLiteralExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExp; 
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
    // $ANTLR end "entryRulePrimitiveLiteralExp"


    // $ANTLR start "rulePrimitiveLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3118:1: rulePrimitiveLiteralExp returns [EObject current=null] : (this_NumberLiteralExp_0= ruleNumberLiteralExp | this_StringLiteralExp_1= ruleStringLiteralExp | this_BooleanLiteralExp_2= ruleBooleanLiteralExp | this_InvalidLiteralExp_3= ruleInvalidLiteralExp | this_NullLiteralExp_4= ruleNullLiteralExp ) ;
    public final EObject rulePrimitiveLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralExp_0 = null;

        EObject this_StringLiteralExp_1 = null;

        EObject this_BooleanLiteralExp_2 = null;

        EObject this_InvalidLiteralExp_3 = null;

        EObject this_NullLiteralExp_4 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3121:28: ( (this_NumberLiteralExp_0= ruleNumberLiteralExp | this_StringLiteralExp_1= ruleStringLiteralExp | this_BooleanLiteralExp_2= ruleBooleanLiteralExp | this_InvalidLiteralExp_3= ruleInvalidLiteralExp | this_NullLiteralExp_4= ruleNullLiteralExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3122:1: (this_NumberLiteralExp_0= ruleNumberLiteralExp | this_StringLiteralExp_1= ruleStringLiteralExp | this_BooleanLiteralExp_2= ruleBooleanLiteralExp | this_InvalidLiteralExp_3= ruleInvalidLiteralExp | this_NullLiteralExp_4= ruleNullLiteralExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3122:1: (this_NumberLiteralExp_0= ruleNumberLiteralExp | this_StringLiteralExp_1= ruleStringLiteralExp | this_BooleanLiteralExp_2= ruleBooleanLiteralExp | this_InvalidLiteralExp_3= ruleInvalidLiteralExp | this_NullLiteralExp_4= ruleNullLiteralExp )
            int alt57=5;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt57=1;
                }
                break;
            case RULE_STRING:
                {
                alt57=2;
                }
                break;
            case 54:
            case 55:
                {
                alt57=3;
                }
                break;
            case 56:
                {
                alt57=4;
                }
                break;
            case 57:
                {
                alt57=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:3123:2: this_NumberLiteralExp_0= ruleNumberLiteralExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpAccess().getNumberLiteralExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NumberLiteralExp_0=ruleNumberLiteralExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NumberLiteralExp_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:3136:2: this_StringLiteralExp_1= ruleStringLiteralExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpAccess().getStringLiteralExpParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_StringLiteralExp_1=ruleStringLiteralExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StringLiteralExp_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalBacktrackingContentAssistTestLanguage.g:3149:2: this_BooleanLiteralExp_2= ruleBooleanLiteralExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpAccess().getBooleanLiteralExpParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BooleanLiteralExp_2=ruleBooleanLiteralExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BooleanLiteralExp_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalBacktrackingContentAssistTestLanguage.g:3162:2: this_InvalidLiteralExp_3= ruleInvalidLiteralExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpAccess().getInvalidLiteralExpParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_InvalidLiteralExp_3=ruleInvalidLiteralExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_InvalidLiteralExp_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalBacktrackingContentAssistTestLanguage.g:3175:2: this_NullLiteralExp_4= ruleNullLiteralExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpAccess().getNullLiteralExpParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NullLiteralExp_4=ruleNullLiteralExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NullLiteralExp_4; 
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
    // $ANTLR end "rulePrimitiveLiteralExp"


    // $ANTLR start "entryRuleTupleLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3194:1: entryRuleTupleLiteralExp returns [EObject current=null] : iv_ruleTupleLiteralExp= ruleTupleLiteralExp EOF ;
    public final EObject entryRuleTupleLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3195:2: (iv_ruleTupleLiteralExp= ruleTupleLiteralExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3196:2: iv_ruleTupleLiteralExp= ruleTupleLiteralExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTupleLiteralExp=ruleTupleLiteralExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExp; 
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
    // $ANTLR end "entryRuleTupleLiteralExp"


    // $ANTLR start "ruleTupleLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3203:1: ruleTupleLiteralExp returns [EObject current=null] : ( () otherlv_1= 'Tuple' (otherlv_2= '{' ( (lv_part_3_0= ruleTupleLiteralPart ) ) (otherlv_4= ',' ( (lv_part_5_0= ruleTupleLiteralPart ) ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleTupleLiteralExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_part_3_0 = null;

        EObject lv_part_5_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3206:28: ( ( () otherlv_1= 'Tuple' (otherlv_2= '{' ( (lv_part_3_0= ruleTupleLiteralPart ) ) (otherlv_4= ',' ( (lv_part_5_0= ruleTupleLiteralPart ) ) )* otherlv_6= '}' )? ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3207:1: ( () otherlv_1= 'Tuple' (otherlv_2= '{' ( (lv_part_3_0= ruleTupleLiteralPart ) ) (otherlv_4= ',' ( (lv_part_5_0= ruleTupleLiteralPart ) ) )* otherlv_6= '}' )? )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3207:1: ( () otherlv_1= 'Tuple' (otherlv_2= '{' ( (lv_part_3_0= ruleTupleLiteralPart ) ) (otherlv_4= ',' ( (lv_part_5_0= ruleTupleLiteralPart ) ) )* otherlv_6= '}' )? )
            // InternalBacktrackingContentAssistTestLanguage.g:3207:2: () otherlv_1= 'Tuple' (otherlv_2= '{' ( (lv_part_3_0= ruleTupleLiteralPart ) ) (otherlv_4= ',' ( (lv_part_5_0= ruleTupleLiteralPart ) ) )* otherlv_6= '}' )?
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3207:2: ()
            // InternalBacktrackingContentAssistTestLanguage.g:3208:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getTupleLiteralExpAccess().getTupleLiteralExpAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpAccess().getTupleKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:3220:1: (otherlv_2= '{' ( (lv_part_3_0= ruleTupleLiteralPart ) ) (otherlv_4= ',' ( (lv_part_5_0= ruleTupleLiteralPart ) ) )* otherlv_6= '}' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==51) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:3220:3: otherlv_2= '{' ( (lv_part_3_0= ruleTupleLiteralPart ) ) (otherlv_4= ',' ( (lv_part_5_0= ruleTupleLiteralPart ) ) )* otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,51,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTupleLiteralExpAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:3224:1: ( (lv_part_3_0= ruleTupleLiteralPart ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:3225:1: (lv_part_3_0= ruleTupleLiteralPart )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:3225:1: (lv_part_3_0= ruleTupleLiteralPart )
                    // InternalBacktrackingContentAssistTestLanguage.g:3226:3: lv_part_3_0= ruleTupleLiteralPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralExpAccess().getPartTupleLiteralPartParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_37);
                    lv_part_3_0=ruleTupleLiteralPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTupleLiteralExpRule());
                      	        }
                             		add(
                             			current, 
                             			"part",
                              		lv_part_3_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TupleLiteralPart");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:3242:2: (otherlv_4= ',' ( (lv_part_5_0= ruleTupleLiteralPart ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==17) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalBacktrackingContentAssistTestLanguage.g:3242:4: otherlv_4= ',' ( (lv_part_5_0= ruleTupleLiteralPart ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getTupleLiteralExpAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // InternalBacktrackingContentAssistTestLanguage.g:3246:1: ( (lv_part_5_0= ruleTupleLiteralPart ) )
                    	    // InternalBacktrackingContentAssistTestLanguage.g:3247:1: (lv_part_5_0= ruleTupleLiteralPart )
                    	    {
                    	    // InternalBacktrackingContentAssistTestLanguage.g:3247:1: (lv_part_5_0= ruleTupleLiteralPart )
                    	    // InternalBacktrackingContentAssistTestLanguage.g:3248:3: lv_part_5_0= ruleTupleLiteralPart
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTupleLiteralExpAccess().getPartTupleLiteralPartParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_37);
                    	    lv_part_5_0=ruleTupleLiteralPart();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTupleLiteralExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"part",
                    	              		lv_part_5_0, 
                    	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TupleLiteralPart");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getTupleLiteralExpAccess().getRightCurlyBracketKeyword_2_3());
                          
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
    // $ANTLR end "ruleTupleLiteralExp"


    // $ANTLR start "entryRuleTupleLiteralPart"
    // InternalBacktrackingContentAssistTestLanguage.g:3276:1: entryRuleTupleLiteralPart returns [EObject current=null] : iv_ruleTupleLiteralPart= ruleTupleLiteralPart EOF ;
    public final EObject entryRuleTupleLiteralPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPart = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3277:2: (iv_ruleTupleLiteralPart= ruleTupleLiteralPart EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3278:2: iv_ruleTupleLiteralPart= ruleTupleLiteralPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTupleLiteralPart=ruleTupleLiteralPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPart; 
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
    // $ANTLR end "entryRuleTupleLiteralPart"


    // $ANTLR start "ruleTupleLiteralPart"
    // InternalBacktrackingContentAssistTestLanguage.g:3285:1: ruleTupleLiteralPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) ) ) ;
    public final EObject ruleTupleLiteralPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3288:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3289:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3289:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3289:2: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3289:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3290:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3290:1: (lv_name_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:3291:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_39);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBacktrackingContentAssistTestLanguage.g:3307:2: (otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==12) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:3307:4: otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) )
                    {
                    otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartAccess().getColonKeyword_1_0());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:3311:1: ( (lv_type_2_0= ruleTypeExp ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:3312:1: (lv_type_2_0= ruleTypeExp )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:3312:1: (lv_type_2_0= ruleTypeExp )
                    // InternalBacktrackingContentAssistTestLanguage.g:3313:3: lv_type_2_0= ruleTypeExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartAccess().getTypeTypeExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_15);
                    lv_type_2_0=ruleTypeExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_2_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TypeExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartAccess().getEqualsSignKeyword_2());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:3333:1: ( (lv_initExpression_4_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3334:1: (lv_initExpression_4_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3334:1: (lv_initExpression_4_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:3335:3: lv_initExpression_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartAccess().getInitExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_initExpression_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartRule());
              	        }
                     		set(
                     			current, 
                     			"initExpression",
                      		lv_initExpression_4_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
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
    // $ANTLR end "ruleTupleLiteralPart"


    // $ANTLR start "entryRuleNumberLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3359:1: entryRuleNumberLiteralExp returns [EObject current=null] : iv_ruleNumberLiteralExp= ruleNumberLiteralExp EOF ;
    public final EObject entryRuleNumberLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3360:2: (iv_ruleNumberLiteralExp= ruleNumberLiteralExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3361:2: iv_ruleNumberLiteralExp= ruleNumberLiteralExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNumberLiteralExp=ruleNumberLiteralExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExp; 
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
    // $ANTLR end "entryRuleNumberLiteralExp"


    // $ANTLR start "ruleNumberLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3368:1: ruleNumberLiteralExp returns [EObject current=null] : ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExp() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3371:28: ( ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3372:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3372:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3373:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3373:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            // InternalBacktrackingContentAssistTestLanguage.g:3374:3: lv_name_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpAccess().getNameNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_name_0_0=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumberLiteralExpRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.NUMBER_LITERAL");
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
    // $ANTLR end "ruleNumberLiteralExp"


    // $ANTLR start "entryRuleStringLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3398:1: entryRuleStringLiteralExp returns [EObject current=null] : iv_ruleStringLiteralExp= ruleStringLiteralExp EOF ;
    public final EObject entryRuleStringLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3399:2: (iv_ruleStringLiteralExp= ruleStringLiteralExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3400:2: iv_ruleStringLiteralExp= ruleStringLiteralExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringLiteralExp=ruleStringLiteralExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExp; 
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
    // $ANTLR end "entryRuleStringLiteralExp"


    // $ANTLR start "ruleStringLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3407:1: ruleStringLiteralExp returns [EObject current=null] : ( (lv_values_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExp() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_values_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3410:28: ( ( (lv_values_0_0= ruleStringLiteral ) )+ )
            // InternalBacktrackingContentAssistTestLanguage.g:3411:1: ( (lv_values_0_0= ruleStringLiteral ) )+
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3411:1: ( (lv_values_0_0= ruleStringLiteral ) )+
            int cnt61=0;
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_STRING) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:3412:1: (lv_values_0_0= ruleStringLiteral )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3412:1: (lv_values_0_0= ruleStringLiteral )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3413:3: lv_values_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpAccess().getValuesStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_40);
            	    lv_values_0_0=ruleStringLiteral();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStringLiteralExpRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"values",
            	              		lv_values_0_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.StringLiteral");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt61 >= 1 ) break loop61;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(61, input);
                        throw eee;
                }
                cnt61++;
            } while (true);


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
    // $ANTLR end "ruleStringLiteralExp"


    // $ANTLR start "entryRuleBooleanLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3437:1: entryRuleBooleanLiteralExp returns [EObject current=null] : iv_ruleBooleanLiteralExp= ruleBooleanLiteralExp EOF ;
    public final EObject entryRuleBooleanLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3438:2: (iv_ruleBooleanLiteralExp= ruleBooleanLiteralExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3439:2: iv_ruleBooleanLiteralExp= ruleBooleanLiteralExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanLiteralExp=ruleBooleanLiteralExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExp; 
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
    // $ANTLR end "entryRuleBooleanLiteralExp"


    // $ANTLR start "ruleBooleanLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3446:1: ruleBooleanLiteralExp returns [EObject current=null] : ( () ( ( (lv_isTrue_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralExp() throws RecognitionException {
        EObject current = null;

        Token lv_isTrue_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3449:28: ( ( () ( ( (lv_isTrue_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3450:1: ( () ( ( (lv_isTrue_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3450:1: ( () ( ( (lv_isTrue_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3450:2: () ( ( (lv_isTrue_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3450:2: ()
            // InternalBacktrackingContentAssistTestLanguage.g:3451:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBooleanLiteralExpAccess().getBooleanLiteralExpAction_0(),
                          current);
                  
            }

            }

            // InternalBacktrackingContentAssistTestLanguage.g:3459:2: ( ( (lv_isTrue_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==54) ) {
                alt62=1;
            }
            else if ( (LA62_0==55) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:3459:3: ( (lv_isTrue_1_0= 'true' ) )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:3459:3: ( (lv_isTrue_1_0= 'true' ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:3460:1: (lv_isTrue_1_0= 'true' )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:3460:1: (lv_isTrue_1_0= 'true' )
                    // InternalBacktrackingContentAssistTestLanguage.g:3461:3: lv_isTrue_1_0= 'true'
                    {
                    lv_isTrue_1_0=(Token)match(input,54,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isTrue_1_0, grammarAccess.getBooleanLiteralExpAccess().getIsTrueTrueKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralExpRule());
                      	        }
                             		setWithLastConsumed(current, "isTrue", true, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:3475:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,55,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralExpAccess().getFalseKeyword_1_1());
                          
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
    // $ANTLR end "ruleBooleanLiteralExp"


    // $ANTLR start "entryRuleInvalidLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3487:1: entryRuleInvalidLiteralExp returns [EObject current=null] : iv_ruleInvalidLiteralExp= ruleInvalidLiteralExp EOF ;
    public final EObject entryRuleInvalidLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3488:2: (iv_ruleInvalidLiteralExp= ruleInvalidLiteralExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3489:2: iv_ruleInvalidLiteralExp= ruleInvalidLiteralExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInvalidLiteralExp=ruleInvalidLiteralExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExp; 
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
    // $ANTLR end "entryRuleInvalidLiteralExp"


    // $ANTLR start "ruleInvalidLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3496:1: ruleInvalidLiteralExp returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3499:28: ( ( () otherlv_1= 'invalid' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3500:1: ( () otherlv_1= 'invalid' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3500:1: ( () otherlv_1= 'invalid' )
            // InternalBacktrackingContentAssistTestLanguage.g:3500:2: () otherlv_1= 'invalid'
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3500:2: ()
            // InternalBacktrackingContentAssistTestLanguage.g:3501:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInvalidLiteralExpAccess().getInvalidLiteralExpAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInvalidLiteralExpAccess().getInvalidKeyword_1());
                  
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
    // $ANTLR end "ruleInvalidLiteralExp"


    // $ANTLR start "entryRuleNullLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3521:1: entryRuleNullLiteralExp returns [EObject current=null] : iv_ruleNullLiteralExp= ruleNullLiteralExp EOF ;
    public final EObject entryRuleNullLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3522:2: (iv_ruleNullLiteralExp= ruleNullLiteralExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3523:2: iv_ruleNullLiteralExp= ruleNullLiteralExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullLiteralExp=ruleNullLiteralExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExp; 
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
    // $ANTLR end "entryRuleNullLiteralExp"


    // $ANTLR start "ruleNullLiteralExp"
    // InternalBacktrackingContentAssistTestLanguage.g:3530:1: ruleNullLiteralExp returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3533:28: ( ( () otherlv_1= 'null' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3534:1: ( () otherlv_1= 'null' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3534:1: ( () otherlv_1= 'null' )
            // InternalBacktrackingContentAssistTestLanguage.g:3534:2: () otherlv_1= 'null'
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3534:2: ()
            // InternalBacktrackingContentAssistTestLanguage.g:3535:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNullLiteralExpAccess().getNullLiteralExpAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,57,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNullLiteralExpAccess().getNullKeyword_1());
                  
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
    // $ANTLR end "ruleNullLiteralExp"


    // $ANTLR start "entryRuleExpression"
    // InternalBacktrackingContentAssistTestLanguage.g:3555:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3556:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3557:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalBacktrackingContentAssistTestLanguage.g:3564:1: ruleExpression returns [EObject current=null] : (this_implies_0= ruleimplies | this_LetExp_1= ruleLetExp ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_implies_0 = null;

        EObject this_LetExp_1 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3567:28: ( (this_implies_0= ruleimplies | this_LetExp_1= ruleLetExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3568:1: (this_implies_0= ruleimplies | this_LetExp_1= ruleLetExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3568:1: (this_implies_0= ruleimplies | this_LetExp_1= ruleLetExp )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=RULE_INT && LA63_0<=RULE_STRING)||LA63_0==16||(LA63_0>=33 && LA63_0<=34)||(LA63_0>=36 && LA63_0<=50)||(LA63_0>=54 && LA63_0<=57)||LA63_0==69||(LA63_0>=75 && LA63_0<=76)) ) {
                alt63=1;
            }
            else if ( (LA63_0==80) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:3569:2: this_implies_0= ruleimplies
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getImpliesParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_implies_0=ruleimplies();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_implies_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:3582:2: this_LetExp_1= ruleLetExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getLetExpParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LetExp_1=ruleLetExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LetExp_1; 
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleimplies"
    // InternalBacktrackingContentAssistTestLanguage.g:3601:1: entryRuleimplies returns [EObject current=null] : iv_ruleimplies= ruleimplies EOF ;
    public final EObject entryRuleimplies() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleimplies = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3602:2: (iv_ruleimplies= ruleimplies EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3603:2: iv_ruleimplies= ruleimplies EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImpliesRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleimplies=ruleimplies();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleimplies; 
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
    // $ANTLR end "entryRuleimplies"


    // $ANTLR start "ruleimplies"
    // InternalBacktrackingContentAssistTestLanguage.g:3610:1: ruleimplies returns [EObject current=null] : (this_xor_0= rulexor ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) ) ) )* ) ;
    public final EObject ruleimplies() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_xor_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3613:28: ( (this_xor_0= rulexor ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) ) ) )* ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3614:1: (this_xor_0= rulexor ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) ) ) )* )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3614:1: (this_xor_0= rulexor ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) ) ) )* )
            // InternalBacktrackingContentAssistTestLanguage.g:3615:2: this_xor_0= rulexor ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getImpliesAccess().getXorParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_41);
            this_xor_0=rulexor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_xor_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:3626:1: ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==58) ) {
                    int LA65_2 = input.LA(2);

                    if ( (synpred87_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt65=1;
                    }


                }


                switch (alt65) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:3626:2: () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3626:2: ()
            	    // InternalBacktrackingContentAssistTestLanguage.g:3627:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getImpliesAccess().getInfixExpSourceAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:3635:2: ( (lv_op_2_0= 'implies' ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3636:1: (lv_op_2_0= 'implies' )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3636:1: (lv_op_2_0= 'implies' )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3637:3: lv_op_2_0= 'implies'
            	    {
            	    lv_op_2_0=(Token)match(input,58,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_op_2_0, grammarAccess.getImpliesAccess().getOpImpliesKeyword_1_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getImpliesRule());
            	      	        }
            	             		setWithLastConsumed(current, "op", lv_op_2_0, "implies");
            	      	    
            	    }

            	    }


            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:3650:2: ( ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3651:1: ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3651:1: ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3652:1: (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3652:1: (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp )
            	    int alt64=2;
            	    int LA64_0 = input.LA(1);

            	    if ( ((LA64_0>=RULE_INT && LA64_0<=RULE_STRING)||LA64_0==16||(LA64_0>=33 && LA64_0<=34)||(LA64_0>=36 && LA64_0<=50)||(LA64_0>=54 && LA64_0<=57)||LA64_0==69||(LA64_0>=75 && LA64_0<=76)) ) {
            	        alt64=1;
            	    }
            	    else if ( (LA64_0==80) ) {
            	        alt64=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 64, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt64) {
            	        case 1 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:3653:3: lv_argument_3_1= rulexor
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getImpliesAccess().getArgumentXorParserRuleCall_1_2_0_0()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_41);
            	            lv_argument_3_1=rulexor();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getImpliesRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_1, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.xor");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:3668:8: lv_argument_3_2= ruleLetExp
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getImpliesAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_41);
            	            lv_argument_3_2=ruleLetExp();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getImpliesRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_2, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.LetExp");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
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
    // $ANTLR end "ruleimplies"


    // $ANTLR start "entryRulexor"
    // InternalBacktrackingContentAssistTestLanguage.g:3694:1: entryRulexor returns [EObject current=null] : iv_rulexor= rulexor EOF ;
    public final EObject entryRulexor() throws RecognitionException {
        EObject current = null;

        EObject iv_rulexor = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3695:2: (iv_rulexor= rulexor EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3696:2: iv_rulexor= rulexor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulexor=rulexor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulexor; 
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
    // $ANTLR end "entryRulexor"


    // $ANTLR start "rulexor"
    // InternalBacktrackingContentAssistTestLanguage.g:3703:1: rulexor returns [EObject current=null] : (this_or_0= ruleor ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) ) ) )* ) ;
    public final EObject rulexor() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_or_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3706:28: ( (this_or_0= ruleor ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) ) ) )* ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3707:1: (this_or_0= ruleor ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) ) ) )* )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3707:1: (this_or_0= ruleor ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) ) ) )* )
            // InternalBacktrackingContentAssistTestLanguage.g:3708:2: this_or_0= ruleor ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXorAccess().getOrParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_42);
            this_or_0=ruleor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_or_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:3719:1: ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==59) ) {
                    int LA67_2 = input.LA(2);

                    if ( (synpred89_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt67=1;
                    }


                }


                switch (alt67) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:3719:2: () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3719:2: ()
            	    // InternalBacktrackingContentAssistTestLanguage.g:3720:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXorAccess().getInfixExpSourceAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:3728:2: ( (lv_op_2_0= 'xor' ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3729:1: (lv_op_2_0= 'xor' )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3729:1: (lv_op_2_0= 'xor' )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3730:3: lv_op_2_0= 'xor'
            	    {
            	    lv_op_2_0=(Token)match(input,59,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_op_2_0, grammarAccess.getXorAccess().getOpXorKeyword_1_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXorRule());
            	      	        }
            	             		setWithLastConsumed(current, "op", lv_op_2_0, "xor");
            	      	    
            	    }

            	    }


            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:3743:2: ( ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3744:1: ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3744:1: ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3745:1: (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3745:1: (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp )
            	    int alt66=2;
            	    int LA66_0 = input.LA(1);

            	    if ( ((LA66_0>=RULE_INT && LA66_0<=RULE_STRING)||LA66_0==16||(LA66_0>=33 && LA66_0<=34)||(LA66_0>=36 && LA66_0<=50)||(LA66_0>=54 && LA66_0<=57)||LA66_0==69||(LA66_0>=75 && LA66_0<=76)) ) {
            	        alt66=1;
            	    }
            	    else if ( (LA66_0==80) ) {
            	        alt66=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 66, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt66) {
            	        case 1 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:3746:3: lv_argument_3_1= ruleor
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXorAccess().getArgumentOrParserRuleCall_1_2_0_0()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_42);
            	            lv_argument_3_1=ruleor();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXorRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_1, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.or");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:3761:8: lv_argument_3_2= ruleLetExp
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXorAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_42);
            	            lv_argument_3_2=ruleLetExp();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXorRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_2, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.LetExp");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop67;
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
    // $ANTLR end "rulexor"


    // $ANTLR start "entryRuleor"
    // InternalBacktrackingContentAssistTestLanguage.g:3787:1: entryRuleor returns [EObject current=null] : iv_ruleor= ruleor EOF ;
    public final EObject entryRuleor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleor = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3788:2: (iv_ruleor= ruleor EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3789:2: iv_ruleor= ruleor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleor=ruleor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleor; 
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
    // $ANTLR end "entryRuleor"


    // $ANTLR start "ruleor"
    // InternalBacktrackingContentAssistTestLanguage.g:3796:1: ruleor returns [EObject current=null] : (this_and_0= ruleand ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) ) ) )* ) ;
    public final EObject ruleor() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_and_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3799:28: ( (this_and_0= ruleand ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) ) ) )* ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3800:1: (this_and_0= ruleand ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) ) ) )* )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3800:1: (this_and_0= ruleand ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) ) ) )* )
            // InternalBacktrackingContentAssistTestLanguage.g:3801:2: this_and_0= ruleand ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_43);
            this_and_0=ruleand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_and_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:3812:1: ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==60) ) {
                    int LA69_2 = input.LA(2);

                    if ( (synpred91_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt69=1;
                    }


                }


                switch (alt69) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:3812:2: () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3812:2: ()
            	    // InternalBacktrackingContentAssistTestLanguage.g:3813:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrAccess().getInfixExpSourceAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:3821:2: ( (lv_op_2_0= 'or' ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3822:1: (lv_op_2_0= 'or' )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3822:1: (lv_op_2_0= 'or' )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3823:3: lv_op_2_0= 'or'
            	    {
            	    lv_op_2_0=(Token)match(input,60,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_op_2_0, grammarAccess.getOrAccess().getOpOrKeyword_1_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getOrRule());
            	      	        }
            	             		setWithLastConsumed(current, "op", lv_op_2_0, "or");
            	      	    
            	    }

            	    }


            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:3836:2: ( ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3837:1: ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3837:1: ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3838:1: (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3838:1: (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp )
            	    int alt68=2;
            	    int LA68_0 = input.LA(1);

            	    if ( ((LA68_0>=RULE_INT && LA68_0<=RULE_STRING)||LA68_0==16||(LA68_0>=33 && LA68_0<=34)||(LA68_0>=36 && LA68_0<=50)||(LA68_0>=54 && LA68_0<=57)||LA68_0==69||(LA68_0>=75 && LA68_0<=76)) ) {
            	        alt68=1;
            	    }
            	    else if ( (LA68_0==80) ) {
            	        alt68=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 68, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt68) {
            	        case 1 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:3839:3: lv_argument_3_1= ruleand
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getOrAccess().getArgumentAndParserRuleCall_1_2_0_0()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_43);
            	            lv_argument_3_1=ruleand();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getOrRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_1, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.and");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:3854:8: lv_argument_3_2= ruleLetExp
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getOrAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_43);
            	            lv_argument_3_2=ruleLetExp();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getOrRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_2, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.LetExp");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
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
    // $ANTLR end "ruleor"


    // $ANTLR start "entryRuleand"
    // InternalBacktrackingContentAssistTestLanguage.g:3880:1: entryRuleand returns [EObject current=null] : iv_ruleand= ruleand EOF ;
    public final EObject entryRuleand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleand = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3881:2: (iv_ruleand= ruleand EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3882:2: iv_ruleand= ruleand EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleand=ruleand();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleand; 
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
    // $ANTLR end "entryRuleand"


    // $ANTLR start "ruleand"
    // InternalBacktrackingContentAssistTestLanguage.g:3889:1: ruleand returns [EObject current=null] : (this_equality_0= ruleequality ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) ) ) )* ) ;
    public final EObject ruleand() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_equality_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3892:28: ( (this_equality_0= ruleequality ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) ) ) )* ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3893:1: (this_equality_0= ruleequality ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) ) ) )* )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3893:1: (this_equality_0= ruleequality ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) ) ) )* )
            // InternalBacktrackingContentAssistTestLanguage.g:3894:2: this_equality_0= ruleequality ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndAccess().getEqualityParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_44);
            this_equality_0=ruleequality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_equality_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:3905:1: ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==61) ) {
                    int LA71_2 = input.LA(2);

                    if ( (synpred93_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt71=1;
                    }


                }


                switch (alt71) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:3905:2: () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3905:2: ()
            	    // InternalBacktrackingContentAssistTestLanguage.g:3906:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndAccess().getInfixExpSourceAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:3914:2: ( (lv_op_2_0= 'and' ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3915:1: (lv_op_2_0= 'and' )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3915:1: (lv_op_2_0= 'and' )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3916:3: lv_op_2_0= 'and'
            	    {
            	    lv_op_2_0=(Token)match(input,61,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_op_2_0, grammarAccess.getAndAccess().getOpAndKeyword_1_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAndRule());
            	      	        }
            	             		setWithLastConsumed(current, "op", lv_op_2_0, "and");
            	      	    
            	    }

            	    }


            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:3929:2: ( ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3930:1: ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3930:1: ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:3931:1: (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3931:1: (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp )
            	    int alt70=2;
            	    int LA70_0 = input.LA(1);

            	    if ( ((LA70_0>=RULE_INT && LA70_0<=RULE_STRING)||LA70_0==16||(LA70_0>=33 && LA70_0<=34)||(LA70_0>=36 && LA70_0<=50)||(LA70_0>=54 && LA70_0<=57)||LA70_0==69||(LA70_0>=75 && LA70_0<=76)) ) {
            	        alt70=1;
            	    }
            	    else if ( (LA70_0==80) ) {
            	        alt70=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 70, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt70) {
            	        case 1 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:3932:3: lv_argument_3_1= ruleequality
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getAndAccess().getArgumentEqualityParserRuleCall_1_2_0_0()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_44);
            	            lv_argument_3_1=ruleequality();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getAndRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_1, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.equality");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:3947:8: lv_argument_3_2= ruleLetExp
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getAndAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_44);
            	            lv_argument_3_2=ruleLetExp();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getAndRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_2, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.LetExp");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
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
    // $ANTLR end "ruleand"


    // $ANTLR start "entryRuleequality"
    // InternalBacktrackingContentAssistTestLanguage.g:3973:1: entryRuleequality returns [EObject current=null] : iv_ruleequality= ruleequality EOF ;
    public final EObject entryRuleequality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleequality = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3974:2: (iv_ruleequality= ruleequality EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:3975:2: iv_ruleequality= ruleequality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleequality=ruleequality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleequality; 
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
    // $ANTLR end "entryRuleequality"


    // $ANTLR start "ruleequality"
    // InternalBacktrackingContentAssistTestLanguage.g:3982:1: ruleequality returns [EObject current=null] : (this_relational_0= rulerelational ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) ) ) )* ) ;
    public final EObject ruleequality() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_relational_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:3985:28: ( (this_relational_0= rulerelational ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) ) ) )* ) )
            // InternalBacktrackingContentAssistTestLanguage.g:3986:1: (this_relational_0= rulerelational ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) ) ) )* )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:3986:1: (this_relational_0= rulerelational ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) ) ) )* )
            // InternalBacktrackingContentAssistTestLanguage.g:3987:2: this_relational_0= rulerelational ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEqualityAccess().getRelationalParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_45);
            this_relational_0=rulerelational();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_relational_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:3998:1: ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==19) ) {
                    int LA74_2 = input.LA(2);

                    if ( (synpred96_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt74=1;
                    }


                }
                else if ( (LA74_0==62) ) {
                    int LA74_3 = input.LA(2);

                    if ( (synpred96_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt74=1;
                    }


                }


                switch (alt74) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:3998:2: () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:3998:2: ()
            	    // InternalBacktrackingContentAssistTestLanguage.g:3999:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getEqualityAccess().getInfixExpSourceAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:4007:2: ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4008:1: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4008:1: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4009:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4009:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
            	    int alt72=2;
            	    int LA72_0 = input.LA(1);

            	    if ( (LA72_0==19) ) {
            	        alt72=1;
            	    }
            	    else if ( (LA72_0==62) ) {
            	        alt72=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 72, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt72) {
            	        case 1 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4010:3: lv_op_2_1= '='
            	            {
            	            lv_op_2_1=(Token)match(input,19,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_1, grammarAccess.getEqualityAccess().getOpEqualsSignKeyword_1_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getEqualityRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4022:8: lv_op_2_2= '<>'
            	            {
            	            lv_op_2_2=(Token)match(input,62,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_2, grammarAccess.getEqualityAccess().getOpLessThanSignGreaterThanSignKeyword_1_1_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getEqualityRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:4037:2: ( ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4038:1: ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4038:1: ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4039:1: (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4039:1: (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp )
            	    int alt73=2;
            	    int LA73_0 = input.LA(1);

            	    if ( ((LA73_0>=RULE_INT && LA73_0<=RULE_STRING)||LA73_0==16||(LA73_0>=33 && LA73_0<=34)||(LA73_0>=36 && LA73_0<=50)||(LA73_0>=54 && LA73_0<=57)||LA73_0==69||(LA73_0>=75 && LA73_0<=76)) ) {
            	        alt73=1;
            	    }
            	    else if ( (LA73_0==80) ) {
            	        alt73=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 73, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt73) {
            	        case 1 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4040:3: lv_argument_3_1= rulerelational
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getEqualityAccess().getArgumentRelationalParserRuleCall_1_2_0_0()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_45);
            	            lv_argument_3_1=rulerelational();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getEqualityRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_1, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.relational");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4055:8: lv_argument_3_2= ruleLetExp
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getEqualityAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_45);
            	            lv_argument_3_2=ruleLetExp();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getEqualityRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_2, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.LetExp");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
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
    // $ANTLR end "ruleequality"


    // $ANTLR start "entryRulerelational"
    // InternalBacktrackingContentAssistTestLanguage.g:4081:1: entryRulerelational returns [EObject current=null] : iv_rulerelational= rulerelational EOF ;
    public final EObject entryRulerelational() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerelational = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4082:2: (iv_rulerelational= rulerelational EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:4083:2: iv_rulerelational= rulerelational EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulerelational=rulerelational();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerelational; 
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
    // $ANTLR end "entryRulerelational"


    // $ANTLR start "rulerelational"
    // InternalBacktrackingContentAssistTestLanguage.g:4090:1: rulerelational returns [EObject current=null] : (this_additive_0= ruleadditive ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) ) ) )* ) ;
    public final EObject rulerelational() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_additive_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4093:28: ( (this_additive_0= ruleadditive ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) ) ) )* ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4094:1: (this_additive_0= ruleadditive ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) ) ) )* )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4094:1: (this_additive_0= ruleadditive ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) ) ) )* )
            // InternalBacktrackingContentAssistTestLanguage.g:4095:2: this_additive_0= ruleadditive ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRelationalAccess().getAdditiveParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_46);
            this_additive_0=ruleadditive();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_additive_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:4106:1: ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) ) ) )*
            loop77:
            do {
                int alt77=2;
                switch ( input.LA(1) ) {
                case 63:
                    {
                    int LA77_2 = input.LA(2);

                    if ( (synpred101_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt77=1;
                    }


                    }
                    break;
                case 64:
                    {
                    int LA77_3 = input.LA(2);

                    if ( (synpred101_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt77=1;
                    }


                    }
                    break;
                case 65:
                    {
                    int LA77_4 = input.LA(2);

                    if ( (synpred101_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt77=1;
                    }


                    }
                    break;
                case 66:
                    {
                    int LA77_5 = input.LA(2);

                    if ( (synpred101_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt77=1;
                    }


                    }
                    break;

                }

                switch (alt77) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:4106:2: () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4106:2: ()
            	    // InternalBacktrackingContentAssistTestLanguage.g:4107:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getRelationalAccess().getInfixExpSourceAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:4115:2: ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4116:1: ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4116:1: ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4117:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4117:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )
            	    int alt75=4;
            	    switch ( input.LA(1) ) {
            	    case 63:
            	        {
            	        alt75=1;
            	        }
            	        break;
            	    case 64:
            	        {
            	        alt75=2;
            	        }
            	        break;
            	    case 65:
            	        {
            	        alt75=3;
            	        }
            	        break;
            	    case 66:
            	        {
            	        alt75=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 75, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt75) {
            	        case 1 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4118:3: lv_op_2_1= '>'
            	            {
            	            lv_op_2_1=(Token)match(input,63,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_1, grammarAccess.getRelationalAccess().getOpGreaterThanSignKeyword_1_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getRelationalRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4130:8: lv_op_2_2= '<'
            	            {
            	            lv_op_2_2=(Token)match(input,64,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_2, grammarAccess.getRelationalAccess().getOpLessThanSignKeyword_1_1_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getRelationalRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4142:8: lv_op_2_3= '>='
            	            {
            	            lv_op_2_3=(Token)match(input,65,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_3, grammarAccess.getRelationalAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_2());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getRelationalRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4154:8: lv_op_2_4= '<='
            	            {
            	            lv_op_2_4=(Token)match(input,66,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_4, grammarAccess.getRelationalAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_3());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getRelationalRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_4, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:4169:2: ( ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4170:1: ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4170:1: ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4171:1: (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4171:1: (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp )
            	    int alt76=2;
            	    int LA76_0 = input.LA(1);

            	    if ( ((LA76_0>=RULE_INT && LA76_0<=RULE_STRING)||LA76_0==16||(LA76_0>=33 && LA76_0<=34)||(LA76_0>=36 && LA76_0<=50)||(LA76_0>=54 && LA76_0<=57)||LA76_0==69||(LA76_0>=75 && LA76_0<=76)) ) {
            	        alt76=1;
            	    }
            	    else if ( (LA76_0==80) ) {
            	        alt76=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 76, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt76) {
            	        case 1 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4172:3: lv_argument_3_1= ruleadditive
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getRelationalAccess().getArgumentAdditiveParserRuleCall_1_2_0_0()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_46);
            	            lv_argument_3_1=ruleadditive();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getRelationalRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_1, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.additive");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4187:8: lv_argument_3_2= ruleLetExp
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getRelationalAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_46);
            	            lv_argument_3_2=ruleLetExp();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getRelationalRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_2, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.LetExp");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop77;
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
    // $ANTLR end "rulerelational"


    // $ANTLR start "entryRuleadditive"
    // InternalBacktrackingContentAssistTestLanguage.g:4213:1: entryRuleadditive returns [EObject current=null] : iv_ruleadditive= ruleadditive EOF ;
    public final EObject entryRuleadditive() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleadditive = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4214:2: (iv_ruleadditive= ruleadditive EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:4215:2: iv_ruleadditive= ruleadditive EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleadditive=ruleadditive();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleadditive; 
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
    // $ANTLR end "entryRuleadditive"


    // $ANTLR start "ruleadditive"
    // InternalBacktrackingContentAssistTestLanguage.g:4222:1: ruleadditive returns [EObject current=null] : (this_multiplicative_0= rulemultiplicative ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) ) ) )* ) ;
    public final EObject ruleadditive() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_multiplicative_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4225:28: ( (this_multiplicative_0= rulemultiplicative ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) ) ) )* ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4226:1: (this_multiplicative_0= rulemultiplicative ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) ) ) )* )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4226:1: (this_multiplicative_0= rulemultiplicative ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) ) ) )* )
            // InternalBacktrackingContentAssistTestLanguage.g:4227:2: this_multiplicative_0= rulemultiplicative ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditiveAccess().getMultiplicativeParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_47);
            this_multiplicative_0=rulemultiplicative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_multiplicative_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:4238:1: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==35) ) {
                    int LA80_2 = input.LA(2);

                    if ( (synpred104_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt80=1;
                    }


                }
                else if ( (LA80_0==36) ) {
                    int LA80_3 = input.LA(2);

                    if ( (synpred104_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt80=1;
                    }


                }


                switch (alt80) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:4238:2: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4238:2: ()
            	    // InternalBacktrackingContentAssistTestLanguage.g:4239:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditiveAccess().getInfixExpSourceAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:4247:2: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4248:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4248:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4249:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4249:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
            	    int alt78=2;
            	    int LA78_0 = input.LA(1);

            	    if ( (LA78_0==35) ) {
            	        alt78=1;
            	    }
            	    else if ( (LA78_0==36) ) {
            	        alt78=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 78, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt78) {
            	        case 1 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4250:3: lv_op_2_1= '+'
            	            {
            	            lv_op_2_1=(Token)match(input,35,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_1, grammarAccess.getAdditiveAccess().getOpPlusSignKeyword_1_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getAdditiveRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4262:8: lv_op_2_2= '-'
            	            {
            	            lv_op_2_2=(Token)match(input,36,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_2, grammarAccess.getAdditiveAccess().getOpHyphenMinusKeyword_1_1_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getAdditiveRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:4277:2: ( ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4278:1: ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4278:1: ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4279:1: (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4279:1: (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp )
            	    int alt79=2;
            	    int LA79_0 = input.LA(1);

            	    if ( ((LA79_0>=RULE_INT && LA79_0<=RULE_STRING)||LA79_0==16||(LA79_0>=33 && LA79_0<=34)||(LA79_0>=36 && LA79_0<=50)||(LA79_0>=54 && LA79_0<=57)||LA79_0==69||(LA79_0>=75 && LA79_0<=76)) ) {
            	        alt79=1;
            	    }
            	    else if ( (LA79_0==80) ) {
            	        alt79=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 79, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt79) {
            	        case 1 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4280:3: lv_argument_3_1= rulemultiplicative
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getAdditiveAccess().getArgumentMultiplicativeParserRuleCall_1_2_0_0()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_47);
            	            lv_argument_3_1=rulemultiplicative();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getAdditiveRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_1, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.multiplicative");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4295:8: lv_argument_3_2= ruleLetExp
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getAdditiveAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_47);
            	            lv_argument_3_2=ruleLetExp();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getAdditiveRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_2, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.LetExp");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
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
    // $ANTLR end "ruleadditive"


    // $ANTLR start "entryRulemultiplicative"
    // InternalBacktrackingContentAssistTestLanguage.g:4321:1: entryRulemultiplicative returns [EObject current=null] : iv_rulemultiplicative= rulemultiplicative EOF ;
    public final EObject entryRulemultiplicative() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiplicative = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4322:2: (iv_rulemultiplicative= rulemultiplicative EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:4323:2: iv_rulemultiplicative= rulemultiplicative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulemultiplicative=rulemultiplicative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulemultiplicative; 
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
    // $ANTLR end "entryRulemultiplicative"


    // $ANTLR start "rulemultiplicative"
    // InternalBacktrackingContentAssistTestLanguage.g:4330:1: rulemultiplicative returns [EObject current=null] : (this_unary_0= ruleunary ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) ) ) )* ) ;
    public final EObject rulemultiplicative() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_unary_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4333:28: ( (this_unary_0= ruleunary ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) ) ) )* ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4334:1: (this_unary_0= ruleunary ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) ) ) )* )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4334:1: (this_unary_0= ruleunary ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) ) ) )* )
            // InternalBacktrackingContentAssistTestLanguage.g:4335:2: this_unary_0= ruleunary ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicativeAccess().getUnaryParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_48);
            this_unary_0=ruleunary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_unary_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:4346:1: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==67) ) {
                    int LA83_2 = input.LA(2);

                    if ( (synpred107_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt83=1;
                    }


                }
                else if ( (LA83_0==68) ) {
                    int LA83_3 = input.LA(2);

                    if ( (synpred107_InternalBacktrackingContentAssistTestLanguage()) ) {
                        alt83=1;
                    }


                }


                switch (alt83) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:4346:2: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4346:2: ()
            	    // InternalBacktrackingContentAssistTestLanguage.g:4347:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicativeAccess().getInfixExpSourceAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:4355:2: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4356:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4356:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4357:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4357:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    int alt81=2;
            	    int LA81_0 = input.LA(1);

            	    if ( (LA81_0==67) ) {
            	        alt81=1;
            	    }
            	    else if ( (LA81_0==68) ) {
            	        alt81=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 81, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt81) {
            	        case 1 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4358:3: lv_op_2_1= '*'
            	            {
            	            lv_op_2_1=(Token)match(input,67,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_1, grammarAccess.getMultiplicativeAccess().getOpAsteriskKeyword_1_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getMultiplicativeRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4370:8: lv_op_2_2= '/'
            	            {
            	            lv_op_2_2=(Token)match(input,68,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_2, grammarAccess.getMultiplicativeAccess().getOpSolidusKeyword_1_1_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getMultiplicativeRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalBacktrackingContentAssistTestLanguage.g:4385:2: ( ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4386:1: ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4386:1: ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:4387:1: (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:4387:1: (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp )
            	    int alt82=2;
            	    int LA82_0 = input.LA(1);

            	    if ( ((LA82_0>=RULE_INT && LA82_0<=RULE_STRING)||LA82_0==16||(LA82_0>=33 && LA82_0<=34)||(LA82_0>=36 && LA82_0<=50)||(LA82_0>=54 && LA82_0<=57)||LA82_0==69||(LA82_0>=75 && LA82_0<=76)) ) {
            	        alt82=1;
            	    }
            	    else if ( (LA82_0==80) ) {
            	        alt82=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 82, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt82) {
            	        case 1 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4388:3: lv_argument_3_1= ruleunary
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getMultiplicativeAccess().getArgumentUnaryParserRuleCall_1_2_0_0()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_48);
            	            lv_argument_3_1=ruleunary();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getMultiplicativeRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_1, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.unary");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBacktrackingContentAssistTestLanguage.g:4403:8: lv_argument_3_2= ruleLetExp
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getMultiplicativeAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_48);
            	            lv_argument_3_2=ruleLetExp();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getMultiplicativeRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"argument",
            	                      		lv_argument_3_2, 
            	                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.LetExp");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop83;
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
    // $ANTLR end "rulemultiplicative"


    // $ANTLR start "entryRuleunary"
    // InternalBacktrackingContentAssistTestLanguage.g:4429:1: entryRuleunary returns [EObject current=null] : iv_ruleunary= ruleunary EOF ;
    public final EObject entryRuleunary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunary = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4430:2: (iv_ruleunary= ruleunary EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:4431:2: iv_ruleunary= ruleunary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleunary=ruleunary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleunary; 
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
    // $ANTLR end "entryRuleunary"


    // $ANTLR start "ruleunary"
    // InternalBacktrackingContentAssistTestLanguage.g:4438:1: ruleunary returns [EObject current=null] : (this_NavigationExp_0= ruleNavigationExp | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunary ) ) ) ) ;
    public final EObject ruleunary() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_NavigationExp_0 = null;

        EObject lv_source_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4441:28: ( (this_NavigationExp_0= ruleNavigationExp | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunary ) ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4442:1: (this_NavigationExp_0= ruleNavigationExp | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunary ) ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4442:1: (this_NavigationExp_0= ruleNavigationExp | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunary ) ) ) )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( ((LA85_0>=RULE_INT && LA85_0<=RULE_STRING)||LA85_0==16||(LA85_0>=33 && LA85_0<=34)||(LA85_0>=37 && LA85_0<=50)||(LA85_0>=54 && LA85_0<=57)||(LA85_0>=75 && LA85_0<=76)) ) {
                alt85=1;
            }
            else if ( (LA85_0==36||LA85_0==69) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4443:2: this_NavigationExp_0= ruleNavigationExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryAccess().getNavigationExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NavigationExp_0=ruleNavigationExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NavigationExp_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4455:6: ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunary ) ) )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:4455:6: ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunary ) ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:4455:7: () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunary ) )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:4455:7: ()
                    // InternalBacktrackingContentAssistTestLanguage.g:4456:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnaryAccess().getPrefixExpAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:4464:2: ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:4465:1: ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:4465:1: ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:4466:1: (lv_op_2_1= '-' | lv_op_2_2= 'not' )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:4466:1: (lv_op_2_1= '-' | lv_op_2_2= 'not' )
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==36) ) {
                        alt84=1;
                    }
                    else if ( (LA84_0==69) ) {
                        alt84=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 84, 0, input);

                        throw nvae;
                    }
                    switch (alt84) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:4467:3: lv_op_2_1= '-'
                            {
                            lv_op_2_1=(Token)match(input,36,FollowSets000.FOLLOW_49); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getUnaryAccess().getOpHyphenMinusKeyword_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnaryRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalBacktrackingContentAssistTestLanguage.g:4479:8: lv_op_2_2= 'not'
                            {
                            lv_op_2_2=(Token)match(input,69,FollowSets000.FOLLOW_49); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getUnaryAccess().getOpNotKeyword_1_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnaryRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:4494:2: ( (lv_source_3_0= ruleunary ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:4495:1: (lv_source_3_0= ruleunary )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:4495:1: (lv_source_3_0= ruleunary )
                    // InternalBacktrackingContentAssistTestLanguage.g:4496:3: lv_source_3_0= ruleunary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryAccess().getSourceUnaryParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_source_3_0=ruleunary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryRule());
                      	        }
                             		set(
                             			current, 
                             			"source",
                              		lv_source_3_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.unary");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


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
    // $ANTLR end "ruleunary"


    // $ANTLR start "entryRuleSubNavigationExp"
    // InternalBacktrackingContentAssistTestLanguage.g:4520:1: entryRuleSubNavigationExp returns [EObject current=null] : iv_ruleSubNavigationExp= ruleSubNavigationExp EOF ;
    public final EObject entryRuleSubNavigationExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubNavigationExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4521:2: (iv_ruleSubNavigationExp= ruleSubNavigationExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:4522:2: iv_ruleSubNavigationExp= ruleSubNavigationExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubNavigationExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSubNavigationExp=ruleSubNavigationExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubNavigationExp; 
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
    // $ANTLR end "entryRuleSubNavigationExp"


    // $ANTLR start "ruleSubNavigationExp"
    // InternalBacktrackingContentAssistTestLanguage.g:4529:1: ruleSubNavigationExp returns [EObject current=null] : (this_RoundBracketExp_0= ruleRoundBracketExp | this_SquareBracketExp_1= ruleSquareBracketExp | this_SelfExp_2= ruleSelfExp | this_PrimitiveLiteralExp_3= rulePrimitiveLiteralExp | this_TupleLiteralExp_4= ruleTupleLiteralExp | this_CollectionLiteralExp_5= ruleCollectionLiteralExp | this_PreExp_6= rulePreExp | this_TypeExp_7= ruleTypeExp | this_IfExp_8= ruleIfExp | (otherlv_9= '(' () ( (lv_source_11_0= ruleExpression ) ) otherlv_12= ')' ) ) ;
    public final EObject ruleSubNavigationExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_9=null;
        Token otherlv_12=null;
        EObject this_RoundBracketExp_0 = null;

        EObject this_SquareBracketExp_1 = null;

        EObject this_SelfExp_2 = null;

        EObject this_PrimitiveLiteralExp_3 = null;

        EObject this_TupleLiteralExp_4 = null;

        EObject this_CollectionLiteralExp_5 = null;

        EObject this_PreExp_6 = null;

        EObject this_TypeExp_7 = null;

        EObject this_IfExp_8 = null;

        EObject lv_source_11_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4532:28: ( (this_RoundBracketExp_0= ruleRoundBracketExp | this_SquareBracketExp_1= ruleSquareBracketExp | this_SelfExp_2= ruleSelfExp | this_PrimitiveLiteralExp_3= rulePrimitiveLiteralExp | this_TupleLiteralExp_4= ruleTupleLiteralExp | this_CollectionLiteralExp_5= ruleCollectionLiteralExp | this_PreExp_6= rulePreExp | this_TypeExp_7= ruleTypeExp | this_IfExp_8= ruleIfExp | (otherlv_9= '(' () ( (lv_source_11_0= ruleExpression ) ) otherlv_12= ')' ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4533:1: (this_RoundBracketExp_0= ruleRoundBracketExp | this_SquareBracketExp_1= ruleSquareBracketExp | this_SelfExp_2= ruleSelfExp | this_PrimitiveLiteralExp_3= rulePrimitiveLiteralExp | this_TupleLiteralExp_4= ruleTupleLiteralExp | this_CollectionLiteralExp_5= ruleCollectionLiteralExp | this_PreExp_6= rulePreExp | this_TypeExp_7= ruleTypeExp | this_IfExp_8= ruleIfExp | (otherlv_9= '(' () ( (lv_source_11_0= ruleExpression ) ) otherlv_12= ')' ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4533:1: (this_RoundBracketExp_0= ruleRoundBracketExp | this_SquareBracketExp_1= ruleSquareBracketExp | this_SelfExp_2= ruleSelfExp | this_PrimitiveLiteralExp_3= rulePrimitiveLiteralExp | this_TupleLiteralExp_4= ruleTupleLiteralExp | this_CollectionLiteralExp_5= ruleCollectionLiteralExp | this_PreExp_6= rulePreExp | this_TypeExp_7= ruleTypeExp | this_IfExp_8= ruleIfExp | (otherlv_9= '(' () ( (lv_source_11_0= ruleExpression ) ) otherlv_12= ')' ) )
            int alt86=10;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4534:2: this_RoundBracketExp_0= ruleRoundBracketExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigationExpAccess().getRoundBracketExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RoundBracketExp_0=ruleRoundBracketExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RoundBracketExp_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4547:2: this_SquareBracketExp_1= ruleSquareBracketExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigationExpAccess().getSquareBracketExpParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SquareBracketExp_1=ruleSquareBracketExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SquareBracketExp_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4560:2: this_SelfExp_2= ruleSelfExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigationExpAccess().getSelfExpParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SelfExp_2=ruleSelfExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SelfExp_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4573:2: this_PrimitiveLiteralExp_3= rulePrimitiveLiteralExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigationExpAccess().getPrimitiveLiteralExpParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PrimitiveLiteralExp_3=rulePrimitiveLiteralExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimitiveLiteralExp_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4586:2: this_TupleLiteralExp_4= ruleTupleLiteralExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigationExpAccess().getTupleLiteralExpParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TupleLiteralExp_4=ruleTupleLiteralExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TupleLiteralExp_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4599:2: this_CollectionLiteralExp_5= ruleCollectionLiteralExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigationExpAccess().getCollectionLiteralExpParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CollectionLiteralExp_5=ruleCollectionLiteralExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionLiteralExp_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4612:2: this_PreExp_6= rulePreExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigationExpAccess().getPreExpParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PreExp_6=rulePreExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PreExp_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4625:2: this_TypeExp_7= ruleTypeExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigationExpAccess().getTypeExpParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeExp_7=ruleTypeExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeExp_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4638:2: this_IfExp_8= ruleIfExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigationExpAccess().getIfExpParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_IfExp_8=ruleIfExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IfExp_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4650:6: (otherlv_9= '(' () ( (lv_source_11_0= ruleExpression ) ) otherlv_12= ')' )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:4650:6: (otherlv_9= '(' () ( (lv_source_11_0= ruleExpression ) ) otherlv_12= ')' )
                    // InternalBacktrackingContentAssistTestLanguage.g:4650:8: otherlv_9= '(' () ( (lv_source_11_0= ruleExpression ) ) otherlv_12= ')'
                    {
                    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getSubNavigationExpAccess().getLeftParenthesisKeyword_9_0());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:4654:1: ()
                    // InternalBacktrackingContentAssistTestLanguage.g:4655:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getSubNavigationExpAccess().getNestedExpAction_9_1(),
                                  current);
                          
                    }

                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:4663:2: ( (lv_source_11_0= ruleExpression ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:4664:1: (lv_source_11_0= ruleExpression )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:4664:1: (lv_source_11_0= ruleExpression )
                    // InternalBacktrackingContentAssistTestLanguage.g:4665:3: lv_source_11_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubNavigationExpAccess().getSourceExpressionParserRuleCall_9_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_33);
                    lv_source_11_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSubNavigationExpRule());
                      	        }
                             		set(
                             			current, 
                             			"source",
                              		lv_source_11_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getSubNavigationExpAccess().getRightParenthesisKeyword_9_3());
                          
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
    // $ANTLR end "ruleSubNavigationExp"


    // $ANTLR start "entryRuleSubNavigatingExp"
    // InternalBacktrackingContentAssistTestLanguage.g:4693:1: entryRuleSubNavigatingExp returns [EObject current=null] : iv_ruleSubNavigatingExp= ruleSubNavigatingExp EOF ;
    public final EObject entryRuleSubNavigatingExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubNavigatingExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4694:2: (iv_ruleSubNavigatingExp= ruleSubNavigatingExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:4695:2: iv_ruleSubNavigatingExp= ruleSubNavigatingExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubNavigatingExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSubNavigatingExp=ruleSubNavigatingExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubNavigatingExp; 
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
    // $ANTLR end "entryRuleSubNavigatingExp"


    // $ANTLR start "ruleSubNavigatingExp"
    // InternalBacktrackingContentAssistTestLanguage.g:4702:1: ruleSubNavigatingExp returns [EObject current=null] : (this_RoundBracketExp_0= ruleRoundBracketExp | this_SquareBracketExp_1= ruleSquareBracketExp | this_PreExp_2= rulePreExp | this_NameExp_3= ruleNameExp ) ;
    public final EObject ruleSubNavigatingExp() throws RecognitionException {
        EObject current = null;

        EObject this_RoundBracketExp_0 = null;

        EObject this_SquareBracketExp_1 = null;

        EObject this_PreExp_2 = null;

        EObject this_NameExp_3 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4705:28: ( (this_RoundBracketExp_0= ruleRoundBracketExp | this_SquareBracketExp_1= ruleSquareBracketExp | this_PreExp_2= rulePreExp | this_NameExp_3= ruleNameExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4706:1: (this_RoundBracketExp_0= ruleRoundBracketExp | this_SquareBracketExp_1= ruleSquareBracketExp | this_PreExp_2= rulePreExp | this_NameExp_3= ruleNameExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4706:1: (this_RoundBracketExp_0= ruleRoundBracketExp | this_SquareBracketExp_1= ruleSquareBracketExp | this_PreExp_2= rulePreExp | this_NameExp_3= ruleNameExp )
            int alt87=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA87_1 = input.LA(2);

                if ( (synpred119_InternalBacktrackingContentAssistTestLanguage()) ) {
                    alt87=1;
                }
                else if ( (synpred120_InternalBacktrackingContentAssistTestLanguage()) ) {
                    alt87=2;
                }
                else if ( (synpred121_InternalBacktrackingContentAssistTestLanguage()) ) {
                    alt87=3;
                }
                else if ( (true) ) {
                    alt87=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 1, input);

                    throw nvae;
                }
                }
                break;
            case 33:
                {
                int LA87_2 = input.LA(2);

                if ( (synpred119_InternalBacktrackingContentAssistTestLanguage()) ) {
                    alt87=1;
                }
                else if ( (synpred120_InternalBacktrackingContentAssistTestLanguage()) ) {
                    alt87=2;
                }
                else if ( (synpred121_InternalBacktrackingContentAssistTestLanguage()) ) {
                    alt87=3;
                }
                else if ( (true) ) {
                    alt87=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 2, input);

                    throw nvae;
                }
                }
                break;
            case 34:
                {
                int LA87_3 = input.LA(2);

                if ( (synpred119_InternalBacktrackingContentAssistTestLanguage()) ) {
                    alt87=1;
                }
                else if ( (synpred120_InternalBacktrackingContentAssistTestLanguage()) ) {
                    alt87=2;
                }
                else if ( (synpred121_InternalBacktrackingContentAssistTestLanguage()) ) {
                    alt87=3;
                }
                else if ( (true) ) {
                    alt87=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4707:2: this_RoundBracketExp_0= ruleRoundBracketExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigatingExpAccess().getRoundBracketExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RoundBracketExp_0=ruleRoundBracketExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RoundBracketExp_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4720:2: this_SquareBracketExp_1= ruleSquareBracketExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigatingExpAccess().getSquareBracketExpParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SquareBracketExp_1=ruleSquareBracketExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SquareBracketExp_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4733:2: this_PreExp_2= rulePreExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigatingExpAccess().getPreExpParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PreExp_2=rulePreExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PreExp_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4746:2: this_NameExp_3= ruleNameExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubNavigatingExpAccess().getNameExpParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NameExp_3=ruleNameExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NameExp_3; 
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
    // $ANTLR end "ruleSubNavigatingExp"


    // $ANTLR start "entryRuleiteratorVariable"
    // InternalBacktrackingContentAssistTestLanguage.g:4765:1: entryRuleiteratorVariable returns [EObject current=null] : iv_ruleiteratorVariable= ruleiteratorVariable EOF ;
    public final EObject entryRuleiteratorVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleiteratorVariable = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4766:2: (iv_ruleiteratorVariable= ruleiteratorVariable EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:4767:2: iv_ruleiteratorVariable= ruleiteratorVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIteratorVariableRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleiteratorVariable=ruleiteratorVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleiteratorVariable; 
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
    // $ANTLR end "entryRuleiteratorVariable"


    // $ANTLR start "ruleiteratorVariable"
    // InternalBacktrackingContentAssistTestLanguage.g:4774:1: ruleiteratorVariable returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )? ) ;
    public final EObject ruleiteratorVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4777:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )? ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4778:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )? )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4778:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )? )
            // InternalBacktrackingContentAssistTestLanguage.g:4778:2: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )?
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4778:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4779:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4779:1: (lv_name_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:4780:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIteratorVariableAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_27);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIteratorVariableRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBacktrackingContentAssistTestLanguage.g:4796:2: (otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==12) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4796:4: otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) )
                    {
                    otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getIteratorVariableAccess().getColonKeyword_1_0());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:4800:1: ( (lv_type_2_0= ruleTypeExp ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:4801:1: (lv_type_2_0= ruleTypeExp )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:4801:1: (lv_type_2_0= ruleTypeExp )
                    // InternalBacktrackingContentAssistTestLanguage.g:4802:3: lv_type_2_0= ruleTypeExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIteratorVariableAccess().getTypeTypeExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_type_2_0=ruleTypeExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIteratorVariableRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_2_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TypeExp");
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
    // $ANTLR end "ruleiteratorVariable"


    // $ANTLR start "entryRuleiteratorAccumulator"
    // InternalBacktrackingContentAssistTestLanguage.g:4826:1: entryRuleiteratorAccumulator returns [EObject current=null] : iv_ruleiteratorAccumulator= ruleiteratorAccumulator EOF ;
    public final EObject entryRuleiteratorAccumulator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleiteratorAccumulator = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4827:2: (iv_ruleiteratorAccumulator= ruleiteratorAccumulator EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:4828:2: iv_ruleiteratorAccumulator= ruleiteratorAccumulator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIteratorAccumulatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleiteratorAccumulator=ruleiteratorAccumulator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleiteratorAccumulator; 
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
    // $ANTLR end "entryRuleiteratorAccumulator"


    // $ANTLR start "ruleiteratorAccumulator"
    // InternalBacktrackingContentAssistTestLanguage.g:4835:1: ruleiteratorAccumulator returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) ) ) ;
    public final EObject ruleiteratorAccumulator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4838:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4839:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4839:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4839:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4839:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4840:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4840:1: (lv_name_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:4841:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIteratorAccumulatorAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_5);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIteratorAccumulatorRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIteratorAccumulatorAccess().getColonKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:4861:1: ( (lv_type_2_0= ruleTypeExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4862:1: (lv_type_2_0= ruleTypeExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4862:1: (lv_type_2_0= ruleTypeExp )
            // InternalBacktrackingContentAssistTestLanguage.g:4863:3: lv_type_2_0= ruleTypeExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIteratorAccumulatorAccess().getTypeTypeExpParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_15);
            lv_type_2_0=ruleTypeExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIteratorAccumulatorRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TypeExp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getIteratorAccumulatorAccess().getEqualsSignKeyword_3());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:4883:1: ( (lv_initExpression_4_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4884:1: (lv_initExpression_4_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4884:1: (lv_initExpression_4_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:4885:3: lv_initExpression_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIteratorAccumulatorAccess().getInitExpressionExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_initExpression_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIteratorAccumulatorRule());
              	        }
                     		set(
                     			current, 
                     			"initExpression",
                      		lv_initExpression_4_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
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
    // $ANTLR end "ruleiteratorAccumulator"


    // $ANTLR start "entryRuleRoundBracketExp"
    // InternalBacktrackingContentAssistTestLanguage.g:4909:1: entryRuleRoundBracketExp returns [EObject current=null] : iv_ruleRoundBracketExp= ruleRoundBracketExp EOF ;
    public final EObject entryRuleRoundBracketExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundBracketExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4910:2: (iv_ruleRoundBracketExp= ruleRoundBracketExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:4911:2: iv_ruleRoundBracketExp= ruleRoundBracketExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoundBracketExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRoundBracketExp=ruleRoundBracketExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoundBracketExp; 
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
    // $ANTLR end "entryRuleRoundBracketExp"


    // $ANTLR start "ruleRoundBracketExp"
    // InternalBacktrackingContentAssistTestLanguage.g:4918:1: ruleRoundBracketExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleNameExp ) ) (otherlv_1= '@' ( (lv_pre_2_0= 'pre' ) ) )? otherlv_3= '(' ( ( (lv_variable1_4_0= ruleiteratorVariable ) ) ( (otherlv_5= ',' ( (lv_variable2_6_0= ruleiteratorVariable ) ) ) | (otherlv_7= ';' ( (lv_variable2_8_0= ruleiteratorAccumulator ) ) ) )? otherlv_9= '|' )? ( ( (lv_arguments_10_0= ruleExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleExpression ) ) )* )? otherlv_13= ')' ) ;
    public final EObject ruleRoundBracketExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_pre_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_name_0_0 = null;

        EObject lv_variable1_4_0 = null;

        EObject lv_variable2_6_0 = null;

        EObject lv_variable2_8_0 = null;

        EObject lv_arguments_10_0 = null;

        EObject lv_arguments_12_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:4921:28: ( ( ( (lv_name_0_0= ruleNameExp ) ) (otherlv_1= '@' ( (lv_pre_2_0= 'pre' ) ) )? otherlv_3= '(' ( ( (lv_variable1_4_0= ruleiteratorVariable ) ) ( (otherlv_5= ',' ( (lv_variable2_6_0= ruleiteratorVariable ) ) ) | (otherlv_7= ';' ( (lv_variable2_8_0= ruleiteratorAccumulator ) ) ) )? otherlv_9= '|' )? ( ( (lv_arguments_10_0= ruleExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleExpression ) ) )* )? otherlv_13= ')' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4922:1: ( ( (lv_name_0_0= ruleNameExp ) ) (otherlv_1= '@' ( (lv_pre_2_0= 'pre' ) ) )? otherlv_3= '(' ( ( (lv_variable1_4_0= ruleiteratorVariable ) ) ( (otherlv_5= ',' ( (lv_variable2_6_0= ruleiteratorVariable ) ) ) | (otherlv_7= ';' ( (lv_variable2_8_0= ruleiteratorAccumulator ) ) ) )? otherlv_9= '|' )? ( ( (lv_arguments_10_0= ruleExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleExpression ) ) )* )? otherlv_13= ')' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4922:1: ( ( (lv_name_0_0= ruleNameExp ) ) (otherlv_1= '@' ( (lv_pre_2_0= 'pre' ) ) )? otherlv_3= '(' ( ( (lv_variable1_4_0= ruleiteratorVariable ) ) ( (otherlv_5= ',' ( (lv_variable2_6_0= ruleiteratorVariable ) ) ) | (otherlv_7= ';' ( (lv_variable2_8_0= ruleiteratorAccumulator ) ) ) )? otherlv_9= '|' )? ( ( (lv_arguments_10_0= ruleExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleExpression ) ) )* )? otherlv_13= ')' )
            // InternalBacktrackingContentAssistTestLanguage.g:4922:2: ( (lv_name_0_0= ruleNameExp ) ) (otherlv_1= '@' ( (lv_pre_2_0= 'pre' ) ) )? otherlv_3= '(' ( ( (lv_variable1_4_0= ruleiteratorVariable ) ) ( (otherlv_5= ',' ( (lv_variable2_6_0= ruleiteratorVariable ) ) ) | (otherlv_7= ';' ( (lv_variable2_8_0= ruleiteratorAccumulator ) ) ) )? otherlv_9= '|' )? ( ( (lv_arguments_10_0= ruleExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleExpression ) ) )* )? otherlv_13= ')'
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4922:2: ( (lv_name_0_0= ruleNameExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:4923:1: (lv_name_0_0= ruleNameExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:4923:1: (lv_name_0_0= ruleNameExp )
            // InternalBacktrackingContentAssistTestLanguage.g:4924:3: lv_name_0_0= ruleNameExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRoundBracketExpAccess().getNameNameExpParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_50);
            lv_name_0_0=ruleNameExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRoundBracketExpRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.NameExp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBacktrackingContentAssistTestLanguage.g:4940:2: (otherlv_1= '@' ( (lv_pre_2_0= 'pre' ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==70) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4940:4: otherlv_1= '@' ( (lv_pre_2_0= 'pre' ) )
                    {
                    otherlv_1=(Token)match(input,70,FollowSets000.FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getRoundBracketExpAccess().getCommercialAtKeyword_1_0());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:4944:1: ( (lv_pre_2_0= 'pre' ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:4945:1: (lv_pre_2_0= 'pre' )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:4945:1: (lv_pre_2_0= 'pre' )
                    // InternalBacktrackingContentAssistTestLanguage.g:4946:3: lv_pre_2_0= 'pre'
                    {
                    lv_pre_2_0=(Token)match(input,26,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_pre_2_0, grammarAccess.getRoundBracketExpAccess().getPrePreKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRoundBracketExpRule());
                      	        }
                             		setWithLastConsumed(current, "pre", true, "pre");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRoundBracketExpAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:4963:1: ( ( (lv_variable1_4_0= ruleiteratorVariable ) ) ( (otherlv_5= ',' ( (lv_variable2_6_0= ruleiteratorVariable ) ) ) | (otherlv_7= ';' ( (lv_variable2_8_0= ruleiteratorAccumulator ) ) ) )? otherlv_9= '|' )?
            int alt91=2;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:4963:2: ( (lv_variable1_4_0= ruleiteratorVariable ) ) ( (otherlv_5= ',' ( (lv_variable2_6_0= ruleiteratorVariable ) ) ) | (otherlv_7= ';' ( (lv_variable2_8_0= ruleiteratorAccumulator ) ) ) )? otherlv_9= '|'
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:4963:2: ( (lv_variable1_4_0= ruleiteratorVariable ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:4964:1: (lv_variable1_4_0= ruleiteratorVariable )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:4964:1: (lv_variable1_4_0= ruleiteratorVariable )
                    // InternalBacktrackingContentAssistTestLanguage.g:4965:3: lv_variable1_4_0= ruleiteratorVariable
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRoundBracketExpAccess().getVariable1IteratorVariableParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_53);
                    lv_variable1_4_0=ruleiteratorVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRoundBracketExpRule());
                      	        }
                             		set(
                             			current, 
                             			"variable1",
                              		lv_variable1_4_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.iteratorVariable");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:4981:2: ( (otherlv_5= ',' ( (lv_variable2_6_0= ruleiteratorVariable ) ) ) | (otherlv_7= ';' ( (lv_variable2_8_0= ruleiteratorAccumulator ) ) ) )?
                    int alt90=3;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==17) ) {
                        alt90=1;
                    }
                    else if ( (LA90_0==71) ) {
                        alt90=2;
                    }
                    switch (alt90) {
                        case 1 :
                            // InternalBacktrackingContentAssistTestLanguage.g:4981:3: (otherlv_5= ',' ( (lv_variable2_6_0= ruleiteratorVariable ) ) )
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:4981:3: (otherlv_5= ',' ( (lv_variable2_6_0= ruleiteratorVariable ) ) )
                            // InternalBacktrackingContentAssistTestLanguage.g:4981:5: otherlv_5= ',' ( (lv_variable2_6_0= ruleiteratorVariable ) )
                            {
                            otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getRoundBracketExpAccess().getCommaKeyword_3_1_0_0());
                                  
                            }
                            // InternalBacktrackingContentAssistTestLanguage.g:4985:1: ( (lv_variable2_6_0= ruleiteratorVariable ) )
                            // InternalBacktrackingContentAssistTestLanguage.g:4986:1: (lv_variable2_6_0= ruleiteratorVariable )
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:4986:1: (lv_variable2_6_0= ruleiteratorVariable )
                            // InternalBacktrackingContentAssistTestLanguage.g:4987:3: lv_variable2_6_0= ruleiteratorVariable
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRoundBracketExpAccess().getVariable2IteratorVariableParserRuleCall_3_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_54);
                            lv_variable2_6_0=ruleiteratorVariable();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRoundBracketExpRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"variable2",
                                      		lv_variable2_6_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.iteratorVariable");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalBacktrackingContentAssistTestLanguage.g:5004:6: (otherlv_7= ';' ( (lv_variable2_8_0= ruleiteratorAccumulator ) ) )
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:5004:6: (otherlv_7= ';' ( (lv_variable2_8_0= ruleiteratorAccumulator ) ) )
                            // InternalBacktrackingContentAssistTestLanguage.g:5004:8: otherlv_7= ';' ( (lv_variable2_8_0= ruleiteratorAccumulator ) )
                            {
                            otherlv_7=(Token)match(input,71,FollowSets000.FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getRoundBracketExpAccess().getSemicolonKeyword_3_1_1_0());
                                  
                            }
                            // InternalBacktrackingContentAssistTestLanguage.g:5008:1: ( (lv_variable2_8_0= ruleiteratorAccumulator ) )
                            // InternalBacktrackingContentAssistTestLanguage.g:5009:1: (lv_variable2_8_0= ruleiteratorAccumulator )
                            {
                            // InternalBacktrackingContentAssistTestLanguage.g:5009:1: (lv_variable2_8_0= ruleiteratorAccumulator )
                            // InternalBacktrackingContentAssistTestLanguage.g:5010:3: lv_variable2_8_0= ruleiteratorAccumulator
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRoundBracketExpAccess().getVariable2IteratorAccumulatorParserRuleCall_3_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_54);
                            lv_variable2_8_0=ruleiteratorAccumulator();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRoundBracketExpRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"variable2",
                                      		lv_variable2_8_0, 
                                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.iteratorAccumulator");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,72,FollowSets000.FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getRoundBracketExpAccess().getVerticalLineKeyword_3_2());
                          
                    }

                    }
                    break;

            }

            // InternalBacktrackingContentAssistTestLanguage.g:5030:3: ( ( (lv_arguments_10_0= ruleExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleExpression ) ) )* )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( ((LA93_0>=RULE_INT && LA93_0<=RULE_STRING)||LA93_0==16||(LA93_0>=33 && LA93_0<=34)||(LA93_0>=36 && LA93_0<=50)||(LA93_0>=54 && LA93_0<=57)||LA93_0==69||(LA93_0>=75 && LA93_0<=76)||LA93_0==80) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:5030:4: ( (lv_arguments_10_0= ruleExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleExpression ) ) )*
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:5030:4: ( (lv_arguments_10_0= ruleExpression ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:5031:1: (lv_arguments_10_0= ruleExpression )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:5031:1: (lv_arguments_10_0= ruleExpression )
                    // InternalBacktrackingContentAssistTestLanguage.g:5032:3: lv_arguments_10_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRoundBracketExpAccess().getArgumentsExpressionParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_12);
                    lv_arguments_10_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRoundBracketExpRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_10_0, 
                              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalBacktrackingContentAssistTestLanguage.g:5048:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleExpression ) ) )*
                    loop92:
                    do {
                        int alt92=2;
                        int LA92_0 = input.LA(1);

                        if ( (LA92_0==17) ) {
                            alt92=1;
                        }


                        switch (alt92) {
                    	case 1 :
                    	    // InternalBacktrackingContentAssistTestLanguage.g:5048:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleExpression ) )
                    	    {
                    	    otherlv_11=(Token)match(input,17,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getRoundBracketExpAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // InternalBacktrackingContentAssistTestLanguage.g:5052:1: ( (lv_arguments_12_0= ruleExpression ) )
                    	    // InternalBacktrackingContentAssistTestLanguage.g:5053:1: (lv_arguments_12_0= ruleExpression )
                    	    {
                    	    // InternalBacktrackingContentAssistTestLanguage.g:5053:1: (lv_arguments_12_0= ruleExpression )
                    	    // InternalBacktrackingContentAssistTestLanguage.g:5054:3: lv_arguments_12_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketExpAccess().getArgumentsExpressionParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_12);
                    	    lv_arguments_12_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_12_0, 
                    	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop92;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getRoundBracketExpAccess().getRightParenthesisKeyword_5());
                  
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
    // $ANTLR end "ruleRoundBracketExp"


    // $ANTLR start "entryRuleSquareBracketExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5082:1: entryRuleSquareBracketExp returns [EObject current=null] : iv_ruleSquareBracketExp= ruleSquareBracketExp EOF ;
    public final EObject entryRuleSquareBracketExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSquareBracketExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5083:2: (iv_ruleSquareBracketExp= ruleSquareBracketExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:5084:2: iv_ruleSquareBracketExp= ruleSquareBracketExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSquareBracketExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSquareBracketExp=ruleSquareBracketExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSquareBracketExp; 
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
    // $ANTLR end "entryRuleSquareBracketExp"


    // $ANTLR start "ruleSquareBracketExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5091:1: ruleSquareBracketExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleNameExp ) ) otherlv_1= '[' ( (lv_arguments_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )* otherlv_5= ']' (otherlv_6= '@' ( (lv_pre_7_0= 'pre' ) ) )? ) ;
    public final EObject ruleSquareBracketExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_pre_7_0=null;
        EObject lv_name_0_0 = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5094:28: ( ( ( (lv_name_0_0= ruleNameExp ) ) otherlv_1= '[' ( (lv_arguments_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )* otherlv_5= ']' (otherlv_6= '@' ( (lv_pre_7_0= 'pre' ) ) )? ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5095:1: ( ( (lv_name_0_0= ruleNameExp ) ) otherlv_1= '[' ( (lv_arguments_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )* otherlv_5= ']' (otherlv_6= '@' ( (lv_pre_7_0= 'pre' ) ) )? )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5095:1: ( ( (lv_name_0_0= ruleNameExp ) ) otherlv_1= '[' ( (lv_arguments_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )* otherlv_5= ']' (otherlv_6= '@' ( (lv_pre_7_0= 'pre' ) ) )? )
            // InternalBacktrackingContentAssistTestLanguage.g:5095:2: ( (lv_name_0_0= ruleNameExp ) ) otherlv_1= '[' ( (lv_arguments_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )* otherlv_5= ']' (otherlv_6= '@' ( (lv_pre_7_0= 'pre' ) ) )?
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5095:2: ( (lv_name_0_0= ruleNameExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5096:1: (lv_name_0_0= ruleNameExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5096:1: (lv_name_0_0= ruleNameExp )
            // InternalBacktrackingContentAssistTestLanguage.g:5097:3: lv_name_0_0= ruleNameExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSquareBracketExpAccess().getNameNameExpParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_55);
            lv_name_0_0=ruleNameExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSquareBracketExpRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.NameExp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,73,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSquareBracketExpAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:5117:1: ( (lv_arguments_2_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5118:1: (lv_arguments_2_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5118:1: (lv_arguments_2_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:5119:3: lv_arguments_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSquareBracketExpAccess().getArgumentsExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_56);
            lv_arguments_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSquareBracketExpRule());
              	        }
                     		add(
                     			current, 
                     			"arguments",
                      		lv_arguments_2_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBacktrackingContentAssistTestLanguage.g:5135:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==17) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:5135:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getSquareBracketExpAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalBacktrackingContentAssistTestLanguage.g:5139:1: ( (lv_arguments_4_0= ruleExpression ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:5140:1: (lv_arguments_4_0= ruleExpression )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:5140:1: (lv_arguments_4_0= ruleExpression )
            	    // InternalBacktrackingContentAssistTestLanguage.g:5141:3: lv_arguments_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSquareBracketExpAccess().getArgumentsExpressionParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_56);
            	    lv_arguments_4_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSquareBracketExpRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"arguments",
            	              		lv_arguments_4_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);

            otherlv_5=(Token)match(input,74,FollowSets000.FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getSquareBracketExpAccess().getRightSquareBracketKeyword_4());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:5161:1: (otherlv_6= '@' ( (lv_pre_7_0= 'pre' ) ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==70) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:5161:3: otherlv_6= '@' ( (lv_pre_7_0= 'pre' ) )
                    {
                    otherlv_6=(Token)match(input,70,FollowSets000.FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSquareBracketExpAccess().getCommercialAtKeyword_5_0());
                          
                    }
                    // InternalBacktrackingContentAssistTestLanguage.g:5165:1: ( (lv_pre_7_0= 'pre' ) )
                    // InternalBacktrackingContentAssistTestLanguage.g:5166:1: (lv_pre_7_0= 'pre' )
                    {
                    // InternalBacktrackingContentAssistTestLanguage.g:5166:1: (lv_pre_7_0= 'pre' )
                    // InternalBacktrackingContentAssistTestLanguage.g:5167:3: lv_pre_7_0= 'pre'
                    {
                    lv_pre_7_0=(Token)match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_pre_7_0, grammarAccess.getSquareBracketExpAccess().getPrePreKeyword_5_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSquareBracketExpRule());
                      	        }
                             		setWithLastConsumed(current, "pre", true, "pre");
                      	    
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
    // $ANTLR end "ruleSquareBracketExp"


    // $ANTLR start "entryRulePreExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5188:1: entryRulePreExp returns [EObject current=null] : iv_rulePreExp= rulePreExp EOF ;
    public final EObject entryRulePreExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5189:2: (iv_rulePreExp= rulePreExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:5190:2: iv_rulePreExp= rulePreExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPreExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePreExp=rulePreExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePreExp; 
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
    // $ANTLR end "entryRulePreExp"


    // $ANTLR start "rulePreExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5197:1: rulePreExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleNameExp ) ) otherlv_1= '@' otherlv_2= 'pre' ) ;
    public final EObject rulePreExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5200:28: ( ( ( (lv_name_0_0= ruleNameExp ) ) otherlv_1= '@' otherlv_2= 'pre' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5201:1: ( ( (lv_name_0_0= ruleNameExp ) ) otherlv_1= '@' otherlv_2= 'pre' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5201:1: ( ( (lv_name_0_0= ruleNameExp ) ) otherlv_1= '@' otherlv_2= 'pre' )
            // InternalBacktrackingContentAssistTestLanguage.g:5201:2: ( (lv_name_0_0= ruleNameExp ) ) otherlv_1= '@' otherlv_2= 'pre'
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5201:2: ( (lv_name_0_0= ruleNameExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5202:1: (lv_name_0_0= ruleNameExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5202:1: (lv_name_0_0= ruleNameExp )
            // InternalBacktrackingContentAssistTestLanguage.g:5203:3: lv_name_0_0= ruleNameExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPreExpAccess().getNameNameExpParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_58);
            lv_name_0_0=ruleNameExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPreExpRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.NameExp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,70,FollowSets000.FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPreExpAccess().getCommercialAtKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPreExpAccess().getPreKeyword_2());
                  
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
    // $ANTLR end "rulePreExp"


    // $ANTLR start "entryRuleSelfExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5235:1: entryRuleSelfExp returns [EObject current=null] : iv_ruleSelfExp= ruleSelfExp EOF ;
    public final EObject entryRuleSelfExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5236:2: (iv_ruleSelfExp= ruleSelfExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:5237:2: iv_ruleSelfExp= ruleSelfExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSelfExp=ruleSelfExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExp; 
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
    // $ANTLR end "entryRuleSelfExp"


    // $ANTLR start "ruleSelfExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5244:1: ruleSelfExp returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5247:28: ( ( () otherlv_1= 'self' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5248:1: ( () otherlv_1= 'self' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5248:1: ( () otherlv_1= 'self' )
            // InternalBacktrackingContentAssistTestLanguage.g:5248:2: () otherlv_1= 'self'
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5248:2: ()
            // InternalBacktrackingContentAssistTestLanguage.g:5249:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSelfExpAccess().getSelfExpAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,75,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSelfExpAccess().getSelfKeyword_1());
                  
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
    // $ANTLR end "ruleSelfExp"


    // $ANTLR start "entryRuleNameExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5269:1: entryRuleNameExp returns [EObject current=null] : iv_ruleNameExp= ruleNameExp EOF ;
    public final EObject entryRuleNameExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5270:2: (iv_ruleNameExp= ruleNameExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:5271:2: iv_ruleNameExp= ruleNameExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNameExp=ruleNameExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExp; 
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
    // $ANTLR end "entryRuleNameExp"


    // $ANTLR start "ruleNameExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5278:1: ruleNameExp returns [EObject current=null] : (this_PathNameExp_0= rulePathNameExp | this_SimpleNameExp_1= ruleSimpleNameExp ) ;
    public final EObject ruleNameExp() throws RecognitionException {
        EObject current = null;

        EObject this_PathNameExp_0 = null;

        EObject this_SimpleNameExp_1 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5281:28: ( (this_PathNameExp_0= rulePathNameExp | this_SimpleNameExp_1= ruleSimpleNameExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5282:1: (this_PathNameExp_0= rulePathNameExp | this_SimpleNameExp_1= ruleSimpleNameExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5282:1: (this_PathNameExp_0= rulePathNameExp | this_SimpleNameExp_1= ruleSimpleNameExp )
            int alt96=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA96_1 = input.LA(2);

                if ( (LA96_1==27) ) {
                    alt96=1;
                }
                else if ( (LA96_1==EOF||LA96_1==11||(LA96_1>=13 && LA96_1<=26)||(LA96_1>=28 && LA96_1<=31)||(LA96_1>=35 && LA96_1<=36)||(LA96_1>=52 && LA96_1<=53)||(LA96_1>=58 && LA96_1<=68)||(LA96_1>=70 && LA96_1<=74)||(LA96_1>=77 && LA96_1<=79)||LA96_1==81) ) {
                    alt96=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 96, 1, input);

                    throw nvae;
                }
                }
                break;
            case 33:
                {
                int LA96_2 = input.LA(2);

                if ( (LA96_2==EOF||LA96_2==11||(LA96_2>=13 && LA96_2<=26)||(LA96_2>=28 && LA96_2<=31)||(LA96_2>=35 && LA96_2<=36)||(LA96_2>=52 && LA96_2<=53)||(LA96_2>=58 && LA96_2<=68)||(LA96_2>=70 && LA96_2<=74)||(LA96_2>=77 && LA96_2<=79)||LA96_2==81) ) {
                    alt96=2;
                }
                else if ( (LA96_2==27) ) {
                    alt96=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 96, 2, input);

                    throw nvae;
                }
                }
                break;
            case 34:
                {
                int LA96_3 = input.LA(2);

                if ( (LA96_3==EOF||LA96_3==11||(LA96_3>=13 && LA96_3<=26)||(LA96_3>=28 && LA96_3<=31)||(LA96_3>=35 && LA96_3<=36)||(LA96_3>=52 && LA96_3<=53)||(LA96_3>=58 && LA96_3<=68)||(LA96_3>=70 && LA96_3<=74)||(LA96_3>=77 && LA96_3<=79)||LA96_3==81) ) {
                    alt96=2;
                }
                else if ( (LA96_3==27) ) {
                    alt96=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 96, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }

            switch (alt96) {
                case 1 :
                    // InternalBacktrackingContentAssistTestLanguage.g:5283:2: this_PathNameExp_0= rulePathNameExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNameExpAccess().getPathNameExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PathNameExp_0=rulePathNameExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PathNameExp_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalBacktrackingContentAssistTestLanguage.g:5296:2: this_SimpleNameExp_1= ruleSimpleNameExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNameExpAccess().getSimpleNameExpParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SimpleNameExp_1=ruleSimpleNameExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SimpleNameExp_1; 
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
    // $ANTLR end "ruleNameExp"


    // $ANTLR start "entryRulePathNameExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5315:1: entryRulePathNameExp returns [EObject current=null] : iv_rulePathNameExp= rulePathNameExp EOF ;
    public final EObject entryRulePathNameExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5316:2: (iv_rulePathNameExp= rulePathNameExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:5317:2: iv_rulePathNameExp= rulePathNameExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePathNameExp=rulePathNameExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameExp; 
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
    // $ANTLR end "entryRulePathNameExp"


    // $ANTLR start "rulePathNameExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5324:1: rulePathNameExp returns [EObject current=null] : ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleNameExp ) ) ) ;
    public final EObject rulePathNameExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_namespace_0_0 = null;

        EObject lv_element_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5327:28: ( ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleNameExp ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5328:1: ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleNameExp ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5328:1: ( ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleNameExp ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5328:2: ( (lv_namespace_0_0= ruleIdentifier ) ) otherlv_1= '::' ( (lv_element_2_0= ruleNameExp ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5328:2: ( (lv_namespace_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5329:1: (lv_namespace_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5329:1: (lv_namespace_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:5330:3: lv_namespace_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameExpAccess().getNamespaceIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_23);
            lv_namespace_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPathNameExpRule());
              	        }
                     		set(
                     			current, 
                     			"namespace",
                      		lv_namespace_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPathNameExpAccess().getColonColonKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:5350:1: ( (lv_element_2_0= ruleNameExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5351:1: (lv_element_2_0= ruleNameExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5351:1: (lv_element_2_0= ruleNameExp )
            // InternalBacktrackingContentAssistTestLanguage.g:5352:3: lv_element_2_0= ruleNameExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameExpAccess().getElementNameExpParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_element_2_0=ruleNameExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPathNameExpRule());
              	        }
                     		set(
                     			current, 
                     			"element",
                      		lv_element_2_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.NameExp");
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
    // $ANTLR end "rulePathNameExp"


    // $ANTLR start "entryRuleSimpleNameExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5376:1: entryRuleSimpleNameExp returns [EObject current=null] : iv_ruleSimpleNameExp= ruleSimpleNameExp EOF ;
    public final EObject entryRuleSimpleNameExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleNameExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5377:2: (iv_ruleSimpleNameExp= ruleSimpleNameExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:5378:2: iv_ruleSimpleNameExp= ruleSimpleNameExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleNameExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleNameExp=ruleSimpleNameExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleNameExp; 
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
    // $ANTLR end "entryRuleSimpleNameExp"


    // $ANTLR start "ruleSimpleNameExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5385:1: ruleSimpleNameExp returns [EObject current=null] : ( (lv_element_0_0= ruleIdentifier ) ) ;
    public final EObject ruleSimpleNameExp() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_element_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5388:28: ( ( (lv_element_0_0= ruleIdentifier ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5389:1: ( (lv_element_0_0= ruleIdentifier ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5389:1: ( (lv_element_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5390:1: (lv_element_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5390:1: (lv_element_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:5391:3: lv_element_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSimpleNameExpAccess().getElementIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_element_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSimpleNameExpRule());
              	        }
                     		set(
                     			current, 
                     			"element",
                      		lv_element_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
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
    // $ANTLR end "ruleSimpleNameExp"


    // $ANTLR start "entryRuleIfExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5415:1: entryRuleIfExp returns [EObject current=null] : iv_ruleIfExp= ruleIfExp EOF ;
    public final EObject entryRuleIfExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5416:2: (iv_ruleIfExp= ruleIfExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:5417:2: iv_ruleIfExp= ruleIfExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIfExp=ruleIfExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExp; 
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
    // $ANTLR end "entryRuleIfExp"


    // $ANTLR start "ruleIfExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5424:1: ruleIfExp returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) otherlv_6= 'endif' ) ;
    public final EObject ruleIfExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_condition_1_0 = null;

        EObject lv_thenExpression_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5427:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) otherlv_6= 'endif' ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5428:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) otherlv_6= 'endif' )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5428:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) otherlv_6= 'endif' )
            // InternalBacktrackingContentAssistTestLanguage.g:5428:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,76,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpAccess().getIfKeyword_0());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:5432:1: ( (lv_condition_1_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5433:1: (lv_condition_1_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5433:1: (lv_condition_1_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:5434:3: lv_condition_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpAccess().getConditionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_59);
            lv_condition_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_1_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,77,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpAccess().getThenKeyword_2());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:5454:1: ( (lv_thenExpression_3_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5455:1: (lv_thenExpression_3_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5455:1: (lv_thenExpression_3_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:5456:3: lv_thenExpression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpAccess().getThenExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_60);
            lv_thenExpression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpRule());
              	        }
                     		set(
                     			current, 
                     			"thenExpression",
                      		lv_thenExpression_3_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,78,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpAccess().getElseKeyword_4());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:5476:1: ( (lv_elseExpression_5_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5477:1: (lv_elseExpression_5_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5477:1: (lv_elseExpression_5_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:5478:3: lv_elseExpression_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpAccess().getElseExpressionExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_61);
            lv_elseExpression_5_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpRule());
              	        }
                     		set(
                     			current, 
                     			"elseExpression",
                      		lv_elseExpression_5_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,79,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getIfExpAccess().getEndifKeyword_6());
                  
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
    // $ANTLR end "ruleIfExp"


    // $ANTLR start "entryRuleLetExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5506:1: entryRuleLetExp returns [EObject current=null] : iv_ruleLetExp= ruleLetExp EOF ;
    public final EObject entryRuleLetExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExp = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5507:2: (iv_ruleLetExp= ruleLetExp EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:5508:2: iv_ruleLetExp= ruleLetExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLetExp=ruleLetExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExp; 
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
    // $ANTLR end "entryRuleLetExp"


    // $ANTLR start "ruleLetExp"
    // InternalBacktrackingContentAssistTestLanguage.g:5515:1: ruleLetExp returns [EObject current=null] : (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariable ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariable ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpression ) ) ) ;
    public final EObject ruleLetExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_variable_1_0 = null;

        EObject lv_variable_3_0 = null;

        EObject lv_in_5_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5518:28: ( (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariable ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariable ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpression ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5519:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariable ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariable ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpression ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5519:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariable ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariable ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpression ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5519:3: otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariable ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariable ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,80,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpAccess().getLetKeyword_0());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:5523:1: ( (lv_variable_1_0= ruleLetVariable ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5524:1: (lv_variable_1_0= ruleLetVariable )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5524:1: (lv_variable_1_0= ruleLetVariable )
            // InternalBacktrackingContentAssistTestLanguage.g:5525:3: lv_variable_1_0= ruleLetVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpAccess().getVariableLetVariableParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_62);
            lv_variable_1_0=ruleLetVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpRule());
              	        }
                     		add(
                     			current, 
                     			"variable",
                      		lv_variable_1_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.LetVariable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalBacktrackingContentAssistTestLanguage.g:5541:2: (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariable ) ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==17) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalBacktrackingContentAssistTestLanguage.g:5541:4: otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariable ) )
            	    {
            	    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalBacktrackingContentAssistTestLanguage.g:5545:1: ( (lv_variable_3_0= ruleLetVariable ) )
            	    // InternalBacktrackingContentAssistTestLanguage.g:5546:1: (lv_variable_3_0= ruleLetVariable )
            	    {
            	    // InternalBacktrackingContentAssistTestLanguage.g:5546:1: (lv_variable_3_0= ruleLetVariable )
            	    // InternalBacktrackingContentAssistTestLanguage.g:5547:3: lv_variable_3_0= ruleLetVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpAccess().getVariableLetVariableParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_62);
            	    lv_variable_3_0=ruleLetVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLetExpRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"variable",
            	              		lv_variable_3_0, 
            	              		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.LetVariable");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop97;
                }
            } while (true);

            otherlv_4=(Token)match(input,81,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpAccess().getInKeyword_3());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:5567:1: ( (lv_in_5_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5568:1: (lv_in_5_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5568:1: (lv_in_5_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:5569:3: lv_in_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpAccess().getInExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_in_5_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpRule());
              	        }
                     		set(
                     			current, 
                     			"in",
                      		lv_in_5_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
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
    // $ANTLR end "ruleLetExp"


    // $ANTLR start "entryRuleLetVariable"
    // InternalBacktrackingContentAssistTestLanguage.g:5593:1: entryRuleLetVariable returns [EObject current=null] : iv_ruleLetVariable= ruleLetVariable EOF ;
    public final EObject entryRuleLetVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariable = null;


        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5594:2: (iv_ruleLetVariable= ruleLetVariable EOF )
            // InternalBacktrackingContentAssistTestLanguage.g:5595:2: iv_ruleLetVariable= ruleLetVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLetVariable=ruleLetVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariable; 
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
    // $ANTLR end "entryRuleLetVariable"


    // $ANTLR start "ruleLetVariable"
    // InternalBacktrackingContentAssistTestLanguage.g:5602:1: ruleLetVariable returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) ) ) ;
    public final EObject ruleLetVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // InternalBacktrackingContentAssistTestLanguage.g:5605:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5606:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5606:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5606:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpression ) )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5606:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5607:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5607:1: (lv_name_0_0= ruleIdentifier )
            // InternalBacktrackingContentAssistTestLanguage.g:5608:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_5);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetVariableRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLetVariableAccess().getColonKeyword_1());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:5628:1: ( (lv_type_2_0= ruleTypeExp ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5629:1: (lv_type_2_0= ruleTypeExp )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5629:1: (lv_type_2_0= ruleTypeExp )
            // InternalBacktrackingContentAssistTestLanguage.g:5630:3: lv_type_2_0= ruleTypeExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableAccess().getTypeTypeExpParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_15);
            lv_type_2_0=ruleTypeExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetVariableRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.TypeExp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetVariableAccess().getEqualsSignKeyword_3());
                  
            }
            // InternalBacktrackingContentAssistTestLanguage.g:5650:1: ( (lv_initExpression_4_0= ruleExpression ) )
            // InternalBacktrackingContentAssistTestLanguage.g:5651:1: (lv_initExpression_4_0= ruleExpression )
            {
            // InternalBacktrackingContentAssistTestLanguage.g:5651:1: (lv_initExpression_4_0= ruleExpression )
            // InternalBacktrackingContentAssistTestLanguage.g:5652:3: lv_initExpression_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableAccess().getInitExpressionExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_initExpression_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetVariableRule());
              	        }
                     		set(
                     			current, 
                     			"initExpression",
                      		lv_initExpression_4_0, 
                      		"org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguage.Expression");
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
    // $ANTLR end "ruleLetVariable"

    // $ANTLR start synpred8_InternalBacktrackingContentAssistTestLanguage
    public final void synpred8_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        EObject this_PropertyContextDecl_0 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:358:2: (this_PropertyContextDecl_0= rulePropertyContextDecl )
        // InternalBacktrackingContentAssistTestLanguage.g:358:2: this_PropertyContextDecl_0= rulePropertyContextDecl
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_PropertyContextDecl_0=rulePropertyContextDecl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred9_InternalBacktrackingContentAssistTestLanguage
    public final void synpred9_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        EObject this_ClassifierContextDecl_1 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:371:2: (this_ClassifierContextDecl_1= ruleClassifierContextDecl )
        // InternalBacktrackingContentAssistTestLanguage.g:371:2: this_ClassifierContextDecl_1= ruleClassifierContextDecl
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_ClassifierContextDecl_1=ruleClassifierContextDecl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred87_InternalBacktrackingContentAssistTestLanguage
    public final void synpred87_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        Token lv_op_2_0=null;
        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:3626:2: ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3626:2: () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3626:2: ()
        // InternalBacktrackingContentAssistTestLanguage.g:3627:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // InternalBacktrackingContentAssistTestLanguage.g:3635:2: ( (lv_op_2_0= 'implies' ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3636:1: (lv_op_2_0= 'implies' )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3636:1: (lv_op_2_0= 'implies' )
        // InternalBacktrackingContentAssistTestLanguage.g:3637:3: lv_op_2_0= 'implies'
        {
        lv_op_2_0=(Token)match(input,58,FollowSets000.FOLLOW_6); if (state.failed) return ;

        }


        }

        // InternalBacktrackingContentAssistTestLanguage.g:3650:2: ( ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3651:1: ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3651:1: ( (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3652:1: (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3652:1: (lv_argument_3_1= rulexor | lv_argument_3_2= ruleLetExp )
        int alt123=2;
        int LA123_0 = input.LA(1);

        if ( ((LA123_0>=RULE_INT && LA123_0<=RULE_STRING)||LA123_0==16||(LA123_0>=33 && LA123_0<=34)||(LA123_0>=36 && LA123_0<=50)||(LA123_0>=54 && LA123_0<=57)||LA123_0==69||(LA123_0>=75 && LA123_0<=76)) ) {
            alt123=1;
        }
        else if ( (LA123_0==80) ) {
            alt123=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 123, 0, input);

            throw nvae;
        }
        switch (alt123) {
            case 1 :
                // InternalBacktrackingContentAssistTestLanguage.g:3653:3: lv_argument_3_1= rulexor
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_1=rulexor();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBacktrackingContentAssistTestLanguage.g:3668:8: lv_argument_3_2= ruleLetExp
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getImpliesAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_2=ruleLetExp();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred87_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred89_InternalBacktrackingContentAssistTestLanguage
    public final void synpred89_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        Token lv_op_2_0=null;
        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:3719:2: ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3719:2: () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3719:2: ()
        // InternalBacktrackingContentAssistTestLanguage.g:3720:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // InternalBacktrackingContentAssistTestLanguage.g:3728:2: ( (lv_op_2_0= 'xor' ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3729:1: (lv_op_2_0= 'xor' )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3729:1: (lv_op_2_0= 'xor' )
        // InternalBacktrackingContentAssistTestLanguage.g:3730:3: lv_op_2_0= 'xor'
        {
        lv_op_2_0=(Token)match(input,59,FollowSets000.FOLLOW_6); if (state.failed) return ;

        }


        }

        // InternalBacktrackingContentAssistTestLanguage.g:3743:2: ( ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3744:1: ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3744:1: ( (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3745:1: (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3745:1: (lv_argument_3_1= ruleor | lv_argument_3_2= ruleLetExp )
        int alt124=2;
        int LA124_0 = input.LA(1);

        if ( ((LA124_0>=RULE_INT && LA124_0<=RULE_STRING)||LA124_0==16||(LA124_0>=33 && LA124_0<=34)||(LA124_0>=36 && LA124_0<=50)||(LA124_0>=54 && LA124_0<=57)||LA124_0==69||(LA124_0>=75 && LA124_0<=76)) ) {
            alt124=1;
        }
        else if ( (LA124_0==80) ) {
            alt124=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 124, 0, input);

            throw nvae;
        }
        switch (alt124) {
            case 1 :
                // InternalBacktrackingContentAssistTestLanguage.g:3746:3: lv_argument_3_1= ruleor
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_1=ruleor();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBacktrackingContentAssistTestLanguage.g:3761:8: lv_argument_3_2= ruleLetExp
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getXorAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_2=ruleLetExp();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred89_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred91_InternalBacktrackingContentAssistTestLanguage
    public final void synpred91_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        Token lv_op_2_0=null;
        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:3812:2: ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3812:2: () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3812:2: ()
        // InternalBacktrackingContentAssistTestLanguage.g:3813:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // InternalBacktrackingContentAssistTestLanguage.g:3821:2: ( (lv_op_2_0= 'or' ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3822:1: (lv_op_2_0= 'or' )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3822:1: (lv_op_2_0= 'or' )
        // InternalBacktrackingContentAssistTestLanguage.g:3823:3: lv_op_2_0= 'or'
        {
        lv_op_2_0=(Token)match(input,60,FollowSets000.FOLLOW_6); if (state.failed) return ;

        }


        }

        // InternalBacktrackingContentAssistTestLanguage.g:3836:2: ( ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3837:1: ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3837:1: ( (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3838:1: (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3838:1: (lv_argument_3_1= ruleand | lv_argument_3_2= ruleLetExp )
        int alt125=2;
        int LA125_0 = input.LA(1);

        if ( ((LA125_0>=RULE_INT && LA125_0<=RULE_STRING)||LA125_0==16||(LA125_0>=33 && LA125_0<=34)||(LA125_0>=36 && LA125_0<=50)||(LA125_0>=54 && LA125_0<=57)||LA125_0==69||(LA125_0>=75 && LA125_0<=76)) ) {
            alt125=1;
        }
        else if ( (LA125_0==80) ) {
            alt125=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 125, 0, input);

            throw nvae;
        }
        switch (alt125) {
            case 1 :
                // InternalBacktrackingContentAssistTestLanguage.g:3839:3: lv_argument_3_1= ruleand
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_1=ruleand();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBacktrackingContentAssistTestLanguage.g:3854:8: lv_argument_3_2= ruleLetExp
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getOrAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_2=ruleLetExp();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred91_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred93_InternalBacktrackingContentAssistTestLanguage
    public final void synpred93_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        Token lv_op_2_0=null;
        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:3905:2: ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3905:2: () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3905:2: ()
        // InternalBacktrackingContentAssistTestLanguage.g:3906:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // InternalBacktrackingContentAssistTestLanguage.g:3914:2: ( (lv_op_2_0= 'and' ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3915:1: (lv_op_2_0= 'and' )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3915:1: (lv_op_2_0= 'and' )
        // InternalBacktrackingContentAssistTestLanguage.g:3916:3: lv_op_2_0= 'and'
        {
        lv_op_2_0=(Token)match(input,61,FollowSets000.FOLLOW_6); if (state.failed) return ;

        }


        }

        // InternalBacktrackingContentAssistTestLanguage.g:3929:2: ( ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3930:1: ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3930:1: ( (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3931:1: (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3931:1: (lv_argument_3_1= ruleequality | lv_argument_3_2= ruleLetExp )
        int alt126=2;
        int LA126_0 = input.LA(1);

        if ( ((LA126_0>=RULE_INT && LA126_0<=RULE_STRING)||LA126_0==16||(LA126_0>=33 && LA126_0<=34)||(LA126_0>=36 && LA126_0<=50)||(LA126_0>=54 && LA126_0<=57)||LA126_0==69||(LA126_0>=75 && LA126_0<=76)) ) {
            alt126=1;
        }
        else if ( (LA126_0==80) ) {
            alt126=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 126, 0, input);

            throw nvae;
        }
        switch (alt126) {
            case 1 :
                // InternalBacktrackingContentAssistTestLanguage.g:3932:3: lv_argument_3_1= ruleequality
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_1=ruleequality();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBacktrackingContentAssistTestLanguage.g:3947:8: lv_argument_3_2= ruleLetExp
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getAndAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_2=ruleLetExp();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred93_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred96_InternalBacktrackingContentAssistTestLanguage
    public final void synpred96_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:3998:2: ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:3998:2: () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:3998:2: ()
        // InternalBacktrackingContentAssistTestLanguage.g:3999:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // InternalBacktrackingContentAssistTestLanguage.g:4007:2: ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4008:1: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4008:1: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4009:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4009:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
        int alt127=2;
        int LA127_0 = input.LA(1);

        if ( (LA127_0==19) ) {
            alt127=1;
        }
        else if ( (LA127_0==62) ) {
            alt127=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 127, 0, input);

            throw nvae;
        }
        switch (alt127) {
            case 1 :
                // InternalBacktrackingContentAssistTestLanguage.g:4010:3: lv_op_2_1= '='
                {
                lv_op_2_1=(Token)match(input,19,FollowSets000.FOLLOW_6); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBacktrackingContentAssistTestLanguage.g:4022:8: lv_op_2_2= '<>'
                {
                lv_op_2_2=(Token)match(input,62,FollowSets000.FOLLOW_6); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalBacktrackingContentAssistTestLanguage.g:4037:2: ( ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4038:1: ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4038:1: ( (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4039:1: (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4039:1: (lv_argument_3_1= rulerelational | lv_argument_3_2= ruleLetExp )
        int alt128=2;
        int LA128_0 = input.LA(1);

        if ( ((LA128_0>=RULE_INT && LA128_0<=RULE_STRING)||LA128_0==16||(LA128_0>=33 && LA128_0<=34)||(LA128_0>=36 && LA128_0<=50)||(LA128_0>=54 && LA128_0<=57)||LA128_0==69||(LA128_0>=75 && LA128_0<=76)) ) {
            alt128=1;
        }
        else if ( (LA128_0==80) ) {
            alt128=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 128, 0, input);

            throw nvae;
        }
        switch (alt128) {
            case 1 :
                // InternalBacktrackingContentAssistTestLanguage.g:4040:3: lv_argument_3_1= rulerelational
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_1=rulerelational();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBacktrackingContentAssistTestLanguage.g:4055:8: lv_argument_3_2= ruleLetExp
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getEqualityAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_2=ruleLetExp();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred96_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred101_InternalBacktrackingContentAssistTestLanguage
    public final void synpred101_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:4106:2: ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4106:2: () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4106:2: ()
        // InternalBacktrackingContentAssistTestLanguage.g:4107:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // InternalBacktrackingContentAssistTestLanguage.g:4115:2: ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4116:1: ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4116:1: ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4117:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4117:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )
        int alt129=4;
        switch ( input.LA(1) ) {
        case 63:
            {
            alt129=1;
            }
            break;
        case 64:
            {
            alt129=2;
            }
            break;
        case 65:
            {
            alt129=3;
            }
            break;
        case 66:
            {
            alt129=4;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 129, 0, input);

            throw nvae;
        }

        switch (alt129) {
            case 1 :
                // InternalBacktrackingContentAssistTestLanguage.g:4118:3: lv_op_2_1= '>'
                {
                lv_op_2_1=(Token)match(input,63,FollowSets000.FOLLOW_6); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBacktrackingContentAssistTestLanguage.g:4130:8: lv_op_2_2= '<'
                {
                lv_op_2_2=(Token)match(input,64,FollowSets000.FOLLOW_6); if (state.failed) return ;

                }
                break;
            case 3 :
                // InternalBacktrackingContentAssistTestLanguage.g:4142:8: lv_op_2_3= '>='
                {
                lv_op_2_3=(Token)match(input,65,FollowSets000.FOLLOW_6); if (state.failed) return ;

                }
                break;
            case 4 :
                // InternalBacktrackingContentAssistTestLanguage.g:4154:8: lv_op_2_4= '<='
                {
                lv_op_2_4=(Token)match(input,66,FollowSets000.FOLLOW_6); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalBacktrackingContentAssistTestLanguage.g:4169:2: ( ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4170:1: ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4170:1: ( (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4171:1: (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4171:1: (lv_argument_3_1= ruleadditive | lv_argument_3_2= ruleLetExp )
        int alt130=2;
        int LA130_0 = input.LA(1);

        if ( ((LA130_0>=RULE_INT && LA130_0<=RULE_STRING)||LA130_0==16||(LA130_0>=33 && LA130_0<=34)||(LA130_0>=36 && LA130_0<=50)||(LA130_0>=54 && LA130_0<=57)||LA130_0==69||(LA130_0>=75 && LA130_0<=76)) ) {
            alt130=1;
        }
        else if ( (LA130_0==80) ) {
            alt130=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 130, 0, input);

            throw nvae;
        }
        switch (alt130) {
            case 1 :
                // InternalBacktrackingContentAssistTestLanguage.g:4172:3: lv_argument_3_1= ruleadditive
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_1=ruleadditive();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBacktrackingContentAssistTestLanguage.g:4187:8: lv_argument_3_2= ruleLetExp
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRelationalAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_2=ruleLetExp();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred101_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred104_InternalBacktrackingContentAssistTestLanguage
    public final void synpred104_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:4238:2: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4238:2: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4238:2: ()
        // InternalBacktrackingContentAssistTestLanguage.g:4239:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // InternalBacktrackingContentAssistTestLanguage.g:4247:2: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4248:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4248:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4249:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4249:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
        int alt131=2;
        int LA131_0 = input.LA(1);

        if ( (LA131_0==35) ) {
            alt131=1;
        }
        else if ( (LA131_0==36) ) {
            alt131=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 131, 0, input);

            throw nvae;
        }
        switch (alt131) {
            case 1 :
                // InternalBacktrackingContentAssistTestLanguage.g:4250:3: lv_op_2_1= '+'
                {
                lv_op_2_1=(Token)match(input,35,FollowSets000.FOLLOW_6); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBacktrackingContentAssistTestLanguage.g:4262:8: lv_op_2_2= '-'
                {
                lv_op_2_2=(Token)match(input,36,FollowSets000.FOLLOW_6); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalBacktrackingContentAssistTestLanguage.g:4277:2: ( ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4278:1: ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4278:1: ( (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4279:1: (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4279:1: (lv_argument_3_1= rulemultiplicative | lv_argument_3_2= ruleLetExp )
        int alt132=2;
        int LA132_0 = input.LA(1);

        if ( ((LA132_0>=RULE_INT && LA132_0<=RULE_STRING)||LA132_0==16||(LA132_0>=33 && LA132_0<=34)||(LA132_0>=36 && LA132_0<=50)||(LA132_0>=54 && LA132_0<=57)||LA132_0==69||(LA132_0>=75 && LA132_0<=76)) ) {
            alt132=1;
        }
        else if ( (LA132_0==80) ) {
            alt132=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 132, 0, input);

            throw nvae;
        }
        switch (alt132) {
            case 1 :
                // InternalBacktrackingContentAssistTestLanguage.g:4280:3: lv_argument_3_1= rulemultiplicative
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_1=rulemultiplicative();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBacktrackingContentAssistTestLanguage.g:4295:8: lv_argument_3_2= ruleLetExp
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getAdditiveAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_2=ruleLetExp();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred104_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred107_InternalBacktrackingContentAssistTestLanguage
    public final void synpred107_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:4346:2: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4346:2: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4346:2: ()
        // InternalBacktrackingContentAssistTestLanguage.g:4347:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // InternalBacktrackingContentAssistTestLanguage.g:4355:2: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4356:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4356:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4357:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4357:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
        int alt133=2;
        int LA133_0 = input.LA(1);

        if ( (LA133_0==67) ) {
            alt133=1;
        }
        else if ( (LA133_0==68) ) {
            alt133=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 133, 0, input);

            throw nvae;
        }
        switch (alt133) {
            case 1 :
                // InternalBacktrackingContentAssistTestLanguage.g:4358:3: lv_op_2_1= '*'
                {
                lv_op_2_1=(Token)match(input,67,FollowSets000.FOLLOW_6); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBacktrackingContentAssistTestLanguage.g:4370:8: lv_op_2_2= '/'
                {
                lv_op_2_2=(Token)match(input,68,FollowSets000.FOLLOW_6); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalBacktrackingContentAssistTestLanguage.g:4385:2: ( ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4386:1: ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4386:1: ( (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp ) )
        // InternalBacktrackingContentAssistTestLanguage.g:4387:1: (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp )
        {
        // InternalBacktrackingContentAssistTestLanguage.g:4387:1: (lv_argument_3_1= ruleunary | lv_argument_3_2= ruleLetExp )
        int alt134=2;
        int LA134_0 = input.LA(1);

        if ( ((LA134_0>=RULE_INT && LA134_0<=RULE_STRING)||LA134_0==16||(LA134_0>=33 && LA134_0<=34)||(LA134_0>=36 && LA134_0<=50)||(LA134_0>=54 && LA134_0<=57)||LA134_0==69||(LA134_0>=75 && LA134_0<=76)) ) {
            alt134=1;
        }
        else if ( (LA134_0==80) ) {
            alt134=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 134, 0, input);

            throw nvae;
        }
        switch (alt134) {
            case 1 :
                // InternalBacktrackingContentAssistTestLanguage.g:4388:3: lv_argument_3_1= ruleunary
                {
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_1=ruleunary();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBacktrackingContentAssistTestLanguage.g:4403:8: lv_argument_3_2= ruleLetExp
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getMultiplicativeAccess().getArgumentLetExpParserRuleCall_1_2_0_1()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_argument_3_2=ruleLetExp();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred107_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred110_InternalBacktrackingContentAssistTestLanguage
    public final void synpred110_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        EObject this_RoundBracketExp_0 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:4534:2: (this_RoundBracketExp_0= ruleRoundBracketExp )
        // InternalBacktrackingContentAssistTestLanguage.g:4534:2: this_RoundBracketExp_0= ruleRoundBracketExp
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_RoundBracketExp_0=ruleRoundBracketExp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred110_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred111_InternalBacktrackingContentAssistTestLanguage
    public final void synpred111_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        EObject this_SquareBracketExp_1 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:4547:2: (this_SquareBracketExp_1= ruleSquareBracketExp )
        // InternalBacktrackingContentAssistTestLanguage.g:4547:2: this_SquareBracketExp_1= ruleSquareBracketExp
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_SquareBracketExp_1=ruleSquareBracketExp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred111_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred114_InternalBacktrackingContentAssistTestLanguage
    public final void synpred114_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExp_4 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:4586:2: (this_TupleLiteralExp_4= ruleTupleLiteralExp )
        // InternalBacktrackingContentAssistTestLanguage.g:4586:2: this_TupleLiteralExp_4= ruleTupleLiteralExp
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_TupleLiteralExp_4=ruleTupleLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred114_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred115_InternalBacktrackingContentAssistTestLanguage
    public final void synpred115_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExp_5 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:4599:2: (this_CollectionLiteralExp_5= ruleCollectionLiteralExp )
        // InternalBacktrackingContentAssistTestLanguage.g:4599:2: this_CollectionLiteralExp_5= ruleCollectionLiteralExp
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_CollectionLiteralExp_5=ruleCollectionLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred115_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred116_InternalBacktrackingContentAssistTestLanguage
    public final void synpred116_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        EObject this_PreExp_6 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:4612:2: (this_PreExp_6= rulePreExp )
        // InternalBacktrackingContentAssistTestLanguage.g:4612:2: this_PreExp_6= rulePreExp
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_PreExp_6=rulePreExp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred116_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred117_InternalBacktrackingContentAssistTestLanguage
    public final void synpred117_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        EObject this_TypeExp_7 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:4625:2: (this_TypeExp_7= ruleTypeExp )
        // InternalBacktrackingContentAssistTestLanguage.g:4625:2: this_TypeExp_7= ruleTypeExp
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_TypeExp_7=ruleTypeExp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred117_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred119_InternalBacktrackingContentAssistTestLanguage
    public final void synpred119_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        EObject this_RoundBracketExp_0 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:4707:2: (this_RoundBracketExp_0= ruleRoundBracketExp )
        // InternalBacktrackingContentAssistTestLanguage.g:4707:2: this_RoundBracketExp_0= ruleRoundBracketExp
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_RoundBracketExp_0=ruleRoundBracketExp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred119_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred120_InternalBacktrackingContentAssistTestLanguage
    public final void synpred120_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        EObject this_SquareBracketExp_1 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:4720:2: (this_SquareBracketExp_1= ruleSquareBracketExp )
        // InternalBacktrackingContentAssistTestLanguage.g:4720:2: this_SquareBracketExp_1= ruleSquareBracketExp
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_SquareBracketExp_1=ruleSquareBracketExp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred120_InternalBacktrackingContentAssistTestLanguage

    // $ANTLR start synpred121_InternalBacktrackingContentAssistTestLanguage
    public final void synpred121_InternalBacktrackingContentAssistTestLanguage_fragment() throws RecognitionException {   
        EObject this_PreExp_2 = null;


        // InternalBacktrackingContentAssistTestLanguage.g:4733:2: (this_PreExp_2= rulePreExp )
        // InternalBacktrackingContentAssistTestLanguage.g:4733:2: this_PreExp_2= rulePreExp
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_PreExp_2=rulePreExp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred121_InternalBacktrackingContentAssistTestLanguage

    // Delegated rules

    public final boolean synpred114_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred115_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred120_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred120_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred121_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred121_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred116_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred116_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred111_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred111_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred107_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred104_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred104_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred110_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred110_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred91_InternalBacktrackingContentAssistTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_InternalBacktrackingContentAssistTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA86 dfa86 = new DFA86(this);
    protected DFA91 dfa91 = new DFA91(this);
    static final String dfa_1s = "\40\uffff";
    static final String dfa_2s = "\1\4\3\0\7\uffff\6\0\17\uffff";
    static final String dfa_3s = "\1\114\3\0\7\uffff\6\0\17\uffff";
    static final String dfa_4s = "\4\uffff\1\3\1\4\13\uffff\1\10\7\uffff\1\11\1\12\1\1\1\2\1\7\1\5\1\6";
    static final String dfa_5s = "\1\uffff\1\0\1\1\1\2\7\uffff\1\3\1\4\1\5\1\6\1\7\1\10\17\uffff}>";
    static final String[] dfa_6s = {
            "\1\5\1\1\1\5\11\uffff\1\32\20\uffff\1\2\1\3\2\uffff\10\21\1\14\1\15\1\16\1\17\1\20\1\13\3\uffff\4\5\21\uffff\1\4\1\31",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "4533:1: (this_RoundBracketExp_0= ruleRoundBracketExp | this_SquareBracketExp_1= ruleSquareBracketExp | this_SelfExp_2= ruleSelfExp | this_PrimitiveLiteralExp_3= rulePrimitiveLiteralExp | this_TupleLiteralExp_4= ruleTupleLiteralExp | this_CollectionLiteralExp_5= ruleCollectionLiteralExp | this_PreExp_6= rulePreExp | this_TypeExp_7= ruleTypeExp | this_IfExp_8= ruleIfExp | (otherlv_9= '(' () ( (lv_source_11_0= ruleExpression ) ) otherlv_12= ')' ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA86_1 = input.LA(1);

                         
                        int index86_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred110_InternalBacktrackingContentAssistTestLanguage()) ) {s = 27;}

                        else if ( (synpred111_InternalBacktrackingContentAssistTestLanguage()) ) {s = 28;}

                        else if ( (synpred116_InternalBacktrackingContentAssistTestLanguage()) ) {s = 29;}

                        else if ( (synpred117_InternalBacktrackingContentAssistTestLanguage()) ) {s = 17;}

                         
                        input.seek(index86_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA86_2 = input.LA(1);

                         
                        int index86_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred110_InternalBacktrackingContentAssistTestLanguage()) ) {s = 27;}

                        else if ( (synpred111_InternalBacktrackingContentAssistTestLanguage()) ) {s = 28;}

                        else if ( (synpred116_InternalBacktrackingContentAssistTestLanguage()) ) {s = 29;}

                        else if ( (synpred117_InternalBacktrackingContentAssistTestLanguage()) ) {s = 17;}

                         
                        input.seek(index86_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA86_3 = input.LA(1);

                         
                        int index86_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred110_InternalBacktrackingContentAssistTestLanguage()) ) {s = 27;}

                        else if ( (synpred111_InternalBacktrackingContentAssistTestLanguage()) ) {s = 28;}

                        else if ( (synpred116_InternalBacktrackingContentAssistTestLanguage()) ) {s = 29;}

                        else if ( (synpred117_InternalBacktrackingContentAssistTestLanguage()) ) {s = 17;}

                         
                        input.seek(index86_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA86_11 = input.LA(1);

                         
                        int index86_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_InternalBacktrackingContentAssistTestLanguage()) ) {s = 30;}

                        else if ( (synpred117_InternalBacktrackingContentAssistTestLanguage()) ) {s = 17;}

                         
                        input.seek(index86_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA86_12 = input.LA(1);

                         
                        int index86_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_InternalBacktrackingContentAssistTestLanguage()) ) {s = 31;}

                        else if ( (synpred117_InternalBacktrackingContentAssistTestLanguage()) ) {s = 17;}

                         
                        input.seek(index86_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA86_13 = input.LA(1);

                         
                        int index86_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_InternalBacktrackingContentAssistTestLanguage()) ) {s = 31;}

                        else if ( (synpred117_InternalBacktrackingContentAssistTestLanguage()) ) {s = 17;}

                         
                        input.seek(index86_13);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA86_14 = input.LA(1);

                         
                        int index86_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_InternalBacktrackingContentAssistTestLanguage()) ) {s = 31;}

                        else if ( (synpred117_InternalBacktrackingContentAssistTestLanguage()) ) {s = 17;}

                         
                        input.seek(index86_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA86_15 = input.LA(1);

                         
                        int index86_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_InternalBacktrackingContentAssistTestLanguage()) ) {s = 31;}

                        else if ( (synpred117_InternalBacktrackingContentAssistTestLanguage()) ) {s = 17;}

                         
                        input.seek(index86_15);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA86_16 = input.LA(1);

                         
                        int index86_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_InternalBacktrackingContentAssistTestLanguage()) ) {s = 31;}

                        else if ( (synpred117_InternalBacktrackingContentAssistTestLanguage()) ) {s = 17;}

                         
                        input.seek(index86_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 86, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\12\uffff";
    static final String dfa_8s = "\1\4\3\14\2\uffff\1\4\3\14";
    static final String dfa_9s = "\1\120\3\111\2\uffff\1\120\3\111";
    static final String dfa_10s = "\4\uffff\1\2\1\1\4\uffff";
    static final String dfa_11s = "\12\uffff}>";
    static final String[] dfa_12s = {
            "\1\4\1\1\1\4\11\uffff\1\4\1\uffff\1\4\16\uffff\1\2\1\3\1\uffff\17\4\3\uffff\4\4\13\uffff\1\4\5\uffff\2\4\3\uffff\1\4",
            "\1\5\3\uffff\1\4\1\6\2\4\7\uffff\5\4\3\uffff\2\4\25\uffff\13\4\1\uffff\1\4\2\5\1\4",
            "\1\5\3\uffff\1\4\1\6\2\4\7\uffff\5\4\3\uffff\2\4\25\uffff\13\4\1\uffff\1\4\2\5\1\4",
            "\1\5\3\uffff\1\4\1\6\2\4\7\uffff\5\4\3\uffff\2\4\25\uffff\13\4\1\uffff\1\4\2\5\1\4",
            "",
            "",
            "\1\4\1\7\1\4\11\uffff\1\4\20\uffff\1\10\1\11\1\uffff\17\4\3\uffff\4\4\13\uffff\1\4\5\uffff\2\4\3\uffff\1\4",
            "\1\5\3\uffff\4\4\7\uffff\5\4\3\uffff\2\4\25\uffff\13\4\1\uffff\1\4\1\uffff\1\5\1\4",
            "\1\5\3\uffff\4\4\7\uffff\5\4\3\uffff\2\4\25\uffff\13\4\1\uffff\1\4\1\uffff\1\5\1\4",
            "\1\5\3\uffff\4\4\7\uffff\5\4\3\uffff\2\4\25\uffff\13\4\1\uffff\1\4\1\uffff\1\5\1\4"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA91 extends DFA {

        public DFA91(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 91;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "4963:1: ( ( (lv_variable1_4_0= ruleiteratorVariable ) ) ( (otherlv_5= ',' ( (lv_variable2_6_0= ruleiteratorVariable ) ) ) | (otherlv_7= ';' ( (lv_variable2_8_0= ruleiteratorAccumulator ) ) ) )? otherlv_9= '|' )?";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000802002L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000600001020L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x03C7FFF600010070L,0x0000000000011820L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000600000020L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000040C002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000011000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0007FFE600040020L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0007FFE600000020L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0007FFE600080020L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0007FFE606000822L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000006000802L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001802000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000300002L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000300000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000000F0000002L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x03C7FFF700050070L,0x0000000000011820L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x03C7FFF700010070L,0x0000000000011820L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000610000002L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000600000002L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001800000010L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000600040020L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0008000000000002L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x03D7FFF600010070L,0x0000000000011820L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0010000000020000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000081000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0400000000000002L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0800000000000002L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x1000000000000002L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x4000000000080002L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000007L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000001800000002L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x03C7FFF600010070L,0x0000000000001820L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000040L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x03C7FFF600050070L,0x0000000000011820L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000180L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000400L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000020000L,0x0000000000020000L});
    }


}