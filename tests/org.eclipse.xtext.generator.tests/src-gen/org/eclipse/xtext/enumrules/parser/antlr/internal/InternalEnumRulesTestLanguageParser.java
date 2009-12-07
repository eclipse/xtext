package org.eclipse.xtext.enumrules.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.enumrules.services.EnumRulesTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEnumRulesTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'existing'", "'generated'", "'SameName'", "'overridden'", "'DifferentLiteral'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalEnumRulesTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g"; }



     	private EnumRulesTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEnumRulesTestLanguageParser(TokenStream input, IAstFactory factory, EnumRulesTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:73:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:73:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:74:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel83); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( ( 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) ( 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | ( 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Enumerator lv_existing_1_0 = null;

        Enumerator lv_generated_3_0 = null;

        Enumerator lv_generated_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:86:6: ( ( ( 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) ( 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | ( 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:87:1: ( ( 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) ( 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | ( 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:87:1: ( ( 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) ( 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | ( 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("87:1: ( ( 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) ( 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | ( 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:87:2: ( 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) ( 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:87:2: ( 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) ( 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:87:4: 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) ( 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )?
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleModel119); 

                            createLeafNode(grammarAccess.getModelAccess().getExistingKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:91:1: ( (lv_existing_1_0= ruleExistingEnum ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:92:1: (lv_existing_1_0= ruleExistingEnum )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:92:1: (lv_existing_1_0= ruleExistingEnum )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:93:3: lv_existing_1_0= ruleExistingEnum
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getExistingExistingEnumEnumRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExistingEnum_in_ruleModel140);
                    lv_existing_1_0=ruleExistingEnum();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"existing",
                    	        		lv_existing_1_0, 
                    	        		"ExistingEnum", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:115:2: ( 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==12) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:115:4: 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) )
                            {
                            match(input,12,FollowSets000.FOLLOW_12_in_ruleModel151); 

                                    createLeafNode(grammarAccess.getModelAccess().getGeneratedKeyword_0_2_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:119:1: ( (lv_generated_3_0= ruleGeneratedEnum ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:120:1: (lv_generated_3_0= ruleGeneratedEnum )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:120:1: (lv_generated_3_0= ruleGeneratedEnum )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:121:3: lv_generated_3_0= ruleGeneratedEnum
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_0_2_1_0(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleGeneratedEnum_in_ruleModel172);
                            lv_generated_3_0=ruleGeneratedEnum();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"generated",
                            	        		lv_generated_3_0, 
                            	        		"GeneratedEnum", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:144:6: ( 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:144:6: ( 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:144:8: 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) )
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel192); 

                            createLeafNode(grammarAccess.getModelAccess().getGeneratedKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:148:1: ( (lv_generated_5_0= ruleGeneratedEnum ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:149:1: (lv_generated_5_0= ruleGeneratedEnum )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:149:1: (lv_generated_5_0= ruleGeneratedEnum )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:150:3: lv_generated_5_0= ruleGeneratedEnum
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedEnum_in_ruleModel213);
                    lv_generated_5_0=ruleGeneratedEnum();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"generated",
                    	        		lv_generated_5_0, 
                    	        		"GeneratedEnum", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


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
    // $ANTLR end ruleModel


    // $ANTLR start ruleExistingEnum
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:179:1: ruleExistingEnum returns [Enumerator current=null] : ( ( 'SameName' ) | ( 'overridden' ) | ( 'DifferentLiteral' ) ) ;
    public final Enumerator ruleExistingEnum() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:183:6: ( ( ( 'SameName' ) | ( 'overridden' ) | ( 'DifferentLiteral' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:184:1: ( ( 'SameName' ) | ( 'overridden' ) | ( 'DifferentLiteral' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:184:1: ( ( 'SameName' ) | ( 'overridden' ) | ( 'DifferentLiteral' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 14:
                {
                alt3=2;
                }
                break;
            case 15:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("184:1: ( ( 'SameName' ) | ( 'overridden' ) | ( 'DifferentLiteral' ) )", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:184:2: ( 'SameName' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:184:2: ( 'SameName' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:184:4: 'SameName'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleExistingEnum261); 

                            current = grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:190:6: ( 'overridden' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:190:6: ( 'overridden' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:190:8: 'overridden'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleExistingEnum276); 

                            current = grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:196:6: ( 'DifferentLiteral' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:196:6: ( 'DifferentLiteral' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:196:8: 'DifferentLiteral'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleExistingEnum291); 

                            current = grammarAccess.getExistingEnumAccess().getDifferentNameEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getExistingEnumAccess().getDifferentNameEnumLiteralDeclaration_2(), null); 
                        

                    }


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
    // $ANTLR end ruleExistingEnum


    // $ANTLR start ruleGeneratedEnum
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:206:1: ruleGeneratedEnum returns [Enumerator current=null] : ( ( 'SameName' ) | ( 'DifferentLiteral' ) ) ;
    public final Enumerator ruleGeneratedEnum() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:210:6: ( ( ( 'SameName' ) | ( 'DifferentLiteral' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:211:1: ( ( 'SameName' ) | ( 'DifferentLiteral' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:211:1: ( ( 'SameName' ) | ( 'DifferentLiteral' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("211:1: ( ( 'SameName' ) | ( 'DifferentLiteral' ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:211:2: ( 'SameName' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:211:2: ( 'SameName' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:211:4: 'SameName'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleGeneratedEnum334); 

                            current = grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:217:6: ( 'DifferentLiteral' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:217:6: ( 'DifferentLiteral' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:217:8: 'DifferentLiteral'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleGeneratedEnum349); 

                            current = grammarAccess.getGeneratedEnumAccess().getDifferentNameEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getGeneratedEnumAccess().getDifferentNameEnumLiteralDeclaration_1(), null); 
                        

                    }


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
    // $ANTLR end ruleGeneratedEnum


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel119 = new BitSet(new long[]{0x000000000000E000L});
        public static final BitSet FOLLOW_ruleExistingEnum_in_ruleModel140 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleModel151 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_ruleGeneratedEnum_in_ruleModel172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel192 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_ruleGeneratedEnum_in_ruleModel213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleExistingEnum261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleExistingEnum276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleExistingEnum291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleGeneratedEnum334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleGeneratedEnum349 = new BitSet(new long[]{0x0000000000000002L});
    }


}