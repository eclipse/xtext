// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g 2008-12-16 15:27:17

package org.eclipse.xtext.parsetree.transientvalues.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.ValueConverterException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTransientValuesTestParser extends AbstractAntlrParser {
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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g"; }


     
        public InternalTransientValuesTestParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalTransientValuesTestParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	} 



    // $ANTLR start entryRuleRoot
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:64:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:64:46: (iv_ruleRoot= ruleRoot EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:65:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:72:1: ruleRoot returns [EObject current=null] : ( 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject this_TestRequired = null;

        EObject this_TestOptional = null;

        EObject this_TestList = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:74:33: ( ( 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:75:1: ( 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:75:1: ( 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:75:2: 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList )
            {
            match(input,11,FOLLOW_11_in_ruleRoot115); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:79:1: ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList )
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
                    new NoViableAltException("79:1: ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:79:2: (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional )
                    {
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:79:2: (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional )
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
                            new NoViableAltException("79:2: (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional )", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:80:5: this_TestRequired= ruleTestRequired
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleTestRequired_in_ruleRoot139);
                            this_TestRequired=ruleTestRequired();
                            _fsp--;

                             
                                    current = this_TestRequired; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:90:5: this_TestOptional= ruleTestOptional
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleTestOptional_in_ruleRoot166);
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
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:100:5: this_TestList= ruleTestList
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestList_in_ruleRoot194);
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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:115:1: entryRuleTestRequired returns [EObject current=null] : iv_ruleTestRequired= ruleTestRequired EOF ;
    public final EObject entryRuleTestRequired() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestRequired = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:115:54: (iv_ruleTestRequired= ruleTestRequired EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:116:2: iv_ruleTestRequired= ruleTestRequired EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTestRequired_in_entryRuleTestRequired227);
            iv_ruleTestRequired=ruleTestRequired();
            _fsp--;

             current =iv_ruleTestRequired; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestRequired237); 

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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:123:1: ruleTestRequired returns [EObject current=null] : ( ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT ) ) ;
    public final EObject ruleTestRequired() throws RecognitionException {
        EObject current = null;

        Token lv_required1=null;
        Token lv_required2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:125:33: ( ( ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:126:1: ( ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:126:1: ( ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:126:2: ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:126:2: ( 'required' (lv_required1= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:126:3: 'required' (lv_required1= RULE_INT )
            {
            match(input,12,FOLLOW_12_in_ruleTestRequired272); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:130:1: (lv_required1= RULE_INT )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:132:6: lv_required1= RULE_INT
            {
            lv_required1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestRequired293); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "required1"); 
                

            	        if (current==null) {
            	            current = factory.create("TestRequired");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "required1", lv_required1,"INT");
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:150:3: (lv_required2= RULE_INT )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:152:6: lv_required2= RULE_INT
            {
            lv_required2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestRequired326); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "required2"); 
                

            	        if (current==null) {
            	            current = factory.create("TestRequired");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "required2", lv_required2,"INT");
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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:177:1: entryRuleTestOptional returns [EObject current=null] : iv_ruleTestOptional= ruleTestOptional EOF ;
    public final EObject entryRuleTestOptional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestOptional = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:177:54: (iv_ruleTestOptional= ruleTestOptional EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:178:2: iv_ruleTestOptional= ruleTestOptional EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTestOptional_in_entryRuleTestOptional370);
            iv_ruleTestOptional=ruleTestOptional();
            _fsp--;

             current =iv_ruleTestOptional; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestOptional380); 

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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:185:1: ruleTestOptional returns [EObject current=null] : ( ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )? ) ;
    public final EObject ruleTestOptional() throws RecognitionException {
        EObject current = null;

        Token lv_opt1=null;
        Token lv_opt2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:187:33: ( ( ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )? ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:188:1: ( ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:188:1: ( ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )? )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:188:2: ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )?
            {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:188:2: ( 'optional' (lv_opt1= RULE_INT )? )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:188:3: 'optional' (lv_opt1= RULE_INT )?
            {
            match(input,13,FOLLOW_13_in_ruleTestOptional415); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:192:1: (lv_opt1= RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:194:6: lv_opt1= RULE_INT
                    {
                    lv_opt1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestOptional436); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "opt1"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("TestOptional");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "opt1", lv_opt1,"INT");
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:212:4: ( ':' (lv_opt2= RULE_INT ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:212:5: ':' (lv_opt2= RULE_INT )
                    {
                    match(input,14,FOLLOW_14_in_ruleTestOptional459); 

                            createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:216:1: (lv_opt2= RULE_INT )
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:218:6: lv_opt2= RULE_INT
                    {
                    lv_opt2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestOptional480); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "opt2"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("TestOptional");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "opt2", lv_opt2,"INT");
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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:243:1: entryRuleTestList returns [EObject current=null] : iv_ruleTestList= ruleTestList EOF ;
    public final EObject entryRuleTestList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestList = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:243:50: (iv_ruleTestList= ruleTestList EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:244:2: iv_ruleTestList= ruleTestList EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTestList_in_entryRuleTestList526);
            iv_ruleTestList=ruleTestList();
            _fsp--;

             current =iv_ruleTestList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestList536); 

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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:251:1: ruleTestList returns [EObject current=null] : ( 'list' (lv_item= RULE_INT )* ) ;
    public final EObject ruleTestList() throws RecognitionException {
        EObject current = null;

        Token lv_item=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:253:33: ( ( 'list' (lv_item= RULE_INT )* ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:254:1: ( 'list' (lv_item= RULE_INT )* )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:254:1: ( 'list' (lv_item= RULE_INT )* )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:254:2: 'list' (lv_item= RULE_INT )*
            {
            match(input,15,FOLLOW_15_in_ruleTestList570); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.3/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:258:1: (lv_item= RULE_INT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_INT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:260:6: lv_item= RULE_INT
            	    {
            	    lv_item=(Token)input.LT(1);
            	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestList591); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "item"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("TestList");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "item", lv_item,"INT");
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


 

    public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoot81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRoot115 = new BitSet(new long[]{0x000000000000B000L});
    public static final BitSet FOLLOW_ruleTestRequired_in_ruleRoot139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestOptional_in_ruleRoot166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestList_in_ruleRoot194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestRequired_in_entryRuleTestRequired227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestRequired237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleTestRequired272 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestOptional_in_entryRuleTestOptional370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestOptional380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleTestOptional415 = new BitSet(new long[]{0x0000000000004012L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional436 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleTestOptional459 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestList_in_entryRuleTestList526 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestList536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleTestList570 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestList591 = new BitSet(new long[]{0x0000000000000012L});

}