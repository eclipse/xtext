package org.eclipse.xtext.ide.tests.testlanguage.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'type'", "'{'", "'}'", "'['", "']'", "'string'", "'int'", "'boolean'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTestLanguage.g"; }



     	private TestLanguageGrammarAccess grammarAccess;

        public InternalTestLanguageParser(TokenStream input, TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalTestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalTestLanguage.g:68:46: (iv_ruleModel= ruleModel EOF )
            // InternalTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTestLanguage.g:75:1: ruleModel returns [EObject current=null] : ( (lv_types_0_0= ruleTypeDeclaration ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_types_0_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:81:2: ( ( (lv_types_0_0= ruleTypeDeclaration ) )* )
            // InternalTestLanguage.g:82:2: ( (lv_types_0_0= ruleTypeDeclaration ) )*
            {
            // InternalTestLanguage.g:82:2: ( (lv_types_0_0= ruleTypeDeclaration ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTestLanguage.g:83:3: (lv_types_0_0= ruleTypeDeclaration )
            	    {
            	    // InternalTestLanguage.g:83:3: (lv_types_0_0= ruleTypeDeclaration )
            	    // InternalTestLanguage.g:84:4: lv_types_0_0= ruleTypeDeclaration
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getTypesTypeDeclarationParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_types_0_0=ruleTypeDeclaration();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"types",
            	    					lv_types_0_0,
            	    					"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.TypeDeclaration");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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


    // $ANTLR start "entryRuleTypeDeclaration"
    // InternalTestLanguage.g:104:1: entryRuleTypeDeclaration returns [EObject current=null] : iv_ruleTypeDeclaration= ruleTypeDeclaration EOF ;
    public final EObject entryRuleTypeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDeclaration = null;


        try {
            // InternalTestLanguage.g:104:56: (iv_ruleTypeDeclaration= ruleTypeDeclaration EOF )
            // InternalTestLanguage.g:105:2: iv_ruleTypeDeclaration= ruleTypeDeclaration EOF
            {
             newCompositeNode(grammarAccess.getTypeDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeDeclaration=ruleTypeDeclaration();

            state._fsp--;

             current =iv_ruleTypeDeclaration; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTypeDeclaration"


    // $ANTLR start "ruleTypeDeclaration"
    // InternalTestLanguage.g:111:1: ruleTypeDeclaration returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) ;
    public final EObject ruleTypeDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_properties_3_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:117:2: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) )
            // InternalTestLanguage.g:118:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            {
            // InternalTestLanguage.g:118:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            // InternalTestLanguage.g:119:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTypeDeclarationAccess().getTypeKeyword_0());
            		
            // InternalTestLanguage.g:123:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTestLanguage.g:124:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTestLanguage.g:124:4: (lv_name_1_0= RULE_ID )
            // InternalTestLanguage.g:125:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTypeDeclarationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTypeDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getTypeDeclarationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTestLanguage.g:145:3: ( (lv_properties_3_0= ruleProperty ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||(LA2_0>=16 && LA2_0<=18)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalTestLanguage.g:146:4: (lv_properties_3_0= ruleProperty )
            	    {
            	    // InternalTestLanguage.g:146:4: (lv_properties_3_0= ruleProperty )
            	    // InternalTestLanguage.g:147:5: lv_properties_3_0= ruleProperty
            	    {

            	    					newCompositeNode(grammarAccess.getTypeDeclarationAccess().getPropertiesPropertyParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_properties_3_0=ruleProperty();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTypeDeclarationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"properties",
            	    						lv_properties_3_0,
            	    						"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Property");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTypeDeclarationAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleTypeDeclaration"


    // $ANTLR start "entryRuleProperty"
    // InternalTestLanguage.g:172:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalTestLanguage.g:172:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalTestLanguage.g:173:2: iv_ruleProperty= ruleProperty EOF
            {
             newCompositeNode(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalTestLanguage.g:179:1: ruleProperty returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:185:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalTestLanguage.g:186:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalTestLanguage.g:186:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalTestLanguage.g:187:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalTestLanguage.g:187:3: ( (lv_type_0_0= ruleType ) )
            // InternalTestLanguage.g:188:4: (lv_type_0_0= ruleType )
            {
            // InternalTestLanguage.g:188:4: (lv_type_0_0= ruleType )
            // InternalTestLanguage.g:189:5: lv_type_0_0= ruleType
            {

            					newCompositeNode(grammarAccess.getPropertyAccess().getTypeTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_0_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPropertyRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:206:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTestLanguage.g:207:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTestLanguage.g:207:4: (lv_name_1_0= RULE_ID )
            // InternalTestLanguage.g:208:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleType"
    // InternalTestLanguage.g:228:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalTestLanguage.g:228:45: (iv_ruleType= ruleType EOF )
            // InternalTestLanguage.g:229:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalTestLanguage.g:235:1: ruleType returns [EObject current=null] : ( (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )* ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_arrayDiemensions_2_0=null;
        Token otherlv_3=null;
        EObject this_TypeReference_0 = null;

        EObject this_PrimitiveType_1 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:241:2: ( ( (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )* ) )
            // InternalTestLanguage.g:242:2: ( (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )* )
            {
            // InternalTestLanguage.g:242:2: ( (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )* )
            // InternalTestLanguage.g:243:3: (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )*
            {
            // InternalTestLanguage.g:243:3: (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=16 && LA3_0<=18)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalTestLanguage.g:244:4: this_TypeReference_0= ruleTypeReference
                    {

                    				newCompositeNode(grammarAccess.getTypeAccess().getTypeReferenceParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_7);
                    this_TypeReference_0=ruleTypeReference();

                    state._fsp--;


                    				current = this_TypeReference_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:253:4: this_PrimitiveType_1= rulePrimitiveType
                    {

                    				newCompositeNode(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_7);
                    this_PrimitiveType_1=rulePrimitiveType();

                    state._fsp--;


                    				current = this_PrimitiveType_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalTestLanguage.g:262:3: ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalTestLanguage.g:263:4: ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']'
            	    {
            	    // InternalTestLanguage.g:263:4: ( (lv_arrayDiemensions_2_0= '[' ) )
            	    // InternalTestLanguage.g:264:5: (lv_arrayDiemensions_2_0= '[' )
            	    {
            	    // InternalTestLanguage.g:264:5: (lv_arrayDiemensions_2_0= '[' )
            	    // InternalTestLanguage.g:265:6: lv_arrayDiemensions_2_0= '['
            	    {
            	    lv_arrayDiemensions_2_0=(Token)match(input,14,FOLLOW_8); 

            	    						newLeafNode(lv_arrayDiemensions_2_0, grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getTypeRule());
            	    						}
            	    						addWithLastConsumed(current, "arrayDiemensions", lv_arrayDiemensions_2_0, "[");
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getRightSquareBracketKeyword_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop4;
                }
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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleTypeReference"
    // InternalTestLanguage.g:286:1: entryRuleTypeReference returns [EObject current=null] : iv_ruleTypeReference= ruleTypeReference EOF ;
    public final EObject entryRuleTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReference = null;


        try {
            // InternalTestLanguage.g:286:54: (iv_ruleTypeReference= ruleTypeReference EOF )
            // InternalTestLanguage.g:287:2: iv_ruleTypeReference= ruleTypeReference EOF
            {
             newCompositeNode(grammarAccess.getTypeReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeReference=ruleTypeReference();

            state._fsp--;

             current =iv_ruleTypeReference; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTypeReference"


    // $ANTLR start "ruleTypeReference"
    // InternalTestLanguage.g:293:1: ruleTypeReference returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:299:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalTestLanguage.g:300:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalTestLanguage.g:300:2: ( (otherlv_0= RULE_ID ) )
            // InternalTestLanguage.g:301:3: (otherlv_0= RULE_ID )
            {
            // InternalTestLanguage.g:301:3: (otherlv_0= RULE_ID )
            // InternalTestLanguage.g:302:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getTypeReferenceRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationCrossReference_0());
            			

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
    // $ANTLR end "ruleTypeReference"


    // $ANTLR start "entryRulePrimitiveType"
    // InternalTestLanguage.g:316:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalTestLanguage.g:316:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalTestLanguage.g:317:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;

             current =iv_rulePrimitiveType; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // InternalTestLanguage.g:323:1: rulePrimitiveType returns [EObject current=null] : ( ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' ) ) ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:329:2: ( ( ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' ) ) ) )
            // InternalTestLanguage.g:330:2: ( ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' ) ) )
            {
            // InternalTestLanguage.g:330:2: ( ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' ) ) )
            // InternalTestLanguage.g:331:3: ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' ) )
            {
            // InternalTestLanguage.g:331:3: ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' ) )
            // InternalTestLanguage.g:332:4: (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' )
            {
            // InternalTestLanguage.g:332:4: (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt5=1;
                }
                break;
            case 17:
                {
                alt5=2;
                }
                break;
            case 18:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalTestLanguage.g:333:5: lv_name_0_1= 'string'
                    {
                    lv_name_0_1=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:344:5: lv_name_0_2= 'int'
                    {
                    lv_name_0_2=(Token)match(input,17,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getPrimitiveTypeAccess().getNameIntKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalTestLanguage.g:355:5: lv_name_0_3= 'boolean'
                    {
                    lv_name_0_3=(Token)match(input,18,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;

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
    // $ANTLR end "rulePrimitiveType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000072010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});

}