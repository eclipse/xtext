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
import org.eclipse.xtext.parsetree.reconstr.services.HiddenTokensMergerTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalHiddenTokensMergerTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'ref'", "';'", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalHiddenTokensMergerTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g"; }


     
     	private HiddenTokensMergerTestLanguageGrammarAccess grammarAccess;
     	
        public InternalHiddenTokensMergerTestLanguageParser(TokenStream input, IAstFactory factory, HiddenTokensMergerTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:80:1: ruleModel returns [EObject current=null] : this_DatatypeBug286557_0= ruleDatatypeBug286557 ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_DatatypeBug286557_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:85:6: (this_DatatypeBug286557_0= ruleDatatypeBug286557 )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:87:5: this_DatatypeBug286557_0= ruleDatatypeBug286557
            {
             
                    currentNode=createCompositeNode(grammarAccess.getModelAccess().getDatatypeBug286557ParserRuleCall(), currentNode); 
                
            pushFollow(FOLLOW_ruleDatatypeBug286557_in_ruleModel129);
            this_DatatypeBug286557_0=ruleDatatypeBug286557();
            _fsp--;

             
                    current = this_DatatypeBug286557_0; 
                    currentNode = currentNode.getParent();
                

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


    // $ANTLR start entryRuleDatatypeBug286557
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:102:1: entryRuleDatatypeBug286557 returns [EObject current=null] : iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF ;
    public final EObject entryRuleDatatypeBug286557() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeBug286557 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:102:59: (iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:103:2: iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeBug286557Rule(), currentNode); 
            pushFollow(FOLLOW_ruleDatatypeBug286557_in_entryRuleDatatypeBug286557160);
            iv_ruleDatatypeBug286557=ruleDatatypeBug286557();
            _fsp--;

             current =iv_ruleDatatypeBug286557; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatypeBug286557170); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDatatypeBug286557


    // $ANTLR start ruleDatatypeBug286557
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:110:1: ruleDatatypeBug286557 returns [EObject current=null] : ( '#1' (lv_name_1= ruleFQN ) ( 'ref' ( ruleFQN ) )? ';' ) ;
    public final EObject ruleDatatypeBug286557() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:115:6: ( ( '#1' (lv_name_1= ruleFQN ) ( 'ref' ( ruleFQN ) )? ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:116:1: ( '#1' (lv_name_1= ruleFQN ) ( 'ref' ( ruleFQN ) )? ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:116:1: ( '#1' (lv_name_1= ruleFQN ) ( 'ref' ( ruleFQN ) )? ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:116:2: '#1' (lv_name_1= ruleFQN ) ( 'ref' ( ruleFQN ) )? ';'
            {
            match(input,11,FOLLOW_11_in_ruleDatatypeBug286557204); 

                    createLeafNode(grammarAccess.getDatatypeBug286557Access().getNumberSignDigitOneKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:120:1: (lv_name_1= ruleFQN )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:123:6: lv_name_1= ruleFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDatatypeBug286557Access().getNameFQNParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleDatatypeBug286557238);
            lv_name_1=ruleFQN();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDatatypeBug286557Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "FQN", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:141:2: ( 'ref' ( ruleFQN ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:141:3: 'ref' ( ruleFQN )
                    {
                    match(input,12,FOLLOW_12_in_ruleDatatypeBug286557252); 

                            createLeafNode(grammarAccess.getDatatypeBug286557Access().getRefKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:145:1: ( ruleFQN )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:148:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getDatatypeBug286557Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDatatypeBug286557Access().getRefDatatypeBug286557CrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleDatatypeBug286557279);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    
                     lastConsumedDatatypeToken = null; 

                    }


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleDatatypeBug286557297); 

                    createLeafNode(grammarAccess.getDatatypeBug286557Access().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleDatatypeBug286557


    // $ANTLR start entryRuleFQN
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:175:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:175:44: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:176:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN331);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN342); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:183:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:189:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:190:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:190:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:190:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN382); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:197:1: (kw= '.' this_ID_2= RULE_ID )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:198:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,14,FOLLOW_14_in_ruleFQN401); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN416); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFQN


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatypeBug286557_in_ruleModel129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatypeBug286557_in_entryRuleDatatypeBug286557160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeBug286557170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleDatatypeBug286557204 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleDatatypeBug286557238 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleDatatypeBug286557252 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleDatatypeBug286557279 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleDatatypeBug286557297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN331 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN382 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleFQN401 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN416 = new BitSet(new long[]{0x0000000000004002L});

}