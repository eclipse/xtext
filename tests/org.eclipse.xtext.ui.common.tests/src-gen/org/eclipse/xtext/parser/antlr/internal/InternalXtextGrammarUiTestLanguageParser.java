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
import org.eclipse.xtext.services.XtextGrammarUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextGrammarUiTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'with'", "','", "'hidden'", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "'returns'", "':'", "';'", "'::'", "'|'", "'?'", "'*'", "'+'", "'{'", "'='", "'+='", "'current'", "'}'", "'?='", "'['", "']'", "'terminal'", "'!'", "'->'", "'..'", "'enum'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalXtextGrammarUiTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g"; }



     	private XtextGrammarUiTestLanguageGrammarAccess grammarAccess;
     	
        public InternalXtextGrammarUiTestLanguageParser(TokenStream input, IAstFactory factory, XtextGrammarUiTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Grammar";	
       	} 



    // $ANTLR start entryRuleGrammar
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:72:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:73:2: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:74:2: iv_ruleGrammar= ruleGrammar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGrammarRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammar_in_entryRuleGrammar75);
            iv_ruleGrammar=ruleGrammar();
            _fsp--;

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
    // $ANTLR end entryRuleGrammar


    // $ANTLR start ruleGrammar
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:81:1: ruleGrammar returns [EObject current=null] : ( 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) ( 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_definesHiddenTokens_6_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_metamodelDeclarations_12_0 = null;

        EObject lv_rules_13_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:86:6: ( ( 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) ( 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:87:1: ( 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) ( 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:87:1: ( 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) ( 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:87:3: 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) ( 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleGrammar120); 

                    createLeafNode(grammarAccess.getGrammarAccess().getGrammarKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:91:1: ( (lv_name_1_0= ruleGrammarID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:92:1: (lv_name_1_0= ruleGrammarID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:92:1: (lv_name_1_0= ruleGrammarID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:93:3: lv_name_1_0= ruleGrammarID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar141);
            lv_name_1_0=ruleGrammarID();
            _fsp--;


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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:115:2: ( 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:115:4: 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )*
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleGrammar152); 

                            createLeafNode(grammarAccess.getGrammarAccess().getWithKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:119:1: ( ( ruleGrammarID ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:120:1: ( ruleGrammarID )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:120:1: ( ruleGrammarID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:121:3: ruleGrammarID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar175);
                    ruleGrammarID();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:135:2: ( ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:135:4: ',' ( ( ruleGrammarID ) )
                    	    {
                    	    match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar186); 

                    	            createLeafNode(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:139:1: ( ( ruleGrammarID ) )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:140:1: ( ruleGrammarID )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:140:1: ( ruleGrammarID )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:141:3: ruleGrammarID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_ruleGrammar209);
                    	    ruleGrammarID();
                    	    _fsp--;

                    	     
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:155:6: ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:155:7: ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')'
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:155:7: ( (lv_definesHiddenTokens_6_0= 'hidden' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:156:1: (lv_definesHiddenTokens_6_0= 'hidden' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:156:1: (lv_definesHiddenTokens_6_0= 'hidden' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:157:3: lv_definesHiddenTokens_6_0= 'hidden'
                    {
                    lv_definesHiddenTokens_6_0=(Token)input.LT(1);
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleGrammar232); 

                            createLeafNode(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0(), "definesHiddenTokens"); 
                        

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

                    match(input,15,FollowSets000.FOLLOW_15_in_ruleGrammar255); 

                            createLeafNode(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:180:1: ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:180:2: ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )*
                            {
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:180:2: ( ( RULE_ID ) )
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:181:1: ( RULE_ID )
                            {
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:181:1: ( RULE_ID )
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:182:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammar274); 

                            		createLeafNode(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0(), "hiddenTokens"); 
                            	

                            }


                            }

                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:194:2: ( ',' ( ( RULE_ID ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:194:4: ',' ( ( RULE_ID ) )
                            	    {
                            	    match(input,13,FollowSets000.FOLLOW_13_in_ruleGrammar285); 

                            	            createLeafNode(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0(), null); 
                            	        
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:198:1: ( ( RULE_ID ) )
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:199:1: ( RULE_ID )
                            	    {
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:199:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:200:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammar303); 

                            	    		createLeafNode(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0(), "hiddenTokens"); 
                            	    	

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

                    match(input,16,FollowSets000.FOLLOW_16_in_ruleGrammar317); 

                            createLeafNode(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:216:3: ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:217:1: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:217:1: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:218:3: lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar340);
            	    lv_metamodelDeclarations_12_0=ruleAbstractMetamodelDeclaration();
            	    _fsp--;


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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:240:3: ( (lv_rules_13_0= ruleAbstractRule ) )+
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
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:241:1: (lv_rules_13_0= ruleAbstractRule )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:241:1: (lv_rules_13_0= ruleAbstractRule )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:242:3: lv_rules_13_0= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_ruleGrammar362);
            	    lv_rules_13_0=ruleAbstractRule();
            	    _fsp--;


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
    // $ANTLR end ruleGrammar


    // $ANTLR start entryRuleGrammarID
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:272:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:273:2: (iv_ruleGrammarID= ruleGrammarID EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:274:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGrammarIDRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammarID_in_entryRuleGrammarID400);
            iv_ruleGrammarID=ruleGrammarID();
            _fsp--;

             current =iv_ruleGrammarID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammarID411); 

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
    // $ANTLR end entryRuleGrammarID


    // $ANTLR start ruleGrammarID
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:281:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:286:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:287:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:287:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:287:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammarID451); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:294:1: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:295:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,17,FollowSets000.FOLLOW_17_in_ruleGrammarID470); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGrammarID485); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

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
    // $ANTLR end ruleGrammarID


    // $ANTLR start entryRuleAbstractRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:315:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:316:2: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:317:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule532);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRule542); 

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
    // $ANTLR end entryRuleAbstractRule


    // $ANTLR start ruleAbstractRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:324:1: ruleAbstractRule returns [EObject current=null] : (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRule_0 = null;

        EObject this_TerminalRule_1 = null;

        EObject this_EnumRule_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:329:6: ( (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:330:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:330:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
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
                    new NoViableAltException("330:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:331:5: this_ParserRule_0= ruleParserRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_ruleAbstractRule589);
                    this_ParserRule_0=ruleParserRule();
                    _fsp--;

                     
                            current = this_ParserRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:341:5: this_TerminalRule_1= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_ruleAbstractRule616);
                    this_TerminalRule_1=ruleTerminalRule();
                    _fsp--;

                     
                            current = this_TerminalRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:351:5: this_EnumRule_2= ruleEnumRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_ruleAbstractRule643);
                    this_EnumRule_2=ruleEnumRule();
                    _fsp--;

                     
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
    // $ANTLR end ruleAbstractRule


    // $ANTLR start entryRuleAbstractMetamodelDeclaration
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:367:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:368:2: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:369:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration678);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();
            _fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration688); 

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
    // $ANTLR end entryRuleAbstractMetamodelDeclaration


    // $ANTLR start ruleAbstractMetamodelDeclaration
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:376:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:381:6: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:382:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:382:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
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
                    new NoViableAltException("382:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:383:5: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration735);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:393:5: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration762);
                    this_ReferencedMetamodel_1=ruleReferencedMetamodel();
                    _fsp--;

                     
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
    // $ANTLR end ruleAbstractMetamodelDeclaration


    // $ANTLR start entryRuleGeneratedMetamodel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:409:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:410:2: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:411:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGeneratedMetamodelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel797);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();
            _fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGeneratedMetamodel807); 

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
    // $ANTLR end entryRuleGeneratedMetamodel


    // $ANTLR start ruleGeneratedMetamodel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:418:1: ruleGeneratedMetamodel returns [EObject current=null] : ( 'generate' ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_alias_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:423:6: ( ( 'generate' ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:424:1: ( 'generate' ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:424:1: ( 'generate' ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:424:3: 'generate' ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleGeneratedMetamodel842); 

                    createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:428:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:429:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:429:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:430:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGeneratedMetamodel859); 

            			createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:452:2: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:453:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:453:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:454:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getGeneratedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel882); 

            		createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0(), "ePackage"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:466:2: ( 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:466:4: 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleGeneratedMetamodel893); 

                            createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:470:1: ( (lv_alias_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:471:1: (lv_alias_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:471:1: (lv_alias_4_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:472:3: lv_alias_4_0= RULE_ID
                    {
                    lv_alias_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGeneratedMetamodel910); 

                    			createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0(), "alias"); 
                    		

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
    // $ANTLR end ruleGeneratedMetamodel


    // $ANTLR start entryRuleReferencedMetamodel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:502:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:503:2: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:504:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferencedMetamodelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel953);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferencedMetamodel963); 

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
    // $ANTLR end entryRuleReferencedMetamodel


    // $ANTLR start ruleReferencedMetamodel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:511:1: ruleReferencedMetamodel returns [EObject current=null] : ( 'import' ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:516:6: ( ( 'import' ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:517:1: ( 'import' ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:517:1: ( 'import' ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:517:3: 'import' ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {
            match(input,20,FollowSets000.FOLLOW_20_in_ruleReferencedMetamodel998); 

                    createLeafNode(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:521:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:522:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:522:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:523:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferencedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1016); 

            		createLeafNode(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0(), "ePackage"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:535:2: ( 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:535:4: 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleReferencedMetamodel1027); 

                            createLeafNode(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:539:1: ( (lv_alias_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:540:1: (lv_alias_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:540:1: (lv_alias_3_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:541:3: lv_alias_3_0= RULE_ID
                    {
                    lv_alias_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferencedMetamodel1044); 

                    			createLeafNode(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0(), "alias"); 
                    		

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
    // $ANTLR end ruleReferencedMetamodel


    // $ANTLR start entryRuleParserRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:571:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:572:2: (iv_ruleParserRule= ruleParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:573:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParserRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParserRule_in_entryRuleParserRule1087);
            iv_ruleParserRule=ruleParserRule();
            _fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParserRule1097); 

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
    // $ANTLR end entryRuleParserRule


    // $ANTLR start ruleParserRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:580:1: ruleParserRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_definesHiddenTokens_3_0=null;
        EObject lv_type_2_0 = null;

        EObject lv_alternatives_10_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:585:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:586:1: ( ( (lv_name_0_0= RULE_ID ) ) ( 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:586:1: ( ( (lv_name_0_0= RULE_ID ) ) ( 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:586:2: ( (lv_name_0_0= RULE_ID ) ) ( 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:586:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:587:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:587:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:588:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1139); 

            			createLeafNode(grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:610:2: ( 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:610:4: 'returns' ( (lv_type_2_0= ruleTypeRef ) )
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleParserRule1155); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:614:1: ( (lv_type_2_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:615:1: (lv_type_2_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:615:1: (lv_type_2_0= ruleTypeRef )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:616:3: lv_type_2_0= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleParserRule1176);
                    lv_type_2_0=ruleTypeRef();
                    _fsp--;


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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:638:4: ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:638:5: ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')'
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:638:5: ( (lv_definesHiddenTokens_3_0= 'hidden' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:639:1: (lv_definesHiddenTokens_3_0= 'hidden' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:639:1: (lv_definesHiddenTokens_3_0= 'hidden' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:640:3: lv_definesHiddenTokens_3_0= 'hidden'
                    {
                    lv_definesHiddenTokens_3_0=(Token)input.LT(1);
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleParserRule1197); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0(), "definesHiddenTokens"); 
                        

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

                    match(input,15,FollowSets000.FOLLOW_15_in_ruleParserRule1220); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:663:1: ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:663:2: ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )*
                            {
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:663:2: ( ( RULE_ID ) )
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:664:1: ( RULE_ID )
                            {
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:664:1: ( RULE_ID )
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:665:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1239); 

                            		createLeafNode(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0(), "hiddenTokens"); 
                            	

                            }


                            }

                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:677:2: ( ',' ( ( RULE_ID ) ) )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==13) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:677:4: ',' ( ( RULE_ID ) )
                            	    {
                            	    match(input,13,FollowSets000.FOLLOW_13_in_ruleParserRule1250); 

                            	            createLeafNode(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0(), null); 
                            	        
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:681:1: ( ( RULE_ID ) )
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:682:1: ( RULE_ID )
                            	    {
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:682:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:683:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParserRule1268); 

                            	    		createLeafNode(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0(), "hiddenTokens"); 
                            	    	

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

                    match(input,16,FollowSets000.FOLLOW_16_in_ruleParserRule1282); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3(), null); 
                        

                    }
                    break;

            }

            match(input,22,FollowSets000.FOLLOW_22_in_ruleParserRule1294); 

                    createLeafNode(grammarAccess.getParserRuleAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:703:1: ( (lv_alternatives_10_0= ruleAlternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:704:1: (lv_alternatives_10_0= ruleAlternatives )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:704:1: (lv_alternatives_10_0= ruleAlternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:705:3: lv_alternatives_10_0= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParserRule1315);
            lv_alternatives_10_0=ruleAlternatives();
            _fsp--;


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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleParserRule1325); 

                    createLeafNode(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5(), null); 
                

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
    // $ANTLR end ruleParserRule


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:739:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:740:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:741:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRefRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_entryRuleTypeRef1361);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRef1371); 

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
    // $ANTLR end entryRuleTypeRef


    // $ANTLR start ruleTypeRef
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:748:1: ruleTypeRef returns [EObject current=null] : ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:753:6: ( ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:754:1: ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:754:1: ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:754:2: ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:754:2: ( ( ( RULE_ID ) ) '::' )?
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
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:754:3: ( ( RULE_ID ) ) '::'
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:754:3: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:755:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:755:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:756:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeRef1415); 

                    		createLeafNode(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0(), "metamodel"); 
                    	

                    }


                    }

                    match(input,24,FollowSets000.FOLLOW_24_in_ruleTypeRef1425); 

                            createLeafNode(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:772:3: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:773:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:773:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:774:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeRef1445); 

            		createLeafNode(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0(), "classifier"); 
            	

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
    // $ANTLR end ruleTypeRef


    // $ANTLR start entryRuleAlternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:794:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:795:2: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:796:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAlternativesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_entryRuleAlternatives1481);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternatives1491); 

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
    // $ANTLR end entryRuleAlternatives


    // $ANTLR start ruleAlternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:803:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group_0 = null;

        EObject lv_groups_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:808:6: ( (this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:809:1: (this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:809:1: (this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:810:5: this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleAlternatives1538);
            this_Group_0=ruleGroup();
            _fsp--;

             
                    current = this_Group_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:818:1: ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:818:2: () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:818:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:819:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:834:2: ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:834:4: '|' ( (lv_groups_3_0= ruleGroup ) )
                    	    {
                    	    match(input,25,FollowSets000.FOLLOW_25_in_ruleAlternatives1558); 

                    	            createLeafNode(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:838:1: ( (lv_groups_3_0= ruleGroup ) )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:839:1: (lv_groups_3_0= ruleGroup )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:839:1: (lv_groups_3_0= ruleGroup )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:840:3: lv_groups_3_0= ruleGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleGroup_in_ruleAlternatives1579);
                    	    lv_groups_3_0=ruleGroup();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAlternativesRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"groups",
                    	    	        		lv_groups_3_0, 
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
    // $ANTLR end ruleAlternatives


    // $ANTLR start entryRuleGroup
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:870:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:871:2: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:872:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleGroup_in_entryRuleGroup1619);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroup1629); 

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
    // $ANTLR end entryRuleGroup


    // $ANTLR start ruleGroup
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:879:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_tokens_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:884:6: ( (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:885:1: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:885:1: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:886:5: this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup1676);
            this_AbstractToken_0=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:894:1: ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||LA21_0==15||LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:894:2: () ( (lv_tokens_2_0= ruleAbstractToken ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:894:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:895:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getGroupAccess().getGroupTokensAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "tokens", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getGroupAccess().getGroupTokensAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:910:2: ( (lv_tokens_2_0= ruleAbstractToken ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:911:1: (lv_tokens_2_0= ruleAbstractToken )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:911:1: (lv_tokens_2_0= ruleAbstractToken )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:912:3: lv_tokens_2_0= ruleAbstractToken
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_ruleGroup1706);
                    	    lv_tokens_2_0=ruleAbstractToken();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getGroupRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"tokens",
                    	    	        		lv_tokens_2_0, 
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
    // $ANTLR end ruleGroup


    // $ANTLR start entryRuleAbstractToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:942:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:943:2: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:944:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTokenRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1745);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractToken1755); 

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
    // $ANTLR end entryRuleAbstractToken


    // $ANTLR start ruleAbstractToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:951:1: ruleAbstractToken returns [EObject current=null] : (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractTokenWithCardinality_0 = null;

        EObject this_Action_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:956:6: ( (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:957:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:957:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
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
                    new NoViableAltException("957:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:958:5: this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken1802);
                    this_AbstractTokenWithCardinality_0=ruleAbstractTokenWithCardinality();
                    _fsp--;

                     
                            current = this_AbstractTokenWithCardinality_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:968:5: this_Action_1= ruleAction
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleAbstractToken1829);
                    this_Action_1=ruleAction();
                    _fsp--;

                     
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
    // $ANTLR end ruleAbstractToken


    // $ANTLR start entryRuleAbstractTokenWithCardinality
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:984:1: entryRuleAbstractTokenWithCardinality returns [EObject current=null] : iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF ;
    public final EObject entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTokenWithCardinality = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:985:2: (iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:986:2: iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality1864);
            iv_ruleAbstractTokenWithCardinality=ruleAbstractTokenWithCardinality();
            _fsp--;

             current =iv_ruleAbstractTokenWithCardinality; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality1874); 

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
    // $ANTLR end entryRuleAbstractTokenWithCardinality


    // $ANTLR start ruleAbstractTokenWithCardinality
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:993:1: ruleAbstractTokenWithCardinality returns [EObject current=null] : ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) ;
    public final EObject ruleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;
        EObject this_Assignment_0 = null;

        EObject this_AbstractTerminal_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:998:6: ( ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:999:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:999:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:999:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:999:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==EOF||(LA23_1>=RULE_ID && LA23_1<=RULE_STRING)||(LA23_1>=15 && LA23_1<=16)||LA23_1==23||(LA23_1>=25 && LA23_1<=29)) ) {
                    alt23=2;
                }
                else if ( ((LA23_1>=30 && LA23_1<=31)||LA23_1==34) ) {
                    alt23=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("999:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )", 23, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA23_0==RULE_STRING||LA23_0==15) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("999:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1000:5: this_Assignment_0= ruleAssignment
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality1922);
                    this_Assignment_0=ruleAssignment();
                    _fsp--;

                     
                            current = this_Assignment_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1010:5: this_AbstractTerminal_1= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality1949);
                    this_AbstractTerminal_1=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1018:2: ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=26 && LA25_0<=28)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1019:1: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1019:1: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1020:1: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1020:1: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
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
                            new NoViableAltException("1020:1: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )", 24, 0, input);

                        throw nvae;
                    }

                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1021:3: lv_cardinality_2_1= '?'
                            {
                            lv_cardinality_2_1=(Token)input.LT(1);
                            match(input,26,FollowSets000.FOLLOW_26_in_ruleAbstractTokenWithCardinality1969); 

                                    createLeafNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0(), "cardinality"); 
                                

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
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1039:8: lv_cardinality_2_2= '*'
                            {
                            lv_cardinality_2_2=(Token)input.LT(1);
                            match(input,27,FollowSets000.FOLLOW_27_in_ruleAbstractTokenWithCardinality1998); 

                                    createLeafNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1(), "cardinality"); 
                                

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
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1057:8: lv_cardinality_2_3= '+'
                            {
                            lv_cardinality_2_3=(Token)input.LT(1);
                            match(input,28,FollowSets000.FOLLOW_28_in_ruleAbstractTokenWithCardinality2027); 

                                    createLeafNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2(), "cardinality"); 
                                

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
    // $ANTLR end ruleAbstractTokenWithCardinality


    // $ANTLR start entryRuleAction
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1086:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1087:2: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1088:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction2080);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction2090); 

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
    // $ANTLR end entryRuleAction


    // $ANTLR start ruleAction
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1095:1: ruleAction returns [EObject current=null] : ( '{' ( (lv_type_1_0= ruleTypeRef ) ) ( '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current' )? '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature_3_0=null;
        Token lv_operator_4_1=null;
        Token lv_operator_4_2=null;
        EObject lv_type_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1100:6: ( ( '{' ( (lv_type_1_0= ruleTypeRef ) ) ( '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current' )? '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1101:1: ( '{' ( (lv_type_1_0= ruleTypeRef ) ) ( '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current' )? '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1101:1: ( '{' ( (lv_type_1_0= ruleTypeRef ) ) ( '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current' )? '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1101:3: '{' ( (lv_type_1_0= ruleTypeRef ) ) ( '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current' )? '}'
            {
            match(input,29,FollowSets000.FOLLOW_29_in_ruleAction2125); 

                    createLeafNode(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1105:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1106:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1106:1: (lv_type_1_0= ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1107:3: lv_type_1_0= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleAction2146);
            lv_type_1_0=ruleTypeRef();
            _fsp--;


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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1129:2: ( '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1129:4: '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleAction2157); 

                            createLeafNode(grammarAccess.getActionAccess().getFullStopKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1133:1: ( (lv_feature_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1134:1: (lv_feature_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1134:1: (lv_feature_3_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1135:3: lv_feature_3_0= RULE_ID
                    {
                    lv_feature_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAction2174); 

                    			createLeafNode(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0(), "feature"); 
                    		

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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1157:2: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1158:1: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1158:1: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1159:1: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1159:1: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
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
                            new NoViableAltException("1159:1: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1160:3: lv_operator_4_1= '='
                            {
                            lv_operator_4_1=(Token)input.LT(1);
                            match(input,30,FollowSets000.FOLLOW_30_in_ruleAction2199); 

                                    createLeafNode(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0(), "operator"); 
                                

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
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1178:8: lv_operator_4_2= '+='
                            {
                            lv_operator_4_2=(Token)input.LT(1);
                            match(input,31,FollowSets000.FOLLOW_31_in_ruleAction2228); 

                                    createLeafNode(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1(), "operator"); 
                                

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

                    match(input,32,FollowSets000.FOLLOW_32_in_ruleAction2254); 

                            createLeafNode(grammarAccess.getActionAccess().getCurrentKeyword_2_3(), null); 
                        

                    }
                    break;

            }

            match(input,33,FollowSets000.FOLLOW_33_in_ruleAction2266); 

                    createLeafNode(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3(), null); 
                

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
    // $ANTLR end ruleAction


    // $ANTLR start entryRuleAbstractTerminal
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1215:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1216:2: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1217:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTerminalRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2302);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractTerminal2312); 

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
    // $ANTLR end entryRuleAbstractTerminal


    // $ANTLR start ruleAbstractTerminal
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1224:1: ruleAbstractTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1229:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1230:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1230:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
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
                    new NoViableAltException("1230:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1231:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAbstractTerminal2359);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1241:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2386);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1251:5: this_ParenthesizedElement_2= ruleParenthesizedElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2413);
                    this_ParenthesizedElement_2=ruleParenthesizedElement();
                    _fsp--;

                     
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
    // $ANTLR end ruleAbstractTerminal


    // $ANTLR start entryRuleKeyword
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1267:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1268:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1269:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeywordRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_entryRuleKeyword2448);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeyword2458); 

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
    // $ANTLR end entryRuleKeyword


    // $ANTLR start ruleKeyword
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1276:1: ruleKeyword returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1281:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1282:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1282:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1283:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1283:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1284:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleKeyword2499); 

            			createLeafNode(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
            		

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
    // $ANTLR end ruleKeyword


    // $ANTLR start entryRuleRuleCall
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1314:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1315:2: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1316:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_entryRuleRuleCall2539);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCall2549); 

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
    // $ANTLR end entryRuleRuleCall


    // $ANTLR start ruleRuleCall
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1323:1: ruleRuleCall returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1328:6: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1329:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1329:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1330:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1330:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1331:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRuleCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCall2591); 

            		createLeafNode(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0(), "rule"); 
            	

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
    // $ANTLR end ruleRuleCall


    // $ANTLR start entryRuleAssignment
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1351:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1352:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1353:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignmentRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment2626);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment2636); 

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
    // $ANTLR end entryRuleAssignment


    // $ANTLR start ruleAssignment
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1360:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        Token lv_operator_1_3=null;
        EObject lv_terminal_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1365:6: ( ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1366:1: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1366:1: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1366:2: ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1366:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1367:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1367:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1368:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignment2678); 

            			createLeafNode(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0(), "feature"); 
            		

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1390:2: ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1391:1: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1391:1: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1392:1: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1392:1: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
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
                    new NoViableAltException("1392:1: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1393:3: lv_operator_1_1= '+='
                    {
                    lv_operator_1_1=(Token)input.LT(1);
                    match(input,31,FollowSets000.FOLLOW_31_in_ruleAssignment2703); 

                            createLeafNode(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0(), "operator"); 
                        

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
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1411:8: lv_operator_1_2= '='
                    {
                    lv_operator_1_2=(Token)input.LT(1);
                    match(input,30,FollowSets000.FOLLOW_30_in_ruleAssignment2732); 

                            createLeafNode(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1(), "operator"); 
                        

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
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1429:8: lv_operator_1_3= '?='
                    {
                    lv_operator_1_3=(Token)input.LT(1);
                    match(input,34,FollowSets000.FOLLOW_34_in_ruleAssignment2761); 

                            createLeafNode(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2(), "operator"); 
                        

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1450:2: ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1451:1: (lv_terminal_2_0= ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1451:1: (lv_terminal_2_0= ruleAssignableTerminal )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1452:3: lv_terminal_2_0= ruleAssignableTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignment2798);
            lv_terminal_2_0=ruleAssignableTerminal();
            _fsp--;


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
    // $ANTLR end ruleAssignment


    // $ANTLR start entryRuleAssignableTerminal
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1482:1: entryRuleAssignableTerminal returns [EObject current=null] : iv_ruleAssignableTerminal= ruleAssignableTerminal EOF ;
    public final EObject entryRuleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableTerminal = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1483:2: (iv_ruleAssignableTerminal= ruleAssignableTerminal EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1484:2: iv_ruleAssignableTerminal= ruleAssignableTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignableTerminalRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal2834);
            iv_ruleAssignableTerminal=ruleAssignableTerminal();
            _fsp--;

             current =iv_ruleAssignableTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableTerminal2844); 

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
    // $ANTLR end entryRuleAssignableTerminal


    // $ANTLR start ruleAssignableTerminal
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1491:1: ruleAssignableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedAssignableElement_2 = null;

        EObject this_CrossReference_3 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1496:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1497:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1497:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
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
                    new NoViableAltException("1497:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1498:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleAssignableTerminal2891);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1508:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleAssignableTerminal2918);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1518:5: this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal2945);
                    this_ParenthesizedAssignableElement_2=ruleParenthesizedAssignableElement();
                    _fsp--;

                     
                            current = this_ParenthesizedAssignableElement_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1528:5: this_CrossReference_3= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_ruleAssignableTerminal2972);
                    this_CrossReference_3=ruleCrossReference();
                    _fsp--;

                     
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
    // $ANTLR end ruleAssignableTerminal


    // $ANTLR start entryRuleParenthesizedAssignableElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1544:1: entryRuleParenthesizedAssignableElement returns [EObject current=null] : iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF ;
    public final EObject entryRuleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedAssignableElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1545:2: (iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1546:2: iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedAssignableElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement3007);
            iv_ruleParenthesizedAssignableElement=ruleParenthesizedAssignableElement();
            _fsp--;

             current =iv_ruleParenthesizedAssignableElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement3017); 

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
    // $ANTLR end entryRuleParenthesizedAssignableElement


    // $ANTLR start ruleParenthesizedAssignableElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1553:1: ruleParenthesizedAssignableElement returns [EObject current=null] : ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' ) ;
    public final EObject ruleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject this_AssignableAlternatives_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1558:6: ( ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1559:1: ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1559:1: ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1559:3: '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')'
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedAssignableElement3052); 

                    createLeafNode(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3074);
            this_AssignableAlternatives_1=ruleAssignableAlternatives();
            _fsp--;

             
                    current = this_AssignableAlternatives_1; 
                    currentNode = currentNode.getParent();
                
            match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedAssignableElement3083); 

                    createLeafNode(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2(), null); 
                

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
    // $ANTLR end ruleParenthesizedAssignableElement


    // $ANTLR start entryRuleAssignableAlternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1584:1: entryRuleAssignableAlternatives returns [EObject current=null] : iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF ;
    public final EObject entryRuleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableAlternatives = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1585:2: (iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1586:2: iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignableAlternativesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3119);
            iv_ruleAssignableAlternatives=ruleAssignableAlternatives();
            _fsp--;

             current =iv_ruleAssignableAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignableAlternatives3129); 

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
    // $ANTLR end entryRuleAssignableAlternatives


    // $ANTLR start ruleAssignableAlternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1593:1: ruleAssignableAlternatives returns [EObject current=null] : (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final EObject ruleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_AssignableTerminal_0 = null;

        EObject lv_groups_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1598:6: ( (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1599:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1599:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1600:5: this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3176);
            this_AssignableTerminal_0=ruleAssignableTerminal();
            _fsp--;

             
                    current = this_AssignableTerminal_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1608:1: ( () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==25) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1608:2: () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1608:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1609:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1624:2: ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1624:4: '|' ( (lv_groups_3_0= ruleAssignableTerminal ) )
                    	    {
                    	    match(input,25,FollowSets000.FOLLOW_25_in_ruleAssignableAlternatives3196); 

                    	            createLeafNode(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1628:1: ( (lv_groups_3_0= ruleAssignableTerminal ) )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1629:1: (lv_groups_3_0= ruleAssignableTerminal )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1629:1: (lv_groups_3_0= ruleAssignableTerminal )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1630:3: lv_groups_3_0= ruleAssignableTerminal
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3217);
                    	    lv_groups_3_0=ruleAssignableTerminal();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAssignableAlternativesRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"groups",
                    	    	        		lv_groups_3_0, 
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
    // $ANTLR end ruleAssignableAlternatives


    // $ANTLR start entryRuleCrossReference
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1660:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1661:2: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1662:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReference_in_entryRuleCrossReference3257);
            iv_ruleCrossReference=ruleCrossReference();
            _fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReference3267); 

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
    // $ANTLR end entryRuleCrossReference


    // $ANTLR start ruleCrossReference
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1669:1: ruleCrossReference returns [EObject current=null] : ( '[' ( (lv_type_1_0= ruleTypeRef ) ) ( '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;

        EObject lv_terminal_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1674:6: ( ( '[' ( (lv_type_1_0= ruleTypeRef ) ) ( '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? ']' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1675:1: ( '[' ( (lv_type_1_0= ruleTypeRef ) ) ( '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? ']' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1675:1: ( '[' ( (lv_type_1_0= ruleTypeRef ) ) ( '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? ']' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1675:3: '[' ( (lv_type_1_0= ruleTypeRef ) ) ( '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? ']'
            {
            match(input,35,FollowSets000.FOLLOW_35_in_ruleCrossReference3302); 

                    createLeafNode(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1679:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1680:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1680:1: (lv_type_1_0= ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1681:3: lv_type_1_0= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleCrossReference3323);
            lv_type_1_0=ruleTypeRef();
            _fsp--;


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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1703:2: ( '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==25) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1703:4: '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleCrossReference3334); 

                            createLeafNode(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1707:1: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1708:1: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1708:1: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1709:3: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3355);
                    lv_terminal_3_0=ruleCrossReferenceableTerminal();
                    _fsp--;


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

            match(input,36,FollowSets000.FOLLOW_36_in_ruleCrossReference3367); 

                    createLeafNode(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3(), null); 
                

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
    // $ANTLR end ruleCrossReference


    // $ANTLR start entryRuleCrossReferenceableTerminal
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1743:1: entryRuleCrossReferenceableTerminal returns [EObject current=null] : iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF ;
    public final EObject entryRuleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableTerminal = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1744:2: (iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1745:2: iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceableTerminalRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal3403);
            iv_ruleCrossReferenceableTerminal=ruleCrossReferenceableTerminal();
            _fsp--;

             current =iv_ruleCrossReferenceableTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal3413); 

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
    // $ANTLR end entryRuleCrossReferenceableTerminal


    // $ANTLR start ruleCrossReferenceableTerminal
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1752:1: ruleCrossReferenceableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement ) ;
    public final EObject ruleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedCrossReferenceableElement_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1757:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1758:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1758:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement )
            int alt34=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt34=1;
                }
                break;
            case RULE_ID:
                {
                alt34=2;
                }
                break;
            case 15:
                {
                alt34=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1758:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement )", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1759:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3460);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1769:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3487);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1779:5: this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getParenthesizedCrossReferenceableElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedCrossReferenceableElement_in_ruleCrossReferenceableTerminal3514);
                    this_ParenthesizedCrossReferenceableElement_2=ruleParenthesizedCrossReferenceableElement();
                    _fsp--;

                     
                            current = this_ParenthesizedCrossReferenceableElement_2; 
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
    // $ANTLR end ruleCrossReferenceableTerminal


    // $ANTLR start entryRuleParenthesizedCrossReferenceableElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1795:1: entryRuleParenthesizedCrossReferenceableElement returns [EObject current=null] : iv_ruleParenthesizedCrossReferenceableElement= ruleParenthesizedCrossReferenceableElement EOF ;
    public final EObject entryRuleParenthesizedCrossReferenceableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedCrossReferenceableElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1796:2: (iv_ruleParenthesizedCrossReferenceableElement= ruleParenthesizedCrossReferenceableElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1797:2: iv_ruleParenthesizedCrossReferenceableElement= ruleParenthesizedCrossReferenceableElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedCrossReferenceableElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement3549);
            iv_ruleParenthesizedCrossReferenceableElement=ruleParenthesizedCrossReferenceableElement();
            _fsp--;

             current =iv_ruleParenthesizedCrossReferenceableElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement3559); 

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
    // $ANTLR end entryRuleParenthesizedCrossReferenceableElement


    // $ANTLR start ruleParenthesizedCrossReferenceableElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1804:1: ruleParenthesizedCrossReferenceableElement returns [EObject current=null] : ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' ) ;
    public final EObject ruleParenthesizedCrossReferenceableElement() throws RecognitionException {
        EObject current = null;

        EObject this_CrossReferenceableAlternatives_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1809:6: ( ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1810:1: ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1810:1: ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1810:3: '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')'
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedCrossReferenceableElement3594); 

                    createLeafNode(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getCrossReferenceableAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableAlternatives_in_ruleParenthesizedCrossReferenceableElement3616);
            this_CrossReferenceableAlternatives_1=ruleCrossReferenceableAlternatives();
            _fsp--;

             
                    current = this_CrossReferenceableAlternatives_1; 
                    currentNode = currentNode.getParent();
                
            match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedCrossReferenceableElement3625); 

                    createLeafNode(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getRightParenthesisKeyword_2(), null); 
                

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
    // $ANTLR end ruleParenthesizedCrossReferenceableElement


    // $ANTLR start entryRuleCrossReferenceableAlternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1835:1: entryRuleCrossReferenceableAlternatives returns [EObject current=null] : iv_ruleCrossReferenceableAlternatives= ruleCrossReferenceableAlternatives EOF ;
    public final EObject entryRuleCrossReferenceableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableAlternatives = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1836:2: (iv_ruleCrossReferenceableAlternatives= ruleCrossReferenceableAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1837:2: iv_ruleCrossReferenceableAlternatives= ruleCrossReferenceableAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceableAlternativesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives3661);
            iv_ruleCrossReferenceableAlternatives=ruleCrossReferenceableAlternatives();
            _fsp--;

             current =iv_ruleCrossReferenceableAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives3671); 

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
    // $ANTLR end entryRuleCrossReferenceableAlternatives


    // $ANTLR start ruleCrossReferenceableAlternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1844:1: ruleCrossReferenceableAlternatives returns [EObject current=null] : (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+ )? ) ;
    public final EObject ruleCrossReferenceableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_CrossReferenceableTerminal_0 = null;

        EObject lv_groups_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1849:6: ( (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1850:1: (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1850:1: (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1851:5: this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getCrossReferenceableAlternativesAccess().getCrossReferenceableTerminalParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives3718);
            this_CrossReferenceableTerminal_0=ruleCrossReferenceableTerminal();
            _fsp--;

             
                    current = this_CrossReferenceableTerminal_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1859:1: ( () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+ )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==25) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1859:2: () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1859:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1860:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getCrossReferenceableAlternativesAccess().getAlternativesGroupsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getCrossReferenceableAlternativesAccess().getAlternativesGroupsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1875:2: ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==25) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1875:4: '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) )
                    	    {
                    	    match(input,25,FollowSets000.FOLLOW_25_in_ruleCrossReferenceableAlternatives3738); 

                    	            createLeafNode(grammarAccess.getCrossReferenceableAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1879:1: ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1880:1: (lv_groups_3_0= ruleCrossReferenceableTerminal )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1880:1: (lv_groups_3_0= ruleCrossReferenceableTerminal )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1881:3: lv_groups_3_0= ruleCrossReferenceableTerminal
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsCrossReferenceableTerminalParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives3759);
                    	    lv_groups_3_0=ruleCrossReferenceableTerminal();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getCrossReferenceableAlternativesRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"groups",
                    	    	        		lv_groups_3_0, 
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

                    	default :
                    	    if ( cnt35 >= 1 ) break loop35;
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
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
    // $ANTLR end ruleCrossReferenceableAlternatives


    // $ANTLR start entryRuleParenthesizedElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1911:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1912:2: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1913:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement3799);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedElement3809); 

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
    // $ANTLR end entryRuleParenthesizedElement


    // $ANTLR start ruleParenthesizedElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1920:1: ruleParenthesizedElement returns [EObject current=null] : ( '(' this_Alternatives_1= ruleAlternatives ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1925:6: ( ( '(' this_Alternatives_1= ruleAlternatives ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1926:1: ( '(' this_Alternatives_1= ruleAlternatives ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1926:1: ( '(' this_Alternatives_1= ruleAlternatives ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1926:3: '(' this_Alternatives_1= ruleAlternatives ')'
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedElement3844); 

                    createLeafNode(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAlternatives_in_ruleParenthesizedElement3866);
            this_Alternatives_1=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives_1; 
                    currentNode = currentNode.getParent();
                
            match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedElement3875); 

                    createLeafNode(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2(), null); 
                

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
    // $ANTLR end ruleParenthesizedElement


    // $ANTLR start entryRuleTerminalRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1951:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1952:2: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1953:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule3911);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule3921); 

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
    // $ANTLR end entryRuleTerminalRule


    // $ANTLR start ruleTerminalRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1960:1: ruleTerminalRule returns [EObject current=null] : ( 'terminal' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_3_0 = null;

        EObject lv_alternatives_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1965:6: ( ( 'terminal' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1966:1: ( 'terminal' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1966:1: ( 'terminal' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1966:3: 'terminal' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) ';'
            {
            match(input,37,FollowSets000.FOLLOW_37_in_ruleTerminalRule3956); 

                    createLeafNode(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1970:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1971:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1971:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1972:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTerminalRule3973); 

            			createLeafNode(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1994:2: ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==21) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1994:4: 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleTerminalRule3989); 

                            createLeafNode(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1998:1: ( (lv_type_3_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1999:1: (lv_type_3_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:1999:1: (lv_type_3_0= ruleTypeRef )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2000:3: lv_type_3_0= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleTerminalRule4010);
                    lv_type_3_0=ruleTypeRef();
                    _fsp--;


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

            match(input,22,FollowSets000.FOLLOW_22_in_ruleTerminalRule4022); 

                    createLeafNode(grammarAccess.getTerminalRuleAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2026:1: ( (lv_alternatives_5_0= ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2027:1: (lv_alternatives_5_0= ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2027:1: (lv_alternatives_5_0= ruleTerminalAlternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2028:3: lv_alternatives_5_0= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule4043);
            lv_alternatives_5_0=ruleTerminalAlternatives();
            _fsp--;


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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleTerminalRule4053); 

                    createLeafNode(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5(), null); 
                

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
    // $ANTLR end ruleTerminalRule


    // $ANTLR start entryRuleTerminalAlternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2062:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2063:2: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2064:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalAlternativesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives4089);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalAlternatives4099); 

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
    // $ANTLR end entryRuleTerminalAlternatives


    // $ANTLR start ruleTerminalAlternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2071:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalGroup_0 = null;

        EObject lv_groups_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2076:6: ( (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2077:1: (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2077:1: (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2078:5: this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4146);
            this_TerminalGroup_0=ruleTerminalGroup();
            _fsp--;

             
                    current = this_TerminalGroup_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2086:1: ( () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==25) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2086:2: () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2086:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2087:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2102:2: ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2102:4: '|' ( (lv_groups_3_0= ruleTerminalGroup ) )
                    	    {
                    	    match(input,25,FollowSets000.FOLLOW_25_in_ruleTerminalAlternatives4166); 

                    	            createLeafNode(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2106:1: ( (lv_groups_3_0= ruleTerminalGroup ) )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2107:1: (lv_groups_3_0= ruleTerminalGroup )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2107:1: (lv_groups_3_0= ruleTerminalGroup )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2108:3: lv_groups_3_0= ruleTerminalGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4187);
                    	    lv_groups_3_0=ruleTerminalGroup();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getTerminalAlternativesRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"groups",
                    	    	        		lv_groups_3_0, 
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
    // $ANTLR end ruleTerminalAlternatives


    // $ANTLR start entryRuleTerminalGroup
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2138:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2139:2: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2140:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalGroupRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup4227);
            iv_ruleTerminalGroup=ruleTerminalGroup();
            _fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalGroup4237); 

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
    // $ANTLR end entryRuleTerminalGroup


    // $ANTLR start ruleTerminalGroup
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2147:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_tokens_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2152:6: ( (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2153:1: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2153:1: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2154:5: this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4284);
            this_TerminalToken_0=ruleTerminalToken();
            _fsp--;

             
                    current = this_TerminalToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2162:1: ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_STRING)||LA41_0==15||LA41_0==17||(LA41_0>=38 && LA41_0<=39)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2162:2: () ( (lv_tokens_2_0= ruleTerminalToken ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2162:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2163:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "tokens", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2178:2: ( (lv_tokens_2_0= ruleTerminalToken ) )+
                    int cnt40=0;
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_STRING)||LA40_0==15||LA40_0==17||(LA40_0>=38 && LA40_0<=39)) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2179:1: (lv_tokens_2_0= ruleTerminalToken )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2179:1: (lv_tokens_2_0= ruleTerminalToken )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2180:3: lv_tokens_2_0= ruleTerminalToken
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4314);
                    	    lv_tokens_2_0=ruleTerminalToken();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getTerminalGroupRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"tokens",
                    	    	        		lv_tokens_2_0, 
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
    // $ANTLR end ruleTerminalGroup


    // $ANTLR start entryRuleTerminalToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2210:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2211:2: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2212:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalTokenRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken4353);
            iv_ruleTerminalToken=ruleTerminalToken();
            _fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalToken4363); 

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
    // $ANTLR end entryRuleTerminalToken


    // $ANTLR start ruleTerminalToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2219:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_1_1=null;
        Token lv_cardinality_1_2=null;
        Token lv_cardinality_1_3=null;
        EObject this_TerminalTokenElement_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2224:6: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2225:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2225:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2226:5: this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4410);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();
            _fsp--;

             
                    current = this_TerminalTokenElement_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2234:1: ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=26 && LA43_0<=28)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2235:1: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2235:1: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2236:1: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2236:1: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    int alt42=3;
                    switch ( input.LA(1) ) {
                    case 26:
                        {
                        alt42=1;
                        }
                        break;
                    case 27:
                        {
                        alt42=2;
                        }
                        break;
                    case 28:
                        {
                        alt42=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("2236:1: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )", 42, 0, input);

                        throw nvae;
                    }

                    switch (alt42) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2237:3: lv_cardinality_1_1= '?'
                            {
                            lv_cardinality_1_1=(Token)input.LT(1);
                            match(input,26,FollowSets000.FOLLOW_26_in_ruleTerminalToken4429); 

                                    createLeafNode(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0(), "cardinality"); 
                                

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
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2255:8: lv_cardinality_1_2= '*'
                            {
                            lv_cardinality_1_2=(Token)input.LT(1);
                            match(input,27,FollowSets000.FOLLOW_27_in_ruleTerminalToken4458); 

                                    createLeafNode(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1(), "cardinality"); 
                                

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
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2273:8: lv_cardinality_1_3= '+'
                            {
                            lv_cardinality_1_3=(Token)input.LT(1);
                            match(input,28,FollowSets000.FOLLOW_28_in_ruleTerminalToken4487); 

                                    createLeafNode(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2(), "cardinality"); 
                                

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
    // $ANTLR end ruleTerminalToken


    // $ANTLR start entryRuleTerminalTokenElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2302:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2303:2: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2304:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalTokenElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement4540);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalTokenElement4550); 

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
    // $ANTLR end entryRuleTerminalTokenElement


    // $ANTLR start ruleTerminalTokenElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2311:1: ruleTerminalTokenElement returns [EObject current=null] : (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2316:6: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2317:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2317:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
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
            case 38:
            case 39:
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
                    new NoViableAltException("2317:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2318:5: this_CharacterRange_0= ruleCharacterRange
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4597);
                    this_CharacterRange_0=ruleCharacterRange();
                    _fsp--;

                     
                            current = this_CharacterRange_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2328:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement4624);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2338:5: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement4651);
                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();
                    _fsp--;

                     
                            current = this_ParenthesizedTerminalElement_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2348:5: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement4678);
                    this_AbstractNegatedToken_3=ruleAbstractNegatedToken();
                    _fsp--;

                     
                            current = this_AbstractNegatedToken_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2358:5: this_Wildcard_4= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_ruleTerminalTokenElement4705);
                    this_Wildcard_4=ruleWildcard();
                    _fsp--;

                     
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
    // $ANTLR end ruleTerminalTokenElement


    // $ANTLR start entryRuleParenthesizedTerminalElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2374:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2375:2: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2376:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedTerminalElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4740);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
            _fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4750); 

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
    // $ANTLR end entryRuleParenthesizedTerminalElement


    // $ANTLR start ruleParenthesizedTerminalElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2383:1: ruleParenthesizedTerminalElement returns [EObject current=null] : ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalAlternatives_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2388:6: ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2389:1: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2389:1: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2389:3: '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')'
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleParenthesizedTerminalElement4785); 

                    createLeafNode(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4807);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();
            _fsp--;

             
                    current = this_TerminalAlternatives_1; 
                    currentNode = currentNode.getParent();
                
            match(input,16,FollowSets000.FOLLOW_16_in_ruleParenthesizedTerminalElement4816); 

                    createLeafNode(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2(), null); 
                

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
    // $ANTLR end ruleParenthesizedTerminalElement


    // $ANTLR start entryRuleAbstractNegatedToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2414:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2415:2: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2416:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractNegatedTokenRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken4852);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();
            _fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractNegatedToken4862); 

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
    // $ANTLR end entryRuleAbstractNegatedToken


    // $ANTLR start ruleAbstractNegatedToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2423:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UntilToken_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2428:6: ( (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2429:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2429:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==38) ) {
                alt45=1;
            }
            else if ( (LA45_0==39) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2429:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2430:5: this_NegatedToken_0= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4909);
                    this_NegatedToken_0=ruleNegatedToken();
                    _fsp--;

                     
                            current = this_NegatedToken_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2440:5: this_UntilToken_1= ruleUntilToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken4936);
                    this_UntilToken_1=ruleUntilToken();
                    _fsp--;

                     
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
    // $ANTLR end ruleAbstractNegatedToken


    // $ANTLR start entryRuleNegatedToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2456:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2457:2: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2458:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNegatedTokenRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4971);
            iv_ruleNegatedToken=ruleNegatedToken();
            _fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegatedToken4981); 

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
    // $ANTLR end entryRuleNegatedToken


    // $ANTLR start ruleNegatedToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2465:1: ruleNegatedToken returns [EObject current=null] : ( '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2470:6: ( ( '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2471:1: ( '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2471:1: ( '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2471:3: '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            match(input,38,FollowSets000.FOLLOW_38_in_ruleNegatedToken5016); 

                    createLeafNode(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2475:1: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2476:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2476:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2477:3: lv_terminal_1_0= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken5037);
            lv_terminal_1_0=ruleTerminalTokenElement();
            _fsp--;


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
    // $ANTLR end ruleNegatedToken


    // $ANTLR start entryRuleUntilToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2507:1: entryRuleUntilToken returns [EObject current=null] : iv_ruleUntilToken= ruleUntilToken EOF ;
    public final EObject entryRuleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntilToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2508:2: (iv_ruleUntilToken= ruleUntilToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2509:2: iv_ruleUntilToken= ruleUntilToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUntilTokenRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUntilToken_in_entryRuleUntilToken5073);
            iv_ruleUntilToken=ruleUntilToken();
            _fsp--;

             current =iv_ruleUntilToken; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUntilToken5083); 

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
    // $ANTLR end entryRuleUntilToken


    // $ANTLR start ruleUntilToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2516:1: ruleUntilToken returns [EObject current=null] : ( '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2521:6: ( ( '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2522:1: ( '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2522:1: ( '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2522:3: '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            match(input,39,FollowSets000.FOLLOW_39_in_ruleUntilToken5118); 

                    createLeafNode(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2526:1: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2527:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2527:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2528:3: lv_terminal_1_0= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken5139);
            lv_terminal_1_0=ruleTerminalTokenElement();
            _fsp--;


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
    // $ANTLR end ruleUntilToken


    // $ANTLR start entryRuleWildcard
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2558:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2559:2: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2560:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWildcardRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleWildcard_in_entryRuleWildcard5175);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcard5185); 

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
    // $ANTLR end entryRuleWildcard


    // $ANTLR start ruleWildcard
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2567:1: ruleWildcard returns [EObject current=null] : ( () '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2572:6: ( ( () '.' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2573:1: ( () '.' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2573:1: ( () '.' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2573:2: () '.'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2573:2: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2574:5: 
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

            match(input,17,FollowSets000.FOLLOW_17_in_ruleWildcard5229); 

                    createLeafNode(grammarAccess.getWildcardAccess().getFullStopKeyword_1(), null); 
                

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
    // $ANTLR end ruleWildcard


    // $ANTLR start entryRuleCharacterRange
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2596:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2597:2: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2598:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCharacterRangeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5265);
            iv_ruleCharacterRange=ruleCharacterRange();
            _fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCharacterRange5275); 

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
    // $ANTLR end entryRuleCharacterRange


    // $ANTLR start ruleCharacterRange
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2605:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( () '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2610:6: ( (this_Keyword_0= ruleKeyword ( () '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2611:1: (this_Keyword_0= ruleKeyword ( () '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2611:1: (this_Keyword_0= ruleKeyword ( () '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2612:5: this_Keyword_0= ruleKeyword ( () '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange5322);
            this_Keyword_0=ruleKeyword();
            _fsp--;

             
                    current = this_Keyword_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2620:1: ( () '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==40) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2620:2: () '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2620:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2621:5: 
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

                    match(input,40,FollowSets000.FOLLOW_40_in_ruleCharacterRange5341); 

                            createLeafNode(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2640:1: ( (lv_right_3_0= ruleKeyword ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2641:1: (lv_right_3_0= ruleKeyword )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2641:1: (lv_right_3_0= ruleKeyword )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2642:3: lv_right_3_0= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleCharacterRange5362);
                    lv_right_3_0=ruleKeyword();
                    _fsp--;


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
    // $ANTLR end ruleCharacterRange


    // $ANTLR start entryRuleEnumRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2672:1: entryRuleEnumRule returns [EObject current=null] : iv_ruleEnumRule= ruleEnumRule EOF ;
    public final EObject entryRuleEnumRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2673:2: (iv_ruleEnumRule= ruleEnumRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2674:2: iv_ruleEnumRule= ruleEnumRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumRule_in_entryRuleEnumRule5400);
            iv_ruleEnumRule=ruleEnumRule();
            _fsp--;

             current =iv_ruleEnumRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumRule5410); 

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
    // $ANTLR end entryRuleEnumRule


    // $ANTLR start ruleEnumRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2681:1: ruleEnumRule returns [EObject current=null] : ( 'enum' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) ';' ) ;
    public final EObject ruleEnumRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_3_0 = null;

        EObject lv_alternatives_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2686:6: ( ( 'enum' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2687:1: ( 'enum' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2687:1: ( 'enum' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2687:3: 'enum' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) ';'
            {
            match(input,41,FollowSets000.FOLLOW_41_in_ruleEnumRule5445); 

                    createLeafNode(grammarAccess.getEnumRuleAccess().getEnumKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2691:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2692:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2692:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2693:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumRule5462); 

            			createLeafNode(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2715:2: ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==21) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2715:4: 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleEnumRule5478); 

                            createLeafNode(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2719:1: ( (lv_type_3_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2720:1: (lv_type_3_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2720:1: (lv_type_3_0= ruleTypeRef )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2721:3: lv_type_3_0= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTypeRef_in_ruleEnumRule5499);
                    lv_type_3_0=ruleTypeRef();
                    _fsp--;


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

            match(input,22,FollowSets000.FOLLOW_22_in_ruleEnumRule5511); 

                    createLeafNode(grammarAccess.getEnumRuleAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2747:1: ( (lv_alternatives_5_0= ruleEnumLiterals ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2748:1: (lv_alternatives_5_0= ruleEnumLiterals )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2748:1: (lv_alternatives_5_0= ruleEnumLiterals )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2749:3: lv_alternatives_5_0= ruleEnumLiterals
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_ruleEnumRule5532);
            lv_alternatives_5_0=ruleEnumLiterals();
            _fsp--;


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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleEnumRule5542); 

                    createLeafNode(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5(), null); 
                

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
    // $ANTLR end ruleEnumRule


    // $ANTLR start entryRuleEnumLiterals
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2783:1: entryRuleEnumLiterals returns [EObject current=null] : iv_ruleEnumLiterals= ruleEnumLiterals EOF ;
    public final EObject entryRuleEnumLiterals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiterals = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2784:2: (iv_ruleEnumLiterals= ruleEnumLiterals EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2785:2: iv_ruleEnumLiterals= ruleEnumLiterals EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumLiteralsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals5578);
            iv_ruleEnumLiterals=ruleEnumLiterals();
            _fsp--;

             current =iv_ruleEnumLiterals; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiterals5588); 

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
    // $ANTLR end entryRuleEnumLiterals


    // $ANTLR start ruleEnumLiterals
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2792:1: ruleEnumLiterals returns [EObject current=null] : (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final EObject ruleEnumLiterals() throws RecognitionException {
        EObject current = null;

        EObject this_EnumLiteralDeclaration_0 = null;

        EObject lv_groups_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2797:6: ( (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2798:1: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2798:1: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2799:5: this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5635);
            this_EnumLiteralDeclaration_0=ruleEnumLiteralDeclaration();
            _fsp--;

             
                    current = this_EnumLiteralDeclaration_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2807:1: ( () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==25) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2807:2: () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2807:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2808:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2823:2: ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2823:4: '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) )
                    	    {
                    	    match(input,25,FollowSets000.FOLLOW_25_in_ruleEnumLiterals5655); 

                    	            createLeafNode(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2827:1: ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2828:1: (lv_groups_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2828:1: (lv_groups_3_0= ruleEnumLiteralDeclaration )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2829:3: lv_groups_3_0= ruleEnumLiteralDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5676);
                    	    lv_groups_3_0=ruleEnumLiteralDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEnumLiteralsRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"groups",
                    	    	        		lv_groups_3_0, 
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
    // $ANTLR end ruleEnumLiterals


    // $ANTLR start entryRuleEnumLiteralDeclaration
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2859:1: entryRuleEnumLiteralDeclaration returns [EObject current=null] : iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF ;
    public final EObject entryRuleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralDeclaration = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2860:2: (iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2861:2: iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumLiteralDeclarationRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration5716);
            iv_ruleEnumLiteralDeclaration=ruleEnumLiteralDeclaration();
            _fsp--;

             current =iv_ruleEnumLiteralDeclaration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration5726); 

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
    // $ANTLR end entryRuleEnumLiteralDeclaration


    // $ANTLR start ruleEnumLiteralDeclaration
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2868:1: ruleEnumLiteralDeclaration returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_literal_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2873:6: ( ( ( ( RULE_ID ) ) ( '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2874:1: ( ( ( RULE_ID ) ) ( '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2874:1: ( ( ( RULE_ID ) ) ( '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2874:2: ( ( RULE_ID ) ) ( '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2874:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2875:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2875:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2876:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getEnumLiteralDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration5769); 

            		createLeafNode(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0(), "enumLiteral"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2888:2: ( '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==30) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2888:4: '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {
                    match(input,30,FollowSets000.FOLLOW_30_in_ruleEnumLiteralDeclaration5780); 

                            createLeafNode(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2892:1: ( (lv_literal_2_0= ruleKeyword ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2893:1: (lv_literal_2_0= ruleKeyword )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2893:1: (lv_literal_2_0= ruleKeyword )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarUiTestLanguage.g:2894:3: lv_literal_2_0= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration5801);
                    lv_literal_2_0=ruleKeyword();
                    _fsp--;


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
    // $ANTLR end ruleEnumLiteralDeclaration


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammar85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleGrammar120 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar141 = new BitSet(new long[]{0x0000022000145010L});
        public static final BitSet FOLLOW_12_in_ruleGrammar152 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar175 = new BitSet(new long[]{0x0000022000146010L});
        public static final BitSet FOLLOW_13_in_ruleGrammar186 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar209 = new BitSet(new long[]{0x0000022000146010L});
        public static final BitSet FOLLOW_14_in_ruleGrammar232 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleGrammar255 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar274 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleGrammar285 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar303 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleGrammar317 = new BitSet(new long[]{0x0000022000140010L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar340 = new BitSet(new long[]{0x0000022000140010L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar362 = new BitSet(new long[]{0x0000022000000012L});
        public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID400 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID451 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleGrammarID470 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID485 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule532 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_ruleAbstractRule643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration678 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel797 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleGeneratedMetamodel842 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel859 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel882 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel893 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel953 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel998 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1016 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleReferencedMetamodel1027 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1087 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1139 = new BitSet(new long[]{0x0000000000604000L});
        public static final BitSet FOLLOW_21_in_ruleParserRule1155 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1176 = new BitSet(new long[]{0x0000000000404000L});
        public static final BitSet FOLLOW_14_in_ruleParserRule1197 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleParserRule1220 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1239 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleParserRule1250 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1268 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleParserRule1282 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleParserRule1294 = new BitSet(new long[]{0x0000000020008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1315 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleParserRule1325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1415 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleTypeRef1425 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives1481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives1491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1538 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleAlternatives1558 = new BitSet(new long[]{0x0000000020008030L});
        public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1579 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup1619 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroup1629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1676 = new BitSet(new long[]{0x0000000020008032L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1706 = new BitSet(new long[]{0x0000000020008032L});
        public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1745 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken1755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken1802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken1829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality1864 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality1874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality1922 = new BitSet(new long[]{0x000000001C000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality1949 = new BitSet(new long[]{0x000000001C000002L});
        public static final BitSet FOLLOW_26_in_ruleAbstractTokenWithCardinality1969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleAbstractTokenWithCardinality1998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleAbstractTokenWithCardinality2027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction2080 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction2090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleAction2125 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction2146 = new BitSet(new long[]{0x0000000200020000L});
        public static final BitSet FOLLOW_17_in_ruleAction2157 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAction2174 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_30_in_ruleAction2199 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_31_in_ruleAction2228 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleAction2254 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleAction2266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2302 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal2312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal2359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword2448 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeyword2458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword2499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall2539 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall2549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall2591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment2626 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment2636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment2678 = new BitSet(new long[]{0x00000004C0000000L});
        public static final BitSet FOLLOW_31_in_ruleAssignment2703 = new BitSet(new long[]{0x0000000800008030L});
        public static final BitSet FOLLOW_30_in_ruleAssignment2732 = new BitSet(new long[]{0x0000000800008030L});
        public static final BitSet FOLLOW_34_in_ruleAssignment2761 = new BitSet(new long[]{0x0000000800008030L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignment2798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal2834 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal2844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleAssignableTerminal2891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleAssignableTerminal2918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal2945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_ruleAssignableTerminal2972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement3007 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement3017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedAssignableElement3052 = new BitSet(new long[]{0x0000000800008030L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3074 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedAssignableElement3083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3119 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives3129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3176 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleAssignableAlternatives3196 = new BitSet(new long[]{0x0000000800008030L});
        public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3217 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference3257 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference3267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleCrossReference3302 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference3323 = new BitSet(new long[]{0x0000001002000000L});
        public static final BitSet FOLLOW_25_in_ruleCrossReference3334 = new BitSet(new long[]{0x0000000000008030L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3355 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleCrossReference3367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal3403 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal3413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_ruleCrossReferenceableTerminal3514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement3549 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement3559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedCrossReferenceableElement3594 = new BitSet(new long[]{0x0000000000008030L});
        public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_ruleParenthesizedCrossReferenceableElement3616 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedCrossReferenceableElement3625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives3661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives3671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives3718 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleCrossReferenceableAlternatives3738 = new BitSet(new long[]{0x0000000000008030L});
        public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives3759 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement3799 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement3809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedElement3844 = new BitSet(new long[]{0x0000000020008030L});
        public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement3866 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedElement3875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule3911 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule3921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleTerminalRule3956 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule3973 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_21_in_ruleTerminalRule3989 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule4010 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleTerminalRule4022 = new BitSet(new long[]{0x000000C000028030L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule4043 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleTerminalRule4053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives4089 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives4099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4146 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleTerminalAlternatives4166 = new BitSet(new long[]{0x000000C000028030L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4187 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup4227 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup4237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4284 = new BitSet(new long[]{0x000000C000028032L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4314 = new BitSet(new long[]{0x000000C000028032L});
        public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken4353 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken4363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4410 = new BitSet(new long[]{0x000000001C000002L});
        public static final BitSet FOLLOW_26_in_ruleTerminalToken4429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleTerminalToken4458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleTerminalToken4487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement4540 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement4550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement4624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement4651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement4678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement4705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4740 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement4785 = new BitSet(new long[]{0x000000C000028030L});
        public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4807 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParenthesizedTerminalElement4816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken4852 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken4862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken4936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4971 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken4981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleNegatedToken5016 = new BitSet(new long[]{0x000000C000028030L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken5037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken5073 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken5083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleUntilToken5118 = new BitSet(new long[]{0x000000C000028030L});
        public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken5139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard5175 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcard5185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleWildcard5229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5265 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange5275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5322 = new BitSet(new long[]{0x0000010000000002L});
        public static final BitSet FOLLOW_40_in_ruleCharacterRange5341 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule5400 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule5410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEnumRule5445 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumRule5462 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_21_in_ruleEnumRule5478 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTypeRef_in_ruleEnumRule5499 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleEnumRule5511 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_ruleEnumRule5532 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleEnumRule5542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals5578 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals5588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5635 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleEnumLiterals5655 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5676 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration5716 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration5726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration5769 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleEnumLiteralDeclaration5780 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration5801 = new BitSet(new long[]{0x0000000000000002L});
    }


}