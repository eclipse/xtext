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
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalEnumAndReferenceTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g"; }



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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:73:1: entryRuleEntityWithEnumAndReference returns [EObject current=null] : iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF ;
    public final EObject entryRuleEntityWithEnumAndReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityWithEnumAndReference = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:74:2: (iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:75:2: iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntityWithEnumAndReferenceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEntityWithEnumAndReference_in_entryRuleEntityWithEnumAndReference75);
            iv_ruleEntityWithEnumAndReference=ruleEntityWithEnumAndReference();
            _fsp--;

             current =iv_ruleEntityWithEnumAndReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEntityWithEnumAndReference85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:82:1: ruleEntityWithEnumAndReference returns [EObject current=null] : ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) 'reference' ( ( RULE_ID ) ) ) ;
    public final EObject ruleEntityWithEnumAndReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Enumerator lv_type_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:87:6: ( ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) 'reference' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:88:1: ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) 'reference' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:88:1: ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) 'reference' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:88:2: ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) 'reference' ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:88:2: ( (lv_type_0_0= ruleKindOfKeyword ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:89:1: (lv_type_0_0= ruleKindOfKeyword )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:89:1: (lv_type_0_0= ruleKindOfKeyword )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:90:3: lv_type_0_0= ruleKindOfKeyword
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getTypeKindOfKeywordEnumRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleKindOfKeyword_in_ruleEntityWithEnumAndReference131);
            lv_type_0_0=ruleKindOfKeyword();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntityWithEnumAndReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_0_0, 
            	        		"KindOfKeyword", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:112:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:113:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:113:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:114:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference148); 

            			createLeafNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntityWithEnumAndReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,11,FollowSets000.FOLLOW_11_in_ruleEntityWithEnumAndReference163); 

                    createLeafNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getReferenceKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:140:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:141:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:141:1: ( RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:142:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getEntityWithEnumAndReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference181); 

            		createLeafNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getRefEntityWithEnumAndReferenceCrossReference_3_0(), "ref"); 
            	

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
    // $ANTLR end ruleEntityWithEnumAndReference


    // $ANTLR start ruleKindOfKeyword
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:162:1: ruleKindOfKeyword returns [Enumerator current=null] : ( ( 'kindOfKeyword' ) | ( 'anotherEnumLiteral' ) ) ;
    public final Enumerator ruleKindOfKeyword() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:166:6: ( ( ( 'kindOfKeyword' ) | ( 'anotherEnumLiteral' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:167:1: ( ( 'kindOfKeyword' ) | ( 'anotherEnumLiteral' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:167:1: ( ( 'kindOfKeyword' ) | ( 'anotherEnumLiteral' ) )
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
                    new NoViableAltException("167:1: ( ( 'kindOfKeyword' ) | ( 'anotherEnumLiteral' ) )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:167:2: ( 'kindOfKeyword' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:167:2: ( 'kindOfKeyword' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:167:4: 'kindOfKeyword'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleKindOfKeyword229); 

                            current = grammarAccess.getKindOfKeywordAccess().getKindOfKeywordEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getKindOfKeywordAccess().getKindOfKeywordEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:173:6: ( 'anotherEnumLiteral' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:173:6: ( 'anotherEnumLiteral' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:173:8: 'anotherEnumLiteral'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleKindOfKeyword244); 

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEntityWithEnumAndReference_in_entryRuleEntityWithEnumAndReference75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEntityWithEnumAndReference85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKindOfKeyword_in_ruleEntityWithEnumAndReference131 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference148 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleEntityWithEnumAndReference163 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleKindOfKeyword229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleKindOfKeyword244 = new BitSet(new long[]{0x0000000000000002L});
    }


}