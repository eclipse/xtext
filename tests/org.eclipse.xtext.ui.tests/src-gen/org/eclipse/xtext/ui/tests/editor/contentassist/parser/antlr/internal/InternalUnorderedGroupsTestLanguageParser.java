package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.UnorderedGroupsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalUnorderedGroupsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'public'", "'private'", "'protected'", "'static'", "'synchronized'", "'abstract'", "'final'", "'class'", "'{'", "'}'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalUnorderedGroupsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g"; }



     	private UnorderedGroupsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalUnorderedGroupsTestLanguageParser(TokenStream input, IAstFactory factory, UnorderedGroupsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:73:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:74:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token lv_name_7_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        	  boolean[] pred_0 = new boolean[4];

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:88:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:89:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:89:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:89:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:89:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:91:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:91:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:92:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* )
            {
             
            	  pred_0 = new boolean[4];
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:95:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:96:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:96:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )*
            loop3:
            do {
                int alt3=5;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=11 && LA3_0<=13)) && (!pred_0[0])) {
                    alt3=1;
                }
                else if ( (LA3_0==14) && (!pred_0[1])) {
                    alt3=2;
                }
                else if ( (LA3_0==15) && (!pred_0[2])) {
                    alt3=3;
                }
                else if ( ((LA3_0>=16 && LA3_0<=17)) && (!pred_0[3])) {
                    alt3=4;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:98:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:98:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:99:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {
            	    if ( !(!pred_0[0]) ) {
            	        throw new FailedPredicateException(input, "ruleModel", "!pred_0[0]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:99:20: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:100:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	     
            	    	 				  pred_0[0] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:104:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:105:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:105:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:106:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:106:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    int alt1=3;
            	    switch ( input.LA(1) ) {
            	    case 11:
            	        {
            	        alt1=1;
            	        }
            	        break;
            	    case 12:
            	        {
            	        alt1=2;
            	        }
            	        break;
            	    case 13:
            	        {
            	        alt1=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("106:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 1, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt1) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:107:3: lv_visibility_1_1= 'public'
            	            {
            	            lv_visibility_1_1=(Token)input.LT(1);
            	            match(input,11,FollowSets000.FOLLOW_11_in_ruleModel172); 

            	                    createLeafNode(grammarAccess.getModelAccess().getVisibilityPublicKeyword_0_0_0_0(), "visibility"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "visibility", lv_visibility_1_1, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:125:8: lv_visibility_1_2= 'private'
            	            {
            	            lv_visibility_1_2=(Token)input.LT(1);
            	            match(input,12,FollowSets000.FOLLOW_12_in_ruleModel201); 

            	                    createLeafNode(grammarAccess.getModelAccess().getVisibilityPrivateKeyword_0_0_0_1(), "visibility"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "visibility", lv_visibility_1_2, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:143:8: lv_visibility_1_3= 'protected'
            	            {
            	            lv_visibility_1_3=(Token)input.LT(1);
            	            match(input,13,FollowSets000.FOLLOW_13_in_ruleModel230); 

            	                    createLeafNode(grammarAccess.getModelAccess().getVisibilityProtectedKeyword_0_0_0_2(), "visibility"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "visibility", lv_visibility_1_3, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:168:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:168:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:169:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    {
            	    if ( !(!pred_0[1]) ) {
            	        throw new FailedPredicateException(input, "ruleModel", "!pred_0[1]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:169:20: ( ( (lv_static_2_0= 'static' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:170:6: ( (lv_static_2_0= 'static' ) )
            	    {
            	     
            	    	 				  pred_0[1] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:174:6: ( (lv_static_2_0= 'static' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:175:1: (lv_static_2_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:175:1: (lv_static_2_0= 'static' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:176:3: lv_static_2_0= 'static'
            	    {
            	    lv_static_2_0=(Token)input.LT(1);
            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleModel307); 

            	            createLeafNode(grammarAccess.getModelAccess().getStaticStaticKeyword_0_1_0(), "static"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "static", true, "static", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:199:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:199:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:200:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {
            	    if ( !(!pred_0[2]) ) {
            	        throw new FailedPredicateException(input, "ruleModel", "!pred_0[2]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:200:20: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:201:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	     
            	    	 				  pred_0[2] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:205:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:206:1: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:206:1: (lv_synchronized_3_0= 'synchronized' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:207:3: lv_synchronized_3_0= 'synchronized'
            	    {
            	    lv_synchronized_3_0=(Token)input.LT(1);
            	    match(input,15,FollowSets000.FOLLOW_15_in_ruleModel381); 

            	            createLeafNode(grammarAccess.getModelAccess().getSynchronizedSynchronizedKeyword_0_2_0(), "synchronized"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "synchronized", true, "synchronized", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:230:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:230:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:231:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {
            	    if ( !(!pred_0[3]) ) {
            	        throw new FailedPredicateException(input, "ruleModel", "!pred_0[3]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:231:20: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:232:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	     
            	    	 				  pred_0[3] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:236:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==16) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==17) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("236:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:236:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:236:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:237:1: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:237:1: (lv_abstract_4_0= 'abstract' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:238:3: lv_abstract_4_0= 'abstract'
            	            {
            	            lv_abstract_4_0=(Token)input.LT(1);
            	            match(input,16,FollowSets000.FOLLOW_16_in_ruleModel456); 

            	                    createLeafNode(grammarAccess.getModelAccess().getAbstractAbstractKeyword_0_3_0_0(), "abstract"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "abstract", true, "abstract", lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:258:6: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:258:6: ( (lv_final_5_0= 'final' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:259:1: (lv_final_5_0= 'final' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:259:1: (lv_final_5_0= 'final' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:260:3: lv_final_5_0= 'final'
            	            {
            	            lv_final_5_0=(Token)input.LT(1);
            	            match(input,17,FollowSets000.FOLLOW_17_in_ruleModel493); 

            	                    createLeafNode(grammarAccess.getModelAccess().getFinalFinalKeyword_0_3_1_0(), "final"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "final", true, "final", lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             
            	  pred_0 = new boolean[4];
            	

            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleModel549); 

                    createLeafNode(grammarAccess.getModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:294:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:295:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:295:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:296:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel566); 

            			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
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

            match(input,19,FollowSets000.FOLLOW_19_in_ruleModel581); 

                    createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,20,FollowSets000.FOLLOW_20_in_ruleModel591); 

                    createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_4(), null); 
                

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel172 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_12_in_ruleModel201 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_13_in_ruleModel230 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_14_in_ruleModel307 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_15_in_ruleModel381 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_16_in_ruleModel456 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_17_in_ruleModel493 = new BitSet(new long[]{0x000000000007F800L});
        public static final BitSet FOLLOW_18_in_ruleModel549 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel566 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleModel581 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleModel591 = new BitSet(new long[]{0x0000000000000002L});
    }


}