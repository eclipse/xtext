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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'zonk'", "'foobar'", "'bar'", "','", "'foo'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=6;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalEObjectAtOffsetTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEObjectAtOffsetTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEObjectAtOffsetTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g"; }



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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_foos_0_0 = null;

        EObject lv_bars_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:79:28: ( ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:80:1: ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:80:1: ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:80:2: ( (lv_foos_0_0= ruleFoo ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:80:2: ( (lv_foos_0_0= ruleFoo ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:81:1: (lv_foos_0_0= ruleFoo )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:81:1: (lv_foos_0_0= ruleFoo )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:82:3: lv_foos_0_0= ruleFoo
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getFoosFooParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFoo_in_ruleModel131);
            	    lv_foos_0_0=ruleFoo();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"foos",
            	            		lv_foos_0_0, 
            	            		"Foo");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:99:6: ( (lv_bars_1_0= ruleAbstractBar ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:99:6: ( (lv_bars_1_0= ruleAbstractBar ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:100:1: (lv_bars_1_0= ruleAbstractBar )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:100:1: (lv_bars_1_0= ruleAbstractBar )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:101:3: lv_bars_1_0= ruleAbstractBar
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getBarsAbstractBarParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractBar_in_ruleModel158);
            	    lv_bars_1_0=ruleAbstractBar();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bars",
            	            		lv_bars_1_0, 
            	            		"AbstractBar");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:125:1: entryRuleAbstractBar returns [EObject current=null] : iv_ruleAbstractBar= ruleAbstractBar EOF ;
    public final EObject entryRuleAbstractBar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractBar = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:126:2: (iv_ruleAbstractBar= ruleAbstractBar EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:127:2: iv_ruleAbstractBar= ruleAbstractBar EOF
            {
             newCompositeNode(grammarAccess.getAbstractBarRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractBar_in_entryRuleAbstractBar195);
            iv_ruleAbstractBar=ruleAbstractBar();

            state._fsp--;

             current =iv_ruleAbstractBar; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractBar205); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:134:1: ruleAbstractBar returns [EObject current=null] : ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? this_Bar_2= ruleBar ( () otherlv_4= 'foobar' ( (otherlv_5= RULE_ID ) ) )? ( (otherlv_6= RULE_ID ) )? ) ;
    public final EObject ruleAbstractBar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_INT_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject this_Bar_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:137:28: ( ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? this_Bar_2= ruleBar ( () otherlv_4= 'foobar' ( (otherlv_5= RULE_ID ) ) )? ( (otherlv_6= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:138:1: ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? this_Bar_2= ruleBar ( () otherlv_4= 'foobar' ( (otherlv_5= RULE_ID ) ) )? ( (otherlv_6= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:138:1: ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? this_Bar_2= ruleBar ( () otherlv_4= 'foobar' ( (otherlv_5= RULE_ID ) ) )? ( (otherlv_6= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:138:2: (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? this_Bar_2= ruleBar ( () otherlv_4= 'foobar' ( (otherlv_5= RULE_ID ) ) )? ( (otherlv_6= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:138:2: (otherlv_0= 'zonk' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:138:4: otherlv_0= 'zonk'
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleAbstractBar243); 

                        	newLeafNode(otherlv_0, grammarAccess.getAbstractBarAccess().getZonkKeyword_0());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:142:3: (this_INT_1= RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:142:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAbstractBar257); 
                     
                        newLeafNode(this_INT_1, grammarAccess.getAbstractBarAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getAbstractBarAccess().getBarParserRuleCall_2()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleBar_in_ruleAbstractBar280);
            this_Bar_2=ruleBar();

            state._fsp--;

             
                    current = this_Bar_2; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:155:1: ( () otherlv_4= 'foobar' ( (otherlv_5= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:155:2: () otherlv_4= 'foobar' ( (otherlv_5= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:155:2: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:156:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getAbstractBarAccess().getFooBarBarAction_3_0(),
                                current);
                        

                    }

                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAbstractBar301); 

                        	newLeafNode(otherlv_4, grammarAccess.getAbstractBarAccess().getFoobarKeyword_3_1());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:165:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:166:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:166:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:167:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAbstractBarRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAbstractBar321); 

                    		newLeafNode(otherlv_5, grammarAccess.getAbstractBarAccess().getFooFooCrossReference_3_2_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:178:4: ( (otherlv_6= RULE_ID ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:179:1: (otherlv_6= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:179:1: (otherlv_6= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:180:3: otherlv_6= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAbstractBarRule());
                    	        }
                            
                    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAbstractBar343); 

                    		newLeafNode(otherlv_6, grammarAccess.getAbstractBarAccess().getFooFooCrossReference_4_0()); 
                    	

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:199:1: entryRuleBar returns [EObject current=null] : iv_ruleBar= ruleBar EOF ;
    public final EObject entryRuleBar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBar = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:200:2: (iv_ruleBar= ruleBar EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:201:2: iv_ruleBar= ruleBar EOF
            {
             newCompositeNode(grammarAccess.getBarRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBar_in_entryRuleBar380);
            iv_ruleBar=ruleBar();

            state._fsp--;

             current =iv_ruleBar; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBar390); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:208:1: ruleBar returns [EObject current=null] : (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* ) ;
    public final EObject ruleBar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:211:28: ( (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:212:1: (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:212:1: (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:212:3: otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleBar427); 

                	newLeafNode(otherlv_0, grammarAccess.getBarAccess().getBarKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:216:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:217:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:217:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:218:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBar444); 

            			newLeafNode(lv_name_1_0, grammarAccess.getBarAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBarRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:234:2: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:235:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:235:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:236:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBarRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBar469); 

            		newLeafNode(otherlv_2, grammarAccess.getBarAccess().getFooFooCrossReference_2_0()); 
            	

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:247:2: (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:247:4: otherlv_3= ',' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBar482); 

            	        	newLeafNode(otherlv_3, grammarAccess.getBarAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:251:1: ( (otherlv_4= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:252:1: (otherlv_4= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:252:1: (otherlv_4= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:253:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getBarRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBar502); 

            	    		newLeafNode(otherlv_4, grammarAccess.getBarAccess().getFooFooCrossReference_3_1_0()); 
            	    	

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:272:1: entryRuleFoo returns [EObject current=null] : iv_ruleFoo= ruleFoo EOF ;
    public final EObject entryRuleFoo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoo = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:273:2: (iv_ruleFoo= ruleFoo EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:274:2: iv_ruleFoo= ruleFoo EOF
            {
             newCompositeNode(grammarAccess.getFooRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFoo_in_entryRuleFoo540);
            iv_ruleFoo=ruleFoo();

            state._fsp--;

             current =iv_ruleFoo; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoo550); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:281:1: ruleFoo returns [EObject current=null] : (otherlv_0= 'foo' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:284:28: ( (otherlv_0= 'foo' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:285:1: (otherlv_0= 'foo' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:285:1: (otherlv_0= 'foo' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:285:3: otherlv_0= 'foo' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleFoo587); 

                	newLeafNode(otherlv_0, grammarAccess.getFooAccess().getFooKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:289:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:290:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:290:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:291:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFoo604); 

            			newLeafNode(lv_name_1_0, grammarAccess.getFooAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFooRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
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
    // $ANTLR end "ruleFoo"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFoo_in_ruleModel131 = new BitSet(new long[]{0x000000000000A812L});
        public static final BitSet FOLLOW_ruleAbstractBar_in_ruleModel158 = new BitSet(new long[]{0x000000000000A812L});
        public static final BitSet FOLLOW_ruleAbstractBar_in_entryRuleAbstractBar195 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractBar205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleAbstractBar243 = new BitSet(new long[]{0x000000000000B830L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAbstractBar257 = new BitSet(new long[]{0x000000000000B830L});
        public static final BitSet FOLLOW_ruleBar_in_ruleAbstractBar280 = new BitSet(new long[]{0x0000000000001022L});
        public static final BitSet FOLLOW_12_in_ruleAbstractBar301 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAbstractBar321 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAbstractBar343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBar_in_entryRuleBar380 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBar390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleBar427 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBar444 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBar469 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleBar482 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBar502 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo540 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoo550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleFoo587 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFoo604 = new BitSet(new long[]{0x0000000000000002L});
    }


}