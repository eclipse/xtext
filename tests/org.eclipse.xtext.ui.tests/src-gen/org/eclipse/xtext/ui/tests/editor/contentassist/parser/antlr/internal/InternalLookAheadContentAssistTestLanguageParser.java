package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.LookAheadContentAssistTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLookAheadContentAssistTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'['", "']'", "'<'", "'>'", "'{'", "'}'", "'='"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalLookAheadContentAssistTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLookAheadContentAssistTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLookAheadContentAssistTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g"; }



     	private LookAheadContentAssistTestLanguageGrammarAccess grammarAccess;
     	
        public InternalLookAheadContentAssistTestLanguageParser(TokenStream input, IAstFactory factory, LookAheadContentAssistTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected LookAheadContentAssistTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:71:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:72:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:79:1: ruleModel returns [EObject current=null] : ( () ( (otherlv_1= '(' ( (lv_attribute_2_0= ruleAttribute ) )* ( (lv_attribute_3_0= rulePair ) )* otherlv_4= ')' ) | (otherlv_5= '[' ( (lv_attribute_6_0= ruleAttribute ) )+ ( (lv_attribute_7_0= rulePair ) )* otherlv_8= ']' ) | (otherlv_9= '<' ( (lv_attribute_10_0= ruleAttribute ) )* ( (lv_attribute_11_0= rulePair ) )+ otherlv_12= '>' ) | (otherlv_13= '{' ( (lv_attribute_14_0= ruleAttribute ) )+ ( (lv_attribute_15_0= rulePair ) )+ otherlv_16= '}' ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_16=null;
        EObject lv_attribute_2_0 = null;

        EObject lv_attribute_3_0 = null;

        EObject lv_attribute_6_0 = null;

        EObject lv_attribute_7_0 = null;

        EObject lv_attribute_10_0 = null;

        EObject lv_attribute_11_0 = null;

        EObject lv_attribute_14_0 = null;

        EObject lv_attribute_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:82:28: ( ( () ( (otherlv_1= '(' ( (lv_attribute_2_0= ruleAttribute ) )* ( (lv_attribute_3_0= rulePair ) )* otherlv_4= ')' ) | (otherlv_5= '[' ( (lv_attribute_6_0= ruleAttribute ) )+ ( (lv_attribute_7_0= rulePair ) )* otherlv_8= ']' ) | (otherlv_9= '<' ( (lv_attribute_10_0= ruleAttribute ) )* ( (lv_attribute_11_0= rulePair ) )+ otherlv_12= '>' ) | (otherlv_13= '{' ( (lv_attribute_14_0= ruleAttribute ) )+ ( (lv_attribute_15_0= rulePair ) )+ otherlv_16= '}' ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:83:1: ( () ( (otherlv_1= '(' ( (lv_attribute_2_0= ruleAttribute ) )* ( (lv_attribute_3_0= rulePair ) )* otherlv_4= ')' ) | (otherlv_5= '[' ( (lv_attribute_6_0= ruleAttribute ) )+ ( (lv_attribute_7_0= rulePair ) )* otherlv_8= ']' ) | (otherlv_9= '<' ( (lv_attribute_10_0= ruleAttribute ) )* ( (lv_attribute_11_0= rulePair ) )+ otherlv_12= '>' ) | (otherlv_13= '{' ( (lv_attribute_14_0= ruleAttribute ) )+ ( (lv_attribute_15_0= rulePair ) )+ otherlv_16= '}' ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:83:1: ( () ( (otherlv_1= '(' ( (lv_attribute_2_0= ruleAttribute ) )* ( (lv_attribute_3_0= rulePair ) )* otherlv_4= ')' ) | (otherlv_5= '[' ( (lv_attribute_6_0= ruleAttribute ) )+ ( (lv_attribute_7_0= rulePair ) )* otherlv_8= ']' ) | (otherlv_9= '<' ( (lv_attribute_10_0= ruleAttribute ) )* ( (lv_attribute_11_0= rulePair ) )+ otherlv_12= '>' ) | (otherlv_13= '{' ( (lv_attribute_14_0= ruleAttribute ) )+ ( (lv_attribute_15_0= rulePair ) )+ otherlv_16= '}' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:83:2: () ( (otherlv_1= '(' ( (lv_attribute_2_0= ruleAttribute ) )* ( (lv_attribute_3_0= rulePair ) )* otherlv_4= ')' ) | (otherlv_5= '[' ( (lv_attribute_6_0= ruleAttribute ) )+ ( (lv_attribute_7_0= rulePair ) )* otherlv_8= ']' ) | (otherlv_9= '<' ( (lv_attribute_10_0= ruleAttribute ) )* ( (lv_attribute_11_0= rulePair ) )+ otherlv_12= '>' ) | (otherlv_13= '{' ( (lv_attribute_14_0= ruleAttribute ) )+ ( (lv_attribute_15_0= rulePair ) )+ otherlv_16= '}' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:83:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:84:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:89:2: ( (otherlv_1= '(' ( (lv_attribute_2_0= ruleAttribute ) )* ( (lv_attribute_3_0= rulePair ) )* otherlv_4= ')' ) | (otherlv_5= '[' ( (lv_attribute_6_0= ruleAttribute ) )+ ( (lv_attribute_7_0= rulePair ) )* otherlv_8= ']' ) | (otherlv_9= '<' ( (lv_attribute_10_0= ruleAttribute ) )* ( (lv_attribute_11_0= rulePair ) )+ otherlv_12= '>' ) | (otherlv_13= '{' ( (lv_attribute_14_0= ruleAttribute ) )+ ( (lv_attribute_15_0= rulePair ) )+ otherlv_16= '}' ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt9=1;
                }
                break;
            case 13:
                {
                alt9=2;
                }
                break;
            case 15:
                {
                alt9=3;
                }
                break;
            case 17:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:89:3: (otherlv_1= '(' ( (lv_attribute_2_0= ruleAttribute ) )* ( (lv_attribute_3_0= rulePair ) )* otherlv_4= ')' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:89:3: (otherlv_1= '(' ( (lv_attribute_2_0= ruleAttribute ) )* ( (lv_attribute_3_0= rulePair ) )* otherlv_4= ')' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:89:5: otherlv_1= '(' ( (lv_attribute_2_0= ruleAttribute ) )* ( (lv_attribute_3_0= rulePair ) )* otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel133); 

                        	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getLeftParenthesisKeyword_1_0_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:93:1: ( (lv_attribute_2_0= ruleAttribute ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_ID) ) {
                            int LA1_1 = input.LA(2);

                            if ( (LA1_1==RULE_ID||LA1_1==12) ) {
                                alt1=1;
                            }


                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:94:1: (lv_attribute_2_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:94:1: (lv_attribute_2_0= ruleAttribute )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:95:3: lv_attribute_2_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_1_0_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleModel154);
                    	    lv_attribute_2_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attribute",
                    	            		lv_attribute_2_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:111:3: ( (lv_attribute_3_0= rulePair ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:112:1: (lv_attribute_3_0= rulePair )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:112:1: (lv_attribute_3_0= rulePair )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:113:3: lv_attribute_3_0= rulePair
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributePairParserRuleCall_1_0_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_rulePair_in_ruleModel176);
                    	    lv_attribute_3_0=rulePair();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attribute",
                    	            		lv_attribute_3_0, 
                    	            		"Pair");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel189); 

                        	newLeafNode(otherlv_4, grammarAccess.getModelAccess().getRightParenthesisKeyword_1_0_3());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:134:6: (otherlv_5= '[' ( (lv_attribute_6_0= ruleAttribute ) )+ ( (lv_attribute_7_0= rulePair ) )* otherlv_8= ']' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:134:6: (otherlv_5= '[' ( (lv_attribute_6_0= ruleAttribute ) )+ ( (lv_attribute_7_0= rulePair ) )* otherlv_8= ']' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:134:8: otherlv_5= '[' ( (lv_attribute_6_0= ruleAttribute ) )+ ( (lv_attribute_7_0= rulePair ) )* otherlv_8= ']'
                    {
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel209); 

                        	newLeafNode(otherlv_5, grammarAccess.getModelAccess().getLeftSquareBracketKeyword_1_1_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:138:1: ( (lv_attribute_6_0= ruleAttribute ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID) ) {
                            int LA3_1 = input.LA(2);

                            if ( (LA3_1==RULE_ID||LA3_1==14) ) {
                                alt3=1;
                            }


                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:139:1: (lv_attribute_6_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:139:1: (lv_attribute_6_0= ruleAttribute )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:140:3: lv_attribute_6_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleModel230);
                    	    lv_attribute_6_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attribute",
                    	            		lv_attribute_6_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:156:3: ( (lv_attribute_7_0= rulePair ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:157:1: (lv_attribute_7_0= rulePair )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:157:1: (lv_attribute_7_0= rulePair )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:158:3: lv_attribute_7_0= rulePair
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributePairParserRuleCall_1_1_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_rulePair_in_ruleModel252);
                    	    lv_attribute_7_0=rulePair();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attribute",
                    	            		lv_attribute_7_0, 
                    	            		"Pair");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel265); 

                        	newLeafNode(otherlv_8, grammarAccess.getModelAccess().getRightSquareBracketKeyword_1_1_3());
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:179:6: (otherlv_9= '<' ( (lv_attribute_10_0= ruleAttribute ) )* ( (lv_attribute_11_0= rulePair ) )+ otherlv_12= '>' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:179:6: (otherlv_9= '<' ( (lv_attribute_10_0= ruleAttribute ) )* ( (lv_attribute_11_0= rulePair ) )+ otherlv_12= '>' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:179:8: otherlv_9= '<' ( (lv_attribute_10_0= ruleAttribute ) )* ( (lv_attribute_11_0= rulePair ) )+ otherlv_12= '>'
                    {
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel285); 

                        	newLeafNode(otherlv_9, grammarAccess.getModelAccess().getLessThanSignKeyword_1_2_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:183:1: ( (lv_attribute_10_0= ruleAttribute ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            int LA5_1 = input.LA(2);

                            if ( (LA5_1==RULE_ID) ) {
                                alt5=1;
                            }


                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:184:1: (lv_attribute_10_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:184:1: (lv_attribute_10_0= ruleAttribute )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:185:3: lv_attribute_10_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleModel306);
                    	    lv_attribute_10_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attribute",
                    	            		lv_attribute_10_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:201:3: ( (lv_attribute_11_0= rulePair ) )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_ID) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:202:1: (lv_attribute_11_0= rulePair )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:202:1: (lv_attribute_11_0= rulePair )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:203:3: lv_attribute_11_0= rulePair
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributePairParserRuleCall_1_2_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_rulePair_in_ruleModel328);
                    	    lv_attribute_11_0=rulePair();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attribute",
                    	            		lv_attribute_11_0, 
                    	            		"Pair");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    otherlv_12=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel341); 

                        	newLeafNode(otherlv_12, grammarAccess.getModelAccess().getGreaterThanSignKeyword_1_2_3());
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:224:6: (otherlv_13= '{' ( (lv_attribute_14_0= ruleAttribute ) )+ ( (lv_attribute_15_0= rulePair ) )+ otherlv_16= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:224:6: (otherlv_13= '{' ( (lv_attribute_14_0= ruleAttribute ) )+ ( (lv_attribute_15_0= rulePair ) )+ otherlv_16= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:224:8: otherlv_13= '{' ( (lv_attribute_14_0= ruleAttribute ) )+ ( (lv_attribute_15_0= rulePair ) )+ otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModel361); 

                        	newLeafNode(otherlv_13, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_3_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:228:1: ( (lv_attribute_14_0= ruleAttribute ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            int LA7_1 = input.LA(2);

                            if ( (LA7_1==RULE_ID) ) {
                                alt7=1;
                            }


                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:229:1: (lv_attribute_14_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:229:1: (lv_attribute_14_0= ruleAttribute )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:230:3: lv_attribute_14_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_1_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleModel382);
                    	    lv_attribute_14_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attribute",
                    	            		lv_attribute_14_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:246:3: ( (lv_attribute_15_0= rulePair ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:247:1: (lv_attribute_15_0= rulePair )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:247:1: (lv_attribute_15_0= rulePair )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:248:3: lv_attribute_15_0= rulePair
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getAttributePairParserRuleCall_1_3_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_rulePair_in_ruleModel404);
                    	    lv_attribute_15_0=rulePair();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attribute",
                    	            		lv_attribute_15_0, 
                    	            		"Pair");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    otherlv_16=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModel417); 

                        	newLeafNode(otherlv_16, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_3_3());
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleAttribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:276:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:277:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:278:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute455);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute465); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:285:1: ruleAttribute returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:288:28: ( ( (lv_value_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:289:1: ( (lv_value_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:289:1: ( (lv_value_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:290:1: (lv_value_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:290:1: (lv_value_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:291:3: lv_value_0_0= RULE_ID
            {
            lv_value_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute506); 

            			newLeafNode(lv_value_0_0, grammarAccess.getAttributeAccess().getValueIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRulePair"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:315:1: entryRulePair returns [EObject current=null] : iv_rulePair= rulePair EOF ;
    public final EObject entryRulePair() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePair = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:316:2: (iv_rulePair= rulePair EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:317:2: iv_rulePair= rulePair EOF
            {
             newCompositeNode(grammarAccess.getPairRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePair_in_entryRulePair546);
            iv_rulePair=rulePair();

            state._fsp--;

             current =iv_rulePair; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePair556); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePair"


    // $ANTLR start "rulePair"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:324:1: rulePair returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_ID ) ) ) ;
    public final EObject rulePair() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:327:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:328:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:328:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:328:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:328:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:329:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:329:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:330:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePair598); 

            			newLeafNode(lv_name_0_0, grammarAccess.getPairAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPairRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_rulePair615); 

                	newLeafNode(otherlv_1, grammarAccess.getPairAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:350:1: ( (lv_value_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:351:1: (lv_value_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:351:1: (lv_value_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:352:3: lv_value_2_0= RULE_ID
            {
            lv_value_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePair632); 

            			newLeafNode(lv_value_2_0, grammarAccess.getPairAccess().getValueIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPairRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePair"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel133 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleModel154 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_rulePair_in_ruleModel176 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleModel189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel209 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleModel230 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rulePair_in_ruleModel252 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleModel265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel285 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleModel306 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rulePair_in_ruleModel328 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleModel341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel361 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleModel382 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rulePair_in_ruleModel404 = new BitSet(new long[]{0x0000000000040010L});
        public static final BitSet FOLLOW_18_in_ruleModel417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute455 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePair_in_entryRulePair546 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePair556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePair598 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_rulePair615 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePair632 = new BitSet(new long[]{0x0000000000000002L});
    }


}