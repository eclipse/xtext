package org.eclipse.xtext.parsetree.transientvalues.parser.antlr.internal; 

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
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTransientValuesTestParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "'required'", "'optional'", "':'", "'list'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalTransientValuesTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g"; }


     
     	private TransientValuesTestGrammarAccess grammarAccess;
     	
        public InternalTransientValuesTestParser(TokenStream input, IAstFactory factory, TransientValuesTestGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	} 



    // $ANTLR start entryRuleRoot
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:69:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:69:46: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:70:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.prRoot().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleRoot_in_entryRuleRoot71);
            iv_ruleRoot=ruleRoot();
            _fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoot81); 

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
    // $ANTLR end entryRuleRoot


    // $ANTLR start ruleRoot
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:77:1: ruleRoot returns [EObject current=null] : ( 'test' ( (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional ) | this_TestList_3= ruleTestList ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject this_TestRequired_1 = null;

        EObject this_TestOptional_2 = null;

        EObject this_TestList_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:82:6: ( ( 'test' ( (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional ) | this_TestList_3= ruleTestList ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:83:1: ( 'test' ( (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional ) | this_TestList_3= ruleTestList ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:83:1: ( 'test' ( (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional ) | this_TestList_3= ruleTestList ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:83:2: 'test' ( (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional ) | this_TestList_3= ruleTestList )
            {
            match(input,11,FOLLOW_11_in_ruleRoot115); 

                    createLeafNode(grammarAccess.prRoot().ele0KeywordTest(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:87:1: ( (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional ) | this_TestList_3= ruleTestList )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=12 && LA2_0<=13)) ) {
                alt2=1;
            }
            else if ( (LA2_0==15) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("87:1: ( (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional ) | this_TestList_3= ruleTestList )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:87:2: (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:87:2: (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==12) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==13) ) {
                        alt1=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("87:2: (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional )", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:88:5: this_TestRequired_1= ruleTestRequired
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prRoot().ele100ParserRuleCallTestRequired(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleTestRequired_in_ruleRoot139);
                            this_TestRequired_1=ruleTestRequired();
                            _fsp--;

                             
                                    current = this_TestRequired_1; 
                                    currentNode = currentNode.getParent();
                                
                             
                                createLeafNode(grammarAccess.prRoot().ele100ParserRuleCallTestRequired(), null); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:102:5: this_TestOptional_2= ruleTestOptional
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prRoot().ele101ParserRuleCallTestOptional(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleTestOptional_in_ruleRoot173);
                            this_TestOptional_2=ruleTestOptional();
                            _fsp--;

                             
                                    current = this_TestOptional_2; 
                                    currentNode = currentNode.getParent();
                                
                             
                                createLeafNode(grammarAccess.prRoot().ele101ParserRuleCallTestOptional(), null); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:116:5: this_TestList_3= ruleTestList
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prRoot().ele11ParserRuleCallTestList(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestList_in_ruleRoot208);
                    this_TestList_3=ruleTestList();
                    _fsp--;

                     
                            current = this_TestList_3; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prRoot().ele11ParserRuleCallTestList(), null); 
                        

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
    // $ANTLR end ruleRoot


    // $ANTLR start entryRuleTestRequired
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:135:1: entryRuleTestRequired returns [EObject current=null] : iv_ruleTestRequired= ruleTestRequired EOF ;
    public final EObject entryRuleTestRequired() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestRequired = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:135:54: (iv_ruleTestRequired= ruleTestRequired EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:136:2: iv_ruleTestRequired= ruleTestRequired EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTestRequired().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestRequired_in_entryRuleTestRequired248);
            iv_ruleTestRequired=ruleTestRequired();
            _fsp--;

             current =iv_ruleTestRequired; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestRequired258); 

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
    // $ANTLR end entryRuleTestRequired


    // $ANTLR start ruleTestRequired
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:143:1: ruleTestRequired returns [EObject current=null] : ( ( 'required' (lv_required1_1= RULE_INT ) ) (lv_required2_2= RULE_INT ) ) ;
    public final EObject ruleTestRequired() throws RecognitionException {
        EObject current = null;

        Token lv_required1_1=null;
        Token lv_required2_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:148:6: ( ( ( 'required' (lv_required1_1= RULE_INT ) ) (lv_required2_2= RULE_INT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:149:1: ( ( 'required' (lv_required1_1= RULE_INT ) ) (lv_required2_2= RULE_INT ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:149:1: ( ( 'required' (lv_required1_1= RULE_INT ) ) (lv_required2_2= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:149:2: ( 'required' (lv_required1_1= RULE_INT ) ) (lv_required2_2= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:149:2: ( 'required' (lv_required1_1= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:149:3: 'required' (lv_required1_1= RULE_INT )
            {
            match(input,12,FOLLOW_12_in_ruleTestRequired293); 

                    createLeafNode(grammarAccess.prTestRequired().ele00KeywordRequired(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:153:1: (lv_required1_1= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:155:6: lv_required1_1= RULE_INT
            {
            lv_required1_1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestRequired315); 

            		createLeafNode(grammarAccess.prTestRequired().ele010TerminalRuleCallINT(), "required1"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prTestRequired().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "required1", lv_required1_1, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:173:3: (lv_required2_2= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:175:6: lv_required2_2= RULE_INT
            {
            lv_required2_2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestRequired346); 

            		createLeafNode(grammarAccess.prTestRequired().ele10TerminalRuleCallINT(), "required2"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prTestRequired().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "required2", lv_required2_2, "INT", lastConsumedNode);
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
    // $ANTLR end ruleTestRequired


    // $ANTLR start entryRuleTestOptional
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:200:1: entryRuleTestOptional returns [EObject current=null] : iv_ruleTestOptional= ruleTestOptional EOF ;
    public final EObject entryRuleTestOptional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestOptional = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:200:54: (iv_ruleTestOptional= ruleTestOptional EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:201:2: iv_ruleTestOptional= ruleTestOptional EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTestOptional().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestOptional_in_entryRuleTestOptional387);
            iv_ruleTestOptional=ruleTestOptional();
            _fsp--;

             current =iv_ruleTestOptional; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestOptional397); 

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
    // $ANTLR end entryRuleTestOptional


    // $ANTLR start ruleTestOptional
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:208:1: ruleTestOptional returns [EObject current=null] : ( ( 'optional' (lv_opt1_1= RULE_INT )? ) ( ':' (lv_opt2_3= RULE_INT ) )? ) ;
    public final EObject ruleTestOptional() throws RecognitionException {
        EObject current = null;

        Token lv_opt1_1=null;
        Token lv_opt2_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:213:6: ( ( ( 'optional' (lv_opt1_1= RULE_INT )? ) ( ':' (lv_opt2_3= RULE_INT ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:214:1: ( ( 'optional' (lv_opt1_1= RULE_INT )? ) ( ':' (lv_opt2_3= RULE_INT ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:214:1: ( ( 'optional' (lv_opt1_1= RULE_INT )? ) ( ':' (lv_opt2_3= RULE_INT ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:214:2: ( 'optional' (lv_opt1_1= RULE_INT )? ) ( ':' (lv_opt2_3= RULE_INT ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:214:2: ( 'optional' (lv_opt1_1= RULE_INT )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:214:3: 'optional' (lv_opt1_1= RULE_INT )?
            {
            match(input,13,FOLLOW_13_in_ruleTestOptional432); 

                    createLeafNode(grammarAccess.prTestOptional().ele00KeywordOptional(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:218:1: (lv_opt1_1= RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:220:6: lv_opt1_1= RULE_INT
                    {
                    lv_opt1_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestOptional454); 

                    		createLeafNode(grammarAccess.prTestOptional().ele010TerminalRuleCallINT(), "opt1"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prTestOptional().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "opt1", lv_opt1_1, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:238:4: ( ':' (lv_opt2_3= RULE_INT ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:238:5: ':' (lv_opt2_3= RULE_INT )
                    {
                    match(input,14,FOLLOW_14_in_ruleTestOptional474); 

                            createLeafNode(grammarAccess.prTestOptional().ele10KeywordColon(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:242:1: (lv_opt2_3= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:244:6: lv_opt2_3= RULE_INT
                    {
                    lv_opt2_3=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestOptional496); 

                    		createLeafNode(grammarAccess.prTestOptional().ele110TerminalRuleCallINT(), "opt2"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prTestOptional().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "opt2", lv_opt2_3, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // $ANTLR end ruleTestOptional


    // $ANTLR start entryRuleTestList
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:269:1: entryRuleTestList returns [EObject current=null] : iv_ruleTestList= ruleTestList EOF ;
    public final EObject entryRuleTestList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestList = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:269:50: (iv_ruleTestList= ruleTestList EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:270:2: iv_ruleTestList= ruleTestList EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTestList().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestList_in_entryRuleTestList539);
            iv_ruleTestList=ruleTestList();
            _fsp--;

             current =iv_ruleTestList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestList549); 

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
    // $ANTLR end entryRuleTestList


    // $ANTLR start ruleTestList
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:277:1: ruleTestList returns [EObject current=null] : ( 'list' (lv_item_1= RULE_INT )* ) ;
    public final EObject ruleTestList() throws RecognitionException {
        EObject current = null;

        Token lv_item_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:282:6: ( ( 'list' (lv_item_1= RULE_INT )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:283:1: ( 'list' (lv_item_1= RULE_INT )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:283:1: ( 'list' (lv_item_1= RULE_INT )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:283:2: 'list' (lv_item_1= RULE_INT )*
            {
            match(input,15,FOLLOW_15_in_ruleTestList583); 

                    createLeafNode(grammarAccess.prTestList().ele0KeywordList(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:287:1: (lv_item_1= RULE_INT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_INT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:289:6: lv_item_1= RULE_INT
            	    {
            	    lv_item_1=(Token)input.LT(1);
            	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestList605); 

            	    		createLeafNode(grammarAccess.prTestList().ele10TerminalRuleCallINT(), "item"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prTestList().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "item", lv_item_1, "INT", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


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
    // $ANTLR end ruleTestList


 

    public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoot81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRoot115 = new BitSet(new long[]{0x000000000000B000L});
    public static final BitSet FOLLOW_ruleTestRequired_in_ruleRoot139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestOptional_in_ruleRoot173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestList_in_ruleRoot208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestRequired_in_entryRuleTestRequired248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestRequired258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleTestRequired293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired315 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestOptional_in_entryRuleTestOptional387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestOptional397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleTestOptional432 = new BitSet(new long[]{0x0000000000004012L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional454 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleTestOptional474 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestList_in_entryRuleTestList539 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestList549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleTestList583 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestList605 = new BitSet(new long[]{0x0000000000000012L});

}