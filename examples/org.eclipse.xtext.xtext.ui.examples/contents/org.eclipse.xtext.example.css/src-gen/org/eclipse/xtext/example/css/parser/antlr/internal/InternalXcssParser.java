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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'*'", "'['", "']'", "';'", "':'", "'font'", "'I'", "'B'", "'#'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'**'", "'/'", "'%'", "'!'", "'.'", "','", "'('", "')'", "'|'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'new'", "'false'", "'true'", "'null'", "'class'", "'throw'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'extends'", "'&'", "'super'", "'em'", "'pt'", "'px'"
    };
    public static final int T__42=42;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__57=57;
    public static final int T__23=23;
    public static final int T__51=51;
    public static final int T__13=13;
    public static final int RULE_STRING=4;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__19=19;
    public static final int T__72=72;
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
    public static final int RULE_ID=5;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:88:1: ruleStyleSheet returns [EObject current=null] : ( () ( (lv_rules_1_0= ruleStyleRule ) )* ) ;
    public final EObject ruleStyleSheet() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:93:6: ( ( () ( (lv_rules_1_0= ruleStyleRule ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:94:1: ( () ( (lv_rules_1_0= ruleStyleRule ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:94:1: ( () ( (lv_rules_1_0= ruleStyleRule ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:94:2: () ( (lv_rules_1_0= ruleStyleRule ) )*
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:94:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:95:2: 
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:108:2: ( (lv_rules_1_0= ruleStyleRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:109:1: (lv_rules_1_0= ruleStyleRule )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:109:1: (lv_rules_1_0= ruleStyleRule )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:110:3: lv_rules_1_0= ruleStyleRule
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:140:1: entryRuleStyleRule returns [EObject current=null] : iv_ruleStyleRule= ruleStyleRule EOF ;
    public final EObject entryRuleStyleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStyleRule = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:141:2: (iv_ruleStyleRule= ruleStyleRule EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:142:2: iv_ruleStyleRule= ruleStyleRule EOF
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:149:1: ruleStyleRule returns [EObject current=null] : ( ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )* otherlv_3= '}' ) ;
    public final EObject ruleStyleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_selectors_0_0 = null;

        EObject lv_settings_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:154:6: ( ( ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )* otherlv_3= '}' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:155:1: ( ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )* otherlv_3= '}' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:155:1: ( ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )* otherlv_3= '}' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:155:2: ( (lv_selectors_0_0= ruleSelector ) )+ otherlv_1= '{' ( (lv_settings_2_0= ruleSetting ) )* otherlv_3= '}'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:155:2: ( (lv_selectors_0_0= ruleSelector ) )+
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
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:156:1: (lv_selectors_0_0= ruleSelector )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:156:1: (lv_selectors_0_0= ruleSelector )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:157:3: lv_selectors_0_0= ruleSelector
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:183:1: ( (lv_settings_2_0= ruleSetting ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_INT)||LA3_0==11||LA3_0==18||LA3_0==21||LA3_0==32||(LA3_0>=35 && LA3_0<=36)||LA3_0==40||LA3_0==43||(LA3_0>=45 && LA3_0<=46)||LA3_0==48||(LA3_0>=51 && LA3_0<=53)||(LA3_0>=56 && LA3_0<=59)||(LA3_0>=61 && LA3_0<=62)||LA3_0==65) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:184:1: (lv_settings_2_0= ruleSetting )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:184:1: (lv_settings_2_0= ruleSetting )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:185:3: lv_settings_2_0= ruleSetting
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
            pushFollow(FOLLOW_ruleSelector_in_entryRuleSelector325);
            iv_ruleSelector=ruleSelector();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelector; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelector335); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:228:1: ruleSelector returns [EObject current=null] : ( (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector ) ( (lv_filter_2_0= ruleFilter ) )? ) ;
    public final EObject ruleSelector() throws RecognitionException {
        EObject current = null;

        EObject this_TypeSelector_0 = null;

        EObject this_WildcardSelector_1 = null;

        EObject lv_filter_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:233:6: ( ( (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector ) ( (lv_filter_2_0= ruleFilter ) )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:234:1: ( (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector ) ( (lv_filter_2_0= ruleFilter ) )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:234:1: ( (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector ) ( (lv_filter_2_0= ruleFilter ) )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:234:2: (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector ) ( (lv_filter_2_0= ruleFilter ) )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:234:2: (this_TypeSelector_0= ruleTypeSelector | this_WildcardSelector_1= ruleWildcardSelector )
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:235:2: this_TypeSelector_0= ruleTypeSelector
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getSelectorAccess().getTypeSelectorParserRuleCall_0_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeSelector_in_ruleSelector386);
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
                    pushFollow(FOLLOW_ruleWildcardSelector_in_ruleSelector416);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:259:2: ( (lv_filter_2_0= ruleFilter ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:260:1: (lv_filter_2_0= ruleFilter )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:260:1: (lv_filter_2_0= ruleFilter )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:261:3: lv_filter_2_0= ruleFilter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSelectorAccess().getFilterFilterParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFilter_in_ruleSelector437);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:293:1: entryRuleTypeSelector returns [EObject current=null] : iv_ruleTypeSelector= ruleTypeSelector EOF ;
    public final EObject entryRuleTypeSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeSelector = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:294:2: (iv_ruleTypeSelector= ruleTypeSelector EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:295:2: iv_ruleTypeSelector= ruleTypeSelector EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeSelectorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeSelector_in_entryRuleTypeSelector476);
            iv_ruleTypeSelector=ruleTypeSelector();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeSelector; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeSelector486); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:302:1: ruleTypeSelector returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleTypeSelector() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:307:6: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:308:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:308:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:309:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:309:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:310:3: ruleQualifiedName
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
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeSelector537);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:335:1: entryRuleWildcardSelector returns [EObject current=null] : iv_ruleWildcardSelector= ruleWildcardSelector EOF ;
    public final EObject entryRuleWildcardSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardSelector = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:336:2: (iv_ruleWildcardSelector= ruleWildcardSelector EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:337:2: iv_ruleWildcardSelector= ruleWildcardSelector EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getWildcardSelectorRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleWildcardSelector_in_entryRuleWildcardSelector572);
            iv_ruleWildcardSelector=ruleWildcardSelector();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardSelector; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcardSelector582); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:344:1: ruleWildcardSelector returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleWildcardSelector() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:349:6: ( ( () otherlv_1= '*' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:350:1: ( () otherlv_1= '*' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:350:1: ( () otherlv_1= '*' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:350:2: () otherlv_1= '*'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:350:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:351:2: 
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

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleWildcardSelector631); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:376:1: entryRuleFilter returns [EObject current=null] : iv_ruleFilter= ruleFilter EOF ;
    public final EObject entryRuleFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilter = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:377:2: (iv_ruleFilter= ruleFilter EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:378:2: iv_ruleFilter= ruleFilter EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFilterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFilter_in_entryRuleFilter667);
            iv_ruleFilter=ruleFilter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFilter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFilter677); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:385:1: ruleFilter returns [EObject current=null] : (otherlv_0= '[' ( (lv_condition_1_0= ruleXExpression ) ) otherlv_2= ']' ) ;
    public final EObject ruleFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:390:6: ( (otherlv_0= '[' ( (lv_condition_1_0= ruleXExpression ) ) otherlv_2= ']' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:391:1: (otherlv_0= '[' ( (lv_condition_1_0= ruleXExpression ) ) otherlv_2= ']' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:391:1: (otherlv_0= '[' ( (lv_condition_1_0= ruleXExpression ) ) otherlv_2= ']' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:391:3: otherlv_0= '[' ( (lv_condition_1_0= ruleXExpression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleFilter714); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getFilterAccess().getLeftSquareBracketKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:395:1: ( (lv_condition_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:396:1: (lv_condition_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:396:1: (lv_condition_1_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:397:3: lv_condition_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getFilterAccess().getConditionXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleFilter735);
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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleFilter747); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:431:1: entryRuleSetting returns [EObject current=null] : iv_ruleSetting= ruleSetting EOF ;
    public final EObject entryRuleSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetting = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:432:2: (iv_ruleSetting= ruleSetting EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:433:2: iv_ruleSetting= ruleSetting EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSettingRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSetting_in_entryRuleSetting783);
            iv_ruleSetting=ruleSetting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetting; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSetting793); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:440:1: ruleSetting returns [EObject current=null] : (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpSettingAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleSetting() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        EObject this_XOrExpression_0 = null;

        EObject lv_value_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:445:6: ( (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpSettingAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? otherlv_4= ';' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:446:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpSettingAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? otherlv_4= ';' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:446:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpSettingAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? otherlv_4= ';' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:447:2: this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpSettingAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? otherlv_4= ';'
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getSettingAccess().getXOrExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_ruleSetting843);
            this_XOrExpression_0=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOrExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:458:1: ( () ( ( ruleOpSettingAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:458:2: () ( ( ruleOpSettingAssign ) ) ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:458:2: ()
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:459:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getSettingAccess().getXAssignmentAssignableAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "assignable", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getSettingAccess().getXAssignmentAssignableAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:477:2: ( ( ruleOpSettingAssign ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:478:1: ( ruleOpSettingAssign )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:478:1: ( ruleOpSettingAssign )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:479:3: ruleOpSettingAssign
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
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSettingAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpSettingAssign_in_ruleSetting882);
                    ruleOpSettingAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:496:2: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:497:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:497:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:498:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSettingAccess().getValueXAssignmentParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleSetting903);
                    lv_value_3_0=ruleXAssignment();

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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleSetting917); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_4, grammarAccess.getSettingAccess().getSemicolonKeyword_2(), null);
                  
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


    // $ANTLR start "entryRuleOpSettingAssign"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:532:1: entryRuleOpSettingAssign returns [String current=null] : iv_ruleOpSettingAssign= ruleOpSettingAssign EOF ;
    public final String entryRuleOpSettingAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSettingAssign = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:533:2: (iv_ruleOpSettingAssign= ruleOpSettingAssign EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:534:2: iv_ruleOpSettingAssign= ruleOpSettingAssign EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpSettingAssignRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpSettingAssign_in_entryRuleOpSettingAssign954);
            iv_ruleOpSettingAssign=ruleOpSettingAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSettingAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSettingAssign965); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:541:1: ruleOpSettingAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= ':' ;
    public final AntlrDatatypeRuleToken ruleOpSettingAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:546:6: (kw= ':' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:548:2: kw= ':'
            {
            kw=(Token)match(input,17,FOLLOW_17_in_ruleOpSettingAssign1002); if (state.failed) return current;
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


    // $ANTLR start "entryRuleCssLiterals"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:563:1: entryRuleCssLiterals returns [EObject current=null] : iv_ruleCssLiterals= ruleCssLiterals EOF ;
    public final EObject entryRuleCssLiterals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCssLiterals = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:564:2: (iv_ruleCssLiterals= ruleCssLiterals EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:565:2: iv_ruleCssLiterals= ruleCssLiterals EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCssLiteralsRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCssLiterals_in_entryRuleCssLiterals1043);
            iv_ruleCssLiterals=ruleCssLiterals();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCssLiterals; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCssLiterals1053); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:572:1: ruleCssLiterals returns [EObject current=null] : (this_FontLiteral_0= ruleFontLiteral | this_ColorLiteral_1= ruleColorLiteral | this_SizeLiteral_2= ruleSizeLiteral ) ;
    public final EObject ruleCssLiterals() throws RecognitionException {
        EObject current = null;

        EObject this_FontLiteral_0 = null;

        EObject this_ColorLiteral_1 = null;

        EObject this_SizeLiteral_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:577:6: ( (this_FontLiteral_0= ruleFontLiteral | this_ColorLiteral_1= ruleColorLiteral | this_SizeLiteral_2= ruleSizeLiteral ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:578:1: (this_FontLiteral_0= ruleFontLiteral | this_ColorLiteral_1= ruleColorLiteral | this_SizeLiteral_2= ruleSizeLiteral )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:578:1: (this_FontLiteral_0= ruleFontLiteral | this_ColorLiteral_1= ruleColorLiteral | this_SizeLiteral_2= ruleSizeLiteral )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt7=1;
                }
                break;
            case 21:
                {
                alt7=2;
                }
                break;
            case RULE_INT:
                {
                alt7=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:579:2: this_FontLiteral_0= ruleFontLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getCssLiteralsAccess().getFontLiteralParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleFontLiteral_in_ruleCssLiterals1103);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:592:2: this_ColorLiteral_1= ruleColorLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getCssLiteralsAccess().getColorLiteralParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleColorLiteral_in_ruleCssLiterals1133);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:605:2: this_SizeLiteral_2= ruleSizeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getCssLiteralsAccess().getSizeLiteralParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleSizeLiteral_in_ruleCssLiterals1163);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:624:1: entryRuleFontLiteral returns [EObject current=null] : iv_ruleFontLiteral= ruleFontLiteral EOF ;
    public final EObject entryRuleFontLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFontLiteral = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getFontLiteralAccess().getUnorderedGroup_3()
        		);
        	
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:630:2: (iv_ruleFontLiteral= ruleFontLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:631:2: iv_ruleFontLiteral= ruleFontLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFontLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFontLiteral_in_entryRuleFontLiteral1204);
            iv_ruleFontLiteral=ruleFontLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFontLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFontLiteral1214); if (state.failed) return current;

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:641:1: ruleFontLiteral returns [EObject current=null] : ( () otherlv_1= 'font' ( (lv_name_2_0= ruleStringOrID ) )? ( ( ( ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleFontLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_italic_4_0=null;
        Token lv_bold_5_0=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_size_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getFontLiteralAccess().getUnorderedGroup_3()
        		);
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:649:6: ( ( () otherlv_1= 'font' ( (lv_name_2_0= ruleStringOrID ) )? ( ( ( ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )* ) ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:650:1: ( () otherlv_1= 'font' ( (lv_name_2_0= ruleStringOrID ) )? ( ( ( ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )* ) ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:650:1: ( () otherlv_1= 'font' ( (lv_name_2_0= ruleStringOrID ) )? ( ( ( ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )* ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:650:2: () otherlv_1= 'font' ( (lv_name_2_0= ruleStringOrID ) )? ( ( ( ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )* ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:650:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:651:2: 
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

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleFontLiteral1267); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getFontLiteralAccess().getFontKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:668:1: ( (lv_name_2_0= ruleStringOrID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_STRING) ) {
                int LA8_1 = input.LA(2);

                if ( (synpred9_InternalXcss()) ) {
                    alt8=1;
                }
            }
            else if ( (LA8_0==RULE_ID) ) {
                int LA8_2 = input.LA(2);

                if ( (synpred9_InternalXcss()) ) {
                    alt8=1;
                }
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:669:1: (lv_name_2_0= ruleStringOrID )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:669:1: (lv_name_2_0= ruleStringOrID )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:670:3: lv_name_2_0= ruleStringOrID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFontLiteralAccess().getNameStringOrIDParserRuleCall_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStringOrID_in_ruleFontLiteral1288);
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
                    break;

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:692:3: ( ( ( ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )* ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:694:1: ( ( ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:694:1: ( ( ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:695:2: ( ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3());
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:698:2: ( ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:699:3: ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )*
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:699:3: ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )*
            loop9:
            do {
                int alt9=4;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:701:4: ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:701:4: ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:702:5: {...}? => ( ( (lv_italic_4_0= 'I' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleFontLiteral", "getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:702:108: ( ( (lv_italic_4_0= 'I' ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:703:6: ( (lv_italic_4_0= 'I' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 0);
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:706:6: ( (lv_italic_4_0= 'I' ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:707:1: (lv_italic_4_0= 'I' )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:707:1: (lv_italic_4_0= 'I' )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:708:3: lv_italic_4_0= 'I'
            	    {
            	    lv_italic_4_0=(Token)match(input,19,FOLLOW_19_in_ruleFontLiteral1349); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_italic_4_0, grammarAccess.getFontLiteralAccess().getItalicIKeyword_3_0_0(), "italic");
            	          
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

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:734:4: ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:734:4: ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:5: {...}? => ( ( (lv_bold_5_0= 'B' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleFontLiteral", "getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:108: ( ( (lv_bold_5_0= 'B' ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:736:6: ( (lv_bold_5_0= 'B' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 1);
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:739:6: ( (lv_bold_5_0= 'B' ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:740:1: (lv_bold_5_0= 'B' )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:740:1: (lv_bold_5_0= 'B' )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:741:3: lv_bold_5_0= 'B'
            	    {
            	    lv_bold_5_0=(Token)match(input,20,FOLLOW_20_in_ruleFontLiteral1430); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_bold_5_0, grammarAccess.getFontLiteralAccess().getBoldBKeyword_3_1_0(), "bold");
            	          
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

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:767:4: ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:767:4: ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:768:5: {...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleFontLiteral", "getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:768:108: ( ( (lv_size_6_0= ruleSizeLiteral ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:769:6: ( (lv_size_6_0= ruleSizeLiteral ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 2);
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:772:6: ( (lv_size_6_0= ruleSizeLiteral ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:773:1: (lv_size_6_0= ruleSizeLiteral )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:773:1: (lv_size_6_0= ruleSizeLiteral )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:774:3: lv_size_6_0= ruleSizeLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getFontLiteralAccess().getSizeSizeLiteralParserRuleCall_3_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSizeLiteral_in_ruleFontLiteral1514);
            	    lv_size_6_0=ruleSizeLiteral();

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

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3());

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

            getUnorderedGroupHelper().leave(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3());

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:821:1: entryRuleStringOrID returns [String current=null] : iv_ruleStringOrID= ruleStringOrID EOF ;
    public final String entryRuleStringOrID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrID = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:822:2: (iv_ruleStringOrID= ruleStringOrID EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:823:2: iv_ruleStringOrID= ruleStringOrID EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStringOrIDRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStringOrID_in_entryRuleStringOrID1594);
            iv_ruleStringOrID=ruleStringOrID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringOrID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringOrID1605); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:830:1: ruleStringOrID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:835:6: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:836:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:836:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:836:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringOrID1645); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_STRING_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          createLeafNode(this_STRING_0, grammarAccess.getStringOrIDAccess().getSTRINGTerminalRuleCall_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:844:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStringOrID1671); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:859:1: entryRuleColorLiteral returns [EObject current=null] : iv_ruleColorLiteral= ruleColorLiteral EOF ;
    public final EObject entryRuleColorLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColorLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:860:2: (iv_ruleColorLiteral= ruleColorLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:861:2: iv_ruleColorLiteral= ruleColorLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getColorLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleColorLiteral_in_entryRuleColorLiteral1716);
            iv_ruleColorLiteral=ruleColorLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleColorLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleColorLiteral1726); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:868:1: ruleColorLiteral returns [EObject current=null] : (this_ColorConstant_0= ruleColorConstant | this_RGB_1= ruleRGB ) ;
    public final EObject ruleColorLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_ColorConstant_0 = null;

        EObject this_RGB_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:873:6: ( (this_ColorConstant_0= ruleColorConstant | this_RGB_1= ruleRGB ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:874:1: (this_ColorConstant_0= ruleColorConstant | this_RGB_1= ruleRGB )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:874:1: (this_ColorConstant_0= ruleColorConstant | this_RGB_1= ruleRGB )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==RULE_INT) ) {
                    alt11=2;
                }
                else if ( (LA11_1==RULE_ID) ) {
                    alt11=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:875:2: this_ColorConstant_0= ruleColorConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getColorConstantParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleColorConstant_in_ruleColorLiteral1776);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:888:2: this_RGB_1= ruleRGB
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getColorLiteralAccess().getRGBParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleRGB_in_ruleColorLiteral1806);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:907:1: entryRuleColorConstant returns [EObject current=null] : iv_ruleColorConstant= ruleColorConstant EOF ;
    public final EObject entryRuleColorConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColorConstant = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:908:2: (iv_ruleColorConstant= ruleColorConstant EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:909:2: iv_ruleColorConstant= ruleColorConstant EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getColorConstantRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleColorConstant_in_entryRuleColorConstant1841);
            iv_ruleColorConstant=ruleColorConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleColorConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleColorConstant1851); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:916:1: ruleColorConstant returns [EObject current=null] : (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleColorConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:921:6: ( (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:922:1: (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:922:1: (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:922:3: otherlv_0= '#' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleColorConstant1888); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getColorConstantAccess().getNumberSignKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:926:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:927:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:927:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:928:3: otherlv_1= RULE_ID
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
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleColorConstant1912); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:951:1: entryRuleRGB returns [EObject current=null] : iv_ruleRGB= ruleRGB EOF ;
    public final EObject entryRuleRGB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRGB = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:952:2: (iv_ruleRGB= ruleRGB EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:953:2: iv_ruleRGB= ruleRGB EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRGBRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRGB_in_entryRuleRGB1948);
            iv_ruleRGB=ruleRGB();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRGB; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRGB1958); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:960:1: ruleRGB returns [EObject current=null] : (otherlv_0= '#' ( (lv_color_1_0= ruleIntAsString ) ) ) ;
    public final EObject ruleRGB() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_color_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:965:6: ( (otherlv_0= '#' ( (lv_color_1_0= ruleIntAsString ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:966:1: (otherlv_0= '#' ( (lv_color_1_0= ruleIntAsString ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:966:1: (otherlv_0= '#' ( (lv_color_1_0= ruleIntAsString ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:966:3: otherlv_0= '#' ( (lv_color_1_0= ruleIntAsString ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleRGB1995); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getRGBAccess().getNumberSignKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:970:1: ( (lv_color_1_0= ruleIntAsString ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:971:1: (lv_color_1_0= ruleIntAsString )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:971:1: (lv_color_1_0= ruleIntAsString )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:972:3: lv_color_1_0= ruleIntAsString
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getRGBAccess().getColorIntAsStringParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleIntAsString_in_ruleRGB2016);
            lv_color_1_0=ruleIntAsString();

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
              	       			"color",
              	        		lv_color_1_0, 
              	        		"IntAsString", 
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
    // $ANTLR end "ruleRGB"


    // $ANTLR start "entryRuleIntAsString"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1002:1: entryRuleIntAsString returns [String current=null] : iv_ruleIntAsString= ruleIntAsString EOF ;
    public final String entryRuleIntAsString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIntAsString = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1003:2: (iv_ruleIntAsString= ruleIntAsString EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1004:2: iv_ruleIntAsString= ruleIntAsString EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIntAsStringRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIntAsString_in_entryRuleIntAsString2053);
            iv_ruleIntAsString=ruleIntAsString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntAsString.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntAsString2064); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntAsString"


    // $ANTLR start "ruleIntAsString"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1011:1: ruleIntAsString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleIntAsString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1016:6: (this_INT_0= RULE_INT )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1017:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntAsString2103); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  createLeafNode(this_INT_0, grammarAccess.getIntAsStringAccess().getINTTerminalRuleCall(), null); 
                  
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
    // $ANTLR end "ruleIntAsString"


    // $ANTLR start "entryRuleSizeLiteral"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1032:1: entryRuleSizeLiteral returns [EObject current=null] : iv_ruleSizeLiteral= ruleSizeLiteral EOF ;
    public final EObject entryRuleSizeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizeLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1033:2: (iv_ruleSizeLiteral= ruleSizeLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1034:2: iv_ruleSizeLiteral= ruleSizeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSizeLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSizeLiteral_in_entryRuleSizeLiteral2147);
            iv_ruleSizeLiteral=ruleSizeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSizeLiteral2157); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1041:1: ruleSizeLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleSizeUnit ) ) ) ;
    public final EObject ruleSizeLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Enumerator lv_unit_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1046:6: ( ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleSizeUnit ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1047:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleSizeUnit ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1047:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleSizeUnit ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1047:2: ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleSizeUnit ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1047:2: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1048:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1048:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1049:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSizeLiteral2199); if (state.failed) return current;
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1071:2: ( (lv_unit_1_0= ruleSizeUnit ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1072:1: (lv_unit_1_0= ruleSizeUnit )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1072:1: (lv_unit_1_0= ruleSizeUnit )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1073:3: lv_unit_1_0= ruleSizeUnit
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getSizeLiteralAccess().getUnitSizeUnitEnumRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleSizeUnit_in_ruleSizeLiteral2225);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1103:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1104:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1105:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXPrimaryExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression2261);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression2271); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1112:1: ruleXPrimaryExpression returns [EObject current=null] : (this_CssLiterals_0= ruleCssLiterals | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral | this_XConstructorCall_7= ruleXConstructorCall | this_XBlockExpression_8= ruleXBlockExpression | this_XSwitchExpression_9= ruleXSwitchExpression | this_XFeatureCall_10= ruleXFeatureCall | this_XIfExpression_11= ruleXIfExpression | this_XForLoopExpression_12= ruleXForLoopExpression | this_XWhileExpression_13= ruleXWhileExpression | this_XDoWhileExpression_14= ruleXDoWhileExpression | this_XCastedExpression_15= ruleXCastedExpression | this_XThrowExpression_16= ruleXThrowExpression | this_XTryCatchFinallyExpression_17= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_18= ruleXParenthesizedExpression ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1117:6: ( (this_CssLiterals_0= ruleCssLiterals | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral | this_XConstructorCall_7= ruleXConstructorCall | this_XBlockExpression_8= ruleXBlockExpression | this_XSwitchExpression_9= ruleXSwitchExpression | this_XFeatureCall_10= ruleXFeatureCall | this_XIfExpression_11= ruleXIfExpression | this_XForLoopExpression_12= ruleXForLoopExpression | this_XWhileExpression_13= ruleXWhileExpression | this_XDoWhileExpression_14= ruleXDoWhileExpression | this_XCastedExpression_15= ruleXCastedExpression | this_XThrowExpression_16= ruleXThrowExpression | this_XTryCatchFinallyExpression_17= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_18= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1118:1: (this_CssLiterals_0= ruleCssLiterals | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral | this_XConstructorCall_7= ruleXConstructorCall | this_XBlockExpression_8= ruleXBlockExpression | this_XSwitchExpression_9= ruleXSwitchExpression | this_XFeatureCall_10= ruleXFeatureCall | this_XIfExpression_11= ruleXIfExpression | this_XForLoopExpression_12= ruleXForLoopExpression | this_XWhileExpression_13= ruleXWhileExpression | this_XDoWhileExpression_14= ruleXDoWhileExpression | this_XCastedExpression_15= ruleXCastedExpression | this_XThrowExpression_16= ruleXThrowExpression | this_XTryCatchFinallyExpression_17= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_18= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1118:1: (this_CssLiterals_0= ruleCssLiterals | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral | this_XConstructorCall_7= ruleXConstructorCall | this_XBlockExpression_8= ruleXBlockExpression | this_XSwitchExpression_9= ruleXSwitchExpression | this_XFeatureCall_10= ruleXFeatureCall | this_XIfExpression_11= ruleXIfExpression | this_XForLoopExpression_12= ruleXForLoopExpression | this_XWhileExpression_13= ruleXWhileExpression | this_XDoWhileExpression_14= ruleXDoWhileExpression | this_XCastedExpression_15= ruleXCastedExpression | this_XThrowExpression_16= ruleXThrowExpression | this_XTryCatchFinallyExpression_17= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_18= ruleXParenthesizedExpression )
            int alt12=19;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1119:2: this_CssLiterals_0= ruleCssLiterals
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getCssLiteralsParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleCssLiterals_in_ruleXPrimaryExpression2321);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1132:2: this_XClosure_1= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXClosureParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXPrimaryExpression2351);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1145:2: this_XBooleanLiteral_2= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBooleanLiteralParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXPrimaryExpression2381);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1158:2: this_XIntLiteral_3= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIntLiteralParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXPrimaryExpression2411);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1171:2: this_XNullLiteral_4= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXNullLiteralParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXPrimaryExpression2441);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1184:2: this_XStringLiteral_5= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXStringLiteralParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXPrimaryExpression2471);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1197:2: this_XTypeLiteral_6= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTypeLiteralParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXPrimaryExpression2501);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1210:2: this_XConstructorCall_7= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_7(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression2531);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1223:2: this_XBlockExpression_8= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_8(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression2561);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1236:2: this_XSwitchExpression_9= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_9(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression2591);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1249:2: this_XFeatureCall_10= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_10(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression2621);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1262:2: this_XIfExpression_11= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_11(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression2651);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1275:2: this_XForLoopExpression_12= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_12(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression2681);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1288:2: this_XWhileExpression_13= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_13(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression2711);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1301:2: this_XDoWhileExpression_14= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_14(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression2741);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1314:2: this_XCastedExpression_15= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXCastedExpressionParserRuleCall_15(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXPrimaryExpression2771);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1327:2: this_XThrowExpression_16= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_16(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression2801);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1340:2: this_XTryCatchFinallyExpression_17= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_17(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression2831);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1353:2: this_XParenthesizedExpression_18= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_18(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression2861);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1372:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1373:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1374:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression2896);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression2906); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1381:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1386:6: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1388:2: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression2955);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1407:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1408:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1409:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAssignmentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment2989);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment2999); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1416:1: ruleXAssignment returns [EObject current=null] : (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_XOrExpression_0 = null;

        EObject lv_value_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1421:6: ( (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1422:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1422:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1423:2: this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment3049);
            this_XOrExpression_0=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOrExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1434:1: ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                int LA13_1 = input.LA(2);

                if ( (synpred33_InternalXcss()) ) {
                    alt13=1;
                }
            }
            else if ( (LA13_0==23) ) {
                int LA13_2 = input.LA(2);

                if ( (synpred33_InternalXcss()) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1434:2: () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1434:2: ()
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1435:2: 
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1453:2: ( ( ruleOpAssign ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1454:1: ( ruleOpAssign )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1454:1: ( ruleOpAssign )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1455:3: ruleOpAssign
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
                    pushFollow(FOLLOW_ruleOpAssign_in_ruleXAssignment3088);
                    ruleOpAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1472:2: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1473:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1473:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1474:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment3109);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1504:1: entryRuleOpAssign returns [String current=null] : iv_ruleOpAssign= ruleOpAssign EOF ;
    public final String entryRuleOpAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAssign = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1505:2: (iv_ruleOpAssign= ruleOpAssign EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1506:2: iv_ruleOpAssign= ruleOpAssign EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAssignRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAssign_in_entryRuleOpAssign3148);
            iv_ruleOpAssign=ruleOpAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAssign3159); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1513:1: ruleOpAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' ) ;
    public final AntlrDatatypeRuleToken ruleOpAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1518:6: ( (kw= '=' | kw= '+=' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1519:1: (kw= '=' | kw= '+=' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1519:1: (kw= '=' | kw= '+=' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            else if ( (LA14_0==23) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1520:2: kw= '='
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleOpAssign3197); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpAssignAccess().getEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1527:2: kw= '+='
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleOpAssign3216); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1540:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1541:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1542:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXOrExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression3256);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression3266); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1549:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1554:6: ( (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1555:1: (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1555:1: (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1556:2: this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression3316);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1567:1: ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred35_InternalXcss()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1567:2: () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1567:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1568:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1586:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1587:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1587:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1588:3: ruleOpOr
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
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression3355);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1605:2: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1606:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1606:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1607:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression3376);
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
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1637:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1638:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1639:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpOrRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr3415);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr3426); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1646:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1651:6: (kw= '||' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1653:2: kw= '||'
            {
            kw=(Token)match(input,24,FOLLOW_24_in_ruleOpOr3463); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1666:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1667:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1668:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAndExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression3502);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression3512); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1675:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1680:6: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1681:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1681:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1682:2: this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3562);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1693:1: ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==25) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred36_InternalXcss()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1693:2: () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1693:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1694:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1712:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1713:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1713:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1714:3: ruleOpAnd
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
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression3601);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1731:2: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1732:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1732:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1733:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3622);
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
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1763:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1764:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1765:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAndRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd3661);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd3672); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1772:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1777:6: (kw= '&&' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1779:2: kw= '&&'
            {
            kw=(Token)match(input,25,FOLLOW_25_in_ruleOpAnd3709); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1792:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1793:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1794:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXEqualityExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression3748);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression3758); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1801:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1806:6: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1807:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1807:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1808:2: this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3808);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1819:1: ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==26) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred37_InternalXcss()) ) {
                        alt17=1;
                    }


                }
                else if ( (LA17_0==27) ) {
                    int LA17_3 = input.LA(2);

                    if ( (synpred37_InternalXcss()) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1819:2: () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1819:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1820:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1838:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1839:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1839:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1840:3: ruleOpEquality
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
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression3847);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1857:2: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1858:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1858:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1859:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3868);
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
            	    break loop17;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1889:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1890:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1891:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpEqualityRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality3907);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality3918); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1898:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1903:6: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1904:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1904:1: (kw= '==' | kw= '!=' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            else if ( (LA18_0==27) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1905:2: kw= '=='
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleOpEquality3956); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1912:2: kw= '!='
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpEquality3975); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1925:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1926:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1927:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXRelationalExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression4015);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression4025); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1934:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_rightOperand_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1939:6: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1940:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1940:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1941:2: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4075);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1952:1: ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop19:
            do {
                int alt19=3;
                switch ( input.LA(1) ) {
                case 28:
                    {
                    int LA19_2 = input.LA(2);

                    if ( (synpred39_InternalXcss()) ) {
                        alt19=1;
                    }


                    }
                    break;
                case 29:
                    {
                    int LA19_3 = input.LA(2);

                    if ( (synpred40_InternalXcss()) ) {
                        alt19=2;
                    }


                    }
                    break;
                case 30:
                    {
                    int LA19_4 = input.LA(2);

                    if ( (synpred40_InternalXcss()) ) {
                        alt19=2;
                    }


                    }
                    break;
                case 31:
                    {
                    int LA19_5 = input.LA(2);

                    if ( (synpred40_InternalXcss()) ) {
                        alt19=2;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA19_6 = input.LA(2);

                    if ( (synpred40_InternalXcss()) ) {
                        alt19=2;
                    }


                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1952:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1952:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1952:3: () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1952:3: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1953:2: 
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

            	    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleXRelationalExpression4100); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_1(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1975:1: ( ( ruleQualifiedName ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1976:1: ( ruleQualifiedName )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1976:1: ( ruleQualifiedName )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1977:3: ruleQualifiedName
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
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression4127);
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
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1995:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1995:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1995:7: () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1995:7: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1996:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2014:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2015:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2015:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2016:3: ruleOpCompare
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
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression4174);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2033:2: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2034:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2034:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2035:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4195);
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
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2065:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2066:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2067:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpCompareRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare4235);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare4246); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2074:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2079:6: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2080:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2080:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt20=1;
                }
                break;
            case 30:
                {
                alt20=2;
                }
                break;
            case 31:
                {
                alt20=3;
                }
                break;
            case 32:
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2081:2: kw= '>='
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpCompare4284); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2088:2: kw= '<='
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpCompare4303); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2095:2: kw= '>'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpCompare4322); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2102:2: kw= '<'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpCompare4341); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2115:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2116:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2117:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXOtherOperatorExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression4381);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression4391); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2124:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2129:6: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2130:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2130:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2131:2: this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4441);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2142:1: ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==33) ) {
                    int LA21_2 = input.LA(2);

                    if ( (synpred44_InternalXcss()) ) {
                        alt21=1;
                    }


                }
                else if ( (LA21_0==34) ) {
                    int LA21_3 = input.LA(2);

                    if ( (synpred44_InternalXcss()) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2142:2: () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2142:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2143:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2161:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2162:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2162:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2163:3: ruleOpOther
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
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression4480);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2180:2: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2181:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2181:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2182:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4501);
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
            	    break loop21;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2212:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2213:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2214:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpOtherRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther4540);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther4551); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2221:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2226:6: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2227:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2227:1: (kw= '->' | kw= '..' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            else if ( (LA22_0==34) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2228:2: kw= '->'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpOther4589); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2235:2: kw= '..'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpOther4608); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2248:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2249:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2250:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAdditiveExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression4648);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression4658); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2257:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2262:6: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2263:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2263:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2264:2: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4708);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2275:1: ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==35) ) {
                    int LA23_2 = input.LA(2);

                    if ( (synpred46_InternalXcss()) ) {
                        alt23=1;
                    }


                }
                else if ( (LA23_0==36) ) {
                    int LA23_3 = input.LA(2);

                    if ( (synpred46_InternalXcss()) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2275:2: () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2275:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2276:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2294:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2295:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2295:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2296:3: ruleOpAdd
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
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression4747);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2313:2: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2314:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2314:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2315:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4768);
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
            	    break loop23;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2345:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2346:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2347:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAddRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd4807);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd4818); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2354:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2359:6: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2360:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2360:1: (kw= '+' | kw= '-' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            else if ( (LA24_0==36) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2361:2: kw= '+'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpAdd4856); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2368:2: kw= '-'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpAdd4875); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2381:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2382:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2383:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXMultiplicativeExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression4915);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression4925); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2390:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2395:6: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2396:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2396:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2397:2: this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression4975);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2408:1: ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop25:
            do {
                int alt25=2;
                switch ( input.LA(1) ) {
                case 13:
                    {
                    int LA25_2 = input.LA(2);

                    if ( (synpred48_InternalXcss()) ) {
                        alt25=1;
                    }


                    }
                    break;
                case 37:
                    {
                    int LA25_3 = input.LA(2);

                    if ( (synpred48_InternalXcss()) ) {
                        alt25=1;
                    }


                    }
                    break;
                case 38:
                    {
                    int LA25_4 = input.LA(2);

                    if ( (synpred48_InternalXcss()) ) {
                        alt25=1;
                    }


                    }
                    break;
                case 39:
                    {
                    int LA25_5 = input.LA(2);

                    if ( (synpred48_InternalXcss()) ) {
                        alt25=1;
                    }


                    }
                    break;

                }

                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2408:2: () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2408:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2409:2: 
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2427:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2428:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2428:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2429:3: ruleOpMulti
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
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression5014);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2446:2: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2447:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2447:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2448:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression5035);
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
            	    break loop25;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2478:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2479:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2480:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpMultiRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti5074);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti5085); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2487:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2492:6: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2493:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2493:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt26=1;
                }
                break;
            case 37:
                {
                alt26=2;
                }
                break;
            case 38:
                {
                alt26=3;
                }
                break;
            case 39:
                {
                alt26=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2494:2: kw= '*'
                    {
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleOpMulti5123); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2501:2: kw= '**'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpMulti5142); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2508:2: kw= '/'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpMulti5161); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2515:2: kw= '%'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleOpMulti5180); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2528:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2529:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2530:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXUnaryOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation5220);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation5230); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2537:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XMemberFeatureCall_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2542:6: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2543:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2543:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=35 && LA27_0<=36)||LA27_0==40) ) {
                alt27=1;
            }
            else if ( ((LA27_0>=RULE_STRING && LA27_0<=RULE_INT)||LA27_0==11||LA27_0==18||LA27_0==21||LA27_0==32||LA27_0==43||(LA27_0>=45 && LA27_0<=46)||LA27_0==48||(LA27_0>=51 && LA27_0<=53)||(LA27_0>=56 && LA27_0<=59)||(LA27_0>=61 && LA27_0<=62)||LA27_0==65) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2543:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2543:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2543:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2543:3: ()
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2544:2: 
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2557:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2558:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2558:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2559:3: ruleOpUnary
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
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation5295);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2576:2: ( (lv_operand_2_0= ruleXMemberFeatureCall ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2577:1: (lv_operand_2_0= ruleXMemberFeatureCall )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2577:1: (lv_operand_2_0= ruleXMemberFeatureCall )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2578:3: lv_operand_2_0= ruleXMemberFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXMemberFeatureCallParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation5316);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2602:2: this_XMemberFeatureCall_3= ruleXMemberFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getXMemberFeatureCallParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation5348);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2621:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2622:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2623:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpUnaryRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary5384);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary5395); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2630:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2635:6: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2636:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2636:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt28=1;
                }
                break;
            case 36:
                {
                alt28=2;
                }
                break;
            case 35:
                {
                alt28=3;
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2637:2: kw= '!'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleOpUnary5433); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2644:2: kw= '-'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpUnary5452); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2651:2: kw= '+'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpUnary5471); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2664:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2665:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2666:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXMemberFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall5511);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall5521); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2673:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2678:6: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2679:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2679:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2680:2: this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall5571);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2691:1: ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==41) ) {
                    int LA34_2 = input.LA(2);

                    if ( (synpred60_InternalXcss()) ) {
                        alt34=1;
                    }


                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2691:2: () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2691:2: ()
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2692:2: 
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

            	    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleXMemberFeatureCall5595); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2714:1: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==32) ) {
            	        alt30=1;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2714:3: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
            	            {
            	            otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleXMemberFeatureCall5608); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_3, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_2_0(), null);
            	                  
            	            }
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2718:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2719:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2719:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2720:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), currentNode); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall5629);
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

            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2742:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop29:
            	            do {
            	                int alt29=2;
            	                int LA29_0 = input.LA(1);

            	                if ( (LA29_0==42) ) {
            	                    alt29=1;
            	                }


            	                switch (alt29) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2742:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_5=(Token)match(input,42,FOLLOW_42_in_ruleXMemberFeatureCall5642); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	createLeafNode(otherlv_5, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_2_2_0(), null);
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2746:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2747:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2747:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2748:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_2_1_0(), currentNode); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall5663);
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
            	            	    break loop29;
            	                }
            	            } while (true);

            	            otherlv_7=(Token)match(input,31,FOLLOW_31_in_ruleXMemberFeatureCall5677); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_2_3(), null);
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2774:3: ( (otherlv_8= RULE_ID ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2775:1: (otherlv_8= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2775:1: (otherlv_8= RULE_ID )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2776:3: otherlv_8= RULE_ID
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
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXMemberFeatureCall5703); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		createLeafNode(otherlv_8, grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_1_3_0(), "feature"); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2791:2: ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
            	    int alt33=2;
            	    alt33 = dfa33.predict(input);
            	    switch (alt33) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2791:3: ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')'
            	            {
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2791:3: ( (lv_explicitOperationCall_9_0= '(' ) )
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2792:1: (lv_explicitOperationCall_9_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2792:1: (lv_explicitOperationCall_9_0= '(' )
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2793:3: lv_explicitOperationCall_9_0= '('
            	            {
            	            lv_explicitOperationCall_9_0=(Token)match(input,43,FOLLOW_43_in_ruleXMemberFeatureCall5722); if (state.failed) return current;
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

            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2812:2: ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )?
            	            int alt32=2;
            	            int LA32_0 = input.LA(1);

            	            if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_INT)||LA32_0==11||LA32_0==18||LA32_0==21||LA32_0==32||(LA32_0>=35 && LA32_0<=36)||LA32_0==40||LA32_0==43||(LA32_0>=45 && LA32_0<=46)||LA32_0==48||(LA32_0>=51 && LA32_0<=53)||(LA32_0>=56 && LA32_0<=59)||(LA32_0>=61 && LA32_0<=62)||LA32_0==65) ) {
            	                alt32=1;
            	            }
            	            switch (alt32) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2812:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2812:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2813:1: (lv_memberCallArguments_10_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2813:1: (lv_memberCallArguments_10_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2814:3: lv_memberCallArguments_10_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_0_0(), currentNode); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5757);
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

            	                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2836:2: (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
            	                    loop31:
            	                    do {
            	                        int alt31=2;
            	                        int LA31_0 = input.LA(1);

            	                        if ( (LA31_0==42) ) {
            	                            alt31=1;
            	                        }


            	                        switch (alt31) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2836:4: otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_11=(Token)match(input,42,FOLLOW_42_in_ruleXMemberFeatureCall5770); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	createLeafNode(otherlv_11, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_4_1_1_0(), null);
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2840:1: ( (lv_memberCallArguments_12_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2841:1: (lv_memberCallArguments_12_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2841:1: (lv_memberCallArguments_12_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2842:3: lv_memberCallArguments_12_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_1_1_0(), currentNode); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5791);
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
            	                    	    break loop31;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            otherlv_13=(Token)match(input,44,FOLLOW_44_in_ruleXMemberFeatureCall5807); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_13, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_4_2(), null);
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2876:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2877:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2878:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXClosureRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure5847);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure5857); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2885:1: ruleXClosure returns [EObject current=null] : ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_formalParameters_1_0 = null;

        EObject lv_formalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2890:6: ( ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2891:1: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2891:1: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2891:2: () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2891:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2892:2: 
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2905:2: ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID||LA36_0==43||LA36_0==65) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2905:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2905:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2906:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2906:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2907:3: lv_formalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_1_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5916);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2929:2: (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==42) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2929:4: otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleXClosure5929); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_2, grammarAccess.getXClosureAccess().getCommaKeyword_1_1_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2933:1: ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2934:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2934:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2935:3: lv_formalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_1_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5950);
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
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,45,FOLLOW_45_in_ruleXClosure5966); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_4, grammarAccess.getXClosureAccess().getVerticalLineKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2961:1: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2962:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2962:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2963:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXClosure5987);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2993:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2994:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2995:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCastedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression6023);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression6033); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3002:1: ruleXCastedExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_type_1_0 = null;

        EObject lv_target_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3007:6: ( (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3008:1: (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3008:1: (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3008:3: otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleXCastedExpression6070); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXCastedExpressionAccess().getLeftParenthesisKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3012:1: ( (lv_type_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3013:1: (lv_type_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3013:1: (lv_type_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3014:3: lv_type_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression6091);
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

            otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXCastedExpression6103); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getRightParenthesisKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3040:1: ( (lv_target_3_0= ruleXMemberFeatureCall ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3041:1: (lv_target_3_0= ruleXMemberFeatureCall )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3041:1: (lv_target_3_0= ruleXMemberFeatureCall )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3042:3: lv_target_3_0= ruleXMemberFeatureCall
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCastedExpressionAccess().getTargetXMemberFeatureCallParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression6124);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3072:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3073:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3074:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXParenthesizedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6160);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression6170); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3081:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3086:6: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3087:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3087:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3087:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleXParenthesizedExpression6207); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null);
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6232);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      currentNode = currentNode.getParent();
                  
            }
            otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXParenthesizedExpression6243); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3115:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3116:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3117:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXIfExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6279);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression6289); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3124:1: ruleXIfExpression returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3129:6: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3130:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3130:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3130:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )?
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleXIfExpression6326); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXIfExpressionAccess().getIfKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleXIfExpression6338); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3138:1: ( (lv_if_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3139:1: (lv_if_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3139:1: (lv_if_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3140:3: lv_if_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6359);
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

            otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleXIfExpression6371); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3166:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3167:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3167:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3168:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6392);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3190:2: (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==47) ) {
                int LA37_1 = input.LA(2);

                if ( (synpred63_InternalXcss()) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3190:4: otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) )
                    {
                    otherlv_5=(Token)match(input,47,FOLLOW_47_in_ruleXIfExpression6405); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXIfExpressionAccess().getElseKeyword_5_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3194:1: ( (lv_else_6_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3195:1: (lv_else_6_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3195:1: (lv_else_6_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3196:3: lv_else_6_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6426);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3226:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3227:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3228:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXSwitchExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6464);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression6474); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3235:1: ruleXSwitchExpression returns [EObject current=null] : (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3240:6: ( (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3241:1: (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3241:1: (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3241:3: otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleXSwitchExpression6511); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3245:1: ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )?
            int alt38=2;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3246:1: (lv_switch_1_0= ruleXExpressionInsideBlock )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3246:1: (lv_switch_1_0= ruleXExpressionInsideBlock )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3247:3: lv_switch_1_0= ruleXExpressionInsideBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionInsideBlockParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXSwitchExpression6532);
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

            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleXSwitchExpression6545); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3273:1: ( (lv_cases_3_0= ruleXCasePart ) )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID||LA39_0==17||LA39_0==43||LA39_0==50||LA39_0==65) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3274:1: (lv_cases_3_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3274:1: (lv_cases_3_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3275:3: lv_cases_3_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_3_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6566);
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
            	    if ( cnt39 >= 1 ) break loop39;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
            } while (true);

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3297:3: (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==49) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3297:5: otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )
                    {
                    otherlv_4=(Token)match(input,49,FOLLOW_49_in_ruleXSwitchExpression6580); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_4_0(), null);
                          
                    }
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleXSwitchExpression6592); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_4_1(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3305:1: ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )
                    int alt40=2;
                    alt40 = dfa40.predict(input);
                    switch (alt40) {
                        case 1 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3305:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3305:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3305:3: ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';'
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3305:3: ( (lv_default_6_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3306:1: (lv_default_6_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3306:1: (lv_default_6_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3307:3: lv_default_6_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_4_2_0_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6615);
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

                            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleXSwitchExpression6627); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	createLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getSemicolonKeyword_4_2_0_1(), null);
                                  
                            }

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3334:6: ( (lv_default_8_0= ruleXBlockExpression ) )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3334:6: ( (lv_default_8_0= ruleXBlockExpression ) )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3335:1: (lv_default_8_0= ruleXBlockExpression )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3335:1: (lv_default_8_0= ruleXBlockExpression )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3336:3: lv_default_8_0= ruleXBlockExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXBlockExpressionParserRuleCall_4_2_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXSwitchExpression6655);
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

            otherlv_9=(Token)match(input,12,FOLLOW_12_in_ruleXSwitchExpression6670); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3370:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3371:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3372:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCasePartRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6706);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6716); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3379:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3384:6: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3385:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3385:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3385:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3385:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID||LA42_0==43||LA42_0==65) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3386:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3386:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3387:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6762);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3409:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==50) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3409:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleXCasePart6776); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3413:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3414:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3414:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3415:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6797);
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleXCasePart6811); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3441:1: ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )
            int alt44=2;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3441:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3441:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3441:3: ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';'
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3441:3: ( (lv_then_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3442:1: (lv_then_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3442:1: (lv_then_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3443:3: lv_then_4_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6834);
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

                    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleXCasePart6846); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXCasePartAccess().getSemicolonKeyword_3_0_1(), null);
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3470:6: ( (lv_then_6_0= ruleXBlockExpression ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3470:6: ( (lv_then_6_0= ruleXBlockExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3471:1: (lv_then_6_0= ruleXBlockExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3471:1: (lv_then_6_0= ruleXBlockExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3472:3: lv_then_6_0= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXBlockExpressionParserRuleCall_3_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXCasePart6874);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3502:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3503:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3504:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXForLoopExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6911);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression6921); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3511:1: ruleXForLoopExpression returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3516:6: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3517:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3517:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3517:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleXForLoopExpression6958); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXForLoopExpressionAccess().getForKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleXForLoopExpression6970); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3525:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3526:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3526:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3527:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6991);
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleXForLoopExpression7003); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3553:1: ( (lv_forExpression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3554:1: (lv_forExpression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3554:1: (lv_forExpression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3555:3: lv_forExpression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression7024);
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

            otherlv_5=(Token)match(input,44,FOLLOW_44_in_ruleXForLoopExpression7036); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_5, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_5(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3581:1: ( (lv_eachExpression_6_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3582:1: (lv_eachExpression_6_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3582:1: (lv_eachExpression_6_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3583:3: lv_eachExpression_6_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_6_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression7057);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3613:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3614:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3615:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression7093);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression7103); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3622:1: ruleXWhileExpression returns [EObject current=null] : (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_predicate_2_0 = null;

        EObject lv_body_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3627:6: ( (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3628:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3628:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3628:3: otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleXWhileExpression7140); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleXWhileExpression7152); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3636:1: ( (lv_predicate_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3637:1: (lv_predicate_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3637:1: (lv_predicate_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3638:3: lv_predicate_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7173);
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

            otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleXWhileExpression7185); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3664:1: ( (lv_body_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3665:1: (lv_body_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3665:1: (lv_body_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3666:3: lv_body_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7206);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3696:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3697:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3698:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXDoWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7242);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression7252); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3705:1: ruleXDoWhileExpression returns [EObject current=null] : (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3710:6: ( (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3711:1: (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3711:1: (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3711:3: otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_53_in_ruleXDoWhileExpression7289); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3715:1: ( (lv_body_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3716:1: (lv_body_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3716:1: (lv_body_1_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3717:3: lv_body_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7310);
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

            otherlv_2=(Token)match(input,52,FOLLOW_52_in_ruleXDoWhileExpression7322); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_2(), null);
                  
            }
            otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleXDoWhileExpression7334); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3747:1: ( (lv_predicate_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3748:1: (lv_predicate_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3748:1: (lv_predicate_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3749:3: lv_predicate_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7355);
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

            otherlv_5=(Token)match(input,44,FOLLOW_44_in_ruleXDoWhileExpression7367); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3783:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3784:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3785:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXBlockExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7403);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression7413); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3792:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3797:6: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3798:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3798:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3798:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3798:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3799:2: 
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

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleXBlockExpression7462); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3816:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=RULE_STRING && LA46_0<=RULE_INT)||LA46_0==11||LA46_0==18||LA46_0==21||LA46_0==32||(LA46_0>=35 && LA46_0<=36)||LA46_0==40||LA46_0==43||(LA46_0>=45 && LA46_0<=46)||LA46_0==48||(LA46_0>=51 && LA46_0<=59)||(LA46_0>=61 && LA46_0<=62)||LA46_0==65) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3816:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3816:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3817:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3817:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3818:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7484);
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

            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3840:2: (otherlv_3= ';' )?
            	    int alt45=2;
            	    int LA45_0 = input.LA(1);

            	    if ( (LA45_0==16) ) {
            	        alt45=1;
            	    }
            	    switch (alt45) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3840:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleXBlockExpression7497); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1(), null);
            	                  
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

            otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleXBlockExpression7513); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3856:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3857:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3858:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXExpressionInsideBlockRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7549);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7559); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3865:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3870:6: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3871:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3871:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=54 && LA47_0<=55)) ) {
                alt47=1;
            }
            else if ( ((LA47_0>=RULE_STRING && LA47_0<=RULE_INT)||LA47_0==11||LA47_0==18||LA47_0==21||LA47_0==32||(LA47_0>=35 && LA47_0<=36)||LA47_0==40||LA47_0==43||(LA47_0>=45 && LA47_0<=46)||LA47_0==48||(LA47_0>=51 && LA47_0<=53)||(LA47_0>=56 && LA47_0<=59)||(LA47_0>=61 && LA47_0<=62)||LA47_0==65) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3872:2: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7609);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3885:2: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7639);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3904:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3905:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3906:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXVariableDeclarationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7674);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7684); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3913:1: ruleXVariableDeclaration returns [EObject current=null] : ( ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3918:6: ( ( ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3919:1: ( ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3919:1: ( ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3919:2: ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3919:2: ( ( (lv_writeable_0_0= 'var' ) ) | otherlv_1= 'val' )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==54) ) {
                alt48=1;
            }
            else if ( (LA48_0==55) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3919:3: ( (lv_writeable_0_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3919:3: ( (lv_writeable_0_0= 'var' ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3920:1: (lv_writeable_0_0= 'var' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3920:1: (lv_writeable_0_0= 'var' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3921:3: lv_writeable_0_0= 'var'
                    {
                    lv_writeable_0_0=(Token)match(input,54,FOLLOW_54_in_ruleXVariableDeclaration7728); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3941:7: otherlv_1= 'val'
                    {
                    otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleXVariableDeclaration7759); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getXVariableDeclarationAccess().getValKeyword_0_1(), null);
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3945:2: ( (lv_type_2_0= ruleJvmTypeReference ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==RULE_ID||LA49_1==32||LA49_1==41) ) {
                    alt49=1;
                }
            }
            else if ( (LA49_0==43||LA49_0==65) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3946:1: (lv_type_2_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3946:1: (lv_type_2_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3947:3: lv_type_2_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7781);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3969:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3970:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3970:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3971:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXVariableDeclaration7799); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleXVariableDeclaration7816); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_4, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3997:1: ( (lv_right_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3998:1: (lv_right_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3998:1: (lv_right_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3999:3: lv_right_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7837);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4029:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4030:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4031:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmFormalParameterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7873);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter7883); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4038:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_parameterType_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4043:6: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4044:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4044:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4044:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4044:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==RULE_ID||LA50_1==32||LA50_1==41) ) {
                    alt50=1;
                }
            }
            else if ( (LA50_0==43||LA50_0==65) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4045:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4045:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4046:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7929);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4068:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4069:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4069:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4070:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJvmFormalParameter7947); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4100:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4101:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4102:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7988);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall7998); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4109:1: ruleXFeatureCall returns [EObject current=null] : ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4114:6: ( ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4115:1: ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4115:1: ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4115:2: (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4115:2: (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==32) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4115:4: otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )* otherlv_4= '>'
                    {
                    otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleXFeatureCall8036); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_0, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4119:1: ( (lv_typeArguments_1_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4120:1: (lv_typeArguments_1_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4120:1: (lv_typeArguments_1_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4121:3: lv_typeArguments_1_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8057);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4143:2: (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==42) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4143:4: otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleXFeatureCall8070); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getCommaKeyword_0_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4147:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4148:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4148:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4149:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8091);
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
                    	    break loop51;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleXFeatureCall8105); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_0_3(), null);
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4175:3: ( (otherlv_5= RULE_ID ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4176:1: (otherlv_5= RULE_ID )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4176:1: (otherlv_5= RULE_ID )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4177:3: otherlv_5= RULE_ID
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
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXFeatureCall8131); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		createLeafNode(otherlv_5, grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_1_0(), "feature"); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4192:2: ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )?
            int alt55=2;
            alt55 = dfa55.predict(input);
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4192:3: ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')'
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4192:3: ( (lv_explicitOperationCall_6_0= '(' ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4193:1: (lv_explicitOperationCall_6_0= '(' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4193:1: (lv_explicitOperationCall_6_0= '(' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4194:3: lv_explicitOperationCall_6_0= '('
                    {
                    lv_explicitOperationCall_6_0=(Token)match(input,43,FOLLOW_43_in_ruleXFeatureCall8150); if (state.failed) return current;
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4213:2: ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( ((LA54_0>=RULE_STRING && LA54_0<=RULE_INT)||LA54_0==11||LA54_0==18||LA54_0==21||LA54_0==32||(LA54_0>=35 && LA54_0<=36)||LA54_0==40||LA54_0==43||(LA54_0>=45 && LA54_0<=46)||LA54_0==48||(LA54_0>=51 && LA54_0<=53)||(LA54_0>=56 && LA54_0<=59)||(LA54_0>=61 && LA54_0<=62)||LA54_0==65) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4213:3: ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4213:3: ( (lv_featureCallArguments_7_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4214:1: (lv_featureCallArguments_7_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4214:1: (lv_featureCallArguments_7_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4215:3: lv_featureCallArguments_7_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8185);
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

                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4237:2: (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                            loop53:
                            do {
                                int alt53=2;
                                int LA53_0 = input.LA(1);

                                if ( (LA53_0==42) ) {
                                    alt53=1;
                                }


                                switch (alt53) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4237:4: otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            	    {
                            	    otherlv_8=(Token)match(input,42,FOLLOW_42_in_ruleXFeatureCall8198); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	createLeafNode(otherlv_8, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_1_1_0(), null);
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4241:1: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4242:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4242:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4243:3: lv_featureCallArguments_9_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8219);
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
                            	    break loop53;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,44,FOLLOW_44_in_ruleXFeatureCall8235); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4277:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4278:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4279:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXConstructorCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8273);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall8283); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4286:1: ruleXConstructorCall returns [EObject current=null] : (otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')' ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4291:6: ( (otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4292:1: (otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4292:1: (otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4292:3: otherlv_0= 'new' ( ( ruleQualifiedName ) ) (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? otherlv_7= '(' ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )? otherlv_11= ')'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleXConstructorCall8320); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXConstructorCallAccess().getNewKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4296:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4297:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4297:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4298:3: ruleQualifiedName
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
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8347);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4315:2: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==32) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4315:4: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleXConstructorCall8360); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_2, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_2_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4319:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4320:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4320:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4321:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8381);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4343:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==42) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4343:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,42,FOLLOW_42_in_ruleXConstructorCall8394); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_4, grammarAccess.getXConstructorCallAccess().getCommaKeyword_2_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4347:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4348:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4348:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4349:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8415);
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
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,31,FOLLOW_31_in_ruleXConstructorCall8429); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_6, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_2_3(), null);
                          
                    }

                    }
                    break;

            }

            otherlv_7=(Token)match(input,43,FOLLOW_43_in_ruleXConstructorCall8443); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4379:1: ( ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=RULE_STRING && LA59_0<=RULE_INT)||LA59_0==11||LA59_0==18||LA59_0==21||LA59_0==32||(LA59_0>=35 && LA59_0<=36)||LA59_0==40||LA59_0==43||(LA59_0>=45 && LA59_0<=46)||LA59_0==48||(LA59_0>=51 && LA59_0<=53)||(LA59_0>=56 && LA59_0<=59)||(LA59_0>=61 && LA59_0<=62)||LA59_0==65) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4379:2: ( (lv_arguments_8_0= ruleXExpression ) ) (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4379:2: ( (lv_arguments_8_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4380:1: (lv_arguments_8_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4380:1: (lv_arguments_8_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4381:3: lv_arguments_8_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8465);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4403:2: (otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==42) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4403:4: otherlv_9= ',' ( (lv_arguments_10_0= ruleXExpression ) )
                    	    {
                    	    otherlv_9=(Token)match(input,42,FOLLOW_42_in_ruleXConstructorCall8478); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_9, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4407:1: ( (lv_arguments_10_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4408:1: (lv_arguments_10_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4408:1: (lv_arguments_10_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4409:3: lv_arguments_10_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8499);
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
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,44,FOLLOW_44_in_ruleXConstructorCall8515); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4443:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4444:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4445:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXBooleanLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8551);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral8561); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4452:1: ruleXBooleanLiteral returns [EObject current=null] : ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4457:6: ( ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4458:1: ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4458:1: ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==57) ) {
                alt60=1;
            }
            else if ( (LA60_0==58) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4458:2: ( () otherlv_1= 'false' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4458:2: ( () otherlv_1= 'false' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4458:3: () otherlv_1= 'false'
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4458:3: ()
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4459:2: 
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

                    otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleXBooleanLiteral8611); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_0_1(), null);
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4477:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4477:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4478:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4478:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4479:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,58,FOLLOW_58_in_ruleXBooleanLiteral8636); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4506:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4507:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4508:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXNullLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8685);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral8695); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4515:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4520:6: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4521:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4521:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4521:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4521:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4522:2: 
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

            otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleXNullLiteral8744); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4547:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4548:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4549:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXIntLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral8780);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral8790); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4556:1: ruleXIntLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4561:6: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4562:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4562:1: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4563:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4563:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4564:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral8831); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4594:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4595:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4596:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral8871);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral8881); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4603:1: ruleXStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4608:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4609:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4609:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4610:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4610:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4611:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral8922); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4641:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4642:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4643:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXTypeLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral8962);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral8972); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4650:1: ruleXTypeLiteral returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4655:6: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4656:1: ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4656:1: ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4656:2: ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class'
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4656:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4657:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4657:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4658:3: ruleQualifiedName
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
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9024);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleXTypeLiteral9036); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getFullStopKeyword_1(), null);
                  
            }
            otherlv_2=(Token)match(input,60,FOLLOW_60_in_ruleXTypeLiteral9048); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4691:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4692:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4693:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXThrowExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9084);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression9094); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4700:1: ruleXThrowExpression returns [EObject current=null] : (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4705:6: ( (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4706:1: (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4706:1: (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4706:3: otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_61_in_ruleXThrowExpression9131); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4710:1: ( (lv_expression_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4711:1: (lv_expression_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4711:1: (lv_expression_1_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4712:3: lv_expression_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression9152);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4742:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4743:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4744:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9188);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9198); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4751:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4756:6: ( (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4757:1: (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4757:1: (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4757:3: otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) )
            {
            otherlv_0=(Token)match(input,62,FOLLOW_62_in_ruleXTryCatchFinallyExpression9235); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4761:1: ( (lv_expression_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4762:1: (lv_expression_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4762:1: (lv_expression_1_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4763:3: lv_expression_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9256);
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

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4785:2: ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==64) ) {
                alt63=1;
            }
            else if ( (LA63_0==63) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4785:3: ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4785:3: ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4785:4: ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4785:4: ( (lv_catchClauses_2_0= ruleXCatchClause ) )+
                    int cnt61=0;
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==64) ) {
                            int LA61_2 = input.LA(2);

                            if ( (synpred87_InternalXcss()) ) {
                                alt61=1;
                            }


                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4786:1: (lv_catchClauses_2_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4786:1: (lv_catchClauses_2_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4787:3: lv_catchClauses_2_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0_0_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9279);
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
                    	    if ( cnt61 >= 1 ) break loop61;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(61, input);
                                throw eee;
                        }
                        cnt61++;
                    } while (true);

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4809:3: (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==63) ) {
                        int LA62_1 = input.LA(2);

                        if ( (synpred88_InternalXcss()) ) {
                            alt62=1;
                        }
                    }
                    switch (alt62) {
                        case 1 :
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4809:5: otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) )
                            {
                            otherlv_3=(Token)match(input,63,FOLLOW_63_in_ruleXTryCatchFinallyExpression9293); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	createLeafNode(otherlv_3, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_0_1_0(), null);
                                  
                            }
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4813:1: ( (lv_finallyExpression_4_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4814:1: (lv_finallyExpression_4_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4814:1: (lv_finallyExpression_4_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4815:3: lv_finallyExpression_4_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_1_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9314);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4838:6: (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4838:6: (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4838:8: otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) )
                    {
                    otherlv_5=(Token)match(input,63,FOLLOW_63_in_ruleXTryCatchFinallyExpression9336); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4842:1: ( (lv_finallyExpression_6_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4843:1: (lv_finallyExpression_6_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4843:1: (lv_finallyExpression_6_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4844:3: lv_finallyExpression_6_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9357);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4874:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4875:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4876:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCatchClauseRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9395);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause9405); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4883:1: ruleXCatchClause returns [EObject current=null] : (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4888:6: ( (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4889:1: (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4889:1: (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4889:3: otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,64,FOLLOW_64_in_ruleXCatchClause9442); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleXCatchClause9454); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4897:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4898:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4898:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4899:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause9475);
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

            otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleXCatchClause9487); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4925:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4926:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4926:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4927:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause9508);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4957:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4958:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4959:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference9544);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference9554); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4966:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4971:6: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4972:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4972:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID) ) {
                alt64=1;
            }
            else if ( (LA64_0==43||LA64_0==65) ) {
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4973:2: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference9604);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4986:2: this_XFunctionTypeRef_1= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference9634);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5005:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5006:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5007:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXFunctionTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef9669);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef9679); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5014:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
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
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5019:6: ( ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5020:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5020:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5020:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5020:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==43) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5020:4: otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleXFunctionTypeRef9717); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5024:1: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5025:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5025:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5026:3: lv_paramTypes_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9738);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5048:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==42) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5048:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleXFunctionTypeRef9751); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5052:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5053:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5053:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5054:3: lv_paramTypes_3_0= ruleJvmTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9772);
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
                    	    break loop65;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,44,FOLLOW_44_in_ruleXFunctionTypeRef9786); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_3(), null);
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,65,FOLLOW_65_in_ruleXFunctionTypeRef9800); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5084:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5085:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5085:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5086:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9821);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5116:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5117:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5118:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference9857);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference9867); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5125:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5130:6: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5131:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5131:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5131:2: ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5131:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5132:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5132:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5133:3: ruleQualifiedName
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
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference9919);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5150:2: (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==32) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5150:4: otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleJvmParameterizedTypeReference9932); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5154:1: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5155:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5155:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5156:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference9953);
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

                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5178:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==42) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5178:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleJvmParameterizedTypeReference9966); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5182:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5183:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5183:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5184:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference9987);
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
                    	    break loop67;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleJvmParameterizedTypeReference10001); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5218:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5219:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5220:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference10039);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference10049); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5227:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5232:6: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5233:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5233:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_ID||LA69_0==43||LA69_0==65) ) {
                alt69=1;
            }
            else if ( (LA69_0==66) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5234:2: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference10099);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5247:2: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference10129);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5266:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5267:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5268:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference10164);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference10174); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5275:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5280:6: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5281:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5281:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5281:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5281:2: ()
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5282:2: 
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

            otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleJvmWildcardTypeReference10223); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5299:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt70=3;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==67) ) {
                alt70=1;
            }
            else if ( (LA70_0==69) ) {
                alt70=2;
            }
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5299:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5299:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5300:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5300:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5301:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference10245);
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
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5324:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5324:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5325:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5325:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5326:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference10272);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5356:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5357:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5358:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmUpperBoundRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound10310);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound10320); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5365:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5370:6: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5371:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5371:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5371:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_67_in_ruleJvmUpperBound10357); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5375:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5376:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5376:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5377:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound10378);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5407:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5408:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5409:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmUpperBoundAndedRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded10414);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded10424); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5416:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5421:6: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5422:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5422:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5422:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_68_in_ruleJvmUpperBoundAnded10461); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5426:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5427:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5427:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5428:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded10482);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5458:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5459:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5460:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmLowerBoundRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound10518);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound10528); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5467:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5472:6: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5473:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5473:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5473:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,69,FOLLOW_69_in_ruleJvmLowerBound10565); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5477:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5478:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5478:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5479:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound10586);
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5511:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5512:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5513:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10625);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10636); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5520:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5525:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5526:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5526:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5526:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName10676); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  createLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5533:1: (kw= '.' this_ID_2= RULE_ID )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==41) ) {
                    int LA71_2 = input.LA(2);

                    if ( (LA71_2==RULE_ID) ) {
                        int LA71_3 = input.LA(3);

                        if ( (synpred98_InternalXcss()) ) {
                            alt71=1;
                        }


                    }


                }


                switch (alt71) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5534:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,41,FOLLOW_41_in_ruleQualifiedName10695); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName10710); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          createLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	          
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
    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5554:1: ruleSizeUnit returns [Enumerator current=null] : ( (enumLiteral_0= 'em' ) | (enumLiteral_1= 'pt' ) | (enumLiteral_2= 'px' ) | (enumLiteral_3= '%' ) ) ;
    public final Enumerator ruleSizeUnit() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5558:6: ( ( (enumLiteral_0= 'em' ) | (enumLiteral_1= 'pt' ) | (enumLiteral_2= 'px' ) | (enumLiteral_3= '%' ) ) )
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5559:1: ( (enumLiteral_0= 'em' ) | (enumLiteral_1= 'pt' ) | (enumLiteral_2= 'px' ) | (enumLiteral_3= '%' ) )
            {
            // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5559:1: ( (enumLiteral_0= 'em' ) | (enumLiteral_1= 'pt' ) | (enumLiteral_2= 'px' ) | (enumLiteral_3= '%' ) )
            int alt72=4;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt72=1;
                }
                break;
            case 71:
                {
                alt72=2;
                }
                break;
            case 72:
                {
                alt72=3;
                }
                break;
            case 39:
                {
                alt72=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5559:2: (enumLiteral_0= 'em' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5559:2: (enumLiteral_0= 'em' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5559:4: enumLiteral_0= 'em'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_70_in_ruleSizeUnit10771); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSizeUnitAccess().getEmEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(enumLiteral_0, grammarAccess.getSizeUnitAccess().getEmEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5565:6: (enumLiteral_1= 'pt' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5565:6: (enumLiteral_1= 'pt' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5565:8: enumLiteral_1= 'pt'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_71_in_ruleSizeUnit10788); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSizeUnitAccess().getPtEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(enumLiteral_1, grammarAccess.getSizeUnitAccess().getPtEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5571:6: (enumLiteral_2= 'px' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5571:6: (enumLiteral_2= 'px' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5571:8: enumLiteral_2= 'px'
                    {
                    enumLiteral_2=(Token)match(input,72,FOLLOW_72_in_ruleSizeUnit10805); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSizeUnitAccess().getPxEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(enumLiteral_2, grammarAccess.getSizeUnitAccess().getPxEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5577:6: (enumLiteral_3= '%' )
                    {
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5577:6: (enumLiteral_3= '%' )
                    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5577:8: enumLiteral_3= '%'
                    {
                    enumLiteral_3=(Token)match(input,39,FOLLOW_39_in_ruleSizeUnit10822); if (state.failed) return current;
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

    // $ANTLR start synpred9_InternalXcss
    public final void synpred9_InternalXcss_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken lv_name_2_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:669:1: ( (lv_name_2_0= ruleStringOrID ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:669:1: (lv_name_2_0= ruleStringOrID )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:669:1: (lv_name_2_0= ruleStringOrID )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:670:3: lv_name_2_0= ruleStringOrID
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getFontLiteralAccess().getNameStringOrIDParserRuleCall_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleStringOrID_in_synpred9_InternalXcss1288);
        lv_name_2_0=ruleStringOrID();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred9_InternalXcss

    // $ANTLR start synpred10_InternalXcss
    public final void synpred10_InternalXcss_fragment() throws RecognitionException {   
        Token lv_italic_4_0=null;

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:701:4: ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:701:4: ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:701:4: ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:702:5: {...}? => ( ( (lv_italic_4_0= 'I' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_InternalXcss", "getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 0)");
        }
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:702:108: ( ( (lv_italic_4_0= 'I' ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:703:6: ( (lv_italic_4_0= 'I' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 0);
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:706:6: ( (lv_italic_4_0= 'I' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:707:1: (lv_italic_4_0= 'I' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:707:1: (lv_italic_4_0= 'I' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:708:3: lv_italic_4_0= 'I'
        {
        lv_italic_4_0=(Token)match(input,19,FOLLOW_19_in_synpred10_InternalXcss1349); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred10_InternalXcss

    // $ANTLR start synpred11_InternalXcss
    public final void synpred11_InternalXcss_fragment() throws RecognitionException {   
        Token lv_bold_5_0=null;

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:734:4: ( ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:734:4: ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:734:4: ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:5: {...}? => ( ( (lv_bold_5_0= 'B' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred11_InternalXcss", "getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 1)");
        }
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:735:108: ( ( (lv_bold_5_0= 'B' ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:736:6: ( (lv_bold_5_0= 'B' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 1);
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:739:6: ( (lv_bold_5_0= 'B' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:740:1: (lv_bold_5_0= 'B' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:740:1: (lv_bold_5_0= 'B' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:741:3: lv_bold_5_0= 'B'
        {
        lv_bold_5_0=(Token)match(input,20,FOLLOW_20_in_synpred11_InternalXcss1430); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred11_InternalXcss

    // $ANTLR start synpred12_InternalXcss
    public final void synpred12_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_size_6_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:767:4: ( ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:767:4: ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:767:4: ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:768:5: {...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred12_InternalXcss", "getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 2)");
        }
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:768:108: ( ( (lv_size_6_0= ruleSizeLiteral ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:769:6: ( (lv_size_6_0= ruleSizeLiteral ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 2);
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:772:6: ( (lv_size_6_0= ruleSizeLiteral ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:773:1: (lv_size_6_0= ruleSizeLiteral )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:773:1: (lv_size_6_0= ruleSizeLiteral )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:774:3: lv_size_6_0= ruleSizeLiteral
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getFontLiteralAccess().getSizeSizeLiteralParserRuleCall_3_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleSizeLiteral_in_synpred12_InternalXcss1514);
        lv_size_6_0=ruleSizeLiteral();

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


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1119:2: (this_CssLiterals_0= ruleCssLiterals )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1119:2: this_CssLiterals_0= ruleCssLiterals
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleCssLiterals_in_synpred15_InternalXcss2321);
        this_CssLiterals_0=ruleCssLiterals();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalXcss

    // $ANTLR start synpred16_InternalXcss
    public final void synpred16_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XClosure_1 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1132:2: (this_XClosure_1= ruleXClosure )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1132:2: this_XClosure_1= ruleXClosure
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXClosure_in_synpred16_InternalXcss2351);
        this_XClosure_1=ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalXcss

    // $ANTLR start synpred18_InternalXcss
    public final void synpred18_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XIntLiteral_3 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1158:2: (this_XIntLiteral_3= ruleXIntLiteral )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1158:2: this_XIntLiteral_3= ruleXIntLiteral
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXIntLiteral_in_synpred18_InternalXcss2411);
        this_XIntLiteral_3=ruleXIntLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalXcss

    // $ANTLR start synpred21_InternalXcss
    public final void synpred21_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XTypeLiteral_6 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1197:2: (this_XTypeLiteral_6= ruleXTypeLiteral )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1197:2: this_XTypeLiteral_6= ruleXTypeLiteral
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXTypeLiteral_in_synpred21_InternalXcss2501);
        this_XTypeLiteral_6=ruleXTypeLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalXcss

    // $ANTLR start synpred25_InternalXcss
    public final void synpred25_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XFeatureCall_10 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1249:2: (this_XFeatureCall_10= ruleXFeatureCall )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1249:2: this_XFeatureCall_10= ruleXFeatureCall
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXFeatureCall_in_synpred25_InternalXcss2621);
        this_XFeatureCall_10=ruleXFeatureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalXcss

    // $ANTLR start synpred30_InternalXcss
    public final void synpred30_InternalXcss_fragment() throws RecognitionException {   
        EObject this_XCastedExpression_15 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1314:2: (this_XCastedExpression_15= ruleXCastedExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1314:2: this_XCastedExpression_15= ruleXCastedExpression
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXCastedExpression_in_synpred30_InternalXcss2771);
        this_XCastedExpression_15=ruleXCastedExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalXcss

    // $ANTLR start synpred33_InternalXcss
    public final void synpred33_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_value_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1434:2: ( () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1434:2: () ( ( ruleOpAssign ) ) ( (lv_value_3_0= ruleXAssignment ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1434:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1435:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1453:2: ( ( ruleOpAssign ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1454:1: ( ruleOpAssign )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1454:1: ( ruleOpAssign )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1455:3: ruleOpAssign
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAssign_in_synpred33_InternalXcss3088);
        ruleOpAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1472:2: ( (lv_value_3_0= ruleXAssignment ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1473:1: (lv_value_3_0= ruleXAssignment )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1473:1: (lv_value_3_0= ruleXAssignment )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1474:3: lv_value_3_0= ruleXAssignment
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAssignment_in_synpred33_InternalXcss3109);
        lv_value_3_0=ruleXAssignment();

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


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1567:2: ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1567:2: () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1567:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1568:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1586:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1587:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1587:1: ( ruleOpOr )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1588:3: ruleOpOr
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpOr_in_synpred35_InternalXcss3355);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1605:2: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1606:1: (lv_rightOperand_3_0= ruleXAndExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1606:1: (lv_rightOperand_3_0= ruleXAndExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1607:3: lv_rightOperand_3_0= ruleXAndExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAndExpression_in_synpred35_InternalXcss3376);
        lv_rightOperand_3_0=ruleXAndExpression();

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


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1693:2: ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1693:2: () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1693:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1694:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1712:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1713:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1713:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1714:3: ruleOpAnd
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAnd_in_synpred36_InternalXcss3601);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1731:2: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1732:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1732:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1733:3: lv_rightOperand_3_0= ruleXEqualityExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXEqualityExpression_in_synpred36_InternalXcss3622);
        lv_rightOperand_3_0=ruleXEqualityExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred36_InternalXcss

    // $ANTLR start synpred37_InternalXcss
    public final void synpred37_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1819:2: ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1819:2: () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1819:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1820:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1838:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1839:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1839:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1840:3: ruleOpEquality
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpEquality_in_synpred37_InternalXcss3847);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1857:2: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1858:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1858:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1859:3: lv_rightOperand_3_0= ruleXRelationalExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXRelationalExpression_in_synpred37_InternalXcss3868);
        lv_rightOperand_3_0=ruleXRelationalExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred37_InternalXcss

    // $ANTLR start synpred39_InternalXcss
    public final void synpred39_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1952:2: ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1952:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1952:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1952:3: () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1952:3: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1953:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_2=(Token)match(input,28,FOLLOW_28_in_synpred39_InternalXcss4100); if (state.failed) return ;
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1975:1: ( ( ruleQualifiedName ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1976:1: ( ruleQualifiedName )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1976:1: ( ruleQualifiedName )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1977:3: ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred39_InternalXcss4127);
        ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred39_InternalXcss

    // $ANTLR start synpred40_InternalXcss
    public final void synpred40_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_6_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1995:6: ( ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1995:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1995:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1995:7: () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1995:7: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:1996:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2014:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2015:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2015:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2016:3: ruleOpCompare
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpCompare_in_synpred40_InternalXcss4174);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2033:2: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2034:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2034:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2035:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_synpred40_InternalXcss4195);
        lv_rightOperand_6_0=ruleXOtherOperatorExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred40_InternalXcss

    // $ANTLR start synpred44_InternalXcss
    public final void synpred44_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2142:2: ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2142:2: () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2142:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2143:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2161:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2162:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2162:1: ( ruleOpOther )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2163:3: ruleOpOther
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpOther_in_synpred44_InternalXcss4480);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2180:2: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2181:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2181:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2182:3: lv_rightOperand_3_0= ruleXAdditiveExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAdditiveExpression_in_synpred44_InternalXcss4501);
        lv_rightOperand_3_0=ruleXAdditiveExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred44_InternalXcss

    // $ANTLR start synpred46_InternalXcss
    public final void synpred46_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2275:2: ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2275:2: () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2275:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2276:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2294:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2295:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2295:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2296:3: ruleOpAdd
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAdd_in_synpred46_InternalXcss4747);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2313:2: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2314:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2314:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2315:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_synpred46_InternalXcss4768);
        lv_rightOperand_3_0=ruleXMultiplicativeExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred46_InternalXcss

    // $ANTLR start synpred48_InternalXcss
    public final void synpred48_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2408:2: ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2408:2: () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2408:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2409:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2427:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2428:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2428:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2429:3: ruleOpMulti
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpMulti_in_synpred48_InternalXcss5014);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2446:2: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2447:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2447:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2448:3: lv_rightOperand_3_0= ruleXUnaryOperation
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXUnaryOperation_in_synpred48_InternalXcss5035);
        lv_rightOperand_3_0=ruleXUnaryOperation();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred48_InternalXcss

    // $ANTLR start synpred59_InternalXcss
    public final void synpred59_InternalXcss_fragment() throws RecognitionException {   
        Token lv_explicitOperationCall_9_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_memberCallArguments_10_0 = null;

        EObject lv_memberCallArguments_12_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2791:3: ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2791:3: ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')'
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2791:3: ( (lv_explicitOperationCall_9_0= '(' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2792:1: (lv_explicitOperationCall_9_0= '(' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2792:1: (lv_explicitOperationCall_9_0= '(' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2793:3: lv_explicitOperationCall_9_0= '('
        {
        lv_explicitOperationCall_9_0=(Token)match(input,43,FOLLOW_43_in_synpred59_InternalXcss5722); if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2812:2: ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )?
        int alt76=2;
        int LA76_0 = input.LA(1);

        if ( ((LA76_0>=RULE_STRING && LA76_0<=RULE_INT)||LA76_0==11||LA76_0==18||LA76_0==21||LA76_0==32||(LA76_0>=35 && LA76_0<=36)||LA76_0==40||LA76_0==43||(LA76_0>=45 && LA76_0<=46)||LA76_0==48||(LA76_0>=51 && LA76_0<=53)||(LA76_0>=56 && LA76_0<=59)||(LA76_0>=61 && LA76_0<=62)||LA76_0==65) ) {
            alt76=1;
        }
        switch (alt76) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2812:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2812:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2813:1: (lv_memberCallArguments_10_0= ruleXExpression )
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2813:1: (lv_memberCallArguments_10_0= ruleXExpression )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2814:3: lv_memberCallArguments_10_0= ruleXExpression
                {
                if ( state.backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_0_0(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleXExpression_in_synpred59_InternalXcss5757);
                lv_memberCallArguments_10_0=ruleXExpression();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2836:2: (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                loop75:
                do {
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==42) ) {
                        alt75=1;
                    }


                    switch (alt75) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2836:4: otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                	    {
                	    otherlv_11=(Token)match(input,42,FOLLOW_42_in_synpred59_InternalXcss5770); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2840:1: ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2841:1: (lv_memberCallArguments_12_0= ruleXExpression )
                	    {
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2841:1: (lv_memberCallArguments_12_0= ruleXExpression )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2842:3: lv_memberCallArguments_12_0= ruleXExpression
                	    {
                	    if ( state.backtracking==0 ) {
                	       
                	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_1_1_0(), currentNode); 
                	      	    
                	    }
                	    pushFollow(FOLLOW_ruleXExpression_in_synpred59_InternalXcss5791);
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

        otherlv_13=(Token)match(input,44,FOLLOW_44_in_synpred59_InternalXcss5807); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_InternalXcss

    // $ANTLR start synpred60_InternalXcss
    public final void synpred60_InternalXcss_fragment() throws RecognitionException {   
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


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2691:2: ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2691:2: () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2691:2: ()
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2692:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_2=(Token)match(input,41,FOLLOW_41_in_synpred60_InternalXcss5595); if (state.failed) return ;
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2714:1: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
        int alt78=2;
        int LA78_0 = input.LA(1);

        if ( (LA78_0==32) ) {
            alt78=1;
        }
        switch (alt78) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2714:3: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                {
                otherlv_3=(Token)match(input,32,FOLLOW_32_in_synpred60_InternalXcss5608); if (state.failed) return ;
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2718:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2719:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2719:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2720:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                {
                if ( state.backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_synpred60_InternalXcss5629);
                lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2742:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                loop77:
                do {
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==42) ) {
                        alt77=1;
                    }


                    switch (alt77) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2742:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                	    {
                	    otherlv_5=(Token)match(input,42,FOLLOW_42_in_synpred60_InternalXcss5642); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2746:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2747:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                	    {
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2747:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2748:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                	    {
                	    if ( state.backtracking==0 ) {
                	       
                	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_2_1_0(), currentNode); 
                	      	    
                	    }
                	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_synpred60_InternalXcss5663);
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

                otherlv_7=(Token)match(input,31,FOLLOW_31_in_synpred60_InternalXcss5677); if (state.failed) return ;

                }
                break;

        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2774:3: ( (otherlv_8= RULE_ID ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2775:1: (otherlv_8= RULE_ID )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2775:1: (otherlv_8= RULE_ID )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2776:3: otherlv_8= RULE_ID
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred60_InternalXcss5703); if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2791:2: ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
        int alt81=2;
        int LA81_0 = input.LA(1);

        if ( (LA81_0==43) ) {
            alt81=1;
        }
        switch (alt81) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2791:3: ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')'
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2791:3: ( (lv_explicitOperationCall_9_0= '(' ) )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2792:1: (lv_explicitOperationCall_9_0= '(' )
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2792:1: (lv_explicitOperationCall_9_0= '(' )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2793:3: lv_explicitOperationCall_9_0= '('
                {
                lv_explicitOperationCall_9_0=(Token)match(input,43,FOLLOW_43_in_synpred60_InternalXcss5722); if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2812:2: ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )?
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( ((LA80_0>=RULE_STRING && LA80_0<=RULE_INT)||LA80_0==11||LA80_0==18||LA80_0==21||LA80_0==32||(LA80_0>=35 && LA80_0<=36)||LA80_0==40||LA80_0==43||(LA80_0>=45 && LA80_0<=46)||LA80_0==48||(LA80_0>=51 && LA80_0<=53)||(LA80_0>=56 && LA80_0<=59)||(LA80_0>=61 && LA80_0<=62)||LA80_0==65) ) {
                    alt80=1;
                }
                switch (alt80) {
                    case 1 :
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2812:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                        {
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2812:3: ( (lv_memberCallArguments_10_0= ruleXExpression ) )
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2813:1: (lv_memberCallArguments_10_0= ruleXExpression )
                        {
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2813:1: (lv_memberCallArguments_10_0= ruleXExpression )
                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2814:3: lv_memberCallArguments_10_0= ruleXExpression
                        {
                        if ( state.backtracking==0 ) {
                           
                          	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_0_0(), currentNode); 
                          	    
                        }
                        pushFollow(FOLLOW_ruleXExpression_in_synpred60_InternalXcss5757);
                        lv_memberCallArguments_10_0=ruleXExpression();

                        state._fsp--;
                        if (state.failed) return ;

                        }


                        }

                        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2836:2: (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                        loop79:
                        do {
                            int alt79=2;
                            int LA79_0 = input.LA(1);

                            if ( (LA79_0==42) ) {
                                alt79=1;
                            }


                            switch (alt79) {
                        	case 1 :
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2836:4: otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                        	    {
                        	    otherlv_11=(Token)match(input,42,FOLLOW_42_in_synpred60_InternalXcss5770); if (state.failed) return ;
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2840:1: ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2841:1: (lv_memberCallArguments_12_0= ruleXExpression )
                        	    {
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2841:1: (lv_memberCallArguments_12_0= ruleXExpression )
                        	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:2842:3: lv_memberCallArguments_12_0= ruleXExpression
                        	    {
                        	    if ( state.backtracking==0 ) {
                        	       
                        	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_1_1_0(), currentNode); 
                        	      	    
                        	    }
                        	    pushFollow(FOLLOW_ruleXExpression_in_synpred60_InternalXcss5791);
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

                otherlv_13=(Token)match(input,44,FOLLOW_44_in_synpred60_InternalXcss5807); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred60_InternalXcss

    // $ANTLR start synpred63_InternalXcss
    public final void synpred63_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3190:4: (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3190:4: otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) )
        {
        otherlv_5=(Token)match(input,47,FOLLOW_47_in_synpred63_InternalXcss6405); if (state.failed) return ;
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3194:1: ( (lv_else_6_0= ruleXExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3195:1: (lv_else_6_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3195:1: (lv_else_6_0= ruleXExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3196:3: lv_else_6_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_5_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred63_InternalXcss6426);
        lv_else_6_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred63_InternalXcss

    // $ANTLR start synpred64_InternalXcss
    public final void synpred64_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_switch_1_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3246:1: ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3246:1: (lv_switch_1_0= ruleXExpressionInsideBlock )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3246:1: (lv_switch_1_0= ruleXExpressionInsideBlock )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3247:3: lv_switch_1_0= ruleXExpressionInsideBlock
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionInsideBlockParserRuleCall_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_synpred64_InternalXcss6532);
        lv_switch_1_0=ruleXExpressionInsideBlock();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred64_InternalXcss

    // $ANTLR start synpred66_InternalXcss
    public final void synpred66_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        EObject lv_default_6_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3305:2: ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3305:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3305:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3305:3: ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';'
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3305:3: ( (lv_default_6_0= ruleXExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3306:1: (lv_default_6_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3306:1: (lv_default_6_0= ruleXExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3307:3: lv_default_6_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_4_2_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred66_InternalXcss6615);
        lv_default_6_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_7=(Token)match(input,16,FOLLOW_16_in_synpred66_InternalXcss6627); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred66_InternalXcss

    // $ANTLR start synpred70_InternalXcss
    public final void synpred70_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_then_4_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3441:2: ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3441:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3441:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3441:3: ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';'
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3441:3: ( (lv_then_4_0= ruleXExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3442:1: (lv_then_4_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3442:1: (lv_then_4_0= ruleXExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:3443:3: lv_then_4_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred70_InternalXcss6834);
        lv_then_4_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_5=(Token)match(input,16,FOLLOW_16_in_synpred70_InternalXcss6846); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred70_InternalXcss

    // $ANTLR start synpred81_InternalXcss
    public final void synpred81_InternalXcss_fragment() throws RecognitionException {   
        Token lv_explicitOperationCall_6_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_featureCallArguments_7_0 = null;

        EObject lv_featureCallArguments_9_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4192:3: ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4192:3: ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')'
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4192:3: ( (lv_explicitOperationCall_6_0= '(' ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4193:1: (lv_explicitOperationCall_6_0= '(' )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4193:1: (lv_explicitOperationCall_6_0= '(' )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4194:3: lv_explicitOperationCall_6_0= '('
        {
        lv_explicitOperationCall_6_0=(Token)match(input,43,FOLLOW_43_in_synpred81_InternalXcss8150); if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4213:2: ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )?
        int alt88=2;
        int LA88_0 = input.LA(1);

        if ( ((LA88_0>=RULE_STRING && LA88_0<=RULE_INT)||LA88_0==11||LA88_0==18||LA88_0==21||LA88_0==32||(LA88_0>=35 && LA88_0<=36)||LA88_0==40||LA88_0==43||(LA88_0>=45 && LA88_0<=46)||LA88_0==48||(LA88_0>=51 && LA88_0<=53)||(LA88_0>=56 && LA88_0<=59)||(LA88_0>=61 && LA88_0<=62)||LA88_0==65) ) {
            alt88=1;
        }
        switch (alt88) {
            case 1 :
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4213:3: ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4213:3: ( (lv_featureCallArguments_7_0= ruleXExpression ) )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4214:1: (lv_featureCallArguments_7_0= ruleXExpression )
                {
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4214:1: (lv_featureCallArguments_7_0= ruleXExpression )
                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4215:3: lv_featureCallArguments_7_0= ruleXExpression
                {
                if ( state.backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_0_0(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleXExpression_in_synpred81_InternalXcss8185);
                lv_featureCallArguments_7_0=ruleXExpression();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4237:2: (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                loop87:
                do {
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==42) ) {
                        alt87=1;
                    }


                    switch (alt87) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4237:4: otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                	    {
                	    otherlv_8=(Token)match(input,42,FOLLOW_42_in_synpred81_InternalXcss8198); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4241:1: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4242:1: (lv_featureCallArguments_9_0= ruleXExpression )
                	    {
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4242:1: (lv_featureCallArguments_9_0= ruleXExpression )
                	    // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4243:3: lv_featureCallArguments_9_0= ruleXExpression
                	    {
                	    if ( state.backtracking==0 ) {
                	       
                	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_1_1_0(), currentNode); 
                	      	    
                	    }
                	    pushFollow(FOLLOW_ruleXExpression_in_synpred81_InternalXcss8219);
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

        otherlv_10=(Token)match(input,44,FOLLOW_44_in_synpred81_InternalXcss8235); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred81_InternalXcss

    // $ANTLR start synpred87_InternalXcss
    public final void synpred87_InternalXcss_fragment() throws RecognitionException {   
        EObject lv_catchClauses_2_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4786:1: ( (lv_catchClauses_2_0= ruleXCatchClause ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4786:1: (lv_catchClauses_2_0= ruleXCatchClause )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4786:1: (lv_catchClauses_2_0= ruleXCatchClause )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4787:3: lv_catchClauses_2_0= ruleXCatchClause
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXCatchClause_in_synpred87_InternalXcss9279);
        lv_catchClauses_2_0=ruleXCatchClause();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred87_InternalXcss

    // $ANTLR start synpred88_InternalXcss
    public final void synpred88_InternalXcss_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        EObject lv_finallyExpression_4_0 = null;


        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4809:5: (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4809:5: otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) )
        {
        otherlv_3=(Token)match(input,63,FOLLOW_63_in_synpred88_InternalXcss9293); if (state.failed) return ;
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4813:1: ( (lv_finallyExpression_4_0= ruleXExpression ) )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4814:1: (lv_finallyExpression_4_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4814:1: (lv_finallyExpression_4_0= ruleXExpression )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:4815:3: lv_finallyExpression_4_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred88_InternalXcss9314);
        lv_finallyExpression_4_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred88_InternalXcss

    // $ANTLR start synpred98_InternalXcss
    public final void synpred98_InternalXcss_fragment() throws RecognitionException {   
        Token kw=null;
        Token this_ID_2=null;

        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5534:2: (kw= '.' this_ID_2= RULE_ID )
        // ../org.eclipse.xtext.example.css/src-gen/org/eclipse/xtext/example/css/parser/antlr/internal/InternalXcss.g:5534:2: kw= '.' this_ID_2= RULE_ID
        {
        kw=(Token)match(input,41,FOLLOW_41_in_synpred98_InternalXcss10695); if (state.failed) return ;
        this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred98_InternalXcss10710); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred98_InternalXcss

    // Delegated rules

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
    public final boolean synpred70_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_InternalXcss_fragment(); // can never throw exception
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
    public final boolean synpred46_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalXcss_fragment(); // can never throw exception
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
    public final boolean synpred60_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_InternalXcss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_InternalXcss_fragment(); // can never throw exception
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
    public final boolean synpred40_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalXcss_fragment(); // can never throw exception
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
    public final boolean synpred66_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_InternalXcss_fragment(); // can never throw exception
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
    public final boolean synpred44_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalXcss_fragment(); // can never throw exception
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
    public final boolean synpred81_InternalXcss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred81_InternalXcss_fragment(); // can never throw exception
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
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA55 dfa55 = new DFA55(this);
    static final String DFA9_eotS =
        "\12\uffff";
    static final String DFA9_eofS =
        "\1\1\11\uffff";
    static final String DFA9_minS =
        "\1\4\1\uffff\1\4\2\uffff\4\0\1\uffff";
    static final String DFA9_maxS =
        "\1\101\1\uffff\1\110\2\uffff\4\0\1\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\4\1\uffff\1\1\1\2\4\uffff\1\3";
    static final String DFA9_specialS =
        "\1\3\4\uffff\1\2\1\0\1\1\1\4\1\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\1\1\2\4\uffff\3\1\1\uffff\4\1\1\3\1\4\34\1\2\uffff\11\1\1"+
            "\uffff\5\1",
            "",
            "\3\1\4\uffff\3\1\2\uffff\1\1\1\uffff\1\1\2\uffff\22\1\1\5\2"+
            "\1\1\uffff\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff\11\1\1\uffff"+
            "\2\1\2\uffff\1\1\4\uffff\1\6\1\7\1\10",
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
            return "()* loopback of 699:3: ( ({...}? => ( ( (lv_italic_4_0= 'I' ) ) ) ) | ({...}? => ( ( (lv_bold_5_0= 'B' ) ) ) ) | ({...}? => ( ( (lv_size_6_0= ruleSizeLiteral ) ) ) ) )*";
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
                        if ( synpred12_InternalXcss() && getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 2) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_7 = input.LA(1);

                         
                        int index9_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred12_InternalXcss() && getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 2) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_5 = input.LA(1);

                         
                        int index9_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred12_InternalXcss() && getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 2) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_0 = input.LA(1);

                         
                        int index9_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA9_0==EOF||(LA9_0>=RULE_STRING && LA9_0<=RULE_ID)||(LA9_0>=11 && LA9_0<=13)||(LA9_0>=15 && LA9_0<=18)||(LA9_0>=21 && LA9_0<=48)||(LA9_0>=51 && LA9_0<=59)||(LA9_0>=61 && LA9_0<=65)) ) {s = 1;}

                        else if ( (LA9_0==RULE_INT) ) {s = 2;}

                        else if ( LA9_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 0) ) {s = 3;}

                        else if ( LA9_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 1) ) {s = 4;}

                         
                        input.seek(index9_0);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_8 = input.LA(1);

                         
                        int index9_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred12_InternalXcss() && getUnorderedGroupHelper().canSelect(grammarAccess.getFontLiteralAccess().getUnorderedGroup_3(), 2) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_8);
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
        "\32\uffff";
    static final String DFA12_eofS =
        "\32\uffff";
    static final String DFA12_minS =
        "\1\4\2\uffff\3\0\24\uffff";
    static final String DFA12_maxS =
        "\1\101\2\uffff\3\0\24\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\1\uffff\1\3\1\uffff\1\5\1\6\1\10\1\11\1"+
        "\12\1\13\1\14\1\15\1\16\1\17\1\21\1\22\1\4\1\7\1\20\1\23";
    static final String DFA12_specialS =
        "\3\uffff\1\0\1\1\1\2\24\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\13\1\4\1\3\4\uffff\1\15\6\uffff\1\1\2\uffff\1\1\12\uffff"+
            "\1\17\12\uffff\1\5\1\uffff\1\6\1\20\1\uffff\1\16\2\uffff\1\21"+
            "\1\22\1\23\2\uffff\1\14\2\10\1\12\1\uffff\1\24\1\25\2\uffff"+
            "\1\6",
            "",
            "",
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
            return "1118:1: (this_CssLiterals_0= ruleCssLiterals | this_XClosure_1= ruleXClosure | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XIntLiteral_3= ruleXIntLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral | this_XConstructorCall_7= ruleXConstructorCall | this_XBlockExpression_8= ruleXBlockExpression | this_XSwitchExpression_9= ruleXSwitchExpression | this_XFeatureCall_10= ruleXFeatureCall | this_XIfExpression_11= ruleXIfExpression | this_XForLoopExpression_12= ruleXForLoopExpression | this_XWhileExpression_13= ruleXWhileExpression | this_XDoWhileExpression_14= ruleXDoWhileExpression | this_XCastedExpression_15= ruleXCastedExpression | this_XThrowExpression_16= ruleXThrowExpression | this_XTryCatchFinallyExpression_17= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_18= ruleXParenthesizedExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_3 = input.LA(1);

                         
                        int index12_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalXcss()) ) {s = 1;}

                        else if ( (synpred18_InternalXcss()) ) {s = 22;}

                         
                        input.seek(index12_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_4 = input.LA(1);

                         
                        int index12_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalXcss()) ) {s = 6;}

                        else if ( (synpred21_InternalXcss()) ) {s = 23;}

                        else if ( (synpred25_InternalXcss()) ) {s = 15;}

                         
                        input.seek(index12_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_5 = input.LA(1);

                         
                        int index12_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalXcss()) ) {s = 6;}

                        else if ( (synpred30_InternalXcss()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index12_5);
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
    static final String DFA33_eotS =
        "\67\uffff";
    static final String DFA33_eofS =
        "\1\2\66\uffff";
    static final String DFA33_minS =
        "\1\4\1\0\65\uffff";
    static final String DFA33_maxS =
        "\1\101\1\0\65\uffff";
    static final String DFA33_acceptS =
        "\2\uffff\1\2\63\uffff\1\1";
    static final String DFA33_specialS =
        "\1\uffff\1\0\65\uffff}>";
    static final String[] DFA33_transitionS = {
            "\3\2\4\uffff\3\2\1\uffff\4\2\2\uffff\26\2\1\1\5\2\2\uffff\11"+
            "\2\1\uffff\5\2",
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
            return "2791:2: ( ( (lv_explicitOperationCall_9_0= '(' ) ) ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_1 = input.LA(1);

                         
                        int index33_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_InternalXcss()) ) {s = 54;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index33_1);
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
    static final String DFA38_eotS =
        "\34\uffff";
    static final String DFA38_eofS =
        "\34\uffff";
    static final String DFA38_minS =
        "\1\4\21\uffff\1\0\11\uffff";
    static final String DFA38_maxS =
        "\1\101\21\uffff\1\0\11\uffff";
    static final String DFA38_acceptS =
        "\1\uffff\1\1\31\uffff\1\2";
    static final String DFA38_specialS =
        "\22\uffff\1\0\11\uffff}>";
    static final String[] DFA38_transitionS = {
            "\3\1\4\uffff\1\22\6\uffff\1\1\2\uffff\1\1\12\uffff\1\1\2\uffff"+
            "\2\1\3\uffff\1\1\2\uffff\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff"+
            "\11\1\1\uffff\2\1\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "3245:1: ( (lv_switch_1_0= ruleXExpressionInsideBlock ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_18 = input.LA(1);

                         
                        int index38_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred64_InternalXcss()) ) {s = 1;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index38_18);
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
    static final String DFA40_eotS =
        "\32\uffff";
    static final String DFA40_eofS =
        "\32\uffff";
    static final String DFA40_minS =
        "\1\4\17\uffff\1\0\11\uffff";
    static final String DFA40_maxS =
        "\1\101\17\uffff\1\0\11\uffff";
    static final String DFA40_acceptS =
        "\1\uffff\1\1\27\uffff\1\2";
    static final String DFA40_specialS =
        "\20\uffff\1\0\11\uffff}>";
    static final String[] DFA40_transitionS = {
            "\3\1\4\uffff\1\20\6\uffff\1\1\2\uffff\1\1\12\uffff\1\1\2\uffff"+
            "\2\1\3\uffff\1\1\2\uffff\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff"+
            "\3\1\2\uffff\4\1\1\uffff\2\1\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "3305:1: ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_16 = input.LA(1);

                         
                        int index40_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_InternalXcss()) ) {s = 1;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index40_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
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
        "\1\101\17\uffff\1\0\11\uffff";
    static final String DFA44_acceptS =
        "\1\uffff\1\1\27\uffff\1\2";
    static final String DFA44_specialS =
        "\20\uffff\1\0\11\uffff}>";
    static final String[] DFA44_transitionS = {
            "\3\1\4\uffff\1\20\6\uffff\1\1\2\uffff\1\1\12\uffff\1\1\2\uffff"+
            "\2\1\3\uffff\1\1\2\uffff\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff"+
            "\3\1\2\uffff\4\1\1\uffff\2\1\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "3441:1: ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )";
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
                        if ( (synpred70_InternalXcss()) ) {s = 1;}

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
    static final String DFA55_eotS =
        "\67\uffff";
    static final String DFA55_eofS =
        "\1\2\66\uffff";
    static final String DFA55_minS =
        "\1\4\1\0\65\uffff";
    static final String DFA55_maxS =
        "\1\101\1\0\65\uffff";
    static final String DFA55_acceptS =
        "\2\uffff\1\2\63\uffff\1\1";
    static final String DFA55_specialS =
        "\1\uffff\1\0\65\uffff}>";
    static final String[] DFA55_transitionS = {
            "\3\2\4\uffff\3\2\1\uffff\4\2\2\uffff\26\2\1\1\5\2\2\uffff\11"+
            "\2\1\uffff\5\2",
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

    static final short[] DFA55_eot = DFA.unpackEncodedString(DFA55_eotS);
    static final short[] DFA55_eof = DFA.unpackEncodedString(DFA55_eofS);
    static final char[] DFA55_min = DFA.unpackEncodedStringToUnsignedChars(DFA55_minS);
    static final char[] DFA55_max = DFA.unpackEncodedStringToUnsignedChars(DFA55_maxS);
    static final short[] DFA55_accept = DFA.unpackEncodedString(DFA55_acceptS);
    static final short[] DFA55_special = DFA.unpackEncodedString(DFA55_specialS);
    static final short[][] DFA55_transition;

    static {
        int numStates = DFA55_transitionS.length;
        DFA55_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA55_transition[i] = DFA.unpackEncodedString(DFA55_transitionS[i]);
        }
    }

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = DFA55_eot;
            this.eof = DFA55_eof;
            this.min = DFA55_min;
            this.max = DFA55_max;
            this.accept = DFA55_accept;
            this.special = DFA55_special;
            this.transition = DFA55_transition;
        }
        public String getDescription() {
            return "4192:2: ( ( (lv_explicitOperationCall_6_0= '(' ) ) ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA55_1 = input.LA(1);

                         
                        int index55_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalXcss()) ) {s = 54;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index55_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 55, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleStyleSheet_in_entryRuleStyleSheet81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStyleSheet91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStyleRule_in_ruleStyleSheet149 = new BitSet(new long[]{0x0000000000002022L});
    public static final BitSet FOLLOW_ruleStyleRule_in_entryRuleStyleRule186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStyleRule196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelector_in_ruleStyleRule242 = new BitSet(new long[]{0x0000000000002820L});
    public static final BitSet FOLLOW_11_in_ruleStyleRule255 = new BitSet(new long[]{0x6F39691900241870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSetting_in_ruleStyleRule276 = new BitSet(new long[]{0x6F39691900241870L,0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleStyleRule289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelector_in_entryRuleSelector325 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelector335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeSelector_in_ruleSelector386 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleWildcardSelector_in_ruleSelector416 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleFilter_in_ruleSelector437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeSelector_in_entryRuleTypeSelector476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeSelector486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeSelector537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcardSelector_in_entryRuleWildcardSelector572 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcardSelector582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleWildcardSelector631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFilter_in_entryRuleFilter667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFilter677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleFilter714 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleFilter735 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFilter747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSetting_in_entryRuleSetting783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSetting793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleSetting843 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_ruleOpSettingAssign_in_ruleSetting882 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleSetting903 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSetting917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSettingAssign_in_entryRuleOpSettingAssign954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSettingAssign965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleOpSettingAssign1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCssLiterals_in_entryRuleCssLiterals1043 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCssLiterals1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFontLiteral_in_ruleCssLiterals1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColorLiteral_in_ruleCssLiterals1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSizeLiteral_in_ruleCssLiterals1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFontLiteral_in_entryRuleFontLiteral1204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFontLiteral1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleFontLiteral1267 = new BitSet(new long[]{0x00000000003C0072L});
    public static final BitSet FOLLOW_ruleStringOrID_in_ruleFontLiteral1288 = new BitSet(new long[]{0x00000000003C0042L});
    public static final BitSet FOLLOW_19_in_ruleFontLiteral1349 = new BitSet(new long[]{0x00000000003C0042L});
    public static final BitSet FOLLOW_20_in_ruleFontLiteral1430 = new BitSet(new long[]{0x00000000003C0042L});
    public static final BitSet FOLLOW_ruleSizeLiteral_in_ruleFontLiteral1514 = new BitSet(new long[]{0x00000000003C0042L});
    public static final BitSet FOLLOW_ruleStringOrID_in_entryRuleStringOrID1594 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringOrID1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringOrID1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStringOrID1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColorLiteral_in_entryRuleColorLiteral1716 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColorLiteral1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColorConstant_in_ruleColorLiteral1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGB_in_ruleColorLiteral1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColorConstant_in_entryRuleColorConstant1841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColorConstant1851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleColorConstant1888 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleColorConstant1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRGB_in_entryRuleRGB1948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRGB1958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleRGB1995 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleIntAsString_in_ruleRGB2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntAsString_in_entryRuleIntAsString2053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntAsString2064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntAsString2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSizeLiteral_in_entryRuleSizeLiteral2147 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSizeLiteral2157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSizeLiteral2199 = new BitSet(new long[]{0x0000008000000000L,0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleSizeUnit_in_ruleSizeLiteral2225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression2261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCssLiterals_in_ruleXPrimaryExpression2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXPrimaryExpression2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXPrimaryExpression2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXPrimaryExpression2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXPrimaryExpression2441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXPrimaryExpression2471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXPrimaryExpression2501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression2531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression2561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression2621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression2681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression2711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression2741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXPrimaryExpression2771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression2801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression2831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression2896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment2989 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment2999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment3049 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_ruleXAssignment3088 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_entryRuleOpAssign3148 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAssign3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpAssign3197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpAssign3216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression3256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression3266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression3316 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression3355 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression3376 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr3415 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpOr3463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression3502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3562 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression3601 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3622 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd3661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd3672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpAnd3709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression3748 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression3758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3808 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression3847 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3868 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality3907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality3918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpEquality3956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpEquality3975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression4015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression4025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4075 = new BitSet(new long[]{0x00000001F0000002L});
    public static final BitSet FOLLOW_28_in_ruleXRelationalExpression4100 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression4127 = new BitSet(new long[]{0x00000001F0000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression4174 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4195 = new BitSet(new long[]{0x00000001F0000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare4235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare4246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpCompare4284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpCompare4303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpCompare4322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpCompare4341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression4381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression4391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4441 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression4480 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4501 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther4540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther4551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpOther4589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpOther4608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression4648 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression4658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4708 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression4747 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4768 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd4807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd4818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpAdd4856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpAdd4875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression4915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression4925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression4975 = new BitSet(new long[]{0x000000E000002002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression5014 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression5035 = new BitSet(new long[]{0x000000E000002002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti5074 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti5085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleOpMulti5123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpMulti5142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpMulti5161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpMulti5180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation5220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation5230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation5295 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation5316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation5348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary5384 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary5395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOpUnary5433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpUnary5452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpUnary5471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall5511 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall5521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall5571 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleXMemberFeatureCall5595 = new BitSet(new long[]{0x0000000100000020L});
    public static final BitSet FOLLOW_32_in_ruleXMemberFeatureCall5608 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000006L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall5629 = new BitSet(new long[]{0x0000040080000000L});
    public static final BitSet FOLLOW_42_in_ruleXMemberFeatureCall5642 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000006L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall5663 = new BitSet(new long[]{0x0000040080000000L});
    public static final BitSet FOLLOW_31_in_ruleXMemberFeatureCall5677 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXMemberFeatureCall5703 = new BitSet(new long[]{0x00000A0000000002L});
    public static final BitSet FOLLOW_43_in_ruleXMemberFeatureCall5722 = new BitSet(new long[]{0x6F39791900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5757 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_ruleXMemberFeatureCall5770 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5791 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_ruleXMemberFeatureCall5807 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure5847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure5857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5916 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_42_in_ruleXClosure5929 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5950 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_45_in_ruleXClosure5966 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXClosure5987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression6023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression6033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleXCastedExpression6070 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression6091 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXCastedExpression6103 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression6124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression6170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleXParenthesizedExpression6207 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6232 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXParenthesizedExpression6243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6279 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression6289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleXIfExpression6326 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXIfExpression6338 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6359 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXIfExpression6371 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6392 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_ruleXIfExpression6405 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression6474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleXSwitchExpression6511 = new BitSet(new long[]{0x6FF9691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXSwitchExpression6532 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleXSwitchExpression6545 = new BitSet(new long[]{0x0004080000020020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6566 = new BitSet(new long[]{0x0006080000021020L,0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleXSwitchExpression6580 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXSwitchExpression6592 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6615 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleXSwitchExpression6627 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXSwitchExpression6655 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXSwitchExpression6670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6762 = new BitSet(new long[]{0x0004000000020000L});
    public static final BitSet FOLLOW_50_in_ruleXCasePart6776 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6797 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXCasePart6811 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6834 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleXCasePart6846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXCasePart6874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression6921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleXForLoopExpression6958 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXForLoopExpression6970 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6991 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXForLoopExpression7003 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression7024 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXForLoopExpression7036 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression7057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression7093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression7103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXWhileExpression7140 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXWhileExpression7152 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7173 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXWhileExpression7185 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression7252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleXDoWhileExpression7289 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7310 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleXDoWhileExpression7322 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXDoWhileExpression7334 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7355 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXDoWhileExpression7367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7403 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression7413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleXBlockExpression7462 = new BitSet(new long[]{0x6FF9691900241870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7484 = new BitSet(new long[]{0x6FF9691900251870L,0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleXBlockExpression7497 = new BitSet(new long[]{0x6FF9691900241870L,0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXBlockExpression7513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXVariableDeclaration7728 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXVariableDeclaration7759 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7781 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXVariableDeclaration7799 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleXVariableDeclaration7816 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7873 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter7883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7929 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJvmFormalParameter7947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7988 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall7998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleXFeatureCall8036 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000006L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8057 = new BitSet(new long[]{0x0000040080000000L});
    public static final BitSet FOLLOW_42_in_ruleXFeatureCall8070 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000006L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8091 = new BitSet(new long[]{0x0000040080000000L});
    public static final BitSet FOLLOW_31_in_ruleXFeatureCall8105 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXFeatureCall8131 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleXFeatureCall8150 = new BitSet(new long[]{0x6F39791900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8185 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_ruleXFeatureCall8198 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8219 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_ruleXFeatureCall8235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall8283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleXConstructorCall8320 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8347 = new BitSet(new long[]{0x0000080100000000L});
    public static final BitSet FOLLOW_32_in_ruleXConstructorCall8360 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000006L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8381 = new BitSet(new long[]{0x0000040080000000L});
    public static final BitSet FOLLOW_42_in_ruleXConstructorCall8394 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000006L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8415 = new BitSet(new long[]{0x0000040080000000L});
    public static final BitSet FOLLOW_31_in_ruleXConstructorCall8429 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXConstructorCall8443 = new BitSet(new long[]{0x6F39791900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8465 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_ruleXConstructorCall8478 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8499 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_ruleXConstructorCall8515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8551 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral8561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleXBooleanLiteral8611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXBooleanLiteral8636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral8695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleXNullLiteral8744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral8780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral8790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral8831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral8871 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral8881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral8922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral8962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral8972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9024 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXTypeLiteral9036 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleXTypeLiteral9048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression9094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXThrowExpression9131 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression9152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9188 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXTryCatchFinallyExpression9235 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9256 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9279 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_63_in_ruleXTryCatchFinallyExpression9293 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXTryCatchFinallyExpression9336 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause9405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleXCatchClause9442 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXCatchClause9454 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause9475 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXCatchClause9487 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause9508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference9544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference9554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference9604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference9634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef9669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef9679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleXFunctionTypeRef9717 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9738 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_ruleXFunctionTypeRef9751 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9772 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_ruleXFunctionTypeRef9786 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXFunctionTypeRef9800 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef9821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference9857 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference9867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference9919 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleJvmParameterizedTypeReference9932 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000006L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference9953 = new BitSet(new long[]{0x0000040080000000L});
    public static final BitSet FOLLOW_42_in_ruleJvmParameterizedTypeReference9966 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000006L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference9987 = new BitSet(new long[]{0x0000040080000000L});
    public static final BitSet FOLLOW_31_in_ruleJvmParameterizedTypeReference10001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference10039 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference10049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference10099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference10129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference10164 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference10174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleJvmWildcardTypeReference10223 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000028L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference10245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference10272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound10310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound10320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleJvmUpperBound10357 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound10378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded10414 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded10424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleJvmUpperBoundAnded10461 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded10482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound10518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound10528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleJvmLowerBound10565 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound10586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10676 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleQualifiedName10695 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10710 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_70_in_ruleSizeUnit10771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleSizeUnit10788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleSizeUnit10805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleSizeUnit10822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringOrID_in_synpred9_InternalXcss1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred10_InternalXcss1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_synpred11_InternalXcss1430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSizeLiteral_in_synpred12_InternalXcss1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCssLiterals_in_synpred15_InternalXcss2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred16_InternalXcss2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_synpred18_InternalXcss2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_synpred21_InternalXcss2501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_synpred25_InternalXcss2621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_synpred30_InternalXcss2771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_synpred33_InternalXcss3088 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_synpred33_InternalXcss3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred35_InternalXcss3355 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_synpred35_InternalXcss3376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred36_InternalXcss3601 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_synpred36_InternalXcss3622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred37_InternalXcss3847 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_synpred37_InternalXcss3868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred39_InternalXcss4100 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred39_InternalXcss4127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred40_InternalXcss4174 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_synpred40_InternalXcss4195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred44_InternalXcss4480 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_synpred44_InternalXcss4501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred46_InternalXcss4747 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_synpred46_InternalXcss4768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred48_InternalXcss5014 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_synpred48_InternalXcss5035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred59_InternalXcss5722 = new BitSet(new long[]{0x6F39791900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred59_InternalXcss5757 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_synpred59_InternalXcss5770 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred59_InternalXcss5791 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_synpred59_InternalXcss5807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred60_InternalXcss5595 = new BitSet(new long[]{0x0000000100000020L});
    public static final BitSet FOLLOW_32_in_synpred60_InternalXcss5608 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000006L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_synpred60_InternalXcss5629 = new BitSet(new long[]{0x0000040080000000L});
    public static final BitSet FOLLOW_42_in_synpred60_InternalXcss5642 = new BitSet(new long[]{0x0000080000000020L,0x0000000000000006L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_synpred60_InternalXcss5663 = new BitSet(new long[]{0x0000040080000000L});
    public static final BitSet FOLLOW_31_in_synpred60_InternalXcss5677 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred60_InternalXcss5703 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_synpred60_InternalXcss5722 = new BitSet(new long[]{0x6F39791900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred60_InternalXcss5757 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_synpred60_InternalXcss5770 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred60_InternalXcss5791 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_synpred60_InternalXcss5807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred63_InternalXcss6405 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred63_InternalXcss6426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_synpred64_InternalXcss6532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred66_InternalXcss6615 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_synpred66_InternalXcss6627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred70_InternalXcss6834 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_synpred70_InternalXcss6846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred81_InternalXcss8150 = new BitSet(new long[]{0x6F39791900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred81_InternalXcss8185 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_42_in_synpred81_InternalXcss8198 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred81_InternalXcss8219 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_44_in_synpred81_InternalXcss8235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_synpred87_InternalXcss9279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_synpred88_InternalXcss9293 = new BitSet(new long[]{0x6F39691900240870L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred88_InternalXcss9314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred98_InternalXcss10695 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred98_InternalXcss10710 = new BitSet(new long[]{0x0000000000000002L});

}
