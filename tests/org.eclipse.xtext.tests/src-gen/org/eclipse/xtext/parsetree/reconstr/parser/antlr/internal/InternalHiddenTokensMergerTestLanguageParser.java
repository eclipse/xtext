package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

import java.io.InputStream;
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
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.reconstr.services.HiddenTokensMergerTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalHiddenTokensMergerTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'ref'", "';'", "'.'", "'#2'", "'kw1'", "'#3'", "'item'", "'#4'", "'#5'", "'refs'", "'#6'", "'#7'", "'class'", "'endclass'", "'#8'", "'sub1'", "'sub2'", "'array'", "'object'", "'resultSet'", "'iterator'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int T__31=31;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalHiddenTokensMergerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalHiddenTokensMergerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalHiddenTokensMergerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g"; }



     	private HiddenTokensMergerTestLanguageGrammarAccess grammarAccess;
     	
        public InternalHiddenTokensMergerTestLanguageParser(TokenStream input, IAstFactory factory, HiddenTokensMergerTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.semanticModelBuilder = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected HiddenTokensMergerTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:80:1: ruleModel returns [EObject current=null] : (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_SingleRef_5= ruleSingleRef | this_AppendToFileEnd_6= ruleAppendToFileEnd | this_Action1_7= ruleAction1 ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_DatatypeBug286557_0 = null;

        EObject this_EnumBug_1 = null;

        EObject this_Commentable_2 = null;

        EObject this_ValueList_3 = null;

        EObject this_RefList_4 = null;

        EObject this_SingleRef_5 = null;

        EObject this_AppendToFileEnd_6 = null;

        EObject this_Action1_7 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:83:28: ( (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_SingleRef_5= ruleSingleRef | this_AppendToFileEnd_6= ruleAppendToFileEnd | this_Action1_7= ruleAction1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:84:1: (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_SingleRef_5= ruleSingleRef | this_AppendToFileEnd_6= ruleAppendToFileEnd | this_Action1_7= ruleAction1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:84:1: (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_SingleRef_5= ruleSingleRef | this_AppendToFileEnd_6= ruleAppendToFileEnd | this_Action1_7= ruleAction1 )
            int alt1=8;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 17:
                {
                alt1=3;
                }
                break;
            case 19:
                {
                alt1=4;
                }
                break;
            case 20:
                {
                alt1=5;
                }
                break;
            case 22:
                {
                alt1=6;
                }
                break;
            case 23:
                {
                alt1=7;
                }
                break;
            case 26:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:85:5: this_DatatypeBug286557_0= ruleDatatypeBug286557
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getDatatypeBug286557ParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeBug286557_in_ruleModel132);
                    this_DatatypeBug286557_0=ruleDatatypeBug286557();

                    state._fsp--;

                     
                            current = this_DatatypeBug286557_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:95:5: this_EnumBug_1= ruleEnumBug
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getEnumBugParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEnumBug_in_ruleModel159);
                    this_EnumBug_1=ruleEnumBug();

                    state._fsp--;

                     
                            current = this_EnumBug_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:105:5: this_Commentable_2= ruleCommentable
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getCommentableParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCommentable_in_ruleModel186);
                    this_Commentable_2=ruleCommentable();

                    state._fsp--;

                     
                            current = this_Commentable_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:115:5: this_ValueList_3= ruleValueList
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getValueListParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleValueList_in_ruleModel213);
                    this_ValueList_3=ruleValueList();

                    state._fsp--;

                     
                            current = this_ValueList_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:125:5: this_RefList_4= ruleRefList
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getRefListParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRefList_in_ruleModel240);
                    this_RefList_4=ruleRefList();

                    state._fsp--;

                     
                            current = this_RefList_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:135:5: this_SingleRef_5= ruleSingleRef
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getSingleRefParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSingleRef_in_ruleModel267);
                    this_SingleRef_5=ruleSingleRef();

                    state._fsp--;

                     
                            current = this_SingleRef_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:145:5: this_AppendToFileEnd_6= ruleAppendToFileEnd
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getAppendToFileEndParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAppendToFileEnd_in_ruleModel294);
                    this_AppendToFileEnd_6=ruleAppendToFileEnd();

                    state._fsp--;

                     
                            current = this_AppendToFileEnd_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:155:5: this_Action1_7= ruleAction1
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getAction1ParserRuleCall_7()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAction1_in_ruleModel321);
                    this_Action1_7=ruleAction1();

                    state._fsp--;

                     
                            current = this_Action1_7; 
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDatatypeBug286557"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:171:1: entryRuleDatatypeBug286557 returns [EObject current=null] : iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF ;
    public final EObject entryRuleDatatypeBug286557() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeBug286557 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:172:2: (iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:173:2: iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF
            {
             newCompositeNode(grammarAccess.getDatatypeBug286557Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeBug286557_in_entryRuleDatatypeBug286557356);
            iv_ruleDatatypeBug286557=ruleDatatypeBug286557();

            state._fsp--;

             current =iv_ruleDatatypeBug286557; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeBug286557366); 

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
    // $ANTLR end "entryRuleDatatypeBug286557"


    // $ANTLR start "ruleDatatypeBug286557"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:180:1: ruleDatatypeBug286557 returns [EObject current=null] : (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleDatatypeBug286557() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:183:28: ( (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:184:1: (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:184:1: (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:184:3: otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleDatatypeBug286557403); 

                	newLeafNode(otherlv_0, grammarAccess.getDatatypeBug286557Access().getNumberSignDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:188:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:189:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:189:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:190:3: lv_name_1_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getDatatypeBug286557Access().getNameFQNParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatypeBug286557424);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDatatypeBug286557Rule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:206:2: (otherlv_2= 'ref' ( ( ruleFQN ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:206:4: otherlv_2= 'ref' ( ( ruleFQN ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDatatypeBug286557437); 

                        	newLeafNode(otherlv_2, grammarAccess.getDatatypeBug286557Access().getRefKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:210:1: ( ( ruleFQN ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:211:1: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:211:1: ( ruleFQN )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:212:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDatatypeBug286557Rule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getDatatypeBug286557Access().getRefDatatypeBug286557CrossReference_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatypeBug286557460);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDatatypeBug286557474); 

                	newLeafNode(otherlv_4, grammarAccess.getDatatypeBug286557Access().getSemicolonKeyword_3());
                

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
    // $ANTLR end "ruleDatatypeBug286557"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:237:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:238:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:239:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN511);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN522); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:246:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:249:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:250:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:250:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:250:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN562); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:257:1: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:258:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleFQN581); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN596); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
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


    // $ANTLR start "entryRuleEnumBug"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:278:1: entryRuleEnumBug returns [EObject current=null] : iv_ruleEnumBug= ruleEnumBug EOF ;
    public final EObject entryRuleEnumBug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumBug = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:279:2: (iv_ruleEnumBug= ruleEnumBug EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:280:2: iv_ruleEnumBug= ruleEnumBug EOF
            {
             newCompositeNode(grammarAccess.getEnumBugRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumBug_in_entryRuleEnumBug643);
            iv_ruleEnumBug=ruleEnumBug();

            state._fsp--;

             current =iv_ruleEnumBug; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumBug653); 

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
    // $ANTLR end "entryRuleEnumBug"


    // $ANTLR start "ruleEnumBug"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:287:1: ruleEnumBug returns [EObject current=null] : (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleEnumBug() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_3_0=null;
        Enumerator lv_return_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:290:28: ( (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:291:1: (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:291:1: (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:291:3: otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEnumBug690); 

                	newLeafNode(otherlv_0, grammarAccess.getEnumBugAccess().getNumberSignDigitTwoKeyword_0());
                
            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleEnumBug702); 

                	newLeafNode(otherlv_1, grammarAccess.getEnumBugAccess().getKw1Keyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:299:1: ( (lv_return_2_0= ruleEnumBugEnum ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:300:1: (lv_return_2_0= ruleEnumBugEnum )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:300:1: (lv_return_2_0= ruleEnumBugEnum )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:301:3: lv_return_2_0= ruleEnumBugEnum
            {
             
            	        newCompositeNode(grammarAccess.getEnumBugAccess().getReturnEnumBugEnumEnumRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumBugEnum_in_ruleEnumBug723);
            lv_return_2_0=ruleEnumBugEnum();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEnumBugRule());
            	        }
                   		set(
                   			current, 
                   			"return",
                    		lv_return_2_0, 
                    		"EnumBugEnum");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:317:2: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:318:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:318:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:319:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumBug740); 

            			newLeafNode(lv_name_3_0, grammarAccess.getEnumBugAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumBugRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
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
    // $ANTLR end "ruleEnumBug"


    // $ANTLR start "entryRuleCommentable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:343:1: entryRuleCommentable returns [EObject current=null] : iv_ruleCommentable= ruleCommentable EOF ;
    public final EObject entryRuleCommentable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentable = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:344:2: (iv_ruleCommentable= ruleCommentable EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:345:2: iv_ruleCommentable= ruleCommentable EOF
            {
             newCompositeNode(grammarAccess.getCommentableRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCommentable_in_entryRuleCommentable781);
            iv_ruleCommentable=ruleCommentable();

            state._fsp--;

             current =iv_ruleCommentable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommentable791); 

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
    // $ANTLR end "entryRuleCommentable"


    // $ANTLR start "ruleCommentable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:352:1: ruleCommentable returns [EObject current=null] : (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) ;
    public final EObject ruleCommentable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_item_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:355:28: ( (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:356:1: (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:356:1: (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:356:3: otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )*
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleCommentable828); 

                	newLeafNode(otherlv_0, grammarAccess.getCommentableAccess().getNumberSignDigitThreeKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:360:1: ( (lv_item_1_0= ruleCommentableItem ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:361:1: (lv_item_1_0= ruleCommentableItem )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:361:1: (lv_item_1_0= ruleCommentableItem )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:362:3: lv_item_1_0= ruleCommentableItem
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCommentableAccess().getItemCommentableItemParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleCommentableItem_in_ruleCommentable849);
            	    lv_item_1_0=ruleCommentableItem();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCommentableRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"item",
            	            		lv_item_1_0, 
            	            		"CommentableItem");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


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
    // $ANTLR end "ruleCommentable"


    // $ANTLR start "entryRuleCommentableItem"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:386:1: entryRuleCommentableItem returns [EObject current=null] : iv_ruleCommentableItem= ruleCommentableItem EOF ;
    public final EObject entryRuleCommentableItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentableItem = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:387:2: (iv_ruleCommentableItem= ruleCommentableItem EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:388:2: iv_ruleCommentableItem= ruleCommentableItem EOF
            {
             newCompositeNode(grammarAccess.getCommentableItemRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCommentableItem_in_entryRuleCommentableItem886);
            iv_ruleCommentableItem=ruleCommentableItem();

            state._fsp--;

             current =iv_ruleCommentableItem; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommentableItem896); 

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
    // $ANTLR end "entryRuleCommentableItem"


    // $ANTLR start "ruleCommentableItem"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:395:1: ruleCommentableItem returns [EObject current=null] : (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) ) ;
    public final EObject ruleCommentableItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:398:28: ( (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:399:1: (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:399:1: (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:399:3: otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleCommentableItem933); 

                	newLeafNode(otherlv_0, grammarAccess.getCommentableItemAccess().getItemKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:403:1: ( (lv_id_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:404:1: (lv_id_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:404:1: (lv_id_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:405:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCommentableItem950); 

            			newLeafNode(lv_id_1_0, grammarAccess.getCommentableItemAccess().getIdIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCommentableItemRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
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
    // $ANTLR end "ruleCommentableItem"


    // $ANTLR start "entryRuleValueList"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:429:1: entryRuleValueList returns [EObject current=null] : iv_ruleValueList= ruleValueList EOF ;
    public final EObject entryRuleValueList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueList = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:430:2: (iv_ruleValueList= ruleValueList EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:431:2: iv_ruleValueList= ruleValueList EOF
            {
             newCompositeNode(grammarAccess.getValueListRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleValueList_in_entryRuleValueList991);
            iv_ruleValueList=ruleValueList();

            state._fsp--;

             current =iv_ruleValueList; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueList1001); 

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
    // $ANTLR end "entryRuleValueList"


    // $ANTLR start "ruleValueList"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:438:1: ruleValueList returns [EObject current=null] : (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* ) ;
    public final EObject ruleValueList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_ids_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:441:28: ( (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:442:1: (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:442:1: (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:442:3: otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )*
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleValueList1038); 

                	newLeafNode(otherlv_0, grammarAccess.getValueListAccess().getNumberSignDigitFourKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:446:1: ( (lv_ids_1_0= ruleFQN ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:447:1: (lv_ids_1_0= ruleFQN )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:447:1: (lv_ids_1_0= ruleFQN )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:448:3: lv_ids_1_0= ruleFQN
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getValueListAccess().getIdsFQNParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleValueList1059);
            	    lv_ids_1_0=ruleFQN();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getValueListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ids",
            	            		lv_ids_1_0, 
            	            		"FQN");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "ruleValueList"


    // $ANTLR start "entryRuleRefList"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:472:1: entryRuleRefList returns [EObject current=null] : iv_ruleRefList= ruleRefList EOF ;
    public final EObject entryRuleRefList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefList = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:473:2: (iv_ruleRefList= ruleRefList EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:474:2: iv_ruleRefList= ruleRefList EOF
            {
             newCompositeNode(grammarAccess.getRefListRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRefList_in_entryRuleRefList1096);
            iv_ruleRefList=ruleRefList();

            state._fsp--;

             current =iv_ruleRefList; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRefList1106); 

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
    // $ANTLR end "entryRuleRefList"


    // $ANTLR start "ruleRefList"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:481:1: ruleRefList returns [EObject current=null] : (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* ) ;
    public final EObject ruleRefList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_objs_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:484:28: ( (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:485:1: (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:485:1: (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:485:3: otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )*
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleRefList1143); 

                	newLeafNode(otherlv_0, grammarAccess.getRefListAccess().getNumberSignDigitFiveKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:489:1: ( (lv_objs_1_0= ruleRefObj ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:490:1: (lv_objs_1_0= ruleRefObj )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:490:1: (lv_objs_1_0= ruleRefObj )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:491:3: lv_objs_1_0= ruleRefObj
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRefListAccess().getObjsRefObjParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRefObj_in_ruleRefList1164);
            	    lv_objs_1_0=ruleRefObj();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRefListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"objs",
            	            		lv_objs_1_0, 
            	            		"RefObj");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleRefList1177); 

                	newLeafNode(otherlv_2, grammarAccess.getRefListAccess().getRefsKeyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:511:1: ( ( ruleFQN ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:512:1: ( ruleFQN )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:512:1: ( ruleFQN )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:513:3: ruleFQN
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRefListRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRefListAccess().getRefsRefObjCrossReference_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleRefList1200);
            	    ruleFQN();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleRefList"


    // $ANTLR start "entryRuleRefObj"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:534:1: entryRuleRefObj returns [EObject current=null] : iv_ruleRefObj= ruleRefObj EOF ;
    public final EObject entryRuleRefObj() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefObj = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:535:2: (iv_ruleRefObj= ruleRefObj EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:536:2: iv_ruleRefObj= ruleRefObj EOF
            {
             newCompositeNode(grammarAccess.getRefObjRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRefObj_in_entryRuleRefObj1237);
            iv_ruleRefObj=ruleRefObj();

            state._fsp--;

             current =iv_ruleRefObj; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRefObj1247); 

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
    // $ANTLR end "entryRuleRefObj"


    // $ANTLR start "ruleRefObj"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:543:1: ruleRefObj returns [EObject current=null] : ( (lv_name_0_0= ruleFQN ) ) ;
    public final EObject ruleRefObj() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:546:28: ( ( (lv_name_0_0= ruleFQN ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:547:1: ( (lv_name_0_0= ruleFQN ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:547:1: ( (lv_name_0_0= ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:548:1: (lv_name_0_0= ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:548:1: (lv_name_0_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:549:3: lv_name_0_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getRefObjAccess().getNameFQNParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleRefObj1292);
            lv_name_0_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRefObjRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"FQN");
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
    // $ANTLR end "ruleRefObj"


    // $ANTLR start "entryRuleSingleRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:573:1: entryRuleSingleRef returns [EObject current=null] : iv_ruleSingleRef= ruleSingleRef EOF ;
    public final EObject entryRuleSingleRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleRef = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:574:2: (iv_ruleSingleRef= ruleSingleRef EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:575:2: iv_ruleSingleRef= ruleSingleRef EOF
            {
             newCompositeNode(grammarAccess.getSingleRefRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleRef_in_entryRuleSingleRef1327);
            iv_ruleSingleRef=ruleSingleRef();

            state._fsp--;

             current =iv_ruleSingleRef; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleRef1337); 

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
    // $ANTLR end "entryRuleSingleRef"


    // $ANTLR start "ruleSingleRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:582:1: ruleSingleRef returns [EObject current=null] : (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSingleRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_obj_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:585:28: ( (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:586:1: (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:586:1: (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:586:3: otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSingleRef1374); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleRefAccess().getNumberSignDigitSixKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:590:1: ( (lv_obj_1_0= ruleRefObj ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:591:1: (lv_obj_1_0= ruleRefObj )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:591:1: (lv_obj_1_0= ruleRefObj )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:592:3: lv_obj_1_0= ruleRefObj
            {
             
            	        newCompositeNode(grammarAccess.getSingleRefAccess().getObjRefObjParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleRefObj_in_ruleSingleRef1395);
            lv_obj_1_0=ruleRefObj();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSingleRefRule());
            	        }
                   		set(
                   			current, 
                   			"obj",
                    		lv_obj_1_0, 
                    		"RefObj");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSingleRef1407); 

                	newLeafNode(otherlv_2, grammarAccess.getSingleRefAccess().getRefKeyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:612:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:613:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:613:1: ( ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:614:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSingleRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSingleRefAccess().getRefRefObjCrossReference_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleSingleRef1430);
            ruleFQN();

            state._fsp--;

             
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
    // $ANTLR end "ruleSingleRef"


    // $ANTLR start "entryRuleAppendToFileEnd"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:635:1: entryRuleAppendToFileEnd returns [EObject current=null] : iv_ruleAppendToFileEnd= ruleAppendToFileEnd EOF ;
    public final EObject entryRuleAppendToFileEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAppendToFileEnd = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:636:2: (iv_ruleAppendToFileEnd= ruleAppendToFileEnd EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:637:2: iv_ruleAppendToFileEnd= ruleAppendToFileEnd EOF
            {
             newCompositeNode(grammarAccess.getAppendToFileEndRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAppendToFileEnd_in_entryRuleAppendToFileEnd1466);
            iv_ruleAppendToFileEnd=ruleAppendToFileEnd();

            state._fsp--;

             current =iv_ruleAppendToFileEnd; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAppendToFileEnd1476); 

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
    // $ANTLR end "entryRuleAppendToFileEnd"


    // $ANTLR start "ruleAppendToFileEnd"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:644:1: ruleAppendToFileEnd returns [EObject current=null] : (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* ) ;
    public final EObject ruleAppendToFileEnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_items_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:647:28: ( (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:648:1: (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:648:1: (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:648:3: otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )*
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleAppendToFileEnd1513); 

                	newLeafNode(otherlv_0, grammarAccess.getAppendToFileEndAccess().getNumberSignDigitSevenKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:652:1: ( (lv_items_1_0= ruleAppendToFileEndItem ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:653:1: (lv_items_1_0= ruleAppendToFileEndItem )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:653:1: (lv_items_1_0= ruleAppendToFileEndItem )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:654:3: lv_items_1_0= ruleAppendToFileEndItem
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAppendToFileEndAccess().getItemsAppendToFileEndItemParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAppendToFileEndItem_in_ruleAppendToFileEnd1534);
            	    lv_items_1_0=ruleAppendToFileEndItem();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAppendToFileEndRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"items",
            	            		lv_items_1_0, 
            	            		"AppendToFileEndItem");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


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
    // $ANTLR end "ruleAppendToFileEnd"


    // $ANTLR start "entryRuleAppendToFileEndItem"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:678:1: entryRuleAppendToFileEndItem returns [EObject current=null] : iv_ruleAppendToFileEndItem= ruleAppendToFileEndItem EOF ;
    public final EObject entryRuleAppendToFileEndItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAppendToFileEndItem = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:679:2: (iv_ruleAppendToFileEndItem= ruleAppendToFileEndItem EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:680:2: iv_ruleAppendToFileEndItem= ruleAppendToFileEndItem EOF
            {
             newCompositeNode(grammarAccess.getAppendToFileEndItemRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAppendToFileEndItem_in_entryRuleAppendToFileEndItem1571);
            iv_ruleAppendToFileEndItem=ruleAppendToFileEndItem();

            state._fsp--;

             current =iv_ruleAppendToFileEndItem; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAppendToFileEndItem1581); 

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
    // $ANTLR end "entryRuleAppendToFileEndItem"


    // $ANTLR start "ruleAppendToFileEndItem"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:687:1: ruleAppendToFileEndItem returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' ) ;
    public final EObject ruleAppendToFileEndItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:690:28: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:691:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:691:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:691:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass'
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleAppendToFileEndItem1618); 

                	newLeafNode(otherlv_0, grammarAccess.getAppendToFileEndItemAccess().getClassKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:695:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:696:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:696:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:697:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAppendToFileEndItem1635); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAppendToFileEndItemAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAppendToFileEndItemRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAppendToFileEndItem1652); 

                	newLeafNode(otherlv_2, grammarAccess.getAppendToFileEndItemAccess().getEndclassKeyword_2());
                

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
    // $ANTLR end "ruleAppendToFileEndItem"


    // $ANTLR start "entryRuleAction1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:725:1: entryRuleAction1 returns [EObject current=null] : iv_ruleAction1= ruleAction1 EOF ;
    public final EObject entryRuleAction1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:726:2: (iv_ruleAction1= ruleAction1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:727:2: iv_ruleAction1= ruleAction1 EOF
            {
             newCompositeNode(grammarAccess.getAction1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction1_in_entryRuleAction11688);
            iv_ruleAction1=ruleAction1();

            state._fsp--;

             current =iv_ruleAction1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction11698); 

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
    // $ANTLR end "entryRuleAction1"


    // $ANTLR start "ruleAction1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:734:1: ruleAction1 returns [EObject current=null] : (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) ) ;
    public final EObject ruleAction1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        EObject lv_actions2_3_0 = null;

        EObject lv_actions2_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:737:28: ( (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:738:1: (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:738:1: (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:738:3: otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) )
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleAction11735); 

                	newLeafNode(otherlv_0, grammarAccess.getAction1Access().getNumberSignDigitEightKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:742:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:743:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAction1Access().getAction1Action_1(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:748:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:749:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:749:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:750:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAction11761); 

            			newLeafNode(lv_name_2_0, grammarAccess.getAction1Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAction1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:766:2: ( (lv_actions2_3_0= ruleAction1Sub1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:767:1: (lv_actions2_3_0= ruleAction1Sub1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:767:1: (lv_actions2_3_0= ruleAction1Sub1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:768:3: lv_actions2_3_0= ruleAction1Sub1
            {
             
            	        newCompositeNode(grammarAccess.getAction1Access().getActions2Action1Sub1ParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAction1Sub1_in_ruleAction11787);
            lv_actions2_3_0=ruleAction1Sub1();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAction1Rule());
            	        }
                   		add(
                   			current, 
                   			"actions2",
                    		lv_actions2_3_0, 
                    		"Action1Sub1");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:784:2: ( (lv_actions2_4_0= ruleAction1Sub2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:785:1: (lv_actions2_4_0= ruleAction1Sub2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:785:1: (lv_actions2_4_0= ruleAction1Sub2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:786:3: lv_actions2_4_0= ruleAction1Sub2
            {
             
            	        newCompositeNode(grammarAccess.getAction1Access().getActions2Action1Sub2ParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAction1Sub2_in_ruleAction11808);
            lv_actions2_4_0=ruleAction1Sub2();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAction1Rule());
            	        }
                   		add(
                   			current, 
                   			"actions2",
                    		lv_actions2_4_0, 
                    		"Action1Sub2");
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
    // $ANTLR end "ruleAction1"


    // $ANTLR start "entryRuleAction1Sub1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:810:1: entryRuleAction1Sub1 returns [EObject current=null] : iv_ruleAction1Sub1= ruleAction1Sub1 EOF ;
    public final EObject entryRuleAction1Sub1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction1Sub1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:811:2: (iv_ruleAction1Sub1= ruleAction1Sub1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:812:2: iv_ruleAction1Sub1= ruleAction1Sub1 EOF
            {
             newCompositeNode(grammarAccess.getAction1Sub1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction1Sub1_in_entryRuleAction1Sub11844);
            iv_ruleAction1Sub1=ruleAction1Sub1();

            state._fsp--;

             current =iv_ruleAction1Sub1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction1Sub11854); 

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
    // $ANTLR end "entryRuleAction1Sub1"


    // $ANTLR start "ruleAction1Sub1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:819:1: ruleAction1Sub1 returns [EObject current=null] : ( () otherlv_1= 'sub1' ) ;
    public final EObject ruleAction1Sub1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:822:28: ( ( () otherlv_1= 'sub1' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:823:1: ( () otherlv_1= 'sub1' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:823:1: ( () otherlv_1= 'sub1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:823:2: () otherlv_1= 'sub1'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:823:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:824:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAction1Sub1Access().getAction1SubAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAction1Sub11900); 

                	newLeafNode(otherlv_1, grammarAccess.getAction1Sub1Access().getSub1Keyword_1());
                

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
    // $ANTLR end "ruleAction1Sub1"


    // $ANTLR start "entryRuleAction1Sub2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:841:1: entryRuleAction1Sub2 returns [EObject current=null] : iv_ruleAction1Sub2= ruleAction1Sub2 EOF ;
    public final EObject entryRuleAction1Sub2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction1Sub2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:842:2: (iv_ruleAction1Sub2= ruleAction1Sub2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:843:2: iv_ruleAction1Sub2= ruleAction1Sub2 EOF
            {
             newCompositeNode(grammarAccess.getAction1Sub2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction1Sub2_in_entryRuleAction1Sub21936);
            iv_ruleAction1Sub2=ruleAction1Sub2();

            state._fsp--;

             current =iv_ruleAction1Sub2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction1Sub21946); 

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
    // $ANTLR end "entryRuleAction1Sub2"


    // $ANTLR start "ruleAction1Sub2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:850:1: ruleAction1Sub2 returns [EObject current=null] : ( () otherlv_1= 'sub2' ) ;
    public final EObject ruleAction1Sub2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:853:28: ( ( () otherlv_1= 'sub2' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:854:1: ( () otherlv_1= 'sub2' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:854:1: ( () otherlv_1= 'sub2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:854:2: () otherlv_1= 'sub2'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:854:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:855:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAction1Sub2Access().getAction1SubClassAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAction1Sub21992); 

                	newLeafNode(otherlv_1, grammarAccess.getAction1Sub2Access().getSub2Keyword_1());
                

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
    // $ANTLR end "ruleAction1Sub2"


    // $ANTLR start "ruleEnumBugEnum"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:872:1: ruleEnumBugEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) ) ;
    public final Enumerator ruleEnumBugEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:874:28: ( ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:875:1: ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:875:1: ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt9=1;
                }
                break;
            case 30:
                {
                alt9=2;
                }
                break;
            case 31:
                {
                alt9=3;
                }
                break;
            case 32:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:875:2: (enumLiteral_0= 'array' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:875:2: (enumLiteral_0= 'array' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:875:4: enumLiteral_0= 'array'
                    {
                    enumLiteral_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEnumBugEnum2042); 

                            current = grammarAccess.getEnumBugEnumAccess().getArrayEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEnumBugEnumAccess().getArrayEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:881:6: (enumLiteral_1= 'object' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:881:6: (enumLiteral_1= 'object' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:881:8: enumLiteral_1= 'object'
                    {
                    enumLiteral_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleEnumBugEnum2059); 

                            current = grammarAccess.getEnumBugEnumAccess().getObjectEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getEnumBugEnumAccess().getObjectEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:887:6: (enumLiteral_2= 'resultSet' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:887:6: (enumLiteral_2= 'resultSet' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:887:8: enumLiteral_2= 'resultSet'
                    {
                    enumLiteral_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleEnumBugEnum2076); 

                            current = grammarAccess.getEnumBugEnumAccess().getResultSetEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getEnumBugEnumAccess().getResultSetEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:893:6: (enumLiteral_3= 'iterator' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:893:6: (enumLiteral_3= 'iterator' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:893:8: enumLiteral_3= 'iterator'
                    {
                    enumLiteral_3=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleEnumBugEnum2093); 

                            current = grammarAccess.getEnumBugEnumAccess().getIteratorEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getEnumBugEnumAccess().getIteratorEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleEnumBugEnum"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeBug286557_in_ruleModel132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumBug_in_ruleModel159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommentable_in_ruleModel186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueList_in_ruleModel213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRefList_in_ruleModel240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleRef_in_ruleModel267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAppendToFileEnd_in_ruleModel294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction1_in_ruleModel321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeBug286557_in_entryRuleDatatypeBug286557356 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeBug286557366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleDatatypeBug286557403 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatypeBug286557424 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_12_in_ruleDatatypeBug286557437 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatypeBug286557460 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleDatatypeBug286557474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN511 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN562 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleFQN581 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN596 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleEnumBug_in_entryRuleEnumBug643 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumBug653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleEnumBug690 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleEnumBug702 = new BitSet(new long[]{0x00000001E0000000L});
        public static final BitSet FOLLOW_ruleEnumBugEnum_in_ruleEnumBug723 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumBug740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommentable_in_entryRuleCommentable781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommentable791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleCommentable828 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleCommentableItem_in_ruleCommentable849 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleCommentableItem_in_entryRuleCommentableItem886 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommentableItem896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleCommentableItem933 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCommentableItem950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueList_in_entryRuleValueList991 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueList1001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleValueList1038 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleValueList1059 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleRefList_in_entryRuleRefList1096 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRefList1106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleRefList1143 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleRefObj_in_ruleRefList1164 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_21_in_ruleRefList1177 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleRefList1200 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleRefObj_in_entryRuleRefObj1237 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRefObj1247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleRefObj1292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleRef_in_entryRuleSingleRef1327 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleRef1337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleSingleRef1374 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleRefObj_in_ruleSingleRef1395 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSingleRef1407 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleSingleRef1430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAppendToFileEnd_in_entryRuleAppendToFileEnd1466 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAppendToFileEnd1476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleAppendToFileEnd1513 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleAppendToFileEndItem_in_ruleAppendToFileEnd1534 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleAppendToFileEndItem_in_entryRuleAppendToFileEndItem1571 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAppendToFileEndItem1581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleAppendToFileEndItem1618 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAppendToFileEndItem1635 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleAppendToFileEndItem1652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction1_in_entryRuleAction11688 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction11698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleAction11735 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAction11761 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_ruleAction1Sub1_in_ruleAction11787 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_ruleAction1Sub2_in_ruleAction11808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction1Sub1_in_entryRuleAction1Sub11844 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction1Sub11854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleAction1Sub11900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction1Sub2_in_entryRuleAction1Sub21936 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction1Sub21946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleAction1Sub21992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleEnumBugEnum2042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleEnumBugEnum2059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleEnumBugEnum2076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleEnumBugEnum2093 = new BitSet(new long[]{0x0000000000000002L});
    }


}