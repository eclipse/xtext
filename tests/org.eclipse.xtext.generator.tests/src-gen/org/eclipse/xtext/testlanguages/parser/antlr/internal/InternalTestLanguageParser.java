package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

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
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'choice'", "'optional'", "'reducible'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g"; }


     
     	private TestLanguageGrammarAccess grammarAccess;
     	
        public InternalTestLanguageParser(TokenStream input, IAstFactory factory, TestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EntryRule";	
       	} 



    // $ANTLR start entryRuleEntryRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:70:1: entryRuleEntryRule returns [EObject current=null] : iv_ruleEntryRule= ruleEntryRule EOF ;
    public final EObject entryRuleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:70:51: (iv_ruleEntryRule= ruleEntryRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:71:2: iv_ruleEntryRule= ruleEntryRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEntryRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntryRule_in_entryRuleEntryRule72);
            iv_ruleEntryRule=ruleEntryRule();
            _fsp--;

             current =iv_ruleEntryRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryRule82); 

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
    // $ANTLR end entryRuleEntryRule


    // $ANTLR start ruleEntryRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:78:1: ruleEntryRule returns [EObject current=null] : (lv_multiFeature_0= ruleAbstractRule )* ;
    public final EObject ruleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject lv_multiFeature_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:83:6: ( (lv_multiFeature_0= ruleAbstractRule )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:84:1: (lv_multiFeature_0= ruleAbstractRule )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:84:1: (lv_multiFeature_0= ruleAbstractRule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:87:6: lv_multiFeature_0= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEntryRule().ele0ParserRuleCallAbstractRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleEntryRule140);
            	    lv_multiFeature_0=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEntryRule().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "multiFeature", lv_multiFeature_0, "AbstractRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end ruleEntryRule


    // $ANTLR start entryRuleAbstractRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:114:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:114:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:115:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule179);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule189); 

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
    // $ANTLR end entryRuleAbstractRule


    // $ANTLR start ruleAbstractRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:122:1: ruleAbstractRule returns [EObject current=null] : (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ChoiceRule_0 = null;

        EObject this_ReducibleRule_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:127:6: ( (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:128:1: (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:128:1: (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("128:1: (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:129:5: this_ChoiceRule_0= ruleChoiceRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele0ParserRuleCallChoiceRule(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChoiceRule_in_ruleAbstractRule236);
                    this_ChoiceRule_0=ruleChoiceRule();
                    _fsp--;

                     
                            current = this_ChoiceRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:139:5: this_ReducibleRule_1= ruleReducibleRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele1ParserRuleCallReducibleRule(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReducibleRule_in_ruleAbstractRule263);
                    this_ReducibleRule_1=ruleReducibleRule();
                    _fsp--;

                     
                            current = this_ReducibleRule_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleAbstractRule


    // $ANTLR start entryRuleChoiceRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:156:1: entryRuleChoiceRule returns [EObject current=null] : iv_ruleChoiceRule= ruleChoiceRule EOF ;
    public final EObject entryRuleChoiceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoiceRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:156:52: (iv_ruleChoiceRule= ruleChoiceRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:157:2: iv_ruleChoiceRule= ruleChoiceRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prChoiceRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleChoiceRule_in_entryRuleChoiceRule297);
            iv_ruleChoiceRule=ruleChoiceRule();
            _fsp--;

             current =iv_ruleChoiceRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoiceRule307); 

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
    // $ANTLR end entryRuleChoiceRule


    // $ANTLR start ruleChoiceRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:164:1: ruleChoiceRule returns [EObject current=null] : ( ( 'choice' (lv_optionalKeyword_1= 'optional' )? ) (lv_name_2= RULE_ID ) ) ;
    public final EObject ruleChoiceRule() throws RecognitionException {
        EObject current = null;

        Token lv_optionalKeyword_1=null;
        Token lv_name_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:169:6: ( ( ( 'choice' (lv_optionalKeyword_1= 'optional' )? ) (lv_name_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:170:1: ( ( 'choice' (lv_optionalKeyword_1= 'optional' )? ) (lv_name_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:170:1: ( ( 'choice' (lv_optionalKeyword_1= 'optional' )? ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:170:2: ( 'choice' (lv_optionalKeyword_1= 'optional' )? ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:170:2: ( 'choice' (lv_optionalKeyword_1= 'optional' )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:170:3: 'choice' (lv_optionalKeyword_1= 'optional' )?
            {
            match(input,11,FOLLOW_11_in_ruleChoiceRule342); 

                    createLeafNode(grammarAccess.prChoiceRule().ele00KeywordChoice(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:174:1: (lv_optionalKeyword_1= 'optional' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:176:6: lv_optionalKeyword_1= 'optional'
                    {
                    lv_optionalKeyword_1=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_ruleChoiceRule363); 

                            createLeafNode(grammarAccess.prChoiceRule().ele010KeywordOptional(), "optionalKeyword"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prChoiceRule().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "optionalKeyword", true, "optional", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:195:4: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:197:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoiceRule400); 

            		createLeafNode(grammarAccess.prChoiceRule().ele10LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prChoiceRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleChoiceRule


    // $ANTLR start entryRuleReducibleRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:224:1: entryRuleReducibleRule returns [EObject current=null] : iv_ruleReducibleRule= ruleReducibleRule EOF ;
    public final EObject entryRuleReducibleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReducibleRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:224:55: (iv_ruleReducibleRule= ruleReducibleRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:225:2: iv_ruleReducibleRule= ruleReducibleRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prReducibleRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleReducibleRule_in_entryRuleReducibleRule443);
            iv_ruleReducibleRule=ruleReducibleRule();
            _fsp--;

             current =iv_ruleReducibleRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReducibleRule453); 

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
    // $ANTLR end entryRuleReducibleRule


    // $ANTLR start ruleReducibleRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:232:1: ruleReducibleRule returns [EObject current=null] : ( ( 'reducible' this_TerminalRule_1= ruleTerminalRule ) ( () (lv_actionFeature_3= ruleTerminalRule ) )? ) ;
    public final EObject ruleReducibleRule() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalRule_1 = null;

        EObject lv_actionFeature_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:237:6: ( ( ( 'reducible' this_TerminalRule_1= ruleTerminalRule ) ( () (lv_actionFeature_3= ruleTerminalRule ) )? ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:238:1: ( ( 'reducible' this_TerminalRule_1= ruleTerminalRule ) ( () (lv_actionFeature_3= ruleTerminalRule ) )? )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:238:1: ( ( 'reducible' this_TerminalRule_1= ruleTerminalRule ) ( () (lv_actionFeature_3= ruleTerminalRule ) )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:238:2: ( 'reducible' this_TerminalRule_1= ruleTerminalRule ) ( () (lv_actionFeature_3= ruleTerminalRule ) )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:238:2: ( 'reducible' this_TerminalRule_1= ruleTerminalRule )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:238:3: 'reducible' this_TerminalRule_1= ruleTerminalRule
            {
            match(input,13,FOLLOW_13_in_ruleReducibleRule488); 

                    createLeafNode(grammarAccess.prReducibleRule().ele00KeywordReducible(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prReducibleRule().ele01ParserRuleCallTerminalRule(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalRule_in_ruleReducibleRule510);
            this_TerminalRule_1=ruleTerminalRule();
            _fsp--;

             
                    current = this_TerminalRule_1; 
                    currentNode = currentNode.getParent();
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:251:2: ( () (lv_actionFeature_3= ruleTerminalRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:251:3: () (lv_actionFeature_3= ruleTerminalRule )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:251:3: ()
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:252:5: 
                    {
                     
                            temp=factory.create(grammarAccess.prReducibleRule().ele10ActionReducibleCompositeactionFeature().getTypeName().getType());
                            try {
                            	factory.add(temp, "actionFeature", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.prReducibleRule().ele10ActionReducibleCompositeactionFeature(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:267:2: (lv_actionFeature_3= ruleTerminalRule )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:270:6: lv_actionFeature_3= ruleTerminalRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prReducibleRule().ele110ParserRuleCallTerminalRule(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleReducibleRule554);
                    lv_actionFeature_3=ruleTerminalRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prReducibleRule().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "actionFeature", lv_actionFeature_3, "TerminalRule", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


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
    // $ANTLR end ruleReducibleRule


    // $ANTLR start entryRuleTerminalRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:297:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:297:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:298:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule595);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule605); 

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
    // $ANTLR end entryRuleTerminalRule


    // $ANTLR start ruleTerminalRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:305:1: ruleTerminalRule returns [EObject current=null] : (lv_stringFeature_0= RULE_STRING ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_stringFeature_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:310:6: ( (lv_stringFeature_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:311:1: (lv_stringFeature_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:311:1: (lv_stringFeature_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalTestLanguage.g:313:6: lv_stringFeature_0= RULE_STRING
            {
            lv_stringFeature_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTerminalRule651); 

            		createLeafNode(grammarAccess.prTerminalRule().ele0LexerRuleCallSTRING(), "stringFeature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prTerminalRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "stringFeature", lv_stringFeature_0, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end ruleTerminalRule


 

    public static final BitSet FOLLOW_ruleEntryRule_in_entryRuleEntryRule72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryRule82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleEntryRule140 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoiceRule_in_ruleAbstractRule236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReducibleRule_in_ruleAbstractRule263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoiceRule_in_entryRuleChoiceRule297 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoiceRule307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleChoiceRule342 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleChoiceRule363 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoiceRule400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReducibleRule_in_entryRuleReducibleRule443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReducibleRule453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleReducibleRule488 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule510 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule595 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTerminalRule651 = new BitSet(new long[]{0x0000000000000002L});

}