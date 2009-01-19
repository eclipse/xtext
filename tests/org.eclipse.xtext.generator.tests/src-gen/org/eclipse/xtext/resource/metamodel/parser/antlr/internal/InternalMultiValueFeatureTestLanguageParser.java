// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g 2009-01-19 15:14:08

package org.eclipse.xtext.resource.metamodel.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalMultiValueFeatureTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalMultiValueFeatureTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g"; }


     
        public InternalMultiValueFeatureTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalMultiValueFeatureTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Start";	
       	} 



    // $ANTLR start entryRuleStart
    // ./src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g:67:1: entryRuleStart returns [EObject current=null] : iv_ruleStart= ruleStart EOF ;
    public final EObject entryRuleStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStart = null;


        try {
            // ./src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g:67:47: (iv_ruleStart= ruleStart EOF )
            // ./src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g:68:2: iv_ruleStart= ruleStart EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/resource/metamodel/MultiValueFeatureTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleStart_in_entryRuleStart72);
            iv_ruleStart=ruleStart();
            _fsp--;

             current =iv_ruleStart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStart82); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStart


    // $ANTLR start ruleStart
    // ./src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g:75:1: ruleStart returns [EObject current=null] : (lv_featureA= RULE_ID )+ ;
    public final EObject ruleStart() throws RecognitionException {
        EObject current = null;

        Token lv_featureA=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g:77:33: ( (lv_featureA= RULE_ID )+ )
            // ./src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g:78:1: (lv_featureA= RULE_ID )+
            {
            // ./src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g:78:1: (lv_featureA= RULE_ID )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/resource/metamodel/parser/antlr/internal/InternalMultiValueFeatureTestLanguage.g:80:6: lv_featureA= RULE_ID
            	    {
            	    lv_featureA=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStart127); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/resource/metamodel/MultiValueFeatureTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, "featureA"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("Start");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "featureA", lv_featureA, "ID", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStart


 

    public static final BitSet FOLLOW_ruleStart_in_entryRuleStart72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStart82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStart127 = new BitSet(new long[]{0x0000000000000012L});

}