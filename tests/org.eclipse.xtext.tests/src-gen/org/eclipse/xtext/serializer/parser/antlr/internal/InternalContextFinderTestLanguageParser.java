package org.eclipse.xtext.serializer.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.serializer.services.ContextFinderTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContextFinderTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'#3'", "'kw1'", "'kw2'", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalContextFinderTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContextFinderTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContextFinderTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g"; }



     	private ContextFinderTestLanguageGrammarAccess grammarAccess;
     	
        public InternalContextFinderTestLanguageParser(TokenStream input, ContextFinderTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected ContextFinderTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '#1' ( ( (lv_attributeExclusion_1_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_1_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_2= '#2' ( ( (lv_nestedType_3_1= ruleNestedTypeTest1 | lv_nestedType_3_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_4= '#3' ( ( (lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2 ) ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributeExclusion_1_1 = null;

        EObject lv_attributeExclusion_1_2 = null;

        EObject lv_nestedType_3_1 = null;

        EObject lv_nestedType_3_2 = null;

        EObject lv_nestedTypeRecursiveTest2_5_1 = null;

        EObject lv_nestedTypeRecursiveTest2_5_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:79:28: ( ( (otherlv_0= '#1' ( ( (lv_attributeExclusion_1_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_1_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_2= '#2' ( ( (lv_nestedType_3_1= ruleNestedTypeTest1 | lv_nestedType_3_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_4= '#3' ( ( (lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2 ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:80:1: ( (otherlv_0= '#1' ( ( (lv_attributeExclusion_1_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_1_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_2= '#2' ( ( (lv_nestedType_3_1= ruleNestedTypeTest1 | lv_nestedType_3_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_4= '#3' ( ( (lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2 ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:80:1: ( (otherlv_0= '#1' ( ( (lv_attributeExclusion_1_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_1_2= ruleAttributeExclusionTest2 ) ) ) ) | (otherlv_2= '#2' ( ( (lv_nestedType_3_1= ruleNestedTypeTest1 | lv_nestedType_3_2= ruleNestedTypeTest2 ) ) ) ) | (otherlv_4= '#3' ( ( (lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2 ) ) ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 12:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:80:2: (otherlv_0= '#1' ( ( (lv_attributeExclusion_1_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_1_2= ruleAttributeExclusionTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:80:2: (otherlv_0= '#1' ( ( (lv_attributeExclusion_1_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_1_2= ruleAttributeExclusionTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:80:4: otherlv_0= '#1' ( ( (lv_attributeExclusion_1_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_1_2= ruleAttributeExclusionTest2 ) ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel123); 

                        	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getNumberSignDigitOneKeyword_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:84:1: ( ( (lv_attributeExclusion_1_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_1_2= ruleAttributeExclusionTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:85:1: ( (lv_attributeExclusion_1_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_1_2= ruleAttributeExclusionTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:85:1: ( (lv_attributeExclusion_1_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_1_2= ruleAttributeExclusionTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:86:1: (lv_attributeExclusion_1_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_1_2= ruleAttributeExclusionTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:86:1: (lv_attributeExclusion_1_1= ruleAttributeExclusionTest1 | lv_attributeExclusion_1_2= ruleAttributeExclusionTest2 )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==14) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==15) ) {
                        alt1=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:87:3: lv_attributeExclusion_1_1= ruleAttributeExclusionTest1
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getAttributeExclusionAttributeExclusionTest1ParserRuleCall_0_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest1_in_ruleModel146);
                            lv_attributeExclusion_1_1=ruleAttributeExclusionTest1();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"attributeExclusion",
                                    		lv_attributeExclusion_1_1, 
                                    		"AttributeExclusionTest1");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:102:8: lv_attributeExclusion_1_2= ruleAttributeExclusionTest2
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getAttributeExclusionAttributeExclusionTest2ParserRuleCall_0_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest2_in_ruleModel165);
                            lv_attributeExclusion_1_2=ruleAttributeExclusionTest2();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"attributeExclusion",
                                    		lv_attributeExclusion_1_2, 
                                    		"AttributeExclusionTest2");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:121:6: (otherlv_2= '#2' ( ( (lv_nestedType_3_1= ruleNestedTypeTest1 | lv_nestedType_3_2= ruleNestedTypeTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:121:6: (otherlv_2= '#2' ( ( (lv_nestedType_3_1= ruleNestedTypeTest1 | lv_nestedType_3_2= ruleNestedTypeTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:121:8: otherlv_2= '#2' ( ( (lv_nestedType_3_1= ruleNestedTypeTest1 | lv_nestedType_3_2= ruleNestedTypeTest2 ) ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel188); 

                        	newLeafNode(otherlv_2, grammarAccess.getModelAccess().getNumberSignDigitTwoKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:125:1: ( ( (lv_nestedType_3_1= ruleNestedTypeTest1 | lv_nestedType_3_2= ruleNestedTypeTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:126:1: ( (lv_nestedType_3_1= ruleNestedTypeTest1 | lv_nestedType_3_2= ruleNestedTypeTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:126:1: ( (lv_nestedType_3_1= ruleNestedTypeTest1 | lv_nestedType_3_2= ruleNestedTypeTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:127:1: (lv_nestedType_3_1= ruleNestedTypeTest1 | lv_nestedType_3_2= ruleNestedTypeTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:127:1: (lv_nestedType_3_1= ruleNestedTypeTest1 | lv_nestedType_3_2= ruleNestedTypeTest2 )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==14) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==15) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:128:3: lv_nestedType_3_1= ruleNestedTypeTest1
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getNestedTypeNestedTypeTest1ParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest1_in_ruleModel211);
                            lv_nestedType_3_1=ruleNestedTypeTest1();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"nestedType",
                                    		lv_nestedType_3_1, 
                                    		"NestedTypeTest1");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:143:8: lv_nestedType_3_2= ruleNestedTypeTest2
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getNestedTypeNestedTypeTest2ParserRuleCall_1_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest2_in_ruleModel230);
                            lv_nestedType_3_2=ruleNestedTypeTest2();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"nestedType",
                                    		lv_nestedType_3_2, 
                                    		"NestedTypeTest2");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:162:6: (otherlv_4= '#3' ( ( (lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:162:6: (otherlv_4= '#3' ( ( (lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2 ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:162:8: otherlv_4= '#3' ( ( (lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2 ) ) )
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel253); 

                        	newLeafNode(otherlv_4, grammarAccess.getModelAccess().getNumberSignDigitThreeKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:166:1: ( ( (lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2 ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:167:1: ( (lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:167:1: ( (lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:168:1: (lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:168:1: (lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1 | lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2 )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==14) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==15) ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:169:3: lv_nestedTypeRecursiveTest2_5_1= ruleNestedTypeRecursiveTest1
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getNestedTypeRecursiveTest2NestedTypeRecursiveTest1ParserRuleCall_2_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest1_in_ruleModel276);
                            lv_nestedTypeRecursiveTest2_5_1=ruleNestedTypeRecursiveTest1();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"nestedTypeRecursiveTest2",
                                    		lv_nestedTypeRecursiveTest2_5_1, 
                                    		"NestedTypeRecursiveTest1");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:184:8: lv_nestedTypeRecursiveTest2_5_2= ruleNestedTypeRecursiveTest2
                            {
                             
                            	        newCompositeNode(grammarAccess.getModelAccess().getNestedTypeRecursiveTest2NestedTypeRecursiveTest2ParserRuleCall_2_1_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest2_in_ruleModel295);
                            lv_nestedTypeRecursiveTest2_5_2=ruleNestedTypeRecursiveTest2();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"nestedTypeRecursiveTest2",
                                    		lv_nestedTypeRecursiveTest2_5_2, 
                                    		"NestedTypeRecursiveTest2");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


                    }


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAttributeExclusionTest1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:210:1: entryRuleAttributeExclusionTest1 returns [EObject current=null] : iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF ;
    public final EObject entryRuleAttributeExclusionTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeExclusionTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:211:2: (iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:212:2: iv_ruleAttributeExclusionTest1= ruleAttributeExclusionTest1 EOF
            {
             newCompositeNode(grammarAccess.getAttributeExclusionTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest1_in_entryRuleAttributeExclusionTest1335);
            iv_ruleAttributeExclusionTest1=ruleAttributeExclusionTest1();

            state._fsp--;

             current =iv_ruleAttributeExclusionTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeExclusionTest1345); 

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
    // $ANTLR end "entryRuleAttributeExclusionTest1"


    // $ANTLR start "ruleAttributeExclusionTest1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:219:1: ruleAttributeExclusionTest1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAttributeExclusionTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr1_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:222:28: ( (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:223:1: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:223:1: (otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:223:3: otherlv_0= 'kw1' ( (lv_attr1_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttributeExclusionTest1382); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeExclusionTest1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:227:1: ( (lv_attr1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:228:1: (lv_attr1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:228:1: (lv_attr1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:229:3: lv_attr1_1_0= RULE_ID
            {
            lv_attr1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeExclusionTest1399); 

            			newLeafNode(lv_attr1_1_0, grammarAccess.getAttributeExclusionTest1Access().getAttr1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeExclusionTest1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"attr1",
                    		lv_attr1_1_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleAttributeExclusionTest1"


    // $ANTLR start "entryRuleAttributeExclusionTest2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:253:1: entryRuleAttributeExclusionTest2 returns [EObject current=null] : iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF ;
    public final EObject entryRuleAttributeExclusionTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeExclusionTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:254:2: (iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:255:2: iv_ruleAttributeExclusionTest2= ruleAttributeExclusionTest2 EOF
            {
             newCompositeNode(grammarAccess.getAttributeExclusionTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeExclusionTest2_in_entryRuleAttributeExclusionTest2440);
            iv_ruleAttributeExclusionTest2=ruleAttributeExclusionTest2();

            state._fsp--;

             current =iv_ruleAttributeExclusionTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeExclusionTest2450); 

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
    // $ANTLR end "entryRuleAttributeExclusionTest2"


    // $ANTLR start "ruleAttributeExclusionTest2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:262:1: ruleAttributeExclusionTest2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAttributeExclusionTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_attr2_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:265:28: ( (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:266:1: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:266:1: (otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:266:3: otherlv_0= 'kw2' ( (lv_attr2_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAttributeExclusionTest2487); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeExclusionTest2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:270:1: ( (lv_attr2_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:271:1: (lv_attr2_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:271:1: (lv_attr2_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:272:3: lv_attr2_1_0= RULE_ID
            {
            lv_attr2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeExclusionTest2504); 

            			newLeafNode(lv_attr2_1_0, grammarAccess.getAttributeExclusionTest2Access().getAttr2IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeExclusionTest2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"attr2",
                    		lv_attr2_1_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleAttributeExclusionTest2"


    // $ANTLR start "entryRuleNestedTypeTest1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:296:1: entryRuleNestedTypeTest1 returns [EObject current=null] : iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF ;
    public final EObject entryRuleNestedTypeTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:297:2: (iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:298:2: iv_ruleNestedTypeTest1= ruleNestedTypeTest1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest1_in_entryRuleNestedTypeTest1545);
            iv_ruleNestedTypeTest1=ruleNestedTypeTest1();

            state._fsp--;

             current =iv_ruleNestedTypeTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeTest1555); 

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
    // $ANTLR end "entryRuleNestedTypeTest1"


    // $ANTLR start "ruleNestedTypeTest1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:305:1: ruleNestedTypeTest1 returns [EObject current=null] : ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) ;
    public final EObject ruleNestedTypeTest1() throws RecognitionException {
        EObject current = null;

        EObject lv_nested_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:308:28: ( ( (lv_nested_0_0= ruleNestedTypeChild1 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:309:1: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:309:1: ( (lv_nested_0_0= ruleNestedTypeChild1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:310:1: (lv_nested_0_0= ruleNestedTypeChild1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:310:1: (lv_nested_0_0= ruleNestedTypeChild1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:311:3: lv_nested_0_0= ruleNestedTypeChild1
            {
             
            	        newCompositeNode(grammarAccess.getNestedTypeTest1Access().getNestedNestedTypeChild1ParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild1_in_ruleNestedTypeTest1600);
            lv_nested_0_0=ruleNestedTypeChild1();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNestedTypeTest1Rule());
            	        }
                   		set(
                   			current, 
                   			"nested",
                    		lv_nested_0_0, 
                    		"NestedTypeChild1");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleNestedTypeTest1"


    // $ANTLR start "entryRuleNestedTypeTest2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:335:1: entryRuleNestedTypeTest2 returns [EObject current=null] : iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF ;
    public final EObject entryRuleNestedTypeTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:336:2: (iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:337:2: iv_ruleNestedTypeTest2= ruleNestedTypeTest2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeTest2_in_entryRuleNestedTypeTest2635);
            iv_ruleNestedTypeTest2=ruleNestedTypeTest2();

            state._fsp--;

             current =iv_ruleNestedTypeTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeTest2645); 

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
    // $ANTLR end "entryRuleNestedTypeTest2"


    // $ANTLR start "ruleNestedTypeTest2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:344:1: ruleNestedTypeTest2 returns [EObject current=null] : ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) ;
    public final EObject ruleNestedTypeTest2() throws RecognitionException {
        EObject current = null;

        EObject lv_nested_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:347:28: ( ( (lv_nested_0_0= ruleNestedTypeChild2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:348:1: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:348:1: ( (lv_nested_0_0= ruleNestedTypeChild2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:349:1: (lv_nested_0_0= ruleNestedTypeChild2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:349:1: (lv_nested_0_0= ruleNestedTypeChild2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:350:3: lv_nested_0_0= ruleNestedTypeChild2
            {
             
            	        newCompositeNode(grammarAccess.getNestedTypeTest2Access().getNestedNestedTypeChild2ParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild2_in_ruleNestedTypeTest2690);
            lv_nested_0_0=ruleNestedTypeChild2();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNestedTypeTest2Rule());
            	        }
                   		set(
                   			current, 
                   			"nested",
                    		lv_nested_0_0, 
                    		"NestedTypeChild2");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleNestedTypeTest2"


    // $ANTLR start "entryRuleNestedTypeChild1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:376:1: entryRuleNestedTypeChild1 returns [EObject current=null] : iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF ;
    public final EObject entryRuleNestedTypeChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeChild1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:377:2: (iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:378:2: iv_ruleNestedTypeChild1= ruleNestedTypeChild1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeChild1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild1_in_entryRuleNestedTypeChild1727);
            iv_ruleNestedTypeChild1=ruleNestedTypeChild1();

            state._fsp--;

             current =iv_ruleNestedTypeChild1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeChild1737); 

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
    // $ANTLR end "entryRuleNestedTypeChild1"


    // $ANTLR start "ruleNestedTypeChild1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:385:1: ruleNestedTypeChild1 returns [EObject current=null] : (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNestedTypeChild1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:388:28: ( (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:389:1: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:389:1: (otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:389:3: otherlv_0= 'kw1' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleNestedTypeChild1774); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedTypeChild1Access().getKw1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:393:1: ( (lv_val_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:394:1: (lv_val_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:394:1: (lv_val_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:395:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedTypeChild1791); 

            			newLeafNode(lv_val_1_0, grammarAccess.getNestedTypeChild1Access().getValIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNestedTypeChild1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_1_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleNestedTypeChild1"


    // $ANTLR start "entryRuleNestedTypeChild2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:419:1: entryRuleNestedTypeChild2 returns [EObject current=null] : iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF ;
    public final EObject entryRuleNestedTypeChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeChild2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:420:2: (iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:421:2: iv_ruleNestedTypeChild2= ruleNestedTypeChild2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeChild2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeChild2_in_entryRuleNestedTypeChild2832);
            iv_ruleNestedTypeChild2=ruleNestedTypeChild2();

            state._fsp--;

             current =iv_ruleNestedTypeChild2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeChild2842); 

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
    // $ANTLR end "entryRuleNestedTypeChild2"


    // $ANTLR start "ruleNestedTypeChild2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:428:1: ruleNestedTypeChild2 returns [EObject current=null] : (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNestedTypeChild2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:431:28: ( (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:432:1: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:432:1: (otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:432:3: otherlv_0= 'kw2' ( (lv_val_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleNestedTypeChild2879); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedTypeChild2Access().getKw2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:436:1: ( (lv_val_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:437:1: (lv_val_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:437:1: (lv_val_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:438:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedTypeChild2896); 

            			newLeafNode(lv_val_1_0, grammarAccess.getNestedTypeChild2Access().getValIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNestedTypeChild2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"val",
                    		lv_val_1_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleNestedTypeChild2"


    // $ANTLR start "entryRuleNestedTypeRecursiveTest1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:462:1: entryRuleNestedTypeRecursiveTest1 returns [EObject current=null] : iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF ;
    public final EObject entryRuleNestedTypeRecursiveTest1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeRecursiveTest1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:463:2: (iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:464:2: iv_ruleNestedTypeRecursiveTest1= ruleNestedTypeRecursiveTest1 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeRecursiveTest1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest1_in_entryRuleNestedTypeRecursiveTest1937);
            iv_ruleNestedTypeRecursiveTest1=ruleNestedTypeRecursiveTest1();

            state._fsp--;

             current =iv_ruleNestedTypeRecursiveTest1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest1947); 

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
    // $ANTLR end "entryRuleNestedTypeRecursiveTest1"


    // $ANTLR start "ruleNestedTypeRecursiveTest1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:471:1: ruleNestedTypeRecursiveTest1 returns [EObject current=null] : ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) ;
    public final EObject ruleNestedTypeRecursiveTest1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:474:28: ( ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:475:1: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:475:1: ( () otherlv_1= 'kw1' ( () otherlv_3= '.' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:475:2: () otherlv_1= 'kw1' ( () otherlv_3= '.' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:475:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:476:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNestedTypeRecursiveTest1Access().getNestedTypeRecursiveTest1Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleNestedTypeRecursiveTest1993); 

                	newLeafNode(otherlv_1, grammarAccess.getNestedTypeRecursiveTest1Access().getKw1Keyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:485:1: ( () otherlv_3= '.' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:485:2: () otherlv_3= '.'
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:485:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:486:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getNestedTypeRecursiveTest1Access().getNestedTypeRecursiveTestLeftAction_2_0(),
            	                current);
            	        

            	    }

            	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleNestedTypeRecursiveTest11015); 

            	        	newLeafNode(otherlv_3, grammarAccess.getNestedTypeRecursiveTest1Access().getFullStopKeyword_2_1());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


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
    // $ANTLR end "ruleNestedTypeRecursiveTest1"


    // $ANTLR start "entryRuleNestedTypeRecursiveTest2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:503:1: entryRuleNestedTypeRecursiveTest2 returns [EObject current=null] : iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF ;
    public final EObject entryRuleNestedTypeRecursiveTest2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedTypeRecursiveTest2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:504:2: (iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:505:2: iv_ruleNestedTypeRecursiveTest2= ruleNestedTypeRecursiveTest2 EOF
            {
             newCompositeNode(grammarAccess.getNestedTypeRecursiveTest2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedTypeRecursiveTest2_in_entryRuleNestedTypeRecursiveTest21053);
            iv_ruleNestedTypeRecursiveTest2=ruleNestedTypeRecursiveTest2();

            state._fsp--;

             current =iv_ruleNestedTypeRecursiveTest2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest21063); 

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
    // $ANTLR end "entryRuleNestedTypeRecursiveTest2"


    // $ANTLR start "ruleNestedTypeRecursiveTest2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:512:1: ruleNestedTypeRecursiveTest2 returns [EObject current=null] : ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) ;
    public final EObject ruleNestedTypeRecursiveTest2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:515:28: ( ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:516:1: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:516:1: ( () otherlv_1= 'kw2' ( () otherlv_3= '.' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:516:2: () otherlv_1= 'kw2' ( () otherlv_3= '.' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:516:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:517:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNestedTypeRecursiveTest2Access().getNestedTypeRecursiveTest2Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleNestedTypeRecursiveTest21109); 

                	newLeafNode(otherlv_1, grammarAccess.getNestedTypeRecursiveTest2Access().getKw2Keyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:526:1: ( () otherlv_3= '.' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==16) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:526:2: () otherlv_3= '.'
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:526:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/serializer/parser/antlr/internal/InternalContextFinderTestLanguage.g:527:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getNestedTypeRecursiveTest2Access().getNestedTypeRecursiveTestLeftAction_2_0(),
            	                current);
            	        

            	    }

            	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleNestedTypeRecursiveTest21131); 

            	        	newLeafNode(otherlv_3, grammarAccess.getNestedTypeRecursiveTest2Access().getFullStopKeyword_2_1());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


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
    // $ANTLR end "ruleNestedTypeRecursiveTest2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel123 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest1_in_ruleModel146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest2_in_ruleModel165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel188 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_ruleNestedTypeTest1_in_ruleModel211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest2_in_ruleModel230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel253 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest1_in_ruleModel276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest2_in_ruleModel295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest1_in_entryRuleAttributeExclusionTest1335 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeExclusionTest1345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleAttributeExclusionTest1382 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeExclusionTest1399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeExclusionTest2_in_entryRuleAttributeExclusionTest2440 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeExclusionTest2450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleAttributeExclusionTest2487 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeExclusionTest2504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest1_in_entryRuleNestedTypeTest1545 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeTest1555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild1_in_ruleNestedTypeTest1600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeTest2_in_entryRuleNestedTypeTest2635 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeTest2645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild2_in_ruleNestedTypeTest2690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild1_in_entryRuleNestedTypeChild1727 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeChild1737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleNestedTypeChild1774 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedTypeChild1791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeChild2_in_entryRuleNestedTypeChild2832 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeChild2842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleNestedTypeChild2879 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedTypeChild2896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest1_in_entryRuleNestedTypeRecursiveTest1937 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest1947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleNestedTypeRecursiveTest1993 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleNestedTypeRecursiveTest11015 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_ruleNestedTypeRecursiveTest2_in_entryRuleNestedTypeRecursiveTest21053 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedTypeRecursiveTest21063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleNestedTypeRecursiveTest21109 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleNestedTypeRecursiveTest21131 = new BitSet(new long[]{0x0000000000010002L});
    }


}