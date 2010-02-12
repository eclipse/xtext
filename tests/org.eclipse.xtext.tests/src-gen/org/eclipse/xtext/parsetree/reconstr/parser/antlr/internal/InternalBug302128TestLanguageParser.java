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
import org.eclipse.xtext.parsetree.reconstr.services.Bug302128TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug302128TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VALUE", "RULE_ID", "RULE_SL_COMMENT", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'-'"
    };
    public static final int RULE_ML_COMMENT=9;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=7;
    public static final int RULE_STRING=8;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=6;
    public static final int RULE_VALUE=4;

        public InternalBug302128TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g"; }



     	private Bug302128TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug302128TestLanguageParser(TokenStream input, IAstFactory factory, Bug302128TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:73:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:74:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:86:6: ( ( (lv_elements_0_0= ruleElement ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:87:1: ( (lv_elements_0_0= ruleElement ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:87:1: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:88:1: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:88:1: (lv_elements_0_0= ruleElement )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:89:3: lv_elements_0_0= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getElementsElementParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleModel130);
            	    lv_elements_0_0=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_0_0, 
            	    	        		"Element", 
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


    // $ANTLR start entryRuleElement
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:119:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:120:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:121:2: iv_ruleElement= ruleElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement166);
            iv_ruleElement=ruleElement();
            _fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement176); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleElement


    // $ANTLR start ruleElement
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:128:1: ruleElement returns [EObject current=null] : ( ( (lv_name_0_0= ruleVariable ) ) ( (lv_value_1_0= RULE_VALUE ) )? ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:133:6: ( ( ( (lv_name_0_0= ruleVariable ) ) ( (lv_value_1_0= RULE_VALUE ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:134:1: ( ( (lv_name_0_0= ruleVariable ) ) ( (lv_value_1_0= RULE_VALUE ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:134:1: ( ( (lv_name_0_0= ruleVariable ) ) ( (lv_value_1_0= RULE_VALUE ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:134:2: ( (lv_name_0_0= ruleVariable ) ) ( (lv_value_1_0= RULE_VALUE ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:134:2: ( (lv_name_0_0= ruleVariable ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:135:1: (lv_name_0_0= ruleVariable )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:135:1: (lv_name_0_0= ruleVariable )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:136:3: lv_name_0_0= ruleVariable
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getNameVariableParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_ruleElement222);
            lv_name_0_0=ruleVariable();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"Variable", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:158:2: ( (lv_value_1_0= RULE_VALUE ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_VALUE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:159:1: (lv_value_1_0= RULE_VALUE )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:159:1: (lv_value_1_0= RULE_VALUE )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:160:3: lv_value_1_0= RULE_VALUE
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,RULE_VALUE,FollowSets000.FOLLOW_RULE_VALUE_in_ruleElement239); 

                    			createLeafNode(grammarAccess.getElementAccess().getValueValueTerminalRuleCall_1_0(), "value"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_1_0, 
                    	        		"Value", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

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
    // $ANTLR end ruleElement


    // $ANTLR start entryRuleVariable
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:190:1: entryRuleVariable returns [String current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final String entryRuleVariable() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariable = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:191:2: (iv_ruleVariable= ruleVariable EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:192:2: iv_ruleVariable= ruleVariable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_entryRuleVariable282);
            iv_ruleVariable=ruleVariable();
            _fsp--;

             current =iv_ruleVariable.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariable293); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVariable


    // $ANTLR start ruleVariable
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:199:1: ruleVariable returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleVariable() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:204:6: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:205:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:205:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:205:6: this_ID_0= RULE_ID ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariable333); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getVariableAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:212:1: ( (kw= '.' | kw= '-' ) this_ID_3= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=12 && LA4_0<=13)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:212:2: (kw= '.' | kw= '-' ) this_ID_3= RULE_ID
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:212:2: (kw= '.' | kw= '-' )
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==12) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==13) ) {
            	        alt3=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("212:2: (kw= '.' | kw= '-' )", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:213:2: kw= '.'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,12,FollowSets000.FOLLOW_12_in_ruleVariable353); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.getVariableAccess().getFullStopKeyword_1_0_0(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalBug302128TestLanguage.g:220:2: kw= '-'
            	            {
            	            kw=(Token)input.LT(1);
            	            match(input,13,FollowSets000.FOLLOW_13_in_ruleVariable372); 

            	                    current.merge(kw);
            	                    createLeafNode(grammarAccess.getVariableAccess().getHyphenMinusKeyword_1_0_1(), null); 
            	                

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariable388); 

            	    		current.merge(this_ID_3);
            	        
            	     
            	        createLeafNode(grammarAccess.getVariableAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

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
    // $ANTLR end ruleVariable


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleModel130 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_ruleElement222 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_VALUE_in_ruleElement239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable282 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariable293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariable333 = new BitSet(new long[]{0x0000000000003002L});
        public static final BitSet FOLLOW_12_in_ruleVariable353 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_13_in_ruleVariable372 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariable388 = new BitSet(new long[]{0x0000000000003002L});
    }


}