package org.eclipse.xtext.purexbase.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.purexbase.services.PureXbaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalPureXbaseParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_HEX", "RULE_INT", "RULE_DECIMAL", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'import'", "'.*'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'=>'", "'<>'", "'?:'", "'<=>'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'.'", "'?.'", "'*.'", "','", "'('", "')'", "'['", "'|'", "']'", "'if'", "'else'", "'switch'", "':'", "'{'", "'default'", "'}'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'super'", "'::'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "'?'", "'extends'", "'&'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=8;
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
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=5;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=6;
    public static final int RULE_DECIMAL=7;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
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
    public static final int RULE_WS=11;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__77=77;

    // delegates
    // delegators


        public InternalPureXbaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPureXbaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPureXbaseParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g"; }



     	private PureXbaseGrammarAccess grammarAccess;
     	
        public InternalPureXbaseParser(TokenStream input, PureXbaseGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected PureXbaseGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:69:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:76:1: ruleModel returns [EObject current=null] : ( (lv_block_0_0= ruleSpecialBlockExpression ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_block_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:79:28: ( ( (lv_block_0_0= ruleSpecialBlockExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:80:1: ( (lv_block_0_0= ruleSpecialBlockExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:80:1: ( (lv_block_0_0= ruleSpecialBlockExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:81:1: (lv_block_0_0= ruleSpecialBlockExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:81:1: (lv_block_0_0= ruleSpecialBlockExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:82:3: lv_block_0_0= ruleSpecialBlockExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModelAccess().getBlockSpecialBlockExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSpecialBlockExpression_in_ruleModel130);
            lv_block_0_0=ruleSpecialBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModelRule());
              	        }
                     		set(
                     			current, 
                     			"block",
                      		lv_block_0_0, 
                      		"SpecialBlockExpression");
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSpecialBlockExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:106:1: entryRuleSpecialBlockExpression returns [EObject current=null] : iv_ruleSpecialBlockExpression= ruleSpecialBlockExpression EOF ;
    public final EObject entryRuleSpecialBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecialBlockExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:107:2: (iv_ruleSpecialBlockExpression= ruleSpecialBlockExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:108:2: iv_ruleSpecialBlockExpression= ruleSpecialBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpecialBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleSpecialBlockExpression_in_entryRuleSpecialBlockExpression165);
            iv_ruleSpecialBlockExpression=ruleSpecialBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecialBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecialBlockExpression175); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecialBlockExpression"


    // $ANTLR start "ruleSpecialBlockExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:115:1: ruleSpecialBlockExpression returns [EObject current=null] : ( () ( ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )? )* ) ;
    public final EObject ruleSpecialBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_expressions_1_0 = null;

        EObject lv_imports_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:118:28: ( ( () ( ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )? )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:119:1: ( () ( ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )? )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:119:1: ( () ( ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )? )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:119:2: () ( ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )? )*
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:119:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:120:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSpecialBlockExpressionAccess().getSpecialBlockExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:125:2: ( ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )? )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_ID)||LA3_0==14||LA3_0==26||(LA3_0>=33 && LA3_0<=34)||LA3_0==39||LA3_0==45||LA3_0==47||LA3_0==50||LA3_0==52||LA3_0==54||(LA3_0>=58 && LA3_0<=63)||(LA3_0>=65 && LA3_0<=72)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:125:3: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:125:3: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||LA1_0==26||(LA1_0>=33 && LA1_0<=34)||LA1_0==39||LA1_0==45||LA1_0==47||LA1_0==50||LA1_0==52||LA1_0==54||(LA1_0>=58 && LA1_0<=63)||(LA1_0>=65 && LA1_0<=72)) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==14) ) {
            	        alt1=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:125:4: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:125:4: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:126:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:126:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:127:3: lv_expressions_1_0= ruleXExpressionInsideBlock
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getSpecialBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleSpecialBlockExpression232);
            	            lv_expressions_1_0=ruleXExpressionInsideBlock();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getSpecialBlockExpressionRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"expressions",
            	                      		lv_expressions_1_0, 
            	                      		"XExpressionInsideBlock");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:144:6: ( (lv_imports_2_0= ruleImport ) )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:144:6: ( (lv_imports_2_0= ruleImport ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:145:1: (lv_imports_2_0= ruleImport )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:145:1: (lv_imports_2_0= ruleImport )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:146:3: lv_imports_2_0= ruleImport
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getSpecialBlockExpressionAccess().getImportsImportParserRuleCall_1_0_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleImport_in_ruleSpecialBlockExpression259);
            	            lv_imports_2_0=ruleImport();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getSpecialBlockExpressionRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"imports",
            	                      		lv_imports_2_0, 
            	                      		"Import");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:162:3: (otherlv_3= ';' )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==13) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:162:5: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleSpecialBlockExpression273); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getSpecialBlockExpressionAccess().getSemicolonKeyword_1_1());
            	                  
            	            }

            	            }
            	            break;

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
    // $ANTLR end "ruleSpecialBlockExpression"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:174:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:175:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:176:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport313);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport323); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:183:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:186:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:187:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:187:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:187:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleImport360); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:191:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:192:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:192:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:193:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport381);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportRule());
              	        }
                     		set(
                     			current, 
                     			"importedNamespace",
                      		lv_importedNamespace_1_0, 
                      		"QualifiedNameWithWildCard");
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:217:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:218:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:219:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard418);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard429); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:226:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:229:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:230:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:230:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:231:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard476);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:241:1: (kw= '.*' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:242:2: kw= '.*'
                    {
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleQualifiedNameWithWildCard495); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 
                          
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
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleXExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:255:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:256:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:257:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression537);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression547); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpression"


    // $ANTLR start "ruleXExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:264:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:267:28: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:269:5: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression593);
            this_XAssignment_0=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAssignment_0; 
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
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:285:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:286:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:287:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment627);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment637); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAssignment"


    // $ANTLR start "ruleXAssignment"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:294:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:297:28: ( ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:298:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:298:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==EOF||(LA6_1>=RULE_STRING && LA6_1<=RULE_ID)||(LA6_1>=13 && LA6_1<=14)||(LA6_1>=17 && LA6_1<=47)||(LA6_1>=49 && LA6_1<=74)) ) {
                    alt6=2;
                }
                else if ( (LA6_1==16) ) {
                    alt6=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_DECIMAL)||LA6_0==26||(LA6_0>=33 && LA6_0<=34)||LA6_0==39||LA6_0==45||LA6_0==47||LA6_0==50||LA6_0==52||LA6_0==54||(LA6_0>=58 && LA6_0<=60)||LA6_0==63||(LA6_0>=65 && LA6_0<=72)) ) {
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:298:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:298:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:298:3: () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:298:3: ()
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:299:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:304:2: ( ( ruleValidID ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:305:1: ( ruleValidID )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:305:1: ( ruleValidID )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:306:3: ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAssignmentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXAssignment695);
                    ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment711);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:327:1: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:328:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:328:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:329:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment731);
                    lv_value_3_0=ruleXAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_3_0, 
                              		"XAssignment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:346:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:346:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:347:5: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment761);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XOrExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==17) ) {
                        int LA5_1 = input.LA(2);

                        if ( (synpred1_InternalPureXbase()) ) {
                            alt5=1;
                        }
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:360:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:360:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:360:7: ()
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:361:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:366:2: ( ( ruleOpMultiAssign ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:367:1: ( ruleOpMultiAssign )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:367:1: ( ruleOpMultiAssign )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:368:3: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getXAssignmentRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment814);
                            ruleOpMultiAssign();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:381:4: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:382:1: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:382:1: (lv_rightOperand_7_0= ruleXAssignment )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:383:3: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment837);
                            lv_rightOperand_7_0=ruleXAssignment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"rightOperand",
                                      		lv_rightOperand_7_0, 
                                      		"XAssignment");
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
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:407:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:408:2: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:409:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign877);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign888); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:416:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:419:28: (kw= '=' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:421:2: kw= '='
            {
            kw=(Token)match(input,16,FOLLOW_16_in_ruleOpSingleAssign925); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword()); 
                  
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
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:434:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:435:2: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:436:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign965);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign976); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:443:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '+=' ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:446:28: (kw= '+=' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:448:2: kw= '+='
            {
            kw=(Token)match(input,17,FOLLOW_17_in_ruleOpMultiAssign1013); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword()); 
                  
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
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:461:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:462:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:463:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1052);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression1062); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXOrExpression"


    // $ANTLR start "ruleXOrExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:470:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:473:28: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:474:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:474:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:475:5: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1109);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    int LA7_2 = input.LA(2);

                    if ( (synpred2_InternalPureXbase()) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:488:6: ( () ( ( ruleOpOr ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:488:7: () ( ( ruleOpOr ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:488:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:489:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:494:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:495:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:495:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:496:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression1162);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:509:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:510:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:510:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:511:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1185);
            	    lv_rightOperand_3_0=ruleXAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:535:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:536:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:537:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr1224);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr1235); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:544:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:547:28: (kw= '||' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:549:2: kw= '||'
            {
            kw=(Token)match(input,18,FOLLOW_18_in_ruleOpOr1272); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); 
                  
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
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:562:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:563:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:564:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1311);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression1321); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAndExpression"


    // $ANTLR start "ruleXAndExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:571:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:574:28: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:575:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:575:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:576:5: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1368);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==19) ) {
                    int LA8_2 = input.LA(2);

                    if ( (synpred3_InternalPureXbase()) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:589:6: ( () ( ( ruleOpAnd ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:589:7: () ( ( ruleOpAnd ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:589:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:590:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:595:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:596:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:596:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:597:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression1421);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:610:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:611:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:611:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:612:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1444);
            	    lv_rightOperand_3_0=ruleXEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XEqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:636:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:637:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:638:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd1483);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd1494); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:645:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:648:28: (kw= '&&' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:650:2: kw= '&&'
            {
            kw=(Token)match(input,19,FOLLOW_19_in_ruleOpAnd1531); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); 
                  
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
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:663:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:664:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:665:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression1570);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression1580); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXEqualityExpression"


    // $ANTLR start "ruleXEqualityExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:672:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:675:28: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:676:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:676:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:677:5: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1627);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==20) ) {
                    int LA9_2 = input.LA(2);

                    if ( (synpred4_InternalPureXbase()) ) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==21) ) {
                    int LA9_3 = input.LA(2);

                    if ( (synpred4_InternalPureXbase()) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:690:6: ( () ( ( ruleOpEquality ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:690:7: () ( ( ruleOpEquality ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:690:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:691:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:696:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:697:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:697:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:698:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1680);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:711:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:712:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:712:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:713:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1703);
            	    lv_rightOperand_3_0=ruleXRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XRelationalExpression");
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
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:737:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:738:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:739:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality1742);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality1753); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:746:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:749:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:750:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:750:1: (kw= '==' | kw= '!=' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            else if ( (LA10_0==21) ) {
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:751:2: kw= '=='
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleOpEquality1791); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:758:2: kw= '!='
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleOpEquality1810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                          
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
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:771:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:772:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:773:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression1850);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression1860); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXRelationalExpression"


    // $ANTLR start "ruleXRelationalExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:780:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_type_3_0 = null;

        EObject lv_rightOperand_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:783:28: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:784:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:784:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:785:5: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1907);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:1: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop11:
            do {
                int alt11=3;
                switch ( input.LA(1) ) {
                case 25:
                    {
                    int LA11_2 = input.LA(2);

                    if ( (synpred6_InternalPureXbase()) ) {
                        alt11=2;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA11_3 = input.LA(2);

                    if ( (synpred6_InternalPureXbase()) ) {
                        alt11=2;
                    }


                    }
                    break;
                case 22:
                    {
                    int LA11_4 = input.LA(2);

                    if ( (synpred5_InternalPureXbase()) ) {
                        alt11=1;
                    }


                    }
                    break;
                case 23:
                    {
                    int LA11_5 = input.LA(2);

                    if ( (synpred6_InternalPureXbase()) ) {
                        alt11=2;
                    }


                    }
                    break;
                case 24:
                    {
                    int LA11_6 = input.LA(2);

                    if ( (synpred6_InternalPureXbase()) ) {
                        alt11=2;
                    }


                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:4: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:795:5: ( () otherlv_2= 'instanceof' )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:795:6: () otherlv_2= 'instanceof'
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:795:6: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:796:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleXRelationalExpression1943); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:805:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:806:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:806:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:807:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression1966);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"type",
            	              		lv_type_3_0, 
            	              		"JvmTypeReference");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:824:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:824:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:824:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:824:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:824:8: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:829:6: ( () ( ( ruleOpCompare ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:829:7: () ( ( ruleOpCompare ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:829:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:830:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:835:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:836:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:836:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:837:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2027);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:850:4: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:851:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:851:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:852:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2050);
            	    lv_rightOperand_6_0=ruleXOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_6_0, 
            	              		"XOtherOperatorExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:876:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:877:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:878:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare2090);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare2101); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:885:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:888:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:889:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:889:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt12=1;
                }
                break;
            case 24:
                {
                alt12=2;
                }
                break;
            case 25:
                {
                alt12=3;
                }
                break;
            case 26:
                {
                alt12=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:890:2: kw= '>='
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleOpCompare2139); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:897:2: kw= '<='
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleOpCompare2158); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:904:2: kw= '>'
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleOpCompare2177); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:911:2: kw= '<'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleOpCompare2196); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                          
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
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:924:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:925:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:926:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2236);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2246); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXOtherOperatorExpression"


    // $ANTLR start "ruleXOtherOperatorExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:933:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:936:28: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:937:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:937:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:938:5: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2293);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:946:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop13:
            do {
                int alt13=2;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:946:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:946:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:946:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:951:6: ( () ( ( ruleOpOther ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:951:7: () ( ( ruleOpOther ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:951:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:952:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:957:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:958:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:958:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:959:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2346);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:972:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:973:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:973:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:974:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2369);
            	    lv_rightOperand_3_0=ruleXAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XAdditiveExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:998:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:999:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1000:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther2408);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther2419); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1007:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' ) ) | kw= '<>' | kw= '?:' | kw= '<=>' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1010:28: ( (kw= '->' | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' ) ) | kw= '<>' | kw= '?:' | kw= '<=>' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1011:1: (kw= '->' | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' ) ) | kw= '<>' | kw= '?:' | kw= '<=>' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1011:1: (kw= '->' | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' ) ) | kw= '<>' | kw= '?:' | kw= '<=>' )
            int alt16=8;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt16=1;
                }
                break;
            case 28:
                {
                alt16=2;
                }
                break;
            case 29:
                {
                alt16=3;
                }
                break;
            case 25:
                {
                alt16=4;
                }
                break;
            case 26:
                {
                alt16=5;
                }
                break;
            case 30:
                {
                alt16=6;
                }
                break;
            case 31:
                {
                alt16=7;
                }
                break;
            case 32:
                {
                alt16=8;
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1012:2: kw= '->'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpOther2457); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1019:2: kw= '..'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpOther2476); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1026:2: kw= '=>'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpOther2495); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1032:6: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1032:6: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1033:2: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleOpOther2515); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_3_0()); 
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1038:1: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==25) ) {
                        int LA14_1 = input.LA(2);

                        if ( (LA14_1==EOF||(LA14_1>=RULE_STRING && LA14_1<=RULE_ID)||LA14_1==26||(LA14_1>=33 && LA14_1<=34)||LA14_1==39||LA14_1==45||LA14_1==47||LA14_1==50||LA14_1==52||LA14_1==54||(LA14_1>=58 && LA14_1<=60)||LA14_1==63||(LA14_1>=65 && LA14_1<=72)) ) {
                            alt14=2;
                        }
                        else if ( (LA14_1==25) && (synpred8_InternalPureXbase())) {
                            alt14=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1038:2: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1038:2: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1038:3: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1042:5: (kw= '>' kw= '>' )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1043:2: kw= '>' kw= '>'
                            {
                            kw=(Token)match(input,25,FOLLOW_25_in_ruleOpOther2546); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_3_1_0_0_0()); 
                                  
                            }
                            kw=(Token)match(input,25,FOLLOW_25_in_ruleOpOther2559); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_3_1_0_0_1()); 
                                  
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1056:2: kw= '>'
                            {
                            kw=(Token)match(input,25,FOLLOW_25_in_ruleOpOther2580); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_3_1_1()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1062:6: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1062:6: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1063:2: kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' )
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleOpOther2602); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_4_0()); 
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1068:1: ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==26) ) {
                        int LA15_1 = input.LA(2);

                        if ( (synpred9_InternalPureXbase()) ) {
                            alt15=1;
                        }
                        else if ( (true) ) {
                            alt15=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1068:2: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1068:2: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1068:3: ( ( '<' '<' ) )=> (kw= '<' kw= '<' )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1072:5: (kw= '<' kw= '<' )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1073:2: kw= '<' kw= '<'
                            {
                            kw=(Token)match(input,26,FOLLOW_26_in_ruleOpOther2633); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_4_1_0_0_0()); 
                                  
                            }
                            kw=(Token)match(input,26,FOLLOW_26_in_ruleOpOther2646); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_4_1_0_0_1()); 
                                  
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1086:2: kw= '<'
                            {
                            kw=(Token)match(input,26,FOLLOW_26_in_ruleOpOther2667); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_4_1_1()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1093:2: kw= '<>'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpOther2688); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1100:2: kw= '?:'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpOther2707); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1107:2: kw= '<=>'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpOther2726); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_7()); 
                          
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
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1120:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1121:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1122:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2766);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression2776); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAdditiveExpression"


    // $ANTLR start "ruleXAdditiveExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1129:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1132:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1133:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1133:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1134:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2823);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1142:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==33) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred10_InternalPureXbase()) ) {
                        alt17=1;
                    }


                }
                else if ( (LA17_0==34) ) {
                    int LA17_3 = input.LA(2);

                    if ( (synpred10_InternalPureXbase()) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1142:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1142:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1142:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1147:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1147:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1147:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1148:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1153:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1154:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1154:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1155:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression2876);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1168:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1169:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1169:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1170:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2899);
            	    lv_rightOperand_3_0=ruleXMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XMultiplicativeExpression");
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
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1194:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1195:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1196:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd2938);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd2949); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1203:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1206:28: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1207:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1207:1: (kw= '+' | kw= '-' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==33) ) {
                alt18=1;
            }
            else if ( (LA18_0==34) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1208:2: kw= '+'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpAdd2987); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1215:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpAdd3006); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                          
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
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1228:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1229:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1230:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3046);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3056); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXMultiplicativeExpression"


    // $ANTLR start "ruleXMultiplicativeExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1237:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1240:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1241:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1241:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1242:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3103);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1250:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop19:
            do {
                int alt19=2;
                switch ( input.LA(1) ) {
                case 35:
                    {
                    int LA19_2 = input.LA(2);

                    if ( (synpred11_InternalPureXbase()) ) {
                        alt19=1;
                    }


                    }
                    break;
                case 36:
                    {
                    int LA19_3 = input.LA(2);

                    if ( (synpred11_InternalPureXbase()) ) {
                        alt19=1;
                    }


                    }
                    break;
                case 37:
                    {
                    int LA19_4 = input.LA(2);

                    if ( (synpred11_InternalPureXbase()) ) {
                        alt19=1;
                    }


                    }
                    break;
                case 38:
                    {
                    int LA19_5 = input.LA(2);

                    if ( (synpred11_InternalPureXbase()) ) {
                        alt19=1;
                    }


                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1250:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1250:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1250:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1255:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1255:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1255:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1256:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1261:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1262:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1262:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1263:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3156);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1276:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1277:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1277:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1278:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3179);
            	    lv_rightOperand_3_0=ruleXUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XUnaryOperation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1302:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1303:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1304:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti3218);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti3229); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1311:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1314:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1315:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1315:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt20=1;
                }
                break;
            case 36:
                {
                alt20=2;
                }
                break;
            case 37:
                {
                alt20=3;
                }
                break;
            case 38:
                {
                alt20=4;
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1316:2: kw= '*'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpMulti3267); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1323:2: kw= '**'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpMulti3286); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1330:2: kw= '/'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpMulti3305); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1337:2: kw= '%'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpMulti3324); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); 
                          
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
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1350:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1351:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1352:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3364);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation3374); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXUnaryOperation"


    // $ANTLR start "ruleXUnaryOperation"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1359:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1362:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1363:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1363:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=33 && LA21_0<=34)||LA21_0==39) ) {
                alt21=1;
            }
            else if ( ((LA21_0>=RULE_STRING && LA21_0<=RULE_ID)||LA21_0==26||LA21_0==45||LA21_0==47||LA21_0==50||LA21_0==52||LA21_0==54||(LA21_0>=58 && LA21_0<=60)||LA21_0==63||(LA21_0>=65 && LA21_0<=72)) ) {
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1363:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1363:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1363:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1363:3: ()
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1364:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1369:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1370:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1370:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1371:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3432);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1384:2: ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1385:1: (lv_operand_2_0= ruleXUnaryOperation )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1385:1: (lv_operand_2_0= ruleXUnaryOperation )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1386:3: lv_operand_2_0= ruleXUnaryOperation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXUnaryOperationParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXUnaryOperation3453);
                    lv_operand_2_0=ruleXUnaryOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_2_0, 
                              		"XUnaryOperation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1404:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3482);
                    this_XCastedExpression_3=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XCastedExpression_3; 
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
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1420:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1421:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1422:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary3518);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary3529); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1429:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1432:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1433:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1433:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt22=1;
                }
                break;
            case 34:
                {
                alt22=2;
                }
                break;
            case 33:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1434:2: kw= '!'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleOpUnary3567); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1441:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpUnary3586); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1448:2: kw= '+'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpUnary3605); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                          
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
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXCastedExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1461:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1462:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1463:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3645);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression3655); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCastedExpression"


    // $ANTLR start "ruleXCastedExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1470:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1473:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1474:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1474:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1475:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3702);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1483:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==40) ) {
                    int LA23_2 = input.LA(2);

                    if ( (synpred12_InternalPureXbase()) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1483:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1483:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1483:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1485:5: ( () otherlv_2= 'as' )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1485:6: () otherlv_2= 'as'
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1485:6: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1486:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleXCastedExpression3737); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1495:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1496:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1496:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1497:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3760);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXCastedExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"type",
            	              		lv_type_3_0, 
            	              		"JvmTypeReference");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1521:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1522:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1523:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3798);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall3808); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXMemberFeatureCall"


    // $ANTLR start "ruleXMemberFeatureCall"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1530:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) ;
    public final EObject ruleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_7=null;
        Token lv_nullSafe_8_0=null;
        Token lv_spreading_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token lv_explicitOperationCall_16_0=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        EObject this_XPrimaryExpression_0 = null;

        EObject lv_value_5_0 = null;

        EObject lv_typeArguments_11_0 = null;

        EObject lv_typeArguments_13_0 = null;

        EObject lv_memberCallArguments_17_0 = null;

        EObject lv_memberCallArguments_18_0 = null;

        EObject lv_memberCallArguments_20_0 = null;

        EObject lv_memberCallArguments_22_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1533:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1534:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1534:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1535:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall3855);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1543:1: ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            loop31:
            do {
                int alt31=3;
                switch ( input.LA(1) ) {
                case 41:
                    {
                    int LA31_2 = input.LA(2);

                    if ( (synpred13_InternalPureXbase()) ) {
                        alt31=1;
                    }
                    else if ( (synpred14_InternalPureXbase()) ) {
                        alt31=2;
                    }


                    }
                    break;
                case 42:
                    {
                    int LA31_3 = input.LA(2);

                    if ( (synpred14_InternalPureXbase()) ) {
                        alt31=2;
                    }


                    }
                    break;
                case 43:
                    {
                    int LA31_4 = input.LA(2);

                    if ( (synpred14_InternalPureXbase()) ) {
                        alt31=2;
                    }


                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1543:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1543:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1543:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1543:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1543:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1549:25: ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1549:26: () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1549:26: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1550:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleXMemberFeatureCall3904); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1559:1: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1560:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1560:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1561:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3927);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall3943);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1582:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1583:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1583:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1584:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall3965);
            	    lv_value_5_0=ruleXAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"value",
            	              		lv_value_5_0, 
            	              		"XAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1601:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1601:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1601:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1601:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1601:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1617:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1617:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1617:8: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1618:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1623:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt24=3;
            	    switch ( input.LA(1) ) {
            	    case 41:
            	        {
            	        alt24=1;
            	        }
            	        break;
            	    case 42:
            	        {
            	        alt24=2;
            	        }
            	        break;
            	    case 43:
            	        {
            	        alt24=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt24) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1623:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,41,FOLLOW_41_in_ruleXMemberFeatureCall4051); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1628:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1628:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1629:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1629:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1630:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,42,FOLLOW_42_in_ruleXMemberFeatureCall4075); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_nullSafe_8_0, grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "nullSafe", true, "?.");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1644:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1644:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1645:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1645:1: (lv_spreading_9_0= '*.' )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1646:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,43,FOLLOW_43_in_ruleXMemberFeatureCall4112); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_spreading_9_0, grammarAccess.getXMemberFeatureCallAccess().getSpreadingAsteriskFullStopKeyword_1_1_0_0_1_2_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "spreading", true, "*.");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1659:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==26) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1659:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,26,FOLLOW_26_in_ruleXMemberFeatureCall4141); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1663:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1664:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1664:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1665:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4162);
            	            lv_typeArguments_11_0=ruleJvmArgumentTypeReference();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"typeArguments",
            	                      		lv_typeArguments_11_0, 
            	                      		"JvmArgumentTypeReference");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1681:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop25:
            	            do {
            	                int alt25=2;
            	                int LA25_0 = input.LA(1);

            	                if ( (LA25_0==44) ) {
            	                    alt25=1;
            	                }


            	                switch (alt25) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1681:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,44,FOLLOW_44_in_ruleXMemberFeatureCall4175); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1685:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1686:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1686:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1687:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4196);
            	            	    lv_typeArguments_13_0=ruleJvmArgumentTypeReference();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      	        if (current==null) {
            	            	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	            	      	        }
            	            	             		add(
            	            	             			current, 
            	            	             			"typeArguments",
            	            	              		lv_typeArguments_13_0, 
            	            	              		"JvmArgumentTypeReference");
            	            	      	        afterParserOrEnumRuleCall();
            	            	      	    
            	            	    }

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop25;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,25,FOLLOW_25_in_ruleXMemberFeatureCall4210); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1707:3: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1708:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1708:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1709:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4235);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1722:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt29=2;
            	    alt29 = dfa29.predict(input);
            	    switch (alt29) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1722:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1722:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1722:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1729:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1730:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,45,FOLLOW_45_in_ruleXMemberFeatureCall4269); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_explicitOperationCall_16_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "explicitOperationCall", true, "(");
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1743:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt28=3;
            	            alt28 = dfa28.predict(input);
            	            switch (alt28) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1743:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1743:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1743:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1760:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1761:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4354);
            	                    lv_memberCallArguments_17_0=ruleXShortClosure();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"memberCallArguments",
            	                              		lv_memberCallArguments_17_0, 
            	                              		"XShortClosure");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }


            	                    }
            	                    break;
            	                case 2 :
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1778:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1778:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1778:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1778:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1779:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1779:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1780:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4382);
            	                    lv_memberCallArguments_18_0=ruleXExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"memberCallArguments",
            	                              		lv_memberCallArguments_18_0, 
            	                              		"XExpression");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1796:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop27:
            	                    do {
            	                        int alt27=2;
            	                        int LA27_0 = input.LA(1);

            	                        if ( (LA27_0==44) ) {
            	                            alt27=1;
            	                        }


            	                        switch (alt27) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1796:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,44,FOLLOW_44_in_ruleXMemberFeatureCall4395); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1800:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1801:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1801:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1802:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4416);
            	                    	    lv_memberCallArguments_20_0=ruleXExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                    	      	        }
            	                    	             		add(
            	                    	             			current, 
            	                    	             			"memberCallArguments",
            	                    	              		lv_memberCallArguments_20_0, 
            	                    	              		"XExpression");
            	                    	      	        afterParserOrEnumRuleCall();
            	                    	      	    
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop27;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_21=(Token)match(input,46,FOLLOW_46_in_ruleXMemberFeatureCall4433); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_21, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1822:3: ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    int alt30=2;
            	    alt30 = dfa30.predict(input);
            	    switch (alt30) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1822:4: ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1825:1: (lv_memberCallArguments_22_0= ruleXClosure )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1826:3: lv_memberCallArguments_22_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4468);
            	            lv_memberCallArguments_22_0=ruleXClosure();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"memberCallArguments",
            	                      		lv_memberCallArguments_22_0, 
            	                      		"XClosure");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1850:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1851:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1852:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4508);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression4518); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXPrimaryExpression"


    // $ANTLR start "ruleXPrimaryExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1859:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XConstructorCall_0 = null;

        EObject this_XBlockExpression_1 = null;

        EObject this_XSwitchExpression_2 = null;

        EObject this_XFeatureCall_3 = null;

        EObject this_XLiteral_4 = null;

        EObject this_XIfExpression_5 = null;

        EObject this_XForLoopExpression_6 = null;

        EObject this_XWhileExpression_7 = null;

        EObject this_XDoWhileExpression_8 = null;

        EObject this_XThrowExpression_9 = null;

        EObject this_XReturnExpression_10 = null;

        EObject this_XTryCatchFinallyExpression_11 = null;

        EObject this_XParenthesizedExpression_12 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1862:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1863:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1863:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            int alt32=13;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1864:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4565);
                    this_XConstructorCall_0=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XConstructorCall_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1874:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4592);
                    this_XBlockExpression_1=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBlockExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1884:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4619);
                    this_XSwitchExpression_2=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XSwitchExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1894:5: this_XFeatureCall_3= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression4646);
                    this_XFeatureCall_3=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFeatureCall_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1904:5: this_XLiteral_4= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression4673);
                    this_XLiteral_4=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1914:5: this_XIfExpression_5= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4700);
                    this_XIfExpression_5=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIfExpression_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1924:5: this_XForLoopExpression_6= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression4727);
                    this_XForLoopExpression_6=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XForLoopExpression_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1934:5: this_XWhileExpression_7= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4754);
                    this_XWhileExpression_7=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWhileExpression_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1944:5: this_XDoWhileExpression_8= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4781);
                    this_XDoWhileExpression_8=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XDoWhileExpression_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1954:5: this_XThrowExpression_9= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4808);
                    this_XThrowExpression_9=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XThrowExpression_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1964:5: this_XReturnExpression_10= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression4835);
                    this_XReturnExpression_10=ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XReturnExpression_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1974:5: this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4862);
                    this_XTryCatchFinallyExpression_11=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_11; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1984:5: this_XParenthesizedExpression_12= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4889);
                    this_XParenthesizedExpression_12=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_12; 
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
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleXLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2000:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2001:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2002:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral4924);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral4934); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXLiteral"


    // $ANTLR start "ruleXLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2009:1: ruleXLiteral returns [EObject current=null] : ( ( ( ( () '[' ) )=>this_XClosure_0= ruleXClosure ) | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XClosure_0 = null;

        EObject this_XBooleanLiteral_1 = null;

        EObject this_XNumberLiteral_2 = null;

        EObject this_XNullLiteral_3 = null;

        EObject this_XStringLiteral_4 = null;

        EObject this_XTypeLiteral_5 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2012:28: ( ( ( ( ( () '[' ) )=>this_XClosure_0= ruleXClosure ) | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2013:1: ( ( ( ( () '[' ) )=>this_XClosure_0= ruleXClosure ) | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2013:1: ( ( ( ( () '[' ) )=>this_XClosure_0= ruleXClosure ) | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt33=6;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==47) && (synpred18_InternalPureXbase())) {
                alt33=1;
            }
            else if ( ((LA33_0>=66 && LA33_0<=67)) ) {
                alt33=2;
            }
            else if ( ((LA33_0>=RULE_HEX && LA33_0<=RULE_DECIMAL)) ) {
                alt33=3;
            }
            else if ( (LA33_0==68) ) {
                alt33=4;
            }
            else if ( (LA33_0==RULE_STRING) ) {
                alt33=5;
            }
            else if ( (LA33_0==69) ) {
                alt33=6;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2013:2: ( ( ( () '[' ) )=>this_XClosure_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2013:2: ( ( ( () '[' ) )=>this_XClosure_0= ruleXClosure )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2013:3: ( ( () '[' ) )=>this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral4994);
                    this_XClosure_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XClosure_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2026:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5022);
                    this_XBooleanLiteral_1=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBooleanLiteral_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2036:5: this_XNumberLiteral_2= ruleXNumberLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNumberLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNumberLiteral_in_ruleXLiteral5049);
                    this_XNumberLiteral_2=ruleXNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XNumberLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2046:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral5076);
                    this_XNullLiteral_3=ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XNullLiteral_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2056:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral5103);
                    this_XStringLiteral_4=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XStringLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2066:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5130);
                    this_XTypeLiteral_5=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTypeLiteral_5; 
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
    // $ANTLR end "ruleXLiteral"


    // $ANTLR start "entryRuleXClosure"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2082:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2083:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2084:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure5165);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure5175); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXClosure"


    // $ANTLR start "ruleXClosure"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2091:1: ruleXClosure returns [EObject current=null] : ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_explicitSyntax_5_0=null;
        Token otherlv_7=null;
        EObject lv_declaredFormalParameters_2_0 = null;

        EObject lv_declaredFormalParameters_4_0 = null;

        EObject lv_expression_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2094:28: ( ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2095:1: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2095:1: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2095:2: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2095:2: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2095:3: ( ( () '[' ) )=> ( () otherlv_1= '[' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2097:5: ( () otherlv_1= '[' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2097:6: () otherlv_1= '['
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2097:6: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2098:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleXClosure5235); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_0_0_1());
                  
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2107:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt36=2;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2107:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2122:6: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2122:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2122:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==RULE_ID||LA35_0==29||LA35_0==45) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2122:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2122:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2123:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2123:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2124:3: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5308);
                            lv_declaredFormalParameters_2_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"declaredFormalParameters",
                                      		lv_declaredFormalParameters_2_0, 
                                      		"JvmFormalParameter");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2140:2: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop34:
                            do {
                                int alt34=2;
                                int LA34_0 = input.LA(1);

                                if ( (LA34_0==44) ) {
                                    alt34=1;
                                }


                                switch (alt34) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2140:4: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleXClosure5321); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_1_0_0_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2144:1: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2145:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2145:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2146:3: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5342);
                            	    lv_declaredFormalParameters_4_0=ruleJvmFormalParameter();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"declaredFormalParameters",
                            	              		lv_declaredFormalParameters_4_0, 
                            	              		"JvmFormalParameter");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
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

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2162:6: ( (lv_explicitSyntax_5_0= '|' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2163:1: (lv_explicitSyntax_5_0= '|' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2163:1: (lv_explicitSyntax_5_0= '|' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2164:3: lv_explicitSyntax_5_0= '|'
                    {
                    lv_explicitSyntax_5_0=(Token)match(input,48,FOLLOW_48_in_ruleXClosure5364); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitSyntax_5_0, grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_1_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXClosureRule());
                      	        }
                             		setWithLastConsumed(current, "explicitSyntax", true, "|");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2177:5: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2178:1: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2178:1: (lv_expression_6_0= ruleXExpressionInClosure )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2179:3: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5401);
            lv_expression_6_0=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXClosureRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_6_0, 
                      		"XExpressionInClosure");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,49,FOLLOW_49_in_ruleXClosure5413); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_3());
                  
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
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXExpressionInClosure"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2207:1: entryRuleXExpressionInClosure returns [EObject current=null] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInClosure = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2208:2: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2209:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5449);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInClosure5459); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpressionInClosure"


    // $ANTLR start "ruleXExpressionInClosure"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2216:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) ;
    public final EObject ruleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2219:28: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2220:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2220:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2220:2: () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2220:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2221:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2226:2: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_STRING && LA38_0<=RULE_ID)||LA38_0==26||(LA38_0>=33 && LA38_0<=34)||LA38_0==39||LA38_0==45||LA38_0==47||LA38_0==50||LA38_0==52||LA38_0==54||(LA38_0>=58 && LA38_0<=63)||(LA38_0>=65 && LA38_0<=72)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2226:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )?
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2226:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2227:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2227:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2228:3: lv_expressions_1_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5515);
            	    lv_expressions_1_0=ruleXExpressionInsideBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXExpressionInClosureRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_1_0, 
            	              		"XExpressionInsideBlock");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2244:2: (otherlv_2= ';' )?
            	    int alt37=2;
            	    int LA37_0 = input.LA(1);

            	    if ( (LA37_0==13) ) {
            	        alt37=1;
            	    }
            	    switch (alt37) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2244:4: otherlv_2= ';'
            	            {
            	            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleXExpressionInClosure5528); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
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
    // $ANTLR end "ruleXExpressionInClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2256:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2257:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2258:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5568);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure5578); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXShortClosure"


    // $ANTLR start "ruleXShortClosure"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2265:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        EObject lv_declaredFormalParameters_1_0 = null;

        EObject lv_declaredFormalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2268:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2269:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2269:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2269:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2269:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2269:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2285:6: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2285:7: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2285:7: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2286:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2291:2: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID||LA40_0==29||LA40_0==45) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2291:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2291:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2292:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2292:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2293:3: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5686);
                    lv_declaredFormalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                      	        }
                             		add(
                             			current, 
                             			"declaredFormalParameters",
                              		lv_declaredFormalParameters_1_0, 
                              		"JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2309:2: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==44) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2309:4: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXShortClosure5699); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2313:1: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2314:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2314:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2315:3: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5720);
                    	    lv_declaredFormalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"declaredFormalParameters",
                    	              		lv_declaredFormalParameters_3_0, 
                    	              		"JvmFormalParameter");
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

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2331:6: ( (lv_explicitSyntax_4_0= '|' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2332:1: (lv_explicitSyntax_4_0= '|' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2332:1: (lv_explicitSyntax_4_0= '|' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2333:3: lv_explicitSyntax_4_0= '|'
            {
            lv_explicitSyntax_4_0=(Token)match(input,48,FOLLOW_48_in_ruleXShortClosure5742); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_explicitSyntax_4_0, grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXShortClosureRule());
              	        }
                     		setWithLastConsumed(current, "explicitSyntax", true, "|");
              	    
            }

            }


            }


            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2346:4: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2347:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2347:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2348:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure5778);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_5_0, 
                      		"XExpression");
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
    // $ANTLR end "ruleXShortClosure"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2372:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2373:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2374:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5814);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression5824); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXParenthesizedExpression"


    // $ANTLR start "ruleXParenthesizedExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2381:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2384:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2385:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2385:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2385:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleXParenthesizedExpression5861); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5883);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleXParenthesizedExpression5894); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                  
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
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXIfExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2410:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2411:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2412:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5930);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression5940); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXIfExpression"


    // $ANTLR start "ruleXIfExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2419:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_if_3_0 = null;

        EObject lv_then_5_0 = null;

        EObject lv_else_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2422:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2423:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2423:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2423:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2423:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2424:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleXIfExpression5986); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleXIfExpression5998); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2437:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2438:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2438:1: (lv_if_3_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2439:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6019);
            lv_if_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"if",
                      		lv_if_3_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleXIfExpression6031); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2459:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2460:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2460:1: (lv_then_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2461:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6052);
            lv_then_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2477:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==51) ) {
                int LA41_1 = input.LA(2);

                if ( (synpred22_InternalPureXbase()) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2477:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2477:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2477:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,51,FOLLOW_51_in_ruleXIfExpression6073); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2482:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2483:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2483:1: (lv_else_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2484:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6095);
                    lv_else_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_7_0, 
                              		"XExpression");
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
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2508:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2509:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2510:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6133);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression6143); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXSwitchExpression"


    // $ANTLR start "ruleXSwitchExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2517:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_localVarName_2_0 = null;

        EObject lv_switch_4_0 = null;

        AntlrDatatypeRuleToken lv_localVarName_6_0 = null;

        EObject lv_switch_8_0 = null;

        EObject lv_cases_11_0 = null;

        EObject lv_default_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2520:28: ( ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2521:1: ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2521:1: ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2521:2: () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2521:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2522:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleXSwitchExpression6189); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2531:1: ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_STRING && LA43_0<=RULE_ID)||LA43_0==26||(LA43_0>=33 && LA43_0<=34)||LA43_0==39||LA43_0==47||LA43_0==50||LA43_0==52||LA43_0==54||(LA43_0>=58 && LA43_0<=60)||LA43_0==63||(LA43_0>=65 && LA43_0<=72)) ) {
                alt43=1;
            }
            else if ( (LA43_0==45) ) {
                int LA43_2 = input.LA(2);

                if ( (LA43_2==RULE_ID) ) {
                    int LA43_3 = input.LA(3);

                    if ( ((LA43_3>=16 && LA43_3<=38)||(LA43_3>=40 && LA43_3<=43)||(LA43_3>=45 && LA43_3<=47)||LA43_3==64) ) {
                        alt43=1;
                    }
                    else if ( (LA43_3==53) && (synpred24_InternalPureXbase())) {
                        alt43=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 3, input);

                        throw nvae;
                    }
                }
                else if ( ((LA43_2>=RULE_STRING && LA43_2<=RULE_DECIMAL)||LA43_2==26||(LA43_2>=33 && LA43_2<=34)||LA43_2==39||LA43_2==45||LA43_2==47||LA43_2==50||LA43_2==52||LA43_2==54||(LA43_2>=58 && LA43_2<=60)||LA43_2==63||(LA43_2>=65 && LA43_2<=72)) ) {
                    alt43=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2531:2: ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2531:2: ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2531:3: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2531:3: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==RULE_ID) ) {
                        int LA42_1 = input.LA(2);

                        if ( (LA42_1==53) && (synpred23_InternalPureXbase())) {
                            alt42=1;
                        }
                    }
                    switch (alt42) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2531:4: ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2536:5: ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2536:6: ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':'
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2536:6: ( (lv_localVarName_2_0= ruleValidID ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2537:1: (lv_localVarName_2_0= ruleValidID )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2537:1: (lv_localVarName_2_0= ruleValidID )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2538:3: lv_localVarName_2_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_0_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression6232);
                            lv_localVarName_2_0=ruleValidID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"localVarName",
                                      		lv_localVarName_2_0, 
                                      		"ValidID");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_3=(Token)match(input,53,FOLLOW_53_in_ruleXSwitchExpression6244); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_1());
                                  
                            }

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2558:4: ( (lv_switch_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2559:1: (lv_switch_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2559:1: (lv_switch_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2560:3: lv_switch_4_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6268);
                    lv_switch_4_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"switch",
                              		lv_switch_4_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2577:6: ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2577:6: ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2577:7: ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')'
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2577:7: ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2577:8: ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2583:5: (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2583:7: otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':'
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_45_in_ruleXSwitchExpression6312); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_1_0_0_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2587:1: ( (lv_localVarName_6_0= ruleValidID ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2588:1: (lv_localVarName_6_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2588:1: (lv_localVarName_6_0= ruleValidID )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2589:3: lv_localVarName_6_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_1_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression6333);
                    lv_localVarName_6_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"localVarName",
                              		lv_localVarName_6_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,53,FOLLOW_53_in_ruleXSwitchExpression6345); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_2());
                          
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2609:3: ( (lv_switch_8_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2610:1: (lv_switch_8_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2610:1: (lv_switch_8_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2611:3: lv_switch_8_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6368);
                    lv_switch_8_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"switch",
                              		lv_switch_8_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,46,FOLLOW_46_in_ruleXSwitchExpression6380); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,54,FOLLOW_54_in_ruleXSwitchExpression6394); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2635:1: ( (lv_cases_11_0= ruleXCasePart ) )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_ID||LA44_0==29||LA44_0==45||LA44_0==53||LA44_0==57) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2636:1: (lv_cases_11_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2636:1: (lv_cases_11_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2637:3: lv_cases_11_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6415);
            	    lv_cases_11_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"cases",
            	              		lv_cases_11_0, 
            	              		"XCasePart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt44 >= 1 ) break loop44;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
            } while (true);

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2653:3: (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==55) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2653:5: otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) )
                    {
                    otherlv_12=(Token)match(input,55,FOLLOW_55_in_ruleXSwitchExpression6429); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0());
                          
                    }
                    otherlv_13=(Token)match(input,53,FOLLOW_53_in_ruleXSwitchExpression6441); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2661:1: ( (lv_default_14_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2662:1: (lv_default_14_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2662:1: (lv_default_14_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2663:3: lv_default_14_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6462);
                    lv_default_14_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"default",
                              		lv_default_14_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,56,FOLLOW_56_in_ruleXSwitchExpression6476); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_6());
                  
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
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXCasePart"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2691:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2692:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2693:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6512);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6522); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCasePart"


    // $ANTLR start "ruleXCasePart"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2700:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2703:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2704:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2704:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2704:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2704:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID||LA46_0==29||LA46_0==45) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2705:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2705:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2706:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6568);
                    lv_typeGuard_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"typeGuard",
                              		lv_typeGuard_0_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2722:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==57) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2722:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleXCasePart6582); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2726:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2727:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2727:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2728:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6603);
                    lv_case_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"case",
                              		lv_case_2_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,53,FOLLOW_53_in_ruleXCasePart6617); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2748:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2749:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2749:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2750:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6638);
            lv_then_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_4_0, 
                      		"XExpression");
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
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2774:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2775:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2776:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6674);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression6684); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXForLoopExpression"


    // $ANTLR start "ruleXForLoopExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2783:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
    public final EObject ruleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_declaredParam_3_0 = null;

        EObject lv_forExpression_5_0 = null;

        EObject lv_eachExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2786:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2787:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2787:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2787:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2787:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2788:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleXForLoopExpression6730); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleXForLoopExpression6742); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2801:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2802:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2802:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2803:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6763);
            lv_declaredParam_3_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_3_0, 
                      		"JvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,53,FOLLOW_53_in_ruleXForLoopExpression6775); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2823:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2824:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2824:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2825:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6796);
            lv_forExpression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"forExpression",
                      		lv_forExpression_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,46,FOLLOW_46_in_ruleXForLoopExpression6808); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2845:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2846:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2846:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2847:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6829);
            lv_eachExpression_7_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"eachExpression",
                      		lv_eachExpression_7_0, 
                      		"XExpression");
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
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2871:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2872:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2873:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6865);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression6875); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXWhileExpression"


    // $ANTLR start "ruleXWhileExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2880:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2883:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2884:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2884:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2884:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2884:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2885:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleXWhileExpression6921); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleXWhileExpression6933); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2898:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2899:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2899:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2900:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression6954);
            lv_predicate_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_3_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleXWhileExpression6966); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2920:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2921:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2921:1: (lv_body_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2922:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression6987);
            lv_body_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_5_0, 
                      		"XExpression");
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
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2946:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2947:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2948:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7023);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression7033); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXDoWhileExpression"


    // $ANTLR start "ruleXDoWhileExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2955:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
    public final EObject ruleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_body_2_0 = null;

        EObject lv_predicate_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2958:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2959:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2959:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2959:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2959:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2960:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,60,FOLLOW_60_in_ruleXDoWhileExpression7079); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2969:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2970:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2970:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2971:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7100);
            lv_body_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,59,FOLLOW_59_in_ruleXDoWhileExpression7112); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,45,FOLLOW_45_in_ruleXDoWhileExpression7124); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2995:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2996:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2996:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2997:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7145);
            lv_predicate_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,46,FOLLOW_46_in_ruleXDoWhileExpression7157); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6());
                  
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
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXBlockExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3025:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3026:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3027:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7193);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression7203); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXBlockExpression"


    // $ANTLR start "ruleXBlockExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3034:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3037:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3038:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3038:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3038:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3038:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3039:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,54,FOLLOW_54_in_ruleXBlockExpression7249); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3048:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=RULE_STRING && LA49_0<=RULE_ID)||LA49_0==26||(LA49_0>=33 && LA49_0<=34)||LA49_0==39||LA49_0==45||LA49_0==47||LA49_0==50||LA49_0==52||LA49_0==54||(LA49_0>=58 && LA49_0<=63)||(LA49_0>=65 && LA49_0<=72)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3048:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3048:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3049:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3049:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3050:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7271);
            	    lv_expressions_2_0=ruleXExpressionInsideBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXBlockExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_2_0, 
            	              		"XExpressionInsideBlock");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3066:2: (otherlv_3= ';' )?
            	    int alt48=2;
            	    int LA48_0 = input.LA(1);

            	    if ( (LA48_0==13) ) {
            	        alt48=1;
            	    }
            	    switch (alt48) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3066:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleXBlockExpression7284); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            otherlv_4=(Token)match(input,56,FOLLOW_56_in_ruleXBlockExpression7300); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3());
                  
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
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXExpressionInsideBlock"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3082:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3083:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3084:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7336);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7346); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpressionInsideBlock"


    // $ANTLR start "ruleXExpressionInsideBlock"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3091:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3094:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3095:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3095:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=61 && LA50_0<=62)) ) {
                alt50=1;
            }
            else if ( ((LA50_0>=RULE_STRING && LA50_0<=RULE_ID)||LA50_0==26||(LA50_0>=33 && LA50_0<=34)||LA50_0==39||LA50_0==45||LA50_0==47||LA50_0==50||LA50_0==52||LA50_0==54||(LA50_0>=58 && LA50_0<=60)||LA50_0==63||(LA50_0>=65 && LA50_0<=72)) ) {
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3096:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7393);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XVariableDeclaration_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3106:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7420);
                    this_XExpression_1=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XExpression_1; 
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
    // $ANTLR end "ruleXExpressionInsideBlock"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3122:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3123:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3124:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7455);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7465); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXVariableDeclaration"


    // $ANTLR start "ruleXVariableDeclaration"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3131:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3134:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3135:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3135:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3135:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3135:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3136:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3141:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==61) ) {
                alt51=1;
            }
            else if ( (LA51_0==62) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3141:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3141:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3142:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3142:1: (lv_writeable_1_0= 'var' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3143:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,61,FOLLOW_61_in_ruleXVariableDeclaration7518); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_writeable_1_0, grammarAccess.getXVariableDeclarationAccess().getWriteableVarKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		setWithLastConsumed(current, "writeable", true, "var");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3157:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,62,FOLLOW_62_in_ruleXVariableDeclaration7549); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3161:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                int LA52_1 = input.LA(2);

                if ( (synpred25_InternalPureXbase()) ) {
                    alt52=1;
                }
                else if ( (true) ) {
                    alt52=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA52_0==45) && (synpred25_InternalPureXbase())) {
                alt52=1;
            }
            else if ( (LA52_0==29) && (synpred25_InternalPureXbase())) {
                alt52=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3161:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3161:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3161:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3169:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3169:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3169:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3170:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3170:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3171:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7597);
                    lv_type_3_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_3_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3187:2: ( (lv_name_4_0= ruleValidID ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3188:1: (lv_name_4_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3188:1: (lv_name_4_0= ruleValidID )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3189:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7618);
                    lv_name_4_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3206:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3206:6: ( (lv_name_5_0= ruleValidID ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3207:1: (lv_name_5_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3207:1: (lv_name_5_0= ruleValidID )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3208:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7647);
                    lv_name_5_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_5_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3224:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==16) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3224:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleXVariableDeclaration7661); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3228:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3229:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3229:1: (lv_right_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3230:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7682);
                    lv_right_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_7_0, 
                              		"XExpression");
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
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3254:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3255:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3256:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7720);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter7730); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmFormalParameter"


    // $ANTLR start "ruleJvmFormalParameter"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3263:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3266:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3267:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3267:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3267:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3267:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==RULE_ID||LA54_1==26||LA54_1==41||LA54_1==47) ) {
                    alt54=1;
                }
            }
            else if ( (LA54_0==29||LA54_0==45) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3268:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3268:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3269:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7776);
                    lv_parameterType_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"parameterType",
                              		lv_parameterType_0_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3285:3: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3286:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3286:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3287:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameter7798);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ValidID");
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
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleFullJvmFormalParameter"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3311:1: entryRuleFullJvmFormalParameter returns [EObject current=null] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3312:2: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3313:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter7834);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFullJvmFormalParameter7844); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFullJvmFormalParameter"


    // $ANTLR start "ruleFullJvmFormalParameter"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3320:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3323:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3324:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3324:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3324:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3324:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3325:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3325:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3326:3: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter7890);
            lv_parameterType_0_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"parameterType",
                      		lv_parameterType_0_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3342:2: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3343:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3343:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3344:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter7911);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ValidID");
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
    // $ANTLR end "ruleFullJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3368:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3369:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3370:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7947);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall7957); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFeatureCall"


    // $ANTLR start "ruleXFeatureCall"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3377:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_explicitOperationCall_8_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_3_0 = null;

        EObject lv_typeArguments_5_0 = null;

        EObject lv_featureCallArguments_9_0 = null;

        EObject lv_featureCallArguments_10_0 = null;

        EObject lv_featureCallArguments_12_0 = null;

        EObject lv_featureCallArguments_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3380:28: ( ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3381:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3381:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3381:2: () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3381:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3382:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3387:2: ( ( ruleStaticQualifier ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==64) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3388:1: ( ruleStaticQualifier )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3388:1: ( ruleStaticQualifier )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3389:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall8014);
                    ruleStaticQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3402:3: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==26) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3402:5: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleXFeatureCall8028); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3406:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3407:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3407:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3408:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8049);
                    lv_typeArguments_3_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_3_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3424:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==44) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3424:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,44,FOLLOW_44_in_ruleXFeatureCall8062); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3428:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3429:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3429:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3430:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8083);
                    	    lv_typeArguments_5_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_5_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,25,FOLLOW_25_in_ruleXFeatureCall8097); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3450:3: ( ( ruleIdOrSuper ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3451:1: ( ruleIdOrSuper )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3451:1: ( ruleIdOrSuper )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3452:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8122);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3465:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3465:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3465:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3465:4: ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3472:1: (lv_explicitOperationCall_8_0= '(' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3473:3: lv_explicitOperationCall_8_0= '('
                    {
                    lv_explicitOperationCall_8_0=(Token)match(input,45,FOLLOW_45_in_ruleXFeatureCall8156); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitOperationCall_8_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                             		setWithLastConsumed(current, "explicitOperationCall", true, "(");
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3486:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt59=3;
                    alt59 = dfa59.predict(input);
                    switch (alt59) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3486:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3486:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3486:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3503:1: (lv_featureCallArguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3504:3: lv_featureCallArguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8241);
                            lv_featureCallArguments_9_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_9_0, 
                                      		"XShortClosure");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3521:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3521:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3521:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3521:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3522:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3522:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3523:3: lv_featureCallArguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8269);
                            lv_featureCallArguments_10_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_10_0, 
                                      		"XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3539:2: (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            loop58:
                            do {
                                int alt58=2;
                                int LA58_0 = input.LA(1);

                                if ( (LA58_0==44) ) {
                                    alt58=1;
                                }


                                switch (alt58) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3539:4: otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,44,FOLLOW_44_in_ruleXFeatureCall8282); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXFeatureCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3543:1: ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3544:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3544:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3545:3: lv_featureCallArguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8303);
                            	    lv_featureCallArguments_12_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"featureCallArguments",
                            	              		lv_featureCallArguments_12_0, 
                            	              		"XExpression");
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


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,46,FOLLOW_46_in_ruleXFeatureCall8320); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3565:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3565:4: ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3568:1: (lv_featureCallArguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3569:3: lv_featureCallArguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXFeatureCall8355);
                    lv_featureCallArguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      	        }
                             		add(
                             			current, 
                             			"featureCallArguments",
                              		lv_featureCallArguments_14_0, 
                              		"XClosure");
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
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleIdOrSuper"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3593:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3594:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3595:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8393);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper8404); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdOrSuper"


    // $ANTLR start "ruleIdOrSuper"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3602:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3605:28: ( (this_ValidID_0= ruleValidID | kw= 'super' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3606:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3606:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_ID) ) {
                alt62=1;
            }
            else if ( (LA62_0==63) ) {
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3607:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleIdOrSuper8451);
                    this_ValidID_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ValidID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3619:2: kw= 'super'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleIdOrSuper8475); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrSuperAccess().getSuperKeyword_1()); 
                          
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
    // $ANTLR end "ruleIdOrSuper"


    // $ANTLR start "entryRuleStaticQualifier"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3632:1: entryRuleStaticQualifier returns [String current=null] : iv_ruleStaticQualifier= ruleStaticQualifier EOF ;
    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3633:2: (iv_ruleStaticQualifier= ruleStaticQualifier EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3634:2: iv_ruleStaticQualifier= ruleStaticQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStaticQualifierRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8516);
            iv_ruleStaticQualifier=ruleStaticQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier8527); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStaticQualifier"


    // $ANTLR start "ruleStaticQualifier"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3641:1: ruleStaticQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '::' )+ ;
    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3644:28: ( (this_ValidID_0= ruleValidID kw= '::' )+ )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3645:1: (this_ValidID_0= ruleValidID kw= '::' )+
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3645:1: (this_ValidID_0= ruleValidID kw= '::' )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_ID) ) {
                    int LA63_2 = input.LA(2);

                    if ( (LA63_2==64) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3646:5: this_ValidID_0= ruleValidID kw= '::'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStaticQualifierAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier8574);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,64,FOLLOW_64_in_ruleStaticQualifier8592); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getStaticQualifierAccess().getColonColonKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt63 >= 1 ) break loop63;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
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
    // $ANTLR end "ruleStaticQualifier"


    // $ANTLR start "entryRuleXConstructorCall"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3670:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3671:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3672:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8633);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall8643); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXConstructorCall"


    // $ANTLR start "ruleXConstructorCall"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3679:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_4_0 = null;

        EObject lv_typeArguments_6_0 = null;

        EObject lv_arguments_9_0 = null;

        EObject lv_arguments_10_0 = null;

        EObject lv_arguments_12_0 = null;

        EObject lv_arguments_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3682:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3683:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3683:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3683:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3683:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3684:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleXConstructorCall8689); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3693:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3694:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3694:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3695:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8712);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3708:2: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt65=2;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3708:3: ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3708:3: ( ( '<' )=>otherlv_3= '<' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3708:4: ( '<' )=>otherlv_3= '<'
                    {
                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleXConstructorCall8733); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3713:2: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3714:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3714:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3715:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8755);
                    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_4_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3731:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==44) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3731:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,44,FOLLOW_44_in_ruleXConstructorCall8768); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3735:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3736:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3736:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3737:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8789);
                    	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_6_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,25,FOLLOW_25_in_ruleXConstructorCall8803); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3757:3: ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt68=2;
            alt68 = dfa68.predict(input);
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3757:4: ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3757:4: ( ( '(' )=>otherlv_8= '(' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3757:5: ( '(' )=>otherlv_8= '('
                    {
                    otherlv_8=(Token)match(input,45,FOLLOW_45_in_ruleXConstructorCall8826); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3762:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt67=3;
                    alt67 = dfa67.predict(input);
                    switch (alt67) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3762:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3762:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3762:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3779:1: (lv_arguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3780:3: lv_arguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8899);
                            lv_arguments_9_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"arguments",
                                      		lv_arguments_9_0, 
                                      		"XShortClosure");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3797:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3797:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3797:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3797:7: ( (lv_arguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3798:1: (lv_arguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3798:1: (lv_arguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3799:3: lv_arguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8927);
                            lv_arguments_10_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"arguments",
                                      		lv_arguments_10_0, 
                                      		"XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3815:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            loop66:
                            do {
                                int alt66=2;
                                int LA66_0 = input.LA(1);

                                if ( (LA66_0==44) ) {
                                    alt66=1;
                                }


                                switch (alt66) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3815:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,44,FOLLOW_44_in_ruleXConstructorCall8940); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3819:1: ( (lv_arguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3820:1: (lv_arguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3820:1: (lv_arguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3821:3: lv_arguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8961);
                            	    lv_arguments_12_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"arguments",
                            	              		lv_arguments_12_0, 
                            	              		"XExpression");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop66;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,46,FOLLOW_46_in_ruleXConstructorCall8978); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3841:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt69=2;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3841:4: ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3844:1: (lv_arguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3845:3: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXConstructorCall9013);
                    lv_arguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_14_0, 
                              		"XClosure");
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
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3869:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3870:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3871:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9050);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral9060); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXBooleanLiteral"


    // $ANTLR start "ruleXBooleanLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3878:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3881:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3882:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3882:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3882:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3882:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3883:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3888:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==66) ) {
                alt70=1;
            }
            else if ( (LA70_0==67) ) {
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3888:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleXBooleanLiteral9107); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3893:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3893:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3894:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3894:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3895:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,67,FOLLOW_67_in_ruleXBooleanLiteral9131); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXBooleanLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "isTrue", true, "true");
                      	    
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
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3916:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3917:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3918:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9181);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral9191); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXNullLiteral"


    // $ANTLR start "ruleXNullLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3925:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3928:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3929:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3929:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3929:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3929:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3930:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleXNullLiteral9237); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXNullLiteralAccess().getNullKeyword_1());
                  
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
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXNumberLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3947:1: entryRuleXNumberLiteral returns [EObject current=null] : iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
    public final EObject entryRuleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNumberLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3948:2: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3949:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral9273);
            iv_ruleXNumberLiteral=ruleXNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNumberLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNumberLiteral9283); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXNumberLiteral"


    // $ANTLR start "ruleXNumberLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3956:1: ruleXNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final EObject ruleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3959:28: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3960:1: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3960:1: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3960:2: () ( (lv_value_1_0= ruleNumber ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3960:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3961:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3966:2: ( (lv_value_1_0= ruleNumber ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3967:1: (lv_value_1_0= ruleNumber )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3967:1: (lv_value_1_0= ruleNumber )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3968:3: lv_value_1_0= ruleNumber
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNumber_in_ruleXNumberLiteral9338);
            lv_value_1_0=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXNumberLiteralRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"Number");
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
    // $ANTLR end "ruleXNumberLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3992:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3993:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3994:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9374);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral9384); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXStringLiteral"


    // $ANTLR start "ruleXStringLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4001:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4004:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4005:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4005:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4005:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4005:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4006:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4011:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4012:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4012:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4013:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral9435); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXStringLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"STRING");
              	    
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
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4037:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4038:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4039:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9476);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral9486); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXTypeLiteral"


    // $ANTLR start "ruleXTypeLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4046:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_arrayDimensions_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4049:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4050:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4050:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4050:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4050:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4051:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,69,FOLLOW_69_in_ruleXTypeLiteral9532); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleXTypeLiteral9544); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4064:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4065:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4065:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4066:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9567);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4079:2: ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==47) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4080:1: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4080:1: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4081:3: lv_arrayDimensions_4_0= ruleArrayBrackets
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getArrayDimensionsArrayBracketsParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleArrayBrackets_in_ruleXTypeLiteral9588);
            	    lv_arrayDimensions_4_0=ruleArrayBrackets();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXTypeLiteralRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"arrayDimensions",
            	              		lv_arrayDimensions_4_0, 
            	              		"ArrayBrackets");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            otherlv_5=(Token)match(input,46,FOLLOW_46_in_ruleXTypeLiteral9601); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_5());
                  
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
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXThrowExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4109:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4110:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4111:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9637);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression9647); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXThrowExpression"


    // $ANTLR start "ruleXThrowExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4118:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4121:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4122:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4122:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4122:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4122:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4123:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,70,FOLLOW_70_in_ruleXThrowExpression9693); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4132:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4133:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4133:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4134:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression9714);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXThrowExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"XExpression");
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
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXReturnExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4158:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4159:2: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4160:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9750);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression9760); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXReturnExpression"


    // $ANTLR start "ruleXReturnExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4167:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4170:28: ( ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4171:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4171:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4171:2: () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4171:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4172:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,71,FOLLOW_71_in_ruleXReturnExpression9806); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4181:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt72=2;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4181:2: ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4186:1: (lv_expression_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4187:3: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXReturnExpression9837);
                    lv_expression_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXReturnExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_2_0, 
                              		"XExpression");
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
    // $ANTLR end "ruleXReturnExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4211:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4212:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4213:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9874);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9884); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXTryCatchFinallyExpression"


    // $ANTLR start "ruleXTryCatchFinallyExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4220:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
    public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_2_0 = null;

        EObject lv_catchClauses_3_0 = null;

        EObject lv_finallyExpression_5_0 = null;

        EObject lv_finallyExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4223:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4224:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4224:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4224:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4224:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4225:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,72,FOLLOW_72_in_ruleXTryCatchFinallyExpression9930); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4234:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4235:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4235:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4236:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9951);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4252:2: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==74) ) {
                alt75=1;
            }
            else if ( (LA75_0==73) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4252:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4252:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4252:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4252:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt73=0;
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==74) ) {
                            int LA73_2 = input.LA(2);

                            if ( (synpred34_InternalPureXbase()) ) {
                                alt73=1;
                            }


                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4252:5: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4254:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4255:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9981);
                    	    lv_catchClauses_3_0=ruleXCatchClause();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"catchClauses",
                    	              		lv_catchClauses_3_0, 
                    	              		"XCatchClause");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt73 >= 1 ) break loop73;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(73, input);
                                throw eee;
                        }
                        cnt73++;
                    } while (true);

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4271:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==73) ) {
                        int LA74_1 = input.LA(2);

                        if ( (synpred35_InternalPureXbase()) ) {
                            alt74=1;
                        }
                    }
                    switch (alt74) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4271:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4271:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4271:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,73,FOLLOW_73_in_ruleXTryCatchFinallyExpression10003); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4276:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4277:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4277:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4278:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10025);
                            lv_finallyExpression_5_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"finallyExpression",
                                      		lv_finallyExpression_5_0, 
                                      		"XExpression");
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4295:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4295:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4295:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,73,FOLLOW_73_in_ruleXTryCatchFinallyExpression10047); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4299:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4300:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4300:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4301:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10068);
                    lv_finallyExpression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"finallyExpression",
                              		lv_finallyExpression_7_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4325:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4326:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4327:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10106);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause10116); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCatchClause"


    // $ANTLR start "ruleXCatchClause"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4334:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4337:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4338:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4338:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4338:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4338:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4338:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_74_in_ruleXCatchClause10161); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleXCatchClause10174); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4347:1: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4348:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4348:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4349:3: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause10195);
            lv_declaredParam_2_0=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_2_0, 
                      		"FullJvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,46,FOLLOW_46_in_ruleXCatchClause10207); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4369:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4370:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4370:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4371:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause10228);
            lv_expression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_4_0, 
                      		"XExpression");
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
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4395:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4396:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4397:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10265);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10276); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4404:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4407:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4408:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4408:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4409:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10323);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4419:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==41) ) {
                    int LA76_2 = input.LA(2);

                    if ( (LA76_2==RULE_ID) ) {
                        int LA76_3 = input.LA(3);

                        if ( (synpred37_InternalPureXbase()) ) {
                            alt76=1;
                        }


                    }


                }


                switch (alt76) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4419:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4419:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4419:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,41,FOLLOW_41_in_ruleQualifiedName10351); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10374);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop76;
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNumber"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4446:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4450:2: (iv_ruleNumber= ruleNumber EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4451:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber10428);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber10439); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4461:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;
        Token this_INT_1=null;
        Token this_DECIMAL_2=null;
        Token kw=null;
        Token this_INT_4=null;
        Token this_DECIMAL_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4465:28: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4466:1: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4466:1: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_HEX) ) {
                alt80=1;
            }
            else if ( ((LA80_0>=RULE_INT && LA80_0<=RULE_DECIMAL)) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4466:6: this_HEX_0= RULE_HEX
                    {
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleNumber10483); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEX_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4474:6: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4474:6: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4474:7: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4474:7: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL )
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==RULE_INT) ) {
                        alt77=1;
                    }
                    else if ( (LA77_0==RULE_DECIMAL) ) {
                        alt77=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 77, 0, input);

                        throw nvae;
                    }
                    switch (alt77) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4474:12: this_INT_1= RULE_INT
                            {
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber10511); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_INT_1);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_INT_1, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4482:10: this_DECIMAL_2= RULE_DECIMAL
                            {
                            this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber10537); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_DECIMAL_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_DECIMAL_2, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1()); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4489:2: (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==41) ) {
                        int LA79_1 = input.LA(2);

                        if ( ((LA79_1>=RULE_INT && LA79_1<=RULE_DECIMAL)) ) {
                            alt79=1;
                        }
                    }
                    switch (alt79) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4490:2: kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            {
                            kw=(Token)match(input,41,FOLLOW_41_in_ruleNumber10557); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0()); 
                                  
                            }
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4495:1: (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            int alt78=2;
                            int LA78_0 = input.LA(1);

                            if ( (LA78_0==RULE_INT) ) {
                                alt78=1;
                            }
                            else if ( (LA78_0==RULE_DECIMAL) ) {
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
                                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4495:6: this_INT_4= RULE_INT
                                    {
                                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber10573); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      		current.merge(this_INT_4);
                                          
                                    }
                                    if ( state.backtracking==0 ) {
                                       
                                          newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_1_0()); 
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4503:10: this_DECIMAL_5= RULE_DECIMAL
                                    {
                                    this_DECIMAL_5=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber10599); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      		current.merge(this_DECIMAL_5);
                                          
                                    }
                                    if ( state.backtracking==0 ) {
                                       
                                          newLeafNode(this_DECIMAL_5, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1_1()); 
                                          
                                    }

                                    }
                                    break;

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4521:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4522:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4523:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10652);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference10662); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4530:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4533:28: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4534:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4534:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_ID) ) {
                alt82=1;
            }
            else if ( (LA82_0==29||LA82_0==45) ) {
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4534:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4534:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4535:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10710);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4543:1: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==47) ) {
                            int LA81_2 = input.LA(2);

                            if ( (LA81_2==49) ) {
                                int LA81_3 = input.LA(3);

                                if ( (synpred38_InternalPureXbase()) ) {
                                    alt81=1;
                                }


                            }


                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4543:2: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4544:24: ( () ruleArrayBrackets )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4544:25: () ruleArrayBrackets
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4544:25: ()
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4545:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	       
                    	              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1()); 
                    	          
                    	    }
                    	    pushFollow(FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference10746);
                    	    ruleArrayBrackets();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              afterParserOrEnumRuleCall();
                    	          
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop81;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4560:5: this_XFunctionTypeRef_3= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10777);
                    this_XFunctionTypeRef_3=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFunctionTypeRef_3; 
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
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleArrayBrackets"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4576:1: entryRuleArrayBrackets returns [String current=null] : iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
    public final String entryRuleArrayBrackets() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArrayBrackets = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4577:2: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4578:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayBracketsRule()); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets10813);
            iv_ruleArrayBrackets=ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayBrackets.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayBrackets10824); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayBrackets"


    // $ANTLR start "ruleArrayBrackets"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4585:1: ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleArrayBrackets() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4588:28: ( (kw= '[' kw= ']' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4589:1: (kw= '[' kw= ']' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4589:1: (kw= '[' kw= ']' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4590:2: kw= '[' kw= ']'
            {
            kw=(Token)match(input,47,FOLLOW_47_in_ruleArrayBrackets10862); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); 
                  
            }
            kw=(Token)match(input,49,FOLLOW_49_in_ruleArrayBrackets10875); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); 
                  
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
    // $ANTLR end "ruleArrayBrackets"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4609:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4610:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4611:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10915);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef10925); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4618:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4621:28: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4622:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4622:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4622:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4622:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==45) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4622:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleXFunctionTypeRef10963); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4626:1: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==RULE_ID||LA84_0==29||LA84_0==45) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4626:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4626:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4627:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4627:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4628:3: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10985);
                            lv_paramTypes_1_0=ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"paramTypes",
                                      		lv_paramTypes_1_0, 
                                      		"JvmTypeReference");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4644:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop83:
                            do {
                                int alt83=2;
                                int LA83_0 = input.LA(1);

                                if ( (LA83_0==44) ) {
                                    alt83=1;
                                }


                                switch (alt83) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4644:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXFunctionTypeRef10998); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4648:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4649:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4649:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4650:3: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11019);
                            	    lv_paramTypes_3_0=ruleJvmTypeReference();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"paramTypes",
                            	              		lv_paramTypes_3_0, 
                            	              		"JvmTypeReference");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
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
                            break;

                    }

                    otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleXFunctionTypeRef11035); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleXFunctionTypeRef11049); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4674:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4675:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4675:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4676:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11070);
            lv_returnType_6_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
              	        }
                     		set(
                     			current, 
                     			"returnType",
                      		lv_returnType_6_0, 
                      		"JvmTypeReference");
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
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4700:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4701:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4702:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11106);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11116); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4709:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4712:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4713:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4713:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4713:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4713:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4714:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4714:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4715:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11164);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4728:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt87=2;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4728:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4728:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4728:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleJvmParameterizedTypeReference11185); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4733:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4734:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4734:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4735:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11207);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_2_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4751:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==44) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4751:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleJvmParameterizedTypeReference11220); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4755:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4756:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4756:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4757:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11241);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_4_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop86;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleJvmParameterizedTypeReference11255); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
                          
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
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4785:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4786:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4787:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11293);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11303); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4794:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4797:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4798:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4798:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_ID||LA88_0==29||LA88_0==45) ) {
                alt88=1;
            }
            else if ( (LA88_0==75) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4799:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11350);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4809:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11377);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmWildcardTypeReference_1; 
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
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4825:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4826:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4827:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11412);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11422); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4834:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4837:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4838:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4838:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4838:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4838:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4839:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,75,FOLLOW_75_in_ruleJvmWildcardTypeReference11468); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4848:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt89=3;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==76) ) {
                alt89=1;
            }
            else if ( (LA89_0==63) ) {
                alt89=2;
            }
            switch (alt89) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4848:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4848:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4849:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4849:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4850:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11490);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_2_0, 
                              		"JvmUpperBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4867:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4867:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4868:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4868:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4869:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11517);
                    lv_constraints_3_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_3_0, 
                              		"JvmLowerBound");
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
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4893:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4894:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4895:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11555);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound11565); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4902:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4905:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4906:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4906:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4906:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,76,FOLLOW_76_in_ruleJvmUpperBound11602); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4910:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4911:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4911:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4912:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11623);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
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
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4936:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4937:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4938:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11659);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11669); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4945:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4948:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4949:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4949:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4949:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,77,FOLLOW_77_in_ruleJvmUpperBoundAnded11706); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4953:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4954:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4954:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4955:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11727);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
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
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4979:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4980:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4981:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11763);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound11773); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4988:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4991:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4992:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4992:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4992:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_63_in_ruleJvmLowerBound11810); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4996:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4997:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4997:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4998:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11831);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
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
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleValidID"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:5024:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:5025:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:5026:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID11870);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID11881); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:5033:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:5036:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:5037:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID11920); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleValidID"

    // $ANTLR start synpred1_InternalPureXbase
    public final void synpred1_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:4: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:4: ( () ( ( ruleOpMultiAssign ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:5: () ( ( ruleOpMultiAssign ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:356:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:356:2: ( ( ruleOpMultiAssign ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:357:1: ( ruleOpMultiAssign )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:357:1: ( ruleOpMultiAssign )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:358:3: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred1_InternalPureXbase782);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalPureXbase

    // $ANTLR start synpred2_InternalPureXbase
    public final void synpred2_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:4: ( () ( ( ruleOpOr ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:5: () ( ( ruleOpOr ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:484:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:484:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:485:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:485:1: ( ruleOpOr )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:486:3: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalPureXbase1130);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalPureXbase

    // $ANTLR start synpred3_InternalPureXbase
    public final void synpred3_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:5: () ( ( ruleOpAnd ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:585:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:585:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:586:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:586:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:587:3: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalPureXbase1389);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalPureXbase

    // $ANTLR start synpred4_InternalPureXbase
    public final void synpred4_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:5: () ( ( ruleOpEquality ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:686:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:686:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:687:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:687:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:688:3: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalPureXbase1648);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalPureXbase

    // $ANTLR start synpred5_InternalPureXbase
    public final void synpred5_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:4: ( ( () 'instanceof' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:5: ( () 'instanceof' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:5: ( () 'instanceof' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:6: () 'instanceof'
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:794:1: 
        {
        }

        match(input,22,FOLLOW_22_in_synpred5_InternalPureXbase1924); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalPureXbase

    // $ANTLR start synpred6_InternalPureXbase
    public final void synpred6_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:824:8: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:824:9: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:824:9: ( () ( ( ruleOpCompare ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:824:10: () ( ( ruleOpCompare ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:824:10: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:825:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:825:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:826:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:826:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:827:3: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred6_InternalPureXbase1995);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalPureXbase

    // $ANTLR start synpred7_InternalPureXbase
    public final void synpred7_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:946:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:946:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:946:4: ( () ( ( ruleOpOther ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:946:5: () ( ( ruleOpOther ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:946:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:947:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:947:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:948:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:948:1: ( ruleOpOther )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:949:3: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred7_InternalPureXbase2314);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalPureXbase

    // $ANTLR start synpred8_InternalPureXbase
    public final void synpred8_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1038:3: ( ( '>' '>' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1038:4: ( '>' '>' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1038:4: ( '>' '>' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1039:2: '>' '>'
        {
        match(input,25,FOLLOW_25_in_synpred8_InternalPureXbase2530); if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred8_InternalPureXbase2535); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalPureXbase

    // $ANTLR start synpred9_InternalPureXbase
    public final void synpred9_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1068:3: ( ( '<' '<' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1068:4: ( '<' '<' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1068:4: ( '<' '<' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1069:2: '<' '<'
        {
        match(input,26,FOLLOW_26_in_synpred9_InternalPureXbase2617); if (state.failed) return ;
        match(input,26,FOLLOW_26_in_synpred9_InternalPureXbase2622); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred9_InternalPureXbase

    // $ANTLR start synpred10_InternalPureXbase
    public final void synpred10_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1142:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1142:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1142:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1142:5: () ( ( ruleOpAdd ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1142:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1143:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1143:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1144:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1144:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1145:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred10_InternalPureXbase2844);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred10_InternalPureXbase

    // $ANTLR start synpred11_InternalPureXbase
    public final void synpred11_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1250:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1250:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1250:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1250:5: () ( ( ruleOpMulti ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1250:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1251:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1251:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1252:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1252:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1253:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred11_InternalPureXbase3124);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred11_InternalPureXbase

    // $ANTLR start synpred12_InternalPureXbase
    public final void synpred12_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1483:3: ( ( () 'as' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1483:4: ( () 'as' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1483:4: ( () 'as' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1483:5: () 'as'
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1483:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1484:1: 
        {
        }

        match(input,40,FOLLOW_40_in_synpred12_InternalPureXbase3718); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_InternalPureXbase

    // $ANTLR start synpred13_InternalPureXbase
    public final void synpred13_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1543:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1543:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1543:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1543:6: () '.' ( ( ruleValidID ) ) ruleOpSingleAssign
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1543:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1544:1: 
        {
        }

        match(input,41,FOLLOW_41_in_synpred13_InternalPureXbase3872); if (state.failed) return ;
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1545:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1546:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1546:1: ( ruleValidID )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1547:3: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred13_InternalPureXbase3881);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred13_InternalPureXbase3887);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalPureXbase

    // $ANTLR start synpred14_InternalPureXbase
    public final void synpred14_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1601:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1601:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1601:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1601:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1601:10: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1602:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1602:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt90=3;
        switch ( input.LA(1) ) {
        case 41:
            {
            alt90=1;
            }
            break;
        case 42:
            {
            alt90=2;
            }
            break;
        case 43:
            {
            alt90=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 90, 0, input);

            throw nvae;
        }

        switch (alt90) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1602:4: '.'
                {
                match(input,41,FOLLOW_41_in_synpred14_InternalPureXbase3990); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1604:6: ( ( '?.' ) )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1604:6: ( ( '?.' ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1605:1: ( '?.' )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1605:1: ( '?.' )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1606:2: '?.'
                {
                match(input,42,FOLLOW_42_in_synpred14_InternalPureXbase4004); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1611:6: ( ( '*.' ) )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1611:6: ( ( '*.' ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1612:1: ( '*.' )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1612:1: ( '*.' )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1613:2: '*.'
                {
                match(input,43,FOLLOW_43_in_synpred14_InternalPureXbase4024); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred14_InternalPureXbase

    // $ANTLR start synpred15_InternalPureXbase
    public final void synpred15_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1722:4: ( ( '(' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1723:1: ( '(' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1723:1: ( '(' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1724:2: '('
        {
        match(input,45,FOLLOW_45_in_synpred15_InternalPureXbase4251); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalPureXbase

    // $ANTLR start synpred16_InternalPureXbase
    public final void synpred16_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1743:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1743:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1743:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1743:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1743:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1744:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1744:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt92=2;
        int LA92_0 = input.LA(1);

        if ( (LA92_0==RULE_ID||LA92_0==29||LA92_0==45) ) {
            alt92=1;
        }
        switch (alt92) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1744:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1744:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1745:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1745:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1746:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalPureXbase4303);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1748:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop91:
                do {
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==44) ) {
                        alt91=1;
                    }


                    switch (alt91) {
                	case 1 :
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1748:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,44,FOLLOW_44_in_synpred16_InternalPureXbase4310); if (state.failed) return ;
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1749:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1750:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1750:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1751:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalPureXbase4317);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop91;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1753:6: ( ( '|' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1754:1: ( '|' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1754:1: ( '|' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1755:2: '|'
        {
        match(input,48,FOLLOW_48_in_synpred16_InternalPureXbase4331); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred16_InternalPureXbase

    // $ANTLR start synpred17_InternalPureXbase
    public final void synpred17_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1822:4: ( ( () '[' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1822:5: ( () '[' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1822:5: ( () '[' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1822:6: () '['
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1822:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1823:1: 
        {
        }

        match(input,47,FOLLOW_47_in_synpred17_InternalPureXbase4451); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred17_InternalPureXbase

    // $ANTLR start synpred18_InternalPureXbase
    public final void synpred18_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2013:3: ( ( () '[' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2013:4: ( () '[' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2013:4: ( () '[' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2013:5: () '['
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2013:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2014:1: 
        {
        }

        match(input,47,FOLLOW_47_in_synpred18_InternalPureXbase4975); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_InternalPureXbase

    // $ANTLR start synpred20_InternalPureXbase
    public final void synpred20_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2107:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2107:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2107:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2107:6: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2107:6: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt94=2;
        int LA94_0 = input.LA(1);

        if ( (LA94_0==RULE_ID||LA94_0==29||LA94_0==45) ) {
            alt94=1;
        }
        switch (alt94) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2107:7: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2107:7: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2108:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2108:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2109:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalPureXbase5254);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2111:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop93:
                do {
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==44) ) {
                        alt93=1;
                    }


                    switch (alt93) {
                	case 1 :
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2111:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,44,FOLLOW_44_in_synpred20_InternalPureXbase5261); if (state.failed) return ;
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2112:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2113:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2113:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2114:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalPureXbase5268);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop93;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2116:6: ( ( '|' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2117:1: ( '|' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2117:1: ( '|' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2118:2: '|'
        {
        match(input,48,FOLLOW_48_in_synpred20_InternalPureXbase5282); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred20_InternalPureXbase

    // $ANTLR start synpred22_InternalPureXbase
    public final void synpred22_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2477:4: ( 'else' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2477:6: 'else'
        {
        match(input,51,FOLLOW_51_in_synpred22_InternalPureXbase6065); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalPureXbase

    // $ANTLR start synpred23_InternalPureXbase
    public final void synpred23_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2531:4: ( ( ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2531:5: ( ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2531:5: ( ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2531:6: ( ( ruleValidID ) ) ':'
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2531:6: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2532:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2532:1: ( ruleValidID )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2533:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred23_InternalPureXbase6207);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,53,FOLLOW_53_in_synpred23_InternalPureXbase6213); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred23_InternalPureXbase

    // $ANTLR start synpred24_InternalPureXbase
    public final void synpred24_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2577:8: ( ( '(' ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2577:9: ( '(' ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2577:9: ( '(' ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2577:11: '(' ( ( ruleValidID ) ) ':'
        {
        match(input,45,FOLLOW_45_in_synpred24_InternalPureXbase6289); if (state.failed) return ;
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2578:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2579:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2579:1: ( ruleValidID )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2580:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred24_InternalPureXbase6296);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,53,FOLLOW_53_in_synpred24_InternalPureXbase6302); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred24_InternalPureXbase

    // $ANTLR start synpred25_InternalPureXbase
    public final void synpred25_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3161:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3161:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3161:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3161:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3161:6: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3162:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3162:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3163:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred25_InternalPureXbase7567);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3165:2: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3166:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3166:1: ( ruleValidID )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3167:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred25_InternalPureXbase7576);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred25_InternalPureXbase

    // $ANTLR start synpred26_InternalPureXbase
    public final void synpred26_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3465:4: ( ( '(' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3466:1: ( '(' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3466:1: ( '(' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3467:2: '('
        {
        match(input,45,FOLLOW_45_in_synpred26_InternalPureXbase8138); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred26_InternalPureXbase

    // $ANTLR start synpred27_InternalPureXbase
    public final void synpred27_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3486:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3486:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3486:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3486:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3486:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3487:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3487:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt98=2;
        int LA98_0 = input.LA(1);

        if ( (LA98_0==RULE_ID||LA98_0==29||LA98_0==45) ) {
            alt98=1;
        }
        switch (alt98) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3487:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3487:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3488:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3488:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3489:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalPureXbase8190);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3491:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop97:
                do {
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==44) ) {
                        alt97=1;
                    }


                    switch (alt97) {
                	case 1 :
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3491:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,44,FOLLOW_44_in_synpred27_InternalPureXbase8197); if (state.failed) return ;
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3492:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3493:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3493:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3494:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalPureXbase8204);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop97;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3496:6: ( ( '|' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3497:1: ( '|' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3497:1: ( '|' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3498:2: '|'
        {
        match(input,48,FOLLOW_48_in_synpred27_InternalPureXbase8218); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred27_InternalPureXbase

    // $ANTLR start synpred28_InternalPureXbase
    public final void synpred28_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3565:4: ( ( () '[' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3565:5: ( () '[' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3565:5: ( () '[' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3565:6: () '['
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3565:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3566:1: 
        {
        }

        match(input,47,FOLLOW_47_in_synpred28_InternalPureXbase8338); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred28_InternalPureXbase

    // $ANTLR start synpred29_InternalPureXbase
    public final void synpred29_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3708:4: ( '<' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3708:6: '<'
        {
        match(input,26,FOLLOW_26_in_synpred29_InternalPureXbase8725); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_InternalPureXbase

    // $ANTLR start synpred30_InternalPureXbase
    public final void synpred30_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3757:5: ( '(' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3757:7: '('
        {
        match(input,45,FOLLOW_45_in_synpred30_InternalPureXbase8818); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalPureXbase

    // $ANTLR start synpred31_InternalPureXbase
    public final void synpred31_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3762:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3762:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3762:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3762:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3762:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3763:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3763:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt100=2;
        int LA100_0 = input.LA(1);

        if ( (LA100_0==RULE_ID||LA100_0==29||LA100_0==45) ) {
            alt100=1;
        }
        switch (alt100) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3763:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3763:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3764:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3764:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3765:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred31_InternalPureXbase8848);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3767:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop99:
                do {
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==44) ) {
                        alt99=1;
                    }


                    switch (alt99) {
                	case 1 :
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3767:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,44,FOLLOW_44_in_synpred31_InternalPureXbase8855); if (state.failed) return ;
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3768:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3769:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3769:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3770:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred31_InternalPureXbase8862);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop99;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3772:6: ( ( '|' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3773:1: ( '|' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3773:1: ( '|' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3774:2: '|'
        {
        match(input,48,FOLLOW_48_in_synpred31_InternalPureXbase8876); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred31_InternalPureXbase

    // $ANTLR start synpred32_InternalPureXbase
    public final void synpred32_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3841:4: ( ( () '[' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3841:5: ( () '[' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3841:5: ( () '[' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3841:6: () '['
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3841:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3842:1: 
        {
        }

        match(input,47,FOLLOW_47_in_synpred32_InternalPureXbase8996); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred32_InternalPureXbase

    // $ANTLR start synpred33_InternalPureXbase
    public final void synpred33_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4181:2: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4182:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4182:1: ( ruleXExpression )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4183:1: ruleXExpression
        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred33_InternalPureXbase9820);
        ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred33_InternalPureXbase

    // $ANTLR start synpred34_InternalPureXbase
    public final void synpred34_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4252:5: ( 'catch' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4252:7: 'catch'
        {
        match(input,74,FOLLOW_74_in_synpred34_InternalPureXbase9965); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalPureXbase

    // $ANTLR start synpred35_InternalPureXbase
    public final void synpred35_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4271:5: ( 'finally' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4271:7: 'finally'
        {
        match(input,73,FOLLOW_73_in_synpred35_InternalPureXbase9995); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalPureXbase

    // $ANTLR start synpred37_InternalPureXbase
    public final void synpred37_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4419:3: ( '.' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4420:2: '.'
        {
        match(input,41,FOLLOW_41_in_synpred37_InternalPureXbase10342); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_InternalPureXbase

    // $ANTLR start synpred38_InternalPureXbase
    public final void synpred38_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4543:2: ( ( () ruleArrayBrackets ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4543:3: ( () ruleArrayBrackets )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4543:3: ( () ruleArrayBrackets )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4543:4: () ruleArrayBrackets
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4543:4: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4544:1: 
        {
        }

        pushFollow(FOLLOW_ruleArrayBrackets_in_synpred38_InternalPureXbase10725);
        ruleArrayBrackets();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred38_InternalPureXbase

    // $ANTLR start synpred39_InternalPureXbase
    public final void synpred39_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4728:4: ( '<' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4728:6: '<'
        {
        match(input,26,FOLLOW_26_in_synpred39_InternalPureXbase11177); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalPureXbase

    // Delegated rules

    public final boolean synpred39_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA72 dfa72 = new DFA72(this);
    protected DFA87 dfa87 = new DFA87(this);
    static final String DFA13_eotS =
        "\13\uffff";
    static final String DFA13_eofS =
        "\1\1\12\uffff";
    static final String DFA13_minS =
        "\1\4\1\uffff\10\0\1\uffff";
    static final String DFA13_maxS =
        "\1\112\1\uffff\10\0\1\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\2\10\uffff\1\1";
    static final String DFA13_specialS =
        "\2\uffff\1\3\1\0\1\4\1\5\1\2\1\1\1\6\1\7\1\uffff}>";
    static final String[] DFA13_transitionS = {
            "\5\1\4\uffff\2\1\2\uffff\10\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
            "\11\17\1\1\uffff\17\1\1\uffff\12\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "()* loopback of 946:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_3 = input.LA(1);

                         
                        int index13_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_7 = input.LA(1);

                         
                        int index13_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_6 = input.LA(1);

                         
                        int index13_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA13_2 = input.LA(1);

                         
                        int index13_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_2);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA13_4 = input.LA(1);

                         
                        int index13_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA13_5 = input.LA(1);

                         
                        int index13_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA13_8 = input.LA(1);

                         
                        int index13_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA13_9 = input.LA(1);

                         
                        int index13_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA29_eotS =
        "\102\uffff";
    static final String DFA29_eofS =
        "\1\2\101\uffff";
    static final String DFA29_minS =
        "\1\4\1\0\100\uffff";
    static final String DFA29_maxS =
        "\1\112\1\0\100\uffff";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\76\uffff\1\1";
    static final String DFA29_specialS =
        "\1\uffff\1\0\100\uffff}>";
    static final String[] DFA29_transitionS = {
            "\5\2\4\uffff\2\2\2\uffff\34\2\1\1\2\2\1\uffff\17\2\1\uffff\12"+
            "\2",
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
            return "1722:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_1 = input.LA(1);

                         
                        int index29_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index29_1);
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
    static final String DFA28_eotS =
        "\36\uffff";
    static final String DFA28_eofS =
        "\36\uffff";
    static final String DFA28_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA28_maxS =
        "\1\110\2\0\33\uffff";
    static final String DFA28_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA28_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA28_transitionS = {
            "\4\5\1\1\21\uffff\1\5\2\uffff\1\3\3\uffff\2\5\4\uffff\1\5\5"+
            "\uffff\1\2\1\35\1\5\1\4\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5"+
            "\3\uffff\3\5\2\uffff\1\5\1\uffff\10\5",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1743:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_0 = input.LA(1);

                         
                        int index28_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA28_0==RULE_ID) ) {s = 1;}

                        else if ( (LA28_0==45) ) {s = 2;}

                        else if ( (LA28_0==29) && (synpred16_InternalPureXbase())) {s = 3;}

                        else if ( (LA28_0==48) && (synpred16_InternalPureXbase())) {s = 4;}

                        else if ( ((LA28_0>=RULE_STRING && LA28_0<=RULE_DECIMAL)||LA28_0==26||(LA28_0>=33 && LA28_0<=34)||LA28_0==39||LA28_0==47||LA28_0==50||LA28_0==52||LA28_0==54||(LA28_0>=58 && LA28_0<=60)||LA28_0==63||(LA28_0>=65 && LA28_0<=72)) ) {s = 5;}

                        else if ( (LA28_0==46) ) {s = 29;}

                         
                        input.seek(index28_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_1 = input.LA(1);

                         
                        int index28_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index28_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA28_2 = input.LA(1);

                         
                        int index28_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index28_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA30_eotS =
        "\102\uffff";
    static final String DFA30_eofS =
        "\1\2\101\uffff";
    static final String DFA30_minS =
        "\1\4\1\0\100\uffff";
    static final String DFA30_maxS =
        "\1\112\1\0\100\uffff";
    static final String DFA30_acceptS =
        "\2\uffff\1\2\76\uffff\1\1";
    static final String DFA30_specialS =
        "\1\uffff\1\0\100\uffff}>";
    static final String[] DFA30_transitionS = {
            "\5\2\4\uffff\2\2\2\uffff\36\2\1\1\1\uffff\17\2\1\uffff\12\2",
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
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "1822:3: ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_1 = input.LA(1);

                         
                        int index30_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index30_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA32_eotS =
        "\16\uffff";
    static final String DFA32_eofS =
        "\16\uffff";
    static final String DFA32_minS =
        "\1\4\15\uffff";
    static final String DFA32_maxS =
        "\1\110\15\uffff";
    static final String DFA32_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15";
    static final String DFA32_specialS =
        "\16\uffff}>";
    static final String[] DFA32_transitionS = {
            "\4\5\1\4\21\uffff\1\4\22\uffff\1\15\1\uffff\1\5\2\uffff\1\6"+
            "\1\uffff\1\3\1\uffff\1\2\3\uffff\1\7\1\10\1\11\2\uffff\1\4\1"+
            "\uffff\1\1\4\5\1\12\1\13\1\14",
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

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "1863:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )";
        }
    }
    static final String DFA36_eotS =
        "\40\uffff";
    static final String DFA36_eofS =
        "\40\uffff";
    static final String DFA36_minS =
        "\1\4\2\0\35\uffff";
    static final String DFA36_maxS =
        "\1\110\2\0\35\uffff";
    static final String DFA36_acceptS =
        "\3\uffff\2\1\1\2\32\uffff";
    static final String DFA36_specialS =
        "\1\0\1\1\1\2\35\uffff}>";
    static final String[] DFA36_transitionS = {
            "\4\5\1\1\21\uffff\1\5\2\uffff\1\3\3\uffff\2\5\4\uffff\1\5\5"+
            "\uffff\1\2\1\uffff\1\5\1\4\2\5\1\uffff\1\5\1\uffff\1\5\3\uffff"+
            "\6\5\1\uffff\10\5",
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

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "2107:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_0 = input.LA(1);

                         
                        int index36_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA36_0==RULE_ID) ) {s = 1;}

                        else if ( (LA36_0==45) ) {s = 2;}

                        else if ( (LA36_0==29) && (synpred20_InternalPureXbase())) {s = 3;}

                        else if ( (LA36_0==48) && (synpred20_InternalPureXbase())) {s = 4;}

                        else if ( ((LA36_0>=RULE_STRING && LA36_0<=RULE_DECIMAL)||LA36_0==26||(LA36_0>=33 && LA36_0<=34)||LA36_0==39||LA36_0==47||(LA36_0>=49 && LA36_0<=50)||LA36_0==52||LA36_0==54||(LA36_0>=58 && LA36_0<=63)||(LA36_0>=65 && LA36_0<=72)) ) {s = 5;}

                         
                        input.seek(index36_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_1 = input.LA(1);

                         
                        int index36_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index36_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA36_2 = input.LA(1);

                         
                        int index36_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index36_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA60_eotS =
        "\102\uffff";
    static final String DFA60_eofS =
        "\1\2\101\uffff";
    static final String DFA60_minS =
        "\1\4\1\0\100\uffff";
    static final String DFA60_maxS =
        "\1\112\1\0\100\uffff";
    static final String DFA60_acceptS =
        "\2\uffff\1\2\76\uffff\1\1";
    static final String DFA60_specialS =
        "\1\uffff\1\0\100\uffff}>";
    static final String[] DFA60_transitionS = {
            "\5\2\4\uffff\2\2\2\uffff\34\2\1\1\2\2\1\uffff\17\2\1\uffff\12"+
            "\2",
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
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA60_eot = DFA.unpackEncodedString(DFA60_eotS);
    static final short[] DFA60_eof = DFA.unpackEncodedString(DFA60_eofS);
    static final char[] DFA60_min = DFA.unpackEncodedStringToUnsignedChars(DFA60_minS);
    static final char[] DFA60_max = DFA.unpackEncodedStringToUnsignedChars(DFA60_maxS);
    static final short[] DFA60_accept = DFA.unpackEncodedString(DFA60_acceptS);
    static final short[] DFA60_special = DFA.unpackEncodedString(DFA60_specialS);
    static final short[][] DFA60_transition;

    static {
        int numStates = DFA60_transitionS.length;
        DFA60_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA60_transition[i] = DFA.unpackEncodedString(DFA60_transitionS[i]);
        }
    }

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = DFA60_eot;
            this.eof = DFA60_eof;
            this.min = DFA60_min;
            this.max = DFA60_max;
            this.accept = DFA60_accept;
            this.special = DFA60_special;
            this.transition = DFA60_transition;
        }
        public String getDescription() {
            return "3465:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_1 = input.LA(1);

                         
                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 60, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA59_eotS =
        "\36\uffff";
    static final String DFA59_eofS =
        "\36\uffff";
    static final String DFA59_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA59_maxS =
        "\1\110\2\0\33\uffff";
    static final String DFA59_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA59_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA59_transitionS = {
            "\4\5\1\1\21\uffff\1\5\2\uffff\1\3\3\uffff\2\5\4\uffff\1\5\5"+
            "\uffff\1\2\1\35\1\5\1\4\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5"+
            "\3\uffff\3\5\2\uffff\1\5\1\uffff\10\5",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA59_eot = DFA.unpackEncodedString(DFA59_eotS);
    static final short[] DFA59_eof = DFA.unpackEncodedString(DFA59_eofS);
    static final char[] DFA59_min = DFA.unpackEncodedStringToUnsignedChars(DFA59_minS);
    static final char[] DFA59_max = DFA.unpackEncodedStringToUnsignedChars(DFA59_maxS);
    static final short[] DFA59_accept = DFA.unpackEncodedString(DFA59_acceptS);
    static final short[] DFA59_special = DFA.unpackEncodedString(DFA59_specialS);
    static final short[][] DFA59_transition;

    static {
        int numStates = DFA59_transitionS.length;
        DFA59_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA59_transition[i] = DFA.unpackEncodedString(DFA59_transitionS[i]);
        }
    }

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = DFA59_eot;
            this.eof = DFA59_eof;
            this.min = DFA59_min;
            this.max = DFA59_max;
            this.accept = DFA59_accept;
            this.special = DFA59_special;
            this.transition = DFA59_transition;
        }
        public String getDescription() {
            return "3486:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_0 = input.LA(1);

                         
                        int index59_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA59_0==RULE_ID) ) {s = 1;}

                        else if ( (LA59_0==45) ) {s = 2;}

                        else if ( (LA59_0==29) && (synpred27_InternalPureXbase())) {s = 3;}

                        else if ( (LA59_0==48) && (synpred27_InternalPureXbase())) {s = 4;}

                        else if ( ((LA59_0>=RULE_STRING && LA59_0<=RULE_DECIMAL)||LA59_0==26||(LA59_0>=33 && LA59_0<=34)||LA59_0==39||LA59_0==47||LA59_0==50||LA59_0==52||LA59_0==54||(LA59_0>=58 && LA59_0<=60)||LA59_0==63||(LA59_0>=65 && LA59_0<=72)) ) {s = 5;}

                        else if ( (LA59_0==46) ) {s = 29;}

                         
                        input.seek(index59_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA59_1 = input.LA(1);

                         
                        int index59_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index59_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA59_2 = input.LA(1);

                         
                        int index59_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index59_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 59, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA61_eotS =
        "\102\uffff";
    static final String DFA61_eofS =
        "\1\2\101\uffff";
    static final String DFA61_minS =
        "\1\4\1\0\100\uffff";
    static final String DFA61_maxS =
        "\1\112\1\0\100\uffff";
    static final String DFA61_acceptS =
        "\2\uffff\1\2\76\uffff\1\1";
    static final String DFA61_specialS =
        "\1\uffff\1\0\100\uffff}>";
    static final String[] DFA61_transitionS = {
            "\5\2\4\uffff\2\2\2\uffff\36\2\1\1\1\uffff\17\2\1\uffff\12\2",
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
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "3565:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_1 = input.LA(1);

                         
                        int index61_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA65_eotS =
        "\102\uffff";
    static final String DFA65_eofS =
        "\1\2\101\uffff";
    static final String DFA65_minS =
        "\1\4\1\0\100\uffff";
    static final String DFA65_maxS =
        "\1\112\1\0\100\uffff";
    static final String DFA65_acceptS =
        "\2\uffff\1\2\76\uffff\1\1";
    static final String DFA65_specialS =
        "\1\uffff\1\0\100\uffff}>";
    static final String[] DFA65_transitionS = {
            "\5\2\4\uffff\2\2\2\uffff\11\2\1\1\25\2\1\uffff\17\2\1\uffff"+
            "\12\2",
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
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "3708:2: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_1 = input.LA(1);

                         
                        int index65_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index65_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 65, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA68_eotS =
        "\102\uffff";
    static final String DFA68_eofS =
        "\1\2\101\uffff";
    static final String DFA68_minS =
        "\1\4\1\0\100\uffff";
    static final String DFA68_maxS =
        "\1\112\1\0\100\uffff";
    static final String DFA68_acceptS =
        "\2\uffff\1\2\76\uffff\1\1";
    static final String DFA68_specialS =
        "\1\uffff\1\0\100\uffff}>";
    static final String[] DFA68_transitionS = {
            "\5\2\4\uffff\2\2\2\uffff\34\2\1\1\2\2\1\uffff\17\2\1\uffff\12"+
            "\2",
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
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA68_eot = DFA.unpackEncodedString(DFA68_eotS);
    static final short[] DFA68_eof = DFA.unpackEncodedString(DFA68_eofS);
    static final char[] DFA68_min = DFA.unpackEncodedStringToUnsignedChars(DFA68_minS);
    static final char[] DFA68_max = DFA.unpackEncodedStringToUnsignedChars(DFA68_maxS);
    static final short[] DFA68_accept = DFA.unpackEncodedString(DFA68_acceptS);
    static final short[] DFA68_special = DFA.unpackEncodedString(DFA68_specialS);
    static final short[][] DFA68_transition;

    static {
        int numStates = DFA68_transitionS.length;
        DFA68_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA68_transition[i] = DFA.unpackEncodedString(DFA68_transitionS[i]);
        }
    }

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = DFA68_eot;
            this.eof = DFA68_eof;
            this.min = DFA68_min;
            this.max = DFA68_max;
            this.accept = DFA68_accept;
            this.special = DFA68_special;
            this.transition = DFA68_transition;
        }
        public String getDescription() {
            return "3757:3: ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA68_1 = input.LA(1);

                         
                        int index68_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index68_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 68, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA67_eotS =
        "\36\uffff";
    static final String DFA67_eofS =
        "\36\uffff";
    static final String DFA67_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA67_maxS =
        "\1\110\2\0\33\uffff";
    static final String DFA67_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA67_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA67_transitionS = {
            "\4\5\1\1\21\uffff\1\5\2\uffff\1\3\3\uffff\2\5\4\uffff\1\5\5"+
            "\uffff\1\2\1\35\1\5\1\4\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5"+
            "\3\uffff\3\5\2\uffff\1\5\1\uffff\10\5",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
    static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
    static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
    static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
    static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
    static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
    static final short[][] DFA67_transition;

    static {
        int numStates = DFA67_transitionS.length;
        DFA67_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = DFA67_eot;
            this.eof = DFA67_eof;
            this.min = DFA67_min;
            this.max = DFA67_max;
            this.accept = DFA67_accept;
            this.special = DFA67_special;
            this.transition = DFA67_transition;
        }
        public String getDescription() {
            return "3762:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_0 = input.LA(1);

                         
                        int index67_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA67_0==RULE_ID) ) {s = 1;}

                        else if ( (LA67_0==45) ) {s = 2;}

                        else if ( (LA67_0==29) && (synpred31_InternalPureXbase())) {s = 3;}

                        else if ( (LA67_0==48) && (synpred31_InternalPureXbase())) {s = 4;}

                        else if ( ((LA67_0>=RULE_STRING && LA67_0<=RULE_DECIMAL)||LA67_0==26||(LA67_0>=33 && LA67_0<=34)||LA67_0==39||LA67_0==47||LA67_0==50||LA67_0==52||LA67_0==54||(LA67_0>=58 && LA67_0<=60)||LA67_0==63||(LA67_0>=65 && LA67_0<=72)) ) {s = 5;}

                        else if ( (LA67_0==46) ) {s = 29;}

                         
                        input.seek(index67_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA67_1 = input.LA(1);

                         
                        int index67_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index67_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA67_2 = input.LA(1);

                         
                        int index67_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index67_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 67, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA69_eotS =
        "\102\uffff";
    static final String DFA69_eofS =
        "\1\2\101\uffff";
    static final String DFA69_minS =
        "\1\4\1\0\100\uffff";
    static final String DFA69_maxS =
        "\1\112\1\0\100\uffff";
    static final String DFA69_acceptS =
        "\2\uffff\1\2\76\uffff\1\1";
    static final String DFA69_specialS =
        "\1\uffff\1\0\100\uffff}>";
    static final String[] DFA69_transitionS = {
            "\5\2\4\uffff\2\2\2\uffff\36\2\1\1\1\uffff\17\2\1\uffff\12\2",
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
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA69_eot = DFA.unpackEncodedString(DFA69_eotS);
    static final short[] DFA69_eof = DFA.unpackEncodedString(DFA69_eofS);
    static final char[] DFA69_min = DFA.unpackEncodedStringToUnsignedChars(DFA69_minS);
    static final char[] DFA69_max = DFA.unpackEncodedStringToUnsignedChars(DFA69_maxS);
    static final short[] DFA69_accept = DFA.unpackEncodedString(DFA69_acceptS);
    static final short[] DFA69_special = DFA.unpackEncodedString(DFA69_specialS);
    static final short[][] DFA69_transition;

    static {
        int numStates = DFA69_transitionS.length;
        DFA69_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA69_transition[i] = DFA.unpackEncodedString(DFA69_transitionS[i]);
        }
    }

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = DFA69_eot;
            this.eof = DFA69_eof;
            this.min = DFA69_min;
            this.max = DFA69_max;
            this.accept = DFA69_accept;
            this.special = DFA69_special;
            this.transition = DFA69_transition;
        }
        public String getDescription() {
            return "3841:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA69_1 = input.LA(1);

                         
                        int index69_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index69_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 69, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA72_eotS =
        "\102\uffff";
    static final String DFA72_eofS =
        "\1\33\101\uffff";
    static final String DFA72_minS =
        "\1\4\32\0\47\uffff";
    static final String DFA72_maxS =
        "\1\112\32\0\47\uffff";
    static final String DFA72_acceptS =
        "\33\uffff\1\2\45\uffff\1\1";
    static final String DFA72_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\47\uffff}>";
    static final String[] DFA72_transitionS = {
            "\1\21\1\15\1\16\1\17\1\1\4\uffff\2\33\2\uffff\11\33\1\10\6\33"+
            "\1\4\1\3\4\33\1\2\5\33\1\32\1\33\1\12\1\uffff\1\33\1\23\1\33"+
            "\1\7\1\33\1\6\3\33\1\24\1\25\1\26\2\33\1\11\1\uffff\1\5\1\13"+
            "\1\14\1\20\1\22\1\27\1\30\1\31\2\33",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA72_eot = DFA.unpackEncodedString(DFA72_eotS);
    static final short[] DFA72_eof = DFA.unpackEncodedString(DFA72_eofS);
    static final char[] DFA72_min = DFA.unpackEncodedStringToUnsignedChars(DFA72_minS);
    static final char[] DFA72_max = DFA.unpackEncodedStringToUnsignedChars(DFA72_maxS);
    static final short[] DFA72_accept = DFA.unpackEncodedString(DFA72_acceptS);
    static final short[] DFA72_special = DFA.unpackEncodedString(DFA72_specialS);
    static final short[][] DFA72_transition;

    static {
        int numStates = DFA72_transitionS.length;
        DFA72_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA72_transition[i] = DFA.unpackEncodedString(DFA72_transitionS[i]);
        }
    }

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = DFA72_eot;
            this.eof = DFA72_eof;
            this.min = DFA72_min;
            this.max = DFA72_max;
            this.accept = DFA72_accept;
            this.special = DFA72_special;
            this.transition = DFA72_transition;
        }
        public String getDescription() {
            return "4181:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA72_1 = input.LA(1);

                         
                        int index72_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA72_2 = input.LA(1);

                         
                        int index72_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA72_3 = input.LA(1);

                         
                        int index72_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA72_4 = input.LA(1);

                         
                        int index72_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA72_5 = input.LA(1);

                         
                        int index72_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA72_6 = input.LA(1);

                         
                        int index72_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA72_7 = input.LA(1);

                         
                        int index72_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA72_8 = input.LA(1);

                         
                        int index72_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA72_9 = input.LA(1);

                         
                        int index72_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA72_10 = input.LA(1);

                         
                        int index72_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA72_11 = input.LA(1);

                         
                        int index72_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA72_12 = input.LA(1);

                         
                        int index72_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA72_13 = input.LA(1);

                         
                        int index72_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA72_14 = input.LA(1);

                         
                        int index72_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA72_15 = input.LA(1);

                         
                        int index72_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA72_16 = input.LA(1);

                         
                        int index72_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA72_17 = input.LA(1);

                         
                        int index72_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA72_18 = input.LA(1);

                         
                        int index72_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA72_19 = input.LA(1);

                         
                        int index72_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA72_20 = input.LA(1);

                         
                        int index72_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA72_21 = input.LA(1);

                         
                        int index72_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA72_22 = input.LA(1);

                         
                        int index72_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA72_23 = input.LA(1);

                         
                        int index72_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA72_24 = input.LA(1);

                         
                        int index72_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA72_25 = input.LA(1);

                         
                        int index72_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA72_26 = input.LA(1);

                         
                        int index72_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 72, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA87_eotS =
        "\102\uffff";
    static final String DFA87_eofS =
        "\1\2\101\uffff";
    static final String DFA87_minS =
        "\1\4\1\0\100\uffff";
    static final String DFA87_maxS =
        "\1\112\1\0\100\uffff";
    static final String DFA87_acceptS =
        "\2\uffff\1\2\76\uffff\1\1";
    static final String DFA87_specialS =
        "\1\uffff\1\0\100\uffff}>";
    static final String[] DFA87_transitionS = {
            "\5\2\4\uffff\2\2\2\uffff\11\2\1\1\25\2\1\uffff\17\2\1\uffff"+
            "\12\2",
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
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA87_eot = DFA.unpackEncodedString(DFA87_eotS);
    static final short[] DFA87_eof = DFA.unpackEncodedString(DFA87_eofS);
    static final char[] DFA87_min = DFA.unpackEncodedStringToUnsignedChars(DFA87_minS);
    static final char[] DFA87_max = DFA.unpackEncodedStringToUnsignedChars(DFA87_maxS);
    static final short[] DFA87_accept = DFA.unpackEncodedString(DFA87_acceptS);
    static final short[] DFA87_special = DFA.unpackEncodedString(DFA87_specialS);
    static final short[][] DFA87_transition;

    static {
        int numStates = DFA87_transitionS.length;
        DFA87_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA87_transition[i] = DFA.unpackEncodedString(DFA87_transitionS[i]);
        }
    }

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = DFA87_eot;
            this.eof = DFA87_eof;
            this.min = DFA87_min;
            this.max = DFA87_max;
            this.accept = DFA87_accept;
            this.special = DFA87_special;
            this.transition = DFA87_transition;
        }
        public String getDescription() {
            return "4728:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA87_1 = input.LA(1);

                         
                        int index87_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalPureXbase()) ) {s = 65;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index87_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 87, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialBlockExpression_in_ruleModel130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialBlockExpression_in_entryRuleSpecialBlockExpression165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecialBlockExpression175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleSpecialBlockExpression232 = new BitSet(new long[]{0xFC54A086040061F2L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleImport_in_ruleSpecialBlockExpression259 = new BitSet(new long[]{0xFC54A086040061F2L,0x00000000000001FEL});
    public static final BitSet FOLLOW_13_in_ruleSpecialBlockExpression273 = new BitSet(new long[]{0xFC54A086040061F2L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleImport360 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard476 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleQualifiedNameWithWildCard495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAssignment695 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment711 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment761 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment814 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleOpSingleAssign925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleOpMultiAssign1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1052 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1109 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression1162 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1185 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr1224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleOpOr1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1368 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression1421 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1444 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd1483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleOpAnd1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression1570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1627 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1680 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1703 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality1742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOpEquality1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOpEquality1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression1850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1907 = new BitSet(new long[]{0x0000000007C00002L});
    public static final BitSet FOLLOW_22_in_ruleXRelationalExpression1943 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression1966 = new BitSet(new long[]{0x0000000007C00002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2027 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2050 = new BitSet(new long[]{0x0000000007C00002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare2090 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare2101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpCompare2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpCompare2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpCompare2177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpCompare2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2236 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2293 = new BitSet(new long[]{0x00000001FE000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2346 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2369 = new BitSet(new long[]{0x00000001FE000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther2408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther2419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpOther2457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpOther2476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpOther2495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpOther2515 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleOpOther2546 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleOpOther2559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpOther2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpOther2602 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleOpOther2633 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleOpOther2646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpOther2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther2688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpOther2707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpOther2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression2776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2823 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression2876 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2899 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd2938 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd2949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpAdd2987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpAdd3006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3046 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3103 = new BitSet(new long[]{0x0000007800000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3156 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3179 = new BitSet(new long[]{0x0000007800000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti3218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti3229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpMulti3267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpMulti3286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpMulti3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpMulti3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3432 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXUnaryOperation3453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary3518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpUnary3567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpUnary3586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpUnary3605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3645 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression3655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3702 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleXCastedExpression3737 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3760 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3798 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall3808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall3855 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_41_in_ruleXMemberFeatureCall3904 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3927 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall3943 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall3965 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_41_in_ruleXMemberFeatureCall4051 = new BitSet(new long[]{0x0000000004000100L});
    public static final BitSet FOLLOW_42_in_ruleXMemberFeatureCall4075 = new BitSet(new long[]{0x0000000004000100L});
    public static final BitSet FOLLOW_43_in_ruleXMemberFeatureCall4112 = new BitSet(new long[]{0x0000000004000100L});
    public static final BitSet FOLLOW_26_in_ruleXMemberFeatureCall4141 = new BitSet(new long[]{0x0000200020000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4162 = new BitSet(new long[]{0x0000100002000000L});
    public static final BitSet FOLLOW_44_in_ruleXMemberFeatureCall4175 = new BitSet(new long[]{0x0000200020000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4196 = new BitSet(new long[]{0x0000100002000000L});
    public static final BitSet FOLLOW_25_in_ruleXMemberFeatureCall4210 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4235 = new BitSet(new long[]{0x0000AE0000000002L});
    public static final BitSet FOLLOW_45_in_ruleXMemberFeatureCall4269 = new BitSet(new long[]{0xFC55E086240001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4354 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4382 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_44_in_ruleXMemberFeatureCall4395 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4416 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_46_in_ruleXMemberFeatureCall4433 = new BitSet(new long[]{0x00008E0000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4468 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression4518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression4646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression4673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression4727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression4835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral4924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral4934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral4994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_ruleXLiteral5049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral5076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral5103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure5165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure5175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleXClosure5235 = new BitSet(new long[]{0xFC57A086240001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5308 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXClosure5321 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5342 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_ruleXClosure5364 = new BitSet(new long[]{0xFC56A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5401 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleXClosure5413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5449 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInClosure5459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5515 = new BitSet(new long[]{0xFC54A086040021F2L,0x00000000000001FEL});
    public static final BitSet FOLLOW_13_in_ruleXExpressionInClosure5528 = new BitSet(new long[]{0xFC54A086040001F2L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure5578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5686 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXShortClosure5699 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5720 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_ruleXShortClosure5742 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure5778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5814 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression5824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleXParenthesizedExpression5861 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5883 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXParenthesizedExpression5894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5930 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression5940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleXIfExpression5986 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleXIfExpression5998 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6019 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXIfExpression6031 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6052 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_ruleXIfExpression6073 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6133 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression6143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXSwitchExpression6189 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression6232 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleXSwitchExpression6244 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6268 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_45_in_ruleXSwitchExpression6312 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression6333 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleXSwitchExpression6345 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6368 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXSwitchExpression6380 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleXSwitchExpression6394 = new BitSet(new long[]{0x0220200020000100L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6415 = new BitSet(new long[]{0x03A0200020000100L});
    public static final BitSet FOLLOW_55_in_ruleXSwitchExpression6429 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleXSwitchExpression6441 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6462 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleXSwitchExpression6476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6512 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6568 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_57_in_ruleXCasePart6582 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6603 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleXCasePart6617 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression6684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXForLoopExpression6730 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleXForLoopExpression6742 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6763 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleXForLoopExpression6775 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6796 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXForLoopExpression6808 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression6875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleXWhileExpression6921 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleXWhileExpression6933 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression6954 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXWhileExpression6966 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression6987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression7033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleXDoWhileExpression7079 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7100 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleXDoWhileExpression7112 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleXDoWhileExpression7124 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7145 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXDoWhileExpression7157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression7203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXBlockExpression7249 = new BitSet(new long[]{0xFD54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7271 = new BitSet(new long[]{0xFD54A086040021F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_13_in_ruleXBlockExpression7284 = new BitSet(new long[]{0xFD54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_56_in_ruleXBlockExpression7300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXVariableDeclaration7518 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_62_in_ruleXVariableDeclaration7549 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7597 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7618 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7647 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleXVariableDeclaration7661 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter7730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7776 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter7798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter7834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFullJvmFormalParameter7844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter7890 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter7911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall7957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall8014 = new BitSet(new long[]{0x8000000004000100L});
    public static final BitSet FOLLOW_26_in_ruleXFeatureCall8028 = new BitSet(new long[]{0x0000200020000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8049 = new BitSet(new long[]{0x0000100002000000L});
    public static final BitSet FOLLOW_44_in_ruleXFeatureCall8062 = new BitSet(new long[]{0x0000200020000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8083 = new BitSet(new long[]{0x0000100002000000L});
    public static final BitSet FOLLOW_25_in_ruleXFeatureCall8097 = new BitSet(new long[]{0x8000000004000100L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8122 = new BitSet(new long[]{0x0000A00000000002L});
    public static final BitSet FOLLOW_45_in_ruleXFeatureCall8156 = new BitSet(new long[]{0xFC55E086240001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8241 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8269 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_44_in_ruleXFeatureCall8282 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8303 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_46_in_ruleXFeatureCall8320 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXFeatureCall8355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper8404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleIdOrSuper8451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleIdOrSuper8475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier8527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier8574 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleStaticQualifier8592 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall8643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXConstructorCall8689 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8712 = new BitSet(new long[]{0x0000A00004000002L});
    public static final BitSet FOLLOW_26_in_ruleXConstructorCall8733 = new BitSet(new long[]{0x0000200020000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8755 = new BitSet(new long[]{0x0000100002000000L});
    public static final BitSet FOLLOW_44_in_ruleXConstructorCall8768 = new BitSet(new long[]{0x0000200020000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8789 = new BitSet(new long[]{0x0000100002000000L});
    public static final BitSet FOLLOW_25_in_ruleXConstructorCall8803 = new BitSet(new long[]{0x0000A00000000002L});
    public static final BitSet FOLLOW_45_in_ruleXConstructorCall8826 = new BitSet(new long[]{0xFC55E086240001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8899 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8927 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_44_in_ruleXConstructorCall8940 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8961 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_46_in_ruleXConstructorCall8978 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXConstructorCall9013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9050 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral9060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXBooleanLiteral9107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXBooleanLiteral9131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral9191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXNullLiteral9237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral9273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNumberLiteral9283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleXNumberLiteral9338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral9384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral9435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral9486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXTypeLiteral9532 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleXTypeLiteral9544 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9567 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleXTypeLiteral9588 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_46_in_ruleXTypeLiteral9601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9637 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression9647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleXThrowExpression9693 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression9714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression9760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleXReturnExpression9806 = new BitSet(new long[]{0xFC54A086040001F2L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression9837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9874 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleXTryCatchFinallyExpression9930 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9951 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9981 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_73_in_ruleXTryCatchFinallyExpression10003 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleXTryCatchFinallyExpression10047 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10106 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause10116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleXCatchClause10161 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleXCatchClause10174 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause10195 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXCatchClause10207 = new BitSet(new long[]{0xFC54A086040001F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause10228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10265 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10323 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleQualifiedName10351 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10374 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber10428 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber10439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleNumber10483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber10511 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber10537 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleNumber10557 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber10573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber10599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10652 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference10662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10710 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference10746 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets10813 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets10824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleArrayBrackets10862 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleArrayBrackets10875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef10925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleXFunctionTypeRef10963 = new BitSet(new long[]{0x0000600020000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10985 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_44_in_ruleXFunctionTypeRef10998 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11019 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_46_in_ruleXFunctionTypeRef11035 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXFunctionTypeRef11049 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11106 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11164 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleJvmParameterizedTypeReference11185 = new BitSet(new long[]{0x0000200020000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11207 = new BitSet(new long[]{0x0000100002000000L});
    public static final BitSet FOLLOW_44_in_ruleJvmParameterizedTypeReference11220 = new BitSet(new long[]{0x0000200020000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11241 = new BitSet(new long[]{0x0000100002000000L});
    public static final BitSet FOLLOW_25_in_ruleJvmParameterizedTypeReference11255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11293 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11412 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleJvmWildcardTypeReference11468 = new BitSet(new long[]{0x8000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11555 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound11565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleJvmUpperBound11602 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleJvmUpperBoundAnded11706 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11763 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound11773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleJvmLowerBound11810 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID11870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID11881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID11920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred1_InternalPureXbase782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalPureXbase1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalPureXbase1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalPureXbase1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred5_InternalPureXbase1924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred6_InternalPureXbase1995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred7_InternalPureXbase2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred8_InternalPureXbase2530 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred8_InternalPureXbase2535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_synpred9_InternalPureXbase2617 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_synpred9_InternalPureXbase2622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred10_InternalPureXbase2844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred11_InternalPureXbase3124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred12_InternalPureXbase3718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred13_InternalPureXbase3872 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred13_InternalPureXbase3881 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred13_InternalPureXbase3887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred14_InternalPureXbase3990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred14_InternalPureXbase4004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred14_InternalPureXbase4024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred15_InternalPureXbase4251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalPureXbase4303 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_synpred16_InternalPureXbase4310 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalPureXbase4317 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_synpred16_InternalPureXbase4331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred17_InternalPureXbase4451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred18_InternalPureXbase4975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalPureXbase5254 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_synpred20_InternalPureXbase5261 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalPureXbase5268 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_synpred20_InternalPureXbase5282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred22_InternalPureXbase6065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred23_InternalPureXbase6207 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_synpred23_InternalPureXbase6213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred24_InternalPureXbase6289 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred24_InternalPureXbase6296 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_synpred24_InternalPureXbase6302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred25_InternalPureXbase7567 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred25_InternalPureXbase7576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred26_InternalPureXbase8138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalPureXbase8190 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_synpred27_InternalPureXbase8197 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalPureXbase8204 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_synpred27_InternalPureXbase8218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred28_InternalPureXbase8338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_synpred29_InternalPureXbase8725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred30_InternalPureXbase8818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred31_InternalPureXbase8848 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_synpred31_InternalPureXbase8855 = new BitSet(new long[]{0x0000200020000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred31_InternalPureXbase8862 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_synpred31_InternalPureXbase8876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred32_InternalPureXbase8996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred33_InternalPureXbase9820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_synpred34_InternalPureXbase9965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_synpred35_InternalPureXbase9995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred37_InternalPureXbase10342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_synpred38_InternalPureXbase10725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_synpred39_InternalPureXbase11177 = new BitSet(new long[]{0x0000000000000002L});

}