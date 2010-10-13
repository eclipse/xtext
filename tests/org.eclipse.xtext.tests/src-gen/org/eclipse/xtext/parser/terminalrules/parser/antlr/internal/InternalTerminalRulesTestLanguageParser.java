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

@SuppressWarnings("all")
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

    // delegates
    // delegators


        public InternalTerminalRulesTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTerminalRulesTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTerminalRulesTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g"; }



     	private TerminalRulesTestLanguageGrammarAccess grammarAccess;
     	
        public InternalTerminalRulesTestLanguageParser(TokenStream input, IAstFactory factory, TerminalRulesTestLanguageGrammarAccess grammarAccess) {
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
       	protected TerminalRulesTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_5_0= RULE_WS ) ) | ( (lv_anyValue_6_0= RULE_ANY_OTHER ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:85:6: ( ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_5_0= RULE_WS ) ) | ( (lv_anyValue_6_0= RULE_ANY_OTHER ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:86:1: ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_5_0= RULE_WS ) ) | ( (lv_anyValue_6_0= RULE_ANY_OTHER ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:86:1: ( ( (lv_idValue_0_0= RULE_ID ) ) | ( (lv_intValue_1_0= RULE_INT ) ) | ( (lv_stringValue_2_0= RULE_STRING ) ) | ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) ) | ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) ) | ( (lv_wsValue_5_0= RULE_WS ) ) | ( (lv_anyValue_6_0= RULE_ANY_OTHER ) ) )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:86:2: ( (lv_idValue_0_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:86:2: ( (lv_idValue_0_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:87:1: (lv_idValue_0_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:87:1: (lv_idValue_0_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:88:3: lv_idValue_0_0= RULE_ID
                    {
                    lv_idValue_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel127); 

                    			createLeafNode(lv_idValue_0_0, grammarAccess.getModelAccess().getIdValueIDTerminalRuleCall_0_0(), "idValue"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:111:6: ( (lv_intValue_1_0= RULE_INT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:111:6: ( (lv_intValue_1_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:112:1: (lv_intValue_1_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:112:1: (lv_intValue_1_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:113:3: lv_intValue_1_0= RULE_INT
                    {
                    lv_intValue_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleModel155); 

                    			createLeafNode(lv_intValue_1_0, grammarAccess.getModelAccess().getIntValueINTTerminalRuleCall_1_0(), "intValue"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:136:6: ( (lv_stringValue_2_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:136:6: ( (lv_stringValue_2_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:137:1: (lv_stringValue_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:137:1: (lv_stringValue_2_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:138:3: lv_stringValue_2_0= RULE_STRING
                    {
                    lv_stringValue_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel183); 

                    			createLeafNode(lv_stringValue_2_0, grammarAccess.getModelAccess().getStringValueSTRINGTerminalRuleCall_2_0(), "stringValue"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:161:6: ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:161:6: ( (lv_mlCommentValue_3_0= RULE_ML_COMMENT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:162:1: (lv_mlCommentValue_3_0= RULE_ML_COMMENT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:162:1: (lv_mlCommentValue_3_0= RULE_ML_COMMENT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:163:3: lv_mlCommentValue_3_0= RULE_ML_COMMENT
                    {
                    lv_mlCommentValue_3_0=(Token)match(input,RULE_ML_COMMENT,FollowSets000.FOLLOW_RULE_ML_COMMENT_in_ruleModel211); 

                    			createLeafNode(lv_mlCommentValue_3_0, grammarAccess.getModelAccess().getMlCommentValueML_COMMENTTerminalRuleCall_3_0(), "mlCommentValue"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:186:6: ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:186:6: ( (lv_slCommentValue_4_0= RULE_SL_COMMENT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:187:1: (lv_slCommentValue_4_0= RULE_SL_COMMENT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:187:1: (lv_slCommentValue_4_0= RULE_SL_COMMENT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:188:3: lv_slCommentValue_4_0= RULE_SL_COMMENT
                    {
                    lv_slCommentValue_4_0=(Token)match(input,RULE_SL_COMMENT,FollowSets000.FOLLOW_RULE_SL_COMMENT_in_ruleModel239); 

                    			createLeafNode(lv_slCommentValue_4_0, grammarAccess.getModelAccess().getSlCommentValueSL_COMMENTTerminalRuleCall_4_0(), "slCommentValue"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:211:6: ( (lv_wsValue_5_0= RULE_WS ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:211:6: ( (lv_wsValue_5_0= RULE_WS ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:212:1: (lv_wsValue_5_0= RULE_WS )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:212:1: (lv_wsValue_5_0= RULE_WS )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:213:3: lv_wsValue_5_0= RULE_WS
                    {
                    lv_wsValue_5_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleModel267); 

                    			createLeafNode(lv_wsValue_5_0, grammarAccess.getModelAccess().getWsValueWSTerminalRuleCall_5_0(), "wsValue"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:236:6: ( (lv_anyValue_6_0= RULE_ANY_OTHER ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:236:6: ( (lv_anyValue_6_0= RULE_ANY_OTHER ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:237:1: (lv_anyValue_6_0= RULE_ANY_OTHER )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:237:1: (lv_anyValue_6_0= RULE_ANY_OTHER )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:238:3: lv_anyValue_6_0= RULE_ANY_OTHER
                    {
                    lv_anyValue_6_0=(Token)match(input,RULE_ANY_OTHER,FollowSets000.FOLLOW_RULE_ANY_OTHER_in_ruleModel295); 

                    			createLeafNode(lv_anyValue_6_0, grammarAccess.getModelAccess().getAnyValueANY_OTHERTerminalRuleCall_6_0(), "anyValue"); 
                    		

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
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleModel155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ML_COMMENT_in_ruleModel211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SL_COMMENT_in_ruleModel239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleModel267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ANY_OTHER_in_ruleModel295 = new BitSet(new long[]{0x0000000000000002L});
    }


}