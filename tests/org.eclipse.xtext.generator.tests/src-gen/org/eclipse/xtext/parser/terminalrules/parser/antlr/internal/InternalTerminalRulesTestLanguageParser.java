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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g"; }


     
        public InternalTerminalRulesTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalTerminalRulesTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:68:47: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( ( ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) ) | (lv_slCommentValue= RULE_SL_COMMENT ) ) | (lv_wsValue= RULE_WS ) ) | (lv_anyValue= RULE_ANY_OTHER ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_idValue=null;
        Token lv_intValue=null;
        Token lv_stringValue=null;
        Token lv_mlCommentValue=null;
        Token lv_slCommentValue=null;
        Token lv_wsValue=null;
        Token lv_anyValue=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:80:6: ( ( ( ( ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) ) | (lv_slCommentValue= RULE_SL_COMMENT ) ) | (lv_wsValue= RULE_WS ) ) | (lv_anyValue= RULE_ANY_OTHER ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:1: ( ( ( ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) ) | (lv_slCommentValue= RULE_SL_COMMENT ) ) | (lv_wsValue= RULE_WS ) ) | (lv_anyValue= RULE_ANY_OTHER ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:1: ( ( ( ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) ) | (lv_slCommentValue= RULE_SL_COMMENT ) ) | (lv_wsValue= RULE_WS ) ) | (lv_anyValue= RULE_ANY_OTHER ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_WS)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ANY_OTHER) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("81:1: ( ( ( ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) ) | (lv_slCommentValue= RULE_SL_COMMENT ) ) | (lv_wsValue= RULE_WS ) ) | (lv_anyValue= RULE_ANY_OTHER ) )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:2: ( ( ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) ) | (lv_slCommentValue= RULE_SL_COMMENT ) ) | (lv_wsValue= RULE_WS ) )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:2: ( ( ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) ) | (lv_slCommentValue= RULE_SL_COMMENT ) ) | (lv_wsValue= RULE_WS ) )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_SL_COMMENT)) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==RULE_WS) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("81:2: ( ( ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) ) | (lv_slCommentValue= RULE_SL_COMMENT ) ) | (lv_wsValue= RULE_WS ) )", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:3: ( ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) ) | (lv_slCommentValue= RULE_SL_COMMENT ) )
                            {
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:3: ( ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) ) | (lv_slCommentValue= RULE_SL_COMMENT ) )
                            int alt4=2;
                            int LA4_0 = input.LA(1);

                            if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_ML_COMMENT)) ) {
                                alt4=1;
                            }
                            else if ( (LA4_0==RULE_SL_COMMENT) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("81:3: ( ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) ) | (lv_slCommentValue= RULE_SL_COMMENT ) )", 4, 0, input);

                                throw nvae;
                            }
                            switch (alt4) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:4: ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) )
                                    {
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:4: ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) )
                                    int alt3=2;
                                    int LA3_0 = input.LA(1);

                                    if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_STRING)) ) {
                                        alt3=1;
                                    }
                                    else if ( (LA3_0==RULE_ML_COMMENT) ) {
                                        alt3=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("81:4: ( ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) ) | (lv_mlCommentValue= RULE_ML_COMMENT ) )", 3, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt3) {
                                        case 1 :
                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:5: ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) )
                                            {
                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:5: ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) )
                                            int alt2=2;
                                            int LA2_0 = input.LA(1);

                                            if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_INT)) ) {
                                                alt2=1;
                                            }
                                            else if ( (LA2_0==RULE_STRING) ) {
                                                alt2=2;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("81:5: ( ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) ) | (lv_stringValue= RULE_STRING ) )", 2, 0, input);

                                                throw nvae;
                                            }
                                            switch (alt2) {
                                                case 1 :
                                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:6: ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) )
                                                    {
                                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:6: ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) )
                                                    int alt1=2;
                                                    int LA1_0 = input.LA(1);

                                                    if ( (LA1_0==RULE_ID) ) {
                                                        alt1=1;
                                                    }
                                                    else if ( (LA1_0==RULE_INT) ) {
                                                        alt1=2;
                                                    }
                                                    else {
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("81:6: ( (lv_idValue= RULE_ID ) | (lv_intValue= RULE_INT ) )", 1, 0, input);

                                                        throw nvae;
                                                    }
                                                    switch (alt1) {
                                                        case 1 :
                                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:7: (lv_idValue= RULE_ID )
                                                            {
                                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:81:7: (lv_idValue= RULE_ID )
                                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:83:6: lv_idValue= RULE_ID
                                                            {
                                                            lv_idValue=(Token)input.LT(1);
                                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel133); 
                                                             
                                                                createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, "idValue"); 
                                                                

                                                            	        if (current==null) {
                                                            	            current = factory.create("Model");
                                                            	            associateNodeWithAstElement(currentNode, current);
                                                            	        }
                                                            	        
                                                            	        try {
                                                            	        	factory.set(current, "idValue", lv_idValue, "ID", currentNode);
                                                            	        } catch (ValueConverterException vce) {
                                                            				handleValueConverterException(vce);
                                                            	        }
                                                            	    

                                                            }


                                                            }
                                                            break;
                                                        case 2 :
                                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:102:6: (lv_intValue= RULE_INT )
                                                            {
                                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:102:6: (lv_intValue= RULE_INT )
                                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:104:6: lv_intValue= RULE_INT
                                                            {
                                                            lv_intValue=(Token)input.LT(1);
                                                            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleModel171); 
                                                             
                                                                createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "intValue"); 
                                                                

                                                            	        if (current==null) {
                                                            	            current = factory.create("Model");
                                                            	            associateNodeWithAstElement(currentNode, current);
                                                            	        }
                                                            	        
                                                            	        try {
                                                            	        	factory.set(current, "intValue", lv_intValue, "INT", currentNode);
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
                                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:123:6: (lv_stringValue= RULE_STRING )
                                                    {
                                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:123:6: (lv_stringValue= RULE_STRING )
                                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:125:6: lv_stringValue= RULE_STRING
                                                    {
                                                    lv_stringValue=(Token)input.LT(1);
                                                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel210); 
                                                     
                                                        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "stringValue"); 
                                                        

                                                    	        if (current==null) {
                                                    	            current = factory.create("Model");
                                                    	            associateNodeWithAstElement(currentNode, current);
                                                    	        }
                                                    	        
                                                    	        try {
                                                    	        	factory.set(current, "stringValue", lv_stringValue, "STRING", currentNode);
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
                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:144:6: (lv_mlCommentValue= RULE_ML_COMMENT )
                                            {
                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:144:6: (lv_mlCommentValue= RULE_ML_COMMENT )
                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:146:6: lv_mlCommentValue= RULE_ML_COMMENT
                                            {
                                            lv_mlCommentValue=(Token)input.LT(1);
                                            match(input,RULE_ML_COMMENT,FOLLOW_RULE_ML_COMMENT_in_ruleModel249); 
                                             
                                                createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "mlCommentValue"); 
                                                

                                            	        if (current==null) {
                                            	            current = factory.create("Model");
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	        	factory.set(current, "mlCommentValue", lv_mlCommentValue, "ML_COMMENT", currentNode);
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
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:165:6: (lv_slCommentValue= RULE_SL_COMMENT )
                                    {
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:165:6: (lv_slCommentValue= RULE_SL_COMMENT )
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:167:6: lv_slCommentValue= RULE_SL_COMMENT
                                    {
                                    lv_slCommentValue=(Token)input.LT(1);
                                    match(input,RULE_SL_COMMENT,FOLLOW_RULE_SL_COMMENT_in_ruleModel288); 
                                     
                                        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "slCommentValue"); 
                                        

                                    	        if (current==null) {
                                    	            current = factory.create("Model");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	        	factory.set(current, "slCommentValue", lv_slCommentValue, "SL_COMMENT", currentNode);
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
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:186:6: (lv_wsValue= RULE_WS )
                            {
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:186:6: (lv_wsValue= RULE_WS )
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:188:6: lv_wsValue= RULE_WS
                            {
                            lv_wsValue=(Token)input.LT(1);
                            match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleModel327); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, "wsValue"); 
                                

                            	        if (current==null) {
                            	            current = factory.create("Model");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "wsValue", lv_wsValue, "WS", currentNode);
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
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:207:6: (lv_anyValue= RULE_ANY_OTHER )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:207:6: (lv_anyValue= RULE_ANY_OTHER )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:209:6: lv_anyValue= RULE_ANY_OTHER
                    {
                    lv_anyValue=(Token)input.LT(1);
                    match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_ruleModel366); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi#//@rules.0/@alternatives/@groups.1/@terminal" /* xtext::RuleCall */, "anyValue"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Model");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "anyValue", lv_anyValue, "ANY_OTHER", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

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
    // $ANTLR end ruleModel


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleModel171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_COMMENT_in_ruleModel249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_COMMENT_in_ruleModel288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleModel327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_ruleModel366 = new BitSet(new long[]{0x0000000000000002L});

}