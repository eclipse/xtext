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
import org.eclipse.xtext.enumrules.services.MultiRuleEnumTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMultiRuleEnumTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'someEnum'", "'A'", "'B'", "'C'", "'D'", "'E'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalMultiRuleEnumTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMultiRuleEnumTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMultiRuleEnumTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMultiRuleEnumTestLanguage.g"; }



     	private MultiRuleEnumTestLanguageGrammarAccess grammarAccess;
     	
        public InternalMultiRuleEnumTestLanguageParser(TokenStream input, MultiRuleEnumTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected MultiRuleEnumTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalMultiRuleEnumTestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalMultiRuleEnumTestLanguage.g:69:2: (iv_ruleModel= ruleModel EOF )
            // InternalMultiRuleEnumTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMultiRuleEnumTestLanguage.g:77:1: ruleModel returns [EObject current=null] : (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_a_1_0 = null;

        Enumerator lv_b_2_0 = null;

        Enumerator lv_c_3_0 = null;


         enterRule(); 
            
        try {
            // InternalMultiRuleEnumTestLanguage.g:80:28: ( (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) ) )
            // InternalMultiRuleEnumTestLanguage.g:81:1: (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) )
            {
            // InternalMultiRuleEnumTestLanguage.g:81:1: (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) )
            // InternalMultiRuleEnumTestLanguage.g:81:3: otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getSomeEnumKeyword_0());
                
            // InternalMultiRuleEnumTestLanguage.g:85:1: ( (lv_a_1_0= ruleEnumRuleA ) )
            // InternalMultiRuleEnumTestLanguage.g:86:1: (lv_a_1_0= ruleEnumRuleA )
            {
            // InternalMultiRuleEnumTestLanguage.g:86:1: (lv_a_1_0= ruleEnumRuleA )
            // InternalMultiRuleEnumTestLanguage.g:87:3: lv_a_1_0= ruleEnumRuleA
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getAEnumRuleAEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_4);
            lv_a_1_0=ruleEnumRuleA();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"a",
                    		lv_a_1_0, 
                    		"org.eclipse.xtext.enumrules.MultiRuleEnumTestLanguage.EnumRuleA");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalMultiRuleEnumTestLanguage.g:103:2: ( (lv_b_2_0= ruleEnumRuleB ) )
            // InternalMultiRuleEnumTestLanguage.g:104:1: (lv_b_2_0= ruleEnumRuleB )
            {
            // InternalMultiRuleEnumTestLanguage.g:104:1: (lv_b_2_0= ruleEnumRuleB )
            // InternalMultiRuleEnumTestLanguage.g:105:3: lv_b_2_0= ruleEnumRuleB
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getBEnumRuleBEnumRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_5);
            lv_b_2_0=ruleEnumRuleB();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"b",
                    		lv_b_2_0, 
                    		"org.eclipse.xtext.enumrules.MultiRuleEnumTestLanguage.EnumRuleB");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalMultiRuleEnumTestLanguage.g:121:2: ( (lv_c_3_0= ruleEnumRuleC ) )
            // InternalMultiRuleEnumTestLanguage.g:122:1: (lv_c_3_0= ruleEnumRuleC )
            {
            // InternalMultiRuleEnumTestLanguage.g:122:1: (lv_c_3_0= ruleEnumRuleC )
            // InternalMultiRuleEnumTestLanguage.g:123:3: lv_c_3_0= ruleEnumRuleC
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getCEnumRuleCEnumRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_c_3_0=ruleEnumRuleC();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"c",
                    		lv_c_3_0, 
                    		"org.eclipse.xtext.enumrules.MultiRuleEnumTestLanguage.EnumRuleC");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "ruleEnumRuleA"
    // InternalMultiRuleEnumTestLanguage.g:147:1: ruleEnumRuleA returns [Enumerator current=null] : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) ) ;
    public final Enumerator ruleEnumRuleA() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // InternalMultiRuleEnumTestLanguage.g:149:28: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) ) )
            // InternalMultiRuleEnumTestLanguage.g:150:1: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) )
            {
            // InternalMultiRuleEnumTestLanguage.g:150:1: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) )
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
            case 14:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalMultiRuleEnumTestLanguage.g:150:2: (enumLiteral_0= 'A' )
                    {
                    // InternalMultiRuleEnumTestLanguage.g:150:2: (enumLiteral_0= 'A' )
                    // InternalMultiRuleEnumTestLanguage.g:150:4: enumLiteral_0= 'A'
                    {
                    enumLiteral_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumRuleAAccess().getAEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEnumRuleAAccess().getAEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalMultiRuleEnumTestLanguage.g:156:6: (enumLiteral_1= 'B' )
                    {
                    // InternalMultiRuleEnumTestLanguage.g:156:6: (enumLiteral_1= 'B' )
                    // InternalMultiRuleEnumTestLanguage.g:156:8: enumLiteral_1= 'B'
                    {
                    enumLiteral_1=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumRuleAAccess().getBEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getEnumRuleAAccess().getBEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalMultiRuleEnumTestLanguage.g:162:6: (enumLiteral_2= 'C' )
                    {
                    // InternalMultiRuleEnumTestLanguage.g:162:6: (enumLiteral_2= 'C' )
                    // InternalMultiRuleEnumTestLanguage.g:162:8: enumLiteral_2= 'C'
                    {
                    enumLiteral_2=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumRuleAAccess().getCEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getEnumRuleAAccess().getCEnumLiteralDeclaration_2()); 
                        

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
    // $ANTLR end "ruleEnumRuleA"


    // $ANTLR start "ruleEnumRuleB"
    // InternalMultiRuleEnumTestLanguage.g:172:1: ruleEnumRuleB returns [Enumerator current=null] : ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) ) ;
    public final Enumerator ruleEnumRuleB() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // InternalMultiRuleEnumTestLanguage.g:174:28: ( ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) ) )
            // InternalMultiRuleEnumTestLanguage.g:175:1: ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) )
            {
            // InternalMultiRuleEnumTestLanguage.g:175:1: ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt2=1;
                }
                break;
            case 15:
                {
                alt2=2;
                }
                break;
            case 16:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalMultiRuleEnumTestLanguage.g:175:2: (enumLiteral_0= 'C' )
                    {
                    // InternalMultiRuleEnumTestLanguage.g:175:2: (enumLiteral_0= 'C' )
                    // InternalMultiRuleEnumTestLanguage.g:175:4: enumLiteral_0= 'C'
                    {
                    enumLiteral_0=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumRuleBAccess().getCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEnumRuleBAccess().getCEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalMultiRuleEnumTestLanguage.g:181:6: (enumLiteral_1= 'D' )
                    {
                    // InternalMultiRuleEnumTestLanguage.g:181:6: (enumLiteral_1= 'D' )
                    // InternalMultiRuleEnumTestLanguage.g:181:8: enumLiteral_1= 'D'
                    {
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumRuleBAccess().getDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getEnumRuleBAccess().getDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalMultiRuleEnumTestLanguage.g:187:6: (enumLiteral_2= 'E' )
                    {
                    // InternalMultiRuleEnumTestLanguage.g:187:6: (enumLiteral_2= 'E' )
                    // InternalMultiRuleEnumTestLanguage.g:187:8: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumRuleBAccess().getEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getEnumRuleBAccess().getEEnumLiteralDeclaration_2()); 
                        

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
    // $ANTLR end "ruleEnumRuleB"


    // $ANTLR start "ruleEnumRuleC"
    // InternalMultiRuleEnumTestLanguage.g:197:1: ruleEnumRuleC returns [Enumerator current=null] : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) ) ;
    public final Enumerator ruleEnumRuleC() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // InternalMultiRuleEnumTestLanguage.g:199:28: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) ) )
            // InternalMultiRuleEnumTestLanguage.g:200:1: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) )
            {
            // InternalMultiRuleEnumTestLanguage.g:200:1: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt3=1;
                }
                break;
            case 15:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalMultiRuleEnumTestLanguage.g:200:2: (enumLiteral_0= 'A' )
                    {
                    // InternalMultiRuleEnumTestLanguage.g:200:2: (enumLiteral_0= 'A' )
                    // InternalMultiRuleEnumTestLanguage.g:200:4: enumLiteral_0= 'A'
                    {
                    enumLiteral_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumRuleCAccess().getAEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEnumRuleCAccess().getAEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalMultiRuleEnumTestLanguage.g:206:6: (enumLiteral_1= 'D' )
                    {
                    // InternalMultiRuleEnumTestLanguage.g:206:6: (enumLiteral_1= 'D' )
                    // InternalMultiRuleEnumTestLanguage.g:206:8: enumLiteral_1= 'D'
                    {
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumRuleCAccess().getDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getEnumRuleCAccess().getDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalMultiRuleEnumTestLanguage.g:212:6: (enumLiteral_2= 'B' )
                    {
                    // InternalMultiRuleEnumTestLanguage.g:212:6: (enumLiteral_2= 'B' )
                    // InternalMultiRuleEnumTestLanguage.g:212:8: enumLiteral_2= 'B'
                    {
                    enumLiteral_2=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumRuleCAccess().getBEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getEnumRuleCAccess().getBEnumLiteralDeclaration_2()); 
                        

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
    // $ANTLR end "ruleEnumRuleC"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000007000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000001C000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000000B000L});
    }


}