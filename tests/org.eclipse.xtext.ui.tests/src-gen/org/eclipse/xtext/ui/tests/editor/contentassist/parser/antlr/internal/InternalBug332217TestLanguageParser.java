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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug332217TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug332217TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'[]'", "'.'", "'('", "')'", "'replace('", "','", "'urlconform('", "'['", "']'", "'split('", "'tableview'", "'{'", "'title:'", "'titleImage:'", "'style:'", "'}'", "'section'", "'cell'", "'text:'", "'details:'", "'image:'", "'action:'", "'accessory:'", "'for'", "'in'", "':'", "'@selector'", "'Plain'", "'Grouped'", "'Default'", "'Value1'", "'Value2'", "'Subtitle'", "'None'", "'Link'", "'Detail'", "'Check'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=5;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalBug332217TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug332217TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug332217TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug332217TestLanguage.g"; }



     	private Bug332217TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug332217TestLanguageParser(TokenStream input, Bug332217TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug332217TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalBug332217TestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug332217TestLanguage.g:69:2: (iv_ruleModel= ruleModel EOF )
            // InternalBug332217TestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalBug332217TestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleTableView ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:80:28: ( ( (lv_elements_0_0= ruleTableView ) )* )
            // InternalBug332217TestLanguage.g:81:1: ( (lv_elements_0_0= ruleTableView ) )*
            {
            // InternalBug332217TestLanguage.g:81:1: ( (lv_elements_0_0= ruleTableView ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==21) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug332217TestLanguage.g:82:1: (lv_elements_0_0= ruleTableView )
            	    {
            	    // InternalBug332217TestLanguage.g:82:1: (lv_elements_0_0= ruleTableView )
            	    // InternalBug332217TestLanguage.g:83:3: lv_elements_0_0= ruleTableView
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getElementsTableViewParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_elements_0_0=ruleTableView();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_0_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.TableView");
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


    // $ANTLR start "entryRuleTypeDescription"
    // InternalBug332217TestLanguage.g:109:1: entryRuleTypeDescription returns [EObject current=null] : iv_ruleTypeDescription= ruleTypeDescription EOF ;
    public final EObject entryRuleTypeDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDescription = null;


        try {
            // InternalBug332217TestLanguage.g:110:2: (iv_ruleTypeDescription= ruleTypeDescription EOF )
            // InternalBug332217TestLanguage.g:111:2: iv_ruleTypeDescription= ruleTypeDescription EOF
            {
             newCompositeNode(grammarAccess.getTypeDescriptionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeDescription=ruleTypeDescription();

            state._fsp--;

             current =iv_ruleTypeDescription; 
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
    // $ANTLR end "entryRuleTypeDescription"


    // $ANTLR start "ruleTypeDescription"
    // InternalBug332217TestLanguage.g:118:1: ruleTypeDescription returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_many_1_0= '[]' ) )? ) ;
    public final EObject ruleTypeDescription() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_many_1_0=null;

         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:121:28: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_many_1_0= '[]' ) )? ) )
            // InternalBug332217TestLanguage.g:122:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_many_1_0= '[]' ) )? )
            {
            // InternalBug332217TestLanguage.g:122:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_many_1_0= '[]' ) )? )
            // InternalBug332217TestLanguage.g:122:2: ( (lv_type_0_0= RULE_ID ) ) ( (lv_many_1_0= '[]' ) )?
            {
            // InternalBug332217TestLanguage.g:122:2: ( (lv_type_0_0= RULE_ID ) )
            // InternalBug332217TestLanguage.g:123:1: (lv_type_0_0= RULE_ID )
            {
            // InternalBug332217TestLanguage.g:123:1: (lv_type_0_0= RULE_ID )
            // InternalBug332217TestLanguage.g:124:3: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            			newLeafNode(lv_type_0_0, grammarAccess.getTypeDescriptionAccess().getTypeIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeDescriptionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"type",
                    		lv_type_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalBug332217TestLanguage.g:140:2: ( (lv_many_1_0= '[]' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug332217TestLanguage.g:141:1: (lv_many_1_0= '[]' )
                    {
                    // InternalBug332217TestLanguage.g:141:1: (lv_many_1_0= '[]' )
                    // InternalBug332217TestLanguage.g:142:3: lv_many_1_0= '[]'
                    {
                    lv_many_1_0=(Token)match(input,11,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_many_1_0, grammarAccess.getTypeDescriptionAccess().getManyLeftSquareBracketRightSquareBracketKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeDescriptionRule());
                    	        }
                           		setWithLastConsumed(current, "many", true, "[]");
                    	    

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
    // $ANTLR end "ruleTypeDescription"


    // $ANTLR start "entryRuleParameter"
    // InternalBug332217TestLanguage.g:163:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalBug332217TestLanguage.g:164:2: (iv_ruleParameter= ruleParameter EOF )
            // InternalBug332217TestLanguage.g:165:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalBug332217TestLanguage.g:172:1: ruleParameter returns [EObject current=null] : ( ( (lv_description_0_0= ruleTypeDescription ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:175:28: ( ( ( (lv_description_0_0= ruleTypeDescription ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalBug332217TestLanguage.g:176:1: ( ( (lv_description_0_0= ruleTypeDescription ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalBug332217TestLanguage.g:176:1: ( ( (lv_description_0_0= ruleTypeDescription ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalBug332217TestLanguage.g:176:2: ( (lv_description_0_0= ruleTypeDescription ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalBug332217TestLanguage.g:176:2: ( (lv_description_0_0= ruleTypeDescription ) )
            // InternalBug332217TestLanguage.g:177:1: (lv_description_0_0= ruleTypeDescription )
            {
            // InternalBug332217TestLanguage.g:177:1: (lv_description_0_0= ruleTypeDescription )
            // InternalBug332217TestLanguage.g:178:3: lv_description_0_0= ruleTypeDescription
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getDescriptionTypeDescriptionParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_5);
            lv_description_0_0=ruleTypeDescription();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterRule());
            	        }
                   		set(
                   			current, 
                   			"description",
                    		lv_description_0_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.TypeDescription");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalBug332217TestLanguage.g:194:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalBug332217TestLanguage.g:195:1: (lv_name_1_0= RULE_ID )
            {
            // InternalBug332217TestLanguage.g:195:1: (lv_name_1_0= RULE_ID )
            // InternalBug332217TestLanguage.g:196:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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


    // $ANTLR start "entryRuleObjectReference"
    // InternalBug332217TestLanguage.g:220:1: entryRuleObjectReference returns [EObject current=null] : iv_ruleObjectReference= ruleObjectReference EOF ;
    public final EObject entryRuleObjectReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectReference = null;


        try {
            // InternalBug332217TestLanguage.g:221:2: (iv_ruleObjectReference= ruleObjectReference EOF )
            // InternalBug332217TestLanguage.g:222:2: iv_ruleObjectReference= ruleObjectReference EOF
            {
             newCompositeNode(grammarAccess.getObjectReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleObjectReference=ruleObjectReference();

            state._fsp--;

             current =iv_ruleObjectReference; 
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
    // $ANTLR end "entryRuleObjectReference"


    // $ANTLR start "ruleObjectReference"
    // InternalBug332217TestLanguage.g:229:1: ruleObjectReference returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_tail_1_0= ruleNestedObjectReference ) )? ) ;
    public final EObject ruleObjectReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_tail_1_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:232:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_tail_1_0= ruleNestedObjectReference ) )? ) )
            // InternalBug332217TestLanguage.g:233:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_tail_1_0= ruleNestedObjectReference ) )? )
            {
            // InternalBug332217TestLanguage.g:233:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_tail_1_0= ruleNestedObjectReference ) )? )
            // InternalBug332217TestLanguage.g:233:2: ( (otherlv_0= RULE_ID ) ) ( (lv_tail_1_0= ruleNestedObjectReference ) )?
            {
            // InternalBug332217TestLanguage.g:233:2: ( (otherlv_0= RULE_ID ) )
            // InternalBug332217TestLanguage.g:234:1: (otherlv_0= RULE_ID )
            {
            // InternalBug332217TestLanguage.g:234:1: (otherlv_0= RULE_ID )
            // InternalBug332217TestLanguage.g:235:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectReferenceRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            		newLeafNode(otherlv_0, grammarAccess.getObjectReferenceAccess().getObjectPropertyPathPartCrossReference_0_0()); 
            	

            }


            }

            // InternalBug332217TestLanguage.g:246:2: ( (lv_tail_1_0= ruleNestedObjectReference ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug332217TestLanguage.g:247:1: (lv_tail_1_0= ruleNestedObjectReference )
                    {
                    // InternalBug332217TestLanguage.g:247:1: (lv_tail_1_0= ruleNestedObjectReference )
                    // InternalBug332217TestLanguage.g:248:3: lv_tail_1_0= ruleNestedObjectReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getObjectReferenceAccess().getTailNestedObjectReferenceParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_tail_1_0=ruleNestedObjectReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getObjectReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"tail",
                            		lv_tail_1_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.NestedObjectReference");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleObjectReference"


    // $ANTLR start "entryRuleNestedObjectReference"
    // InternalBug332217TestLanguage.g:272:1: entryRuleNestedObjectReference returns [EObject current=null] : iv_ruleNestedObjectReference= ruleNestedObjectReference EOF ;
    public final EObject entryRuleNestedObjectReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedObjectReference = null;


        try {
            // InternalBug332217TestLanguage.g:273:2: (iv_ruleNestedObjectReference= ruleNestedObjectReference EOF )
            // InternalBug332217TestLanguage.g:274:2: iv_ruleNestedObjectReference= ruleNestedObjectReference EOF
            {
             newCompositeNode(grammarAccess.getNestedObjectReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedObjectReference=ruleNestedObjectReference();

            state._fsp--;

             current =iv_ruleNestedObjectReference; 
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
    // $ANTLR end "entryRuleNestedObjectReference"


    // $ANTLR start "ruleNestedObjectReference"
    // InternalBug332217TestLanguage.g:281:1: ruleNestedObjectReference returns [EObject current=null] : (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_tail_2_0= ruleNestedObjectReference ) )? ) ;
    public final EObject ruleNestedObjectReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_tail_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:284:28: ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_tail_2_0= ruleNestedObjectReference ) )? ) )
            // InternalBug332217TestLanguage.g:285:1: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_tail_2_0= ruleNestedObjectReference ) )? )
            {
            // InternalBug332217TestLanguage.g:285:1: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_tail_2_0= ruleNestedObjectReference ) )? )
            // InternalBug332217TestLanguage.g:285:3: otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_tail_2_0= ruleNestedObjectReference ) )?
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedObjectReferenceAccess().getFullStopKeyword_0());
                
            // InternalBug332217TestLanguage.g:289:1: ( (otherlv_1= RULE_ID ) )
            // InternalBug332217TestLanguage.g:290:1: (otherlv_1= RULE_ID )
            {
            // InternalBug332217TestLanguage.g:290:1: (otherlv_1= RULE_ID )
            // InternalBug332217TestLanguage.g:291:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNestedObjectReferenceRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            		newLeafNode(otherlv_1, grammarAccess.getNestedObjectReferenceAccess().getObjectPropertyPathPartCrossReference_1_0()); 
            	

            }


            }

            // InternalBug332217TestLanguage.g:302:2: ( (lv_tail_2_0= ruleNestedObjectReference ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug332217TestLanguage.g:303:1: (lv_tail_2_0= ruleNestedObjectReference )
                    {
                    // InternalBug332217TestLanguage.g:303:1: (lv_tail_2_0= ruleNestedObjectReference )
                    // InternalBug332217TestLanguage.g:304:3: lv_tail_2_0= ruleNestedObjectReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getNestedObjectReferenceAccess().getTailNestedObjectReferenceParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_tail_2_0=ruleNestedObjectReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNestedObjectReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"tail",
                            		lv_tail_2_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.NestedObjectReference");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleNestedObjectReference"


    // $ANTLR start "entryRuleImageExpression"
    // InternalBug332217TestLanguage.g:330:1: entryRuleImageExpression returns [EObject current=null] : iv_ruleImageExpression= ruleImageExpression EOF ;
    public final EObject entryRuleImageExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImageExpression = null;


        try {
            // InternalBug332217TestLanguage.g:331:2: (iv_ruleImageExpression= ruleImageExpression EOF )
            // InternalBug332217TestLanguage.g:332:2: iv_ruleImageExpression= ruleImageExpression EOF
            {
             newCompositeNode(grammarAccess.getImageExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleImageExpression=ruleImageExpression();

            state._fsp--;

             current =iv_ruleImageExpression; 
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
    // $ANTLR end "entryRuleImageExpression"


    // $ANTLR start "ruleImageExpression"
    // InternalBug332217TestLanguage.g:339:1: ruleImageExpression returns [EObject current=null] : this_ScalarExpression_0= ruleScalarExpression ;
    public final EObject ruleImageExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ScalarExpression_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:342:28: (this_ScalarExpression_0= ruleScalarExpression )
            // InternalBug332217TestLanguage.g:344:5: this_ScalarExpression_0= ruleScalarExpression
            {
             
                    newCompositeNode(grammarAccess.getImageExpressionAccess().getScalarExpressionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
            this_ScalarExpression_0=ruleScalarExpression();

            state._fsp--;

             
                    current = this_ScalarExpression_0; 
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleImageExpression"


    // $ANTLR start "entryRuleScalarExpression"
    // InternalBug332217TestLanguage.g:360:1: entryRuleScalarExpression returns [EObject current=null] : iv_ruleScalarExpression= ruleScalarExpression EOF ;
    public final EObject entryRuleScalarExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarExpression = null;


        try {
            // InternalBug332217TestLanguage.g:361:2: (iv_ruleScalarExpression= ruleScalarExpression EOF )
            // InternalBug332217TestLanguage.g:362:2: iv_ruleScalarExpression= ruleScalarExpression EOF
            {
             newCompositeNode(grammarAccess.getScalarExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScalarExpression=ruleScalarExpression();

            state._fsp--;

             current =iv_ruleScalarExpression; 
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
    // $ANTLR end "entryRuleScalarExpression"


    // $ANTLR start "ruleScalarExpression"
    // InternalBug332217TestLanguage.g:369:1: ruleScalarExpression returns [EObject current=null] : (this_StringLiteral_0= ruleStringLiteral | this_StringFunction_1= ruleStringFunction | this_ObjectReference_2= ruleObjectReference ) ;
    public final EObject ruleScalarExpression() throws RecognitionException {
        EObject current = null;

        EObject this_StringLiteral_0 = null;

        EObject this_StringFunction_1 = null;

        EObject this_ObjectReference_2 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:372:28: ( (this_StringLiteral_0= ruleStringLiteral | this_StringFunction_1= ruleStringFunction | this_ObjectReference_2= ruleObjectReference ) )
            // InternalBug332217TestLanguage.g:373:1: (this_StringLiteral_0= ruleStringLiteral | this_StringFunction_1= ruleStringFunction | this_ObjectReference_2= ruleObjectReference )
            {
            // InternalBug332217TestLanguage.g:373:1: (this_StringLiteral_0= ruleStringLiteral | this_StringFunction_1= ruleStringFunction | this_ObjectReference_2= ruleObjectReference )
            int alt5=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt5=1;
                }
                break;
            case 13:
            case 15:
            case 17:
                {
                alt5=2;
                }
                break;
            case RULE_ID:
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
                    // InternalBug332217TestLanguage.g:374:5: this_StringLiteral_0= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getScalarExpressionAccess().getStringLiteralParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_StringLiteral_0=ruleStringLiteral();

                    state._fsp--;

                     
                            current = this_StringLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalBug332217TestLanguage.g:384:5: this_StringFunction_1= ruleStringFunction
                    {
                     
                            newCompositeNode(grammarAccess.getScalarExpressionAccess().getStringFunctionParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_StringFunction_1=ruleStringFunction();

                    state._fsp--;

                     
                            current = this_StringFunction_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalBug332217TestLanguage.g:394:5: this_ObjectReference_2= ruleObjectReference
                    {
                     
                            newCompositeNode(grammarAccess.getScalarExpressionAccess().getObjectReferenceParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ObjectReference_2=ruleObjectReference();

                    state._fsp--;

                     
                            current = this_ObjectReference_2; 
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
    // $ANTLR end "ruleScalarExpression"


    // $ANTLR start "entryRuleCollectionExpression"
    // InternalBug332217TestLanguage.g:410:1: entryRuleCollectionExpression returns [EObject current=null] : iv_ruleCollectionExpression= ruleCollectionExpression EOF ;
    public final EObject entryRuleCollectionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionExpression = null;


        try {
            // InternalBug332217TestLanguage.g:411:2: (iv_ruleCollectionExpression= ruleCollectionExpression EOF )
            // InternalBug332217TestLanguage.g:412:2: iv_ruleCollectionExpression= ruleCollectionExpression EOF
            {
             newCompositeNode(grammarAccess.getCollectionExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionExpression=ruleCollectionExpression();

            state._fsp--;

             current =iv_ruleCollectionExpression; 
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
    // $ANTLR end "entryRuleCollectionExpression"


    // $ANTLR start "ruleCollectionExpression"
    // InternalBug332217TestLanguage.g:419:1: ruleCollectionExpression returns [EObject current=null] : (this_CollectionLiteral_0= ruleCollectionLiteral | this_CollectionFunction_1= ruleCollectionFunction | this_ObjectReference_2= ruleObjectReference ) ;
    public final EObject ruleCollectionExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CollectionLiteral_0 = null;

        EObject this_CollectionFunction_1 = null;

        EObject this_ObjectReference_2 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:422:28: ( (this_CollectionLiteral_0= ruleCollectionLiteral | this_CollectionFunction_1= ruleCollectionFunction | this_ObjectReference_2= ruleObjectReference ) )
            // InternalBug332217TestLanguage.g:423:1: (this_CollectionLiteral_0= ruleCollectionLiteral | this_CollectionFunction_1= ruleCollectionFunction | this_ObjectReference_2= ruleObjectReference )
            {
            // InternalBug332217TestLanguage.g:423:1: (this_CollectionLiteral_0= ruleCollectionLiteral | this_CollectionFunction_1= ruleCollectionFunction | this_ObjectReference_2= ruleObjectReference )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt6=1;
                }
                break;
            case 20:
                {
                alt6=2;
                }
                break;
            case RULE_ID:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalBug332217TestLanguage.g:424:5: this_CollectionLiteral_0= ruleCollectionLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getCollectionExpressionAccess().getCollectionLiteralParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CollectionLiteral_0=ruleCollectionLiteral();

                    state._fsp--;

                     
                            current = this_CollectionLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalBug332217TestLanguage.g:434:5: this_CollectionFunction_1= ruleCollectionFunction
                    {
                     
                            newCompositeNode(grammarAccess.getCollectionExpressionAccess().getCollectionFunctionParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CollectionFunction_1=ruleCollectionFunction();

                    state._fsp--;

                     
                            current = this_CollectionFunction_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalBug332217TestLanguage.g:444:5: this_ObjectReference_2= ruleObjectReference
                    {
                     
                            newCompositeNode(grammarAccess.getCollectionExpressionAccess().getObjectReferenceParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ObjectReference_2=ruleObjectReference();

                    state._fsp--;

                     
                            current = this_ObjectReference_2; 
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
    // $ANTLR end "ruleCollectionExpression"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalBug332217TestLanguage.g:460:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalBug332217TestLanguage.g:461:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalBug332217TestLanguage.g:462:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
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
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalBug332217TestLanguage.g:469:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:472:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalBug332217TestLanguage.g:473:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalBug332217TestLanguage.g:473:1: ( (lv_value_0_0= RULE_STRING ) )
            // InternalBug332217TestLanguage.g:474:1: (lv_value_0_0= RULE_STRING )
            {
            // InternalBug332217TestLanguage.g:474:1: (lv_value_0_0= RULE_STRING )
            // InternalBug332217TestLanguage.g:475:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

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
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleStringFunction"
    // InternalBug332217TestLanguage.g:499:1: entryRuleStringFunction returns [EObject current=null] : iv_ruleStringFunction= ruleStringFunction EOF ;
    public final EObject entryRuleStringFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringFunction = null;


        try {
            // InternalBug332217TestLanguage.g:500:2: (iv_ruleStringFunction= ruleStringFunction EOF )
            // InternalBug332217TestLanguage.g:501:2: iv_ruleStringFunction= ruleStringFunction EOF
            {
             newCompositeNode(grammarAccess.getStringFunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringFunction=ruleStringFunction();

            state._fsp--;

             current =iv_ruleStringFunction; 
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
    // $ANTLR end "entryRuleStringFunction"


    // $ANTLR start "ruleStringFunction"
    // InternalBug332217TestLanguage.g:508:1: ruleStringFunction returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_values_2_0= ruleScalarExpression ) )+ otherlv_3= ')' ) | ( () otherlv_5= 'replace(' ( (lv_value_6_0= ruleScalarExpression ) ) otherlv_7= ',' ( (lv_match_8_0= ruleScalarExpression ) ) otherlv_9= ',' ( (lv_replacement_10_0= ruleScalarExpression ) ) otherlv_11= ')' ) | ( () otherlv_13= 'urlconform(' ( (lv_value_14_0= ruleScalarExpression ) ) otherlv_15= ')' ) ) ;
    public final EObject ruleStringFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_values_2_0 = null;

        EObject lv_value_6_0 = null;

        EObject lv_match_8_0 = null;

        EObject lv_replacement_10_0 = null;

        EObject lv_value_14_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:511:28: ( ( ( () otherlv_1= '(' ( (lv_values_2_0= ruleScalarExpression ) )+ otherlv_3= ')' ) | ( () otherlv_5= 'replace(' ( (lv_value_6_0= ruleScalarExpression ) ) otherlv_7= ',' ( (lv_match_8_0= ruleScalarExpression ) ) otherlv_9= ',' ( (lv_replacement_10_0= ruleScalarExpression ) ) otherlv_11= ')' ) | ( () otherlv_13= 'urlconform(' ( (lv_value_14_0= ruleScalarExpression ) ) otherlv_15= ')' ) ) )
            // InternalBug332217TestLanguage.g:512:1: ( ( () otherlv_1= '(' ( (lv_values_2_0= ruleScalarExpression ) )+ otherlv_3= ')' ) | ( () otherlv_5= 'replace(' ( (lv_value_6_0= ruleScalarExpression ) ) otherlv_7= ',' ( (lv_match_8_0= ruleScalarExpression ) ) otherlv_9= ',' ( (lv_replacement_10_0= ruleScalarExpression ) ) otherlv_11= ')' ) | ( () otherlv_13= 'urlconform(' ( (lv_value_14_0= ruleScalarExpression ) ) otherlv_15= ')' ) )
            {
            // InternalBug332217TestLanguage.g:512:1: ( ( () otherlv_1= '(' ( (lv_values_2_0= ruleScalarExpression ) )+ otherlv_3= ')' ) | ( () otherlv_5= 'replace(' ( (lv_value_6_0= ruleScalarExpression ) ) otherlv_7= ',' ( (lv_match_8_0= ruleScalarExpression ) ) otherlv_9= ',' ( (lv_replacement_10_0= ruleScalarExpression ) ) otherlv_11= ')' ) | ( () otherlv_13= 'urlconform(' ( (lv_value_14_0= ruleScalarExpression ) ) otherlv_15= ')' ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt8=1;
                }
                break;
            case 15:
                {
                alt8=2;
                }
                break;
            case 17:
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
                    // InternalBug332217TestLanguage.g:512:2: ( () otherlv_1= '(' ( (lv_values_2_0= ruleScalarExpression ) )+ otherlv_3= ')' )
                    {
                    // InternalBug332217TestLanguage.g:512:2: ( () otherlv_1= '(' ( (lv_values_2_0= ruleScalarExpression ) )+ otherlv_3= ')' )
                    // InternalBug332217TestLanguage.g:512:3: () otherlv_1= '(' ( (lv_values_2_0= ruleScalarExpression ) )+ otherlv_3= ')'
                    {
                    // InternalBug332217TestLanguage.g:512:3: ()
                    // InternalBug332217TestLanguage.g:513:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getStringFunctionAccess().getStringConcatAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_1, grammarAccess.getStringFunctionAccess().getLeftParenthesisKeyword_0_1());
                        
                    // InternalBug332217TestLanguage.g:522:1: ( (lv_values_2_0= ruleScalarExpression ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_STRING)||LA7_0==13||LA7_0==15||LA7_0==17) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalBug332217TestLanguage.g:523:1: (lv_values_2_0= ruleScalarExpression )
                    	    {
                    	    // InternalBug332217TestLanguage.g:523:1: (lv_values_2_0= ruleScalarExpression )
                    	    // InternalBug332217TestLanguage.g:524:3: lv_values_2_0= ruleScalarExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStringFunctionAccess().getValuesScalarExpressionParserRuleCall_0_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_8);
                    	    lv_values_2_0=ruleScalarExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"values",
                    	            		lv_values_2_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_3, grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_0_3());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBug332217TestLanguage.g:545:6: ( () otherlv_5= 'replace(' ( (lv_value_6_0= ruleScalarExpression ) ) otherlv_7= ',' ( (lv_match_8_0= ruleScalarExpression ) ) otherlv_9= ',' ( (lv_replacement_10_0= ruleScalarExpression ) ) otherlv_11= ')' )
                    {
                    // InternalBug332217TestLanguage.g:545:6: ( () otherlv_5= 'replace(' ( (lv_value_6_0= ruleScalarExpression ) ) otherlv_7= ',' ( (lv_match_8_0= ruleScalarExpression ) ) otherlv_9= ',' ( (lv_replacement_10_0= ruleScalarExpression ) ) otherlv_11= ')' )
                    // InternalBug332217TestLanguage.g:545:7: () otherlv_5= 'replace(' ( (lv_value_6_0= ruleScalarExpression ) ) otherlv_7= ',' ( (lv_match_8_0= ruleScalarExpression ) ) otherlv_9= ',' ( (lv_replacement_10_0= ruleScalarExpression ) ) otherlv_11= ')'
                    {
                    // InternalBug332217TestLanguage.g:545:7: ()
                    // InternalBug332217TestLanguage.g:546:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getStringFunctionAccess().getStringReplaceAction_1_0(),
                                current);
                        

                    }

                    otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_5, grammarAccess.getStringFunctionAccess().getReplaceKeyword_1_1());
                        
                    // InternalBug332217TestLanguage.g:555:1: ( (lv_value_6_0= ruleScalarExpression ) )
                    // InternalBug332217TestLanguage.g:556:1: (lv_value_6_0= ruleScalarExpression )
                    {
                    // InternalBug332217TestLanguage.g:556:1: (lv_value_6_0= ruleScalarExpression )
                    // InternalBug332217TestLanguage.g:557:3: lv_value_6_0= ruleScalarExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getStringFunctionAccess().getValueScalarExpressionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_value_6_0=ruleScalarExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_6_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_7, grammarAccess.getStringFunctionAccess().getCommaKeyword_1_3());
                        
                    // InternalBug332217TestLanguage.g:577:1: ( (lv_match_8_0= ruleScalarExpression ) )
                    // InternalBug332217TestLanguage.g:578:1: (lv_match_8_0= ruleScalarExpression )
                    {
                    // InternalBug332217TestLanguage.g:578:1: (lv_match_8_0= ruleScalarExpression )
                    // InternalBug332217TestLanguage.g:579:3: lv_match_8_0= ruleScalarExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getStringFunctionAccess().getMatchScalarExpressionParserRuleCall_1_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_match_8_0=ruleScalarExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"match",
                            		lv_match_8_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_9, grammarAccess.getStringFunctionAccess().getCommaKeyword_1_5());
                        
                    // InternalBug332217TestLanguage.g:599:1: ( (lv_replacement_10_0= ruleScalarExpression ) )
                    // InternalBug332217TestLanguage.g:600:1: (lv_replacement_10_0= ruleScalarExpression )
                    {
                    // InternalBug332217TestLanguage.g:600:1: (lv_replacement_10_0= ruleScalarExpression )
                    // InternalBug332217TestLanguage.g:601:3: lv_replacement_10_0= ruleScalarExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getStringFunctionAccess().getReplacementScalarExpressionParserRuleCall_1_6_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_replacement_10_0=ruleScalarExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"replacement",
                            		lv_replacement_10_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_11, grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_1_7());
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalBug332217TestLanguage.g:622:6: ( () otherlv_13= 'urlconform(' ( (lv_value_14_0= ruleScalarExpression ) ) otherlv_15= ')' )
                    {
                    // InternalBug332217TestLanguage.g:622:6: ( () otherlv_13= 'urlconform(' ( (lv_value_14_0= ruleScalarExpression ) ) otherlv_15= ')' )
                    // InternalBug332217TestLanguage.g:622:7: () otherlv_13= 'urlconform(' ( (lv_value_14_0= ruleScalarExpression ) ) otherlv_15= ')'
                    {
                    // InternalBug332217TestLanguage.g:622:7: ()
                    // InternalBug332217TestLanguage.g:623:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getStringFunctionAccess().getStringUrlConformAction_2_0(),
                                current);
                        

                    }

                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_13, grammarAccess.getStringFunctionAccess().getUrlconformKeyword_2_1());
                        
                    // InternalBug332217TestLanguage.g:632:1: ( (lv_value_14_0= ruleScalarExpression ) )
                    // InternalBug332217TestLanguage.g:633:1: (lv_value_14_0= ruleScalarExpression )
                    {
                    // InternalBug332217TestLanguage.g:633:1: (lv_value_14_0= ruleScalarExpression )
                    // InternalBug332217TestLanguage.g:634:3: lv_value_14_0= ruleScalarExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getStringFunctionAccess().getValueScalarExpressionParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_value_14_0=ruleScalarExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_14_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_15=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_15, grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_2_3());
                        

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
    // $ANTLR end "ruleStringFunction"


    // $ANTLR start "entryRuleCollectionLiteral"
    // InternalBug332217TestLanguage.g:662:1: entryRuleCollectionLiteral returns [EObject current=null] : iv_ruleCollectionLiteral= ruleCollectionLiteral EOF ;
    public final EObject entryRuleCollectionLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteral = null;


        try {
            // InternalBug332217TestLanguage.g:663:2: (iv_ruleCollectionLiteral= ruleCollectionLiteral EOF )
            // InternalBug332217TestLanguage.g:664:2: iv_ruleCollectionLiteral= ruleCollectionLiteral EOF
            {
             newCompositeNode(grammarAccess.getCollectionLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionLiteral=ruleCollectionLiteral();

            state._fsp--;

             current =iv_ruleCollectionLiteral; 
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
    // $ANTLR end "entryRuleCollectionLiteral"


    // $ANTLR start "ruleCollectionLiteral"
    // InternalBug332217TestLanguage.g:671:1: ruleCollectionLiteral returns [EObject current=null] : (otherlv_0= '[' ( (lv_items_1_0= ruleScalarExpression ) ) (otherlv_2= ',' ( (lv_items_3_0= ruleScalarExpression ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleCollectionLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_items_1_0 = null;

        EObject lv_items_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:674:28: ( (otherlv_0= '[' ( (lv_items_1_0= ruleScalarExpression ) ) (otherlv_2= ',' ( (lv_items_3_0= ruleScalarExpression ) ) )* otherlv_4= ']' ) )
            // InternalBug332217TestLanguage.g:675:1: (otherlv_0= '[' ( (lv_items_1_0= ruleScalarExpression ) ) (otherlv_2= ',' ( (lv_items_3_0= ruleScalarExpression ) ) )* otherlv_4= ']' )
            {
            // InternalBug332217TestLanguage.g:675:1: (otherlv_0= '[' ( (lv_items_1_0= ruleScalarExpression ) ) (otherlv_2= ',' ( (lv_items_3_0= ruleScalarExpression ) ) )* otherlv_4= ']' )
            // InternalBug332217TestLanguage.g:675:3: otherlv_0= '[' ( (lv_items_1_0= ruleScalarExpression ) ) (otherlv_2= ',' ( (lv_items_3_0= ruleScalarExpression ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getCollectionLiteralAccess().getLeftSquareBracketKeyword_0());
                
            // InternalBug332217TestLanguage.g:679:1: ( (lv_items_1_0= ruleScalarExpression ) )
            // InternalBug332217TestLanguage.g:680:1: (lv_items_1_0= ruleScalarExpression )
            {
            // InternalBug332217TestLanguage.g:680:1: (lv_items_1_0= ruleScalarExpression )
            // InternalBug332217TestLanguage.g:681:3: lv_items_1_0= ruleScalarExpression
            {
             
            	        newCompositeNode(grammarAccess.getCollectionLiteralAccess().getItemsScalarExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_11);
            lv_items_1_0=ruleScalarExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCollectionLiteralRule());
            	        }
                   		add(
                   			current, 
                   			"items",
                    		lv_items_1_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalBug332217TestLanguage.g:697:2: (otherlv_2= ',' ( (lv_items_3_0= ruleScalarExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBug332217TestLanguage.g:697:4: otherlv_2= ',' ( (lv_items_3_0= ruleScalarExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_7); 

            	        	newLeafNode(otherlv_2, grammarAccess.getCollectionLiteralAccess().getCommaKeyword_2_0());
            	        
            	    // InternalBug332217TestLanguage.g:701:1: ( (lv_items_3_0= ruleScalarExpression ) )
            	    // InternalBug332217TestLanguage.g:702:1: (lv_items_3_0= ruleScalarExpression )
            	    {
            	    // InternalBug332217TestLanguage.g:702:1: (lv_items_3_0= ruleScalarExpression )
            	    // InternalBug332217TestLanguage.g:703:3: lv_items_3_0= ruleScalarExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCollectionLiteralAccess().getItemsScalarExpressionParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_items_3_0=ruleScalarExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCollectionLiteralRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"items",
            	            		lv_items_3_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getCollectionLiteralAccess().getRightSquareBracketKeyword_3());
                

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
    // $ANTLR end "ruleCollectionLiteral"


    // $ANTLR start "entryRuleCollectionFunction"
    // InternalBug332217TestLanguage.g:731:1: entryRuleCollectionFunction returns [EObject current=null] : iv_ruleCollectionFunction= ruleCollectionFunction EOF ;
    public final EObject entryRuleCollectionFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionFunction = null;


        try {
            // InternalBug332217TestLanguage.g:732:2: (iv_ruleCollectionFunction= ruleCollectionFunction EOF )
            // InternalBug332217TestLanguage.g:733:2: iv_ruleCollectionFunction= ruleCollectionFunction EOF
            {
             newCompositeNode(grammarAccess.getCollectionFunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionFunction=ruleCollectionFunction();

            state._fsp--;

             current =iv_ruleCollectionFunction; 
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
    // $ANTLR end "entryRuleCollectionFunction"


    // $ANTLR start "ruleCollectionFunction"
    // InternalBug332217TestLanguage.g:740:1: ruleCollectionFunction returns [EObject current=null] : ( () otherlv_1= 'split(' ( (lv_value_2_0= ruleScalarExpression ) ) otherlv_3= ',' ( (lv_delimiter_4_0= ruleScalarExpression ) ) otherlv_5= ')' ) ;
    public final EObject ruleCollectionFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_2_0 = null;

        EObject lv_delimiter_4_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:743:28: ( ( () otherlv_1= 'split(' ( (lv_value_2_0= ruleScalarExpression ) ) otherlv_3= ',' ( (lv_delimiter_4_0= ruleScalarExpression ) ) otherlv_5= ')' ) )
            // InternalBug332217TestLanguage.g:744:1: ( () otherlv_1= 'split(' ( (lv_value_2_0= ruleScalarExpression ) ) otherlv_3= ',' ( (lv_delimiter_4_0= ruleScalarExpression ) ) otherlv_5= ')' )
            {
            // InternalBug332217TestLanguage.g:744:1: ( () otherlv_1= 'split(' ( (lv_value_2_0= ruleScalarExpression ) ) otherlv_3= ',' ( (lv_delimiter_4_0= ruleScalarExpression ) ) otherlv_5= ')' )
            // InternalBug332217TestLanguage.g:744:2: () otherlv_1= 'split(' ( (lv_value_2_0= ruleScalarExpression ) ) otherlv_3= ',' ( (lv_delimiter_4_0= ruleScalarExpression ) ) otherlv_5= ')'
            {
            // InternalBug332217TestLanguage.g:744:2: ()
            // InternalBug332217TestLanguage.g:745:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCollectionFunctionAccess().getStringSplitAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_1, grammarAccess.getCollectionFunctionAccess().getSplitKeyword_1());
                
            // InternalBug332217TestLanguage.g:754:1: ( (lv_value_2_0= ruleScalarExpression ) )
            // InternalBug332217TestLanguage.g:755:1: (lv_value_2_0= ruleScalarExpression )
            {
            // InternalBug332217TestLanguage.g:755:1: (lv_value_2_0= ruleScalarExpression )
            // InternalBug332217TestLanguage.g:756:3: lv_value_2_0= ruleScalarExpression
            {
             
            	        newCompositeNode(grammarAccess.getCollectionFunctionAccess().getValueScalarExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_9);
            lv_value_2_0=ruleScalarExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_3, grammarAccess.getCollectionFunctionAccess().getCommaKeyword_3());
                
            // InternalBug332217TestLanguage.g:776:1: ( (lv_delimiter_4_0= ruleScalarExpression ) )
            // InternalBug332217TestLanguage.g:777:1: (lv_delimiter_4_0= ruleScalarExpression )
            {
            // InternalBug332217TestLanguage.g:777:1: (lv_delimiter_4_0= ruleScalarExpression )
            // InternalBug332217TestLanguage.g:778:3: lv_delimiter_4_0= ruleScalarExpression
            {
             
            	        newCompositeNode(grammarAccess.getCollectionFunctionAccess().getDelimiterScalarExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_10);
            lv_delimiter_4_0=ruleScalarExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
            	        }
                   		set(
                   			current, 
                   			"delimiter",
                    		lv_delimiter_4_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getCollectionFunctionAccess().getRightParenthesisKeyword_5());
                

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
    // $ANTLR end "ruleCollectionFunction"


    // $ANTLR start "entryRuleTableView"
    // InternalBug332217TestLanguage.g:806:1: entryRuleTableView returns [EObject current=null] : iv_ruleTableView= ruleTableView EOF ;
    public final EObject entryRuleTableView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableView = null;


        try {
            // InternalBug332217TestLanguage.g:807:2: (iv_ruleTableView= ruleTableView EOF )
            // InternalBug332217TestLanguage.g:808:2: iv_ruleTableView= ruleTableView EOF
            {
             newCompositeNode(grammarAccess.getTableViewRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTableView=ruleTableView();

            state._fsp--;

             current =iv_ruleTableView; 
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
    // $ANTLR end "entryRuleTableView"


    // $ANTLR start "ruleTableView"
    // InternalBug332217TestLanguage.g:815:1: ruleTableView returns [EObject current=null] : (otherlv_0= 'tableview' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_content_3_0= ruleParameter ) ) otherlv_4= ')' )? otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) ) )* ) ) ) ( (lv_sections_13_0= ruleSection ) )* otherlv_14= '}' ) ;
    public final EObject ruleTableView() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        EObject lv_content_3_0 = null;

        EObject lv_title_8_0 = null;

        EObject lv_titleImage_10_0 = null;

        Enumerator lv_style_12_0 = null;

        EObject lv_sections_13_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:818:28: ( (otherlv_0= 'tableview' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_content_3_0= ruleParameter ) ) otherlv_4= ')' )? otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) ) )* ) ) ) ( (lv_sections_13_0= ruleSection ) )* otherlv_14= '}' ) )
            // InternalBug332217TestLanguage.g:819:1: (otherlv_0= 'tableview' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_content_3_0= ruleParameter ) ) otherlv_4= ')' )? otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) ) )* ) ) ) ( (lv_sections_13_0= ruleSection ) )* otherlv_14= '}' )
            {
            // InternalBug332217TestLanguage.g:819:1: (otherlv_0= 'tableview' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_content_3_0= ruleParameter ) ) otherlv_4= ')' )? otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) ) )* ) ) ) ( (lv_sections_13_0= ruleSection ) )* otherlv_14= '}' )
            // InternalBug332217TestLanguage.g:819:3: otherlv_0= 'tableview' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_content_3_0= ruleParameter ) ) otherlv_4= ')' )? otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) ) )* ) ) ) ( (lv_sections_13_0= ruleSection ) )* otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getTableViewAccess().getTableviewKeyword_0());
                
            // InternalBug332217TestLanguage.g:823:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalBug332217TestLanguage.g:824:1: (lv_name_1_0= RULE_ID )
            {
            // InternalBug332217TestLanguage.g:824:1: (lv_name_1_0= RULE_ID )
            // InternalBug332217TestLanguage.g:825:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            			newLeafNode(lv_name_1_0, grammarAccess.getTableViewAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTableViewRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalBug332217TestLanguage.g:841:2: (otherlv_2= '(' ( (lv_content_3_0= ruleParameter ) ) otherlv_4= ')' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalBug332217TestLanguage.g:841:4: otherlv_2= '(' ( (lv_content_3_0= ruleParameter ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_2, grammarAccess.getTableViewAccess().getLeftParenthesisKeyword_2_0());
                        
                    // InternalBug332217TestLanguage.g:845:1: ( (lv_content_3_0= ruleParameter ) )
                    // InternalBug332217TestLanguage.g:846:1: (lv_content_3_0= ruleParameter )
                    {
                    // InternalBug332217TestLanguage.g:846:1: (lv_content_3_0= ruleParameter )
                    // InternalBug332217TestLanguage.g:847:3: lv_content_3_0= ruleParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getTableViewAccess().getContentParameterParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_content_3_0=ruleParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTableViewRule());
                    	        }
                           		set(
                           			current, 
                           			"content",
                            		lv_content_3_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.Parameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_13); 

                        	newLeafNode(otherlv_4, grammarAccess.getTableViewAccess().getRightParenthesisKeyword_2_2());
                        

                    }
                    break;

            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_14); 

                	newLeafNode(otherlv_5, grammarAccess.getTableViewAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalBug332217TestLanguage.g:871:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) ) )* ) ) )
            // InternalBug332217TestLanguage.g:873:1: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) ) )* ) )
            {
            // InternalBug332217TestLanguage.g:873:1: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) ) )* ) )
            // InternalBug332217TestLanguage.g:874:2: ( ( ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getTableViewAccess().getUnorderedGroup_4());
            	
            // InternalBug332217TestLanguage.g:877:2: ( ( ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) ) )* )
            // InternalBug332217TestLanguage.g:878:3: ( ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) ) )*
            {
            // InternalBug332217TestLanguage.g:878:3: ( ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) ) )*
            loop11:
            do {
                int alt11=4;
                int LA11_0 = input.LA(1);

                if ( LA11_0 == 23 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 0) ) {
                    alt11=1;
                }
                else if ( LA11_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 1) ) {
                    alt11=2;
                }
                else if ( LA11_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 2) ) {
                    alt11=3;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBug332217TestLanguage.g:880:4: ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) )
            	    {
            	    // InternalBug332217TestLanguage.g:880:4: ({...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:881:5: {...}? => ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTableView", "getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalBug332217TestLanguage.g:881:106: ( ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:882:6: ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 0);
            	    	 				
            	    // InternalBug332217TestLanguage.g:885:6: ({...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) ) )
            	    // InternalBug332217TestLanguage.g:885:7: {...}? => (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTableView", "true");
            	    }
            	    // InternalBug332217TestLanguage.g:885:16: (otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) ) )
            	    // InternalBug332217TestLanguage.g:885:18: otherlv_7= 'title:' ( (lv_title_8_0= ruleScalarExpression ) )
            	    {
            	    otherlv_7=(Token)match(input,23,FollowSets000.FOLLOW_7); 

            	        	newLeafNode(otherlv_7, grammarAccess.getTableViewAccess().getTitleKeyword_4_0_0());
            	        
            	    // InternalBug332217TestLanguage.g:889:1: ( (lv_title_8_0= ruleScalarExpression ) )
            	    // InternalBug332217TestLanguage.g:890:1: (lv_title_8_0= ruleScalarExpression )
            	    {
            	    // InternalBug332217TestLanguage.g:890:1: (lv_title_8_0= ruleScalarExpression )
            	    // InternalBug332217TestLanguage.g:891:3: lv_title_8_0= ruleScalarExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableViewAccess().getTitleScalarExpressionParserRuleCall_4_0_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_title_8_0=ruleScalarExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableViewRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"title",
            	            		lv_title_8_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTableViewAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBug332217TestLanguage.g:914:4: ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) )
            	    {
            	    // InternalBug332217TestLanguage.g:914:4: ({...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:915:5: {...}? => ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTableView", "getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalBug332217TestLanguage.g:915:106: ( ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:916:6: ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 1);
            	    	 				
            	    // InternalBug332217TestLanguage.g:919:6: ({...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) ) )
            	    // InternalBug332217TestLanguage.g:919:7: {...}? => (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTableView", "true");
            	    }
            	    // InternalBug332217TestLanguage.g:919:16: (otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) ) )
            	    // InternalBug332217TestLanguage.g:919:18: otherlv_9= 'titleImage:' ( (lv_titleImage_10_0= ruleImageExpression ) )
            	    {
            	    otherlv_9=(Token)match(input,24,FollowSets000.FOLLOW_7); 

            	        	newLeafNode(otherlv_9, grammarAccess.getTableViewAccess().getTitleImageKeyword_4_1_0());
            	        
            	    // InternalBug332217TestLanguage.g:923:1: ( (lv_titleImage_10_0= ruleImageExpression ) )
            	    // InternalBug332217TestLanguage.g:924:1: (lv_titleImage_10_0= ruleImageExpression )
            	    {
            	    // InternalBug332217TestLanguage.g:924:1: (lv_titleImage_10_0= ruleImageExpression )
            	    // InternalBug332217TestLanguage.g:925:3: lv_titleImage_10_0= ruleImageExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableViewAccess().getTitleImageImageExpressionParserRuleCall_4_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_titleImage_10_0=ruleImageExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableViewRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"titleImage",
            	            		lv_titleImage_10_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ImageExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTableViewAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalBug332217TestLanguage.g:948:4: ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) )
            	    {
            	    // InternalBug332217TestLanguage.g:948:4: ({...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:949:5: {...}? => ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTableView", "getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalBug332217TestLanguage.g:949:106: ( ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:950:6: ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 2);
            	    	 				
            	    // InternalBug332217TestLanguage.g:953:6: ({...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) ) )
            	    // InternalBug332217TestLanguage.g:953:7: {...}? => (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTableView", "true");
            	    }
            	    // InternalBug332217TestLanguage.g:953:16: (otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) ) )
            	    // InternalBug332217TestLanguage.g:953:18: otherlv_11= 'style:' ( (lv_style_12_0= ruleTableViewStyle ) )
            	    {
            	    otherlv_11=(Token)match(input,25,FollowSets000.FOLLOW_15); 

            	        	newLeafNode(otherlv_11, grammarAccess.getTableViewAccess().getStyleKeyword_4_2_0());
            	        
            	    // InternalBug332217TestLanguage.g:957:1: ( (lv_style_12_0= ruleTableViewStyle ) )
            	    // InternalBug332217TestLanguage.g:958:1: (lv_style_12_0= ruleTableViewStyle )
            	    {
            	    // InternalBug332217TestLanguage.g:958:1: (lv_style_12_0= ruleTableViewStyle )
            	    // InternalBug332217TestLanguage.g:959:3: lv_style_12_0= ruleTableViewStyle
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableViewAccess().getStyleTableViewStyleEnumRuleCall_4_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_style_12_0=ruleTableViewStyle();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableViewRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"style",
            	            		lv_style_12_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.TableViewStyle");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTableViewAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getTableViewAccess().getUnorderedGroup_4());
            	

            }

            // InternalBug332217TestLanguage.g:989:2: ( (lv_sections_13_0= ruleSection ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==27) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug332217TestLanguage.g:990:1: (lv_sections_13_0= ruleSection )
            	    {
            	    // InternalBug332217TestLanguage.g:990:1: (lv_sections_13_0= ruleSection )
            	    // InternalBug332217TestLanguage.g:991:3: lv_sections_13_0= ruleSection
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableViewAccess().getSectionsSectionParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_16);
            	    lv_sections_13_0=ruleSection();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableViewRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"sections",
            	            		lv_sections_13_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.Section");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_14=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_14, grammarAccess.getTableViewAccess().getRightCurlyBracketKeyword_6());
                

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
    // $ANTLR end "ruleTableView"


    // $ANTLR start "entryRuleSection"
    // InternalBug332217TestLanguage.g:1021:1: entryRuleSection returns [EObject current=null] : iv_ruleSection= ruleSection EOF ;
    public final EObject entryRuleSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSection = null;


        try {
            // InternalBug332217TestLanguage.g:1022:2: (iv_ruleSection= ruleSection EOF )
            // InternalBug332217TestLanguage.g:1023:2: iv_ruleSection= ruleSection EOF
            {
             newCompositeNode(grammarAccess.getSectionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSection=ruleSection();

            state._fsp--;

             current =iv_ruleSection; 
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
    // $ANTLR end "entryRuleSection"


    // $ANTLR start "ruleSection"
    // InternalBug332217TestLanguage.g:1030:1: ruleSection returns [EObject current=null] : (otherlv_0= 'section' ( (lv_iterator_1_0= ruleCollectionIterator ) )? otherlv_2= '{' (otherlv_3= 'title:' ( (lv_title_4_0= ruleScalarExpression ) ) )? ( (lv_cells_5_0= ruleCell ) )+ otherlv_6= '}' ) ;
    public final EObject ruleSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_iterator_1_0 = null;

        EObject lv_title_4_0 = null;

        EObject lv_cells_5_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:1033:28: ( (otherlv_0= 'section' ( (lv_iterator_1_0= ruleCollectionIterator ) )? otherlv_2= '{' (otherlv_3= 'title:' ( (lv_title_4_0= ruleScalarExpression ) ) )? ( (lv_cells_5_0= ruleCell ) )+ otherlv_6= '}' ) )
            // InternalBug332217TestLanguage.g:1034:1: (otherlv_0= 'section' ( (lv_iterator_1_0= ruleCollectionIterator ) )? otherlv_2= '{' (otherlv_3= 'title:' ( (lv_title_4_0= ruleScalarExpression ) ) )? ( (lv_cells_5_0= ruleCell ) )+ otherlv_6= '}' )
            {
            // InternalBug332217TestLanguage.g:1034:1: (otherlv_0= 'section' ( (lv_iterator_1_0= ruleCollectionIterator ) )? otherlv_2= '{' (otherlv_3= 'title:' ( (lv_title_4_0= ruleScalarExpression ) ) )? ( (lv_cells_5_0= ruleCell ) )+ otherlv_6= '}' )
            // InternalBug332217TestLanguage.g:1034:3: otherlv_0= 'section' ( (lv_iterator_1_0= ruleCollectionIterator ) )? otherlv_2= '{' (otherlv_3= 'title:' ( (lv_title_4_0= ruleScalarExpression ) ) )? ( (lv_cells_5_0= ruleCell ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getSectionAccess().getSectionKeyword_0());
                
            // InternalBug332217TestLanguage.g:1038:1: ( (lv_iterator_1_0= ruleCollectionIterator ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==34) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalBug332217TestLanguage.g:1039:1: (lv_iterator_1_0= ruleCollectionIterator )
                    {
                    // InternalBug332217TestLanguage.g:1039:1: (lv_iterator_1_0= ruleCollectionIterator )
                    // InternalBug332217TestLanguage.g:1040:3: lv_iterator_1_0= ruleCollectionIterator
                    {
                     
                    	        newCompositeNode(grammarAccess.getSectionAccess().getIteratorCollectionIteratorParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_13);
                    lv_iterator_1_0=ruleCollectionIterator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSectionRule());
                    	        }
                           		set(
                           			current, 
                           			"iterator",
                            		lv_iterator_1_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.CollectionIterator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_18); 

                	newLeafNode(otherlv_2, grammarAccess.getSectionAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalBug332217TestLanguage.g:1060:1: (otherlv_3= 'title:' ( (lv_title_4_0= ruleScalarExpression ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalBug332217TestLanguage.g:1060:3: otherlv_3= 'title:' ( (lv_title_4_0= ruleScalarExpression ) )
                    {
                    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_7); 

                        	newLeafNode(otherlv_3, grammarAccess.getSectionAccess().getTitleKeyword_3_0());
                        
                    // InternalBug332217TestLanguage.g:1064:1: ( (lv_title_4_0= ruleScalarExpression ) )
                    // InternalBug332217TestLanguage.g:1065:1: (lv_title_4_0= ruleScalarExpression )
                    {
                    // InternalBug332217TestLanguage.g:1065:1: (lv_title_4_0= ruleScalarExpression )
                    // InternalBug332217TestLanguage.g:1066:3: lv_title_4_0= ruleScalarExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSectionAccess().getTitleScalarExpressionParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_18);
                    lv_title_4_0=ruleScalarExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSectionRule());
                    	        }
                           		set(
                           			current, 
                           			"title",
                            		lv_title_4_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalBug332217TestLanguage.g:1082:4: ( (lv_cells_5_0= ruleCell ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==28) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalBug332217TestLanguage.g:1083:1: (lv_cells_5_0= ruleCell )
            	    {
            	    // InternalBug332217TestLanguage.g:1083:1: (lv_cells_5_0= ruleCell )
            	    // InternalBug332217TestLanguage.g:1084:3: lv_cells_5_0= ruleCell
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSectionAccess().getCellsCellParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    lv_cells_5_0=ruleCell();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSectionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"cells",
            	            		lv_cells_5_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.Cell");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getSectionAccess().getRightCurlyBracketKeyword_5());
                

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
    // $ANTLR end "ruleSection"


    // $ANTLR start "entryRuleCell"
    // InternalBug332217TestLanguage.g:1112:1: entryRuleCell returns [EObject current=null] : iv_ruleCell= ruleCell EOF ;
    public final EObject entryRuleCell() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCell = null;


        try {
            // InternalBug332217TestLanguage.g:1113:2: (iv_ruleCell= ruleCell EOF )
            // InternalBug332217TestLanguage.g:1114:2: iv_ruleCell= ruleCell EOF
            {
             newCompositeNode(grammarAccess.getCellRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCell=ruleCell();

            state._fsp--;

             current =iv_ruleCell; 
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
    // $ANTLR end "entryRuleCell"


    // $ANTLR start "ruleCell"
    // InternalBug332217TestLanguage.g:1121:1: ruleCell returns [EObject current=null] : (otherlv_0= 'cell' ( (lv_type_1_0= ruleCellType ) ) ( (lv_iterator_2_0= ruleCollectionIterator ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) ) )* ) ) ) otherlv_15= '}' ) ;
    public final EObject ruleCell() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_iterator_2_0 = null;

        EObject lv_text_6_0 = null;

        EObject lv_details_8_0 = null;

        EObject lv_image_10_0 = null;

        EObject lv_action_12_0 = null;

        Enumerator lv_accessory_14_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:1124:28: ( (otherlv_0= 'cell' ( (lv_type_1_0= ruleCellType ) ) ( (lv_iterator_2_0= ruleCollectionIterator ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) ) )* ) ) ) otherlv_15= '}' ) )
            // InternalBug332217TestLanguage.g:1125:1: (otherlv_0= 'cell' ( (lv_type_1_0= ruleCellType ) ) ( (lv_iterator_2_0= ruleCollectionIterator ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) ) )* ) ) ) otherlv_15= '}' )
            {
            // InternalBug332217TestLanguage.g:1125:1: (otherlv_0= 'cell' ( (lv_type_1_0= ruleCellType ) ) ( (lv_iterator_2_0= ruleCollectionIterator ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) ) )* ) ) ) otherlv_15= '}' )
            // InternalBug332217TestLanguage.g:1125:3: otherlv_0= 'cell' ( (lv_type_1_0= ruleCellType ) ) ( (lv_iterator_2_0= ruleCollectionIterator ) )? otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) ) )* ) ) ) otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_20); 

                	newLeafNode(otherlv_0, grammarAccess.getCellAccess().getCellKeyword_0());
                
            // InternalBug332217TestLanguage.g:1129:1: ( (lv_type_1_0= ruleCellType ) )
            // InternalBug332217TestLanguage.g:1130:1: (lv_type_1_0= ruleCellType )
            {
            // InternalBug332217TestLanguage.g:1130:1: (lv_type_1_0= ruleCellType )
            // InternalBug332217TestLanguage.g:1131:3: lv_type_1_0= ruleCellType
            {
             
            	        newCompositeNode(grammarAccess.getCellAccess().getTypeCellTypeEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_17);
            lv_type_1_0=ruleCellType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCellRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.CellType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalBug332217TestLanguage.g:1147:2: ( (lv_iterator_2_0= ruleCollectionIterator ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==34) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalBug332217TestLanguage.g:1148:1: (lv_iterator_2_0= ruleCollectionIterator )
                    {
                    // InternalBug332217TestLanguage.g:1148:1: (lv_iterator_2_0= ruleCollectionIterator )
                    // InternalBug332217TestLanguage.g:1149:3: lv_iterator_2_0= ruleCollectionIterator
                    {
                     
                    	        newCompositeNode(grammarAccess.getCellAccess().getIteratorCollectionIteratorParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_13);
                    lv_iterator_2_0=ruleCollectionIterator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCellRule());
                    	        }
                           		set(
                           			current, 
                           			"iterator",
                            		lv_iterator_2_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.CollectionIterator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,22,FollowSets000.FOLLOW_21); 

                	newLeafNode(otherlv_3, grammarAccess.getCellAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalBug332217TestLanguage.g:1169:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) ) )* ) ) )
            // InternalBug332217TestLanguage.g:1171:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) ) )* ) )
            {
            // InternalBug332217TestLanguage.g:1171:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) ) )* ) )
            // InternalBug332217TestLanguage.g:1172:2: ( ( ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getCellAccess().getUnorderedGroup_4());
            	
            // InternalBug332217TestLanguage.g:1175:2: ( ( ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) ) )* )
            // InternalBug332217TestLanguage.g:1176:3: ( ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) ) )*
            {
            // InternalBug332217TestLanguage.g:1176:3: ( ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) ) )*
            loop17:
            do {
                int alt17=6;
                int LA17_0 = input.LA(1);

                if ( LA17_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0) ) {
                    alt17=1;
                }
                else if ( LA17_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1) ) {
                    alt17=2;
                }
                else if ( LA17_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2) ) {
                    alt17=3;
                }
                else if ( LA17_0 == 32 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3) ) {
                    alt17=4;
                }
                else if ( LA17_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4) ) {
                    alt17=5;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalBug332217TestLanguage.g:1178:4: ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) )
            	    {
            	    // InternalBug332217TestLanguage.g:1178:4: ({...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:1179:5: {...}? => ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleCell", "getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalBug332217TestLanguage.g:1179:101: ( ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:1180:6: ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0);
            	    	 				
            	    // InternalBug332217TestLanguage.g:1183:6: ({...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) ) )
            	    // InternalBug332217TestLanguage.g:1183:7: {...}? => (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCell", "true");
            	    }
            	    // InternalBug332217TestLanguage.g:1183:16: (otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) ) )
            	    // InternalBug332217TestLanguage.g:1183:18: otherlv_5= 'text:' ( (lv_text_6_0= ruleScalarExpression ) )
            	    {
            	    otherlv_5=(Token)match(input,29,FollowSets000.FOLLOW_7); 

            	        	newLeafNode(otherlv_5, grammarAccess.getCellAccess().getTextKeyword_4_0_0());
            	        
            	    // InternalBug332217TestLanguage.g:1187:1: ( (lv_text_6_0= ruleScalarExpression ) )
            	    // InternalBug332217TestLanguage.g:1188:1: (lv_text_6_0= ruleScalarExpression )
            	    {
            	    // InternalBug332217TestLanguage.g:1188:1: (lv_text_6_0= ruleScalarExpression )
            	    // InternalBug332217TestLanguage.g:1189:3: lv_text_6_0= ruleScalarExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCellAccess().getTextScalarExpressionParserRuleCall_4_0_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    lv_text_6_0=ruleScalarExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCellRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"text",
            	            		lv_text_6_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCellAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBug332217TestLanguage.g:1212:4: ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) )
            	    {
            	    // InternalBug332217TestLanguage.g:1212:4: ({...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:1213:5: {...}? => ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleCell", "getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalBug332217TestLanguage.g:1213:101: ( ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:1214:6: ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1);
            	    	 				
            	    // InternalBug332217TestLanguage.g:1217:6: ({...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) ) )
            	    // InternalBug332217TestLanguage.g:1217:7: {...}? => (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCell", "true");
            	    }
            	    // InternalBug332217TestLanguage.g:1217:16: (otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) ) )
            	    // InternalBug332217TestLanguage.g:1217:18: otherlv_7= 'details:' ( (lv_details_8_0= ruleScalarExpression ) )
            	    {
            	    otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_7); 

            	        	newLeafNode(otherlv_7, grammarAccess.getCellAccess().getDetailsKeyword_4_1_0());
            	        
            	    // InternalBug332217TestLanguage.g:1221:1: ( (lv_details_8_0= ruleScalarExpression ) )
            	    // InternalBug332217TestLanguage.g:1222:1: (lv_details_8_0= ruleScalarExpression )
            	    {
            	    // InternalBug332217TestLanguage.g:1222:1: (lv_details_8_0= ruleScalarExpression )
            	    // InternalBug332217TestLanguage.g:1223:3: lv_details_8_0= ruleScalarExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCellAccess().getDetailsScalarExpressionParserRuleCall_4_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    lv_details_8_0=ruleScalarExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCellRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"details",
            	            		lv_details_8_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCellAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalBug332217TestLanguage.g:1246:4: ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) )
            	    {
            	    // InternalBug332217TestLanguage.g:1246:4: ({...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:1247:5: {...}? => ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleCell", "getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalBug332217TestLanguage.g:1247:101: ( ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:1248:6: ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2);
            	    	 				
            	    // InternalBug332217TestLanguage.g:1251:6: ({...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) ) )
            	    // InternalBug332217TestLanguage.g:1251:7: {...}? => (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCell", "true");
            	    }
            	    // InternalBug332217TestLanguage.g:1251:16: (otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) ) )
            	    // InternalBug332217TestLanguage.g:1251:18: otherlv_9= 'image:' ( (lv_image_10_0= ruleScalarExpression ) )
            	    {
            	    otherlv_9=(Token)match(input,31,FollowSets000.FOLLOW_7); 

            	        	newLeafNode(otherlv_9, grammarAccess.getCellAccess().getImageKeyword_4_2_0());
            	        
            	    // InternalBug332217TestLanguage.g:1255:1: ( (lv_image_10_0= ruleScalarExpression ) )
            	    // InternalBug332217TestLanguage.g:1256:1: (lv_image_10_0= ruleScalarExpression )
            	    {
            	    // InternalBug332217TestLanguage.g:1256:1: (lv_image_10_0= ruleScalarExpression )
            	    // InternalBug332217TestLanguage.g:1257:3: lv_image_10_0= ruleScalarExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCellAccess().getImageScalarExpressionParserRuleCall_4_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    lv_image_10_0=ruleScalarExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCellRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"image",
            	            		lv_image_10_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCellAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalBug332217TestLanguage.g:1280:4: ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) )
            	    {
            	    // InternalBug332217TestLanguage.g:1280:4: ({...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:1281:5: {...}? => ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleCell", "getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalBug332217TestLanguage.g:1281:101: ( ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:1282:6: ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3);
            	    	 				
            	    // InternalBug332217TestLanguage.g:1285:6: ({...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) ) )
            	    // InternalBug332217TestLanguage.g:1285:7: {...}? => (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCell", "true");
            	    }
            	    // InternalBug332217TestLanguage.g:1285:16: (otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) ) )
            	    // InternalBug332217TestLanguage.g:1285:18: otherlv_11= 'action:' ( (lv_action_12_0= ruleViewAction ) )
            	    {
            	    otherlv_11=(Token)match(input,32,FollowSets000.FOLLOW_22); 

            	        	newLeafNode(otherlv_11, grammarAccess.getCellAccess().getActionKeyword_4_3_0());
            	        
            	    // InternalBug332217TestLanguage.g:1289:1: ( (lv_action_12_0= ruleViewAction ) )
            	    // InternalBug332217TestLanguage.g:1290:1: (lv_action_12_0= ruleViewAction )
            	    {
            	    // InternalBug332217TestLanguage.g:1290:1: (lv_action_12_0= ruleViewAction )
            	    // InternalBug332217TestLanguage.g:1291:3: lv_action_12_0= ruleViewAction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCellAccess().getActionViewActionParserRuleCall_4_3_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    lv_action_12_0=ruleViewAction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCellRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"action",
            	            		lv_action_12_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ViewAction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCellAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalBug332217TestLanguage.g:1314:4: ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) )
            	    {
            	    // InternalBug332217TestLanguage.g:1314:4: ({...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:1315:5: {...}? => ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleCell", "getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // InternalBug332217TestLanguage.g:1315:101: ( ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) ) )
            	    // InternalBug332217TestLanguage.g:1316:6: ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4);
            	    	 				
            	    // InternalBug332217TestLanguage.g:1319:6: ({...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) ) )
            	    // InternalBug332217TestLanguage.g:1319:7: {...}? => (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCell", "true");
            	    }
            	    // InternalBug332217TestLanguage.g:1319:16: (otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) ) )
            	    // InternalBug332217TestLanguage.g:1319:18: otherlv_13= 'accessory:' ( (lv_accessory_14_0= ruleCellAccessory ) )
            	    {
            	    otherlv_13=(Token)match(input,33,FollowSets000.FOLLOW_23); 

            	        	newLeafNode(otherlv_13, grammarAccess.getCellAccess().getAccessoryKeyword_4_4_0());
            	        
            	    // InternalBug332217TestLanguage.g:1323:1: ( (lv_accessory_14_0= ruleCellAccessory ) )
            	    // InternalBug332217TestLanguage.g:1324:1: (lv_accessory_14_0= ruleCellAccessory )
            	    {
            	    // InternalBug332217TestLanguage.g:1324:1: (lv_accessory_14_0= ruleCellAccessory )
            	    // InternalBug332217TestLanguage.g:1325:3: lv_accessory_14_0= ruleCellAccessory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCellAccess().getAccessoryCellAccessoryEnumRuleCall_4_4_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    lv_accessory_14_0=ruleCellAccessory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCellRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"accessory",
            	            		lv_accessory_14_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.CellAccessory");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCellAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getCellAccess().getUnorderedGroup_4());
            	

            }

            otherlv_15=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_15, grammarAccess.getCellAccess().getRightCurlyBracketKeyword_5());
                

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
    // $ANTLR end "ruleCell"


    // $ANTLR start "entryRuleCollectionIterator"
    // InternalBug332217TestLanguage.g:1367:1: entryRuleCollectionIterator returns [EObject current=null] : iv_ruleCollectionIterator= ruleCollectionIterator EOF ;
    public final EObject entryRuleCollectionIterator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionIterator = null;


        try {
            // InternalBug332217TestLanguage.g:1368:2: (iv_ruleCollectionIterator= ruleCollectionIterator EOF )
            // InternalBug332217TestLanguage.g:1369:2: iv_ruleCollectionIterator= ruleCollectionIterator EOF
            {
             newCompositeNode(grammarAccess.getCollectionIteratorRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionIterator=ruleCollectionIterator();

            state._fsp--;

             current =iv_ruleCollectionIterator; 
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
    // $ANTLR end "entryRuleCollectionIterator"


    // $ANTLR start "ruleCollectionIterator"
    // InternalBug332217TestLanguage.g:1376:1: ruleCollectionIterator returns [EObject current=null] : (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_collection_3_0= ruleCollectionExpression ) ) ) ;
    public final EObject ruleCollectionIterator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_collection_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:1379:28: ( (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_collection_3_0= ruleCollectionExpression ) ) ) )
            // InternalBug332217TestLanguage.g:1380:1: (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_collection_3_0= ruleCollectionExpression ) ) )
            {
            // InternalBug332217TestLanguage.g:1380:1: (otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_collection_3_0= ruleCollectionExpression ) ) )
            // InternalBug332217TestLanguage.g:1380:3: otherlv_0= 'for' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'in' ( (lv_collection_3_0= ruleCollectionExpression ) )
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getCollectionIteratorAccess().getForKeyword_0());
                
            // InternalBug332217TestLanguage.g:1384:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalBug332217TestLanguage.g:1385:1: (lv_name_1_0= RULE_ID )
            {
            // InternalBug332217TestLanguage.g:1385:1: (lv_name_1_0= RULE_ID )
            // InternalBug332217TestLanguage.g:1386:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_24); 

            			newLeafNode(lv_name_1_0, grammarAccess.getCollectionIteratorAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCollectionIteratorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_25); 

                	newLeafNode(otherlv_2, grammarAccess.getCollectionIteratorAccess().getInKeyword_2());
                
            // InternalBug332217TestLanguage.g:1406:1: ( (lv_collection_3_0= ruleCollectionExpression ) )
            // InternalBug332217TestLanguage.g:1407:1: (lv_collection_3_0= ruleCollectionExpression )
            {
            // InternalBug332217TestLanguage.g:1407:1: (lv_collection_3_0= ruleCollectionExpression )
            // InternalBug332217TestLanguage.g:1408:3: lv_collection_3_0= ruleCollectionExpression
            {
             
            	        newCompositeNode(grammarAccess.getCollectionIteratorAccess().getCollectionCollectionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_collection_3_0=ruleCollectionExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCollectionIteratorRule());
            	        }
                   		set(
                   			current, 
                   			"collection",
                    		lv_collection_3_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.CollectionExpression");
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
    // $ANTLR end "ruleCollectionIterator"


    // $ANTLR start "entryRuleViewAction"
    // InternalBug332217TestLanguage.g:1432:1: entryRuleViewAction returns [EObject current=null] : iv_ruleViewAction= ruleViewAction EOF ;
    public final EObject entryRuleViewAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleViewAction = null;


        try {
            // InternalBug332217TestLanguage.g:1433:2: (iv_ruleViewAction= ruleViewAction EOF )
            // InternalBug332217TestLanguage.g:1434:2: iv_ruleViewAction= ruleViewAction EOF
            {
             newCompositeNode(grammarAccess.getViewActionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleViewAction=ruleViewAction();

            state._fsp--;

             current =iv_ruleViewAction; 
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
    // $ANTLR end "entryRuleViewAction"


    // $ANTLR start "ruleViewAction"
    // InternalBug332217TestLanguage.g:1441:1: ruleViewAction returns [EObject current=null] : (this_ExternalOpen_0= ruleExternalOpen | this_Selector_1= ruleSelector ) ;
    public final EObject ruleViewAction() throws RecognitionException {
        EObject current = null;

        EObject this_ExternalOpen_0 = null;

        EObject this_Selector_1 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:1444:28: ( (this_ExternalOpen_0= ruleExternalOpen | this_Selector_1= ruleSelector ) )
            // InternalBug332217TestLanguage.g:1445:1: (this_ExternalOpen_0= ruleExternalOpen | this_Selector_1= ruleSelector )
            {
            // InternalBug332217TestLanguage.g:1445:1: (this_ExternalOpen_0= ruleExternalOpen | this_Selector_1= ruleSelector )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_ID && LA18_0<=RULE_STRING)||LA18_0==13||LA18_0==15||LA18_0==17) ) {
                alt18=1;
            }
            else if ( (LA18_0==37) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalBug332217TestLanguage.g:1446:5: this_ExternalOpen_0= ruleExternalOpen
                    {
                     
                            newCompositeNode(grammarAccess.getViewActionAccess().getExternalOpenParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ExternalOpen_0=ruleExternalOpen();

                    state._fsp--;

                     
                            current = this_ExternalOpen_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalBug332217TestLanguage.g:1456:5: this_Selector_1= ruleSelector
                    {
                     
                            newCompositeNode(grammarAccess.getViewActionAccess().getSelectorParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Selector_1=ruleSelector();

                    state._fsp--;

                     
                            current = this_Selector_1; 
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
    // $ANTLR end "ruleViewAction"


    // $ANTLR start "entryRuleSelectorName"
    // InternalBug332217TestLanguage.g:1472:1: entryRuleSelectorName returns [String current=null] : iv_ruleSelectorName= ruleSelectorName EOF ;
    public final String entryRuleSelectorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSelectorName = null;


        try {
            // InternalBug332217TestLanguage.g:1473:2: (iv_ruleSelectorName= ruleSelectorName EOF )
            // InternalBug332217TestLanguage.g:1474:2: iv_ruleSelectorName= ruleSelectorName EOF
            {
             newCompositeNode(grammarAccess.getSelectorNameRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSelectorName=ruleSelectorName();

            state._fsp--;

             current =iv_ruleSelectorName.getText(); 
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
    // $ANTLR end "entryRuleSelectorName"


    // $ANTLR start "ruleSelectorName"
    // InternalBug332217TestLanguage.g:1481:1: ruleSelectorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ':' this_ID_2= RULE_ID )* (kw= ':' )? ) ;
    public final AntlrDatatypeRuleToken ruleSelectorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:1484:28: ( (this_ID_0= RULE_ID (kw= ':' this_ID_2= RULE_ID )* (kw= ':' )? ) )
            // InternalBug332217TestLanguage.g:1485:1: (this_ID_0= RULE_ID (kw= ':' this_ID_2= RULE_ID )* (kw= ':' )? )
            {
            // InternalBug332217TestLanguage.g:1485:1: (this_ID_0= RULE_ID (kw= ':' this_ID_2= RULE_ID )* (kw= ':' )? )
            // InternalBug332217TestLanguage.g:1485:6: this_ID_0= RULE_ID (kw= ':' this_ID_2= RULE_ID )* (kw= ':' )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getSelectorNameAccess().getIDTerminalRuleCall_0()); 
                
            // InternalBug332217TestLanguage.g:1492:1: (kw= ':' this_ID_2= RULE_ID )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==36) ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1==RULE_ID) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // InternalBug332217TestLanguage.g:1493:2: kw= ':' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,36,FollowSets000.FOLLOW_5); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getSelectorNameAccess().getColonKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getSelectorNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // InternalBug332217TestLanguage.g:1505:3: (kw= ':' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==36) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBug332217TestLanguage.g:1506:2: kw= ':'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSelectorNameAccess().getColonKeyword_2()); 
                        

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
    // $ANTLR end "ruleSelectorName"


    // $ANTLR start "entryRuleSelector"
    // InternalBug332217TestLanguage.g:1519:1: entryRuleSelector returns [EObject current=null] : iv_ruleSelector= ruleSelector EOF ;
    public final EObject entryRuleSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelector = null;


        try {
            // InternalBug332217TestLanguage.g:1520:2: (iv_ruleSelector= ruleSelector EOF )
            // InternalBug332217TestLanguage.g:1521:2: iv_ruleSelector= ruleSelector EOF
            {
             newCompositeNode(grammarAccess.getSelectorRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSelector=ruleSelector();

            state._fsp--;

             current =iv_ruleSelector; 
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
    // $ANTLR end "entryRuleSelector"


    // $ANTLR start "ruleSelector"
    // InternalBug332217TestLanguage.g:1528:1: ruleSelector returns [EObject current=null] : (otherlv_0= '@selector' otherlv_1= '(' ( (lv_name_2_0= ruleSelectorName ) ) otherlv_3= ')' ) ;
    public final EObject ruleSelector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:1531:28: ( (otherlv_0= '@selector' otherlv_1= '(' ( (lv_name_2_0= ruleSelectorName ) ) otherlv_3= ')' ) )
            // InternalBug332217TestLanguage.g:1532:1: (otherlv_0= '@selector' otherlv_1= '(' ( (lv_name_2_0= ruleSelectorName ) ) otherlv_3= ')' )
            {
            // InternalBug332217TestLanguage.g:1532:1: (otherlv_0= '@selector' otherlv_1= '(' ( (lv_name_2_0= ruleSelectorName ) ) otherlv_3= ')' )
            // InternalBug332217TestLanguage.g:1532:3: otherlv_0= '@selector' otherlv_1= '(' ( (lv_name_2_0= ruleSelectorName ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_27); 

                	newLeafNode(otherlv_0, grammarAccess.getSelectorAccess().getSelectorKeyword_0());
                
            otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getSelectorAccess().getLeftParenthesisKeyword_1());
                
            // InternalBug332217TestLanguage.g:1540:1: ( (lv_name_2_0= ruleSelectorName ) )
            // InternalBug332217TestLanguage.g:1541:1: (lv_name_2_0= ruleSelectorName )
            {
            // InternalBug332217TestLanguage.g:1541:1: (lv_name_2_0= ruleSelectorName )
            // InternalBug332217TestLanguage.g:1542:3: lv_name_2_0= ruleSelectorName
            {
             
            	        newCompositeNode(grammarAccess.getSelectorAccess().getNameSelectorNameParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_10);
            lv_name_2_0=ruleSelectorName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSelectorRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.SelectorName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_3, grammarAccess.getSelectorAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleSelector"


    // $ANTLR start "entryRuleExternalOpen"
    // InternalBug332217TestLanguage.g:1570:1: entryRuleExternalOpen returns [EObject current=null] : iv_ruleExternalOpen= ruleExternalOpen EOF ;
    public final EObject entryRuleExternalOpen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalOpen = null;


        try {
            // InternalBug332217TestLanguage.g:1571:2: (iv_ruleExternalOpen= ruleExternalOpen EOF )
            // InternalBug332217TestLanguage.g:1572:2: iv_ruleExternalOpen= ruleExternalOpen EOF
            {
             newCompositeNode(grammarAccess.getExternalOpenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExternalOpen=ruleExternalOpen();

            state._fsp--;

             current =iv_ruleExternalOpen; 
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
    // $ANTLR end "entryRuleExternalOpen"


    // $ANTLR start "ruleExternalOpen"
    // InternalBug332217TestLanguage.g:1579:1: ruleExternalOpen returns [EObject current=null] : ( (lv_url_0_0= ruleScalarExpression ) ) ;
    public final EObject ruleExternalOpen() throws RecognitionException {
        EObject current = null;

        EObject lv_url_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug332217TestLanguage.g:1582:28: ( ( (lv_url_0_0= ruleScalarExpression ) ) )
            // InternalBug332217TestLanguage.g:1583:1: ( (lv_url_0_0= ruleScalarExpression ) )
            {
            // InternalBug332217TestLanguage.g:1583:1: ( (lv_url_0_0= ruleScalarExpression ) )
            // InternalBug332217TestLanguage.g:1584:1: (lv_url_0_0= ruleScalarExpression )
            {
            // InternalBug332217TestLanguage.g:1584:1: (lv_url_0_0= ruleScalarExpression )
            // InternalBug332217TestLanguage.g:1585:3: lv_url_0_0= ruleScalarExpression
            {
             
            	        newCompositeNode(grammarAccess.getExternalOpenAccess().getUrlScalarExpressionParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_url_0_0=ruleScalarExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExternalOpenRule());
            	        }
                   		set(
                   			current, 
                   			"url",
                    		lv_url_0_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug332217TestLanguage.ScalarExpression");
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
    // $ANTLR end "ruleExternalOpen"


    // $ANTLR start "ruleTableViewStyle"
    // InternalBug332217TestLanguage.g:1609:1: ruleTableViewStyle returns [Enumerator current=null] : ( (enumLiteral_0= 'Plain' ) | (enumLiteral_1= 'Grouped' ) ) ;
    public final Enumerator ruleTableViewStyle() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalBug332217TestLanguage.g:1611:28: ( ( (enumLiteral_0= 'Plain' ) | (enumLiteral_1= 'Grouped' ) ) )
            // InternalBug332217TestLanguage.g:1612:1: ( (enumLiteral_0= 'Plain' ) | (enumLiteral_1= 'Grouped' ) )
            {
            // InternalBug332217TestLanguage.g:1612:1: ( (enumLiteral_0= 'Plain' ) | (enumLiteral_1= 'Grouped' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==38) ) {
                alt21=1;
            }
            else if ( (LA21_0==39) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalBug332217TestLanguage.g:1612:2: (enumLiteral_0= 'Plain' )
                    {
                    // InternalBug332217TestLanguage.g:1612:2: (enumLiteral_0= 'Plain' )
                    // InternalBug332217TestLanguage.g:1612:4: enumLiteral_0= 'Plain'
                    {
                    enumLiteral_0=(Token)match(input,38,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getTableViewStyleAccess().getPlainEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getTableViewStyleAccess().getPlainEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBug332217TestLanguage.g:1618:6: (enumLiteral_1= 'Grouped' )
                    {
                    // InternalBug332217TestLanguage.g:1618:6: (enumLiteral_1= 'Grouped' )
                    // InternalBug332217TestLanguage.g:1618:8: enumLiteral_1= 'Grouped'
                    {
                    enumLiteral_1=(Token)match(input,39,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getTableViewStyleAccess().getGroupedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getTableViewStyleAccess().getGroupedEnumLiteralDeclaration_1()); 
                        

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
    // $ANTLR end "ruleTableViewStyle"


    // $ANTLR start "ruleCellType"
    // InternalBug332217TestLanguage.g:1628:1: ruleCellType returns [Enumerator current=null] : ( (enumLiteral_0= 'Default' ) | (enumLiteral_1= 'Value1' ) | (enumLiteral_2= 'Value2' ) | (enumLiteral_3= 'Subtitle' ) ) ;
    public final Enumerator ruleCellType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalBug332217TestLanguage.g:1630:28: ( ( (enumLiteral_0= 'Default' ) | (enumLiteral_1= 'Value1' ) | (enumLiteral_2= 'Value2' ) | (enumLiteral_3= 'Subtitle' ) ) )
            // InternalBug332217TestLanguage.g:1631:1: ( (enumLiteral_0= 'Default' ) | (enumLiteral_1= 'Value1' ) | (enumLiteral_2= 'Value2' ) | (enumLiteral_3= 'Subtitle' ) )
            {
            // InternalBug332217TestLanguage.g:1631:1: ( (enumLiteral_0= 'Default' ) | (enumLiteral_1= 'Value1' ) | (enumLiteral_2= 'Value2' ) | (enumLiteral_3= 'Subtitle' ) )
            int alt22=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt22=1;
                }
                break;
            case 41:
                {
                alt22=2;
                }
                break;
            case 42:
                {
                alt22=3;
                }
                break;
            case 43:
                {
                alt22=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalBug332217TestLanguage.g:1631:2: (enumLiteral_0= 'Default' )
                    {
                    // InternalBug332217TestLanguage.g:1631:2: (enumLiteral_0= 'Default' )
                    // InternalBug332217TestLanguage.g:1631:4: enumLiteral_0= 'Default'
                    {
                    enumLiteral_0=(Token)match(input,40,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getCellTypeAccess().getDefaultEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCellTypeAccess().getDefaultEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBug332217TestLanguage.g:1637:6: (enumLiteral_1= 'Value1' )
                    {
                    // InternalBug332217TestLanguage.g:1637:6: (enumLiteral_1= 'Value1' )
                    // InternalBug332217TestLanguage.g:1637:8: enumLiteral_1= 'Value1'
                    {
                    enumLiteral_1=(Token)match(input,41,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getCellTypeAccess().getValue1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCellTypeAccess().getValue1EnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalBug332217TestLanguage.g:1643:6: (enumLiteral_2= 'Value2' )
                    {
                    // InternalBug332217TestLanguage.g:1643:6: (enumLiteral_2= 'Value2' )
                    // InternalBug332217TestLanguage.g:1643:8: enumLiteral_2= 'Value2'
                    {
                    enumLiteral_2=(Token)match(input,42,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getCellTypeAccess().getValue2EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getCellTypeAccess().getValue2EnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalBug332217TestLanguage.g:1649:6: (enumLiteral_3= 'Subtitle' )
                    {
                    // InternalBug332217TestLanguage.g:1649:6: (enumLiteral_3= 'Subtitle' )
                    // InternalBug332217TestLanguage.g:1649:8: enumLiteral_3= 'Subtitle'
                    {
                    enumLiteral_3=(Token)match(input,43,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getCellTypeAccess().getSubtitleEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getCellTypeAccess().getSubtitleEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleCellType"


    // $ANTLR start "ruleCellAccessory"
    // InternalBug332217TestLanguage.g:1659:1: ruleCellAccessory returns [Enumerator current=null] : ( (enumLiteral_0= 'None' ) | (enumLiteral_1= 'Link' ) | (enumLiteral_2= 'Detail' ) | (enumLiteral_3= 'Check' ) ) ;
    public final Enumerator ruleCellAccessory() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalBug332217TestLanguage.g:1661:28: ( ( (enumLiteral_0= 'None' ) | (enumLiteral_1= 'Link' ) | (enumLiteral_2= 'Detail' ) | (enumLiteral_3= 'Check' ) ) )
            // InternalBug332217TestLanguage.g:1662:1: ( (enumLiteral_0= 'None' ) | (enumLiteral_1= 'Link' ) | (enumLiteral_2= 'Detail' ) | (enumLiteral_3= 'Check' ) )
            {
            // InternalBug332217TestLanguage.g:1662:1: ( (enumLiteral_0= 'None' ) | (enumLiteral_1= 'Link' ) | (enumLiteral_2= 'Detail' ) | (enumLiteral_3= 'Check' ) )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt23=1;
                }
                break;
            case 45:
                {
                alt23=2;
                }
                break;
            case 46:
                {
                alt23=3;
                }
                break;
            case 47:
                {
                alt23=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalBug332217TestLanguage.g:1662:2: (enumLiteral_0= 'None' )
                    {
                    // InternalBug332217TestLanguage.g:1662:2: (enumLiteral_0= 'None' )
                    // InternalBug332217TestLanguage.g:1662:4: enumLiteral_0= 'None'
                    {
                    enumLiteral_0=(Token)match(input,44,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getCellAccessoryAccess().getNoneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCellAccessoryAccess().getNoneEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBug332217TestLanguage.g:1668:6: (enumLiteral_1= 'Link' )
                    {
                    // InternalBug332217TestLanguage.g:1668:6: (enumLiteral_1= 'Link' )
                    // InternalBug332217TestLanguage.g:1668:8: enumLiteral_1= 'Link'
                    {
                    enumLiteral_1=(Token)match(input,45,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getCellAccessoryAccess().getLinkEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCellAccessoryAccess().getLinkEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalBug332217TestLanguage.g:1674:6: (enumLiteral_2= 'Detail' )
                    {
                    // InternalBug332217TestLanguage.g:1674:6: (enumLiteral_2= 'Detail' )
                    // InternalBug332217TestLanguage.g:1674:8: enumLiteral_2= 'Detail'
                    {
                    enumLiteral_2=(Token)match(input,46,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getCellAccessoryAccess().getDetailEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getCellAccessoryAccess().getDetailEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalBug332217TestLanguage.g:1680:6: (enumLiteral_3= 'Check' )
                    {
                    // InternalBug332217TestLanguage.g:1680:6: (enumLiteral_3= 'Check' )
                    // InternalBug332217TestLanguage.g:1680:8: enumLiteral_3= 'Check'
                    {
                    enumLiteral_3=(Token)match(input,47,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getCellAccessoryAccess().getCheckEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getCellAccessoryAccess().getCheckEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleCellAccessory"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000002A030L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000002E030L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000090000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000402000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000F800000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000C000000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000400400000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000010800000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000014800000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000F0000000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000003E4000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000200002A030L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000F00000000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000000016A030L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000002000L});
    }


}