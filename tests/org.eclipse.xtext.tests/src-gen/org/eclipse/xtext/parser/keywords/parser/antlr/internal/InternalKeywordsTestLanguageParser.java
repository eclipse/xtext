package org.eclipse.xtext.parser.keywords.parser.antlr.internal; 

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
import org.eclipse.xtext.parser.keywords.services.KeywordsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalKeywordsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foo\\\\bar'", "'foo\\\\'", "'\\\\bar'", "'\\\\'", "'\"a\"'", "'\\'b\\''", "'\\'c\\''", "'\"d\"'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalKeywordsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g"; }



     	private KeywordsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalKeywordsTestLanguageParser(TokenStream input, IAstFactory factory, KeywordsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected KeywordsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_first_0_0=null;
        Token lv_second_1_0=null;
        Token lv_third_2_0=null;
        Token lv_forth_3_0=null;
        Token lv_fifth_4_0=null;
        Token lv_sixth_5_0=null;
        Token lv_seventh_6_0=null;
        Token lv_eighth_7_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:91:6: ( ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:92:1: ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:92:1: ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) )
            int alt1=8;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            case 15:
                {
                alt1=5;
                }
                break;
            case 16:
                {
                alt1=6;
                }
                break;
            case 17:
                {
                alt1=7;
                }
                break;
            case 18:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("92:1: ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:92:2: ( (lv_first_0_0= 'foo\\\\bar' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:92:2: ( (lv_first_0_0= 'foo\\\\bar' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:93:1: (lv_first_0_0= 'foo\\\\bar' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:93:1: (lv_first_0_0= 'foo\\\\bar' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:94:3: lv_first_0_0= 'foo\\\\bar'
                    {
                    lv_first_0_0=(Token)input.LT(1);
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleModel128); 

                            createLeafNode(grammarAccess.getModelAccess().getFirstFooBarKeyword_0_0(), "first"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "first", true, "foo\\bar", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:114:6: ( (lv_second_1_0= 'foo\\\\' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:114:6: ( (lv_second_1_0= 'foo\\\\' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:115:1: (lv_second_1_0= 'foo\\\\' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:115:1: (lv_second_1_0= 'foo\\\\' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:116:3: lv_second_1_0= 'foo\\\\'
                    {
                    lv_second_1_0=(Token)input.LT(1);
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel165); 

                            createLeafNode(grammarAccess.getModelAccess().getSecondFooKeyword_1_0(), "second"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "second", true, "foo\\", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:136:6: ( (lv_third_2_0= '\\\\bar' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:136:6: ( (lv_third_2_0= '\\\\bar' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:137:1: (lv_third_2_0= '\\\\bar' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:137:1: (lv_third_2_0= '\\\\bar' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:138:3: lv_third_2_0= '\\\\bar'
                    {
                    lv_third_2_0=(Token)input.LT(1);
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel202); 

                            createLeafNode(grammarAccess.getModelAccess().getThirdBarKeyword_2_0(), "third"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "third", true, "\\bar", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:158:6: ( (lv_forth_3_0= '\\\\' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:158:6: ( (lv_forth_3_0= '\\\\' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:159:1: (lv_forth_3_0= '\\\\' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:159:1: (lv_forth_3_0= '\\\\' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:160:3: lv_forth_3_0= '\\\\'
                    {
                    lv_forth_3_0=(Token)input.LT(1);
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleModel239); 

                            createLeafNode(grammarAccess.getModelAccess().getForthReverseSolidusKeyword_3_0(), "forth"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "forth", true, "\\", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:180:6: ( (lv_fifth_4_0= '\"a\"' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:180:6: ( (lv_fifth_4_0= '\"a\"' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:181:1: (lv_fifth_4_0= '\"a\"' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:181:1: (lv_fifth_4_0= '\"a\"' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:182:3: lv_fifth_4_0= '\"a\"'
                    {
                    lv_fifth_4_0=(Token)input.LT(1);
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleModel276); 

                            createLeafNode(grammarAccess.getModelAccess().getFifthAKeyword_4_0(), "fifth"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "fifth", true, "\"a\"", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:202:6: ( (lv_sixth_5_0= '\\'b\\'' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:202:6: ( (lv_sixth_5_0= '\\'b\\'' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:203:1: (lv_sixth_5_0= '\\'b\\'' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:203:1: (lv_sixth_5_0= '\\'b\\'' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:204:3: lv_sixth_5_0= '\\'b\\''
                    {
                    lv_sixth_5_0=(Token)input.LT(1);
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleModel313); 

                            createLeafNode(grammarAccess.getModelAccess().getSixthBKeyword_5_0(), "sixth"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "sixth", true, "\'b\'", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:224:6: ( (lv_seventh_6_0= '\\'c\\'' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:224:6: ( (lv_seventh_6_0= '\\'c\\'' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:225:1: (lv_seventh_6_0= '\\'c\\'' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:225:1: (lv_seventh_6_0= '\\'c\\'' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:226:3: lv_seventh_6_0= '\\'c\\''
                    {
                    lv_seventh_6_0=(Token)input.LT(1);
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleModel350); 

                            createLeafNode(grammarAccess.getModelAccess().getSeventhCKeyword_6_0(), "seventh"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "seventh", true, "\'c\'", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:246:6: ( (lv_eighth_7_0= '\"d\"' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:246:6: ( (lv_eighth_7_0= '\"d\"' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:247:1: (lv_eighth_7_0= '\"d\"' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:247:1: (lv_eighth_7_0= '\"d\"' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:248:3: lv_eighth_7_0= '\"d\"'
                    {
                    lv_eighth_7_0=(Token)input.LT(1);
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleModel387); 

                            createLeafNode(grammarAccess.getModelAccess().getEighthDKeyword_7_0(), "eighth"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "eighth", true, "\"d\"", lastConsumedNode);
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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleModel387 = new BitSet(new long[]{0x0000000000000002L});
    }


}