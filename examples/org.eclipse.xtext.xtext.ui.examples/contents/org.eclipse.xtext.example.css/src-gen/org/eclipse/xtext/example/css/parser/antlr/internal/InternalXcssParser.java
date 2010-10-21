package org.eclipse.xtext.example.css.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.example.css.services.XcssGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalXcssParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'*'", "'['", "']'", "';'", "':'", "'font'", "'I'", "'B'", "'#'", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'**'", "'/'", "'%'", "'!'", "'.'", "','", "'('", "')'", "'|'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'='", "'new'", "'false'", "'true'", "'null'", "'class'", "'throw'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'extends'", "'&'", "'super'", "'em'", "'pt'", "'px'"
    };
    public static final int T__42=42;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__57=57;
    public static final int T__23=23;
    public static final int T__51=51;
    public static final int T__13=13;
    public static final int RULE_STRING=5;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__19=19;
    public static final int T__70=70;
    public static final int T__67=67;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__68=68;
    public static final int T__17=17;
    public static final int T__62=62;
    public static final int RULE_INT=6;
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
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__66=66;
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
    public static final int T__71=71;
    public static final int T__18=18;

    // delegates
    // delegators


        public InternalXcssParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXcssParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXcssParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private XcssGrammarAccess grammarAccess;
     	
        public InternalXcssParser(TokenStream input, IAstFactory factory, XcssGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "StyleSheet";	
       	}
       	
       	@Override
       	protected XcssGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleStyleSheet"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:79:1: entryRuleStyleSheet returns [EObject current=null] : iv_ruleStyleSheet= ruleStyleSheet EOF ;
    public final EObject entryRuleStyleSheet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStyleSheet = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:80:2: (iv_ruleStyleSheet= ruleStyleSheet EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:81:2: iv_ruleStyleSheet= ruleStyleSheet EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStyleSheetRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStyleSheet_in_entryRuleStyleSheet81);
            iv_ruleStyleSheet=ruleStyleSheet();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStyleSheet; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStyleSheet91); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStyleSheet"


    // $ANTLR start "ruleStyleSheet"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:88:1: ruleStyleSheet returns [EObject current=null] : ( (lv_rules_0_0= ruleStyleRule ) )* ;
    public final EObject ruleStyleSheet() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:93:6: ( ( (lv_rules_0_0= ruleStyleRule ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:94:1: ( (lv_rules_0_0= ruleStyleRule ) )*
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:94:1: ( (lv_rules_0_0= ruleStyleRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:95:1: (lv_rules_0_0= ruleStyleRule )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:95:1: (lv_rules_0_0= ruleStyleRule )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:96:3: lv_rules_0_0= ruleStyleRule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getStyleSheetAccess().getRulesStyleRuleParserRuleCall_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStyleRule_in_ruleStyleSheet136);
            	    lv_rules_0_0=ruleStyleRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getStyleSheetRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"rules",
            	      	        		lv_rules_0_0, 
            	      	        		"StyleRule", 
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
    // $ANTLR end "ruleStyleSheet"


    // $ANTLR start "entryRuleStyleRule"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:126:1: entryRuleStyleRule returns [EObject current=null] : iv_ruleStyleRule= ruleStyleRule EOF ;
    public final EObject entryRuleStyleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStyleRule = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:127:2: (iv_ruleStyleRule= ruleStyleRule EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:128:2: iv_ruleStyleRule= ruleStyleRule EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStyleRuleRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStyleRule_in_entryRuleStyleRule172);
            iv_ruleStyleRule=ruleStyleRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStyleRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStyleRule182); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStyleRule"


    // $ANTLR start "ruleStyleRule"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:135:1: ruleStyleRule returns [EObject current=null] : ( ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )+ otherlv_3= '}' ) ;
    public final EObject ruleStyleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_selectors_0_0 = null;

        EObject lv_settings_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:140:6: ( ( ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:141:1: ( ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:141:1: ( ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )+ otherlv_3= '}' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:141:2: ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )+ otherlv_3= '}'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:141:2: ( (lv_selectors_0_0= ruleSelector ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:142:1: (lv_selectors_0_0= ruleSelector )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:142:1: (lv_selectors_0_0= ruleSelector )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:143:3: lv_selectors_0_0= ruleSelector
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getStyleRuleAccess().getSelectorsSelectorParserRuleCall_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSelector_in_ruleStyleRule228);
            	    lv_selectors_0_0=ruleSelector();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getStyleRuleRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"selectors",
            	      	        		lv_selectors_0_0, 
            	      	        		"Selector", 
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
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleStyleRule241); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getStyleRuleAccess().getLeftCurlyBracketKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:169:1: ( (lv_settings_2_0= ruleSetting ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:170:1: (lv_settings_2_0= ruleSetting )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:170:1: (lv_settings_2_0= ruleSetting )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:171:3: lv_settings_2_0= ruleSetting
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getStyleRuleAccess().getSettingsSettingParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSetting_in_ruleStyleRule262);
            	    lv_settings_2_0=ruleSetting();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getStyleRuleRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"settings",
            	      	        		lv_settings_2_0, 
            	      	        		"Setting", 
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
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleStyleRule275); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getStyleRuleAccess().getRightCurlyBracketKeyword_3(), null);
                  
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
    // $ANTLR end "ruleStyleRule"


    // $ANTLR start "entryRuleSelector"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:205:1: entryRuleSelector returns [EObject current=null] : iv_ruleSelector= ruleSelector EOF ;
    public final EObject entryRuleSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelector = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:206:2: (iv_ruleSelector= ruleSelector EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:207:2: iv_ruleSelector= ruleSelector EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSelectorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSelector_in_entryRuleSelector311);
            iv_ruleSelector=ruleSelector();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelector; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelector321); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelector"


    // $ANTLR start "ruleSelector"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:214:1: ruleSelector returns [EObject current=null] : ( (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector ) ( (lv_filter_2_0= ruleFilter ) )? ) ;
    public final EObject ruleSelector() throws RecognitionException {
        EObject current = null;

        EObject this_TypeSelector_0 = null;

        EObject this_WildcardSelector_1 = null;

        EObject lv_filter_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:219:6: ( ( (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector ) ( (lv_filter_2_0= ruleFilter ) )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:220:1: ( (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector ) ( (lv_filter_2_0= ruleFilter ) )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:220:1: ( (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector ) ( (lv_filter_2_0= ruleFilter ) )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:220:2: (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector ) ( (lv_filter_2_0= ruleFilter ) )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:220:2: (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==13) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:221:2: this_TypeSelector_0= ruleTypeSelector
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getSelectorAccess().getTypeSelectorParserRuleCall_0_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeSelector_in_ruleSelector372);
                    this_TypeSelector_0=ruleTypeSelector();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeSelector_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:234:2: this_WildcardSelector_1= ruleWildcardSelector
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getSelectorAccess().getWildcardSelectorParserRuleCall_0_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleWildcardSelector_in_ruleSelector402);
                    this_WildcardSelector_1=ruleWildcardSelector();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_WildcardSelector_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:245:2: ( (lv_filter_2_0= ruleFilter ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:246:1: (lv_filter_2_0= ruleFilter )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:246:1: (lv_filter_2_0= ruleFilter )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:247:3: lv_filter_2_0= ruleFilter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSelectorAccess().getFilterFilterParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFilter_in_ruleSelector423);
                    lv_filter_2_0=ruleFilter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSelectorRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"filter",
                      	        		lv_filter_2_0, 
                      	        		"Filter", 
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
    // $ANTLR end "ruleSelector"


    // $ANTLR start "entryRuleTypeSelector"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:279:1: entryRuleTypeSelector returns [EObject current=null] : iv_ruleTypeSelector= ruleTypeSelector EOF ;
    public final EObject entryRuleTypeSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeSelector = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:280:2: (iv_ruleTypeSelector= ruleTypeSelector EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:281:2: iv_ruleTypeSelector= ruleTypeSelector EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeSelectorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeSelector_in_entryRuleTypeSelector462);
            iv_ruleTypeSelector=ruleTypeSelector();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeSelector; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeSelector472); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeSelector"


    // $ANTLR start "ruleTypeSelector"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:288:1: ruleTypeSelector returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleTypeSelector() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:293:6: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:294:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:294:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:295:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:295:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:296:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getTypeSelectorRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTypeSelectorAccess().getTypeJvmTypeCrossReference_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeSelector523);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
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
        }
        return current;
    }
    // $ANTLR end "ruleTypeSelector"


    // $ANTLR start "entryRuleWildcardSelector"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:321:1: entryRuleWildcardSelector returns [EObject current=null] : iv_ruleWildcardSelector= ruleWildcardSelector EOF ;
    public final EObject entryRuleWildcardSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardSelector = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:322:2: (iv_ruleWildcardSelector= ruleWildcardSelector EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:323:2: iv_ruleWildcardSelector= ruleWildcardSelector EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getWildcardSelectorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleWildcardSelector_in_entryRuleWildcardSelector558);
            iv_ruleWildcardSelector=ruleWildcardSelector();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardSelector; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcardSelector568); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWildcardSelector"


    // $ANTLR start "ruleWildcardSelector"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:330:1: ruleWildcardSelector returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleWildcardSelector() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:335:6: ( ( () otherlv_1= '*' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:336:1: ( () otherlv_1= '*' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:336:1: ( () otherlv_1= '*' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:336:2: () otherlv_1= '*'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:336:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:337:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getWildcardSelectorAccess().getWildcardSelectorAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getWildcardSelectorAccess().getWildcardSelectorAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleWildcardSelector617); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getWildcardSelectorAccess().getAsteriskKeyword_1(), null);
                  
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
    // $ANTLR end "ruleWildcardSelector"


    // $ANTLR start "entryRuleFilter"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:362:1: entryRuleFilter returns [EObject current=null] : iv_ruleFilter= ruleFilter EOF ;
    public final EObject entryRuleFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilter = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:363:2: (iv_ruleFilter= ruleFilter EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:364:2: iv_ruleFilter= ruleFilter EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFilterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFilter_in_entryRuleFilter653);
            iv_ruleFilter=ruleFilter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFilter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFilter663); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFilter"


    // $ANTLR start "ruleFilter"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:371:1: ruleFilter returns [EObject current=null] : (otherlv_0= '[' ( (lv_condition_1_0= ruleXExpression ) ) otherlv_2= ']' ) ;
    public final EObject ruleFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:376:6: ( (otherlv_0= '[' ( (lv_condition_1_0= ruleXExpression ) ) otherlv_2= ']' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:377:1: (otherlv_0= '[' ( (lv_condition_1_0= ruleXExpression ) ) otherlv_2= ']' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:377:1: (otherlv_0= '[' ( (lv_condition_1_0= ruleXExpression ) ) otherlv_2= ']' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:377:3: otherlv_0= '[' ( (lv_condition_1_0= ruleXExpression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleFilter700); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getFilterAccess().getLeftSquareBracketKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:381:1: ( (lv_condition_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:382:1: (lv_condition_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:382:1: (lv_condition_1_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:383:3: lv_condition_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getFilterAccess().getConditionXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleFilter721);
            lv_condition_1_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getFilterRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"condition",
              	        		lv_condition_1_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleFilter733); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getFilterAccess().getRightSquareBracketKeyword_2(), null);
                  
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
    // $ANTLR end "ruleFilter"


    // $ANTLR start "entryRuleSetting"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:417:1: entryRuleSetting returns [EObject current=null] : iv_ruleSetting= ruleSetting EOF ;
    public final EObject entryRuleSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetting = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:418:2: (iv_ruleSetting= ruleSetting EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:419:2: iv_ruleSetting= ruleSetting EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSettingRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSetting_in_entryRuleSetting769);
            iv_ruleSetting=ruleSetting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetting; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSetting779); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetting"


    // $ANTLR start "ruleSetting"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:426:1: ruleSetting returns [EObject current=null] : ( () ( (lv_params_1_0= ruleFeatureReference ) ) ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXExpression ) ) otherlv_4= ';' ) ;
    public final EObject ruleSetting() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        EObject lv_params_1_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:431:6: ( ( () ( (lv_params_1_0= ruleFeatureReference ) ) ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXExpression ) ) otherlv_4= ';' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:432:1: ( () ( (lv_params_1_0= ruleFeatureReference ) ) ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXExpression ) ) otherlv_4= ';' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:432:1: ( () ( (lv_params_1_0= ruleFeatureReference ) ) ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXExpression ) ) otherlv_4= ';' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:432:2: () ( (lv_params_1_0= ruleFeatureReference ) ) ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXExpression ) ) otherlv_4= ';'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:432:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:433:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getSettingAccess().getSettingAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getSettingAccess().getSettingAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:446:2: ( (lv_params_1_0= ruleFeatureReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:447:1: (lv_params_1_0= ruleFeatureReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:447:1: (lv_params_1_0= ruleFeatureReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:448:3: lv_params_1_0= ruleFeatureReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getSettingAccess().getParamsFeatureReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleFeatureReference_in_ruleSetting837);
            lv_params_1_0=ruleFeatureReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSettingRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		add(
              	       			current, 
              	       			"params",
              	        		lv_params_1_0, 
              	        		"FeatureReference", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:470:2: ( ( ruleOpAssign ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:471:1: ( ruleOpAssign )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:471:1: ( ruleOpAssign )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:472:3: ruleOpAssign
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getSettingRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getSettingAccess().getFeatureJvmIdentifyableElementCrossReference_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOpAssign_in_ruleSetting864);
            ruleOpAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:489:2: ( (lv_params_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:490:1: (lv_params_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:490:1: (lv_params_3_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:491:3: lv_params_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getSettingAccess().getParamsXExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleSetting885);
            lv_params_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSettingRule().getType().getClassifier());
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleSetting897); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_4, grammarAccess.getSettingAccess().getSemicolonKeyword_4(), null);
                  
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
    // $ANTLR end "ruleSetting"


    // $ANTLR start "entryRuleOpAssign"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:525:1: entryRuleOpAssign returns [String current=null] : iv_ruleOpAssign= ruleOpAssign EOF ;
    public final String entryRuleOpAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAssign = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:526:2: (iv_ruleOpAssign= ruleOpAssign EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:527:2: iv_ruleOpAssign= ruleOpAssign EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAssignRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAssign_in_entryRuleOpAssign934);
            iv_ruleOpAssign=ruleOpAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAssign945); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAssign"


    // $ANTLR start "ruleOpAssign"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:534:1: ruleOpAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= ':' ;
    public final AntlrDatatypeRuleToken ruleOpAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:539:6: (kw= ':' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:541:2: kw= ':'
            {
            kw=(Token)match(input,17,FOLLOW_17_in_ruleOpAssign982); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(kw, grammarAccess.getOpAssignAccess().getColonKeyword(), null); 
                  
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
    // $ANTLR end "ruleOpAssign"


    // $ANTLR start "entryRuleFeatureReference"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:554:1: entryRuleFeatureReference returns [EObject current=null] : iv_ruleFeatureReference= ruleFeatureReference EOF ;
    public final EObject entryRuleFeatureReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:555:2: (iv_ruleFeatureReference= ruleFeatureReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:556:2: iv_ruleFeatureReference= ruleFeatureReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFeatureReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFeatureReference_in_entryRuleFeatureReference1021);
            iv_ruleFeatureReference=ruleFeatureReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureReference1031); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureReference"


    // $ANTLR start "ruleFeatureReference"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:563:1: ruleFeatureReference returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFeatureReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:568:6: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:569:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:569:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:570:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:570:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:571:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getFeatureReferenceRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureReference1079); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		createLeafNode(otherlv_0, grammarAccess.getFeatureReferenceAccess().getFeatureJvmIdentifyableElementCrossReference_0(), "feature"); 
              	
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
    // $ANTLR end "ruleFeatureReference"


    // $ANTLR start "entryRuleCssLiterals"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:594:1: entryRuleCssLiterals returns [EObject current=null] : iv_ruleCssLiterals= ruleCssLiterals EOF ;
    public final EObject entryRuleCssLiterals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCssLiterals = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:595:2: (iv_ruleCssLiterals= ruleCssLiterals EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:596:2: iv_ruleCssLiterals= ruleCssLiterals EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCssLiteralsRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCssLiterals_in_entryRuleCssLiterals1114);
            iv_ruleCssLiterals=ruleCssLiterals();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCssLiterals; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCssLiterals1124); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCssLiterals"


    // $ANTLR start "ruleCssLiterals"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:603:1: ruleCssLiterals returns [EObject current=null] : (this_FontLiteral_0= ruleFontLiteral | this_ColorLiteral_1= ruleColorLiteral | this_SizeLiteral_2= ruleSizeLiteral ) ;
    public final EObject ruleCssLiterals() throws RecognitionException {
        EObject current = null;

        EObject this_FontLiteral_0 = null;

        EObject this_ColorLiteral_1 = null;

        EObject this_SizeLiteral_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:608:6: ( (this_FontLiteral_0= ruleFontLiteral | this_ColorLiteral_1= ruleColorLiteral | this_SizeLiteral_2= ruleSizeLiteral ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:609:1: (this_FontLiteral_0= ruleFontLiteral | this_ColorLiteral_1= ruleColorLiteral | this_SizeLiteral_2= ruleSizeLiteral )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:609:1: (this_FontLiteral_0= ruleFontLiteral | this_ColorLiteral_1= ruleColorLiteral | this_SizeLiteral_2= ruleSizeLiteral )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case 18:
                {
                alt6=1;
                }
                break;
            case RULE_ID:
                {
                int LA6_2 = input.LA(2);

                if ( (synpred6_InternalXcss()) ) {
                    alt6=1;
                }
                else if ( (synpred7_InternalXcss()) ) {
                    alt6=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                alt6=2;
                }
                break;
            case RULE_INT:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:610:2: this_FontLiteral_0= ruleFontLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getCssLiteralsAccess().getFontLiteralParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleFontLiteral_in_ruleCssLiterals1174);
                    this_FontLiteral_0=ruleFontLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FontLiteral_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:623:2: this_ColorLiteral_1= ruleColorLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getCssLiteralsAccess().getColorLiteralParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleColorLiteral_in_ruleCssLiterals1204);
                    this_ColorLiteral_1=ruleColorLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ColorLiteral_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:636:2: this_SizeLiteral_2= ruleSizeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getCssLiteralsAccess().getSizeLiteralParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleSizeLiteral_in_ruleCssLiterals1234);
                    this_SizeLiteral_2=ruleSizeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SizeLiteral_2; 
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
        }
        return current;
    }
    // $ANTLR end "ruleCssLiterals"


    // $ANTLR start "entryRuleFontLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:655:1: entryRuleFontLiteral returns [EObject current=null] : iv_ruleFontLiteral= ruleFontLiteral EOF ;
    public final EObject entryRuleFontLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFontLiteral = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getFontLiteralAccess().getUnorderedGroup_2()
        		);
        	
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:661:2: (iv_ruleFontLiteral= ruleFontLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:662:2: iv_ruleFontLiteral= ruleFontLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFontLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFontLiteral_in_entryRuleFontLiteral1275);
            iv_ruleFontLiteral=ruleFontLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFontLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFontLiteral1285); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleFontLiteral"


    // $ANTLR start "ruleFontLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:672:1: ruleFontLiteral returns [EObject current=null] : ( () ( ( (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) ) ) | otherlv_3= 'font' ) ( ( ( ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleFontLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_italic_5_0=null;
        Token lv_bold_6_0=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_size_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getFontLiteralAccess().getUnorderedGroup_2()
        		);
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:680:6: ( ( () ( ( (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) ) ) | otherlv_3= 'font' ) ( ( ( ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )* ) ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:681:1: ( () ( ( (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) ) ) | otherlv_3= 'font' ) ( ( ( ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )* ) ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:681:1: ( () ( ( (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) ) ) | otherlv_3= 'font' ) ( ( ( ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )* ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:681:2: () ( ( (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) ) ) | otherlv_3= 'font' ) ( ( ( ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )* ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:681:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:682:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getFontLiteralAccess().getFontLiteralAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getFontLiteralAccess().getFontLiteralAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:2: ( ( (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) ) ) | otherlv_3= 'font' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                int LA8_1 = input.LA(2);

                if ( (synpred9_InternalXcss()) ) {
                    alt8=1;
                }
                else if ( (true) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_STRING)) ) {
                alt8=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:3: ( (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:3: ( (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:4: (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:4: (otherlv_1= 'font' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==18) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:6: otherlv_1= 'font'
                            {
                            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleFontLiteral1341); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	createLeafNode(otherlv_1, grammarAccess.getFontLiteralAccess().getFontKeyword_1_0_0(), null);
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:699:3: ( (lv_name_2_0= ruleStringOrID ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:700:1: (lv_name_2_0= ruleStringOrID )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:700:1: (lv_name_2_0= ruleStringOrID )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:701:3: lv_name_2_0= ruleStringOrID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFontLiteralAccess().getNameStringOrIDParserRuleCall_1_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStringOrID_in_ruleFontLiteral1364);
                    lv_name_2_0=ruleStringOrID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFontLiteralRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"name",
                      	        		lv_name_2_0, 
                      	        		"StringOrID", 
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:724:7: otherlv_3= 'font'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleFontLiteral1383); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_3, grammarAccess.getFontLiteralAccess().getFontKeyword_1_1(), null);
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:728:2: ( ( ( ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )* ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:730:1: ( ( ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:730:1: ( ( ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:731:2: ( ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2());
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:734:2: ( ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:3: ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )*
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:3: ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )*
            loop9:
            do {
                int alt9=4;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:737:4: ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:737:4: ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:738:5: {...}? => ( ( (lv_italic_5_0= 'I' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleFontLiteral", "getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:738:108: ( ( (lv_italic_5_0= 'I' ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:739:6: ( (lv_italic_5_0= 'I' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 0);
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:742:6: ( (lv_italic_5_0= 'I' ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:743:1: (lv_italic_5_0= 'I' )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:743:1: (lv_italic_5_0= 'I' )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:744:3: lv_italic_5_0= 'I'
            	    {
            	    lv_italic_5_0=(Token)match(input,19,FOLLOW_19_in_ruleFontLiteral1444); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_italic_5_0, grammarAccess.getFontLiteralAccess().getItalicIKeyword_2_0_0(), "italic");
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getFontLiteralRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "italic", true, "I", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:770:4: ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:770:4: ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:771:5: {...}? => ( ( (lv_bold_6_0= 'B' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleFontLiteral", "getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:771:108: ( ( (lv_bold_6_0= 'B' ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:772:6: ( (lv_bold_6_0= 'B' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 1);
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:775:6: ( (lv_bold_6_0= 'B' ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:776:1: (lv_bold_6_0= 'B' )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:776:1: (lv_bold_6_0= 'B' )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:777:3: lv_bold_6_0= 'B'
            	    {
            	    lv_bold_6_0=(Token)match(input,20,FOLLOW_20_in_ruleFontLiteral1525); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_bold_6_0, grammarAccess.getFontLiteralAccess().getBoldBKeyword_2_1_0(), "bold");
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getFontLiteralRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "bold", true, "B", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:803:4: ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:803:4: ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:804:5: {...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleFontLiteral", "getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:804:108: ( ( (lv_size_7_0= ruleSizeLiteral ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:805:6: ( (lv_size_7_0= ruleSizeLiteral ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 2);
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:808:6: ( (lv_size_7_0= ruleSizeLiteral ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:809:1: (lv_size_7_0= ruleSizeLiteral )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:809:1: (lv_size_7_0= ruleSizeLiteral )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:810:3: lv_size_7_0= ruleSizeLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getFontLiteralAccess().getSizeSizeLiteralParserRuleCall_2_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSizeLiteral_in_ruleFontLiteral1609);
            	    lv_size_7_0=ruleSizeLiteral();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getFontLiteralRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"size",
            	      	        		true, 
            	      	        		"SizeLiteral", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2());

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

            getUnorderedGroupHelper().leave(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2());

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

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleFontLiteral"


    // $ANTLR start "entryRuleStringOrID"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:857:1: entryRuleStringOrID returns [String current=null] : iv_ruleStringOrID= ruleStringOrID EOF ;
    public final String entryRuleStringOrID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrID = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:858:2: (iv_ruleStringOrID= ruleStringOrID EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:859:2: iv_ruleStringOrID= ruleStringOrID EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStringOrIDRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStringOrID_in_entryRuleStringOrID1689);
            iv_ruleStringOrID=ruleStringOrID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringOrID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringOrID1700); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringOrID"


    // $ANTLR start "ruleStringOrID"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:866:1: ruleStringOrID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:871:6: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:872:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:872:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_STRING) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:872:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringOrID1740); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_STRING_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          createLeafNode(this_STRING_0, grammarAccess.getStringOrIDAccess().getSTRINGTerminalRuleCall_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:880:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStringOrID1766); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          createLeafNode(this_ID_1, grammarAccess.getStringOrIDAccess().getIDTerminalRuleCall_1(), null); 
                          
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
        }
        return current;
    }
    // $ANTLR end "ruleStringOrID"


    // $ANTLR start "entryRuleColorLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:895:1: entryRuleColorLiteral returns [EObject current=null] : iv_ruleColorLiteral= ruleColorLiteral EOF ;
    public final EObject entryRuleColorLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColorLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:896:2: (iv_ruleColorLiteral= ruleColorLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:897:2: iv_ruleColorLiteral= ruleColorLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getColorLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleColorLiteral_in_entryRuleColorLiteral1811);
            iv_ruleColorLiteral=ruleColorLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleColorLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleColorLiteral1821); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColorLiteral"


    // $ANTLR start "ruleColorLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:904:1: ruleColorLiteral returns [EObject current=null] : (this_ColorConstant_0= ruleColorConstant | this_RGB_1= ruleRGB ) ;
    public final EObject ruleColorLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_ColorConstant_0 = null;

        EObject this_RGB_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:909:6: ( (this_ColorConstant_0= ruleColorConstant | this_RGB_1= ruleRGB ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:910:1: (this_ColorConstant_0= ruleColorConstant | this_RGB_1= ruleRGB )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:910:1: (this_ColorConstant_0= ruleColorConstant | this_RGB_1= ruleRGB )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==21) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:911:2: this_ColorConstant_0= ruleColorConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getColorConstantParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleColorConstant_in_ruleColorLiteral1871);
                    this_ColorConstant_0=ruleColorConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ColorConstant_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:924:2: this_RGB_1= ruleRGB
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getRGBParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleRGB_in_ruleColorLiteral1901);
                    this_RGB_1=ruleRGB();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RGB_1; 
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
        }
        return current;
    }
    // $ANTLR end "ruleColorLiteral"


    // $ANTLR start "entryRuleColorConstant"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:943:1: entryRuleColorConstant returns [EObject current=null] : iv_ruleColorConstant= ruleColorConstant EOF ;
    public final EObject entryRuleColorConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColorConstant = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:944:2: (iv_ruleColorConstant= ruleColorConstant EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:945:2: iv_ruleColorConstant= ruleColorConstant EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getColorConstantRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleColorConstant_in_entryRuleColorConstant1936);
            iv_ruleColorConstant=ruleColorConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleColorConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleColorConstant1946); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColorConstant"


    // $ANTLR start "ruleColorConstant"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:952:1: ruleColorConstant returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleColorConstant() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:957:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:958:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:958:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:959:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:959:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:960:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleColorConstant1987); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_0_0, grammarAccess.getColorConstantAccess().getNameIDTerminalRuleCall_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getColorConstantRule().getType().getClassifier());
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
    // $ANTLR end "ruleColorConstant"


    // $ANTLR start "entryRuleRGB"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:990:1: entryRuleRGB returns [EObject current=null] : iv_ruleRGB= ruleRGB EOF ;
    public final EObject entryRuleRGB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRGB = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:991:2: (iv_ruleRGB= ruleRGB EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:992:2: iv_ruleRGB= ruleRGB EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRGBRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRGB_in_entryRuleRGB2027);
            iv_ruleRGB=ruleRGB();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRGB; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRGB2037); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRGB"


    // $ANTLR start "ruleRGB"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:999:1: ruleRGB returns [EObject current=null] : (otherlv_0= '#' ( (lv_color_1_0= RULE_INT ) ) ) ;
    public final EObject ruleRGB() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_color_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1004:6: ( (otherlv_0= '#' ( (lv_color_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1005:1: (otherlv_0= '#' ( (lv_color_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1005:1: (otherlv_0= '#' ( (lv_color_1_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1005:3: otherlv_0= '#' ( (lv_color_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleRGB2074); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getRGBAccess().getNumberSignKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1009:1: ( (lv_color_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1010:1: (lv_color_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1010:1: (lv_color_1_0= RULE_INT )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1011:3: lv_color_1_0= RULE_INT
            {
            lv_color_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGB2091); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_color_1_0, grammarAccess.getRGBAccess().getColorINTTerminalRuleCall_1_0(), "color"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getRGBRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"color",
              	        		lv_color_1_0, 
              	        		"INT", 
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
    // $ANTLR end "ruleRGB"


    // $ANTLR start "entryRuleSizeLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1041:1: entryRuleSizeLiteral returns [EObject current=null] : iv_ruleSizeLiteral= ruleSizeLiteral EOF ;
    public final EObject entryRuleSizeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizeLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1042:2: (iv_ruleSizeLiteral= ruleSizeLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1043:2: iv_ruleSizeLiteral= ruleSizeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSizeLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSizeLiteral_in_entryRuleSizeLiteral2132);
            iv_ruleSizeLiteral=ruleSizeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSizeLiteral2142); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSizeLiteral"


    // $ANTLR start "ruleSizeLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1050:1: ruleSizeLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleSizeUnit ) ) ) ;
    public final EObject ruleSizeLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Enumerator lv_unit_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1055:6: ( ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleSizeUnit ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1056:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleSizeUnit ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1056:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleSizeUnit ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1056:2: ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleSizeUnit ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1056:2: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1057:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1057:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1058:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSizeLiteral2184); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_value_0_0, grammarAccess.getSizeLiteralAccess().getValueINTTerminalRuleCall_0_0(), "value"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSizeLiteralRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1080:2: ( (lv_unit_1_0= ruleSizeUnit ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1081:1: (lv_unit_1_0= ruleSizeUnit )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1081:1: (lv_unit_1_0= ruleSizeUnit )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1082:3: lv_unit_1_0= ruleSizeUnit
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getSizeLiteralAccess().getUnitSizeUnitEnumRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleSizeUnit_in_ruleSizeLiteral2210);
            lv_unit_1_0=ruleSizeUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSizeLiteralRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"unit",
              	        		lv_unit_1_0, 
              	        		"SizeUnit", 
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
        }
        return current;
    }
    // $ANTLR end "ruleSizeLiteral"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1112:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1113:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1114:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXPrimaryExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression2246);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression2256); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1121:1: ruleXPrimaryExpression returns [EObject current=null] : (this_CssLiterals_0= ruleCssLiterals | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral | this_XConstructorCall_7= ruleXConstructorCall | this_XBlockExpression_8= ruleXBlockExpression | this_XSwitchExpression_9= ruleXSwitchExpression | this_XFeatureCall_10= ruleXFeatureCall | this_XIfExpression_11= ruleXIfExpression | this_XForLoopExpression_12= ruleXForLoopExpression | this_XWhileExpression_13= ruleXWhileExpression | this_XDoWhileExpression_14= ruleXDoWhileExpression | this_XCastedExpression_15= ruleXCastedExpression | this_XThrowExpression_16= ruleXThrowExpression | this_XTryCatchFinallyExpression_17= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_18= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CssLiterals_0 = null;

        EObject this_XClosure_1 = null;

        EObject this_XBooleanLiteral_2 = null;

        EObject this_XIntLiteral_3 = null;

        EObject this_XNullLiteral_4 = null;

        EObject this_XStringLiteral_5 = null;

        EObject this_XTypeLiteral_6 = null;

        EObject this_XConstructorCall_7 = null;

        EObject this_XBlockExpression_8 = null;

        EObject this_XSwitchExpression_9 = null;

        EObject this_XFeatureCall_10 = null;

        EObject this_XIfExpression_11 = null;

        EObject this_XForLoopExpression_12 = null;

        EObject this_XWhileExpression_13 = null;

        EObject this_XDoWhileExpression_14 = null;

        EObject this_XCastedExpression_15 = null;

        EObject this_XThrowExpression_16 = null;

        EObject this_XTryCatchFinallyExpression_17 = null;

        EObject this_XParenthesizedExpression_18 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1126:6: ( (this_CssLiterals_0= ruleCssLiterals | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral | this_XConstructorCall_7= ruleXConstructorCall | this_XBlockExpression_8= ruleXBlockExpression | this_XSwitchExpression_9= ruleXSwitchExpression | this_XFeatureCall_10= ruleXFeatureCall | this_XIfExpression_11= ruleXIfExpression | this_XForLoopExpression_12= ruleXForLoopExpression | this_XWhileExpression_13= ruleXWhileExpression | this_XDoWhileExpression_14= ruleXDoWhileExpression | this_XCastedExpression_15= ruleXCastedExpression | this_XThrowExpression_16= ruleXThrowExpression | this_XTryCatchFinallyExpression_17= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_18= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1127:1: (this_CssLiterals_0= ruleCssLiterals | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral | this_XConstructorCall_7= ruleXConstructorCall | this_XBlockExpression_8= ruleXBlockExpression | this_XSwitchExpression_9= ruleXSwitchExpression | this_XFeatureCall_10= ruleXFeatureCall | this_XIfExpression_11= ruleXIfExpression | this_XForLoopExpression_12= ruleXForLoopExpression | this_XWhileExpression_13= ruleXWhileExpression | this_XDoWhileExpression_14= ruleXDoWhileExpression | this_XCastedExpression_15= ruleXCastedExpression | this_XThrowExpression_16= ruleXThrowExpression | this_XTryCatchFinallyExpression_17= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_18= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1127:1: (this_CssLiterals_0= ruleCssLiterals | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral | this_XConstructorCall_7= ruleXConstructorCall | this_XBlockExpression_8= ruleXBlockExpression | this_XSwitchExpression_9= ruleXSwitchExpression | this_XFeatureCall_10= ruleXFeatureCall | this_XIfExpression_11= ruleXIfExpression | this_XForLoopExpression_12= ruleXForLoopExpression | this_XWhileExpression_13= ruleXWhileExpression | this_XDoWhileExpression_14= ruleXDoWhileExpression | this_XCastedExpression_15= ruleXCastedExpression | this_XThrowExpression_16= ruleXThrowExpression | this_XTryCatchFinallyExpression_17= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_18= ruleXParenthesizedExpression )
            int alt12=19;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1128:2: this_CssLiterals_0= ruleCssLiterals
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getCssLiteralsParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleCssLiterals_in_ruleXPrimaryExpression2306);
                    this_CssLiterals_0=ruleCssLiterals();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CssLiterals_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1141:2: this_XClosure_1= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXClosureParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXPrimaryExpression2336);
                    this_XClosure_1=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XClosure_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1154:2: this_XBooleanLiteral_2= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBooleanLiteralParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXPrimaryExpression2366);
                    this_XBooleanLiteral_2=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBooleanLiteral_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1167:2: this_XIntLiteral_3= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIntLiteralParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXPrimaryExpression2396);
                    this_XIntLiteral_3=ruleXIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIntLiteral_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1180:2: this_XNullLiteral_4= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXNullLiteralParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXPrimaryExpression2426);
                    this_XNullLiteral_4=ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XNullLiteral_4; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1193:2: this_XStringLiteral_5= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXStringLiteralParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXPrimaryExpression2456);
                    this_XStringLiteral_5=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XStringLiteral_5; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1206:2: this_XTypeLiteral_6= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTypeLiteralParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXPrimaryExpression2486);
                    this_XTypeLiteral_6=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTypeLiteral_6; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1219:2: this_XConstructorCall_7= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_7(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression2516);
                    this_XConstructorCall_7=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XConstructorCall_7; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1232:2: this_XBlockExpression_8= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_8(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression2546);
                    this_XBlockExpression_8=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBlockExpression_8; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1245:2: this_XSwitchExpression_9= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_9(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression2576);
                    this_XSwitchExpression_9=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XSwitchExpression_9; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1258:2: this_XFeatureCall_10= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_10(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression2606);
                    this_XFeatureCall_10=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFeatureCall_10; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1271:2: this_XIfExpression_11= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_11(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression2636);
                    this_XIfExpression_11=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIfExpression_11; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1284:2: this_XForLoopExpression_12= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_12(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression2666);
                    this_XForLoopExpression_12=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XForLoopExpression_12; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 14 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1297:2: this_XWhileExpression_13= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_13(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression2696);
                    this_XWhileExpression_13=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWhileExpression_13; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 15 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1310:2: this_XDoWhileExpression_14= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_14(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression2726);
                    this_XDoWhileExpression_14=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XDoWhileExpression_14; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 16 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1323:2: this_XCastedExpression_15= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXCastedExpressionParserRuleCall_15(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXPrimaryExpression2756);
                    this_XCastedExpression_15=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XCastedExpression_15; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 17 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1336:2: this_XThrowExpression_16= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_16(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression2786);
                    this_XThrowExpression_16=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XThrowExpression_16; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 18 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1349:2: this_XTryCatchFinallyExpression_17= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_17(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression2816);
                    this_XTryCatchFinallyExpression_17=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_17; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 19 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1362:2: this_XParenthesizedExpression_18= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_18(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression2846);
                    this_XParenthesizedExpression_18=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_18; 
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
        }
        return current;
    }
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleXExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1381:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1382:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1383:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression2881);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression2891); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1390:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1395:6: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1397:2: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression2940);
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
        }
        return current;
    }
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1416:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1417:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1418:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAssignmentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment2974);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment2984); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1425:1: ruleXAssignment returns [EObject current=null] : (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_XOrExpression_0 = null;

        EObject lv_value_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1430:6: ( (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1431:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1431:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1432:2: this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment3034);
            this_XOrExpression_0=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOrExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1443:1: ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                int LA13_1 = input.LA(2);

                if ( (synpred33_InternalXcss()) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1443:2: () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1443:2: ()
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1444:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "assignable", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getXAssignmentAccess().getXAssignmentAssignableAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1462:2: ( ( ruleOpAssign ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1463:1: ( ruleOpAssign )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1463:1: ( ruleOpAssign )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1464:3: ruleOpAssign
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
                    pushFollow(FOLLOW_ruleOpAssign_in_ruleXAssignment3073);
                    ruleOpAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1481:2: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1482:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1482:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1483:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment3094);
                    lv_value_3_0=ruleXAssignment();

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
                      	       			"value",
                      	        		lv_value_3_0, 
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
        }
        return current;
    }
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleXOrExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1513:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1514:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1515:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXOrExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression3132);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression3142); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1522:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1527:6: ( (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1528:1: (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1528:1: (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1529:2: this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression3192);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1540:1: ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==22) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred34_InternalXcss()) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1540:2: () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1540:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1541:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1559:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1560:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1560:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1561:3: ruleOpOr
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
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression3231);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1578:2: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1579:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1579:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1580:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression3252);
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
            	    break loop14;
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
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1610:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1611:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1612:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpOrRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr3291);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr3302); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1619:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1624:6: (kw= '||' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1626:2: kw= '||'
            {
            kw=(Token)match(input,22,FOLLOW_22_in_ruleOpOr3339); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1639:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1640:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1641:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAndExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression3378);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression3388); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1648:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1653:6: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1654:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1654:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1655:2: this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3438);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1666:1: ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==23) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred35_InternalXcss()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1666:2: () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1666:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1667:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1685:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1686:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1686:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1687:3: ruleOpAnd
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
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression3477);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1704:2: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1705:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1705:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1706:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3498);
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
            	    break loop15;
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
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1736:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1737:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1738:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAndRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd3537);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd3548); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1745:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1750:6: (kw= '&&' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1752:2: kw= '&&'
            {
            kw=(Token)match(input,23,FOLLOW_23_in_ruleOpAnd3585); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1765:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1766:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1767:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXEqualityExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression3624);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression3634); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1774:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1779:6: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1780:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1780:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1781:2: this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3684);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1792:1: ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==24) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred36_InternalXcss()) ) {
                        alt16=1;
                    }


                }
                else if ( (LA16_0==25) ) {
                    int LA16_3 = input.LA(2);

                    if ( (synpred36_InternalXcss()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1792:2: () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1792:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1793:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1811:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1812:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1812:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1813:3: ruleOpEquality
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
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression3723);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1830:2: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1831:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1831:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1832:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3744);
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
            	    break loop16;
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
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1862:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1863:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1864:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpEqualityRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality3783);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality3794); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1871:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1876:6: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1877:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1877:1: (kw= '==' | kw= '!=' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==24) ) {
                alt17=1;
            }
            else if ( (LA17_0==25) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1878:2: kw= '=='
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleOpEquality3832); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1885:2: kw= '!='
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleOpEquality3851); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1898:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1899:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1900:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXRelationalExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression3891);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression3901); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1907:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_rightOperand_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1912:6: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1913:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1913:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1914:2: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression3951);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1925:1: ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop18:
            do {
                int alt18=3;
                switch ( input.LA(1) ) {
                case 26:
                    {
                    int LA18_2 = input.LA(2);

                    if ( (synpred38_InternalXcss()) ) {
                        alt18=1;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA18_3 = input.LA(2);

                    if ( (synpred39_InternalXcss()) ) {
                        alt18=2;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA18_4 = input.LA(2);

                    if ( (synpred39_InternalXcss()) ) {
                        alt18=2;
                    }


                    }
                    break;
                case 29:
                    {
                    int LA18_5 = input.LA(2);

                    if ( (synpred39_InternalXcss()) ) {
                        alt18=2;
                    }


                    }
                    break;
                case 30:
                    {
                    int LA18_6 = input.LA(2);

                    if ( (synpred39_InternalXcss()) ) {
                        alt18=2;
                    }


                    }
                    break;

                }

                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1925:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1925:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1925:3: () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1925:3: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1926:2: 
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

            	    otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleXRelationalExpression3976); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_1(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1948:1: ( ( ruleQualifiedName ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1949:1: ( ruleQualifiedName )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1949:1: ( ruleQualifiedName )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1950:3: ruleQualifiedName
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
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression4003);
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
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1968:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1968:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1968:7: () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1968:7: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1969:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1987:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1988:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1988:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1989:3: ruleOpCompare
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
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression4050);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2006:2: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2007:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2007:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2008:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4071);
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
            	    break loop18;
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
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2038:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2039:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2040:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpCompareRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare4111);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare4122); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2047:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2052:6: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2053:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2053:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt19=1;
                }
                break;
            case 28:
                {
                alt19=2;
                }
                break;
            case 29:
                {
                alt19=3;
                }
                break;
            case 30:
                {
                alt19=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2054:2: kw= '>='
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpCompare4160); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2061:2: kw= '<='
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpCompare4179); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2068:2: kw= '>'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpCompare4198); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2075:2: kw= '<'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpCompare4217); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2088:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2089:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2090:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXOtherOperatorExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression4257);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression4267); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2097:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2102:6: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2103:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2103:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2104:2: this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4317);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2115:1: ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    int LA20_2 = input.LA(2);

                    if ( (synpred43_InternalXcss()) ) {
                        alt20=1;
                    }


                }
                else if ( (LA20_0==32) ) {
                    int LA20_3 = input.LA(2);

                    if ( (synpred43_InternalXcss()) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2115:2: () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2115:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2116:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2134:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2135:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2135:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2136:3: ruleOpOther
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
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression4356);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2153:2: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2154:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2154:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2155:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4377);
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
            	    break loop20;
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
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2185:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2186:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2187:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpOtherRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther4416);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther4427); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2194:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2199:6: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2200:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2200:1: (kw= '->' | kw= '..' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            else if ( (LA21_0==32) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2201:2: kw= '->'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpOther4465); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2208:2: kw= '..'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpOther4484); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2221:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2222:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2223:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAdditiveExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression4524);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression4534); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2230:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2235:6: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2236:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2236:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2237:2: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4584);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2248:1: ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==33) ) {
                    int LA22_2 = input.LA(2);

                    if ( (synpred45_InternalXcss()) ) {
                        alt22=1;
                    }


                }
                else if ( (LA22_0==34) ) {
                    int LA22_3 = input.LA(2);

                    if ( (synpred45_InternalXcss()) ) {
                        alt22=1;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2248:2: () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2248:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2249:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2267:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2268:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2268:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2269:3: ruleOpAdd
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
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression4623);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2286:2: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2287:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2287:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2288:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4644);
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
        }
        return current;
    }
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2318:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2319:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2320:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAddRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd4683);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd4694); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2327:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2332:6: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2333:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2333:1: (kw= '+' | kw= '-' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            else if ( (LA23_0==34) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2334:2: kw= '+'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpAdd4732); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2341:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpAdd4751); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2354:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2355:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2356:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXMultiplicativeExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression4791);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression4801); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2363:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2368:6: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2369:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2369:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2370:2: this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression4851);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2381:1: ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop24:
            do {
                int alt24=2;
                switch ( input.LA(1) ) {
                case 13:
                    {
                    int LA24_2 = input.LA(2);

                    if ( (synpred47_InternalXcss()) ) {
                        alt24=1;
                    }


                    }
                    break;
                case 35:
                    {
                    int LA24_3 = input.LA(2);

                    if ( (synpred47_InternalXcss()) ) {
                        alt24=1;
                    }


                    }
                    break;
                case 36:
                    {
                    int LA24_4 = input.LA(2);

                    if ( (synpred47_InternalXcss()) ) {
                        alt24=1;
                    }


                    }
                    break;
                case 37:
                    {
                    int LA24_5 = input.LA(2);

                    if ( (synpred47_InternalXcss()) ) {
                        alt24=1;
                    }


                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2381:2: () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2381:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2382:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2400:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2401:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2401:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2402:3: ruleOpMulti
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
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression4890);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2419:2: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2420:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2420:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2421:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression4911);
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
            	    break loop24;
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
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2451:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2452:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2453:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpMultiRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti4950);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti4961); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2460:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2465:6: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2466:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2466:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt25=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt25=1;
                }
                break;
            case 35:
                {
                alt25=2;
                }
                break;
            case 36:
                {
                alt25=3;
                }
                break;
            case 37:
                {
                alt25=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2467:2: kw= '*'
                    {
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleOpMulti4999); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2474:2: kw= '**'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpMulti5018); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2481:2: kw= '/'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpMulti5037); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2488:2: kw= '%'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpMulti5056); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2501:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2502:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2503:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXUnaryOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation5096);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation5106); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2510:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XMemberFeatureCall_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2515:6: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2516:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2516:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=33 && LA26_0<=34)||LA26_0==38) ) {
                alt26=1;
            }
            else if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_INT)||LA26_0==11||LA26_0==18||LA26_0==21||LA26_0==30||LA26_0==41||(LA26_0>=43 && LA26_0<=44)||LA26_0==46||(LA26_0>=49 && LA26_0<=51)||(LA26_0>=55 && LA26_0<=58)||(LA26_0>=60 && LA26_0<=61)||LA26_0==64) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2516:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2516:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2516:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2516:3: ()
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2517:2: 
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2530:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2531:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2531:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2532:3: ruleOpUnary
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
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation5171);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2549:2: ( (lv_operand_2_0= ruleXMemberFeatureCall ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2550:1: (lv_operand_2_0= ruleXMemberFeatureCall )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2550:1: (lv_operand_2_0= ruleXMemberFeatureCall )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2551:3: lv_operand_2_0= ruleXMemberFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXMemberFeatureCallParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation5192);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2575:2: this_XMemberFeatureCall_3= ruleXMemberFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getXMemberFeatureCallParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation5224);
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
        }
        return current;
    }
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2594:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2595:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2596:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpUnaryRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary5260);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary5271); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2603:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2608:6: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2609:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2609:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt27=1;
                }
                break;
            case 34:
                {
                alt27=2;
                }
                break;
            case 33:
                {
                alt27=3;
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2610:2: kw= '!'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpUnary5309); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2617:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpUnary5328); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2624:2: kw= '+'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpUnary5347); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2637:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2638:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2639:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXMemberFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall5387);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall5397); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2646:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* ) ;
    public final EObject ruleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_explicitOperationCall_9_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject this_XPrimaryExpression_0 = null;

        EObject lv_typeArguments_4_0 = null;

        EObject lv_typeArguments_6_0 = null;

        EObject lv_memberCallArguments_10_0 = null;

        EObject lv_memberCallArguments_12_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2651:6: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2652:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2652:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2653:2: this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall5447);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2664:1: ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==39) ) {
                    int LA33_2 = input.LA(2);

                    if ( (synpred59_InternalXcss()) ) {
                        alt33=1;
                    }


                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2664:2: () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2664:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2665:2: 
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

            	    otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleXMemberFeatureCall5471); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2687:1: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==30) ) {
            	        alt29=1;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2687:3: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
            	            {
            	            otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleXMemberFeatureCall5484); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_3, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_2_0(), null);
            	                  
            	            }
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2691:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2692:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2692:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2693:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), currentNode); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall5505);
            	            lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

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
            	              	        		"JvmArgumentTypeReference", 
            	              	        		currentNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	        currentNode = currentNode.getParent();
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2715:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop28:
            	            do {
            	                int alt28=2;
            	                int LA28_0 = input.LA(1);

            	                if ( (LA28_0==40) ) {
            	                    alt28=1;
            	                }


            	                switch (alt28) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2715:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_5=(Token)match(input,40,FOLLOW_40_in_ruleXMemberFeatureCall5518); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	createLeafNode(otherlv_5, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_2_2_0(), null);
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2719:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2720:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2720:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2721:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_2_1_0(), currentNode); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall5539);
            	            	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

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
            	            	      	        		"JvmArgumentTypeReference", 
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
            	            	    break loop28;
            	                }
            	            } while (true);

            	            otherlv_7=(Token)match(input,29,FOLLOW_29_in_ruleXMemberFeatureCall5553); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_2_3(), null);
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2747:3: ( (otherlv_8= RULE_ID ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2748:1: (otherlv_8= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2748:1: (otherlv_8= RULE_ID )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2749:3: otherlv_8= RULE_ID
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
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXMemberFeatureCall5579); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		createLeafNode(otherlv_8, grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_1_3_0(), "feature"); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2764:2: ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
            	    int alt32=2;
            	    alt32 = dfa32.predict(input);
            	    switch (alt32) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2764:3: ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')'
            	            {
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2764:3: ( (lv_explicitOperationCall_9_0= '(' ) )
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2765:1: (lv_explicitOperationCall_9_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2765:1: (lv_explicitOperationCall_9_0= '(' )
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2766:3: lv_explicitOperationCall_9_0= '('
            	            {
            	            lv_explicitOperationCall_9_0=(Token)match(input,41,FOLLOW_41_in_ruleXMemberFeatureCall5598); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_explicitOperationCall_9_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_4_0_0(), "explicitOperationCall");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getXMemberFeatureCallRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "explicitOperationCall", true, "(", lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2785:2: ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )?
            	            int alt31=2;
            	            int LA31_0 = input.LA(1);

            	            if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_INT)||LA31_0==11||LA31_0==18||LA31_0==21||LA31_0==30||(LA31_0>=33 && LA31_0<=34)||LA31_0==38||LA31_0==41||(LA31_0>=43 && LA31_0<=44)||LA31_0==46||(LA31_0>=49 && LA31_0<=51)||(LA31_0>=55 && LA31_0<=58)||(LA31_0>=60 && LA31_0<=61)||LA31_0==64) ) {
            	                alt31=1;
            	            }
            	            switch (alt31) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2785:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2785:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2786:1: (lv_memberCallArguments_10_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2786:1: (lv_memberCallArguments_10_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2787:3: lv_memberCallArguments_10_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_0_0(), currentNode); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5633);
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

            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2809:2: (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
            	                    loop30:
            	                    do {
            	                        int alt30=2;
            	                        int LA30_0 = input.LA(1);

            	                        if ( (LA30_0==40) ) {
            	                            alt30=1;
            	                        }


            	                        switch (alt30) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2809:4: otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_11=(Token)match(input,40,FOLLOW_40_in_ruleXMemberFeatureCall5646); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	createLeafNode(otherlv_11, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_4_1_1_0(), null);
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2813:1: ( (lv_memberCallArguments_12_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2814:1: (lv_memberCallArguments_12_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2814:1: (lv_memberCallArguments_12_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2815:3: lv_memberCallArguments_12_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_1_1_0(), currentNode); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5667);
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
            	                    	    break loop30;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            otherlv_13=(Token)match(input,42,FOLLOW_42_in_ruleXMemberFeatureCall5683); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_13, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_4_2(), null);
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXClosure"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2849:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2850:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2851:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXClosureRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure5723);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure5733); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2858:1: ruleXClosure returns [EObject current=null] : ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_formalParameters_1_0 = null;

        EObject lv_formalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2863:6: ( ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2864:1: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2864:1: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2864:2: () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2864:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2865:2: 
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2878:2: ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID||LA35_0==41||LA35_0==64) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2878:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2878:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2879:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2879:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2880:3: lv_formalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_1_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5792);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2902:2: (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==40) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2902:4: otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleXClosure5805); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_2, grammarAccess.getXClosureAccess().getCommaKeyword_1_1_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2906:1: ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2907:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2907:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2908:3: lv_formalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_1_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5826);
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
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,43,FOLLOW_43_in_ruleXClosure5842); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_4, grammarAccess.getXClosureAccess().getVerticalLineKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2934:1: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2935:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2935:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2936:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXClosure5863);
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
        }
        return current;
    }
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXCastedExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2966:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2967:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2968:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCastedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression5899);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression5909); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2975:1: ruleXCastedExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_type_1_0 = null;

        EObject lv_target_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2980:6: ( (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2981:1: (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2981:1: (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2981:3: otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) )
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleXCastedExpression5946); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXCastedExpressionAccess().getLeftParenthesisKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2985:1: ( (lv_type_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2986:1: (lv_type_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2986:1: (lv_type_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2987:3: lv_type_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression5967);
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

            otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleXCastedExpression5979); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getRightParenthesisKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3013:1: ( (lv_target_3_0= ruleXMemberFeatureCall ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3014:1: (lv_target_3_0= ruleXMemberFeatureCall )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3014:1: (lv_target_3_0= ruleXMemberFeatureCall )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3015:3: lv_target_3_0= ruleXMemberFeatureCall
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCastedExpressionAccess().getTargetXMemberFeatureCallParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression6000);
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
        }
        return current;
    }
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3045:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3046:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3047:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXParenthesizedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6036);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression6046); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3054:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3059:6: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3060:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3060:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3060:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleXParenthesizedExpression6083); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null);
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6108);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      currentNode = currentNode.getParent();
                  
            }
            otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleXParenthesizedExpression6119); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXIfExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3088:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3089:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3090:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXIfExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6155);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression6165); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3097:1: ruleXIfExpression returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_if_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3102:6: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3103:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3103:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3103:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )?
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleXIfExpression6202); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXIfExpressionAccess().getIfKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleXIfExpression6214); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3111:1: ( (lv_if_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3112:1: (lv_if_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3112:1: (lv_if_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3113:3: lv_if_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6235);
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

            otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleXIfExpression6247); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3139:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3140:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3140:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3141:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6268);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3163:2: (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==45) ) {
                int LA36_1 = input.LA(2);

                if ( (synpred62_InternalXcss()) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3163:4: otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) )
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_45_in_ruleXIfExpression6281); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXIfExpressionAccess().getElseKeyword_5_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3167:1: ( (lv_else_6_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3168:1: (lv_else_6_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3168:1: (lv_else_6_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3169:3: lv_else_6_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6302);
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
        }
        return current;
    }
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3199:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3200:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3201:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXSwitchExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6340);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression6350); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3208:1: ruleXSwitchExpression returns [EObject current=null] : (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3213:6: ( (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3214:1: (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3214:1: (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3214:3: otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleXSwitchExpression6387); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3218:1: ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )?
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3219:1: (lv_switch_1_0= ruleXExpressionInsideBlock )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3219:1: (lv_switch_1_0= ruleXExpressionInsideBlock )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3220:3: lv_switch_1_0= ruleXExpressionInsideBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionInsideBlockParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXSwitchExpression6408);
                    lv_switch_1_0=ruleXExpressionInsideBlock();

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
                      	        		"XExpressionInsideBlock", 
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

            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleXSwitchExpression6421); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3246:1: ( (lv_cases_3_0= ruleXCasePart ) )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID||LA38_0==17||LA38_0==41||LA38_0==48||LA38_0==64) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3247:1: (lv_cases_3_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3247:1: (lv_cases_3_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3248:3: lv_cases_3_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_3_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6442);
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
            	    if ( cnt38 >= 1 ) break loop38;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3270:3: (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==47) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3270:5: otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )
                    {
                    otherlv_4=(Token)match(input,47,FOLLOW_47_in_ruleXSwitchExpression6456); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_4_0(), null);
                          
                    }
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleXSwitchExpression6468); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_4_1(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3278:1: ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )
                    int alt39=2;
                    alt39 = dfa39.predict(input);
                    switch (alt39) {
                        case 1 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3278:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3278:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3278:3: ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';'
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3278:3: ( (lv_default_6_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3279:1: (lv_default_6_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3279:1: (lv_default_6_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3280:3: lv_default_6_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_4_2_0_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6491);
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

                            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleXSwitchExpression6503); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	createLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getSemicolonKeyword_4_2_0_1(), null);
                                  
                            }

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3307:6: ( (lv_default_8_0= ruleXBlockExpression ) )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3307:6: ( (lv_default_8_0= ruleXBlockExpression ) )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3308:1: (lv_default_8_0= ruleXBlockExpression )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3308:1: (lv_default_8_0= ruleXBlockExpression )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3309:3: lv_default_8_0= ruleXBlockExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXBlockExpressionParserRuleCall_4_2_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXSwitchExpression6531);
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

            otherlv_9=(Token)match(input,12,FOLLOW_12_in_ruleXSwitchExpression6546); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXCasePart"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3343:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3344:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3345:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCasePartRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6582);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6592); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3352:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_then_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3357:6: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3358:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3358:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3358:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3358:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID||LA41_0==41||LA41_0==64) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3359:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3359:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3360:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6638);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3382:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==48) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3382:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleXCasePart6652); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3386:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3387:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3387:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3388:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6673);
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleXCasePart6687); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3414:1: ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )
            int alt43=2;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3414:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3414:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3414:3: ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';'
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3414:3: ( (lv_then_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3415:1: (lv_then_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3415:1: (lv_then_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3416:3: lv_then_4_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6710);
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

                    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleXCasePart6722); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXCasePartAccess().getSemicolonKeyword_3_0_1(), null);
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3443:6: ( (lv_then_6_0= ruleXBlockExpression ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3443:6: ( (lv_then_6_0= ruleXBlockExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3444:1: (lv_then_6_0= ruleXBlockExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3444:1: (lv_then_6_0= ruleXBlockExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3445:3: lv_then_6_0= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXBlockExpressionParserRuleCall_3_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXCasePart6750);
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
        }
        return current;
    }
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3475:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3476:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3477:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXForLoopExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6787);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression6797); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3484:1: ruleXForLoopExpression returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) ) ;
    public final EObject ruleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_forExpression_4_0 = null;

        EObject lv_eachExpression_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3489:6: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3490:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3490:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3490:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleXForLoopExpression6834); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXForLoopExpressionAccess().getForKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleXForLoopExpression6846); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3498:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3499:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3499:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3500:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6867);
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleXForLoopExpression6879); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3526:1: ( (lv_forExpression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3527:1: (lv_forExpression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3527:1: (lv_forExpression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3528:3: lv_forExpression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6900);
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

            otherlv_5=(Token)match(input,42,FOLLOW_42_in_ruleXForLoopExpression6912); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_5, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_5(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3554:1: ( (lv_eachExpression_6_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3555:1: (lv_eachExpression_6_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3555:1: (lv_eachExpression_6_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3556:3: lv_eachExpression_6_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_6_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6933);
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
        }
        return current;
    }
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3586:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3587:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3588:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6969);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression6979); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3595:1: ruleXWhileExpression returns [EObject current=null] : (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_predicate_2_0 = null;

        EObject lv_body_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3600:6: ( (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3601:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3601:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3601:3: otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleXWhileExpression7016); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleXWhileExpression7028); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3609:1: ( (lv_predicate_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3610:1: (lv_predicate_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3610:1: (lv_predicate_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3611:3: lv_predicate_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7049);
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

            otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleXWhileExpression7061); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3637:1: ( (lv_body_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3638:1: (lv_body_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3638:1: (lv_body_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3639:3: lv_body_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7082);
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
        }
        return current;
    }
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3669:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3670:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3671:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXDoWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7118);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression7128); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3678:1: ruleXDoWhileExpression returns [EObject current=null] : (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' ) ;
    public final EObject ruleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_body_1_0 = null;

        EObject lv_predicate_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3683:6: ( (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3684:1: (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3684:1: (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3684:3: otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleXDoWhileExpression7165); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3688:1: ( (lv_body_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3689:1: (lv_body_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3689:1: (lv_body_1_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3690:3: lv_body_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7186);
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

            otherlv_2=(Token)match(input,50,FOLLOW_50_in_ruleXDoWhileExpression7198); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_2(), null);
                  
            }
            otherlv_3=(Token)match(input,41,FOLLOW_41_in_ruleXDoWhileExpression7210); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3720:1: ( (lv_predicate_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3721:1: (lv_predicate_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3721:1: (lv_predicate_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3722:3: lv_predicate_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7231);
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

            otherlv_5=(Token)match(input,42,FOLLOW_42_in_ruleXDoWhileExpression7243); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXBlockExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3756:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3757:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3758:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXBlockExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7279);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression7289); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3765:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3770:6: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3771:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3771:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3771:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3771:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3772:2: 
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

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleXBlockExpression7338); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3789:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=RULE_ID && LA45_0<=RULE_INT)||LA45_0==11||LA45_0==18||LA45_0==21||LA45_0==30||(LA45_0>=33 && LA45_0<=34)||LA45_0==38||LA45_0==41||(LA45_0>=43 && LA45_0<=44)||LA45_0==46||(LA45_0>=49 && LA45_0<=53)||(LA45_0>=55 && LA45_0<=58)||(LA45_0>=60 && LA45_0<=61)||LA45_0==64) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3789:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3789:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3790:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3790:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3791:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7360);
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3813:2: (otherlv_3= ';' )?
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==16) ) {
            	        alt44=1;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3813:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleXBlockExpression7373); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1(), null);
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleXBlockExpression7389); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXExpressionInsideBlock"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3829:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3830:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3831:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXExpressionInsideBlockRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7425);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7435); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3838:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3843:6: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3844:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3844:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=52 && LA46_0<=53)) ) {
                alt46=1;
            }
            else if ( ((LA46_0>=RULE_ID && LA46_0<=RULE_INT)||LA46_0==11||LA46_0==18||LA46_0==21||LA46_0==30||(LA46_0>=33 && LA46_0<=34)||LA46_0==38||LA46_0==41||(LA46_0>=43 && LA46_0<=44)||LA46_0==46||(LA46_0>=49 && LA46_0<=51)||(LA46_0>=55 && LA46_0<=58)||(LA46_0>=60 && LA46_0<=61)||LA46_0==64) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3845:2: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7485);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3858:2: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7515);
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
        }
        return current;
    }
    // $ANTLR end "ruleXExpressionInsideBlock"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3877:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3878:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3879:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXVariableDeclarationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7550);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7560); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3886:1: ruleXVariableDeclaration returns [EObject current=null] : ( ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_writeable_0_0=null;
        Token otherlv_1=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        EObject lv_type_2_0 = null;

        EObject lv_right_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3891:6: ( ( ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3892:1: ( ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3892:1: ( ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3892:2: ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3892:2: ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==52) ) {
                alt47=1;
            }
            else if ( (LA47_0==53) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3892:3: ( (lv_writeable_0_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3892:3: ( (lv_writeable_0_0= 'var' ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3893:1: (lv_writeable_0_0= 'var' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3893:1: (lv_writeable_0_0= 'var' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3894:3: lv_writeable_0_0= 'var'
                    {
                    lv_writeable_0_0=(Token)match(input,52,FOLLOW_52_in_ruleXVariableDeclaration7604); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              createLeafNode(lv_writeable_0_0, grammarAccess.getXVariableDeclarationAccess().getWriteableVarKeyword_0_0_0(), "writeable");
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXVariableDeclarationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "writeable", true, "var", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3914:7: otherlv_1= 'val'
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleXVariableDeclaration7635); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getXVariableDeclarationAccess().getValKeyword_0_1(), null);
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3918:2: ( (lv_type_2_0= ruleJvmTypeReference ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==RULE_ID||LA48_1==30||LA48_1==39) ) {
                    alt48=1;
                }
            }
            else if ( (LA48_0==41||LA48_0==64) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3919:1: (lv_type_2_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3919:1: (lv_type_2_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3920:3: lv_type_2_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7657);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3942:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3943:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3943:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3944:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXVariableDeclaration7675); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,54,FOLLOW_54_in_ruleXVariableDeclaration7692); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_4, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3970:1: ( (lv_right_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3971:1: (lv_right_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3971:1: (lv_right_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3972:3: lv_right_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7713);
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
        }
        return current;
    }
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4002:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4003:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4004:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmFormalParameterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7749);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter7759); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4011:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_parameterType_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4016:6: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4017:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4017:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4017:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4017:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==RULE_ID||LA49_1==30||LA49_1==39) ) {
                    alt49=1;
                }
            }
            else if ( (LA49_0==41||LA49_0==64) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4018:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4018:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4019:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7805);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4041:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4042:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4042:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4043:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJvmFormalParameter7823); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4073:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4074:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4075:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7864);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall7874); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4082:1: ruleXFeatureCall returns [EObject current=null] : ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_explicitOperationCall_6_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_typeArguments_1_0 = null;

        EObject lv_typeArguments_3_0 = null;

        EObject lv_featureCallArguments_7_0 = null;

        EObject lv_featureCallArguments_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4087:6: ( ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4088:1: ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4088:1: ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4088:2: (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4088:2: (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==30) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4088:4: otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>'
                    {
                    otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleXFeatureCall7912); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_0, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4092:1: ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4093:1: (lv_typeArguments_1_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4093:1: (lv_typeArguments_1_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4094:3: lv_typeArguments_1_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7933);
                    lv_typeArguments_1_0=ruleJvmArgumentTypeReference();

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
                      	        		"JvmArgumentTypeReference", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4116:2: (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==40) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4116:4: otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleXFeatureCall7946); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getCommaKeyword_0_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4120:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4121:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4121:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4122:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7967);
                    	    lv_typeArguments_3_0=ruleJvmArgumentTypeReference();

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
                    	      	        		"JvmArgumentTypeReference", 
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
                    	    break loop50;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleXFeatureCall7981); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_0_3(), null);
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4148:3: ( (otherlv_5= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4149:1: (otherlv_5= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4149:1: (otherlv_5= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4150:3: otherlv_5= RULE_ID
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
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXFeatureCall8007); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		createLeafNode(otherlv_5, grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_1_0(), "feature"); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4165:2: ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )?
            int alt54=2;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4165:3: ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')'
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4165:3: ( (lv_explicitOperationCall_6_0= '(' ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4166:1: (lv_explicitOperationCall_6_0= '(' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4166:1: (lv_explicitOperationCall_6_0= '(' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4167:3: lv_explicitOperationCall_6_0= '('
                    {
                    lv_explicitOperationCall_6_0=(Token)match(input,41,FOLLOW_41_in_ruleXFeatureCall8026); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              createLeafNode(lv_explicitOperationCall_6_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_2_0_0(), "explicitOperationCall");
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXFeatureCallRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "explicitOperationCall", true, "(", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4186:2: ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( ((LA53_0>=RULE_ID && LA53_0<=RULE_INT)||LA53_0==11||LA53_0==18||LA53_0==21||LA53_0==30||(LA53_0>=33 && LA53_0<=34)||LA53_0==38||LA53_0==41||(LA53_0>=43 && LA53_0<=44)||LA53_0==46||(LA53_0>=49 && LA53_0<=51)||(LA53_0>=55 && LA53_0<=58)||(LA53_0>=60 && LA53_0<=61)||LA53_0==64) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4186:3: ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4186:3: ( (lv_featureCallArguments_7_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4187:1: (lv_featureCallArguments_7_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4187:1: (lv_featureCallArguments_7_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4188:3: lv_featureCallArguments_7_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8061);
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

                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4210:2: (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==40) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4210:4: otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            	    {
                            	    otherlv_8=(Token)match(input,40,FOLLOW_40_in_ruleXFeatureCall8074); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	createLeafNode(otherlv_8, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_1_1_0(), null);
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4214:1: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4215:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4215:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4216:3: lv_featureCallArguments_9_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8095);
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
                            	    break loop52;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,42,FOLLOW_42_in_ruleXFeatureCall8111); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleXConstructorCall"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4250:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4251:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4252:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXConstructorCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8149);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall8159); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4259:1: ruleXConstructorCall returns [EObject current=null] : (otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')' ) ;
    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_typeArguments_3_0 = null;

        EObject lv_typeArguments_5_0 = null;

        EObject lv_arguments_8_0 = null;

        EObject lv_arguments_10_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4264:6: ( (otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4265:1: (otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4265:1: (otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4265:3: otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_55_in_ruleXConstructorCall8196); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXConstructorCallAccess().getNewKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4269:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4270:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4270:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4271:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getXConstructorCallRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8223);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4288:2: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==30) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4288:4: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleXConstructorCall8236); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_2, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_2_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4292:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4293:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4293:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4294:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8257);
                    lv_typeArguments_3_0=ruleJvmArgumentTypeReference();

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
                      	       			"typeArguments",
                      	        		lv_typeArguments_3_0, 
                      	        		"JvmArgumentTypeReference", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4316:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==40) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4316:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleXConstructorCall8270); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_4, grammarAccess.getXConstructorCallAccess().getCommaKeyword_2_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4320:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4321:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4321:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4322:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8291);
                    	    lv_typeArguments_5_0=ruleJvmArgumentTypeReference();

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
                    	      	       			"typeArguments",
                    	      	        		lv_typeArguments_5_0, 
                    	      	        		"JvmArgumentTypeReference", 
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
                    	    break loop55;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleXConstructorCall8305); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_6, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_2_3(), null);
                          
                    }

                    }
                    break;

            }

            otherlv_7=(Token)match(input,41,FOLLOW_41_in_ruleXConstructorCall8319); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4352:1: ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=RULE_ID && LA58_0<=RULE_INT)||LA58_0==11||LA58_0==18||LA58_0==21||LA58_0==30||(LA58_0>=33 && LA58_0<=34)||LA58_0==38||LA58_0==41||(LA58_0>=43 && LA58_0<=44)||LA58_0==46||(LA58_0>=49 && LA58_0<=51)||(LA58_0>=55 && LA58_0<=58)||(LA58_0>=60 && LA58_0<=61)||LA58_0==64) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4352:2: ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4352:2: ( (lv_arguments_8_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4353:1: (lv_arguments_8_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4353:1: (lv_arguments_8_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4354:3: lv_arguments_8_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8341);
                    lv_arguments_8_0=ruleXExpression();

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
                      	        		lv_arguments_8_0, 
                      	        		"XExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4376:2: (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==40) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4376:4: otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) )
                    	    {
                    	    otherlv_9=(Token)match(input,40,FOLLOW_40_in_ruleXConstructorCall8354); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_9, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4380:1: ( (lv_arguments_10_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4381:1: (lv_arguments_10_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4381:1: (lv_arguments_10_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4382:3: lv_arguments_10_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8375);
                    	    lv_arguments_10_0=ruleXExpression();

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
                    	      	        		lv_arguments_10_0, 
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
                    	    break loop57;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,42,FOLLOW_42_in_ruleXConstructorCall8391); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_5(), null);
                  
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
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4416:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4417:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4418:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXBooleanLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8427);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral8437); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4425:1: ruleXBooleanLiteral returns [EObject current=null] : ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4430:6: ( ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4431:1: ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4431:1: ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==56) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4431:2: ( () otherlv_1= 'false' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4431:2: ( () otherlv_1= 'false' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4431:3: () otherlv_1= 'false'
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4431:3: ()
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4432:2: 
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

                    otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleXBooleanLiteral8487); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_0_1(), null);
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4450:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4450:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4451:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4451:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4452:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,57,FOLLOW_57_in_ruleXBooleanLiteral8512); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4479:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4480:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4481:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXNullLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8561);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral8571); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4488:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4493:6: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4494:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4494:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4494:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4494:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4495:2: 
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

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleXNullLiteral8620); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXIntLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4520:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4521:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4522:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXIntLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral8656);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral8666); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4529:1: ruleXIntLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4534:6: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4535:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4535:1: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4536:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4536:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4537:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral8707); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleXIntLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4567:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4568:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4569:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral8747);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral8757); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4576:1: ruleXStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4581:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4582:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4582:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4583:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4583:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4584:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral8798); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4614:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4615:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4616:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXTypeLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral8838);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral8848); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4623:1: ruleXTypeLiteral returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4628:6: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4629:1: ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4629:1: ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4629:2: ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4629:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4630:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4630:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4631:3: ruleQualifiedName
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
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral8900);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleXTypeLiteral8912); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getFullStopKeyword_1(), null);
                  
            }
            otherlv_2=(Token)match(input,59,FOLLOW_59_in_ruleXTypeLiteral8924); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXThrowExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4664:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4665:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4666:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXThrowExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression8960);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression8970); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4673:1: ruleXThrowExpression returns [EObject current=null] : (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4678:6: ( (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4679:1: (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4679:1: (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4679:3: otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleXThrowExpression9007); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4683:1: ( (lv_expression_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4684:1: (lv_expression_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4684:1: (lv_expression_1_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4685:3: lv_expression_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression9028);
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
        }
        return current;
    }
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4715:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4716:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4717:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9064);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9074); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4724:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) ) ;
    public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expression_1_0 = null;

        EObject lv_catchClauses_2_0 = null;

        EObject lv_finallyExpression_4_0 = null;

        EObject lv_finallyExpression_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4729:6: ( (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4730:1: (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4730:1: (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4730:3: otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_61_in_ruleXTryCatchFinallyExpression9111); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4734:1: ( (lv_expression_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4735:1: (lv_expression_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4735:1: (lv_expression_1_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4736:3: lv_expression_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9132);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4758:2: ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==63) ) {
                alt62=1;
            }
            else if ( (LA62_0==62) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4758:3: ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4758:3: ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4758:4: ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4758:4: ( (lv_catchClauses_2_0= ruleXCatchClause ) )+
                    int cnt60=0;
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==63) ) {
                            int LA60_2 = input.LA(2);

                            if ( (synpred86_InternalXcss()) ) {
                                alt60=1;
                            }


                        }


                        switch (alt60) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4759:1: (lv_catchClauses_2_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4759:1: (lv_catchClauses_2_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4760:3: lv_catchClauses_2_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0_0_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9155);
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
                    	    if ( cnt60 >= 1 ) break loop60;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(60, input);
                                throw eee;
                        }
                        cnt60++;
                    } while (true);

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4782:3: (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==62) ) {
                        int LA61_1 = input.LA(2);

                        if ( (synpred87_InternalXcss()) ) {
                            alt61=1;
                        }
                    }
                    switch (alt61) {
                        case 1 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4782:5: otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) )
                            {
                            otherlv_3=(Token)match(input,62,FOLLOW_62_in_ruleXTryCatchFinallyExpression9169); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	createLeafNode(otherlv_3, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_0_1_0(), null);
                                  
                            }
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4786:1: ( (lv_finallyExpression_4_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4787:1: (lv_finallyExpression_4_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4787:1: (lv_finallyExpression_4_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4788:3: lv_finallyExpression_4_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_1_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9190);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4811:6: (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4811:6: (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4811:8: otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) )
                    {
                    otherlv_5=(Token)match(input,62,FOLLOW_62_in_ruleXTryCatchFinallyExpression9212); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4815:1: ( (lv_finallyExpression_6_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4816:1: (lv_finallyExpression_6_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4816:1: (lv_finallyExpression_6_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4817:3: lv_finallyExpression_6_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9233);
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
        }
        return current;
    }
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4847:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4848:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4849:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCatchClauseRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9271);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause9281); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4856:1: ruleXCatchClause returns [EObject current=null] : (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4861:6: ( (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4862:1: (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4862:1: (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4862:3: otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_63_in_ruleXCatchClause9318); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleXCatchClause9330); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4870:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4871:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4871:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4872:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause9351);
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

            otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleXCatchClause9363); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4898:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4899:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4899:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4900:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause9384);
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
        }
        return current;
    }
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4930:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4931:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4932:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference9420);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference9430); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4939:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4944:6: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4945:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4945:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_ID) ) {
                alt63=1;
            }
            else if ( (LA63_0==41||LA63_0==64) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4946:2: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference9480);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4959:2: this_XFunctionTypeRef_1= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference9510);
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
        }
        return current;
    }
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4978:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4979:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4980:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXFunctionTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef9545);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef9555); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4987:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4992:6: ( ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4993:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4993:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4993:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4993:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==41) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4993:4: otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleXFunctionTypeRef9593); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4997:1: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4998:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4998:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4999:3: lv_paramTypes_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9614);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5021:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==40) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5021:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleXFunctionTypeRef9627); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5025:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5026:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5026:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5027:3: lv_paramTypes_3_0= ruleJvmTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9648);
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
                    	    break loop64;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,42,FOLLOW_42_in_ruleXFunctionTypeRef9662); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_3(), null);
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,64,FOLLOW_64_in_ruleXFunctionTypeRef9676); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5057:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5058:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5058:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5059:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9697);
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
        }
        return current;
    }
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5089:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5090:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5091:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference9733);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference9743); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5098:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5103:6: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5104:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5104:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5104:2: ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5104:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5105:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5105:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5106:3: ruleQualifiedName
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
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference9795);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5123:2: (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==30) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5123:4: otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleJvmParameterizedTypeReference9808); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5127:1: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5128:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5128:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5129:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference9829);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

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
                      	        		"JvmArgumentTypeReference", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5151:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==40) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5151:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,40,FOLLOW_40_in_ruleJvmParameterizedTypeReference9842); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5155:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5156:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5156:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5157:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference9863);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

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
                    	      	        		"JvmArgumentTypeReference", 
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
                    	    break loop66;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleJvmParameterizedTypeReference9877); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5191:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5192:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5193:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference9915);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference9925); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5200:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5205:6: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5206:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5206:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_ID||LA68_0==41||LA68_0==64) ) {
                alt68=1;
            }
            else if ( (LA68_0==65) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5207:2: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference9975);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmTypeReference_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5220:2: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference10005);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmWildcardTypeReference_1; 
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
        }
        return current;
    }
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5239:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5240:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5241:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference10040);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference10050); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5248:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5253:6: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5254:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5254:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5254:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5254:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5255:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleJvmWildcardTypeReference10099); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5272:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt69=3;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==66) ) {
                alt69=1;
            }
            else if ( (LA69_0==68) ) {
                alt69=2;
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5272:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5272:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5273:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5273:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5274:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference10121);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJvmWildcardTypeReferenceRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5297:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5297:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5298:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5298:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5299:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference10148);
                    lv_constraints_3_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJvmWildcardTypeReferenceRule().getType().getClassifier());
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
        }
        return current;
    }
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5329:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5330:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5331:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmUpperBoundRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound10186);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound10196); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5338:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5343:6: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5344:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5344:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5344:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,66,FOLLOW_66_in_ruleJvmUpperBound10233); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5348:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5349:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5349:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5350:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound10254);
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
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5380:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5381:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5382:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmUpperBoundAndedRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded10290);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded10300); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5389:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5394:6: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5395:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5395:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5395:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_67_in_ruleJvmUpperBoundAnded10337); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5399:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5400:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5400:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5401:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded10358);
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
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5431:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5432:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5433:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmLowerBoundRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound10394);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound10404); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5440:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5445:6: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5446:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5446:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5446:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_68_in_ruleJvmLowerBound10441); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5450:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5451:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5451:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5452:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound10462);
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
        }
        return current;
    }
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5484:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5485:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5486:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10501);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10512); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5493:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5498:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5499:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5499:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5499:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName10552); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  createLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5506:1: (kw= '.' this_ID_2= RULE_ID )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==39) ) {
                    int LA70_2 = input.LA(2);

                    if ( (LA70_2==RULE_ID) ) {
                        int LA70_3 = input.LA(3);

                        if ( (synpred97_InternalXcss()) ) {
                            alt70=1;
                        }


                    }


                }


                switch (alt70) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5507:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,39,FOLLOW_39_in_ruleQualifiedName10571); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName10586); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          createLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop70;
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "ruleSizeUnit"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5527:1: ruleSizeUnit returns [Enumerator current=null] : ( (enumLiteral_0= 'em' ) | (enumLiteral_1= 'pt' ) | (enumLiteral_2= 'px' ) | (enumLiteral_3= '%' ) ) ;
    public final Enumerator ruleSizeUnit() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5531:6: ( ( (enumLiteral_0= 'em' ) | (enumLiteral_1= 'pt' ) | (enumLiteral_2= 'px' ) | (enumLiteral_3= '%' ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5532:1: ( (enumLiteral_0= 'em' ) | (enumLiteral_1= 'pt' ) | (enumLiteral_2= 'px' ) | (enumLiteral_3= '%' ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5532:1: ( (enumLiteral_0= 'em' ) | (enumLiteral_1= 'pt' ) | (enumLiteral_2= 'px' ) | (enumLiteral_3= '%' ) )
            int alt71=4;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt71=1;
                }
                break;
            case 70:
                {
                alt71=2;
                }
                break;
            case 71:
                {
                alt71=3;
                }
                break;
            case 37:
                {
                alt71=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5532:2: (enumLiteral_0= 'em' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5532:2: (enumLiteral_0= 'em' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5532:4: enumLiteral_0= 'em'
                    {
                    enumLiteral_0=(Token)match(input,69,FOLLOW_69_in_ruleSizeUnit10647); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSizeUnitAccess().getEmEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(enumLiteral_0, grammarAccess.getSizeUnitAccess().getEmEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5538:6: (enumLiteral_1= 'pt' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5538:6: (enumLiteral_1= 'pt' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5538:8: enumLiteral_1= 'pt'
                    {
                    enumLiteral_1=(Token)match(input,70,FOLLOW_70_in_ruleSizeUnit10664); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSizeUnitAccess().getPtEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(enumLiteral_1, grammarAccess.getSizeUnitAccess().getPtEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5544:6: (enumLiteral_2= 'px' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5544:6: (enumLiteral_2= 'px' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5544:8: enumLiteral_2= 'px'
                    {
                    enumLiteral_2=(Token)match(input,71,FOLLOW_71_in_ruleSizeUnit10681); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSizeUnitAccess().getPxEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(enumLiteral_2, grammarAccess.getSizeUnitAccess().getPxEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5550:6: (enumLiteral_3= '%' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5550:6: (enumLiteral_3= '%' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5550:8: enumLiteral_3= '%'
                    {
                    enumLiteral_3=(Token)match(input,37,FOLLOW_37_in_ruleSizeUnit10698); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSizeUnitAccess().getPercentEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              createLeafNode(enumLiteral_3, grammarAccess.getSizeUnitAccess().getPercentEnumLiteralDeclaration_3(), null); 
                          
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
        }
        return current;
    }
    // $ANTLR end "ruleSizeUnit"

    // $ANTLR start synpred6_InternalXcss
    public final void synpred6_InternalXcss_fragment() throws RecognitionException {   
        EObject this_FontLiteral_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:610:2: (this_FontLiteral_0= ruleFontLiteral )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:610:2: this_FontLiteral_0= ruleFontLiteral
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleFontLiteral_in_synpred6_InternalXcss1174);
        this_FontLiteral_0=ruleFontLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalXcss

    // $ANTLR start synpred7_InternalXcss
    public final void synpred7_InternalXcss_fragment() throws RecognitionException {   
        EObject this_ColorLiteral_1 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:623:2: (this_ColorLiteral_1= ruleColorLiteral )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:623:2: this_ColorLiteral_1= ruleColorLiteral
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleColorLiteral_in_synpred7_InternalXcss1204);
        this_ColorLiteral_1=ruleColorLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalXcss

    // $ANTLR start synpred9_InternalXcss
    public final void synpred9_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:3: ( ( (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:3: ( (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:3: ( (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:4: (otherlv_1= 'font' )? ( (lv_name_2_0= ruleStringOrID ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:4: (otherlv_1= 'font' )?
        int alt72=2;
        int LA72_0 = input.LA(1);

        if ( (LA72_0==18) ) {
            alt72=1;
        }
        switch (alt72) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:6: otherlv_1= 'font'
                {
                otherlv_1=(Token)match(input,18,FOLLOW_18_in_synpred9_InternalXcss1341); if (state.failed) return ;

                }
                break;

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:699:3: ( (lv_name_2_0= ruleStringOrID ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:700:1: (lv_name_2_0= ruleStringOrID )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:700:1: (lv_name_2_0= ruleStringOrID )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:701:3: lv_name_2_0= ruleStringOrID
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getFontLiteralAccess().getNameStringOrIDParserRuleCall_1_0_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleStringOrID_in_synpred9_InternalXcss1364);
        lv_name_2_0=ruleStringOrID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalXcss

    // $ANTLR start synpred10_InternalXcss
    public final void synpred10_InternalXcss_fragment() throws RecognitionException {   
        Token lv_italic_5_0=null;

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:737:4: ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:737:4: ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:737:4: ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:738:5: {...}? => ( ( (lv_italic_5_0= 'I' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_InternalXcss", "getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 0)");
        }
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:738:108: ( ( (lv_italic_5_0= 'I' ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:739:6: ( (lv_italic_5_0= 'I' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 0);
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:742:6: ( (lv_italic_5_0= 'I' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:743:1: (lv_italic_5_0= 'I' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:743:1: (lv_italic_5_0= 'I' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:744:3: lv_italic_5_0= 'I'
        {
        lv_italic_5_0=(Token)match(input,19,FOLLOW_19_in_synpred10_InternalXcss1444); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred10_InternalXcss

    // $ANTLR start synpred11_InternalXcss
    public final void synpred11_InternalXcss_fragment() throws RecognitionException {   
        Token lv_bold_6_0=null;

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:770:4: ( ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:770:4: ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:770:4: ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:771:5: {...}? => ( ( (lv_bold_6_0= 'B' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred11_InternalXcss", "getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 1)");
        }
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:771:108: ( ( (lv_bold_6_0= 'B' ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:772:6: ( (lv_bold_6_0= 'B' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 1);
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:775:6: ( (lv_bold_6_0= 'B' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:776:1: (lv_bold_6_0= 'B' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:776:1: (lv_bold_6_0= 'B' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:777:3: lv_bold_6_0= 'B'
        {
        lv_bold_6_0=(Token)match(input,20,FOLLOW_20_in_synpred11_InternalXcss1525); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred11_InternalXcss

    // $ANTLR start synpred12_InternalXcss
    public final void synpred12_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_size_7_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:803:4: ( ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:803:4: ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:803:4: ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:804:5: {...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred12_InternalXcss", "getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 2)");
        }
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:804:108: ( ( (lv_size_7_0= ruleSizeLiteral ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:805:6: ( (lv_size_7_0= ruleSizeLiteral ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 2);
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:808:6: ( (lv_size_7_0= ruleSizeLiteral ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:809:1: (lv_size_7_0= ruleSizeLiteral )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:809:1: (lv_size_7_0= ruleSizeLiteral )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:810:3: lv_size_7_0= ruleSizeLiteral
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getFontLiteralAccess().getSizeSizeLiteralParserRuleCall_2_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleSizeLiteral_in_synpred12_InternalXcss1609);
        lv_size_7_0=ruleSizeLiteral();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred12_InternalXcss

    // $ANTLR start synpred15_InternalXcss
    public final void synpred15_InternalXcss_fragment() throws RecognitionException {   
        EObject this_CssLiterals_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1128:2: (this_CssLiterals_0= ruleCssLiterals )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1128:2: this_CssLiterals_0= ruleCssLiterals
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleCssLiterals_in_synpred15_InternalXcss2306);
        this_CssLiterals_0=ruleCssLiterals();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalXcss

    // $ANTLR start synpred16_InternalXcss
    public final void synpred16_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XClosure_1 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1141:2: (this_XClosure_1= ruleXClosure )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1141:2: this_XClosure_1= ruleXClosure
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXClosure_in_synpred16_InternalXcss2336);
        this_XClosure_1=ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalXcss

    // $ANTLR start synpred18_InternalXcss
    public final void synpred18_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XIntLiteral_3 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1167:2: (this_XIntLiteral_3= ruleXIntLiteral )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1167:2: this_XIntLiteral_3= ruleXIntLiteral
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXIntLiteral_in_synpred18_InternalXcss2396);
        this_XIntLiteral_3=ruleXIntLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalXcss

    // $ANTLR start synpred20_InternalXcss
    public final void synpred20_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XStringLiteral_5 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1193:2: (this_XStringLiteral_5= ruleXStringLiteral )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1193:2: this_XStringLiteral_5= ruleXStringLiteral
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXStringLiteral_in_synpred20_InternalXcss2456);
        this_XStringLiteral_5=ruleXStringLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalXcss

    // $ANTLR start synpred21_InternalXcss
    public final void synpred21_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XTypeLiteral_6 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1206:2: (this_XTypeLiteral_6= ruleXTypeLiteral )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1206:2: this_XTypeLiteral_6= ruleXTypeLiteral
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXTypeLiteral_in_synpred21_InternalXcss2486);
        this_XTypeLiteral_6=ruleXTypeLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalXcss

    // $ANTLR start synpred25_InternalXcss
    public final void synpred25_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XFeatureCall_10 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1258:2: (this_XFeatureCall_10= ruleXFeatureCall )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1258:2: this_XFeatureCall_10= ruleXFeatureCall
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXFeatureCall_in_synpred25_InternalXcss2606);
        this_XFeatureCall_10=ruleXFeatureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalXcss

    // $ANTLR start synpred30_InternalXcss
    public final void synpred30_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XCastedExpression_15 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1323:2: (this_XCastedExpression_15= ruleXCastedExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1323:2: this_XCastedExpression_15= ruleXCastedExpression
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXCastedExpression_in_synpred30_InternalXcss2756);
        this_XCastedExpression_15=ruleXCastedExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalXcss

    // $ANTLR start synpred33_InternalXcss
    public final void synpred33_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_value_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1443:2: ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1443:2: () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1443:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1444:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1462:2: ( ( ruleOpAssign ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1463:1: ( ruleOpAssign )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1463:1: ( ruleOpAssign )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1464:3: ruleOpAssign
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAssign_in_synpred33_InternalXcss3073);
        ruleOpAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1481:2: ( (lv_value_3_0= ruleXAssignment ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1482:1: (lv_value_3_0= ruleXAssignment )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1482:1: (lv_value_3_0= ruleXAssignment )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1483:3: lv_value_3_0= ruleXAssignment
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAssignment_in_synpred33_InternalXcss3094);
        lv_value_3_0=ruleXAssignment();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred33_InternalXcss

    // $ANTLR start synpred34_InternalXcss
    public final void synpred34_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1540:2: ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1540:2: () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1540:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1541:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1559:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1560:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1560:1: ( ruleOpOr )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1561:3: ruleOpOr
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpOr_in_synpred34_InternalXcss3231);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1578:2: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1579:1: (lv_rightOperand_3_0= ruleXAndExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1579:1: (lv_rightOperand_3_0= ruleXAndExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1580:3: lv_rightOperand_3_0= ruleXAndExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAndExpression_in_synpred34_InternalXcss3252);
        lv_rightOperand_3_0=ruleXAndExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred34_InternalXcss

    // $ANTLR start synpred35_InternalXcss
    public final void synpred35_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1666:2: ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1666:2: () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1666:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1667:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1685:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1686:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1686:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1687:3: ruleOpAnd
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAnd_in_synpred35_InternalXcss3477);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1704:2: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1705:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1705:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1706:3: lv_rightOperand_3_0= ruleXEqualityExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXEqualityExpression_in_synpred35_InternalXcss3498);
        lv_rightOperand_3_0=ruleXEqualityExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred35_InternalXcss

    // $ANTLR start synpred36_InternalXcss
    public final void synpred36_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1792:2: ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1792:2: () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1792:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1793:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1811:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1812:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1812:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1813:3: ruleOpEquality
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpEquality_in_synpred36_InternalXcss3723);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1830:2: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1831:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1831:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1832:3: lv_rightOperand_3_0= ruleXRelationalExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXRelationalExpression_in_synpred36_InternalXcss3744);
        lv_rightOperand_3_0=ruleXRelationalExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred36_InternalXcss

    // $ANTLR start synpred38_InternalXcss
    public final void synpred38_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1925:2: ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1925:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1925:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1925:3: () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1925:3: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1926:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_2=(Token)match(input,26,FOLLOW_26_in_synpred38_InternalXcss3976); if (state.failed) return ;
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1948:1: ( ( ruleQualifiedName ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1949:1: ( ruleQualifiedName )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1949:1: ( ruleQualifiedName )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1950:3: ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred38_InternalXcss4003);
        ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred38_InternalXcss

    // $ANTLR start synpred39_InternalXcss
    public final void synpred39_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_6_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1968:6: ( ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1968:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1968:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1968:7: () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1968:7: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1969:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1987:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1988:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1988:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1989:3: ruleOpCompare
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpCompare_in_synpred39_InternalXcss4050);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2006:2: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2007:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2007:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2008:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_synpred39_InternalXcss4071);
        lv_rightOperand_6_0=ruleXOtherOperatorExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred39_InternalXcss

    // $ANTLR start synpred43_InternalXcss
    public final void synpred43_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2115:2: ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2115:2: () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2115:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2116:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2134:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2135:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2135:1: ( ruleOpOther )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2136:3: ruleOpOther
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpOther_in_synpred43_InternalXcss4356);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2153:2: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2154:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2154:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2155:3: lv_rightOperand_3_0= ruleXAdditiveExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAdditiveExpression_in_synpred43_InternalXcss4377);
        lv_rightOperand_3_0=ruleXAdditiveExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred43_InternalXcss

    // $ANTLR start synpred45_InternalXcss
    public final void synpred45_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2248:2: ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2248:2: () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2248:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2249:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2267:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2268:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2268:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2269:3: ruleOpAdd
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAdd_in_synpred45_InternalXcss4623);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2286:2: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2287:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2287:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2288:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_synpred45_InternalXcss4644);
        lv_rightOperand_3_0=ruleXMultiplicativeExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred45_InternalXcss

    // $ANTLR start synpred47_InternalXcss
    public final void synpred47_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2381:2: ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2381:2: () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2381:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2382:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2400:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2401:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2401:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2402:3: ruleOpMulti
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpMulti_in_synpred47_InternalXcss4890);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2419:2: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2420:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2420:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2421:3: lv_rightOperand_3_0= ruleXUnaryOperation
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXUnaryOperation_in_synpred47_InternalXcss4911);
        lv_rightOperand_3_0=ruleXUnaryOperation();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred47_InternalXcss

    // $ANTLR start synpred58_InternalXcss
    public final void synpred58_InternalXcss_fragment() throws RecognitionException {   
        Token lv_explicitOperationCall_9_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_memberCallArguments_10_0 = null;

        EObject lv_memberCallArguments_12_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2764:3: ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2764:3: ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')'
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2764:3: ( (lv_explicitOperationCall_9_0= '(' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2765:1: (lv_explicitOperationCall_9_0= '(' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2765:1: (lv_explicitOperationCall_9_0= '(' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2766:3: lv_explicitOperationCall_9_0= '('
        {
        lv_explicitOperationCall_9_0=(Token)match(input,41,FOLLOW_41_in_synpred58_InternalXcss5598); if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2785:2: ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )?
        int alt76=2;
        int LA76_0 = input.LA(1);

        if ( ((LA76_0>=RULE_ID && LA76_0<=RULE_INT)||LA76_0==11||LA76_0==18||LA76_0==21||LA76_0==30||(LA76_0>=33 && LA76_0<=34)||LA76_0==38||LA76_0==41||(LA76_0>=43 && LA76_0<=44)||LA76_0==46||(LA76_0>=49 && LA76_0<=51)||(LA76_0>=55 && LA76_0<=58)||(LA76_0>=60 && LA76_0<=61)||LA76_0==64) ) {
            alt76=1;
        }
        switch (alt76) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2785:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2785:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2786:1: (lv_memberCallArguments_10_0= ruleXExpression )
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2786:1: (lv_memberCallArguments_10_0= ruleXExpression )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2787:3: lv_memberCallArguments_10_0= ruleXExpression
                {
                if ( state.backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_0_0(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleXExpression_in_synpred58_InternalXcss5633);
                lv_memberCallArguments_10_0=ruleXExpression();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2809:2: (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                loop75:
                do {
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==40) ) {
                        alt75=1;
                    }


                    switch (alt75) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2809:4: otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                	    {
                	    otherlv_11=(Token)match(input,40,FOLLOW_40_in_synpred58_InternalXcss5646); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2813:1: ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2814:1: (lv_memberCallArguments_12_0= ruleXExpression )
                	    {
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2814:1: (lv_memberCallArguments_12_0= ruleXExpression )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2815:3: lv_memberCallArguments_12_0= ruleXExpression
                	    {
                	    if ( state.backtracking==0 ) {
                	       
                	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_1_1_0(), currentNode); 
                	      	    
                	    }
                	    pushFollow(FOLLOW_ruleXExpression_in_synpred58_InternalXcss5667);
                	    lv_memberCallArguments_12_0=ruleXExpression();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop75;
                    }
                } while (true);


                }
                break;

        }

        otherlv_13=(Token)match(input,42,FOLLOW_42_in_synpred58_InternalXcss5683); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_InternalXcss

    // $ANTLR start synpred59_InternalXcss
    public final void synpred59_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_explicitOperationCall_9_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_4_0 = null;

        EObject lv_typeArguments_6_0 = null;

        EObject lv_memberCallArguments_10_0 = null;

        EObject lv_memberCallArguments_12_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2664:2: ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2664:2: () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2664:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2665:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_2=(Token)match(input,39,FOLLOW_39_in_synpred59_InternalXcss5471); if (state.failed) return ;
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2687:1: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
        int alt78=2;
        int LA78_0 = input.LA(1);

        if ( (LA78_0==30) ) {
            alt78=1;
        }
        switch (alt78) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2687:3: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                {
                otherlv_3=(Token)match(input,30,FOLLOW_30_in_synpred59_InternalXcss5484); if (state.failed) return ;
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2691:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2692:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2692:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2693:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                {
                if ( state.backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_synpred59_InternalXcss5505);
                lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2715:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                loop77:
                do {
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==40) ) {
                        alt77=1;
                    }


                    switch (alt77) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2715:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                	    {
                	    otherlv_5=(Token)match(input,40,FOLLOW_40_in_synpred59_InternalXcss5518); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2719:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2720:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                	    {
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2720:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2721:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                	    {
                	    if ( state.backtracking==0 ) {
                	       
                	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_2_1_0(), currentNode); 
                	      	    
                	    }
                	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_synpred59_InternalXcss5539);
                	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop77;
                    }
                } while (true);

                otherlv_7=(Token)match(input,29,FOLLOW_29_in_synpred59_InternalXcss5553); if (state.failed) return ;

                }
                break;

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2747:3: ( (otherlv_8= RULE_ID ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2748:1: (otherlv_8= RULE_ID )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2748:1: (otherlv_8= RULE_ID )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2749:3: otherlv_8= RULE_ID
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred59_InternalXcss5579); if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2764:2: ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
        int alt81=2;
        int LA81_0 = input.LA(1);

        if ( (LA81_0==41) ) {
            alt81=1;
        }
        switch (alt81) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2764:3: ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')'
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2764:3: ( (lv_explicitOperationCall_9_0= '(' ) )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2765:1: (lv_explicitOperationCall_9_0= '(' )
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2765:1: (lv_explicitOperationCall_9_0= '(' )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2766:3: lv_explicitOperationCall_9_0= '('
                {
                lv_explicitOperationCall_9_0=(Token)match(input,41,FOLLOW_41_in_synpred59_InternalXcss5598); if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2785:2: ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )?
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( ((LA80_0>=RULE_ID && LA80_0<=RULE_INT)||LA80_0==11||LA80_0==18||LA80_0==21||LA80_0==30||(LA80_0>=33 && LA80_0<=34)||LA80_0==38||LA80_0==41||(LA80_0>=43 && LA80_0<=44)||LA80_0==46||(LA80_0>=49 && LA80_0<=51)||(LA80_0>=55 && LA80_0<=58)||(LA80_0>=60 && LA80_0<=61)||LA80_0==64) ) {
                    alt80=1;
                }
                switch (alt80) {
                    case 1 :
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2785:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                        {
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2785:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) )
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2786:1: (lv_memberCallArguments_10_0= ruleXExpression )
                        {
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2786:1: (lv_memberCallArguments_10_0= ruleXExpression )
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2787:3: lv_memberCallArguments_10_0= ruleXExpression
                        {
                        if ( state.backtracking==0 ) {
                           
                          	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_0_0(), currentNode); 
                          	    
                        }
                        pushFollow(FOLLOW_ruleXExpression_in_synpred59_InternalXcss5633);
                        lv_memberCallArguments_10_0=ruleXExpression();

                        state._fsp--;
                        if (state.failed) return ;

                        }


                        }

                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2809:2: (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                        loop79:
                        do {
                            int alt79=2;
                            int LA79_0 = input.LA(1);

                            if ( (LA79_0==40) ) {
                                alt79=1;
                            }


                            switch (alt79) {
                        	case 1 :
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2809:4: otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                        	    {
                        	    otherlv_11=(Token)match(input,40,FOLLOW_40_in_synpred59_InternalXcss5646); if (state.failed) return ;
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2813:1: ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2814:1: (lv_memberCallArguments_12_0= ruleXExpression )
                        	    {
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2814:1: (lv_memberCallArguments_12_0= ruleXExpression )
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2815:3: lv_memberCallArguments_12_0= ruleXExpression
                        	    {
                        	    if ( state.backtracking==0 ) {
                        	       
                        	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_1_1_0(), currentNode); 
                        	      	    
                        	    }
                        	    pushFollow(FOLLOW_ruleXExpression_in_synpred59_InternalXcss5667);
                        	    lv_memberCallArguments_12_0=ruleXExpression();

                        	    state._fsp--;
                        	    if (state.failed) return ;

                        	    }


                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop79;
                            }
                        } while (true);


                        }
                        break;

                }

                otherlv_13=(Token)match(input,42,FOLLOW_42_in_synpred59_InternalXcss5683); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred59_InternalXcss

    // $ANTLR start synpred62_InternalXcss
    public final void synpred62_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3163:4: (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3163:4: otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) )
        {
        otherlv_5=(Token)match(input,45,FOLLOW_45_in_synpred62_InternalXcss6281); if (state.failed) return ;
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3167:1: ( (lv_else_6_0= ruleXExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3168:1: (lv_else_6_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3168:1: (lv_else_6_0= ruleXExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3169:3: lv_else_6_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_5_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred62_InternalXcss6302);
        lv_else_6_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred62_InternalXcss

    // $ANTLR start synpred63_InternalXcss
    public final void synpred63_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_switch_1_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3219:1: ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3219:1: (lv_switch_1_0= ruleXExpressionInsideBlock )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3219:1: (lv_switch_1_0= ruleXExpressionInsideBlock )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3220:3: lv_switch_1_0= ruleXExpressionInsideBlock
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionInsideBlockParserRuleCall_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_synpred63_InternalXcss6408);
        lv_switch_1_0=ruleXExpressionInsideBlock();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred63_InternalXcss

    // $ANTLR start synpred65_InternalXcss
    public final void synpred65_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        EObject lv_default_6_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3278:2: ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3278:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3278:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3278:3: ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';'
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3278:3: ( (lv_default_6_0= ruleXExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3279:1: (lv_default_6_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3279:1: (lv_default_6_0= ruleXExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3280:3: lv_default_6_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_4_2_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred65_InternalXcss6491);
        lv_default_6_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_7=(Token)match(input,16,FOLLOW_16_in_synpred65_InternalXcss6503); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred65_InternalXcss

    // $ANTLR start synpred69_InternalXcss
    public final void synpred69_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_then_4_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3414:2: ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3414:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3414:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3414:3: ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';'
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3414:3: ( (lv_then_4_0= ruleXExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3415:1: (lv_then_4_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3415:1: (lv_then_4_0= ruleXExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3416:3: lv_then_4_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred69_InternalXcss6710);
        lv_then_4_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_5=(Token)match(input,16,FOLLOW_16_in_synpred69_InternalXcss6722); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred69_InternalXcss

    // $ANTLR start synpred80_InternalXcss
    public final void synpred80_InternalXcss_fragment() throws RecognitionException {   
        Token lv_explicitOperationCall_6_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_featureCallArguments_7_0 = null;

        EObject lv_featureCallArguments_9_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4165:3: ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4165:3: ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')'
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4165:3: ( (lv_explicitOperationCall_6_0= '(' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4166:1: (lv_explicitOperationCall_6_0= '(' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4166:1: (lv_explicitOperationCall_6_0= '(' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4167:3: lv_explicitOperationCall_6_0= '('
        {
        lv_explicitOperationCall_6_0=(Token)match(input,41,FOLLOW_41_in_synpred80_InternalXcss8026); if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4186:2: ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )?
        int alt88=2;
        int LA88_0 = input.LA(1);

        if ( ((LA88_0>=RULE_ID && LA88_0<=RULE_INT)||LA88_0==11||LA88_0==18||LA88_0==21||LA88_0==30||(LA88_0>=33 && LA88_0<=34)||LA88_0==38||LA88_0==41||(LA88_0>=43 && LA88_0<=44)||LA88_0==46||(LA88_0>=49 && LA88_0<=51)||(LA88_0>=55 && LA88_0<=58)||(LA88_0>=60 && LA88_0<=61)||LA88_0==64) ) {
            alt88=1;
        }
        switch (alt88) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4186:3: ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4186:3: ( (lv_featureCallArguments_7_0= ruleXExpression ) )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4187:1: (lv_featureCallArguments_7_0= ruleXExpression )
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4187:1: (lv_featureCallArguments_7_0= ruleXExpression )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4188:3: lv_featureCallArguments_7_0= ruleXExpression
                {
                if ( state.backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_0_0(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleXExpression_in_synpred80_InternalXcss8061);
                lv_featureCallArguments_7_0=ruleXExpression();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4210:2: (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                loop87:
                do {
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==40) ) {
                        alt87=1;
                    }


                    switch (alt87) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4210:4: otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                	    {
                	    otherlv_8=(Token)match(input,40,FOLLOW_40_in_synpred80_InternalXcss8074); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4214:1: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4215:1: (lv_featureCallArguments_9_0= ruleXExpression )
                	    {
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4215:1: (lv_featureCallArguments_9_0= ruleXExpression )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4216:3: lv_featureCallArguments_9_0= ruleXExpression
                	    {
                	    if ( state.backtracking==0 ) {
                	       
                	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_1_1_0(), currentNode); 
                	      	    
                	    }
                	    pushFollow(FOLLOW_ruleXExpression_in_synpred80_InternalXcss8095);
                	    lv_featureCallArguments_9_0=ruleXExpression();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop87;
                    }
                } while (true);


                }
                break;

        }

        otherlv_10=(Token)match(input,42,FOLLOW_42_in_synpred80_InternalXcss8111); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred80_InternalXcss

    // $ANTLR start synpred86_InternalXcss
    public final void synpred86_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_catchClauses_2_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4759:1: ( (lv_catchClauses_2_0= ruleXCatchClause ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4759:1: (lv_catchClauses_2_0= ruleXCatchClause )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4759:1: (lv_catchClauses_2_0= ruleXCatchClause )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4760:3: lv_catchClauses_2_0= ruleXCatchClause
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXCatchClause_in_synpred86_InternalXcss9155);
        lv_catchClauses_2_0=ruleXCatchClause();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred86_InternalXcss

    // $ANTLR start synpred87_InternalXcss
    public final void synpred87_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        EObject lv_finallyExpression_4_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4782:5: (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4782:5: otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) )
        {
        otherlv_3=(Token)match(input,62,FOLLOW_62_in_synpred87_InternalXcss9169); if (state.failed) return ;
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4786:1: ( (lv_finallyExpression_4_0= ruleXExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4787:1: (lv_finallyExpression_4_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4787:1: (lv_finallyExpression_4_0= ruleXExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4788:3: lv_finallyExpression_4_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred87_InternalXcss9190);
        lv_finallyExpression_4_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred87_InternalXcss

    // $ANTLR start synpred97_InternalXcss
    public final void synpred97_InternalXcss_fragment() throws RecognitionException {   
        Token kw=null;
        Token this_ID_2=null;

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5507:2: (kw= '.' this_ID_2= RULE_ID )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5507:2: kw= '.' this_ID_2= RULE_ID
        {
        kw=(Token)match(input,39,FOLLOW_39_in_synpred97_InternalXcss10571); if (state.failed) return ;
        this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred97_InternalXcss10586); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred97_InternalXcss

    // Delegated rules

    public final boolean synpred47_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred80_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred63_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred63_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred97_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred97_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA54 dfa54 = new DFA54(this);
    static final String DFA9_eotS =
        "\12\uffff";
    static final String DFA9_eofS =
        "\1\1\11\uffff";
    static final String DFA9_minS =
        "\1\4\1\uffff\1\4\2\uffff\4\0\1\uffff";
    static final String DFA9_maxS =
        "\1\100\1\uffff\1\107\2\uffff\4\0\1\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\4\1\uffff\1\1\1\2\4\uffff\1\3";
    static final String DFA9_specialS =
        "\1\3\4\uffff\1\2\1\4\1\1\1\0\1\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\1\1\2\4\uffff\3\1\1\uffff\4\1\1\3\1\4\32\1\2\uffff\5\1\1"+
            "\uffff\4\1\1\uffff\5\1",
            "",
            "\3\1\4\uffff\3\1\2\uffff\3\1\2\uffff\20\1\1\10\2\1\1\uffff"+
            "\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff\5\1\1\uffff\4\1\1\uffff"+
            "\2\1\2\uffff\1\1\4\uffff\1\5\1\6\1\7",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "()* loopback of 735:3: ( ({...}? => ( ( (lv_italic_5_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_6_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_7_0= ruleSizeLiteral ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_8 = input.LA(1);

                         
                        int index9_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred12_InternalXcss() && getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 2) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_7 = input.LA(1);

                         
                        int index9_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred12_InternalXcss() && getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 2) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_5 = input.LA(1);

                         
                        int index9_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred12_InternalXcss() && getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 2) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_0 = input.LA(1);

                         
                        int index9_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA9_0==EOF||(LA9_0>=RULE_ID && LA9_0<=RULE_STRING)||(LA9_0>=11 && LA9_0<=13)||(LA9_0>=15 && LA9_0<=18)||(LA9_0>=21 && LA9_0<=46)||(LA9_0>=49 && LA9_0<=53)||(LA9_0>=55 && LA9_0<=58)||(LA9_0>=60 && LA9_0<=64)) ) {s = 1;}

                        else if ( (LA9_0==RULE_INT) ) {s = 2;}

                        else if ( LA9_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 0) ) {s = 3;}

                        else if ( LA9_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 1) ) {s = 4;}

                         
                        input.seek(index9_0);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_6 = input.LA(1);

                         
                        int index9_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred12_InternalXcss() && getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_2(), 2) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA12_eotS =
        "\33\uffff";
    static final String DFA12_eofS =
        "\33\uffff";
    static final String DFA12_minS =
        "\1\4\1\uffff\2\0\1\uffff\2\0\24\uffff";
    static final String DFA12_maxS =
        "\1\100\1\uffff\2\0\1\uffff\2\0\24\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\5\uffff\1\2\1\uffff\1\3\1\uffff\1\5\1\10\1\11\1\12"+
        "\1\13\1\14\1\15\1\16\1\17\1\21\1\22\1\6\1\7\1\4\1\20\1\23";
    static final String DFA12_specialS =
        "\2\uffff\1\0\1\1\1\uffff\1\2\1\3\24\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\3\1\2\1\5\4\uffff\1\15\6\uffff\1\1\2\uffff\1\1\10\uffff\1"+
            "\17\12\uffff\1\6\1\uffff\1\7\1\20\1\uffff\1\16\2\uffff\1\21"+
            "\1\22\1\23\3\uffff\1\14\2\11\1\13\1\uffff\1\24\1\25\2\uffff"+
            "\1\7",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
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

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1127:1: (this_CssLiterals_0= ruleCssLiterals | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral | this_XConstructorCall_7= ruleXConstructorCall | this_XBlockExpression_8= ruleXBlockExpression | this_XSwitchExpression_9= ruleXSwitchExpression | this_XFeatureCall_10= ruleXFeatureCall | this_XIfExpression_11= ruleXIfExpression | this_XForLoopExpression_12= ruleXForLoopExpression | this_XWhileExpression_13= ruleXWhileExpression | this_XDoWhileExpression_14= ruleXDoWhileExpression | this_XCastedExpression_15= ruleXCastedExpression | this_XThrowExpression_16= ruleXThrowExpression | this_XTryCatchFinallyExpression_17= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_18= ruleXParenthesizedExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_2 = input.LA(1);

                         
                        int index12_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalXcss()) ) {s = 1;}

                        else if ( (synpred20_InternalXcss()) ) {s = 22;}

                         
                        input.seek(index12_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_3 = input.LA(1);

                         
                        int index12_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalXcss()) ) {s = 1;}

                        else if ( (synpred16_InternalXcss()) ) {s = 7;}

                        else if ( (synpred21_InternalXcss()) ) {s = 23;}

                        else if ( (synpred25_InternalXcss()) ) {s = 15;}

                         
                        input.seek(index12_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_5 = input.LA(1);

                         
                        int index12_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalXcss()) ) {s = 1;}

                        else if ( (synpred18_InternalXcss()) ) {s = 24;}

                         
                        input.seek(index12_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_6 = input.LA(1);

                         
                        int index12_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalXcss()) ) {s = 7;}

                        else if ( (synpred30_InternalXcss()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA32_eotS =
        "\65\uffff";
    static final String DFA32_eofS =
        "\1\2\64\uffff";
    static final String DFA32_minS =
        "\1\4\1\0\63\uffff";
    static final String DFA32_maxS =
        "\1\100\1\0\63\uffff";
    static final String DFA32_acceptS =
        "\2\uffff\1\2\61\uffff\1\1";
    static final String DFA32_specialS =
        "\1\uffff\1\0\63\uffff}>";
    static final String[] DFA32_transitionS = {
            "\3\2\4\uffff\3\2\1\uffff\4\2\2\uffff\24\2\1\1\5\2\2\uffff\5"+
            "\2\1\uffff\4\2\1\uffff\5\2",
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
            return "2764:2: ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_1 = input.LA(1);

                         
                        int index32_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred58_InternalXcss()) ) {s = 52;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA37_eotS =
        "\34\uffff";
    static final String DFA37_eofS =
        "\34\uffff";
    static final String DFA37_minS =
        "\1\4\21\uffff\1\0\11\uffff";
    static final String DFA37_maxS =
        "\1\100\21\uffff\1\0\11\uffff";
    static final String DFA37_acceptS =
        "\1\uffff\1\1\31\uffff\1\2";
    static final String DFA37_specialS =
        "\22\uffff\1\0\11\uffff}>";
    static final String[] DFA37_transitionS = {
            "\3\1\4\uffff\1\22\6\uffff\1\1\2\uffff\1\1\10\uffff\1\1\2\uffff"+
            "\2\1\3\uffff\1\1\2\uffff\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff"+
            "\5\1\1\uffff\4\1\1\uffff\2\1\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "3218:1: ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_18 = input.LA(1);

                         
                        int index37_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred63_InternalXcss()) ) {s = 1;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index37_18);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA39_eotS =
        "\32\uffff";
    static final String DFA39_eofS =
        "\32\uffff";
    static final String DFA39_minS =
        "\1\4\17\uffff\1\0\11\uffff";
    static final String DFA39_maxS =
        "\1\100\17\uffff\1\0\11\uffff";
    static final String DFA39_acceptS =
        "\1\uffff\1\1\27\uffff\1\2";
    static final String DFA39_specialS =
        "\20\uffff\1\0\11\uffff}>";
    static final String[] DFA39_transitionS = {
            "\3\1\4\uffff\1\20\6\uffff\1\1\2\uffff\1\1\10\uffff\1\1\2\uffff"+
            "\2\1\3\uffff\1\1\2\uffff\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff"+
            "\3\1\3\uffff\4\1\1\uffff\2\1\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "3278:1: ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_16 = input.LA(1);

                         
                        int index39_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalXcss()) ) {s = 1;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index39_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA43_eotS =
        "\32\uffff";
    static final String DFA43_eofS =
        "\32\uffff";
    static final String DFA43_minS =
        "\1\4\17\uffff\1\0\11\uffff";
    static final String DFA43_maxS =
        "\1\100\17\uffff\1\0\11\uffff";
    static final String DFA43_acceptS =
        "\1\uffff\1\1\27\uffff\1\2";
    static final String DFA43_specialS =
        "\20\uffff\1\0\11\uffff}>";
    static final String[] DFA43_transitionS = {
            "\3\1\4\uffff\1\20\6\uffff\1\1\2\uffff\1\1\10\uffff\1\1\2\uffff"+
            "\2\1\3\uffff\1\1\2\uffff\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff"+
            "\3\1\3\uffff\4\1\1\uffff\2\1\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "3414:1: ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_16 = input.LA(1);

                         
                        int index43_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred69_InternalXcss()) ) {s = 1;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index43_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA54_eotS =
        "\65\uffff";
    static final String DFA54_eofS =
        "\1\2\64\uffff";
    static final String DFA54_minS =
        "\1\4\1\0\63\uffff";
    static final String DFA54_maxS =
        "\1\100\1\0\63\uffff";
    static final String DFA54_acceptS =
        "\2\uffff\1\2\61\uffff\1\1";
    static final String DFA54_specialS =
        "\1\uffff\1\0\63\uffff}>";
    static final String[] DFA54_transitionS = {
            "\3\2\4\uffff\3\2\1\uffff\4\2\2\uffff\24\2\1\1\5\2\2\uffff\5"+
            "\2\1\uffff\4\2\1\uffff\5\2",
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
            ""
    };

    static final short[] DFA54_eot = DFA.unpackEncodedString(DFA54_eotS);
    static final short[] DFA54_eof = DFA.unpackEncodedString(DFA54_eofS);
    static final char[] DFA54_min = DFA.unpackEncodedStringToUnsignedChars(DFA54_minS);
    static final char[] DFA54_max = DFA.unpackEncodedStringToUnsignedChars(DFA54_maxS);
    static final short[] DFA54_accept = DFA.unpackEncodedString(DFA54_acceptS);
    static final short[] DFA54_special = DFA.unpackEncodedString(DFA54_specialS);
    static final short[][] DFA54_transition;

    static {
        int numStates = DFA54_transitionS.length;
        DFA54_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA54_transition[i] = DFA.unpackEncodedString(DFA54_transitionS[i]);
        }
    }

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = DFA54_eot;
            this.eof = DFA54_eof;
            this.min = DFA54_min;
            this.max = DFA54_max;
            this.accept = DFA54_accept;
            this.special = DFA54_special;
            this.transition = DFA54_transition;
        }
        public String getDescription() {
            return "4165:2: ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA54_1 = input.LA(1);

                         
                        int index54_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalXcss()) ) {s = 52;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index54_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 54, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleStyleSheet_in_entryRuleStyleSheet81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStyleSheet91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStyleRule_in_ruleStyleSheet136 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_ruleStyleRule_in_entryRuleStyleRule172 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStyleRule182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelector_in_ruleStyleRule228 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_11_in_ruleStyleRule241 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSetting_in_ruleStyleRule262 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleStyleRule275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelector_in_entryRuleSelector311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelector321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeSelector_in_ruleSelector372 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleWildcardSelector_in_ruleSelector402 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleFilter_in_ruleSelector423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeSelector_in_entryRuleTypeSelector462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeSelector472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeSelector523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcardSelector_in_entryRuleWildcardSelector558 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcardSelector568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleWildcardSelector617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFilter_in_entryRuleFilter653 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFilter663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleFilter700 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleFilter721 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFilter733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSetting_in_entryRuleSetting769 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSetting779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureReference_in_ruleSetting837 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleOpAssign_in_ruleSetting864 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleSetting885 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSetting897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_entryRuleOpAssign934 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAssign945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleOpAssign982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureReference_in_entryRuleFeatureReference1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureReference1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureReference1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCssLiterals_in_entryRuleCssLiterals1114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCssLiterals1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFontLiteral_in_ruleCssLiterals1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColorLiteral_in_ruleCssLiterals1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSizeLiteral_in_ruleCssLiterals1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFontLiteral_in_entryRuleFontLiteral1275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFontLiteral1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleFontLiteral1341 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_ruleStringOrID_in_ruleFontLiteral1364 = new BitSet(new long[]{0x00000000003C0072L});
    public static final BitSet FOLLOW_18_in_ruleFontLiteral1383 = new BitSet(new long[]{0x00000000003C0072L});
    public static final BitSet FOLLOW_19_in_ruleFontLiteral1444 = new BitSet(new long[]{0x00000000003C0072L});
    public static final BitSet FOLLOW_20_in_ruleFontLiteral1525 = new BitSet(new long[]{0x00000000003C0072L});
    public static final BitSet FOLLOW_ruleSizeLiteral_in_ruleFontLiteral1609 = new BitSet(new long[]{0x00000000003C0072L});
    public static final BitSet FOLLOW_ruleStringOrID_in_entryRuleStringOrID1689 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringOrID1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringOrID1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStringOrID1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColorLiteral_in_entryRuleColorLiteral1811 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColorLiteral1821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColorConstant_in_ruleColorLiteral1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGB_in_ruleColorLiteral1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColorConstant_in_entryRuleColorConstant1936 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColorConstant1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleColorConstant1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGB_in_entryRuleRGB2027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRGB2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleRGB2074 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGB2091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSizeLiteral_in_entryRuleSizeLiteral2132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSizeLiteral2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSizeLiteral2184 = new BitSet(new long[]{0x0000002000000000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_ruleSizeUnit_in_ruleSizeLiteral2210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression2246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCssLiterals_in_ruleXPrimaryExpression2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXPrimaryExpression2336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXPrimaryExpression2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXPrimaryExpression2396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXPrimaryExpression2426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXPrimaryExpression2456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXPrimaryExpression2486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression2576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression2696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXPrimaryExpression2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression2846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression2881 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression2940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment2974 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment2984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment3034 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_ruleXAssignment3073 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression3132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression3142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression3192 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression3231 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression3252 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr3291 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpOr3339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression3378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3438 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression3477 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3498 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd3537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd3548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpAnd3585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression3624 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression3634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3684 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression3723 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3744 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality3783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpEquality3832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpEquality3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression3891 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression3901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression3951 = new BitSet(new long[]{0x000000007C000002L});
    public static final BitSet FOLLOW_26_in_ruleXRelationalExpression3976 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression4003 = new BitSet(new long[]{0x000000007C000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression4050 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4071 = new BitSet(new long[]{0x000000007C000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare4111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare4122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpCompare4160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpCompare4179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpCompare4198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpCompare4217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression4257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression4267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4317 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression4356 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4377 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther4416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther4427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpOther4465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpOther4484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression4524 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression4534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4584 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression4623 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4644 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd4683 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd4694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpAdd4732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpAdd4751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression4791 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression4801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression4851 = new BitSet(new long[]{0x0000003800002002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression4890 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression4911 = new BitSet(new long[]{0x0000003800002002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti4950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti4961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleOpMulti4999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpMulti5018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpMulti5037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpMulti5056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation5096 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation5106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation5171 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation5192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation5224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary5260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary5271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpUnary5309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpUnary5328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpUnary5347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall5387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall5397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall5447 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleXMemberFeatureCall5471 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_30_in_ruleXMemberFeatureCall5484 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall5505 = new BitSet(new long[]{0x0000010020000000L});
    public static final BitSet FOLLOW_40_in_ruleXMemberFeatureCall5518 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall5539 = new BitSet(new long[]{0x0000010020000000L});
    public static final BitSet FOLLOW_29_in_ruleXMemberFeatureCall5553 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXMemberFeatureCall5579 = new BitSet(new long[]{0x0000028000000002L});
    public static final BitSet FOLLOW_41_in_ruleXMemberFeatureCall5598 = new BitSet(new long[]{0x378E5E4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5633 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_40_in_ruleXMemberFeatureCall5646 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5667 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_42_in_ruleXMemberFeatureCall5683 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure5723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure5733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5792 = new BitSet(new long[]{0x0000090000000000L});
    public static final BitSet FOLLOW_40_in_ruleXClosure5805 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5826 = new BitSet(new long[]{0x0000090000000000L});
    public static final BitSet FOLLOW_43_in_ruleXClosure5842 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXClosure5863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression5899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression5909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleXCastedExpression5946 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression5967 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXCastedExpression5979 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression6000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression6046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleXParenthesizedExpression6083 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6108 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXParenthesizedExpression6119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression6165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleXIfExpression6202 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXIfExpression6214 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6235 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXIfExpression6247 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6268 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleXIfExpression6281 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression6350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleXSwitchExpression6387 = new BitSet(new long[]{0x37BE5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXSwitchExpression6408 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleXSwitchExpression6421 = new BitSet(new long[]{0x0001020000020010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6442 = new BitSet(new long[]{0x0001820000021010L,0x0000000000000001L});
    public static final BitSet FOLLOW_47_in_ruleXSwitchExpression6456 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXSwitchExpression6468 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6491 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleXSwitchExpression6503 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXSwitchExpression6531 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXSwitchExpression6546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6638 = new BitSet(new long[]{0x0001000000020000L});
    public static final BitSet FOLLOW_48_in_ruleXCasePart6652 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6673 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXCasePart6687 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6710 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleXCasePart6722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXCasePart6750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression6797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleXForLoopExpression6834 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXForLoopExpression6846 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6867 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXForLoopExpression6879 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6900 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXForLoopExpression6912 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression6979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleXWhileExpression7016 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXWhileExpression7028 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7049 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXWhileExpression7061 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression7128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleXDoWhileExpression7165 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7186 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleXDoWhileExpression7198 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXDoWhileExpression7210 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7231 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXDoWhileExpression7243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7279 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression7289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleXBlockExpression7338 = new BitSet(new long[]{0x37BE5A4640241870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7360 = new BitSet(new long[]{0x37BE5A4640251870L,0x0000000000000001L});
    public static final BitSet FOLLOW_16_in_ruleXBlockExpression7373 = new BitSet(new long[]{0x37BE5A4640241870L,0x0000000000000001L});
    public static final BitSet FOLLOW_12_in_ruleXBlockExpression7389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXVariableDeclaration7604 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_53_in_ruleXVariableDeclaration7635 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7657 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXVariableDeclaration7675 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleXVariableDeclaration7692 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter7759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7805 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJvmFormalParameter7823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall7874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleXFeatureCall7912 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7933 = new BitSet(new long[]{0x0000010020000000L});
    public static final BitSet FOLLOW_40_in_ruleXFeatureCall7946 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7967 = new BitSet(new long[]{0x0000010020000000L});
    public static final BitSet FOLLOW_29_in_ruleXFeatureCall7981 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXFeatureCall8007 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleXFeatureCall8026 = new BitSet(new long[]{0x378E5E4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8061 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_40_in_ruleXFeatureCall8074 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8095 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_42_in_ruleXFeatureCall8111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8149 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall8159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXConstructorCall8196 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8223 = new BitSet(new long[]{0x0000020040000000L});
    public static final BitSet FOLLOW_30_in_ruleXConstructorCall8236 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8257 = new BitSet(new long[]{0x0000010020000000L});
    public static final BitSet FOLLOW_40_in_ruleXConstructorCall8270 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8291 = new BitSet(new long[]{0x0000010020000000L});
    public static final BitSet FOLLOW_29_in_ruleXConstructorCall8305 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXConstructorCall8319 = new BitSet(new long[]{0x378E5E4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8341 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_40_in_ruleXConstructorCall8354 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8375 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_42_in_ruleXConstructorCall8391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral8437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleXBooleanLiteral8487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleXBooleanLiteral8512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral8571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXNullLiteral8620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral8656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral8666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral8707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral8747 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral8757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral8798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral8838 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral8848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral8900 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXTypeLiteral8912 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleXTypeLiteral8924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression8960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression8970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleXThrowExpression9007 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression9028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9064 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXTryCatchFinallyExpression9111 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9132 = new BitSet(new long[]{0xC000000000000000L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9155 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXTryCatchFinallyExpression9169 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXTryCatchFinallyExpression9212 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9271 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause9281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXCatchClause9318 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXCatchClause9330 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause9351 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXCatchClause9363 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause9384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference9420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference9430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference9480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference9510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef9545 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef9555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleXFunctionTypeRef9593 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9614 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_40_in_ruleXFunctionTypeRef9627 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9648 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_42_in_ruleXFunctionTypeRef9662 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleXFunctionTypeRef9676 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference9733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference9743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference9795 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleJvmParameterizedTypeReference9808 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference9829 = new BitSet(new long[]{0x0000010020000000L});
    public static final BitSet FOLLOW_40_in_ruleJvmParameterizedTypeReference9842 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference9863 = new BitSet(new long[]{0x0000010020000000L});
    public static final BitSet FOLLOW_29_in_ruleJvmParameterizedTypeReference9877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference9915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference9925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference9975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference10005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference10040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference10050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleJvmWildcardTypeReference10099 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000014L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference10121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference10148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound10186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound10196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleJvmUpperBound10233 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound10254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded10290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded10300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleJvmUpperBoundAnded10337 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded10358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound10394 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound10404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleJvmLowerBound10441 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound10462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10501 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10552 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleQualifiedName10571 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10586 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_69_in_ruleSizeUnit10647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleSizeUnit10664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleSizeUnit10681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleSizeUnit10698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFontLiteral_in_synpred6_InternalXcss1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColorLiteral_in_synpred7_InternalXcss1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred9_InternalXcss1341 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_ruleStringOrID_in_synpred9_InternalXcss1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred10_InternalXcss1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_synpred11_InternalXcss1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSizeLiteral_in_synpred12_InternalXcss1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCssLiterals_in_synpred15_InternalXcss2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred16_InternalXcss2336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_synpred18_InternalXcss2396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_synpred20_InternalXcss2456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_synpred21_InternalXcss2486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_synpred25_InternalXcss2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_synpred30_InternalXcss2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_synpred33_InternalXcss3073 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXAssignment_in_synpred33_InternalXcss3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred34_InternalXcss3231 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_synpred34_InternalXcss3252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred35_InternalXcss3477 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_synpred35_InternalXcss3498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred36_InternalXcss3723 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_synpred36_InternalXcss3744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_synpred38_InternalXcss3976 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred38_InternalXcss4003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred39_InternalXcss4050 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_synpred39_InternalXcss4071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred43_InternalXcss4356 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_synpred43_InternalXcss4377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred45_InternalXcss4623 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_synpred45_InternalXcss4644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred47_InternalXcss4890 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_synpred47_InternalXcss4911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred58_InternalXcss5598 = new BitSet(new long[]{0x378E5E4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred58_InternalXcss5633 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_40_in_synpred58_InternalXcss5646 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred58_InternalXcss5667 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_42_in_synpred58_InternalXcss5683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred59_InternalXcss5471 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_30_in_synpred59_InternalXcss5484 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_synpred59_InternalXcss5505 = new BitSet(new long[]{0x0000010020000000L});
    public static final BitSet FOLLOW_40_in_synpred59_InternalXcss5518 = new BitSet(new long[]{0x0000020000000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_synpred59_InternalXcss5539 = new BitSet(new long[]{0x0000010020000000L});
    public static final BitSet FOLLOW_29_in_synpred59_InternalXcss5553 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred59_InternalXcss5579 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_synpred59_InternalXcss5598 = new BitSet(new long[]{0x378E5E4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred59_InternalXcss5633 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_40_in_synpred59_InternalXcss5646 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred59_InternalXcss5667 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_42_in_synpred59_InternalXcss5683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred62_InternalXcss6281 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred62_InternalXcss6302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_synpred63_InternalXcss6408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred65_InternalXcss6491 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_synpred65_InternalXcss6503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred69_InternalXcss6710 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_synpred69_InternalXcss6722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred80_InternalXcss8026 = new BitSet(new long[]{0x378E5E4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred80_InternalXcss8061 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_40_in_synpred80_InternalXcss8074 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred80_InternalXcss8095 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_42_in_synpred80_InternalXcss8111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_synpred86_InternalXcss9155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_synpred87_InternalXcss9169 = new BitSet(new long[]{0x378E5A4640240870L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred87_InternalXcss9190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred97_InternalXcss10571 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred97_InternalXcss10586 = new BitSet(new long[]{0x0000000000000002L});

}
