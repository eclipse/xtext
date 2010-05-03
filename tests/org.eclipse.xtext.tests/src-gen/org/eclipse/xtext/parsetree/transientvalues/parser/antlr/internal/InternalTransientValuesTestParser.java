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

@SuppressWarnings("all")
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g"; }



     	private TransientValuesTestGrammarAccess grammarAccess;
     	
        public InternalTransientValuesTestParser(TokenStream input, IAstFactory factory, TransientValuesTestGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
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
       	
       	@Override
       	protected TransientValuesTestGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleRoot
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:77:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:78:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:79:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRootRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot75);
            iv_ruleRoot=ruleRoot();
            _fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:86:1: ruleRoot returns [EObject current=null] : ( 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject this_TestRequired_1 = null;

        EObject this_TestOptional_2 = null;

        EObject this_TestList_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:91:6: ( ( 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:92:1: ( 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:92:1: ( 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:92:3: 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot120); 

                    createLeafNode(grammarAccess.getRootAccess().getTestKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:96:1: (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 15:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("96:1: (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:97:5: this_TestRequired_1= ruleTestRequired
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootAccess().getTestRequiredParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTestRequired_in_ruleRoot143);
                    this_TestRequired_1=ruleTestRequired();
                    _fsp--;

                     
                            current = this_TestRequired_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:107:5: this_TestOptional_2= ruleTestOptional
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootAccess().getTestOptionalParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTestOptional_in_ruleRoot170);
                    this_TestOptional_2=ruleTestOptional();
                    _fsp--;

                     
                            current = this_TestOptional_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:117:5: this_TestList_3= ruleTestList
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootAccess().getTestListParserRuleCall_1_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTestList_in_ruleRoot197);
                    this_TestList_3=ruleTestList();
                    _fsp--;

                     
                            current = this_TestList_3; 
                            currentNode = currentNode.getParent();
                        

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:133:1: entryRuleTestRequired returns [EObject current=null] : iv_ruleTestRequired= ruleTestRequired EOF ;
    public final EObject entryRuleTestRequired() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestRequired = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:134:2: (iv_ruleTestRequired= ruleTestRequired EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:135:2: iv_ruleTestRequired= ruleTestRequired EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestRequiredRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTestRequired_in_entryRuleTestRequired233);
            iv_ruleTestRequired=ruleTestRequired();
            _fsp--;

             current =iv_ruleTestRequired; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestRequired243); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:142:1: ruleTestRequired returns [EObject current=null] : ( 'required' ( (lv_required1_1_0= RULE_INT ) ) ( (lv_required2_2_0= RULE_INT ) ) ) ;
    public final EObject ruleTestRequired() throws RecognitionException {
        EObject current = null;

        Token lv_required1_1_0=null;
        Token lv_required2_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:147:6: ( ( 'required' ( (lv_required1_1_0= RULE_INT ) ) ( (lv_required2_2_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:148:1: ( 'required' ( (lv_required1_1_0= RULE_INT ) ) ( (lv_required2_2_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:148:1: ( 'required' ( (lv_required1_1_0= RULE_INT ) ) ( (lv_required2_2_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:148:3: 'required' ( (lv_required1_1_0= RULE_INT ) ) ( (lv_required2_2_0= RULE_INT ) )
            {
            match(input,12,FollowSets000.FOLLOW_12_in_ruleTestRequired278); 

                    createLeafNode(grammarAccess.getTestRequiredAccess().getRequiredKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:152:1: ( (lv_required1_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:153:1: (lv_required1_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:153:1: (lv_required1_1_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:154:3: lv_required1_1_0= RULE_INT
            {
            lv_required1_1_0=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestRequired295); 

            			createLeafNode(grammarAccess.getTestRequiredAccess().getRequired1INTTerminalRuleCall_1_0(), "required1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTestRequiredRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"required1",
            	        		lv_required1_1_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:176:2: ( (lv_required2_2_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:177:1: (lv_required2_2_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:177:1: (lv_required2_2_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:178:3: lv_required2_2_0= RULE_INT
            {
            lv_required2_2_0=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestRequired317); 

            			createLeafNode(grammarAccess.getTestRequiredAccess().getRequired2INTTerminalRuleCall_2_0(), "required2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTestRequiredRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"required2",
            	        		lv_required2_2_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:208:1: entryRuleTestOptional returns [EObject current=null] : iv_ruleTestOptional= ruleTestOptional EOF ;
    public final EObject entryRuleTestOptional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestOptional = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:209:2: (iv_ruleTestOptional= ruleTestOptional EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:210:2: iv_ruleTestOptional= ruleTestOptional EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestOptionalRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTestOptional_in_entryRuleTestOptional358);
            iv_ruleTestOptional=ruleTestOptional();
            _fsp--;

             current =iv_ruleTestOptional; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestOptional368); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:217:1: ruleTestOptional returns [EObject current=null] : ( 'optional' ( (lv_opt1_1_0= RULE_INT ) )? ( ':' ( (lv_opt2_3_0= RULE_INT ) ) )? ) ;
    public final EObject ruleTestOptional() throws RecognitionException {
        EObject current = null;

        Token lv_opt1_1_0=null;
        Token lv_opt2_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:222:6: ( ( 'optional' ( (lv_opt1_1_0= RULE_INT ) )? ( ':' ( (lv_opt2_3_0= RULE_INT ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:223:1: ( 'optional' ( (lv_opt1_1_0= RULE_INT ) )? ( ':' ( (lv_opt2_3_0= RULE_INT ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:223:1: ( 'optional' ( (lv_opt1_1_0= RULE_INT ) )? ( ':' ( (lv_opt2_3_0= RULE_INT ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:223:3: 'optional' ( (lv_opt1_1_0= RULE_INT ) )? ( ':' ( (lv_opt2_3_0= RULE_INT ) ) )?
            {
            match(input,13,FollowSets000.FOLLOW_13_in_ruleTestOptional403); 

                    createLeafNode(grammarAccess.getTestOptionalAccess().getOptionalKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:227:1: ( (lv_opt1_1_0= RULE_INT ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:228:1: (lv_opt1_1_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:228:1: (lv_opt1_1_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:229:3: lv_opt1_1_0= RULE_INT
                    {
                    lv_opt1_1_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestOptional420); 

                    			createLeafNode(grammarAccess.getTestOptionalAccess().getOpt1INTTerminalRuleCall_1_0(), "opt1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTestOptionalRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"opt1",
                    	        		lv_opt1_1_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:251:3: ( ':' ( (lv_opt2_3_0= RULE_INT ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:251:5: ':' ( (lv_opt2_3_0= RULE_INT ) )
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleTestOptional437); 

                            createLeafNode(grammarAccess.getTestOptionalAccess().getColonKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:255:1: ( (lv_opt2_3_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:256:1: (lv_opt2_3_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:256:1: (lv_opt2_3_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:257:3: lv_opt2_3_0= RULE_INT
                    {
                    lv_opt2_3_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestOptional454); 

                    			createLeafNode(grammarAccess.getTestOptionalAccess().getOpt2INTTerminalRuleCall_2_1_0(), "opt2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTestOptionalRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"opt2",
                    	        		lv_opt2_3_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:287:1: entryRuleTestList returns [EObject current=null] : iv_ruleTestList= ruleTestList EOF ;
    public final EObject entryRuleTestList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestList = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:288:2: (iv_ruleTestList= ruleTestList EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:289:2: iv_ruleTestList= ruleTestList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestListRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTestList_in_entryRuleTestList497);
            iv_ruleTestList=ruleTestList();
            _fsp--;

             current =iv_ruleTestList; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestList507); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:296:1: ruleTestList returns [EObject current=null] : ( 'list' ( (lv_item_1_0= RULE_INT ) )* ) ;
    public final EObject ruleTestList() throws RecognitionException {
        EObject current = null;

        Token lv_item_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:301:6: ( ( 'list' ( (lv_item_1_0= RULE_INT ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:302:1: ( 'list' ( (lv_item_1_0= RULE_INT ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:302:1: ( 'list' ( (lv_item_1_0= RULE_INT ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:302:3: 'list' ( (lv_item_1_0= RULE_INT ) )*
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleTestList542); 

                    createLeafNode(grammarAccess.getTestListAccess().getListKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:306:1: ( (lv_item_1_0= RULE_INT ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_INT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:307:1: (lv_item_1_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:307:1: (lv_item_1_0= RULE_INT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:308:3: lv_item_1_0= RULE_INT
            	    {
            	    lv_item_1_0=(Token)input.LT(1);
            	    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestList559); 

            	    			createLeafNode(grammarAccess.getTestListAccess().getItemINTTerminalRuleCall_1_0(), "item"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTestListRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"item",
            	    	        		lv_item_1_0, 
            	    	        		"INT", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot120 = new BitSet(new long[]{0x000000000000B000L});
        public static final BitSet FOLLOW_ruleTestRequired_in_ruleRoot143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestOptional_in_ruleRoot170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestList_in_ruleRoot197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestRequired_in_entryRuleTestRequired233 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestRequired243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleTestRequired278 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired295 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestOptional_in_entryRuleTestOptional358 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestOptional368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleTestOptional403 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional420 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleTestOptional437 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestList_in_entryRuleTestList497 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestList507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleTestList542 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestList559 = new BitSet(new long[]{0x0000000000000012L});
    }


}