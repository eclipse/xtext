package org.eclipse.xtext.ui.common.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.common.editor.contentassist.services.LookAheadContentAssistTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLookAheadContentAssistTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'['", "']'", "'<'", "'>'", "'{'", "'}'", "'='"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalLookAheadContentAssistTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g"; }


     
     	private LookAheadContentAssistTestLanguageGrammarAccess grammarAccess;
     	
        public InternalLookAheadContentAssistTestLanguageParser(TokenStream input, IAstFactory factory, LookAheadContentAssistTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel83); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( ( '(' ( (lv_attribute_1_0= ruleAttribute ) )* ( (lv_attribute_2_0= rulePair ) )* ')' ) | ( '[' ( (lv_attribute_5_0= ruleAttribute ) )+ ( (lv_attribute_6_0= rulePair ) )* ']' ) | ( '<' ( (lv_attribute_9_0= ruleAttribute ) )* ( (lv_attribute_10_0= rulePair ) )+ '>' ) | ( '{' ( (lv_attribute_13_0= ruleAttribute ) )+ ( (lv_attribute_14_0= rulePair ) )+ '}' ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_attribute_1_0 = null;

        EObject lv_attribute_2_0 = null;

        EObject lv_attribute_5_0 = null;

        EObject lv_attribute_6_0 = null;

        EObject lv_attribute_9_0 = null;

        EObject lv_attribute_10_0 = null;

        EObject lv_attribute_13_0 = null;

        EObject lv_attribute_14_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:85:6: ( ( ( '(' ( (lv_attribute_1_0= ruleAttribute ) )* ( (lv_attribute_2_0= rulePair ) )* ')' ) | ( '[' ( (lv_attribute_5_0= ruleAttribute ) )+ ( (lv_attribute_6_0= rulePair ) )* ']' ) | ( '<' ( (lv_attribute_9_0= ruleAttribute ) )* ( (lv_attribute_10_0= rulePair ) )+ '>' ) | ( '{' ( (lv_attribute_13_0= ruleAttribute ) )+ ( (lv_attribute_14_0= rulePair ) )+ '}' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:86:1: ( ( '(' ( (lv_attribute_1_0= ruleAttribute ) )* ( (lv_attribute_2_0= rulePair ) )* ')' ) | ( '[' ( (lv_attribute_5_0= ruleAttribute ) )+ ( (lv_attribute_6_0= rulePair ) )* ']' ) | ( '<' ( (lv_attribute_9_0= ruleAttribute ) )* ( (lv_attribute_10_0= rulePair ) )+ '>' ) | ( '{' ( (lv_attribute_13_0= ruleAttribute ) )+ ( (lv_attribute_14_0= rulePair ) )+ '}' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:86:1: ( ( '(' ( (lv_attribute_1_0= ruleAttribute ) )* ( (lv_attribute_2_0= rulePair ) )* ')' ) | ( '[' ( (lv_attribute_5_0= ruleAttribute ) )+ ( (lv_attribute_6_0= rulePair ) )* ']' ) | ( '<' ( (lv_attribute_9_0= ruleAttribute ) )* ( (lv_attribute_10_0= rulePair ) )+ '>' ) | ( '{' ( (lv_attribute_13_0= ruleAttribute ) )+ ( (lv_attribute_14_0= rulePair ) )+ '}' ) )
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
                    new NoViableAltException("86:1: ( ( '(' ( (lv_attribute_1_0= ruleAttribute ) )* ( (lv_attribute_2_0= rulePair ) )* ')' ) | ( '[' ( (lv_attribute_5_0= ruleAttribute ) )+ ( (lv_attribute_6_0= rulePair ) )* ']' ) | ( '<' ( (lv_attribute_9_0= ruleAttribute ) )* ( (lv_attribute_10_0= rulePair ) )+ '>' ) | ( '{' ( (lv_attribute_13_0= ruleAttribute ) )+ ( (lv_attribute_14_0= rulePair ) )+ '}' ) )", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:86:2: ( '(' ( (lv_attribute_1_0= ruleAttribute ) )* ( (lv_attribute_2_0= rulePair ) )* ')' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:86:2: ( '(' ( (lv_attribute_1_0= ruleAttribute ) )* ( (lv_attribute_2_0= rulePair ) )* ')' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:86:3: '(' ( (lv_attribute_1_0= ruleAttribute ) )* ( (lv_attribute_2_0= rulePair ) )* ')'
                    {
                    match(input,11,FOLLOW_11_in_ruleModel118); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftParenthesisKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:90:1: ( (lv_attribute_1_0= ruleAttribute ) )*
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:91:1: (lv_attribute_1_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:91:1: (lv_attribute_1_0= ruleAttribute )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:92:3: lv_attribute_1_0= ruleAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_0_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleModel139);
                    	    lv_attribute_1_0=ruleAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attribute",
                    	    	        		lv_attribute_1_0, 
                    	    	        		"Attribute", 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:114:3: ( (lv_attribute_2_0= rulePair ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:115:1: (lv_attribute_2_0= rulePair )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:115:1: (lv_attribute_2_0= rulePair )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:116:3: lv_attribute_2_0= rulePair
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributePairParserRuleCall_0_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePair_in_ruleModel161);
                    	    lv_attribute_2_0=rulePair();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attribute",
                    	    	        		lv_attribute_2_0, 
                    	    	        		"Pair", 
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

                    match(input,12,FOLLOW_12_in_ruleModel171); 

                            createLeafNode(grammarAccess.getModelAccess().getRightParenthesisKeyword_0_3(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:143:6: ( '[' ( (lv_attribute_5_0= ruleAttribute ) )+ ( (lv_attribute_6_0= rulePair ) )* ']' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:143:6: ( '[' ( (lv_attribute_5_0= ruleAttribute ) )+ ( (lv_attribute_6_0= rulePair ) )* ']' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:143:7: '[' ( (lv_attribute_5_0= ruleAttribute ) )+ ( (lv_attribute_6_0= rulePair ) )* ']'
                    {
                    match(input,13,FOLLOW_13_in_ruleModel188); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftSquareBracketKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:147:1: ( (lv_attribute_5_0= ruleAttribute ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:148:1: (lv_attribute_5_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:148:1: (lv_attribute_5_0= ruleAttribute )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:149:3: lv_attribute_5_0= ruleAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleModel209);
                    	    lv_attribute_5_0=ruleAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attribute",
                    	    	        		lv_attribute_5_0, 
                    	    	        		"Attribute", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:171:3: ( (lv_attribute_6_0= rulePair ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:172:1: (lv_attribute_6_0= rulePair )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:172:1: (lv_attribute_6_0= rulePair )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:173:3: lv_attribute_6_0= rulePair
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributePairParserRuleCall_1_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePair_in_ruleModel231);
                    	    lv_attribute_6_0=rulePair();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attribute",
                    	    	        		lv_attribute_6_0, 
                    	    	        		"Pair", 
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

                    match(input,14,FOLLOW_14_in_ruleModel241); 

                            createLeafNode(grammarAccess.getModelAccess().getRightSquareBracketKeyword_1_3(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:200:6: ( '<' ( (lv_attribute_9_0= ruleAttribute ) )* ( (lv_attribute_10_0= rulePair ) )+ '>' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:200:6: ( '<' ( (lv_attribute_9_0= ruleAttribute ) )* ( (lv_attribute_10_0= rulePair ) )+ '>' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:200:7: '<' ( (lv_attribute_9_0= ruleAttribute ) )* ( (lv_attribute_10_0= rulePair ) )+ '>'
                    {
                    match(input,15,FOLLOW_15_in_ruleModel258); 

                            createLeafNode(grammarAccess.getModelAccess().getLessThanSignKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:204:1: ( (lv_attribute_9_0= ruleAttribute ) )*
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:205:1: (lv_attribute_9_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:205:1: (lv_attribute_9_0= ruleAttribute )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:206:3: lv_attribute_9_0= ruleAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleModel279);
                    	    lv_attribute_9_0=ruleAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attribute",
                    	    	        		lv_attribute_9_0, 
                    	    	        		"Attribute", 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:228:3: ( (lv_attribute_10_0= rulePair ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:229:1: (lv_attribute_10_0= rulePair )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:229:1: (lv_attribute_10_0= rulePair )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:230:3: lv_attribute_10_0= rulePair
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributePairParserRuleCall_2_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePair_in_ruleModel301);
                    	    lv_attribute_10_0=rulePair();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attribute",
                    	    	        		lv_attribute_10_0, 
                    	    	        		"Pair", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

                    match(input,16,FOLLOW_16_in_ruleModel311); 

                            createLeafNode(grammarAccess.getModelAccess().getGreaterThanSignKeyword_2_3(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:257:6: ( '{' ( (lv_attribute_13_0= ruleAttribute ) )+ ( (lv_attribute_14_0= rulePair ) )+ '}' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:257:6: ( '{' ( (lv_attribute_13_0= ruleAttribute ) )+ ( (lv_attribute_14_0= rulePair ) )+ '}' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:257:7: '{' ( (lv_attribute_13_0= ruleAttribute ) )+ ( (lv_attribute_14_0= rulePair ) )+ '}'
                    {
                    match(input,17,FOLLOW_17_in_ruleModel328); 

                            createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:261:1: ( (lv_attribute_13_0= ruleAttribute ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:262:1: (lv_attribute_13_0= ruleAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:262:1: (lv_attribute_13_0= ruleAttribute )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:263:3: lv_attribute_13_0= ruleAttribute
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_3_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleModel349);
                    	    lv_attribute_13_0=ruleAttribute();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attribute",
                    	    	        		lv_attribute_13_0, 
                    	    	        		"Attribute", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:285:3: ( (lv_attribute_14_0= rulePair ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:286:1: (lv_attribute_14_0= rulePair )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:286:1: (lv_attribute_14_0= rulePair )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:287:3: lv_attribute_14_0= rulePair
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getAttributePairParserRuleCall_3_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePair_in_ruleModel371);
                    	    lv_attribute_14_0=rulePair();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"attribute",
                    	    	        		lv_attribute_14_0, 
                    	    	        		"Pair", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

                    match(input,18,FOLLOW_18_in_ruleModel381); 

                            createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_3_3(), null); 
                        

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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:320:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:320:51: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:321:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute415);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute425); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAttribute


    // $ANTLR start ruleAttribute
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:328:1: ruleAttribute returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:333:6: ( ( (lv_value_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:334:1: ( (lv_value_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:334:1: ( (lv_value_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:335:1: (lv_value_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:335:1: (lv_value_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:336:3: lv_value_0_0= RULE_ID
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute466); 

            			createLeafNode(grammarAccess.getAttributeAccess().getValueIDTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
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
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRulePair
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:365:1: entryRulePair returns [EObject current=null] : iv_rulePair= rulePair EOF ;
    public final EObject entryRulePair() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePair = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:365:46: (iv_rulePair= rulePair EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:366:2: iv_rulePair= rulePair EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPairRule(), currentNode); 
            pushFollow(FOLLOW_rulePair_in_entryRulePair503);
            iv_rulePair=rulePair();
            _fsp--;

             current =iv_rulePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePair513); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePair


    // $ANTLR start rulePair
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:373:1: rulePair returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= RULE_ID ) ) ) ;
    public final EObject rulePair() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_value_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:378:6: ( ( ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:379:1: ( ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:379:1: ( ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:379:2: ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_value_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:379:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:380:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:380:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:381:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePair555); 

            			createLeafNode(grammarAccess.getPairAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPairRule().getType().getClassifier());
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

            match(input,19,FOLLOW_19_in_rulePair569); 

                    createLeafNode(grammarAccess.getPairAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:407:1: ( (lv_value_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:408:1: (lv_value_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:408:1: (lv_value_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:409:3: lv_value_2_0= RULE_ID
            {
            lv_value_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePair586); 

            			createLeafNode(grammarAccess.getPairAccess().getValueIDTerminalRuleCall_2_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPairRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end rulePair


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel118 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleModel139 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rulePair_in_ruleModel161 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleModel171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModel188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleModel209 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_rulePair_in_ruleModel231 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleModel241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleModel258 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleModel279 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePair_in_ruleModel301 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_ruleModel311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleModel328 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleModel349 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePair_in_ruleModel371 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleModel381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute415 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePair_in_entryRulePair503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePair513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePair555 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePair569 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePair586 = new BitSet(new long[]{0x0000000000000002L});

}