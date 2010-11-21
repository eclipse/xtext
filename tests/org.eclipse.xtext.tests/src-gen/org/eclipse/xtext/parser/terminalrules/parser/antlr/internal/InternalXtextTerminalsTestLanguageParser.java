package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtextTerminalsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'with'", "','", "'hidden'", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "'returns'", "':'", "';'", "'::'", "'|'", "'?'", "'*'", "'+'", "'{'", "'='", "'+='", "'current'", "'}'", "'?='", "'['", "']'", "'terminal'", "'!'", "'->'", "'..'", "'enum'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=5;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__33=33;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int T__29=29;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__24=24;
    public static final int T__37=37;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__34=34;
    public static final int T__41=41;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalXtextTerminalsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtextTerminalsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtextTerminalsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g"; }



     	private XtextTerminalsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalXtextTerminalsTestLanguageParser(TokenStream input, IAstFactory factory, XtextTerminalsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.semanticModelBuilder = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Grammar";	
       	}
       	
       	@Override
       	protected XtextTerminalsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleGrammar"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:70:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:71:2: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:72:2: iv_ruleGrammar= ruleGrammar EOF
            {
             newCompositeNode(grammarAccess.getGrammarRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammar_in_entryRuleGrammar75);
            iv_ruleGrammar=ruleGrammar();

            state._fsp--;

             current =iv_ruleGrammar; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammar85); 

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
    // $ANTLR end "entryRuleGrammar"


    // $ANTLR start "ruleGrammar"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:79:1: ruleGrammar returns [EObject current=null] : (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_definesHiddenTokens_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_metamodelDeclarations_12_0 = null;

        EObject lv_rules_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:82:28: ( (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:83:1: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:83:1: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:83:3: otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleGrammar122); 

                	newLeafNode(otherlv_0, grammarAccess.getGrammarAccess().getGrammarKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:87:1: ( (lv_name_1_0= ruleGrammarID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:88:1: (lv_name_1_0= ruleGrammarID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:88:1: (lv_name_1_0= ruleGrammarID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:89:3: lv_name_1_0= ruleGrammarID
            {
             
            	        newCompositeNode(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar143);
            lv_name_1_0=ruleGrammarID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGrammarRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"GrammarID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:105:2: (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:105:4: otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleGrammar156); 

                        	newLeafNode(otherlv_2, grammarAccess.getGrammarAccess().getWithKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:109:1: ( ( ruleGrammarID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:110:1: ( ruleGrammarID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:110:1: ( ruleGrammarID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:111:3: ruleGrammarID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getGrammarRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar179);
                    ruleGrammarID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:124:2: (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:124:4: otherlv_4= ',' ( ( ruleGrammarID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar192); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:128:1: ( ( ruleGrammarID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:129:1: ( ruleGrammarID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:129:1: ( ruleGrammarID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:130:3: ruleGrammarID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getGrammarRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar215);
                    	    ruleGrammarID();

                    	    state._fsp--;

                    	     
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
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:143:6: ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:143:7: ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:143:7: ( (lv_definesHiddenTokens_6_0= 'hidden' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:144:1: (lv_definesHiddenTokens_6_0= 'hidden' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:144:1: (lv_definesHiddenTokens_6_0= 'hidden' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:145:3: lv_definesHiddenTokens_6_0= 'hidden'
                    {
                    lv_definesHiddenTokens_6_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleGrammar238); 

                            newLeafNode(lv_definesHiddenTokens_6_0, grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGrammarRule());
                    	        }
                           		setWithLastConsumed(current, "definesHiddenTokens", true, "hidden");
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleGrammar263); 

                        	newLeafNode(otherlv_7, grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:162:1: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:162:2: ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:162:2: ( (otherlv_8= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:163:1: (otherlv_8= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:163:1: (otherlv_8= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:164:3: otherlv_8= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getGrammarRule());
                            	        }
                                    
                            otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammar284); 

                            		newLeafNode(otherlv_8, grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
                            	

                            }


                            }

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:175:2: (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:175:4: otherlv_9= ',' ( (otherlv_10= RULE_ID ) )
                            	    {
                            	    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar297); 

                            	        	newLeafNode(otherlv_9, grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0());
                            	        
                            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:179:1: ( (otherlv_10= RULE_ID ) )
                            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:180:1: (otherlv_10= RULE_ID )
                            	    {
                            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:180:1: (otherlv_10= RULE_ID )
                            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:181:3: otherlv_10= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getGrammarRule());
                            	    	        }
                            	            
                            	    otherlv_10=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammar317); 

                            	    		newLeafNode(otherlv_10, grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleGrammar333); 

                        	newLeafNode(otherlv_11, grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:196:3: ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:197:1: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:197:1: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:198:3: lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar356);
            	    lv_metamodelDeclarations_12_0=ruleAbstractMetamodelDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGrammarRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"metamodelDeclarations",
            	            		lv_metamodelDeclarations_12_0, 
            	            		"AbstractMetamodelDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:214:3: ( (lv_rules_13_0= ruleAbstractRule ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==37||LA7_0==41) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:215:1: (lv_rules_13_0= ruleAbstractRule )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:215:1: (lv_rules_13_0= ruleAbstractRule )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:216:3: lv_rules_13_0= ruleAbstractRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_ruleGrammar378);
            	    lv_rules_13_0=ruleAbstractRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGrammarRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_13_0, 
            	            		"AbstractRule");
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
    // $ANTLR end "ruleGrammar"


    // $ANTLR start "entryRuleGrammarID"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:240:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:241:2: (iv_ruleGrammarID= ruleGrammarID EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:242:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             newCompositeNode(grammarAccess.getGrammarIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_entryRuleGrammarID416);
            iv_ruleGrammarID=ruleGrammarID();

            state._fsp--;

             current =iv_ruleGrammarID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammarID427); 

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
    // $ANTLR end "entryRuleGrammarID"


    // $ANTLR start "ruleGrammarID"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:249:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:252:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:253:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:253:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:253:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammarID467); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:260:1: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:261:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGrammarID486); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammarID501); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1()); 
            	        

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
    // $ANTLR end "ruleGrammarID"


    // $ANTLR start "entryRuleAbstractRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:281:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:282:2: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:283:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             newCompositeNode(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule548);
            iv_ruleAbstractRule=ruleAbstractRule();

            state._fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRule558); 

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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:290:1: ruleAbstractRule returns [EObject current=null] : (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRule_0 = null;

        EObject this_TerminalRule_1 = null;

        EObject this_EnumRule_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:293:28: ( (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:294:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:294:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            int alt9=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt9=1;
                }
                break;
            case 37:
                {
                alt9=2;
                }
                break;
            case 41:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:295:5: this_ParserRule_0= ruleParserRule
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_ruleAbstractRule605);
                    this_ParserRule_0=ruleParserRule();

                    state._fsp--;

                     
                            current = this_ParserRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:305:5: this_TerminalRule_1= ruleTerminalRule
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_ruleAbstractRule632);
                    this_TerminalRule_1=ruleTerminalRule();

                    state._fsp--;

                     
                            current = this_TerminalRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:315:5: this_EnumRule_2= ruleEnumRule
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_ruleAbstractRule659);
                    this_EnumRule_2=ruleEnumRule();

                    state._fsp--;

                     
                            current = this_EnumRule_2; 
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
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleAbstractMetamodelDeclaration"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:331:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:332:2: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:333:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             newCompositeNode(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration694);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();

            state._fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration704); 

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
    // $ANTLR end "entryRuleAbstractMetamodelDeclaration"


    // $ANTLR start "ruleAbstractMetamodelDeclaration"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:340:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:343:28: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:344:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:344:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            else if ( (LA10_0==20) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:345:5: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration751);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();

                    state._fsp--;

                     
                            current = this_GeneratedMetamodel_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:355:5: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration778);
                    this_ReferencedMetamodel_1=ruleReferencedMetamodel();

                    state._fsp--;

                     
                            current = this_ReferencedMetamodel_1; 
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
    // $ANTLR end "ruleAbstractMetamodelDeclaration"


    // $ANTLR start "entryRuleGeneratedMetamodel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:371:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:372:2: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:373:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             newCompositeNode(grammarAccess.getGeneratedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel813);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();

            state._fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGeneratedMetamodel823); 

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
    // $ANTLR end "entryRuleGeneratedMetamodel"


    // $ANTLR start "ruleGeneratedMetamodel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:380:1: ruleGeneratedMetamodel returns [EObject current=null] : (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:383:28: ( (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:384:1: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:384:1: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:384:3: otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleGeneratedMetamodel860); 

                	newLeafNode(otherlv_0, grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:388:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:389:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:389:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:390:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGeneratedMetamodel877); 

            			newLeafNode(lv_name_1_0, grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGeneratedMetamodelRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:406:2: ( (otherlv_2= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:407:1: (otherlv_2= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:407:1: (otherlv_2= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:408:3: otherlv_2= RULE_STRING
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getGeneratedMetamodelRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel902); 

            		newLeafNode(otherlv_2, grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            	

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:419:2: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:419:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleGeneratedMetamodel915); 

                        	newLeafNode(otherlv_3, grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:423:1: ( (lv_alias_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:424:1: (lv_alias_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:424:1: (lv_alias_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:425:3: lv_alias_4_0= RULE_ID
                    {
                    lv_alias_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGeneratedMetamodel932); 

                    			newLeafNode(lv_alias_4_0, grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGeneratedMetamodelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"alias",
                            		lv_alias_4_0, 
                            		"ID");
                    	    

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
    // $ANTLR end "ruleGeneratedMetamodel"


    // $ANTLR start "entryRuleReferencedMetamodel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:449:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:450:2: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:451:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             newCompositeNode(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel975);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();

            state._fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferencedMetamodel985); 

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
    // $ANTLR end "entryRuleReferencedMetamodel"


    // $ANTLR start "ruleReferencedMetamodel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:458:1: ruleReferencedMetamodel returns [EObject current=null] : (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:461:28: ( (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:462:1: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:462:1: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:462:3: otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReferencedMetamodel1022); 

                	newLeafNode(otherlv_0, grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:466:1: ( (otherlv_1= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:467:1: (otherlv_1= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:467:1: (otherlv_1= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:468:3: otherlv_1= RULE_STRING
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencedMetamodelRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1042); 

            		newLeafNode(otherlv_1, grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:479:2: (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:479:4: otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReferencedMetamodel1055); 

                        	newLeafNode(otherlv_2, grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:483:1: ( (lv_alias_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:484:1: (lv_alias_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:484:1: (lv_alias_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:485:3: lv_alias_3_0= RULE_ID
                    {
                    lv_alias_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferencedMetamodel1072); 

                    			newLeafNode(lv_alias_3_0, grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferencedMetamodelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"alias",
                            		lv_alias_3_0, 
                            		"ID");
                    	    

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
    // $ANTLR end "ruleReferencedMetamodel"


    // $ANTLR start "entryRuleParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:509:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:510:2: (iv_ruleParserRule= ruleParserRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:511:2: iv_ruleParserRule= ruleParserRule EOF
            {
             newCompositeNode(grammarAccess.getParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_entryRuleParserRule1115);
            iv_ruleParserRule=ruleParserRule();

            state._fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRule1125); 

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
    // $ANTLR end "entryRuleParserRule"


    // $ANTLR start "ruleParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:518:1: ruleParserRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_definesHiddenTokens_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_type_2_0 = null;

        EObject lv_alternatives_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:521:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:522:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:522:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:522:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:522:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:523:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:523:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:524:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1167); 

            			newLeafNode(lv_name_0_0, grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParserRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:540:2: (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:540:4: otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) )
                    {
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParserRule1185); 

                        	newLeafNode(otherlv_1, grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:544:1: ( (lv_type_2_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:545:1: (lv_type_2_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:545:1: (lv_type_2_0= ruleTypeRef )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:546:3: lv_type_2_0= ruleTypeRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleParserRule1206);
                    lv_type_2_0=ruleTypeRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParserRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_2_0, 
                            		"TypeRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:562:4: ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:562:5: ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:562:5: ( (lv_definesHiddenTokens_3_0= 'hidden' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:563:1: (lv_definesHiddenTokens_3_0= 'hidden' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:563:1: (lv_definesHiddenTokens_3_0= 'hidden' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:564:3: lv_definesHiddenTokens_3_0= 'hidden'
                    {
                    lv_definesHiddenTokens_3_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParserRule1227); 

                            newLeafNode(lv_definesHiddenTokens_3_0, grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getParserRuleRule());
                    	        }
                           		setWithLastConsumed(current, "definesHiddenTokens", true, "hidden");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParserRule1252); 

                        	newLeafNode(otherlv_4, grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:581:1: ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:581:2: ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:581:2: ( (otherlv_5= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:582:1: (otherlv_5= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:582:1: (otherlv_5= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:583:3: otherlv_5= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getParserRuleRule());
                            	        }
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1273); 

                            		newLeafNode(otherlv_5, grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
                            	

                            }


                            }

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:594:2: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==13) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:594:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                            	    {
                            	    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParserRule1286); 

                            	        	newLeafNode(otherlv_6, grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0());
                            	        
                            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:598:1: ( (otherlv_7= RULE_ID ) )
                            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:599:1: (otherlv_7= RULE_ID )
                            	    {
                            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:599:1: (otherlv_7= RULE_ID )
                            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:600:3: otherlv_7= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getParserRuleRule());
                            	    	        }
                            	            
                            	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1306); 

                            	    		newLeafNode(otherlv_7, grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop14;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParserRule1322); 

                        	newLeafNode(otherlv_8, grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3());
                        

                    }
                    break;

            }

            otherlv_9=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParserRule1336); 

                	newLeafNode(otherlv_9, grammarAccess.getParserRuleAccess().getColonKeyword_3());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:619:1: ( (lv_alternatives_10_0= ruleAlternatives ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:620:1: (lv_alternatives_10_0= ruleAlternatives )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:620:1: (lv_alternatives_10_0= ruleAlternatives )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:621:3: lv_alternatives_10_0= ruleAlternatives
            {
             
            	        newCompositeNode(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParserRule1357);
            lv_alternatives_10_0=ruleAlternatives();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParserRuleRule());
            	        }
                   		set(
                   			current, 
                   			"alternatives",
                    		lv_alternatives_10_0, 
                    		"Alternatives");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_11=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleParserRule1369); 

                	newLeafNode(otherlv_11, grammarAccess.getParserRuleAccess().getSemicolonKeyword_5());
                

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
    // $ANTLR end "ruleParserRule"


    // $ANTLR start "entryRuleTypeRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:649:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:650:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:651:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             newCompositeNode(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_entryRuleTypeRef1405);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRef1415); 

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
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:658:1: ruleTypeRef returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:661:28: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:662:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:662:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:662:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:662:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==24) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:662:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:662:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:663:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:663:1: (otherlv_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:664:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeRefRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeRef1461); 

                    		newLeafNode(otherlv_0, grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
                    	

                    }


                    }

                    otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTypeRef1473); 

                        	newLeafNode(otherlv_1, grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:679:3: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:680:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:680:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:681:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeRefRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeRef1495); 

            		newLeafNode(otherlv_2, grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleAlternatives"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:700:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:701:2: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:702:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             newCompositeNode(grammarAccess.getAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_entryRuleAlternatives1531);
            iv_ruleAlternatives=ruleAlternatives();

            state._fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternatives1541); 

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
    // $ANTLR end "entryRuleAlternatives"


    // $ANTLR start "ruleAlternatives"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:709:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Group_0 = null;

        EObject lv_groups_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:712:28: ( (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:713:1: (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:713:1: (this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:714:5: this_Group_0= ruleGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleAlternatives1588);
            this_Group_0=ruleGroup();

            state._fsp--;

             
                    current = this_Group_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:722:1: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:722:2: () (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:722:2: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:723:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:728:2: (otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==25) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:728:4: otherlv_2= '|' ( (lv_groups_3_0= ruleGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAlternatives1610); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:732:1: ( (lv_groups_3_0= ruleGroup ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:733:1: (lv_groups_3_0= ruleGroup )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:733:1: (lv_groups_3_0= ruleGroup )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:734:3: lv_groups_3_0= ruleGroup
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleAlternatives1631);
                    	    lv_groups_3_0=ruleGroup();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAlternativesRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"groups",
                    	            		lv_groups_3_0, 
                    	            		"Group");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);


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
    // $ANTLR end "ruleAlternatives"


    // $ANTLR start "entryRuleGroup"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:758:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:2: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:760:2: iv_ruleGroup= ruleGroup EOF
            {
             newCompositeNode(grammarAccess.getGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_entryRuleGroup1671);
            iv_ruleGroup=ruleGroup();

            state._fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroup1681); 

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
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:767:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_tokens_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:770:28: ( (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:771:1: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:771:1: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:772:5: this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup1728);
            this_AbstractToken_0=ruleAbstractToken();

            state._fsp--;

             
                    current = this_AbstractToken_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:780:1: ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||LA21_0==15||LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:780:2: () ( (lv_tokens_2_0= ruleAbstractToken ) )+
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:780:2: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:781:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getGroupAccess().getGroupTokensAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:786:2: ( (lv_tokens_2_0= ruleAbstractToken ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_STRING)||LA20_0==15||LA20_0==29) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:787:1: (lv_tokens_2_0= ruleAbstractToken )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:787:1: (lv_tokens_2_0= ruleAbstractToken )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:788:3: lv_tokens_2_0= ruleAbstractToken
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup1758);
                    	    lv_tokens_2_0=ruleAbstractToken();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getGroupRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"tokens",
                    	            		lv_tokens_2_0, 
                    	            		"AbstractToken");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


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
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAbstractToken"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:812:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:813:2: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:814:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             newCompositeNode(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1797);
            iv_ruleAbstractToken=ruleAbstractToken();

            state._fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractToken1807); 

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
    // $ANTLR end "entryRuleAbstractToken"


    // $ANTLR start "ruleAbstractToken"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:821:1: ruleAbstractToken returns [EObject current=null] : (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractTokenWithCardinality_0 = null;

        EObject this_Action_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:824:28: ( (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:825:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:825:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_STRING)||LA22_0==15) ) {
                alt22=1;
            }
            else if ( (LA22_0==29) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:826:5: this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken1854);
                    this_AbstractTokenWithCardinality_0=ruleAbstractTokenWithCardinality();

                    state._fsp--;

                     
                            current = this_AbstractTokenWithCardinality_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:836:5: this_Action_1= ruleAction
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleAbstractToken1881);
                    this_Action_1=ruleAction();

                    state._fsp--;

                     
                            current = this_Action_1; 
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
    // $ANTLR end "ruleAbstractToken"


    // $ANTLR start "entryRuleAbstractTokenWithCardinality"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:852:1: entryRuleAbstractTokenWithCardinality returns [EObject current=null] : iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF ;
    public final EObject entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTokenWithCardinality = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:853:2: (iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:854:2: iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF
            {
             newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality1916);
            iv_ruleAbstractTokenWithCardinality=ruleAbstractTokenWithCardinality();

            state._fsp--;

             current =iv_ruleAbstractTokenWithCardinality; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality1926); 

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
    // $ANTLR end "entryRuleAbstractTokenWithCardinality"


    // $ANTLR start "ruleAbstractTokenWithCardinality"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:861:1: ruleAbstractTokenWithCardinality returns [EObject current=null] : ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) ;
    public final EObject ruleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;
        EObject this_Assignment_0 = null;

        EObject this_AbstractTerminal_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:864:28: ( ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:865:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:865:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:865:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:865:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                int LA23_1 = input.LA(2);

                if ( ((LA23_1>=30 && LA23_1<=31)||LA23_1==34) ) {
                    alt23=1;
                }
                else if ( (LA23_1==EOF||(LA23_1>=RULE_ID && LA23_1<=RULE_STRING)||(LA23_1>=15 && LA23_1<=16)||LA23_1==23||(LA23_1>=25 && LA23_1<=29)) ) {
                    alt23=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA23_0==RULE_STRING||LA23_0==15) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:866:5: this_Assignment_0= ruleAssignment
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality1974);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;

                     
                            current = this_Assignment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:876:5: this_AbstractTerminal_1= ruleAbstractTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2001);
                    this_AbstractTerminal_1=ruleAbstractTerminal();

                    state._fsp--;

                     
                            current = this_AbstractTerminal_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:884:2: ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=26 && LA25_0<=28)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:885:1: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:885:1: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:886:1: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:886:1: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    int alt24=3;
                    switch ( input.LA(1) ) {
                    case 26:
                        {
                        alt24=1;
                        }
                        break;
                    case 27:
                        {
                        alt24=2;
                        }
                        break;
                    case 28:
                        {
                        alt24=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }

                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:887:3: lv_cardinality_2_1= '?'
                            {
                            lv_cardinality_2_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleAbstractTokenWithCardinality2021); 

                                    newLeafNode(lv_cardinality_2_1, grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAbstractTokenWithCardinalityRule());
                            	        }
                                   		setWithLastConsumed(current, "cardinality", lv_cardinality_2_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:899:8: lv_cardinality_2_2= '*'
                            {
                            lv_cardinality_2_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAbstractTokenWithCardinality2050); 

                                    newLeafNode(lv_cardinality_2_2, grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAbstractTokenWithCardinalityRule());
                            	        }
                                   		setWithLastConsumed(current, "cardinality", lv_cardinality_2_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:911:8: lv_cardinality_2_3= '+'
                            {
                            lv_cardinality_2_3=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAbstractTokenWithCardinality2079); 

                                    newLeafNode(lv_cardinality_2_3, grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAbstractTokenWithCardinalityRule());
                            	        }
                                   		setWithLastConsumed(current, "cardinality", lv_cardinality_2_3, null);
                            	    

                            }
                            break;

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
    // $ANTLR end "ruleAbstractTokenWithCardinality"


    // $ANTLR start "entryRuleAction"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:934:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:935:2: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:936:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction2132);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction2142); 

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
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:943:1: ruleAction returns [EObject current=null] : (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_feature_3_0=null;
        Token lv_operator_4_1=null;
        Token lv_operator_4_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_type_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:946:28: ( (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:947:1: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:947:1: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:947:3: otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAction2179); 

                	newLeafNode(otherlv_0, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:951:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:952:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:952:1: (lv_type_1_0= ruleTypeRef )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:953:3: lv_type_1_0= ruleTypeRef
            {
             
            	        newCompositeNode(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleAction2200);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getActionRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"TypeRef");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:969:2: (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:969:4: otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current'
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAction2213); 

                        	newLeafNode(otherlv_2, grammarAccess.getActionAccess().getFullStopKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:973:1: ( (lv_feature_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:974:1: (lv_feature_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:974:1: (lv_feature_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:975:3: lv_feature_3_0= RULE_ID
                    {
                    lv_feature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAction2230); 

                    			newLeafNode(lv_feature_3_0, grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getActionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"feature",
                            		lv_feature_3_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:991:2: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:992:1: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:992:1: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:993:1: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:993:1: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==30) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==31) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:994:3: lv_operator_4_1= '='
                            {
                            lv_operator_4_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleAction2255); 

                                    newLeafNode(lv_operator_4_1, grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getActionRule());
                            	        }
                                   		setWithLastConsumed(current, "operator", lv_operator_4_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1006:8: lv_operator_4_2= '+='
                            {
                            lv_operator_4_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAction2284); 

                                    newLeafNode(lv_operator_4_2, grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getActionRule());
                            	        }
                                   		setWithLastConsumed(current, "operator", lv_operator_4_2, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    otherlv_5=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAction2312); 

                        	newLeafNode(otherlv_5, grammarAccess.getActionAccess().getCurrentKeyword_2_3());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAction2326); 

                	newLeafNode(otherlv_6, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleAbstractTerminal"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1037:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1038:2: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1039:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             newCompositeNode(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2362);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();

            state._fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTerminal2372); 

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
    // $ANTLR end "entryRuleAbstractTerminal"


    // $ANTLR start "ruleAbstractTerminal"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1046:1: ruleAbstractTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1049:28: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1050:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1050:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
            int alt28=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt28=1;
                }
                break;
            case RULE_ID:
                {
                alt28=2;
                }
                break;
            case 15:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1051:5: this_Keyword_0= ruleKeyword
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAbstractTerminal2419);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;

                     
                            current = this_Keyword_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1061:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2446);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1071:5: this_ParenthesizedElement_2= ruleParenthesizedElement
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2473);
                    this_ParenthesizedElement_2=ruleParenthesizedElement();

                    state._fsp--;

                     
                            current = this_ParenthesizedElement_2; 
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
    // $ANTLR end "ruleAbstractTerminal"


    // $ANTLR start "entryRuleKeyword"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1087:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1088:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1089:2: iv_ruleKeyword= ruleKeyword EOF
            {
             newCompositeNode(grammarAccess.getKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_entryRuleKeyword2508);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeyword2518); 

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
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1096:1: ruleKeyword returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1099:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1100:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1100:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1101:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1101:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1102:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleKeyword2559); 

            			newLeafNode(lv_value_0_0, grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKeywordRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

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
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleRuleCall"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1126:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1127:2: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1128:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             newCompositeNode(grammarAccess.getRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_entryRuleRuleCall2599);
            iv_ruleRuleCall=ruleRuleCall();

            state._fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCall2609); 

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
    // $ANTLR end "entryRuleRuleCall"


    // $ANTLR start "ruleRuleCall"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1135:1: ruleRuleCall returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1138:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1139:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1139:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1140:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1140:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1141:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCall2653); 

            		newLeafNode(otherlv_0, grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            	

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
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1160:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1161:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1162:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment2688);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment2698); 

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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1169:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        Token lv_operator_1_3=null;
        EObject lv_terminal_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1172:28: ( ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1173:1: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1173:1: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1173:2: ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1173:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1174:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1174:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1175:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignment2740); 

            			newLeafNode(lv_feature_0_0, grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssignmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"feature",
                    		lv_feature_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1191:2: ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1192:1: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1192:1: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1193:1: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1193:1: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt29=1;
                }
                break;
            case 30:
                {
                alt29=2;
                }
                break;
            case 34:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1194:3: lv_operator_1_1= '+='
                    {
                    lv_operator_1_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAssignment2765); 

                            newLeafNode(lv_operator_1_1, grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssignmentRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1206:8: lv_operator_1_2= '='
                    {
                    lv_operator_1_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleAssignment2794); 

                            newLeafNode(lv_operator_1_2, grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssignmentRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1218:8: lv_operator_1_3= '?='
                    {
                    lv_operator_1_3=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAssignment2823); 

                            newLeafNode(lv_operator_1_3, grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssignmentRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_1_3, null);
                    	    

                    }
                    break;

            }


            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1233:2: ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1234:1: (lv_terminal_2_0= ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1234:1: (lv_terminal_2_0= ruleAssignableTerminal )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1235:3: lv_terminal_2_0= ruleAssignableTerminal
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignment2860);
            lv_terminal_2_0=ruleAssignableTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"terminal",
                    		lv_terminal_2_0, 
                    		"AssignableTerminal");
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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleAssignableTerminal"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1259:1: entryRuleAssignableTerminal returns [EObject current=null] : iv_ruleAssignableTerminal= ruleAssignableTerminal EOF ;
    public final EObject entryRuleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableTerminal = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1260:2: (iv_ruleAssignableTerminal= ruleAssignableTerminal EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1261:2: iv_ruleAssignableTerminal= ruleAssignableTerminal EOF
            {
             newCompositeNode(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal2896);
            iv_ruleAssignableTerminal=ruleAssignableTerminal();

            state._fsp--;

             current =iv_ruleAssignableTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableTerminal2906); 

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
    // $ANTLR end "entryRuleAssignableTerminal"


    // $ANTLR start "ruleAssignableTerminal"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1268:1: ruleAssignableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedAssignableElement_2 = null;

        EObject this_CrossReference_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1271:28: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1272:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1272:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            int alt30=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt30=1;
                }
                break;
            case RULE_ID:
                {
                alt30=2;
                }
                break;
            case 15:
                {
                alt30=3;
                }
                break;
            case 35:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1273:5: this_Keyword_0= ruleKeyword
                    {
                     
                            newCompositeNode(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAssignableTerminal2953);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;

                     
                            current = this_Keyword_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1283:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            newCompositeNode(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAssignableTerminal2980);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1293:5: this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement
                    {
                     
                            newCompositeNode(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal3007);
                    this_ParenthesizedAssignableElement_2=ruleParenthesizedAssignableElement();

                    state._fsp--;

                     
                            current = this_ParenthesizedAssignableElement_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1303:5: this_CrossReference_3= ruleCrossReference
                    {
                     
                            newCompositeNode(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_ruleAssignableTerminal3034);
                    this_CrossReference_3=ruleCrossReference();

                    state._fsp--;

                     
                            current = this_CrossReference_3; 
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
    // $ANTLR end "ruleAssignableTerminal"


    // $ANTLR start "entryRuleParenthesizedAssignableElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1319:1: entryRuleParenthesizedAssignableElement returns [EObject current=null] : iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF ;
    public final EObject entryRuleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedAssignableElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1320:2: (iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1321:2: iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement3069);
            iv_ruleParenthesizedAssignableElement=ruleParenthesizedAssignableElement();

            state._fsp--;

             current =iv_ruleParenthesizedAssignableElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement3079); 

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
    // $ANTLR end "entryRuleParenthesizedAssignableElement"


    // $ANTLR start "ruleParenthesizedAssignableElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1328:1: ruleParenthesizedAssignableElement returns [EObject current=null] : (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AssignableAlternatives_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1331:28: ( (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1332:1: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1332:1: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1332:3: otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedAssignableElement3116); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3138);
            this_AssignableAlternatives_1=ruleAssignableAlternatives();

            state._fsp--;

             
                    current = this_AssignableAlternatives_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedAssignableElement3149); 

                	newLeafNode(otherlv_2, grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2());
                

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
    // $ANTLR end "ruleParenthesizedAssignableElement"


    // $ANTLR start "entryRuleAssignableAlternatives"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1357:1: entryRuleAssignableAlternatives returns [EObject current=null] : iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF ;
    public final EObject entryRuleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableAlternatives = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1358:2: (iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1359:2: iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF
            {
             newCompositeNode(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3185);
            iv_ruleAssignableAlternatives=ruleAssignableAlternatives();

            state._fsp--;

             current =iv_ruleAssignableAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableAlternatives3195); 

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
    // $ANTLR end "entryRuleAssignableAlternatives"


    // $ANTLR start "ruleAssignableAlternatives"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1366:1: ruleAssignableAlternatives returns [EObject current=null] : (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final EObject ruleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AssignableTerminal_0 = null;

        EObject lv_groups_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1369:28: ( (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1370:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1370:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1371:5: this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3242);
            this_AssignableTerminal_0=ruleAssignableTerminal();

            state._fsp--;

             
                    current = this_AssignableTerminal_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1379:1: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==25) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1379:2: () (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1379:2: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1380:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1385:2: (otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==25) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1385:4: otherlv_2= '|' ( (lv_groups_3_0= ruleAssignableTerminal ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAssignableAlternatives3264); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1389:1: ( (lv_groups_3_0= ruleAssignableTerminal ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1390:1: (lv_groups_3_0= ruleAssignableTerminal )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1390:1: (lv_groups_3_0= ruleAssignableTerminal )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1391:3: lv_groups_3_0= ruleAssignableTerminal
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3285);
                    	    lv_groups_3_0=ruleAssignableTerminal();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAssignableAlternativesRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"groups",
                    	            		lv_groups_3_0, 
                    	            		"AssignableTerminal");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);


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
    // $ANTLR end "ruleAssignableAlternatives"


    // $ANTLR start "entryRuleCrossReference"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1415:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1416:2: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1417:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             newCompositeNode(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_entryRuleCrossReference3325);
            iv_ruleCrossReference=ruleCrossReference();

            state._fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReference3335); 

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
    // $ANTLR end "entryRuleCrossReference"


    // $ANTLR start "ruleCrossReference"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1424:1: ruleCrossReference returns [EObject current=null] : (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_terminal_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1427:28: ( (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1428:1: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1428:1: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1428:3: otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleCrossReference3372); 

                	newLeafNode(otherlv_0, grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1432:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1433:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1433:1: (lv_type_1_0= ruleTypeRef )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1434:3: lv_type_1_0= ruleTypeRef
            {
             
            	        newCompositeNode(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleCrossReference3393);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCrossReferenceRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"TypeRef");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1450:2: (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==25) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1450:4: otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleCrossReference3406); 

                        	newLeafNode(otherlv_2, grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1454:1: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1455:1: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1455:1: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1456:3: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {
                     
                    	        newCompositeNode(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3427);
                    lv_terminal_3_0=ruleCrossReferenceableTerminal();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCrossReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"terminal",
                            		lv_terminal_3_0, 
                            		"CrossReferenceableTerminal");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleCrossReference3441); 

                	newLeafNode(otherlv_4, grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3());
                

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
    // $ANTLR end "ruleCrossReference"


    // $ANTLR start "entryRuleCrossReferenceableTerminal"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1484:1: entryRuleCrossReferenceableTerminal returns [EObject current=null] : iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF ;
    public final EObject entryRuleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableTerminal = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1485:2: (iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1486:2: iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF
            {
             newCompositeNode(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal3477);
            iv_ruleCrossReferenceableTerminal=ruleCrossReferenceableTerminal();

            state._fsp--;

             current =iv_ruleCrossReferenceableTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal3487); 

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
    // $ANTLR end "entryRuleCrossReferenceableTerminal"


    // $ANTLR start "ruleCrossReferenceableTerminal"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1493:1: ruleCrossReferenceableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) ;
    public final EObject ruleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1496:28: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1497:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1497:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_STRING) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_ID) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1498:5: this_Keyword_0= ruleKeyword
                    {
                     
                            newCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3534);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;

                     
                            current = this_Keyword_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1508:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            newCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3561);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_1; 
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
    // $ANTLR end "ruleCrossReferenceableTerminal"


    // $ANTLR start "entryRuleParenthesizedElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1524:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1525:2: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1526:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement3596);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();

            state._fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedElement3606); 

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
    // $ANTLR end "entryRuleParenthesizedElement"


    // $ANTLR start "ruleParenthesizedElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1533:1: ruleParenthesizedElement returns [EObject current=null] : (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Alternatives_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1536:28: ( (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1537:1: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1537:1: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1537:3: otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedElement3643); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParenthesizedElement3665);
            this_Alternatives_1=ruleAlternatives();

            state._fsp--;

             
                    current = this_Alternatives_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedElement3676); 

                	newLeafNode(otherlv_2, grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2());
                

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
    // $ANTLR end "ruleParenthesizedElement"


    // $ANTLR start "entryRuleTerminalRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1562:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1563:2: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1564:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             newCompositeNode(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule3712);
            iv_ruleTerminalRule=ruleTerminalRule();

            state._fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule3722); 

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
    // $ANTLR end "entryRuleTerminalRule"


    // $ANTLR start "ruleTerminalRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1571:1: ruleTerminalRule returns [EObject current=null] : (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        EObject lv_alternatives_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1574:28: ( (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1575:1: (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1575:1: (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1575:3: otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleTerminalRule3759); 

                	newLeafNode(otherlv_0, grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1579:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1580:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1580:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1581:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTerminalRule3776); 

            			newLeafNode(lv_name_1_0, grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTerminalRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1597:2: (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==21) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1597:4: otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleTerminalRule3794); 

                        	newLeafNode(otherlv_2, grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1601:1: ( (lv_type_3_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1602:1: (lv_type_3_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1602:1: (lv_type_3_0= ruleTypeRef )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1603:3: lv_type_3_0= ruleTypeRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleTerminalRule3815);
                    lv_type_3_0=ruleTypeRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTerminalRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_3_0, 
                            		"TypeRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTerminalRule3829); 

                	newLeafNode(otherlv_4, grammarAccess.getTerminalRuleAccess().getColonKeyword_3());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1623:1: ( (lv_alternatives_5_0= ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1624:1: (lv_alternatives_5_0= ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1624:1: (lv_alternatives_5_0= ruleTerminalAlternatives )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1625:3: lv_alternatives_5_0= ruleTerminalAlternatives
            {
             
            	        newCompositeNode(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule3850);
            lv_alternatives_5_0=ruleTerminalAlternatives();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTerminalRuleRule());
            	        }
                   		set(
                   			current, 
                   			"alternatives",
                    		lv_alternatives_5_0, 
                    		"TerminalAlternatives");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTerminalRule3862); 

                	newLeafNode(otherlv_6, grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5());
                

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
    // $ANTLR end "ruleTerminalRule"


    // $ANTLR start "entryRuleTerminalAlternatives"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1653:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1654:2: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1655:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             newCompositeNode(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives3898);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();

            state._fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalAlternatives3908); 

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
    // $ANTLR end "entryRuleTerminalAlternatives"


    // $ANTLR start "ruleTerminalAlternatives"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1662:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_TerminalGroup_0 = null;

        EObject lv_groups_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1665:28: ( (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1666:1: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1666:1: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1667:5: this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives3955);
            this_TerminalGroup_0=ruleTerminalGroup();

            state._fsp--;

             
                    current = this_TerminalGroup_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1675:1: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==25) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1675:2: () (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1675:2: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1676:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1681:2: (otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==25) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1681:4: otherlv_2= '|' ( (lv_groups_3_0= ruleTerminalGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTerminalAlternatives3977); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1685:1: ( (lv_groups_3_0= ruleTerminalGroup ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1686:1: (lv_groups_3_0= ruleTerminalGroup )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1686:1: (lv_groups_3_0= ruleTerminalGroup )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1687:3: lv_groups_3_0= ruleTerminalGroup
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives3998);
                    	    lv_groups_3_0=ruleTerminalGroup();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTerminalAlternativesRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"groups",
                    	            		lv_groups_3_0, 
                    	            		"TerminalGroup");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt36 >= 1 ) break loop36;
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
                    } while (true);


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
    // $ANTLR end "ruleTerminalAlternatives"


    // $ANTLR start "entryRuleTerminalGroup"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1711:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1712:2: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1713:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             newCompositeNode(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup4038);
            iv_ruleTerminalGroup=ruleTerminalGroup();

            state._fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalGroup4048); 

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
    // $ANTLR end "entryRuleTerminalGroup"


    // $ANTLR start "ruleTerminalGroup"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1720:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_tokens_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1723:28: ( (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1724:1: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1724:1: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1725:5: this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4095);
            this_TerminalToken_0=ruleTerminalToken();

            state._fsp--;

             
                    current = this_TerminalToken_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1733:1: ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_STRING)||LA39_0==15||LA39_0==17||(LA39_0>=38 && LA39_0<=39)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1733:2: () ( (lv_tokens_2_0= ruleTerminalToken ) )+
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1733:2: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1734:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1739:2: ( (lv_tokens_2_0= ruleTerminalToken ) )+
                    int cnt38=0;
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_STRING)||LA38_0==15||LA38_0==17||(LA38_0>=38 && LA38_0<=39)) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1740:1: (lv_tokens_2_0= ruleTerminalToken )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1740:1: (lv_tokens_2_0= ruleTerminalToken )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1741:3: lv_tokens_2_0= ruleTerminalToken
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4125);
                    	    lv_tokens_2_0=ruleTerminalToken();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTerminalGroupRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"tokens",
                    	            		lv_tokens_2_0, 
                    	            		"TerminalToken");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt38 >= 1 ) break loop38;
                                EarlyExitException eee =
                                    new EarlyExitException(38, input);
                                throw eee;
                        }
                        cnt38++;
                    } while (true);


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
    // $ANTLR end "ruleTerminalGroup"


    // $ANTLR start "entryRuleTerminalToken"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1765:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1766:2: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1767:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             newCompositeNode(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken4164);
            iv_ruleTerminalToken=ruleTerminalToken();

            state._fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalToken4174); 

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
    // $ANTLR end "entryRuleTerminalToken"


    // $ANTLR start "ruleTerminalToken"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1774:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_1_1=null;
        Token lv_cardinality_1_2=null;
        Token lv_cardinality_1_3=null;
        EObject this_TerminalTokenElement_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1777:28: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1778:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1778:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1779:5: this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4221);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();

            state._fsp--;

             
                    current = this_TerminalTokenElement_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1787:1: ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=26 && LA41_0<=28)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1788:1: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1788:1: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1789:1: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1789:1: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    int alt40=3;
                    switch ( input.LA(1) ) {
                    case 26:
                        {
                        alt40=1;
                        }
                        break;
                    case 27:
                        {
                        alt40=2;
                        }
                        break;
                    case 28:
                        {
                        alt40=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }

                    switch (alt40) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1790:3: lv_cardinality_1_1= '?'
                            {
                            lv_cardinality_1_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTerminalToken4240); 

                                    newLeafNode(lv_cardinality_1_1, grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTerminalTokenRule());
                            	        }
                                   		setWithLastConsumed(current, "cardinality", lv_cardinality_1_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1802:8: lv_cardinality_1_2= '*'
                            {
                            lv_cardinality_1_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTerminalToken4269); 

                                    newLeafNode(lv_cardinality_1_2, grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTerminalTokenRule());
                            	        }
                                   		setWithLastConsumed(current, "cardinality", lv_cardinality_1_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1814:8: lv_cardinality_1_3= '+'
                            {
                            lv_cardinality_1_3=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTerminalToken4298); 

                                    newLeafNode(lv_cardinality_1_3, grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTerminalTokenRule());
                            	        }
                                   		setWithLastConsumed(current, "cardinality", lv_cardinality_1_3, null);
                            	    

                            }
                            break;

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
    // $ANTLR end "ruleTerminalToken"


    // $ANTLR start "entryRuleTerminalTokenElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1837:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1838:2: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1839:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             newCompositeNode(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement4351);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();

            state._fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalTokenElement4361); 

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
    // $ANTLR end "entryRuleTerminalTokenElement"


    // $ANTLR start "ruleTerminalTokenElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1846:1: ruleTerminalTokenElement returns [EObject current=null] : (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1849:28: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1850:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1850:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
            int alt42=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt42=1;
                }
                break;
            case RULE_ID:
                {
                alt42=2;
                }
                break;
            case 15:
                {
                alt42=3;
                }
                break;
            case 38:
            case 39:
                {
                alt42=4;
                }
                break;
            case 17:
                {
                alt42=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1851:5: this_CharacterRange_0= ruleCharacterRange
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4408);
                    this_CharacterRange_0=ruleCharacterRange();

                    state._fsp--;

                     
                            current = this_CharacterRange_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1861:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement4435);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1871:5: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement4462);
                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();

                    state._fsp--;

                     
                            current = this_ParenthesizedTerminalElement_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1881:5: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement4489);
                    this_AbstractNegatedToken_3=ruleAbstractNegatedToken();

                    state._fsp--;

                     
                            current = this_AbstractNegatedToken_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1891:5: this_Wildcard_4= ruleWildcard
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_ruleTerminalTokenElement4516);
                    this_Wildcard_4=ruleWildcard();

                    state._fsp--;

                     
                            current = this_Wildcard_4; 
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
    // $ANTLR end "ruleTerminalTokenElement"


    // $ANTLR start "entryRuleParenthesizedTerminalElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1907:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1908:2: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1909:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4551);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();

            state._fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4561); 

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
    // $ANTLR end "entryRuleParenthesizedTerminalElement"


    // $ANTLR start "ruleParenthesizedTerminalElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1916:1: ruleParenthesizedTerminalElement returns [EObject current=null] : (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_TerminalAlternatives_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1919:28: ( (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1920:1: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1920:1: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1920:3: otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedTerminalElement4598); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4620);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();

            state._fsp--;

             
                    current = this_TerminalAlternatives_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedTerminalElement4631); 

                	newLeafNode(otherlv_2, grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2());
                

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
    // $ANTLR end "ruleParenthesizedTerminalElement"


    // $ANTLR start "entryRuleAbstractNegatedToken"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1945:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1946:2: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1947:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             newCompositeNode(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken4667);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();

            state._fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractNegatedToken4677); 

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
    // $ANTLR end "entryRuleAbstractNegatedToken"


    // $ANTLR start "ruleAbstractNegatedToken"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1954:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UntilToken_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1957:28: ( (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1958:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1958:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==38) ) {
                alt43=1;
            }
            else if ( (LA43_0==39) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1959:5: this_NegatedToken_0= ruleNegatedToken
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4724);
                    this_NegatedToken_0=ruleNegatedToken();

                    state._fsp--;

                     
                            current = this_NegatedToken_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1969:5: this_UntilToken_1= ruleUntilToken
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken4751);
                    this_UntilToken_1=ruleUntilToken();

                    state._fsp--;

                     
                            current = this_UntilToken_1; 
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
    // $ANTLR end "ruleAbstractNegatedToken"


    // $ANTLR start "entryRuleNegatedToken"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1985:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1986:2: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1987:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             newCompositeNode(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4786);
            iv_ruleNegatedToken=ruleNegatedToken();

            state._fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegatedToken4796); 

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
    // $ANTLR end "entryRuleNegatedToken"


    // $ANTLR start "ruleNegatedToken"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1994:1: ruleNegatedToken returns [EObject current=null] : (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_terminal_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1997:28: ( (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1998:1: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1998:1: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1998:3: otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleNegatedToken4833); 

                	newLeafNode(otherlv_0, grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2002:1: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2003:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2003:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2004:3: lv_terminal_1_0= ruleTerminalTokenElement
            {
             
            	        newCompositeNode(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4854);
            lv_terminal_1_0=ruleTerminalTokenElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNegatedTokenRule());
            	        }
                   		set(
                   			current, 
                   			"terminal",
                    		lv_terminal_1_0, 
                    		"TerminalTokenElement");
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
    // $ANTLR end "ruleNegatedToken"


    // $ANTLR start "entryRuleUntilToken"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2028:1: entryRuleUntilToken returns [EObject current=null] : iv_ruleUntilToken= ruleUntilToken EOF ;
    public final EObject entryRuleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntilToken = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2029:2: (iv_ruleUntilToken= ruleUntilToken EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2030:2: iv_ruleUntilToken= ruleUntilToken EOF
            {
             newCompositeNode(grammarAccess.getUntilTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_entryRuleUntilToken4890);
            iv_ruleUntilToken=ruleUntilToken();

            state._fsp--;

             current =iv_ruleUntilToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUntilToken4900); 

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
    // $ANTLR end "entryRuleUntilToken"


    // $ANTLR start "ruleUntilToken"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2037:1: ruleUntilToken returns [EObject current=null] : (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleUntilToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_terminal_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2040:28: ( (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2041:1: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2041:1: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2041:3: otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleUntilToken4937); 

                	newLeafNode(otherlv_0, grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2045:1: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2046:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2046:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2047:3: lv_terminal_1_0= ruleTerminalTokenElement
            {
             
            	        newCompositeNode(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken4958);
            lv_terminal_1_0=ruleTerminalTokenElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUntilTokenRule());
            	        }
                   		set(
                   			current, 
                   			"terminal",
                    		lv_terminal_1_0, 
                    		"TerminalTokenElement");
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
    // $ANTLR end "ruleUntilToken"


    // $ANTLR start "entryRuleWildcard"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2071:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2072:2: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2073:2: iv_ruleWildcard= ruleWildcard EOF
            {
             newCompositeNode(grammarAccess.getWildcardRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_entryRuleWildcard4994);
            iv_ruleWildcard=ruleWildcard();

            state._fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcard5004); 

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
    // $ANTLR end "entryRuleWildcard"


    // $ANTLR start "ruleWildcard"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2080:1: ruleWildcard returns [EObject current=null] : ( () otherlv_1= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2083:28: ( ( () otherlv_1= '.' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2084:1: ( () otherlv_1= '.' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2084:1: ( () otherlv_1= '.' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2084:2: () otherlv_1= '.'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2084:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2085:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWildcardAccess().getWildcardAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleWildcard5050); 

                	newLeafNode(otherlv_1, grammarAccess.getWildcardAccess().getFullStopKeyword_1());
                

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
    // $ANTLR end "ruleWildcard"


    // $ANTLR start "entryRuleCharacterRange"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2102:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2103:2: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2104:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             newCompositeNode(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5086);
            iv_ruleCharacterRange=ruleCharacterRange();

            state._fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCharacterRange5096); 

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
    // $ANTLR end "entryRuleCharacterRange"


    // $ANTLR start "ruleCharacterRange"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2111:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Keyword_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2114:28: ( (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2115:1: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2115:1: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2116:5: this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange5143);
            this_Keyword_0=ruleKeyword();

            state._fsp--;

             
                    current = this_Keyword_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2124:1: ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==40) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2124:2: () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2124:2: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2125:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0(),
                                current);
                        

                    }

                    otherlv_2=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleCharacterRange5164); 

                        	newLeafNode(otherlv_2, grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2134:1: ( (lv_right_3_0= ruleKeyword ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2135:1: (lv_right_3_0= ruleKeyword )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2135:1: (lv_right_3_0= ruleKeyword )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2136:3: lv_right_3_0= ruleKeyword
                    {
                     
                    	        newCompositeNode(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange5185);
                    lv_right_3_0=ruleKeyword();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCharacterRangeRule());
                    	        }
                           		set(
                           			current, 
                           			"right",
                            		lv_right_3_0, 
                            		"Keyword");
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
    // $ANTLR end "ruleCharacterRange"


    // $ANTLR start "entryRuleEnumRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2160:1: entryRuleEnumRule returns [EObject current=null] : iv_ruleEnumRule= ruleEnumRule EOF ;
    public final EObject entryRuleEnumRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2161:2: (iv_ruleEnumRule= ruleEnumRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2162:2: iv_ruleEnumRule= ruleEnumRule EOF
            {
             newCompositeNode(grammarAccess.getEnumRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_entryRuleEnumRule5223);
            iv_ruleEnumRule=ruleEnumRule();

            state._fsp--;

             current =iv_ruleEnumRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumRule5233); 

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
    // $ANTLR end "entryRuleEnumRule"


    // $ANTLR start "ruleEnumRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2169:1: ruleEnumRule returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) ;
    public final EObject ruleEnumRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        EObject lv_alternatives_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2172:28: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2173:1: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2173:1: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2173:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEnumRule5270); 

                	newLeafNode(otherlv_0, grammarAccess.getEnumRuleAccess().getEnumKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2177:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2178:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2178:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2179:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumRule5287); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2195:2: (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==21) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2195:4: otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEnumRule5305); 

                        	newLeafNode(otherlv_2, grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2199:1: ( (lv_type_3_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2200:1: (lv_type_3_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2200:1: (lv_type_3_0= ruleTypeRef )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2201:3: lv_type_3_0= ruleTypeRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleEnumRule5326);
                    lv_type_3_0=ruleTypeRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_3_0, 
                            		"TypeRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleEnumRule5340); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumRuleAccess().getColonKeyword_3());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2221:1: ( (lv_alternatives_5_0= ruleEnumLiterals ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2222:1: (lv_alternatives_5_0= ruleEnumLiterals )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2222:1: (lv_alternatives_5_0= ruleEnumLiterals )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2223:3: lv_alternatives_5_0= ruleEnumLiterals
            {
             
            	        newCompositeNode(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_ruleEnumRule5361);
            lv_alternatives_5_0=ruleEnumLiterals();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEnumRuleRule());
            	        }
                   		set(
                   			current, 
                   			"alternatives",
                    		lv_alternatives_5_0, 
                    		"EnumLiterals");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleEnumRule5373); 

                	newLeafNode(otherlv_6, grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5());
                

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
    // $ANTLR end "ruleEnumRule"


    // $ANTLR start "entryRuleEnumLiterals"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2251:1: entryRuleEnumLiterals returns [EObject current=null] : iv_ruleEnumLiterals= ruleEnumLiterals EOF ;
    public final EObject entryRuleEnumLiterals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiterals = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2252:2: (iv_ruleEnumLiterals= ruleEnumLiterals EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2253:2: iv_ruleEnumLiterals= ruleEnumLiterals EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals5409);
            iv_ruleEnumLiterals=ruleEnumLiterals();

            state._fsp--;

             current =iv_ruleEnumLiterals; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiterals5419); 

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
    // $ANTLR end "entryRuleEnumLiterals"


    // $ANTLR start "ruleEnumLiterals"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2260:1: ruleEnumLiterals returns [EObject current=null] : (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final EObject ruleEnumLiterals() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_EnumLiteralDeclaration_0 = null;

        EObject lv_groups_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2263:28: ( (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2264:1: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2264:1: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2265:5: this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5466);
            this_EnumLiteralDeclaration_0=ruleEnumLiteralDeclaration();

            state._fsp--;

             
                    current = this_EnumLiteralDeclaration_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2273:1: ( () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==25) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2273:2: () (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2273:2: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2274:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2279:2: (otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+
                    int cnt46=0;
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==25) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2279:4: otherlv_2= '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleEnumLiterals5488); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0());
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2283:1: ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2284:1: (lv_groups_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2284:1: (lv_groups_3_0= ruleEnumLiteralDeclaration )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2285:3: lv_groups_3_0= ruleEnumLiteralDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5509);
                    	    lv_groups_3_0=ruleEnumLiteralDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEnumLiteralsRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"groups",
                    	            		lv_groups_3_0, 
                    	            		"EnumLiteralDeclaration");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt46 >= 1 ) break loop46;
                                EarlyExitException eee =
                                    new EarlyExitException(46, input);
                                throw eee;
                        }
                        cnt46++;
                    } while (true);


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
    // $ANTLR end "ruleEnumLiterals"


    // $ANTLR start "entryRuleEnumLiteralDeclaration"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2309:1: entryRuleEnumLiteralDeclaration returns [EObject current=null] : iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF ;
    public final EObject entryRuleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralDeclaration = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2310:2: (iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2311:2: iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration5549);
            iv_ruleEnumLiteralDeclaration=ruleEnumLiteralDeclaration();

            state._fsp--;

             current =iv_ruleEnumLiteralDeclaration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration5559); 

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
    // $ANTLR end "entryRuleEnumLiteralDeclaration"


    // $ANTLR start "ruleEnumLiteralDeclaration"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2318:1: ruleEnumLiteralDeclaration returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_literal_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2321:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2322:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2322:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2322:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2322:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2323:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2323:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2324:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumLiteralDeclarationRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration5604); 

            		newLeafNode(otherlv_0, grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            	

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2335:2: (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==30) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2335:4: otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {
                    otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleEnumLiteralDeclaration5617); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2339:1: ( (lv_literal_2_0= ruleKeyword ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2340:1: (lv_literal_2_0= ruleKeyword )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2340:1: (lv_literal_2_0= ruleKeyword )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2341:3: lv_literal_2_0= ruleKeyword
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration5638);
                    lv_literal_2_0=ruleKeyword();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumLiteralDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"literal",
                            		lv_literal_2_0, 
                            		"Keyword");
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
    // $ANTLR end "ruleEnumLiteralDeclaration"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammar85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleGrammar122 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar143 = new BitSet(new long[]{0x0000022000145010L});
        public static final BitSet FOLLOW_12_in_ruleGrammar156 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar179 = new BitSet(new long[]{0x0000022000147010L});
        public static final BitSet FOLLOW_13_in_ruleGrammar192 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar215 = new BitSet(new long[]{0x0000022000147010L});
        public static final BitSet FOLLOW_14_in_ruleGrammar238 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleGrammar263 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar284 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleGrammar297 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar317 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleGrammar333 = new BitSet(new long[]{0x0000022000145010L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar356 = new BitSet(new long[]{0x0000022000145010L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar378 = new BitSet(new long[]{0x0000022000145012L});
        public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID416 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID467 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleGrammarID486 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID501 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule548 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_ruleAbstractRule659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration694 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel813 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleGeneratedMetamodel860 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel877 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel902 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel915 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel975 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel1022 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1042 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleReferencedMetamodel1055 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1115 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1167 = new BitSet(new long[]{0x0000000000604000L});
        public static final BitSet FOLLOW_21_in_ruleParserRule1185 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1206 = new BitSet(new long[]{0x0000000000404000L});
        public static final BitSet FOLLOW_14_in_ruleParserRule1227 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleParserRule1252 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1273 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleParserRule1286 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1306 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleParserRule1322 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleParserRule1336 = new BitSet(new long[]{0x0000000020008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1357 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleParserRule1369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1405 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1461 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleTypeRef1473 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives1531 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives1541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1588 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleAlternatives1610 = new BitSet(new long[]{0x0000000020008030L});
        public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1631 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup1671 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroup1681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1728 = new BitSet(new long[]{0x0000000020008032L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1758 = new BitSet(new long[]{0x0000000020008032L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1797 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken1807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken1854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken1881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality1916 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality1926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality1974 = new BitSet(new long[]{0x000000001C000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2001 = new BitSet(new long[]{0x000000001C000002L});
        public static final BitSet FOLLOW_26_in_ruleAbstractTokenWithCardinality2021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleAbstractTokenWithCardinality2050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleAbstractTokenWithCardinality2079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction2132 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction2142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleAction2179 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction2200 = new BitSet(new long[]{0x0000000200020000L});
        public static final BitSet FOLLOW_17_in_ruleAction2213 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAction2230 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_30_in_ruleAction2255 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_31_in_ruleAction2284 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleAction2312 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleAction2326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2362 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal2372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal2419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword2508 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeyword2518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword2559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall2599 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall2609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall2653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment2688 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment2698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment2740 = new BitSet(new long[]{0x00000004C0000000L});
        public static final BitSet FOLLOW_31_in_ruleAssignment2765 = new BitSet(new long[]{0x0000000800008030L});
        public static final BitSet FOLLOW_30_in_ruleAssignment2794 = new BitSet(new long[]{0x0000000800008030L});
        public static final BitSet FOLLOW_34_in_ruleAssignment2823 = new BitSet(new long[]{0x0000000800008030L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignment2860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal2896 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal2906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleAssignableTerminal2953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleAssignableTerminal2980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal3007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_ruleAssignableTerminal3034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement3069 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement3079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedAssignableElement3116 = new BitSet(new long[]{0x0000000800008030L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3138 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedAssignableElement3149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3185 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives3195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3242 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleAssignableAlternatives3264 = new BitSet(new long[]{0x0000000800008030L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3285 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference3325 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference3335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleCrossReference3372 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference3393 = new BitSet(new long[]{0x0000001002000000L});
        public static final BitSet FOLLOW_25_in_ruleCrossReference3406 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3427 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleCrossReference3441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal3477 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal3487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement3596 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement3606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedElement3643 = new BitSet(new long[]{0x0000000020008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement3665 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedElement3676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule3712 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule3722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleTerminalRule3759 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule3776 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_21_in_ruleTerminalRule3794 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule3815 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleTerminalRule3829 = new BitSet(new long[]{0x000000C000028030L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule3850 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleTerminalRule3862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives3898 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives3908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives3955 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleTerminalAlternatives3977 = new BitSet(new long[]{0x000000C000028030L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives3998 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup4038 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup4048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4095 = new BitSet(new long[]{0x000000C000028032L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4125 = new BitSet(new long[]{0x000000C000028032L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken4164 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken4174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4221 = new BitSet(new long[]{0x000000001C000002L});
        public static final BitSet FOLLOW_26_in_ruleTerminalToken4240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleTerminalToken4269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleTerminalToken4298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement4351 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement4361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement4435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement4462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement4489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement4516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4551 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement4598 = new BitSet(new long[]{0x000000C000028030L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4620 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedTerminalElement4631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken4667 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken4677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken4751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4786 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken4796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleNegatedToken4833 = new BitSet(new long[]{0x000000C000028030L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken4890 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken4900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleUntilToken4937 = new BitSet(new long[]{0x000000C000028030L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken4958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard4994 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcard5004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleWildcard5050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5086 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange5096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5143 = new BitSet(new long[]{0x0000010000000002L});
        public static final BitSet FOLLOW_40_in_ruleCharacterRange5164 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule5223 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule5233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEnumRule5270 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumRule5287 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_21_in_ruleEnumRule5305 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleEnumRule5326 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleEnumRule5340 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_ruleEnumRule5361 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleEnumRule5373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals5409 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals5419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5466 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleEnumLiterals5488 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5509 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration5549 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration5559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration5604 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleEnumLiteralDeclaration5617 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration5638 = new BitSet(new long[]{0x0000000000000002L});
    }


}