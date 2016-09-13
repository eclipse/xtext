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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'type'", "'extends'", "'{'", "'}'", "'['", "']'", "'op'", "'('", "','", "')'", "':'", "'string'", "'int'", "'boolean'", "'void'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

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
    // InternalTestLanguage.g:111:1: ruleTypeDeclaration returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}' ) ;
    public final EObject ruleTypeDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_members_5_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:117:2: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}' ) )
            // InternalTestLanguage.g:118:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}' )
            {
            // InternalTestLanguage.g:118:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}' )
            // InternalTestLanguage.g:119:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}'
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

            // InternalTestLanguage.g:141:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalTestLanguage.g:142:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getTypeDeclarationAccess().getExtendsKeyword_2_0());
                    			
                    // InternalTestLanguage.g:146:4: ( (otherlv_3= RULE_ID ) )
                    // InternalTestLanguage.g:147:5: (otherlv_3= RULE_ID )
                    {
                    // InternalTestLanguage.g:147:5: (otherlv_3= RULE_ID )
                    // InternalTestLanguage.g:148:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeDeclarationRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_3, grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getTypeDeclarationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTestLanguage.g:164:3: ( (lv_members_5_0= ruleMember ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID||LA3_0==17||(LA3_0>=22 && LA3_0<=25)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalTestLanguage.g:165:4: (lv_members_5_0= ruleMember )
            	    {
            	    // InternalTestLanguage.g:165:4: (lv_members_5_0= ruleMember )
            	    // InternalTestLanguage.g:166:5: lv_members_5_0= ruleMember
            	    {

            	    					newCompositeNode(grammarAccess.getTypeDeclarationAccess().getMembersMemberParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_members_5_0=ruleMember();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTypeDeclarationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"members",
            	    						lv_members_5_0,
            	    						"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Member");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getTypeDeclarationAccess().getRightCurlyBracketKeyword_5());
            		

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


    // $ANTLR start "entryRuleMember"
    // InternalTestLanguage.g:191:1: entryRuleMember returns [EObject current=null] : iv_ruleMember= ruleMember EOF ;
    public final EObject entryRuleMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMember = null;


        try {
            // InternalTestLanguage.g:191:47: (iv_ruleMember= ruleMember EOF )
            // InternalTestLanguage.g:192:2: iv_ruleMember= ruleMember EOF
            {
             newCompositeNode(grammarAccess.getMemberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMember=ruleMember();

            state._fsp--;

             current =iv_ruleMember; 
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
    // $ANTLR end "entryRuleMember"


    // $ANTLR start "ruleMember"
    // InternalTestLanguage.g:198:1: ruleMember returns [EObject current=null] : (this_Property_0= ruleProperty | this_Operation_1= ruleOperation ) ;
    public final EObject ruleMember() throws RecognitionException {
        EObject current = null;

        EObject this_Property_0 = null;

        EObject this_Operation_1 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:204:2: ( (this_Property_0= ruleProperty | this_Operation_1= ruleOperation ) )
            // InternalTestLanguage.g:205:2: (this_Property_0= ruleProperty | this_Operation_1= ruleOperation )
            {
            // InternalTestLanguage.g:205:2: (this_Property_0= ruleProperty | this_Operation_1= ruleOperation )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID||(LA4_0>=22 && LA4_0<=25)) ) {
                alt4=1;
            }
            else if ( (LA4_0==17) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalTestLanguage.g:206:3: this_Property_0= ruleProperty
                    {

                    			newCompositeNode(grammarAccess.getMemberAccess().getPropertyParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Property_0=ruleProperty();

                    state._fsp--;


                    			current = this_Property_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:215:3: this_Operation_1= ruleOperation
                    {

                    			newCompositeNode(grammarAccess.getMemberAccess().getOperationParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Operation_1=ruleOperation();

                    state._fsp--;


                    			current = this_Operation_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleMember"


    // $ANTLR start "entryRuleProperty"
    // InternalTestLanguage.g:227:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalTestLanguage.g:227:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalTestLanguage.g:228:2: iv_ruleProperty= ruleProperty EOF
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
    // InternalTestLanguage.g:234:1: ruleProperty returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:240:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalTestLanguage.g:241:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalTestLanguage.g:241:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalTestLanguage.g:242:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalTestLanguage.g:242:3: ( (lv_type_0_0= ruleType ) )
            // InternalTestLanguage.g:243:4: (lv_type_0_0= ruleType )
            {
            // InternalTestLanguage.g:243:4: (lv_type_0_0= ruleType )
            // InternalTestLanguage.g:244:5: lv_type_0_0= ruleType
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

            // InternalTestLanguage.g:261:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTestLanguage.g:262:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTestLanguage.g:262:4: (lv_name_1_0= RULE_ID )
            // InternalTestLanguage.g:263:5: lv_name_1_0= RULE_ID
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
    // InternalTestLanguage.g:283:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalTestLanguage.g:283:45: (iv_ruleType= ruleType EOF )
            // InternalTestLanguage.g:284:2: iv_ruleType= ruleType EOF
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
    // InternalTestLanguage.g:290:1: ruleType returns [EObject current=null] : ( (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )* ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_arrayDiemensions_2_0=null;
        Token otherlv_3=null;
        EObject this_TypeReference_0 = null;

        EObject this_PrimitiveType_1 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:296:2: ( ( (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )* ) )
            // InternalTestLanguage.g:297:2: ( (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )* )
            {
            // InternalTestLanguage.g:297:2: ( (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )* )
            // InternalTestLanguage.g:298:3: (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )*
            {
            // InternalTestLanguage.g:298:3: (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=22 && LA5_0<=25)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalTestLanguage.g:299:4: this_TypeReference_0= ruleTypeReference
                    {

                    				newCompositeNode(grammarAccess.getTypeAccess().getTypeReferenceParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_8);
                    this_TypeReference_0=ruleTypeReference();

                    state._fsp--;


                    				current = this_TypeReference_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:308:4: this_PrimitiveType_1= rulePrimitiveType
                    {

                    				newCompositeNode(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_8);
                    this_PrimitiveType_1=rulePrimitiveType();

                    state._fsp--;


                    				current = this_PrimitiveType_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalTestLanguage.g:317:3: ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalTestLanguage.g:318:4: ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']'
            	    {
            	    // InternalTestLanguage.g:318:4: ( (lv_arrayDiemensions_2_0= '[' ) )
            	    // InternalTestLanguage.g:319:5: (lv_arrayDiemensions_2_0= '[' )
            	    {
            	    // InternalTestLanguage.g:319:5: (lv_arrayDiemensions_2_0= '[' )
            	    // InternalTestLanguage.g:320:6: lv_arrayDiemensions_2_0= '['
            	    {
            	    lv_arrayDiemensions_2_0=(Token)match(input,15,FOLLOW_9); 

            	    						newLeafNode(lv_arrayDiemensions_2_0, grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getTypeRule());
            	    						}
            	    						addWithLastConsumed(current, "arrayDiemensions", lv_arrayDiemensions_2_0, "[");
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getRightSquareBracketKeyword_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop6;
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


    // $ANTLR start "entryRuleOperation"
    // InternalTestLanguage.g:341:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalTestLanguage.g:341:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalTestLanguage.g:342:2: iv_ruleOperation= ruleOperation EOF
            {
             newCompositeNode(grammarAccess.getOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
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
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // InternalTestLanguage.g:348:1: ruleOperation returns [EObject current=null] : ( () otherlv_1= 'op' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) ) )? otherlv_10= '{' ( (lv_operationCall_11_0= ruleOperationCall ) )? otherlv_12= '}' ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_params_4_0 = null;

        EObject lv_params_6_0 = null;

        EObject lv_returnType_9_0 = null;

        EObject lv_operationCall_11_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:354:2: ( ( () otherlv_1= 'op' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) ) )? otherlv_10= '{' ( (lv_operationCall_11_0= ruleOperationCall ) )? otherlv_12= '}' ) )
            // InternalTestLanguage.g:355:2: ( () otherlv_1= 'op' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) ) )? otherlv_10= '{' ( (lv_operationCall_11_0= ruleOperationCall ) )? otherlv_12= '}' )
            {
            // InternalTestLanguage.g:355:2: ( () otherlv_1= 'op' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) ) )? otherlv_10= '{' ( (lv_operationCall_11_0= ruleOperationCall ) )? otherlv_12= '}' )
            // InternalTestLanguage.g:356:3: () otherlv_1= 'op' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) ) )? otherlv_10= '{' ( (lv_operationCall_11_0= ruleOperationCall ) )? otherlv_12= '}'
            {
            // InternalTestLanguage.g:356:3: ()
            // InternalTestLanguage.g:357:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOperationAccess().getOperationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAccess().getOpKeyword_1());
            		
            // InternalTestLanguage.g:367:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTestLanguage.g:368:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTestLanguage.g:368:4: (lv_name_2_0= RULE_ID )
            // InternalTestLanguage.g:369:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3());
            		
            // InternalTestLanguage.g:389:3: ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalTestLanguage.g:390:4: ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )*
                    {
                    // InternalTestLanguage.g:390:4: ( (lv_params_4_0= ruleParameter ) )
                    // InternalTestLanguage.g:391:5: (lv_params_4_0= ruleParameter )
                    {
                    // InternalTestLanguage.g:391:5: (lv_params_4_0= ruleParameter )
                    // InternalTestLanguage.g:392:6: lv_params_4_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_params_4_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOperationRule());
                    						}
                    						add(
                    							current,
                    							"params",
                    							lv_params_4_0,
                    							"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTestLanguage.g:409:4: (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==19) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalTestLanguage.g:410:5: otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) )
                    	    {
                    	    otherlv_5=(Token)match(input,19,FOLLOW_4); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getOperationAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalTestLanguage.g:414:5: ( (lv_params_6_0= ruleParameter ) )
                    	    // InternalTestLanguage.g:415:6: (lv_params_6_0= ruleParameter )
                    	    {
                    	    // InternalTestLanguage.g:415:6: (lv_params_6_0= ruleParameter )
                    	    // InternalTestLanguage.g:416:7: lv_params_6_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_params_6_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getOperationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"params",
                    	    								lv_params_6_0,
                    	    								"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_7, grammarAccess.getOperationAccess().getRightParenthesisKeyword_5());
            		
            // InternalTestLanguage.g:439:3: (otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalTestLanguage.g:440:4: otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) )
                    {
                    otherlv_8=(Token)match(input,21,FOLLOW_14); 

                    				newLeafNode(otherlv_8, grammarAccess.getOperationAccess().getColonKeyword_6_0());
                    			
                    // InternalTestLanguage.g:444:4: ( (lv_returnType_9_0= ruleType ) )
                    // InternalTestLanguage.g:445:5: (lv_returnType_9_0= ruleType )
                    {
                    // InternalTestLanguage.g:445:5: (lv_returnType_9_0= ruleType )
                    // InternalTestLanguage.g:446:6: lv_returnType_9_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getReturnTypeTypeParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_returnType_9_0=ruleType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOperationRule());
                    						}
                    						set(
                    							current,
                    							"returnType",
                    							lv_returnType_9_0,
                    							"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Type");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,13,FOLLOW_15); 

            			newLeafNode(otherlv_10, grammarAccess.getOperationAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalTestLanguage.g:468:3: ( (lv_operationCall_11_0= ruleOperationCall ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalTestLanguage.g:469:4: (lv_operationCall_11_0= ruleOperationCall )
                    {
                    // InternalTestLanguage.g:469:4: (lv_operationCall_11_0= ruleOperationCall )
                    // InternalTestLanguage.g:470:5: lv_operationCall_11_0= ruleOperationCall
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getOperationCallOperationCallParserRuleCall_8_0());
                    				
                    pushFollow(FOLLOW_16);
                    lv_operationCall_11_0=ruleOperationCall();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperationRule());
                    					}
                    					set(
                    						current,
                    						"operationCall",
                    						lv_operationCall_11_0,
                    						"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.OperationCall");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getOperationAccess().getRightCurlyBracketKeyword_9());
            		

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
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleOperationCall"
    // InternalTestLanguage.g:495:1: entryRuleOperationCall returns [EObject current=null] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final EObject entryRuleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCall = null;


        try {
            // InternalTestLanguage.g:495:54: (iv_ruleOperationCall= ruleOperationCall EOF )
            // InternalTestLanguage.g:496:2: iv_ruleOperationCall= ruleOperationCall EOF
            {
             newCompositeNode(grammarAccess.getOperationCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationCall=ruleOperationCall();

            state._fsp--;

             current =iv_ruleOperationCall; 
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
    // $ANTLR end "entryRuleOperationCall"


    // $ANTLR start "ruleOperationCall"
    // InternalTestLanguage.g:502:1: ruleOperationCall returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleOperationCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_params_2_0=null;
        Token otherlv_3=null;
        Token lv_params_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:508:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )* )? otherlv_5= ')' ) )
            // InternalTestLanguage.g:509:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )* )? otherlv_5= ')' )
            {
            // InternalTestLanguage.g:509:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )* )? otherlv_5= ')' )
            // InternalTestLanguage.g:510:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )* )? otherlv_5= ')'
            {
            // InternalTestLanguage.g:510:3: ( (otherlv_0= RULE_ID ) )
            // InternalTestLanguage.g:511:4: (otherlv_0= RULE_ID )
            {
            // InternalTestLanguage.g:511:4: (otherlv_0= RULE_ID )
            // InternalTestLanguage.g:512:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationCallRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_0, grammarAccess.getOperationCallAccess().getOperationOperationCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalTestLanguage.g:527:3: ( ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_INT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTestLanguage.g:528:4: ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )*
                    {
                    // InternalTestLanguage.g:528:4: ( (lv_params_2_0= RULE_INT ) )
                    // InternalTestLanguage.g:529:5: (lv_params_2_0= RULE_INT )
                    {
                    // InternalTestLanguage.g:529:5: (lv_params_2_0= RULE_INT )
                    // InternalTestLanguage.g:530:6: lv_params_2_0= RULE_INT
                    {
                    lv_params_2_0=(Token)match(input,RULE_INT,FOLLOW_12); 

                    						newLeafNode(lv_params_2_0, grammarAccess.getOperationCallAccess().getParamsINTTerminalRuleCall_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOperationCallRule());
                    						}
                    						addWithLastConsumed(
                    							current,
                    							"params",
                    							lv_params_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    // InternalTestLanguage.g:546:4: (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==19) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalTestLanguage.g:547:5: otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_18); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getOperationCallAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalTestLanguage.g:551:5: ( (lv_params_4_0= RULE_INT ) )
                    	    // InternalTestLanguage.g:552:6: (lv_params_4_0= RULE_INT )
                    	    {
                    	    // InternalTestLanguage.g:552:6: (lv_params_4_0= RULE_INT )
                    	    // InternalTestLanguage.g:553:7: lv_params_4_0= RULE_INT
                    	    {
                    	    lv_params_4_0=(Token)match(input,RULE_INT,FOLLOW_12); 

                    	    							newLeafNode(lv_params_4_0, grammarAccess.getOperationCallAccess().getParamsINTTerminalRuleCall_2_1_1_0());
                    	    						

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getOperationCallRule());
                    	    							}
                    	    							addWithLastConsumed(
                    	    								current,
                    	    								"params",
                    	    								lv_params_4_0,
                    	    								"org.eclipse.xtext.common.Terminals.INT");
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleOperationCall"


    // $ANTLR start "entryRuleParameter"
    // InternalTestLanguage.g:579:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalTestLanguage.g:579:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalTestLanguage.g:580:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalTestLanguage.g:586:1: ruleParameter returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleType ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:592:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleType ) ) ) )
            // InternalTestLanguage.g:593:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleType ) ) )
            {
            // InternalTestLanguage.g:593:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleType ) ) )
            // InternalTestLanguage.g:594:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleType ) )
            {
            // InternalTestLanguage.g:594:3: ()
            // InternalTestLanguage.g:595:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAccess().getParameterAction_0(),
            					current);
            			

            }

            // InternalTestLanguage.g:601:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTestLanguage.g:602:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTestLanguage.g:602:4: (lv_name_1_0= RULE_ID )
            // InternalTestLanguage.g:603:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_name_1_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
            		
            // InternalTestLanguage.g:623:3: ( (lv_type_3_0= ruleType ) )
            // InternalTestLanguage.g:624:4: (lv_type_3_0= ruleType )
            {
            // InternalTestLanguage.g:624:4: (lv_type_3_0= ruleType )
            // InternalTestLanguage.g:625:5: lv_type_3_0= ruleType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_3_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Type");
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTypeReference"
    // InternalTestLanguage.g:646:1: entryRuleTypeReference returns [EObject current=null] : iv_ruleTypeReference= ruleTypeReference EOF ;
    public final EObject entryRuleTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReference = null;


        try {
            // InternalTestLanguage.g:646:54: (iv_ruleTypeReference= ruleTypeReference EOF )
            // InternalTestLanguage.g:647:2: iv_ruleTypeReference= ruleTypeReference EOF
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
    // InternalTestLanguage.g:653:1: ruleTypeReference returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:659:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalTestLanguage.g:660:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalTestLanguage.g:660:2: ( (otherlv_0= RULE_ID ) )
            // InternalTestLanguage.g:661:3: (otherlv_0= RULE_ID )
            {
            // InternalTestLanguage.g:661:3: (otherlv_0= RULE_ID )
            // InternalTestLanguage.g:662:4: otherlv_0= RULE_ID
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
    // InternalTestLanguage.g:676:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalTestLanguage.g:676:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalTestLanguage.g:677:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalTestLanguage.g:683:1: rulePrimitiveType returns [EObject current=null] : ( ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' ) ) ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:689:2: ( ( ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' ) ) ) )
            // InternalTestLanguage.g:690:2: ( ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' ) ) )
            {
            // InternalTestLanguage.g:690:2: ( ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' ) ) )
            // InternalTestLanguage.g:691:3: ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' ) )
            {
            // InternalTestLanguage.g:691:3: ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' ) )
            // InternalTestLanguage.g:692:4: (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' )
            {
            // InternalTestLanguage.g:692:4: (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt13=1;
                }
                break;
            case 23:
                {
                alt13=2;
                }
                break;
            case 24:
                {
                alt13=3;
                }
                break;
            case 25:
                {
                alt13=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalTestLanguage.g:693:5: lv_name_0_1= 'string'
                    {
                    lv_name_0_1=(Token)match(input,22,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:704:5: lv_name_0_2= 'int'
                    {
                    lv_name_0_2=(Token)match(input,23,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getPrimitiveTypeAccess().getNameIntKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalTestLanguage.g:715:5: lv_name_0_3= 'boolean'
                    {
                    lv_name_0_3=(Token)match(input,24,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalTestLanguage.g:726:5: lv_name_0_4= 'void'
                    {
                    lv_name_0_4=(Token)match(input,25,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getPrimitiveTypeAccess().getNameVoidKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

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
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000003C24010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000003C00010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200000L});

}