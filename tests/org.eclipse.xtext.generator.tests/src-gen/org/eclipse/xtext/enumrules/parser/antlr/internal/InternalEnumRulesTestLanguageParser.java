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
            super(input, factory, grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:70:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:71:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel71);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel81); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:78:1: ruleModel returns [EObject current=null] : ( ( 'existing' (lv_existing_1= ruleExistingEnum ) ) | ( 'generated' (lv_generated_3= ruleGeneratedEnum ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Enumerator lv_existing_1 = null;

        Enumerator lv_generated_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:83:6: ( ( ( 'existing' (lv_existing_1= ruleExistingEnum ) ) | ( 'generated' (lv_generated_3= ruleGeneratedEnum ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:84:1: ( ( 'existing' (lv_existing_1= ruleExistingEnum ) ) | ( 'generated' (lv_generated_3= ruleGeneratedEnum ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:84:1: ( ( 'existing' (lv_existing_1= ruleExistingEnum ) ) | ( 'generated' (lv_generated_3= ruleGeneratedEnum ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("84:1: ( ( 'existing' (lv_existing_1= ruleExistingEnum ) ) | ( 'generated' (lv_generated_3= ruleGeneratedEnum ) ) )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:84:2: ( 'existing' (lv_existing_1= ruleExistingEnum ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:84:2: ( 'existing' (lv_existing_1= ruleExistingEnum ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:84:3: 'existing' (lv_existing_1= ruleExistingEnum )
                    {
                    match(input,11,FOLLOW_11_in_ruleModel116); 

                            createLeafNode(grammarAccess.getModelAccess().getExistingKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:88:1: (lv_existing_1= ruleExistingEnum )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:91:6: lv_existing_1= ruleExistingEnum
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getExistingExistingEnumEnumRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExistingEnum_in_ruleModel150);
                    lv_existing_1=ruleExistingEnum();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "existing", lv_existing_1, "ExistingEnum", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:110:6: ( 'generated' (lv_generated_3= ruleGeneratedEnum ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:110:6: ( 'generated' (lv_generated_3= ruleGeneratedEnum ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:110:7: 'generated' (lv_generated_3= ruleGeneratedEnum )
                    {
                    match(input,12,FOLLOW_12_in_ruleModel171); 

                            createLeafNode(grammarAccess.getModelAccess().getGeneratedKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:114:1: (lv_generated_3= ruleGeneratedEnum )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:117:6: lv_generated_3= ruleGeneratedEnum
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGeneratedEnum_in_ruleModel205);
                    lv_generated_3=ruleGeneratedEnum();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "generated", lv_generated_3, "GeneratedEnum", lastConsumedNode);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:142:1: ruleExistingEnum returns [Enumerator current=null] : ( ( 'SameName' ) | ( 'overridden' ) | ( 'DifferentLiteral' ) ) ;
    public final Enumerator ruleExistingEnum() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:146:6: ( ( ( 'SameName' ) | ( 'overridden' ) | ( 'DifferentLiteral' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:147:1: ( ( 'SameName' ) | ( 'overridden' ) | ( 'DifferentLiteral' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:147:1: ( ( 'SameName' ) | ( 'overridden' ) | ( 'DifferentLiteral' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt2=1;
                }
                break;
            case 14:
                {
                alt2=2;
                }
                break;
            case 15:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("147:1: ( ( 'SameName' ) | ( 'overridden' ) | ( 'DifferentLiteral' ) )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:147:2: ( 'SameName' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:147:2: ( 'SameName' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:147:4: 'SameName'
                    {
                    match(input,13,FOLLOW_13_in_ruleExistingEnum257); 

                            current = grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:153:6: ( 'overridden' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:153:6: ( 'overridden' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:153:8: 'overridden'
                    {
                    match(input,14,FOLLOW_14_in_ruleExistingEnum272); 

                            current = grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:159:6: ( 'DifferentLiteral' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:159:6: ( 'DifferentLiteral' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:159:8: 'DifferentLiteral'
                    {
                    match(input,15,FOLLOW_15_in_ruleExistingEnum287); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:169:1: ruleGeneratedEnum returns [Enumerator current=null] : ( ( 'SameName' ) | ( 'DifferentLiteral' ) ) ;
    public final Enumerator ruleGeneratedEnum() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:173:6: ( ( ( 'SameName' ) | ( 'DifferentLiteral' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:174:1: ( ( 'SameName' ) | ( 'DifferentLiteral' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:174:1: ( ( 'SameName' ) | ( 'DifferentLiteral' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("174:1: ( ( 'SameName' ) | ( 'DifferentLiteral' ) )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:174:2: ( 'SameName' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:174:2: ( 'SameName' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:174:4: 'SameName'
                    {
                    match(input,13,FOLLOW_13_in_ruleGeneratedEnum330); 

                            current = grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:180:6: ( 'DifferentLiteral' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:180:6: ( 'DifferentLiteral' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumRulesTestLanguage.g:180:8: 'DifferentLiteral'
                    {
                    match(input,15,FOLLOW_15_in_ruleGeneratedEnum345); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel116 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_ruleExistingEnum_in_ruleModel150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleModel171 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_ruleGeneratedEnum_in_ruleModel205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleExistingEnum257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleExistingEnum272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleExistingEnum287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleGeneratedEnum330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleGeneratedEnum345 = new BitSet(new long[]{0x0000000000000002L});

}