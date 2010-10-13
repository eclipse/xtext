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

@SuppressWarnings("all")
public class InternalKeywordsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foo\\\\bar'", "'foo\\\\'", "'\\\\bar'", "'\\\\'", "'\"a\"'", "'\\'b\\''", "'\\'c\\''", "'\"d\"'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalKeywordsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalKeywordsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalKeywordsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g"; }



     	private KeywordsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalKeywordsTestLanguageParser(TokenStream input, IAstFactory factory, KeywordsTestLanguageGrammarAccess grammarAccess) {
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
       	protected KeywordsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) ) ;
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

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:85:6: ( ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:86:1: ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:86:1: ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:86:2: ( (lv_first_0_0= 'foo\\\\bar' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:86:2: ( (lv_first_0_0= 'foo\\\\bar' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:87:1: (lv_first_0_0= 'foo\\\\bar' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:87:1: (lv_first_0_0= 'foo\\\\bar' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:88:3: lv_first_0_0= 'foo\\\\bar'
                    {
                    lv_first_0_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel128); 

                            createLeafNode(lv_first_0_0, grammarAccess.getModelAccess().getFirstFooBarKeyword_0_0(), "first");
                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:108:6: ( (lv_second_1_0= 'foo\\\\' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:108:6: ( (lv_second_1_0= 'foo\\\\' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:109:1: (lv_second_1_0= 'foo\\\\' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:109:1: (lv_second_1_0= 'foo\\\\' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:110:3: lv_second_1_0= 'foo\\\\'
                    {
                    lv_second_1_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel165); 

                            createLeafNode(lv_second_1_0, grammarAccess.getModelAccess().getSecondFooKeyword_1_0(), "second");
                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:130:6: ( (lv_third_2_0= '\\\\bar' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:130:6: ( (lv_third_2_0= '\\\\bar' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:131:1: (lv_third_2_0= '\\\\bar' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:131:1: (lv_third_2_0= '\\\\bar' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:132:3: lv_third_2_0= '\\\\bar'
                    {
                    lv_third_2_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel202); 

                            createLeafNode(lv_third_2_0, grammarAccess.getModelAccess().getThirdBarKeyword_2_0(), "third");
                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:152:6: ( (lv_forth_3_0= '\\\\' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:152:6: ( (lv_forth_3_0= '\\\\' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:153:1: (lv_forth_3_0= '\\\\' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:153:1: (lv_forth_3_0= '\\\\' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:154:3: lv_forth_3_0= '\\\\'
                    {
                    lv_forth_3_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel239); 

                            createLeafNode(lv_forth_3_0, grammarAccess.getModelAccess().getForthReverseSolidusKeyword_3_0(), "forth");
                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:174:6: ( (lv_fifth_4_0= '\"a\"' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:174:6: ( (lv_fifth_4_0= '\"a\"' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:175:1: (lv_fifth_4_0= '\"a\"' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:175:1: (lv_fifth_4_0= '\"a\"' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:176:3: lv_fifth_4_0= '\"a\"'
                    {
                    lv_fifth_4_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel276); 

                            createLeafNode(lv_fifth_4_0, grammarAccess.getModelAccess().getFifthAKeyword_4_0(), "fifth");
                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:196:6: ( (lv_sixth_5_0= '\\'b\\'' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:196:6: ( (lv_sixth_5_0= '\\'b\\'' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:197:1: (lv_sixth_5_0= '\\'b\\'' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:197:1: (lv_sixth_5_0= '\\'b\\'' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:198:3: lv_sixth_5_0= '\\'b\\''
                    {
                    lv_sixth_5_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel313); 

                            createLeafNode(lv_sixth_5_0, grammarAccess.getModelAccess().getSixthBKeyword_5_0(), "sixth");
                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:218:6: ( (lv_seventh_6_0= '\\'c\\'' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:218:6: ( (lv_seventh_6_0= '\\'c\\'' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:219:1: (lv_seventh_6_0= '\\'c\\'' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:219:1: (lv_seventh_6_0= '\\'c\\'' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:220:3: lv_seventh_6_0= '\\'c\\''
                    {
                    lv_seventh_6_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModel350); 

                            createLeafNode(lv_seventh_6_0, grammarAccess.getModelAccess().getSeventhCKeyword_6_0(), "seventh");
                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:240:6: ( (lv_eighth_7_0= '\"d\"' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:240:6: ( (lv_eighth_7_0= '\"d\"' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:241:1: (lv_eighth_7_0= '\"d\"' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:241:1: (lv_eighth_7_0= '\"d\"' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:242:3: lv_eighth_7_0= '\"d\"'
                    {
                    lv_eighth_7_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModel387); 

                            createLeafNode(lv_eighth_7_0, grammarAccess.getModelAccess().getEighthDKeyword_7_0(), "eighth");
                        

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
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
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