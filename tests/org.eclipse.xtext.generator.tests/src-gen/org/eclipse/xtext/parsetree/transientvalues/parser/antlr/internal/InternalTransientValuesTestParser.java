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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g"; }


     
     	private TransientValuesTestGrammarAccess grammarAccess;
     	
        public InternalTransientValuesTestParser(TokenStream input, IAstFactory factory, TransientValuesTestGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalTransientValuesTestParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	} 



    // $ANTLR start entryRuleRoot
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:70:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:70:46: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:71:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.prRoot().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleRoot_in_entryRuleRoot72);
            iv_ruleRoot=ruleRoot();
            _fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoot82); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:78:1: ruleRoot returns [EObject current=null] : ( 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject this_TestRequired = null;

        EObject this_TestOptional = null;

        EObject this_TestList = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:82:6: ( ( 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:83:1: ( 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:83:1: ( 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:83:2: 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList )
            {
            match(input,11,FOLLOW_11_in_ruleRoot116); 

                    createLeafNode(grammarAccess.prRoot().ele0KeywordTest(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:87:1: ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList )
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
                    new NoViableAltException("87:1: ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:87:2: (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:87:2: (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional )
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
                            new NoViableAltException("87:2: (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional )", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:88:5: this_TestRequired= ruleTestRequired
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prRoot().ele100ParserRuleCallTestRequired(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleTestRequired_in_ruleRoot140);
                            this_TestRequired=ruleTestRequired();
                            _fsp--;

                             
                                    current = this_TestRequired; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:98:5: this_TestOptional= ruleTestOptional
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prRoot().ele101ParserRuleCallTestOptional(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleTestOptional_in_ruleRoot167);
                            this_TestOptional=ruleTestOptional();
                            _fsp--;

                             
                                    current = this_TestOptional; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:108:5: this_TestList= ruleTestList
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prRoot().ele11ParserRuleCallTestList(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestList_in_ruleRoot195);
                    this_TestList=ruleTestList();
                    _fsp--;

                     
                            current = this_TestList; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleRoot


    // $ANTLR start entryRuleTestRequired
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:125:1: entryRuleTestRequired returns [EObject current=null] : iv_ruleTestRequired= ruleTestRequired EOF ;
    public final EObject entryRuleTestRequired() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestRequired = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:125:54: (iv_ruleTestRequired= ruleTestRequired EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:126:2: iv_ruleTestRequired= ruleTestRequired EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTestRequired().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestRequired_in_entryRuleTestRequired230);
            iv_ruleTestRequired=ruleTestRequired();
            _fsp--;

             current =iv_ruleTestRequired; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestRequired240); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:133:1: ruleTestRequired returns [EObject current=null] : ( ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT ) ) ;
    public final EObject ruleTestRequired() throws RecognitionException {
        EObject current = null;

        Token lv_required1=null;
        Token lv_required2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:137:6: ( ( ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:138:1: ( ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:138:1: ( ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:138:2: ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:138:2: ( 'required' (lv_required1= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:138:3: 'required' (lv_required1= RULE_INT )
            {
            match(input,12,FOLLOW_12_in_ruleTestRequired275); 

                    createLeafNode(grammarAccess.prTestRequired().ele00KeywordRequired(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:142:1: (lv_required1= RULE_INT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:144:6: lv_required1= RULE_INT
            {
            lv_required1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestRequired296); 
             
                createLeafNode(grammarAccess.prTestRequired().ele010LexerRuleCallINT(), "required1"); 
                

            	        if (current==null) {
            	            current = factory.create("TestRequired");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "required1", lv_required1, "INT", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:162:3: (lv_required2= RULE_INT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:164:6: lv_required2= RULE_INT
            {
            lv_required2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestRequired329); 
             
                createLeafNode(grammarAccess.prTestRequired().ele10LexerRuleCallINT(), "required2"); 
                

            	        if (current==null) {
            	            current = factory.create("TestRequired");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "required2", lv_required2, "INT", currentNode);
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
    // $ANTLR end ruleTestRequired


    // $ANTLR start entryRuleTestOptional
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:191:1: entryRuleTestOptional returns [EObject current=null] : iv_ruleTestOptional= ruleTestOptional EOF ;
    public final EObject entryRuleTestOptional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestOptional = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:191:54: (iv_ruleTestOptional= ruleTestOptional EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:192:2: iv_ruleTestOptional= ruleTestOptional EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTestOptional().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestOptional_in_entryRuleTestOptional375);
            iv_ruleTestOptional=ruleTestOptional();
            _fsp--;

             current =iv_ruleTestOptional; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestOptional385); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:199:1: ruleTestOptional returns [EObject current=null] : ( ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )? ) ;
    public final EObject ruleTestOptional() throws RecognitionException {
        EObject current = null;

        Token lv_opt1=null;
        Token lv_opt2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:203:6: ( ( ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )? ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:204:1: ( ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )? )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:204:1: ( ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:204:2: ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:204:2: ( 'optional' (lv_opt1= RULE_INT )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:204:3: 'optional' (lv_opt1= RULE_INT )?
            {
            match(input,13,FOLLOW_13_in_ruleTestOptional420); 

                    createLeafNode(grammarAccess.prTestOptional().ele00KeywordOptional(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:208:1: (lv_opt1= RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:210:6: lv_opt1= RULE_INT
                    {
                    lv_opt1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestOptional441); 
                     
                        createLeafNode(grammarAccess.prTestOptional().ele010LexerRuleCallINT(), "opt1"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("TestOptional");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "opt1", lv_opt1, "INT", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:228:4: ( ':' (lv_opt2= RULE_INT ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:228:5: ':' (lv_opt2= RULE_INT )
                    {
                    match(input,14,FOLLOW_14_in_ruleTestOptional464); 

                            createLeafNode(grammarAccess.prTestOptional().ele10KeywordColon(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:232:1: (lv_opt2= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:234:6: lv_opt2= RULE_INT
                    {
                    lv_opt2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestOptional485); 
                     
                        createLeafNode(grammarAccess.prTestOptional().ele110LexerRuleCallINT(), "opt2"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("TestOptional");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "opt2", lv_opt2, "INT", currentNode);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:261:1: entryRuleTestList returns [EObject current=null] : iv_ruleTestList= ruleTestList EOF ;
    public final EObject entryRuleTestList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestList = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:261:50: (iv_ruleTestList= ruleTestList EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:262:2: iv_ruleTestList= ruleTestList EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTestList().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestList_in_entryRuleTestList533);
            iv_ruleTestList=ruleTestList();
            _fsp--;

             current =iv_ruleTestList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestList543); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:269:1: ruleTestList returns [EObject current=null] : ( 'list' (lv_item= RULE_INT )* ) ;
    public final EObject ruleTestList() throws RecognitionException {
        EObject current = null;

        Token lv_item=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:273:6: ( ( 'list' (lv_item= RULE_INT )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:274:1: ( 'list' (lv_item= RULE_INT )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:274:1: ( 'list' (lv_item= RULE_INT )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:274:2: 'list' (lv_item= RULE_INT )*
            {
            match(input,15,FOLLOW_15_in_ruleTestList577); 

                    createLeafNode(grammarAccess.prTestList().ele0KeywordList(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:278:1: (lv_item= RULE_INT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_INT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:280:6: lv_item= RULE_INT
            	    {
            	    lv_item=(Token)input.LT(1);
            	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestList598); 
            	     
            	        createLeafNode(grammarAccess.prTestList().ele10LexerRuleCallINT(), "item"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("TestList");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "item", lv_item, "INT", currentNode);
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


 

    public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoot82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRoot116 = new BitSet(new long[]{0x000000000000B000L});
    public static final BitSet FOLLOW_ruleTestRequired_in_ruleRoot140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestOptional_in_ruleRoot167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestList_in_ruleRoot195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestRequired_in_entryRuleTestRequired230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestRequired240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleTestRequired275 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired296 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestOptional_in_entryRuleTestOptional375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestOptional385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleTestOptional420 = new BitSet(new long[]{0x0000000000004012L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional441 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleTestOptional464 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestList_in_entryRuleTestList533 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestList543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleTestList577 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestList598 = new BitSet(new long[]{0x0000000000000012L});

}