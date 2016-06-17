package org.eclipse.xtext.parser.antlr.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.services.Bug289524TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBug289524TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Model'", "'reference'", "'$'", "'containment'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug289524TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug289524TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug289524TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug289524TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private Bug289524TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug289524TestLanguageParser(TokenStream input, Bug289524TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug289524TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalBug289524TestLanguage.g:73:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug289524TestLanguage.g:74:2: (iv_ruleModel= ruleModel EOF )
            // InternalBug289524TestLanguage.g:75:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // InternalBug289524TestLanguage.g:82:1: ruleModel returns [EObject current=null] : ( () otherlv_1= 'Model' ( (lv_refs_2_0= ruleModelElement ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_refs_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBug289524TestLanguage.g:85:28: ( ( () otherlv_1= 'Model' ( (lv_refs_2_0= ruleModelElement ) )* ) )
            // InternalBug289524TestLanguage.g:86:1: ( () otherlv_1= 'Model' ( (lv_refs_2_0= ruleModelElement ) )* )
            {
            // InternalBug289524TestLanguage.g:86:1: ( () otherlv_1= 'Model' ( (lv_refs_2_0= ruleModelElement ) )* )
            // InternalBug289524TestLanguage.g:86:2: () otherlv_1= 'Model' ( (lv_refs_2_0= ruleModelElement ) )*
            {
            // InternalBug289524TestLanguage.g:86:2: ()
            // InternalBug289524TestLanguage.g:87:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getModelAccess().getModelAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getModelKeyword_1());
                  
            }
            // InternalBug289524TestLanguage.g:99:1: ( (lv_refs_2_0= ruleModelElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug289524TestLanguage.g:100:1: (lv_refs_2_0= ruleModelElement )
            	    {
            	    // InternalBug289524TestLanguage.g:100:1: (lv_refs_2_0= ruleModelElement )
            	    // InternalBug289524TestLanguage.g:101:3: lv_refs_2_0= ruleModelElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getRefsModelElementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_refs_2_0=ruleModelElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"refs",
            	              		lv_refs_2_0, 
            	              		"org.eclipse.xtext.parser.antlr.Bug289524TestLanguage.ModelElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleModelElement"
    // InternalBug289524TestLanguage.g:125:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // InternalBug289524TestLanguage.g:126:2: (iv_ruleModelElement= ruleModelElement EOF )
            // InternalBug289524TestLanguage.g:127:2: iv_ruleModelElement= ruleModelElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModelElement=ruleModelElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleModelElement"


    // $ANTLR start "ruleModelElement"
    // InternalBug289524TestLanguage.g:134:1: ruleModelElement returns [EObject current=null] : ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )+ ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_containments_1_0 = null;


         enterRule(); 
            
        try {
            // InternalBug289524TestLanguage.g:137:28: ( ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )+ ) )
            // InternalBug289524TestLanguage.g:138:1: ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )+ )
            {
            // InternalBug289524TestLanguage.g:138:1: ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )+ )
            // InternalBug289524TestLanguage.g:138:2: () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )+
            {
            // InternalBug289524TestLanguage.g:138:2: ()
            // InternalBug289524TestLanguage.g:139:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getModelElementAccess().getModelElementAction_0(),
                          current);
                  
            }

            }

            // InternalBug289524TestLanguage.g:147:2: ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    int LA3_2 = input.LA(2);

                    if ( (synpred2_InternalBug289524TestLanguage()) ) {
                        alt3=1;
                    }


                }
                else if ( (LA3_0==12) ) {
                    int LA3_3 = input.LA(2);

                    if ( (synpred4_InternalBug289524TestLanguage()) ) {
                        alt3=2;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug289524TestLanguage.g:147:3: ( (lv_containments_1_0= ruleContained ) )
            	    {
            	    // InternalBug289524TestLanguage.g:147:3: ( (lv_containments_1_0= ruleContained ) )
            	    // InternalBug289524TestLanguage.g:148:1: (lv_containments_1_0= ruleContained )
            	    {
            	    // InternalBug289524TestLanguage.g:148:1: (lv_containments_1_0= ruleContained )
            	    // InternalBug289524TestLanguage.g:149:3: lv_containments_1_0= ruleContained
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_containments_1_0=ruleContained();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelElementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"containments",
            	              		lv_containments_1_0, 
            	              		"org.eclipse.xtext.parser.antlr.Bug289524TestLanguage.Contained");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBug289524TestLanguage.g:166:6: (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* )
            	    {
            	    // InternalBug289524TestLanguage.g:166:6: (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* )
            	    // InternalBug289524TestLanguage.g:166:8: otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )*
            	    {
            	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getModelElementAccess().getReferenceKeyword_1_1_0());
            	          
            	    }
            	    // InternalBug289524TestLanguage.g:170:1: ( (otherlv_3= RULE_ID ) )
            	    // InternalBug289524TestLanguage.g:171:1: (otherlv_3= RULE_ID )
            	    {
            	    // InternalBug289524TestLanguage.g:171:1: (otherlv_3= RULE_ID )
            	    // InternalBug289524TestLanguage.g:172:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getModelElementRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getModelElementAccess().getRefsContainedCrossReference_1_1_1_0()); 
            	      	
            	    }

            	    }


            	    }

            	    // InternalBug289524TestLanguage.g:186:2: (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==13) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalBug289524TestLanguage.g:186:4: otherlv_4= '$' ( (otherlv_5= RULE_ID ) )
            	    	    {
            	    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	          	newLeafNode(otherlv_4, grammarAccess.getModelElementAccess().getDollarSignKeyword_1_1_2_0());
            	    	          
            	    	    }
            	    	    // InternalBug289524TestLanguage.g:190:1: ( (otherlv_5= RULE_ID ) )
            	    	    // InternalBug289524TestLanguage.g:191:1: (otherlv_5= RULE_ID )
            	    	    {
            	    	    // InternalBug289524TestLanguage.g:191:1: (otherlv_5= RULE_ID )
            	    	    // InternalBug289524TestLanguage.g:192:3: otherlv_5= RULE_ID
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      		  /* */ 
            	    	      		
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = createModelElement(grammarAccess.getModelElementRule());
            	    	      	        }
            	    	              
            	    	    }
            	    	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      		newLeafNode(otherlv_5, grammarAccess.getModelElementAccess().getRefsContainedCrossReference_1_1_2_1_0()); 
            	    	      	
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleModelElement"


    // $ANTLR start "entryRuleContained"
    // InternalBug289524TestLanguage.g:214:1: entryRuleContained returns [EObject current=null] : iv_ruleContained= ruleContained EOF ;
    public final EObject entryRuleContained() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContained = null;


        try {
            // InternalBug289524TestLanguage.g:215:2: (iv_ruleContained= ruleContained EOF )
            // InternalBug289524TestLanguage.g:216:2: iv_ruleContained= ruleContained EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainedRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContained=ruleContained();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContained; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleContained"


    // $ANTLR start "ruleContained"
    // InternalBug289524TestLanguage.g:223:1: ruleContained returns [EObject current=null] : (otherlv_0= 'containment' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleContained() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalBug289524TestLanguage.g:226:28: ( (otherlv_0= 'containment' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalBug289524TestLanguage.g:227:1: (otherlv_0= 'containment' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalBug289524TestLanguage.g:227:1: (otherlv_0= 'containment' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalBug289524TestLanguage.g:227:3: otherlv_0= 'containment' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getContainedAccess().getContainmentKeyword_0());
                  
            }
            // InternalBug289524TestLanguage.g:231:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalBug289524TestLanguage.g:232:1: (lv_name_1_0= RULE_ID )
            {
            // InternalBug289524TestLanguage.g:232:1: (lv_name_1_0= RULE_ID )
            // InternalBug289524TestLanguage.g:233:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getContainedAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getContainedRule());
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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleContained"

    // $ANTLR start synpred2_InternalBug289524TestLanguage
    public final void synpred2_InternalBug289524TestLanguage_fragment() throws RecognitionException {   
        EObject lv_containments_1_0 = null;


        // InternalBug289524TestLanguage.g:147:3: ( ( (lv_containments_1_0= ruleContained ) ) )
        // InternalBug289524TestLanguage.g:147:3: ( (lv_containments_1_0= ruleContained ) )
        {
        // InternalBug289524TestLanguage.g:147:3: ( (lv_containments_1_0= ruleContained ) )
        // InternalBug289524TestLanguage.g:148:1: (lv_containments_1_0= ruleContained )
        {
        // InternalBug289524TestLanguage.g:148:1: (lv_containments_1_0= ruleContained )
        // InternalBug289524TestLanguage.g:149:3: lv_containments_1_0= ruleContained
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_containments_1_0=ruleContained();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred2_InternalBug289524TestLanguage

    // $ANTLR start synpred4_InternalBug289524TestLanguage
    public final void synpred4_InternalBug289524TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        // InternalBug289524TestLanguage.g:166:6: ( (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* ) )
        // InternalBug289524TestLanguage.g:166:6: (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* )
        {
        // InternalBug289524TestLanguage.g:166:6: (otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )* )
        // InternalBug289524TestLanguage.g:166:8: otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )*
        {
        otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // InternalBug289524TestLanguage.g:170:1: ( (otherlv_3= RULE_ID ) )
        // InternalBug289524TestLanguage.g:171:1: (otherlv_3= RULE_ID )
        {
        // InternalBug289524TestLanguage.g:171:1: (otherlv_3= RULE_ID )
        // InternalBug289524TestLanguage.g:172:3: otherlv_3= RULE_ID
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return ;

        }


        }

        // InternalBug289524TestLanguage.g:186:2: (otherlv_4= '$' ( (otherlv_5= RULE_ID ) ) )*
        loop4:
        do {
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }


            switch (alt4) {
        	case 1 :
        	    // InternalBug289524TestLanguage.g:186:4: otherlv_4= '$' ( (otherlv_5= RULE_ID ) )
        	    {
        	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_4); if (state.failed) return ;
        	    // InternalBug289524TestLanguage.g:190:1: ( (otherlv_5= RULE_ID ) )
        	    // InternalBug289524TestLanguage.g:191:1: (otherlv_5= RULE_ID )
        	    {
        	    // InternalBug289524TestLanguage.g:191:1: (otherlv_5= RULE_ID )
        	    // InternalBug289524TestLanguage.g:192:3: otherlv_5= RULE_ID
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      		  /* */ 
        	      		
        	    }
        	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop4;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred4_InternalBug289524TestLanguage

    // Delegated rules

    public final boolean synpred2_InternalBug289524TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalBug289524TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalBug289524TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalBug289524TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000007002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002002L});
    }


}