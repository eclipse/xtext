package org.eclipse.xtext.resource.parser.antlr.internal; 

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
import org.eclipse.xtext.resource.services.EObjectAtOffsetTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEObjectAtOffsetTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foobar'", "'bar'", "','", "'foo'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;

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
     	
        public InternalEObjectAtOffsetTestLanguageParser(TokenStream input, IAstFactory factory, EObjectAtOffsetTestLanguageGrammarAccess grammarAccess) {
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
       	protected EObjectAtOffsetTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_foos_0_0 = null;

        EObject lv_bars_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:85:6: ( ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:86:1: ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:86:1: ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }
                else if ( (LA1_0==12) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:86:2: ( (lv_foos_0_0= ruleFoo ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:86:2: ( (lv_foos_0_0= ruleFoo ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:87:1: (lv_foos_0_0= ruleFoo )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:87:1: (lv_foos_0_0= ruleFoo )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:88:3: lv_foos_0_0= ruleFoo
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getFoosFooParserRuleCall_0_0(), currentNode); 
            	    	    
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
            	            		"Foo", 
            	            		currentNode);
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:106:6: ( (lv_bars_1_0= ruleAbstractBar ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:106:6: ( (lv_bars_1_0= ruleAbstractBar ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:107:1: (lv_bars_1_0= ruleAbstractBar )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:107:1: (lv_bars_1_0= ruleAbstractBar )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:108:3: lv_bars_1_0= ruleAbstractBar
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getBarsAbstractBarParserRuleCall_1_0(), currentNode); 
            	    	    
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
            	            		"AbstractBar", 
            	            		currentNode);
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


    // $ANTLR start "entryRuleAbstractBar"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:133:1: entryRuleAbstractBar returns [EObject current=null] : iv_ruleAbstractBar= ruleAbstractBar EOF ;
    public final EObject entryRuleAbstractBar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractBar = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:134:2: (iv_ruleAbstractBar= ruleAbstractBar EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:135:2: iv_ruleAbstractBar= ruleAbstractBar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractBarRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:142:1: ruleAbstractBar returns [EObject current=null] : (this_Bar_0= ruleBar ( () otherlv_2= 'foobar' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleAbstractBar() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_Bar_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:147:6: ( (this_Bar_0= ruleBar ( () otherlv_2= 'foobar' ( (otherlv_3= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:148:1: (this_Bar_0= ruleBar ( () otherlv_2= 'foobar' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:148:1: (this_Bar_0= ruleBar ( () otherlv_2= 'foobar' ( (otherlv_3= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:149:5: this_Bar_0= ruleBar ( () otherlv_2= 'foobar' ( (otherlv_3= RULE_ID ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAbstractBarAccess().getBarParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleBar_in_ruleAbstractBar252);
            this_Bar_0=ruleBar();

            state._fsp--;

             
                    current = this_Bar_0; 
                    // currentNode = currentNode.getParent();
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:158:1: ( () otherlv_2= 'foobar' ( (otherlv_3= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:158:2: () otherlv_2= 'foobar' ( (otherlv_3= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:158:2: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:159:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getAbstractBarAccess().getFooBarBarAction_1_0(),
                                current);
                        

                    }

                    otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleAbstractBar273); 

                        	createLeafNode(otherlv_2, grammarAccess.getAbstractBarAccess().getFoobarKeyword_1_1(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:168:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:169:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:169:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:170:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAbstractBarRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAbstractBar293); 

                    		createLeafNode(otherlv_3, grammarAccess.getAbstractBarAccess().getFooFooCrossReference_1_2_0(), "foo"); 
                    	

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleAbstractBar"


    // $ANTLR start "entryRuleBar"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:189:1: entryRuleBar returns [EObject current=null] : iv_ruleBar= ruleBar EOF ;
    public final EObject entryRuleBar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBar = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:190:2: (iv_ruleBar= ruleBar EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:191:2: iv_ruleBar= ruleBar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBarRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBar_in_entryRuleBar331);
            iv_ruleBar=ruleBar();

            state._fsp--;

             current =iv_ruleBar; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBar341); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:198:1: ruleBar returns [EObject current=null] : (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* ) ;
    public final EObject ruleBar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:203:6: ( (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:204:1: (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:204:1: (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:204:3: otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleBar378); 

                	createLeafNode(otherlv_0, grammarAccess.getBarAccess().getBarKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:208:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:209:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:209:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:210:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBar395); 

            			createLeafNode(lv_name_1_0, grammarAccess.getBarAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBarRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:227:2: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:228:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:228:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:229:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBarRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBar420); 

            		createLeafNode(otherlv_2, grammarAccess.getBarAccess().getFooFooCrossReference_2_0(), "foo"); 
            	

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:240:2: (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:240:4: otherlv_3= ',' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleBar433); 

            	        	createLeafNode(otherlv_3, grammarAccess.getBarAccess().getCommaKeyword_3_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:244:1: ( (otherlv_4= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:245:1: (otherlv_4= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:245:1: (otherlv_4= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:246:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getBarRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBar453); 

            	    		createLeafNode(otherlv_4, grammarAccess.getBarAccess().getFooFooCrossReference_3_1_0(), "foo"); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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
    // $ANTLR end "ruleBar"


    // $ANTLR start "entryRuleFoo"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:265:1: entryRuleFoo returns [EObject current=null] : iv_ruleFoo= ruleFoo EOF ;
    public final EObject entryRuleFoo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoo = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:266:2: (iv_ruleFoo= ruleFoo EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:267:2: iv_ruleFoo= ruleFoo EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFooRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFoo_in_entryRuleFoo491);
            iv_ruleFoo=ruleFoo();

            state._fsp--;

             current =iv_ruleFoo; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoo501); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:274:1: ruleFoo returns [EObject current=null] : (otherlv_0= 'foo' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:279:6: ( (otherlv_0= 'foo' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:280:1: (otherlv_0= 'foo' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:280:1: (otherlv_0= 'foo' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:280:3: otherlv_0= 'foo' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleFoo538); 

                	createLeafNode(otherlv_0, grammarAccess.getFooAccess().getFooKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:284:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:285:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:285:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalEObjectAtOffsetTestLanguage.g:286:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFoo555); 

            			createLeafNode(lv_name_1_0, grammarAccess.getFooAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFooRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleFoo"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFoo_in_ruleModel131 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_ruleAbstractBar_in_ruleModel158 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_ruleAbstractBar_in_entryRuleAbstractBar195 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractBar205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBar_in_ruleAbstractBar252 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_11_in_ruleAbstractBar273 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAbstractBar293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBar_in_entryRuleBar331 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBar341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleBar378 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBar395 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBar420 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleBar433 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBar453 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo491 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoo501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleFoo538 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFoo555 = new BitSet(new long[]{0x0000000000000002L});
    }


}