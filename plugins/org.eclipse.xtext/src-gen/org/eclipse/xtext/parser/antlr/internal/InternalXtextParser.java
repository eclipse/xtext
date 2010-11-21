package org.eclipse.xtext.parser.antlr.internal; 

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
import org.eclipse.xtext.services.XtextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'with'", "','", "'hidden'", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "'returns'", "':'", "';'", "'::'", "'|'", "'&'", "'?'", "'*'", "'+'", "'{'", "'='", "'+='", "'current'", "'}'", "'?='", "'['", "']'", "'terminal'", "'!'", "'->'", "'..'", "'enum'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__42=42;
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


        public InternalXtextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtextParser.tokenNames; }
    public String getGrammarFileName() { return "../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g"; }



     	private XtextGrammarAccess grammarAccess;
     	
        public InternalXtextParser(TokenStream input, IAstFactory factory, XtextGrammarAccess grammarAccess) {
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
       	protected XtextGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleGrammar"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:70:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:71:2: (iv_ruleGrammar= ruleGrammar EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:72:2: iv_ruleGrammar= ruleGrammar EOF
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:79:1: ruleGrammar returns [EObject current=null] : (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) ;
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
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:82:28: ( (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:83:1: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:83:1: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:83:3: otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleGrammar122); 

                	newLeafNode(otherlv_0, grammarAccess.getGrammarAccess().getGrammarKeyword_0());
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:87:1: ( (lv_name_1_0= ruleGrammarID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:88:1: (lv_name_1_0= ruleGrammarID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:88:1: (lv_name_1_0= ruleGrammarID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:89:3: lv_name_1_0= ruleGrammarID
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:105:2: (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:105:4: otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleGrammar156); 

                        	newLeafNode(otherlv_2, grammarAccess.getGrammarAccess().getWithKeyword_2_0());
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:109:1: ( ( ruleGrammarID ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:110:1: ( ruleGrammarID )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:110:1: ( ruleGrammarID )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:111:3: ruleGrammarID
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

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:124:2: (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:124:4: otherlv_4= ',' ( ( ruleGrammarID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar192); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:128:1: ( ( ruleGrammarID ) )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:129:1: ( ruleGrammarID )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:129:1: ( ruleGrammarID )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:130:3: ruleGrammarID
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:143:6: ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:143:7: ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')'
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:143:7: ( (lv_definesHiddenTokens_6_0= 'hidden' ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:144:1: (lv_definesHiddenTokens_6_0= 'hidden' )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:144:1: (lv_definesHiddenTokens_6_0= 'hidden' )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:145:3: lv_definesHiddenTokens_6_0= 'hidden'
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
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:162:1: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:162:2: ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                            {
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:162:2: ( (otherlv_8= RULE_ID ) )
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:163:1: (otherlv_8= RULE_ID )
                            {
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:163:1: (otherlv_8= RULE_ID )
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:164:3: otherlv_8= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getGrammarRule());
                            	        }
                                    
                            otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammar284); 

                            		newLeafNode(otherlv_8, grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
                            	

                            }


                            }

                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:175:2: (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:175:4: otherlv_9= ',' ( (otherlv_10= RULE_ID ) )
                            	    {
                            	    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar297); 

                            	        	newLeafNode(otherlv_9, grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0());
                            	        
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:179:1: ( (otherlv_10= RULE_ID ) )
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:180:1: (otherlv_10= RULE_ID )
                            	    {
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:180:1: (otherlv_10= RULE_ID )
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:181:3: otherlv_10= RULE_ID
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:196:3: ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:197:1: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:197:1: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:198:3: lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:214:3: ( (lv_rules_13_0= ruleAbstractRule ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==38||LA7_0==42) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:215:1: (lv_rules_13_0= ruleAbstractRule )
            	    {
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:215:1: (lv_rules_13_0= ruleAbstractRule )
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:216:3: lv_rules_13_0= ruleAbstractRule
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:240:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:241:2: (iv_ruleGrammarID= ruleGrammarID EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:242:2: iv_ruleGrammarID= ruleGrammarID EOF
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:249:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:252:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:253:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:253:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:253:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammarID467); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:260:1: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:261:2: kw= '.' this_ID_2= RULE_ID
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:281:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:282:2: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:283:2: iv_ruleAbstractRule= ruleAbstractRule EOF
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:290:1: ruleAbstractRule returns [EObject current=null] : (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRule_0 = null;

        EObject this_TerminalRule_1 = null;

        EObject this_EnumRule_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:293:28: ( (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:294:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:294:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            int alt9=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt9=1;
                }
                break;
            case 38:
                {
                alt9=2;
                }
                break;
            case 42:
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:295:5: this_ParserRule_0= ruleParserRule
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:305:5: this_TerminalRule_1= ruleTerminalRule
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:315:5: this_EnumRule_2= ruleEnumRule
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:331:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:332:2: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:333:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:340:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:343:28: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:344:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:344:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:345:5: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:355:5: this_ReferencedMetamodel_1= ruleReferencedMetamodel
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:371:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:372:2: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:373:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:380:1: ruleGeneratedMetamodel returns [EObject current=null] : (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:383:28: ( (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:384:1: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:384:1: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:384:3: otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleGeneratedMetamodel860); 

                	newLeafNode(otherlv_0, grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0());
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:388:1: ( (lv_name_1_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:389:1: (lv_name_1_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:389:1: (lv_name_1_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:390:3: lv_name_1_0= RULE_ID
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:406:2: ( (otherlv_2= RULE_STRING ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:407:1: (otherlv_2= RULE_STRING )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:407:1: (otherlv_2= RULE_STRING )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:408:3: otherlv_2= RULE_STRING
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getGeneratedMetamodelRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel902); 

            		newLeafNode(otherlv_2, grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            	

            }


            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:419:2: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:419:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleGeneratedMetamodel915); 

                        	newLeafNode(otherlv_3, grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0());
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:423:1: ( (lv_alias_4_0= RULE_ID ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:424:1: (lv_alias_4_0= RULE_ID )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:424:1: (lv_alias_4_0= RULE_ID )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:425:3: lv_alias_4_0= RULE_ID
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:449:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:450:2: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:451:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:458:1: ruleReferencedMetamodel returns [EObject current=null] : (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:461:28: ( (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:462:1: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:462:1: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:462:3: otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReferencedMetamodel1022); 

                	newLeafNode(otherlv_0, grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0());
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:466:1: ( (otherlv_1= RULE_STRING ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:467:1: (otherlv_1= RULE_STRING )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:467:1: (otherlv_1= RULE_STRING )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:468:3: otherlv_1= RULE_STRING
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencedMetamodelRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1042); 

            		newLeafNode(otherlv_1, grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            	

            }


            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:479:2: (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:479:4: otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReferencedMetamodel1055); 

                        	newLeafNode(otherlv_2, grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0());
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:483:1: ( (lv_alias_3_0= RULE_ID ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:484:1: (lv_alias_3_0= RULE_ID )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:484:1: (lv_alias_3_0= RULE_ID )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:485:3: lv_alias_3_0= RULE_ID
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:509:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:510:2: (iv_ruleParserRule= ruleParserRule EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:511:2: iv_ruleParserRule= ruleParserRule EOF
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:518:1: ruleParserRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' ) ;
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
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:521:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:522:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:522:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:522:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';'
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:522:2: ( (lv_name_0_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:523:1: (lv_name_0_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:523:1: (lv_name_0_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:524:3: lv_name_0_0= RULE_ID
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:540:2: (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:540:4: otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) )
                    {
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParserRule1185); 

                        	newLeafNode(otherlv_1, grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0());
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:544:1: ( (lv_type_2_0= ruleTypeRef ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:545:1: (lv_type_2_0= ruleTypeRef )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:545:1: (lv_type_2_0= ruleTypeRef )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:546:3: lv_type_2_0= ruleTypeRef
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:562:4: ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:562:5: ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')'
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:562:5: ( (lv_definesHiddenTokens_3_0= 'hidden' ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:563:1: (lv_definesHiddenTokens_3_0= 'hidden' )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:563:1: (lv_definesHiddenTokens_3_0= 'hidden' )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:564:3: lv_definesHiddenTokens_3_0= 'hidden'
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
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:581:1: ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:581:2: ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                            {
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:581:2: ( (otherlv_5= RULE_ID ) )
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:582:1: (otherlv_5= RULE_ID )
                            {
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:582:1: (otherlv_5= RULE_ID )
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:583:3: otherlv_5= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getParserRuleRule());
                            	        }
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1273); 

                            		newLeafNode(otherlv_5, grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
                            	

                            }


                            }

                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:594:2: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==13) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:594:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                            	    {
                            	    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParserRule1286); 

                            	        	newLeafNode(otherlv_6, grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0());
                            	        
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:598:1: ( (otherlv_7= RULE_ID ) )
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:599:1: (otherlv_7= RULE_ID )
                            	    {
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:599:1: (otherlv_7= RULE_ID )
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:600:3: otherlv_7= RULE_ID
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
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:619:1: ( (lv_alternatives_10_0= ruleAlternatives ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:620:1: (lv_alternatives_10_0= ruleAlternatives )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:620:1: (lv_alternatives_10_0= ruleAlternatives )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:621:3: lv_alternatives_10_0= ruleAlternatives
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:649:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:650:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:651:2: iv_ruleTypeRef= ruleTypeRef EOF
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:658:1: ruleTypeRef returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:661:28: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:662:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:662:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:662:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:662:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:662:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:662:3: ( (otherlv_0= RULE_ID ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:663:1: (otherlv_0= RULE_ID )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:663:1: (otherlv_0= RULE_ID )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:664:3: otherlv_0= RULE_ID
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:679:3: ( (otherlv_2= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:1: (otherlv_2= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:1: (otherlv_2= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:681:3: otherlv_2= RULE_ID
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:700:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:701:2: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:702:2: iv_ruleAlternatives= ruleAlternatives EOF
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:709:1: ruleAlternatives returns [EObject current=null] : (this_UnorderedGroup_0= ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_UnorderedGroup_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:712:28: ( (this_UnorderedGroup_0= ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:713:1: (this_UnorderedGroup_0= ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:713:1: (this_UnorderedGroup_0= ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:714:5: this_UnorderedGroup_0= ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getAlternativesAccess().getUnorderedGroupParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_ruleAlternatives1588);
            this_UnorderedGroup_0=ruleUnorderedGroup();

            state._fsp--;

             
                    current = this_UnorderedGroup_0; 
                    afterParserOrEnumRuleCall();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:722:1: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:722:2: () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:722:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:723:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0(),
                                current);
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:728:2: (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+
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
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:728:4: otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAlternatives1610); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	        
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:732:1: ( (lv_elements_3_0= ruleUnorderedGroup ) )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:733:1: (lv_elements_3_0= ruleUnorderedGroup )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:733:1: (lv_elements_3_0= ruleUnorderedGroup )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:734:3: lv_elements_3_0= ruleUnorderedGroup
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAlternativesAccess().getElementsUnorderedGroupParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_ruleAlternatives1631);
                    	    lv_elements_3_0=ruleUnorderedGroup();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAlternativesRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_3_0, 
                    	            		"UnorderedGroup");
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


    // $ANTLR start "entryRuleUnorderedGroup"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:758:1: entryRuleUnorderedGroup returns [EObject current=null] : iv_ruleUnorderedGroup= ruleUnorderedGroup EOF ;
    public final EObject entryRuleUnorderedGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedGroup = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:759:2: (iv_ruleUnorderedGroup= ruleUnorderedGroup EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:760:2: iv_ruleUnorderedGroup= ruleUnorderedGroup EOF
            {
             newCompositeNode(grammarAccess.getUnorderedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup1671);
            iv_ruleUnorderedGroup=ruleUnorderedGroup();

            state._fsp--;

             current =iv_ruleUnorderedGroup; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnorderedGroup1681); 

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
    // $ANTLR end "entryRuleUnorderedGroup"


    // $ANTLR start "ruleUnorderedGroup"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:767:1: ruleUnorderedGroup returns [EObject current=null] : (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) ;
    public final EObject ruleUnorderedGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Group_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:770:28: ( (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:771:1: (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:771:1: (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:772:5: this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleUnorderedGroup1728);
            this_Group_0=ruleGroup();

            state._fsp--;

             
                    current = this_Group_0; 
                    afterParserOrEnumRuleCall();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:780:1: ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==26) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:780:2: () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:780:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:781:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0(),
                                current);
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:786:2: (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==26) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:786:4: otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleUnorderedGroup1750); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0());
                    	        
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:790:1: ( (lv_elements_3_0= ruleGroup ) )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:791:1: (lv_elements_3_0= ruleGroup )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:791:1: (lv_elements_3_0= ruleGroup )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:792:3: lv_elements_3_0= ruleGroup
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleUnorderedGroup1771);
                    	    lv_elements_3_0=ruleGroup();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getUnorderedGroupRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_3_0, 
                    	            		"Group");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


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
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleGroup"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:816:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:817:2: (iv_ruleGroup= ruleGroup EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:818:2: iv_ruleGroup= ruleGroup EOF
            {
             newCompositeNode(grammarAccess.getGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_entryRuleGroup1811);
            iv_ruleGroup=ruleGroup();

            state._fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroup1821); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:825:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:828:28: ( (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:829:1: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:829:1: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:830:5: this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup1868);
            this_AbstractToken_0=ruleAbstractToken();

            state._fsp--;

             
                    current = this_AbstractToken_0; 
                    afterParserOrEnumRuleCall();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:838:1: ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_STRING)||LA23_0==15||LA23_0==30) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:838:2: () ( (lv_elements_2_0= ruleAbstractToken ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:838:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:839:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getGroupAccess().getGroupElementsAction_1_0(),
                                current);
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:844:2: ( (lv_elements_2_0= ruleAbstractToken ) )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_STRING)||LA22_0==15||LA22_0==30) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:845:1: (lv_elements_2_0= ruleAbstractToken )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:845:1: (lv_elements_2_0= ruleAbstractToken )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:846:3: lv_elements_2_0= ruleAbstractToken
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup1898);
                    	    lv_elements_2_0=ruleAbstractToken();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getGroupRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_2_0, 
                    	            		"AbstractToken");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:870:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:871:2: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:872:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             newCompositeNode(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1937);
            iv_ruleAbstractToken=ruleAbstractToken();

            state._fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractToken1947); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:879:1: ruleAbstractToken returns [EObject current=null] : (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractTokenWithCardinality_0 = null;

        EObject this_Action_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:882:28: ( (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:883:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:883:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)||LA24_0==15) ) {
                alt24=1;
            }
            else if ( (LA24_0==30) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:884:5: this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken1994);
                    this_AbstractTokenWithCardinality_0=ruleAbstractTokenWithCardinality();

                    state._fsp--;

                     
                            current = this_AbstractTokenWithCardinality_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:894:5: this_Action_1= ruleAction
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleAbstractToken2021);
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:910:1: entryRuleAbstractTokenWithCardinality returns [EObject current=null] : iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF ;
    public final EObject entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTokenWithCardinality = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:911:2: (iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:912:2: iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF
            {
             newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality2056);
            iv_ruleAbstractTokenWithCardinality=ruleAbstractTokenWithCardinality();

            state._fsp--;

             current =iv_ruleAbstractTokenWithCardinality; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality2066); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:919:1: ruleAbstractTokenWithCardinality returns [EObject current=null] : ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) ;
    public final EObject ruleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;
        EObject this_Assignment_0 = null;

        EObject this_AbstractTerminal_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:922:28: ( ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:923:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:923:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:923:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:923:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==EOF||(LA25_1>=RULE_ID && LA25_1<=RULE_STRING)||(LA25_1>=15 && LA25_1<=16)||LA25_1==23||(LA25_1>=25 && LA25_1<=30)) ) {
                    alt25=2;
                }
                else if ( ((LA25_1>=31 && LA25_1<=32)||LA25_1==35) ) {
                    alt25=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA25_0==RULE_STRING||LA25_0==15) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:924:5: this_Assignment_0= ruleAssignment
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality2114);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;

                     
                            current = this_Assignment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:934:5: this_AbstractTerminal_1= ruleAbstractTerminal
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2141);
                    this_AbstractTerminal_1=ruleAbstractTerminal();

                    state._fsp--;

                     
                            current = this_AbstractTerminal_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:942:2: ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=27 && LA27_0<=29)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:943:1: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:943:1: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:944:1: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:944:1: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    int alt26=3;
                    switch ( input.LA(1) ) {
                    case 27:
                        {
                        alt26=1;
                        }
                        break;
                    case 28:
                        {
                        alt26=2;
                        }
                        break;
                    case 29:
                        {
                        alt26=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }

                    switch (alt26) {
                        case 1 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:945:3: lv_cardinality_2_1= '?'
                            {
                            lv_cardinality_2_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAbstractTokenWithCardinality2161); 

                                    newLeafNode(lv_cardinality_2_1, grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAbstractTokenWithCardinalityRule());
                            	        }
                                   		setWithLastConsumed(current, "cardinality", lv_cardinality_2_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:957:8: lv_cardinality_2_2= '*'
                            {
                            lv_cardinality_2_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAbstractTokenWithCardinality2190); 

                                    newLeafNode(lv_cardinality_2_2, grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAbstractTokenWithCardinalityRule());
                            	        }
                                   		setWithLastConsumed(current, "cardinality", lv_cardinality_2_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:969:8: lv_cardinality_2_3= '+'
                            {
                            lv_cardinality_2_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAbstractTokenWithCardinality2219); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:992:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:993:2: (iv_ruleAction= ruleAction EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:994:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction2272);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction2282); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1001:1: ruleAction returns [EObject current=null] : (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) ;
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
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1004:28: ( (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1005:1: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1005:1: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1005:3: otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleAction2319); 

                	newLeafNode(otherlv_0, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0());
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1009:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1010:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1010:1: (lv_type_1_0= ruleTypeRef )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1011:3: lv_type_1_0= ruleTypeRef
            {
             
            	        newCompositeNode(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleAction2340);
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1027:2: (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==17) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1027:4: otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current'
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAction2353); 

                        	newLeafNode(otherlv_2, grammarAccess.getActionAccess().getFullStopKeyword_2_0());
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1031:1: ( (lv_feature_3_0= RULE_ID ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1032:1: (lv_feature_3_0= RULE_ID )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1032:1: (lv_feature_3_0= RULE_ID )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1033:3: lv_feature_3_0= RULE_ID
                    {
                    lv_feature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAction2370); 

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

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1049:2: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1050:1: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1050:1: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1051:1: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1051:1: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==31) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==32) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1052:3: lv_operator_4_1= '='
                            {
                            lv_operator_4_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAction2395); 

                                    newLeafNode(lv_operator_4_1, grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getActionRule());
                            	        }
                                   		setWithLastConsumed(current, "operator", lv_operator_4_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1064:8: lv_operator_4_2= '+='
                            {
                            lv_operator_4_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAction2424); 

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

                    otherlv_5=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAction2452); 

                        	newLeafNode(otherlv_5, grammarAccess.getActionAccess().getCurrentKeyword_2_3());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAction2466); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1095:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1096:2: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1097:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             newCompositeNode(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2502);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();

            state._fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTerminal2512); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1104:1: ruleAbstractTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1107:28: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1108:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1108:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
            int alt30=3;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1109:5: this_Keyword_0= ruleKeyword
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAbstractTerminal2559);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;

                     
                            current = this_Keyword_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1119:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2586);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1129:5: this_ParenthesizedElement_2= ruleParenthesizedElement
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2613);
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1145:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1146:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1147:2: iv_ruleKeyword= ruleKeyword EOF
            {
             newCompositeNode(grammarAccess.getKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_entryRuleKeyword2648);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeyword2658); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1154:1: ruleKeyword returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1157:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1158:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1158:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1159:1: (lv_value_0_0= RULE_STRING )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1159:1: (lv_value_0_0= RULE_STRING )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1160:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleKeyword2699); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1184:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1185:2: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1186:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             newCompositeNode(grammarAccess.getRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_entryRuleRuleCall2739);
            iv_ruleRuleCall=ruleRuleCall();

            state._fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCall2749); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1193:1: ruleRuleCall returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1196:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1197:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1197:1: ( (otherlv_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1198:1: (otherlv_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1198:1: (otherlv_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1199:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCall2793); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1218:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1219:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1220:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment2828);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment2838); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1227:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        Token lv_operator_1_3=null;
        EObject lv_terminal_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1230:28: ( ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1231:1: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1231:1: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1231:2: ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1231:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1232:1: (lv_feature_0_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1232:1: (lv_feature_0_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1233:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignment2880); 

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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1249:2: ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1250:1: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1250:1: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1251:1: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1251:1: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt31=1;
                }
                break;
            case 31:
                {
                alt31=2;
                }
                break;
            case 35:
                {
                alt31=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1252:3: lv_operator_1_1= '+='
                    {
                    lv_operator_1_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAssignment2905); 

                            newLeafNode(lv_operator_1_1, grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssignmentRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1264:8: lv_operator_1_2= '='
                    {
                    lv_operator_1_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAssignment2934); 

                            newLeafNode(lv_operator_1_2, grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssignmentRule());
                    	        }
                           		setWithLastConsumed(current, "operator", lv_operator_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1276:8: lv_operator_1_3= '?='
                    {
                    lv_operator_1_3=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAssignment2963); 

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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1291:2: ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1292:1: (lv_terminal_2_0= ruleAssignableTerminal )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1292:1: (lv_terminal_2_0= ruleAssignableTerminal )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1293:3: lv_terminal_2_0= ruleAssignableTerminal
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignment3000);
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1317:1: entryRuleAssignableTerminal returns [EObject current=null] : iv_ruleAssignableTerminal= ruleAssignableTerminal EOF ;
    public final EObject entryRuleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableTerminal = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1318:2: (iv_ruleAssignableTerminal= ruleAssignableTerminal EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1319:2: iv_ruleAssignableTerminal= ruleAssignableTerminal EOF
            {
             newCompositeNode(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal3036);
            iv_ruleAssignableTerminal=ruleAssignableTerminal();

            state._fsp--;

             current =iv_ruleAssignableTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableTerminal3046); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1326:1: ruleAssignableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedAssignableElement_2 = null;

        EObject this_CrossReference_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1329:28: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1330:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1330:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            int alt32=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt32=1;
                }
                break;
            case RULE_ID:
                {
                alt32=2;
                }
                break;
            case 15:
                {
                alt32=3;
                }
                break;
            case 36:
                {
                alt32=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1331:5: this_Keyword_0= ruleKeyword
                    {
                     
                            newCompositeNode(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAssignableTerminal3093);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;

                     
                            current = this_Keyword_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1341:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            newCompositeNode(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAssignableTerminal3120);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1351:5: this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement
                    {
                     
                            newCompositeNode(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal3147);
                    this_ParenthesizedAssignableElement_2=ruleParenthesizedAssignableElement();

                    state._fsp--;

                     
                            current = this_ParenthesizedAssignableElement_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1361:5: this_CrossReference_3= ruleCrossReference
                    {
                     
                            newCompositeNode(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_ruleAssignableTerminal3174);
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1377:1: entryRuleParenthesizedAssignableElement returns [EObject current=null] : iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF ;
    public final EObject entryRuleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedAssignableElement = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1378:2: (iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1379:2: iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement3209);
            iv_ruleParenthesizedAssignableElement=ruleParenthesizedAssignableElement();

            state._fsp--;

             current =iv_ruleParenthesizedAssignableElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement3219); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1386:1: ruleParenthesizedAssignableElement returns [EObject current=null] : (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AssignableAlternatives_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1389:28: ( (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1390:1: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1390:1: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1390:3: otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedAssignableElement3256); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3278);
            this_AssignableAlternatives_1=ruleAssignableAlternatives();

            state._fsp--;

             
                    current = this_AssignableAlternatives_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedAssignableElement3289); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1415:1: entryRuleAssignableAlternatives returns [EObject current=null] : iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF ;
    public final EObject entryRuleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableAlternatives = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1416:2: (iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1417:2: iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF
            {
             newCompositeNode(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3325);
            iv_ruleAssignableAlternatives=ruleAssignableAlternatives();

            state._fsp--;

             current =iv_ruleAssignableAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableAlternatives3335); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1424:1: ruleAssignableAlternatives returns [EObject current=null] : (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final EObject ruleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AssignableTerminal_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1427:28: ( (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1428:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1428:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1429:5: this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3382);
            this_AssignableTerminal_0=ruleAssignableTerminal();

            state._fsp--;

             
                    current = this_AssignableTerminal_0; 
                    afterParserOrEnumRuleCall();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1437:1: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==25) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1437:2: () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1437:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1438:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0(),
                                current);
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1443:2: (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==25) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1443:4: otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAssignableAlternatives3404); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	        
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1447:1: ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1448:1: (lv_elements_3_0= ruleAssignableTerminal )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1448:1: (lv_elements_3_0= ruleAssignableTerminal )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1449:3: lv_elements_3_0= ruleAssignableTerminal
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3425);
                    	    lv_elements_3_0=ruleAssignableTerminal();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAssignableAlternativesRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_3_0, 
                    	            		"AssignableTerminal");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt33 >= 1 ) break loop33;
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1473:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1474:2: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1475:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             newCompositeNode(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_entryRuleCrossReference3465);
            iv_ruleCrossReference=ruleCrossReference();

            state._fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReference3475); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1482:1: ruleCrossReference returns [EObject current=null] : (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_terminal_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1485:28: ( (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1486:1: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1486:1: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1486:3: otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleCrossReference3512); 

                	newLeafNode(otherlv_0, grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0());
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1490:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1491:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1491:1: (lv_type_1_0= ruleTypeRef )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1492:3: lv_type_1_0= ruleTypeRef
            {
             
            	        newCompositeNode(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleCrossReference3533);
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1508:2: (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==25) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1508:4: otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleCrossReference3546); 

                        	newLeafNode(otherlv_2, grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0());
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1512:1: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1513:1: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1513:1: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1514:3: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {
                     
                    	        newCompositeNode(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3567);
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

            otherlv_4=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleCrossReference3581); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1542:1: entryRuleCrossReferenceableTerminal returns [EObject current=null] : iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF ;
    public final EObject entryRuleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableTerminal = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1543:2: (iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1544:2: iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF
            {
             newCompositeNode(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal3617);
            iv_ruleCrossReferenceableTerminal=ruleCrossReferenceableTerminal();

            state._fsp--;

             current =iv_ruleCrossReferenceableTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal3627); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1551:1: ruleCrossReferenceableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) ;
    public final EObject ruleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1554:28: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1555:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1555:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_STRING) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_ID) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:5: this_Keyword_0= ruleKeyword
                    {
                     
                            newCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3674);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;

                     
                            current = this_Keyword_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1566:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            newCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3701);
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1582:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1583:2: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1584:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement3736);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();

            state._fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedElement3746); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1591:1: ruleParenthesizedElement returns [EObject current=null] : (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Alternatives_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1594:28: ( (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1595:1: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1595:1: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1595:3: otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedElement3783); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParenthesizedElement3805);
            this_Alternatives_1=ruleAlternatives();

            state._fsp--;

             
                    current = this_Alternatives_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedElement3816); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1620:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1621:2: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1622:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             newCompositeNode(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule3852);
            iv_ruleTerminalRule=ruleTerminalRule();

            state._fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule3862); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1629:1: ruleTerminalRule returns [EObject current=null] : (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' ) ;
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
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1632:28: ( (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1633:1: (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1633:1: (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1633:3: otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleTerminalRule3899); 

                	newLeafNode(otherlv_0, grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0());
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1637:1: ( (lv_name_1_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1638:1: (lv_name_1_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1638:1: (lv_name_1_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1639:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTerminalRule3916); 

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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1655:2: (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==21) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1655:4: otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleTerminalRule3934); 

                        	newLeafNode(otherlv_2, grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0());
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1659:1: ( (lv_type_3_0= ruleTypeRef ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1660:1: (lv_type_3_0= ruleTypeRef )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1660:1: (lv_type_3_0= ruleTypeRef )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1661:3: lv_type_3_0= ruleTypeRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleTerminalRule3955);
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

            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTerminalRule3969); 

                	newLeafNode(otherlv_4, grammarAccess.getTerminalRuleAccess().getColonKeyword_3());
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1681:1: ( (lv_alternatives_5_0= ruleTerminalAlternatives ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1682:1: (lv_alternatives_5_0= ruleTerminalAlternatives )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1682:1: (lv_alternatives_5_0= ruleTerminalAlternatives )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1683:3: lv_alternatives_5_0= ruleTerminalAlternatives
            {
             
            	        newCompositeNode(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule3990);
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

            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTerminalRule4002); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1711:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1712:2: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1713:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             newCompositeNode(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives4038);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();

            state._fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalAlternatives4048); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1720:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_TerminalGroup_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1723:28: ( (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1724:1: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1724:1: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1725:5: this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4095);
            this_TerminalGroup_0=ruleTerminalGroup();

            state._fsp--;

             
                    current = this_TerminalGroup_0; 
                    afterParserOrEnumRuleCall();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1733:1: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==25) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1733:2: () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1733:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1734:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0(),
                                current);
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1739:2: (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    int cnt38=0;
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==25) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1739:4: otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTerminalAlternatives4117); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	        
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1743:1: ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1744:1: (lv_elements_3_0= ruleTerminalGroup )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1744:1: (lv_elements_3_0= ruleTerminalGroup )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1745:3: lv_elements_3_0= ruleTerminalGroup
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4138);
                    	    lv_elements_3_0=ruleTerminalGroup();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTerminalAlternativesRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_3_0, 
                    	            		"TerminalGroup");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


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
    // $ANTLR end "ruleTerminalAlternatives"


    // $ANTLR start "entryRuleTerminalGroup"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1769:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1770:2: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1771:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             newCompositeNode(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup4178);
            iv_ruleTerminalGroup=ruleTerminalGroup();

            state._fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalGroup4188); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1778:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1781:28: ( (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1782:1: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1782:1: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1783:5: this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4235);
            this_TerminalToken_0=ruleTerminalToken();

            state._fsp--;

             
                    current = this_TerminalToken_0; 
                    afterParserOrEnumRuleCall();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1791:1: ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_STRING)||LA41_0==15||LA41_0==17||(LA41_0>=39 && LA41_0<=40)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1791:2: () ( (lv_elements_2_0= ruleTerminalToken ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1791:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1792:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0(),
                                current);
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1797:2: ( (lv_elements_2_0= ruleTerminalToken ) )+
                    int cnt40=0;
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_STRING)||LA40_0==15||LA40_0==17||(LA40_0>=39 && LA40_0<=40)) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1798:1: (lv_elements_2_0= ruleTerminalToken )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1798:1: (lv_elements_2_0= ruleTerminalToken )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1799:3: lv_elements_2_0= ruleTerminalToken
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4265);
                    	    lv_elements_2_0=ruleTerminalToken();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTerminalGroupRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_2_0, 
                    	            		"TerminalToken");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt40 >= 1 ) break loop40;
                                EarlyExitException eee =
                                    new EarlyExitException(40, input);
                                throw eee;
                        }
                        cnt40++;
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1823:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1824:2: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1825:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             newCompositeNode(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken4304);
            iv_ruleTerminalToken=ruleTerminalToken();

            state._fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalToken4314); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1832:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_1_1=null;
        Token lv_cardinality_1_2=null;
        Token lv_cardinality_1_3=null;
        EObject this_TerminalTokenElement_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1835:28: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1836:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1836:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1837:5: this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4361);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();

            state._fsp--;

             
                    current = this_TerminalTokenElement_0; 
                    afterParserOrEnumRuleCall();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1845:1: ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=27 && LA43_0<=29)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1846:1: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1846:1: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1847:1: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1847:1: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    int alt42=3;
                    switch ( input.LA(1) ) {
                    case 27:
                        {
                        alt42=1;
                        }
                        break;
                    case 28:
                        {
                        alt42=2;
                        }
                        break;
                    case 29:
                        {
                        alt42=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 0, input);

                        throw nvae;
                    }

                    switch (alt42) {
                        case 1 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1848:3: lv_cardinality_1_1= '?'
                            {
                            lv_cardinality_1_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTerminalToken4380); 

                                    newLeafNode(lv_cardinality_1_1, grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTerminalTokenRule());
                            	        }
                                   		setWithLastConsumed(current, "cardinality", lv_cardinality_1_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1860:8: lv_cardinality_1_2= '*'
                            {
                            lv_cardinality_1_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTerminalToken4409); 

                                    newLeafNode(lv_cardinality_1_2, grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTerminalTokenRule());
                            	        }
                                   		setWithLastConsumed(current, "cardinality", lv_cardinality_1_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1872:8: lv_cardinality_1_3= '+'
                            {
                            lv_cardinality_1_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTerminalToken4438); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1895:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1896:2: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1897:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             newCompositeNode(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement4491);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();

            state._fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalTokenElement4501); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1904:1: ruleTerminalTokenElement returns [EObject current=null] : (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1907:28: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1908:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1908:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
            int alt44=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt44=1;
                }
                break;
            case RULE_ID:
                {
                alt44=2;
                }
                break;
            case 15:
                {
                alt44=3;
                }
                break;
            case 39:
            case 40:
                {
                alt44=4;
                }
                break;
            case 17:
                {
                alt44=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1909:5: this_CharacterRange_0= ruleCharacterRange
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4548);
                    this_CharacterRange_0=ruleCharacterRange();

                    state._fsp--;

                     
                            current = this_CharacterRange_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1919:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement4575);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1929:5: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement4602);
                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();

                    state._fsp--;

                     
                            current = this_ParenthesizedTerminalElement_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1939:5: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement4629);
                    this_AbstractNegatedToken_3=ruleAbstractNegatedToken();

                    state._fsp--;

                     
                            current = this_AbstractNegatedToken_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1949:5: this_Wildcard_4= ruleWildcard
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_ruleTerminalTokenElement4656);
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1965:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1966:2: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1967:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4691);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();

            state._fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4701); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1974:1: ruleParenthesizedTerminalElement returns [EObject current=null] : (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_TerminalAlternatives_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1977:28: ( (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1978:1: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1978:1: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1978:3: otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedTerminalElement4738); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4760);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();

            state._fsp--;

             
                    current = this_TerminalAlternatives_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedTerminalElement4771); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2003:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2004:2: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2005:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             newCompositeNode(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken4807);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();

            state._fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractNegatedToken4817); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2012:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UntilToken_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2015:28: ( (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2016:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2016:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==39) ) {
                alt45=1;
            }
            else if ( (LA45_0==40) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2017:5: this_NegatedToken_0= ruleNegatedToken
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4864);
                    this_NegatedToken_0=ruleNegatedToken();

                    state._fsp--;

                     
                            current = this_NegatedToken_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2027:5: this_UntilToken_1= ruleUntilToken
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken4891);
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2043:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2044:2: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2045:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             newCompositeNode(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4926);
            iv_ruleNegatedToken=ruleNegatedToken();

            state._fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegatedToken4936); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2052:1: ruleNegatedToken returns [EObject current=null] : (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_terminal_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2055:28: ( (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2056:1: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2056:1: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2056:3: otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleNegatedToken4973); 

                	newLeafNode(otherlv_0, grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0());
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2060:1: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2061:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2061:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2062:3: lv_terminal_1_0= ruleTerminalTokenElement
            {
             
            	        newCompositeNode(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4994);
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2086:1: entryRuleUntilToken returns [EObject current=null] : iv_ruleUntilToken= ruleUntilToken EOF ;
    public final EObject entryRuleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntilToken = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2087:2: (iv_ruleUntilToken= ruleUntilToken EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2088:2: iv_ruleUntilToken= ruleUntilToken EOF
            {
             newCompositeNode(grammarAccess.getUntilTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_entryRuleUntilToken5030);
            iv_ruleUntilToken=ruleUntilToken();

            state._fsp--;

             current =iv_ruleUntilToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUntilToken5040); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2095:1: ruleUntilToken returns [EObject current=null] : (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleUntilToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_terminal_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2098:28: ( (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2099:1: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2099:1: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2099:3: otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleUntilToken5077); 

                	newLeafNode(otherlv_0, grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0());
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2103:1: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2104:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2104:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2105:3: lv_terminal_1_0= ruleTerminalTokenElement
            {
             
            	        newCompositeNode(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken5098);
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2129:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2130:2: (iv_ruleWildcard= ruleWildcard EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2131:2: iv_ruleWildcard= ruleWildcard EOF
            {
             newCompositeNode(grammarAccess.getWildcardRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_entryRuleWildcard5134);
            iv_ruleWildcard=ruleWildcard();

            state._fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcard5144); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2138:1: ruleWildcard returns [EObject current=null] : ( () otherlv_1= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2141:28: ( ( () otherlv_1= '.' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2142:1: ( () otherlv_1= '.' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2142:1: ( () otherlv_1= '.' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2142:2: () otherlv_1= '.'
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2142:2: ()
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2143:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWildcardAccess().getWildcardAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleWildcard5190); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2160:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2161:2: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2162:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             newCompositeNode(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5226);
            iv_ruleCharacterRange=ruleCharacterRange();

            state._fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCharacterRange5236); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2169:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Keyword_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2172:28: ( (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2173:1: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2173:1: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2174:5: this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange5283);
            this_Keyword_0=ruleKeyword();

            state._fsp--;

             
                    current = this_Keyword_0; 
                    afterParserOrEnumRuleCall();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2182:1: ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==41) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2182:2: () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2182:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2183:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0(),
                                current);
                        

                    }

                    otherlv_2=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleCharacterRange5304); 

                        	newLeafNode(otherlv_2, grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1());
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2192:1: ( (lv_right_3_0= ruleKeyword ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2193:1: (lv_right_3_0= ruleKeyword )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2193:1: (lv_right_3_0= ruleKeyword )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2194:3: lv_right_3_0= ruleKeyword
                    {
                     
                    	        newCompositeNode(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange5325);
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2218:1: entryRuleEnumRule returns [EObject current=null] : iv_ruleEnumRule= ruleEnumRule EOF ;
    public final EObject entryRuleEnumRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumRule = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2219:2: (iv_ruleEnumRule= ruleEnumRule EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2220:2: iv_ruleEnumRule= ruleEnumRule EOF
            {
             newCompositeNode(grammarAccess.getEnumRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_entryRuleEnumRule5363);
            iv_ruleEnumRule=ruleEnumRule();

            state._fsp--;

             current =iv_ruleEnumRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumRule5373); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2227:1: ruleEnumRule returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) ;
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
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2230:28: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2231:1: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2231:1: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2231:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEnumRule5410); 

                	newLeafNode(otherlv_0, grammarAccess.getEnumRuleAccess().getEnumKeyword_0());
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2235:1: ( (lv_name_1_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2236:1: (lv_name_1_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2236:1: (lv_name_1_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2237:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumRule5427); 

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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2253:2: (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==21) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2253:4: otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEnumRule5445); 

                        	newLeafNode(otherlv_2, grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0());
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2257:1: ( (lv_type_3_0= ruleTypeRef ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2258:1: (lv_type_3_0= ruleTypeRef )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2258:1: (lv_type_3_0= ruleTypeRef )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2259:3: lv_type_3_0= ruleTypeRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleEnumRule5466);
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

            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleEnumRule5480); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumRuleAccess().getColonKeyword_3());
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2279:1: ( (lv_alternatives_5_0= ruleEnumLiterals ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2280:1: (lv_alternatives_5_0= ruleEnumLiterals )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2280:1: (lv_alternatives_5_0= ruleEnumLiterals )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2281:3: lv_alternatives_5_0= ruleEnumLiterals
            {
             
            	        newCompositeNode(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_ruleEnumRule5501);
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

            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleEnumRule5513); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2309:1: entryRuleEnumLiterals returns [EObject current=null] : iv_ruleEnumLiterals= ruleEnumLiterals EOF ;
    public final EObject entryRuleEnumLiterals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiterals = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2310:2: (iv_ruleEnumLiterals= ruleEnumLiterals EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2311:2: iv_ruleEnumLiterals= ruleEnumLiterals EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals5549);
            iv_ruleEnumLiterals=ruleEnumLiterals();

            state._fsp--;

             current =iv_ruleEnumLiterals; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiterals5559); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2318:1: ruleEnumLiterals returns [EObject current=null] : (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final EObject ruleEnumLiterals() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_EnumLiteralDeclaration_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2321:28: ( (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2322:1: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2322:1: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2323:5: this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5606);
            this_EnumLiteralDeclaration_0=ruleEnumLiteralDeclaration();

            state._fsp--;

             
                    current = this_EnumLiteralDeclaration_0; 
                    afterParserOrEnumRuleCall();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2331:1: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==25) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2331:2: () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2331:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2332:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0(),
                                current);
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2337:2: (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    int cnt48=0;
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==25) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2337:4: otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleEnumLiterals5628); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0());
                    	        
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2341:1: ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2342:1: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2342:1: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2343:3: lv_elements_3_0= ruleEnumLiteralDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5649);
                    	    lv_elements_3_0=ruleEnumLiteralDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEnumLiteralsRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_3_0, 
                    	            		"EnumLiteralDeclaration");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt48 >= 1 ) break loop48;
                                EarlyExitException eee =
                                    new EarlyExitException(48, input);
                                throw eee;
                        }
                        cnt48++;
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2367:1: entryRuleEnumLiteralDeclaration returns [EObject current=null] : iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF ;
    public final EObject entryRuleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralDeclaration = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2368:2: (iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2369:2: iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration5689);
            iv_ruleEnumLiteralDeclaration=ruleEnumLiteralDeclaration();

            state._fsp--;

             current =iv_ruleEnumLiteralDeclaration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration5699); 

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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2376:1: ruleEnumLiteralDeclaration returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_literal_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2379:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2380:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2380:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2380:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2380:2: ( (otherlv_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2381:1: (otherlv_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2381:1: (otherlv_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2382:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumLiteralDeclarationRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration5744); 

            		newLeafNode(otherlv_0, grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            	

            }


            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2393:2: (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==31) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2393:4: otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleEnumLiteralDeclaration5757); 

                        	newLeafNode(otherlv_1, grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0());
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2397:1: ( (lv_literal_2_0= ruleKeyword ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2398:1: (lv_literal_2_0= ruleKeyword )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2398:1: (lv_literal_2_0= ruleKeyword )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2399:3: lv_literal_2_0= ruleKeyword
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration5778);
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
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar143 = new BitSet(new long[]{0x0000044000145010L});
        public static final BitSet FOLLOW_12_in_ruleGrammar156 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar179 = new BitSet(new long[]{0x0000044000147010L});
        public static final BitSet FOLLOW_13_in_ruleGrammar192 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar215 = new BitSet(new long[]{0x0000044000147010L});
        public static final BitSet FOLLOW_14_in_ruleGrammar238 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleGrammar263 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar284 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleGrammar297 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar317 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleGrammar333 = new BitSet(new long[]{0x0000044000145010L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar356 = new BitSet(new long[]{0x0000044000145010L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar378 = new BitSet(new long[]{0x0000044000145012L});
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
        public static final BitSet FOLLOW_22_in_ruleParserRule1336 = new BitSet(new long[]{0x0000000040008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1357 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleParserRule1369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1405 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1461 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleTypeRef1473 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives1531 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives1541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_ruleAlternatives1588 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleAlternatives1610 = new BitSet(new long[]{0x0000000040008030L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_ruleAlternatives1631 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleUnorderedGroup_in_entryRuleUnorderedGroup1671 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnorderedGroup1681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_ruleUnorderedGroup1728 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleUnorderedGroup1750 = new BitSet(new long[]{0x0000000040008030L});
        public static final BitSet FOLLOW_ruleGroup_in_ruleUnorderedGroup1771 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup1811 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroup1821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1868 = new BitSet(new long[]{0x0000000040008032L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1898 = new BitSet(new long[]{0x0000000040008032L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1937 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken1947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken1994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality2056 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality2066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality2114 = new BitSet(new long[]{0x0000000038000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2141 = new BitSet(new long[]{0x0000000038000002L});
        public static final BitSet FOLLOW_27_in_ruleAbstractTokenWithCardinality2161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleAbstractTokenWithCardinality2190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleAbstractTokenWithCardinality2219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction2272 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction2282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleAction2319 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction2340 = new BitSet(new long[]{0x0000000400020000L});
        public static final BitSet FOLLOW_17_in_ruleAction2353 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAction2370 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_ruleAction2395 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_32_in_ruleAction2424 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleAction2452 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAction2466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2502 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal2512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal2559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword2648 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeyword2658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword2699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall2739 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall2749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall2793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment2828 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment2838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment2880 = new BitSet(new long[]{0x0000000980000000L});
        public static final BitSet FOLLOW_32_in_ruleAssignment2905 = new BitSet(new long[]{0x0000001000008030L});
        public static final BitSet FOLLOW_31_in_ruleAssignment2934 = new BitSet(new long[]{0x0000001000008030L});
        public static final BitSet FOLLOW_35_in_ruleAssignment2963 = new BitSet(new long[]{0x0000001000008030L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignment3000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal3036 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal3046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleAssignableTerminal3093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleAssignableTerminal3120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal3147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_ruleAssignableTerminal3174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement3209 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement3219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedAssignableElement3256 = new BitSet(new long[]{0x0000001000008030L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3278 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedAssignableElement3289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3325 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives3335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3382 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleAssignableAlternatives3404 = new BitSet(new long[]{0x0000001000008030L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3425 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference3465 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference3475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleCrossReference3512 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference3533 = new BitSet(new long[]{0x0000002002000000L});
        public static final BitSet FOLLOW_25_in_ruleCrossReference3546 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3567 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleCrossReference3581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal3617 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal3627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement3736 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement3746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedElement3783 = new BitSet(new long[]{0x0000000040008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement3805 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedElement3816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule3852 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule3862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleTerminalRule3899 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule3916 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_21_in_ruleTerminalRule3934 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule3955 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleTerminalRule3969 = new BitSet(new long[]{0x0000018000028030L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule3990 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleTerminalRule4002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives4038 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives4048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4095 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleTerminalAlternatives4117 = new BitSet(new long[]{0x0000018000028030L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4138 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup4178 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup4188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4235 = new BitSet(new long[]{0x0000018000028032L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4265 = new BitSet(new long[]{0x0000018000028032L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken4304 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken4314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4361 = new BitSet(new long[]{0x0000000038000002L});
        public static final BitSet FOLLOW_27_in_ruleTerminalToken4380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleTerminalToken4409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleTerminalToken4438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement4491 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement4501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement4575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement4602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement4629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement4656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4691 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement4738 = new BitSet(new long[]{0x0000018000028030L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4760 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedTerminalElement4771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken4807 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken4817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken4891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4926 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken4936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleNegatedToken4973 = new BitSet(new long[]{0x0000018000028030L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken5030 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken5040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleUntilToken5077 = new BitSet(new long[]{0x0000018000028030L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken5098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard5134 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcard5144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleWildcard5190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5226 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange5236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5283 = new BitSet(new long[]{0x0000020000000002L});
        public static final BitSet FOLLOW_41_in_ruleCharacterRange5304 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule5363 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule5373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEnumRule5410 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumRule5427 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_21_in_ruleEnumRule5445 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleEnumRule5466 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleEnumRule5480 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_ruleEnumRule5501 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleEnumRule5513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals5549 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals5559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5606 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleEnumLiterals5628 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5649 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration5689 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration5699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration5744 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_31_in_ruleEnumLiteralDeclaration5757 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration5778 = new BitSet(new long[]{0x0000000000000002L});
    }


}