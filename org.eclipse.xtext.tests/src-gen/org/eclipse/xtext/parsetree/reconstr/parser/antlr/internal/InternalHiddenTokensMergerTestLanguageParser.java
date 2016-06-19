package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

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
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalHiddenTokensMergerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalHiddenTokensMergerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalHiddenTokensMergerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalHiddenTokensMergerTestLanguage.g"; }



     	private HiddenTokensMergerTestLanguageGrammarAccess grammarAccess;
     	
        public InternalHiddenTokensMergerTestLanguageParser(TokenStream input, HiddenTokensMergerTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // InternalHiddenTokensMergerTestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:69:2: (iv_ruleModel= ruleModel EOF )
            // InternalHiddenTokensMergerTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalHiddenTokensMergerTestLanguage.g:77:1: ruleModel returns [EObject current=null] : (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_SingleRef_5= ruleSingleRef | this_AppendToFileEnd_6= ruleAppendToFileEnd | this_Action1_7= ruleAction1 ) ;
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
            // InternalHiddenTokensMergerTestLanguage.g:80:28: ( (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_SingleRef_5= ruleSingleRef | this_AppendToFileEnd_6= ruleAppendToFileEnd | this_Action1_7= ruleAction1 ) )
            // InternalHiddenTokensMergerTestLanguage.g:81:1: (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_SingleRef_5= ruleSingleRef | this_AppendToFileEnd_6= ruleAppendToFileEnd | this_Action1_7= ruleAction1 )
            {
            // InternalHiddenTokensMergerTestLanguage.g:81:1: (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_SingleRef_5= ruleSingleRef | this_AppendToFileEnd_6= ruleAppendToFileEnd | this_Action1_7= ruleAction1 )
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
                    // InternalHiddenTokensMergerTestLanguage.g:82:5: this_DatatypeBug286557_0= ruleDatatypeBug286557
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getDatatypeBug286557ParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DatatypeBug286557_0=ruleDatatypeBug286557();

                    state._fsp--;

                     
                            current = this_DatatypeBug286557_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalHiddenTokensMergerTestLanguage.g:92:5: this_EnumBug_1= ruleEnumBug
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getEnumBugParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EnumBug_1=ruleEnumBug();

                    state._fsp--;

                     
                            current = this_EnumBug_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalHiddenTokensMergerTestLanguage.g:102:5: this_Commentable_2= ruleCommentable
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getCommentableParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Commentable_2=ruleCommentable();

                    state._fsp--;

                     
                            current = this_Commentable_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalHiddenTokensMergerTestLanguage.g:112:5: this_ValueList_3= ruleValueList
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getValueListParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ValueList_3=ruleValueList();

                    state._fsp--;

                     
                            current = this_ValueList_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalHiddenTokensMergerTestLanguage.g:122:5: this_RefList_4= ruleRefList
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getRefListParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RefList_4=ruleRefList();

                    state._fsp--;

                     
                            current = this_RefList_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalHiddenTokensMergerTestLanguage.g:132:5: this_SingleRef_5= ruleSingleRef
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getSingleRefParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SingleRef_5=ruleSingleRef();

                    state._fsp--;

                     
                            current = this_SingleRef_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalHiddenTokensMergerTestLanguage.g:142:5: this_AppendToFileEnd_6= ruleAppendToFileEnd
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getAppendToFileEndParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AppendToFileEnd_6=ruleAppendToFileEnd();

                    state._fsp--;

                     
                            current = this_AppendToFileEnd_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // InternalHiddenTokensMergerTestLanguage.g:152:5: this_Action1_7= ruleAction1
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getAction1ParserRuleCall_7()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalHiddenTokensMergerTestLanguage.g:168:1: entryRuleDatatypeBug286557 returns [EObject current=null] : iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF ;
    public final EObject entryRuleDatatypeBug286557() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeBug286557 = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:169:2: (iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF )
            // InternalHiddenTokensMergerTestLanguage.g:170:2: iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF
            {
             newCompositeNode(grammarAccess.getDatatypeBug286557Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatypeBug286557=ruleDatatypeBug286557();

            state._fsp--;

             current =iv_ruleDatatypeBug286557; 
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
    // $ANTLR end "entryRuleDatatypeBug286557"


    // $ANTLR start "ruleDatatypeBug286557"
    // InternalHiddenTokensMergerTestLanguage.g:177:1: ruleDatatypeBug286557 returns [EObject current=null] : (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleDatatypeBug286557() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:180:28: ( (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' ) )
            // InternalHiddenTokensMergerTestLanguage.g:181:1: (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' )
            {
            // InternalHiddenTokensMergerTestLanguage.g:181:1: (otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';' )
            // InternalHiddenTokensMergerTestLanguage.g:181:3: otherlv_0= '#1' ( (lv_name_1_0= ruleFQN ) ) (otherlv_2= 'ref' ( ( ruleFQN ) ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getDatatypeBug286557Access().getNumberSignDigitOneKeyword_0());
                
            // InternalHiddenTokensMergerTestLanguage.g:185:1: ( (lv_name_1_0= ruleFQN ) )
            // InternalHiddenTokensMergerTestLanguage.g:186:1: (lv_name_1_0= ruleFQN )
            {
            // InternalHiddenTokensMergerTestLanguage.g:186:1: (lv_name_1_0= ruleFQN )
            // InternalHiddenTokensMergerTestLanguage.g:187:3: lv_name_1_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getDatatypeBug286557Access().getNameFQNParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_4);
            lv_name_1_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDatatypeBug286557Rule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage.FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalHiddenTokensMergerTestLanguage.g:203:2: (otherlv_2= 'ref' ( ( ruleFQN ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalHiddenTokensMergerTestLanguage.g:203:4: otherlv_2= 'ref' ( ( ruleFQN ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getDatatypeBug286557Access().getRefKeyword_2_0());
                        
                    // InternalHiddenTokensMergerTestLanguage.g:207:1: ( ( ruleFQN ) )
                    // InternalHiddenTokensMergerTestLanguage.g:208:1: ( ruleFQN )
                    {
                    // InternalHiddenTokensMergerTestLanguage.g:208:1: ( ruleFQN )
                    // InternalHiddenTokensMergerTestLanguage.g:209:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDatatypeBug286557Rule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getDatatypeBug286557Access().getRefDatatypeBug286557CrossReference_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_5);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_2); 

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
    // InternalHiddenTokensMergerTestLanguage.g:234:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:235:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalHiddenTokensMergerTestLanguage.g:236:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalHiddenTokensMergerTestLanguage.g:243:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:246:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalHiddenTokensMergerTestLanguage.g:247:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalHiddenTokensMergerTestLanguage.g:247:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalHiddenTokensMergerTestLanguage.g:247:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalHiddenTokensMergerTestLanguage.g:254:1: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalHiddenTokensMergerTestLanguage.g:255:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

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
    // InternalHiddenTokensMergerTestLanguage.g:275:1: entryRuleEnumBug returns [EObject current=null] : iv_ruleEnumBug= ruleEnumBug EOF ;
    public final EObject entryRuleEnumBug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumBug = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:276:2: (iv_ruleEnumBug= ruleEnumBug EOF )
            // InternalHiddenTokensMergerTestLanguage.g:277:2: iv_ruleEnumBug= ruleEnumBug EOF
            {
             newCompositeNode(grammarAccess.getEnumBugRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumBug=ruleEnumBug();

            state._fsp--;

             current =iv_ruleEnumBug; 
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
    // $ANTLR end "entryRuleEnumBug"


    // $ANTLR start "ruleEnumBug"
    // InternalHiddenTokensMergerTestLanguage.g:284:1: ruleEnumBug returns [EObject current=null] : (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleEnumBug() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_3_0=null;
        Enumerator lv_return_2_0 = null;


         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:287:28: ( (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalHiddenTokensMergerTestLanguage.g:288:1: (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalHiddenTokensMergerTestLanguage.g:288:1: (otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // InternalHiddenTokensMergerTestLanguage.g:288:3: otherlv_0= '#2' otherlv_1= 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getEnumBugAccess().getNumberSignDigitTwoKeyword_0());
                
            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_1, grammarAccess.getEnumBugAccess().getKw1Keyword_1());
                
            // InternalHiddenTokensMergerTestLanguage.g:296:1: ( (lv_return_2_0= ruleEnumBugEnum ) )
            // InternalHiddenTokensMergerTestLanguage.g:297:1: (lv_return_2_0= ruleEnumBugEnum )
            {
            // InternalHiddenTokensMergerTestLanguage.g:297:1: (lv_return_2_0= ruleEnumBugEnum )
            // InternalHiddenTokensMergerTestLanguage.g:298:3: lv_return_2_0= ruleEnumBugEnum
            {
             
            	        newCompositeNode(grammarAccess.getEnumBugAccess().getReturnEnumBugEnumEnumRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_3);
            lv_return_2_0=ruleEnumBugEnum();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEnumBugRule());
            	        }
                   		set(
                   			current, 
                   			"return",
                    		lv_return_2_0, 
                    		"org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage.EnumBugEnum");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalHiddenTokensMergerTestLanguage.g:314:2: ( (lv_name_3_0= RULE_ID ) )
            // InternalHiddenTokensMergerTestLanguage.g:315:1: (lv_name_3_0= RULE_ID )
            {
            // InternalHiddenTokensMergerTestLanguage.g:315:1: (lv_name_3_0= RULE_ID )
            // InternalHiddenTokensMergerTestLanguage.g:316:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_3_0, grammarAccess.getEnumBugAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumBugRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
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
    // $ANTLR end "ruleEnumBug"


    // $ANTLR start "entryRuleCommentable"
    // InternalHiddenTokensMergerTestLanguage.g:340:1: entryRuleCommentable returns [EObject current=null] : iv_ruleCommentable= ruleCommentable EOF ;
    public final EObject entryRuleCommentable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentable = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:341:2: (iv_ruleCommentable= ruleCommentable EOF )
            // InternalHiddenTokensMergerTestLanguage.g:342:2: iv_ruleCommentable= ruleCommentable EOF
            {
             newCompositeNode(grammarAccess.getCommentableRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCommentable=ruleCommentable();

            state._fsp--;

             current =iv_ruleCommentable; 
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
    // $ANTLR end "entryRuleCommentable"


    // $ANTLR start "ruleCommentable"
    // InternalHiddenTokensMergerTestLanguage.g:349:1: ruleCommentable returns [EObject current=null] : (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) ;
    public final EObject ruleCommentable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_item_1_0 = null;


         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:352:28: ( (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) )
            // InternalHiddenTokensMergerTestLanguage.g:353:1: (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            {
            // InternalHiddenTokensMergerTestLanguage.g:353:1: (otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            // InternalHiddenTokensMergerTestLanguage.g:353:3: otherlv_0= '#3' ( (lv_item_1_0= ruleCommentableItem ) )*
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_0, grammarAccess.getCommentableAccess().getNumberSignDigitThreeKeyword_0());
                
            // InternalHiddenTokensMergerTestLanguage.g:357:1: ( (lv_item_1_0= ruleCommentableItem ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalHiddenTokensMergerTestLanguage.g:358:1: (lv_item_1_0= ruleCommentableItem )
            	    {
            	    // InternalHiddenTokensMergerTestLanguage.g:358:1: (lv_item_1_0= ruleCommentableItem )
            	    // InternalHiddenTokensMergerTestLanguage.g:359:3: lv_item_1_0= ruleCommentableItem
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCommentableAccess().getItemCommentableItemParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    lv_item_1_0=ruleCommentableItem();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCommentableRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"item",
            	            		lv_item_1_0, 
            	            		"org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage.CommentableItem");
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
    // InternalHiddenTokensMergerTestLanguage.g:383:1: entryRuleCommentableItem returns [EObject current=null] : iv_ruleCommentableItem= ruleCommentableItem EOF ;
    public final EObject entryRuleCommentableItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentableItem = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:384:2: (iv_ruleCommentableItem= ruleCommentableItem EOF )
            // InternalHiddenTokensMergerTestLanguage.g:385:2: iv_ruleCommentableItem= ruleCommentableItem EOF
            {
             newCompositeNode(grammarAccess.getCommentableItemRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCommentableItem=ruleCommentableItem();

            state._fsp--;

             current =iv_ruleCommentableItem; 
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
    // $ANTLR end "entryRuleCommentableItem"


    // $ANTLR start "ruleCommentableItem"
    // InternalHiddenTokensMergerTestLanguage.g:392:1: ruleCommentableItem returns [EObject current=null] : (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) ) ;
    public final EObject ruleCommentableItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;

         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:395:28: ( (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) ) )
            // InternalHiddenTokensMergerTestLanguage.g:396:1: (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) )
            {
            // InternalHiddenTokensMergerTestLanguage.g:396:1: (otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) ) )
            // InternalHiddenTokensMergerTestLanguage.g:396:3: otherlv_0= 'item' ( (lv_id_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getCommentableItemAccess().getItemKeyword_0());
                
            // InternalHiddenTokensMergerTestLanguage.g:400:1: ( (lv_id_1_0= RULE_ID ) )
            // InternalHiddenTokensMergerTestLanguage.g:401:1: (lv_id_1_0= RULE_ID )
            {
            // InternalHiddenTokensMergerTestLanguage.g:401:1: (lv_id_1_0= RULE_ID )
            // InternalHiddenTokensMergerTestLanguage.g:402:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_id_1_0, grammarAccess.getCommentableItemAccess().getIdIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCommentableItemRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
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
    // $ANTLR end "ruleCommentableItem"


    // $ANTLR start "entryRuleValueList"
    // InternalHiddenTokensMergerTestLanguage.g:426:1: entryRuleValueList returns [EObject current=null] : iv_ruleValueList= ruleValueList EOF ;
    public final EObject entryRuleValueList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueList = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:427:2: (iv_ruleValueList= ruleValueList EOF )
            // InternalHiddenTokensMergerTestLanguage.g:428:2: iv_ruleValueList= ruleValueList EOF
            {
             newCompositeNode(grammarAccess.getValueListRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValueList=ruleValueList();

            state._fsp--;

             current =iv_ruleValueList; 
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
    // $ANTLR end "entryRuleValueList"


    // $ANTLR start "ruleValueList"
    // InternalHiddenTokensMergerTestLanguage.g:435:1: ruleValueList returns [EObject current=null] : (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* ) ;
    public final EObject ruleValueList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_ids_1_0 = null;


         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:438:28: ( (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* ) )
            // InternalHiddenTokensMergerTestLanguage.g:439:1: (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            {
            // InternalHiddenTokensMergerTestLanguage.g:439:1: (otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            // InternalHiddenTokensMergerTestLanguage.g:439:3: otherlv_0= '#4' ( (lv_ids_1_0= ruleFQN ) )*
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getValueListAccess().getNumberSignDigitFourKeyword_0());
                
            // InternalHiddenTokensMergerTestLanguage.g:443:1: ( (lv_ids_1_0= ruleFQN ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalHiddenTokensMergerTestLanguage.g:444:1: (lv_ids_1_0= ruleFQN )
            	    {
            	    // InternalHiddenTokensMergerTestLanguage.g:444:1: (lv_ids_1_0= ruleFQN )
            	    // InternalHiddenTokensMergerTestLanguage.g:445:3: lv_ids_1_0= ruleFQN
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getValueListAccess().getIdsFQNParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    lv_ids_1_0=ruleFQN();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getValueListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ids",
            	            		lv_ids_1_0, 
            	            		"org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage.FQN");
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
    // InternalHiddenTokensMergerTestLanguage.g:469:1: entryRuleRefList returns [EObject current=null] : iv_ruleRefList= ruleRefList EOF ;
    public final EObject entryRuleRefList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefList = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:470:2: (iv_ruleRefList= ruleRefList EOF )
            // InternalHiddenTokensMergerTestLanguage.g:471:2: iv_ruleRefList= ruleRefList EOF
            {
             newCompositeNode(grammarAccess.getRefListRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRefList=ruleRefList();

            state._fsp--;

             current =iv_ruleRefList; 
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
    // $ANTLR end "entryRuleRefList"


    // $ANTLR start "ruleRefList"
    // InternalHiddenTokensMergerTestLanguage.g:478:1: ruleRefList returns [EObject current=null] : (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* ) ;
    public final EObject ruleRefList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_objs_1_0 = null;


         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:481:28: ( (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* ) )
            // InternalHiddenTokensMergerTestLanguage.g:482:1: (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* )
            {
            // InternalHiddenTokensMergerTestLanguage.g:482:1: (otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )* )
            // InternalHiddenTokensMergerTestLanguage.g:482:3: otherlv_0= '#5' ( (lv_objs_1_0= ruleRefObj ) )* otherlv_2= 'refs' ( ( ruleFQN ) )*
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_11); 

                	newLeafNode(otherlv_0, grammarAccess.getRefListAccess().getNumberSignDigitFiveKeyword_0());
                
            // InternalHiddenTokensMergerTestLanguage.g:486:1: ( (lv_objs_1_0= ruleRefObj ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalHiddenTokensMergerTestLanguage.g:487:1: (lv_objs_1_0= ruleRefObj )
            	    {
            	    // InternalHiddenTokensMergerTestLanguage.g:487:1: (lv_objs_1_0= ruleRefObj )
            	    // InternalHiddenTokensMergerTestLanguage.g:488:3: lv_objs_1_0= ruleRefObj
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRefListAccess().getObjsRefObjParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_objs_1_0=ruleRefObj();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRefListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"objs",
            	            		lv_objs_1_0, 
            	            		"org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage.RefObj");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_2, grammarAccess.getRefListAccess().getRefsKeyword_2());
                
            // InternalHiddenTokensMergerTestLanguage.g:508:1: ( ( ruleFQN ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalHiddenTokensMergerTestLanguage.g:509:1: ( ruleFQN )
            	    {
            	    // InternalHiddenTokensMergerTestLanguage.g:509:1: ( ruleFQN )
            	    // InternalHiddenTokensMergerTestLanguage.g:510:3: ruleFQN
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRefListRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRefListAccess().getRefsRefObjCrossReference_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_10);
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
    // InternalHiddenTokensMergerTestLanguage.g:531:1: entryRuleRefObj returns [EObject current=null] : iv_ruleRefObj= ruleRefObj EOF ;
    public final EObject entryRuleRefObj() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefObj = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:532:2: (iv_ruleRefObj= ruleRefObj EOF )
            // InternalHiddenTokensMergerTestLanguage.g:533:2: iv_ruleRefObj= ruleRefObj EOF
            {
             newCompositeNode(grammarAccess.getRefObjRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRefObj=ruleRefObj();

            state._fsp--;

             current =iv_ruleRefObj; 
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
    // $ANTLR end "entryRuleRefObj"


    // $ANTLR start "ruleRefObj"
    // InternalHiddenTokensMergerTestLanguage.g:540:1: ruleRefObj returns [EObject current=null] : ( (lv_name_0_0= ruleFQN ) ) ;
    public final EObject ruleRefObj() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:543:28: ( ( (lv_name_0_0= ruleFQN ) ) )
            // InternalHiddenTokensMergerTestLanguage.g:544:1: ( (lv_name_0_0= ruleFQN ) )
            {
            // InternalHiddenTokensMergerTestLanguage.g:544:1: ( (lv_name_0_0= ruleFQN ) )
            // InternalHiddenTokensMergerTestLanguage.g:545:1: (lv_name_0_0= ruleFQN )
            {
            // InternalHiddenTokensMergerTestLanguage.g:545:1: (lv_name_0_0= ruleFQN )
            // InternalHiddenTokensMergerTestLanguage.g:546:3: lv_name_0_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getRefObjAccess().getNameFQNParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_name_0_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRefObjRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage.FQN");
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
    // InternalHiddenTokensMergerTestLanguage.g:570:1: entryRuleSingleRef returns [EObject current=null] : iv_ruleSingleRef= ruleSingleRef EOF ;
    public final EObject entryRuleSingleRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleRef = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:571:2: (iv_ruleSingleRef= ruleSingleRef EOF )
            // InternalHiddenTokensMergerTestLanguage.g:572:2: iv_ruleSingleRef= ruleSingleRef EOF
            {
             newCompositeNode(grammarAccess.getSingleRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleRef=ruleSingleRef();

            state._fsp--;

             current =iv_ruleSingleRef; 
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
    // $ANTLR end "entryRuleSingleRef"


    // $ANTLR start "ruleSingleRef"
    // InternalHiddenTokensMergerTestLanguage.g:579:1: ruleSingleRef returns [EObject current=null] : (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSingleRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_obj_1_0 = null;


         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:582:28: ( (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) ) )
            // InternalHiddenTokensMergerTestLanguage.g:583:1: (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) )
            {
            // InternalHiddenTokensMergerTestLanguage.g:583:1: (otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) ) )
            // InternalHiddenTokensMergerTestLanguage.g:583:3: otherlv_0= '#6' ( (lv_obj_1_0= ruleRefObj ) ) otherlv_2= 'ref' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSingleRefAccess().getNumberSignDigitSixKeyword_0());
                
            // InternalHiddenTokensMergerTestLanguage.g:587:1: ( (lv_obj_1_0= ruleRefObj ) )
            // InternalHiddenTokensMergerTestLanguage.g:588:1: (lv_obj_1_0= ruleRefObj )
            {
            // InternalHiddenTokensMergerTestLanguage.g:588:1: (lv_obj_1_0= ruleRefObj )
            // InternalHiddenTokensMergerTestLanguage.g:589:3: lv_obj_1_0= ruleRefObj
            {
             
            	        newCompositeNode(grammarAccess.getSingleRefAccess().getObjRefObjParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_12);
            lv_obj_1_0=ruleRefObj();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSingleRefRule());
            	        }
                   		set(
                   			current, 
                   			"obj",
                    		lv_obj_1_0, 
                    		"org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage.RefObj");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSingleRefAccess().getRefKeyword_2());
                
            // InternalHiddenTokensMergerTestLanguage.g:609:1: ( ( ruleFQN ) )
            // InternalHiddenTokensMergerTestLanguage.g:610:1: ( ruleFQN )
            {
            // InternalHiddenTokensMergerTestLanguage.g:610:1: ( ruleFQN )
            // InternalHiddenTokensMergerTestLanguage.g:611:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSingleRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSingleRefAccess().getRefRefObjCrossReference_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalHiddenTokensMergerTestLanguage.g:632:1: entryRuleAppendToFileEnd returns [EObject current=null] : iv_ruleAppendToFileEnd= ruleAppendToFileEnd EOF ;
    public final EObject entryRuleAppendToFileEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAppendToFileEnd = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:633:2: (iv_ruleAppendToFileEnd= ruleAppendToFileEnd EOF )
            // InternalHiddenTokensMergerTestLanguage.g:634:2: iv_ruleAppendToFileEnd= ruleAppendToFileEnd EOF
            {
             newCompositeNode(grammarAccess.getAppendToFileEndRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAppendToFileEnd=ruleAppendToFileEnd();

            state._fsp--;

             current =iv_ruleAppendToFileEnd; 
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
    // $ANTLR end "entryRuleAppendToFileEnd"


    // $ANTLR start "ruleAppendToFileEnd"
    // InternalHiddenTokensMergerTestLanguage.g:641:1: ruleAppendToFileEnd returns [EObject current=null] : (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* ) ;
    public final EObject ruleAppendToFileEnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_items_1_0 = null;


         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:644:28: ( (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* ) )
            // InternalHiddenTokensMergerTestLanguage.g:645:1: (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* )
            {
            // InternalHiddenTokensMergerTestLanguage.g:645:1: (otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* )
            // InternalHiddenTokensMergerTestLanguage.g:645:3: otherlv_0= '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )*
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_13); 

                	newLeafNode(otherlv_0, grammarAccess.getAppendToFileEndAccess().getNumberSignDigitSevenKeyword_0());
                
            // InternalHiddenTokensMergerTestLanguage.g:649:1: ( (lv_items_1_0= ruleAppendToFileEndItem ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalHiddenTokensMergerTestLanguage.g:650:1: (lv_items_1_0= ruleAppendToFileEndItem )
            	    {
            	    // InternalHiddenTokensMergerTestLanguage.g:650:1: (lv_items_1_0= ruleAppendToFileEndItem )
            	    // InternalHiddenTokensMergerTestLanguage.g:651:3: lv_items_1_0= ruleAppendToFileEndItem
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAppendToFileEndAccess().getItemsAppendToFileEndItemParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_13);
            	    lv_items_1_0=ruleAppendToFileEndItem();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAppendToFileEndRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"items",
            	            		lv_items_1_0, 
            	            		"org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage.AppendToFileEndItem");
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
    // InternalHiddenTokensMergerTestLanguage.g:675:1: entryRuleAppendToFileEndItem returns [EObject current=null] : iv_ruleAppendToFileEndItem= ruleAppendToFileEndItem EOF ;
    public final EObject entryRuleAppendToFileEndItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAppendToFileEndItem = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:676:2: (iv_ruleAppendToFileEndItem= ruleAppendToFileEndItem EOF )
            // InternalHiddenTokensMergerTestLanguage.g:677:2: iv_ruleAppendToFileEndItem= ruleAppendToFileEndItem EOF
            {
             newCompositeNode(grammarAccess.getAppendToFileEndItemRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAppendToFileEndItem=ruleAppendToFileEndItem();

            state._fsp--;

             current =iv_ruleAppendToFileEndItem; 
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
    // $ANTLR end "entryRuleAppendToFileEndItem"


    // $ANTLR start "ruleAppendToFileEndItem"
    // InternalHiddenTokensMergerTestLanguage.g:684:1: ruleAppendToFileEndItem returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' ) ;
    public final EObject ruleAppendToFileEndItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:687:28: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' ) )
            // InternalHiddenTokensMergerTestLanguage.g:688:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' )
            {
            // InternalHiddenTokensMergerTestLanguage.g:688:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass' )
            // InternalHiddenTokensMergerTestLanguage.g:688:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'endclass'
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAppendToFileEndItemAccess().getClassKeyword_0());
                
            // InternalHiddenTokensMergerTestLanguage.g:692:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalHiddenTokensMergerTestLanguage.g:693:1: (lv_name_1_0= RULE_ID )
            {
            // InternalHiddenTokensMergerTestLanguage.g:693:1: (lv_name_1_0= RULE_ID )
            // InternalHiddenTokensMergerTestLanguage.g:694:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAppendToFileEndItemAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAppendToFileEndItemRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_2); 

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
    // InternalHiddenTokensMergerTestLanguage.g:722:1: entryRuleAction1 returns [EObject current=null] : iv_ruleAction1= ruleAction1 EOF ;
    public final EObject entryRuleAction1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction1 = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:723:2: (iv_ruleAction1= ruleAction1 EOF )
            // InternalHiddenTokensMergerTestLanguage.g:724:2: iv_ruleAction1= ruleAction1 EOF
            {
             newCompositeNode(grammarAccess.getAction1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAction1=ruleAction1();

            state._fsp--;

             current =iv_ruleAction1; 
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
    // $ANTLR end "entryRuleAction1"


    // $ANTLR start "ruleAction1"
    // InternalHiddenTokensMergerTestLanguage.g:731:1: ruleAction1 returns [EObject current=null] : (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) ) ;
    public final EObject ruleAction1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        EObject lv_actions2_3_0 = null;

        EObject lv_actions2_4_0 = null;


         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:734:28: ( (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) ) )
            // InternalHiddenTokensMergerTestLanguage.g:735:1: (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) )
            {
            // InternalHiddenTokensMergerTestLanguage.g:735:1: (otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) ) )
            // InternalHiddenTokensMergerTestLanguage.g:735:3: otherlv_0= '#8' () ( (lv_name_2_0= RULE_ID ) ) ( (lv_actions2_3_0= ruleAction1Sub1 ) ) ( (lv_actions2_4_0= ruleAction1Sub2 ) )
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getAction1Access().getNumberSignDigitEightKeyword_0());
                
            // InternalHiddenTokensMergerTestLanguage.g:739:1: ()
            // InternalHiddenTokensMergerTestLanguage.g:740:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAction1Access().getAction1Action_1(),
                        current);
                

            }

            // InternalHiddenTokensMergerTestLanguage.g:745:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalHiddenTokensMergerTestLanguage.g:746:1: (lv_name_2_0= RULE_ID )
            {
            // InternalHiddenTokensMergerTestLanguage.g:746:1: (lv_name_2_0= RULE_ID )
            // InternalHiddenTokensMergerTestLanguage.g:747:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

            			newLeafNode(lv_name_2_0, grammarAccess.getAction1Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAction1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalHiddenTokensMergerTestLanguage.g:763:2: ( (lv_actions2_3_0= ruleAction1Sub1 ) )
            // InternalHiddenTokensMergerTestLanguage.g:764:1: (lv_actions2_3_0= ruleAction1Sub1 )
            {
            // InternalHiddenTokensMergerTestLanguage.g:764:1: (lv_actions2_3_0= ruleAction1Sub1 )
            // InternalHiddenTokensMergerTestLanguage.g:765:3: lv_actions2_3_0= ruleAction1Sub1
            {
             
            	        newCompositeNode(grammarAccess.getAction1Access().getActions2Action1Sub1ParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_16);
            lv_actions2_3_0=ruleAction1Sub1();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAction1Rule());
            	        }
                   		add(
                   			current, 
                   			"actions2",
                    		lv_actions2_3_0, 
                    		"org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage.Action1Sub1");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalHiddenTokensMergerTestLanguage.g:781:2: ( (lv_actions2_4_0= ruleAction1Sub2 ) )
            // InternalHiddenTokensMergerTestLanguage.g:782:1: (lv_actions2_4_0= ruleAction1Sub2 )
            {
            // InternalHiddenTokensMergerTestLanguage.g:782:1: (lv_actions2_4_0= ruleAction1Sub2 )
            // InternalHiddenTokensMergerTestLanguage.g:783:3: lv_actions2_4_0= ruleAction1Sub2
            {
             
            	        newCompositeNode(grammarAccess.getAction1Access().getActions2Action1Sub2ParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_actions2_4_0=ruleAction1Sub2();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAction1Rule());
            	        }
                   		add(
                   			current, 
                   			"actions2",
                    		lv_actions2_4_0, 
                    		"org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage.Action1Sub2");
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
    // InternalHiddenTokensMergerTestLanguage.g:807:1: entryRuleAction1Sub1 returns [EObject current=null] : iv_ruleAction1Sub1= ruleAction1Sub1 EOF ;
    public final EObject entryRuleAction1Sub1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction1Sub1 = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:808:2: (iv_ruleAction1Sub1= ruleAction1Sub1 EOF )
            // InternalHiddenTokensMergerTestLanguage.g:809:2: iv_ruleAction1Sub1= ruleAction1Sub1 EOF
            {
             newCompositeNode(grammarAccess.getAction1Sub1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAction1Sub1=ruleAction1Sub1();

            state._fsp--;

             current =iv_ruleAction1Sub1; 
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
    // $ANTLR end "entryRuleAction1Sub1"


    // $ANTLR start "ruleAction1Sub1"
    // InternalHiddenTokensMergerTestLanguage.g:816:1: ruleAction1Sub1 returns [EObject current=null] : ( () otherlv_1= 'sub1' ) ;
    public final EObject ruleAction1Sub1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:819:28: ( ( () otherlv_1= 'sub1' ) )
            // InternalHiddenTokensMergerTestLanguage.g:820:1: ( () otherlv_1= 'sub1' )
            {
            // InternalHiddenTokensMergerTestLanguage.g:820:1: ( () otherlv_1= 'sub1' )
            // InternalHiddenTokensMergerTestLanguage.g:820:2: () otherlv_1= 'sub1'
            {
            // InternalHiddenTokensMergerTestLanguage.g:820:2: ()
            // InternalHiddenTokensMergerTestLanguage.g:821:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAction1Sub1Access().getAction1SubAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_2); 

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
    // InternalHiddenTokensMergerTestLanguage.g:838:1: entryRuleAction1Sub2 returns [EObject current=null] : iv_ruleAction1Sub2= ruleAction1Sub2 EOF ;
    public final EObject entryRuleAction1Sub2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction1Sub2 = null;


        try {
            // InternalHiddenTokensMergerTestLanguage.g:839:2: (iv_ruleAction1Sub2= ruleAction1Sub2 EOF )
            // InternalHiddenTokensMergerTestLanguage.g:840:2: iv_ruleAction1Sub2= ruleAction1Sub2 EOF
            {
             newCompositeNode(grammarAccess.getAction1Sub2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAction1Sub2=ruleAction1Sub2();

            state._fsp--;

             current =iv_ruleAction1Sub2; 
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
    // $ANTLR end "entryRuleAction1Sub2"


    // $ANTLR start "ruleAction1Sub2"
    // InternalHiddenTokensMergerTestLanguage.g:847:1: ruleAction1Sub2 returns [EObject current=null] : ( () otherlv_1= 'sub2' ) ;
    public final EObject ruleAction1Sub2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalHiddenTokensMergerTestLanguage.g:850:28: ( ( () otherlv_1= 'sub2' ) )
            // InternalHiddenTokensMergerTestLanguage.g:851:1: ( () otherlv_1= 'sub2' )
            {
            // InternalHiddenTokensMergerTestLanguage.g:851:1: ( () otherlv_1= 'sub2' )
            // InternalHiddenTokensMergerTestLanguage.g:851:2: () otherlv_1= 'sub2'
            {
            // InternalHiddenTokensMergerTestLanguage.g:851:2: ()
            // InternalHiddenTokensMergerTestLanguage.g:852:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAction1Sub2Access().getAction1SubClassAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_2); 

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
    // InternalHiddenTokensMergerTestLanguage.g:869:1: ruleEnumBugEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) ) ;
    public final Enumerator ruleEnumBugEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalHiddenTokensMergerTestLanguage.g:871:28: ( ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) ) )
            // InternalHiddenTokensMergerTestLanguage.g:872:1: ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) )
            {
            // InternalHiddenTokensMergerTestLanguage.g:872:1: ( (enumLiteral_0= 'array' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'resultSet' ) | (enumLiteral_3= 'iterator' ) )
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
                    // InternalHiddenTokensMergerTestLanguage.g:872:2: (enumLiteral_0= 'array' )
                    {
                    // InternalHiddenTokensMergerTestLanguage.g:872:2: (enumLiteral_0= 'array' )
                    // InternalHiddenTokensMergerTestLanguage.g:872:4: enumLiteral_0= 'array'
                    {
                    enumLiteral_0=(Token)match(input,29,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumBugEnumAccess().getArrayEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEnumBugEnumAccess().getArrayEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalHiddenTokensMergerTestLanguage.g:878:6: (enumLiteral_1= 'object' )
                    {
                    // InternalHiddenTokensMergerTestLanguage.g:878:6: (enumLiteral_1= 'object' )
                    // InternalHiddenTokensMergerTestLanguage.g:878:8: enumLiteral_1= 'object'
                    {
                    enumLiteral_1=(Token)match(input,30,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumBugEnumAccess().getObjectEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getEnumBugEnumAccess().getObjectEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalHiddenTokensMergerTestLanguage.g:884:6: (enumLiteral_2= 'resultSet' )
                    {
                    // InternalHiddenTokensMergerTestLanguage.g:884:6: (enumLiteral_2= 'resultSet' )
                    // InternalHiddenTokensMergerTestLanguage.g:884:8: enumLiteral_2= 'resultSet'
                    {
                    enumLiteral_2=(Token)match(input,31,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumBugEnumAccess().getResultSetEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getEnumBugEnumAccess().getResultSetEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalHiddenTokensMergerTestLanguage.g:890:6: (enumLiteral_3= 'iterator' )
                    {
                    // InternalHiddenTokensMergerTestLanguage.g:890:6: (enumLiteral_3= 'iterator' )
                    // InternalHiddenTokensMergerTestLanguage.g:890:8: enumLiteral_3= 'iterator'
                    {
                    enumLiteral_3=(Token)match(input,32,FollowSets000.FOLLOW_2); 

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000001E0000000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000010000000L});
    }


}