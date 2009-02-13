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
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalConcreteTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_REAL", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "':'", "'overriddenelement'", "'overridden other element'", "'-'", "'subrule1'", "'subrule3'", "'element'", "'overridemodel'", "'extendedmodel'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=7;
    public static final int RULE_REAL=4;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;

        public InternalConcreteTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g"; }


     
     	private ConcreteTestLanguageGrammarAccess grammarAccess;
     	
        public InternalConcreteTestLanguageParser(TokenStream input, IAstFactory factory, ConcreteTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:70:1: entryRuleRootRule returns [EObject current=null] : iv_ruleRootRule= ruleRootRule EOF ;
    public final EObject entryRuleRootRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:70:50: (iv_ruleRootRule= ruleRootRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:71:2: iv_ruleRootRule= ruleRootRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prRootRule().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:78:1: ruleRootRule returns [EObject current=null] : ( ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule ) | this_OverridableParserRule2_3= ruleOverridableParserRule2 ) ;
    public final EObject ruleRootRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteParserRule_0 = null;

        EObject this_CallOverridenParserRule_1 = null;

        EObject this_CallExtendedParserRule_2 = null;

        EObject this_OverridableParserRule2_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:83:6: ( ( ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule ) | this_OverridableParserRule2_3= ruleOverridableParserRule2 ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:84:1: ( ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule ) | this_OverridableParserRule2_3= ruleOverridableParserRule2 )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:84:1: ( ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule ) | this_OverridableParserRule2_3= ruleOverridableParserRule2 )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12||(LA3_0>=20 && LA3_0<=21)) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("84:1: ( ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule ) | this_OverridableParserRule2_3= ruleOverridableParserRule2 )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:84:2: ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:84:2: ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==12||LA2_0==20) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==21) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("84:2: ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule )", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:84:3: (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:84:3: (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule )
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==12) ) {
                                alt1=1;
                            }
                            else if ( (LA1_0==20) ) {
                                alt1=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("84:3: (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule )", 1, 0, input);

                                throw nvae;
                            }
                            switch (alt1) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:85:5: this_ConcreteParserRule_0= ruleConcreteParserRule
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prRootRule().ele000ParserRuleCallConcreteParserRule(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleConcreteParserRule_in_ruleRootRule131);
                                    this_ConcreteParserRule_0=ruleConcreteParserRule();
                                    _fsp--;

                                     
                                            current = this_ConcreteParserRule_0; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:95:5: this_CallOverridenParserRule_1= ruleCallOverridenParserRule
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prRootRule().ele001ParserRuleCallCallOverridenParserRule(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleCallOverridenParserRule_in_ruleRootRule158);
                                    this_CallOverridenParserRule_1=ruleCallOverridenParserRule();
                                    _fsp--;

                                     
                                            current = this_CallOverridenParserRule_1; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:105:5: this_CallExtendedParserRule_2= ruleCallExtendedParserRule
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prRootRule().ele01ParserRuleCallCallExtendedParserRule(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleCallExtendedParserRule_in_ruleRootRule186);
                            this_CallExtendedParserRule_2=ruleCallExtendedParserRule();
                            _fsp--;

                             
                                    current = this_CallExtendedParserRule_2; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:115:5: this_OverridableParserRule2_3= ruleOverridableParserRule2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prRootRule().ele1ParserRuleCallOverridableParserRule2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOverridableParserRule2_in_ruleRootRule214);
                    this_OverridableParserRule2_3=ruleOverridableParserRule2();
                    _fsp--;

                     
                            current = this_OverridableParserRule2_3; 
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
    // $ANTLR end ruleRootRule


    // $ANTLR start entryRuleConcreteParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:132:1: entryRuleConcreteParserRule returns [EObject current=null] : iv_ruleConcreteParserRule= ruleConcreteParserRule EOF ;
    public final EObject entryRuleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:132:60: (iv_ruleConcreteParserRule= ruleConcreteParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:133:2: iv_ruleConcreteParserRule= ruleConcreteParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prConcreteParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule248);
            iv_ruleConcreteParserRule=ruleConcreteParserRule();
            _fsp--;

             current =iv_ruleConcreteParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteParserRule258); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:140:1: ruleConcreteParserRule returns [EObject current=null] : ( ( ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':' ) (lv_elements_3= ruleInheritedParserRule )* ) ;
    public final EObject ruleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_magicNumber_1=null;
        EObject lv_elements_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:145:6: ( ( ( ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':' ) (lv_elements_3= ruleInheritedParserRule )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:1: ( ( ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':' ) (lv_elements_3= ruleInheritedParserRule )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:1: ( ( ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':' ) (lv_elements_3= ruleInheritedParserRule )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:2: ( ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':' ) (lv_elements_3= ruleInheritedParserRule )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:2: ( ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:3: ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:3: ( 'model' (lv_magicNumber_1= RULE_REAL ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:4: 'model' (lv_magicNumber_1= RULE_REAL )
            {
            match(input,12,FOLLOW_12_in_ruleConcreteParserRule294); 

                    createLeafNode(grammarAccess.prConcreteParserRule().ele000KeywordModel(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:150:1: (lv_magicNumber_1= RULE_REAL )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:152:6: lv_magicNumber_1= RULE_REAL
            {
            lv_magicNumber_1=(Token)input.LT(1);
            match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleConcreteParserRule316); 

            		createLeafNode(grammarAccess.prConcreteParserRule().ele0010LexerRuleCallREAL(), "magicNumber"); 
            	

            	        if (current==null) {
            	            current = factory.create("ConcreteParserRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "magicNumber", lv_magicNumber_1, "REAL", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleConcreteParserRule334); 

                    createLeafNode(grammarAccess.prConcreteParserRule().ele01KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:174:2: (lv_elements_3= ruleInheritedParserRule )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==19) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:177:6: lv_elements_3= ruleInheritedParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prConcreteParserRule().ele10ParserRuleCallInheritedParserRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule369);
            	    lv_elements_3=ruleInheritedParserRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("ConcreteParserRule");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "elements", lv_elements_3, "InheritedParserRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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
    // $ANTLR end ruleConcreteParserRule


    // $ANTLR start entryRuleOverridableParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:204:1: entryRuleOverridableParserRule returns [EObject current=null] : iv_ruleOverridableParserRule= ruleOverridableParserRule EOF ;
    public final EObject entryRuleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:204:63: (iv_ruleOverridableParserRule= ruleOverridableParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:205:2: iv_ruleOverridableParserRule= ruleOverridableParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prOverridableParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule409);
            iv_ruleOverridableParserRule=ruleOverridableParserRule();
            _fsp--;

             current =iv_ruleOverridableParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridableParserRule419); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:212:1: ruleOverridableParserRule returns [EObject current=null] : ( 'overriddenelement' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:217:6: ( ( 'overriddenelement' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:218:1: ( 'overriddenelement' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:218:1: ( 'overriddenelement' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:218:2: 'overriddenelement' (lv_name_1= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleOverridableParserRule453); 

                    createLeafNode(grammarAccess.prOverridableParserRule().ele0KeywordOverriddenelement(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:222:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:224:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOverridableParserRule475); 

            		createLeafNode(grammarAccess.prOverridableParserRule().ele10LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create("AType");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
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
    // $ANTLR end ruleOverridableParserRule


    // $ANTLR start entryRuleCallOverridenParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:251:1: entryRuleCallOverridenParserRule returns [EObject current=null] : iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF ;
    public final EObject entryRuleCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallOverridenParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:251:65: (iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:252:2: iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCallOverridenParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCallOverridenParserRule_in_entryRuleCallOverridenParserRule518);
            iv_ruleCallOverridenParserRule=ruleCallOverridenParserRule();
            _fsp--;

             current =iv_ruleCallOverridenParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallOverridenParserRule528); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:259:1: ruleCallOverridenParserRule returns [EObject current=null] : (lv_call_0= ruleAbstractCallOverridenParserRule ) ;
    public final EObject ruleCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:264:6: ( (lv_call_0= ruleAbstractCallOverridenParserRule ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:265:1: (lv_call_0= ruleAbstractCallOverridenParserRule )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:265:1: (lv_call_0= ruleAbstractCallOverridenParserRule )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:268:6: lv_call_0= ruleAbstractCallOverridenParserRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prCallOverridenParserRule().ele0ParserRuleCallAbstractCallOverridenParserRule(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractCallOverridenParserRule_in_ruleCallOverridenParserRule586);
            lv_call_0=ruleAbstractCallOverridenParserRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("CallOverridenParserRule");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "call", lv_call_0, "AbstractCallOverridenParserRule", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleCallOverridenParserRule


    // $ANTLR start entryRuleOverridableParserRule2
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:295:1: entryRuleOverridableParserRule2 returns [EObject current=null] : iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF ;
    public final EObject entryRuleOverridableParserRule2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:295:64: (iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:296:2: iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prOverridableParserRule2().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleOverridableParserRule2_in_entryRuleOverridableParserRule2624);
            iv_ruleOverridableParserRule2=ruleOverridableParserRule2();
            _fsp--;

             current =iv_ruleOverridableParserRule2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridableParserRule2634); 

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
    // $ANTLR end entryRuleOverridableParserRule2


    // $ANTLR start ruleOverridableParserRule2
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:303:1: ruleOverridableParserRule2 returns [EObject current=null] : ( ( ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-' ) (lv_age_3= RULE_INT ) ) ;
    public final EObject ruleOverridableParserRule2() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_age_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:308:6: ( ( ( ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-' ) (lv_age_3= RULE_INT ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:309:1: ( ( ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-' ) (lv_age_3= RULE_INT ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:309:1: ( ( ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-' ) (lv_age_3= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:309:2: ( ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-' ) (lv_age_3= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:309:2: ( ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:309:3: ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:309:3: ( 'overridden other element' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:309:4: 'overridden other element' (lv_name_1= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleOverridableParserRule2670); 

                    createLeafNode(grammarAccess.prOverridableParserRule2().ele000KeywordOverriddenOtherElement(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:313:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:315:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOverridableParserRule2692); 

            		createLeafNode(grammarAccess.prOverridableParserRule2().ele0010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create("AType2");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleOverridableParserRule2710); 

                    createLeafNode(grammarAccess.prOverridableParserRule2().ele01KeywordHyphenMinus(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:337:2: (lv_age_3= RULE_INT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:339:6: lv_age_3= RULE_INT
            {
            lv_age_3=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleOverridableParserRule2733); 

            		createLeafNode(grammarAccess.prOverridableParserRule2().ele10LexerRuleCallINT(), "age"); 
            	

            	        if (current==null) {
            	            current = factory.create("AType2");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "age", lv_age_3, "INT", lastConsumedNode);
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
    // $ANTLR end ruleOverridableParserRule2


    // $ANTLR start entryRuleExtendableParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:366:1: entryRuleExtendableParserRule returns [EObject current=null] : iv_ruleExtendableParserRule= ruleExtendableParserRule EOF ;
    public final EObject entryRuleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendableParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:366:62: (iv_ruleExtendableParserRule= ruleExtendableParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:367:2: iv_ruleExtendableParserRule= ruleExtendableParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prExtendableParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule776);
            iv_ruleExtendableParserRule=ruleExtendableParserRule();
            _fsp--;

             current =iv_ruleExtendableParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtendableParserRule786); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:374:1: ruleExtendableParserRule returns [EObject current=null] : ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 ) ;
    public final EObject ruleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject this_Subrule1_0 = null;

        EObject this_Subrule2_1 = null;

        EObject this_Subrule3_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:379:6: ( ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:380:1: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:380:1: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            else if ( (LA6_0==18) ) {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==RULE_ID) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==RULE_INT) ) {
                        alt6=2;
                    }
                    else if ( (LA6_3==RULE_STRING) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("380:1: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 )", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("380:1: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 )", 6, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("380:1: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:380:2: (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:380:2: (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==17) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==18) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("380:2: (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 )", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:381:5: this_Subrule1_0= ruleSubrule1
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prExtendableParserRule().ele00ParserRuleCallSubrule1(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleSubrule1_in_ruleExtendableParserRule834);
                            this_Subrule1_0=ruleSubrule1();
                            _fsp--;

                             
                                    current = this_Subrule1_0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:391:5: this_Subrule2_1= ruleSubrule2
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prExtendableParserRule().ele01ParserRuleCallSubrule2(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleSubrule2_in_ruleExtendableParserRule861);
                            this_Subrule2_1=ruleSubrule2();
                            _fsp--;

                             
                                    current = this_Subrule2_1; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:401:5: this_Subrule3_2= ruleSubrule3
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prExtendableParserRule().ele1ParserRuleCallSubrule3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSubrule3_in_ruleExtendableParserRule889);
                    this_Subrule3_2=ruleSubrule3();
                    _fsp--;

                     
                            current = this_Subrule3_2; 
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
    // $ANTLR end ruleExtendableParserRule


    // $ANTLR start entryRuleSubrule1
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:418:1: entryRuleSubrule1 returns [EObject current=null] : iv_ruleSubrule1= ruleSubrule1 EOF ;
    public final EObject entryRuleSubrule1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:418:50: (iv_ruleSubrule1= ruleSubrule1 EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:419:2: iv_ruleSubrule1= ruleSubrule1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSubrule1().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubrule1_in_entryRuleSubrule1923);
            iv_ruleSubrule1=ruleSubrule1();
            _fsp--;

             current =iv_ruleSubrule1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubrule1933); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:426:1: ruleSubrule1 returns [EObject current=null] : ( ( 'subrule1' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_ID ) ) ;
    public final EObject ruleSubrule1() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_sub1_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:431:6: ( ( ( 'subrule1' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:432:1: ( ( 'subrule1' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:432:1: ( ( 'subrule1' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:432:2: ( 'subrule1' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:432:2: ( 'subrule1' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:432:3: 'subrule1' (lv_name_1= RULE_ID )
            {
            match(input,17,FOLLOW_17_in_ruleSubrule1968); 

                    createLeafNode(grammarAccess.prSubrule1().ele00KeywordSubrule1(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:436:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:438:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubrule1990); 

            		createLeafNode(grammarAccess.prSubrule1().ele010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create("Subrule1");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:456:3: (lv_sub1_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:458:6: lv_sub1_2= RULE_ID
            {
            lv_sub1_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubrule11021); 

            		createLeafNode(grammarAccess.prSubrule1().ele10LexerRuleCallID(), "sub1"); 
            	

            	        if (current==null) {
            	            current = factory.create("Subrule1");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "sub1", lv_sub1_2, "ID", lastConsumedNode);
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
    // $ANTLR end ruleSubrule1


    // $ANTLR start entryRuleSubrule2
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:485:1: entryRuleSubrule2 returns [EObject current=null] : iv_ruleSubrule2= ruleSubrule2 EOF ;
    public final EObject entryRuleSubrule2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:485:50: (iv_ruleSubrule2= ruleSubrule2 EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:486:2: iv_ruleSubrule2= ruleSubrule2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSubrule2().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubrule2_in_entryRuleSubrule21064);
            iv_ruleSubrule2=ruleSubrule2();
            _fsp--;

             current =iv_ruleSubrule2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubrule21074); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:493:1: ruleSubrule2 returns [EObject current=null] : ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub2_2= RULE_STRING ) ) ;
    public final EObject ruleSubrule2() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_sub2_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:498:6: ( ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub2_2= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:499:1: ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub2_2= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:499:1: ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub2_2= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:499:2: ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub2_2= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:499:2: ( 'subrule3' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:499:3: 'subrule3' (lv_name_1= RULE_ID )
            {
            match(input,18,FOLLOW_18_in_ruleSubrule21109); 

                    createLeafNode(grammarAccess.prSubrule2().ele00KeywordSubrule3(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:503:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:505:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubrule21131); 

            		createLeafNode(grammarAccess.prSubrule2().ele010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create("Subrule2");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:523:3: (lv_sub2_2= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:525:6: lv_sub2_2= RULE_STRING
            {
            lv_sub2_2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSubrule21162); 

            		createLeafNode(grammarAccess.prSubrule2().ele10LexerRuleCallSTRING(), "sub2"); 
            	

            	        if (current==null) {
            	            current = factory.create("Subrule2");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "sub2", lv_sub2_2, "STRING", lastConsumedNode);
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
    // $ANTLR end ruleSubrule2


    // $ANTLR start entryRuleSubrule3
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:552:1: entryRuleSubrule3 returns [EObject current=null] : iv_ruleSubrule3= ruleSubrule3 EOF ;
    public final EObject entryRuleSubrule3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule3 = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:552:50: (iv_ruleSubrule3= ruleSubrule3 EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:553:2: iv_ruleSubrule3= ruleSubrule3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSubrule3().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubrule3_in_entryRuleSubrule31205);
            iv_ruleSubrule3=ruleSubrule3();
            _fsp--;

             current =iv_ruleSubrule3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubrule31215); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:560:1: ruleSubrule3 returns [EObject current=null] : ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_INT ) ) ;
    public final EObject ruleSubrule3() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_sub1_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:565:6: ( ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_INT ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:566:1: ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_INT ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:566:1: ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:566:2: ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:566:2: ( 'subrule3' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:566:3: 'subrule3' (lv_name_1= RULE_ID )
            {
            match(input,18,FOLLOW_18_in_ruleSubrule31250); 

                    createLeafNode(grammarAccess.prSubrule3().ele00KeywordSubrule3(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:570:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:572:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubrule31272); 

            		createLeafNode(grammarAccess.prSubrule3().ele010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create("Subrule3");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:590:3: (lv_sub1_2= RULE_INT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:592:6: lv_sub1_2= RULE_INT
            {
            lv_sub1_2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSubrule31303); 

            		createLeafNode(grammarAccess.prSubrule3().ele10LexerRuleCallINT(), "sub1"); 
            	

            	        if (current==null) {
            	            current = factory.create("Subrule3");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "sub1", lv_sub1_2, "INT", lastConsumedNode);
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
    // $ANTLR end ruleSubrule3


    // $ANTLR start entryRuleCallExtendedParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:619:1: entryRuleCallExtendedParserRule returns [EObject current=null] : iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF ;
    public final EObject entryRuleCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExtendedParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:619:64: (iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:620:2: iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCallExtendedParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCallExtendedParserRule_in_entryRuleCallExtendedParserRule1346);
            iv_ruleCallExtendedParserRule=ruleCallExtendedParserRule();
            _fsp--;

             current =iv_ruleCallExtendedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallExtendedParserRule1356); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:627:1: ruleCallExtendedParserRule returns [EObject current=null] : (lv_call_0= ruleAbstractCallExtendedParserRule ) ;
    public final EObject ruleCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:632:6: ( (lv_call_0= ruleAbstractCallExtendedParserRule ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:633:1: (lv_call_0= ruleAbstractCallExtendedParserRule )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:633:1: (lv_call_0= ruleAbstractCallExtendedParserRule )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:636:6: lv_call_0= ruleAbstractCallExtendedParserRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prCallExtendedParserRule().ele0ParserRuleCallAbstractCallExtendedParserRule(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractCallExtendedParserRule_in_ruleCallExtendedParserRule1414);
            lv_call_0=ruleAbstractCallExtendedParserRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("CallExtendedParserRule");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "call", lv_call_0, "AbstractCallExtendedParserRule", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleCallExtendedParserRule


    // $ANTLR start entryRuleInheritedParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:663:1: entryRuleInheritedParserRule returns [EObject current=null] : iv_ruleInheritedParserRule= ruleInheritedParserRule EOF ;
    public final EObject entryRuleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritedParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:663:61: (iv_ruleInheritedParserRule= ruleInheritedParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:664:2: iv_ruleInheritedParserRule= ruleInheritedParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prInheritedParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule1452);
            iv_ruleInheritedParserRule=ruleInheritedParserRule();
            _fsp--;

             current =iv_ruleInheritedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInheritedParserRule1462); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:671:1: ruleInheritedParserRule returns [EObject current=null] : ( 'element' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:676:6: ( ( 'element' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:677:1: ( 'element' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:677:1: ( 'element' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:677:2: 'element' (lv_name_1= RULE_ID )
            {
            match(input,19,FOLLOW_19_in_ruleInheritedParserRule1496); 

                    createLeafNode(grammarAccess.prInheritedParserRule().ele0KeywordElement(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:681:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:683:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInheritedParserRule1518); 

            		createLeafNode(grammarAccess.prInheritedParserRule().ele10LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create("AType");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
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
    // $ANTLR end ruleInheritedParserRule


    // $ANTLR start entryRuleAbstractCallOverridenParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:710:1: entryRuleAbstractCallOverridenParserRule returns [EObject current=null] : iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF ;
    public final EObject entryRuleAbstractCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractCallOverridenParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:710:73: (iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:711:2: iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractCallOverridenParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractCallOverridenParserRule_in_entryRuleAbstractCallOverridenParserRule1561);
            iv_ruleAbstractCallOverridenParserRule=ruleAbstractCallOverridenParserRule();
            _fsp--;

             current =iv_ruleAbstractCallOverridenParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractCallOverridenParserRule1571); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:718:1: ruleAbstractCallOverridenParserRule returns [EObject current=null] : ( 'overridemodel' (lv_elements_1= ruleOverridableParserRule )* ) ;
    public final EObject ruleAbstractCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:723:6: ( ( 'overridemodel' (lv_elements_1= ruleOverridableParserRule )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:724:1: ( 'overridemodel' (lv_elements_1= ruleOverridableParserRule )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:724:1: ( 'overridemodel' (lv_elements_1= ruleOverridableParserRule )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:724:2: 'overridemodel' (lv_elements_1= ruleOverridableParserRule )*
            {
            match(input,20,FOLLOW_20_in_ruleAbstractCallOverridenParserRule1605); 

                    createLeafNode(grammarAccess.prAbstractCallOverridenParserRule().ele0KeywordOverridemodel(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:728:1: (lv_elements_1= ruleOverridableParserRule )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:731:6: lv_elements_1= ruleOverridableParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prAbstractCallOverridenParserRule().ele10ParserRuleCallOverridableParserRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleOverridableParserRule_in_ruleAbstractCallOverridenParserRule1639);
            	    lv_elements_1=ruleOverridableParserRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AModel");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "elements", lv_elements_1, "OverridableParserRule", currentNode);
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
    // $ANTLR end ruleAbstractCallOverridenParserRule


    // $ANTLR start entryRuleAbstractCallExtendedParserRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:758:1: entryRuleAbstractCallExtendedParserRule returns [EObject current=null] : iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF ;
    public final EObject entryRuleAbstractCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractCallExtendedParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:758:72: (iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:759:2: iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractCallExtendedParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractCallExtendedParserRule_in_entryRuleAbstractCallExtendedParserRule1679);
            iv_ruleAbstractCallExtendedParserRule=ruleAbstractCallExtendedParserRule();
            _fsp--;

             current =iv_ruleAbstractCallExtendedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractCallExtendedParserRule1689); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:766:1: ruleAbstractCallExtendedParserRule returns [EObject current=null] : ( 'extendedmodel' (lv_elements_1= ruleExtendableParserRule )* ) ;
    public final EObject ruleAbstractCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:771:6: ( ( 'extendedmodel' (lv_elements_1= ruleExtendableParserRule )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:772:1: ( 'extendedmodel' (lv_elements_1= ruleExtendableParserRule )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:772:1: ( 'extendedmodel' (lv_elements_1= ruleExtendableParserRule )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:772:2: 'extendedmodel' (lv_elements_1= ruleExtendableParserRule )*
            {
            match(input,21,FOLLOW_21_in_ruleAbstractCallExtendedParserRule1723); 

                    createLeafNode(grammarAccess.prAbstractCallExtendedParserRule().ele0KeywordExtendedmodel(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:776:1: (lv_elements_1= ruleExtendableParserRule )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=17 && LA8_0<=18)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:779:6: lv_elements_1= ruleExtendableParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prAbstractCallExtendedParserRule().ele10ParserRuleCallExtendableParserRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExtendableParserRule_in_ruleAbstractCallExtendedParserRule1757);
            	    lv_elements_1=ruleExtendableParserRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AModel");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "elements", lv_elements_1, "ExtendableParserRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end ruleAbstractCallExtendedParserRule


 

    public static final BitSet FOLLOW_ruleRootRule_in_entryRuleRootRule72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRootRule82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteParserRule_in_ruleRootRule131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallOverridenParserRule_in_ruleRootRule158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExtendedParserRule_in_ruleRootRule186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule2_in_ruleRootRule214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteParserRule258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleConcreteParserRule294 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleConcreteParserRule316 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleConcreteParserRule334 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule369 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule409 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOverridableParserRule453 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallOverridenParserRule_in_entryRuleCallOverridenParserRule518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallOverridenParserRule528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractCallOverridenParserRule_in_ruleCallOverridenParserRule586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule2_in_entryRuleOverridableParserRule2624 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule2634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleOverridableParserRule2670 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule2692 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOverridableParserRule2710 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleOverridableParserRule2733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule776 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtendableParserRule786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule1_in_ruleExtendableParserRule834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule2_in_ruleExtendableParserRule861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule3_in_ruleExtendableParserRule889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule1_in_entryRuleSubrule1923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubrule1933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSubrule1968 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule1990 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule11021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule2_in_entryRuleSubrule21064 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubrule21074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSubrule21109 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule21131 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSubrule21162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule3_in_entryRuleSubrule31205 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubrule31215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSubrule31250 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule31272 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSubrule31303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExtendedParserRule_in_entryRuleCallExtendedParserRule1346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallExtendedParserRule1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractCallExtendedParserRule_in_ruleCallExtendedParserRule1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule1452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritedParserRule1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleInheritedParserRule1496 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInheritedParserRule1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractCallOverridenParserRule_in_entryRuleAbstractCallOverridenParserRule1561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractCallOverridenParserRule1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleAbstractCallOverridenParserRule1605 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule_in_ruleAbstractCallOverridenParserRule1639 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleAbstractCallExtendedParserRule_in_entryRuleAbstractCallExtendedParserRule1679 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractCallExtendedParserRule1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleAbstractCallExtendedParserRule1723 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_ruleExtendableParserRule_in_ruleAbstractCallExtendedParserRule1757 = new BitSet(new long[]{0x0000000000060002L});

}