package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalHiddenTerminalsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'without'", "'hiddens'", "';'", "'with'", "'overriding'", "'('", "')'", "'call'", "'inheriting'", "'datatype'", "'rule'", "'hiding'"
    };
    public static final int RULE_ML_COMMENT=5;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__19=19;
    public static final int T__9=9;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int RULE_WS=4;
    public static final int T__17=17;
    public static final int T__8=8;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__10=10;
    public static final int RULE_ANY_OTHER=7;
    public static final int RULE_SL_COMMENT=6;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalHiddenTerminalsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalHiddenTerminalsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalHiddenTerminalsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g"; }



     	private HiddenTerminalsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalHiddenTerminalsTestLanguageParser(TokenStream input, IAstFactory factory, HiddenTerminalsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected HiddenTerminalsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:80:1: ruleModel returns [EObject current=null] : (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_WithoutHiddens_0 = null;

        EObject this_WithHiddens_1 = null;

        EObject this_OverridingHiddens_2 = null;

        EObject this_InheritingHiddens_3 = null;

        EObject this_DatatypeHiddens_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:85:6: ( (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:86:1: (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:86:1: (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 8:
                {
                alt1=1;
                }
                break;
            case 11:
                {
                alt1=2;
                }
                break;
            case 12:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:87:5: this_WithoutHiddens_0= ruleWithoutHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getWithoutHiddensParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWithoutHiddens_in_ruleModel132);
                    this_WithoutHiddens_0=ruleWithoutHiddens();

                    state._fsp--;

                     
                            current = this_WithoutHiddens_0; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:98:5: this_WithHiddens_1= ruleWithHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getWithHiddensParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWithHiddens_in_ruleModel159);
                    this_WithHiddens_1=ruleWithHiddens();

                    state._fsp--;

                     
                            current = this_WithHiddens_1; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:109:5: this_OverridingHiddens_2= ruleOverridingHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getOverridingHiddensParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddens_in_ruleModel186);
                    this_OverridingHiddens_2=ruleOverridingHiddens();

                    state._fsp--;

                     
                            current = this_OverridingHiddens_2; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:120:5: this_InheritingHiddens_3= ruleInheritingHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getInheritingHiddensParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddens_in_ruleModel213);
                    this_InheritingHiddens_3=ruleInheritingHiddens();

                    state._fsp--;

                     
                            current = this_InheritingHiddens_3; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:131:5: this_DatatypeHiddens_4= ruleDatatypeHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getDatatypeHiddensParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeHiddens_in_ruleModel240);
                    this_DatatypeHiddens_4=ruleDatatypeHiddens();

                    state._fsp--;

                     
                            current = this_DatatypeHiddens_4; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleWithoutHiddens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:148:1: entryRuleWithoutHiddens returns [EObject current=null] : iv_ruleWithoutHiddens= ruleWithoutHiddens EOF ;
    public final EObject entryRuleWithoutHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithoutHiddens = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:149:2: (iv_ruleWithoutHiddens= ruleWithoutHiddens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:150:2: iv_ruleWithoutHiddens= ruleWithoutHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWithoutHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleWithoutHiddens_in_entryRuleWithoutHiddens275);
            iv_ruleWithoutHiddens=ruleWithoutHiddens();

            state._fsp--;

             current =iv_ruleWithoutHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWithoutHiddens285); 

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
    // $ANTLR end "entryRuleWithoutHiddens"


    // $ANTLR start "ruleWithoutHiddens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:157:1: ruleWithoutHiddens returns [EObject current=null] : (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) ;
    public final EObject ruleWithoutHiddens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_spaces_1_0=null;
        Token otherlv_2=null;
        Token lv_spaces_3_0=null;
        Token lv_valid_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:162:6: ( (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:163:1: (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:163:1: (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:163:3: otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) )
            {
            otherlv_0=(Token)match(input,8,FollowSets000.FOLLOW_8_in_ruleWithoutHiddens322); 

                	createLeafNode(otherlv_0, grammarAccess.getWithoutHiddensAccess().getWithoutKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:167:1: ( (lv_spaces_1_0= RULE_WS ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:168:1: (lv_spaces_1_0= RULE_WS )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:168:1: (lv_spaces_1_0= RULE_WS )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:169:3: lv_spaces_1_0= RULE_WS
            {
            lv_spaces_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleWithoutHiddens339); 

            			createLeafNode(lv_spaces_1_0, grammarAccess.getWithoutHiddensAccess().getSpacesWSTerminalRuleCall_1_0(), "spaces"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWithoutHiddensRule());
            	        }
                   		add(
                   			current, 
                   			"spaces",
                    		lv_spaces_1_0, 
                    		"WS", 
                    		lastConsumedNode);
            	    

            }


            }

            otherlv_2=(Token)match(input,9,FollowSets000.FOLLOW_9_in_ruleWithoutHiddens356); 

                	createLeafNode(otherlv_2, grammarAccess.getWithoutHiddensAccess().getHiddensKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:190:1: ( (lv_spaces_3_0= RULE_WS ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_WS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:191:1: (lv_spaces_3_0= RULE_WS )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:191:1: (lv_spaces_3_0= RULE_WS )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:192:3: lv_spaces_3_0= RULE_WS
                    {
                    lv_spaces_3_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleWithoutHiddens373); 

                    			createLeafNode(lv_spaces_3_0, grammarAccess.getWithoutHiddensAccess().getSpacesWSTerminalRuleCall_3_0(), "spaces"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWithoutHiddensRule());
                    	        }
                           		add(
                           			current, 
                           			"spaces",
                            		lv_spaces_3_0, 
                            		"WS", 
                            		lastConsumedNode);
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:209:3: ( (lv_valid_4_0= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:210:1: (lv_valid_4_0= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:210:1: (lv_valid_4_0= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:211:3: lv_valid_4_0= ';'
            {
            lv_valid_4_0=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleWithoutHiddens397); 

                    createLeafNode(lv_valid_4_0, grammarAccess.getWithoutHiddensAccess().getValidSemicolonKeyword_4_0(), "valid");
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWithoutHiddensRule());
            	        }
                   		set(current, "valid", true, ";", lastConsumedNode);
            	    

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
    // $ANTLR end "ruleWithoutHiddens"


    // $ANTLR start "entryRuleWithHiddens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:232:1: entryRuleWithHiddens returns [EObject current=null] : iv_ruleWithHiddens= ruleWithHiddens EOF ;
    public final EObject entryRuleWithHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithHiddens = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:236:2: (iv_ruleWithHiddens= ruleWithHiddens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:237:2: iv_ruleWithHiddens= ruleWithHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWithHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleWithHiddens_in_entryRuleWithHiddens452);
            iv_ruleWithHiddens=ruleWithHiddens();

            state._fsp--;

             current =iv_ruleWithHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWithHiddens462); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleWithHiddens"


    // $ANTLR start "ruleWithHiddens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:247:1: ruleWithHiddens returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) ) ;
    public final EObject ruleWithHiddens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_valid_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:253:6: ( (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:254:1: (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:254:1: (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:254:3: otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleWithHiddens503); 

                	createLeafNode(otherlv_0, grammarAccess.getWithHiddensAccess().getWithKeyword_0(), null);
                
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_9_in_ruleWithHiddens515); 

                	createLeafNode(otherlv_1, grammarAccess.getWithHiddensAccess().getHiddensKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:262:1: ( (lv_valid_2_0= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:263:1: (lv_valid_2_0= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:263:1: (lv_valid_2_0= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:264:3: lv_valid_2_0= ';'
            {
            lv_valid_2_0=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleWithHiddens533); 

                    createLeafNode(lv_valid_2_0, grammarAccess.getWithHiddensAccess().getValidSemicolonKeyword_2_0(), "valid");
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWithHiddensRule());
            	        }
                   		set(current, "valid", true, ";", lastConsumedNode);
            	    

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleWithHiddens"


    // $ANTLR start "entryRuleOverridingHiddens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:288:1: entryRuleOverridingHiddens returns [EObject current=null] : iv_ruleOverridingHiddens= ruleOverridingHiddens EOF ;
    public final EObject entryRuleOverridingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridingHiddens = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:292:2: (iv_ruleOverridingHiddens= ruleOverridingHiddens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:293:2: iv_ruleOverridingHiddens= ruleOverridingHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOverridingHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddens_in_entryRuleOverridingHiddens592);
            iv_ruleOverridingHiddens=ruleOverridingHiddens();

            state._fsp--;

             current =iv_ruleOverridingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridingHiddens602); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleOverridingHiddens"


    // $ANTLR start "ruleOverridingHiddens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:303:1: ruleOverridingHiddens returns [EObject current=null] : (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) ) ;
    public final EObject ruleOverridingHiddens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_valid_5_0=null;
        EObject lv_called_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:309:6: ( (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:310:1: (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:310:1: (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:310:3: otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleOverridingHiddens643); 

                	createLeafNode(otherlv_0, grammarAccess.getOverridingHiddensAccess().getOverridingKeyword_0(), null);
                
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_9_in_ruleOverridingHiddens655); 

                	createLeafNode(otherlv_1, grammarAccess.getOverridingHiddensAccess().getHiddensKeyword_1(), null);
                
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleOverridingHiddens667); 

                	createLeafNode(otherlv_2, grammarAccess.getOverridingHiddensAccess().getLeftParenthesisKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:322:1: ( (lv_called_3_0= ruleOverridingHiddensCall ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:323:1: (lv_called_3_0= ruleOverridingHiddensCall )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:323:1: (lv_called_3_0= ruleOverridingHiddensCall )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:324:3: lv_called_3_0= ruleOverridingHiddensCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getOverridingHiddensAccess().getCalledOverridingHiddensCallParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddensCall_in_ruleOverridingHiddens688);
            lv_called_3_0=ruleOverridingHiddensCall();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOverridingHiddensRule());
            	        }
                   		set(
                   			current, 
                   			"called",
                    		lv_called_3_0, 
                    		"OverridingHiddensCall", 
                    		currentNode);
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOverridingHiddens700); 

                	createLeafNode(otherlv_4, grammarAccess.getOverridingHiddensAccess().getRightParenthesisKeyword_4(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:345:1: ( (lv_valid_5_0= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:346:1: (lv_valid_5_0= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:346:1: (lv_valid_5_0= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:347:3: lv_valid_5_0= ';'
            {
            lv_valid_5_0=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleOverridingHiddens718); 

                    createLeafNode(lv_valid_5_0, grammarAccess.getOverridingHiddensAccess().getValidSemicolonKeyword_5_0(), "valid");
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOverridingHiddensRule());
            	        }
                   		set(current, "valid", true, ";", lastConsumedNode);
            	    

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleOverridingHiddens"


    // $ANTLR start "entryRuleOverridingHiddensCall"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:371:1: entryRuleOverridingHiddensCall returns [EObject current=null] : iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF ;
    public final EObject entryRuleOverridingHiddensCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridingHiddensCall = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:375:2: (iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:376:2: iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOverridingHiddensCallRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddensCall_in_entryRuleOverridingHiddensCall777);
            iv_ruleOverridingHiddensCall=ruleOverridingHiddensCall();

            state._fsp--;

             current =iv_ruleOverridingHiddensCall; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridingHiddensCall787); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleOverridingHiddensCall"


    // $ANTLR start "ruleOverridingHiddensCall"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:386:1: ruleOverridingHiddensCall returns [EObject current=null] : (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) ;
    public final EObject ruleOverridingHiddensCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_spaces_1_0=null;
        Token lv_valid_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:392:6: ( (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:393:1: (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:393:1: (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:393:3: otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOverridingHiddensCall828); 

                	createLeafNode(otherlv_0, grammarAccess.getOverridingHiddensCallAccess().getCallKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:397:1: ( (lv_spaces_1_0= RULE_WS ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:398:1: (lv_spaces_1_0= RULE_WS )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:398:1: (lv_spaces_1_0= RULE_WS )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:399:3: lv_spaces_1_0= RULE_WS
                    {
                    lv_spaces_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleOverridingHiddensCall845); 

                    			createLeafNode(lv_spaces_1_0, grammarAccess.getOverridingHiddensCallAccess().getSpacesWSTerminalRuleCall_1_0(), "spaces"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getOverridingHiddensCallRule());
                    	        }
                           		add(
                           			current, 
                           			"spaces",
                            		lv_spaces_1_0, 
                            		"WS", 
                            		lastConsumedNode);
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:416:3: ( (lv_valid_2_0= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:417:1: (lv_valid_2_0= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:417:1: (lv_valid_2_0= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:418:3: lv_valid_2_0= ';'
            {
            lv_valid_2_0=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleOverridingHiddensCall869); 

                    createLeafNode(lv_valid_2_0, grammarAccess.getOverridingHiddensCallAccess().getValidSemicolonKeyword_2_0(), "valid");
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOverridingHiddensCallRule());
            	        }
                   		set(current, "valid", true, ";", lastConsumedNode);
            	    

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleOverridingHiddensCall"


    // $ANTLR start "entryRuleInheritingHiddens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:442:1: entryRuleInheritingHiddens returns [EObject current=null] : iv_ruleInheritingHiddens= ruleInheritingHiddens EOF ;
    public final EObject entryRuleInheritingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritingHiddens = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:446:2: (iv_ruleInheritingHiddens= ruleInheritingHiddens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:2: iv_ruleInheritingHiddens= ruleInheritingHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInheritingHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddens_in_entryRuleInheritingHiddens928);
            iv_ruleInheritingHiddens=ruleInheritingHiddens();

            state._fsp--;

             current =iv_ruleInheritingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInheritingHiddens938); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleInheritingHiddens"


    // $ANTLR start "ruleInheritingHiddens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:457:1: ruleInheritingHiddens returns [EObject current=null] : (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) ) ;
    public final EObject ruleInheritingHiddens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token lv_valid_6_0=null;
        EObject lv_called_3_0 = null;

        EObject lv_hidingCalled_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:463:6: ( (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:464:1: (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:464:1: (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:464:3: otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleInheritingHiddens979); 

                	createLeafNode(otherlv_0, grammarAccess.getInheritingHiddensAccess().getInheritingKeyword_0(), null);
                
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_9_in_ruleInheritingHiddens991); 

                	createLeafNode(otherlv_1, grammarAccess.getInheritingHiddensAccess().getHiddensKeyword_1(), null);
                
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleInheritingHiddens1003); 

                	createLeafNode(otherlv_2, grammarAccess.getInheritingHiddensAccess().getLeftParenthesisKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:476:1: ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==19) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:476:2: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:476:2: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:477:1: (lv_called_3_0= ruleInheritingHiddensCall )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:477:1: (lv_called_3_0= ruleInheritingHiddensCall )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:478:3: lv_called_3_0= ruleInheritingHiddensCall
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInheritingHiddensAccess().getCalledInheritingHiddensCallParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddensCall_in_ruleInheritingHiddens1025);
                    lv_called_3_0=ruleInheritingHiddensCall();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInheritingHiddensRule());
                    	        }
                           		set(
                           			current, 
                           			"called",
                            		lv_called_3_0, 
                            		"InheritingHiddensCall", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:496:6: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:496:6: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:497:1: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:497:1: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:498:3: lv_hidingCalled_4_0= ruleHidingHiddens
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInheritingHiddensAccess().getHidingCalledHidingHiddensParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleHidingHiddens_in_ruleInheritingHiddens1052);
                    lv_hidingCalled_4_0=ruleHidingHiddens();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInheritingHiddensRule());
                    	        }
                           		set(
                           			current, 
                           			"hidingCalled",
                            		lv_hidingCalled_4_0, 
                            		"HidingHiddens", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleInheritingHiddens1065); 

                	createLeafNode(otherlv_5, grammarAccess.getInheritingHiddensAccess().getRightParenthesisKeyword_4(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:519:1: ( (lv_valid_6_0= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:520:1: (lv_valid_6_0= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:520:1: (lv_valid_6_0= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:521:3: lv_valid_6_0= ';'
            {
            lv_valid_6_0=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleInheritingHiddens1083); 

                    createLeafNode(lv_valid_6_0, grammarAccess.getInheritingHiddensAccess().getValidSemicolonKeyword_5_0(), "valid");
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInheritingHiddensRule());
            	        }
                   		set(current, "valid", true, ";", lastConsumedNode);
            	    

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleInheritingHiddens"


    // $ANTLR start "entryRuleDatatypeHiddens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:545:1: entryRuleDatatypeHiddens returns [EObject current=null] : iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF ;
    public final EObject entryRuleDatatypeHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeHiddens = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:546:2: (iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:547:2: iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeHiddens_in_entryRuleDatatypeHiddens1136);
            iv_ruleDatatypeHiddens=ruleDatatypeHiddens();

            state._fsp--;

             current =iv_ruleDatatypeHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeHiddens1146); 

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
    // $ANTLR end "entryRuleDatatypeHiddens"


    // $ANTLR start "ruleDatatypeHiddens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:554:1: ruleDatatypeHiddens returns [EObject current=null] : (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) ;
    public final EObject ruleDatatypeHiddens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_valid_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:559:6: ( (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:560:1: (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:560:1: (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:560:3: otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDatatypeHiddens1183); 

                	createLeafNode(otherlv_0, grammarAccess.getDatatypeHiddensAccess().getDatatypeKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:564:1: ( (lv_valid_1_0= ruleDatatypeRule ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:565:1: (lv_valid_1_0= ruleDatatypeRule )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:565:1: (lv_valid_1_0= ruleDatatypeRule )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:566:3: lv_valid_1_0= ruleDatatypeRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDatatypeHiddensAccess().getValidDatatypeRuleParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_ruleDatatypeHiddens1204);
            lv_valid_1_0=ruleDatatypeRule();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDatatypeHiddensRule());
            	        }
                   		set(
                   			current, 
                   			"valid",
                    		true, 
                    		"DatatypeRule", 
                    		currentNode);
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleDatatypeHiddens"


    // $ANTLR start "entryRuleDatatypeRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:591:1: entryRuleDatatypeRule returns [String current=null] : iv_ruleDatatypeRule= ruleDatatypeRule EOF ;
    public final String entryRuleDatatypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatypeRule = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:595:2: (iv_ruleDatatypeRule= ruleDatatypeRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:596:2: iv_ruleDatatypeRule= ruleDatatypeRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule1247);
            iv_ruleDatatypeRule=ruleDatatypeRule();

            state._fsp--;

             current =iv_ruleDatatypeRule.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeRule1258); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDatatypeRule"


    // $ANTLR start "ruleDatatypeRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:606:1: ruleDatatypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'rule' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleDatatypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:612:6: ( (kw= 'rule' kw= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:613:1: (kw= 'rule' kw= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:613:1: (kw= 'rule' kw= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:614:2: kw= 'rule' kw= ';'
            {
            kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleDatatypeRule1300); 

                    current.merge(kw);
                    createLeafNode(kw, grammarAccess.getDatatypeRuleAccess().getRuleKeyword_0(), null); 
                
            kw=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleDatatypeRule1313); 

                    current.merge(kw);
                    createLeafNode(kw, grammarAccess.getDatatypeRuleAccess().getSemicolonKeyword_1(), null); 
                

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDatatypeRule"


    // $ANTLR start "entryRuleHidingHiddens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:636:1: entryRuleHidingHiddens returns [EObject current=null] : iv_ruleHidingHiddens= ruleHidingHiddens EOF ;
    public final EObject entryRuleHidingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHidingHiddens = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:640:2: (iv_ruleHidingHiddens= ruleHidingHiddens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:641:2: iv_ruleHidingHiddens= ruleHidingHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getHidingHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleHidingHiddens_in_entryRuleHidingHiddens1363);
            iv_ruleHidingHiddens=ruleHidingHiddens();

            state._fsp--;

             current =iv_ruleHidingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHidingHiddens1373); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleHidingHiddens"


    // $ANTLR start "ruleHidingHiddens"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:651:1: ruleHidingHiddens returns [EObject current=null] : (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) ;
    public final EObject ruleHidingHiddens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_space_1_0=null;
        EObject lv_called_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:657:6: ( (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:658:1: (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:658:1: (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:658:3: otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleHidingHiddens1414); 

                	createLeafNode(otherlv_0, grammarAccess.getHidingHiddensAccess().getHidingKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:662:1: ( (lv_space_1_0= RULE_WS ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:663:1: (lv_space_1_0= RULE_WS )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:663:1: (lv_space_1_0= RULE_WS )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:664:3: lv_space_1_0= RULE_WS
            {
            lv_space_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleHidingHiddens1431); 

            			createLeafNode(lv_space_1_0, grammarAccess.getHidingHiddensAccess().getSpaceWSTerminalRuleCall_1_0(), "space"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getHidingHiddensRule());
            	        }
                   		set(
                   			current, 
                   			"space",
                    		lv_space_1_0, 
                    		"WS", 
                    		lastConsumedNode);
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:681:2: ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:682:1: (lv_called_2_0= ruleInheritingHiddensCall )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:682:1: (lv_called_2_0= ruleInheritingHiddensCall )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:683:3: lv_called_2_0= ruleInheritingHiddensCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getHidingHiddensAccess().getCalledInheritingHiddensCallParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddensCall_in_ruleHidingHiddens1457);
            lv_called_2_0=ruleInheritingHiddensCall();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getHidingHiddensRule());
            	        }
                   		set(
                   			current, 
                   			"called",
                    		lv_called_2_0, 
                    		"InheritingHiddensCall", 
                    		currentNode);
            	        afterParserOrEnumRuleCall();
            	    

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleHidingHiddens"


    // $ANTLR start "entryRuleInheritingHiddensCall"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:711:1: entryRuleInheritingHiddensCall returns [EObject current=null] : iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF ;
    public final EObject entryRuleInheritingHiddensCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritingHiddensCall = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:712:2: (iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:713:2: iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInheritingHiddensCallRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddensCall_in_entryRuleInheritingHiddensCall1497);
            iv_ruleInheritingHiddensCall=ruleInheritingHiddensCall();

            state._fsp--;

             current =iv_ruleInheritingHiddensCall; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInheritingHiddensCall1507); 

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
    // $ANTLR end "entryRuleInheritingHiddensCall"


    // $ANTLR start "ruleInheritingHiddensCall"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:720:1: ruleInheritingHiddensCall returns [EObject current=null] : (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) ) ;
    public final EObject ruleInheritingHiddensCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_valid_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:725:6: ( (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:726:1: (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:726:1: (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:726:3: otherlv_0= 'call' ( (lv_valid_1_0= ';' ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleInheritingHiddensCall1544); 

                	createLeafNode(otherlv_0, grammarAccess.getInheritingHiddensCallAccess().getCallKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:730:1: ( (lv_valid_1_0= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:731:1: (lv_valid_1_0= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:731:1: (lv_valid_1_0= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:732:3: lv_valid_1_0= ';'
            {
            lv_valid_1_0=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleInheritingHiddensCall1562); 

                    createLeafNode(lv_valid_1_0, grammarAccess.getInheritingHiddensCallAccess().getValidSemicolonKeyword_1_0(), "valid");
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInheritingHiddensCallRule());
            	        }
                   		set(current, "valid", true, ";", lastConsumedNode);
            	    

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
    // $ANTLR end "ruleInheritingHiddensCall"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithoutHiddens_in_ruleModel132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithHiddens_in_ruleModel159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridingHiddens_in_ruleModel186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritingHiddens_in_ruleModel213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeHiddens_in_ruleModel240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithoutHiddens_in_entryRuleWithoutHiddens275 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWithoutHiddens285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_8_in_ruleWithoutHiddens322 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleWithoutHiddens339 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleWithoutHiddens356 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleWithoutHiddens373 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleWithoutHiddens397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithHiddens_in_entryRuleWithHiddens452 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWithHiddens462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleWithHiddens503 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleWithHiddens515 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleWithHiddens533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridingHiddens_in_entryRuleOverridingHiddens592 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridingHiddens602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleOverridingHiddens643 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleOverridingHiddens655 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleOverridingHiddens667 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleOverridingHiddensCall_in_ruleOverridingHiddens688 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOverridingHiddens700 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleOverridingHiddens718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridingHiddensCall_in_entryRuleOverridingHiddensCall777 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridingHiddensCall787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleOverridingHiddensCall828 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleOverridingHiddensCall845 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleOverridingHiddensCall869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritingHiddens_in_entryRuleInheritingHiddens928 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInheritingHiddens938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleInheritingHiddens979 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleInheritingHiddens991 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleInheritingHiddens1003 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_ruleInheritingHiddens1025 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleHidingHiddens_in_ruleInheritingHiddens1052 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleInheritingHiddens1065 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleInheritingHiddens1083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeHiddens_in_entryRuleDatatypeHiddens1136 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeHiddens1146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleDatatypeHiddens1183 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_ruleDatatypeHiddens1204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule1247 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeRule1258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleDatatypeRule1300 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleDatatypeRule1313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHidingHiddens_in_entryRuleHidingHiddens1363 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHidingHiddens1373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleHidingHiddens1414 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleHidingHiddens1431 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_ruleHidingHiddens1457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_entryRuleInheritingHiddensCall1497 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInheritingHiddensCall1507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleInheritingHiddensCall1544 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleInheritingHiddensCall1562 = new BitSet(new long[]{0x0000000000000002L});
    }


}