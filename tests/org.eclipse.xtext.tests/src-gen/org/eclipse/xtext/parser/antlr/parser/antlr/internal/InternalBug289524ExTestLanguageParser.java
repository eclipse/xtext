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
import org.eclipse.xtext.parser.antlr.services.Bug289524ExTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBug289524ExTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Containment", "Reference", "Model", "DollarSign", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=8;
    public static final int RULE_STRING=10;
    public static final int Model=6;
    public static final int DollarSign=7;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_INT=9;
    public static final int RULE_WS=13;
    public static final int RULE_SL_COMMENT=12;
    public static final int EOF=-1;
    public static final int Reference=5;
    public static final int Containment=4;
    public static final int RULE_ML_COMMENT=11;

    // delegates
    // delegators


        public InternalBug289524ExTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug289524ExTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug289524ExTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     

    	private Bug289524ExTestLanguageGrammarAccess grammarAccess;
    	 	
    	public InternalBug289524ExTestLanguageParser(TokenStream input, Bug289524ExTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Model";	
    	} 
    	   	   	
    	@Override
    	protected Bug289524ExTestLanguageGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:69:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel83); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:76:1: ruleModel returns [EObject current=null] : ( () otherlv_1= Model ( (lv_refs_2_0= ruleModelElement ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_refs_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:79:28: ( ( () otherlv_1= Model ( (lv_refs_2_0= ruleModelElement ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:80:1: ( () otherlv_1= Model ( (lv_refs_2_0= ruleModelElement ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:80:1: ( () otherlv_1= Model ( (lv_refs_2_0= ruleModelElement ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:80:2: () otherlv_1= Model ( (lv_refs_2_0= ruleModelElement ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:80:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:81:2: 
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

            otherlv_1=(Token)match(input,Model,FollowSets000.FOLLOW_Model_in_ruleModel133); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getModelKeyword_1());
                  
            }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:94:1: ( (lv_refs_2_0= ruleModelElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=Containment && LA1_0<=Reference)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:95:1: (lv_refs_2_0= ruleModelElement )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:95:1: (lv_refs_2_0= ruleModelElement )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:96:3: lv_refs_2_0= ruleModelElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getRefsModelElementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_ruleModel153);
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
            	              		"org.eclipse.xtext.parser.antlr.Bug289524ExTestLanguage.ModelElement");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:120:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:121:2: (iv_ruleModelElement= ruleModelElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:122:2: iv_ruleModelElement= ruleModelElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_entryRuleModelElement189);
            iv_ruleModelElement=ruleModelElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelElement199); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:129:1: ruleModelElement returns [EObject current=null] : ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )* ) )+ ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_containments_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:132:28: ( ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )* ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:133:1: ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )* ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:133:1: ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )* ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:133:2: () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )* ) )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:133:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:134:2: 
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:142:2: ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )* ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Containment) ) {
                    int LA3_2 = input.LA(2);

                    if ( (synpred2_InternalBug289524ExTestLanguageParser()) ) {
                        alt3=1;
                    }


                }
                else if ( (LA3_0==Reference) ) {
                    int LA3_3 = input.LA(2);

                    if ( (synpred4_InternalBug289524ExTestLanguageParser()) ) {
                        alt3=2;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:142:3: ( (lv_containments_1_0= ruleContained ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:142:3: ( (lv_containments_1_0= ruleContained ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:143:1: (lv_containments_1_0= ruleContained )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:143:1: (lv_containments_1_0= ruleContained )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:144:3: lv_containments_1_0= ruleContained
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleContained_in_ruleModelElement258);
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
            	              		"org.eclipse.xtext.parser.antlr.Bug289524ExTestLanguage.Contained");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:161:6: (otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )* )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:161:6: (otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )* )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:162:2: otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )*
            	    {
            	    otherlv_2=(Token)match(input,Reference,FollowSets000.FOLLOW_Reference_in_ruleModelElement278); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getModelElementAccess().getReferenceKeyword_1_1_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:166:1: ( (otherlv_3= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:167:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:167:1: (otherlv_3= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:168:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getModelElementRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement301); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getModelElementAccess().getRefsContainedCrossReference_1_1_1_0()); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:182:2: (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==DollarSign) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:183:2: otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) )
            	    	    {
            	    	    otherlv_4=(Token)match(input,DollarSign,FollowSets000.FOLLOW_DollarSign_in_ruleModelElement315); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	          	newLeafNode(otherlv_4, grammarAccess.getModelElementAccess().getDollarSignKeyword_1_1_2_0());
            	    	          
            	    	    }
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:187:1: ( (otherlv_5= RULE_ID ) )
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:188:1: (otherlv_5= RULE_ID )
            	    	    {
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:188:1: (otherlv_5= RULE_ID )
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:189:3: otherlv_5= RULE_ID
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      		  /* */ 
            	    	      		
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = createModelElement(grammarAccess.getModelElementRule());
            	    	      	        }
            	    	              
            	    	    }
            	    	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement338); if (state.failed) return current;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:211:1: entryRuleContained returns [EObject current=null] : iv_ruleContained= ruleContained EOF ;
    public final EObject entryRuleContained() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContained = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:212:2: (iv_ruleContained= ruleContained EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:213:2: iv_ruleContained= ruleContained EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainedRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleContained_in_entryRuleContained378);
            iv_ruleContained=ruleContained();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContained; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContained388); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:220:1: ruleContained returns [EObject current=null] : (otherlv_0= Containment ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleContained() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:223:28: ( (otherlv_0= Containment ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:224:1: (otherlv_0= Containment ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:224:1: (otherlv_0= Containment ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:225:2: otherlv_0= Containment ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,Containment,FollowSets000.FOLLOW_Containment_in_ruleContained426); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getContainedAccess().getContainmentKeyword_0());
                  
            }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:229:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:230:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:230:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:231:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleContained442); if (state.failed) return current;
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

    // $ANTLR start synpred2_InternalBug289524ExTestLanguageParser
    public final void synpred2_InternalBug289524ExTestLanguageParser_fragment() throws RecognitionException {   
        EObject lv_containments_1_0 = null;


        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:142:3: ( ( (lv_containments_1_0= ruleContained ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:142:3: ( (lv_containments_1_0= ruleContained ) )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:142:3: ( (lv_containments_1_0= ruleContained ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:143:1: (lv_containments_1_0= ruleContained )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:143:1: (lv_containments_1_0= ruleContained )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:144:3: lv_containments_1_0= ruleContained
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleContained_in_synpred2_InternalBug289524ExTestLanguageParser258);
        lv_containments_1_0=ruleContained();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred2_InternalBug289524ExTestLanguageParser

    // $ANTLR start synpred4_InternalBug289524ExTestLanguageParser
    public final void synpred4_InternalBug289524ExTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:161:6: ( (otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )* ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:161:6: (otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )* )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:161:6: (otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )* )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:162:2: otherlv_2= Reference ( (otherlv_3= RULE_ID ) ) (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )*
        {
        otherlv_2=(Token)match(input,Reference,FollowSets000.FOLLOW_Reference_in_synpred4_InternalBug289524ExTestLanguageParser278); if (state.failed) return ;
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:166:1: ( (otherlv_3= RULE_ID ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:167:1: (otherlv_3= RULE_ID )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:167:1: (otherlv_3= RULE_ID )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:168:3: otherlv_3= RULE_ID
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred4_InternalBug289524ExTestLanguageParser301); if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:182:2: (otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) ) )*
        loop4:
        do {
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==DollarSign) ) {
                alt4=1;
            }


            switch (alt4) {
        	case 1 :
        	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:183:2: otherlv_4= DollarSign ( (otherlv_5= RULE_ID ) )
        	    {
        	    otherlv_4=(Token)match(input,DollarSign,FollowSets000.FOLLOW_DollarSign_in_synpred4_InternalBug289524ExTestLanguageParser315); if (state.failed) return ;
        	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:187:1: ( (otherlv_5= RULE_ID ) )
        	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:188:1: (otherlv_5= RULE_ID )
        	    {
        	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:188:1: (otherlv_5= RULE_ID )
        	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:189:3: otherlv_5= RULE_ID
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      		  /* */ 
        	      		
        	    }
        	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred4_InternalBug289524ExTestLanguageParser338); if (state.failed) return ;

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
    // $ANTLR end synpred4_InternalBug289524ExTestLanguageParser

    // Delegated rules

    public final boolean synpred2_InternalBug289524ExTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalBug289524ExTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalBug289524ExTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalBug289524ExTestLanguageParser_fragment(); // can never throw exception
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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_Model_in_ruleModel133 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_ruleModelElement_in_ruleModel153 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelElement199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContained_in_ruleModelElement258 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_Reference_in_ruleModelElement278 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement301 = new BitSet(new long[]{0x00000000000000B2L});
        public static final BitSet FOLLOW_DollarSign_in_ruleModelElement315 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement338 = new BitSet(new long[]{0x00000000000000B2L});
        public static final BitSet FOLLOW_ruleContained_in_entryRuleContained378 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContained388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_Containment_in_ruleContained426 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleContained442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContained_in_synpred2_InternalBug289524ExTestLanguageParser258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_Reference_in_synpred4_InternalBug289524ExTestLanguageParser278 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred4_InternalBug289524ExTestLanguageParser301 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_DollarSign_in_synpred4_InternalBug289524ExTestLanguageParser315 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred4_InternalBug289524ExTestLanguageParser338 = new BitSet(new long[]{0x0000000000000082L});
    }


}