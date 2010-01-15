package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

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
import org.eclipse.xtext.parsetree.reconstr.services.Bug299395TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug299395TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'['", "']'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug299395TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g"; }



     	private Bug299395TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug299395TestLanguageParser(TokenStream input, IAstFactory factory, Bug299395TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:73:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:74:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( () ( '{' ( (lv_unused_2_0= RULE_STRING ) )? '}' )* ( '[' ( ( (lv_key_5_0= RULE_STRING ) ) ( (lv_value_6_0= RULE_STRING ) ) )* ']' )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_unused_2_0=null;
        Token lv_key_5_0=null;
        Token lv_value_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:86:6: ( ( () ( '{' ( (lv_unused_2_0= RULE_STRING ) )? '}' )* ( '[' ( ( (lv_key_5_0= RULE_STRING ) ) ( (lv_value_6_0= RULE_STRING ) ) )* ']' )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:87:1: ( () ( '{' ( (lv_unused_2_0= RULE_STRING ) )? '}' )* ( '[' ( ( (lv_key_5_0= RULE_STRING ) ) ( (lv_value_6_0= RULE_STRING ) ) )* ']' )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:87:1: ( () ( '{' ( (lv_unused_2_0= RULE_STRING ) )? '}' )* ( '[' ( ( (lv_key_5_0= RULE_STRING ) ) ( (lv_value_6_0= RULE_STRING ) ) )* ']' )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:87:2: () ( '{' ( (lv_unused_2_0= RULE_STRING ) )? '}' )* ( '[' ( ( (lv_key_5_0= RULE_STRING ) ) ( (lv_value_6_0= RULE_STRING ) ) )* ']' )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:87:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:88:5: 
            {
             
                    temp=factory.create(grammarAccess.getModelAccess().getModelAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getModelAccess().getModelAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:98:2: ( '{' ( (lv_unused_2_0= RULE_STRING ) )? '}' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:98:4: '{' ( (lv_unused_2_0= RULE_STRING ) )? '}'
            	    {
            	    match(input,11,FollowSets000.FOLLOW_11_in_ruleModel130); 

            	            createLeafNode(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:102:1: ( (lv_unused_2_0= RULE_STRING ) )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==RULE_STRING) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:103:1: (lv_unused_2_0= RULE_STRING )
            	            {
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:103:1: (lv_unused_2_0= RULE_STRING )
            	            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:104:3: lv_unused_2_0= RULE_STRING
            	            {
            	            lv_unused_2_0=(Token)input.LT(1);
            	            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel147); 

            	            			createLeafNode(grammarAccess.getModelAccess().getUnusedSTRINGTerminalRuleCall_1_1_0(), "unused"); 
            	            		

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        try {
            	            	       		add(
            	            	       			current, 
            	            	       			"unused",
            	            	        		lv_unused_2_0, 
            	            	        		"STRING", 
            	            	        		lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }


            	            }
            	            break;

            	    }

            	    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel163); 

            	            createLeafNode(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_2(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:130:3: ( '[' ( ( (lv_key_5_0= RULE_STRING ) ) ( (lv_value_6_0= RULE_STRING ) ) )* ']' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:130:5: '[' ( ( (lv_key_5_0= RULE_STRING ) ) ( (lv_value_6_0= RULE_STRING ) ) )* ']'
            	    {
            	    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel176); 

            	            createLeafNode(grammarAccess.getModelAccess().getLeftSquareBracketKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:134:1: ( ( (lv_key_5_0= RULE_STRING ) ) ( (lv_value_6_0= RULE_STRING ) ) )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==RULE_STRING) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:134:2: ( (lv_key_5_0= RULE_STRING ) ) ( (lv_value_6_0= RULE_STRING ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:134:2: ( (lv_key_5_0= RULE_STRING ) )
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:135:1: (lv_key_5_0= RULE_STRING )
            	    	    {
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:135:1: (lv_key_5_0= RULE_STRING )
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:136:3: lv_key_5_0= RULE_STRING
            	    	    {
            	    	    lv_key_5_0=(Token)input.LT(1);
            	    	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel194); 

            	    	    			createLeafNode(grammarAccess.getModelAccess().getKeySTRINGTerminalRuleCall_2_1_0_0(), "key"); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode, current);
            	    	    	        }
            	    	    	        try {
            	    	    	       		add(
            	    	    	       			current, 
            	    	    	       			"key",
            	    	    	        		lv_key_5_0, 
            	    	    	        		"STRING", 
            	    	    	        		lastConsumedNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	    

            	    	    }


            	    	    }

            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:158:2: ( (lv_value_6_0= RULE_STRING ) )
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:159:1: (lv_value_6_0= RULE_STRING )
            	    	    {
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:159:1: (lv_value_6_0= RULE_STRING )
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug299395TestLanguage.g:160:3: lv_value_6_0= RULE_STRING
            	    	    {
            	    	    lv_value_6_0=(Token)input.LT(1);
            	    	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel216); 

            	    	    			createLeafNode(grammarAccess.getModelAccess().getValueSTRINGTerminalRuleCall_2_1_1_0(), "value"); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode, current);
            	    	    	        }
            	    	    	        try {
            	    	    	       		add(
            	    	    	       			current, 
            	    	    	       			"value",
            	    	    	        		lv_value_6_0, 
            	    	    	        		"STRING", 
            	    	    	        		lastConsumedNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);

            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleModel233); 

            	            createLeafNode(grammarAccess.getModelAccess().getRightSquareBracketKeyword_2_2(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


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
        public static final BitSet FOLLOW_11_in_ruleModel130 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel147 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel163 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_13_in_ruleModel176 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel194 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel216 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleModel233 = new BitSet(new long[]{0x0000000000002002L});
    }


}