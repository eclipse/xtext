package org.eclipse.xtext.enumrules.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.enumrules.services.EnumAndReferenceTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEnumAndReferenceTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'reference'", "'kindOfKeyword'", "'anotherEnumLiteral'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalEnumAndReferenceTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEnumAndReferenceTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEnumAndReferenceTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g"; }



     	private EnumAndReferenceTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEnumAndReferenceTestLanguageParser(TokenStream input, EnumAndReferenceTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EntityWithEnumAndReference";	
       	}
       	
       	@Override
       	protected EnumAndReferenceTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleEntityWithEnumAndReference"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:68:1: entryRuleEntityWithEnumAndReference returns [EObject current=null] : iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF ;
    public final EObject entryRuleEntityWithEnumAndReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityWithEnumAndReference = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:69:2: (iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:70:2: iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF
            {
             newCompositeNode(grammarAccess.getEntityWithEnumAndReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEntityWithEnumAndReference_in_entryRuleEntityWithEnumAndReference75);
            iv_ruleEntityWithEnumAndReference=ruleEntityWithEnumAndReference();

            state._fsp--;

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
    // $ANTLR end "entryRuleEntityWithEnumAndReference"


    // $ANTLR start "ruleEntityWithEnumAndReference"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:77:1: ruleEntityWithEnumAndReference returns [EObject current=null] : ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleEntityWithEnumAndReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Enumerator lv_type_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:80:28: ( ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:81:1: ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:81:1: ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:81:2: ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:81:2: ( (lv_type_0_0= ruleKindOfKeyword ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:82:1: (lv_type_0_0= ruleKindOfKeyword )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:82:1: (lv_type_0_0= ruleKindOfKeyword )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:83:3: lv_type_0_0= ruleKindOfKeyword
            {
             
            	        newCompositeNode(grammarAccess.getEntityWithEnumAndReferenceAccess().getTypeKindOfKeywordEnumRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleKindOfKeyword_in_ruleEntityWithEnumAndReference131);
            lv_type_0_0=ruleKindOfKeyword();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEntityWithEnumAndReferenceRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_0_0, 
                    		"org.eclipse.xtext.enumrules.EnumAndReferenceTestLanguage.KindOfKeyword");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:99:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:100:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:100:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:101:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference148); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEntityWithEnumAndReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEntityWithEnumAndReferenceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleEntityWithEnumAndReference165); 

                	newLeafNode(otherlv_2, grammarAccess.getEntityWithEnumAndReferenceAccess().getReferenceKeyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:121:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:122:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:122:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:123:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEntityWithEnumAndReferenceRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference185); 

            		newLeafNode(otherlv_3, grammarAccess.getEntityWithEnumAndReferenceAccess().getRefEntityWithEnumAndReferenceCrossReference_3_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityWithEnumAndReference"


    // $ANTLR start "ruleKindOfKeyword"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:142:1: ruleKindOfKeyword returns [Enumerator current=null] : ( (enumLiteral_0= 'kindOfKeyword' ) | (enumLiteral_1= 'anotherEnumLiteral' ) ) ;
    public final Enumerator ruleKindOfKeyword() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:144:28: ( ( (enumLiteral_0= 'kindOfKeyword' ) | (enumLiteral_1= 'anotherEnumLiteral' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:145:1: ( (enumLiteral_0= 'kindOfKeyword' ) | (enumLiteral_1= 'anotherEnumLiteral' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:145:1: ( (enumLiteral_0= 'kindOfKeyword' ) | (enumLiteral_1= 'anotherEnumLiteral' ) )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:145:2: (enumLiteral_0= 'kindOfKeyword' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:145:2: (enumLiteral_0= 'kindOfKeyword' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:145:4: enumLiteral_0= 'kindOfKeyword'
                    {
                    enumLiteral_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleKindOfKeyword235); 

                            current = grammarAccess.getKindOfKeywordAccess().getKindOfKeywordEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getKindOfKeywordAccess().getKindOfKeywordEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:151:6: (enumLiteral_1= 'anotherEnumLiteral' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:151:6: (enumLiteral_1= 'anotherEnumLiteral' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/enumrules/parser/antlr/internal/InternalEnumAndReferenceTestLanguage.g:151:8: enumLiteral_1= 'anotherEnumLiteral'
                    {
                    enumLiteral_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleKindOfKeyword252); 

                            current = grammarAccess.getKindOfKeywordAccess().getAnotherEnumLiteralEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getKindOfKeywordAccess().getAnotherEnumLiteralEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKindOfKeyword"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEntityWithEnumAndReference_in_entryRuleEntityWithEnumAndReference75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEntityWithEnumAndReference85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKindOfKeyword_in_ruleEntityWithEnumAndReference131 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference148 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleEntityWithEnumAndReference165 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleKindOfKeyword235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleKindOfKeyword252 = new BitSet(new long[]{0x0000000000000002L});
    }


}