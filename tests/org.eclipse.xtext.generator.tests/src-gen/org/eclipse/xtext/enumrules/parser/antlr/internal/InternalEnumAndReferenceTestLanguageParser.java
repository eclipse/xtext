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
import org.eclipse.xtext.enumrules.services.EnumAndReferenceTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEnumAndReferenceTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'reference'", "'kindOfKeyword'", "'anotherEnumLiteral'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalEnumAndReferenceTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g"; }


     
     	private EnumAndReferenceTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEnumAndReferenceTestLanguageParser(TokenStream input, IAstFactory factory, EnumAndReferenceTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EntityWithEnumAndReference";	
       	} 



    // $ANTLR start entryRuleEntityWithEnumAndReference
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:73:1: entryRuleEntityWithEnumAndReference returns [EObject current=null] : iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF ;
    public final EObject entryRuleEntityWithEnumAndReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityWithEnumAndReference = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:73:68: (iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:74:2: iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntityWithEnumAndReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntityWithEnumAndReference_in_entryRuleEntityWithEnumAndReference73);
            iv_ruleEntityWithEnumAndReference=ruleEntityWithEnumAndReference();
            _fsp--;

             current =iv_ruleEntityWithEnumAndReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntityWithEnumAndReference83); 

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
    // $ANTLR end entryRuleEntityWithEnumAndReference


    // $ANTLR start ruleEntityWithEnumAndReference
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:81:1: ruleEntityWithEnumAndReference returns [EObject current=null] : ( (lv_type_0= ruleKindOfKeyword ) (lv_name_1= RULE_ID ) 'reference' ( RULE_ID ) ) ;
    public final EObject ruleEntityWithEnumAndReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Enumerator lv_type_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:86:6: ( ( (lv_type_0= ruleKindOfKeyword ) (lv_name_1= RULE_ID ) 'reference' ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:87:1: ( (lv_type_0= ruleKindOfKeyword ) (lv_name_1= RULE_ID ) 'reference' ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:87:1: ( (lv_type_0= ruleKindOfKeyword ) (lv_name_1= RULE_ID ) 'reference' ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:87:2: (lv_type_0= ruleKindOfKeyword ) (lv_name_1= RULE_ID ) 'reference' ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:87:2: (lv_type_0= ruleKindOfKeyword )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:90:6: lv_type_0= ruleKindOfKeyword
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getTypeKindOfKeywordEnumRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKindOfKeyword_in_ruleEntityWithEnumAndReference142);
            lv_type_0=ruleKindOfKeyword();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntityWithEnumAndReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "type", lv_type_0, "KindOfKeyword", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:108:2: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:110:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference168); 

            		createLeafNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntityWithEnumAndReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,11,FOLLOW_11_in_ruleEntityWithEnumAndReference185); 

                    createLeafNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getReferenceKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:132:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:135:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getEntityWithEnumAndReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference207); 

            		createLeafNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getRefEntityWithEnumAndReferenceCrossReference_3_0(), "ref"); 
            	

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
    // $ANTLR end ruleEntityWithEnumAndReference


    // $ANTLR start ruleKindOfKeyword
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:155:1: ruleKindOfKeyword returns [Enumerator current=null] : ( ( 'kindOfKeyword' ) | ( 'anotherEnumLiteral' ) ) ;
    public final Enumerator ruleKindOfKeyword() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:159:6: ( ( ( 'kindOfKeyword' ) | ( 'anotherEnumLiteral' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:160:1: ( ( 'kindOfKeyword' ) | ( 'anotherEnumLiteral' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:160:1: ( ( 'kindOfKeyword' ) | ( 'anotherEnumLiteral' ) )
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
                    new NoViableAltException("160:1: ( ( 'kindOfKeyword' ) | ( 'anotherEnumLiteral' ) )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:160:2: ( 'kindOfKeyword' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:160:2: ( 'kindOfKeyword' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:160:4: 'kindOfKeyword'
                    {
                    match(input,12,FOLLOW_12_in_ruleKindOfKeyword257); 

                            current = grammarAccess.getKindOfKeywordAccess().getKindOfKeywordEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getKindOfKeywordAccess().getKindOfKeywordEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:166:6: ( 'anotherEnumLiteral' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:166:6: ( 'anotherEnumLiteral' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:166:8: 'anotherEnumLiteral'
                    {
                    match(input,13,FOLLOW_13_in_ruleKindOfKeyword272); 

                            current = grammarAccess.getKindOfKeywordAccess().getAnotherEnumLiteralEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getKindOfKeywordAccess().getAnotherEnumLiteralEnumLiteralDeclaration_1(), null); 
                        

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
    // $ANTLR end ruleKindOfKeyword


 

    public static final BitSet FOLLOW_ruleEntityWithEnumAndReference_in_entryRuleEntityWithEnumAndReference73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntityWithEnumAndReference83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKindOfKeyword_in_ruleEntityWithEnumAndReference142 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference168 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleEntityWithEnumAndReference185 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleKindOfKeyword257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleKindOfKeyword272 = new BitSet(new long[]{0x0000000000000002L});

}