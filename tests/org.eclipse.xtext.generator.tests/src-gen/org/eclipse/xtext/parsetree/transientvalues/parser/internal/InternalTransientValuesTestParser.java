// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g 2008-12-08 18:03:02

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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:62:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:62:46: (iv_ruleRoot= ruleRoot EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:63:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRoot_in_entryRuleRoot70);
            iv_ruleRoot=ruleRoot();
            _fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoot80); 

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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:70:1: ruleRoot returns [EObject current=null] : ( 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject this_TestRequired = null;

        EObject this_TestOptional = null;

        EObject this_TestList = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:72:33: ( ( 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:73:1: ( 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:73:1: ( 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:73:2: 'test' ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList )
            {
            match(input,11,FOLLOW_11_in_ruleRoot114); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:77:1: ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList )
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
                    new NoViableAltException("77:1: ( (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional ) | this_TestList= ruleTestList )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:77:2: (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional )
                    {
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:77:2: (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional )
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
                            new NoViableAltException("77:2: (this_TestRequired= ruleTestRequired | this_TestOptional= ruleTestOptional )", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:78:5: this_TestRequired= ruleTestRequired
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleTestRequired_in_ruleRoot138);
                            this_TestRequired=ruleTestRequired();
                            _fsp--;

                             
                                    current = this_TestRequired; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:88:5: this_TestOptional= ruleTestOptional
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleTestOptional_in_ruleRoot165);
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
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:98:5: this_TestList= ruleTestList
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestList_in_ruleRoot193);
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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:111:1: entryRuleTestRequired returns [EObject current=null] : iv_ruleTestRequired= ruleTestRequired EOF ;
    public final EObject entryRuleTestRequired() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestRequired = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:111:54: (iv_ruleTestRequired= ruleTestRequired EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:112:2: iv_ruleTestRequired= ruleTestRequired EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTestRequired_in_entryRuleTestRequired228);
            iv_ruleTestRequired=ruleTestRequired();
            _fsp--;

             current =iv_ruleTestRequired; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestRequired238); 

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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:119:1: ruleTestRequired returns [EObject current=null] : ( ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT ) ) ;
    public final EObject ruleTestRequired() throws RecognitionException {
        EObject current = null;

        Token lv_required1=null;
        Token lv_required2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:121:33: ( ( ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:122:1: ( ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:122:1: ( ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:122:2: ( 'required' (lv_required1= RULE_INT ) ) (lv_required2= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:122:2: ( 'required' (lv_required1= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:122:3: 'required' (lv_required1= RULE_INT )
            {
            match(input,12,FOLLOW_12_in_ruleTestRequired273); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:126:1: (lv_required1= RULE_INT )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:128:6: lv_required1= RULE_INT
            {
            lv_required1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestRequired294); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "required1"); 
                

            	        if (current==null) {
            	            current = factory.create("TestRequired");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "required1", lv_required1,"INT");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:142:3: (lv_required2= RULE_INT )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:144:6: lv_required2= RULE_INT
            {
            lv_required2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestRequired327); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "required2"); 
                

            	        if (current==null) {
            	            current = factory.create("TestRequired");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "required2", lv_required2,"INT");
            	         

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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:163:1: entryRuleTestOptional returns [EObject current=null] : iv_ruleTestOptional= ruleTestOptional EOF ;
    public final EObject entryRuleTestOptional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestOptional = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:163:54: (iv_ruleTestOptional= ruleTestOptional EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:164:2: iv_ruleTestOptional= ruleTestOptional EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTestOptional_in_entryRuleTestOptional373);
            iv_ruleTestOptional=ruleTestOptional();
            _fsp--;

             current =iv_ruleTestOptional; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestOptional383); 

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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:171:1: ruleTestOptional returns [EObject current=null] : ( ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )? ) ;
    public final EObject ruleTestOptional() throws RecognitionException {
        EObject current = null;

        Token lv_opt1=null;
        Token lv_opt2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:173:33: ( ( ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )? ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:174:1: ( ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:174:1: ( ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )? )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:174:2: ( 'optional' (lv_opt1= RULE_INT )? ) ( ':' (lv_opt2= RULE_INT ) )?
            {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:174:2: ( 'optional' (lv_opt1= RULE_INT )? )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:174:3: 'optional' (lv_opt1= RULE_INT )?
            {
            match(input,13,FOLLOW_13_in_ruleTestOptional418); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:178:1: (lv_opt1= RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:180:6: lv_opt1= RULE_INT
                    {
                    lv_opt1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestOptional439); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "opt1"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("TestOptional");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "opt1", lv_opt1,"INT");
                    	         

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:194:4: ( ':' (lv_opt2= RULE_INT ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:194:5: ':' (lv_opt2= RULE_INT )
                    {
                    match(input,14,FOLLOW_14_in_ruleTestOptional462); 

                            createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:198:1: (lv_opt2= RULE_INT )
                    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:200:6: lv_opt2= RULE_INT
                    {
                    lv_opt2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestOptional483); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.2/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "opt2"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("TestOptional");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "opt2", lv_opt2,"INT");
                    	         

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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:219:1: entryRuleTestList returns [EObject current=null] : iv_ruleTestList= ruleTestList EOF ;
    public final EObject entryRuleTestList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestList = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:219:50: (iv_ruleTestList= ruleTestList EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:220:2: iv_ruleTestList= ruleTestList EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTestList_in_entryRuleTestList531);
            iv_ruleTestList=ruleTestList();
            _fsp--;

             current =iv_ruleTestList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestList541); 

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
    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:227:1: ruleTestList returns [EObject current=null] : ( 'list' (lv_item= RULE_INT )* ) ;
    public final EObject ruleTestList() throws RecognitionException {
        EObject current = null;

        Token lv_item=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:229:33: ( ( 'list' (lv_item= RULE_INT )* ) )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:230:1: ( 'list' (lv_item= RULE_INT )* )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:230:1: ( 'list' (lv_item= RULE_INT )* )
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:230:2: 'list' (lv_item= RULE_INT )*
            {
            match(input,15,FOLLOW_15_in_ruleTestList575); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.3/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:234:1: (lv_item= RULE_INT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_INT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/internal/InternalTransientValuesTest.g:236:6: lv_item= RULE_INT
            	    {
            	    lv_item=(Token)input.LT(1);
            	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTestList596); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "item"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("TestList");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "item", lv_item,"INT");
            	    	         

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


 

    public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot70 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoot80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRoot114 = new BitSet(new long[]{0x000000000000B000L});
    public static final BitSet FOLLOW_ruleTestRequired_in_ruleRoot138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestOptional_in_ruleRoot165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestList_in_ruleRoot193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestRequired_in_entryRuleTestRequired228 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestRequired238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleTestRequired273 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired294 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestOptional_in_entryRuleTestOptional373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestOptional383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleTestOptional418 = new BitSet(new long[]{0x0000000000004012L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional439 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleTestOptional462 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestList_in_entryRuleTestList531 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestList541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleTestList575 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTestList596 = new BitSet(new long[]{0x0000000000000012L});

}