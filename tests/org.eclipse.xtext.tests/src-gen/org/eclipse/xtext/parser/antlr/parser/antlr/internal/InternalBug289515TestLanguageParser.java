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
import org.eclipse.xtext.parser.antlr.services.Bug289515TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug289515TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'%'", "'2'", "'3'", "'\\\\%'", "'4'", "'5'", "'%%'", "'6'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalBug289515TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g"; }



     	private Bug289515TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug289515TestLanguageParser(TokenStream input, IAstFactory factory, Bug289515TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug289515TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( ( '1' ( (lv_value_1_0= '%' ) ) ) | ( '2' ( (lv_value_3_0= '%' ) ) ) | ( '3' ( (lv_value_5_0= '\\\\%' ) ) ) | ( '4' ( (lv_value_7_0= '\\\\%' ) ) ) | ( '5' ( (lv_value_9_0= '%%' ) ) ) | ( '6' ( (lv_value_11_0= '%%' ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        Token lv_value_5_0=null;
        Token lv_value_7_0=null;
        Token lv_value_9_0=null;
        Token lv_value_11_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:91:6: ( ( ( '1' ( (lv_value_1_0= '%' ) ) ) | ( '2' ( (lv_value_3_0= '%' ) ) ) | ( '3' ( (lv_value_5_0= '\\\\%' ) ) ) | ( '4' ( (lv_value_7_0= '\\\\%' ) ) ) | ( '5' ( (lv_value_9_0= '%%' ) ) ) | ( '6' ( (lv_value_11_0= '%%' ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:92:1: ( ( '1' ( (lv_value_1_0= '%' ) ) ) | ( '2' ( (lv_value_3_0= '%' ) ) ) | ( '3' ( (lv_value_5_0= '\\\\%' ) ) ) | ( '4' ( (lv_value_7_0= '\\\\%' ) ) ) | ( '5' ( (lv_value_9_0= '%%' ) ) ) | ( '6' ( (lv_value_11_0= '%%' ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:92:1: ( ( '1' ( (lv_value_1_0= '%' ) ) ) | ( '2' ( (lv_value_3_0= '%' ) ) ) | ( '3' ( (lv_value_5_0= '\\\\%' ) ) ) | ( '4' ( (lv_value_7_0= '\\\\%' ) ) ) | ( '5' ( (lv_value_9_0= '%%' ) ) ) | ( '6' ( (lv_value_11_0= '%%' ) ) ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 14:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            case 19:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("92:1: ( ( '1' ( (lv_value_1_0= '%' ) ) ) | ( '2' ( (lv_value_3_0= '%' ) ) ) | ( '3' ( (lv_value_5_0= '\\\\%' ) ) ) | ( '4' ( (lv_value_7_0= '\\\\%' ) ) ) | ( '5' ( (lv_value_9_0= '%%' ) ) ) | ( '6' ( (lv_value_11_0= '%%' ) ) ) )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:92:2: ( '1' ( (lv_value_1_0= '%' ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:92:2: ( '1' ( (lv_value_1_0= '%' ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:92:4: '1' ( (lv_value_1_0= '%' ) )
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleModel121); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitOneKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:96:1: ( (lv_value_1_0= '%' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:97:1: (lv_value_1_0= '%' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:97:1: (lv_value_1_0= '%' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:98:3: lv_value_1_0= '%'
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel139); 

                            createLeafNode(grammarAccess.getModelAccess().getValuePercentSignKeyword_0_1_0(), "value"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_1_0, "%", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:118:6: ( '2' ( (lv_value_3_0= '%' ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:118:6: ( '2' ( (lv_value_3_0= '%' ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:118:8: '2' ( (lv_value_3_0= '%' ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel170); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:122:1: ( (lv_value_3_0= '%' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:123:1: (lv_value_3_0= '%' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:123:1: (lv_value_3_0= '%' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:124:3: lv_value_3_0= '%'
                    {
                    lv_value_3_0=(Token)input.LT(1);
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel188); 

                            createLeafNode(grammarAccess.getModelAccess().getValuePercentSignKeyword_1_1_0(), "value"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_3_0, "%", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:144:6: ( '3' ( (lv_value_5_0= '\\\\%' ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:144:6: ( '3' ( (lv_value_5_0= '\\\\%' ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:144:8: '3' ( (lv_value_5_0= '\\\\%' ) )
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleModel219); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitThreeKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:148:1: ( (lv_value_5_0= '\\\\%' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:149:1: (lv_value_5_0= '\\\\%' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:149:1: (lv_value_5_0= '\\\\%' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:150:3: lv_value_5_0= '\\\\%'
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleModel237); 

                            createLeafNode(grammarAccess.getModelAccess().getValueReverseSolidusPercentSignKeyword_2_1_0(), "value"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_5_0, "\\%", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:170:6: ( '4' ( (lv_value_7_0= '\\\\%' ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:170:6: ( '4' ( (lv_value_7_0= '\\\\%' ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:170:8: '4' ( (lv_value_7_0= '\\\\%' ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleModel268); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitFourKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:174:1: ( (lv_value_7_0= '\\\\%' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:175:1: (lv_value_7_0= '\\\\%' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:175:1: (lv_value_7_0= '\\\\%' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:176:3: lv_value_7_0= '\\\\%'
                    {
                    lv_value_7_0=(Token)input.LT(1);
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleModel286); 

                            createLeafNode(grammarAccess.getModelAccess().getValueReverseSolidusPercentSignKeyword_3_1_0(), "value"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_7_0, "\\%", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:196:6: ( '5' ( (lv_value_9_0= '%%' ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:196:6: ( '5' ( (lv_value_9_0= '%%' ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:196:8: '5' ( (lv_value_9_0= '%%' ) )
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleModel317); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitFiveKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:200:1: ( (lv_value_9_0= '%%' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:201:1: (lv_value_9_0= '%%' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:201:1: (lv_value_9_0= '%%' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:202:3: lv_value_9_0= '%%'
                    {
                    lv_value_9_0=(Token)input.LT(1);
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleModel335); 

                            createLeafNode(grammarAccess.getModelAccess().getValuePercentSignPercentSignKeyword_4_1_0(), "value"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_9_0, "%%", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:222:6: ( '6' ( (lv_value_11_0= '%%' ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:222:6: ( '6' ( (lv_value_11_0= '%%' ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:222:8: '6' ( (lv_value_11_0= '%%' ) )
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleModel366); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitSixKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:226:1: ( (lv_value_11_0= '%%' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:227:1: (lv_value_11_0= '%%' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:227:1: (lv_value_11_0= '%%' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:228:3: lv_value_11_0= '%%'
                    {
                    lv_value_11_0=(Token)input.LT(1);
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleModel384); 

                            createLeafNode(grammarAccess.getModelAccess().getValuePercentSignPercentSignKeyword_5_1_0(), "value"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_11_0, "%%", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel121 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel170 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel219 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleModel237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel268 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleModel286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel317 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModel335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleModel366 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModel384 = new BitSet(new long[]{0x0000000000000002L});
    }


}