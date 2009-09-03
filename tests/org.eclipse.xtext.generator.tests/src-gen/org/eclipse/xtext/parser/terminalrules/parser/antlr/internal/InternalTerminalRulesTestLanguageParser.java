package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal; 

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
import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTerminalRulesTestLanguageParser extends AbstractInternalAntlrParser {
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

        public InternalTerminalRulesTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g"; }


     
     	private TerminalRulesTestLanguageGrammarAccess grammarAccess;
     	
        public InternalTerminalRulesTestLanguageParser(TokenStream input, IAstFactory factory, TerminalRulesTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_5_0= RULE_WS ) ) | ( (lv_anyValue_6_0= RULE_ANY_OTHER ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_idValue_0_0=null;
        Token lv_intValue_1_0=null;
        Token lv_stringValue_2_0=null;
        Token lv_mlCommentValue_3_0=null;
        Token lv_slCommentValue_4_0=null;
        Token lv_wsValue_5_0=null;
        Token lv_anyValue_6_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:85:6: ( ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_5_0= RULE_WS ) ) | ( (lv_anyValue_6_0= RULE_ANY_OTHER ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:86:1: ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_5_0= RULE_WS ) ) | ( (lv_anyValue_6_0= RULE_ANY_OTHER ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:86:1: ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_5_0= RULE_WS ) ) | ( (lv_anyValue_6_0= RULE_ANY_OTHER ) ) )
            int alt1=7;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt1=1;
                }
                break;
            case RULE_INT:
                {
                alt1=2;
                }
                break;
            case RULE_STRING:
                {
                alt1=3;
                }
                break;
            case RULE_ML_COMMENT:
                {
                alt1=4;
                }
                break;
            case RULE_SL_COMMENT:
                {
                alt1=5;
                }
                break;
            case RULE_WS:
                {
                alt1=6;
                }
                break;
            case RULE_ANY_OTHER:
                {
                alt1=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("86:1: ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_5_0= RULE_WS ) ) | ( (lv_anyValue_6_0= RULE_ANY_OTHER ) ) )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:86:2: ( (lv_idValue_0_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:86:2: ( (lv_idValue_0_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:87:1: (lv_idValue_0_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:87:1: (lv_idValue_0_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:88:3: lv_idValue_0_0= RULE_ID
                    {
                    lv_idValue_0_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel125); 

                    			createLeafNode(grammarAccess.getModelAccess().getIdValueIDTerminalRuleCall_0_0(), "idValue"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"idValue",
                    	        		lv_idValue_0_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:111:6: ( (lv_intValue_1_0= RULE_INT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:111:6: ( (lv_intValue_1_0= RULE_INT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:112:1: (lv_intValue_1_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:112:1: (lv_intValue_1_0= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:113:3: lv_intValue_1_0= RULE_INT
                    {
                    lv_intValue_1_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleModel153); 

                    			createLeafNode(grammarAccess.getModelAccess().getIntValueINTTerminalRuleCall_1_0(), "intValue"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"intValue",
                    	        		lv_intValue_1_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:136:6: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:136:6: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:137:1: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:137:1: (lv_stringValue_2_0= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:138:3: lv_stringValue_2_0= RULE_STRING
                    {
                    lv_stringValue_2_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel181); 

                    			createLeafNode(grammarAccess.getModelAccess().getStringValueSTRINGTerminalRuleCall_2_0(), "stringValue"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"stringValue",
                    	        		lv_stringValue_2_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:161:6: ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:161:6: ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:162:1: (lv_mlCommentValue_3_0= RULE_ML_COMMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:162:1: (lv_mlCommentValue_3_0= RULE_ML_COMMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:163:3: lv_mlCommentValue_3_0= RULE_ML_COMMENT
                    {
                    lv_mlCommentValue_3_0=(Token)input.LT(1);
                    match(input,RULE_ML_COMMENT,FOLLOW_RULE_ML_COMMENT_in_ruleModel209); 

                    			createLeafNode(grammarAccess.getModelAccess().getMlCommentValueML_COMMENTTerminalRuleCall_3_0(), "mlCommentValue"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"mlCommentValue",
                    	        		lv_mlCommentValue_3_0, 
                    	        		"ML_COMMENT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:186:6: ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:186:6: ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:187:1: (lv_slCommentValue_4_0= RULE_SL_COMMENT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:187:1: (lv_slCommentValue_4_0= RULE_SL_COMMENT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:188:3: lv_slCommentValue_4_0= RULE_SL_COMMENT
                    {
                    lv_slCommentValue_4_0=(Token)input.LT(1);
                    match(input,RULE_SL_COMMENT,FOLLOW_RULE_SL_COMMENT_in_ruleModel237); 

                    			createLeafNode(grammarAccess.getModelAccess().getSlCommentValueSL_COMMENTTerminalRuleCall_4_0(), "slCommentValue"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"slCommentValue",
                    	        		lv_slCommentValue_4_0, 
                    	        		"SL_COMMENT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:211:6: ( (lv_wsValue_5_0= RULE_WS ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:211:6: ( (lv_wsValue_5_0= RULE_WS ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:212:1: (lv_wsValue_5_0= RULE_WS )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:212:1: (lv_wsValue_5_0= RULE_WS )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:213:3: lv_wsValue_5_0= RULE_WS
                    {
                    lv_wsValue_5_0=(Token)input.LT(1);
                    match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleModel265); 

                    			createLeafNode(grammarAccess.getModelAccess().getWsValueWSTerminalRuleCall_5_0(), "wsValue"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"wsValue",
                    	        		lv_wsValue_5_0, 
                    	        		"WS", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:236:6: ( (lv_anyValue_6_0= RULE_ANY_OTHER ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:236:6: ( (lv_anyValue_6_0= RULE_ANY_OTHER ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:237:1: (lv_anyValue_6_0= RULE_ANY_OTHER )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:237:1: (lv_anyValue_6_0= RULE_ANY_OTHER )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:238:3: lv_anyValue_6_0= RULE_ANY_OTHER
                    {
                    lv_anyValue_6_0=(Token)input.LT(1);
                    match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_ruleModel293); 

                    			createLeafNode(grammarAccess.getModelAccess().getAnyValueANY_OTHERTerminalRuleCall_6_0(), "anyValue"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"anyValue",
                    	        		lv_anyValue_6_0, 
                    	        		"ANY_OTHER", 
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
    // $ANTLR end ruleModel


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleModel153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_COMMENT_in_ruleModel209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_COMMENT_in_ruleModel237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleModel265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_ruleModel293 = new BitSet(new long[]{0x0000000000000002L});

}