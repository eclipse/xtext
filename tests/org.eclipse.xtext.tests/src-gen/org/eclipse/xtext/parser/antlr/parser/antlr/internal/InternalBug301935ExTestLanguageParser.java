package org.eclipse.xtext.parser.antlr.parser.antlr.internal; 

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
import org.eclipse.xtext.parser.antlr.services.Bug301935ExTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug301935ExTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_1", "KEYWORD_2", "RULE_ID", "RULE_WS", "RULE_ANY_OTHER", "Tokens"
    };
    public static final int RULE_ID=6;
    public static final int RULE_WS=7;
    public static final int KEYWORD_1=4;
    public static final int EOF=-1;
    public static final int Tokens=9;
    public static final int RULE_ANY_OTHER=8;
    public static final int KEYWORD_2=5;

        public InternalBug301935ExTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g"; }




     	private Bug301935ExTestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug301935ExTestLanguageParser(TokenStream input, IAstFactory factory, Bug301935ExTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "DelegateModel";	
       	} 
       	   	
       	@Override
       	protected Bug301935ExTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleDelegateModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:71:1: entryRuleDelegateModel returns [EObject current=null] : iv_ruleDelegateModel= ruleDelegateModel EOF ;
    public final EObject entryRuleDelegateModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegateModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:72:2: (iv_ruleDelegateModel= ruleDelegateModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:73:2: iv_ruleDelegateModel= ruleDelegateModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDelegateModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegateModel_in_entryRuleDelegateModel67);
            iv_ruleDelegateModel=ruleDelegateModel();
            _fsp--;

             current =iv_ruleDelegateModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegateModel77); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDelegateModel


    // $ANTLR start ruleDelegateModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:80:1: ruleDelegateModel returns [EObject current=null] : this_Model_0= ruleModel ;
    public final EObject ruleDelegateModel() throws RecognitionException {
        EObject current = null;

        EObject this_Model_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:85:6: (this_Model_0= ruleModel )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:87:5: this_Model_0= ruleModel
            {
             
                    currentNode=createCompositeNode(grammarAccess.getDelegateModelAccess().getModelParserRuleCall(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_ruleDelegateModel123);
            this_Model_0=ruleModel();
            _fsp--;

             
                    current = this_Model_0; 
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
    // $ANTLR end ruleDelegateModel


    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:103:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:104:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:105:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel156);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel166); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:112:1: ruleModel returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) RULE_WS ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_value_2_0=null;
        Token lv_value2_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:117:6: ( ( ( (lv_name_0_0= RULE_ID ) ) RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) RULE_WS ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:118:1: ( ( (lv_name_0_0= RULE_ID ) ) RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) RULE_WS )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:118:1: ( ( (lv_name_0_0= RULE_ID ) ) RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) RULE_WS )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:118:2: ( (lv_name_0_0= RULE_ID ) ) RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) RULE_WS
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:118:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:119:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:119:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:120:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel208); 

            			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
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

            match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleModel222); 
             
                createLeafNode(grammarAccess.getModelAccess().getWSTerminalRuleCall_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:146:1: ( (lv_value_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:147:1: (lv_value_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:147:1: (lv_value_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:148:3: lv_value_2_0= RULE_ID
            {
            lv_value_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel238); 

            			createLeafNode(grammarAccess.getModelAccess().getValueIDTerminalRuleCall_2_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
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

            pushFollow(FollowSets000.FOLLOW_ruleNL_in_ruleModel252);
            ruleNL();
            _fsp--;

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:170:8: ( (lv_value2_4_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:171:1: (lv_value2_4_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:171:1: (lv_value2_4_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:172:3: lv_value2_4_0= RULE_ID
            {
            lv_value2_4_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel261); 

            			createLeafNode(grammarAccess.getModelAccess().getValue2IDTerminalRuleCall_4_0(), "value2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value2",
            	        		lv_value2_4_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleModel275); 
             
                createLeafNode(grammarAccess.getModelAccess().getWSTerminalRuleCall_5(), null); 
                

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


    // $ANTLR start entryRuleNL
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:206:1: entryRuleNL returns [String current=null] : iv_ruleNL= ruleNL EOF ;
    public final String entryRuleNL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNL = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:207:1: (iv_ruleNL= ruleNL EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:208:2: iv_ruleNL= ruleNL EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNLRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNL_in_entryRuleNL310);
            iv_ruleNL=ruleNL();
            _fsp--;

             current =iv_ruleNL.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNL321); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNL


    // $ANTLR start ruleNL
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:215:1: ruleNL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WS_0= RULE_WS )* ( (kw= KEYWORD_2 )? kw= KEYWORD_1 ) (this_WS_3= RULE_WS )* ) ;
    public final AntlrDatatypeRuleToken ruleNL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token kw=null;
        Token this_WS_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:220:6: ( ( (this_WS_0= RULE_WS )* ( (kw= KEYWORD_2 )? kw= KEYWORD_1 ) (this_WS_3= RULE_WS )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:221:1: ( (this_WS_0= RULE_WS )* ( (kw= KEYWORD_2 )? kw= KEYWORD_1 ) (this_WS_3= RULE_WS )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:221:1: ( (this_WS_0= RULE_WS )* ( (kw= KEYWORD_2 )? kw= KEYWORD_1 ) (this_WS_3= RULE_WS )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:221:2: (this_WS_0= RULE_WS )* ( (kw= KEYWORD_2 )? kw= KEYWORD_1 ) (this_WS_3= RULE_WS )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:221:2: (this_WS_0= RULE_WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:221:7: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)input.LT(1);
            	    match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleNL362); 

            	    		current.merge(this_WS_0);
            	        
            	     
            	        createLeafNode(grammarAccess.getNLAccess().getWSTerminalRuleCall_0(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:228:3: ( (kw= KEYWORD_2 )? kw= KEYWORD_1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:228:4: (kw= KEYWORD_2 )? kw= KEYWORD_1
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:228:4: (kw= KEYWORD_2 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==KEYWORD_2) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:229:2: kw= KEYWORD_2
                    {
                    kw=(Token)input.LT(1);
                    match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleNL384); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getNLAccess().getCarriageReturnCrKeyword_1_0(), null); 
                        

                    }
                    break;

            }

            kw=(Token)input.LT(1);
            match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleNL399); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getNLAccess().getLineFeedLfKeyword_1_1(), null); 
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:240:2: (this_WS_3= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguage.g:240:7: this_WS_3= RULE_WS
            	    {
            	    this_WS_3=(Token)input.LT(1);
            	    match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleNL416); 

            	    		current.merge(this_WS_3);
            	        
            	     
            	        createLeafNode(grammarAccess.getNLAccess().getWSTerminalRuleCall_2(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end ruleNL


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleDelegateModel_in_entryRuleDelegateModel67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegateModel77 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel_in_ruleDelegateModel123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel156 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel208 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleModel222 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel238 = new BitSet(new long[]{0x00000000000000B0L});
        public static final BitSet FOLLOW_ruleNL_in_ruleModel252 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel261 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleModel275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNL_in_entryRuleNL310 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNL321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleNL362 = new BitSet(new long[]{0x00000000000000B0L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleNL384 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleNL399 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleNL416 = new BitSet(new long[]{0x0000000000000082L});
    }


}