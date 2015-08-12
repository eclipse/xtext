package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug347012TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug347012TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LT", "RULE_ID", "RULE_NUMBER", "RULE_STRING", "RULE_IDPLAINCHAR", "RULE_DIGIT", "RULE_WS", "RULE_ESCAPE", "RULE_HEX", "'.'", "';'", "'true'", "'false'", "'package'", "'{'", "'}'", "'public'", "'class'", "'private'", "'var'", "','", "':'", "'='"
    };
    public static final int RULE_ESCAPE=11;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_LT=4;
    public static final int T__19=19;
    public static final int RULE_HEX=12;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_NUMBER=6;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_IDPLAINCHAR=8;
    public static final int RULE_WS=10;
    public static final int RULE_DIGIT=9;

    // delegates
    // delegators


        public InternalBug347012TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug347012TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug347012TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g"; }



     	private Bug347012TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug347012TestLanguageParser(TokenStream input, Bug347012TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MyProgram";	
       	}
       	
       	@Override
       	protected Bug347012TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMyProgram"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:67:1: entryRuleMyProgram returns [EObject current=null] : iv_ruleMyProgram= ruleMyProgram EOF ;
    public final EObject entryRuleMyProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyProgram = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:68:2: (iv_ruleMyProgram= ruleMyProgram EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:69:2: iv_ruleMyProgram= ruleMyProgram EOF
            {
             newCompositeNode(grammarAccess.getMyProgramRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyProgram_in_entryRuleMyProgram75);
            iv_ruleMyProgram=ruleMyProgram();

            state._fsp--;

             current =iv_ruleMyProgram; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyProgram85); 

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
    // $ANTLR end "entryRuleMyProgram"


    // $ANTLR start "ruleMyProgram"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:76:1: ruleMyProgram returns [EObject current=null] : ( () (this_LT_1= RULE_LT )* ( (lv_package_2_0= ruleMyPackage ) ) (this_LT_3= RULE_LT )* ) ;
    public final EObject ruleMyProgram() throws RecognitionException {
        EObject current = null;

        Token this_LT_1=null;
        Token this_LT_3=null;
        EObject lv_package_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:79:28: ( ( () (this_LT_1= RULE_LT )* ( (lv_package_2_0= ruleMyPackage ) ) (this_LT_3= RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:80:1: ( () (this_LT_1= RULE_LT )* ( (lv_package_2_0= ruleMyPackage ) ) (this_LT_3= RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:80:1: ( () (this_LT_1= RULE_LT )* ( (lv_package_2_0= ruleMyPackage ) ) (this_LT_3= RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:80:2: () (this_LT_1= RULE_LT )* ( (lv_package_2_0= ruleMyPackage ) ) (this_LT_3= RULE_LT )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:80:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMyProgramAccess().getMyProgramAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:86:2: (this_LT_1= RULE_LT )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_LT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:86:3: this_LT_1= RULE_LT
            	    {
            	    this_LT_1=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyProgram131); 
            	     
            	        newLeafNode(this_LT_1, grammarAccess.getMyProgramAccess().getLTTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:90:3: ( (lv_package_2_0= ruleMyPackage ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:91:1: (lv_package_2_0= ruleMyPackage )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:91:1: (lv_package_2_0= ruleMyPackage )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:92:3: lv_package_2_0= ruleMyPackage
            {
             
            	        newCompositeNode(grammarAccess.getMyProgramAccess().getPackageMyPackageParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMyPackage_in_ruleMyProgram153);
            lv_package_2_0=ruleMyPackage();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMyProgramRule());
            	        }
                   		set(
                   			current, 
                   			"package",
                    		lv_package_2_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.MyPackage");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:108:2: (this_LT_3= RULE_LT )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_LT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:108:3: this_LT_3= RULE_LT
            	    {
            	    this_LT_3=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyProgram165); 
            	     
            	        newLeafNode(this_LT_3, grammarAccess.getMyProgramAccess().getLTTerminalRuleCall_3()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleMyProgram"


    // $ANTLR start "entryRuleIdentifier"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:120:1: entryRuleIdentifier returns [EObject current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final EObject entryRuleIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifier = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:121:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:122:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
             newCompositeNode(grammarAccess.getIdentifierRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier202);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;

             current =iv_ruleIdentifier; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier212); 

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
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:129:1: ruleIdentifier returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:132:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:133:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:133:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:134:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:134:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:135:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdentifier253); 

            			newLeafNode(lv_name_0_0, grammarAccess.getIdentifierAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIdentifierRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.ID");
            	    

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
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:159:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:160:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:161:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN294);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN305); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:168:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (this_LT_1= RULE_LT )* kw= '.' (this_LT_3= RULE_LT )* this_ID_4= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_LT_1=null;
        Token kw=null;
        Token this_LT_3=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:171:28: ( (this_ID_0= RULE_ID ( (this_LT_1= RULE_LT )* kw= '.' (this_LT_3= RULE_LT )* this_ID_4= RULE_ID )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:172:1: (this_ID_0= RULE_ID ( (this_LT_1= RULE_LT )* kw= '.' (this_LT_3= RULE_LT )* this_ID_4= RULE_ID )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:172:1: (this_ID_0= RULE_ID ( (this_LT_1= RULE_LT )* kw= '.' (this_LT_3= RULE_LT )* this_ID_4= RULE_ID )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:172:6: this_ID_0= RULE_ID ( (this_LT_1= RULE_LT )* kw= '.' (this_LT_3= RULE_LT )* this_ID_4= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN345); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:179:1: ( (this_LT_1= RULE_LT )* kw= '.' (this_LT_3= RULE_LT )* this_ID_4= RULE_ID )*
            loop5:
            do {
                int alt5=2;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:179:2: (this_LT_1= RULE_LT )* kw= '.' (this_LT_3= RULE_LT )* this_ID_4= RULE_ID
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:179:2: (this_LT_1= RULE_LT )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==RULE_LT) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:179:7: this_LT_1= RULE_LT
            	    	    {
            	    	    this_LT_1=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleFQN367); 

            	    	    		current.merge(this_LT_1);
            	    	        
            	    	     
            	    	        newLeafNode(this_LT_1, grammarAccess.getFQNAccess().getLTTerminalRuleCall_1_0()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);

            	    kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleFQN387); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_1()); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:192:1: (this_LT_3= RULE_LT )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==RULE_LT) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:192:6: this_LT_3= RULE_LT
            	    	    {
            	    	    this_LT_3=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleFQN403); 

            	    	    		current.merge(this_LT_3);
            	    	        
            	    	     
            	    	        newLeafNode(this_LT_3, grammarAccess.getFQNAccess().getLTTerminalRuleCall_1_2()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);

            	    this_ID_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN425); 

            	    		current.merge(this_ID_4);
            	        
            	     
            	        newLeafNode(this_ID_4, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_3()); 
            	        

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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleVirtualSemi"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:214:1: entryRuleVirtualSemi returns [String current=null] : iv_ruleVirtualSemi= ruleVirtualSemi EOF ;
    public final String entryRuleVirtualSemi() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVirtualSemi = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:215:2: (iv_ruleVirtualSemi= ruleVirtualSemi EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:216:2: iv_ruleVirtualSemi= ruleVirtualSemi EOF
            {
             newCompositeNode(grammarAccess.getVirtualSemiRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleVirtualSemi_in_entryRuleVirtualSemi473);
            iv_ruleVirtualSemi=ruleVirtualSemi();

            state._fsp--;

             current =iv_ruleVirtualSemi.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVirtualSemi484); 

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
    // $ANTLR end "entryRuleVirtualSemi"


    // $ANTLR start "ruleVirtualSemi"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:223:1: ruleVirtualSemi returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= ';' | this_LT_1= RULE_LT ) ;
    public final AntlrDatatypeRuleToken ruleVirtualSemi() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_LT_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:226:28: ( (kw= ';' | this_LT_1= RULE_LT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:227:1: (kw= ';' | this_LT_1= RULE_LT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:227:1: (kw= ';' | this_LT_1= RULE_LT )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_LT) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:228:2: kw= ';'
                    {
                    kw=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleVirtualSemi522); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVirtualSemiAccess().getSemicolonKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:234:10: this_LT_1= RULE_LT
                    {
                    this_LT_1=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleVirtualSemi543); 

                    		current.merge(this_LT_1);
                        
                     
                        newLeafNode(this_LT_1, grammarAccess.getVirtualSemiAccess().getLTTerminalRuleCall_1()); 
                        

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
    // $ANTLR end "ruleVirtualSemi"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:249:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:250:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:251:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLiteral_in_entryRuleLiteral588);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLiteral598); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:258:1: ruleLiteral returns [EObject current=null] : ( ( (lv_num_0_0= RULE_NUMBER ) ) | ( (lv_str_1_0= RULE_STRING ) ) | ( (lv_bool_2_0= 'true' ) ) | ( (lv_bool_3_0= 'false' ) ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_num_0_0=null;
        Token lv_str_1_0=null;
        Token lv_bool_2_0=null;
        Token lv_bool_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:261:28: ( ( ( (lv_num_0_0= RULE_NUMBER ) ) | ( (lv_str_1_0= RULE_STRING ) ) | ( (lv_bool_2_0= 'true' ) ) | ( (lv_bool_3_0= 'false' ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:262:1: ( ( (lv_num_0_0= RULE_NUMBER ) ) | ( (lv_str_1_0= RULE_STRING ) ) | ( (lv_bool_2_0= 'true' ) ) | ( (lv_bool_3_0= 'false' ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:262:1: ( ( (lv_num_0_0= RULE_NUMBER ) ) | ( (lv_str_1_0= RULE_STRING ) ) | ( (lv_bool_2_0= 'true' ) ) | ( (lv_bool_3_0= 'false' ) ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt7=1;
                }
                break;
            case RULE_STRING:
                {
                alt7=2;
                }
                break;
            case 15:
                {
                alt7=3;
                }
                break;
            case 16:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:262:2: ( (lv_num_0_0= RULE_NUMBER ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:262:2: ( (lv_num_0_0= RULE_NUMBER ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:263:1: (lv_num_0_0= RULE_NUMBER )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:263:1: (lv_num_0_0= RULE_NUMBER )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:264:3: lv_num_0_0= RULE_NUMBER
                    {
                    lv_num_0_0=(Token)match(input,RULE_NUMBER,FollowSets000.FOLLOW_RULE_NUMBER_in_ruleLiteral640); 

                    			newLeafNode(lv_num_0_0, grammarAccess.getLiteralAccess().getNumNUMBERTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLiteralRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"num",
                            		lv_num_0_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.NUMBER");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:281:6: ( (lv_str_1_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:281:6: ( (lv_str_1_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:282:1: (lv_str_1_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:282:1: (lv_str_1_0= RULE_STRING )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:283:3: lv_str_1_0= RULE_STRING
                    {
                    lv_str_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLiteral668); 

                    			newLeafNode(lv_str_1_0, grammarAccess.getLiteralAccess().getStrSTRINGTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLiteralRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"str",
                            		lv_str_1_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.STRING");
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:300:6: ( (lv_bool_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:300:6: ( (lv_bool_2_0= 'true' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:301:1: (lv_bool_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:301:1: (lv_bool_2_0= 'true' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:302:3: lv_bool_2_0= 'true'
                    {
                    lv_bool_2_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleLiteral697); 

                            newLeafNode(lv_bool_2_0, grammarAccess.getLiteralAccess().getBoolTrueKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLiteralRule());
                    	        }
                           		setWithLastConsumed(current, "bool", lv_bool_2_0, "true");
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:316:6: ( (lv_bool_3_0= 'false' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:316:6: ( (lv_bool_3_0= 'false' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:317:1: (lv_bool_3_0= 'false' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:317:1: (lv_bool_3_0= 'false' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:318:3: lv_bool_3_0= 'false'
                    {
                    lv_bool_3_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleLiteral734); 

                            newLeafNode(lv_bool_3_0, grammarAccess.getLiteralAccess().getBoolFalseKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLiteralRule());
                    	        }
                           		setWithLastConsumed(current, "bool", lv_bool_3_0, "false");
                    	    

                    }


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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleMyPrimary"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:339:1: entryRuleMyPrimary returns [EObject current=null] : iv_ruleMyPrimary= ruleMyPrimary EOF ;
    public final EObject entryRuleMyPrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyPrimary = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:340:2: (iv_ruleMyPrimary= ruleMyPrimary EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:341:2: iv_ruleMyPrimary= ruleMyPrimary EOF
            {
             newCompositeNode(grammarAccess.getMyPrimaryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyPrimary_in_entryRuleMyPrimary783);
            iv_ruleMyPrimary=ruleMyPrimary();

            state._fsp--;

             current =iv_ruleMyPrimary; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyPrimary793); 

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
    // $ANTLR end "entryRuleMyPrimary"


    // $ANTLR start "ruleMyPrimary"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:348:1: ruleMyPrimary returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_Identifier_1= ruleIdentifier ) ;
    public final EObject ruleMyPrimary() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_Identifier_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:351:28: ( (this_Literal_0= ruleLiteral | this_Identifier_1= ruleIdentifier ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:352:1: (this_Literal_0= ruleLiteral | this_Identifier_1= ruleIdentifier )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:352:1: (this_Literal_0= ruleLiteral | this_Identifier_1= ruleIdentifier )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_NUMBER && LA8_0<=RULE_STRING)||(LA8_0>=15 && LA8_0<=16)) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:353:5: this_Literal_0= ruleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getMyPrimaryAccess().getLiteralParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLiteral_in_ruleMyPrimary840);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:363:5: this_Identifier_1= ruleIdentifier
                    {
                     
                            newCompositeNode(grammarAccess.getMyPrimaryAccess().getIdentifierParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleMyPrimary867);
                    this_Identifier_1=ruleIdentifier();

                    state._fsp--;

                     
                            current = this_Identifier_1; 
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
    // $ANTLR end "ruleMyPrimary"


    // $ANTLR start "entryRuleMyPackage"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:379:1: entryRuleMyPackage returns [EObject current=null] : iv_ruleMyPackage= ruleMyPackage EOF ;
    public final EObject entryRuleMyPackage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyPackage = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:380:2: (iv_ruleMyPackage= ruleMyPackage EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:381:2: iv_ruleMyPackage= ruleMyPackage EOF
            {
             newCompositeNode(grammarAccess.getMyPackageRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyPackage_in_entryRuleMyPackage902);
            iv_ruleMyPackage=ruleMyPackage();

            state._fsp--;

             current =iv_ruleMyPackage; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyPackage912); 

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
    // $ANTLR end "entryRuleMyPackage"


    // $ANTLR start "ruleMyPackage"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:388:1: ruleMyPackage returns [EObject current=null] : (otherlv_0= 'package' (this_LT_1= RULE_LT )* ( (lv_name_2_0= ruleFQN ) ) (this_LT_3= RULE_LT )* otherlv_4= '{' (this_LT_5= RULE_LT )* ( ( (lv_directives_6_0= ruleMyClass ) ) (this_LT_7= RULE_LT )* )* otherlv_8= '}' ) ;
    public final EObject ruleMyPackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_LT_1=null;
        Token this_LT_3=null;
        Token otherlv_4=null;
        Token this_LT_5=null;
        Token this_LT_7=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_directives_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:391:28: ( (otherlv_0= 'package' (this_LT_1= RULE_LT )* ( (lv_name_2_0= ruleFQN ) ) (this_LT_3= RULE_LT )* otherlv_4= '{' (this_LT_5= RULE_LT )* ( ( (lv_directives_6_0= ruleMyClass ) ) (this_LT_7= RULE_LT )* )* otherlv_8= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:392:1: (otherlv_0= 'package' (this_LT_1= RULE_LT )* ( (lv_name_2_0= ruleFQN ) ) (this_LT_3= RULE_LT )* otherlv_4= '{' (this_LT_5= RULE_LT )* ( ( (lv_directives_6_0= ruleMyClass ) ) (this_LT_7= RULE_LT )* )* otherlv_8= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:392:1: (otherlv_0= 'package' (this_LT_1= RULE_LT )* ( (lv_name_2_0= ruleFQN ) ) (this_LT_3= RULE_LT )* otherlv_4= '{' (this_LT_5= RULE_LT )* ( ( (lv_directives_6_0= ruleMyClass ) ) (this_LT_7= RULE_LT )* )* otherlv_8= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:392:3: otherlv_0= 'package' (this_LT_1= RULE_LT )* ( (lv_name_2_0= ruleFQN ) ) (this_LT_3= RULE_LT )* otherlv_4= '{' (this_LT_5= RULE_LT )* ( ( (lv_directives_6_0= ruleMyClass ) ) (this_LT_7= RULE_LT )* )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMyPackage949); 

                	newLeafNode(otherlv_0, grammarAccess.getMyPackageAccess().getPackageKeyword_0());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:396:1: (this_LT_1= RULE_LT )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_LT) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:396:2: this_LT_1= RULE_LT
            	    {
            	    this_LT_1=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyPackage961); 
            	     
            	        newLeafNode(this_LT_1, grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:400:3: ( (lv_name_2_0= ruleFQN ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:401:1: (lv_name_2_0= ruleFQN )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:401:1: (lv_name_2_0= ruleFQN )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:402:3: lv_name_2_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getMyPackageAccess().getNameFQNParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleMyPackage983);
            lv_name_2_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMyPackageRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:418:2: (this_LT_3= RULE_LT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_LT) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:418:3: this_LT_3= RULE_LT
            	    {
            	    this_LT_3=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyPackage995); 
            	     
            	        newLeafNode(this_LT_3, grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_3()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMyPackage1008); 

                	newLeafNode(otherlv_4, grammarAccess.getMyPackageAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:426:1: (this_LT_5= RULE_LT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_LT) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:426:2: this_LT_5= RULE_LT
            	    {
            	    this_LT_5=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyPackage1020); 
            	     
            	        newLeafNode(this_LT_5, grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_5()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:430:3: ( ( (lv_directives_6_0= ruleMyClass ) ) (this_LT_7= RULE_LT )* )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=20 && LA13_0<=21)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:430:4: ( (lv_directives_6_0= ruleMyClass ) ) (this_LT_7= RULE_LT )*
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:430:4: ( (lv_directives_6_0= ruleMyClass ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:431:1: (lv_directives_6_0= ruleMyClass )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:431:1: (lv_directives_6_0= ruleMyClass )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:432:3: lv_directives_6_0= ruleMyClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMyPackageAccess().getDirectivesMyClassParserRuleCall_6_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMyClass_in_ruleMyPackage1043);
            	    lv_directives_6_0=ruleMyClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMyPackageRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"directives",
            	            		lv_directives_6_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.MyClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:448:2: (this_LT_7= RULE_LT )*
            	    loop12:
            	    do {
            	        int alt12=2;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==RULE_LT) ) {
            	            alt12=1;
            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:448:3: this_LT_7= RULE_LT
            	    	    {
            	    	    this_LT_7=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyPackage1055); 
            	    	     
            	    	        newLeafNode(this_LT_7, grammarAccess.getMyPackageAccess().getLTTerminalRuleCall_6_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop12;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMyPackage1070); 

                	newLeafNode(otherlv_8, grammarAccess.getMyPackageAccess().getRightCurlyBracketKeyword_7());
                

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
    // $ANTLR end "ruleMyPackage"


    // $ANTLR start "entryRuleMyClass"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:464:1: entryRuleMyClass returns [EObject current=null] : iv_ruleMyClass= ruleMyClass EOF ;
    public final EObject entryRuleMyClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyClass = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:465:2: (iv_ruleMyClass= ruleMyClass EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:466:2: iv_ruleMyClass= ruleMyClass EOF
            {
             newCompositeNode(grammarAccess.getMyClassRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyClass_in_entryRuleMyClass1106);
            iv_ruleMyClass=ruleMyClass();

            state._fsp--;

             current =iv_ruleMyClass; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyClass1116); 

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
    // $ANTLR end "entryRuleMyClass"


    // $ANTLR start "ruleMyClass"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:473:1: ruleMyClass returns [EObject current=null] : ( (otherlv_0= 'public' )? otherlv_1= 'class' (this_LT_2= RULE_LT )* ( (lv_name_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* otherlv_5= '{' (this_LT_6= RULE_LT )* ( ( (lv_directives_7_0= ruleMyField ) ) (this_LT_8= RULE_LT )* )* otherlv_9= '}' ) ;
    public final EObject ruleMyClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_LT_2=null;
        Token lv_name_3_0=null;
        Token this_LT_4=null;
        Token otherlv_5=null;
        Token this_LT_6=null;
        Token this_LT_8=null;
        Token otherlv_9=null;
        EObject lv_directives_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:476:28: ( ( (otherlv_0= 'public' )? otherlv_1= 'class' (this_LT_2= RULE_LT )* ( (lv_name_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* otherlv_5= '{' (this_LT_6= RULE_LT )* ( ( (lv_directives_7_0= ruleMyField ) ) (this_LT_8= RULE_LT )* )* otherlv_9= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:477:1: ( (otherlv_0= 'public' )? otherlv_1= 'class' (this_LT_2= RULE_LT )* ( (lv_name_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* otherlv_5= '{' (this_LT_6= RULE_LT )* ( ( (lv_directives_7_0= ruleMyField ) ) (this_LT_8= RULE_LT )* )* otherlv_9= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:477:1: ( (otherlv_0= 'public' )? otherlv_1= 'class' (this_LT_2= RULE_LT )* ( (lv_name_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* otherlv_5= '{' (this_LT_6= RULE_LT )* ( ( (lv_directives_7_0= ruleMyField ) ) (this_LT_8= RULE_LT )* )* otherlv_9= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:477:2: (otherlv_0= 'public' )? otherlv_1= 'class' (this_LT_2= RULE_LT )* ( (lv_name_3_0= RULE_ID ) ) (this_LT_4= RULE_LT )* otherlv_5= '{' (this_LT_6= RULE_LT )* ( ( (lv_directives_7_0= ruleMyField ) ) (this_LT_8= RULE_LT )* )* otherlv_9= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:477:2: (otherlv_0= 'public' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:477:4: otherlv_0= 'public'
                    {
                    otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMyClass1154); 

                        	newLeafNode(otherlv_0, grammarAccess.getMyClassAccess().getPublicKeyword_0());
                        

                    }
                    break;

            }

            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMyClass1168); 

                	newLeafNode(otherlv_1, grammarAccess.getMyClassAccess().getClassKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:485:1: (this_LT_2= RULE_LT )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_LT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:485:2: this_LT_2= RULE_LT
            	    {
            	    this_LT_2=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyClass1180); 
            	     
            	        newLeafNode(this_LT_2, grammarAccess.getMyClassAccess().getLTTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:489:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:490:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:490:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:491:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMyClass1198); 

            			newLeafNode(lv_name_3_0, grammarAccess.getMyClassAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMyClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:507:2: (this_LT_4= RULE_LT )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_LT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:507:3: this_LT_4= RULE_LT
            	    {
            	    this_LT_4=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyClass1215); 
            	     
            	        newLeafNode(this_LT_4, grammarAccess.getMyClassAccess().getLTTerminalRuleCall_4()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMyClass1228); 

                	newLeafNode(otherlv_5, grammarAccess.getMyClassAccess().getLeftCurlyBracketKeyword_5());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:515:1: (this_LT_6= RULE_LT )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_LT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:515:2: this_LT_6= RULE_LT
            	    {
            	    this_LT_6=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyClass1240); 
            	     
            	        newLeafNode(this_LT_6, grammarAccess.getMyClassAccess().getLTTerminalRuleCall_6()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:519:3: ( ( (lv_directives_7_0= ruleMyField ) ) (this_LT_8= RULE_LT )* )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==EOF||LA19_0==20||(LA19_0>=22 && LA19_0<=23)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:519:4: ( (lv_directives_7_0= ruleMyField ) ) (this_LT_8= RULE_LT )*
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:519:4: ( (lv_directives_7_0= ruleMyField ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:520:1: (lv_directives_7_0= ruleMyField )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:520:1: (lv_directives_7_0= ruleMyField )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:521:3: lv_directives_7_0= ruleMyField
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMyClassAccess().getDirectivesMyFieldParserRuleCall_7_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMyField_in_ruleMyClass1263);
            	    lv_directives_7_0=ruleMyField();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMyClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"directives",
            	            		lv_directives_7_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.MyField");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:537:2: (this_LT_8= RULE_LT )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==RULE_LT) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:537:3: this_LT_8= RULE_LT
            	    	    {
            	    	    this_LT_8=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyClass1275); 
            	    	     
            	    	        newLeafNode(this_LT_8, grammarAccess.getMyClassAccess().getLTTerminalRuleCall_7_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop18;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_9=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMyClass1290); 

                	newLeafNode(otherlv_9, grammarAccess.getMyClassAccess().getRightCurlyBracketKeyword_8());
                

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
    // $ANTLR end "ruleMyClass"


    // $ANTLR start "entryRuleMyAttribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:553:1: entryRuleMyAttribute returns [EObject current=null] : iv_ruleMyAttribute= ruleMyAttribute EOF ;
    public final EObject entryRuleMyAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:554:2: (iv_ruleMyAttribute= ruleMyAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:555:2: iv_ruleMyAttribute= ruleMyAttribute EOF
            {
             newCompositeNode(grammarAccess.getMyAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyAttribute_in_entryRuleMyAttribute1326);
            iv_ruleMyAttribute=ruleMyAttribute();

            state._fsp--;

             current =iv_ruleMyAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyAttribute1336); 

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
    // $ANTLR end "entryRuleMyAttribute"


    // $ANTLR start "ruleMyAttribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:562:1: ruleMyAttribute returns [EObject current=null] : ( ( (lv_PUBLIC_0_0= 'public' ) ) | ( (lv_PRIVATE_1_0= 'private' ) ) ) ;
    public final EObject ruleMyAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_PUBLIC_0_0=null;
        Token lv_PRIVATE_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:565:28: ( ( ( (lv_PUBLIC_0_0= 'public' ) ) | ( (lv_PRIVATE_1_0= 'private' ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:566:1: ( ( (lv_PUBLIC_0_0= 'public' ) ) | ( (lv_PRIVATE_1_0= 'private' ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:566:1: ( ( (lv_PUBLIC_0_0= 'public' ) ) | ( (lv_PRIVATE_1_0= 'private' ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==20) ) {
                alt20=1;
            }
            else if ( (LA20_0==22) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:566:2: ( (lv_PUBLIC_0_0= 'public' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:566:2: ( (lv_PUBLIC_0_0= 'public' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:567:1: (lv_PUBLIC_0_0= 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:567:1: (lv_PUBLIC_0_0= 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:568:3: lv_PUBLIC_0_0= 'public'
                    {
                    lv_PUBLIC_0_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMyAttribute1379); 

                            newLeafNode(lv_PUBLIC_0_0, grammarAccess.getMyAttributeAccess().getPUBLICPublicKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMyAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "PUBLIC", lv_PUBLIC_0_0, "public");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:582:6: ( (lv_PRIVATE_1_0= 'private' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:582:6: ( (lv_PRIVATE_1_0= 'private' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:583:1: (lv_PRIVATE_1_0= 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:583:1: (lv_PRIVATE_1_0= 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:584:3: lv_PRIVATE_1_0= 'private'
                    {
                    lv_PRIVATE_1_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMyAttribute1416); 

                            newLeafNode(lv_PRIVATE_1_0, grammarAccess.getMyAttributeAccess().getPRIVATEPrivateKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMyAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "PRIVATE", lv_PRIVATE_1_0, "private");
                    	    

                    }


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
    // $ANTLR end "ruleMyAttribute"


    // $ANTLR start "entryRuleMyAttributes"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:605:1: entryRuleMyAttributes returns [EObject current=null] : iv_ruleMyAttributes= ruleMyAttributes EOF ;
    public final EObject entryRuleMyAttributes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyAttributes = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:606:2: (iv_ruleMyAttributes= ruleMyAttributes EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:607:2: iv_ruleMyAttributes= ruleMyAttributes EOF
            {
             newCompositeNode(grammarAccess.getMyAttributesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyAttributes_in_entryRuleMyAttributes1465);
            iv_ruleMyAttributes=ruleMyAttributes();

            state._fsp--;

             current =iv_ruleMyAttributes; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyAttributes1475); 

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
    // $ANTLR end "entryRuleMyAttributes"


    // $ANTLR start "ruleMyAttributes"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:614:1: ruleMyAttributes returns [EObject current=null] : ( () ( (lv_attributes_1_0= ruleMyAttribute ) )* ) ;
    public final EObject ruleMyAttributes() throws RecognitionException {
        EObject current = null;

        EObject lv_attributes_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:617:28: ( ( () ( (lv_attributes_1_0= ruleMyAttribute ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:618:1: ( () ( (lv_attributes_1_0= ruleMyAttribute ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:618:1: ( () ( (lv_attributes_1_0= ruleMyAttribute ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:618:2: () ( (lv_attributes_1_0= ruleMyAttribute ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:618:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:619:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMyAttributesAccess().getMyAttributesAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:624:2: ( (lv_attributes_1_0= ruleMyAttribute ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==20||LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:625:1: (lv_attributes_1_0= ruleMyAttribute )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:625:1: (lv_attributes_1_0= ruleMyAttribute )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:626:3: lv_attributes_1_0= ruleMyAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMyAttributesAccess().getAttributesMyAttributeParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMyAttribute_in_ruleMyAttributes1530);
            	    lv_attributes_1_0=ruleMyAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMyAttributesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_1_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.MyAttribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // $ANTLR end "ruleMyAttributes"


    // $ANTLR start "entryRuleMyField"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:650:1: entryRuleMyField returns [EObject current=null] : iv_ruleMyField= ruleMyField EOF ;
    public final EObject entryRuleMyField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyField = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:651:2: (iv_ruleMyField= ruleMyField EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:652:2: iv_ruleMyField= ruleMyField EOF
            {
             newCompositeNode(grammarAccess.getMyFieldRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyField_in_entryRuleMyField1567);
            iv_ruleMyField=ruleMyField();

            state._fsp--;

             current =iv_ruleMyField; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyField1577); 

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
    // $ANTLR end "entryRuleMyField"


    // $ANTLR start "ruleMyField"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:659:1: ruleMyField returns [EObject current=null] : ( ( (lv_attr_0_0= ruleMyAttributes ) ) otherlv_1= 'var' (this_LT_2= RULE_LT )* ( (lv_bindings_3_0= ruleMyBinding ) ) ( (this_LT_4= RULE_LT )* otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_bindings_7_0= ruleMyBinding ) ) )* ruleVirtualSemi ) ;
    public final EObject ruleMyField() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_LT_2=null;
        Token this_LT_4=null;
        Token otherlv_5=null;
        Token this_LT_6=null;
        EObject lv_attr_0_0 = null;

        EObject lv_bindings_3_0 = null;

        EObject lv_bindings_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:662:28: ( ( ( (lv_attr_0_0= ruleMyAttributes ) ) otherlv_1= 'var' (this_LT_2= RULE_LT )* ( (lv_bindings_3_0= ruleMyBinding ) ) ( (this_LT_4= RULE_LT )* otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_bindings_7_0= ruleMyBinding ) ) )* ruleVirtualSemi ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:663:1: ( ( (lv_attr_0_0= ruleMyAttributes ) ) otherlv_1= 'var' (this_LT_2= RULE_LT )* ( (lv_bindings_3_0= ruleMyBinding ) ) ( (this_LT_4= RULE_LT )* otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_bindings_7_0= ruleMyBinding ) ) )* ruleVirtualSemi )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:663:1: ( ( (lv_attr_0_0= ruleMyAttributes ) ) otherlv_1= 'var' (this_LT_2= RULE_LT )* ( (lv_bindings_3_0= ruleMyBinding ) ) ( (this_LT_4= RULE_LT )* otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_bindings_7_0= ruleMyBinding ) ) )* ruleVirtualSemi )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:663:2: ( (lv_attr_0_0= ruleMyAttributes ) ) otherlv_1= 'var' (this_LT_2= RULE_LT )* ( (lv_bindings_3_0= ruleMyBinding ) ) ( (this_LT_4= RULE_LT )* otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_bindings_7_0= ruleMyBinding ) ) )* ruleVirtualSemi
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:663:2: ( (lv_attr_0_0= ruleMyAttributes ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:664:1: (lv_attr_0_0= ruleMyAttributes )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:664:1: (lv_attr_0_0= ruleMyAttributes )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:665:3: lv_attr_0_0= ruleMyAttributes
            {
             
            	        newCompositeNode(grammarAccess.getMyFieldAccess().getAttrMyAttributesParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMyAttributes_in_ruleMyField1623);
            lv_attr_0_0=ruleMyAttributes();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMyFieldRule());
            	        }
                   		set(
                   			current, 
                   			"attr",
                    		lv_attr_0_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.MyAttributes");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMyField1635); 

                	newLeafNode(otherlv_1, grammarAccess.getMyFieldAccess().getVarKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:685:1: (this_LT_2= RULE_LT )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_LT) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:685:2: this_LT_2= RULE_LT
            	    {
            	    this_LT_2=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyField1647); 
            	     
            	        newLeafNode(this_LT_2, grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:689:3: ( (lv_bindings_3_0= ruleMyBinding ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:690:1: (lv_bindings_3_0= ruleMyBinding )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:690:1: (lv_bindings_3_0= ruleMyBinding )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:691:3: lv_bindings_3_0= ruleMyBinding
            {
             
            	        newCompositeNode(grammarAccess.getMyFieldAccess().getBindingsMyBindingParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMyBinding_in_ruleMyField1669);
            lv_bindings_3_0=ruleMyBinding();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMyFieldRule());
            	        }
                   		add(
                   			current, 
                   			"bindings",
                    		lv_bindings_3_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.MyBinding");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:707:2: ( (this_LT_4= RULE_LT )* otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_bindings_7_0= ruleMyBinding ) ) )*
            loop25:
            do {
                int alt25=2;
                alt25 = dfa25.predict(input);
                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:707:3: (this_LT_4= RULE_LT )* otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_bindings_7_0= ruleMyBinding ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:707:3: (this_LT_4= RULE_LT )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==RULE_LT) ) {
            	            alt23=1;
            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:707:4: this_LT_4= RULE_LT
            	    	    {
            	    	    this_LT_4=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyField1682); 
            	    	     
            	    	        newLeafNode(this_LT_4, grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_4_0()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop23;
            	        }
            	    } while (true);

            	    otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMyField1695); 

            	        	newLeafNode(otherlv_5, grammarAccess.getMyFieldAccess().getCommaKeyword_4_1());
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:715:1: (this_LT_6= RULE_LT )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==RULE_LT) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:715:2: this_LT_6= RULE_LT
            	    	    {
            	    	    this_LT_6=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyField1707); 
            	    	     
            	    	        newLeafNode(this_LT_6, grammarAccess.getMyFieldAccess().getLTTerminalRuleCall_4_2()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop24;
            	        }
            	    } while (true);

            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:719:3: ( (lv_bindings_7_0= ruleMyBinding ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:720:1: (lv_bindings_7_0= ruleMyBinding )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:720:1: (lv_bindings_7_0= ruleMyBinding )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:721:3: lv_bindings_7_0= ruleMyBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMyFieldAccess().getBindingsMyBindingParserRuleCall_4_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMyBinding_in_ruleMyField1729);
            	    lv_bindings_7_0=ruleMyBinding();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMyFieldRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bindings",
            	            		lv_bindings_7_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.MyBinding");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             
                    newCompositeNode(grammarAccess.getMyFieldAccess().getVirtualSemiParserRuleCall_5()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleVirtualSemi_in_ruleMyField1747);
            ruleVirtualSemi();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleMyField"


    // $ANTLR start "entryRuleMyBinding"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:753:1: entryRuleMyBinding returns [EObject current=null] : iv_ruleMyBinding= ruleMyBinding EOF ;
    public final EObject entryRuleMyBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyBinding = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:754:2: (iv_ruleMyBinding= ruleMyBinding EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:755:2: iv_ruleMyBinding= ruleMyBinding EOF
            {
             newCompositeNode(grammarAccess.getMyBindingRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyBinding_in_entryRuleMyBinding1782);
            iv_ruleMyBinding=ruleMyBinding();

            state._fsp--;

             current =iv_ruleMyBinding; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyBinding1792); 

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
    // $ANTLR end "entryRuleMyBinding"


    // $ANTLR start "ruleMyBinding"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:762:1: ruleMyBinding returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (this_LT_1= RULE_LT )* otherlv_2= ':' (this_LT_3= RULE_LT )* ( (lv_type_4_0= ruleFQN ) ) )? ( (this_LT_5= RULE_LT )* otherlv_6= '=' (this_LT_7= RULE_LT )* ( (lv_expression_8_0= ruleMyPrimary ) ) )? ) ;
    public final EObject ruleMyBinding() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_LT_1=null;
        Token otherlv_2=null;
        Token this_LT_3=null;
        Token this_LT_5=null;
        Token otherlv_6=null;
        Token this_LT_7=null;
        AntlrDatatypeRuleToken lv_type_4_0 = null;

        EObject lv_expression_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:765:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (this_LT_1= RULE_LT )* otherlv_2= ':' (this_LT_3= RULE_LT )* ( (lv_type_4_0= ruleFQN ) ) )? ( (this_LT_5= RULE_LT )* otherlv_6= '=' (this_LT_7= RULE_LT )* ( (lv_expression_8_0= ruleMyPrimary ) ) )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:766:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (this_LT_1= RULE_LT )* otherlv_2= ':' (this_LT_3= RULE_LT )* ( (lv_type_4_0= ruleFQN ) ) )? ( (this_LT_5= RULE_LT )* otherlv_6= '=' (this_LT_7= RULE_LT )* ( (lv_expression_8_0= ruleMyPrimary ) ) )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:766:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (this_LT_1= RULE_LT )* otherlv_2= ':' (this_LT_3= RULE_LT )* ( (lv_type_4_0= ruleFQN ) ) )? ( (this_LT_5= RULE_LT )* otherlv_6= '=' (this_LT_7= RULE_LT )* ( (lv_expression_8_0= ruleMyPrimary ) ) )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:766:2: ( (lv_name_0_0= RULE_ID ) ) ( (this_LT_1= RULE_LT )* otherlv_2= ':' (this_LT_3= RULE_LT )* ( (lv_type_4_0= ruleFQN ) ) )? ( (this_LT_5= RULE_LT )* otherlv_6= '=' (this_LT_7= RULE_LT )* ( (lv_expression_8_0= ruleMyPrimary ) ) )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:766:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:767:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:767:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:768:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMyBinding1834); 

            			newLeafNode(lv_name_0_0, grammarAccess.getMyBindingAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMyBindingRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:784:2: ( (this_LT_1= RULE_LT )* otherlv_2= ':' (this_LT_3= RULE_LT )* ( (lv_type_4_0= ruleFQN ) ) )?
            int alt28=2;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:784:3: (this_LT_1= RULE_LT )* otherlv_2= ':' (this_LT_3= RULE_LT )* ( (lv_type_4_0= ruleFQN ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:784:3: (this_LT_1= RULE_LT )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==RULE_LT) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:784:4: this_LT_1= RULE_LT
                    	    {
                    	    this_LT_1=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyBinding1852); 
                    	     
                    	        newLeafNode(this_LT_1, grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleMyBinding1865); 

                        	newLeafNode(otherlv_2, grammarAccess.getMyBindingAccess().getColonKeyword_1_1());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:792:1: (this_LT_3= RULE_LT )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==RULE_LT) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:792:2: this_LT_3= RULE_LT
                    	    {
                    	    this_LT_3=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyBinding1877); 
                    	     
                    	        newLeafNode(this_LT_3, grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_1_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:796:3: ( (lv_type_4_0= ruleFQN ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:797:1: (lv_type_4_0= ruleFQN )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:797:1: (lv_type_4_0= ruleFQN )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:798:3: lv_type_4_0= ruleFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getMyBindingAccess().getTypeFQNParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleMyBinding1899);
                    lv_type_4_0=ruleFQN();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMyBindingRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_4_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.FQN");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:814:4: ( (this_LT_5= RULE_LT )* otherlv_6= '=' (this_LT_7= RULE_LT )* ( (lv_expression_8_0= ruleMyPrimary ) ) )?
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:814:5: (this_LT_5= RULE_LT )* otherlv_6= '=' (this_LT_7= RULE_LT )* ( (lv_expression_8_0= ruleMyPrimary ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:814:5: (this_LT_5= RULE_LT )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_LT) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:814:6: this_LT_5= RULE_LT
                    	    {
                    	    this_LT_5=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyBinding1914); 
                    	     
                    	        newLeafNode(this_LT_5, grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_2_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleMyBinding1927); 

                        	newLeafNode(otherlv_6, grammarAccess.getMyBindingAccess().getEqualsSignKeyword_2_1());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:822:1: (this_LT_7= RULE_LT )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_LT) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:822:2: this_LT_7= RULE_LT
                    	    {
                    	    this_LT_7=(Token)match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_ruleMyBinding1939); 
                    	     
                    	        newLeafNode(this_LT_7, grammarAccess.getMyBindingAccess().getLTTerminalRuleCall_2_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:826:3: ( (lv_expression_8_0= ruleMyPrimary ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:827:1: (lv_expression_8_0= ruleMyPrimary )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:827:1: (lv_expression_8_0= ruleMyPrimary )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug347012TestLanguage.g:828:3: lv_expression_8_0= ruleMyPrimary
                    {
                     
                    	        newCompositeNode(grammarAccess.getMyBindingAccess().getExpressionMyPrimaryParserRuleCall_2_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMyPrimary_in_ruleMyBinding1961);
                    lv_expression_8_0=ruleMyPrimary();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMyBindingRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_8_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug347012TestLanguage.MyPrimary");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleMyBinding"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA31 dfa31 = new DFA31(this);
    static final String DFA5_eotS =
        "\5\uffff";
    static final String DFA5_eofS =
        "\1\1\1\uffff\1\1\2\uffff";
    static final String DFA5_minS =
        "\1\4\1\uffff\1\4\1\uffff\1\4";
    static final String DFA5_maxS =
        "\1\32\1\uffff\1\32\1\uffff\1\32";
    static final String DFA5_acceptS =
        "\1\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA5_specialS =
        "\5\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\10\uffff\1\3\1\1\3\uffff\1\1\5\uffff\1\1\1\uffff\1\1",
            "",
            "\1\4\10\uffff\1\3\4\uffff\3\1\1\uffff\3\1\1\uffff\1\1",
            "",
            "\1\4\10\uffff\1\3\4\uffff\3\1\1\uffff\3\1\1\uffff\1\1"
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()* loopback of 179:1: ( (this_LT_1= RULE_LT )* kw= '.' (this_LT_3= RULE_LT )* this_ID_4= RULE_ID )*";
        }
    }
    static final String DFA25_eotS =
        "\5\uffff";
    static final String DFA25_eofS =
        "\2\uffff\1\1\2\uffff";
    static final String DFA25_minS =
        "\1\4\1\uffff\1\4\1\uffff\1\4";
    static final String DFA25_maxS =
        "\1\30\1\uffff\1\30\1\uffff\1\30";
    static final String DFA25_acceptS =
        "\1\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA25_specialS =
        "\5\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\2\11\uffff\1\1\11\uffff\1\3",
            "",
            "\1\4\16\uffff\2\1\1\uffff\2\1\1\3",
            "",
            "\1\4\16\uffff\2\1\1\uffff\2\1\1\3"
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "()* loopback of 707:2: ( (this_LT_4= RULE_LT )* otherlv_5= ',' (this_LT_6= RULE_LT )* ( (lv_bindings_7_0= ruleMyBinding ) ) )*";
        }
    }
    static final String DFA28_eotS =
        "\5\uffff";
    static final String DFA28_eofS =
        "\2\3\3\uffff";
    static final String DFA28_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA28_maxS =
        "\2\32\2\uffff\1\32";
    static final String DFA28_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA28_specialS =
        "\5\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\1\11\uffff\1\3\11\uffff\1\3\1\2\1\3",
            "\1\4\16\uffff\2\3\1\uffff\3\3\1\2\1\3",
            "",
            "",
            "\1\4\16\uffff\2\3\1\uffff\3\3\1\2\1\3"
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "784:2: ( (this_LT_1= RULE_LT )* otherlv_2= ':' (this_LT_3= RULE_LT )* ( (lv_type_4_0= ruleFQN ) ) )?";
        }
    }
    static final String DFA31_eotS =
        "\5\uffff";
    static final String DFA31_eofS =
        "\2\3\3\uffff";
    static final String DFA31_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA31_maxS =
        "\2\32\2\uffff\1\32";
    static final String DFA31_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA31_specialS =
        "\5\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\1\11\uffff\1\3\11\uffff\1\3\1\uffff\1\2",
            "\1\4\16\uffff\2\3\1\uffff\3\3\1\uffff\1\2",
            "",
            "",
            "\1\4\16\uffff\2\3\1\uffff\3\3\1\uffff\1\2"
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "814:4: ( (this_LT_5= RULE_LT )* otherlv_6= '=' (this_LT_7= RULE_LT )* ( (lv_expression_8_0= ruleMyPrimary ) ) )?";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMyProgram_in_entryRuleMyProgram75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyProgram85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyProgram131 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_ruleMyPackage_in_ruleMyProgram153 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyProgram165 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier202 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN294 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN345 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleFQN367 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_13_in_ruleFQN387 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleFQN403 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN425 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_ruleVirtualSemi_in_entryRuleVirtualSemi473 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVirtualSemi484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleVirtualSemi522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleVirtualSemi543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral588 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLiteral598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NUMBER_in_ruleLiteral640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteral668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleLiteral697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleLiteral734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyPrimary_in_entryRuleMyPrimary783 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyPrimary793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteral_in_ruleMyPrimary840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleMyPrimary867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyPackage_in_entryRuleMyPackage902 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyPackage912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMyPackage949 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyPackage961 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleMyPackage983 = new BitSet(new long[]{0x0000000000040010L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyPackage995 = new BitSet(new long[]{0x0000000000040010L});
        public static final BitSet FOLLOW_18_in_ruleMyPackage1008 = new BitSet(new long[]{0x0000000000380010L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyPackage1020 = new BitSet(new long[]{0x0000000000380010L});
        public static final BitSet FOLLOW_ruleMyClass_in_ruleMyPackage1043 = new BitSet(new long[]{0x0000000000380010L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyPackage1055 = new BitSet(new long[]{0x0000000000380010L});
        public static final BitSet FOLLOW_19_in_ruleMyPackage1070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyClass_in_entryRuleMyClass1106 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyClass1116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleMyClass1154 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleMyClass1168 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyClass1180 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMyClass1198 = new BitSet(new long[]{0x0000000000040010L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyClass1215 = new BitSet(new long[]{0x0000000000040010L});
        public static final BitSet FOLLOW_18_in_ruleMyClass1228 = new BitSet(new long[]{0x0000000000D80010L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyClass1240 = new BitSet(new long[]{0x0000000000D80010L});
        public static final BitSet FOLLOW_ruleMyField_in_ruleMyClass1263 = new BitSet(new long[]{0x0000000000D80010L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyClass1275 = new BitSet(new long[]{0x0000000000D80010L});
        public static final BitSet FOLLOW_19_in_ruleMyClass1290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyAttribute_in_entryRuleMyAttribute1326 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyAttribute1336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleMyAttribute1379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleMyAttribute1416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyAttributes_in_entryRuleMyAttributes1465 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyAttributes1475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyAttribute_in_ruleMyAttributes1530 = new BitSet(new long[]{0x0000000000500002L});
        public static final BitSet FOLLOW_ruleMyField_in_entryRuleMyField1567 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyField1577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyAttributes_in_ruleMyField1623 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleMyField1635 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyField1647 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleMyBinding_in_ruleMyField1669 = new BitSet(new long[]{0x0000000001004010L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyField1682 = new BitSet(new long[]{0x0000000001000010L});
        public static final BitSet FOLLOW_24_in_ruleMyField1695 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyField1707 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleMyBinding_in_ruleMyField1729 = new BitSet(new long[]{0x0000000001004010L});
        public static final BitSet FOLLOW_ruleVirtualSemi_in_ruleMyField1747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyBinding_in_entryRuleMyBinding1782 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyBinding1792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMyBinding1834 = new BitSet(new long[]{0x0000000006000012L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyBinding1852 = new BitSet(new long[]{0x0000000002000010L});
        public static final BitSet FOLLOW_25_in_ruleMyBinding1865 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyBinding1877 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleMyBinding1899 = new BitSet(new long[]{0x0000000004000012L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyBinding1914 = new BitSet(new long[]{0x0000000004000010L});
        public static final BitSet FOLLOW_26_in_ruleMyBinding1927 = new BitSet(new long[]{0x00000000000180F0L});
        public static final BitSet FOLLOW_RULE_LT_in_ruleMyBinding1939 = new BitSet(new long[]{0x00000000000180F0L});
        public static final BitSet FOLLOW_ruleMyPrimary_in_ruleMyBinding1961 = new BitSet(new long[]{0x0000000000000002L});
    }


}