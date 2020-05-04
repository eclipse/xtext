package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug360834TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug360834TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'alternative'", "'unordered'", "'package'", "';'", "'.'", "'class'", "'{'", "'}'", "'final'", "'abstract'", "'extern'", "'var'", "'public'", "'protected'", "'private'"
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


        public InternalBug360834TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug360834TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug360834TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug360834TestLanguage.g"; }



     	private Bug360834TestLanguageGrammarAccess grammarAccess;

        public InternalBug360834TestLanguageParser(TokenStream input, Bug360834TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected Bug360834TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalBug360834TestLanguage.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug360834TestLanguage.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalBug360834TestLanguage.g:66:2: iv_ruleModel= ruleModel EOF
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
    // InternalBug360834TestLanguage.g:72:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'alternative' ( (lv_element_1_0= ruleAlternative ) ) ) | (otherlv_2= 'unordered' ( (lv_element_3_0= ruleUnordered ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_element_1_0 = null;

        EObject lv_element_3_0 = null;



        	enterRule();

        try {
            // InternalBug360834TestLanguage.g:78:2: ( ( (otherlv_0= 'alternative' ( (lv_element_1_0= ruleAlternative ) ) ) | (otherlv_2= 'unordered' ( (lv_element_3_0= ruleUnordered ) ) ) ) )
            // InternalBug360834TestLanguage.g:79:2: ( (otherlv_0= 'alternative' ( (lv_element_1_0= ruleAlternative ) ) ) | (otherlv_2= 'unordered' ( (lv_element_3_0= ruleUnordered ) ) ) )
            {
            // InternalBug360834TestLanguage.g:79:2: ( (otherlv_0= 'alternative' ( (lv_element_1_0= ruleAlternative ) ) ) | (otherlv_2= 'unordered' ( (lv_element_3_0= ruleUnordered ) ) ) )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalBug360834TestLanguage.g:80:3: (otherlv_0= 'alternative' ( (lv_element_1_0= ruleAlternative ) ) )
                    {
                    // InternalBug360834TestLanguage.g:80:3: (otherlv_0= 'alternative' ( (lv_element_1_0= ruleAlternative ) ) )
                    // InternalBug360834TestLanguage.g:81:4: otherlv_0= 'alternative' ( (lv_element_1_0= ruleAlternative ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getModelAccess().getAlternativeKeyword_0_0());
                    			
                    // InternalBug360834TestLanguage.g:85:4: ( (lv_element_1_0= ruleAlternative ) )
                    // InternalBug360834TestLanguage.g:86:5: (lv_element_1_0= ruleAlternative )
                    {
                    // InternalBug360834TestLanguage.g:86:5: (lv_element_1_0= ruleAlternative )
                    // InternalBug360834TestLanguage.g:87:6: lv_element_1_0= ruleAlternative
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getElementAlternativeParserRuleCall_0_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_1_0=ruleAlternative();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"element",
                    							lv_element_1_0,
                    							"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.Alternative");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug360834TestLanguage.g:106:3: (otherlv_2= 'unordered' ( (lv_element_3_0= ruleUnordered ) ) )
                    {
                    // InternalBug360834TestLanguage.g:106:3: (otherlv_2= 'unordered' ( (lv_element_3_0= ruleUnordered ) ) )
                    // InternalBug360834TestLanguage.g:107:4: otherlv_2= 'unordered' ( (lv_element_3_0= ruleUnordered ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getUnorderedKeyword_1_0());
                    			
                    // InternalBug360834TestLanguage.g:111:4: ( (lv_element_3_0= ruleUnordered ) )
                    // InternalBug360834TestLanguage.g:112:5: (lv_element_3_0= ruleUnordered )
                    {
                    // InternalBug360834TestLanguage.g:112:5: (lv_element_3_0= ruleUnordered )
                    // InternalBug360834TestLanguage.g:113:6: lv_element_3_0= ruleUnordered
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getElementUnorderedParserRuleCall_1_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_element_3_0=ruleUnordered();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"element",
                    							lv_element_3_0,
                    							"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.Unordered");
                    						afterParserOrEnumRuleCall();
                    					

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


    // $ANTLR start "entryRuleAlternative"
    // InternalBug360834TestLanguage.g:135:1: entryRuleAlternative returns [EObject current=null] : iv_ruleAlternative= ruleAlternative EOF ;
    public final EObject entryRuleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternative = null;


        try {
            // InternalBug360834TestLanguage.g:135:52: (iv_ruleAlternative= ruleAlternative EOF )
            // InternalBug360834TestLanguage.g:136:2: iv_ruleAlternative= ruleAlternative EOF
            {
             newCompositeNode(grammarAccess.getAlternativeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAlternative=ruleAlternative();

            state._fsp--;

             current =iv_ruleAlternative; 
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
    // $ANTLR end "entryRuleAlternative"


    // $ANTLR start "ruleAlternative"
    // InternalBug360834TestLanguage.g:142:1: ruleAlternative returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= ';' ( (lv_rootDeclaration_3_0= ruleRecursiveClassDeclaration ) ) ) ;
    public final EObject ruleAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_rootDeclaration_3_0 = null;



        	enterRule();

        try {
            // InternalBug360834TestLanguage.g:148:2: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= ';' ( (lv_rootDeclaration_3_0= ruleRecursiveClassDeclaration ) ) ) )
            // InternalBug360834TestLanguage.g:149:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= ';' ( (lv_rootDeclaration_3_0= ruleRecursiveClassDeclaration ) ) )
            {
            // InternalBug360834TestLanguage.g:149:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= ';' ( (lv_rootDeclaration_3_0= ruleRecursiveClassDeclaration ) ) )
            // InternalBug360834TestLanguage.g:150:3: otherlv_0= 'package' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= ';' ( (lv_rootDeclaration_3_0= ruleRecursiveClassDeclaration ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getAlternativeAccess().getPackageKeyword_0());
            		
            // InternalBug360834TestLanguage.g:154:3: ( (lv_name_1_0= ruleFQN ) )
            // InternalBug360834TestLanguage.g:155:4: (lv_name_1_0= ruleFQN )
            {
            // InternalBug360834TestLanguage.g:155:4: (lv_name_1_0= ruleFQN )
            // InternalBug360834TestLanguage.g:156:5: lv_name_1_0= ruleFQN
            {

            					newCompositeNode(grammarAccess.getAlternativeAccess().getNameFQNParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_5);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAlternativeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.FQN");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getAlternativeAccess().getSemicolonKeyword_2());
            		
            // InternalBug360834TestLanguage.g:177:3: ( (lv_rootDeclaration_3_0= ruleRecursiveClassDeclaration ) )
            // InternalBug360834TestLanguage.g:178:4: (lv_rootDeclaration_3_0= ruleRecursiveClassDeclaration )
            {
            // InternalBug360834TestLanguage.g:178:4: (lv_rootDeclaration_3_0= ruleRecursiveClassDeclaration )
            // InternalBug360834TestLanguage.g:179:5: lv_rootDeclaration_3_0= ruleRecursiveClassDeclaration
            {

            					newCompositeNode(grammarAccess.getAlternativeAccess().getRootDeclarationRecursiveClassDeclarationParserRuleCall_3_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_rootDeclaration_3_0=ruleRecursiveClassDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAlternativeRule());
            					}
            					set(
            						current,
            						"rootDeclaration",
            						lv_rootDeclaration_3_0,
            						"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.RecursiveClassDeclaration");
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
    // $ANTLR end "ruleAlternative"


    // $ANTLR start "entryRuleFQN"
    // InternalBug360834TestLanguage.g:200:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalBug360834TestLanguage.g:200:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalBug360834TestLanguage.g:201:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalBug360834TestLanguage.g:207:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalBug360834TestLanguage.g:213:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalBug360834TestLanguage.g:214:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalBug360834TestLanguage.g:214:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalBug360834TestLanguage.g:215:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalBug360834TestLanguage.g:222:3: (kw= '.' this_ID_2= RULE_ID )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBug360834TestLanguage.g:223:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,15,FollowSets000.FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleRecursiveClassDeclaration"
    // InternalBug360834TestLanguage.g:240:1: entryRuleRecursiveClassDeclaration returns [EObject current=null] : iv_ruleRecursiveClassDeclaration= ruleRecursiveClassDeclaration EOF ;
    public final EObject entryRuleRecursiveClassDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecursiveClassDeclaration = null;


        try {
            // InternalBug360834TestLanguage.g:240:66: (iv_ruleRecursiveClassDeclaration= ruleRecursiveClassDeclaration EOF )
            // InternalBug360834TestLanguage.g:241:2: iv_ruleRecursiveClassDeclaration= ruleRecursiveClassDeclaration EOF
            {
             newCompositeNode(grammarAccess.getRecursiveClassDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRecursiveClassDeclaration=ruleRecursiveClassDeclaration();

            state._fsp--;

             current =iv_ruleRecursiveClassDeclaration; 
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
    // $ANTLR end "entryRuleRecursiveClassDeclaration"


    // $ANTLR start "ruleRecursiveClassDeclaration"
    // InternalBug360834TestLanguage.g:247:1: ruleRecursiveClassDeclaration returns [EObject current=null] : ( ( (lv_modifiers_0_0= ruleAlternativeClassModifiers ) ) otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_members_4_0= ruleRecursiveClassDeclaration ) )* otherlv_5= '}' ) ;
    public final EObject ruleRecursiveClassDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_modifiers_0_0 = null;

        EObject lv_members_4_0 = null;



        	enterRule();

        try {
            // InternalBug360834TestLanguage.g:253:2: ( ( ( (lv_modifiers_0_0= ruleAlternativeClassModifiers ) ) otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_members_4_0= ruleRecursiveClassDeclaration ) )* otherlv_5= '}' ) )
            // InternalBug360834TestLanguage.g:254:2: ( ( (lv_modifiers_0_0= ruleAlternativeClassModifiers ) ) otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_members_4_0= ruleRecursiveClassDeclaration ) )* otherlv_5= '}' )
            {
            // InternalBug360834TestLanguage.g:254:2: ( ( (lv_modifiers_0_0= ruleAlternativeClassModifiers ) ) otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_members_4_0= ruleRecursiveClassDeclaration ) )* otherlv_5= '}' )
            // InternalBug360834TestLanguage.g:255:3: ( (lv_modifiers_0_0= ruleAlternativeClassModifiers ) ) otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_members_4_0= ruleRecursiveClassDeclaration ) )* otherlv_5= '}'
            {
            // InternalBug360834TestLanguage.g:255:3: ( (lv_modifiers_0_0= ruleAlternativeClassModifiers ) )
            // InternalBug360834TestLanguage.g:256:4: (lv_modifiers_0_0= ruleAlternativeClassModifiers )
            {
            // InternalBug360834TestLanguage.g:256:4: (lv_modifiers_0_0= ruleAlternativeClassModifiers )
            // InternalBug360834TestLanguage.g:257:5: lv_modifiers_0_0= ruleAlternativeClassModifiers
            {

            					newCompositeNode(grammarAccess.getRecursiveClassDeclarationAccess().getModifiersAlternativeClassModifiersParserRuleCall_0_0());
            				
            pushFollow(FollowSets000.FOLLOW_8);
            lv_modifiers_0_0=ruleAlternativeClassModifiers();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRecursiveClassDeclarationRule());
            					}
            					set(
            						current,
            						"modifiers",
            						lv_modifiers_0_0,
            						"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.AlternativeClassModifiers");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getRecursiveClassDeclarationAccess().getClassKeyword_1());
            		
            // InternalBug360834TestLanguage.g:278:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug360834TestLanguage.g:279:4: (lv_name_2_0= RULE_ID )
            {
            // InternalBug360834TestLanguage.g:279:4: (lv_name_2_0= RULE_ID )
            // InternalBug360834TestLanguage.g:280:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					newLeafNode(lv_name_2_0, grammarAccess.getRecursiveClassDeclarationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRecursiveClassDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getRecursiveClassDeclarationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalBug360834TestLanguage.g:300:3: ( (lv_members_4_0= ruleRecursiveClassDeclaration ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==EOF||LA3_0==16||(LA3_0>=19 && LA3_0<=21)||(LA3_0>=23 && LA3_0<=25)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug360834TestLanguage.g:301:4: (lv_members_4_0= ruleRecursiveClassDeclaration )
            	    {
            	    // InternalBug360834TestLanguage.g:301:4: (lv_members_4_0= ruleRecursiveClassDeclaration )
            	    // InternalBug360834TestLanguage.g:302:5: lv_members_4_0= ruleRecursiveClassDeclaration
            	    {

            	    					newCompositeNode(grammarAccess.getRecursiveClassDeclarationAccess().getMembersRecursiveClassDeclarationParserRuleCall_4_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    lv_members_4_0=ruleRecursiveClassDeclaration();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRecursiveClassDeclarationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"members",
            	    						lv_members_4_0,
            	    						"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.RecursiveClassDeclaration");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getRecursiveClassDeclarationAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleRecursiveClassDeclaration"


    // $ANTLR start "entryRuleAlternativeClassModifiers"
    // InternalBug360834TestLanguage.g:327:1: entryRuleAlternativeClassModifiers returns [EObject current=null] : iv_ruleAlternativeClassModifiers= ruleAlternativeClassModifiers EOF ;
    public final EObject entryRuleAlternativeClassModifiers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeClassModifiers = null;


        try {
            // InternalBug360834TestLanguage.g:327:66: (iv_ruleAlternativeClassModifiers= ruleAlternativeClassModifiers EOF )
            // InternalBug360834TestLanguage.g:328:2: iv_ruleAlternativeClassModifiers= ruleAlternativeClassModifiers EOF
            {
             newCompositeNode(grammarAccess.getAlternativeClassModifiersRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAlternativeClassModifiers=ruleAlternativeClassModifiers();

            state._fsp--;

             current =iv_ruleAlternativeClassModifiers; 
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
    // $ANTLR end "entryRuleAlternativeClassModifiers"


    // $ANTLR start "ruleAlternativeClassModifiers"
    // InternalBug360834TestLanguage.g:334:1: ruleAlternativeClassModifiers returns [EObject current=null] : ( () ( ( (lv_final_1_0= 'final' ) ) | ( (lv_abstract_2_0= 'abstract' ) ) | ( (lv_extern_3_0= 'extern' ) ) | ( (lv_visibility_4_0= ruleVisibility ) )? ) ) ;
    public final EObject ruleAlternativeClassModifiers() throws RecognitionException {
        EObject current = null;

        Token lv_final_1_0=null;
        Token lv_abstract_2_0=null;
        Token lv_extern_3_0=null;
        Enumerator lv_visibility_4_0 = null;



        	enterRule();

        try {
            // InternalBug360834TestLanguage.g:340:2: ( ( () ( ( (lv_final_1_0= 'final' ) ) | ( (lv_abstract_2_0= 'abstract' ) ) | ( (lv_extern_3_0= 'extern' ) ) | ( (lv_visibility_4_0= ruleVisibility ) )? ) ) )
            // InternalBug360834TestLanguage.g:341:2: ( () ( ( (lv_final_1_0= 'final' ) ) | ( (lv_abstract_2_0= 'abstract' ) ) | ( (lv_extern_3_0= 'extern' ) ) | ( (lv_visibility_4_0= ruleVisibility ) )? ) )
            {
            // InternalBug360834TestLanguage.g:341:2: ( () ( ( (lv_final_1_0= 'final' ) ) | ( (lv_abstract_2_0= 'abstract' ) ) | ( (lv_extern_3_0= 'extern' ) ) | ( (lv_visibility_4_0= ruleVisibility ) )? ) )
            // InternalBug360834TestLanguage.g:342:3: () ( ( (lv_final_1_0= 'final' ) ) | ( (lv_abstract_2_0= 'abstract' ) ) | ( (lv_extern_3_0= 'extern' ) ) | ( (lv_visibility_4_0= ruleVisibility ) )? )
            {
            // InternalBug360834TestLanguage.g:342:3: ()
            // InternalBug360834TestLanguage.g:343:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAlternativeClassModifiersAccess().getModifiersAction_0(),
            					current);
            			

            }

            // InternalBug360834TestLanguage.g:349:3: ( ( (lv_final_1_0= 'final' ) ) | ( (lv_abstract_2_0= 'abstract' ) ) | ( (lv_extern_3_0= 'extern' ) ) | ( (lv_visibility_4_0= ruleVisibility ) )? )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt5=1;
                }
                break;
            case 20:
                {
                alt5=2;
                }
                break;
            case 21:
                {
                alt5=3;
                }
                break;
            case EOF:
            case 16:
            case 23:
            case 24:
            case 25:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalBug360834TestLanguage.g:350:4: ( (lv_final_1_0= 'final' ) )
                    {
                    // InternalBug360834TestLanguage.g:350:4: ( (lv_final_1_0= 'final' ) )
                    // InternalBug360834TestLanguage.g:351:5: (lv_final_1_0= 'final' )
                    {
                    // InternalBug360834TestLanguage.g:351:5: (lv_final_1_0= 'final' )
                    // InternalBug360834TestLanguage.g:352:6: lv_final_1_0= 'final'
                    {
                    lv_final_1_0=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_final_1_0, grammarAccess.getAlternativeClassModifiersAccess().getFinalFinalKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAlternativeClassModifiersRule());
                    						}
                    						setWithLastConsumed(current, "final", lv_final_1_0 != null, "final");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug360834TestLanguage.g:365:4: ( (lv_abstract_2_0= 'abstract' ) )
                    {
                    // InternalBug360834TestLanguage.g:365:4: ( (lv_abstract_2_0= 'abstract' ) )
                    // InternalBug360834TestLanguage.g:366:5: (lv_abstract_2_0= 'abstract' )
                    {
                    // InternalBug360834TestLanguage.g:366:5: (lv_abstract_2_0= 'abstract' )
                    // InternalBug360834TestLanguage.g:367:6: lv_abstract_2_0= 'abstract'
                    {
                    lv_abstract_2_0=(Token)match(input,20,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_abstract_2_0, grammarAccess.getAlternativeClassModifiersAccess().getAbstractAbstractKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAlternativeClassModifiersRule());
                    						}
                    						setWithLastConsumed(current, "abstract", lv_abstract_2_0 != null, "abstract");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBug360834TestLanguage.g:380:4: ( (lv_extern_3_0= 'extern' ) )
                    {
                    // InternalBug360834TestLanguage.g:380:4: ( (lv_extern_3_0= 'extern' ) )
                    // InternalBug360834TestLanguage.g:381:5: (lv_extern_3_0= 'extern' )
                    {
                    // InternalBug360834TestLanguage.g:381:5: (lv_extern_3_0= 'extern' )
                    // InternalBug360834TestLanguage.g:382:6: lv_extern_3_0= 'extern'
                    {
                    lv_extern_3_0=(Token)match(input,21,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_extern_3_0, grammarAccess.getAlternativeClassModifiersAccess().getExternExternKeyword_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAlternativeClassModifiersRule());
                    						}
                    						setWithLastConsumed(current, "extern", lv_extern_3_0 != null, "extern");
                    					

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBug360834TestLanguage.g:395:4: ( (lv_visibility_4_0= ruleVisibility ) )?
                    {
                    // InternalBug360834TestLanguage.g:395:4: ( (lv_visibility_4_0= ruleVisibility ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=23 && LA4_0<=25)) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalBug360834TestLanguage.g:396:5: (lv_visibility_4_0= ruleVisibility )
                            {
                            // InternalBug360834TestLanguage.g:396:5: (lv_visibility_4_0= ruleVisibility )
                            // InternalBug360834TestLanguage.g:397:6: lv_visibility_4_0= ruleVisibility
                            {

                            						newCompositeNode(grammarAccess.getAlternativeClassModifiersAccess().getVisibilityVisibilityEnumRuleCall_1_3_0());
                            					
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_visibility_4_0=ruleVisibility();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getAlternativeClassModifiersRule());
                            						}
                            						set(
                            							current,
                            							"visibility",
                            							lv_visibility_4_0,
                            							"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.Visibility");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

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
    // $ANTLR end "ruleAlternativeClassModifiers"


    // $ANTLR start "entryRuleUnordered"
    // InternalBug360834TestLanguage.g:419:1: entryRuleUnordered returns [EObject current=null] : iv_ruleUnordered= ruleUnordered EOF ;
    public final EObject entryRuleUnordered() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnordered = null;


        try {
            // InternalBug360834TestLanguage.g:419:50: (iv_ruleUnordered= ruleUnordered EOF )
            // InternalBug360834TestLanguage.g:420:2: iv_ruleUnordered= ruleUnordered EOF
            {
             newCompositeNode(grammarAccess.getUnorderedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnordered=ruleUnordered();

            state._fsp--;

             current =iv_ruleUnordered; 
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
    // $ANTLR end "entryRuleUnordered"


    // $ANTLR start "ruleUnordered"
    // InternalBug360834TestLanguage.g:426:1: ruleUnordered returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= ';' ( (lv_rootDeclaration_3_0= ruleSimpleClassDeclaration ) ) ) ;
    public final EObject ruleUnordered() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_rootDeclaration_3_0 = null;



        	enterRule();

        try {
            // InternalBug360834TestLanguage.g:432:2: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= ';' ( (lv_rootDeclaration_3_0= ruleSimpleClassDeclaration ) ) ) )
            // InternalBug360834TestLanguage.g:433:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= ';' ( (lv_rootDeclaration_3_0= ruleSimpleClassDeclaration ) ) )
            {
            // InternalBug360834TestLanguage.g:433:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= ';' ( (lv_rootDeclaration_3_0= ruleSimpleClassDeclaration ) ) )
            // InternalBug360834TestLanguage.g:434:3: otherlv_0= 'package' ( (lv_name_1_0= ruleFQN ) ) otherlv_2= ';' ( (lv_rootDeclaration_3_0= ruleSimpleClassDeclaration ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getUnorderedAccess().getPackageKeyword_0());
            		
            // InternalBug360834TestLanguage.g:438:3: ( (lv_name_1_0= ruleFQN ) )
            // InternalBug360834TestLanguage.g:439:4: (lv_name_1_0= ruleFQN )
            {
            // InternalBug360834TestLanguage.g:439:4: (lv_name_1_0= ruleFQN )
            // InternalBug360834TestLanguage.g:440:5: lv_name_1_0= ruleFQN
            {

            					newCompositeNode(grammarAccess.getUnorderedAccess().getNameFQNParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_5);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnorderedRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.FQN");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getUnorderedAccess().getSemicolonKeyword_2());
            		
            // InternalBug360834TestLanguage.g:461:3: ( (lv_rootDeclaration_3_0= ruleSimpleClassDeclaration ) )
            // InternalBug360834TestLanguage.g:462:4: (lv_rootDeclaration_3_0= ruleSimpleClassDeclaration )
            {
            // InternalBug360834TestLanguage.g:462:4: (lv_rootDeclaration_3_0= ruleSimpleClassDeclaration )
            // InternalBug360834TestLanguage.g:463:5: lv_rootDeclaration_3_0= ruleSimpleClassDeclaration
            {

            					newCompositeNode(grammarAccess.getUnorderedAccess().getRootDeclarationSimpleClassDeclarationParserRuleCall_3_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_rootDeclaration_3_0=ruleSimpleClassDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnorderedRule());
            					}
            					set(
            						current,
            						"rootDeclaration",
            						lv_rootDeclaration_3_0,
            						"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.SimpleClassDeclaration");
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
    // $ANTLR end "ruleUnordered"


    // $ANTLR start "entryRuleSimpleClassDeclaration"
    // InternalBug360834TestLanguage.g:484:1: entryRuleSimpleClassDeclaration returns [EObject current=null] : iv_ruleSimpleClassDeclaration= ruleSimpleClassDeclaration EOF ;
    public final EObject entryRuleSimpleClassDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleClassDeclaration = null;


        try {
            // InternalBug360834TestLanguage.g:484:63: (iv_ruleSimpleClassDeclaration= ruleSimpleClassDeclaration EOF )
            // InternalBug360834TestLanguage.g:485:2: iv_ruleSimpleClassDeclaration= ruleSimpleClassDeclaration EOF
            {
             newCompositeNode(grammarAccess.getSimpleClassDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleClassDeclaration=ruleSimpleClassDeclaration();

            state._fsp--;

             current =iv_ruleSimpleClassDeclaration; 
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
    // $ANTLR end "entryRuleSimpleClassDeclaration"


    // $ANTLR start "ruleSimpleClassDeclaration"
    // InternalBug360834TestLanguage.g:491:1: ruleSimpleClassDeclaration returns [EObject current=null] : ( ( (lv_modifiers_0_0= ruleUnorderedModifiers ) ) otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_members_4_0= ruleClassMember ) )* otherlv_5= '}' ) ;
    public final EObject ruleSimpleClassDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_modifiers_0_0 = null;

        EObject lv_members_4_0 = null;



        	enterRule();

        try {
            // InternalBug360834TestLanguage.g:497:2: ( ( ( (lv_modifiers_0_0= ruleUnorderedModifiers ) ) otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_members_4_0= ruleClassMember ) )* otherlv_5= '}' ) )
            // InternalBug360834TestLanguage.g:498:2: ( ( (lv_modifiers_0_0= ruleUnorderedModifiers ) ) otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_members_4_0= ruleClassMember ) )* otherlv_5= '}' )
            {
            // InternalBug360834TestLanguage.g:498:2: ( ( (lv_modifiers_0_0= ruleUnorderedModifiers ) ) otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_members_4_0= ruleClassMember ) )* otherlv_5= '}' )
            // InternalBug360834TestLanguage.g:499:3: ( (lv_modifiers_0_0= ruleUnorderedModifiers ) ) otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_members_4_0= ruleClassMember ) )* otherlv_5= '}'
            {
            // InternalBug360834TestLanguage.g:499:3: ( (lv_modifiers_0_0= ruleUnorderedModifiers ) )
            // InternalBug360834TestLanguage.g:500:4: (lv_modifiers_0_0= ruleUnorderedModifiers )
            {
            // InternalBug360834TestLanguage.g:500:4: (lv_modifiers_0_0= ruleUnorderedModifiers )
            // InternalBug360834TestLanguage.g:501:5: lv_modifiers_0_0= ruleUnorderedModifiers
            {

            					newCompositeNode(grammarAccess.getSimpleClassDeclarationAccess().getModifiersUnorderedModifiersParserRuleCall_0_0());
            				
            pushFollow(FollowSets000.FOLLOW_8);
            lv_modifiers_0_0=ruleUnorderedModifiers();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleClassDeclarationRule());
            					}
            					set(
            						current,
            						"modifiers",
            						lv_modifiers_0_0,
            						"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.UnorderedModifiers");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getSimpleClassDeclarationAccess().getClassKeyword_1());
            		
            // InternalBug360834TestLanguage.g:522:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug360834TestLanguage.g:523:4: (lv_name_2_0= RULE_ID )
            {
            // InternalBug360834TestLanguage.g:523:4: (lv_name_2_0= RULE_ID )
            // InternalBug360834TestLanguage.g:524:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					newLeafNode(lv_name_2_0, grammarAccess.getSimpleClassDeclarationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSimpleClassDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getSimpleClassDeclarationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalBug360834TestLanguage.g:544:3: ( (lv_members_4_0= ruleClassMember ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=19 && LA6_0<=25)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBug360834TestLanguage.g:545:4: (lv_members_4_0= ruleClassMember )
            	    {
            	    // InternalBug360834TestLanguage.g:545:4: (lv_members_4_0= ruleClassMember )
            	    // InternalBug360834TestLanguage.g:546:5: lv_members_4_0= ruleClassMember
            	    {

            	    					newCompositeNode(grammarAccess.getSimpleClassDeclarationAccess().getMembersClassMemberParserRuleCall_4_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_members_4_0=ruleClassMember();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSimpleClassDeclarationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"members",
            	    						lv_members_4_0,
            	    						"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.ClassMember");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getSimpleClassDeclarationAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleSimpleClassDeclaration"


    // $ANTLR start "entryRuleClassMember"
    // InternalBug360834TestLanguage.g:571:1: entryRuleClassMember returns [EObject current=null] : iv_ruleClassMember= ruleClassMember EOF ;
    public final EObject entryRuleClassMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassMember = null;


        try {
            // InternalBug360834TestLanguage.g:571:52: (iv_ruleClassMember= ruleClassMember EOF )
            // InternalBug360834TestLanguage.g:572:2: iv_ruleClassMember= ruleClassMember EOF
            {
             newCompositeNode(grammarAccess.getClassMemberRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClassMember=ruleClassMember();

            state._fsp--;

             current =iv_ruleClassMember; 
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
    // $ANTLR end "entryRuleClassMember"


    // $ANTLR start "ruleClassMember"
    // InternalBug360834TestLanguage.g:578:1: ruleClassMember returns [EObject current=null] : ( ( (lv_modifiers_0_0= ruleUnorderedModifiers ) ) otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleClassMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_modifiers_0_0 = null;



        	enterRule();

        try {
            // InternalBug360834TestLanguage.g:584:2: ( ( ( (lv_modifiers_0_0= ruleUnorderedModifiers ) ) otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalBug360834TestLanguage.g:585:2: ( ( (lv_modifiers_0_0= ruleUnorderedModifiers ) ) otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalBug360834TestLanguage.g:585:2: ( ( (lv_modifiers_0_0= ruleUnorderedModifiers ) ) otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalBug360834TestLanguage.g:586:3: ( (lv_modifiers_0_0= ruleUnorderedModifiers ) ) otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            // InternalBug360834TestLanguage.g:586:3: ( (lv_modifiers_0_0= ruleUnorderedModifiers ) )
            // InternalBug360834TestLanguage.g:587:4: (lv_modifiers_0_0= ruleUnorderedModifiers )
            {
            // InternalBug360834TestLanguage.g:587:4: (lv_modifiers_0_0= ruleUnorderedModifiers )
            // InternalBug360834TestLanguage.g:588:5: lv_modifiers_0_0= ruleUnorderedModifiers
            {

            					newCompositeNode(grammarAccess.getClassMemberAccess().getModifiersUnorderedModifiersParserRuleCall_0_0());
            				
            pushFollow(FollowSets000.FOLLOW_12);
            lv_modifiers_0_0=ruleUnorderedModifiers();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClassMemberRule());
            					}
            					set(
            						current,
            						"modifiers",
            						lv_modifiers_0_0,
            						"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.UnorderedModifiers");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getClassMemberAccess().getVarKeyword_1());
            		
            // InternalBug360834TestLanguage.g:609:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug360834TestLanguage.g:610:4: (lv_name_2_0= RULE_ID )
            {
            // InternalBug360834TestLanguage.g:610:4: (lv_name_2_0= RULE_ID )
            // InternalBug360834TestLanguage.g:611:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					newLeafNode(lv_name_2_0, grammarAccess.getClassMemberAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClassMemberRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getClassMemberAccess().getSemicolonKeyword_3());
            		

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
    // $ANTLR end "ruleClassMember"


    // $ANTLR start "entryRuleUnorderedModifiers"
    // InternalBug360834TestLanguage.g:635:1: entryRuleUnorderedModifiers returns [EObject current=null] : iv_ruleUnorderedModifiers= ruleUnorderedModifiers EOF ;
    public final EObject entryRuleUnorderedModifiers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedModifiers = null;


        try {
            // InternalBug360834TestLanguage.g:635:59: (iv_ruleUnorderedModifiers= ruleUnorderedModifiers EOF )
            // InternalBug360834TestLanguage.g:636:2: iv_ruleUnorderedModifiers= ruleUnorderedModifiers EOF
            {
             newCompositeNode(grammarAccess.getUnorderedModifiersRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedModifiers=ruleUnorderedModifiers();

            state._fsp--;

             current =iv_ruleUnorderedModifiers; 
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
    // $ANTLR end "entryRuleUnorderedModifiers"


    // $ANTLR start "ruleUnorderedModifiers"
    // InternalBug360834TestLanguage.g:642:1: ruleUnorderedModifiers returns [EObject current=null] : ( () ( ( ( ( ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleUnorderedModifiers() throws RecognitionException {
        EObject current = null;

        Token lv_final_2_0=null;
        Token lv_abstract_3_0=null;
        Token lv_extern_4_0=null;
        Enumerator lv_visibility_5_0 = null;



        	enterRule();

        try {
            // InternalBug360834TestLanguage.g:648:2: ( ( () ( ( ( ( ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) ) )* ) ) ) ) )
            // InternalBug360834TestLanguage.g:649:2: ( () ( ( ( ( ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) ) )* ) ) ) )
            {
            // InternalBug360834TestLanguage.g:649:2: ( () ( ( ( ( ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) ) )* ) ) ) )
            // InternalBug360834TestLanguage.g:650:3: () ( ( ( ( ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) ) )* ) ) )
            {
            // InternalBug360834TestLanguage.g:650:3: ()
            // InternalBug360834TestLanguage.g:651:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUnorderedModifiersAccess().getModifiersAction_0(),
            					current);
            			

            }

            // InternalBug360834TestLanguage.g:657:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) ) )* ) ) )
            // InternalBug360834TestLanguage.g:658:4: ( ( ( ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) ) )* ) )
            {
            // InternalBug360834TestLanguage.g:658:4: ( ( ( ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) ) )* ) )
            // InternalBug360834TestLanguage.g:659:5: ( ( ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
            				
            // InternalBug360834TestLanguage.g:662:5: ( ( ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) ) )* )
            // InternalBug360834TestLanguage.g:663:6: ( ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) ) )*
            {
            // InternalBug360834TestLanguage.g:663:6: ( ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) ) )*
            loop7:
            do {
                int alt7=5;
                int LA7_0 = input.LA(1);

                if ( LA7_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
                    alt7=2;
                }
                else if ( LA7_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
                    alt7=3;
                }
                else if ( LA7_0 >= 23 && LA7_0 <= 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
                    alt7=4;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBug360834TestLanguage.g:664:4: ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) )
            	    {
            	    // InternalBug360834TestLanguage.g:664:4: ({...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) ) )
            	    // InternalBug360834TestLanguage.g:665:5: {...}? => ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedModifiers", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // InternalBug360834TestLanguage.g:665:115: ( ({...}? => ( (lv_final_2_0= 'final' ) ) ) )
            	    // InternalBug360834TestLanguage.g:666:6: ({...}? => ( (lv_final_2_0= 'final' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 0);
            	    					
            	    // InternalBug360834TestLanguage.g:669:9: ({...}? => ( (lv_final_2_0= 'final' ) ) )
            	    // InternalBug360834TestLanguage.g:669:10: {...}? => ( (lv_final_2_0= 'final' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedModifiers", "true");
            	    }
            	    // InternalBug360834TestLanguage.g:669:19: ( (lv_final_2_0= 'final' ) )
            	    // InternalBug360834TestLanguage.g:669:20: (lv_final_2_0= 'final' )
            	    {
            	    // InternalBug360834TestLanguage.g:669:20: (lv_final_2_0= 'final' )
            	    // InternalBug360834TestLanguage.g:670:10: lv_final_2_0= 'final'
            	    {
            	    lv_final_2_0=(Token)match(input,19,FollowSets000.FOLLOW_13); 

            	    										newLeafNode(lv_final_2_0, grammarAccess.getUnorderedModifiersAccess().getFinalFinalKeyword_1_0_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnorderedModifiersRule());
            	    										}
            	    										setWithLastConsumed(current, "final", lv_final_2_0 != null, "final");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBug360834TestLanguage.g:687:4: ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) )
            	    {
            	    // InternalBug360834TestLanguage.g:687:4: ({...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) ) )
            	    // InternalBug360834TestLanguage.g:688:5: {...}? => ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedModifiers", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // InternalBug360834TestLanguage.g:688:115: ( ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) ) )
            	    // InternalBug360834TestLanguage.g:689:6: ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 1);
            	    					
            	    // InternalBug360834TestLanguage.g:692:9: ({...}? => ( (lv_abstract_3_0= 'abstract' ) ) )
            	    // InternalBug360834TestLanguage.g:692:10: {...}? => ( (lv_abstract_3_0= 'abstract' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedModifiers", "true");
            	    }
            	    // InternalBug360834TestLanguage.g:692:19: ( (lv_abstract_3_0= 'abstract' ) )
            	    // InternalBug360834TestLanguage.g:692:20: (lv_abstract_3_0= 'abstract' )
            	    {
            	    // InternalBug360834TestLanguage.g:692:20: (lv_abstract_3_0= 'abstract' )
            	    // InternalBug360834TestLanguage.g:693:10: lv_abstract_3_0= 'abstract'
            	    {
            	    lv_abstract_3_0=(Token)match(input,20,FollowSets000.FOLLOW_13); 

            	    										newLeafNode(lv_abstract_3_0, grammarAccess.getUnorderedModifiersAccess().getAbstractAbstractKeyword_1_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnorderedModifiersRule());
            	    										}
            	    										setWithLastConsumed(current, "abstract", lv_abstract_3_0 != null, "abstract");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalBug360834TestLanguage.g:710:4: ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) )
            	    {
            	    // InternalBug360834TestLanguage.g:710:4: ({...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) ) )
            	    // InternalBug360834TestLanguage.g:711:5: {...}? => ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedModifiers", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // InternalBug360834TestLanguage.g:711:115: ( ({...}? => ( (lv_extern_4_0= 'extern' ) ) ) )
            	    // InternalBug360834TestLanguage.g:712:6: ({...}? => ( (lv_extern_4_0= 'extern' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 2);
            	    					
            	    // InternalBug360834TestLanguage.g:715:9: ({...}? => ( (lv_extern_4_0= 'extern' ) ) )
            	    // InternalBug360834TestLanguage.g:715:10: {...}? => ( (lv_extern_4_0= 'extern' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedModifiers", "true");
            	    }
            	    // InternalBug360834TestLanguage.g:715:19: ( (lv_extern_4_0= 'extern' ) )
            	    // InternalBug360834TestLanguage.g:715:20: (lv_extern_4_0= 'extern' )
            	    {
            	    // InternalBug360834TestLanguage.g:715:20: (lv_extern_4_0= 'extern' )
            	    // InternalBug360834TestLanguage.g:716:10: lv_extern_4_0= 'extern'
            	    {
            	    lv_extern_4_0=(Token)match(input,21,FollowSets000.FOLLOW_13); 

            	    										newLeafNode(lv_extern_4_0, grammarAccess.getUnorderedModifiersAccess().getExternExternKeyword_1_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnorderedModifiersRule());
            	    										}
            	    										setWithLastConsumed(current, "extern", lv_extern_4_0 != null, "extern");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalBug360834TestLanguage.g:733:4: ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) )
            	    {
            	    // InternalBug360834TestLanguage.g:733:4: ({...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) ) )
            	    // InternalBug360834TestLanguage.g:734:5: {...}? => ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedModifiers", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3)");
            	    }
            	    // InternalBug360834TestLanguage.g:734:115: ( ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) ) )
            	    // InternalBug360834TestLanguage.g:735:6: ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1(), 3);
            	    					
            	    // InternalBug360834TestLanguage.g:738:9: ({...}? => ( (lv_visibility_5_0= ruleVisibility ) ) )
            	    // InternalBug360834TestLanguage.g:738:10: {...}? => ( (lv_visibility_5_0= ruleVisibility ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnorderedModifiers", "true");
            	    }
            	    // InternalBug360834TestLanguage.g:738:19: ( (lv_visibility_5_0= ruleVisibility ) )
            	    // InternalBug360834TestLanguage.g:738:20: (lv_visibility_5_0= ruleVisibility )
            	    {
            	    // InternalBug360834TestLanguage.g:738:20: (lv_visibility_5_0= ruleVisibility )
            	    // InternalBug360834TestLanguage.g:739:10: lv_visibility_5_0= ruleVisibility
            	    {

            	    										newCompositeNode(grammarAccess.getUnorderedModifiersAccess().getVisibilityVisibilityEnumRuleCall_1_3_0());
            	    									
            	    pushFollow(FollowSets000.FOLLOW_13);
            	    lv_visibility_5_0=ruleVisibility();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getUnorderedModifiersRule());
            	    										}
            	    										set(
            	    											current,
            	    											"visibility",
            	    											lv_visibility_5_0,
            	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug360834TestLanguage.Visibility");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getUnorderedModifiersAccess().getUnorderedGroup_1());
            				

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
    // $ANTLR end "ruleUnorderedModifiers"


    // $ANTLR start "ruleVisibility"
    // InternalBug360834TestLanguage.g:772:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'protected' ) | (enumLiteral_2= 'private' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalBug360834TestLanguage.g:778:2: ( ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'protected' ) | (enumLiteral_2= 'private' ) ) )
            // InternalBug360834TestLanguage.g:779:2: ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'protected' ) | (enumLiteral_2= 'private' ) )
            {
            // InternalBug360834TestLanguage.g:779:2: ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'protected' ) | (enumLiteral_2= 'private' ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt8=1;
                }
                break;
            case 24:
                {
                alt8=2;
                }
                break;
            case 25:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalBug360834TestLanguage.g:780:3: (enumLiteral_0= 'public' )
                    {
                    // InternalBug360834TestLanguage.g:780:3: (enumLiteral_0= 'public' )
                    // InternalBug360834TestLanguage.g:781:4: enumLiteral_0= 'public'
                    {
                    enumLiteral_0=(Token)match(input,23,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBug360834TestLanguage.g:788:3: (enumLiteral_1= 'protected' )
                    {
                    // InternalBug360834TestLanguage.g:788:3: (enumLiteral_1= 'protected' )
                    // InternalBug360834TestLanguage.g:789:4: enumLiteral_1= 'protected'
                    {
                    enumLiteral_1=(Token)match(input,24,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBug360834TestLanguage.g:796:3: (enumLiteral_2= 'private' )
                    {
                    // InternalBug360834TestLanguage.g:796:3: (enumLiteral_2= 'private' )
                    // InternalBug360834TestLanguage.g:797:4: enumLiteral_2= 'private'
                    {
                    enumLiteral_2=(Token)match(input,25,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleVisibility"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000003B90000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000003BD0000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000003FC0000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000003B80002L});
    }


}