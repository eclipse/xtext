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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foo\\\\bar'", "'foo\\\\'", "'\\\\bar'", "'\\\\'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalKeywordsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g"; }


     
     	private KeywordsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalKeywordsTestLanguageParser(TokenStream input, IAstFactory factory, KeywordsTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalKeywordsTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:70:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:71:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prModel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel72);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel82); 

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
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:78:1: ruleModel returns [EObject current=null] : ( ( ( (lv_first_0= 'foo\\\\bar' ) | (lv_second_1= 'foo\\\\' ) ) | (lv_third_2= '\\\\bar' ) ) | (lv_forth_3= '\\\\' ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_first_0=null;
        Token lv_second_1=null;
        Token lv_third_2=null;
        Token lv_forth_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:83:6: ( ( ( ( (lv_first_0= 'foo\\\\bar' ) | (lv_second_1= 'foo\\\\' ) ) | (lv_third_2= '\\\\bar' ) ) | (lv_forth_3= '\\\\' ) ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:84:1: ( ( ( (lv_first_0= 'foo\\\\bar' ) | (lv_second_1= 'foo\\\\' ) ) | (lv_third_2= '\\\\bar' ) ) | (lv_forth_3= '\\\\' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:84:1: ( ( ( (lv_first_0= 'foo\\\\bar' ) | (lv_second_1= 'foo\\\\' ) ) | (lv_third_2= '\\\\bar' ) ) | (lv_forth_3= '\\\\' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=11 && LA3_0<=13)) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("84:1: ( ( ( (lv_first_0= 'foo\\\\bar' ) | (lv_second_1= 'foo\\\\' ) ) | (lv_third_2= '\\\\bar' ) ) | (lv_forth_3= '\\\\' ) )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:84:2: ( ( (lv_first_0= 'foo\\\\bar' ) | (lv_second_1= 'foo\\\\' ) ) | (lv_third_2= '\\\\bar' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:84:2: ( ( (lv_first_0= 'foo\\\\bar' ) | (lv_second_1= 'foo\\\\' ) ) | (lv_third_2= '\\\\bar' ) )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( ((LA2_0>=11 && LA2_0<=12)) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==13) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("84:2: ( ( (lv_first_0= 'foo\\\\bar' ) | (lv_second_1= 'foo\\\\' ) ) | (lv_third_2= '\\\\bar' ) )", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:84:3: ( (lv_first_0= 'foo\\\\bar' ) | (lv_second_1= 'foo\\\\' ) )
                            {
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:84:3: ( (lv_first_0= 'foo\\\\bar' ) | (lv_second_1= 'foo\\\\' ) )
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==11) ) {
                                alt1=1;
                            }
                            else if ( (LA1_0==12) ) {
                                alt1=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("84:3: ( (lv_first_0= 'foo\\\\bar' ) | (lv_second_1= 'foo\\\\' ) )", 1, 0, input);

                                throw nvae;
                            }
                            switch (alt1) {
                                case 1 :
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:84:4: (lv_first_0= 'foo\\\\bar' )
                                    {
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:84:4: (lv_first_0= 'foo\\\\bar' )
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:86:6: lv_first_0= 'foo\\\\bar'
                                    {
                                    lv_first_0=(Token)input.LT(1);
                                    match(input,11,FOLLOW_11_in_ruleModel130); 

                                            createLeafNode(grammarAccess.prModel().ele0000KeywordFooBar(), "first"); 
                                        

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "first", true, "foo\\bar", lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:106:6: (lv_second_1= 'foo\\\\' )
                                    {
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:106:6: (lv_second_1= 'foo\\\\' )
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:108:6: lv_second_1= 'foo\\\\'
                                    {
                                    lv_second_1=(Token)input.LT(1);
                                    match(input,12,FOLLOW_12_in_ruleModel170); 

                                            createLeafNode(grammarAccess.prModel().ele0010KeywordFoo(), "second"); 
                                        

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "second", true, "foo\\", lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:128:6: (lv_third_2= '\\\\bar' )
                            {
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:128:6: (lv_third_2= '\\\\bar' )
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:130:6: lv_third_2= '\\\\bar'
                            {
                            lv_third_2=(Token)input.LT(1);
                            match(input,13,FOLLOW_13_in_ruleModel211); 

                                    createLeafNode(grammarAccess.prModel().ele010KeywordBar(), "third"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "third", true, "\\bar", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:150:6: (lv_forth_3= '\\\\' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:150:6: (lv_forth_3= '\\\\' )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:152:6: lv_forth_3= '\\\\'
                    {
                    lv_forth_3=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleModel252); 

                            createLeafNode(grammarAccess.prModel().ele10KeywordReverseSolidus(), "forth"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "forth", true, "\\", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleModel170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModel211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleModel252 = new BitSet(new long[]{0x0000000000000002L});

}