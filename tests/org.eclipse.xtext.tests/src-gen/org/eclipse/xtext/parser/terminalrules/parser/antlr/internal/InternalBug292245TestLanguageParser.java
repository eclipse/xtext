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
import org.eclipse.xtext.parser.terminalrules.services.Bug292245TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug292245TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_APOSTROPHE_CHAR", "RULE_CHAR", "RULE_WS", "'FIX'", "'ERROR'", "'TICK'", "'^'"
    };
    public static final int RULE_WS=6;
    public static final int RULE_CHAR=5;
    public static final int EOF=-1;
    public static final int RULE_APOSTROPHE_CHAR=4;

        public InternalBug292245TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g"; }



     	private Bug292245TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug292245TestLanguageParser(TokenStream input, IAstFactory factory, Bug292245TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:76:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:77:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel81);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel91); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:87:1: ruleModel returns [EObject current=null] : ( ( 'FIX' ( (lv_fix_1_0= ruleFix ) )+ ) | ( 'ERROR' ( (lv_error_3_0= ruleError ) )+ ) | ( 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_fix_1_0 = null;

        AntlrDatatypeRuleToken lv_error_3_0 = null;

        AntlrDatatypeRuleToken lv_tick_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:93:6: ( ( ( 'FIX' ( (lv_fix_1_0= ruleFix ) )+ ) | ( 'ERROR' ( (lv_error_3_0= ruleError ) )+ ) | ( 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:94:1: ( ( 'FIX' ( (lv_fix_1_0= ruleFix ) )+ ) | ( 'ERROR' ( (lv_error_3_0= ruleError ) )+ ) | ( 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:94:1: ( ( 'FIX' ( (lv_fix_1_0= ruleFix ) )+ ) | ( 'ERROR' ( (lv_error_3_0= ruleError ) )+ ) | ( 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ ) )*
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case 7:
                    {
                    alt4=1;
                    }
                    break;
                case 8:
                    {
                    alt4=2;
                    }
                    break;
                case 9:
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:94:2: ( 'FIX' ( (lv_fix_1_0= ruleFix ) )+ )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:94:2: ( 'FIX' ( (lv_fix_1_0= ruleFix ) )+ )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:94:4: 'FIX' ( (lv_fix_1_0= ruleFix ) )+
            	    {
            	    match(input,7,FollowSets000.FOLLOW_7_in_ruleModel131); 

            	            createLeafNode(grammarAccess.getModelAccess().getFIXKeyword_0_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:98:1: ( (lv_fix_1_0= ruleFix ) )+
            	    int cnt1=0;
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==RULE_APOSTROPHE_CHAR) ) {
            	            alt1=1;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:99:1: (lv_fix_1_0= ruleFix )
            	    	    {
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:99:1: (lv_fix_1_0= ruleFix )
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:100:3: lv_fix_1_0= ruleFix
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getFixFixParserRuleCall_0_1_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFix_in_ruleModel152);
            	    	    lv_fix_1_0=ruleFix();
            	    	    _fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	    	        }
            	    	    	        try {
            	    	    	       		add(
            	    	    	       			current, 
            	    	    	       			"fix",
            	    	    	        		lv_fix_1_0, 
            	    	    	        		"Fix", 
            	    	    	        		currentNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	        currentNode = currentNode.getParent();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt1 >= 1 ) break loop1;
            	                EarlyExitException eee =
            	                    new EarlyExitException(1, input);
            	                throw eee;
            	        }
            	        cnt1++;
            	    } while (true);


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:123:6: ( 'ERROR' ( (lv_error_3_0= ruleError ) )+ )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:123:6: ( 'ERROR' ( (lv_error_3_0= ruleError ) )+ )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:123:8: 'ERROR' ( (lv_error_3_0= ruleError ) )+
            	    {
            	    match(input,8,FollowSets000.FOLLOW_8_in_ruleModel171); 

            	            createLeafNode(grammarAccess.getModelAccess().getERRORKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:127:1: ( (lv_error_3_0= ruleError ) )+
            	    int cnt2=0;
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==RULE_APOSTROPHE_CHAR) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:128:1: (lv_error_3_0= ruleError )
            	    	    {
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:128:1: (lv_error_3_0= ruleError )
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:129:3: lv_error_3_0= ruleError
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getErrorErrorParserRuleCall_1_1_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleError_in_ruleModel192);
            	    	    lv_error_3_0=ruleError();
            	    	    _fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	    	        }
            	    	    	        try {
            	    	    	       		add(
            	    	    	       			current, 
            	    	    	       			"error",
            	    	    	        		lv_error_3_0, 
            	    	    	        		"Error", 
            	    	    	        		currentNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	        currentNode = currentNode.getParent();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt2 >= 1 ) break loop2;
            	                EarlyExitException eee =
            	                    new EarlyExitException(2, input);
            	                throw eee;
            	        }
            	        cnt2++;
            	    } while (true);


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:152:6: ( 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:152:6: ( 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+ )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:152:8: 'TICK' ( (lv_tick_5_0= ruleApostrophe ) )+
            	    {
            	    match(input,9,FollowSets000.FOLLOW_9_in_ruleModel211); 

            	            createLeafNode(grammarAccess.getModelAccess().getTICKKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:156:1: ( (lv_tick_5_0= ruleApostrophe ) )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==RULE_APOSTROPHE_CHAR) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:157:1: (lv_tick_5_0= ruleApostrophe )
            	    	    {
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:157:1: (lv_tick_5_0= ruleApostrophe )
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:158:3: lv_tick_5_0= ruleApostrophe
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getTickApostropheParserRuleCall_2_1_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleApostrophe_in_ruleModel232);
            	    	    lv_tick_5_0=ruleApostrophe();
            	    	    _fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	    	        }
            	    	    	        try {
            	    	    	       		add(
            	    	    	       			current, 
            	    	    	       			"tick",
            	    	    	        		lv_tick_5_0, 
            	    	    	        		"Apostrophe", 
            	    	    	        		currentNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	        currentNode = currentNode.getParent();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleError
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:191:1: entryRuleError returns [String current=null] : iv_ruleError= ruleError EOF ;
    public final String entryRuleError() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleError = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:195:2: (iv_ruleError= ruleError EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:196:2: iv_ruleError= ruleError EOF
            {
             currentNode = createCompositeNode(grammarAccess.getErrorRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleError_in_entryRuleError282);
            iv_ruleError=ruleError();
            _fsp--;

             current =iv_ruleError.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError293); 

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
    // $ANTLR end entryRuleError


    // $ANTLR start ruleError
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:206:1: ruleError returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR ) ;
    public final AntlrDatatypeRuleToken ruleError() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_APOSTROPHE_CHAR_0=null;
        Token this_APOSTROPHE_CHAR_2=null;
        AntlrDatatypeRuleToken this_Graphical_1 = null;


         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:212:6: ( (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:213:1: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:213:1: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:213:6: this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR
            {
            this_APOSTROPHE_CHAR_0=(Token)input.LT(1);
            match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleError337); 

            		current.merge(this_APOSTROPHE_CHAR_0);
                
             
                createLeafNode(grammarAccess.getErrorAccess().getAPOSTROPHE_CHARTerminalRuleCall_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getErrorAccess().getGraphicalParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleGraphical_in_ruleError364);
            this_Graphical_1=ruleGraphical();
            _fsp--;


            		current.merge(this_Graphical_1);
                
             
                    currentNode = currentNode.getParent();
                
            this_APOSTROPHE_CHAR_2=(Token)input.LT(1);
            match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleError384); 

            		current.merge(this_APOSTROPHE_CHAR_2);
                
             
                createLeafNode(grammarAccess.getErrorAccess().getAPOSTROPHE_CHARTerminalRuleCall_2(), null); 
                

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
    // $ANTLR end ruleError


    // $ANTLR start entryRuleFix
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:249:1: entryRuleFix returns [String current=null] : iv_ruleFix= ruleFix EOF ;
    public final String entryRuleFix() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFix = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:253:2: (iv_ruleFix= ruleFix EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:254:2: iv_ruleFix= ruleFix EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFixRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFix_in_entryRuleFix440);
            iv_ruleFix=ruleFix();
            _fsp--;

             current =iv_ruleFix.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFix451); 

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
    // $ANTLR end entryRuleFix


    // $ANTLR start ruleFix
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:264:1: ruleFix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR this_Rehide_3= ruleRehide ) ;
    public final AntlrDatatypeRuleToken ruleFix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_APOSTROPHE_CHAR_0=null;
        Token this_APOSTROPHE_CHAR_2=null;
        AntlrDatatypeRuleToken this_Graphical_1 = null;

        AntlrDatatypeRuleToken this_Rehide_3 = null;


         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:270:6: ( (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR this_Rehide_3= ruleRehide ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:271:1: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR this_Rehide_3= ruleRehide )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:271:1: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR this_Rehide_3= ruleRehide )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:271:6: this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR this_Graphical_1= ruleGraphical this_APOSTROPHE_CHAR_2= RULE_APOSTROPHE_CHAR this_Rehide_3= ruleRehide
            {
            this_APOSTROPHE_CHAR_0=(Token)input.LT(1);
            match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleFix495); 

            		current.merge(this_APOSTROPHE_CHAR_0);
                
             
                createLeafNode(grammarAccess.getFixAccess().getAPOSTROPHE_CHARTerminalRuleCall_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getFixAccess().getGraphicalParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleGraphical_in_ruleFix522);
            this_Graphical_1=ruleGraphical();
            _fsp--;


            		current.merge(this_Graphical_1);
                
             
                    currentNode = currentNode.getParent();
                
            this_APOSTROPHE_CHAR_2=(Token)input.LT(1);
            match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleFix542); 

            		current.merge(this_APOSTROPHE_CHAR_2);
                
             
                createLeafNode(grammarAccess.getFixAccess().getAPOSTROPHE_CHARTerminalRuleCall_2(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getFixAccess().getRehideParserRuleCall_3(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRehide_in_ruleFix569);
            this_Rehide_3=ruleRehide();
            _fsp--;


            		current.merge(this_Rehide_3);
                
             
                    currentNode = currentNode.getParent();
                

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
    // $ANTLR end ruleFix


    // $ANTLR start entryRuleApostrophe
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:318:1: entryRuleApostrophe returns [String current=null] : iv_ruleApostrophe= ruleApostrophe EOF ;
    public final String entryRuleApostrophe() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleApostrophe = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:322:2: (iv_ruleApostrophe= ruleApostrophe EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:323:2: iv_ruleApostrophe= ruleApostrophe EOF
            {
             currentNode = createCompositeNode(grammarAccess.getApostropheRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleApostrophe_in_entryRuleApostrophe625);
            iv_ruleApostrophe=ruleApostrophe();
            _fsp--;

             current =iv_ruleApostrophe.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleApostrophe636); 

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
    // $ANTLR end entryRuleApostrophe


    // $ANTLR start ruleApostrophe
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:333:1: ruleApostrophe returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR ;
    public final AntlrDatatypeRuleToken ruleApostrophe() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_APOSTROPHE_CHAR_0=null;

         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:339:6: (this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:340:5: this_APOSTROPHE_CHAR_0= RULE_APOSTROPHE_CHAR
            {
            this_APOSTROPHE_CHAR_0=(Token)input.LT(1);
            match(input,RULE_APOSTROPHE_CHAR,FollowSets000.FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleApostrophe679); 

            		current.merge(this_APOSTROPHE_CHAR_0);
                
             
                createLeafNode(grammarAccess.getApostropheAccess().getAPOSTROPHE_CHARTerminalRuleCall(), null); 
                

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
    // $ANTLR end ruleApostrophe


    // $ANTLR start entryRuleRehide
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:358:1: entryRuleRehide returns [String current=null] : iv_ruleRehide= ruleRehide EOF ;
    public final String entryRuleRehide() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRehide = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:362:2: (iv_ruleRehide= ruleRehide EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:363:2: iv_ruleRehide= ruleRehide EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRehideRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRehide_in_entryRuleRehide734);
            iv_ruleRehide=ruleRehide();
            _fsp--;

             current =iv_ruleRehide.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRehide745); 

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
    // $ANTLR end entryRuleRehide


    // $ANTLR start ruleRehide
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:373:1: ruleRehide returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '^' )? ;
    public final AntlrDatatypeRuleToken ruleRehide() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:379:6: ( (kw= '^' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:380:1: (kw= '^' )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:380:1: (kw= '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==10) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:381:2: kw= '^'
                    {
                    kw=(Token)input.LT(1);
                    match(input,10,FollowSets000.FOLLOW_10_in_ruleRehide787); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRehideAccess().getCircumflexAccentKeyword(), null); 
                        

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleRehide


    // $ANTLR start entryRuleGraphical
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:397:1: entryRuleGraphical returns [String current=null] : iv_ruleGraphical= ruleGraphical EOF ;
    public final String entryRuleGraphical() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGraphical = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:398:2: (iv_ruleGraphical= ruleGraphical EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:399:2: iv_ruleGraphical= ruleGraphical EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGraphicalRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleGraphical_in_entryRuleGraphical833);
            iv_ruleGraphical=ruleGraphical();
            _fsp--;

             current =iv_ruleGraphical.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGraphical844); 

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
    // $ANTLR end entryRuleGraphical


    // $ANTLR start ruleGraphical
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:406:1: ruleGraphical returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS ) ;
    public final AntlrDatatypeRuleToken ruleGraphical() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CHAR_0=null;
        Token this_WS_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:411:6: ( (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:412:1: (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:412:1: (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_CHAR) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_WS) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("412:1: (this_CHAR_0= RULE_CHAR | this_WS_1= RULE_WS )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:412:6: this_CHAR_0= RULE_CHAR
                    {
                    this_CHAR_0=(Token)input.LT(1);
                    match(input,RULE_CHAR,FollowSets000.FOLLOW_RULE_CHAR_in_ruleGraphical884); 

                    		current.merge(this_CHAR_0);
                        
                     
                        createLeafNode(grammarAccess.getGraphicalAccess().getCHARTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug292245TestLanguage.g:420:10: this_WS_1= RULE_WS
                    {
                    this_WS_1=(Token)input.LT(1);
                    match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleGraphical910); 

                    		current.merge(this_WS_1);
                        
                     
                        createLeafNode(grammarAccess.getGraphicalAccess().getWSTerminalRuleCall_1(), null); 
                        

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
    // $ANTLR end ruleGraphical


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_7_in_ruleModel131 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFix_in_ruleModel152 = new BitSet(new long[]{0x0000000000000392L});
        public static final BitSet FOLLOW_8_in_ruleModel171 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleError_in_ruleModel192 = new BitSet(new long[]{0x0000000000000392L});
        public static final BitSet FOLLOW_9_in_ruleModel211 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleApostrophe_in_ruleModel232 = new BitSet(new long[]{0x0000000000000392L});
        public static final BitSet FOLLOW_ruleError_in_entryRuleError282 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleError337 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleGraphical_in_ruleError364 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleError384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFix_in_entryRuleFix440 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFix451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleFix495 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleGraphical_in_ruleFix522 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleFix542 = new BitSet(new long[]{0x0000000000000402L});
        public static final BitSet FOLLOW_ruleRehide_in_ruleFix569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleApostrophe_in_entryRuleApostrophe625 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleApostrophe636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_APOSTROPHE_CHAR_in_ruleApostrophe679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRehide_in_entryRuleRehide734 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRehide745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_10_in_ruleRehide787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGraphical_in_entryRuleGraphical833 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGraphical844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_CHAR_in_ruleGraphical884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleGraphical910 = new BitSet(new long[]{0x0000000000000002L});
    }


}