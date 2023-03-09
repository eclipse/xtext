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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'{'", "'}'", "'type'", "'extends'", "'['", "']'", "'op'", "'('", "','", "')'", "':'", "'string'", "'int'", "'boolean'", "'void'", "'.'"
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
    public static final int T__26=26;
    public static final int T__27=27;
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
    // InternalTestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalTestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:82:2: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // InternalTestLanguage.g:83:2: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // InternalTestLanguage.g:83:2: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTestLanguage.g:84:3: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // InternalTestLanguage.g:84:3: (lv_elements_0_0= ruleAbstractElement )
            	    // InternalTestLanguage.g:85:4: lv_elements_0_0= ruleAbstractElement
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleAbstractElement();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.AbstractElement");
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


    // $ANTLR start "entryRulePackageDeclaration"
    // InternalTestLanguage.g:105:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // InternalTestLanguage.g:105:59: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // InternalTestLanguage.g:106:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
            {
             newCompositeNode(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageDeclaration=rulePackageDeclaration();

            state._fsp--;

             current =iv_rulePackageDeclaration; 
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
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // InternalTestLanguage.g:112:1: rulePackageDeclaration returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:118:2: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' ) )
            // InternalTestLanguage.g:119:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' )
            {
            // InternalTestLanguage.g:119:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' )
            // InternalTestLanguage.g:120:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
            		
            // InternalTestLanguage.g:124:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTestLanguage.g:125:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTestLanguage.g:125:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTestLanguage.g:126:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTestLanguage.g:147:3: ( (lv_elements_3_0= ruleAbstractElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11||LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalTestLanguage.g:148:4: (lv_elements_3_0= ruleAbstractElement )
            	    {
            	    // InternalTestLanguage.g:148:4: (lv_elements_3_0= ruleAbstractElement )
            	    // InternalTestLanguage.g:149:5: lv_elements_3_0= ruleAbstractElement
            	    {

            	    					newCompositeNode(grammarAccess.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_elements_3_0=ruleAbstractElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_3_0,
            	    						"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.AbstractElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleAbstractElement"
    // InternalTestLanguage.g:174:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // InternalTestLanguage.g:174:56: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // InternalTestLanguage.g:175:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
             newCompositeNode(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractElement=ruleAbstractElement();

            state._fsp--;

             current =iv_ruleAbstractElement; 
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
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalTestLanguage.g:181:1: ruleAbstractElement returns [EObject current=null] : (this_PackageDeclaration_0= rulePackageDeclaration | this_TypeDeclaration_1= ruleTypeDeclaration ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDeclaration_0 = null;

        EObject this_TypeDeclaration_1 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:187:2: ( (this_PackageDeclaration_0= rulePackageDeclaration | this_TypeDeclaration_1= ruleTypeDeclaration ) )
            // InternalTestLanguage.g:188:2: (this_PackageDeclaration_0= rulePackageDeclaration | this_TypeDeclaration_1= ruleTypeDeclaration )
            {
            // InternalTestLanguage.g:188:2: (this_PackageDeclaration_0= rulePackageDeclaration | this_TypeDeclaration_1= ruleTypeDeclaration )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalTestLanguage.g:189:3: this_PackageDeclaration_0= rulePackageDeclaration
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getPackageDeclarationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PackageDeclaration_0=rulePackageDeclaration();

                    state._fsp--;


                    			current = this_PackageDeclaration_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:198:3: this_TypeDeclaration_1= ruleTypeDeclaration
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getTypeDeclarationParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TypeDeclaration_1=ruleTypeDeclaration();

                    state._fsp--;


                    			current = this_TypeDeclaration_1;
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
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleTypeDeclaration"
    // InternalTestLanguage.g:210:1: entryRuleTypeDeclaration returns [EObject current=null] : iv_ruleTypeDeclaration= ruleTypeDeclaration EOF ;
    public final EObject entryRuleTypeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDeclaration = null;


        try {
            // InternalTestLanguage.g:210:56: (iv_ruleTypeDeclaration= ruleTypeDeclaration EOF )
            // InternalTestLanguage.g:211:2: iv_ruleTypeDeclaration= ruleTypeDeclaration EOF
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
    // InternalTestLanguage.g:217:1: ruleTypeDeclaration returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}' ) ;
    public final EObject ruleTypeDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_members_5_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:223:2: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}' ) )
            // InternalTestLanguage.g:224:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}' )
            {
            // InternalTestLanguage.g:224:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}' )
            // InternalTestLanguage.g:225:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTypeDeclarationAccess().getTypeKeyword_0());
            		
            // InternalTestLanguage.g:229:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTestLanguage.g:230:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTestLanguage.g:230:4: (lv_name_1_0= RULE_ID )
            // InternalTestLanguage.g:231:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

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

            // InternalTestLanguage.g:247:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalTestLanguage.g:248:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getTypeDeclarationAccess().getExtendsKeyword_2_0());
                    			
                    // InternalTestLanguage.g:252:4: ( ( ruleQualifiedName ) )
                    // InternalTestLanguage.g:253:5: ( ruleQualifiedName )
                    {
                    // InternalTestLanguage.g:253:5: ( ruleQualifiedName )
                    // InternalTestLanguage.g:254:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeDeclarationRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getTypeDeclarationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTestLanguage.g:273:3: ( (lv_members_5_0= ruleMember ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID||LA5_0==18||(LA5_0>=23 && LA5_0<=26)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalTestLanguage.g:274:4: (lv_members_5_0= ruleMember )
            	    {
            	    // InternalTestLanguage.g:274:4: (lv_members_5_0= ruleMember )
            	    // InternalTestLanguage.g:275:5: lv_members_5_0= ruleMember
            	    {

            	    					newCompositeNode(grammarAccess.getTypeDeclarationAccess().getMembersMemberParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_8);
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
            	    break loop5;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

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
    // InternalTestLanguage.g:300:1: entryRuleMember returns [EObject current=null] : iv_ruleMember= ruleMember EOF ;
    public final EObject entryRuleMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMember = null;


        try {
            // InternalTestLanguage.g:300:47: (iv_ruleMember= ruleMember EOF )
            // InternalTestLanguage.g:301:2: iv_ruleMember= ruleMember EOF
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
    // InternalTestLanguage.g:307:1: ruleMember returns [EObject current=null] : (this_Property_0= ruleProperty | this_Operation_1= ruleOperation ) ;
    public final EObject ruleMember() throws RecognitionException {
        EObject current = null;

        EObject this_Property_0 = null;

        EObject this_Operation_1 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:313:2: ( (this_Property_0= ruleProperty | this_Operation_1= ruleOperation ) )
            // InternalTestLanguage.g:314:2: (this_Property_0= ruleProperty | this_Operation_1= ruleOperation )
            {
            // InternalTestLanguage.g:314:2: (this_Property_0= ruleProperty | this_Operation_1= ruleOperation )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||(LA6_0>=23 && LA6_0<=26)) ) {
                alt6=1;
            }
            else if ( (LA6_0==18) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalTestLanguage.g:315:3: this_Property_0= ruleProperty
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
                    // InternalTestLanguage.g:324:3: this_Operation_1= ruleOperation
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
    // InternalTestLanguage.g:336:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalTestLanguage.g:336:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalTestLanguage.g:337:2: iv_ruleProperty= ruleProperty EOF
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
    // InternalTestLanguage.g:343:1: ruleProperty returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:349:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalTestLanguage.g:350:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalTestLanguage.g:350:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalTestLanguage.g:351:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalTestLanguage.g:351:3: ( (lv_type_0_0= ruleType ) )
            // InternalTestLanguage.g:352:4: (lv_type_0_0= ruleType )
            {
            // InternalTestLanguage.g:352:4: (lv_type_0_0= ruleType )
            // InternalTestLanguage.g:353:5: lv_type_0_0= ruleType
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

            // InternalTestLanguage.g:370:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTestLanguage.g:371:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTestLanguage.g:371:4: (lv_name_1_0= RULE_ID )
            // InternalTestLanguage.g:372:5: lv_name_1_0= RULE_ID
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
    // InternalTestLanguage.g:392:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalTestLanguage.g:392:45: (iv_ruleType= ruleType EOF )
            // InternalTestLanguage.g:393:2: iv_ruleType= ruleType EOF
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
    // InternalTestLanguage.g:399:1: ruleType returns [EObject current=null] : ( (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )* ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_arrayDiemensions_2_0=null;
        Token otherlv_3=null;
        EObject this_TypeReference_0 = null;

        EObject this_PrimitiveType_1 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:405:2: ( ( (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )* ) )
            // InternalTestLanguage.g:406:2: ( (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )* )
            {
            // InternalTestLanguage.g:406:2: ( (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )* )
            // InternalTestLanguage.g:407:3: (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType ) ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )*
            {
            // InternalTestLanguage.g:407:3: (this_TypeReference_0= ruleTypeReference | this_PrimitiveType_1= rulePrimitiveType )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=23 && LA7_0<=26)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalTestLanguage.g:408:4: this_TypeReference_0= ruleTypeReference
                    {

                    				newCompositeNode(grammarAccess.getTypeAccess().getTypeReferenceParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_9);
                    this_TypeReference_0=ruleTypeReference();

                    state._fsp--;


                    				current = this_TypeReference_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:417:4: this_PrimitiveType_1= rulePrimitiveType
                    {

                    				newCompositeNode(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_9);
                    this_PrimitiveType_1=rulePrimitiveType();

                    state._fsp--;


                    				current = this_PrimitiveType_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalTestLanguage.g:426:3: ( ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==16) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalTestLanguage.g:427:4: ( (lv_arrayDiemensions_2_0= '[' ) ) otherlv_3= ']'
            	    {
            	    // InternalTestLanguage.g:427:4: ( (lv_arrayDiemensions_2_0= '[' ) )
            	    // InternalTestLanguage.g:428:5: (lv_arrayDiemensions_2_0= '[' )
            	    {
            	    // InternalTestLanguage.g:428:5: (lv_arrayDiemensions_2_0= '[' )
            	    // InternalTestLanguage.g:429:6: lv_arrayDiemensions_2_0= '['
            	    {
            	    lv_arrayDiemensions_2_0=(Token)match(input,16,FOLLOW_10); 

            	    						newLeafNode(lv_arrayDiemensions_2_0, grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getTypeRule());
            	    						}
            	    						addWithLastConsumed(current, "arrayDiemensions", lv_arrayDiemensions_2_0, "[");
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,17,FOLLOW_9); 

            	    				newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getRightSquareBracketKeyword_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // InternalTestLanguage.g:450:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalTestLanguage.g:450:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalTestLanguage.g:451:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalTestLanguage.g:457:1: ruleOperation returns [EObject current=null] : ( () otherlv_1= 'op' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) ) )? otherlv_10= '{' ( (lv_operationCall_11_0= ruleOperationCall ) )? otherlv_12= '}' ) ;
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
            // InternalTestLanguage.g:463:2: ( ( () otherlv_1= 'op' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) ) )? otherlv_10= '{' ( (lv_operationCall_11_0= ruleOperationCall ) )? otherlv_12= '}' ) )
            // InternalTestLanguage.g:464:2: ( () otherlv_1= 'op' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) ) )? otherlv_10= '{' ( (lv_operationCall_11_0= ruleOperationCall ) )? otherlv_12= '}' )
            {
            // InternalTestLanguage.g:464:2: ( () otherlv_1= 'op' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) ) )? otherlv_10= '{' ( (lv_operationCall_11_0= ruleOperationCall ) )? otherlv_12= '}' )
            // InternalTestLanguage.g:465:3: () otherlv_1= 'op' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) ) )? otherlv_10= '{' ( (lv_operationCall_11_0= ruleOperationCall ) )? otherlv_12= '}'
            {
            // InternalTestLanguage.g:465:3: ()
            // InternalTestLanguage.g:466:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOperationAccess().getOperationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAccess().getOpKeyword_1());
            		
            // InternalTestLanguage.g:476:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTestLanguage.g:477:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTestLanguage.g:477:4: (lv_name_2_0= RULE_ID )
            // InternalTestLanguage.g:478:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_11); 

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

            otherlv_3=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3());
            		
            // InternalTestLanguage.g:498:3: ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalTestLanguage.g:499:4: ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )*
                    {
                    // InternalTestLanguage.g:499:4: ( (lv_params_4_0= ruleParameter ) )
                    // InternalTestLanguage.g:500:5: (lv_params_4_0= ruleParameter )
                    {
                    // InternalTestLanguage.g:500:5: (lv_params_4_0= ruleParameter )
                    // InternalTestLanguage.g:501:6: lv_params_4_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_13);
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

                    // InternalTestLanguage.g:518:4: (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==20) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalTestLanguage.g:519:5: otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) )
                    	    {
                    	    otherlv_5=(Token)match(input,20,FOLLOW_4); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getOperationAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalTestLanguage.g:523:5: ( (lv_params_6_0= ruleParameter ) )
                    	    // InternalTestLanguage.g:524:6: (lv_params_6_0= ruleParameter )
                    	    {
                    	    // InternalTestLanguage.g:524:6: (lv_params_6_0= ruleParameter )
                    	    // InternalTestLanguage.g:525:7: lv_params_6_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
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
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,21,FOLLOW_14); 

            			newLeafNode(otherlv_7, grammarAccess.getOperationAccess().getRightParenthesisKeyword_5());
            		
            // InternalTestLanguage.g:548:3: (otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTestLanguage.g:549:4: otherlv_8= ':' ( (lv_returnType_9_0= ruleType ) )
                    {
                    otherlv_8=(Token)match(input,22,FOLLOW_15); 

                    				newLeafNode(otherlv_8, grammarAccess.getOperationAccess().getColonKeyword_6_0());
                    			
                    // InternalTestLanguage.g:553:4: ( (lv_returnType_9_0= ruleType ) )
                    // InternalTestLanguage.g:554:5: (lv_returnType_9_0= ruleType )
                    {
                    // InternalTestLanguage.g:554:5: (lv_returnType_9_0= ruleType )
                    // InternalTestLanguage.g:555:6: lv_returnType_9_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getReturnTypeTypeParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_5);
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

            otherlv_10=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_10, grammarAccess.getOperationAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalTestLanguage.g:577:3: ( (lv_operationCall_11_0= ruleOperationCall ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTestLanguage.g:578:4: (lv_operationCall_11_0= ruleOperationCall )
                    {
                    // InternalTestLanguage.g:578:4: (lv_operationCall_11_0= ruleOperationCall )
                    // InternalTestLanguage.g:579:5: lv_operationCall_11_0= ruleOperationCall
                    {

                    					newCompositeNode(grammarAccess.getOperationAccess().getOperationCallOperationCallParserRuleCall_8_0());
                    				
                    pushFollow(FOLLOW_17);
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

            otherlv_12=(Token)match(input,13,FOLLOW_2); 

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
    // InternalTestLanguage.g:604:1: entryRuleOperationCall returns [EObject current=null] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final EObject entryRuleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCall = null;


        try {
            // InternalTestLanguage.g:604:54: (iv_ruleOperationCall= ruleOperationCall EOF )
            // InternalTestLanguage.g:605:2: iv_ruleOperationCall= ruleOperationCall EOF
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
    // InternalTestLanguage.g:611:1: ruleOperationCall returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalTestLanguage.g:617:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )* )? otherlv_5= ')' ) )
            // InternalTestLanguage.g:618:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )* )? otherlv_5= ')' )
            {
            // InternalTestLanguage.g:618:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )* )? otherlv_5= ')' )
            // InternalTestLanguage.g:619:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )* )? otherlv_5= ')'
            {
            // InternalTestLanguage.g:619:3: ( (otherlv_0= RULE_ID ) )
            // InternalTestLanguage.g:620:4: (otherlv_0= RULE_ID )
            {
            // InternalTestLanguage.g:620:4: (otherlv_0= RULE_ID )
            // InternalTestLanguage.g:621:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationCallRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_0, grammarAccess.getOperationCallAccess().getOperationOperationCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalTestLanguage.g:636:3: ( ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_INT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTestLanguage.g:637:4: ( (lv_params_2_0= RULE_INT ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )*
                    {
                    // InternalTestLanguage.g:637:4: ( (lv_params_2_0= RULE_INT ) )
                    // InternalTestLanguage.g:638:5: (lv_params_2_0= RULE_INT )
                    {
                    // InternalTestLanguage.g:638:5: (lv_params_2_0= RULE_INT )
                    // InternalTestLanguage.g:639:6: lv_params_2_0= RULE_INT
                    {
                    lv_params_2_0=(Token)match(input,RULE_INT,FOLLOW_13); 

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

                    // InternalTestLanguage.g:655:4: (otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==20) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalTestLanguage.g:656:5: otherlv_3= ',' ( (lv_params_4_0= RULE_INT ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_19); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getOperationCallAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalTestLanguage.g:660:5: ( (lv_params_4_0= RULE_INT ) )
                    	    // InternalTestLanguage.g:661:6: (lv_params_4_0= RULE_INT )
                    	    {
                    	    // InternalTestLanguage.g:661:6: (lv_params_4_0= RULE_INT )
                    	    // InternalTestLanguage.g:662:7: lv_params_4_0= RULE_INT
                    	    {
                    	    lv_params_4_0=(Token)match(input,RULE_INT,FOLLOW_13); 

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
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,21,FOLLOW_2); 

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
    // InternalTestLanguage.g:688:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalTestLanguage.g:688:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalTestLanguage.g:689:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalTestLanguage.g:695:1: ruleParameter returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleType ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:701:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleType ) ) ) )
            // InternalTestLanguage.g:702:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleType ) ) )
            {
            // InternalTestLanguage.g:702:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleType ) ) )
            // InternalTestLanguage.g:703:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleType ) )
            {
            // InternalTestLanguage.g:703:3: ()
            // InternalTestLanguage.g:704:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAccess().getParameterAction_0(),
            					current);
            			

            }

            // InternalTestLanguage.g:710:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTestLanguage.g:711:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTestLanguage.g:711:4: (lv_name_1_0= RULE_ID )
            // InternalTestLanguage.g:712:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); 

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

            otherlv_2=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
            		
            // InternalTestLanguage.g:732:3: ( (lv_type_3_0= ruleType ) )
            // InternalTestLanguage.g:733:4: (lv_type_3_0= ruleType )
            {
            // InternalTestLanguage.g:733:4: (lv_type_3_0= ruleType )
            // InternalTestLanguage.g:734:5: lv_type_3_0= ruleType
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
    // InternalTestLanguage.g:755:1: entryRuleTypeReference returns [EObject current=null] : iv_ruleTypeReference= ruleTypeReference EOF ;
    public final EObject entryRuleTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReference = null;


        try {
            // InternalTestLanguage.g:755:54: (iv_ruleTypeReference= ruleTypeReference EOF )
            // InternalTestLanguage.g:756:2: iv_ruleTypeReference= ruleTypeReference EOF
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
    // InternalTestLanguage.g:762:1: ruleTypeReference returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleTypeReference() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalTestLanguage.g:768:2: ( ( ( ruleQualifiedName ) ) )
            // InternalTestLanguage.g:769:2: ( ( ruleQualifiedName ) )
            {
            // InternalTestLanguage.g:769:2: ( ( ruleQualifiedName ) )
            // InternalTestLanguage.g:770:3: ( ruleQualifiedName )
            {
            // InternalTestLanguage.g:770:3: ( ruleQualifiedName )
            // InternalTestLanguage.g:771:4: ruleQualifiedName
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getTypeReferenceRule());
            				}
            			

            				newCompositeNode(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleTypeReference"


    // $ANTLR start "entryRulePrimitiveType"
    // InternalTestLanguage.g:788:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalTestLanguage.g:788:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalTestLanguage.g:789:2: iv_rulePrimitiveType= rulePrimitiveType EOF
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
    // InternalTestLanguage.g:795:1: rulePrimitiveType returns [EObject current=null] : ( ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' ) ) ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:801:2: ( ( ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' ) ) ) )
            // InternalTestLanguage.g:802:2: ( ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' ) ) )
            {
            // InternalTestLanguage.g:802:2: ( ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' ) ) )
            // InternalTestLanguage.g:803:3: ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' ) )
            {
            // InternalTestLanguage.g:803:3: ( (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' ) )
            // InternalTestLanguage.g:804:4: (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' )
            {
            // InternalTestLanguage.g:804:4: (lv_name_0_1= 'string' | lv_name_0_2= 'int' | lv_name_0_3= 'boolean' | lv_name_0_4= 'void' )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt15=1;
                }
                break;
            case 24:
                {
                alt15=2;
                }
                break;
            case 25:
                {
                alt15=3;
                }
                break;
            case 26:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalTestLanguage.g:805:5: lv_name_0_1= 'string'
                    {
                    lv_name_0_1=(Token)match(input,23,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:816:5: lv_name_0_2= 'int'
                    {
                    lv_name_0_2=(Token)match(input,24,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getPrimitiveTypeAccess().getNameIntKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalTestLanguage.g:827:5: lv_name_0_3= 'boolean'
                    {
                    lv_name_0_3=(Token)match(input,25,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalTestLanguage.g:838:5: lv_name_0_4= 'void'
                    {
                    lv_name_0_4=(Token)match(input,26,FOLLOW_2); 

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


    // $ANTLR start "entryRuleQualifiedName"
    // InternalTestLanguage.g:854:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalTestLanguage.g:854:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalTestLanguage.g:855:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalTestLanguage.g:861:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:867:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTestLanguage.g:868:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTestLanguage.g:868:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTestLanguage.g:869:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalTestLanguage.g:876:3: (kw= '.' this_ID_2= RULE_ID )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==27) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalTestLanguage.g:877:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,27,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_21); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006800L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000007842010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000401000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000007800010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000002L});

}