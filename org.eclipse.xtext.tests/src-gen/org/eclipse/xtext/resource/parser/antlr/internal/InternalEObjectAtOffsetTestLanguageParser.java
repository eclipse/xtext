package org.eclipse.xtext.resource.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.resource.services.EObjectAtOffsetTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEObjectAtOffsetTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'zonk'", "'foobar'", "'bar'", "','", "'foo'", "'='", "'.'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=4;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalEObjectAtOffsetTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEObjectAtOffsetTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEObjectAtOffsetTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEObjectAtOffsetTestLanguage.g"; }



     	private EObjectAtOffsetTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEObjectAtOffsetTestLanguageParser(TokenStream input, EObjectAtOffsetTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected EObjectAtOffsetTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalEObjectAtOffsetTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalEObjectAtOffsetTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalEObjectAtOffsetTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalEObjectAtOffsetTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_foos_0_0 = null;

        EObject lv_bars_1_0 = null;


         enterRule(); 
            
        try {
            // InternalEObjectAtOffsetTestLanguage.g:79:28: ( ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )* )
            // InternalEObjectAtOffsetTestLanguage.g:80:1: ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )*
            {
            // InternalEObjectAtOffsetTestLanguage.g:80:1: ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }
                else if ( (LA1_0==RULE_INT||LA1_0==11||LA1_0==13) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalEObjectAtOffsetTestLanguage.g:80:2: ( (lv_foos_0_0= ruleFoo ) )
            	    {
            	    // InternalEObjectAtOffsetTestLanguage.g:80:2: ( (lv_foos_0_0= ruleFoo ) )
            	    // InternalEObjectAtOffsetTestLanguage.g:81:1: (lv_foos_0_0= ruleFoo )
            	    {
            	    // InternalEObjectAtOffsetTestLanguage.g:81:1: (lv_foos_0_0= ruleFoo )
            	    // InternalEObjectAtOffsetTestLanguage.g:82:3: lv_foos_0_0= ruleFoo
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getFoosFooParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_foos_0_0=ruleFoo();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"foos",
            	            		lv_foos_0_0, 
            	            		"org.eclipse.xtext.resource.EObjectAtOffsetTestLanguage.Foo");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalEObjectAtOffsetTestLanguage.g:99:6: ( (lv_bars_1_0= ruleAbstractBar ) )
            	    {
            	    // InternalEObjectAtOffsetTestLanguage.g:99:6: ( (lv_bars_1_0= ruleAbstractBar ) )
            	    // InternalEObjectAtOffsetTestLanguage.g:100:1: (lv_bars_1_0= ruleAbstractBar )
            	    {
            	    // InternalEObjectAtOffsetTestLanguage.g:100:1: (lv_bars_1_0= ruleAbstractBar )
            	    // InternalEObjectAtOffsetTestLanguage.g:101:3: lv_bars_1_0= ruleAbstractBar
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getBarsAbstractBarParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_bars_1_0=ruleAbstractBar();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bars",
            	            		lv_bars_1_0, 
            	            		"org.eclipse.xtext.resource.EObjectAtOffsetTestLanguage.AbstractBar");
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


    // $ANTLR start "entryRuleAbstractBar"
    // InternalEObjectAtOffsetTestLanguage.g:125:1: entryRuleAbstractBar returns [EObject current=null] : iv_ruleAbstractBar= ruleAbstractBar EOF ;
    public final EObject entryRuleAbstractBar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractBar = null;


        try {
            // InternalEObjectAtOffsetTestLanguage.g:126:2: (iv_ruleAbstractBar= ruleAbstractBar EOF )
            // InternalEObjectAtOffsetTestLanguage.g:127:2: iv_ruleAbstractBar= ruleAbstractBar EOF
            {
             newCompositeNode(grammarAccess.getAbstractBarRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractBar=ruleAbstractBar();

            state._fsp--;

             current =iv_ruleAbstractBar; 
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
    // $ANTLR end "entryRuleAbstractBar"


    // $ANTLR start "ruleAbstractBar"
    // InternalEObjectAtOffsetTestLanguage.g:134:1: ruleAbstractBar returns [EObject current=null] : ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? this_Bar_2= ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )? ) ;
    public final EObject ruleAbstractBar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_INT_1=null;
        Token otherlv_4=null;
        EObject this_Bar_2 = null;


         enterRule(); 
            
        try {
            // InternalEObjectAtOffsetTestLanguage.g:137:28: ( ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? this_Bar_2= ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )? ) )
            // InternalEObjectAtOffsetTestLanguage.g:138:1: ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? this_Bar_2= ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )? )
            {
            // InternalEObjectAtOffsetTestLanguage.g:138:1: ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? this_Bar_2= ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )? )
            // InternalEObjectAtOffsetTestLanguage.g:138:2: (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? this_Bar_2= ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )?
            {
            // InternalEObjectAtOffsetTestLanguage.g:138:2: (otherlv_0= 'zonk' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalEObjectAtOffsetTestLanguage.g:138:4: otherlv_0= 'zonk'
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_0, grammarAccess.getAbstractBarAccess().getZonkKeyword_0());
                        

                    }
                    break;

            }

            // InternalEObjectAtOffsetTestLanguage.g:142:3: (this_INT_1= RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalEObjectAtOffsetTestLanguage.g:142:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 
                     
                        newLeafNode(this_INT_1, grammarAccess.getAbstractBarAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getAbstractBarAccess().getBarParserRuleCall_2()); 
                
            pushFollow(FollowSets000.FOLLOW_5);
            this_Bar_2=ruleBar();

            state._fsp--;

             
                    current = this_Bar_2; 
                    afterParserOrEnumRuleCall();
                
            // InternalEObjectAtOffsetTestLanguage.g:155:1: ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalEObjectAtOffsetTestLanguage.g:155:2: () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) )
                    {
                    // InternalEObjectAtOffsetTestLanguage.g:155:2: ()
                    // InternalEObjectAtOffsetTestLanguage.g:156:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getAbstractBarAccess().getFooBarBarAction_3_0(),
                                current);
                        

                    }

                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_4, grammarAccess.getAbstractBarAccess().getFoobarKeyword_3_1());
                        
                    // InternalEObjectAtOffsetTestLanguage.g:165:1: ( ( ruleQualifiedNameWithOtherDelim ) )
                    // InternalEObjectAtOffsetTestLanguage.g:166:1: ( ruleQualifiedNameWithOtherDelim )
                    {
                    // InternalEObjectAtOffsetTestLanguage.g:166:1: ( ruleQualifiedNameWithOtherDelim )
                    // InternalEObjectAtOffsetTestLanguage.g:167:3: ruleQualifiedNameWithOtherDelim
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAbstractBarRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getAbstractBarAccess().getFooFooCrossReference_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_7);
                    ruleQualifiedNameWithOtherDelim();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalEObjectAtOffsetTestLanguage.g:180:4: ( ( ruleQualifiedNameWithOtherDelim ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalEObjectAtOffsetTestLanguage.g:181:1: ( ruleQualifiedNameWithOtherDelim )
                    {
                    // InternalEObjectAtOffsetTestLanguage.g:181:1: ( ruleQualifiedNameWithOtherDelim )
                    // InternalEObjectAtOffsetTestLanguage.g:182:3: ruleQualifiedNameWithOtherDelim
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAbstractBarRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getAbstractBarAccess().getFooFooCrossReference_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleQualifiedNameWithOtherDelim();

                    state._fsp--;

                     
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
    // $ANTLR end "ruleAbstractBar"


    // $ANTLR start "entryRuleBar"
    // InternalEObjectAtOffsetTestLanguage.g:203:1: entryRuleBar returns [EObject current=null] : iv_ruleBar= ruleBar EOF ;
    public final EObject entryRuleBar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBar = null;


        try {
            // InternalEObjectAtOffsetTestLanguage.g:204:2: (iv_ruleBar= ruleBar EOF )
            // InternalEObjectAtOffsetTestLanguage.g:205:2: iv_ruleBar= ruleBar EOF
            {
             newCompositeNode(grammarAccess.getBarRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBar=ruleBar();

            state._fsp--;

             current =iv_ruleBar; 
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
    // $ANTLR end "entryRuleBar"


    // $ANTLR start "ruleBar"
    // InternalEObjectAtOffsetTestLanguage.g:212:1: ruleBar returns [EObject current=null] : (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )* ) ;
    public final EObject ruleBar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalEObjectAtOffsetTestLanguage.g:215:28: ( (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )* ) )
            // InternalEObjectAtOffsetTestLanguage.g:216:1: (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )* )
            {
            // InternalEObjectAtOffsetTestLanguage.g:216:1: (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )* )
            // InternalEObjectAtOffsetTestLanguage.g:216:3: otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )*
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getBarAccess().getBarKeyword_0());
                
            // InternalEObjectAtOffsetTestLanguage.g:220:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalEObjectAtOffsetTestLanguage.g:221:1: (lv_name_1_0= RULE_ID )
            {
            // InternalEObjectAtOffsetTestLanguage.g:221:1: (lv_name_1_0= RULE_ID )
            // InternalEObjectAtOffsetTestLanguage.g:222:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            			newLeafNode(lv_name_1_0, grammarAccess.getBarAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBarRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalEObjectAtOffsetTestLanguage.g:238:2: ( ( ruleQualifiedNameWithOtherDelim ) )
            // InternalEObjectAtOffsetTestLanguage.g:239:1: ( ruleQualifiedNameWithOtherDelim )
            {
            // InternalEObjectAtOffsetTestLanguage.g:239:1: ( ruleQualifiedNameWithOtherDelim )
            // InternalEObjectAtOffsetTestLanguage.g:240:3: ruleQualifiedNameWithOtherDelim
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBarRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getBarAccess().getFooFooCrossReference_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_8);
            ruleQualifiedNameWithOtherDelim();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalEObjectAtOffsetTestLanguage.g:253:2: (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalEObjectAtOffsetTestLanguage.g:253:4: otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) )
            	    {
            	    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            	        	newLeafNode(otherlv_3, grammarAccess.getBarAccess().getCommaKeyword_3_0());
            	        
            	    // InternalEObjectAtOffsetTestLanguage.g:257:1: ( ( ruleQualifiedNameWithOtherDelim ) )
            	    // InternalEObjectAtOffsetTestLanguage.g:258:1: ( ruleQualifiedNameWithOtherDelim )
            	    {
            	    // InternalEObjectAtOffsetTestLanguage.g:258:1: ( ruleQualifiedNameWithOtherDelim )
            	    // InternalEObjectAtOffsetTestLanguage.g:259:3: ruleQualifiedNameWithOtherDelim
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getBarRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getBarAccess().getFooFooCrossReference_3_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    ruleQualifiedNameWithOtherDelim();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


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
    // $ANTLR end "ruleBar"


    // $ANTLR start "entryRuleFoo"
    // InternalEObjectAtOffsetTestLanguage.g:280:1: entryRuleFoo returns [EObject current=null] : iv_ruleFoo= ruleFoo EOF ;
    public final EObject entryRuleFoo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoo = null;


        try {
            // InternalEObjectAtOffsetTestLanguage.g:281:2: (iv_ruleFoo= ruleFoo EOF )
            // InternalEObjectAtOffsetTestLanguage.g:282:2: iv_ruleFoo= ruleFoo EOF
            {
             newCompositeNode(grammarAccess.getFooRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFoo=ruleFoo();

            state._fsp--;

             current =iv_ruleFoo; 
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
    // $ANTLR end "entryRuleFoo"


    // $ANTLR start "ruleFoo"
    // InternalEObjectAtOffsetTestLanguage.g:289:1: ruleFoo returns [EObject current=null] : (otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) ) ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalEObjectAtOffsetTestLanguage.g:292:28: ( (otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) ) ) )
            // InternalEObjectAtOffsetTestLanguage.g:293:1: (otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) ) )
            {
            // InternalEObjectAtOffsetTestLanguage.g:293:1: (otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) ) )
            // InternalEObjectAtOffsetTestLanguage.g:293:3: otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getFooAccess().getFooKeyword_0());
                
            // InternalEObjectAtOffsetTestLanguage.g:297:1: ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) )
            // InternalEObjectAtOffsetTestLanguage.g:298:1: (lv_name_1_0= ruleQualifiedNameWithOtherDelim )
            {
            // InternalEObjectAtOffsetTestLanguage.g:298:1: (lv_name_1_0= ruleQualifiedNameWithOtherDelim )
            // InternalEObjectAtOffsetTestLanguage.g:299:3: lv_name_1_0= ruleQualifiedNameWithOtherDelim
            {
             
            	        newCompositeNode(grammarAccess.getFooAccess().getNameQualifiedNameWithOtherDelimParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_name_1_0=ruleQualifiedNameWithOtherDelim();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFooRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.resource.EObjectAtOffsetTestLanguage.QualifiedNameWithOtherDelim");
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
    // $ANTLR end "ruleFoo"


    // $ANTLR start "entryRuleQualifiedNameWithOtherDelim"
    // InternalEObjectAtOffsetTestLanguage.g:323:1: entryRuleQualifiedNameWithOtherDelim returns [String current=null] : iv_ruleQualifiedNameWithOtherDelim= ruleQualifiedNameWithOtherDelim EOF ;
    public final String entryRuleQualifiedNameWithOtherDelim() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithOtherDelim = null;


        try {
            // InternalEObjectAtOffsetTestLanguage.g:324:2: (iv_ruleQualifiedNameWithOtherDelim= ruleQualifiedNameWithOtherDelim EOF )
            // InternalEObjectAtOffsetTestLanguage.g:325:2: iv_ruleQualifiedNameWithOtherDelim= ruleQualifiedNameWithOtherDelim EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithOtherDelimRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQualifiedNameWithOtherDelim=ruleQualifiedNameWithOtherDelim();

            state._fsp--;

             current =iv_ruleQualifiedNameWithOtherDelim.getText(); 
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
    // $ANTLR end "entryRuleQualifiedNameWithOtherDelim"


    // $ANTLR start "ruleQualifiedNameWithOtherDelim"
    // InternalEObjectAtOffsetTestLanguage.g:332:1: ruleQualifiedNameWithOtherDelim returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '=' this_QualifiedName_2= ruleQualifiedName )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithOtherDelim() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;

        AntlrDatatypeRuleToken this_QualifiedName_2 = null;


         enterRule(); 
            
        try {
            // InternalEObjectAtOffsetTestLanguage.g:335:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '=' this_QualifiedName_2= ruleQualifiedName )* ) )
            // InternalEObjectAtOffsetTestLanguage.g:336:1: (this_QualifiedName_0= ruleQualifiedName (kw= '=' this_QualifiedName_2= ruleQualifiedName )* )
            {
            // InternalEObjectAtOffsetTestLanguage.g:336:1: (this_QualifiedName_0= ruleQualifiedName (kw= '=' this_QualifiedName_2= ruleQualifiedName )* )
            // InternalEObjectAtOffsetTestLanguage.g:337:5: this_QualifiedName_0= ruleQualifiedName (kw= '=' this_QualifiedName_2= ruleQualifiedName )*
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithOtherDelimAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_9);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalEObjectAtOffsetTestLanguage.g:347:1: (kw= '=' this_QualifiedName_2= ruleQualifiedName )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalEObjectAtOffsetTestLanguage.g:348:2: kw= '=' this_QualifiedName_2= ruleQualifiedName
            	    {
            	    kw=(Token)match(input,16,FollowSets000.FOLLOW_6); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameWithOtherDelimAccess().getEqualsSignKeyword_1_0()); 
            	        
            	     
            	            newCompositeNode(grammarAccess.getQualifiedNameWithOtherDelimAccess().getQualifiedNameParserRuleCall_1_1()); 
            	        
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    this_QualifiedName_2=ruleQualifiedName();

            	    state._fsp--;


            	    		current.merge(this_QualifiedName_2);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

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
    // $ANTLR end "ruleQualifiedNameWithOtherDelim"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalEObjectAtOffsetTestLanguage.g:372:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalEObjectAtOffsetTestLanguage.g:373:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalEObjectAtOffsetTestLanguage.g:374:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalEObjectAtOffsetTestLanguage.g:381:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalEObjectAtOffsetTestLanguage.g:384:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalEObjectAtOffsetTestLanguage.g:385:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalEObjectAtOffsetTestLanguage.g:385:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalEObjectAtOffsetTestLanguage.g:385:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // InternalEObjectAtOffsetTestLanguage.g:392:1: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalEObjectAtOffsetTestLanguage.g:393:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,17,FollowSets000.FOLLOW_6); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000A812L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000000B830L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001022L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020002L});
    }


}