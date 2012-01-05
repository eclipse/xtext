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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'import'", "'.*'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'.'", "'?.'", "'*.'", "','", "'('", "')'", "'['", "'|'", "']'", "'if'", "'else'", "'switch'", "':'", "'{'", "'default'", "'}'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'super'", "'::'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'extends'", "'&'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=6;
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
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
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

                if ( ((LA3_0>=RULE_INT && LA3_0<=RULE_ID)||LA3_0==12||LA3_0==24||(LA3_0>=27 && LA3_0<=28)||LA3_0==33||LA3_0==39||LA3_0==41||LA3_0==44||LA3_0==46||LA3_0==48||(LA3_0>=52 && LA3_0<=57)||(LA3_0>=59 && LA3_0<=66)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:125:3: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:125:3: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( ((LA1_0>=RULE_INT && LA1_0<=RULE_ID)||LA1_0==24||(LA1_0>=27 && LA1_0<=28)||LA1_0==33||LA1_0==39||LA1_0==41||LA1_0==44||LA1_0==46||LA1_0==48||(LA1_0>=52 && LA1_0<=57)||(LA1_0>=59 && LA1_0<=66)) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==12) ) {
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

            	    if ( (LA2_0==11) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:162:5: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,11,FOLLOW_11_in_ruleSpecialBlockExpression273); if (state.failed) return current;
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
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleImport360); if (state.failed) return current;
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

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:242:2: kw= '.*'
                    {
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleQualifiedNameWithWildCard495); if (state.failed) return current;
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

                if ( (LA6_1==EOF||(LA6_1>=RULE_INT && LA6_1<=RULE_ID)||(LA6_1>=11 && LA6_1<=12)||(LA6_1>=15 && LA6_1<=41)||(LA6_1>=43 && LA6_1<=69)) ) {
                    alt6=2;
                }
                else if ( (LA6_1==14) ) {
                    alt6=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA6_0>=RULE_INT && LA6_0<=RULE_STRING)||LA6_0==24||(LA6_0>=27 && LA6_0<=28)||LA6_0==33||LA6_0==39||LA6_0==41||LA6_0==44||LA6_0==46||LA6_0==48||(LA6_0>=52 && LA6_0<=54)||LA6_0==57||(LA6_0>=59 && LA6_0<=66)) ) {
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

                    if ( (LA5_0==15) ) {
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
            kw=(Token)match(input,14,FOLLOW_14_in_ruleOpSingleAssign925); if (state.failed) return current;
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
            kw=(Token)match(input,15,FOLLOW_15_in_ruleOpMultiAssign1013); if (state.failed) return current;
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

                if ( (LA7_0==16) ) {
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
            kw=(Token)match(input,16,FOLLOW_16_in_ruleOpOr1272); if (state.failed) return current;
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

                if ( (LA8_0==17) ) {
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
            kw=(Token)match(input,17,FOLLOW_17_in_ruleOpAnd1531); if (state.failed) return current;
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

                if ( (LA9_0==18) ) {
                    int LA9_2 = input.LA(2);

                    if ( (synpred4_InternalPureXbase()) ) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==19) ) {
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

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            else if ( (LA10_0==19) ) {
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
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleOpEquality1791); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:758:2: kw= '!='
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleOpEquality1810); if (state.failed) return current;
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
                case 20:
                    {
                    int LA11_2 = input.LA(2);

                    if ( (synpred5_InternalPureXbase()) ) {
                        alt11=1;
                    }


                    }
                    break;
                case 21:
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

                    if ( (synpred6_InternalPureXbase()) ) {
                        alt11=2;
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

            	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleXRelationalExpression1943); if (state.failed) return current;
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
            case 21:
                {
                alt12=1;
                }
                break;
            case 22:
                {
                alt12=2;
                }
                break;
            case 23:
                {
                alt12=3;
                }
                break;
            case 24:
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
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleOpCompare2139); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:897:2: kw= '<='
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleOpCompare2158); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:904:2: kw= '>'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleOpCompare2177); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:911:2: kw= '<'
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleOpCompare2196); if (state.failed) return current;
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
                int LA13_0 = input.LA(1);

                if ( (LA13_0==25) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred7_InternalPureXbase()) ) {
                        alt13=1;
                    }


                }
                else if ( (LA13_0==26) ) {
                    int LA13_3 = input.LA(2);

                    if ( (synpred7_InternalPureXbase()) ) {
                        alt13=1;
                    }


                }


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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1007:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1010:28: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1011:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1011:1: (kw= '->' | kw= '..' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            else if ( (LA14_0==26) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1012:2: kw= '->'
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleOpOther2457); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1019:2: kw= '..'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleOpOther2476); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_1()); 
                          
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1032:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1033:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1034:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2516);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression2526); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1041:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1044:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1045:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1045:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1046:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2573);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1054:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==27) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred8_InternalPureXbase()) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==28) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred8_InternalPureXbase()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1054:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1054:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1054:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1059:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1059:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1059:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1060:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1065:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1066:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1066:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1067:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression2626);
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

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1080:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1081:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1081:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1082:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2649);
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
            	    break loop15;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1106:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1107:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1108:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd2688);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd2699); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1115:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1118:28: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1119:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1119:1: (kw= '+' | kw= '-' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            else if ( (LA16_0==28) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1120:2: kw= '+'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpAdd2737); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1127:2: kw= '-'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpAdd2756); if (state.failed) return current;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1140:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1141:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1142:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression2796);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression2806); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1149:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1152:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1153:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1153:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1154:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2853);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1162:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop17:
            do {
                int alt17=2;
                switch ( input.LA(1) ) {
                case 29:
                    {
                    int LA17_2 = input.LA(2);

                    if ( (synpred9_InternalPureXbase()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case 30:
                    {
                    int LA17_3 = input.LA(2);

                    if ( (synpred9_InternalPureXbase()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case 31:
                    {
                    int LA17_4 = input.LA(2);

                    if ( (synpred9_InternalPureXbase()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA17_5 = input.LA(2);

                    if ( (synpred9_InternalPureXbase()) ) {
                        alt17=1;
                    }


                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1162:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1162:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1162:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1167:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1167:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1167:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1168:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1173:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1174:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1174:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1175:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression2906);
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

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1188:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1189:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1189:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1190:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2929);
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
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1214:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1215:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1216:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti2968);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti2979); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1223:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1226:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1227:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1227:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt18=1;
                }
                break;
            case 30:
                {
                alt18=2;
                }
                break;
            case 31:
                {
                alt18=3;
                }
                break;
            case 32:
                {
                alt18=4;
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1228:2: kw= '*'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpMulti3017); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1235:2: kw= '**'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpMulti3036); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1242:2: kw= '/'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpMulti3055); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1249:2: kw= '%'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpMulti3074); if (state.failed) return current;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1262:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1263:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1264:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3114);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation3124); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1271:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1274:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1275:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1275:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=27 && LA19_0<=28)||LA19_0==33) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=RULE_INT && LA19_0<=RULE_ID)||LA19_0==24||LA19_0==39||LA19_0==41||LA19_0==44||LA19_0==46||LA19_0==48||(LA19_0>=52 && LA19_0<=54)||LA19_0==57||(LA19_0>=59 && LA19_0<=66)) ) {
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1275:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1275:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1275:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1275:3: ()
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1276:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1281:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1282:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1282:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1283:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3182);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1296:2: ( (lv_operand_2_0= ruleXCastedExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1297:1: (lv_operand_2_0= ruleXCastedExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1297:1: (lv_operand_2_0= ruleXCastedExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1298:3: lv_operand_2_0= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXCastedExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3203);
                    lv_operand_2_0=ruleXCastedExpression();

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
                              		"XCastedExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1316:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3232);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1332:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1333:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1334:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary3268);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary3279); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1341:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1344:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1345:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1345:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt20=1;
                }
                break;
            case 28:
                {
                alt20=2;
                }
                break;
            case 27:
                {
                alt20=3;
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1346:2: kw= '!'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpUnary3317); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1353:2: kw= '-'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpUnary3336); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1360:2: kw= '+'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpUnary3355); if (state.failed) return current;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1373:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1374:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1375:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3395);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression3405); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1382:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1385:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1386:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1386:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1387:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3452);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1395:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==34) ) {
                    int LA21_2 = input.LA(2);

                    if ( (synpred10_InternalPureXbase()) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1395:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1395:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1395:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1397:5: ( () otherlv_2= 'as' )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1397:6: () otherlv_2= 'as'
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1397:6: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1398:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleXCastedExpression3487); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1407:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1408:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1408:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1409:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3510);
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
            	    break loop21;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1433:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1434:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1435:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3548);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall3558); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1442:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) ;
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
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1445:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1446:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1446:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1447:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall3605);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:1: ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            loop29:
            do {
                int alt29=3;
                switch ( input.LA(1) ) {
                case 35:
                    {
                    int LA29_2 = input.LA(2);

                    if ( (synpred11_InternalPureXbase()) ) {
                        alt29=1;
                    }
                    else if ( (synpred12_InternalPureXbase()) ) {
                        alt29=2;
                    }


                    }
                    break;
                case 36:
                    {
                    int LA29_3 = input.LA(2);

                    if ( (synpred12_InternalPureXbase()) ) {
                        alt29=2;
                    }


                    }
                    break;
                case 37:
                    {
                    int LA29_4 = input.LA(2);

                    if ( (synpred12_InternalPureXbase()) ) {
                        alt29=2;
                    }


                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1461:25: ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1461:26: () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1461:26: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1462:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleXMemberFeatureCall3654); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1471:1: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1472:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1472:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1473:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3677);
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
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall3693);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1494:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1495:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1495:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1496:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall3715);
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
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1513:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1513:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1513:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1513:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1513:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1529:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1529:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1529:8: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1530:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1535:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt22=3;
            	    switch ( input.LA(1) ) {
            	    case 35:
            	        {
            	        alt22=1;
            	        }
            	        break;
            	    case 36:
            	        {
            	        alt22=2;
            	        }
            	        break;
            	    case 37:
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
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1535:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,35,FOLLOW_35_in_ruleXMemberFeatureCall3801); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1540:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1540:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1541:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1541:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1542:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,36,FOLLOW_36_in_ruleXMemberFeatureCall3825); if (state.failed) return current;
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
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1556:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1556:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1557:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1557:1: (lv_spreading_9_0= '*.' )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1558:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,37,FOLLOW_37_in_ruleXMemberFeatureCall3862); if (state.failed) return current;
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

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1571:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==24) ) {
            	        alt24=1;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1571:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,24,FOLLOW_24_in_ruleXMemberFeatureCall3891); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1575:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1576:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1576:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1577:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall3912);
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

            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1593:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop23:
            	            do {
            	                int alt23=2;
            	                int LA23_0 = input.LA(1);

            	                if ( (LA23_0==38) ) {
            	                    alt23=1;
            	                }


            	                switch (alt23) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1593:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,38,FOLLOW_38_in_ruleXMemberFeatureCall3925); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1597:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1598:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1598:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1599:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall3946);
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
            	            	    break loop23;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,23,FOLLOW_23_in_ruleXMemberFeatureCall3960); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1619:3: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1620:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1620:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1621:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3985);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1634:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt27=2;
            	    alt27 = dfa27.predict(input);
            	    switch (alt27) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1634:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1634:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1634:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1641:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1642:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,39,FOLLOW_39_in_ruleXMemberFeatureCall4019); if (state.failed) return current;
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

            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1655:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt26=3;
            	            alt26 = dfa26.predict(input);
            	            switch (alt26) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1655:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1655:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1655:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1672:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1673:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4104);
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
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1690:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1690:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1690:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1690:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1691:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1691:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1692:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4132);
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

            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1708:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop25:
            	                    do {
            	                        int alt25=2;
            	                        int LA25_0 = input.LA(1);

            	                        if ( (LA25_0==38) ) {
            	                            alt25=1;
            	                        }


            	                        switch (alt25) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1708:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,38,FOLLOW_38_in_ruleXMemberFeatureCall4145); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1712:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1713:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1713:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1714:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4166);
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
            	                    	    break loop25;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_21=(Token)match(input,40,FOLLOW_40_in_ruleXMemberFeatureCall4183); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_21, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1734:3: ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    int alt28=2;
            	    alt28 = dfa28.predict(input);
            	    switch (alt28) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1734:4: ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1739:1: (lv_memberCallArguments_22_0= ruleXClosure )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1740:3: lv_memberCallArguments_22_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4216);
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
            	    break loop29;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1764:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1765:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1766:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4256);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression4266); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1773:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) ;
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
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1776:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1777:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1777:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            int alt30=13;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt30=1;
                }
                break;
            case 48:
                {
                alt30=2;
                }
                break;
            case 46:
                {
                alt30=3;
                }
                break;
            case RULE_ID:
            case 24:
            case 57:
                {
                alt30=4;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 41:
            case 60:
            case 61:
            case 62:
            case 63:
                {
                alt30=5;
                }
                break;
            case 44:
                {
                alt30=6;
                }
                break;
            case 52:
                {
                alt30=7;
                }
                break;
            case 53:
                {
                alt30=8;
                }
                break;
            case 54:
                {
                alt30=9;
                }
                break;
            case 64:
                {
                alt30=10;
                }
                break;
            case 65:
                {
                alt30=11;
                }
                break;
            case 66:
                {
                alt30=12;
                }
                break;
            case 39:
                {
                alt30=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1778:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4313);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1788:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4340);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1798:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4367);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1808:5: this_XFeatureCall_3= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression4394);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1818:5: this_XLiteral_4= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression4421);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1828:5: this_XIfExpression_5= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4448);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1838:5: this_XForLoopExpression_6= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression4475);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1848:5: this_XWhileExpression_7= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4502);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1858:5: this_XDoWhileExpression_8= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4529);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1868:5: this_XThrowExpression_9= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4556);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1878:5: this_XReturnExpression_10= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression4583);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1888:5: this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4610);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1898:5: this_XParenthesizedExpression_12= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4637);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1914:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1915:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1916:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral4672);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral4682); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1923:1: ruleXLiteral returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XClosure_0 = null;

        EObject this_XBooleanLiteral_1 = null;

        EObject this_XIntLiteral_2 = null;

        EObject this_XNullLiteral_3 = null;

        EObject this_XStringLiteral_4 = null;

        EObject this_XTypeLiteral_5 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1926:28: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1927:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1927:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt31=6;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt31=1;
                }
                break;
            case 60:
            case 61:
                {
                alt31=2;
                }
                break;
            case RULE_INT:
                {
                alt31=3;
                }
                break;
            case 62:
                {
                alt31=4;
                }
                break;
            case RULE_STRING:
                {
                alt31=5;
                }
                break;
            case 63:
                {
                alt31=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1928:5: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral4729);
                    this_XClosure_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XClosure_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1938:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral4756);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1948:5: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXIntLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXLiteral4783);
                    this_XIntLiteral_2=ruleXIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIntLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1958:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral4810);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1968:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral4837);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1978:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral4864);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1994:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1995:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1996:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure4899);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure4909); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2003:1: ruleXClosure returns [EObject current=null] : ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
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
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2006:28: ( ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2007:1: ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2007:1: ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2007:2: () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2007:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2008:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleXClosure4955); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2017:1: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2017:2: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2032:6: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2032:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2032:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==RULE_ID||LA33_0==39||LA33_0==69) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2032:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2032:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2033:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2033:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2034:3: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_2_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5026);
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

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2050:2: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop32:
                            do {
                                int alt32=2;
                                int LA32_0 = input.LA(1);

                                if ( (LA32_0==38) ) {
                                    alt32=1;
                                }


                                switch (alt32) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2050:4: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,38,FOLLOW_38_in_ruleXClosure5039); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_2_0_0_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2054:1: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2055:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2055:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2056:3: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_2_0_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5060);
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
                            	    break loop32;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2072:6: ( (lv_explicitSyntax_5_0= '|' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2073:1: (lv_explicitSyntax_5_0= '|' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2073:1: (lv_explicitSyntax_5_0= '|' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2074:3: lv_explicitSyntax_5_0= '|'
                    {
                    lv_explicitSyntax_5_0=(Token)match(input,42,FOLLOW_42_in_ruleXClosure5082); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitSyntax_5_0, grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_2_0_1_0());
                          
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

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2087:5: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2088:1: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2088:1: (lv_expression_6_0= ruleXExpressionInClosure )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2089:3: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5119);
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

            otherlv_7=(Token)match(input,43,FOLLOW_43_in_ruleXClosure5131); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_4());
                  
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2117:1: entryRuleXExpressionInClosure returns [EObject current=null] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInClosure = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2118:2: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2119:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5167);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInClosure5177); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2126:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) ;
    public final EObject ruleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2129:28: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2130:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2130:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2130:2: () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2130:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2131:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2136:2: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=RULE_INT && LA36_0<=RULE_ID)||LA36_0==24||(LA36_0>=27 && LA36_0<=28)||LA36_0==33||LA36_0==39||LA36_0==41||LA36_0==44||LA36_0==46||LA36_0==48||(LA36_0>=52 && LA36_0<=57)||(LA36_0>=59 && LA36_0<=66)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2136:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )?
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2136:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2137:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2137:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2138:3: lv_expressions_1_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5233);
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

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2154:2: (otherlv_2= ';' )?
            	    int alt35=2;
            	    int LA35_0 = input.LA(1);

            	    if ( (LA35_0==11) ) {
            	        alt35=1;
            	    }
            	    switch (alt35) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2154:4: otherlv_2= ';'
            	            {
            	            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleXExpressionInClosure5246); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2166:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2167:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2168:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5286);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure5296); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2175:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        EObject lv_declaredFormalParameters_1_0 = null;

        EObject lv_declaredFormalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2178:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2179:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2179:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2179:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2179:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2179:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2195:6: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2195:7: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2195:7: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2196:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2201:2: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID||LA38_0==39||LA38_0==69) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2201:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2201:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2202:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2202:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2203:3: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5404);
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

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2219:2: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==38) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2219:4: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleXShortClosure5417); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2223:1: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2224:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2224:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2225:3: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5438);
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
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2241:6: ( (lv_explicitSyntax_4_0= '|' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2242:1: (lv_explicitSyntax_4_0= '|' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2242:1: (lv_explicitSyntax_4_0= '|' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2243:3: lv_explicitSyntax_4_0= '|'
            {
            lv_explicitSyntax_4_0=(Token)match(input,42,FOLLOW_42_in_ruleXShortClosure5460); if (state.failed) return current;
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

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2256:4: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2257:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2257:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2258:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure5496);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2282:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2283:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2284:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5532);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression5542); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2291:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2294:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2295:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2295:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2295:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleXParenthesizedExpression5579); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5601);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleXParenthesizedExpression5612); if (state.failed) return current;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2320:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2321:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2322:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5648);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression5658); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2329:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2332:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2333:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2333:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2333:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2333:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2334:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,44,FOLLOW_44_in_ruleXIfExpression5704); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleXIfExpression5716); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2347:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2348:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2348:1: (lv_if_3_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2349:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5737);
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

            otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleXIfExpression5749); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2369:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2370:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2370:1: (lv_then_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2371:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5770);
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

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2387:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==45) ) {
                int LA39_1 = input.LA(2);

                if ( (synpred18_InternalPureXbase()) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2387:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2387:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2387:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,45,FOLLOW_45_in_ruleXIfExpression5791); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2392:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2393:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2393:1: (lv_else_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2394:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5813);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2418:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2419:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2420:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression5851);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression5861); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2427:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_localVarName_2_0 = null;

        EObject lv_switch_4_0 = null;

        EObject lv_cases_6_0 = null;

        EObject lv_default_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2430:28: ( ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2431:1: ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2431:1: ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2431:2: () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2431:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2432:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleXSwitchExpression5907); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2441:1: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==47) && (synpred19_InternalPureXbase())) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2441:2: ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2446:5: ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2446:6: ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':'
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2446:6: ( (lv_localVarName_2_0= ruleValidID ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2447:1: (lv_localVarName_2_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2447:1: (lv_localVarName_2_0= ruleValidID )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2448:3: lv_localVarName_2_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression5948);
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

                    otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleXSwitchExpression5960); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_1());
                          
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2468:4: ( (lv_switch_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2469:1: (lv_switch_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2469:1: (lv_switch_4_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2470:3: lv_switch_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression5984);
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

            otherlv_5=(Token)match(input,48,FOLLOW_48_in_ruleXSwitchExpression5996); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2490:1: ( (lv_cases_6_0= ruleXCasePart ) )+
            int cnt41=0;
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_ID||LA41_0==39||LA41_0==47||LA41_0==51||LA41_0==69) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2491:1: (lv_cases_6_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2491:1: (lv_cases_6_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2492:3: lv_cases_6_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6017);
            	    lv_cases_6_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"cases",
            	              		lv_cases_6_0, 
            	              		"XCasePart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt41 >= 1 ) break loop41;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(41, input);
                        throw eee;
                }
                cnt41++;
            } while (true);

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2508:3: (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==49) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2508:5: otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) )
                    {
                    otherlv_7=(Token)match(input,49,FOLLOW_49_in_ruleXSwitchExpression6031); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_6_0());
                          
                    }
                    otherlv_8=(Token)match(input,47,FOLLOW_47_in_ruleXSwitchExpression6043); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_6_1());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2516:1: ( (lv_default_9_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2517:1: (lv_default_9_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2517:1: (lv_default_9_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2518:3: lv_default_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6064);
                    lv_default_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"default",
                              		lv_default_9_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,50,FOLLOW_50_in_ruleXSwitchExpression6078); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_7());
                  
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2546:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2547:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2548:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6114);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6124); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2555:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2558:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2559:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2559:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2559:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2559:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID||LA43_0==39||LA43_0==69) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2560:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2560:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2561:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6170);
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

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2577:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==51) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2577:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleXCasePart6184); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2581:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2582:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2582:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2583:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6205);
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

            otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleXCasePart6219); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2603:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2604:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2604:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2605:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6240);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2629:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2630:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2631:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6276);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression6286); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2638:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
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
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2641:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2642:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2642:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2642:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2642:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2643:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleXForLoopExpression6332); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleXForLoopExpression6344); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2656:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2657:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2657:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2658:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6365);
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

            otherlv_4=(Token)match(input,47,FOLLOW_47_in_ruleXForLoopExpression6377); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2678:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2679:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2679:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2680:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6398);
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

            otherlv_6=(Token)match(input,40,FOLLOW_40_in_ruleXForLoopExpression6410); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2700:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2701:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2701:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2702:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6431);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2726:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2727:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2728:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6467);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression6477); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2735:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2738:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2739:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2739:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2739:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2739:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2740:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleXWhileExpression6523); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleXWhileExpression6535); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2753:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2754:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2754:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2755:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression6556);
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

            otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleXWhileExpression6568); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2775:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2776:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2776:1: (lv_body_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2777:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression6589);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2801:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2802:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2803:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression6625);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression6635); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2810:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
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
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2813:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2814:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2814:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2814:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2814:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2815:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,54,FOLLOW_54_in_ruleXDoWhileExpression6681); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2824:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2825:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2825:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2826:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6702);
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

            otherlv_3=(Token)match(input,53,FOLLOW_53_in_ruleXDoWhileExpression6714); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleXDoWhileExpression6726); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2850:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2851:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2851:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2852:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6747);
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

            otherlv_6=(Token)match(input,40,FOLLOW_40_in_ruleXDoWhileExpression6759); if (state.failed) return current;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2880:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2881:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2882:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression6795);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression6805); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2889:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2892:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2893:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2893:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2893:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2893:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2894:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleXBlockExpression6851); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2903:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=RULE_INT && LA46_0<=RULE_ID)||LA46_0==24||(LA46_0>=27 && LA46_0<=28)||LA46_0==33||LA46_0==39||LA46_0==41||LA46_0==44||LA46_0==46||LA46_0==48||(LA46_0>=52 && LA46_0<=57)||(LA46_0>=59 && LA46_0<=66)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2903:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2903:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2904:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2904:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2905:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression6873);
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

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2921:2: (otherlv_3= ';' )?
            	    int alt45=2;
            	    int LA45_0 = input.LA(1);

            	    if ( (LA45_0==11) ) {
            	        alt45=1;
            	    }
            	    switch (alt45) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2921:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,11,FOLLOW_11_in_ruleXBlockExpression6886); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_4=(Token)match(input,50,FOLLOW_50_in_ruleXBlockExpression6902); if (state.failed) return current;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2937:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2938:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2939:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock6938);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock6948); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2946:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2949:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2950:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2950:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=55 && LA47_0<=56)) ) {
                alt47=1;
            }
            else if ( ((LA47_0>=RULE_INT && LA47_0<=RULE_ID)||LA47_0==24||(LA47_0>=27 && LA47_0<=28)||LA47_0==33||LA47_0==39||LA47_0==41||LA47_0==44||LA47_0==46||LA47_0==48||(LA47_0>=52 && LA47_0<=54)||LA47_0==57||(LA47_0>=59 && LA47_0<=66)) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2951:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock6995);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2961:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7022);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2977:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2978:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2979:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7057);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7067); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2986:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2989:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2990:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2990:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2990:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2990:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2991:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2996:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==55) ) {
                alt48=1;
            }
            else if ( (LA48_0==56) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2996:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2996:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2997:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2997:1: (lv_writeable_1_0= 'var' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2998:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,55,FOLLOW_55_in_ruleXVariableDeclaration7120); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3012:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,56,FOLLOW_56_in_ruleXVariableDeclaration7151); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3016:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                int LA49_1 = input.LA(2);

                if ( (synpred20_InternalPureXbase()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA49_0==39) && (synpred20_InternalPureXbase())) {
                alt49=1;
            }
            else if ( (LA49_0==69) && (synpred20_InternalPureXbase())) {
                alt49=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3016:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3016:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3016:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3024:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3024:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3024:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3025:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3025:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3026:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7199);
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

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3042:2: ( (lv_name_4_0= ruleValidID ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3043:1: (lv_name_4_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3043:1: (lv_name_4_0= ruleValidID )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3044:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7220);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3061:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3061:6: ( (lv_name_5_0= ruleValidID ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3062:1: (lv_name_5_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3062:1: (lv_name_5_0= ruleValidID )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3063:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7249);
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

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3079:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==14) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3079:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleXVariableDeclaration7263); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3083:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3084:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3084:1: (lv_right_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3085:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7284);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3109:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3110:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3111:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7322);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter7332); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3118:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3121:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3122:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3122:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3122:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3122:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==RULE_ID||LA51_1==24||LA51_1==35||LA51_1==41) ) {
                    alt51=1;
                }
            }
            else if ( (LA51_0==39||LA51_0==69) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3123:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3123:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3124:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7378);
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

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3140:3: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3141:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3141:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3142:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameter7400);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3166:1: entryRuleFullJvmFormalParameter returns [EObject current=null] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3167:2: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3168:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter7436);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFullJvmFormalParameter7446); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3175:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3178:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3179:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3179:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3179:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3179:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3180:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3180:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3181:3: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter7492);
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

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3197:2: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3198:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3198:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3199:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter7513);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3223:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3224:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3225:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7549);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall7559); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3232:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) ;
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
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3235:28: ( ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3236:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3236:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3236:2: () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3236:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3237:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3242:2: ( ( ruleStaticQualifier ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==58) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3243:1: ( ruleStaticQualifier )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3243:1: ( ruleStaticQualifier )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3244:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall7616);
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

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3257:3: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==24) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3257:5: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleXFeatureCall7630); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3261:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3262:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3262:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3263:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7651);
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

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3279:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==38) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3279:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,38,FOLLOW_38_in_ruleXFeatureCall7664); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3283:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3284:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3284:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3285:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7685);
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
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleXFeatureCall7699); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3305:3: ( ( ruleIdOrSuper ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3306:1: ( ruleIdOrSuper )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3306:1: ( ruleIdOrSuper )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3307:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall7724);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3320:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt57=2;
            alt57 = dfa57.predict(input);
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3320:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3320:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3320:4: ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3327:1: (lv_explicitOperationCall_8_0= '(' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3328:3: lv_explicitOperationCall_8_0= '('
                    {
                    lv_explicitOperationCall_8_0=(Token)match(input,39,FOLLOW_39_in_ruleXFeatureCall7758); if (state.failed) return current;
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

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3341:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt56=3;
                    alt56 = dfa56.predict(input);
                    switch (alt56) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3341:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3341:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3341:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3358:1: (lv_featureCallArguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3359:3: lv_featureCallArguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall7843);
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
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3376:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3376:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3376:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3376:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3377:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3377:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3378:3: lv_featureCallArguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall7871);
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

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3394:2: (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            loop55:
                            do {
                                int alt55=2;
                                int LA55_0 = input.LA(1);

                                if ( (LA55_0==38) ) {
                                    alt55=1;
                                }


                                switch (alt55) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3394:4: otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,38,FOLLOW_38_in_ruleXFeatureCall7884); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXFeatureCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3398:1: ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3399:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3399:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3400:3: lv_featureCallArguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall7905);
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
                            	    break loop55;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,40,FOLLOW_40_in_ruleXFeatureCall7922); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3420:3: ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            int alt58=2;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3420:4: ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3425:1: (lv_featureCallArguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3426:3: lv_featureCallArguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXFeatureCall7955);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3450:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3451:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3452:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper7993);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper8004); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3459:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3462:28: ( (this_ValidID_0= ruleValidID | kw= 'super' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3463:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3463:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                alt59=1;
            }
            else if ( (LA59_0==57) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3464:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleIdOrSuper8051);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3476:2: kw= 'super'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleIdOrSuper8075); if (state.failed) return current;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3489:1: entryRuleStaticQualifier returns [String current=null] : iv_ruleStaticQualifier= ruleStaticQualifier EOF ;
    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3490:2: (iv_ruleStaticQualifier= ruleStaticQualifier EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3491:2: iv_ruleStaticQualifier= ruleStaticQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStaticQualifierRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8116);
            iv_ruleStaticQualifier=ruleStaticQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier8127); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3498:1: ruleStaticQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '::' )+ ;
    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3501:28: ( (this_ValidID_0= ruleValidID kw= '::' )+ )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3502:1: (this_ValidID_0= ruleValidID kw= '::' )+
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3502:1: (this_ValidID_0= ruleValidID kw= '::' )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID) ) {
                    int LA60_2 = input.LA(2);

                    if ( (LA60_2==58) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3503:5: this_ValidID_0= ruleValidID kw= '::'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStaticQualifierAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier8174);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,58,FOLLOW_58_in_ruleStaticQualifier8192); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getStaticQualifierAccess().getColonColonKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt60 >= 1 ) break loop60;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3527:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3528:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3529:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8233);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall8243); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3536:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
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
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3539:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3540:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3540:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3540:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3540:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3541:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleXConstructorCall8289); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3550:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3551:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3551:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3552:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8312);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3565:2: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==24) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3565:4: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleXConstructorCall8325); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3569:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3570:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3570:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3571:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8346);
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

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3587:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==38) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3587:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,38,FOLLOW_38_in_ruleXConstructorCall8359); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3591:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3592:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3592:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3593:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8380);
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
                    	    break loop61;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleXConstructorCall8394); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,39,FOLLOW_39_in_ruleXConstructorCall8408); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3617:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
            int alt64=3;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3617:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3617:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3617:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3634:1: (lv_arguments_9_0= ruleXShortClosure )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3635:3: lv_arguments_9_0= ruleXShortClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_5_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8480);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3652:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3652:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3652:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3652:7: ( (lv_arguments_10_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3653:1: (lv_arguments_10_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3653:1: (lv_arguments_10_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3654:3: lv_arguments_10_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8508);
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

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3670:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==38) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3670:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                    	    {
                    	    otherlv_11=(Token)match(input,38,FOLLOW_38_in_ruleXConstructorCall8521); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_5_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3674:1: ( (lv_arguments_12_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3675:1: (lv_arguments_12_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3675:1: (lv_arguments_12_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3676:3: lv_arguments_12_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8542);
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
                    	    break loop63;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,40,FOLLOW_40_in_ruleXConstructorCall8559); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3696:1: ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt65=2;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3696:2: ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3701:1: (lv_arguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3702:3: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXConstructorCall8590);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3726:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3727:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3728:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8627);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral8637); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3735:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3738:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3739:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3739:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3739:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3739:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3740:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3745:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==60) ) {
                alt66=1;
            }
            else if ( (LA66_0==61) ) {
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3745:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,60,FOLLOW_60_in_ruleXBooleanLiteral8684); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3750:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3750:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3751:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3751:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3752:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,61,FOLLOW_61_in_ruleXBooleanLiteral8708); if (state.failed) return current;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3773:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3774:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3775:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8758);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral8768); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3782:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3785:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3786:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3786:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3786:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3786:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3787:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleXNullLiteral8814); if (state.failed) return current;
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


    // $ANTLR start "entryRuleXIntLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3804:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3805:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3806:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral8850);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral8860); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXIntLiteral"


    // $ANTLR start "ruleXIntLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3813:1: ruleXIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3816:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3817:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3817:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3817:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3817:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3818:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIntLiteralAccess().getXIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3823:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3824:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3824:1: (lv_value_1_0= RULE_INT )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3825:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral8911); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getXIntLiteralAccess().getValueINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXIntLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"INT");
              	    
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
    // $ANTLR end "ruleXIntLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3849:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3850:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3851:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral8952);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral8962); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3858:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3861:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3862:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3862:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3862:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3862:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3863:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3868:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3869:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3869:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3870:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral9013); if (state.failed) return current;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3894:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3895:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3896:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9054);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral9064); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3903:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3906:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3907:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3907:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3907:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3907:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3908:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,63,FOLLOW_63_in_ruleXTypeLiteral9110); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleXTypeLiteral9122); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3921:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3922:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3922:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3923:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9145);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleXTypeLiteral9157); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_4());
                  
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3948:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3949:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3950:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9193);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression9203); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3957:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3960:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3961:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3961:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3961:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3961:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3962:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,64,FOLLOW_64_in_ruleXThrowExpression9249); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3971:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3972:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3972:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3973:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression9270);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3997:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3998:2: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3999:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9306);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression9316); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4006:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4009:28: ( ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4010:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4010:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4010:2: () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4010:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4011:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleXReturnExpression9362); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4020:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt67=2;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4020:2: ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4025:1: (lv_expression_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4026:3: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXReturnExpression9393);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4050:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4051:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4052:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9430);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9440); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4059:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4062:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4063:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4063:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4063:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4063:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4064:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleXTryCatchFinallyExpression9486); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4073:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4074:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4074:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4075:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9507);
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

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4091:2: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==68) ) {
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4091:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4091:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4091:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4091:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt68=0;
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==68) ) {
                            int LA68_2 = input.LA(2);

                            if ( (synpred27_InternalPureXbase()) ) {
                                alt68=1;
                            }


                        }


                        switch (alt68) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4091:5: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4093:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4094:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9537);
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
                    	    if ( cnt68 >= 1 ) break loop68;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(68, input);
                                throw eee;
                        }
                        cnt68++;
                    } while (true);

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4110:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==67) ) {
                        int LA69_1 = input.LA(2);

                        if ( (synpred28_InternalPureXbase()) ) {
                            alt69=1;
                        }
                    }
                    switch (alt69) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4110:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4110:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4110:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,67,FOLLOW_67_in_ruleXTryCatchFinallyExpression9559); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4115:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4116:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4116:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4117:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9581);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4134:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4134:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4134:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,67,FOLLOW_67_in_ruleXTryCatchFinallyExpression9603); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4138:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4139:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4139:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4140:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9624);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4164:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4165:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4166:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9662);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause9672); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4173:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4176:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4177:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4177:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4177:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4177:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4177:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,68,FOLLOW_68_in_ruleXCatchClause9717); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleXCatchClause9730); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4186:1: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4187:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4187:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4188:3: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause9751);
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

            otherlv_3=(Token)match(input,40,FOLLOW_40_in_ruleXCatchClause9763); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4208:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4209:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4209:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4210:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause9784);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4234:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4235:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4236:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9821);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName9832); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4243:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4246:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4247:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4247:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4248:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName9879);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4258:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==35) ) {
                    int LA71_2 = input.LA(2);

                    if ( (LA71_2==RULE_ID) ) {
                        int LA71_3 = input.LA(3);

                        if ( (synpred30_InternalPureXbase()) ) {
                            alt71=1;
                        }


                    }


                }


                switch (alt71) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4258:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4258:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4258:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,35,FOLLOW_35_in_ruleQualifiedName9907); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName9930);
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4285:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4286:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4287:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference9977);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference9987); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4294:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4297:28: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4298:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4298:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_ID) ) {
                alt73=1;
            }
            else if ( (LA73_0==39||LA73_0==69) ) {
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4298:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4298:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4299:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10035);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4307:1: ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==41) ) {
                            int LA72_2 = input.LA(2);

                            if ( (LA72_2==43) ) {
                                int LA72_3 = input.LA(3);

                                if ( (synpred31_InternalPureXbase()) ) {
                                    alt72=1;
                                }


                            }


                        }


                        switch (alt72) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4307:2: ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4310:5: ( () otherlv_2= '[' otherlv_3= ']' )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4310:6: () otherlv_2= '[' otherlv_3= ']'
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4310:6: ()
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4311:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleJvmTypeReference10073); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getJvmTypeReferenceAccess().getLeftSquareBracketKeyword_0_1_0_1());
                    	          
                    	    }
                    	    otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleJvmTypeReference10085); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmTypeReferenceAccess().getRightSquareBracketKeyword_0_1_0_2());
                    	          
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4326:5: this_XFunctionTypeRef_4= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10117);
                    this_XFunctionTypeRef_4=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFunctionTypeRef_4; 
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


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4342:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4343:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4344:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10152);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef10162); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4351:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
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
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4354:28: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4355:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4355:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4355:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4355:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==39) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4355:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleXFunctionTypeRef10200); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4359:1: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==RULE_ID||LA75_0==39||LA75_0==69) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4359:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4359:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4360:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4360:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4361:3: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10222);
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

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4377:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop74:
                            do {
                                int alt74=2;
                                int LA74_0 = input.LA(1);

                                if ( (LA74_0==38) ) {
                                    alt74=1;
                                }


                                switch (alt74) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4377:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleXFunctionTypeRef10235); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4381:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4382:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4382:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4383:3: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10256);
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
                            	    break loop74;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleXFunctionTypeRef10272); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,69,FOLLOW_69_in_ruleXFunctionTypeRef10286); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4407:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4408:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4408:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4409:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10307);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4433:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4434:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4435:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference10343);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference10353); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4442:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4445:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4446:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4446:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4446:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4446:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4447:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4447:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4448:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference10401);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4461:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt78=2;
            alt78 = dfa78.predict(input);
            switch (alt78) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4461:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4461:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4461:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleJvmParameterizedTypeReference10422); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4466:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4467:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4467:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4468:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10444);
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

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4484:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==38) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4484:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,38,FOLLOW_38_in_ruleJvmParameterizedTypeReference10457); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4488:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4489:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4489:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4490:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10478);
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
                    	    break loop77;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleJvmParameterizedTypeReference10492); if (state.failed) return current;
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4518:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4519:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4520:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference10530);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference10540); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4527:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4530:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4531:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4531:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_ID||LA79_0==39||LA79_0==69) ) {
                alt79=1;
            }
            else if ( (LA79_0==70) ) {
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4532:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference10587);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4542:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference10614);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4558:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4559:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4560:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference10649);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference10659); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4567:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4570:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4571:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4571:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4571:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4571:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4572:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,70,FOLLOW_70_in_ruleJvmWildcardTypeReference10705); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4581:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt80=3;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==71) ) {
                alt80=1;
            }
            else if ( (LA80_0==57) ) {
                alt80=2;
            }
            switch (alt80) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4581:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4581:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4582:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4582:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4583:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference10727);
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
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4600:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4600:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4601:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4601:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4602:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference10754);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4626:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4627:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4628:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound10792);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound10802); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4635:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4638:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4639:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4639:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4639:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_71_in_ruleJvmUpperBound10839); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4643:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4644:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4644:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4645:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound10860);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4669:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4670:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4671:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded10896);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded10906); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4678:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4681:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4682:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4682:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4682:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_72_in_ruleJvmUpperBoundAnded10943); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4686:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4687:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4687:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4688:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded10964);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4712:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4713:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4714:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11000);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound11010); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4721:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4724:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4725:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4725:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4725:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,57,FOLLOW_57_in_ruleJvmLowerBound11047); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4729:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4730:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4730:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4731:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11068);
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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4757:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4758:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4759:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID11107);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID11118); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4766:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4769:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4770:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID11157); if (state.failed) return current;
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

        match(input,20,FOLLOW_20_in_synpred5_InternalPureXbase1924); if (state.failed) return ;

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
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1054:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1054:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1054:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1054:5: () ( ( ruleOpAdd ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1054:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1055:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1055:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1056:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1056:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1057:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred8_InternalPureXbase2594);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalPureXbase

    // $ANTLR start synpred9_InternalPureXbase
    public final void synpred9_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1162:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1162:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1162:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1162:5: () ( ( ruleOpMulti ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1162:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1163:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1163:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1164:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1164:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1165:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred9_InternalPureXbase2874);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalPureXbase

    // $ANTLR start synpred10_InternalPureXbase
    public final void synpred10_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1395:3: ( ( () 'as' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1395:4: ( () 'as' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1395:4: ( () 'as' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1395:5: () 'as'
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1395:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1396:1: 
        {
        }

        match(input,34,FOLLOW_34_in_synpred10_InternalPureXbase3468); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalPureXbase

    // $ANTLR start synpred11_InternalPureXbase
    public final void synpred11_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:6: () '.' ( ( ruleValidID ) ) ruleOpSingleAssign
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1456:1: 
        {
        }

        match(input,35,FOLLOW_35_in_synpred11_InternalPureXbase3622); if (state.failed) return ;
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1457:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1458:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1458:1: ( ruleValidID )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1459:3: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred11_InternalPureXbase3631);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred11_InternalPureXbase3637);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalPureXbase

    // $ANTLR start synpred12_InternalPureXbase
    public final void synpred12_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1513:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1513:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1513:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1513:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1513:10: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1514:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1514:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt81=3;
        switch ( input.LA(1) ) {
        case 35:
            {
            alt81=1;
            }
            break;
        case 36:
            {
            alt81=2;
            }
            break;
        case 37:
            {
            alt81=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 81, 0, input);

            throw nvae;
        }

        switch (alt81) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1514:4: '.'
                {
                match(input,35,FOLLOW_35_in_synpred12_InternalPureXbase3740); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1516:6: ( ( '?.' ) )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1516:6: ( ( '?.' ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1517:1: ( '?.' )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1517:1: ( '?.' )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1518:2: '?.'
                {
                match(input,36,FOLLOW_36_in_synpred12_InternalPureXbase3754); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1523:6: ( ( '*.' ) )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1523:6: ( ( '*.' ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1524:1: ( '*.' )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1524:1: ( '*.' )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1525:2: '*.'
                {
                match(input,37,FOLLOW_37_in_synpred12_InternalPureXbase3774); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred12_InternalPureXbase

    // $ANTLR start synpred13_InternalPureXbase
    public final void synpred13_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1634:4: ( ( '(' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1635:1: ( '(' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1635:1: ( '(' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1636:2: '('
        {
        match(input,39,FOLLOW_39_in_synpred13_InternalPureXbase4001); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalPureXbase

    // $ANTLR start synpred14_InternalPureXbase
    public final void synpred14_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1655:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1655:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1655:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1655:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1655:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1656:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1656:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt83=2;
        int LA83_0 = input.LA(1);

        if ( (LA83_0==RULE_ID||LA83_0==39||LA83_0==69) ) {
            alt83=1;
        }
        switch (alt83) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1656:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1656:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1657:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1657:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1658:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalPureXbase4053);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1660:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop82:
                do {
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==38) ) {
                        alt82=1;
                    }


                    switch (alt82) {
                	case 1 :
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1660:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,38,FOLLOW_38_in_synpred14_InternalPureXbase4060); if (state.failed) return ;
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1661:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1662:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1662:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1663:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalPureXbase4067);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop82;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1665:6: ( ( '|' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1666:1: ( '|' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1666:1: ( '|' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1667:2: '|'
        {
        match(input,42,FOLLOW_42_in_synpred14_InternalPureXbase4081); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred14_InternalPureXbase

    // $ANTLR start synpred15_InternalPureXbase
    public final void synpred15_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1734:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1735:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1735:1: ( ruleXClosure )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1736:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred15_InternalPureXbase4199);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalPureXbase

    // $ANTLR start synpred16_InternalPureXbase
    public final void synpred16_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2017:2: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2017:3: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2017:3: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2017:4: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2017:4: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt85=2;
        int LA85_0 = input.LA(1);

        if ( (LA85_0==RULE_ID||LA85_0==39||LA85_0==69) ) {
            alt85=1;
        }
        switch (alt85) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2017:5: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2017:5: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2018:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2018:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2019:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalPureXbase4972);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2021:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop84:
                do {
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==38) ) {
                        alt84=1;
                    }


                    switch (alt84) {
                	case 1 :
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2021:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,38,FOLLOW_38_in_synpred16_InternalPureXbase4979); if (state.failed) return ;
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2022:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2023:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2023:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2024:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalPureXbase4986);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop84;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2026:6: ( ( '|' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2027:1: ( '|' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2027:1: ( '|' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2028:2: '|'
        {
        match(input,42,FOLLOW_42_in_synpred16_InternalPureXbase5000); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred16_InternalPureXbase

    // $ANTLR start synpred18_InternalPureXbase
    public final void synpred18_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2387:4: ( 'else' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2387:6: 'else'
        {
        match(input,45,FOLLOW_45_in_synpred18_InternalPureXbase5783); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalPureXbase

    // $ANTLR start synpred19_InternalPureXbase
    public final void synpred19_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2441:2: ( ( ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2441:3: ( ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2441:3: ( ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2441:4: ( ( ruleValidID ) ) ':'
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2441:4: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2442:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2442:1: ( ruleValidID )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2443:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred19_InternalPureXbase5923);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,47,FOLLOW_47_in_synpred19_InternalPureXbase5929); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalPureXbase

    // $ANTLR start synpred20_InternalPureXbase
    public final void synpred20_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3016:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3016:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3016:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3016:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3016:6: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3017:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3017:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3018:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred20_InternalPureXbase7169);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3020:2: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3021:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3021:1: ( ruleValidID )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3022:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred20_InternalPureXbase7178);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred20_InternalPureXbase

    // $ANTLR start synpred21_InternalPureXbase
    public final void synpred21_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3320:4: ( ( '(' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3321:1: ( '(' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3321:1: ( '(' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3322:2: '('
        {
        match(input,39,FOLLOW_39_in_synpred21_InternalPureXbase7740); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalPureXbase

    // $ANTLR start synpred22_InternalPureXbase
    public final void synpred22_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3341:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3341:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3341:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3341:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3341:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3342:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3342:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt89=2;
        int LA89_0 = input.LA(1);

        if ( (LA89_0==RULE_ID||LA89_0==39||LA89_0==69) ) {
            alt89=1;
        }
        switch (alt89) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3342:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3342:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3343:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3343:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3344:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalPureXbase7792);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3346:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop88:
                do {
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==38) ) {
                        alt88=1;
                    }


                    switch (alt88) {
                	case 1 :
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3346:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,38,FOLLOW_38_in_synpred22_InternalPureXbase7799); if (state.failed) return ;
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3347:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3348:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3348:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3349:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalPureXbase7806);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop88;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3351:6: ( ( '|' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3352:1: ( '|' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3352:1: ( '|' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3353:2: '|'
        {
        match(input,42,FOLLOW_42_in_synpred22_InternalPureXbase7820); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred22_InternalPureXbase

    // $ANTLR start synpred23_InternalPureXbase
    public final void synpred23_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3420:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3421:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3421:1: ( ruleXClosure )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3422:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred23_InternalPureXbase7938);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred23_InternalPureXbase

    // $ANTLR start synpred24_InternalPureXbase
    public final void synpred24_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3617:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3617:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3617:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3617:5: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3617:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3618:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3618:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt91=2;
        int LA91_0 = input.LA(1);

        if ( (LA91_0==RULE_ID||LA91_0==39||LA91_0==69) ) {
            alt91=1;
        }
        switch (alt91) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3618:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3618:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3619:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3619:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3620:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred24_InternalPureXbase8429);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3622:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop90:
                do {
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==38) ) {
                        alt90=1;
                    }


                    switch (alt90) {
                	case 1 :
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3622:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,38,FOLLOW_38_in_synpred24_InternalPureXbase8436); if (state.failed) return ;
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3623:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3624:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3624:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3625:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred24_InternalPureXbase8443);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop90;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3627:6: ( ( '|' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3628:1: ( '|' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3628:1: ( '|' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3629:2: '|'
        {
        match(input,42,FOLLOW_42_in_synpred24_InternalPureXbase8457); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred24_InternalPureXbase

    // $ANTLR start synpred25_InternalPureXbase
    public final void synpred25_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3696:2: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3697:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3697:1: ( ruleXClosure )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3698:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred25_InternalPureXbase8573);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred25_InternalPureXbase

    // $ANTLR start synpred26_InternalPureXbase
    public final void synpred26_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4020:2: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4021:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4021:1: ( ruleXExpression )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4022:1: ruleXExpression
        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred26_InternalPureXbase9376);
        ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred26_InternalPureXbase

    // $ANTLR start synpred27_InternalPureXbase
    public final void synpred27_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4091:5: ( 'catch' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4091:7: 'catch'
        {
        match(input,68,FOLLOW_68_in_synpred27_InternalPureXbase9521); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalPureXbase

    // $ANTLR start synpred28_InternalPureXbase
    public final void synpred28_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4110:5: ( 'finally' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4110:7: 'finally'
        {
        match(input,67,FOLLOW_67_in_synpred28_InternalPureXbase9551); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalPureXbase

    // $ANTLR start synpred30_InternalPureXbase
    public final void synpred30_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4258:3: ( '.' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4259:2: '.'
        {
        match(input,35,FOLLOW_35_in_synpred30_InternalPureXbase9898); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalPureXbase

    // $ANTLR start synpred31_InternalPureXbase
    public final void synpred31_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4307:2: ( ( () '[' ']' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4307:3: ( () '[' ']' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4307:3: ( () '[' ']' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4307:4: () '[' ']'
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4307:4: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4308:1: 
        {
        }

        match(input,41,FOLLOW_41_in_synpred31_InternalPureXbase10050); if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred31_InternalPureXbase10054); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred31_InternalPureXbase

    // $ANTLR start synpred32_InternalPureXbase
    public final void synpred32_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4461:4: ( '<' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4461:6: '<'
        {
        match(input,24,FOLLOW_24_in_synpred32_InternalPureXbase10414); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_InternalPureXbase

    // Delegated rules

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
    public final boolean synpred19_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalPureXbase_fragment(); // can never throw exception
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
    public final boolean synpred21_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalPureXbase_fragment(); // can never throw exception
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


    protected DFA27 dfa27 = new DFA27(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA78 dfa78 = new DFA78(this);
    static final String DFA27_eotS =
        "\75\uffff";
    static final String DFA27_eofS =
        "\1\2\74\uffff";
    static final String DFA27_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA27_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA27_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA27_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA27_transitionS = {
            "\3\2\4\uffff\2\2\2\uffff\30\2\1\1\2\2\1\uffff\17\2\1\uffff\13"+
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
            return "1634:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_1 = input.LA(1);

                         
                        int index27_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index27_1);
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
    static final String DFA26_eotS =
        "\34\uffff";
    static final String DFA26_eofS =
        "\34\uffff";
    static final String DFA26_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA26_maxS =
        "\1\105\2\0\31\uffff";
    static final String DFA26_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA26_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA26_transitionS = {
            "\2\5\1\1\21\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5\uffff\1\2\1"+
            "\33\1\5\1\4\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5\3\uffff\3\5"+
            "\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
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
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "1655:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_0 = input.LA(1);

                         
                        int index26_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_0==RULE_ID) ) {s = 1;}

                        else if ( (LA26_0==39) ) {s = 2;}

                        else if ( (LA26_0==69) && (synpred14_InternalPureXbase())) {s = 3;}

                        else if ( (LA26_0==42) && (synpred14_InternalPureXbase())) {s = 4;}

                        else if ( ((LA26_0>=RULE_INT && LA26_0<=RULE_STRING)||LA26_0==24||(LA26_0>=27 && LA26_0<=28)||LA26_0==33||LA26_0==41||LA26_0==44||LA26_0==46||LA26_0==48||(LA26_0>=52 && LA26_0<=54)||LA26_0==57||(LA26_0>=59 && LA26_0<=66)) ) {s = 5;}

                        else if ( (LA26_0==40) ) {s = 27;}

                         
                        input.seek(index26_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_1 = input.LA(1);

                         
                        int index26_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index26_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA26_2 = input.LA(1);

                         
                        int index26_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index26_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA28_eotS =
        "\75\uffff";
    static final String DFA28_eofS =
        "\1\2\74\uffff";
    static final String DFA28_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA28_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA28_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA28_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA28_transitionS = {
            "\3\2\4\uffff\2\2\2\uffff\32\2\1\1\1\uffff\17\2\1\uffff\13\2",
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
            return "1734:3: ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_1 = input.LA(1);

                         
                        int index28_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index28_1);
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
    static final String DFA34_eotS =
        "\36\uffff";
    static final String DFA34_eofS =
        "\36\uffff";
    static final String DFA34_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA34_maxS =
        "\1\105\2\0\33\uffff";
    static final String DFA34_acceptS =
        "\3\uffff\2\1\1\2\30\uffff";
    static final String DFA34_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA34_transitionS = {
            "\2\5\1\1\21\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5\uffff\1\2\1"+
            "\uffff\1\5\1\4\2\5\1\uffff\1\5\1\uffff\1\5\3\uffff\6\5\1\uffff"+
            "\10\5\2\uffff\1\3",
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

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "2017:1: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_0 = input.LA(1);

                         
                        int index34_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA34_0==RULE_ID) ) {s = 1;}

                        else if ( (LA34_0==39) ) {s = 2;}

                        else if ( (LA34_0==69) && (synpred16_InternalPureXbase())) {s = 3;}

                        else if ( (LA34_0==42) && (synpred16_InternalPureXbase())) {s = 4;}

                        else if ( ((LA34_0>=RULE_INT && LA34_0<=RULE_STRING)||LA34_0==24||(LA34_0>=27 && LA34_0<=28)||LA34_0==33||LA34_0==41||(LA34_0>=43 && LA34_0<=44)||LA34_0==46||LA34_0==48||(LA34_0>=52 && LA34_0<=57)||(LA34_0>=59 && LA34_0<=66)) ) {s = 5;}

                         
                        input.seek(index34_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA34_1 = input.LA(1);

                         
                        int index34_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index34_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA34_2 = input.LA(1);

                         
                        int index34_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index34_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA57_eotS =
        "\75\uffff";
    static final String DFA57_eofS =
        "\1\2\74\uffff";
    static final String DFA57_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA57_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA57_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA57_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA57_transitionS = {
            "\3\2\4\uffff\2\2\2\uffff\30\2\1\1\2\2\1\uffff\17\2\1\uffff\13"+
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
            ""
    };

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "3320:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA57_1 = input.LA(1);

                         
                        int index57_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index57_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 57, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA56_eotS =
        "\34\uffff";
    static final String DFA56_eofS =
        "\34\uffff";
    static final String DFA56_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA56_maxS =
        "\1\105\2\0\31\uffff";
    static final String DFA56_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA56_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA56_transitionS = {
            "\2\5\1\1\21\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5\uffff\1\2\1"+
            "\33\1\5\1\4\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5\3\uffff\3\5"+
            "\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
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
            ""
    };

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "3341:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA56_0 = input.LA(1);

                         
                        int index56_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA56_0==RULE_ID) ) {s = 1;}

                        else if ( (LA56_0==39) ) {s = 2;}

                        else if ( (LA56_0==69) && (synpred22_InternalPureXbase())) {s = 3;}

                        else if ( (LA56_0==42) && (synpred22_InternalPureXbase())) {s = 4;}

                        else if ( ((LA56_0>=RULE_INT && LA56_0<=RULE_STRING)||LA56_0==24||(LA56_0>=27 && LA56_0<=28)||LA56_0==33||LA56_0==41||LA56_0==44||LA56_0==46||LA56_0==48||(LA56_0>=52 && LA56_0<=54)||LA56_0==57||(LA56_0>=59 && LA56_0<=66)) ) {s = 5;}

                        else if ( (LA56_0==40) ) {s = 27;}

                         
                        input.seek(index56_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA56_1 = input.LA(1);

                         
                        int index56_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index56_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA56_2 = input.LA(1);

                         
                        int index56_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index56_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 56, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA58_eotS =
        "\75\uffff";
    static final String DFA58_eofS =
        "\1\2\74\uffff";
    static final String DFA58_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA58_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA58_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA58_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA58_transitionS = {
            "\3\2\4\uffff\2\2\2\uffff\32\2\1\1\1\uffff\17\2\1\uffff\13\2",
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
            ""
    };

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "3420:3: ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_1 = input.LA(1);

                         
                        int index58_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 58, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA64_eotS =
        "\34\uffff";
    static final String DFA64_eofS =
        "\34\uffff";
    static final String DFA64_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA64_maxS =
        "\1\105\2\0\31\uffff";
    static final String DFA64_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA64_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA64_transitionS = {
            "\2\5\1\1\21\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5\uffff\1\2\1"+
            "\33\1\5\1\4\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5\3\uffff\3\5"+
            "\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
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
            ""
    };

    static final short[] DFA64_eot = DFA.unpackEncodedString(DFA64_eotS);
    static final short[] DFA64_eof = DFA.unpackEncodedString(DFA64_eofS);
    static final char[] DFA64_min = DFA.unpackEncodedStringToUnsignedChars(DFA64_minS);
    static final char[] DFA64_max = DFA.unpackEncodedStringToUnsignedChars(DFA64_maxS);
    static final short[] DFA64_accept = DFA.unpackEncodedString(DFA64_acceptS);
    static final short[] DFA64_special = DFA.unpackEncodedString(DFA64_specialS);
    static final short[][] DFA64_transition;

    static {
        int numStates = DFA64_transitionS.length;
        DFA64_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA64_transition[i] = DFA.unpackEncodedString(DFA64_transitionS[i]);
        }
    }

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = DFA64_eot;
            this.eof = DFA64_eof;
            this.min = DFA64_min;
            this.max = DFA64_max;
            this.accept = DFA64_accept;
            this.special = DFA64_special;
            this.transition = DFA64_transition;
        }
        public String getDescription() {
            return "3617:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA64_0 = input.LA(1);

                         
                        int index64_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA64_0==RULE_ID) ) {s = 1;}

                        else if ( (LA64_0==39) ) {s = 2;}

                        else if ( (LA64_0==69) && (synpred24_InternalPureXbase())) {s = 3;}

                        else if ( (LA64_0==42) && (synpred24_InternalPureXbase())) {s = 4;}

                        else if ( ((LA64_0>=RULE_INT && LA64_0<=RULE_STRING)||LA64_0==24||(LA64_0>=27 && LA64_0<=28)||LA64_0==33||LA64_0==41||LA64_0==44||LA64_0==46||LA64_0==48||(LA64_0>=52 && LA64_0<=54)||LA64_0==57||(LA64_0>=59 && LA64_0<=66)) ) {s = 5;}

                        else if ( (LA64_0==40) ) {s = 27;}

                         
                        input.seek(index64_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA64_1 = input.LA(1);

                         
                        int index64_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index64_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA64_2 = input.LA(1);

                         
                        int index64_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index64_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 64, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA65_eotS =
        "\75\uffff";
    static final String DFA65_eofS =
        "\1\2\74\uffff";
    static final String DFA65_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA65_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA65_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA65_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA65_transitionS = {
            "\3\2\4\uffff\2\2\2\uffff\32\2\1\1\1\uffff\17\2\1\uffff\13\2",
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
            return "3696:1: ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
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
                        if ( (synpred25_InternalPureXbase()) ) {s = 60;}

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
    static final String DFA67_eotS =
        "\75\uffff";
    static final String DFA67_eofS =
        "\1\31\74\uffff";
    static final String DFA67_minS =
        "\1\4\30\0\44\uffff";
    static final String DFA67_maxS =
        "\1\105\30\0\44\uffff";
    static final String DFA67_acceptS =
        "\31\uffff\1\2\42\uffff\1\1";
    static final String DFA67_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\44\uffff}>";
    static final String[] DFA67_transitionS = {
            "\1\15\1\17\1\1\4\uffff\2\31\2\uffff\11\31\1\10\2\31\1\4\1\3"+
            "\4\31\1\2\5\31\1\30\1\31\1\12\1\uffff\1\31\1\21\1\31\1\7\1\31"+
            "\1\6\3\31\1\22\1\23\1\24\2\31\1\11\1\uffff\1\5\1\13\1\14\1\16"+
            "\1\20\1\25\1\26\1\27\3\31",
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
            return "4020:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_1 = input.LA(1);

                         
                        int index67_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA67_2 = input.LA(1);

                         
                        int index67_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA67_3 = input.LA(1);

                         
                        int index67_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA67_4 = input.LA(1);

                         
                        int index67_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA67_5 = input.LA(1);

                         
                        int index67_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA67_6 = input.LA(1);

                         
                        int index67_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA67_7 = input.LA(1);

                         
                        int index67_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA67_8 = input.LA(1);

                         
                        int index67_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA67_9 = input.LA(1);

                         
                        int index67_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA67_10 = input.LA(1);

                         
                        int index67_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA67_11 = input.LA(1);

                         
                        int index67_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA67_12 = input.LA(1);

                         
                        int index67_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA67_13 = input.LA(1);

                         
                        int index67_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA67_14 = input.LA(1);

                         
                        int index67_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA67_15 = input.LA(1);

                         
                        int index67_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA67_16 = input.LA(1);

                         
                        int index67_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA67_17 = input.LA(1);

                         
                        int index67_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA67_18 = input.LA(1);

                         
                        int index67_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA67_19 = input.LA(1);

                         
                        int index67_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA67_20 = input.LA(1);

                         
                        int index67_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA67_21 = input.LA(1);

                         
                        int index67_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA67_22 = input.LA(1);

                         
                        int index67_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA67_23 = input.LA(1);

                         
                        int index67_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA67_24 = input.LA(1);

                         
                        int index67_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_24);
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
    static final String DFA78_eotS =
        "\75\uffff";
    static final String DFA78_eofS =
        "\1\2\74\uffff";
    static final String DFA78_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA78_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA78_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA78_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA78_transitionS = {
            "\3\2\4\uffff\2\2\2\uffff\11\2\1\1\21\2\1\uffff\17\2\1\uffff"+
            "\13\2",
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
            ""
    };

    static final short[] DFA78_eot = DFA.unpackEncodedString(DFA78_eotS);
    static final short[] DFA78_eof = DFA.unpackEncodedString(DFA78_eofS);
    static final char[] DFA78_min = DFA.unpackEncodedStringToUnsignedChars(DFA78_minS);
    static final char[] DFA78_max = DFA.unpackEncodedStringToUnsignedChars(DFA78_maxS);
    static final short[] DFA78_accept = DFA.unpackEncodedString(DFA78_acceptS);
    static final short[] DFA78_special = DFA.unpackEncodedString(DFA78_specialS);
    static final short[][] DFA78_transition;

    static {
        int numStates = DFA78_transitionS.length;
        DFA78_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA78_transition[i] = DFA.unpackEncodedString(DFA78_transitionS[i]);
        }
    }

    class DFA78 extends DFA {

        public DFA78(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 78;
            this.eot = DFA78_eot;
            this.eof = DFA78_eof;
            this.min = DFA78_min;
            this.max = DFA78_max;
            this.accept = DFA78_accept;
            this.special = DFA78_special;
            this.transition = DFA78_transition;
        }
        public String getDescription() {
            return "4461:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA78_1 = input.LA(1);

                         
                        int index78_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index78_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 78, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialBlockExpression_in_ruleModel130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialBlockExpression_in_entryRuleSpecialBlockExpression165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecialBlockExpression175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleSpecialBlockExpression232 = new BitSet(new long[]{0xFBF1528219001872L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleImport_in_ruleSpecialBlockExpression259 = new BitSet(new long[]{0xFBF1528219001872L,0x0000000000000007L});
    public static final BitSet FOLLOW_11_in_ruleSpecialBlockExpression273 = new BitSet(new long[]{0xFBF1528219001872L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleImport360 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard476 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedNameWithWildCard495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAssignment695 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment711 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment761 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment814 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOpSingleAssign925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleOpMultiAssign1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1052 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1109 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression1162 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1185 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr1224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleOpOr1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1368 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression1421 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1444 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd1483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleOpAnd1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression1570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1627 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1680 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1703 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality1742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleOpEquality1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleOpEquality1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression1850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1907 = new BitSet(new long[]{0x0000000001F00002L});
    public static final BitSet FOLLOW_20_in_ruleXRelationalExpression1943 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression1966 = new BitSet(new long[]{0x0000000001F00002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2027 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2050 = new BitSet(new long[]{0x0000000001F00002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare2090 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare2101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOpCompare2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpCompare2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpCompare2177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpCompare2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2236 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2293 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2346 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2369 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther2408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther2419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpOther2457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpOther2476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression2526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2573 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression2626 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2649 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd2688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpAdd2737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpAdd2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression2796 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression2806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2853 = new BitSet(new long[]{0x00000001E0000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression2906 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2929 = new BitSet(new long[]{0x00000001E0000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti2968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti2979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpMulti3017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpMulti3036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpMulti3055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpMulti3074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3182 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary3268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary3279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpUnary3317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpUnary3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpUnary3355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression3405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3452 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleXCastedExpression3487 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3510 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3548 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall3558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall3605 = new BitSet(new long[]{0x0000003800000002L});
    public static final BitSet FOLLOW_35_in_ruleXMemberFeatureCall3654 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3677 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall3693 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall3715 = new BitSet(new long[]{0x0000003800000002L});
    public static final BitSet FOLLOW_35_in_ruleXMemberFeatureCall3801 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_36_in_ruleXMemberFeatureCall3825 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_37_in_ruleXMemberFeatureCall3862 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_24_in_ruleXMemberFeatureCall3891 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall3912 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_38_in_ruleXMemberFeatureCall3925 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall3946 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_23_in_ruleXMemberFeatureCall3960 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3985 = new BitSet(new long[]{0x000002B800000002L});
    public static final BitSet FOLLOW_39_in_ruleXMemberFeatureCall4019 = new BitSet(new long[]{0xFBF1578219000070L,0x0000000000000027L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4104 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4132 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_38_in_ruleXMemberFeatureCall4145 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4166 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_40_in_ruleXMemberFeatureCall4183 = new BitSet(new long[]{0x0000023800000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4216 = new BitSet(new long[]{0x0000003800000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression4266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression4394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression4421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression4475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression4583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral4672 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral4682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral4729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral4756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXLiteral4783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral4810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral4837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral4864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure4899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure4909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleXClosure4955 = new BitSet(new long[]{0xFBF15E8219000070L,0x0000000000000027L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5026 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_38_in_ruleXClosure5039 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5060 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_ruleXClosure5082 = new BitSet(new long[]{0xFBF15A8219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5119 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXClosure5131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInClosure5177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5233 = new BitSet(new long[]{0xFBF1528219000872L,0x0000000000000007L});
    public static final BitSet FOLLOW_11_in_ruleXExpressionInClosure5246 = new BitSet(new long[]{0xFBF1528219000072L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure5296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5404 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_38_in_ruleXShortClosure5417 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5438 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_ruleXShortClosure5460 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure5496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression5542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleXParenthesizedExpression5579 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5601 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXParenthesizedExpression5612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5648 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression5658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleXIfExpression5704 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXIfExpression5716 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5737 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXIfExpression5749 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5770 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleXIfExpression5791 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression5851 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression5861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleXSwitchExpression5907 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression5948 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXSwitchExpression5960 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression5984 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXSwitchExpression5996 = new BitSet(new long[]{0x0008808000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6017 = new BitSet(new long[]{0x000E808000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_49_in_ruleXSwitchExpression6031 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXSwitchExpression6043 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6064 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleXSwitchExpression6078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6170 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_51_in_ruleXCasePart6184 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6205 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXCasePart6219 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression6286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXForLoopExpression6332 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXForLoopExpression6344 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6365 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXForLoopExpression6377 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6398 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXForLoopExpression6410 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression6477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleXWhileExpression6523 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXWhileExpression6535 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression6556 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXWhileExpression6568 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression6589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression6625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression6635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXDoWhileExpression6681 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6702 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleXDoWhileExpression6714 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXDoWhileExpression6726 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6747 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXDoWhileExpression6759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression6795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression6805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleXBlockExpression6851 = new BitSet(new long[]{0xFBF5528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression6873 = new BitSet(new long[]{0xFBF5528219000870L,0x0000000000000007L});
    public static final BitSet FOLLOW_11_in_ruleXBlockExpression6886 = new BitSet(new long[]{0xFBF5528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_50_in_ruleXBlockExpression6902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock6938 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock6948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock6995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7057 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXVariableDeclaration7120 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_56_in_ruleXVariableDeclaration7151 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7199 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7220 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7249 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleXVariableDeclaration7263 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter7332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7378 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter7400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter7436 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFullJvmFormalParameter7446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter7492 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter7513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall7559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall7616 = new BitSet(new long[]{0x0200000001000040L});
    public static final BitSet FOLLOW_24_in_ruleXFeatureCall7630 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7651 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_38_in_ruleXFeatureCall7664 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7685 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_23_in_ruleXFeatureCall7699 = new BitSet(new long[]{0x0200000001000040L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall7724 = new BitSet(new long[]{0x0000028000000002L});
    public static final BitSet FOLLOW_39_in_ruleXFeatureCall7758 = new BitSet(new long[]{0xFBF1578219000070L,0x0000000000000027L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall7843 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall7871 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_38_in_ruleXFeatureCall7884 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall7905 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_40_in_ruleXFeatureCall7922 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXFeatureCall7955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper7993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper8004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleIdOrSuper8051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleIdOrSuper8075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier8127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier8174 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleStaticQualifier8192 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall8243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleXConstructorCall8289 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8312 = new BitSet(new long[]{0x0000008001000000L});
    public static final BitSet FOLLOW_24_in_ruleXConstructorCall8325 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8346 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_38_in_ruleXConstructorCall8359 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8380 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_23_in_ruleXConstructorCall8394 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXConstructorCall8408 = new BitSet(new long[]{0xFBF1578219000070L,0x0000000000000027L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8480 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8508 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_38_in_ruleXConstructorCall8521 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8542 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_40_in_ruleXConstructorCall8559 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXConstructorCall8590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral8637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleXBooleanLiteral8684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXBooleanLiteral8708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8758 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral8768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXNullLiteral8814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral8850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral8860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral8911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral8952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral8962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral9013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral9064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXTypeLiteral9110 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXTypeLiteral9122 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9145 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXTypeLiteral9157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression9203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleXThrowExpression9249 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression9270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression9316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXReturnExpression9362 = new BitSet(new long[]{0xFBF1528219000072L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression9393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXTryCatchFinallyExpression9486 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9507 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9537 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_67_in_ruleXTryCatchFinallyExpression9559 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXTryCatchFinallyExpression9603 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause9672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXCatchClause9717 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXCatchClause9730 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause9751 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXCatchClause9763 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause9784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName9832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName9879 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleQualifiedName9907 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName9930 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference9977 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference9987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10035 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleJvmTypeReference10073 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleJvmTypeReference10085 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef10162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleXFunctionTypeRef10200 = new BitSet(new long[]{0x0000018000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10222 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_38_in_ruleXFunctionTypeRef10235 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10256 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_40_in_ruleXFunctionTypeRef10272 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleXFunctionTypeRef10286 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference10343 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference10353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference10401 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleJvmParameterizedTypeReference10422 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10444 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_38_in_ruleJvmParameterizedTypeReference10457 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10478 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_23_in_ruleJvmParameterizedTypeReference10492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference10530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference10540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference10587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference10614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference10649 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference10659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleJvmWildcardTypeReference10705 = new BitSet(new long[]{0x0200000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference10727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference10754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound10792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound10802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleJvmUpperBound10839 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound10860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded10896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded10906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleJvmUpperBoundAnded10943 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded10964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11000 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound11010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleJvmLowerBound11047 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID11107 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID11118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID11157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred1_InternalPureXbase782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalPureXbase1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalPureXbase1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalPureXbase1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_synpred5_InternalPureXbase1924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred6_InternalPureXbase1995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred7_InternalPureXbase2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred8_InternalPureXbase2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred9_InternalPureXbase2874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred10_InternalPureXbase3468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred11_InternalPureXbase3622 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred11_InternalPureXbase3631 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred11_InternalPureXbase3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred12_InternalPureXbase3740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_synpred12_InternalPureXbase3754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_synpred12_InternalPureXbase3774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred13_InternalPureXbase4001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalPureXbase4053 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_38_in_synpred14_InternalPureXbase4060 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalPureXbase4067 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_synpred14_InternalPureXbase4081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred15_InternalPureXbase4199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalPureXbase4972 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_38_in_synpred16_InternalPureXbase4979 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalPureXbase4986 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_synpred16_InternalPureXbase5000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred18_InternalPureXbase5783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred19_InternalPureXbase5923 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_synpred19_InternalPureXbase5929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred20_InternalPureXbase7169 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred20_InternalPureXbase7178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred21_InternalPureXbase7740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalPureXbase7792 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_38_in_synpred22_InternalPureXbase7799 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalPureXbase7806 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_synpred22_InternalPureXbase7820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred23_InternalPureXbase7938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred24_InternalPureXbase8429 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_38_in_synpred24_InternalPureXbase8436 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred24_InternalPureXbase8443 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_synpred24_InternalPureXbase8457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred25_InternalPureXbase8573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred26_InternalPureXbase9376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_synpred27_InternalPureXbase9521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_synpred28_InternalPureXbase9551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred30_InternalPureXbase9898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred31_InternalPureXbase10050 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred31_InternalPureXbase10054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_synpred32_InternalPureXbase10414 = new BitSet(new long[]{0x0000000000000002L});

}