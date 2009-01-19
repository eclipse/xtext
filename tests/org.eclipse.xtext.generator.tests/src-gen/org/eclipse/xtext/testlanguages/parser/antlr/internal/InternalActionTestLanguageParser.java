// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g 2009-01-19 15:13:58

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
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalActionTestLanguageParser extends AbstractInternalAntlrParser {
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

        public InternalActionTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g"; }


     
        public InternalActionTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalActionTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:67:47: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:68:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:75:1: ruleModel returns [EObject current=null] : (lv_children= ruleElement )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:77:33: ( (lv_children= ruleElement )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:78:1: (lv_children= ruleElement )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:78:1: (lv_children= ruleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:81:6: lv_children= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleModel140);
            	    lv_children=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Model");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "children", lv_children, "Element", currentNode);
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


    // $ANTLR start entryRuleElement
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:108:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:108:49: (iv_ruleElement= ruleElement EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:109:2: iv_ruleElement= ruleElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement179);
            iv_ruleElement=ruleElement();
            _fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement189); 

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
    // $ANTLR end entryRuleElement


    // $ANTLR start ruleElement
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:116:1: ruleElement returns [EObject current=null] : (this_Item= ruleItem ( () (lv_items= ruleItem ) ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Item = null;

        EObject lv_items = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:118:33: ( (this_Item= ruleItem ( () (lv_items= ruleItem ) ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:119:1: (this_Item= ruleItem ( () (lv_items= ruleItem ) ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:119:1: (this_Item= ruleItem ( () (lv_items= ruleItem ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:120:5: this_Item= ruleItem ( () (lv_items= ruleItem ) )
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleItem_in_ruleElement236);
            this_Item=ruleItem();
            _fsp--;

             
                    current = this_Item; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:128:1: ( () (lv_items= ruleItem ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:128:2: () (lv_items= ruleItem )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:128:2: ()
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:129:5: 
            {
             
                    temp=factory.create("Item");
                    try {
                    	factory.add(temp, "items", current, null /*ParserRule*/, currentNode);
                    } catch(ValueConverterException vce) {
                    	handleValueConverterException(vce);
                    }
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:144:2: (lv_items= ruleItem )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:147:6: lv_items= ruleItem
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleItem_in_ruleElement279);
            lv_items=ruleItem();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "items", lv_items, "Item", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleElement


    // $ANTLR start entryRuleItem
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:174:1: entryRuleItem returns [EObject current=null] : iv_ruleItem= ruleItem EOF ;
    public final EObject entryRuleItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleItem = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:174:46: (iv_ruleItem= ruleItem EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:175:2: iv_ruleItem= ruleItem EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleItem_in_entryRuleItem319);
            iv_ruleItem=ruleItem();
            _fsp--;

             current =iv_ruleItem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleItem329); 

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
    // $ANTLR end entryRuleItem


    // $ANTLR start ruleItem
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:182:1: ruleItem returns [EObject current=null] : ( () (lv_name= RULE_ID ) ) ;
    public final EObject ruleItem() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:184:33: ( ( () (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:185:1: ( () (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:185:1: ( () (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:185:2: () (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:185:2: ()
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:186:5: 
            {
             
                    temp=factory.create("Thing");
                    try {
                    	factory.set(temp, "content", current, null /*ParserRule*/, currentNode);
                    } catch(ValueConverterException vce) {
                    	handleValueConverterException(vce);
                    }
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:201:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:203:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleItem384); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
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
    // $ANTLR end ruleItem


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_ruleModel140 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleItem_in_ruleElement236 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleItem_in_ruleElement279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleItem_in_entryRuleItem319 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleItem329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleItem384 = new BitSet(new long[]{0x0000000000000002L});

}