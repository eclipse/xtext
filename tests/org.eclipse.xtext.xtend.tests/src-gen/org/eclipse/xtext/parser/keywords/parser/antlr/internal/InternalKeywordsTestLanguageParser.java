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
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g"; }


     
        public InternalKeywordsTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:68:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/keywords/KeywordsTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( ( (lv_first= 'foo\\\\bar' ) | (lv_second= 'foo\\\\' ) ) | (lv_third= '\\\\bar' ) ) | (lv_forth= '\\\\' ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_first=null;
        Token lv_second=null;
        Token lv_third=null;
        Token lv_forth=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:82:6: ( ( ( ( (lv_first= 'foo\\\\bar' ) | (lv_second= 'foo\\\\' ) ) | (lv_third= '\\\\bar' ) ) | (lv_forth= '\\\\' ) ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:83:1: ( ( ( (lv_first= 'foo\\\\bar' ) | (lv_second= 'foo\\\\' ) ) | (lv_third= '\\\\bar' ) ) | (lv_forth= '\\\\' ) )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:83:1: ( ( ( (lv_first= 'foo\\\\bar' ) | (lv_second= 'foo\\\\' ) ) | (lv_third= '\\\\bar' ) ) | (lv_forth= '\\\\' ) )
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
                    new NoViableAltException("83:1: ( ( ( (lv_first= 'foo\\\\bar' ) | (lv_second= 'foo\\\\' ) ) | (lv_third= '\\\\bar' ) ) | (lv_forth= '\\\\' ) )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:83:2: ( ( (lv_first= 'foo\\\\bar' ) | (lv_second= 'foo\\\\' ) ) | (lv_third= '\\\\bar' ) )
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:83:2: ( ( (lv_first= 'foo\\\\bar' ) | (lv_second= 'foo\\\\' ) ) | (lv_third= '\\\\bar' ) )
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
                            new NoViableAltException("83:2: ( ( (lv_first= 'foo\\\\bar' ) | (lv_second= 'foo\\\\' ) ) | (lv_third= '\\\\bar' ) )", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:83:3: ( (lv_first= 'foo\\\\bar' ) | (lv_second= 'foo\\\\' ) )
                            {
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:83:3: ( (lv_first= 'foo\\\\bar' ) | (lv_second= 'foo\\\\' ) )
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
                                    new NoViableAltException("83:3: ( (lv_first= 'foo\\\\bar' ) | (lv_second= 'foo\\\\' ) )", 1, 0, input);

                                throw nvae;
                            }
                            switch (alt1) {
                                case 1 :
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:83:4: (lv_first= 'foo\\\\bar' )
                                    {
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:83:4: (lv_first= 'foo\\\\bar' )
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:85:6: lv_first= 'foo\\\\bar'
                                    {
                                    lv_first=(Token)input.LT(1);
                                    match(input,11,FOLLOW_11_in_ruleModel130); 

                                            createLeafNode("classpath:/org/eclipse/xtext/parser/keywords/KeywordsTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::Keyword */, "first"); 
                                        

                                    	        if (current==null) {
                                    	            current = factory.create("Model");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	        	factory.set(current, "first", true, "foo\\bar", currentNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:104:6: (lv_second= 'foo\\\\' )
                                    {
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:104:6: (lv_second= 'foo\\\\' )
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:106:6: lv_second= 'foo\\\\'
                                    {
                                    lv_second=(Token)input.LT(1);
                                    match(input,12,FOLLOW_12_in_ruleModel169); 

                                            createLeafNode("classpath:/org/eclipse/xtext/parser/keywords/KeywordsTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "second"); 
                                        

                                    	        if (current==null) {
                                    	            current = factory.create("Model");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	        	factory.set(current, "second", true, "foo\\", currentNode);
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
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:125:6: (lv_third= '\\\\bar' )
                            {
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:125:6: (lv_third= '\\\\bar' )
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:127:6: lv_third= '\\\\bar'
                            {
                            lv_third=(Token)input.LT(1);
                            match(input,13,FOLLOW_13_in_ruleModel209); 

                                    createLeafNode("classpath:/org/eclipse/xtext/parser/keywords/KeywordsTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.1/@terminal" /* xtext::Keyword */, "third"); 
                                

                            	        if (current==null) {
                            	            current = factory.create("Model");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "third", true, "\\bar", currentNode);
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
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:146:6: (lv_forth= '\\\\' )
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:146:6: (lv_forth= '\\\\' )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/keywords/parser/antlr/internal/InternalKeywordsTestLanguage.g:148:6: lv_forth= '\\\\'
                    {
                    lv_forth=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleModel249); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/keywords/KeywordsTestLanguage.xmi#//@rules.0/@alternatives/@groups.1/@terminal" /* xtext::Keyword */, "forth"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Model");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "forth", true, "\\", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
            		myHiddenTokenState.restore();
                
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
    public static final BitSet FOLLOW_12_in_ruleModel169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModel209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleModel249 = new BitSet(new long[]{0x0000000000000002L});

}