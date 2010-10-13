package org.eclipse.xtext.linking.parser.antlr.internal; 

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
import org.eclipse.xtext.linking.services.Bug287988TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug287988TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'actions'", "'simple'", "'rulecall'", "'rulecall2'", "'rulecall3'", "'inlinedActions'", "'ref'", "';'", "'attribute'", "'master'", "'call'", "'me'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
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


        public InternalBug287988TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug287988TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug287988TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g"; }



     	private Bug287988TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug287988TestLanguageParser(TokenStream input, IAstFactory factory, Bug287988TestLanguageGrammarAccess grammarAccess) {
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
       	protected Bug287988TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_attributes_1_0 = null;

        EObject lv_attributes_3_0 = null;

        EObject lv_attributes_5_0 = null;

        EObject lv_attributes_7_0 = null;

        EObject lv_attributes_9_0 = null;

        EObject lv_attributes_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:85:6: ( ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:86:1: ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:86:1: ( (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* ) | (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* ) | (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* ) | (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* ) | (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* ) | (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt7=1;
                }
                break;
            case 12:
                {
                alt7=2;
                }
                break;
            case 13:
                {
                alt7=3;
                }
                break;
            case 14:
                {
                alt7=4;
                }
                break;
            case 15:
                {
                alt7=5;
                }
                break;
            case 16:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:86:2: (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:86:2: (otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:86:4: otherlv_0= 'actions' ( (lv_attributes_1_0= ruleBaseAttribute ) )*
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel123); 

                        	createLeafNode(otherlv_0, grammarAccess.getModelAccess().getActionsKeyword_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:90:1: ( (lv_attributes_1_0= ruleBaseAttribute ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=19 && LA1_0<=20)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:91:1: (lv_attributes_1_0= ruleBaseAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:91:1: (lv_attributes_1_0= ruleBaseAttribute )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:92:3: lv_attributes_1_0= ruleBaseAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesBaseAttributeParserRuleCall_0_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleBaseAttribute_in_ruleModel144);
                    	    lv_attributes_1_0=ruleBaseAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_1_0, 
                    	    	        		"BaseAttribute", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:115:6: (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:115:6: (otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:115:8: otherlv_2= 'simple' ( (lv_attributes_3_0= ruleSimpleAttribute ) )*
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel165); 

                        	createLeafNode(otherlv_2, grammarAccess.getModelAccess().getSimpleKeyword_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:119:1: ( (lv_attributes_3_0= ruleSimpleAttribute ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID||LA2_0==17) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:120:1: (lv_attributes_3_0= ruleSimpleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:120:1: (lv_attributes_3_0= ruleSimpleAttribute )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:121:3: lv_attributes_3_0= ruleSimpleAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesSimpleAttributeParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleSimpleAttribute_in_ruleModel186);
                    	    lv_attributes_3_0=ruleSimpleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_3_0, 
                    	    	        		"SimpleAttribute", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:144:6: (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:144:6: (otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:144:8: otherlv_4= 'rulecall' ( (lv_attributes_5_0= ruleRuleCallAttribute ) )*
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel207); 

                        	createLeafNode(otherlv_4, grammarAccess.getModelAccess().getRulecallKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:148:1: ( (lv_attributes_5_0= ruleRuleCallAttribute ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID||LA3_0==17) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:149:1: (lv_attributes_5_0= ruleRuleCallAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:149:1: (lv_attributes_5_0= ruleRuleCallAttribute )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:150:3: lv_attributes_5_0= ruleRuleCallAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesRuleCallAttributeParserRuleCall_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleRuleCallAttribute_in_ruleModel228);
                    	    lv_attributes_5_0=ruleRuleCallAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_5_0, 
                    	    	        		"RuleCallAttribute", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:173:6: (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:173:6: (otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:173:8: otherlv_6= 'rulecall2' ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )*
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel249); 

                        	createLeafNode(otherlv_6, grammarAccess.getModelAccess().getRulecall2Keyword_3_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:177:1: ( (lv_attributes_7_0= ruleRuleCallAttribute2 ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:178:1: (lv_attributes_7_0= ruleRuleCallAttribute2 )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:178:1: (lv_attributes_7_0= ruleRuleCallAttribute2 )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:179:3: lv_attributes_7_0= ruleRuleCallAttribute2
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesRuleCallAttribute2ParserRuleCall_3_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleRuleCallAttribute2_in_ruleModel270);
                    	    lv_attributes_7_0=ruleRuleCallAttribute2();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_7_0, 
                    	    	        		"RuleCallAttribute2", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:202:6: (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:202:6: (otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:202:8: otherlv_8= 'rulecall3' ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )*
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel291); 

                        	createLeafNode(otherlv_8, grammarAccess.getModelAccess().getRulecall3Keyword_4_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:206:1: ( (lv_attributes_9_0= ruleRuleCallAttribute3 ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==21) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:207:1: (lv_attributes_9_0= ruleRuleCallAttribute3 )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:207:1: (lv_attributes_9_0= ruleRuleCallAttribute3 )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:208:3: lv_attributes_9_0= ruleRuleCallAttribute3
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesRuleCallAttribute3ParserRuleCall_4_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleRuleCallAttribute3_in_ruleModel312);
                    	    lv_attributes_9_0=ruleRuleCallAttribute3();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_9_0, 
                    	    	        		"RuleCallAttribute3", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:231:6: (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:231:6: (otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:231:8: otherlv_10= 'inlinedActions' ( (lv_attributes_11_0= ruleActionAttribute ) )*
                    {
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel333); 

                        	createLeafNode(otherlv_10, grammarAccess.getModelAccess().getInlinedActionsKeyword_5_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:235:1: ( (lv_attributes_11_0= ruleActionAttribute ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=19 && LA6_0<=20)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:236:1: (lv_attributes_11_0= ruleActionAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:236:1: (lv_attributes_11_0= ruleActionAttribute )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:237:3: lv_attributes_11_0= ruleActionAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributesActionAttributeParserRuleCall_5_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleActionAttribute_in_ruleModel354);
                    	    lv_attributes_11_0=ruleActionAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attributes",
                    	    	        		lv_attributes_11_0, 
                    	    	        		"ActionAttribute", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


    // $ANTLR start "entryRuleBaseAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:267:1: entryRuleBaseAttribute returns [EObject current=null] : iv_ruleBaseAttribute= ruleBaseAttribute EOF ;
    public final EObject entryRuleBaseAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseAttribute = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:268:2: (iv_ruleBaseAttribute= ruleBaseAttribute EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:269:2: iv_ruleBaseAttribute= ruleBaseAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBaseAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBaseAttribute_in_entryRuleBaseAttribute392);
            iv_ruleBaseAttribute=ruleBaseAttribute();

            state._fsp--;

             current =iv_ruleBaseAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBaseAttribute402); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseAttribute"


    // $ANTLR start "ruleBaseAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:276:1: ruleBaseAttribute returns [EObject current=null] : ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' ) ;
    public final EObject ruleBaseAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_type_4_0=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        EObject this_Attribute_0 = null;

        EObject this_Master_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:281:6: ( ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:282:1: ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:282:1: ( (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:282:2: (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster ) ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:282:2: (this_Attribute_0= ruleAttribute | this_Master_1= ruleMaster )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            else if ( (LA8_0==20) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:283:5: this_Attribute_0= ruleAttribute
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBaseAttributeAccess().getAttributeParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleBaseAttribute450);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;

                     
                            current = this_Attribute_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:293:5: this_Master_1= ruleMaster
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBaseAttributeAccess().getMasterParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMaster_in_ruleBaseAttribute477);
                    this_Master_1=ruleMaster();

                    state._fsp--;

                     
                            current = this_Master_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:301:2: ( (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_type_4_0= RULE_ID ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:301:3: (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:301:3: (otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:301:5: otherlv_2= 'ref' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleBaseAttribute491); 

                        	createLeafNode(otherlv_2, grammarAccess.getBaseAttributeAccess().getRefKeyword_1_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:305:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:306:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:306:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:307:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getBaseAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBaseAttribute511); 

                    		createLeafNode(otherlv_3, grammarAccess.getBaseAttributeAccess().getTypeRefBaseAttributeCrossReference_1_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:320:6: ( (lv_type_4_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:320:6: ( (lv_type_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:321:1: (lv_type_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:321:1: (lv_type_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:322:3: lv_type_4_0= RULE_ID
                    {
                    lv_type_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBaseAttribute535); 

                    			createLeafNode(lv_type_4_0, grammarAccess.getBaseAttributeAccess().getTypeIDTerminalRuleCall_1_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBaseAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_4_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:344:3: ( (lv_name_5_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:345:1: (lv_name_5_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:345:1: (lv_name_5_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:346:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBaseAttribute558); 

            			createLeafNode(lv_name_5_0, grammarAccess.getBaseAttributeAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBaseAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_5_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleBaseAttribute575); 

                	createLeafNode(otherlv_6, grammarAccess.getBaseAttributeAccess().getSemicolonKeyword_3(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBaseAttribute"


    // $ANTLR start "entryRuleAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:380:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:381:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:382:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute611);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute621); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:389:1: ruleAttribute returns [EObject current=null] : ( () otherlv_1= 'attribute' ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:394:6: ( ( () otherlv_1= 'attribute' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:395:1: ( () otherlv_1= 'attribute' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:395:1: ( () otherlv_1= 'attribute' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:395:2: () otherlv_1= 'attribute'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:395:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:396:5: 
            {
             
                    temp=factory.create(grammarAccess.getAttributeAccess().getAttributeAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getAttributeAccess().getAttributeAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAttribute667); 

                	createLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getAttributeKeyword_1(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


    // $ANTLR start "entryRuleMaster"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:418:1: entryRuleMaster returns [EObject current=null] : iv_ruleMaster= ruleMaster EOF ;
    public final EObject entryRuleMaster() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaster = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:419:2: (iv_ruleMaster= ruleMaster EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:420:2: iv_ruleMaster= ruleMaster EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMasterRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMaster_in_entryRuleMaster703);
            iv_ruleMaster=ruleMaster();

            state._fsp--;

             current =iv_ruleMaster; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaster713); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaster"


    // $ANTLR start "ruleMaster"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:427:1: ruleMaster returns [EObject current=null] : ( () otherlv_1= 'master' ) ;
    public final EObject ruleMaster() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:432:6: ( ( () otherlv_1= 'master' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:433:1: ( () otherlv_1= 'master' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:433:1: ( () otherlv_1= 'master' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:433:2: () otherlv_1= 'master'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:433:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:434:5: 
            {
             
                    temp=factory.create(grammarAccess.getMasterAccess().getMasterAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getMasterAccess().getMasterAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMaster759); 

                	createLeafNode(otherlv_1, grammarAccess.getMasterAccess().getMasterKeyword_1(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaster"


    // $ANTLR start "entryRuleActionAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:456:1: entryRuleActionAttribute returns [EObject current=null] : iv_ruleActionAttribute= ruleActionAttribute EOF ;
    public final EObject entryRuleActionAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionAttribute = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:457:2: (iv_ruleActionAttribute= ruleActionAttribute EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:458:2: iv_ruleActionAttribute= ruleActionAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleActionAttribute_in_entryRuleActionAttribute795);
            iv_ruleActionAttribute=ruleActionAttribute();

            state._fsp--;

             current =iv_ruleActionAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleActionAttribute805); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionAttribute"


    // $ANTLR start "ruleActionAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:465:1: ruleActionAttribute returns [EObject current=null] : ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' ) ;
    public final EObject ruleActionAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_type_6_0=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:470:6: ( ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:471:1: ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:471:1: ( ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:471:2: ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) ) ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) otherlv_8= ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:471:2: ( ( () otherlv_1= 'attribute' ) | ( () otherlv_3= 'master' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            else if ( (LA10_0==20) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:471:3: ( () otherlv_1= 'attribute' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:471:3: ( () otherlv_1= 'attribute' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:471:4: () otherlv_1= 'attribute'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:471:4: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:472:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getActionAttributeAccess().getAttributeAction_0_0_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getActionAttributeAccess().getAttributeAction_0_0_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleActionAttribute853); 

                        	createLeafNode(otherlv_1, grammarAccess.getActionAttributeAccess().getAttributeKeyword_0_0_1(), null);
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:487:6: ( () otherlv_3= 'master' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:487:6: ( () otherlv_3= 'master' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:487:7: () otherlv_3= 'master'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:487:7: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:488:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getActionAttributeAccess().getMasterAction_0_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getActionAttributeAccess().getMasterAction_0_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleActionAttribute882); 

                        	createLeafNode(otherlv_3, grammarAccess.getActionAttributeAccess().getMasterKeyword_0_1_1(), null);
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:502:3: ( (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) ) | ( (lv_type_6_0= RULE_ID ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_ID) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:502:4: (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:502:4: (otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:502:6: otherlv_4= 'ref' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleActionAttribute898); 

                        	createLeafNode(otherlv_4, grammarAccess.getActionAttributeAccess().getRefKeyword_1_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:506:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:507:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:507:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:508:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getActionAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleActionAttribute918); 

                    		createLeafNode(otherlv_5, grammarAccess.getActionAttributeAccess().getTypeRefBaseAttributeCrossReference_1_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:521:6: ( (lv_type_6_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:521:6: ( (lv_type_6_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:522:1: (lv_type_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:522:1: (lv_type_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:523:3: lv_type_6_0= RULE_ID
                    {
                    lv_type_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleActionAttribute942); 

                    			createLeafNode(lv_type_6_0, grammarAccess.getActionAttributeAccess().getTypeIDTerminalRuleCall_1_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getActionAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_6_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:545:3: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:546:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:546:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:547:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleActionAttribute965); 

            			createLeafNode(lv_name_7_0, grammarAccess.getActionAttributeAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getActionAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_7_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_8=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleActionAttribute982); 

                	createLeafNode(otherlv_8, grammarAccess.getActionAttributeAccess().getSemicolonKeyword_3(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionAttribute"


    // $ANTLR start "entryRuleSimpleAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:581:1: entryRuleSimpleAttribute returns [EObject current=null] : iv_ruleSimpleAttribute= ruleSimpleAttribute EOF ;
    public final EObject entryRuleSimpleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAttribute = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:582:2: (iv_ruleSimpleAttribute= ruleSimpleAttribute EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:583:2: iv_ruleSimpleAttribute= ruleSimpleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleAttribute_in_entryRuleSimpleAttribute1018);
            iv_ruleSimpleAttribute=ruleSimpleAttribute();

            state._fsp--;

             current =iv_ruleSimpleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleAttribute1028); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleAttribute"


    // $ANTLR start "ruleSimpleAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:590:1: ruleSimpleAttribute returns [EObject current=null] : ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' ) ;
    public final EObject ruleSimpleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:595:6: ( ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:596:1: ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:596:1: ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:596:2: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:596:2: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:596:3: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:596:3: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:596:5: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSimpleAttribute1067); 

                        	createLeafNode(otherlv_0, grammarAccess.getSimpleAttributeAccess().getRefKeyword_0_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:600:1: ( (otherlv_1= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:601:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:601:1: (otherlv_1= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:602:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSimpleAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAttribute1087); 

                    		createLeafNode(otherlv_1, grammarAccess.getSimpleAttributeAccess().getTypeRefBaseAttributeCrossReference_0_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:615:6: ( (lv_type_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:615:6: ( (lv_type_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:616:1: (lv_type_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:616:1: (lv_type_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:617:3: lv_type_2_0= RULE_ID
                    {
                    lv_type_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAttribute1111); 

                    			createLeafNode(lv_type_2_0, grammarAccess.getSimpleAttributeAccess().getTypeIDTerminalRuleCall_0_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSimpleAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:639:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:640:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:640:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:641:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAttribute1134); 

            			createLeafNode(lv_name_3_0, grammarAccess.getSimpleAttributeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleAttributeRule().getType().getClassifier());
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

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSimpleAttribute1151); 

                	createLeafNode(otherlv_4, grammarAccess.getSimpleAttributeAccess().getSemicolonKeyword_2(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleAttribute"


    // $ANTLR start "entryRuleRuleCallAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:675:1: entryRuleRuleCallAttribute returns [EObject current=null] : iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF ;
    public final EObject entryRuleRuleCallAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallAttribute = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:676:2: (iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:677:2: iv_ruleRuleCallAttribute= ruleRuleCallAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallAttribute_in_entryRuleRuleCallAttribute1187);
            iv_ruleRuleCallAttribute=ruleRuleCallAttribute();

            state._fsp--;

             current =iv_ruleRuleCallAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallAttribute1197); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleCallAttribute"


    // $ANTLR start "ruleRuleCallAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:684:1: ruleRuleCallAttribute returns [EObject current=null] : (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleRuleCallAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject this_CallMe_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:689:6: ( (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:690:1: (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:690:1: (this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:691:5: this_CallMe_0= ruleCallMe ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRuleCallAttributeAccess().getCallMeParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCallMe_in_ruleRuleCallAttribute1244);
            this_CallMe_0=ruleCallMe();

            state._fsp--;

             
                    current = this_CallMe_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:699:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:700:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:700:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:701:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallAttribute1260); 

            			createLeafNode(lv_name_1_0, grammarAccess.getRuleCallAttributeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRuleCallAttributeRule().getType().getClassifier());
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

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleRuleCallAttribute1277); 

                	createLeafNode(otherlv_2, grammarAccess.getRuleCallAttributeAccess().getSemicolonKeyword_2(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleCallAttribute"


    // $ANTLR start "entryRuleCallMe"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:735:1: entryRuleCallMe returns [EObject current=null] : iv_ruleCallMe= ruleCallMe EOF ;
    public final EObject entryRuleCallMe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:736:2: (iv_ruleCallMe= ruleCallMe EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:737:2: iv_ruleCallMe= ruleCallMe EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallMeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCallMe_in_entryRuleCallMe1313);
            iv_ruleCallMe=ruleCallMe();

            state._fsp--;

             current =iv_ruleCallMe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallMe1323); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallMe"


    // $ANTLR start "ruleCallMe"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:744:1: ruleCallMe returns [EObject current=null] : ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) ;
    public final EObject ruleCallMe() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:749:6: ( ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:750:1: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:750:1: ( (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) ) | ( (lv_type_2_0= RULE_ID ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:750:2: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:750:2: (otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:750:4: otherlv_0= 'ref' ( (otherlv_1= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleCallMe1361); 

                        	createLeafNode(otherlv_0, grammarAccess.getCallMeAccess().getRefKeyword_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:754:1: ( (otherlv_1= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:755:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:755:1: (otherlv_1= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:756:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getCallMeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCallMe1381); 

                    		createLeafNode(otherlv_1, grammarAccess.getCallMeAccess().getTypeRefBaseAttributeCrossReference_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:769:6: ( (lv_type_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:769:6: ( (lv_type_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:770:1: (lv_type_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:770:1: (lv_type_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:771:3: lv_type_2_0= RULE_ID
                    {
                    lv_type_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCallMe1405); 

                    			createLeafNode(lv_type_2_0, grammarAccess.getCallMeAccess().getTypeIDTerminalRuleCall_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCallMeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallMe"


    // $ANTLR start "entryRuleRuleCallAttribute2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:801:1: entryRuleRuleCallAttribute2 returns [EObject current=null] : iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF ;
    public final EObject entryRuleRuleCallAttribute2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallAttribute2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:802:2: (iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:803:2: iv_ruleRuleCallAttribute2= ruleRuleCallAttribute2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallAttribute2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallAttribute2_in_entryRuleRuleCallAttribute21446);
            iv_ruleRuleCallAttribute2=ruleRuleCallAttribute2();

            state._fsp--;

             current =iv_ruleRuleCallAttribute2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallAttribute21456); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleCallAttribute2"


    // $ANTLR start "ruleRuleCallAttribute2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:810:1: ruleRuleCallAttribute2 returns [EObject current=null] : (this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) ;
    public final EObject ruleRuleCallAttribute2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token otherlv_4=null;
        EObject this_CallMe2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:815:6: ( (this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:816:1: (this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:816:1: (this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:817:5: this_CallMe2_0= ruleCallMe2 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRuleCallAttribute2Access().getCallMe2ParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCallMe2_in_ruleRuleCallAttribute21503);
            this_CallMe2_0=ruleCallMe2();

            state._fsp--;

             
                    current = this_CallMe2_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:825:1: ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==17) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:825:2: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:825:2: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:825:4: otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleCallAttribute21516); 

                        	createLeafNode(otherlv_1, grammarAccess.getRuleCallAttribute2Access().getRefKeyword_1_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:829:1: ( (otherlv_2= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:830:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:830:1: (otherlv_2= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:831:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleCallAttribute2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallAttribute21536); 

                    		createLeafNode(otherlv_2, grammarAccess.getRuleCallAttribute2Access().getTypeRefBaseAttributeCrossReference_1_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:844:6: ( (lv_type_3_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:844:6: ( (lv_type_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:845:1: (lv_type_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:845:1: (lv_type_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:846:3: lv_type_3_0= RULE_ID
                    {
                    lv_type_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallAttribute21560); 

                    			createLeafNode(lv_type_3_0, grammarAccess.getRuleCallAttribute2Access().getTypeIDTerminalRuleCall_1_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleCallAttribute2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleRuleCallAttribute21578); 

                	createLeafNode(otherlv_4, grammarAccess.getRuleCallAttribute2Access().getSemicolonKeyword_2(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleCallAttribute2"


    // $ANTLR start "entryRuleCallMe2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:880:1: entryRuleCallMe2 returns [EObject current=null] : iv_ruleCallMe2= ruleCallMe2 EOF ;
    public final EObject entryRuleCallMe2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:881:2: (iv_ruleCallMe2= ruleCallMe2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:882:2: iv_ruleCallMe2= ruleCallMe2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallMe2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCallMe2_in_entryRuleCallMe21614);
            iv_ruleCallMe2=ruleCallMe2();

            state._fsp--;

             current =iv_ruleCallMe2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallMe21624); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallMe2"


    // $ANTLR start "ruleCallMe2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:889:1: ruleCallMe2 returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleCallMe2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:894:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:895:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:895:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:896:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:896:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:897:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCallMe21665); 

            			createLeafNode(lv_name_0_0, grammarAccess.getCallMe2Access().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCallMe2Rule().getType().getClassifier());
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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallMe2"


    // $ANTLR start "entryRuleRuleCallAttribute3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:927:1: entryRuleRuleCallAttribute3 returns [EObject current=null] : iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF ;
    public final EObject entryRuleRuleCallAttribute3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallAttribute3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:928:2: (iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:929:2: iv_ruleRuleCallAttribute3= ruleRuleCallAttribute3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallAttribute3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallAttribute3_in_entryRuleRuleCallAttribute31705);
            iv_ruleRuleCallAttribute3=ruleRuleCallAttribute3();

            state._fsp--;

             current =iv_ruleRuleCallAttribute3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallAttribute31715); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleCallAttribute3"


    // $ANTLR start "ruleRuleCallAttribute3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:936:1: ruleRuleCallAttribute3 returns [EObject current=null] : (this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) ;
    public final EObject ruleRuleCallAttribute3() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token otherlv_4=null;
        EObject this_CallMe3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:941:6: ( (this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:942:1: (this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:942:1: (this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:943:5: this_CallMe3_0= ruleCallMe3 ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) ) otherlv_4= ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRuleCallAttribute3Access().getCallMe3ParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCallMe3_in_ruleRuleCallAttribute31762);
            this_CallMe3_0=ruleCallMe3();

            state._fsp--;

             
                    current = this_CallMe3_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:951:1: ( (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) ) | ( (lv_type_3_0= RULE_ID ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==17) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ID) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:951:2: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:951:2: (otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:951:4: otherlv_1= 'ref' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleCallAttribute31775); 

                        	createLeafNode(otherlv_1, grammarAccess.getRuleCallAttribute3Access().getRefKeyword_1_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:955:1: ( (otherlv_2= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:956:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:956:1: (otherlv_2= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:957:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleCallAttribute3Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallAttribute31795); 

                    		createLeafNode(otherlv_2, grammarAccess.getRuleCallAttribute3Access().getTypeRefBaseAttributeCrossReference_1_0_1_0(), "typeRef"); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:970:6: ( (lv_type_3_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:970:6: ( (lv_type_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:971:1: (lv_type_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:971:1: (lv_type_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:972:3: lv_type_3_0= RULE_ID
                    {
                    lv_type_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallAttribute31819); 

                    			createLeafNode(lv_type_3_0, grammarAccess.getRuleCallAttribute3Access().getTypeIDTerminalRuleCall_1_1_0(), "type"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleCallAttribute3Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleRuleCallAttribute31837); 

                	createLeafNode(otherlv_4, grammarAccess.getRuleCallAttribute3Access().getSemicolonKeyword_2(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleCallAttribute3"


    // $ANTLR start "entryRuleCallMe3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1006:1: entryRuleCallMe3 returns [EObject current=null] : iv_ruleCallMe3= ruleCallMe3 EOF ;
    public final EObject entryRuleCallMe3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1007:2: (iv_ruleCallMe3= ruleCallMe3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1008:2: iv_ruleCallMe3= ruleCallMe3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallMe3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCallMe3_in_entryRuleCallMe31873);
            iv_ruleCallMe3=ruleCallMe3();

            state._fsp--;

             current =iv_ruleCallMe3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallMe31883); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallMe3"


    // $ANTLR start "ruleCallMe3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1015:1: ruleCallMe3 returns [EObject current=null] : (otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4 ) ;
    public final EObject ruleCallMe3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_CallMe4_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1020:6: ( (otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1021:1: (otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1021:1: (otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1021:3: otherlv_0= 'call' otherlv_1= 'me' this_CallMe4_2= ruleCallMe4
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleCallMe31920); 

                	createLeafNode(otherlv_0, grammarAccess.getCallMe3Access().getCallKeyword_0(), null);
                
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCallMe31932); 

                	createLeafNode(otherlv_1, grammarAccess.getCallMe3Access().getMeKeyword_1(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getCallMe3Access().getCallMe4ParserRuleCall_2(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCallMe4_in_ruleCallMe31954);
            this_CallMe4_2=ruleCallMe4();

            state._fsp--;

             
                    current = this_CallMe4_2; 
                    currentNode = currentNode.getParent();
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallMe3"


    // $ANTLR start "entryRuleCallMe4"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1046:1: entryRuleCallMe4 returns [EObject current=null] : iv_ruleCallMe4= ruleCallMe4 EOF ;
    public final EObject entryRuleCallMe4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallMe4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1047:2: (iv_ruleCallMe4= ruleCallMe4 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1048:2: iv_ruleCallMe4= ruleCallMe4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallMe4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCallMe4_in_entryRuleCallMe41989);
            iv_ruleCallMe4=ruleCallMe4();

            state._fsp--;

             current =iv_ruleCallMe4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallMe41999); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallMe4"


    // $ANTLR start "ruleCallMe4"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1055:1: ruleCallMe4 returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleCallMe4() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1060:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1061:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1061:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1062:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1062:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug287988TestLanguage.g:1063:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCallMe42040); 

            			createLeafNode(lv_name_0_0, grammarAccess.getCallMe4Access().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCallMe4Rule().getType().getClassifier());
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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallMe4"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel123 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_ruleBaseAttribute_in_ruleModel144 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_12_in_ruleModel165 = new BitSet(new long[]{0x0000000000020012L});
        public static final BitSet FOLLOW_ruleSimpleAttribute_in_ruleModel186 = new BitSet(new long[]{0x0000000000020012L});
        public static final BitSet FOLLOW_13_in_ruleModel207 = new BitSet(new long[]{0x0000000000020012L});
        public static final BitSet FOLLOW_ruleRuleCallAttribute_in_ruleModel228 = new BitSet(new long[]{0x0000000000020012L});
        public static final BitSet FOLLOW_14_in_ruleModel249 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleRuleCallAttribute2_in_ruleModel270 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_15_in_ruleModel291 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleRuleCallAttribute3_in_ruleModel312 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_16_in_ruleModel333 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_ruleActionAttribute_in_ruleModel354 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_ruleBaseAttribute_in_entryRuleBaseAttribute392 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBaseAttribute402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleBaseAttribute450 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleMaster_in_ruleBaseAttribute477 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_17_in_ruleBaseAttribute491 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBaseAttribute511 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBaseAttribute535 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBaseAttribute558 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleBaseAttribute575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute611 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleAttribute667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaster_in_entryRuleMaster703 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaster713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleMaster759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleActionAttribute_in_entryRuleActionAttribute795 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleActionAttribute805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleActionAttribute853 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_20_in_ruleActionAttribute882 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_17_in_ruleActionAttribute898 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleActionAttribute918 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleActionAttribute942 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleActionAttribute965 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleActionAttribute982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAttribute_in_entryRuleSimpleAttribute1018 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAttribute1028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSimpleAttribute1067 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAttribute1087 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAttribute1111 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAttribute1134 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleSimpleAttribute1151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallAttribute_in_entryRuleRuleCallAttribute1187 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallAttribute1197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe_in_ruleRuleCallAttribute1244 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute1260 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleRuleCallAttribute1277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe_in_entryRuleCallMe1313 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallMe1323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleCallMe1361 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCallMe1381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCallMe1405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallAttribute2_in_entryRuleRuleCallAttribute21446 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallAttribute21456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe2_in_ruleRuleCallAttribute21503 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_17_in_ruleRuleCallAttribute21516 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute21536 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute21560 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleRuleCallAttribute21578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe2_in_entryRuleCallMe21614 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallMe21624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCallMe21665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallAttribute3_in_entryRuleRuleCallAttribute31705 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallAttribute31715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe3_in_ruleRuleCallAttribute31762 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_17_in_ruleRuleCallAttribute31775 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute31795 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallAttribute31819 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleRuleCallAttribute31837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe3_in_entryRuleCallMe31873 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallMe31883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleCallMe31920 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleCallMe31932 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleCallMe4_in_ruleCallMe31954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallMe4_in_entryRuleCallMe41989 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallMe41999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCallMe42040 = new BitSet(new long[]{0x0000000000000002L});
    }


}