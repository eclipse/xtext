package org.eclipse.xtext.grammarinheritance.parser.antlr.internal; 

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

public class InternalConcreteTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_REAL", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "':'", "'overriddenelement'", "'subrule1'", "'subrule3'", "'element'", "'overridemodel'", "'extendedmodel'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=7;
    public static final int RULE_STRING=6;
    public static final int RULE_REAL=4;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;

        public InternalConcreteTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g"; }


     
        public InternalConcreteTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalConcreteTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RootRule";	
       	} 



    // $ANTLR start entryRuleRootRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:68:1: entryRuleRootRule returns [EObject current=null] : iv_ruleRootRule= ruleRootRule EOF ;
    public final EObject entryRuleRootRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:68:50: (iv_ruleRootRule= ruleRootRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:69:2: iv_ruleRootRule= ruleRootRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRootRule_in_entryRuleRootRule72);
            iv_ruleRootRule=ruleRootRule();
            _fsp--;

             current =iv_ruleRootRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRootRule82); 

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
    // $ANTLR end entryRuleRootRule


    // $ANTLR start ruleRootRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:76:1: ruleRootRule returns [EObject current=null] : ( (this_ConcreteParserRule= ruleConcreteParserRule | this_CallOverridenParserRule= ruleCallOverridenParserRule ) | this_CallExtendedParserRule= ruleCallExtendedParserRule ) ;
    public final EObject ruleRootRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteParserRule = null;

        EObject this_CallOverridenParserRule = null;

        EObject this_CallExtendedParserRule = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:80:6: ( ( (this_ConcreteParserRule= ruleConcreteParserRule | this_CallOverridenParserRule= ruleCallOverridenParserRule ) | this_CallExtendedParserRule= ruleCallExtendedParserRule ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:81:1: ( (this_ConcreteParserRule= ruleConcreteParserRule | this_CallOverridenParserRule= ruleCallOverridenParserRule ) | this_CallExtendedParserRule= ruleCallExtendedParserRule )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:81:1: ( (this_ConcreteParserRule= ruleConcreteParserRule | this_CallOverridenParserRule= ruleCallOverridenParserRule ) | this_CallExtendedParserRule= ruleCallExtendedParserRule )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12||LA2_0==18) ) {
                alt2=1;
            }
            else if ( (LA2_0==19) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("81:1: ( (this_ConcreteParserRule= ruleConcreteParserRule | this_CallOverridenParserRule= ruleCallOverridenParserRule ) | this_CallExtendedParserRule= ruleCallExtendedParserRule )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:81:2: (this_ConcreteParserRule= ruleConcreteParserRule | this_CallOverridenParserRule= ruleCallOverridenParserRule )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:81:2: (this_ConcreteParserRule= ruleConcreteParserRule | this_CallOverridenParserRule= ruleCallOverridenParserRule )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==12) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==18) ) {
                        alt1=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("81:2: (this_ConcreteParserRule= ruleConcreteParserRule | this_CallOverridenParserRule= ruleCallOverridenParserRule )", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:82:5: this_ConcreteParserRule= ruleConcreteParserRule
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.0/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleConcreteParserRule_in_ruleRootRule130);
                            this_ConcreteParserRule=ruleConcreteParserRule();
                            _fsp--;

                             
                                    current = this_ConcreteParserRule; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:92:5: this_CallOverridenParserRule= ruleCallOverridenParserRule
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.0/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleCallOverridenParserRule_in_ruleRootRule157);
                            this_CallOverridenParserRule=ruleCallOverridenParserRule();
                            _fsp--;

                             
                                    current = this_CallOverridenParserRule; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:102:5: this_CallExtendedParserRule= ruleCallExtendedParserRule
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.0/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleCallExtendedParserRule_in_ruleRootRule185);
                    this_CallExtendedParserRule=ruleCallExtendedParserRule();
                    _fsp--;

                     
                            current = this_CallExtendedParserRule; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleRootRule


    // $ANTLR start entryRuleConcreteParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:119:1: entryRuleConcreteParserRule returns [EObject current=null] : iv_ruleConcreteParserRule= ruleConcreteParserRule EOF ;
    public final EObject entryRuleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:119:60: (iv_ruleConcreteParserRule= ruleConcreteParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:120:2: iv_ruleConcreteParserRule= ruleConcreteParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule219);
            iv_ruleConcreteParserRule=ruleConcreteParserRule();
            _fsp--;

             current =iv_ruleConcreteParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteParserRule229); 

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
    // $ANTLR end entryRuleConcreteParserRule


    // $ANTLR start ruleConcreteParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:127:1: ruleConcreteParserRule returns [EObject current=null] : ( ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )* ) ;
    public final EObject ruleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_magicNumber=null;
        EObject lv_elements = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:131:6: ( ( ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:132:1: ( ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:132:1: ( ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:132:2: ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' ) (lv_elements= ruleInheritedParserRule )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:132:2: ( ( 'model' (lv_magicNumber= RULE_REAL ) ) ':' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:132:3: ( 'model' (lv_magicNumber= RULE_REAL ) ) ':'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:132:3: ( 'model' (lv_magicNumber= RULE_REAL ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:132:4: 'model' (lv_magicNumber= RULE_REAL )
            {
            match(input,12,FOLLOW_12_in_ruleConcreteParserRule265); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:136:1: (lv_magicNumber= RULE_REAL )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:138:6: lv_magicNumber= RULE_REAL
            {
            lv_magicNumber=(Token)input.LT(1);
            match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleConcreteParserRule286); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "magicNumber"); 
                

            	        if (current==null) {
            	            current = factory.create("ConcreteParserRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "magicNumber", lv_magicNumber, "REAL", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleConcreteParserRule307); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:160:2: (lv_elements= ruleInheritedParserRule )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:163:6: lv_elements= ruleInheritedParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule342);
            	    lv_elements=ruleInheritedParserRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("ConcreteParserRule");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "elements", lv_elements, "InheritedParserRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end ruleConcreteParserRule


    // $ANTLR start entryRuleOverridableParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:190:1: entryRuleOverridableParserRule returns [EObject current=null] : iv_ruleOverridableParserRule= ruleOverridableParserRule EOF ;
    public final EObject entryRuleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:190:63: (iv_ruleOverridableParserRule= ruleOverridableParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:191:2: iv_ruleOverridableParserRule= ruleOverridableParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule382);
            iv_ruleOverridableParserRule=ruleOverridableParserRule();
            _fsp--;

             current =iv_ruleOverridableParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridableParserRule392); 

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
    // $ANTLR end entryRuleOverridableParserRule


    // $ANTLR start ruleOverridableParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:198:1: ruleOverridableParserRule returns [EObject current=null] : ( 'overriddenelement' (lv_name= RULE_ID ) ) ;
    public final EObject ruleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:202:6: ( ( 'overriddenelement' (lv_name= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:203:1: ( 'overriddenelement' (lv_name= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:203:1: ( 'overriddenelement' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:203:2: 'overriddenelement' (lv_name= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleOverridableParserRule426); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.2/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:207:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:209:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOverridableParserRule447); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("AType");
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
    // $ANTLR end ruleOverridableParserRule


    // $ANTLR start entryRuleCallOverridenParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:236:1: entryRuleCallOverridenParserRule returns [EObject current=null] : iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF ;
    public final EObject entryRuleCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallOverridenParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:236:65: (iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:237:2: iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCallOverridenParserRule_in_entryRuleCallOverridenParserRule493);
            iv_ruleCallOverridenParserRule=ruleCallOverridenParserRule();
            _fsp--;

             current =iv_ruleCallOverridenParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallOverridenParserRule503); 

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
    // $ANTLR end entryRuleCallOverridenParserRule


    // $ANTLR start ruleCallOverridenParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:244:1: ruleCallOverridenParserRule returns [EObject current=null] : (lv_call= ruleAbstractCallOverridenParserRule ) ;
    public final EObject ruleCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_call = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:248:6: ( (lv_call= ruleAbstractCallOverridenParserRule ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:249:1: (lv_call= ruleAbstractCallOverridenParserRule )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:249:1: (lv_call= ruleAbstractCallOverridenParserRule )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:252:6: lv_call= ruleAbstractCallOverridenParserRule
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.3/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractCallOverridenParserRule_in_ruleCallOverridenParserRule561);
            lv_call=ruleAbstractCallOverridenParserRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("CallOverridenParserRule");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "call", lv_call, "AbstractCallOverridenParserRule", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleCallOverridenParserRule


    // $ANTLR start entryRuleExtendableParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:279:1: entryRuleExtendableParserRule returns [EObject current=null] : iv_ruleExtendableParserRule= ruleExtendableParserRule EOF ;
    public final EObject entryRuleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendableParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:279:62: (iv_ruleExtendableParserRule= ruleExtendableParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:280:2: iv_ruleExtendableParserRule= ruleExtendableParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule599);
            iv_ruleExtendableParserRule=ruleExtendableParserRule();
            _fsp--;

             current =iv_ruleExtendableParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtendableParserRule609); 

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
    // $ANTLR end entryRuleExtendableParserRule


    // $ANTLR start ruleExtendableParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:287:1: ruleExtendableParserRule returns [EObject current=null] : ( (this_Subrule1= ruleSubrule1 | this_Subrule2= ruleSubrule2 ) | this_Subrule3= ruleSubrule3 ) ;
    public final EObject ruleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject this_Subrule1 = null;

        EObject this_Subrule2 = null;

        EObject this_Subrule3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:291:6: ( ( (this_Subrule1= ruleSubrule1 | this_Subrule2= ruleSubrule2 ) | this_Subrule3= ruleSubrule3 ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:292:1: ( (this_Subrule1= ruleSubrule1 | this_Subrule2= ruleSubrule2 ) | this_Subrule3= ruleSubrule3 )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:292:1: ( (this_Subrule1= ruleSubrule1 | this_Subrule2= ruleSubrule2 ) | this_Subrule3= ruleSubrule3 )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            else if ( (LA5_0==16) ) {
                int LA5_2 = input.LA(2);

                if ( (LA5_2==RULE_ID) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==RULE_STRING) ) {
                        alt5=1;
                    }
                    else if ( (LA5_3==RULE_INT) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: ( (this_Subrule1= ruleSubrule1 | this_Subrule2= ruleSubrule2 ) | this_Subrule3= ruleSubrule3 )", 5, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: ( (this_Subrule1= ruleSubrule1 | this_Subrule2= ruleSubrule2 ) | this_Subrule3= ruleSubrule3 )", 5, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("292:1: ( (this_Subrule1= ruleSubrule1 | this_Subrule2= ruleSubrule2 ) | this_Subrule3= ruleSubrule3 )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:292:2: (this_Subrule1= ruleSubrule1 | this_Subrule2= ruleSubrule2 )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:292:2: (this_Subrule1= ruleSubrule1 | this_Subrule2= ruleSubrule2 )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==15) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==16) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("292:2: (this_Subrule1= ruleSubrule1 | this_Subrule2= ruleSubrule2 )", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:293:5: this_Subrule1= ruleSubrule1
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.4/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleSubrule1_in_ruleExtendableParserRule657);
                            this_Subrule1=ruleSubrule1();
                            _fsp--;

                             
                                    current = this_Subrule1; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:303:5: this_Subrule2= ruleSubrule2
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.4/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleSubrule2_in_ruleExtendableParserRule684);
                            this_Subrule2=ruleSubrule2();
                            _fsp--;

                             
                                    current = this_Subrule2; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:313:5: this_Subrule3= ruleSubrule3
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.4/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleSubrule3_in_ruleExtendableParserRule712);
                    this_Subrule3=ruleSubrule3();
                    _fsp--;

                     
                            current = this_Subrule3; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleExtendableParserRule


    // $ANTLR start entryRuleSubrule1
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:330:1: entryRuleSubrule1 returns [EObject current=null] : iv_ruleSubrule1= ruleSubrule1 EOF ;
    public final EObject entryRuleSubrule1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:330:50: (iv_ruleSubrule1= ruleSubrule1 EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:331:2: iv_ruleSubrule1= ruleSubrule1 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSubrule1_in_entryRuleSubrule1746);
            iv_ruleSubrule1=ruleSubrule1();
            _fsp--;

             current =iv_ruleSubrule1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubrule1756); 

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
    // $ANTLR end entryRuleSubrule1


    // $ANTLR start ruleSubrule1
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:338:1: ruleSubrule1 returns [EObject current=null] : ( ( 'subrule1' (lv_name= RULE_ID ) ) (lv_sub1= RULE_ID ) ) ;
    public final EObject ruleSubrule1() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_sub1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:342:6: ( ( ( 'subrule1' (lv_name= RULE_ID ) ) (lv_sub1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:343:1: ( ( 'subrule1' (lv_name= RULE_ID ) ) (lv_sub1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:343:1: ( ( 'subrule1' (lv_name= RULE_ID ) ) (lv_sub1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:343:2: ( 'subrule1' (lv_name= RULE_ID ) ) (lv_sub1= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:343:2: ( 'subrule1' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:343:3: 'subrule1' (lv_name= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleSubrule1791); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:347:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:349:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubrule1812); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Subrule1");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:367:3: (lv_sub1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:369:6: lv_sub1= RULE_ID
            {
            lv_sub1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubrule1845); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "sub1"); 
                

            	        if (current==null) {
            	            current = factory.create("Subrule1");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "sub1", lv_sub1, "ID", currentNode);
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
    // $ANTLR end ruleSubrule1


    // $ANTLR start entryRuleSubrule2
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:396:1: entryRuleSubrule2 returns [EObject current=null] : iv_ruleSubrule2= ruleSubrule2 EOF ;
    public final EObject entryRuleSubrule2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:396:50: (iv_ruleSubrule2= ruleSubrule2 EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:397:2: iv_ruleSubrule2= ruleSubrule2 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSubrule2_in_entryRuleSubrule2891);
            iv_ruleSubrule2=ruleSubrule2();
            _fsp--;

             current =iv_ruleSubrule2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubrule2901); 

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
    // $ANTLR end entryRuleSubrule2


    // $ANTLR start ruleSubrule2
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:404:1: ruleSubrule2 returns [EObject current=null] : ( ( 'subrule3' (lv_name= RULE_ID ) ) (lv_sub2= RULE_STRING ) ) ;
    public final EObject ruleSubrule2() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_sub2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:408:6: ( ( ( 'subrule3' (lv_name= RULE_ID ) ) (lv_sub2= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:409:1: ( ( 'subrule3' (lv_name= RULE_ID ) ) (lv_sub2= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:409:1: ( ( 'subrule3' (lv_name= RULE_ID ) ) (lv_sub2= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:409:2: ( 'subrule3' (lv_name= RULE_ID ) ) (lv_sub2= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:409:2: ( 'subrule3' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:409:3: 'subrule3' (lv_name= RULE_ID )
            {
            match(input,16,FOLLOW_16_in_ruleSubrule2936); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:413:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:415:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubrule2957); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Subrule2");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:433:3: (lv_sub2= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:435:6: lv_sub2= RULE_STRING
            {
            lv_sub2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSubrule2990); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "sub2"); 
                

            	        if (current==null) {
            	            current = factory.create("Subrule2");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "sub2", lv_sub2, "STRING", currentNode);
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
    // $ANTLR end ruleSubrule2


    // $ANTLR start entryRuleSubrule3
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:462:1: entryRuleSubrule3 returns [EObject current=null] : iv_ruleSubrule3= ruleSubrule3 EOF ;
    public final EObject entryRuleSubrule3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule3 = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:462:50: (iv_ruleSubrule3= ruleSubrule3 EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:463:2: iv_ruleSubrule3= ruleSubrule3 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSubrule3_in_entryRuleSubrule31036);
            iv_ruleSubrule3=ruleSubrule3();
            _fsp--;

             current =iv_ruleSubrule3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubrule31046); 

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
    // $ANTLR end entryRuleSubrule3


    // $ANTLR start ruleSubrule3
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:470:1: ruleSubrule3 returns [EObject current=null] : ( ( 'subrule3' (lv_name= RULE_ID ) ) (lv_sub1= RULE_INT ) ) ;
    public final EObject ruleSubrule3() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_sub1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:474:6: ( ( ( 'subrule3' (lv_name= RULE_ID ) ) (lv_sub1= RULE_INT ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:475:1: ( ( 'subrule3' (lv_name= RULE_ID ) ) (lv_sub1= RULE_INT ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:475:1: ( ( 'subrule3' (lv_name= RULE_ID ) ) (lv_sub1= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:475:2: ( 'subrule3' (lv_name= RULE_ID ) ) (lv_sub1= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:475:2: ( 'subrule3' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:475:3: 'subrule3' (lv_name= RULE_ID )
            {
            match(input,16,FOLLOW_16_in_ruleSubrule31081); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:479:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:481:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubrule31102); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Subrule3");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:499:3: (lv_sub1= RULE_INT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:501:6: lv_sub1= RULE_INT
            {
            lv_sub1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSubrule31135); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "sub1"); 
                

            	        if (current==null) {
            	            current = factory.create("Subrule3");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "sub1", lv_sub1, "INT", currentNode);
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
    // $ANTLR end ruleSubrule3


    // $ANTLR start entryRuleCallExtendedParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:528:1: entryRuleCallExtendedParserRule returns [EObject current=null] : iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF ;
    public final EObject entryRuleCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExtendedParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:528:64: (iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:529:2: iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.8" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCallExtendedParserRule_in_entryRuleCallExtendedParserRule1181);
            iv_ruleCallExtendedParserRule=ruleCallExtendedParserRule();
            _fsp--;

             current =iv_ruleCallExtendedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallExtendedParserRule1191); 

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
    // $ANTLR end entryRuleCallExtendedParserRule


    // $ANTLR start ruleCallExtendedParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:536:1: ruleCallExtendedParserRule returns [EObject current=null] : (lv_call= ruleAbstractCallExtendedParserRule ) ;
    public final EObject ruleCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_call = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:540:6: ( (lv_call= ruleAbstractCallExtendedParserRule ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:541:1: (lv_call= ruleAbstractCallExtendedParserRule )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:541:1: (lv_call= ruleAbstractCallExtendedParserRule )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:544:6: lv_call= ruleAbstractCallExtendedParserRule
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/0/@rules.8/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractCallExtendedParserRule_in_ruleCallExtendedParserRule1249);
            lv_call=ruleAbstractCallExtendedParserRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("CallExtendedParserRule");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "call", lv_call, "AbstractCallExtendedParserRule", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleCallExtendedParserRule


    // $ANTLR start entryRuleInheritedParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:571:1: entryRuleInheritedParserRule returns [EObject current=null] : iv_ruleInheritedParserRule= ruleInheritedParserRule EOF ;
    public final EObject entryRuleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritedParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:571:61: (iv_ruleInheritedParserRule= ruleInheritedParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:572:2: iv_ruleInheritedParserRule= ruleInheritedParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule1287);
            iv_ruleInheritedParserRule=ruleInheritedParserRule();
            _fsp--;

             current =iv_ruleInheritedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInheritedParserRule1297); 

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
    // $ANTLR end entryRuleInheritedParserRule


    // $ANTLR start ruleInheritedParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:579:1: ruleInheritedParserRule returns [EObject current=null] : ( 'element' (lv_name= RULE_ID ) ) ;
    public final EObject ruleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:583:6: ( ( 'element' (lv_name= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:584:1: ( 'element' (lv_name= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:584:1: ( 'element' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:584:2: 'element' (lv_name= RULE_ID )
            {
            match(input,17,FOLLOW_17_in_ruleInheritedParserRule1331); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.0/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:588:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:590:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInheritedParserRule1352); 
             
                createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("AType");
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
    // $ANTLR end ruleInheritedParserRule


    // $ANTLR start entryRuleAbstractCallOverridenParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:617:1: entryRuleAbstractCallOverridenParserRule returns [EObject current=null] : iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF ;
    public final EObject entryRuleAbstractCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractCallOverridenParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:617:73: (iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:618:2: iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractCallOverridenParserRule_in_entryRuleAbstractCallOverridenParserRule1398);
            iv_ruleAbstractCallOverridenParserRule=ruleAbstractCallOverridenParserRule();
            _fsp--;

             current =iv_ruleAbstractCallOverridenParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractCallOverridenParserRule1408); 

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
    // $ANTLR end entryRuleAbstractCallOverridenParserRule


    // $ANTLR start ruleAbstractCallOverridenParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:625:1: ruleAbstractCallOverridenParserRule returns [EObject current=null] : ( 'overridemodel' (lv_elements= ruleOverridableParserRule )* ) ;
    public final EObject ruleAbstractCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_elements = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:629:6: ( ( 'overridemodel' (lv_elements= ruleOverridableParserRule )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:630:1: ( 'overridemodel' (lv_elements= ruleOverridableParserRule )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:630:1: ( 'overridemodel' (lv_elements= ruleOverridableParserRule )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:630:2: 'overridemodel' (lv_elements= ruleOverridableParserRule )*
            {
            match(input,18,FOLLOW_18_in_ruleAbstractCallOverridenParserRule1442); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:634:1: (lv_elements= ruleOverridableParserRule )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:637:6: lv_elements= ruleOverridableParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleOverridableParserRule_in_ruleAbstractCallOverridenParserRule1476);
            	    lv_elements=ruleOverridableParserRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AModel");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "elements", lv_elements, "OverridableParserRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end ruleAbstractCallOverridenParserRule


    // $ANTLR start entryRuleAbstractCallExtendedParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:664:1: entryRuleAbstractCallExtendedParserRule returns [EObject current=null] : iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF ;
    public final EObject entryRuleAbstractCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractCallExtendedParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:664:72: (iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:665:2: iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractCallExtendedParserRule_in_entryRuleAbstractCallExtendedParserRule1516);
            iv_ruleAbstractCallExtendedParserRule=ruleAbstractCallExtendedParserRule();
            _fsp--;

             current =iv_ruleAbstractCallExtendedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractCallExtendedParserRule1526); 

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
    // $ANTLR end entryRuleAbstractCallExtendedParserRule


    // $ANTLR start ruleAbstractCallExtendedParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:672:1: ruleAbstractCallExtendedParserRule returns [EObject current=null] : ( 'extendedmodel' (lv_elements= ruleExtendableParserRule )* ) ;
    public final EObject ruleAbstractCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_elements = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:676:6: ( ( 'extendedmodel' (lv_elements= ruleExtendableParserRule )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:677:1: ( 'extendedmodel' (lv_elements= ruleExtendableParserRule )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:677:1: ( 'extendedmodel' (lv_elements= ruleExtendableParserRule )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:677:2: 'extendedmodel' (lv_elements= ruleExtendableParserRule )*
            {
            match(input,19,FOLLOW_19_in_ruleAbstractCallExtendedParserRule1560); 

                    createLeafNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.3/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:681:1: (lv_elements= ruleExtendableParserRule )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=15 && LA7_0<=16)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:684:6: lv_elements= ruleExtendableParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi#/1/@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExtendableParserRule_in_ruleAbstractCallExtendedParserRule1594);
            	    lv_elements=ruleExtendableParserRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AModel");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "elements", lv_elements, "ExtendableParserRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end ruleAbstractCallExtendedParserRule


 

    public static final BitSet FOLLOW_ruleRootRule_in_entryRuleRootRule72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRootRule82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteParserRule_in_ruleRootRule130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallOverridenParserRule_in_ruleRootRule157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExtendedParserRule_in_ruleRootRule185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteParserRule229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleConcreteParserRule265 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleConcreteParserRule286 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleConcreteParserRule307 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule342 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOverridableParserRule426 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallOverridenParserRule_in_entryRuleCallOverridenParserRule493 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallOverridenParserRule503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractCallOverridenParserRule_in_ruleCallOverridenParserRule561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtendableParserRule609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule1_in_ruleExtendableParserRule657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule2_in_ruleExtendableParserRule684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule3_in_ruleExtendableParserRule712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule1_in_entryRuleSubrule1746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubrule1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleSubrule1791 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule1812 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule1845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule2_in_entryRuleSubrule2891 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubrule2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSubrule2936 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule2957 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSubrule2990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule3_in_entryRuleSubrule31036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubrule31046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSubrule31081 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule31102 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSubrule31135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExtendedParserRule_in_entryRuleCallExtendedParserRule1181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallExtendedParserRule1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractCallExtendedParserRule_in_ruleCallExtendedParserRule1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule1287 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritedParserRule1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleInheritedParserRule1331 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInheritedParserRule1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractCallOverridenParserRule_in_entryRuleAbstractCallOverridenParserRule1398 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractCallOverridenParserRule1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleAbstractCallOverridenParserRule1442 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule_in_ruleAbstractCallOverridenParserRule1476 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleAbstractCallExtendedParserRule_in_entryRuleAbstractCallExtendedParserRule1516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractCallExtendedParserRule1526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleAbstractCallExtendedParserRule1560 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_ruleExtendableParserRule_in_ruleAbstractCallExtendedParserRule1594 = new BitSet(new long[]{0x0000000000018002L});

}