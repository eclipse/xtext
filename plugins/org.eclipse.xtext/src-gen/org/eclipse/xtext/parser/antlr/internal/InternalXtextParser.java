package org.eclipse.xtext.parser.antlr.internal; 

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
            this.factory = factory;
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:71:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:72:2: (iv_ruleGrammar= ruleGrammar EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:73:2: iv_ruleGrammar= ruleGrammar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGrammarRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:80:1: ruleGrammar returns [EObject current=null] : (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) ;
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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:85:6: ( (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:86:1: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:86:1: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:86:3: otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleGrammar122); 

                	createLeafNode(otherlv_0, grammarAccess.getGrammarAccess().getGrammarKeyword_0(), null);
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:90:1: ( (lv_name_1_0= ruleGrammarID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:91:1: (lv_name_1_0= ruleGrammarID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:91:1: (lv_name_1_0= ruleGrammarID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:92:3: lv_name_1_0= ruleGrammarID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar143);
            lv_name_1_0=ruleGrammarID();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"GrammarID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:114:2: (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:114:4: otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleGrammar156); 

                        	createLeafNode(otherlv_2, grammarAccess.getGrammarAccess().getWithKeyword_2_0(), null);
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:118:1: ( ( ruleGrammarID ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:119:1: ( ruleGrammarID )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:119:1: ( ruleGrammarID )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:120:3: ruleGrammarID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar179);
                    ruleGrammarID();

                    state._fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:134:2: (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:134:4: otherlv_4= ',' ( ( ruleGrammarID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar192); 

                    	        	createLeafNode(otherlv_4, grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0(), null);
                    	        
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:138:1: ( ( ruleGrammarID ) )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:139:1: ( ruleGrammarID )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:139:1: ( ruleGrammarID )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:140:3: ruleGrammarID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar215);
                    	    ruleGrammarID();

                    	    state._fsp--;

                    	     
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:154:6: ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:154:7: ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= ')'
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:154:7: ( (lv_definesHiddenTokens_6_0= 'hidden' ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:155:1: (lv_definesHiddenTokens_6_0= 'hidden' )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:155:1: (lv_definesHiddenTokens_6_0= 'hidden' )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:156:3: lv_definesHiddenTokens_6_0= 'hidden'
                    {
                    lv_definesHiddenTokens_6_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleGrammar238); 

                            createLeafNode(lv_definesHiddenTokens_6_0, grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0(), "definesHiddenTokens");
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "definesHiddenTokens", true, "hidden", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleGrammar263); 

                        	createLeafNode(otherlv_7, grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1(), null);
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:179:1: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:179:2: ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                            {
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:179:2: ( (otherlv_8= RULE_ID ) )
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:180:1: (otherlv_8= RULE_ID )
                            {
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:180:1: (otherlv_8= RULE_ID )
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:181:3: otherlv_8= RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammar284); 

                            		createLeafNode(otherlv_8, grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0(), "hiddenTokens"); 
                            	

                            }


                            }

                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:193:2: (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:193:4: otherlv_9= ',' ( (otherlv_10= RULE_ID ) )
                            	    {
                            	    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar297); 

                            	        	createLeafNode(otherlv_9, grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0(), null);
                            	        
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:197:1: ( (otherlv_10= RULE_ID ) )
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:198:1: (otherlv_10= RULE_ID )
                            	    {
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:198:1: (otherlv_10= RULE_ID )
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:199:3: otherlv_10= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    otherlv_10=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammar317); 

                            	    		createLeafNode(otherlv_10, grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0(), "hiddenTokens"); 
                            	    	

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

                        	createLeafNode(otherlv_11, grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3(), null);
                        

                    }
                    break;

            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:215:3: ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:216:1: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:216:1: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:217:3: lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar356);
            	    lv_metamodelDeclarations_12_0=ruleAbstractMetamodelDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"metamodelDeclarations",
            	    	        		lv_metamodelDeclarations_12_0, 
            	    	        		"AbstractMetamodelDeclaration", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:239:3: ( (lv_rules_13_0= ruleAbstractRule ) )+
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
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:240:1: (lv_rules_13_0= ruleAbstractRule )
            	    {
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:240:1: (lv_rules_13_0= ruleAbstractRule )
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:241:3: lv_rules_13_0= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_ruleGrammar378);
            	    lv_rules_13_0=ruleAbstractRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"rules",
            	    	        		lv_rules_13_0, 
            	    	        		"AbstractRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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
    // $ANTLR end "ruleGrammar"


    // $ANTLR start "entryRuleGrammarID"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:271:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:272:2: (iv_ruleGrammarID= ruleGrammarID EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:273:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGrammarIDRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:280:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:285:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:286:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:286:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:286:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammarID467); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(this_ID_0, grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:293:1: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:294:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGrammarID486); 

            	            current.merge(kw);
            	            createLeafNode(kw, grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammarID501); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(this_ID_2, grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "ruleGrammarID"


    // $ANTLR start "entryRuleAbstractRule"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:314:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:315:2: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:316:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRuleRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:323:1: ruleAbstractRule returns [EObject current=null] : (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRule_0 = null;

        EObject this_TerminalRule_1 = null;

        EObject this_EnumRule_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:328:6: ( (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:329:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:329:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:330:5: this_ParserRule_0= ruleParserRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_ruleAbstractRule605);
                    this_ParserRule_0=ruleParserRule();

                    state._fsp--;

                     
                            current = this_ParserRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:340:5: this_TerminalRule_1= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_ruleAbstractRule632);
                    this_TerminalRule_1=ruleTerminalRule();

                    state._fsp--;

                     
                            current = this_TerminalRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:350:5: this_EnumRule_2= ruleEnumRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_ruleAbstractRule659);
                    this_EnumRule_2=ruleEnumRule();

                    state._fsp--;

                     
                            current = this_EnumRule_2; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleAbstractMetamodelDeclaration"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:366:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:367:2: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:368:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:375:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:380:6: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:381:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:381:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:382:5: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration751);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();

                    state._fsp--;

                     
                            current = this_GeneratedMetamodel_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:392:5: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration778);
                    this_ReferencedMetamodel_1=ruleReferencedMetamodel();

                    state._fsp--;

                     
                            current = this_ReferencedMetamodel_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end "ruleAbstractMetamodelDeclaration"


    // $ANTLR start "entryRuleGeneratedMetamodel"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:408:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:409:2: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:410:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGeneratedMetamodelRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:417:1: ruleGeneratedMetamodel returns [EObject current=null] : (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:422:6: ( (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:423:1: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:423:1: (otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:423:3: otherlv_0= 'generate' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleGeneratedMetamodel860); 

                	createLeafNode(otherlv_0, grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0(), null);
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:427:1: ( (lv_name_1_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:428:1: (lv_name_1_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:428:1: (lv_name_1_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:429:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGeneratedMetamodel877); 

            			createLeafNode(lv_name_1_0, grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getGeneratedMetamodelRule().getType().getClassifier());
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:451:2: ( (otherlv_2= RULE_STRING ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:452:1: (otherlv_2= RULE_STRING )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:452:1: (otherlv_2= RULE_STRING )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:453:3: otherlv_2= RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getGeneratedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel902); 

            		createLeafNode(otherlv_2, grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0(), "ePackage"); 
            	

            }


            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:465:2: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:465:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleGeneratedMetamodel915); 

                        	createLeafNode(otherlv_3, grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0(), null);
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:469:1: ( (lv_alias_4_0= RULE_ID ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:470:1: (lv_alias_4_0= RULE_ID )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:470:1: (lv_alias_4_0= RULE_ID )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:471:3: lv_alias_4_0= RULE_ID
                    {
                    lv_alias_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGeneratedMetamodel932); 

                    			createLeafNode(lv_alias_4_0, grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0(), "alias"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getGeneratedMetamodelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"alias",
                    	        		lv_alias_4_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // $ANTLR end "ruleGeneratedMetamodel"


    // $ANTLR start "entryRuleReferencedMetamodel"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:501:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:502:2: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:503:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferencedMetamodelRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:510:1: ruleReferencedMetamodel returns [EObject current=null] : (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:515:6: ( (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:516:1: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:516:1: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:516:3: otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReferencedMetamodel1022); 

                	createLeafNode(otherlv_0, grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0(), null);
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:520:1: ( (otherlv_1= RULE_STRING ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:521:1: (otherlv_1= RULE_STRING )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:521:1: (otherlv_1= RULE_STRING )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:522:3: otherlv_1= RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferencedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_1=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1042); 

            		createLeafNode(otherlv_1, grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0(), "ePackage"); 
            	

            }


            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:534:2: (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:534:4: otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReferencedMetamodel1055); 

                        	createLeafNode(otherlv_2, grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0(), null);
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:538:1: ( (lv_alias_3_0= RULE_ID ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:539:1: (lv_alias_3_0= RULE_ID )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:539:1: (lv_alias_3_0= RULE_ID )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:540:3: lv_alias_3_0= RULE_ID
                    {
                    lv_alias_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferencedMetamodel1072); 

                    			createLeafNode(lv_alias_3_0, grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0(), "alias"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReferencedMetamodelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"alias",
                    	        		lv_alias_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // $ANTLR end "ruleReferencedMetamodel"


    // $ANTLR start "entryRuleParserRule"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:570:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:571:2: (iv_ruleParserRule= ruleParserRule EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:572:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParserRuleRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:579:1: ruleParserRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' ) ;
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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:584:6: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:585:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:585:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:585:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )? otherlv_9= ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) otherlv_11= ';'
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:585:2: ( (lv_name_0_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:586:1: (lv_name_0_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:586:1: (lv_name_0_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:587:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1167); 

            			createLeafNode(lv_name_0_0, grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:609:2: (otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:609:4: otherlv_1= 'returns' ( (lv_type_2_0= ruleTypeRef ) )
                    {
                    otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParserRule1185); 

                        	createLeafNode(otherlv_1, grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0(), null);
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:613:1: ( (lv_type_2_0= ruleTypeRef ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:614:1: (lv_type_2_0= ruleTypeRef )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:614:1: (lv_type_2_0= ruleTypeRef )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:615:3: lv_type_2_0= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleParserRule1206);
                    lv_type_2_0=ruleTypeRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_2_0, 
                    	        		"TypeRef", 
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:637:4: ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:637:5: ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) otherlv_4= '(' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= ')'
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:637:5: ( (lv_definesHiddenTokens_3_0= 'hidden' ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:638:1: (lv_definesHiddenTokens_3_0= 'hidden' )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:638:1: (lv_definesHiddenTokens_3_0= 'hidden' )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:639:3: lv_definesHiddenTokens_3_0= 'hidden'
                    {
                    lv_definesHiddenTokens_3_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParserRule1227); 

                            createLeafNode(lv_definesHiddenTokens_3_0, grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0(), "definesHiddenTokens");
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "definesHiddenTokens", true, "hidden", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParserRule1252); 

                        	createLeafNode(otherlv_4, grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1(), null);
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:662:1: ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:662:2: ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                            {
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:662:2: ( (otherlv_5= RULE_ID ) )
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:663:1: (otherlv_5= RULE_ID )
                            {
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:663:1: (otherlv_5= RULE_ID )
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:664:3: otherlv_5= RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1273); 

                            		createLeafNode(otherlv_5, grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0(), "hiddenTokens"); 
                            	

                            }


                            }

                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:676:2: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==13) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:676:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                            	    {
                            	    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParserRule1286); 

                            	        	createLeafNode(otherlv_6, grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0(), null);
                            	        
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:1: ( (otherlv_7= RULE_ID ) )
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:681:1: (otherlv_7= RULE_ID )
                            	    {
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:681:1: (otherlv_7= RULE_ID )
                            	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:682:3: otherlv_7= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1306); 

                            	    		createLeafNode(otherlv_7, grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0(), "hiddenTokens"); 
                            	    	

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

                        	createLeafNode(otherlv_8, grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3(), null);
                        

                    }
                    break;

            }

            otherlv_9=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParserRule1336); 

                	createLeafNode(otherlv_9, grammarAccess.getParserRuleAccess().getColonKeyword_3(), null);
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:702:1: ( (lv_alternatives_10_0= ruleAlternatives ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:703:1: (lv_alternatives_10_0= ruleAlternatives )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:703:1: (lv_alternatives_10_0= ruleAlternatives )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:704:3: lv_alternatives_10_0= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParserRule1357);
            lv_alternatives_10_0=ruleAlternatives();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"alternatives",
            	        		lv_alternatives_10_0, 
            	        		"Alternatives", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            otherlv_11=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleParserRule1369); 

                	createLeafNode(otherlv_11, grammarAccess.getParserRuleAccess().getSemicolonKeyword_5(), null);
                

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
    // $ANTLR end "ruleParserRule"


    // $ANTLR start "entryRuleTypeRef"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:738:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:739:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:740:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRefRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:747:1: ruleTypeRef returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:752:6: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:753:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:753:1: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:753:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:753:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:753:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:753:3: ( (otherlv_0= RULE_ID ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:754:1: (otherlv_0= RULE_ID )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:754:1: (otherlv_0= RULE_ID )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:755:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeRef1461); 

                    		createLeafNode(otherlv_0, grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0(), "metamodel"); 
                    	

                    }


                    }

                    otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTypeRef1473); 

                        	createLeafNode(otherlv_1, grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1(), null);
                        

                    }
                    break;

            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:771:3: ( (otherlv_2= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:772:1: (otherlv_2= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:772:1: (otherlv_2= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:773:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeRef1495); 

            		createLeafNode(otherlv_2, grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0(), "classifier"); 
            	

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
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleAlternatives"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:793:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:794:2: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:795:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAlternativesRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:802:1: ruleAlternatives returns [EObject current=null] : (this_UnorderedGroup_0= ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_UnorderedGroup_0 = null;

        EObject lv_elements_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:807:6: ( (this_UnorderedGroup_0= ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:808:1: (this_UnorderedGroup_0= ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:808:1: (this_UnorderedGroup_0= ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:809:5: this_UnorderedGroup_0= ruleUnorderedGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getUnorderedGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_ruleAlternatives1588);
            this_UnorderedGroup_0=ruleUnorderedGroup();

            state._fsp--;

             
                    current = this_UnorderedGroup_0; 
                    currentNode = currentNode.getParent();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:817:1: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:817:2: () (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:817:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:818:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "elements", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:833:2: (otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) ) )+
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
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:833:4: otherlv_2= '|' ( (lv_elements_3_0= ruleUnorderedGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAlternatives1610); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0(), null);
                    	        
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:837:1: ( (lv_elements_3_0= ruleUnorderedGroup ) )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:838:1: (lv_elements_3_0= ruleUnorderedGroup )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:838:1: (lv_elements_3_0= ruleUnorderedGroup )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:839:3: lv_elements_3_0= ruleUnorderedGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getElementsUnorderedGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleUnorderedGroup_in_ruleAlternatives1631);
                    	    lv_elements_3_0=ruleUnorderedGroup();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAlternativesRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"elements",
                    	    	        		lv_elements_3_0, 
                    	    	        		"UnorderedGroup", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // $ANTLR end "ruleAlternatives"


    // $ANTLR start "entryRuleUnorderedGroup"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:869:1: entryRuleUnorderedGroup returns [EObject current=null] : iv_ruleUnorderedGroup= ruleUnorderedGroup EOF ;
    public final EObject entryRuleUnorderedGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedGroup = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:870:2: (iv_ruleUnorderedGroup= ruleUnorderedGroup EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:871:2: iv_ruleUnorderedGroup= ruleUnorderedGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnorderedGroupRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:878:1: ruleUnorderedGroup returns [EObject current=null] : (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) ;
    public final EObject ruleUnorderedGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Group_0 = null;

        EObject lv_elements_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:883:6: ( (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:884:1: (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:884:1: (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:885:5: this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleUnorderedGroup1728);
            this_Group_0=ruleGroup();

            state._fsp--;

             
                    current = this_Group_0; 
                    currentNode = currentNode.getParent();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:893:1: ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==26) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:893:2: () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:893:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:894:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "elements", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:909:2: (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
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
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:909:4: otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleUnorderedGroup1750); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0(), null);
                    	        
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:913:1: ( (lv_elements_3_0= ruleGroup ) )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:914:1: (lv_elements_3_0= ruleGroup )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:914:1: (lv_elements_3_0= ruleGroup )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:915:3: lv_elements_3_0= ruleGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleUnorderedGroup1771);
                    	    lv_elements_3_0=ruleGroup();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getUnorderedGroupRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"elements",
                    	    	        		lv_elements_3_0, 
                    	    	        		"Group", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleGroup"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:945:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:946:2: (iv_ruleGroup= ruleGroup EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:947:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:954:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_elements_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:959:6: ( (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:960:1: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:960:1: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:961:5: this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup1868);
            this_AbstractToken_0=ruleAbstractToken();

            state._fsp--;

             
                    current = this_AbstractToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:969:1: ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_STRING)||LA23_0==15||LA23_0==30) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:969:2: () ( (lv_elements_2_0= ruleAbstractToken ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:969:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:970:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getGroupAccess().getGroupElementsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "elements", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getGroupAccess().getGroupElementsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:985:2: ( (lv_elements_2_0= ruleAbstractToken ) )+
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
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:986:1: (lv_elements_2_0= ruleAbstractToken )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:986:1: (lv_elements_2_0= ruleAbstractToken )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:987:3: lv_elements_2_0= ruleAbstractToken
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup1898);
                    	    lv_elements_2_0=ruleAbstractToken();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getGroupRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"elements",
                    	    	        		lv_elements_2_0, 
                    	    	        		"AbstractToken", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAbstractToken"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1017:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1018:2: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1019:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTokenRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1026:1: ruleAbstractToken returns [EObject current=null] : (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractTokenWithCardinality_0 = null;

        EObject this_Action_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1031:6: ( (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1032:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1032:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1033:5: this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken1994);
                    this_AbstractTokenWithCardinality_0=ruleAbstractTokenWithCardinality();

                    state._fsp--;

                     
                            current = this_AbstractTokenWithCardinality_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1043:5: this_Action_1= ruleAction
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleAbstractToken2021);
                    this_Action_1=ruleAction();

                    state._fsp--;

                     
                            current = this_Action_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end "ruleAbstractToken"


    // $ANTLR start "entryRuleAbstractTokenWithCardinality"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1059:1: entryRuleAbstractTokenWithCardinality returns [EObject current=null] : iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF ;
    public final EObject entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTokenWithCardinality = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1060:2: (iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1061:2: iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1068:1: ruleAbstractTokenWithCardinality returns [EObject current=null] : ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) ;
    public final EObject ruleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;
        EObject this_Assignment_0 = null;

        EObject this_AbstractTerminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1073:6: ( ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1074:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1074:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1074:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1074:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1075:5: this_Assignment_0= ruleAssignment
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality2114);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;

                     
                            current = this_Assignment_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1085:5: this_AbstractTerminal_1= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2141);
                    this_AbstractTerminal_1=ruleAbstractTerminal();

                    state._fsp--;

                     
                            current = this_AbstractTerminal_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1093:2: ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=27 && LA27_0<=29)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1094:1: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1094:1: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1095:1: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1095:1: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
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
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1096:3: lv_cardinality_2_1= '?'
                            {
                            lv_cardinality_2_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAbstractTokenWithCardinality2161); 

                                    createLeafNode(lv_cardinality_2_1, grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0(), "cardinality");
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getAbstractTokenWithCardinalityRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "cardinality", lv_cardinality_2_1, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 2 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1114:8: lv_cardinality_2_2= '*'
                            {
                            lv_cardinality_2_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAbstractTokenWithCardinality2190); 

                                    createLeafNode(lv_cardinality_2_2, grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1(), "cardinality");
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getAbstractTokenWithCardinalityRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "cardinality", lv_cardinality_2_2, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 3 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1132:8: lv_cardinality_2_3= '+'
                            {
                            lv_cardinality_2_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAbstractTokenWithCardinality2219); 

                                    createLeafNode(lv_cardinality_2_3, grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2(), "cardinality");
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getAbstractTokenWithCardinalityRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "cardinality", lv_cardinality_2_3, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

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
    // $ANTLR end "ruleAbstractTokenWithCardinality"


    // $ANTLR start "entryRuleAction"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1161:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1162:2: (iv_ruleAction= ruleAction EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1163:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1170:1: ruleAction returns [EObject current=null] : (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) ;
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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1175:6: ( (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1176:1: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1176:1: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1176:3: otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleAction2319); 

                	createLeafNode(otherlv_0, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0(), null);
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1180:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1181:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1181:1: (lv_type_1_0= ruleTypeRef )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1182:3: lv_type_1_0= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleAction2340);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_1_0, 
            	        		"TypeRef", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1204:2: (otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==17) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1204:4: otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current'
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAction2353); 

                        	createLeafNode(otherlv_2, grammarAccess.getActionAccess().getFullStopKeyword_2_0(), null);
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1208:1: ( (lv_feature_3_0= RULE_ID ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1209:1: (lv_feature_3_0= RULE_ID )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1209:1: (lv_feature_3_0= RULE_ID )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1210:3: lv_feature_3_0= RULE_ID
                    {
                    lv_feature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAction2370); 

                    			createLeafNode(lv_feature_3_0, grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0(), "feature"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"feature",
                    	        		lv_feature_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1232:2: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1233:1: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1233:1: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1234:1: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1234:1: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
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
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1235:3: lv_operator_4_1= '='
                            {
                            lv_operator_4_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAction2395); 

                                    createLeafNode(lv_operator_4_1, grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0(), "operator");
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "operator", lv_operator_4_1, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 2 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1253:8: lv_operator_4_2= '+='
                            {
                            lv_operator_4_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAction2424); 

                                    createLeafNode(lv_operator_4_2, grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1(), "operator");
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "operator", lv_operator_4_2, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }


                    }

                    otherlv_5=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAction2452); 

                        	createLeafNode(otherlv_5, grammarAccess.getActionAccess().getCurrentKeyword_2_3(), null);
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAction2466); 

                	createLeafNode(otherlv_6, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3(), null);
                

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
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleAbstractTerminal"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1290:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1291:2: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1292:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTerminalRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1299:1: ruleAbstractTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1304:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1305:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1305:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1306:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAbstractTerminal2559);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1316:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2586);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1326:5: this_ParenthesizedElement_2= ruleParenthesizedElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2613);
                    this_ParenthesizedElement_2=ruleParenthesizedElement();

                    state._fsp--;

                     
                            current = this_ParenthesizedElement_2; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end "ruleAbstractTerminal"


    // $ANTLR start "entryRuleKeyword"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1342:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1343:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1344:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeywordRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1351:1: ruleKeyword returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1356:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1357:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1357:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1358:1: (lv_value_0_0= RULE_STRING )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1358:1: (lv_value_0_0= RULE_STRING )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1359:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleKeyword2699); 

            			createLeafNode(lv_value_0_0, grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getKeywordRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleRuleCall"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1389:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1390:2: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1391:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1398:1: ruleRuleCall returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1403:6: ( ( (otherlv_0= RULE_ID ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1404:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1404:1: ( (otherlv_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1405:1: (otherlv_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1405:1: (otherlv_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1406:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRuleCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCall2793); 

            		createLeafNode(otherlv_0, grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0(), "rule"); 
            	

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
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1426:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1427:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1428:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignmentRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1435:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        Token lv_operator_1_3=null;
        EObject lv_terminal_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1440:6: ( ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1441:1: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1441:1: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1441:2: ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1441:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1442:1: (lv_feature_0_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1442:1: (lv_feature_0_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1443:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignment2880); 

            			createLeafNode(lv_feature_0_0, grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0(), "feature"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"feature",
            	        		lv_feature_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1465:2: ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1466:1: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1466:1: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1467:1: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1467:1: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1468:3: lv_operator_1_1= '+='
                    {
                    lv_operator_1_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAssignment2905); 

                            createLeafNode(lv_operator_1_1, grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0(), "operator");
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "operator", lv_operator_1_1, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1486:8: lv_operator_1_2= '='
                    {
                    lv_operator_1_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAssignment2934); 

                            createLeafNode(lv_operator_1_2, grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1(), "operator");
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "operator", lv_operator_1_2, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1504:8: lv_operator_1_3= '?='
                    {
                    lv_operator_1_3=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAssignment2963); 

                            createLeafNode(lv_operator_1_3, grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2(), "operator");
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "operator", lv_operator_1_3, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }


            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1525:2: ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1526:1: (lv_terminal_2_0= ruleAssignableTerminal )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1526:1: (lv_terminal_2_0= ruleAssignableTerminal )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:3: lv_terminal_2_0= ruleAssignableTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignment3000);
            lv_terminal_2_0=ruleAssignableTerminal();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"terminal",
            	        		lv_terminal_2_0, 
            	        		"AssignableTerminal", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleAssignableTerminal"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1557:1: entryRuleAssignableTerminal returns [EObject current=null] : iv_ruleAssignableTerminal= ruleAssignableTerminal EOF ;
    public final EObject entryRuleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableTerminal = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1558:2: (iv_ruleAssignableTerminal= ruleAssignableTerminal EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1559:2: iv_ruleAssignableTerminal= ruleAssignableTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignableTerminalRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1566:1: ruleAssignableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedAssignableElement_2 = null;

        EObject this_CrossReference_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1571:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1572:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1572:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1573:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAssignableTerminal3093);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1583:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAssignableTerminal3120);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1593:5: this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal3147);
                    this_ParenthesizedAssignableElement_2=ruleParenthesizedAssignableElement();

                    state._fsp--;

                     
                            current = this_ParenthesizedAssignableElement_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1603:5: this_CrossReference_3= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_ruleAssignableTerminal3174);
                    this_CrossReference_3=ruleCrossReference();

                    state._fsp--;

                     
                            current = this_CrossReference_3; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end "ruleAssignableTerminal"


    // $ANTLR start "entryRuleParenthesizedAssignableElement"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1619:1: entryRuleParenthesizedAssignableElement returns [EObject current=null] : iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF ;
    public final EObject entryRuleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedAssignableElement = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1620:2: (iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1621:2: iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedAssignableElementRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1628:1: ruleParenthesizedAssignableElement returns [EObject current=null] : (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AssignableAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1633:6: ( (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1634:1: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1634:1: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1634:3: otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedAssignableElement3256); 

                	createLeafNode(otherlv_0, grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3278);
            this_AssignableAlternatives_1=ruleAssignableAlternatives();

            state._fsp--;

             
                    current = this_AssignableAlternatives_1; 
                    currentNode = currentNode.getParent();
                
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedAssignableElement3289); 

                	createLeafNode(otherlv_2, grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2(), null);
                

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
    // $ANTLR end "ruleParenthesizedAssignableElement"


    // $ANTLR start "entryRuleAssignableAlternatives"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1659:1: entryRuleAssignableAlternatives returns [EObject current=null] : iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF ;
    public final EObject entryRuleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableAlternatives = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1660:2: (iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1661:2: iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignableAlternativesRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1668:1: ruleAssignableAlternatives returns [EObject current=null] : (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final EObject ruleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AssignableTerminal_0 = null;

        EObject lv_elements_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1673:6: ( (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1674:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1674:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1675:5: this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3382);
            this_AssignableTerminal_0=ruleAssignableTerminal();

            state._fsp--;

             
                    current = this_AssignableTerminal_0; 
                    currentNode = currentNode.getParent();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1683:1: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==25) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1683:2: () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1683:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1684:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "elements", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1699:2: (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
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
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1699:4: otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAssignableAlternatives3404); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0(), null);
                    	        
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1703:1: ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1704:1: (lv_elements_3_0= ruleAssignableTerminal )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1704:1: (lv_elements_3_0= ruleAssignableTerminal )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1705:3: lv_elements_3_0= ruleAssignableTerminal
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3425);
                    	    lv_elements_3_0=ruleAssignableTerminal();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAssignableAlternativesRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"elements",
                    	    	        		lv_elements_3_0, 
                    	    	        		"AssignableTerminal", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // $ANTLR end "ruleAssignableAlternatives"


    // $ANTLR start "entryRuleCrossReference"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1735:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1736:2: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1737:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1744:1: ruleCrossReference returns [EObject current=null] : (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_terminal_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1749:6: ( (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1750:1: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1750:1: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1750:3: otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleCrossReference3512); 

                	createLeafNode(otherlv_0, grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0(), null);
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1754:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1755:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1755:1: (lv_type_1_0= ruleTypeRef )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1756:3: lv_type_1_0= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleCrossReference3533);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCrossReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_1_0, 
            	        		"TypeRef", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1778:2: (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==25) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1778:4: otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleCrossReference3546); 

                        	createLeafNode(otherlv_2, grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0(), null);
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1782:1: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1783:1: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1783:1: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1784:3: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3567);
                    lv_terminal_3_0=ruleCrossReferenceableTerminal();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCrossReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"terminal",
                    	        		lv_terminal_3_0, 
                    	        		"CrossReferenceableTerminal", 
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

            otherlv_4=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleCrossReference3581); 

                	createLeafNode(otherlv_4, grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3(), null);
                

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
    // $ANTLR end "ruleCrossReference"


    // $ANTLR start "entryRuleCrossReferenceableTerminal"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1818:1: entryRuleCrossReferenceableTerminal returns [EObject current=null] : iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF ;
    public final EObject entryRuleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableTerminal = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1819:2: (iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1820:2: iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceableTerminalRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1827:1: ruleCrossReferenceableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) ;
    public final EObject ruleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1832:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1833:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1833:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1834:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3674);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1844:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3701);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end "ruleCrossReferenceableTerminal"


    // $ANTLR start "entryRuleParenthesizedElement"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1860:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1861:2: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1862:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedElementRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1869:1: ruleParenthesizedElement returns [EObject current=null] : (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Alternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1874:6: ( (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1875:1: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1875:1: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1875:3: otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedElement3783); 

                	createLeafNode(otherlv_0, grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParenthesizedElement3805);
            this_Alternatives_1=ruleAlternatives();

            state._fsp--;

             
                    current = this_Alternatives_1; 
                    currentNode = currentNode.getParent();
                
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedElement3816); 

                	createLeafNode(otherlv_2, grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2(), null);
                

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
    // $ANTLR end "ruleParenthesizedElement"


    // $ANTLR start "entryRuleTerminalRule"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1900:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1901:2: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1902:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalRuleRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1909:1: ruleTerminalRule returns [EObject current=null] : (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        EObject lv_alternatives_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1914:6: ( (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1915:1: (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1915:1: (otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1915:3: otherlv_0= 'terminal' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleTerminalRule3899); 

                	createLeafNode(otherlv_0, grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0(), null);
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1919:1: ( (lv_name_1_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1920:1: (lv_name_1_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1920:1: (lv_name_1_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1921:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTerminalRule3916); 

            			createLeafNode(lv_name_1_0, grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTerminalRuleRule().getType().getClassifier());
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1943:2: (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==21) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1943:4: otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleTerminalRule3934); 

                        	createLeafNode(otherlv_2, grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0(), null);
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1947:1: ( (lv_type_3_0= ruleTypeRef ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1948:1: (lv_type_3_0= ruleTypeRef )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1948:1: (lv_type_3_0= ruleTypeRef )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1949:3: lv_type_3_0= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleTerminalRule3955);
                    lv_type_3_0=ruleTypeRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTerminalRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_3_0, 
                    	        		"TypeRef", 
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

            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTerminalRule3969); 

                	createLeafNode(otherlv_4, grammarAccess.getTerminalRuleAccess().getColonKeyword_3(), null);
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1975:1: ( (lv_alternatives_5_0= ruleTerminalAlternatives ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1976:1: (lv_alternatives_5_0= ruleTerminalAlternatives )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1976:1: (lv_alternatives_5_0= ruleTerminalAlternatives )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1977:3: lv_alternatives_5_0= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule3990);
            lv_alternatives_5_0=ruleTerminalAlternatives();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTerminalRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"alternatives",
            	        		lv_alternatives_5_0, 
            	        		"TerminalAlternatives", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTerminalRule4002); 

                	createLeafNode(otherlv_6, grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5(), null);
                

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
    // $ANTLR end "ruleTerminalRule"


    // $ANTLR start "entryRuleTerminalAlternatives"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2011:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2012:2: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2013:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalAlternativesRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2020:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_TerminalGroup_0 = null;

        EObject lv_elements_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2025:6: ( (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2026:1: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2026:1: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2027:5: this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4095);
            this_TerminalGroup_0=ruleTerminalGroup();

            state._fsp--;

             
                    current = this_TerminalGroup_0; 
                    currentNode = currentNode.getParent();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2035:1: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==25) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2035:2: () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2035:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2036:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "elements", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2051:2: (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
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
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2051:4: otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTerminalAlternatives4117); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0(), null);
                    	        
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2055:1: ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2056:1: (lv_elements_3_0= ruleTerminalGroup )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2056:1: (lv_elements_3_0= ruleTerminalGroup )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2057:3: lv_elements_3_0= ruleTerminalGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4138);
                    	    lv_elements_3_0=ruleTerminalGroup();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getTerminalAlternativesRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"elements",
                    	    	        		lv_elements_3_0, 
                    	    	        		"TerminalGroup", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // $ANTLR end "ruleTerminalAlternatives"


    // $ANTLR start "entryRuleTerminalGroup"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2087:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2088:2: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2089:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalGroupRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2096:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_elements_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2101:6: ( (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2102:1: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2102:1: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2103:5: this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4235);
            this_TerminalToken_0=ruleTerminalToken();

            state._fsp--;

             
                    current = this_TerminalToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2111:1: ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_STRING)||LA41_0==15||LA41_0==17||(LA41_0>=39 && LA41_0<=40)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2111:2: () ( (lv_elements_2_0= ruleTerminalToken ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2111:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2112:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "elements", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2127:2: ( (lv_elements_2_0= ruleTerminalToken ) )+
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
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2128:1: (lv_elements_2_0= ruleTerminalToken )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2128:1: (lv_elements_2_0= ruleTerminalToken )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2129:3: lv_elements_2_0= ruleTerminalToken
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4265);
                    	    lv_elements_2_0=ruleTerminalToken();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getTerminalGroupRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"elements",
                    	    	        		lv_elements_2_0, 
                    	    	        		"TerminalToken", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // $ANTLR end "ruleTerminalGroup"


    // $ANTLR start "entryRuleTerminalToken"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2159:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2160:2: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2161:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalTokenRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2168:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_1_1=null;
        Token lv_cardinality_1_2=null;
        Token lv_cardinality_1_3=null;
        EObject this_TerminalTokenElement_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2173:6: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2174:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2174:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2175:5: this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4361);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();

            state._fsp--;

             
                    current = this_TerminalTokenElement_0; 
                    currentNode = currentNode.getParent();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2183:1: ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=27 && LA43_0<=29)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2184:1: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2184:1: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2185:1: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2185:1: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
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
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2186:3: lv_cardinality_1_1= '?'
                            {
                            lv_cardinality_1_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTerminalToken4380); 

                                    createLeafNode(lv_cardinality_1_1, grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0(), "cardinality");
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getTerminalTokenRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "cardinality", lv_cardinality_1_1, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 2 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2204:8: lv_cardinality_1_2= '*'
                            {
                            lv_cardinality_1_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTerminalToken4409); 

                                    createLeafNode(lv_cardinality_1_2, grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1(), "cardinality");
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getTerminalTokenRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "cardinality", lv_cardinality_1_2, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 3 :
                            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2222:8: lv_cardinality_1_3= '+'
                            {
                            lv_cardinality_1_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTerminalToken4438); 

                                    createLeafNode(lv_cardinality_1_3, grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2(), "cardinality");
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getTerminalTokenRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "cardinality", lv_cardinality_1_3, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

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
    // $ANTLR end "ruleTerminalToken"


    // $ANTLR start "entryRuleTerminalTokenElement"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2251:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2252:2: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2253:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalTokenElementRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2260:1: ruleTerminalTokenElement returns [EObject current=null] : (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2265:6: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2266:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2266:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2267:5: this_CharacterRange_0= ruleCharacterRange
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4548);
                    this_CharacterRange_0=ruleCharacterRange();

                    state._fsp--;

                     
                            current = this_CharacterRange_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2277:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement4575);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2287:5: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement4602);
                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();

                    state._fsp--;

                     
                            current = this_ParenthesizedTerminalElement_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2297:5: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement4629);
                    this_AbstractNegatedToken_3=ruleAbstractNegatedToken();

                    state._fsp--;

                     
                            current = this_AbstractNegatedToken_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2307:5: this_Wildcard_4= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_ruleTerminalTokenElement4656);
                    this_Wildcard_4=ruleWildcard();

                    state._fsp--;

                     
                            current = this_Wildcard_4; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end "ruleTerminalTokenElement"


    // $ANTLR start "entryRuleParenthesizedTerminalElement"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2323:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2324:2: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2325:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedTerminalElementRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2332:1: ruleParenthesizedTerminalElement returns [EObject current=null] : (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_TerminalAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2337:6: ( (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2338:1: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2338:1: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2338:3: otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedTerminalElement4738); 

                	createLeafNode(otherlv_0, grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4760);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();

            state._fsp--;

             
                    current = this_TerminalAlternatives_1; 
                    currentNode = currentNode.getParent();
                
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedTerminalElement4771); 

                	createLeafNode(otherlv_2, grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2(), null);
                

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
    // $ANTLR end "ruleParenthesizedTerminalElement"


    // $ANTLR start "entryRuleAbstractNegatedToken"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2363:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2364:2: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2365:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractNegatedTokenRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2372:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UntilToken_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2377:6: ( (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2378:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2378:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
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
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2379:5: this_NegatedToken_0= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4864);
                    this_NegatedToken_0=ruleNegatedToken();

                    state._fsp--;

                     
                            current = this_NegatedToken_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2389:5: this_UntilToken_1= ruleUntilToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken4891);
                    this_UntilToken_1=ruleUntilToken();

                    state._fsp--;

                     
                            current = this_UntilToken_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end "ruleAbstractNegatedToken"


    // $ANTLR start "entryRuleNegatedToken"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2405:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2406:2: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2407:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNegatedTokenRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2414:1: ruleNegatedToken returns [EObject current=null] : (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_terminal_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2419:6: ( (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2420:1: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2420:1: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2420:3: otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleNegatedToken4973); 

                	createLeafNode(otherlv_0, grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0(), null);
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2424:1: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2425:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2425:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2426:3: lv_terminal_1_0= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4994);
            lv_terminal_1_0=ruleTerminalTokenElement();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNegatedTokenRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"terminal",
            	        		lv_terminal_1_0, 
            	        		"TerminalTokenElement", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end "ruleNegatedToken"


    // $ANTLR start "entryRuleUntilToken"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2456:1: entryRuleUntilToken returns [EObject current=null] : iv_ruleUntilToken= ruleUntilToken EOF ;
    public final EObject entryRuleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntilToken = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2457:2: (iv_ruleUntilToken= ruleUntilToken EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2458:2: iv_ruleUntilToken= ruleUntilToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUntilTokenRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2465:1: ruleUntilToken returns [EObject current=null] : (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleUntilToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_terminal_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2470:6: ( (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2471:1: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2471:1: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2471:3: otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleUntilToken5077); 

                	createLeafNode(otherlv_0, grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0(), null);
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2475:1: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2476:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2476:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2477:3: lv_terminal_1_0= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken5098);
            lv_terminal_1_0=ruleTerminalTokenElement();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUntilTokenRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"terminal",
            	        		lv_terminal_1_0, 
            	        		"TerminalTokenElement", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end "ruleUntilToken"


    // $ANTLR start "entryRuleWildcard"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2507:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2508:2: (iv_ruleWildcard= ruleWildcard EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2509:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWildcardRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2516:1: ruleWildcard returns [EObject current=null] : ( () otherlv_1= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2521:6: ( ( () otherlv_1= '.' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2522:1: ( () otherlv_1= '.' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2522:1: ( () otherlv_1= '.' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2522:2: () otherlv_1= '.'
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2522:2: ()
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2523:5: 
            {
             
                    temp=factory.create(grammarAccess.getWildcardAccess().getWildcardAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getWildcardAccess().getWildcardAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleWildcard5190); 

                	createLeafNode(otherlv_1, grammarAccess.getWildcardAccess().getFullStopKeyword_1(), null);
                

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
    // $ANTLR end "ruleWildcard"


    // $ANTLR start "entryRuleCharacterRange"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2545:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2546:2: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2547:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCharacterRangeRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2554:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Keyword_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2559:6: ( (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2560:1: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2560:1: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2561:5: this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange5283);
            this_Keyword_0=ruleKeyword();

            state._fsp--;

             
                    current = this_Keyword_0; 
                    currentNode = currentNode.getParent();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2569:1: ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==41) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2569:2: () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2569:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2570:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    otherlv_2=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleCharacterRange5304); 

                        	createLeafNode(otherlv_2, grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1(), null);
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2589:1: ( (lv_right_3_0= ruleKeyword ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2590:1: (lv_right_3_0= ruleKeyword )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2590:1: (lv_right_3_0= ruleKeyword )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2591:3: lv_right_3_0= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange5325);
                    lv_right_3_0=ruleKeyword();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCharacterRangeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"right",
                    	        		lv_right_3_0, 
                    	        		"Keyword", 
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
    // $ANTLR end "ruleCharacterRange"


    // $ANTLR start "entryRuleEnumRule"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2621:1: entryRuleEnumRule returns [EObject current=null] : iv_ruleEnumRule= ruleEnumRule EOF ;
    public final EObject entryRuleEnumRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumRule = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2622:2: (iv_ruleEnumRule= ruleEnumRule EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2623:2: iv_ruleEnumRule= ruleEnumRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumRuleRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2630:1: ruleEnumRule returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) ;
    public final EObject ruleEnumRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        EObject lv_alternatives_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2635:6: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2636:1: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2636:1: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';' )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2636:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? otherlv_4= ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEnumRule5410); 

                	createLeafNode(otherlv_0, grammarAccess.getEnumRuleAccess().getEnumKeyword_0(), null);
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2640:1: ( (lv_name_1_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2641:1: (lv_name_1_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2641:1: (lv_name_1_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2642:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumRule5427); 

            			createLeafNode(lv_name_1_0, grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumRuleRule().getType().getClassifier());
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

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2664:2: (otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==21) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2664:4: otherlv_2= 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEnumRule5445); 

                        	createLeafNode(otherlv_2, grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0(), null);
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2668:1: ( (lv_type_3_0= ruleTypeRef ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2669:1: (lv_type_3_0= ruleTypeRef )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2669:1: (lv_type_3_0= ruleTypeRef )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2670:3: lv_type_3_0= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleEnumRule5466);
                    lv_type_3_0=ruleTypeRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEnumRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_3_0, 
                    	        		"TypeRef", 
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

            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleEnumRule5480); 

                	createLeafNode(otherlv_4, grammarAccess.getEnumRuleAccess().getColonKeyword_3(), null);
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2696:1: ( (lv_alternatives_5_0= ruleEnumLiterals ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2697:1: (lv_alternatives_5_0= ruleEnumLiterals )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2697:1: (lv_alternatives_5_0= ruleEnumLiterals )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2698:3: lv_alternatives_5_0= ruleEnumLiterals
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_ruleEnumRule5501);
            lv_alternatives_5_0=ruleEnumLiterals();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"alternatives",
            	        		lv_alternatives_5_0, 
            	        		"EnumLiterals", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleEnumRule5513); 

                	createLeafNode(otherlv_6, grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5(), null);
                

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
    // $ANTLR end "ruleEnumRule"


    // $ANTLR start "entryRuleEnumLiterals"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2732:1: entryRuleEnumLiterals returns [EObject current=null] : iv_ruleEnumLiterals= ruleEnumLiterals EOF ;
    public final EObject entryRuleEnumLiterals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiterals = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2733:2: (iv_ruleEnumLiterals= ruleEnumLiterals EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2734:2: iv_ruleEnumLiterals= ruleEnumLiterals EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumLiteralsRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2741:1: ruleEnumLiterals returns [EObject current=null] : (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final EObject ruleEnumLiterals() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_EnumLiteralDeclaration_0 = null;

        EObject lv_elements_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2746:6: ( (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2747:1: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2747:1: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2748:5: this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5606);
            this_EnumLiteralDeclaration_0=ruleEnumLiteralDeclaration();

            state._fsp--;

             
                    current = this_EnumLiteralDeclaration_0; 
                    currentNode = currentNode.getParent();
                
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2756:1: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==25) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2756:2: () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2756:2: ()
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2757:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "elements", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2772:2: (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
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
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2772:4: otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleEnumLiterals5628); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0(), null);
                    	        
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2776:1: ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2777:1: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2777:1: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2778:3: lv_elements_3_0= ruleEnumLiteralDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5649);
                    	    lv_elements_3_0=ruleEnumLiteralDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEnumLiteralsRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"elements",
                    	    	        		lv_elements_3_0, 
                    	    	        		"EnumLiteralDeclaration", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // $ANTLR end "ruleEnumLiterals"


    // $ANTLR start "entryRuleEnumLiteralDeclaration"
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2808:1: entryRuleEnumLiteralDeclaration returns [EObject current=null] : iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF ;
    public final EObject entryRuleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralDeclaration = null;


        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2809:2: (iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2810:2: iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumLiteralDeclarationRule(), currentNode); 
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
    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2817:1: ruleEnumLiteralDeclaration returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_literal_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2822:6: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2823:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2823:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2823:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2823:2: ( (otherlv_0= RULE_ID ) )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2824:1: (otherlv_0= RULE_ID )
            {
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2824:1: (otherlv_0= RULE_ID )
            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2825:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getEnumLiteralDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration5744); 

            		createLeafNode(otherlv_0, grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0(), "enumLiteral"); 
            	

            }


            }

            // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2837:2: (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==31) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2837:4: otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleEnumLiteralDeclaration5757); 

                        	createLeafNode(otherlv_1, grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0(), null);
                        
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2841:1: ( (lv_literal_2_0= ruleKeyword ) )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2842:1: (lv_literal_2_0= ruleKeyword )
                    {
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2842:1: (lv_literal_2_0= ruleKeyword )
                    // ../../plugins/org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2843:3: lv_literal_2_0= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration5778);
                    lv_literal_2_0=ruleKeyword();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEnumLiteralDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"literal",
                    	        		lv_literal_2_0, 
                    	        		"Keyword", 
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