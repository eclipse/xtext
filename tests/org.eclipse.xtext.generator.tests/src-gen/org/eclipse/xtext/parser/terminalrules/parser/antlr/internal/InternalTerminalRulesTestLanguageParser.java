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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g"; }


     
     	private TerminalRulesTestLanguageGrammarAccess grammarAccess;
     	
        public InternalTerminalRulesTestLanguageParser(TokenStream input, IAstFactory factory, TerminalRulesTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:70:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:71:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:78:1: ruleModel returns [EObject current=null] : ( ( ( ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) ) | (lv_slCommentValue_4= RULE_SL_COMMENT ) ) | (lv_wsValue_5= RULE_WS ) ) | (lv_anyValue_6= RULE_ANY_OTHER ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_idValue_0=null;
        Token lv_intValue_1=null;
        Token lv_stringValue_2=null;
        Token lv_mlCommentValue_3=null;
        Token lv_slCommentValue_4=null;
        Token lv_wsValue_5=null;
        Token lv_anyValue_6=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:83:6: ( ( ( ( ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) ) | (lv_slCommentValue_4= RULE_SL_COMMENT ) ) | (lv_wsValue_5= RULE_WS ) ) | (lv_anyValue_6= RULE_ANY_OTHER ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:1: ( ( ( ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) ) | (lv_slCommentValue_4= RULE_SL_COMMENT ) ) | (lv_wsValue_5= RULE_WS ) ) | (lv_anyValue_6= RULE_ANY_OTHER ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:1: ( ( ( ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) ) | (lv_slCommentValue_4= RULE_SL_COMMENT ) ) | (lv_wsValue_5= RULE_WS ) ) | (lv_anyValue_6= RULE_ANY_OTHER ) )
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
                    new NoViableAltException("84:1: ( ( ( ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) ) | (lv_slCommentValue_4= RULE_SL_COMMENT ) ) | (lv_wsValue_5= RULE_WS ) ) | (lv_anyValue_6= RULE_ANY_OTHER ) )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:2: ( ( ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) ) | (lv_slCommentValue_4= RULE_SL_COMMENT ) ) | (lv_wsValue_5= RULE_WS ) )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:2: ( ( ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) ) | (lv_slCommentValue_4= RULE_SL_COMMENT ) ) | (lv_wsValue_5= RULE_WS ) )
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
                            new NoViableAltException("84:2: ( ( ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) ) | (lv_slCommentValue_4= RULE_SL_COMMENT ) ) | (lv_wsValue_5= RULE_WS ) )", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:3: ( ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) ) | (lv_slCommentValue_4= RULE_SL_COMMENT ) )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:3: ( ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) ) | (lv_slCommentValue_4= RULE_SL_COMMENT ) )
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
                                    new NoViableAltException("84:3: ( ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) ) | (lv_slCommentValue_4= RULE_SL_COMMENT ) )", 4, 0, input);

                                throw nvae;
                            }
                            switch (alt4) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:4: ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:4: ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) )
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
                                            new NoViableAltException("84:4: ( ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) ) | (lv_mlCommentValue_3= RULE_ML_COMMENT ) )", 3, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt3) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:5: ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:5: ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) )
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
                                                    new NoViableAltException("84:5: ( ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) ) | (lv_stringValue_2= RULE_STRING ) )", 2, 0, input);

                                                throw nvae;
                                            }
                                            switch (alt2) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:6: ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) )
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:6: ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) )
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
                                                            new NoViableAltException("84:6: ( (lv_idValue_0= RULE_ID ) | (lv_intValue_1= RULE_INT ) )", 1, 0, input);

                                                        throw nvae;
                                                    }
                                                    switch (alt1) {
                                                        case 1 :
                                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:7: (lv_idValue_0= RULE_ID )
                                                            {
                                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:84:7: (lv_idValue_0= RULE_ID )
                                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:86:6: lv_idValue_0= RULE_ID
                                                            {
                                                            lv_idValue_0=(Token)input.LT(1);
                                                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel133); 

                                                            		createLeafNode(grammarAccess.prModel().ele0000000ParserRuleCallID(), "idValue"); 
                                                            	

                                                            	        if (current==null) {
                                                            	            current = factory.create("Model");
                                                            	            associateNodeWithAstElement(currentNode, current);
                                                            	        }
                                                            	        
                                                            	        try {
                                                            	       		set(current, "idValue", lv_idValue_0, "ID", lastConsumedNode);
                                                            	        } catch (ValueConverterException vce) {
                                                            				handleValueConverterException(vce);
                                                            	        }
                                                            	    

                                                            }


                                                            }
                                                            break;
                                                        case 2 :
                                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:104:6: (lv_intValue_1= RULE_INT )
                                                            {
                                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:104:6: (lv_intValue_1= RULE_INT )
                                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:106:6: lv_intValue_1= RULE_INT
                                                            {
                                                            lv_intValue_1=(Token)input.LT(1);
                                                            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleModel167); 

                                                            		createLeafNode(grammarAccess.prModel().ele0000010ParserRuleCallINT(), "intValue"); 
                                                            	

                                                            	        if (current==null) {
                                                            	            current = factory.create("Model");
                                                            	            associateNodeWithAstElement(currentNode, current);
                                                            	        }
                                                            	        
                                                            	        try {
                                                            	       		set(current, "intValue", lv_intValue_1, "INT", lastConsumedNode);
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
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:124:6: (lv_stringValue_2= RULE_STRING )
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:124:6: (lv_stringValue_2= RULE_STRING )
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:126:6: lv_stringValue_2= RULE_STRING
                                                    {
                                                    lv_stringValue_2=(Token)input.LT(1);
                                                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel202); 

                                                    		createLeafNode(grammarAccess.prModel().ele000010ParserRuleCallSTRING(), "stringValue"); 
                                                    	

                                                    	        if (current==null) {
                                                    	            current = factory.create("Model");
                                                    	            associateNodeWithAstElement(currentNode, current);
                                                    	        }
                                                    	        
                                                    	        try {
                                                    	       		set(current, "stringValue", lv_stringValue_2, "STRING", lastConsumedNode);
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
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:144:6: (lv_mlCommentValue_3= RULE_ML_COMMENT )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:144:6: (lv_mlCommentValue_3= RULE_ML_COMMENT )
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:146:6: lv_mlCommentValue_3= RULE_ML_COMMENT
                                            {
                                            lv_mlCommentValue_3=(Token)input.LT(1);
                                            match(input,RULE_ML_COMMENT,FOLLOW_RULE_ML_COMMENT_in_ruleModel237); 

                                            		createLeafNode(grammarAccess.prModel().ele00010ParserRuleCallML_COMMENT(), "mlCommentValue"); 
                                            	

                                            	        if (current==null) {
                                            	            current = factory.create("Model");
                                            	            associateNodeWithAstElement(currentNode, current);
                                            	        }
                                            	        
                                            	        try {
                                            	       		set(current, "mlCommentValue", lv_mlCommentValue_3, "ML_COMMENT", lastConsumedNode);
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
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:164:6: (lv_slCommentValue_4= RULE_SL_COMMENT )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:164:6: (lv_slCommentValue_4= RULE_SL_COMMENT )
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:166:6: lv_slCommentValue_4= RULE_SL_COMMENT
                                    {
                                    lv_slCommentValue_4=(Token)input.LT(1);
                                    match(input,RULE_SL_COMMENT,FOLLOW_RULE_SL_COMMENT_in_ruleModel272); 

                                    		createLeafNode(grammarAccess.prModel().ele0010ParserRuleCallSL_COMMENT(), "slCommentValue"); 
                                    	

                                    	        if (current==null) {
                                    	            current = factory.create("Model");
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "slCommentValue", lv_slCommentValue_4, "SL_COMMENT", lastConsumedNode);
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
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:184:6: (lv_wsValue_5= RULE_WS )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:184:6: (lv_wsValue_5= RULE_WS )
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:186:6: lv_wsValue_5= RULE_WS
                            {
                            lv_wsValue_5=(Token)input.LT(1);
                            match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleModel307); 

                            		createLeafNode(grammarAccess.prModel().ele010ParserRuleCallWS(), "wsValue"); 
                            	

                            	        if (current==null) {
                            	            current = factory.create("Model");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "wsValue", lv_wsValue_5, "WS", lastConsumedNode);
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:204:6: (lv_anyValue_6= RULE_ANY_OTHER )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:204:6: (lv_anyValue_6= RULE_ANY_OTHER )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalTerminalRulesTestLanguage.g:206:6: lv_anyValue_6= RULE_ANY_OTHER
                    {
                    lv_anyValue_6=(Token)input.LT(1);
                    match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_ruleModel342); 

                    		createLeafNode(grammarAccess.prModel().ele10ParserRuleCallANY_OTHER(), "anyValue"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create("Model");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "anyValue", lv_anyValue_6, "ANY_OTHER", lastConsumedNode);
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
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleModel167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_COMMENT_in_ruleModel237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_COMMENT_in_ruleModel272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleModel307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_ruleModel342 = new BitSet(new long[]{0x0000000000000002L});

}