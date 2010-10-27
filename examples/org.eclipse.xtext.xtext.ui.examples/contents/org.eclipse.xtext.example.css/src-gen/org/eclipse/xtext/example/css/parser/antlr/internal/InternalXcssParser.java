package org.eclipse.xtext.example.css.parser.antlr.internal; 

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'#'", "'*'", "'['", "']'", "';'", "':'", "'$'", "'('", "','", "')'", "'%'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'**'", "'/'", "'!'", "'.'", "'|'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'new'", "'false'", "'true'", "'null'", "'class'", "'throw'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'extends'", "'&'", "'super'"
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
    public static final int T__65=65;
    public static final int T__19=19;
    public static final int T__67=67;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:77:1: entryRuleStyleSheet returns [EObject current=null] : iv_ruleStyleSheet= ruleStyleSheet EOF ;
    public final EObject entryRuleStyleSheet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStyleSheet = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:78:2: (iv_ruleStyleSheet= ruleStyleSheet EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:79:2: iv_ruleStyleSheet= ruleStyleSheet EOF
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:86:1: ruleStyleSheet returns [EObject current=null] : ( () ( (lv_rules_1_0= ruleStyleRule ) )* ) ;
    public final EObject ruleStyleSheet() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:91:6: ( ( () ( (lv_rules_1_0= ruleStyleRule ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:92:1: ( () ( (lv_rules_1_0= ruleStyleRule ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:92:1: ( () ( (lv_rules_1_0= ruleStyleRule ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:92:2: () ( (lv_rules_1_0= ruleStyleRule ) )*
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:92:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:93:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getStyleSheetAccess().getStyleSheetAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getStyleSheetAccess().getStyleSheetAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:106:2: ( (lv_rules_1_0= ruleStyleRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=13 && LA1_0<=14)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:107:1: (lv_rules_1_0= ruleStyleRule )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:107:1: (lv_rules_1_0= ruleStyleRule )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:108:3: lv_rules_1_0= ruleStyleRule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getStyleSheetAccess().getRulesStyleRuleParserRuleCall_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStyleRule_in_ruleStyleSheet149);
            	    lv_rules_1_0=ruleStyleRule();

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
            	      	        		lv_rules_1_0, 
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:138:1: entryRuleStyleRule returns [EObject current=null] : iv_ruleStyleRule= ruleStyleRule EOF ;
    public final EObject entryRuleStyleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStyleRule = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:139:2: (iv_ruleStyleRule= ruleStyleRule EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:140:2: iv_ruleStyleRule= ruleStyleRule EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStyleRuleRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStyleRule_in_entryRuleStyleRule186);
            iv_ruleStyleRule=ruleStyleRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStyleRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStyleRule196); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:147:1: ruleStyleRule returns [EObject current=null] : ( ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )* otherlv_3= '}' ) ;
    public final EObject ruleStyleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_selectors_0_0 = null;

        EObject lv_settings_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:152:6: ( ( ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )* otherlv_3= '}' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:153:1: ( ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )* otherlv_3= '}' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:153:1: ( ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )* otherlv_3= '}' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:153:2: ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )* otherlv_3= '}'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:153:2: ( (lv_selectors_0_0= ruleSelector ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||(LA2_0>=13 && LA2_0<=14)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:154:1: (lv_selectors_0_0= ruleSelector )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:154:1: (lv_selectors_0_0= ruleSelector )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:155:3: lv_selectors_0_0= ruleSelector
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getStyleRuleAccess().getSelectorsSelectorParserRuleCall_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSelector_in_ruleStyleRule242);
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

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleStyleRule255); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getStyleRuleAccess().getLeftCurlyBracketKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:181:1: ( (lv_settings_2_0= ruleSetting ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_STRING)||LA3_0==11||LA3_0==13||(LA3_0>=19 && LA3_0<=20)||LA3_0==34||(LA3_0>=37 && LA3_0<=38)||LA3_0==41||(LA3_0>=43 && LA3_0<=44)||LA3_0==46||(LA3_0>=49 && LA3_0<=51)||(LA3_0>=54 && LA3_0<=57)||(LA3_0>=59 && LA3_0<=60)||LA3_0==63) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:182:1: (lv_settings_2_0= ruleSetting )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:182:1: (lv_settings_2_0= ruleSetting )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:183:3: lv_settings_2_0= ruleSetting
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getStyleRuleAccess().getSettingsSettingParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSetting_in_ruleStyleRule276);
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
            	    break loop3;
                }
            } while (true);

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleStyleRule289); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:219:1: entryRuleSelector returns [EObject current=null] : iv_ruleSelector= ruleSelector EOF ;
    public final EObject entryRuleSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelector = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:220:2: (iv_ruleSelector= ruleSelector EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:221:2: iv_ruleSelector= ruleSelector EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSelectorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSelector_in_entryRuleSelector327);
            iv_ruleSelector=ruleSelector();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelector; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelector337); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:228:1: ruleSelector returns [EObject current=null] : ( (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector | this_IdSelector_2= ruleIdSelector ) ( (lv_filter_3_0= ruleFilter ) )? ) ;
    public final EObject ruleSelector() throws RecognitionException {
        EObject current = null;

        EObject this_TypeSelector_0 = null;

        EObject this_WildcardSelector_1 = null;

        EObject this_IdSelector_2 = null;

        EObject lv_filter_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:233:6: ( ( (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector | this_IdSelector_2= ruleIdSelector ) ( (lv_filter_3_0= ruleFilter ) )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:234:1: ( (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector | this_IdSelector_2= ruleIdSelector ) ( (lv_filter_3_0= ruleFilter ) )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:234:1: ( (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector | this_IdSelector_2= ruleIdSelector ) ( (lv_filter_3_0= ruleFilter ) )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:234:2: (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector | this_IdSelector_2= ruleIdSelector ) ( (lv_filter_3_0= ruleFilter ) )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:234:2: (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector | this_IdSelector_2= ruleIdSelector )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt4=1;
                }
                break;
            case 14:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:235:2: this_TypeSelector_0= ruleTypeSelector
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getSelectorAccess().getTypeSelectorParserRuleCall_0_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeSelector_in_ruleSelector388);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:248:2: this_WildcardSelector_1= ruleWildcardSelector
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getSelectorAccess().getWildcardSelectorParserRuleCall_0_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleWildcardSelector_in_ruleSelector418);
                    this_WildcardSelector_1=ruleWildcardSelector();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_WildcardSelector_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:261:2: this_IdSelector_2= ruleIdSelector
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getSelectorAccess().getIdSelectorParserRuleCall_0_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIdSelector_in_ruleSelector448);
                    this_IdSelector_2=ruleIdSelector();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IdSelector_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:272:2: ( (lv_filter_3_0= ruleFilter ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:273:1: (lv_filter_3_0= ruleFilter )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:273:1: (lv_filter_3_0= ruleFilter )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:274:3: lv_filter_3_0= ruleFilter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSelectorAccess().getFilterFilterParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFilter_in_ruleSelector469);
                    lv_filter_3_0=ruleFilter();

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
                      	        		lv_filter_3_0, 
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:304:1: entryRuleTypeSelector returns [EObject current=null] : iv_ruleTypeSelector= ruleTypeSelector EOF ;
    public final EObject entryRuleTypeSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeSelector = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:305:2: (iv_ruleTypeSelector= ruleTypeSelector EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:306:2: iv_ruleTypeSelector= ruleTypeSelector EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeSelectorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeSelector_in_entryRuleTypeSelector506);
            iv_ruleTypeSelector=ruleTypeSelector();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeSelector; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeSelector516); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:313:1: ruleTypeSelector returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleTypeSelector() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:318:6: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:319:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:319:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:320:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:320:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:321:3: ruleQualifiedName
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
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeSelector567);
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


    // $ANTLR start "entryRuleIdSelector"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:346:1: entryRuleIdSelector returns [EObject current=null] : iv_ruleIdSelector= ruleIdSelector EOF ;
    public final EObject entryRuleIdSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdSelector = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:347:2: (iv_ruleIdSelector= ruleIdSelector EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:348:2: iv_ruleIdSelector= ruleIdSelector EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIdSelectorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIdSelector_in_entryRuleIdSelector602);
            iv_ruleIdSelector=ruleIdSelector();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdSelector; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdSelector612); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdSelector"


    // $ANTLR start "ruleIdSelector"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:355:1: ruleIdSelector returns [EObject current=null] : (otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) ) ) ;
    public final EObject ruleIdSelector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:360:6: ( (otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:361:1: (otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:361:1: (otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:361:3: otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleIdSelector649); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getIdSelectorAccess().getNumberSignKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:365:1: ( (lv_id_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:366:1: (lv_id_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:366:1: (lv_id_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:367:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdSelector666); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_id_1_0, grammarAccess.getIdSelectorAccess().getIdIDTerminalRuleCall_1_0(), "id"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIdSelectorRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"id",
              	        		lv_id_1_0, 
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
    // $ANTLR end "ruleIdSelector"


    // $ANTLR start "entryRuleWildcardSelector"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:397:1: entryRuleWildcardSelector returns [EObject current=null] : iv_ruleWildcardSelector= ruleWildcardSelector EOF ;
    public final EObject entryRuleWildcardSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardSelector = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:398:2: (iv_ruleWildcardSelector= ruleWildcardSelector EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:399:2: iv_ruleWildcardSelector= ruleWildcardSelector EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getWildcardSelectorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleWildcardSelector_in_entryRuleWildcardSelector707);
            iv_ruleWildcardSelector=ruleWildcardSelector();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardSelector; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcardSelector717); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:406:1: ruleWildcardSelector returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleWildcardSelector() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:411:6: ( ( () otherlv_1= '*' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:412:1: ( () otherlv_1= '*' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:412:1: ( () otherlv_1= '*' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:412:2: () otherlv_1= '*'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:412:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:413:2: 
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

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleWildcardSelector766); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:438:1: entryRuleFilter returns [EObject current=null] : iv_ruleFilter= ruleFilter EOF ;
    public final EObject entryRuleFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilter = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:439:2: (iv_ruleFilter= ruleFilter EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:440:2: iv_ruleFilter= ruleFilter EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFilterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFilter_in_entryRuleFilter802);
            iv_ruleFilter=ruleFilter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFilter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFilter812); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:447:1: ruleFilter returns [EObject current=null] : (otherlv_0= '[' this_XExpression_1= ruleXExpression otherlv_2= ']' ) ;
    public final EObject ruleFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:452:6: ( (otherlv_0= '[' this_XExpression_1= ruleXExpression otherlv_2= ']' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:453:1: (otherlv_0= '[' this_XExpression_1= ruleXExpression otherlv_2= ']' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:453:1: (otherlv_0= '[' this_XExpression_1= ruleXExpression otherlv_2= ']' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:453:3: otherlv_0= '[' this_XExpression_1= ruleXExpression otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleFilter849); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getFilterAccess().getLeftSquareBracketKeyword_0(), null);
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getFilterAccess().getXExpressionParserRuleCall_1(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleFilter874);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      currentNode = currentNode.getParent();
                  
            }
            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleFilter885); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:481:1: entryRuleSetting returns [EObject current=null] : iv_ruleSetting= ruleSetting EOF ;
    public final EObject entryRuleSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetting = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:482:2: (iv_ruleSetting= ruleSetting EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:483:2: iv_ruleSetting= ruleSetting EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSettingRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSetting_in_entryRuleSetting921);
            iv_ruleSetting=ruleSetting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetting; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSetting931); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:490:1: ruleSetting returns [EObject current=null] : ( (this_XExpression_0= ruleXExpression otherlv_1= ';' ) | ( () ( (lv_assignable_3_0= ruleFeatureReference ) ) ( ( ruleOpSettingAssign ) ) ( (lv_value_5_0= ruleXExpression ) ) otherlv_6= ';' ) ) ;
    public final EObject ruleSetting() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_6=null;
        EObject this_XExpression_0 = null;

        EObject lv_assignable_3_0 = null;

        EObject lv_value_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:495:6: ( ( (this_XExpression_0= ruleXExpression otherlv_1= ';' ) | ( () ( (lv_assignable_3_0= ruleFeatureReference ) ) ( ( ruleOpSettingAssign ) ) ( (lv_value_5_0= ruleXExpression ) ) otherlv_6= ';' ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:496:1: ( (this_XExpression_0= ruleXExpression otherlv_1= ';' ) | ( () ( (lv_assignable_3_0= ruleFeatureReference ) ) ( ( ruleOpSettingAssign ) ) ( (lv_value_5_0= ruleXExpression ) ) otherlv_6= ';' ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:496:1: ( (this_XExpression_0= ruleXExpression otherlv_1= ';' ) | ( () ( (lv_assignable_3_0= ruleFeatureReference ) ) ( ( ruleOpSettingAssign ) ) ( (lv_value_5_0= ruleXExpression ) ) otherlv_6= ';' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_INT && LA6_0<=RULE_STRING)||LA6_0==11||LA6_0==13||(LA6_0>=19 && LA6_0<=20)||LA6_0==34||(LA6_0>=37 && LA6_0<=38)||LA6_0==41||(LA6_0>=43 && LA6_0<=44)||LA6_0==46||(LA6_0>=49 && LA6_0<=51)||(LA6_0>=54 && LA6_0<=57)||(LA6_0>=59 && LA6_0<=60)||LA6_0==63) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==RULE_ID||LA6_2==14||LA6_2==17||(LA6_2>=20 && LA6_2<=21)||(LA6_2>=23 && LA6_2<=40)||(LA6_2>=42 && LA6_2<=43)) ) {
                    alt6=1;
                }
                else if ( (LA6_2==18) ) {
                    alt6=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:496:2: (this_XExpression_0= ruleXExpression otherlv_1= ';' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:496:2: (this_XExpression_0= ruleXExpression otherlv_1= ';' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:497:2: this_XExpression_0= ruleXExpression otherlv_1= ';'
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getSettingAccess().getXExpressionParserRuleCall_0_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleSetting982);
                    this_XExpression_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XExpression_0; 
                              currentNode = currentNode.getParent();
                          
                    }
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleSetting993); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getSettingAccess().getSemicolonKeyword_0_1(), null);
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:513:6: ( () ( (lv_assignable_3_0= ruleFeatureReference ) ) ( ( ruleOpSettingAssign ) ) ( (lv_value_5_0= ruleXExpression ) ) otherlv_6= ';' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:513:6: ( () ( (lv_assignable_3_0= ruleFeatureReference ) ) ( ( ruleOpSettingAssign ) ) ( (lv_value_5_0= ruleXExpression ) ) otherlv_6= ';' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:513:7: () ( (lv_assignable_3_0= ruleFeatureReference ) ) ( ( ruleOpSettingAssign ) ) ( (lv_value_5_0= ruleXExpression ) ) otherlv_6= ';'
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:513:7: ()
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:514:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getSettingAccess().getXAssignmentAction_1_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getSettingAccess().getXAssignmentAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:527:2: ( (lv_assignable_3_0= ruleFeatureReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:528:1: (lv_assignable_3_0= ruleFeatureReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:528:1: (lv_assignable_3_0= ruleFeatureReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:529:3: lv_assignable_3_0= ruleFeatureReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSettingAccess().getAssignableFeatureReferenceParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFeatureReference_in_ruleSetting1034);
                    lv_assignable_3_0=ruleFeatureReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSettingRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"assignable",
                      	        		lv_assignable_3_0, 
                      	        		"FeatureReference", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:551:2: ( ( ruleOpSettingAssign ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:552:1: ( ruleOpSettingAssign )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:552:1: ( ruleOpSettingAssign )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:553:3: ruleOpSettingAssign
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
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSettingAccess().getFeatureJvmIdentifyableElementCrossReference_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpSettingAssign_in_ruleSetting1061);
                    ruleOpSettingAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:570:2: ( (lv_value_5_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:571:1: (lv_value_5_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:571:1: (lv_value_5_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:572:3: lv_value_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSettingAccess().getValueXExpressionParserRuleCall_1_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleSetting1082);
                    lv_value_5_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSettingRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"value",
                      	        		lv_value_5_0, 
                      	        		"XExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleSetting1094); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_6, grammarAccess.getSettingAccess().getSemicolonKeyword_1_4(), null);
                          
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
    // $ANTLR end "ruleSetting"


    // $ANTLR start "entryRuleOpSettingAssign"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:606:1: entryRuleOpSettingAssign returns [String current=null] : iv_ruleOpSettingAssign= ruleOpSettingAssign EOF ;
    public final String entryRuleOpSettingAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSettingAssign = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:607:2: (iv_ruleOpSettingAssign= ruleOpSettingAssign EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:608:2: iv_ruleOpSettingAssign= ruleOpSettingAssign EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpSettingAssignRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpSettingAssign_in_entryRuleOpSettingAssign1132);
            iv_ruleOpSettingAssign=ruleOpSettingAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSettingAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSettingAssign1143); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpSettingAssign"


    // $ANTLR start "ruleOpSettingAssign"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:615:1: ruleOpSettingAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= ':' ;
    public final AntlrDatatypeRuleToken ruleOpSettingAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:620:6: (kw= ':' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:622:2: kw= ':'
            {
            kw=(Token)match(input,18,FOLLOW_18_in_ruleOpSettingAssign1180); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(kw, grammarAccess.getOpSettingAssignAccess().getColonKeyword(), null); 
                  
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
    // $ANTLR end "ruleOpSettingAssign"


    // $ANTLR start "entryRuleFeatureReference"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:635:1: entryRuleFeatureReference returns [EObject current=null] : iv_ruleFeatureReference= ruleFeatureReference EOF ;
    public final EObject entryRuleFeatureReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:636:2: (iv_ruleFeatureReference= ruleFeatureReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:637:2: iv_ruleFeatureReference= ruleFeatureReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFeatureReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFeatureReference_in_entryRuleFeatureReference1219);
            iv_ruleFeatureReference=ruleFeatureReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureReference1229); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:644:1: ruleFeatureReference returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFeatureReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:649:6: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:650:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:650:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:651:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:651:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:652:3: otherlv_0= RULE_ID
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
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureReference1277); if (state.failed) return current;
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


    // $ANTLR start "entryRuleColorLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:675:1: entryRuleColorLiteral returns [EObject current=null] : iv_ruleColorLiteral= ruleColorLiteral EOF ;
    public final EObject entryRuleColorLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColorLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:676:2: (iv_ruleColorLiteral= ruleColorLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:677:2: iv_ruleColorLiteral= ruleColorLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getColorLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleColorLiteral_in_entryRuleColorLiteral1312);
            iv_ruleColorLiteral=ruleColorLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleColorLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleColorLiteral1322); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:684:1: ruleColorLiteral returns [EObject current=null] : ( (this_RGB_0= ruleRGB | this_ColorConstant_1= ruleColorConstant ) ( () ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+ ( (lv_percents_4_0= rulePercent ) )* )? ) ;
    public final EObject ruleColorLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RGB_0 = null;

        EObject this_ColorConstant_1 = null;

        EObject lv_colors_3_1 = null;

        EObject lv_colors_3_2 = null;

        EObject lv_percents_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:689:6: ( ( (this_RGB_0= ruleRGB | this_ColorConstant_1= ruleColorConstant ) ( () ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+ ( (lv_percents_4_0= rulePercent ) )* )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:690:1: ( (this_RGB_0= ruleRGB | this_ColorConstant_1= ruleColorConstant ) ( () ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+ ( (lv_percents_4_0= rulePercent ) )* )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:690:1: ( (this_RGB_0= ruleRGB | this_ColorConstant_1= ruleColorConstant ) ( () ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+ ( (lv_percents_4_0= rulePercent ) )* )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:690:2: (this_RGB_0= ruleRGB | this_ColorConstant_1= ruleColorConstant ) ( () ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+ ( (lv_percents_4_0= rulePercent ) )* )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:690:2: (this_RGB_0= ruleRGB | this_ColorConstant_1= ruleColorConstant )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                alt7=1;
            }
            else if ( (LA7_0==19) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:691:2: this_RGB_0= ruleRGB
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getRGBParserRuleCall_0_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleRGB_in_ruleColorLiteral1373);
                    this_RGB_0=ruleRGB();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RGB_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:704:2: this_ColorConstant_1= ruleColorConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getColorConstantParserRuleCall_0_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleColorConstant_in_ruleColorLiteral1403);
                    this_ColorConstant_1=ruleColorConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ColorConstant_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:715:2: ( () ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+ ( (lv_percents_4_0= rulePercent ) )* )?
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:715:3: () ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+ ( (lv_percents_4_0= rulePercent ) )*
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:715:3: ()
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:716:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getColorLiteralAccess().getGradientColorsAction_1_0().getType().getClassifier());
                              try {
                              	factory.add(temp, "colors", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getColorLiteralAccess().getGradientColorsAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:734:2: ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        alt9 = dfa9.predict(input);
                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:1: ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:1: ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:736:1: (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:736:1: (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant )
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( (LA8_0==13) ) {
                    	        alt8=1;
                    	    }
                    	    else if ( (LA8_0==19) ) {
                    	        alt8=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 8, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:737:3: lv_colors_3_1= ruleRGB
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getColorsRGBParserRuleCall_1_1_0_0(), currentNode); 
                    	              	    
                    	            }
                    	            pushFollow(FOLLOW_ruleRGB_in_ruleColorLiteral1439);
                    	            lv_colors_3_1=ruleRGB();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = factory.create(grammarAccess.getColorLiteralRule().getType().getClassifier());
                    	              	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	              	        }
                    	              	        try {
                    	              	       		add(
                    	              	       			current, 
                    	              	       			"colors",
                    	              	        		lv_colors_3_1, 
                    	              	        		"RGB", 
                    	              	        		currentNode);
                    	              	        } catch (ValueConverterException vce) {
                    	              				handleValueConverterException(vce);
                    	              	        }
                    	              	        currentNode = currentNode.getParent();
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:758:8: lv_colors_3_2= ruleColorConstant
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getColorsColorConstantParserRuleCall_1_1_0_1(), currentNode); 
                    	              	    
                    	            }
                    	            pushFollow(FOLLOW_ruleColorConstant_in_ruleColorLiteral1458);
                    	            lv_colors_3_2=ruleColorConstant();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = factory.create(grammarAccess.getColorLiteralRule().getType().getClassifier());
                    	              	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	              	        }
                    	              	        try {
                    	              	       		add(
                    	              	       			current, 
                    	              	       			"colors",
                    	              	        		lv_colors_3_2, 
                    	              	        		"ColorConstant", 
                    	              	        		currentNode);
                    	              	        } catch (ValueConverterException vce) {
                    	              				handleValueConverterException(vce);
                    	              	        }
                    	              	        currentNode = currentNode.getParent();
                    	              	    
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:782:3: ( (lv_percents_4_0= rulePercent ) )*
                    loop10:
                    do {
                        int alt10=2;
                        alt10 = dfa10.predict(input);
                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:783:1: (lv_percents_4_0= rulePercent )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:783:1: (lv_percents_4_0= rulePercent )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:784:3: lv_percents_4_0= rulePercent
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getPercentsPercentParserRuleCall_1_2_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePercent_in_ruleColorLiteral1483);
                    	    lv_percents_4_0=rulePercent();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getColorLiteralRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"percents",
                    	      	        		lv_percents_4_0, 
                    	      	        		"Percent", 
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
                    	    break loop10;
                        }
                    } while (true);


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
    // $ANTLR end "ruleColorLiteral"


    // $ANTLR start "entryRuleColorConstant"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:814:1: entryRuleColorConstant returns [EObject current=null] : iv_ruleColorConstant= ruleColorConstant EOF ;
    public final EObject entryRuleColorConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColorConstant = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:815:2: (iv_ruleColorConstant= ruleColorConstant EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:816:2: iv_ruleColorConstant= ruleColorConstant EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getColorConstantRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleColorConstant_in_entryRuleColorConstant1522);
            iv_ruleColorConstant=ruleColorConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleColorConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleColorConstant1532); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:823:1: ruleColorConstant returns [EObject current=null] : (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleColorConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:828:6: ( (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:829:1: (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:829:1: (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:829:3: otherlv_0= '$' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleColorConstant1569); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getColorConstantAccess().getDollarSignKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:833:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:834:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:834:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:835:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getColorConstantRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleColorConstant1593); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		createLeafNode(otherlv_1, grammarAccess.getColorConstantAccess().getConstantJvmIdentifyableElementCrossReference_1_0(), "constant"); 
              	
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:858:1: entryRuleRGB returns [EObject current=null] : iv_ruleRGB= ruleRGB EOF ;
    public final EObject entryRuleRGB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRGB = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:859:2: (iv_ruleRGB= ruleRGB EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:860:2: iv_ruleRGB= ruleRGB EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRGBRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRGB_in_entryRuleRGB1629);
            iv_ruleRGB=ruleRGB();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRGB; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRGB1639); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:867:1: ruleRGB returns [EObject current=null] : ( ( ( (lv_hex_0_0= '#' ) ) ( (lv_value_1_0= ruleHEXINT ) ) ) | (otherlv_2= '#' otherlv_3= '(' ( (lv_red_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_green_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_blue_8_0= RULE_INT ) ) otherlv_9= ')' ) ) ;
    public final EObject ruleRGB() throws RecognitionException {
        EObject current = null;

        Token lv_hex_0_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_red_4_0=null;
        Token otherlv_5=null;
        Token lv_green_6_0=null;
        Token otherlv_7=null;
        Token lv_blue_8_0=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:872:6: ( ( ( ( (lv_hex_0_0= '#' ) ) ( (lv_value_1_0= ruleHEXINT ) ) ) | (otherlv_2= '#' otherlv_3= '(' ( (lv_red_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_green_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_blue_8_0= RULE_INT ) ) otherlv_9= ')' ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:873:1: ( ( ( (lv_hex_0_0= '#' ) ) ( (lv_value_1_0= ruleHEXINT ) ) ) | (otherlv_2= '#' otherlv_3= '(' ( (lv_red_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_green_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_blue_8_0= RULE_INT ) ) otherlv_9= ')' ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:873:1: ( ( ( (lv_hex_0_0= '#' ) ) ( (lv_value_1_0= ruleHEXINT ) ) ) | (otherlv_2= '#' otherlv_3= '(' ( (lv_red_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_green_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_blue_8_0= RULE_INT ) ) otherlv_9= ')' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==13) ) {
                int LA12_1 = input.LA(2);

                if ( ((LA12_1>=RULE_ID && LA12_1<=RULE_INT)) ) {
                    alt12=1;
                }
                else if ( (LA12_1==20) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:873:2: ( ( (lv_hex_0_0= '#' ) ) ( (lv_value_1_0= ruleHEXINT ) ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:873:2: ( ( (lv_hex_0_0= '#' ) ) ( (lv_value_1_0= ruleHEXINT ) ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:873:3: ( (lv_hex_0_0= '#' ) ) ( (lv_value_1_0= ruleHEXINT ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:873:3: ( (lv_hex_0_0= '#' ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:874:1: (lv_hex_0_0= '#' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:874:1: (lv_hex_0_0= '#' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:875:3: lv_hex_0_0= '#'
                    {
                    lv_hex_0_0=(Token)match(input,13,FOLLOW_13_in_ruleRGB1683); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              createLeafNode(lv_hex_0_0, grammarAccess.getRGBAccess().getHexNumberSignKeyword_0_0_0(), "hex");
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getRGBRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "hex", true, "#", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:894:2: ( (lv_value_1_0= ruleHEXINT ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:895:1: (lv_value_1_0= ruleHEXINT )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:895:1: (lv_value_1_0= ruleHEXINT )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:896:3: lv_value_1_0= ruleHEXINT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getRGBAccess().getValueHEXINTParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleHEXINT_in_ruleRGB1717);
                    lv_value_1_0=ruleHEXINT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getRGBRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"value",
                      	        		lv_value_1_0, 
                      	        		"HEXINT", 
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:919:6: (otherlv_2= '#' otherlv_3= '(' ( (lv_red_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_green_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_blue_8_0= RULE_INT ) ) otherlv_9= ')' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:919:6: (otherlv_2= '#' otherlv_3= '(' ( (lv_red_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_green_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_blue_8_0= RULE_INT ) ) otherlv_9= ')' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:919:8: otherlv_2= '#' otherlv_3= '(' ( (lv_red_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_green_6_0= RULE_INT ) ) otherlv_7= ',' ( (lv_blue_8_0= RULE_INT ) ) otherlv_9= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleRGB1737); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_2, grammarAccess.getRGBAccess().getNumberSignKeyword_1_0(), null);
                          
                    }
                    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleRGB1749); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_3, grammarAccess.getRGBAccess().getLeftParenthesisKeyword_1_1(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:927:1: ( (lv_red_4_0= RULE_INT ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:928:1: (lv_red_4_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:928:1: (lv_red_4_0= RULE_INT )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:929:3: lv_red_4_0= RULE_INT
                    {
                    lv_red_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGB1766); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			createLeafNode(lv_red_4_0, grammarAccess.getRGBAccess().getRedINTTerminalRuleCall_1_2_0(), "red"); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getRGBRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"red",
                      	        		lv_red_4_0, 
                      	        		"INT", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleRGB1783); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getRGBAccess().getCommaKeyword_1_3(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:955:1: ( (lv_green_6_0= RULE_INT ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:956:1: (lv_green_6_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:956:1: (lv_green_6_0= RULE_INT )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:957:3: lv_green_6_0= RULE_INT
                    {
                    lv_green_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGB1800); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			createLeafNode(lv_green_6_0, grammarAccess.getRGBAccess().getGreenINTTerminalRuleCall_1_4_0(), "green"); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getRGBRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"green",
                      	        		lv_green_6_0, 
                      	        		"INT", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleRGB1817); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_7, grammarAccess.getRGBAccess().getCommaKeyword_1_5(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:983:1: ( (lv_blue_8_0= RULE_INT ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:984:1: (lv_blue_8_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:984:1: (lv_blue_8_0= RULE_INT )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:985:3: lv_blue_8_0= RULE_INT
                    {
                    lv_blue_8_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRGB1834); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			createLeafNode(lv_blue_8_0, grammarAccess.getRGBAccess().getBlueINTTerminalRuleCall_1_6_0(), "blue"); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getRGBRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"blue",
                      	        		lv_blue_8_0, 
                      	        		"INT", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,22,FOLLOW_22_in_ruleRGB1851); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_9, grammarAccess.getRGBAccess().getRightParenthesisKeyword_1_7(), null);
                          
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
    // $ANTLR end "ruleRGB"


    // $ANTLR start "entryRulePercent"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1019:1: entryRulePercent returns [EObject current=null] : iv_rulePercent= rulePercent EOF ;
    public final EObject entryRulePercent() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePercent = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1020:2: (iv_rulePercent= rulePercent EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1021:2: iv_rulePercent= rulePercent EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPercentRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulePercent_in_entryRulePercent1888);
            iv_rulePercent=rulePercent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePercent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePercent1898); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePercent"


    // $ANTLR start "rulePercent"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1028:1: rulePercent returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INT ) ) otherlv_1= '%' ) ;
    public final EObject rulePercent() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1033:6: ( ( ( (lv_value_0_0= RULE_INT ) ) otherlv_1= '%' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1034:1: ( ( (lv_value_0_0= RULE_INT ) ) otherlv_1= '%' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1034:1: ( ( (lv_value_0_0= RULE_INT ) ) otherlv_1= '%' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1034:2: ( (lv_value_0_0= RULE_INT ) ) otherlv_1= '%'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1034:2: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1035:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1035:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1036:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePercent1940); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_value_0_0, grammarAccess.getPercentAccess().getValueINTTerminalRuleCall_0_0(), "value"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getPercentRule().getType().getClassifier());
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

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_rulePercent1957); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getPercentAccess().getPercentSignKeyword_1(), null);
                  
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
    // $ANTLR end "rulePercent"


    // $ANTLR start "entryRuleHEXINT"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1070:1: entryRuleHEXINT returns [String current=null] : iv_ruleHEXINT= ruleHEXINT EOF ;
    public final String entryRuleHEXINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHEXINT = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1071:2: (iv_ruleHEXINT= ruleHEXINT EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1072:2: iv_ruleHEXINT= ruleHEXINT EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getHEXINTRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleHEXINT_in_entryRuleHEXINT1994);
            iv_ruleHEXINT=ruleHEXINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHEXINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXINT2005); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHEXINT"


    // $ANTLR start "ruleHEXINT"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1079:1: ruleHEXINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT (this_ID_1= RULE_ID )? ) | this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleHEXINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_ID_1=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1084:6: ( ( (this_INT_0= RULE_INT (this_ID_1= RULE_ID )? ) | this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1085:1: ( (this_INT_0= RULE_INT (this_ID_1= RULE_ID )? ) | this_ID_2= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1085:1: ( (this_INT_0= RULE_INT (this_ID_1= RULE_ID )? ) | this_ID_2= RULE_ID )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_INT) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1085:2: (this_INT_0= RULE_INT (this_ID_1= RULE_ID )? )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1085:2: (this_INT_0= RULE_INT (this_ID_1= RULE_ID )? )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1085:7: this_INT_0= RULE_INT (this_ID_1= RULE_ID )?
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleHEXINT2046); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          createLeafNode(this_INT_0, grammarAccess.getHEXINTAccess().getINTTerminalRuleCall_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1092:1: (this_ID_1= RULE_ID )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==RULE_ID) ) {
                        int LA13_1 = input.LA(2);

                        if ( (synpred14_InternalXcss()) ) {
                            alt13=1;
                        }
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1092:6: this_ID_1= RULE_ID
                            {
                            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHEXINT2067); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_ID_1);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  createLeafNode(this_ID_1, grammarAccess.getHEXINTAccess().getIDTerminalRuleCall_0_1(), null); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1100:10: this_ID_2= RULE_ID
                    {
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHEXINT2096); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          createLeafNode(this_ID_2, grammarAccess.getHEXINTAccess().getIDTerminalRuleCall_1(), null); 
                          
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
    // $ANTLR end "ruleHEXINT"


    // $ANTLR start "entryRuleXLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1115:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1116:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1117:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral2141);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral2151); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1124:1: ruleXLiteral returns [EObject current=null] : (this_ColorLiteral_0= ruleColorLiteral | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral ) ;
    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_ColorLiteral_0 = null;

        EObject this_XClosure_1 = null;

        EObject this_XBooleanLiteral_2 = null;

        EObject this_XIntLiteral_3 = null;

        EObject this_XNullLiteral_4 = null;

        EObject this_XStringLiteral_5 = null;

        EObject this_XTypeLiteral_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1129:6: ( (this_ColorLiteral_0= ruleColorLiteral | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1130:1: (this_ColorLiteral_0= ruleColorLiteral | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1130:1: (this_ColorLiteral_0= ruleColorLiteral | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )
            int alt15=7;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1131:2: this_ColorLiteral_0= ruleColorLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXLiteralAccess().getColorLiteralParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleColorLiteral_in_ruleXLiteral2201);
                    this_ColorLiteral_0=ruleColorLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ColorLiteral_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1144:2: this_XClosure_1= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral2231);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1157:2: this_XBooleanLiteral_2= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral2261);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1170:2: this_XIntLiteral_3= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXLiteralAccess().getXIntLiteralParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXLiteral2291);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1183:2: this_XNullLiteral_4= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral2321);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1196:2: this_XStringLiteral_5= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral2351);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1209:2: this_XTypeLiteral_6= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral2381);
                    this_XTypeLiteral_6=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTypeLiteral_6; 
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
    // $ANTLR end "ruleXLiteral"


    // $ANTLR start "entryRuleXExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1228:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1229:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1230:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression2416);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression2426); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1237:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1242:6: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1244:2: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression2475);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1263:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1264:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1265:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAssignmentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment2509);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment2519); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1272:1: ruleXAssignment returns [EObject current=null] : (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_XOrExpression_0 = null;

        EObject lv_value_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1277:6: ( (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1278:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1278:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1279:2: this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment2569);
            this_XOrExpression_0=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOrExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1290:1: ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                int LA16_1 = input.LA(2);

                if ( (synpred22_InternalXcss()) ) {
                    alt16=1;
                }
            }
            else if ( (LA16_0==25) ) {
                int LA16_2 = input.LA(2);

                if ( (synpred22_InternalXcss()) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1290:2: () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1290:2: ()
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1291:2: 
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1309:2: ( ( ruleOpAssign ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1310:1: ( ruleOpAssign )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1310:1: ( ruleOpAssign )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1311:3: ruleOpAssign
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
                    pushFollow(FOLLOW_ruleOpAssign_in_ruleXAssignment2608);
                    ruleOpAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1328:2: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1329:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1329:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1330:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment2629);
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


    // $ANTLR start "entryRuleOpAssign"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1360:1: entryRuleOpAssign returns [String current=null] : iv_ruleOpAssign= ruleOpAssign EOF ;
    public final String entryRuleOpAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAssign = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1361:2: (iv_ruleOpAssign= ruleOpAssign EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1362:2: iv_ruleOpAssign= ruleOpAssign EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAssignRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAssign_in_entryRuleOpAssign2668);
            iv_ruleOpAssign=ruleOpAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAssign2679); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1369:1: ruleOpAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' ) ;
    public final AntlrDatatypeRuleToken ruleOpAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1374:6: ( (kw= '=' | kw= '+=' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1375:1: (kw= '=' | kw= '+=' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1375:1: (kw= '=' | kw= '+=' )
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1376:2: kw= '='
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleOpAssign2717); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpAssignAccess().getEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1383:2: kw= '+='
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleOpAssign2736); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleOpAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1396:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1397:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1398:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXOrExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression2776);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression2786); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1405:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1410:6: ( (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1411:1: (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1411:1: (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1412:2: this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression2836);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1423:1: ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==26) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred24_InternalXcss()) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1423:2: () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1423:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1424:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1442:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1443:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1443:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1444:3: ruleOpOr
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
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression2875);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1461:2: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1462:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1462:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1463:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression2896);
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
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1493:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1494:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1495:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpOrRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr2935);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr2946); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1502:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1507:6: (kw= '||' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1509:2: kw= '||'
            {
            kw=(Token)match(input,26,FOLLOW_26_in_ruleOpOr2983); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1522:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1523:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1524:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAndExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression3022);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression3032); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1531:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1536:6: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1537:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1537:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1538:2: this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3082);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1549:1: ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==27) ) {
                    int LA19_2 = input.LA(2);

                    if ( (synpred25_InternalXcss()) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1549:2: () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1549:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1550:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1568:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1569:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1569:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1570:3: ruleOpAnd
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
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression3121);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1587:2: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1588:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1588:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1589:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3142);
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
            	    break loop19;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1619:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1620:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1621:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAndRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd3181);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd3192); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1628:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1633:6: (kw= '&&' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1635:2: kw= '&&'
            {
            kw=(Token)match(input,27,FOLLOW_27_in_ruleOpAnd3229); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1648:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1649:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1650:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXEqualityExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression3268);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression3278); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1657:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1662:6: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1663:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1663:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1664:2: this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3328);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1675:1: ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==28) ) {
                    int LA20_2 = input.LA(2);

                    if ( (synpred26_InternalXcss()) ) {
                        alt20=1;
                    }


                }
                else if ( (LA20_0==29) ) {
                    int LA20_3 = input.LA(2);

                    if ( (synpred26_InternalXcss()) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1675:2: () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1675:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1676:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1694:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1695:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1695:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1696:3: ruleOpEquality
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
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression3367);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1713:2: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1714:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1714:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1715:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3388);
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
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1745:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1746:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1747:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpEqualityRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality3427);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality3438); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1754:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1759:6: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1760:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1760:1: (kw= '==' | kw= '!=' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            else if ( (LA21_0==29) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1761:2: kw= '=='
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpEquality3476); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1768:2: kw= '!='
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpEquality3495); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1781:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1782:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1783:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXRelationalExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression3535);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression3545); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1790:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_rightOperand_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1795:6: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1796:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1796:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1797:2: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression3595);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1808:1: ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop22:
            do {
                int alt22=3;
                switch ( input.LA(1) ) {
                case 30:
                    {
                    int LA22_2 = input.LA(2);

                    if ( (synpred28_InternalXcss()) ) {
                        alt22=1;
                    }


                    }
                    break;
                case 31:
                    {
                    int LA22_3 = input.LA(2);

                    if ( (synpred29_InternalXcss()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA22_4 = input.LA(2);

                    if ( (synpred29_InternalXcss()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 33:
                    {
                    int LA22_5 = input.LA(2);

                    if ( (synpred29_InternalXcss()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 34:
                    {
                    int LA22_6 = input.LA(2);

                    if ( (synpred29_InternalXcss()) ) {
                        alt22=2;
                    }


                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1808:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1808:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1808:3: () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1808:3: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1809:2: 
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

            	    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleXRelationalExpression3620); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_1(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1831:1: ( ( ruleQualifiedName ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1832:1: ( ruleQualifiedName )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1832:1: ( ruleQualifiedName )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1833:3: ruleQualifiedName
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
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression3647);
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
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1851:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1851:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1851:7: () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1851:7: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1852:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1870:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1871:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1871:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1872:3: ruleOpCompare
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
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression3694);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1889:2: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1890:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1890:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1891:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression3715);
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
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1921:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1922:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1923:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpCompareRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare3755);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare3766); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1930:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1935:6: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1936:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1936:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt23=1;
                }
                break;
            case 32:
                {
                alt23=2;
                }
                break;
            case 33:
                {
                alt23=3;
                }
                break;
            case 34:
                {
                alt23=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1937:2: kw= '>='
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpCompare3804); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1944:2: kw= '<='
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpCompare3823); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1951:2: kw= '>'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpCompare3842); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1958:2: kw= '<'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpCompare3861); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1971:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1972:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1973:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXOtherOperatorExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression3901);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression3911); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1980:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1985:6: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1986:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1986:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1987:2: this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3961);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1998:1: ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==35) ) {
                    int LA24_2 = input.LA(2);

                    if ( (synpred33_InternalXcss()) ) {
                        alt24=1;
                    }


                }
                else if ( (LA24_0==36) ) {
                    int LA24_3 = input.LA(2);

                    if ( (synpred33_InternalXcss()) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1998:2: () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1998:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1999:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2017:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2018:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2018:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2019:3: ruleOpOther
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
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression4000);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2036:2: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2037:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2037:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2038:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4021);
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
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2068:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2069:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2070:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpOtherRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther4060);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther4071); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2077:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2082:6: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2083:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2083:1: (kw= '->' | kw= '..' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==35) ) {
                alt25=1;
            }
            else if ( (LA25_0==36) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2084:2: kw= '->'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpOther4109); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2091:2: kw= '..'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpOther4128); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2104:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2105:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2106:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAdditiveExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression4168);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression4178); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2113:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2118:6: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2119:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2119:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2120:2: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4228);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2131:1: ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==37) ) {
                    int LA26_2 = input.LA(2);

                    if ( (synpred35_InternalXcss()) ) {
                        alt26=1;
                    }


                }
                else if ( (LA26_0==38) ) {
                    int LA26_3 = input.LA(2);

                    if ( (synpred35_InternalXcss()) ) {
                        alt26=1;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2131:2: () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2131:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2132:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2150:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2151:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2151:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2152:3: ruleOpAdd
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
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression4267);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2169:2: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2170:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2170:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2171:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4288);
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
            	    break loop26;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2201:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2202:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2203:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAddRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd4327);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd4338); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2210:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2215:6: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2216:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2216:1: (kw= '+' | kw= '-' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==37) ) {
                alt27=1;
            }
            else if ( (LA27_0==38) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2217:2: kw= '+'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpAdd4376); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2224:2: kw= '-'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpAdd4395); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2237:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2238:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2239:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXMultiplicativeExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression4435);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression4445); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2246:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2251:6: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2252:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2252:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2253:2: this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression4495);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2264:1: ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop28:
            do {
                int alt28=2;
                switch ( input.LA(1) ) {
                case 14:
                    {
                    int LA28_2 = input.LA(2);

                    if ( (synpred37_InternalXcss()) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 39:
                    {
                    int LA28_3 = input.LA(2);

                    if ( (synpred37_InternalXcss()) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA28_4 = input.LA(2);

                    if ( (synpred37_InternalXcss()) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 23:
                    {
                    int LA28_5 = input.LA(2);

                    if ( (synpred37_InternalXcss()) ) {
                        alt28=1;
                    }


                    }
                    break;

                }

                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2264:2: () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2264:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2265:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2283:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2284:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2284:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2285:3: ruleOpMulti
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
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression4534);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2302:2: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2303:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2303:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2304:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression4555);
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
            	    break loop28;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2334:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2335:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2336:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpMultiRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti4594);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti4605); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2343:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2348:6: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2349:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2349:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt29=4;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt29=1;
                }
                break;
            case 39:
                {
                alt29=2;
                }
                break;
            case 40:
                {
                alt29=3;
                }
                break;
            case 23:
                {
                alt29=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2350:2: kw= '*'
                    {
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleOpMulti4643); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2357:2: kw= '**'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleOpMulti4662); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2364:2: kw= '/'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleOpMulti4681); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2371:2: kw= '%'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleOpMulti4700); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2384:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2385:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2386:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXUnaryOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation4740);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation4750); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2393:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XMemberFeatureCall_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2398:6: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2399:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2399:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=37 && LA30_0<=38)||LA30_0==41) ) {
                alt30=1;
            }
            else if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_STRING)||LA30_0==11||LA30_0==13||(LA30_0>=19 && LA30_0<=20)||LA30_0==34||(LA30_0>=43 && LA30_0<=44)||LA30_0==46||(LA30_0>=49 && LA30_0<=51)||(LA30_0>=54 && LA30_0<=57)||(LA30_0>=59 && LA30_0<=60)||LA30_0==63) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2399:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2399:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2399:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2399:3: ()
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2400:2: 
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2413:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2414:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2414:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2415:3: ruleOpUnary
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
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation4815);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2432:2: ( (lv_operand_2_0= ruleXMemberFeatureCall ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2433:1: (lv_operand_2_0= ruleXMemberFeatureCall )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2433:1: (lv_operand_2_0= ruleXMemberFeatureCall )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2434:3: lv_operand_2_0= ruleXMemberFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXMemberFeatureCallParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation4836);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2458:2: this_XMemberFeatureCall_3= ruleXMemberFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getXMemberFeatureCallParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation4868);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2477:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2478:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2479:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpUnaryRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary4904);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary4915); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2486:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2491:6: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2492:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2492:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt31=1;
                }
                break;
            case 38:
                {
                alt31=2;
                }
                break;
            case 37:
                {
                alt31=3;
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2493:2: kw= '!'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleOpUnary4953); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2500:2: kw= '-'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpUnary4972); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2507:2: kw= '+'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpUnary4991); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2520:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2521:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2522:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXMemberFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall5031);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall5041); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2529:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2534:6: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2535:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2535:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2536:2: this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall5091);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2547:1: ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==42) ) {
                    int LA37_2 = input.LA(2);

                    if ( (synpred49_InternalXcss()) ) {
                        alt37=1;
                    }


                }


                switch (alt37) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2547:2: () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2547:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2548:2: 
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

            	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleXMemberFeatureCall5115); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2570:1: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            	    int alt33=2;
            	    int LA33_0 = input.LA(1);

            	    if ( (LA33_0==34) ) {
            	        alt33=1;
            	    }
            	    switch (alt33) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2570:3: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
            	            {
            	            otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleXMemberFeatureCall5128); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_3, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_2_0(), null);
            	                  
            	            }
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2574:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2575:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2575:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2576:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), currentNode); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall5149);
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

            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2598:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop32:
            	            do {
            	                int alt32=2;
            	                int LA32_0 = input.LA(1);

            	                if ( (LA32_0==21) ) {
            	                    alt32=1;
            	                }


            	                switch (alt32) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2598:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleXMemberFeatureCall5162); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	createLeafNode(otherlv_5, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_2_2_0(), null);
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2602:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2603:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2603:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2604:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_2_1_0(), currentNode); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall5183);
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
            	            	    break loop32;
            	                }
            	            } while (true);

            	            otherlv_7=(Token)match(input,33,FOLLOW_33_in_ruleXMemberFeatureCall5197); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_2_3(), null);
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2630:3: ( (otherlv_8= RULE_ID ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2631:1: (otherlv_8= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2631:1: (otherlv_8= RULE_ID )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2632:3: otherlv_8= RULE_ID
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
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXMemberFeatureCall5223); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		createLeafNode(otherlv_8, grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_1_3_0(), "feature"); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2647:2: ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
            	    int alt36=2;
            	    alt36 = dfa36.predict(input);
            	    switch (alt36) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2647:3: ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')'
            	            {
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2647:3: ( (lv_explicitOperationCall_9_0= '(' ) )
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2648:1: (lv_explicitOperationCall_9_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2648:1: (lv_explicitOperationCall_9_0= '(' )
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2649:3: lv_explicitOperationCall_9_0= '('
            	            {
            	            lv_explicitOperationCall_9_0=(Token)match(input,20,FOLLOW_20_in_ruleXMemberFeatureCall5242); if (state.failed) return current;
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

            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2668:2: ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )?
            	            int alt35=2;
            	            int LA35_0 = input.LA(1);

            	            if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_STRING)||LA35_0==11||LA35_0==13||(LA35_0>=19 && LA35_0<=20)||LA35_0==34||(LA35_0>=37 && LA35_0<=38)||LA35_0==41||(LA35_0>=43 && LA35_0<=44)||LA35_0==46||(LA35_0>=49 && LA35_0<=51)||(LA35_0>=54 && LA35_0<=57)||(LA35_0>=59 && LA35_0<=60)||LA35_0==63) ) {
            	                alt35=1;
            	            }
            	            switch (alt35) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2668:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2668:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2669:1: (lv_memberCallArguments_10_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2669:1: (lv_memberCallArguments_10_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2670:3: lv_memberCallArguments_10_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_0_0(), currentNode); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5277);
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

            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2692:2: (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
            	                    loop34:
            	                    do {
            	                        int alt34=2;
            	                        int LA34_0 = input.LA(1);

            	                        if ( (LA34_0==21) ) {
            	                            alt34=1;
            	                        }


            	                        switch (alt34) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2692:4: otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_11=(Token)match(input,21,FOLLOW_21_in_ruleXMemberFeatureCall5290); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	createLeafNode(otherlv_11, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_4_1_1_0(), null);
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2696:1: ( (lv_memberCallArguments_12_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2697:1: (lv_memberCallArguments_12_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2697:1: (lv_memberCallArguments_12_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2698:3: lv_memberCallArguments_12_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_1_1_0(), currentNode); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5311);
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
            	                    	    break loop34;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            otherlv_13=(Token)match(input,22,FOLLOW_22_in_ruleXMemberFeatureCall5327); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_13, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_4_2(), null);
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
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


    // $ANTLR start "entryRuleXPrimaryExpression"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2732:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2733:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2734:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXPrimaryExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression5367);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression5377); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2741:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XLiteral_0= ruleXLiteral | this_XConstructorCall_1= ruleXConstructorCall | this_XBlockExpression_2= ruleXBlockExpression | this_XSwitchExpression_3= ruleXSwitchExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XCastedExpression_9= ruleXCastedExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XLiteral_0 = null;

        EObject this_XConstructorCall_1 = null;

        EObject this_XBlockExpression_2 = null;

        EObject this_XSwitchExpression_3 = null;

        EObject this_XFeatureCall_4 = null;

        EObject this_XIfExpression_5 = null;

        EObject this_XForLoopExpression_6 = null;

        EObject this_XWhileExpression_7 = null;

        EObject this_XDoWhileExpression_8 = null;

        EObject this_XCastedExpression_9 = null;

        EObject this_XThrowExpression_10 = null;

        EObject this_XTryCatchFinallyExpression_11 = null;

        EObject this_XParenthesizedExpression_12 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2746:6: ( (this_XLiteral_0= ruleXLiteral | this_XConstructorCall_1= ruleXConstructorCall | this_XBlockExpression_2= ruleXBlockExpression | this_XSwitchExpression_3= ruleXSwitchExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XCastedExpression_9= ruleXCastedExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2747:1: (this_XLiteral_0= ruleXLiteral | this_XConstructorCall_1= ruleXConstructorCall | this_XBlockExpression_2= ruleXBlockExpression | this_XSwitchExpression_3= ruleXSwitchExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XCastedExpression_9= ruleXCastedExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2747:1: (this_XLiteral_0= ruleXLiteral | this_XConstructorCall_1= ruleXConstructorCall | this_XBlockExpression_2= ruleXBlockExpression | this_XSwitchExpression_3= ruleXSwitchExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XCastedExpression_9= ruleXCastedExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            int alt38=13;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2748:2: this_XLiteral_0= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression5427);
                    this_XLiteral_0=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XLiteral_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2761:2: this_XConstructorCall_1= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression5457);
                    this_XConstructorCall_1=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XConstructorCall_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2774:2: this_XBlockExpression_2= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression5487);
                    this_XBlockExpression_2=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBlockExpression_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2787:2: this_XSwitchExpression_3= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression5517);
                    this_XSwitchExpression_3=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XSwitchExpression_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2800:2: this_XFeatureCall_4= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression5547);
                    this_XFeatureCall_4=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFeatureCall_4; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2813:2: this_XIfExpression_5= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression5577);
                    this_XIfExpression_5=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIfExpression_5; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2826:2: this_XForLoopExpression_6= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression5607);
                    this_XForLoopExpression_6=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XForLoopExpression_6; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2839:2: this_XWhileExpression_7= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_7(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression5637);
                    this_XWhileExpression_7=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWhileExpression_7; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2852:2: this_XDoWhileExpression_8= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_8(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression5667);
                    this_XDoWhileExpression_8=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XDoWhileExpression_8; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2865:2: this_XCastedExpression_9= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXCastedExpressionParserRuleCall_9(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXPrimaryExpression5697);
                    this_XCastedExpression_9=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XCastedExpression_9; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2878:2: this_XThrowExpression_10= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_10(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression5727);
                    this_XThrowExpression_10=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XThrowExpression_10; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2891:2: this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_11(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression5757);
                    this_XTryCatchFinallyExpression_11=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_11; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2904:2: this_XParenthesizedExpression_12= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_12(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression5787);
                    this_XParenthesizedExpression_12=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_12; 
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


    // $ANTLR start "entryRuleXClosure"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2923:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2924:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2925:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXClosureRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure5822);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure5832); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2932:1: ruleXClosure returns [EObject current=null] : ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_formalParameters_1_0 = null;

        EObject lv_formalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2937:6: ( ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2938:1: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2938:1: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2938:2: () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2938:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2939:2: 
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2952:2: ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID||LA40_0==20||LA40_0==63) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2952:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2952:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2953:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2953:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2954:3: lv_formalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_1_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5891);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2976:2: (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==21) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2976:4: otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleXClosure5904); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_2, grammarAccess.getXClosureAccess().getCommaKeyword_1_1_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2980:1: ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2981:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2981:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2982:3: lv_formalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_1_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5925);
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
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,43,FOLLOW_43_in_ruleXClosure5941); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_4, grammarAccess.getXClosureAccess().getVerticalLineKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3008:1: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3009:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3009:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3010:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXClosure5962);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3040:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3041:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3042:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCastedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression5998);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression6008); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3049:1: ruleXCastedExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_type_1_0 = null;

        EObject lv_target_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3054:6: ( (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3055:1: (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3055:1: (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3055:3: otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleXCastedExpression6045); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXCastedExpressionAccess().getLeftParenthesisKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3059:1: ( (lv_type_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3060:1: (lv_type_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3060:1: (lv_type_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3061:3: lv_type_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression6066);
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

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleXCastedExpression6078); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getRightParenthesisKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3087:1: ( (lv_target_3_0= ruleXMemberFeatureCall ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3088:1: (lv_target_3_0= ruleXMemberFeatureCall )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3088:1: (lv_target_3_0= ruleXMemberFeatureCall )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3089:3: lv_target_3_0= ruleXMemberFeatureCall
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCastedExpressionAccess().getTargetXMemberFeatureCallParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression6099);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3119:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3120:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3121:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXParenthesizedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6135);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression6145); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3128:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3133:6: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3134:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3134:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3134:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleXParenthesizedExpression6182); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null);
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6207);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      currentNode = currentNode.getParent();
                  
            }
            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleXParenthesizedExpression6218); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3162:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3163:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3164:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXIfExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6254);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression6264); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3171:1: ruleXIfExpression returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3176:6: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3177:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3177:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3177:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )?
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleXIfExpression6301); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXIfExpressionAccess().getIfKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleXIfExpression6313); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3185:1: ( (lv_if_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3186:1: (lv_if_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3186:1: (lv_if_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3187:3: lv_if_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6334);
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

            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleXIfExpression6346); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3213:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3214:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3214:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3215:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6367);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3237:2: (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==45) ) {
                int LA41_1 = input.LA(2);

                if ( (synpred64_InternalXcss()) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3237:4: otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) )
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_45_in_ruleXIfExpression6380); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXIfExpressionAccess().getElseKeyword_5_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3241:1: ( (lv_else_6_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3242:1: (lv_else_6_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3242:1: (lv_else_6_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3243:3: lv_else_6_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6401);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3273:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3274:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3275:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXSwitchExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6439);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression6449); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3282:1: ruleXSwitchExpression returns [EObject current=null] : (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3287:6: ( (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3288:1: (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3288:1: (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3288:3: otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleXSwitchExpression6486); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3292:1: ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )?
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3293:1: (lv_switch_1_0= ruleXExpressionInsideBlock )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3293:1: (lv_switch_1_0= ruleXExpressionInsideBlock )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3294:3: lv_switch_1_0= ruleXExpressionInsideBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionInsideBlockParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXSwitchExpression6507);
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

            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleXSwitchExpression6520); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3320:1: ( (lv_cases_3_0= ruleXCasePart ) )+
            int cnt43=0;
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID||LA43_0==18||LA43_0==20||LA43_0==48||LA43_0==63) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3321:1: (lv_cases_3_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3321:1: (lv_cases_3_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3322:3: lv_cases_3_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_3_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6541);
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
            	    if ( cnt43 >= 1 ) break loop43;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(43, input);
                        throw eee;
                }
                cnt43++;
            } while (true);

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3344:3: (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==47) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3344:5: otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )
                    {
                    otherlv_4=(Token)match(input,47,FOLLOW_47_in_ruleXSwitchExpression6555); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_4_0(), null);
                          
                    }
                    otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleXSwitchExpression6567); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_4_1(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3352:1: ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )
                    int alt44=2;
                    alt44 = dfa44.predict(input);
                    switch (alt44) {
                        case 1 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3352:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3352:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3352:3: ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';'
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3352:3: ( (lv_default_6_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3353:1: (lv_default_6_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3353:1: (lv_default_6_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3354:3: lv_default_6_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_4_2_0_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6590);
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

                            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleXSwitchExpression6602); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	createLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getSemicolonKeyword_4_2_0_1(), null);
                                  
                            }

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3381:6: ( (lv_default_8_0= ruleXBlockExpression ) )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3381:6: ( (lv_default_8_0= ruleXBlockExpression ) )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3382:1: (lv_default_8_0= ruleXBlockExpression )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3382:1: (lv_default_8_0= ruleXBlockExpression )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3383:3: lv_default_8_0= ruleXBlockExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXBlockExpressionParserRuleCall_4_2_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXSwitchExpression6630);
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

            otherlv_9=(Token)match(input,12,FOLLOW_12_in_ruleXSwitchExpression6645); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3417:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3418:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3419:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCasePartRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6681);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6691); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3426:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3431:6: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3432:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3432:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3432:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3432:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID||LA46_0==20||LA46_0==63) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3433:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3433:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3434:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6737);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3456:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==48) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3456:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleXCasePart6751); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3460:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3461:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3461:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3462:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6772);
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

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleXCasePart6786); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3488:1: ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )
            int alt48=2;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3488:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3488:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3488:3: ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';'
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3488:3: ( (lv_then_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3489:1: (lv_then_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3489:1: (lv_then_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3490:3: lv_then_4_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6809);
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

                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleXCasePart6821); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXCasePartAccess().getSemicolonKeyword_3_0_1(), null);
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3517:6: ( (lv_then_6_0= ruleXBlockExpression ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3517:6: ( (lv_then_6_0= ruleXBlockExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3518:1: (lv_then_6_0= ruleXBlockExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3518:1: (lv_then_6_0= ruleXBlockExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3519:3: lv_then_6_0= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXBlockExpressionParserRuleCall_3_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXCasePart6849);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3549:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3550:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3551:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXForLoopExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6886);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression6896); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3558:1: ruleXForLoopExpression returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3563:6: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3564:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3564:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3564:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleXForLoopExpression6933); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXForLoopExpressionAccess().getForKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleXForLoopExpression6945); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3572:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3573:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3573:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3574:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6966);
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

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleXForLoopExpression6978); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3600:1: ( (lv_forExpression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3601:1: (lv_forExpression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3601:1: (lv_forExpression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3602:3: lv_forExpression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6999);
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

            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleXForLoopExpression7011); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_5, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_5(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3628:1: ( (lv_eachExpression_6_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3629:1: (lv_eachExpression_6_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3629:1: (lv_eachExpression_6_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3630:3: lv_eachExpression_6_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_6_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression7032);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3660:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3661:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3662:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression7068);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression7078); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3669:1: ruleXWhileExpression returns [EObject current=null] : (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_predicate_2_0 = null;

        EObject lv_body_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3674:6: ( (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3675:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3675:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3675:3: otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleXWhileExpression7115); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleXWhileExpression7127); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3683:1: ( (lv_predicate_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3684:1: (lv_predicate_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3684:1: (lv_predicate_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3685:3: lv_predicate_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7148);
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

            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleXWhileExpression7160); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3711:1: ( (lv_body_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3712:1: (lv_body_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3712:1: (lv_body_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3713:3: lv_body_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7181);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3743:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3744:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3745:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXDoWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7217);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression7227); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3752:1: ruleXDoWhileExpression returns [EObject current=null] : (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3757:6: ( (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3758:1: (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3758:1: (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3758:3: otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleXDoWhileExpression7264); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3762:1: ( (lv_body_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3763:1: (lv_body_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3763:1: (lv_body_1_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3764:3: lv_body_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7285);
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

            otherlv_2=(Token)match(input,50,FOLLOW_50_in_ruleXDoWhileExpression7297); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_2(), null);
                  
            }
            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleXDoWhileExpression7309); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3794:1: ( (lv_predicate_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3795:1: (lv_predicate_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3795:1: (lv_predicate_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3796:3: lv_predicate_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7330);
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

            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleXDoWhileExpression7342); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3830:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3831:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3832:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXBlockExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7378);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression7388); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3839:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3844:6: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3845:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3845:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3845:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3845:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3846:2: 
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

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleXBlockExpression7437); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3863:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=RULE_ID && LA50_0<=RULE_STRING)||LA50_0==11||LA50_0==13||(LA50_0>=19 && LA50_0<=20)||LA50_0==34||(LA50_0>=37 && LA50_0<=38)||LA50_0==41||(LA50_0>=43 && LA50_0<=44)||LA50_0==46||(LA50_0>=49 && LA50_0<=57)||(LA50_0>=59 && LA50_0<=60)||LA50_0==63) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3863:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3863:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3864:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3864:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3865:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7459);
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3887:2: (otherlv_3= ';' )?
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==17) ) {
            	        alt49=1;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3887:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleXBlockExpression7472); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1(), null);
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleXBlockExpression7488); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3903:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3904:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3905:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXExpressionInsideBlockRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7524);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7534); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3912:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3917:6: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3918:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3918:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=52 && LA51_0<=53)) ) {
                alt51=1;
            }
            else if ( ((LA51_0>=RULE_ID && LA51_0<=RULE_STRING)||LA51_0==11||LA51_0==13||(LA51_0>=19 && LA51_0<=20)||LA51_0==34||(LA51_0>=37 && LA51_0<=38)||LA51_0==41||(LA51_0>=43 && LA51_0<=44)||LA51_0==46||(LA51_0>=49 && LA51_0<=51)||(LA51_0>=54 && LA51_0<=57)||(LA51_0>=59 && LA51_0<=60)||LA51_0==63) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3919:2: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7584);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3932:2: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7614);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3951:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3952:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3953:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXVariableDeclarationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7649);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7659); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3960:1: ruleXVariableDeclaration returns [EObject current=null] : ( ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3965:6: ( ( ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3966:1: ( ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3966:1: ( ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3966:2: ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3966:2: ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==52) ) {
                alt52=1;
            }
            else if ( (LA52_0==53) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3966:3: ( (lv_writeable_0_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3966:3: ( (lv_writeable_0_0= 'var' ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3967:1: (lv_writeable_0_0= 'var' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3967:1: (lv_writeable_0_0= 'var' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3968:3: lv_writeable_0_0= 'var'
                    {
                    lv_writeable_0_0=(Token)match(input,52,FOLLOW_52_in_ruleXVariableDeclaration7703); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3988:7: otherlv_1= 'val'
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleXVariableDeclaration7734); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getXVariableDeclarationAccess().getValKeyword_0_1(), null);
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3992:2: ( (lv_type_2_0= ruleJvmTypeReference ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==RULE_ID||LA53_1==34||LA53_1==42) ) {
                    alt53=1;
                }
            }
            else if ( (LA53_0==20||LA53_0==63) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3993:1: (lv_type_2_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3993:1: (lv_type_2_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3994:3: lv_type_2_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7756);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4016:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4017:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4017:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4018:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXVariableDeclaration7774); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleXVariableDeclaration7791); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_4, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4044:1: ( (lv_right_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4045:1: (lv_right_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4045:1: (lv_right_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4046:3: lv_right_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7812);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4076:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4077:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4078:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmFormalParameterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7848);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter7858); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4085:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_parameterType_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4090:6: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4091:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4091:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4091:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4091:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==RULE_ID||LA54_1==34||LA54_1==42) ) {
                    alt54=1;
                }
            }
            else if ( (LA54_0==20||LA54_0==63) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4092:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4092:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4093:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7904);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4115:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4116:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4116:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4117:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJvmFormalParameter7922); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4147:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4148:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4149:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7963);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall7973); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4156:1: ruleXFeatureCall returns [EObject current=null] : ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4161:6: ( ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4162:1: ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4162:1: ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4162:2: (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4162:2: (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==34) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4162:4: otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>'
                    {
                    otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleXFeatureCall8011); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_0, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4166:1: ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4167:1: (lv_typeArguments_1_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4167:1: (lv_typeArguments_1_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4168:3: lv_typeArguments_1_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8032);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4190:2: (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==21) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4190:4: otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleXFeatureCall8045); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getCommaKeyword_0_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4194:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4195:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4195:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4196:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8066);
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
                    	    break loop55;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleXFeatureCall8080); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_0_3(), null);
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4222:3: ( (otherlv_5= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4223:1: (otherlv_5= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4223:1: (otherlv_5= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4224:3: otherlv_5= RULE_ID
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
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXFeatureCall8106); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		createLeafNode(otherlv_5, grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_1_0(), "feature"); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4239:2: ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )?
            int alt59=2;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4239:3: ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')'
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4239:3: ( (lv_explicitOperationCall_6_0= '(' ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4240:1: (lv_explicitOperationCall_6_0= '(' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4240:1: (lv_explicitOperationCall_6_0= '(' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4241:3: lv_explicitOperationCall_6_0= '('
                    {
                    lv_explicitOperationCall_6_0=(Token)match(input,20,FOLLOW_20_in_ruleXFeatureCall8125); if (state.failed) return current;
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4260:2: ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( ((LA58_0>=RULE_ID && LA58_0<=RULE_STRING)||LA58_0==11||LA58_0==13||(LA58_0>=19 && LA58_0<=20)||LA58_0==34||(LA58_0>=37 && LA58_0<=38)||LA58_0==41||(LA58_0>=43 && LA58_0<=44)||LA58_0==46||(LA58_0>=49 && LA58_0<=51)||(LA58_0>=54 && LA58_0<=57)||(LA58_0>=59 && LA58_0<=60)||LA58_0==63) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4260:3: ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4260:3: ( (lv_featureCallArguments_7_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4261:1: (lv_featureCallArguments_7_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4261:1: (lv_featureCallArguments_7_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4262:3: lv_featureCallArguments_7_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8160);
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

                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4284:2: (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                            loop57:
                            do {
                                int alt57=2;
                                int LA57_0 = input.LA(1);

                                if ( (LA57_0==21) ) {
                                    alt57=1;
                                }


                                switch (alt57) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4284:4: otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            	    {
                            	    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleXFeatureCall8173); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	createLeafNode(otherlv_8, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_1_1_0(), null);
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4288:1: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4289:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4289:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4290:3: lv_featureCallArguments_9_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8194);
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
                            	    break loop57;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleXFeatureCall8210); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4324:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4325:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4326:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXConstructorCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8248);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall8258); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4333:1: ruleXConstructorCall returns [EObject current=null] : (otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')' ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4338:6: ( (otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4339:1: (otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4339:1: (otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4339:3: otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_54_in_ruleXConstructorCall8295); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXConstructorCallAccess().getNewKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4343:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4344:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4344:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4345:3: ruleQualifiedName
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
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8322);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4362:2: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==34) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4362:4: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleXConstructorCall8335); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_2, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_2_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4366:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4367:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4367:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4368:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8356);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4390:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==21) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4390:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleXConstructorCall8369); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_4, grammarAccess.getXConstructorCallAccess().getCommaKeyword_2_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4394:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4395:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4395:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4396:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8390);
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
                    	    break loop60;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleXConstructorCall8404); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_6, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_2_3(), null);
                          
                    }

                    }
                    break;

            }

            otherlv_7=(Token)match(input,20,FOLLOW_20_in_ruleXConstructorCall8418); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4426:1: ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=RULE_ID && LA63_0<=RULE_STRING)||LA63_0==11||LA63_0==13||(LA63_0>=19 && LA63_0<=20)||LA63_0==34||(LA63_0>=37 && LA63_0<=38)||LA63_0==41||(LA63_0>=43 && LA63_0<=44)||LA63_0==46||(LA63_0>=49 && LA63_0<=51)||(LA63_0>=54 && LA63_0<=57)||(LA63_0>=59 && LA63_0<=60)||LA63_0==63) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4426:2: ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4426:2: ( (lv_arguments_8_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4427:1: (lv_arguments_8_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4427:1: (lv_arguments_8_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4428:3: lv_arguments_8_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8440);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4450:2: (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==21) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4450:4: otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) )
                    	    {
                    	    otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleXConstructorCall8453); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_9, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4454:1: ( (lv_arguments_10_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4455:1: (lv_arguments_10_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4455:1: (lv_arguments_10_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4456:3: lv_arguments_10_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8474);
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
                    	    break loop62;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,22,FOLLOW_22_in_ruleXConstructorCall8490); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4490:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4491:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4492:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXBooleanLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8526);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral8536); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4499:1: ruleXBooleanLiteral returns [EObject current=null] : ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4504:6: ( ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4505:1: ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4505:1: ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==55) ) {
                alt64=1;
            }
            else if ( (LA64_0==56) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4505:2: ( () otherlv_1= 'false' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4505:2: ( () otherlv_1= 'false' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4505:3: () otherlv_1= 'false'
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4505:3: ()
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4506:2: 
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

                    otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleXBooleanLiteral8586); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_0_1(), null);
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4524:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4524:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4525:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4525:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4526:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,56,FOLLOW_56_in_ruleXBooleanLiteral8611); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4553:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4554:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4555:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXNullLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8660);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral8670); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4562:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4567:6: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4568:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4568:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4568:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4568:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4569:2: 
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

            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleXNullLiteral8719); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4594:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4595:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4596:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXIntLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral8755);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral8765); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4603:1: ruleXIntLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4608:6: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4609:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4609:1: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4610:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4610:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4611:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral8806); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4641:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4642:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4643:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral8846);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral8856); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4650:1: ruleXStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4655:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4656:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4656:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4657:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4657:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4658:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral8897); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4688:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4689:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4690:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXTypeLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral8937);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral8947); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4697:1: ruleXTypeLiteral returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4702:6: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4703:1: ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4703:1: ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4703:2: ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4703:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4704:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4704:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4705:3: ruleQualifiedName
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
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral8999);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleXTypeLiteral9011); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getFullStopKeyword_1(), null);
                  
            }
            otherlv_2=(Token)match(input,58,FOLLOW_58_in_ruleXTypeLiteral9023); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4738:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4739:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4740:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXThrowExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9059);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression9069); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4747:1: ruleXThrowExpression returns [EObject current=null] : (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4752:6: ( (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4753:1: (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4753:1: (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4753:3: otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleXThrowExpression9106); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4757:1: ( (lv_expression_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4758:1: (lv_expression_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4758:1: (lv_expression_1_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4759:3: lv_expression_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression9127);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4789:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4790:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4791:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9163);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9173); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4798:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4803:6: ( (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4804:1: (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4804:1: (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4804:3: otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) )
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleXTryCatchFinallyExpression9210); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4808:1: ( (lv_expression_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4809:1: (lv_expression_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4809:1: (lv_expression_1_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4810:3: lv_expression_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9231);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4832:2: ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==62) ) {
                alt67=1;
            }
            else if ( (LA67_0==61) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4832:3: ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4832:3: ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4832:4: ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4832:4: ( (lv_catchClauses_2_0= ruleXCatchClause ) )+
                    int cnt65=0;
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==62) ) {
                            int LA65_2 = input.LA(2);

                            if ( (synpred88_InternalXcss()) ) {
                                alt65=1;
                            }


                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4833:1: (lv_catchClauses_2_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4833:1: (lv_catchClauses_2_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4834:3: lv_catchClauses_2_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0_0_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9254);
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
                    	    if ( cnt65 >= 1 ) break loop65;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(65, input);
                                throw eee;
                        }
                        cnt65++;
                    } while (true);

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4856:3: (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==61) ) {
                        int LA66_1 = input.LA(2);

                        if ( (synpred89_InternalXcss()) ) {
                            alt66=1;
                        }
                    }
                    switch (alt66) {
                        case 1 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4856:5: otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) )
                            {
                            otherlv_3=(Token)match(input,61,FOLLOW_61_in_ruleXTryCatchFinallyExpression9268); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	createLeafNode(otherlv_3, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_0_1_0(), null);
                                  
                            }
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4860:1: ( (lv_finallyExpression_4_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4861:1: (lv_finallyExpression_4_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4861:1: (lv_finallyExpression_4_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4862:3: lv_finallyExpression_4_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_1_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9289);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4885:6: (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4885:6: (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4885:8: otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) )
                    {
                    otherlv_5=(Token)match(input,61,FOLLOW_61_in_ruleXTryCatchFinallyExpression9311); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4889:1: ( (lv_finallyExpression_6_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4890:1: (lv_finallyExpression_6_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4890:1: (lv_finallyExpression_6_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4891:3: lv_finallyExpression_6_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9332);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4921:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4922:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4923:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCatchClauseRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9370);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause9380); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4930:1: ruleXCatchClause returns [EObject current=null] : (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4935:6: ( (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4936:1: (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4936:1: (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4936:3: otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,62,FOLLOW_62_in_ruleXCatchClause9417); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleXCatchClause9429); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4944:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4945:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4945:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4946:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause9450);
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

            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleXCatchClause9462); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4972:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4973:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4973:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4974:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause9483);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5004:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5005:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5006:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference9519);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference9529); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5013:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5018:6: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5019:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5019:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_ID) ) {
                alt68=1;
            }
            else if ( (LA68_0==20||LA68_0==63) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5020:2: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference9579);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5033:2: this_XFunctionTypeRef_1= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference9609);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5052:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5053:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5054:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXFunctionTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef9644);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef9654); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5061:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5066:6: ( ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5067:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5067:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5067:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5067:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==20) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5067:4: otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleXFunctionTypeRef9692); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5071:1: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5072:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5072:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5073:3: lv_paramTypes_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9713);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5095:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==21) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5095:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleXFunctionTypeRef9726); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5099:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5100:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5100:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5101:3: lv_paramTypes_3_0= ruleJvmTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9747);
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
                    	    break loop69;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleXFunctionTypeRef9761); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_3(), null);
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,63,FOLLOW_63_in_ruleXFunctionTypeRef9775); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5131:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5132:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5132:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5133:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9796);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5163:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5164:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5165:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference9832);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference9842); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5172:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5177:6: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5178:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5178:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5178:2: ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5178:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5179:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5179:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5180:3: ruleQualifiedName
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
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference9894);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5197:2: (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==34) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5197:4: otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleJvmParameterizedTypeReference9907); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5201:1: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5202:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5202:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5203:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference9928);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5225:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==21) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5225:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleJvmParameterizedTypeReference9941); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5229:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5230:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5230:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5231:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference9962);
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
                    	    break loop71;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleJvmParameterizedTypeReference9976); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5265:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5266:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5267:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference10014);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference10024); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5274:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5279:6: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5280:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5280:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_ID||LA73_0==20||LA73_0==63) ) {
                alt73=1;
            }
            else if ( (LA73_0==64) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5281:2: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference10074);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5294:2: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference10104);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5313:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5314:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5315:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference10139);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference10149); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5322:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5327:6: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5328:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5328:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5328:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5328:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5329:2: 
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

            otherlv_1=(Token)match(input,64,FOLLOW_64_in_ruleJvmWildcardTypeReference10198); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5346:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt74=3;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==65) ) {
                alt74=1;
            }
            else if ( (LA74_0==67) ) {
                alt74=2;
            }
            switch (alt74) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5346:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5346:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5347:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5347:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5348:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference10220);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5371:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5371:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5372:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5372:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5373:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference10247);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5403:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5404:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5405:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmUpperBoundRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound10285);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound10295); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5412:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5417:6: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5418:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5418:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5418:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,65,FOLLOW_65_in_ruleJvmUpperBound10332); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5422:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5423:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5423:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5424:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound10353);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5454:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5455:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5456:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmUpperBoundAndedRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded10389);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded10399); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5463:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5468:6: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5469:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5469:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5469:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,66,FOLLOW_66_in_ruleJvmUpperBoundAnded10436); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5473:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5474:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5474:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5475:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded10457);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5505:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5506:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5507:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmLowerBoundRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound10493);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound10503); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5514:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5519:6: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5520:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5520:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5520:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_67_in_ruleJvmLowerBound10540); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5524:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5525:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5525:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5526:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound10561);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5558:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5559:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5560:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10600);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10611); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5567:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5572:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5573:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5573:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5573:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName10651); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  createLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5580:1: (kw= '.' this_ID_2= RULE_ID )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==42) ) {
                    int LA75_2 = input.LA(2);

                    if ( (LA75_2==RULE_ID) ) {
                        int LA75_3 = input.LA(3);

                        if ( (synpred99_InternalXcss()) ) {
                            alt75=1;
                        }


                    }


                }


                switch (alt75) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5581:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,42,FOLLOW_42_in_ruleQualifiedName10670); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName10685); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          createLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop75;
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

    // $ANTLR start synpred10_InternalXcss
    public final void synpred10_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_colors_3_1 = null;

        EObject lv_colors_3_2 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:1: ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:1: ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:1: ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:736:1: (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:736:1: (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant )
        int alt76=2;
        int LA76_0 = input.LA(1);

        if ( (LA76_0==13) ) {
            alt76=1;
        }
        else if ( (LA76_0==19) ) {
            alt76=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 76, 0, input);

            throw nvae;
        }
        switch (alt76) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:737:3: lv_colors_3_1= ruleRGB
                {
                pushFollow(FOLLOW_ruleRGB_in_synpred10_InternalXcss1439);
                lv_colors_3_1=ruleRGB();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:758:8: lv_colors_3_2= ruleColorConstant
                {
                if ( state.backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getColorsColorConstantParserRuleCall_1_1_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleColorConstant_in_synpred10_InternalXcss1458);
                lv_colors_3_2=ruleColorConstant();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred10_InternalXcss

    // $ANTLR start synpred11_InternalXcss
    public final void synpred11_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_percents_4_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:783:1: ( (lv_percents_4_0= rulePercent ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:783:1: (lv_percents_4_0= rulePercent )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:783:1: (lv_percents_4_0= rulePercent )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:784:3: lv_percents_4_0= rulePercent
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getPercentsPercentParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_rulePercent_in_synpred11_InternalXcss1483);
        lv_percents_4_0=rulePercent();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalXcss

    // $ANTLR start synpred12_InternalXcss
    public final void synpred12_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_colors_3_1 = null;

        EObject lv_colors_3_2 = null;

        EObject lv_percents_4_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:715:3: ( () ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+ ( (lv_percents_4_0= rulePercent ) )* )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:715:3: () ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+ ( (lv_percents_4_0= rulePercent ) )*
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:715:3: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:716:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:734:2: ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+
        int cnt78=0;
        loop78:
        do {
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==13||LA78_0==19) ) {
                alt78=1;
            }


            switch (alt78) {
        	case 1 :
        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:1: ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) )
        	    {
        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:1: ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) )
        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:736:1: (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant )
        	    {
        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:736:1: (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant )
        	    int alt77=2;
        	    int LA77_0 = input.LA(1);

        	    if ( (LA77_0==13) ) {
        	        alt77=1;
        	    }
        	    else if ( (LA77_0==19) ) {
        	        alt77=2;
        	    }
        	    else {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        NoViableAltException nvae =
        	            new NoViableAltException("", 77, 0, input);

        	        throw nvae;
        	    }
        	    switch (alt77) {
        	        case 1 :
        	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:737:3: lv_colors_3_1= ruleRGB
        	            {
        	            pushFollow(FOLLOW_ruleRGB_in_synpred12_InternalXcss1439);
        	            lv_colors_3_1=ruleRGB();

        	            state._fsp--;
        	            if (state.failed) return ;

        	            }
        	            break;
        	        case 2 :
        	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:758:8: lv_colors_3_2= ruleColorConstant
        	            {
        	            if ( state.backtracking==0 ) {
        	               
        	              	        currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getColorsColorConstantParserRuleCall_1_1_0_1(), currentNode); 
        	              	    
        	            }
        	            pushFollow(FOLLOW_ruleColorConstant_in_synpred12_InternalXcss1458);
        	            lv_colors_3_2=ruleColorConstant();

        	            state._fsp--;
        	            if (state.failed) return ;

        	            }
        	            break;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt78 >= 1 ) break loop78;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(78, input);
                    throw eee;
            }
            cnt78++;
        } while (true);

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:782:3: ( (lv_percents_4_0= rulePercent ) )*
        loop79:
        do {
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_INT) ) {
                alt79=1;
            }


            switch (alt79) {
        	case 1 :
        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:783:1: (lv_percents_4_0= rulePercent )
        	    {
        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:783:1: (lv_percents_4_0= rulePercent )
        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:784:3: lv_percents_4_0= rulePercent
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getPercentsPercentParserRuleCall_1_2_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FOLLOW_rulePercent_in_synpred12_InternalXcss1483);
        	    lv_percents_4_0=rulePercent();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop79;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred12_InternalXcss

    // $ANTLR start synpred14_InternalXcss
    public final void synpred14_InternalXcss_fragment() throws RecognitionException {   
        Token this_ID_1=null;

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1092:6: (this_ID_1= RULE_ID )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1092:6: this_ID_1= RULE_ID
        {
        this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred14_InternalXcss2067); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalXcss

    // $ANTLR start synpred22_InternalXcss
    public final void synpred22_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_value_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1290:2: ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1290:2: () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1290:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1291:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1309:2: ( ( ruleOpAssign ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1310:1: ( ruleOpAssign )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1310:1: ( ruleOpAssign )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1311:3: ruleOpAssign
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAssign_in_synpred22_InternalXcss2608);
        ruleOpAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1328:2: ( (lv_value_3_0= ruleXAssignment ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1329:1: (lv_value_3_0= ruleXAssignment )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1329:1: (lv_value_3_0= ruleXAssignment )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1330:3: lv_value_3_0= ruleXAssignment
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAssignment_in_synpred22_InternalXcss2629);
        lv_value_3_0=ruleXAssignment();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred22_InternalXcss

    // $ANTLR start synpred24_InternalXcss
    public final void synpred24_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1423:2: ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1423:2: () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1423:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1424:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1442:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1443:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1443:1: ( ruleOpOr )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1444:3: ruleOpOr
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpOr_in_synpred24_InternalXcss2875);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1461:2: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1462:1: (lv_rightOperand_3_0= ruleXAndExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1462:1: (lv_rightOperand_3_0= ruleXAndExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1463:3: lv_rightOperand_3_0= ruleXAndExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAndExpression_in_synpred24_InternalXcss2896);
        lv_rightOperand_3_0=ruleXAndExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred24_InternalXcss

    // $ANTLR start synpred25_InternalXcss
    public final void synpred25_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1549:2: ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1549:2: () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1549:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1550:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1568:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1569:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1569:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1570:3: ruleOpAnd
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAnd_in_synpred25_InternalXcss3121);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1587:2: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1588:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1588:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1589:3: lv_rightOperand_3_0= ruleXEqualityExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXEqualityExpression_in_synpred25_InternalXcss3142);
        lv_rightOperand_3_0=ruleXEqualityExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred25_InternalXcss

    // $ANTLR start synpred26_InternalXcss
    public final void synpred26_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1675:2: ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1675:2: () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1675:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1676:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1694:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1695:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1695:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1696:3: ruleOpEquality
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpEquality_in_synpred26_InternalXcss3367);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1713:2: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1714:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1714:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1715:3: lv_rightOperand_3_0= ruleXRelationalExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXRelationalExpression_in_synpred26_InternalXcss3388);
        lv_rightOperand_3_0=ruleXRelationalExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred26_InternalXcss

    // $ANTLR start synpred28_InternalXcss
    public final void synpred28_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1808:2: ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1808:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1808:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1808:3: () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1808:3: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1809:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_2=(Token)match(input,30,FOLLOW_30_in_synpred28_InternalXcss3620); if (state.failed) return ;
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1831:1: ( ( ruleQualifiedName ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1832:1: ( ruleQualifiedName )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1832:1: ( ruleQualifiedName )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1833:3: ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred28_InternalXcss3647);
        ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred28_InternalXcss

    // $ANTLR start synpred29_InternalXcss
    public final void synpred29_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_6_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1851:6: ( ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1851:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1851:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1851:7: () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1851:7: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1852:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1870:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1871:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1871:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1872:3: ruleOpCompare
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpCompare_in_synpred29_InternalXcss3694);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1889:2: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1890:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1890:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1891:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_synpred29_InternalXcss3715);
        lv_rightOperand_6_0=ruleXOtherOperatorExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred29_InternalXcss

    // $ANTLR start synpred33_InternalXcss
    public final void synpred33_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1998:2: ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1998:2: () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1998:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1999:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2017:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2018:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2018:1: ( ruleOpOther )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2019:3: ruleOpOther
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpOther_in_synpred33_InternalXcss4000);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2036:2: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2037:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2037:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2038:3: lv_rightOperand_3_0= ruleXAdditiveExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAdditiveExpression_in_synpred33_InternalXcss4021);
        lv_rightOperand_3_0=ruleXAdditiveExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred33_InternalXcss

    // $ANTLR start synpred35_InternalXcss
    public final void synpred35_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2131:2: ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2131:2: () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2131:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2132:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2150:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2151:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2151:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2152:3: ruleOpAdd
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAdd_in_synpred35_InternalXcss4267);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2169:2: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2170:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2170:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2171:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_synpred35_InternalXcss4288);
        lv_rightOperand_3_0=ruleXMultiplicativeExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred35_InternalXcss

    // $ANTLR start synpred37_InternalXcss
    public final void synpred37_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2264:2: ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2264:2: () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2264:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2265:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2283:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2284:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2284:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2285:3: ruleOpMulti
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpMulti_in_synpred37_InternalXcss4534);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2302:2: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2303:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2303:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2304:3: lv_rightOperand_3_0= ruleXUnaryOperation
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXUnaryOperation_in_synpred37_InternalXcss4555);
        lv_rightOperand_3_0=ruleXUnaryOperation();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred37_InternalXcss

    // $ANTLR start synpred48_InternalXcss
    public final void synpred48_InternalXcss_fragment() throws RecognitionException {   
        Token lv_explicitOperationCall_9_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_memberCallArguments_10_0 = null;

        EObject lv_memberCallArguments_12_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2647:3: ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2647:3: ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')'
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2647:3: ( (lv_explicitOperationCall_9_0= '(' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2648:1: (lv_explicitOperationCall_9_0= '(' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2648:1: (lv_explicitOperationCall_9_0= '(' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2649:3: lv_explicitOperationCall_9_0= '('
        {
        lv_explicitOperationCall_9_0=(Token)match(input,20,FOLLOW_20_in_synpred48_InternalXcss5242); if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2668:2: ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )?
        int alt84=2;
        int LA84_0 = input.LA(1);

        if ( ((LA84_0>=RULE_ID && LA84_0<=RULE_STRING)||LA84_0==11||LA84_0==13||(LA84_0>=19 && LA84_0<=20)||LA84_0==34||(LA84_0>=37 && LA84_0<=38)||LA84_0==41||(LA84_0>=43 && LA84_0<=44)||LA84_0==46||(LA84_0>=49 && LA84_0<=51)||(LA84_0>=54 && LA84_0<=57)||(LA84_0>=59 && LA84_0<=60)||LA84_0==63) ) {
            alt84=1;
        }
        switch (alt84) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2668:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2668:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2669:1: (lv_memberCallArguments_10_0= ruleXExpression )
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2669:1: (lv_memberCallArguments_10_0= ruleXExpression )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2670:3: lv_memberCallArguments_10_0= ruleXExpression
                {
                if ( state.backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_0_0(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleXExpression_in_synpred48_InternalXcss5277);
                lv_memberCallArguments_10_0=ruleXExpression();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2692:2: (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                loop83:
                do {
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==21) ) {
                        alt83=1;
                    }


                    switch (alt83) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2692:4: otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                	    {
                	    otherlv_11=(Token)match(input,21,FOLLOW_21_in_synpred48_InternalXcss5290); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2696:1: ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2697:1: (lv_memberCallArguments_12_0= ruleXExpression )
                	    {
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2697:1: (lv_memberCallArguments_12_0= ruleXExpression )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2698:3: lv_memberCallArguments_12_0= ruleXExpression
                	    {
                	    if ( state.backtracking==0 ) {
                	       
                	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_1_1_0(), currentNode); 
                	      	    
                	    }
                	    pushFollow(FOLLOW_ruleXExpression_in_synpred48_InternalXcss5311);
                	    lv_memberCallArguments_12_0=ruleXExpression();

                	    state._fsp--;
                	    if (state.failed) return ;

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

        otherlv_13=(Token)match(input,22,FOLLOW_22_in_synpred48_InternalXcss5327); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_InternalXcss

    // $ANTLR start synpred49_InternalXcss
    public final void synpred49_InternalXcss_fragment() throws RecognitionException {   
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


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2547:2: ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2547:2: () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2547:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2548:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_2=(Token)match(input,42,FOLLOW_42_in_synpred49_InternalXcss5115); if (state.failed) return ;
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2570:1: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
        int alt86=2;
        int LA86_0 = input.LA(1);

        if ( (LA86_0==34) ) {
            alt86=1;
        }
        switch (alt86) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2570:3: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                {
                otherlv_3=(Token)match(input,34,FOLLOW_34_in_synpred49_InternalXcss5128); if (state.failed) return ;
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2574:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2575:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2575:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2576:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                {
                if ( state.backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_synpred49_InternalXcss5149);
                lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2598:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                loop85:
                do {
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==21) ) {
                        alt85=1;
                    }


                    switch (alt85) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2598:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                	    {
                	    otherlv_5=(Token)match(input,21,FOLLOW_21_in_synpred49_InternalXcss5162); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2602:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2603:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                	    {
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2603:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2604:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                	    {
                	    if ( state.backtracking==0 ) {
                	       
                	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_2_1_0(), currentNode); 
                	      	    
                	    }
                	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_synpred49_InternalXcss5183);
                	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop85;
                    }
                } while (true);

                otherlv_7=(Token)match(input,33,FOLLOW_33_in_synpred49_InternalXcss5197); if (state.failed) return ;

                }
                break;

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2630:3: ( (otherlv_8= RULE_ID ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2631:1: (otherlv_8= RULE_ID )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2631:1: (otherlv_8= RULE_ID )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2632:3: otherlv_8= RULE_ID
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred49_InternalXcss5223); if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2647:2: ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
        int alt89=2;
        int LA89_0 = input.LA(1);

        if ( (LA89_0==20) ) {
            alt89=1;
        }
        switch (alt89) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2647:3: ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')'
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2647:3: ( (lv_explicitOperationCall_9_0= '(' ) )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2648:1: (lv_explicitOperationCall_9_0= '(' )
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2648:1: (lv_explicitOperationCall_9_0= '(' )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2649:3: lv_explicitOperationCall_9_0= '('
                {
                lv_explicitOperationCall_9_0=(Token)match(input,20,FOLLOW_20_in_synpred49_InternalXcss5242); if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2668:2: ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )?
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( ((LA88_0>=RULE_ID && LA88_0<=RULE_STRING)||LA88_0==11||LA88_0==13||(LA88_0>=19 && LA88_0<=20)||LA88_0==34||(LA88_0>=37 && LA88_0<=38)||LA88_0==41||(LA88_0>=43 && LA88_0<=44)||LA88_0==46||(LA88_0>=49 && LA88_0<=51)||(LA88_0>=54 && LA88_0<=57)||(LA88_0>=59 && LA88_0<=60)||LA88_0==63) ) {
                    alt88=1;
                }
                switch (alt88) {
                    case 1 :
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2668:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                        {
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2668:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) )
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2669:1: (lv_memberCallArguments_10_0= ruleXExpression )
                        {
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2669:1: (lv_memberCallArguments_10_0= ruleXExpression )
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2670:3: lv_memberCallArguments_10_0= ruleXExpression
                        {
                        if ( state.backtracking==0 ) {
                           
                          	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_0_0(), currentNode); 
                          	    
                        }
                        pushFollow(FOLLOW_ruleXExpression_in_synpred49_InternalXcss5277);
                        lv_memberCallArguments_10_0=ruleXExpression();

                        state._fsp--;
                        if (state.failed) return ;

                        }


                        }

                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2692:2: (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                        loop87:
                        do {
                            int alt87=2;
                            int LA87_0 = input.LA(1);

                            if ( (LA87_0==21) ) {
                                alt87=1;
                            }


                            switch (alt87) {
                        	case 1 :
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2692:4: otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                        	    {
                        	    otherlv_11=(Token)match(input,21,FOLLOW_21_in_synpred49_InternalXcss5290); if (state.failed) return ;
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2696:1: ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2697:1: (lv_memberCallArguments_12_0= ruleXExpression )
                        	    {
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2697:1: (lv_memberCallArguments_12_0= ruleXExpression )
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2698:3: lv_memberCallArguments_12_0= ruleXExpression
                        	    {
                        	    if ( state.backtracking==0 ) {
                        	       
                        	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_1_1_0(), currentNode); 
                        	      	    
                        	    }
                        	    pushFollow(FOLLOW_ruleXExpression_in_synpred49_InternalXcss5311);
                        	    lv_memberCallArguments_12_0=ruleXExpression();

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

                otherlv_13=(Token)match(input,22,FOLLOW_22_in_synpred49_InternalXcss5327); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred49_InternalXcss

    // $ANTLR start synpred50_InternalXcss
    public final void synpred50_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XLiteral_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2748:2: (this_XLiteral_0= ruleXLiteral )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2748:2: this_XLiteral_0= ruleXLiteral
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXLiteral_in_synpred50_InternalXcss5427);
        this_XLiteral_0=ruleXLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_InternalXcss

    // $ANTLR start synpred54_InternalXcss
    public final void synpred54_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XFeatureCall_4 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2800:2: (this_XFeatureCall_4= ruleXFeatureCall )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2800:2: this_XFeatureCall_4= ruleXFeatureCall
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXFeatureCall_in_synpred54_InternalXcss5547);
        this_XFeatureCall_4=ruleXFeatureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_InternalXcss

    // $ANTLR start synpred59_InternalXcss
    public final void synpred59_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XCastedExpression_9 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2865:2: (this_XCastedExpression_9= ruleXCastedExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2865:2: this_XCastedExpression_9= ruleXCastedExpression
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXCastedExpression_in_synpred59_InternalXcss5697);
        this_XCastedExpression_9=ruleXCastedExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_InternalXcss

    // $ANTLR start synpred64_InternalXcss
    public final void synpred64_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3237:4: (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3237:4: otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) )
        {
        otherlv_5=(Token)match(input,45,FOLLOW_45_in_synpred64_InternalXcss6380); if (state.failed) return ;
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3241:1: ( (lv_else_6_0= ruleXExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3242:1: (lv_else_6_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3242:1: (lv_else_6_0= ruleXExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3243:3: lv_else_6_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_5_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred64_InternalXcss6401);
        lv_else_6_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred64_InternalXcss

    // $ANTLR start synpred65_InternalXcss
    public final void synpred65_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_switch_1_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3293:1: ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3293:1: (lv_switch_1_0= ruleXExpressionInsideBlock )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3293:1: (lv_switch_1_0= ruleXExpressionInsideBlock )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3294:3: lv_switch_1_0= ruleXExpressionInsideBlock
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionInsideBlockParserRuleCall_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_synpred65_InternalXcss6507);
        lv_switch_1_0=ruleXExpressionInsideBlock();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred65_InternalXcss

    // $ANTLR start synpred67_InternalXcss
    public final void synpred67_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        EObject lv_default_6_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3352:2: ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3352:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3352:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3352:3: ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';'
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3352:3: ( (lv_default_6_0= ruleXExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3353:1: (lv_default_6_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3353:1: (lv_default_6_0= ruleXExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3354:3: lv_default_6_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_4_2_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred67_InternalXcss6590);
        lv_default_6_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_7=(Token)match(input,17,FOLLOW_17_in_synpred67_InternalXcss6602); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred67_InternalXcss

    // $ANTLR start synpred71_InternalXcss
    public final void synpred71_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_then_4_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3488:2: ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3488:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3488:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3488:3: ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';'
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3488:3: ( (lv_then_4_0= ruleXExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3489:1: (lv_then_4_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3489:1: (lv_then_4_0= ruleXExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3490:3: lv_then_4_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred71_InternalXcss6809);
        lv_then_4_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_5=(Token)match(input,17,FOLLOW_17_in_synpred71_InternalXcss6821); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred71_InternalXcss

    // $ANTLR start synpred82_InternalXcss
    public final void synpred82_InternalXcss_fragment() throws RecognitionException {   
        Token lv_explicitOperationCall_6_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_featureCallArguments_7_0 = null;

        EObject lv_featureCallArguments_9_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4239:3: ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4239:3: ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')'
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4239:3: ( (lv_explicitOperationCall_6_0= '(' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4240:1: (lv_explicitOperationCall_6_0= '(' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4240:1: (lv_explicitOperationCall_6_0= '(' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4241:3: lv_explicitOperationCall_6_0= '('
        {
        lv_explicitOperationCall_6_0=(Token)match(input,20,FOLLOW_20_in_synpred82_InternalXcss8125); if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4260:2: ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )?
        int alt96=2;
        int LA96_0 = input.LA(1);

        if ( ((LA96_0>=RULE_ID && LA96_0<=RULE_STRING)||LA96_0==11||LA96_0==13||(LA96_0>=19 && LA96_0<=20)||LA96_0==34||(LA96_0>=37 && LA96_0<=38)||LA96_0==41||(LA96_0>=43 && LA96_0<=44)||LA96_0==46||(LA96_0>=49 && LA96_0<=51)||(LA96_0>=54 && LA96_0<=57)||(LA96_0>=59 && LA96_0<=60)||LA96_0==63) ) {
            alt96=1;
        }
        switch (alt96) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4260:3: ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4260:3: ( (lv_featureCallArguments_7_0= ruleXExpression ) )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4261:1: (lv_featureCallArguments_7_0= ruleXExpression )
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4261:1: (lv_featureCallArguments_7_0= ruleXExpression )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4262:3: lv_featureCallArguments_7_0= ruleXExpression
                {
                if ( state.backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_0_0(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleXExpression_in_synpred82_InternalXcss8160);
                lv_featureCallArguments_7_0=ruleXExpression();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4284:2: (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                loop95:
                do {
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==21) ) {
                        alt95=1;
                    }


                    switch (alt95) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4284:4: otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                	    {
                	    otherlv_8=(Token)match(input,21,FOLLOW_21_in_synpred82_InternalXcss8173); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4288:1: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4289:1: (lv_featureCallArguments_9_0= ruleXExpression )
                	    {
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4289:1: (lv_featureCallArguments_9_0= ruleXExpression )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4290:3: lv_featureCallArguments_9_0= ruleXExpression
                	    {
                	    if ( state.backtracking==0 ) {
                	       
                	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_1_1_0(), currentNode); 
                	      	    
                	    }
                	    pushFollow(FOLLOW_ruleXExpression_in_synpred82_InternalXcss8194);
                	    lv_featureCallArguments_9_0=ruleXExpression();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop95;
                    }
                } while (true);


                }
                break;

        }

        otherlv_10=(Token)match(input,22,FOLLOW_22_in_synpred82_InternalXcss8210); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred82_InternalXcss

    // $ANTLR start synpred88_InternalXcss
    public final void synpred88_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_catchClauses_2_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4833:1: ( (lv_catchClauses_2_0= ruleXCatchClause ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4833:1: (lv_catchClauses_2_0= ruleXCatchClause )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4833:1: (lv_catchClauses_2_0= ruleXCatchClause )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4834:3: lv_catchClauses_2_0= ruleXCatchClause
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXCatchClause_in_synpred88_InternalXcss9254);
        lv_catchClauses_2_0=ruleXCatchClause();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred88_InternalXcss

    // $ANTLR start synpred89_InternalXcss
    public final void synpred89_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        EObject lv_finallyExpression_4_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4856:5: (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4856:5: otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) )
        {
        otherlv_3=(Token)match(input,61,FOLLOW_61_in_synpred89_InternalXcss9268); if (state.failed) return ;
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4860:1: ( (lv_finallyExpression_4_0= ruleXExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4861:1: (lv_finallyExpression_4_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4861:1: (lv_finallyExpression_4_0= ruleXExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4862:3: lv_finallyExpression_4_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred89_InternalXcss9289);
        lv_finallyExpression_4_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred89_InternalXcss

    // $ANTLR start synpred99_InternalXcss
    public final void synpred99_InternalXcss_fragment() throws RecognitionException {   
        Token kw=null;
        Token this_ID_2=null;

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5581:2: (kw= '.' this_ID_2= RULE_ID )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5581:2: kw= '.' this_ID_2= RULE_ID
        {
        kw=(Token)match(input,42,FOLLOW_42_in_synpred99_InternalXcss10670); if (state.failed) return ;
        this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred99_InternalXcss10685); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred99_InternalXcss

    // Delegated rules

    public final boolean synpred24_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred88_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_InternalXcss_fragment(); // can never throw exception
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
    public final boolean synpred67_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_InternalXcss_fragment(); // can never throw exception
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
    public final boolean synpred71_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_InternalXcss_fragment(); // can never throw exception
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
    public final boolean synpred14_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalXcss_fragment(); // can never throw exception
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
    public final boolean synpred82_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred82_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_InternalXcss_fragment(); // can never throw exception
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
    public final boolean synpred22_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalXcss_fragment(); // can never throw exception
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
    public final boolean synpred29_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA11 dfa11 = new DFA11(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA59 dfa59 = new DFA59(this);
    static final String DFA11_eotS =
        "\17\uffff";
    static final String DFA11_eofS =
        "\1\3\16\uffff";
    static final String DFA11_minS =
        "\3\4\1\uffff\1\5\3\0\1\25\1\uffff\1\5\1\25\1\5\1\26\1\0";
    static final String DFA11_maxS =
        "\1\77\1\24\1\4\1\uffff\1\5\3\0\1\25\1\uffff\1\5\1\25\1\5\1\26\1"+
        "\0";
    static final String DFA11_acceptS =
        "\3\uffff\1\2\5\uffff\1\1\5\uffff";
    static final String DFA11_specialS =
        "\5\uffff\1\3\1\0\1\1\6\uffff\1\2}>";
    static final String[] DFA11_transitionS = {
            "\3\3\4\uffff\2\3\1\1\1\3\1\uffff\3\3\1\2\33\3\2\uffff\11\3\1"+
            "\uffff\5\3",
            "\1\6\1\5\16\uffff\1\4",
            "\1\7",
            "",
            "\1\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\12",
            "",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\uffff"
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "715:2: ( () ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+ ( (lv_percents_4_0= rulePercent ) )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_6 = input.LA(1);

                         
                        int index11_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalXcss()) ) {s = 9;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index11_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_7 = input.LA(1);

                         
                        int index11_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalXcss()) ) {s = 9;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index11_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_14 = input.LA(1);

                         
                        int index11_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalXcss()) ) {s = 9;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index11_14);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_5 = input.LA(1);

                         
                        int index11_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalXcss()) ) {s = 9;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index11_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA9_eotS =
        "\17\uffff";
    static final String DFA9_eofS =
        "\1\1\16\uffff";
    static final String DFA9_minS =
        "\1\4\1\uffff\2\4\1\5\3\0\1\25\1\uffff\1\5\1\25\1\5\1\26\1\0";
    static final String DFA9_maxS =
        "\1\77\1\uffff\1\24\1\4\1\5\3\0\1\25\1\uffff\1\5\1\25\1\5\1\26\1"+
        "\0";
    static final String DFA9_acceptS =
        "\1\uffff\1\2\7\uffff\1\1\5\uffff";
    static final String DFA9_specialS =
        "\5\uffff\1\3\1\0\1\1\6\uffff\1\2}>";
    static final String[] DFA9_transitionS = {
            "\3\1\4\uffff\2\1\1\2\1\1\1\uffff\3\1\1\3\33\1\2\uffff\11\1\1"+
            "\uffff\5\1",
            "",
            "\1\6\1\5\16\uffff\1\4",
            "\1\7",
            "\1\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\12",
            "",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\uffff"
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
            return "()+ loopback of 734:2: ( ( (lv_colors_3_1= ruleRGB | lv_colors_3_2= ruleColorConstant ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_6 = input.LA(1);

                         
                        int index9_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalXcss()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_7 = input.LA(1);

                         
                        int index9_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalXcss()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_14 = input.LA(1);

                         
                        int index9_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalXcss()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_14);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_5 = input.LA(1);

                         
                        int index9_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalXcss()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_5);
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
    static final String DFA10_eotS =
        "\67\uffff";
    static final String DFA10_eofS =
        "\1\1\66\uffff";
    static final String DFA10_minS =
        "\1\4\51\uffff\1\0\14\uffff";
    static final String DFA10_maxS =
        "\1\77\51\uffff\1\0\14\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\2\64\uffff\1\1";
    static final String DFA10_specialS =
        "\52\uffff\1\0\14\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1\1\52\1\1\4\uffff\4\1\1\uffff\37\1\2\uffff\11\1\1\uffff"+
            "\5\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            "",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "()* loopback of 782:3: ( (lv_percents_4_0= rulePercent ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_42 = input.LA(1);

                         
                        int index10_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalXcss()) ) {s = 54;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index10_42);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA15_eotS =
        "\13\uffff";
    static final String DFA15_eofS =
        "\13\uffff";
    static final String DFA15_minS =
        "\1\4\1\uffff\1\4\5\uffff\2\4\1\uffff";
    static final String DFA15_maxS =
        "\1\77\1\uffff\1\53\5\uffff\1\72\1\52\1\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\2\uffff\1\7";
    static final String DFA15_specialS =
        "\13\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\2\1\5\1\7\6\uffff\1\1\5\uffff\1\1\1\3\26\uffff\1\3\13\uffff"+
            "\2\4\1\6\5\uffff\1\3",
            "",
            "\1\3\20\uffff\1\3\14\uffff\1\3\7\uffff\1\10\1\3",
            "",
            "",
            "",
            "",
            "",
            "\1\11\65\uffff\1\12",
            "\1\3\35\uffff\1\3\7\uffff\1\10",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1130:1: (this_ColorLiteral_0= ruleColorLiteral | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )";
        }
    }
    static final String DFA36_eotS =
        "\67\uffff";
    static final String DFA36_eofS =
        "\1\2\66\uffff";
    static final String DFA36_minS =
        "\1\4\1\0\65\uffff";
    static final String DFA36_maxS =
        "\1\77\1\0\65\uffff";
    static final String DFA36_acceptS =
        "\2\uffff\1\2\63\uffff\1\1";
    static final String DFA36_specialS =
        "\1\uffff\1\0\65\uffff}>";
    static final String[] DFA36_transitionS = {
            "\3\2\4\uffff\4\2\1\uffff\4\2\1\1\32\2\2\uffff\11\2\1\uffff\5"+
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
            return "2647:2: ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_1 = input.LA(1);

                         
                        int index36_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_InternalXcss()) ) {s = 54;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index36_1);
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
    static final String DFA38_eotS =
        "\30\uffff";
    static final String DFA38_eofS =
        "\30\uffff";
    static final String DFA38_minS =
        "\1\4\2\uffff\2\0\23\uffff";
    static final String DFA38_maxS =
        "\1\77\2\uffff\2\0\23\uffff";
    static final String DFA38_acceptS =
        "\1\uffff\1\1\12\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\13\1\14"+
        "\1\12\1\15";
    static final String DFA38_specialS =
        "\3\uffff\1\0\1\1\23\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\3\2\1\4\uffff\1\15\1\uffff\1\1\5\uffff\1\1\1\4\15\uffff\1"+
            "\17\10\uffff\1\1\1\20\1\uffff\1\16\2\uffff\1\21\1\22\1\23\2"+
            "\uffff\1\14\3\1\1\uffff\1\24\1\25\2\uffff\1\1",
            "",
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
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "2747:1: (this_XLiteral_0= ruleXLiteral | this_XConstructorCall_1= ruleXConstructorCall | this_XBlockExpression_2= ruleXBlockExpression | this_XSwitchExpression_3= ruleXSwitchExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XCastedExpression_9= ruleXCastedExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_3 = input.LA(1);

                         
                        int index38_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_InternalXcss()) ) {s = 1;}

                        else if ( (synpred54_InternalXcss()) ) {s = 15;}

                         
                        input.seek(index38_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_4 = input.LA(1);

                         
                        int index38_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_InternalXcss()) ) {s = 1;}

                        else if ( (synpred59_InternalXcss()) ) {s = 22;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index38_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA42_eotS =
        "\34\uffff";
    static final String DFA42_eofS =
        "\34\uffff";
    static final String DFA42_minS =
        "\1\4\21\uffff\1\0\11\uffff";
    static final String DFA42_maxS =
        "\1\77\21\uffff\1\0\11\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\1\31\uffff\1\2";
    static final String DFA42_specialS =
        "\22\uffff\1\0\11\uffff}>";
    static final String[] DFA42_transitionS = {
            "\3\1\4\uffff\1\22\1\uffff\1\1\5\uffff\2\1\15\uffff\1\1\2\uffff"+
            "\2\1\2\uffff\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff\11\1\1\uffff"+
            "\2\1\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "3292:1: ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_18 = input.LA(1);

                         
                        int index42_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_InternalXcss()) ) {s = 1;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index42_18);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA44_eotS =
        "\32\uffff";
    static final String DFA44_eofS =
        "\32\uffff";
    static final String DFA44_minS =
        "\1\4\17\uffff\1\0\11\uffff";
    static final String DFA44_maxS =
        "\1\77\17\uffff\1\0\11\uffff";
    static final String DFA44_acceptS =
        "\1\uffff\1\1\27\uffff\1\2";
    static final String DFA44_specialS =
        "\20\uffff\1\0\11\uffff}>";
    static final String[] DFA44_transitionS = {
            "\3\1\4\uffff\1\20\1\uffff\1\1\5\uffff\2\1\15\uffff\1\1\2\uffff"+
            "\2\1\2\uffff\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff\3\1\2\uffff"+
            "\4\1\1\uffff\2\1\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "3352:1: ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA44_16 = input.LA(1);

                         
                        int index44_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_InternalXcss()) ) {s = 1;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index44_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 44, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA48_eotS =
        "\32\uffff";
    static final String DFA48_eofS =
        "\32\uffff";
    static final String DFA48_minS =
        "\1\4\17\uffff\1\0\11\uffff";
    static final String DFA48_maxS =
        "\1\77\17\uffff\1\0\11\uffff";
    static final String DFA48_acceptS =
        "\1\uffff\1\1\27\uffff\1\2";
    static final String DFA48_specialS =
        "\20\uffff\1\0\11\uffff}>";
    static final String[] DFA48_transitionS = {
            "\3\1\4\uffff\1\20\1\uffff\1\1\5\uffff\2\1\15\uffff\1\1\2\uffff"+
            "\2\1\2\uffff\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff\3\1\2\uffff"+
            "\4\1\1\uffff\2\1\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "3488:1: ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA48_16 = input.LA(1);

                         
                        int index48_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred71_InternalXcss()) ) {s = 1;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index48_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 48, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA59_eotS =
        "\67\uffff";
    static final String DFA59_eofS =
        "\1\2\66\uffff";
    static final String DFA59_minS =
        "\1\4\1\0\65\uffff";
    static final String DFA59_maxS =
        "\1\77\1\0\65\uffff";
    static final String DFA59_acceptS =
        "\2\uffff\1\2\63\uffff\1\1";
    static final String DFA59_specialS =
        "\1\uffff\1\0\65\uffff}>";
    static final String[] DFA59_transitionS = {
            "\3\2\4\uffff\4\2\1\uffff\4\2\1\1\32\2\2\uffff\11\2\1\uffff\5"+
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
            return "4239:2: ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_1 = input.LA(1);

                         
                        int index59_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_InternalXcss()) ) {s = 54;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index59_1);
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
 

    public static final BitSet FOLLOW_ruleStyleSheet_in_entryRuleStyleSheet81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStyleSheet91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStyleRule_in_ruleStyleSheet149 = new BitSet(new long[]{0x0000000000006012L});
    public static final BitSet FOLLOW_ruleStyleRule_in_entryRuleStyleRule186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStyleRule196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelector_in_ruleStyleRule242 = new BitSet(new long[]{0x0000000000006810L});
    public static final BitSet FOLLOW_11_in_ruleStyleRule255 = new BitSet(new long[]{0x9BCE5A6400183870L});
    public static final BitSet FOLLOW_ruleSetting_in_ruleStyleRule276 = new BitSet(new long[]{0x9BCE5A6400183870L});
    public static final BitSet FOLLOW_12_in_ruleStyleRule289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelector_in_entryRuleSelector327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelector337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeSelector_in_ruleSelector388 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleWildcardSelector_in_ruleSelector418 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleIdSelector_in_ruleSelector448 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleFilter_in_ruleSelector469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeSelector_in_entryRuleTypeSelector506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeSelector516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeSelector567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdSelector_in_entryRuleIdSelector602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdSelector612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleIdSelector649 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdSelector666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcardSelector_in_entryRuleWildcardSelector707 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcardSelector717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleWildcardSelector766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFilter_in_entryRuleFilter802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFilter812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleFilter849 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleFilter874 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFilter885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSetting_in_entryRuleSetting921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSetting931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleSetting982 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSetting993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureReference_in_ruleSetting1034 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleOpSettingAssign_in_ruleSetting1061 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleSetting1082 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSetting1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSettingAssign_in_entryRuleOpSettingAssign1132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSettingAssign1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleOpSettingAssign1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureReference_in_entryRuleFeatureReference1219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureReference1229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureReference1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColorLiteral_in_entryRuleColorLiteral1312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColorLiteral1322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGB_in_ruleColorLiteral1373 = new BitSet(new long[]{0x0000000000082002L});
    public static final BitSet FOLLOW_ruleColorConstant_in_ruleColorLiteral1403 = new BitSet(new long[]{0x0000000000082002L});
    public static final BitSet FOLLOW_ruleRGB_in_ruleColorLiteral1439 = new BitSet(new long[]{0x0000000000082022L});
    public static final BitSet FOLLOW_ruleColorConstant_in_ruleColorLiteral1458 = new BitSet(new long[]{0x0000000000082022L});
    public static final BitSet FOLLOW_rulePercent_in_ruleColorLiteral1483 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleColorConstant_in_entryRuleColorConstant1522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColorConstant1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleColorConstant1569 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleColorConstant1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGB_in_entryRuleRGB1629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRGB1639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleRGB1683 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleHEXINT_in_ruleRGB1717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleRGB1737 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleRGB1749 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGB1766 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleRGB1783 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGB1800 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleRGB1817 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRGB1834 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleRGB1851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePercent_in_entryRulePercent1888 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePercent1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePercent1940 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rulePercent1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXINT_in_entryRuleHEXINT1994 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXINT2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleHEXINT2046 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHEXINT2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHEXINT2096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral2141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral2151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColorLiteral_in_ruleXLiteral2201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXLiteral2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression2416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression2426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression2475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment2509 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment2519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment2569 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_ruleXAssignment2608 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_entryRuleOpAssign2668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAssign2679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpAssign2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpAssign2736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression2776 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression2836 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression2875 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression2896 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr2935 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr2946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpOr2983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression3022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression3032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3082 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression3121 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3142 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd3181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd3192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpAnd3229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression3268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression3278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3328 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression3367 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3388 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality3427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpEquality3476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpEquality3495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression3535 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression3545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression3595 = new BitSet(new long[]{0x00000007C0000002L});
    public static final BitSet FOLLOW_30_in_ruleXRelationalExpression3620 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression3647 = new BitSet(new long[]{0x00000007C0000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression3694 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression3715 = new BitSet(new long[]{0x00000007C0000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare3755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare3766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpCompare3804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpCompare3823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpCompare3842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpCompare3861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression3901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression3911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3961 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression4000 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4021 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther4060 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther4071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpOther4109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpOther4128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression4168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression4178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4228 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression4267 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4288 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd4327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd4338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpAdd4376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpAdd4395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression4435 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression4445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression4495 = new BitSet(new long[]{0x0000018000804002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression4534 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression4555 = new BitSet(new long[]{0x0000018000804002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti4594 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti4605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOpMulti4643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpMulti4662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOpMulti4681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpMulti4700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation4740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation4750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation4815 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation4836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation4868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary4904 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary4915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOpUnary4953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpUnary4972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpUnary4991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall5031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall5041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall5091 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleXMemberFeatureCall5115 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_34_in_ruleXMemberFeatureCall5128 = new BitSet(new long[]{0x8000000000100010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall5149 = new BitSet(new long[]{0x0000000200200000L});
    public static final BitSet FOLLOW_21_in_ruleXMemberFeatureCall5162 = new BitSet(new long[]{0x8000000000100010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall5183 = new BitSet(new long[]{0x0000000200200000L});
    public static final BitSet FOLLOW_33_in_ruleXMemberFeatureCall5197 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXMemberFeatureCall5223 = new BitSet(new long[]{0x0000040000100002L});
    public static final BitSet FOLLOW_20_in_ruleXMemberFeatureCall5242 = new BitSet(new long[]{0x9BCE5A6400582870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5277 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleXMemberFeatureCall5290 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5311 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_ruleXMemberFeatureCall5327 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression5367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression5377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression5427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression5457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression5487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression5517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression5547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression5577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression5607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression5637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression5667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXPrimaryExpression5697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression5727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression5757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression5787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure5822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure5832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5891 = new BitSet(new long[]{0x0000080000200000L});
    public static final BitSet FOLLOW_21_in_ruleXClosure5904 = new BitSet(new long[]{0x8000000000100010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5925 = new BitSet(new long[]{0x0000080000200000L});
    public static final BitSet FOLLOW_43_in_ruleXClosure5941 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXClosure5962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression5998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression6008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleXCastedExpression6045 = new BitSet(new long[]{0x8000000000100010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression6066 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleXCastedExpression6078 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression6099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression6145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleXParenthesizedExpression6182 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6207 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleXParenthesizedExpression6218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression6264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleXIfExpression6301 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleXIfExpression6313 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6334 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleXIfExpression6346 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6367 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleXIfExpression6380 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression6449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleXSwitchExpression6486 = new BitSet(new long[]{0x9BFE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXSwitchExpression6507 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleXSwitchExpression6520 = new BitSet(new long[]{0x8001000000140010L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6541 = new BitSet(new long[]{0x8001800000141010L});
    public static final BitSet FOLLOW_47_in_ruleXSwitchExpression6555 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleXSwitchExpression6567 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6590 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXSwitchExpression6602 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXSwitchExpression6630 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXSwitchExpression6645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6681 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6737 = new BitSet(new long[]{0x0001000000040000L});
    public static final BitSet FOLLOW_48_in_ruleXCasePart6751 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6772 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleXCasePart6786 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6809 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXCasePart6821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXCasePart6849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression6896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleXForLoopExpression6933 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleXForLoopExpression6945 = new BitSet(new long[]{0x8000000000100010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6966 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleXForLoopExpression6978 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6999 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleXForLoopExpression7011 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression7032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression7068 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression7078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleXWhileExpression7115 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleXWhileExpression7127 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7148 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleXWhileExpression7160 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression7227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleXDoWhileExpression7264 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7285 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleXDoWhileExpression7297 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleXDoWhileExpression7309 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7330 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleXDoWhileExpression7342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression7388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleXBlockExpression7437 = new BitSet(new long[]{0x9BFE5A6400183870L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7459 = new BitSet(new long[]{0x9BFE5A64001A3870L});
    public static final BitSet FOLLOW_17_in_ruleXBlockExpression7472 = new BitSet(new long[]{0x9BFE5A6400183870L});
    public static final BitSet FOLLOW_12_in_ruleXBlockExpression7488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7524 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7649 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXVariableDeclaration7703 = new BitSet(new long[]{0x8000000000100010L});
    public static final BitSet FOLLOW_53_in_ruleXVariableDeclaration7734 = new BitSet(new long[]{0x8000000000100010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7756 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXVariableDeclaration7774 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleXVariableDeclaration7791 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7848 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter7858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7904 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJvmFormalParameter7922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall7973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleXFeatureCall8011 = new BitSet(new long[]{0x8000000000100010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8032 = new BitSet(new long[]{0x0000000200200000L});
    public static final BitSet FOLLOW_21_in_ruleXFeatureCall8045 = new BitSet(new long[]{0x8000000000100010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8066 = new BitSet(new long[]{0x0000000200200000L});
    public static final BitSet FOLLOW_33_in_ruleXFeatureCall8080 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXFeatureCall8106 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleXFeatureCall8125 = new BitSet(new long[]{0x9BCE5A6400582870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8160 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleXFeatureCall8173 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8194 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_ruleXFeatureCall8210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall8258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXConstructorCall8295 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8322 = new BitSet(new long[]{0x0000000400100000L});
    public static final BitSet FOLLOW_34_in_ruleXConstructorCall8335 = new BitSet(new long[]{0x8000000000100010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8356 = new BitSet(new long[]{0x0000000200200000L});
    public static final BitSet FOLLOW_21_in_ruleXConstructorCall8369 = new BitSet(new long[]{0x8000000000100010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8390 = new BitSet(new long[]{0x0000000200200000L});
    public static final BitSet FOLLOW_33_in_ruleXConstructorCall8404 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleXConstructorCall8418 = new BitSet(new long[]{0x9BCE5A6400582870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8440 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleXConstructorCall8453 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8474 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_ruleXConstructorCall8490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8526 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral8536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXBooleanLiteral8586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleXBooleanLiteral8611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral8670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleXNullLiteral8719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral8755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral8765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral8806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral8846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral8856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral8897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral8937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral8947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral8999 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXTypeLiteral9011 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleXTypeLiteral9023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9059 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression9069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleXThrowExpression9106 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression9127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleXTryCatchFinallyExpression9210 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9231 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9254 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXTryCatchFinallyExpression9268 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXTryCatchFinallyExpression9311 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause9380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXCatchClause9417 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleXCatchClause9429 = new BitSet(new long[]{0x8000000000100010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause9450 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleXCatchClause9462 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause9483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference9519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference9529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference9579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference9609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef9644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef9654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleXFunctionTypeRef9692 = new BitSet(new long[]{0x8000000000100010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9713 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleXFunctionTypeRef9726 = new BitSet(new long[]{0x8000000000100010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9747 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_ruleXFunctionTypeRef9761 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleXFunctionTypeRef9775 = new BitSet(new long[]{0x8000000000100010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference9832 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference9842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference9894 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleJvmParameterizedTypeReference9907 = new BitSet(new long[]{0x8000000000100010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference9928 = new BitSet(new long[]{0x0000000200200000L});
    public static final BitSet FOLLOW_21_in_ruleJvmParameterizedTypeReference9941 = new BitSet(new long[]{0x8000000000100010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference9962 = new BitSet(new long[]{0x0000000200200000L});
    public static final BitSet FOLLOW_33_in_ruleJvmParameterizedTypeReference9976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference10014 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference10024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference10074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference10104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference10139 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference10149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleJvmWildcardTypeReference10198 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000AL});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference10220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference10247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound10285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound10295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleJvmUpperBound10332 = new BitSet(new long[]{0x8000000000100010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound10353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded10389 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded10399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleJvmUpperBoundAnded10436 = new BitSet(new long[]{0x8000000000100010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded10457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound10493 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound10503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleJvmLowerBound10540 = new BitSet(new long[]{0x8000000000100010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound10561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10651 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleQualifiedName10670 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10685 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleRGB_in_synpred10_InternalXcss1439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColorConstant_in_synpred10_InternalXcss1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePercent_in_synpred11_InternalXcss1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGB_in_synpred12_InternalXcss1439 = new BitSet(new long[]{0x0000000000082022L});
    public static final BitSet FOLLOW_ruleColorConstant_in_synpred12_InternalXcss1458 = new BitSet(new long[]{0x0000000000082022L});
    public static final BitSet FOLLOW_rulePercent_in_synpred12_InternalXcss1483 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred14_InternalXcss2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_synpred22_InternalXcss2608 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXAssignment_in_synpred22_InternalXcss2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred24_InternalXcss2875 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_synpred24_InternalXcss2896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred25_InternalXcss3121 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_synpred25_InternalXcss3142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred26_InternalXcss3367 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_synpred26_InternalXcss3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred28_InternalXcss3620 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred28_InternalXcss3647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred29_InternalXcss3694 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_synpred29_InternalXcss3715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred33_InternalXcss4000 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_synpred33_InternalXcss4021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred35_InternalXcss4267 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_synpred35_InternalXcss4288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred37_InternalXcss4534 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_synpred37_InternalXcss4555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_synpred48_InternalXcss5242 = new BitSet(new long[]{0x9BCE5A6400582870L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred48_InternalXcss5277 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_synpred48_InternalXcss5290 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred48_InternalXcss5311 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_synpred48_InternalXcss5327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred49_InternalXcss5115 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_34_in_synpred49_InternalXcss5128 = new BitSet(new long[]{0x8000000000100010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_synpred49_InternalXcss5149 = new BitSet(new long[]{0x0000000200200000L});
    public static final BitSet FOLLOW_21_in_synpred49_InternalXcss5162 = new BitSet(new long[]{0x8000000000100010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_synpred49_InternalXcss5183 = new BitSet(new long[]{0x0000000200200000L});
    public static final BitSet FOLLOW_33_in_synpred49_InternalXcss5197 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred49_InternalXcss5223 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_synpred49_InternalXcss5242 = new BitSet(new long[]{0x9BCE5A6400582870L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred49_InternalXcss5277 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_synpred49_InternalXcss5290 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred49_InternalXcss5311 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_synpred49_InternalXcss5327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_synpred50_InternalXcss5427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_synpred54_InternalXcss5547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_synpred59_InternalXcss5697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred64_InternalXcss6380 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred64_InternalXcss6401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_synpred65_InternalXcss6507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred67_InternalXcss6590 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_synpred67_InternalXcss6602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred71_InternalXcss6809 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_synpred71_InternalXcss6821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_synpred82_InternalXcss8125 = new BitSet(new long[]{0x9BCE5A6400582870L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred82_InternalXcss8160 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_synpred82_InternalXcss8173 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred82_InternalXcss8194 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_synpred82_InternalXcss8210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_synpred88_InternalXcss9254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred89_InternalXcss9268 = new BitSet(new long[]{0x9BCE5A6400182870L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred89_InternalXcss9289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred99_InternalXcss10670 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred99_InternalXcss10685 = new BitSet(new long[]{0x0000000000000002L});

}