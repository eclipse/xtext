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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_1", "KEYWORD_2", "RULE_ID", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=6;
    public static final int RULE_WS=7;
    public static final int KEYWORD_1=4;
    public static final int EOF=-1;
    public static final int RULE_ANY_OTHER=8;
    public static final int KEYWORD_2=5;

    // delegates
    // delegators


        public InternalBug301935ExTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug301935ExTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug301935ExTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g"; }




     	private Bug301935ExTestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug301935ExTestLanguageParser(TokenStream input, IAstFactory factory, Bug301935ExTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "DelegateModel";	
       	} 
       	   	
       	@Override
       	protected Bug301935ExTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleDelegateModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:65:1: entryRuleDelegateModel returns [EObject current=null] : iv_ruleDelegateModel= ruleDelegateModel EOF ;
    public final EObject entryRuleDelegateModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegateModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:66:2: (iv_ruleDelegateModel= ruleDelegateModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:67:2: iv_ruleDelegateModel= ruleDelegateModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDelegateModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegateModel_in_entryRuleDelegateModel67);
            iv_ruleDelegateModel=ruleDelegateModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleDelegateModel"


    // $ANTLR start "ruleDelegateModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:74:1: ruleDelegateModel returns [EObject current=null] : this_Model_0= ruleModel ;
    public final EObject ruleDelegateModel() throws RecognitionException {
        EObject current = null;

        EObject this_Model_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:79:6: (this_Model_0= ruleModel )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:81:5: this_Model_0= ruleModel
            {
             
                    currentNode=createCompositeNode(grammarAccess.getDelegateModelAccess().getModelParserRuleCall(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_ruleDelegateModel123);
            this_Model_0=ruleModel();

            state._fsp--;


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
    // $ANTLR end "ruleDelegateModel"


    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:97:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:98:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:99:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel156);
            iv_ruleModel=ruleModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:106:1: ruleModel returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_WS_1=null;
        Token lv_value_2_0=null;
        Token lv_value2_4_0=null;
        Token this_WS_5=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:111:6: ( ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:112:1: ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:112:1: ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:112:2: ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:112:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:113:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:113:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:114:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel208); 

            			createLeafNode(lv_name_0_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

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

            this_WS_1=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleModel224); 
             
                createLeafNode(this_WS_1, grammarAccess.getModelAccess().getWSTerminalRuleCall_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:140:1: ( (lv_value_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:141:1: (lv_value_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:141:1: (lv_value_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:142:3: lv_value_2_0= RULE_ID
            {
            lv_value_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel240); 

            			createLeafNode(lv_value_2_0, grammarAccess.getModelAccess().getValueIDTerminalRuleCall_2_0(), "value"); 
            		

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

             
                    currentNode=createCompositeNode(grammarAccess.getModelAccess().getNLParserRuleCall_3(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleNL_in_ruleModel261);
            ruleNL();

            state._fsp--;


                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:172:1: ( (lv_value2_4_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:173:1: (lv_value2_4_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:173:1: (lv_value2_4_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:174:3: lv_value2_4_0= RULE_ID
            {
            lv_value2_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel277); 

            			createLeafNode(lv_value2_4_0, grammarAccess.getModelAccess().getValue2IDTerminalRuleCall_4_0(), "value2"); 
            		

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

            this_WS_5=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleModel293); 
             
                createLeafNode(this_WS_5, grammarAccess.getModelAccess().getWSTerminalRuleCall_5(), null); 
                

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


    // $ANTLR start "entryRuleNL"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:208:1: entryRuleNL returns [String current=null] : iv_ruleNL= ruleNL EOF ;
    public final String entryRuleNL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNL = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:209:1: (iv_ruleNL= ruleNL EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:210:2: iv_ruleNL= ruleNL EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNLRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNL_in_entryRuleNL328);
            iv_ruleNL=ruleNL();

            state._fsp--;

             current =iv_ruleNL.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNL339); 

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
    // $ANTLR end "entryRuleNL"


    // $ANTLR start "ruleNL"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:217:1: ruleNL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WS_0= RULE_WS )* ( (kw= KEYWORD_2 )? kw= KEYWORD_1 ) (this_WS_3= RULE_WS )* ) ;
    public final AntlrDatatypeRuleToken ruleNL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token kw=null;
        Token this_WS_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:222:6: ( ( (this_WS_0= RULE_WS )* ( (kw= KEYWORD_2 )? kw= KEYWORD_1 ) (this_WS_3= RULE_WS )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:223:1: ( (this_WS_0= RULE_WS )* ( (kw= KEYWORD_2 )? kw= KEYWORD_1 ) (this_WS_3= RULE_WS )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:223:1: ( (this_WS_0= RULE_WS )* ( (kw= KEYWORD_2 )? kw= KEYWORD_1 ) (this_WS_3= RULE_WS )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:223:2: (this_WS_0= RULE_WS )* ( (kw= KEYWORD_2 )? kw= KEYWORD_1 ) (this_WS_3= RULE_WS )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:223:2: (this_WS_0= RULE_WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:223:7: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleNL380); 

            	    		current.merge(this_WS_0);
            	        
            	     
            	        createLeafNode(this_WS_0, grammarAccess.getNLAccess().getWSTerminalRuleCall_0(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:230:3: ( (kw= KEYWORD_2 )? kw= KEYWORD_1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:230:4: (kw= KEYWORD_2 )? kw= KEYWORD_1
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:230:4: (kw= KEYWORD_2 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==KEYWORD_2) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:231:2: kw= KEYWORD_2
                    {
                    kw=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleNL402); 

                            current.merge(kw);
                            createLeafNode(kw, grammarAccess.getNLAccess().getCarriageReturnCrKeyword_1_0(), null); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleNL417); 

                    current.merge(kw);
                    createLeafNode(kw, grammarAccess.getNLAccess().getLineFeedLfKeyword_1_1(), null); 
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:242:2: (this_WS_3= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935ExTestLanguageParser.g:242:7: this_WS_3= RULE_WS
            	    {
            	    this_WS_3=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleNL434); 

            	    		current.merge(this_WS_3);
            	        
            	     
            	        createLeafNode(this_WS_3, grammarAccess.getNLAccess().getWSTerminalRuleCall_2(), null); 
            	        

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
    // $ANTLR end "ruleNL"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleDelegateModel_in_entryRuleDelegateModel67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegateModel77 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel_in_ruleDelegateModel123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel156 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel208 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleModel224 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel240 = new BitSet(new long[]{0x00000000000000B0L});
        public static final BitSet FOLLOW_ruleNL_in_ruleModel261 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel277 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleModel293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNL_in_entryRuleNL328 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNL339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleNL380 = new BitSet(new long[]{0x00000000000000B0L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleNL402 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleNL417 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleNL434 = new BitSet(new long[]{0x0000000000000082L});
    }


}