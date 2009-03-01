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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g"; }


     
     	private ConcreteTestLanguageGrammarAccess grammarAccess;
     	
        public InternalConcreteTestLanguageParser(TokenStream input, IAstFactory factory, ConcreteTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RootRule";	
       	} 



    // $ANTLR start entryRuleRootRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:70:1: entryRuleRootRule returns [EObject current=null] : iv_ruleRootRule= ruleRootRule EOF ;
    public final EObject entryRuleRootRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:70:50: (iv_ruleRootRule= ruleRootRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:71:2: iv_ruleRootRule= ruleRootRule EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:78:1: ruleRootRule returns [EObject current=null] : ( ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule ) | this_OverridableParserRule2_3= ruleOverridableParserRule2 ) ;
    public final EObject ruleRootRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteParserRule_0 = null;

        EObject this_CallOverridenParserRule_1 = null;

        EObject this_CallExtendedParserRule_2 = null;

        EObject this_OverridableParserRule2_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:83:6: ( ( ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule ) | this_OverridableParserRule2_3= ruleOverridableParserRule2 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:84:1: ( ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule ) | this_OverridableParserRule2_3= ruleOverridableParserRule2 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:84:1: ( ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule ) | this_OverridableParserRule2_3= ruleOverridableParserRule2 )
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:84:2: ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:84:2: ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule ) | this_CallExtendedParserRule_2= ruleCallExtendedParserRule )
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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:84:3: (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:84:3: (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule )
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
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:85:5: this_ConcreteParserRule_0= ruleConcreteParserRule
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
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:95:5: this_CallOverridenParserRule_1= ruleCallOverridenParserRule
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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:105:5: this_CallExtendedParserRule_2= ruleCallExtendedParserRule
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:115:5: this_OverridableParserRule2_3= ruleOverridableParserRule2
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:132:1: entryRuleConcreteParserRule returns [EObject current=null] : iv_ruleConcreteParserRule= ruleConcreteParserRule EOF ;
    public final EObject entryRuleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:132:60: (iv_ruleConcreteParserRule= ruleConcreteParserRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:133:2: iv_ruleConcreteParserRule= ruleConcreteParserRule EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:140:1: ruleConcreteParserRule returns [EObject current=null] : ( ( ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':' ) (lv_elements_3= ruleInheritedParserRule )* ) ;
    public final EObject ruleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_magicNumber_1=null;
        EObject lv_elements_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:145:6: ( ( ( ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':' ) (lv_elements_3= ruleInheritedParserRule )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:1: ( ( ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':' ) (lv_elements_3= ruleInheritedParserRule )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:1: ( ( ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':' ) (lv_elements_3= ruleInheritedParserRule )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:2: ( ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':' ) (lv_elements_3= ruleInheritedParserRule )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:2: ( ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:3: ( 'model' (lv_magicNumber_1= RULE_REAL ) ) ':'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:3: ( 'model' (lv_magicNumber_1= RULE_REAL ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:146:4: 'model' (lv_magicNumber_1= RULE_REAL )
            {
            match(input,12,FOLLOW_12_in_ruleConcreteParserRule294); 

                    createLeafNode(grammarAccess.prConcreteParserRule().ele000KeywordModel(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:150:1: (lv_magicNumber_1= RULE_REAL )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:152:6: lv_magicNumber_1= RULE_REAL
            {
            lv_magicNumber_1=(Token)input.LT(1);
            match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleConcreteParserRule315); 

            		createLeafNode(grammarAccess.prConcreteParserRule().ele0010ParserRuleCallREAL(), "magicNumber"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prConcreteParserRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "magicNumber", lv_magicNumber_1, "REAL", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleConcreteParserRule332); 

                    createLeafNode(grammarAccess.prConcreteParserRule().ele01KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:173:2: (lv_elements_3= ruleInheritedParserRule )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==19) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:176:6: lv_elements_3= ruleInheritedParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prConcreteParserRule().ele10ParserRuleCallInheritedParserRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule367);
            	    lv_elements_3=ruleInheritedParserRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prConcreteParserRule().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:203:1: entryRuleOverridableParserRule returns [EObject current=null] : iv_ruleOverridableParserRule= ruleOverridableParserRule EOF ;
    public final EObject entryRuleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:203:63: (iv_ruleOverridableParserRule= ruleOverridableParserRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:204:2: iv_ruleOverridableParserRule= ruleOverridableParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prOverridableParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule407);
            iv_ruleOverridableParserRule=ruleOverridableParserRule();
            _fsp--;

             current =iv_ruleOverridableParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridableParserRule417); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:211:1: ruleOverridableParserRule returns [EObject current=null] : ( 'overriddenelement' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:216:6: ( ( 'overriddenelement' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:217:1: ( 'overriddenelement' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:217:1: ( 'overriddenelement' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:217:2: 'overriddenelement' (lv_name_1= RULE_ID )
            {
            match(input,14,FOLLOW_14_in_ruleOverridableParserRule451); 

                    createLeafNode(grammarAccess.prOverridableParserRule().ele0KeywordOverriddenelement(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:221:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:223:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOverridableParserRule472); 

            		createLeafNode(grammarAccess.prOverridableParserRule().ele10ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prOverridableParserRule().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:249:1: entryRuleCallOverridenParserRule returns [EObject current=null] : iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF ;
    public final EObject entryRuleCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallOverridenParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:249:65: (iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:250:2: iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCallOverridenParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCallOverridenParserRule_in_entryRuleCallOverridenParserRule514);
            iv_ruleCallOverridenParserRule=ruleCallOverridenParserRule();
            _fsp--;

             current =iv_ruleCallOverridenParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallOverridenParserRule524); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:257:1: ruleCallOverridenParserRule returns [EObject current=null] : (lv_call_0= ruleAbstractCallOverridenParserRule ) ;
    public final EObject ruleCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:262:6: ( (lv_call_0= ruleAbstractCallOverridenParserRule ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:263:1: (lv_call_0= ruleAbstractCallOverridenParserRule )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:263:1: (lv_call_0= ruleAbstractCallOverridenParserRule )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:266:6: lv_call_0= ruleAbstractCallOverridenParserRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prCallOverridenParserRule().ele0ParserRuleCallAbstractCallOverridenParserRule(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractCallOverridenParserRule_in_ruleCallOverridenParserRule582);
            lv_call_0=ruleAbstractCallOverridenParserRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prCallOverridenParserRule().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:293:1: entryRuleOverridableParserRule2 returns [EObject current=null] : iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF ;
    public final EObject entryRuleOverridableParserRule2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:293:64: (iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:294:2: iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prOverridableParserRule2().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleOverridableParserRule2_in_entryRuleOverridableParserRule2620);
            iv_ruleOverridableParserRule2=ruleOverridableParserRule2();
            _fsp--;

             current =iv_ruleOverridableParserRule2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridableParserRule2630); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:301:1: ruleOverridableParserRule2 returns [EObject current=null] : ( ( ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-' ) (lv_age_3= RULE_INT ) ) ;
    public final EObject ruleOverridableParserRule2() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_age_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:306:6: ( ( ( ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-' ) (lv_age_3= RULE_INT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:307:1: ( ( ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-' ) (lv_age_3= RULE_INT ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:307:1: ( ( ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-' ) (lv_age_3= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:307:2: ( ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-' ) (lv_age_3= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:307:2: ( ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:307:3: ( 'overridden other element' (lv_name_1= RULE_ID ) ) '-'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:307:3: ( 'overridden other element' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:307:4: 'overridden other element' (lv_name_1= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleOverridableParserRule2666); 

                    createLeafNode(grammarAccess.prOverridableParserRule2().ele000KeywordOverriddenOtherElement(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:311:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:313:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOverridableParserRule2687); 

            		createLeafNode(grammarAccess.prOverridableParserRule2().ele0010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prOverridableParserRule2().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleOverridableParserRule2704); 

                    createLeafNode(grammarAccess.prOverridableParserRule2().ele01KeywordHyphenMinus(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:334:2: (lv_age_3= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:336:6: lv_age_3= RULE_INT
            {
            lv_age_3=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleOverridableParserRule2726); 

            		createLeafNode(grammarAccess.prOverridableParserRule2().ele10ParserRuleCallINT(), "age"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prOverridableParserRule2().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:362:1: entryRuleExtendableParserRule returns [EObject current=null] : iv_ruleExtendableParserRule= ruleExtendableParserRule EOF ;
    public final EObject entryRuleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendableParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:362:62: (iv_ruleExtendableParserRule= ruleExtendableParserRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:363:2: iv_ruleExtendableParserRule= ruleExtendableParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prExtendableParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule768);
            iv_ruleExtendableParserRule=ruleExtendableParserRule();
            _fsp--;

             current =iv_ruleExtendableParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtendableParserRule778); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:370:1: ruleExtendableParserRule returns [EObject current=null] : ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 ) ;
    public final EObject ruleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject this_Subrule1_0 = null;

        EObject this_Subrule2_1 = null;

        EObject this_Subrule3_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:375:6: ( ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:376:1: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:376:1: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 )
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
                            new NoViableAltException("376:1: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 )", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("376:1: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 )", 6, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("376:1: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 ) | this_Subrule3_2= ruleSubrule3 )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:376:2: (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:376:2: (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 )
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
                            new NoViableAltException("376:2: (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 )", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:377:5: this_Subrule1_0= ruleSubrule1
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prExtendableParserRule().ele00ParserRuleCallSubrule1(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleSubrule1_in_ruleExtendableParserRule826);
                            this_Subrule1_0=ruleSubrule1();
                            _fsp--;

                             
                                    current = this_Subrule1_0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:387:5: this_Subrule2_1= ruleSubrule2
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prExtendableParserRule().ele01ParserRuleCallSubrule2(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleSubrule2_in_ruleExtendableParserRule853);
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:397:5: this_Subrule3_2= ruleSubrule3
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prExtendableParserRule().ele1ParserRuleCallSubrule3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSubrule3_in_ruleExtendableParserRule881);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:414:1: entryRuleSubrule1 returns [EObject current=null] : iv_ruleSubrule1= ruleSubrule1 EOF ;
    public final EObject entryRuleSubrule1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:414:50: (iv_ruleSubrule1= ruleSubrule1 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:415:2: iv_ruleSubrule1= ruleSubrule1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSubrule1().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubrule1_in_entryRuleSubrule1915);
            iv_ruleSubrule1=ruleSubrule1();
            _fsp--;

             current =iv_ruleSubrule1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubrule1925); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:422:1: ruleSubrule1 returns [EObject current=null] : ( ( 'subrule1' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_ID ) ) ;
    public final EObject ruleSubrule1() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_sub1_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:427:6: ( ( ( 'subrule1' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:428:1: ( ( 'subrule1' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:428:1: ( ( 'subrule1' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:428:2: ( 'subrule1' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:428:2: ( 'subrule1' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:428:3: 'subrule1' (lv_name_1= RULE_ID )
            {
            match(input,17,FOLLOW_17_in_ruleSubrule1960); 

                    createLeafNode(grammarAccess.prSubrule1().ele00KeywordSubrule1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:432:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:434:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubrule1981); 

            		createLeafNode(grammarAccess.prSubrule1().ele010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSubrule1().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:451:3: (lv_sub1_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:453:6: lv_sub1_2= RULE_ID
            {
            lv_sub1_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubrule11010); 

            		createLeafNode(grammarAccess.prSubrule1().ele10ParserRuleCallID(), "sub1"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSubrule1().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:479:1: entryRuleSubrule2 returns [EObject current=null] : iv_ruleSubrule2= ruleSubrule2 EOF ;
    public final EObject entryRuleSubrule2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:479:50: (iv_ruleSubrule2= ruleSubrule2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:480:2: iv_ruleSubrule2= ruleSubrule2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSubrule2().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubrule2_in_entryRuleSubrule21052);
            iv_ruleSubrule2=ruleSubrule2();
            _fsp--;

             current =iv_ruleSubrule2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubrule21062); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:487:1: ruleSubrule2 returns [EObject current=null] : ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub2_2= RULE_STRING ) ) ;
    public final EObject ruleSubrule2() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_sub2_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:492:6: ( ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub2_2= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:493:1: ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub2_2= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:493:1: ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub2_2= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:493:2: ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub2_2= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:493:2: ( 'subrule3' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:493:3: 'subrule3' (lv_name_1= RULE_ID )
            {
            match(input,18,FOLLOW_18_in_ruleSubrule21097); 

                    createLeafNode(grammarAccess.prSubrule2().ele00KeywordSubrule3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:497:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:499:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubrule21118); 

            		createLeafNode(grammarAccess.prSubrule2().ele010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSubrule2().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:516:3: (lv_sub2_2= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:518:6: lv_sub2_2= RULE_STRING
            {
            lv_sub2_2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSubrule21147); 

            		createLeafNode(grammarAccess.prSubrule2().ele10ParserRuleCallSTRING(), "sub2"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSubrule2().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:544:1: entryRuleSubrule3 returns [EObject current=null] : iv_ruleSubrule3= ruleSubrule3 EOF ;
    public final EObject entryRuleSubrule3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule3 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:544:50: (iv_ruleSubrule3= ruleSubrule3 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:545:2: iv_ruleSubrule3= ruleSubrule3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSubrule3().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubrule3_in_entryRuleSubrule31189);
            iv_ruleSubrule3=ruleSubrule3();
            _fsp--;

             current =iv_ruleSubrule3; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubrule31199); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:552:1: ruleSubrule3 returns [EObject current=null] : ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_INT ) ) ;
    public final EObject ruleSubrule3() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_sub1_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:557:6: ( ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_INT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:558:1: ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_INT ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:558:1: ( ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:558:2: ( 'subrule3' (lv_name_1= RULE_ID ) ) (lv_sub1_2= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:558:2: ( 'subrule3' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:558:3: 'subrule3' (lv_name_1= RULE_ID )
            {
            match(input,18,FOLLOW_18_in_ruleSubrule31234); 

                    createLeafNode(grammarAccess.prSubrule3().ele00KeywordSubrule3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:562:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:564:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubrule31255); 

            		createLeafNode(grammarAccess.prSubrule3().ele010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSubrule3().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:581:3: (lv_sub1_2= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:583:6: lv_sub1_2= RULE_INT
            {
            lv_sub1_2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSubrule31284); 

            		createLeafNode(grammarAccess.prSubrule3().ele10ParserRuleCallINT(), "sub1"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSubrule3().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:609:1: entryRuleCallExtendedParserRule returns [EObject current=null] : iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF ;
    public final EObject entryRuleCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExtendedParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:609:64: (iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:610:2: iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCallExtendedParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCallExtendedParserRule_in_entryRuleCallExtendedParserRule1326);
            iv_ruleCallExtendedParserRule=ruleCallExtendedParserRule();
            _fsp--;

             current =iv_ruleCallExtendedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallExtendedParserRule1336); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:617:1: ruleCallExtendedParserRule returns [EObject current=null] : (lv_call_0= ruleAbstractCallExtendedParserRule ) ;
    public final EObject ruleCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:622:6: ( (lv_call_0= ruleAbstractCallExtendedParserRule ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:623:1: (lv_call_0= ruleAbstractCallExtendedParserRule )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:623:1: (lv_call_0= ruleAbstractCallExtendedParserRule )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:626:6: lv_call_0= ruleAbstractCallExtendedParserRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prCallExtendedParserRule().ele0ParserRuleCallAbstractCallExtendedParserRule(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractCallExtendedParserRule_in_ruleCallExtendedParserRule1394);
            lv_call_0=ruleAbstractCallExtendedParserRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prCallExtendedParserRule().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:653:1: entryRuleInheritedParserRule returns [EObject current=null] : iv_ruleInheritedParserRule= ruleInheritedParserRule EOF ;
    public final EObject entryRuleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritedParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:653:61: (iv_ruleInheritedParserRule= ruleInheritedParserRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:654:2: iv_ruleInheritedParserRule= ruleInheritedParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prInheritedParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule1432);
            iv_ruleInheritedParserRule=ruleInheritedParserRule();
            _fsp--;

             current =iv_ruleInheritedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInheritedParserRule1442); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:661:1: ruleInheritedParserRule returns [EObject current=null] : ( 'element' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:666:6: ( ( 'element' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:667:1: ( 'element' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:667:1: ( 'element' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:667:2: 'element' (lv_name_1= RULE_ID )
            {
            match(input,19,FOLLOW_19_in_ruleInheritedParserRule1476); 

                    createLeafNode(grammarAccess.prInheritedParserRule().ele0KeywordElement(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:671:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:673:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInheritedParserRule1497); 

            		createLeafNode(grammarAccess.prInheritedParserRule().ele10ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prInheritedParserRule().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:699:1: entryRuleAbstractCallOverridenParserRule returns [EObject current=null] : iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF ;
    public final EObject entryRuleAbstractCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractCallOverridenParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:699:73: (iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:700:2: iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractCallOverridenParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractCallOverridenParserRule_in_entryRuleAbstractCallOverridenParserRule1539);
            iv_ruleAbstractCallOverridenParserRule=ruleAbstractCallOverridenParserRule();
            _fsp--;

             current =iv_ruleAbstractCallOverridenParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractCallOverridenParserRule1549); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:707:1: ruleAbstractCallOverridenParserRule returns [EObject current=null] : ( 'overridemodel' (lv_elements_1= ruleOverridableParserRule )* ) ;
    public final EObject ruleAbstractCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:712:6: ( ( 'overridemodel' (lv_elements_1= ruleOverridableParserRule )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:713:1: ( 'overridemodel' (lv_elements_1= ruleOverridableParserRule )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:713:1: ( 'overridemodel' (lv_elements_1= ruleOverridableParserRule )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:713:2: 'overridemodel' (lv_elements_1= ruleOverridableParserRule )*
            {
            match(input,20,FOLLOW_20_in_ruleAbstractCallOverridenParserRule1583); 

                    createLeafNode(grammarAccess.prAbstractCallOverridenParserRule().ele0KeywordOverridemodel(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:717:1: (lv_elements_1= ruleOverridableParserRule )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:720:6: lv_elements_1= ruleOverridableParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prAbstractCallOverridenParserRule().ele10ParserRuleCallOverridableParserRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleOverridableParserRule_in_ruleAbstractCallOverridenParserRule1617);
            	    lv_elements_1=ruleOverridableParserRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prAbstractCallOverridenParserRule().getRule().getType().getType());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:747:1: entryRuleAbstractCallExtendedParserRule returns [EObject current=null] : iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF ;
    public final EObject entryRuleAbstractCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractCallExtendedParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:747:72: (iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:748:2: iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractCallExtendedParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractCallExtendedParserRule_in_entryRuleAbstractCallExtendedParserRule1657);
            iv_ruleAbstractCallExtendedParserRule=ruleAbstractCallExtendedParserRule();
            _fsp--;

             current =iv_ruleAbstractCallExtendedParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractCallExtendedParserRule1667); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:755:1: ruleAbstractCallExtendedParserRule returns [EObject current=null] : ( 'extendedmodel' (lv_elements_1= ruleExtendableParserRule )* ) ;
    public final EObject ruleAbstractCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:760:6: ( ( 'extendedmodel' (lv_elements_1= ruleExtendableParserRule )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:761:1: ( 'extendedmodel' (lv_elements_1= ruleExtendableParserRule )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:761:1: ( 'extendedmodel' (lv_elements_1= ruleExtendableParserRule )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:761:2: 'extendedmodel' (lv_elements_1= ruleExtendableParserRule )*
            {
            match(input,21,FOLLOW_21_in_ruleAbstractCallExtendedParserRule1701); 

                    createLeafNode(grammarAccess.prAbstractCallExtendedParserRule().ele0KeywordExtendedmodel(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:765:1: (lv_elements_1= ruleExtendableParserRule )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=17 && LA8_0<=18)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:768:6: lv_elements_1= ruleExtendableParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prAbstractCallExtendedParserRule().ele10ParserRuleCallExtendableParserRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExtendableParserRule_in_ruleAbstractCallExtendedParserRule1735);
            	    lv_elements_1=ruleExtendableParserRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prAbstractCallExtendedParserRule().getRule().getType().getType());
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
    public static final BitSet FOLLOW_RULE_REAL_in_ruleConcreteParserRule315 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleConcreteParserRule332 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule367 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOverridableParserRule451 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallOverridenParserRule_in_entryRuleCallOverridenParserRule514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallOverridenParserRule524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractCallOverridenParserRule_in_ruleCallOverridenParserRule582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule2_in_entryRuleOverridableParserRule2620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule2630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleOverridableParserRule2666 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule2687 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOverridableParserRule2704 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleOverridableParserRule2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule768 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtendableParserRule778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule1_in_ruleExtendableParserRule826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule2_in_ruleExtendableParserRule853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule3_in_ruleExtendableParserRule881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule1_in_entryRuleSubrule1915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubrule1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSubrule1960 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule1981 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule11010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule2_in_entryRuleSubrule21052 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubrule21062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSubrule21097 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule21118 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSubrule21147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubrule3_in_entryRuleSubrule31189 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubrule31199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSubrule31234 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule31255 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSubrule31284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExtendedParserRule_in_entryRuleCallExtendedParserRule1326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallExtendedParserRule1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractCallExtendedParserRule_in_ruleCallExtendedParserRule1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule1432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritedParserRule1442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleInheritedParserRule1476 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInheritedParserRule1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractCallOverridenParserRule_in_entryRuleAbstractCallOverridenParserRule1539 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractCallOverridenParserRule1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleAbstractCallOverridenParserRule1583 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleOverridableParserRule_in_ruleAbstractCallOverridenParserRule1617 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleAbstractCallExtendedParserRule_in_entryRuleAbstractCallExtendedParserRule1657 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractCallExtendedParserRule1667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleAbstractCallExtendedParserRule1701 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_ruleExtendableParserRule_in_ruleAbstractCallExtendedParserRule1735 = new BitSet(new long[]{0x0000000000060002L});

}