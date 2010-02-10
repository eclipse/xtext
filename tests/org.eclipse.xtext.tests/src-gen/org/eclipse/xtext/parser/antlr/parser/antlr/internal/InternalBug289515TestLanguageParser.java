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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_8", "KEYWORD_9", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "KEYWORD_5", "KEYWORD_6", "KEYWORD_7", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "Tokens"
    };
    public static final int KEYWORD_7=12;
    public static final int RULE_ML_COMMENT=16;
    public static final int RULE_ID=13;
    public static final int KEYWORD_1=6;
    public static final int RULE_STRING=15;
    public static final int KEYWORD_2=7;
    public static final int KEYWORD_9=5;
    public static final int KEYWORD_4=9;
    public static final int RULE_WS=18;
    public static final int EOF=-1;
    public static final int RULE_INT=14;
    public static final int KEYWORD_5=10;
    public static final int Tokens=20;
    public static final int KEYWORD_6=11;
    public static final int RULE_ANY_OTHER=19;
    public static final int RULE_SL_COMMENT=17;
    public static final int KEYWORD_8=4;
    public static final int KEYWORD_3=8;

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



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:66:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:67:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:68:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel67);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel77); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:75:1: ruleModel returns [EObject current=null] : ( ( KEYWORD_2 ( (lv_value_1_0= KEYWORD_1 ) ) ) | ( KEYWORD_3 ( (lv_value_3_0= KEYWORD_1 ) ) ) | ( KEYWORD_4 ( (lv_value_5_0= KEYWORD_9 ) ) ) | ( KEYWORD_5 ( (lv_value_7_0= KEYWORD_9 ) ) ) | ( KEYWORD_6 ( (lv_value_9_0= KEYWORD_8 ) ) ) | ( KEYWORD_7 ( (lv_value_11_0= KEYWORD_8 ) ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:80:6: ( ( ( KEYWORD_2 ( (lv_value_1_0= KEYWORD_1 ) ) ) | ( KEYWORD_3 ( (lv_value_3_0= KEYWORD_1 ) ) ) | ( KEYWORD_4 ( (lv_value_5_0= KEYWORD_9 ) ) ) | ( KEYWORD_5 ( (lv_value_7_0= KEYWORD_9 ) ) ) | ( KEYWORD_6 ( (lv_value_9_0= KEYWORD_8 ) ) ) | ( KEYWORD_7 ( (lv_value_11_0= KEYWORD_8 ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:81:1: ( ( KEYWORD_2 ( (lv_value_1_0= KEYWORD_1 ) ) ) | ( KEYWORD_3 ( (lv_value_3_0= KEYWORD_1 ) ) ) | ( KEYWORD_4 ( (lv_value_5_0= KEYWORD_9 ) ) ) | ( KEYWORD_5 ( (lv_value_7_0= KEYWORD_9 ) ) ) | ( KEYWORD_6 ( (lv_value_9_0= KEYWORD_8 ) ) ) | ( KEYWORD_7 ( (lv_value_11_0= KEYWORD_8 ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:81:1: ( ( KEYWORD_2 ( (lv_value_1_0= KEYWORD_1 ) ) ) | ( KEYWORD_3 ( (lv_value_3_0= KEYWORD_1 ) ) ) | ( KEYWORD_4 ( (lv_value_5_0= KEYWORD_9 ) ) ) | ( KEYWORD_5 ( (lv_value_7_0= KEYWORD_9 ) ) ) | ( KEYWORD_6 ( (lv_value_9_0= KEYWORD_8 ) ) ) | ( KEYWORD_7 ( (lv_value_11_0= KEYWORD_8 ) ) ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case KEYWORD_2:
                {
                alt1=1;
                }
                break;
            case KEYWORD_3:
                {
                alt1=2;
                }
                break;
            case KEYWORD_4:
                {
                alt1=3;
                }
                break;
            case KEYWORD_5:
                {
                alt1=4;
                }
                break;
            case KEYWORD_6:
                {
                alt1=5;
                }
                break;
            case KEYWORD_7:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("81:1: ( ( KEYWORD_2 ( (lv_value_1_0= KEYWORD_1 ) ) ) | ( KEYWORD_3 ( (lv_value_3_0= KEYWORD_1 ) ) ) | ( KEYWORD_4 ( (lv_value_5_0= KEYWORD_9 ) ) ) | ( KEYWORD_5 ( (lv_value_7_0= KEYWORD_9 ) ) ) | ( KEYWORD_6 ( (lv_value_9_0= KEYWORD_8 ) ) ) | ( KEYWORD_7 ( (lv_value_11_0= KEYWORD_8 ) ) ) )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:81:2: ( KEYWORD_2 ( (lv_value_1_0= KEYWORD_1 ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:81:2: ( KEYWORD_2 ( (lv_value_1_0= KEYWORD_1 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:82:2: KEYWORD_2 ( (lv_value_1_0= KEYWORD_1 ) )
                    {
                    match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleModel114); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitOneKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:86:1: ( (lv_value_1_0= KEYWORD_1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:87:1: (lv_value_1_0= KEYWORD_1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:87:1: (lv_value_1_0= KEYWORD_1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:88:3: lv_value_1_0= KEYWORD_1
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleModel133); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:109:6: ( KEYWORD_3 ( (lv_value_3_0= KEYWORD_1 ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:109:6: ( KEYWORD_3 ( (lv_value_3_0= KEYWORD_1 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:110:2: KEYWORD_3 ( (lv_value_3_0= KEYWORD_1 ) )
                    {
                    match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_ruleModel165); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:114:1: ( (lv_value_3_0= KEYWORD_1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:115:1: (lv_value_3_0= KEYWORD_1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:115:1: (lv_value_3_0= KEYWORD_1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:116:3: lv_value_3_0= KEYWORD_1
                    {
                    lv_value_3_0=(Token)input.LT(1);
                    match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleModel184); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:137:6: ( KEYWORD_4 ( (lv_value_5_0= KEYWORD_9 ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:137:6: ( KEYWORD_4 ( (lv_value_5_0= KEYWORD_9 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:138:2: KEYWORD_4 ( (lv_value_5_0= KEYWORD_9 ) )
                    {
                    match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleModel216); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitThreeKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:142:1: ( (lv_value_5_0= KEYWORD_9 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:143:1: (lv_value_5_0= KEYWORD_9 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:143:1: (lv_value_5_0= KEYWORD_9 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:144:3: lv_value_5_0= KEYWORD_9
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleModel235); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:165:6: ( KEYWORD_5 ( (lv_value_7_0= KEYWORD_9 ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:165:6: ( KEYWORD_5 ( (lv_value_7_0= KEYWORD_9 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:166:2: KEYWORD_5 ( (lv_value_7_0= KEYWORD_9 ) )
                    {
                    match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleModel267); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitFourKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:170:1: ( (lv_value_7_0= KEYWORD_9 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:171:1: (lv_value_7_0= KEYWORD_9 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:171:1: (lv_value_7_0= KEYWORD_9 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:172:3: lv_value_7_0= KEYWORD_9
                    {
                    lv_value_7_0=(Token)input.LT(1);
                    match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleModel286); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:193:6: ( KEYWORD_6 ( (lv_value_9_0= KEYWORD_8 ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:193:6: ( KEYWORD_6 ( (lv_value_9_0= KEYWORD_8 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:194:2: KEYWORD_6 ( (lv_value_9_0= KEYWORD_8 ) )
                    {
                    match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleModel318); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitFiveKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:198:1: ( (lv_value_9_0= KEYWORD_8 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:199:1: (lv_value_9_0= KEYWORD_8 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:199:1: (lv_value_9_0= KEYWORD_8 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:200:3: lv_value_9_0= KEYWORD_8
                    {
                    lv_value_9_0=(Token)input.LT(1);
                    match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleModel337); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:221:6: ( KEYWORD_7 ( (lv_value_11_0= KEYWORD_8 ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:221:6: ( KEYWORD_7 ( (lv_value_11_0= KEYWORD_8 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:222:2: KEYWORD_7 ( (lv_value_11_0= KEYWORD_8 ) )
                    {
                    match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_ruleModel369); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitSixKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:226:1: ( (lv_value_11_0= KEYWORD_8 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:227:1: (lv_value_11_0= KEYWORD_8 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:227:1: (lv_value_11_0= KEYWORD_8 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.g:228:3: lv_value_11_0= KEYWORD_8
                    {
                    lv_value_11_0=(Token)input.LT(1);
                    match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleModel388); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleModel114 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleModel133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_3_in_ruleModel165 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleModel184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleModel216 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleModel235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleModel267 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleModel286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleModel318 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleModel337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_7_in_ruleModel369 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleModel388 = new BitSet(new long[]{0x0000000000000002L});

}