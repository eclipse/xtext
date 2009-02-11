package org.eclipse.xtext.valueconverter.parser.antlr.internal; 

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

public class InternalBug250313Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#2'", "'mykeyword1'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug250313Parser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g"; }


     
        public InternalBug250313Parser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalBug250313Parser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Ref2";	
       	} 



    // $ANTLR start entryRuleRef2
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:68:1: entryRuleRef2 returns [EObject current=null] : iv_ruleRef2= ruleRef2 EOF ;
    public final EObject entryRuleRef2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRef2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:68:46: (iv_ruleRef2= ruleRef2 EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:69:2: iv_ruleRef2= ruleRef2 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#/0/@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRef2_in_entryRuleRef272);
            iv_ruleRef2=ruleRef2();
            _fsp--;

             current =iv_ruleRef2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRef282); 

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
    // $ANTLR end entryRuleRef2


    // $ANTLR start ruleRef2
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:76:1: ruleRef2 returns [EObject current=null] : ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | RULE_ID ) ) ) ;
    public final EObject ruleRef2() throws RecognitionException {
        EObject current = null;

        Token lv_ref2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:80:6: ( ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:81:1: ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:81:1: ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:81:2: '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | RULE_ID ) )
            {
            match(input,11,FOLLOW_11_in_ruleRef2116); 

                    createLeafNode("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#/0/@rules.0/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:85:1: (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:87:6: lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:87:14: ( ( 'mykeyword1' | RULE_STRING ) | RULE_ID )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING||LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("87:14: ( ( 'mykeyword1' | RULE_STRING ) | RULE_ID )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:87:15: ( 'mykeyword1' | RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:87:15: ( 'mykeyword1' | RULE_STRING )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==12) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==RULE_STRING) ) {
                        alt1=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("87:15: ( 'mykeyword1' | RULE_STRING )", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:87:16: 'mykeyword1'
                            {
                            match(input,12,FOLLOW_12_in_ruleRef2139); 

                                    createLeafNode("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#/0/@rules.0/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "ref2"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:92:6: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRef2154); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#/0/@rules.0/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::RuleCall */, "ref2"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:97:6: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRef2169); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi#/0/@rules.0/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::RuleCall */, "ref2"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Ref2");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "ref2", input.LT(-1), null, currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRef2


 

    public static final BitSet FOLLOW_ruleRef2_in_entryRuleRef272 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRef282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRef2116 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_12_in_ruleRef2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRef2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRef2169 = new BitSet(new long[]{0x0000000000000002L});

}