package org.eclipse.xtext.linking.parser.antlr.internal; 

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
import org.eclipse.xtext.linking.services.Bug313089TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug313089TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'baz'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__11=11;

    // delegates
    // delegators


        public InternalBug313089TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug313089TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug313089TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g"; }



     	private Bug313089TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug313089TestLanguageParser(TokenStream input, IAstFactory factory, Bug313089TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Foo";	
       	}
       	
       	@Override
       	protected Bug313089TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleFoo"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:71:1: entryRuleFoo returns [EObject current=null] : iv_ruleFoo= ruleFoo EOF ;
    public final EObject entryRuleFoo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoo = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:72:2: (iv_ruleFoo= ruleFoo EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:73:2: iv_ruleFoo= ruleFoo EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFooRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFoo_in_entryRuleFoo75);
            iv_ruleFoo=ruleFoo();

            state._fsp--;

             current =iv_ruleFoo; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoo85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:80:1: ruleFoo returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_3=null;
        EObject lv_bar_1_0 = null;

        EObject lv_baz_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:85:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:86:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:86:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:86:2: ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) ) ( (otherlv_3= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:86:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:87:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:87:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:88:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFoo127); 

            			createLeafNode(lv_name_0_0, grammarAccess.getFooAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFooRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:110:2: ( ( (lv_bar_1_0= ruleBar ) ) | ( (lv_baz_2_0= ruleBaz ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==11) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:110:3: ( (lv_bar_1_0= ruleBar ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:110:3: ( (lv_bar_1_0= ruleBar ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:111:1: (lv_bar_1_0= ruleBar )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:111:1: (lv_bar_1_0= ruleBar )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:112:3: lv_bar_1_0= ruleBar
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFooAccess().getBarBarParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleBar_in_ruleFoo154);
                    lv_bar_1_0=ruleBar();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFooRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"bar",
                    	        		lv_bar_1_0, 
                    	        		"Bar", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:135:6: ( (lv_baz_2_0= ruleBaz ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:135:6: ( (lv_baz_2_0= ruleBaz ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:136:1: (lv_baz_2_0= ruleBaz )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:136:1: (lv_baz_2_0= ruleBaz )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:137:3: lv_baz_2_0= ruleBaz
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFooAccess().getBazBazParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleBaz_in_ruleFoo181);
                    lv_baz_2_0=ruleBaz();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFooRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"baz",
                    	        		lv_baz_2_0, 
                    	        		"Baz", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:159:3: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:160:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:160:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:161:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFooRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFoo202); 

            		createLeafNode(otherlv_3, grammarAccess.getFooAccess().getRefFooCrossReference_2_0(), "ref"); 
            	

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


    // $ANTLR start "entryRuleBar"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:181:1: entryRuleBar returns [EObject current=null] : iv_ruleBar= ruleBar EOF ;
    public final EObject entryRuleBar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBar = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:182:2: (iv_ruleBar= ruleBar EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:183:2: iv_ruleBar= ruleBar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBarRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBar_in_entryRuleBar238);
            iv_ruleBar=ruleBar();

            state._fsp--;

             current =iv_ruleBar; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBar248); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:190:1: ruleBar returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleBar() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:195:6: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:196:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:196:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:196:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:196:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:197:5: 
            {
             
                    temp=factory.create(grammarAccess.getBarAccess().getBarAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getBarAccess().getBarAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:207:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:208:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:208:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:209:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBar299); 

            			createLeafNode(lv_name_1_0, grammarAccess.getBarAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBarRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end "ruleBar"


    // $ANTLR start "entryRuleBaz"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:239:1: entryRuleBaz returns [EObject current=null] : iv_ruleBaz= ruleBaz EOF ;
    public final EObject entryRuleBaz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaz = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:240:2: (iv_ruleBaz= ruleBaz EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:241:2: iv_ruleBaz= ruleBaz EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBazRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBaz_in_entryRuleBaz340);
            iv_ruleBaz=ruleBaz();

            state._fsp--;

             current =iv_ruleBaz; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBaz350); 

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
    // $ANTLR end "entryRuleBaz"


    // $ANTLR start "ruleBaz"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:248:1: ruleBaz returns [EObject current=null] : (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleBaz() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:253:6: ( (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:254:1: (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:254:1: (otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:254:3: otherlv_0= 'baz' ( (lv_name_1_0= RULE_ID ) ) ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleBaz387); 

                	createLeafNode(otherlv_0, grammarAccess.getBazAccess().getBazKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:258:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:259:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:259:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:260:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBaz404); 

            			createLeafNode(lv_name_1_0, grammarAccess.getBazAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBazRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:282:2: ( () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:282:3: () otherlv_3= 'baz' ( (lv_name_4_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:282:3: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:283:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getBazAccess().getBazChildAction_2_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "child", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getBazAccess().getBazChildAction_2_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    otherlv_3=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleBaz431); 

            	        	createLeafNode(otherlv_3, grammarAccess.getBazAccess().getBazKeyword_2_1(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:302:1: ( (lv_name_4_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:303:1: (lv_name_4_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:303:1: (lv_name_4_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/parser/antlr/internal/InternalBug313089TestLanguage.g:304:3: lv_name_4_0= RULE_ID
            	    {
            	    lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBaz448); 

            	    			createLeafNode(lv_name_4_0, grammarAccess.getBazAccess().getNameIDTerminalRuleCall_2_2_0(), "name"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBazRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"name",
            	    	        		lv_name_4_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
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
    // $ANTLR end "ruleBaz"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoo85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFoo127 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_ruleBar_in_ruleFoo154 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleBaz_in_ruleFoo181 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFoo202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBar_in_entryRuleBar238 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBar248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBar299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBaz_in_entryRuleBaz340 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBaz350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleBaz387 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBaz404 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_11_in_ruleBaz431 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBaz448 = new BitSet(new long[]{0x0000000000000802L});
    }


}