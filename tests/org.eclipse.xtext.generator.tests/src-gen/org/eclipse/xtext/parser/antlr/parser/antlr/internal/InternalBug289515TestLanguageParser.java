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

public class InternalBug289515TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'%'", "'2'", "'3'", "'\\\\%'", "'4'", "'5'", "'%%'", "'6'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug289515TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g"; }



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



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( ( '1' ( (lv_value_1_0= '%' ) ) ) | ( '2' ( (lv_value_3_0= '%' ) ) ) | ( '3' ( (lv_value_5_0= '\\\\%' ) ) ) | ( '4' ( (lv_value_7_0= '\\\\%' ) ) ) | ( '5' ( (lv_value_9_0= '%%' ) ) ) | ( '6' ( (lv_value_11_0= '%%' ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        Token lv_value_5_0=null;
        Token lv_value_7_0=null;
        Token lv_value_9_0=null;
        Token lv_value_11_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:85:6: ( ( ( '1' ( (lv_value_1_0= '%' ) ) ) | ( '2' ( (lv_value_3_0= '%' ) ) ) | ( '3' ( (lv_value_5_0= '\\\\%' ) ) ) | ( '4' ( (lv_value_7_0= '\\\\%' ) ) ) | ( '5' ( (lv_value_9_0= '%%' ) ) ) | ( '6' ( (lv_value_11_0= '%%' ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:86:1: ( ( '1' ( (lv_value_1_0= '%' ) ) ) | ( '2' ( (lv_value_3_0= '%' ) ) ) | ( '3' ( (lv_value_5_0= '\\\\%' ) ) ) | ( '4' ( (lv_value_7_0= '\\\\%' ) ) ) | ( '5' ( (lv_value_9_0= '%%' ) ) ) | ( '6' ( (lv_value_11_0= '%%' ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:86:1: ( ( '1' ( (lv_value_1_0= '%' ) ) ) | ( '2' ( (lv_value_3_0= '%' ) ) ) | ( '3' ( (lv_value_5_0= '\\\\%' ) ) ) | ( '4' ( (lv_value_7_0= '\\\\%' ) ) ) | ( '5' ( (lv_value_9_0= '%%' ) ) ) | ( '6' ( (lv_value_11_0= '%%' ) ) ) )
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
                    new NoViableAltException("86:1: ( ( '1' ( (lv_value_1_0= '%' ) ) ) | ( '2' ( (lv_value_3_0= '%' ) ) ) | ( '3' ( (lv_value_5_0= '\\\\%' ) ) ) | ( '4' ( (lv_value_7_0= '\\\\%' ) ) ) | ( '5' ( (lv_value_9_0= '%%' ) ) ) | ( '6' ( (lv_value_11_0= '%%' ) ) ) )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:86:2: ( '1' ( (lv_value_1_0= '%' ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:86:2: ( '1' ( (lv_value_1_0= '%' ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:86:4: '1' ( (lv_value_1_0= '%' ) )
                    {
                    match(input,11,FOLLOW_11_in_ruleModel119); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitOneKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:90:1: ( (lv_value_1_0= '%' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:91:1: (lv_value_1_0= '%' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:91:1: (lv_value_1_0= '%' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:92:3: lv_value_1_0= '%'
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_ruleModel137); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:112:6: ( '2' ( (lv_value_3_0= '%' ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:112:6: ( '2' ( (lv_value_3_0= '%' ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:112:8: '2' ( (lv_value_3_0= '%' ) )
                    {
                    match(input,13,FOLLOW_13_in_ruleModel168); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:116:1: ( (lv_value_3_0= '%' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:117:1: (lv_value_3_0= '%' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:117:1: (lv_value_3_0= '%' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:118:3: lv_value_3_0= '%'
                    {
                    lv_value_3_0=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_ruleModel186); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:138:6: ( '3' ( (lv_value_5_0= '\\\\%' ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:138:6: ( '3' ( (lv_value_5_0= '\\\\%' ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:138:8: '3' ( (lv_value_5_0= '\\\\%' ) )
                    {
                    match(input,14,FOLLOW_14_in_ruleModel217); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitThreeKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:142:1: ( (lv_value_5_0= '\\\\%' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:143:1: (lv_value_5_0= '\\\\%' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:143:1: (lv_value_5_0= '\\\\%' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:144:3: lv_value_5_0= '\\\\%'
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleModel235); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:164:6: ( '4' ( (lv_value_7_0= '\\\\%' ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:164:6: ( '4' ( (lv_value_7_0= '\\\\%' ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:164:8: '4' ( (lv_value_7_0= '\\\\%' ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleModel266); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitFourKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:168:1: ( (lv_value_7_0= '\\\\%' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:169:1: (lv_value_7_0= '\\\\%' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:169:1: (lv_value_7_0= '\\\\%' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:170:3: lv_value_7_0= '\\\\%'
                    {
                    lv_value_7_0=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleModel284); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:190:6: ( '5' ( (lv_value_9_0= '%%' ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:190:6: ( '5' ( (lv_value_9_0= '%%' ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:190:8: '5' ( (lv_value_9_0= '%%' ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleModel315); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitFiveKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:194:1: ( (lv_value_9_0= '%%' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:195:1: (lv_value_9_0= '%%' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:195:1: (lv_value_9_0= '%%' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:196:3: lv_value_9_0= '%%'
                    {
                    lv_value_9_0=(Token)input.LT(1);
                    match(input,18,FOLLOW_18_in_ruleModel333); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:216:6: ( '6' ( (lv_value_11_0= '%%' ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:216:6: ( '6' ( (lv_value_11_0= '%%' ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:216:8: '6' ( (lv_value_11_0= '%%' ) )
                    {
                    match(input,19,FOLLOW_19_in_ruleModel364); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitSixKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:220:1: ( (lv_value_11_0= '%%' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:221:1: (lv_value_11_0= '%%' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:221:1: (lv_value_11_0= '%%' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:222:3: lv_value_11_0= '%%'
                    {
                    lv_value_11_0=(Token)input.LT(1);
                    match(input,18,FOLLOW_18_in_ruleModel382); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel119 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleModel137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModel168 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleModel186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleModel217 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModel235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleModel266 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModel284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleModel315 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleModel333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleModel364 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleModel382 = new BitSet(new long[]{0x0000000000000002L});

}